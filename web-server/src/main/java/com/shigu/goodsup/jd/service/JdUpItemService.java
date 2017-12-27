package com.shigu.goodsup.jd.service;

import com.alibaba.fastjson.JSONObject;
import com.opentae.data.jd.beans.JdItemProp;
import com.opentae.data.jd.beans.JdPropValue;
import com.opentae.data.jd.beans.JdTbBind;
import com.opentae.data.jd.beans.ShiguJdcat;
import com.opentae.data.jd.examples.JdItemPropExample;
import com.opentae.data.jd.examples.JdPropValueExample;
import com.opentae.data.jd.examples.JdTbBindExample;
import com.opentae.data.jd.interfaces.JdItemPropMapper;
import com.opentae.data.jd.interfaces.JdPropValueMapper;
import com.opentae.data.jd.interfaces.JdTbBindMapper;
import com.opentae.data.jd.interfaces.ShiguJdcatMapper;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ShiguPropImgsExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.goodsup.jd.vo.*;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.services.ItemAddOrUpdateService;
import com.shigu.main4.jd.exceptions.JdUpException;
import com.shigu.main4.jd.service.JdCategoryService;
import com.shigu.main4.jd.service.JdOrderService;
import com.shigu.main4.jd.vo.JdCategoryAttrValueJosVO;
import com.shigu.main4.jd.vo.JdPostTemplateVO;
import com.shigu.main4.jd.vo.JdShopCategoryVO;
import com.shigu.main4.jd.vo.JdVenderBrandPubInfoVO;
import com.shigu.tb.finder.vo.PropType;
import com.taobao.api.domain.*;
import org.apache.commons.lang3.StringUtils;
import com.taobao.api.domain.Item;
import com.taobao.api.domain.ItemImg;
import com.taobao.api.domain.Location;
import com.taobao.api.domain.PropImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created By admin on 2017/12/15/15:23
 */
@Service
public class JdUpItemService {
    @Autowired
    private ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;
    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapperImpl;
    @Autowired
    private ShiguShopMapper shiguShopMapper;
    @Autowired
    private JdItemPropMapper jdItemPropMapper;
    @Autowired
    private JdPropValueMapper jdPropValueMapper;
    @Autowired
    private JdTbBindMapper jdTbBindMapper;
    @Autowired
    ShiguGoodsExtendsMapper shiguGoodsExtendsMapper;
    @Autowired
    ShiguPropImgsMapper shiguPropImgsMapper;
    @Autowired
    ShiguJdcatMapper shiguJdcatMapper;


    @Autowired
    EhCacheCacheManager ehCacheManager;


    @Autowired
    ItemAddOrUpdateService itemAddOrUpdateService;
    @Autowired
    PropsService propsService;
    @Autowired
    JdUserInfoService jdUserInfoService;
    @Autowired
    JdOrderService jdOrderService;
    @Autowired
    JdCategoryService jdCategoryService;
    /**
     * 得到商品
     * @return
     * @throws Main4Exception
     */
    public JdPageItem findGoods(Long goodsId) throws Main4Exception{
        ShiguGoodsIdGenerator sgig=shiguGoodsIdGeneratorMapper.selectByPrimaryKey(goodsId);
        if(sgig==null){
            throw new Main4Exception(goodsId+" goodsId生成表没找到");
        }
        ShiguGoodsTiny sgt=new ShiguGoodsTiny();
        sgt.setGoodsId(goodsId);
        sgt.setWebSite(sgig.getWebSite());
        sgt=shiguGoodsTinyMapperImpl.selectByPrimaryKey(sgt);
        if(sgt==null){
            throw new Main4Exception(goodsId+" goodsTiny表没找到");
        }
        sgt.setWebSite(sgig.getWebSite());

        JdPageItem pageItem=new JdPageItem();
        pageItem.setNumIid(sgt.getNumIid());
        pageItem.setStoreId(sgt.getStoreId());
        pageItem.setWebSite(sgig.getWebSite());
        pageItem.setGoodsId(goodsId);
        pageItem.setHuohao(sgt.getGoodsNo());
        pageItem.setPiPrice(sgt.getPiPriceString());
        if (sgt.getStoreId() != null) {
            List<Long> storeIds=new ArrayList<>();
            storeIds.add(sgt.getStoreId());
            List<ShopNumAndMarket> gmi=shiguShopMapper.selShopNumAndMarkets(storeIds);
            if (gmi.size()>0) {
                pageItem.setParentMarketName(gmi.get(0).getMarket());
                pageItem.setStoreNum(gmi.get(0).getShopNum());
            }
        }

        Item it=staticGoods(sgt);
        pageItem.setItem(it);
        if(sgt.getNumIid()==null){
            pageItem.setGoodsType(2);
        }else{
            pageItem.setGoodsType(1);
        }
        pageItem.setDataType(2);
        JdTbBindExample jdTbBindExample=new JdTbBindExample();
        jdTbBindExample.createCriteria().andTbCidEqualTo(it.getCid());
        List<JdTbBind> binds=jdTbBindMapper.selectByExample(jdTbBindExample);
        if(binds.size()==0){
            throw new Main4Exception("商品暂不支持上传");
        }
        JdTbBind bind = binds.get(0);
        if(binds.size()>1){
            if(it.getTitle().contains("女")){
                bind=binds.stream().filter(jdTbBind -> jdTbBind.getSex()==2).findFirst().get();
            }else if(it.getTitle().contains("男")){
                bind=binds.stream().filter(jdTbBind -> jdTbBind.getSex()==1).findFirst().get();
            }else{
                throw new Main4Exception("商品暂不支持上传");
            }
        }
        pageItem.setJdCid(bind.getJdCid());
        return pageItem;
    }

    /**
     * 获取运费模版
     * @param jdUserId
     * @return
     * @throws JdUpException
     */
    public List<DeliveryTemplate> selPostModel(Long jdUserId) throws JdUpException {
        List<JdPostTemplateVO> jdPostTemplateVOS=jdOrderService.getPostTemplates(jdUserId);
        List<DeliveryTemplate> vs=new ArrayList<>();
        DeliveryTemplate v1=new DeliveryTemplate();
        v1.setTemplateId(-1L);
        v1.setName("不使用运费模版");
        vs.add(v1);
        vs.addAll(jdPostTemplateVOS.stream().map(jdPostTemplateVO -> {
            DeliveryTemplate v=new DeliveryTemplate();
            v.setTemplateId(jdPostTemplateVO.getId());
            v.setName(jdPostTemplateVO.getTemplateName());
            return v;
        }).collect(Collectors.toList()));
        return vs;
    }

    /**
     * 更新运费模版
     * @param jdUserId
     * @return
     * @throws JdUpException
     */
    public List<DeliveryTemplate> updatePostModel(Long jdUserId) throws JdUpException {
        List<JdPostTemplateVO> jdPostTemplateVOS=jdOrderService.updatePostTemplates(jdUserId);
        List<DeliveryTemplate> vs=new ArrayList<>();
        DeliveryTemplate v1=new DeliveryTemplate();
        v1.setTemplateId(-1L);
        v1.setName("不使用运费模版");
        vs.add(v1);
        vs.addAll(jdPostTemplateVOS.stream().map(jdPostTemplateVO -> {
            DeliveryTemplate v=new DeliveryTemplate();
            v.setTemplateId(jdPostTemplateVO.getId());
            v.setName(jdPostTemplateVO.getTemplateName());
            return v;
        }).collect(Collectors.toList()));
        return vs;
    }

    /**
     * 获取店内类目
     * @param jdUserId
     * @return
     * @throws JdUpException
     */
    public List<StoreCatVO> selShopCats(Long jdUserId) throws JdUpException {
        List<JdShopCategoryVO> jdShopCategoryVOS=jdCategoryService.getJdSellercats(jdUserId);
        Map<Long,List<JdShopCategoryVO>> map=jdShopCategoryVOS.stream().collect(Collectors.groupingBy(JdShopCategoryVO::getParentId));
        return map.get(0L).stream().map(jdShopCategoryVO -> {
            StoreCatVO vo=new StoreCatVO();
            vo.setCatId(jdShopCategoryVO.getCid());
            vo.setName(jdShopCategoryVO.getName());
            List<JdShopCategoryVO> vv=map.get(jdShopCategoryVO.getCid());
            if(vv!=null){
                vo.setSubCat(vv.stream().map(jdShopCategoryVO1 -> {
                    StoreCatVO svo=new StoreCatVO();
                    svo.setName(jdShopCategoryVO1.getName());
                    svo.setCatId(jdShopCategoryVO1.getCid());
                    return svo;
                }).collect(Collectors.toList()));
            }
            return vo;
        }).collect(Collectors.toList());
    }

    /**
     * 更新店内类目
     * @param jdUserId
     * @return
     * @throws JdUpException
     */
    public List<StoreCatVO> updateShopCats(Long jdUserId) throws JdUpException {
        List<JdShopCategoryVO> jdShopCategoryVOS=jdCategoryService.getJdSellercats(jdUserId);
        Map<Long,List<JdShopCategoryVO>> map=jdShopCategoryVOS.stream().collect(Collectors.groupingBy(JdShopCategoryVO::getParentId));
        return map.get(0L).stream().map(jdShopCategoryVO -> {
            StoreCatVO vo=new StoreCatVO();
            vo.setCatId(jdShopCategoryVO.getCid());
            vo.setName(jdShopCategoryVO.getName());
            List<JdShopCategoryVO> vv=map.get(jdShopCategoryVO.getCid());
            if(vv!=null){
                vo.setSubCat(vv.stream().map(jdShopCategoryVO1 -> {
                    StoreCatVO svo=new StoreCatVO();
                    svo.setName(jdShopCategoryVO1.getName());
                    svo.setCatId(jdShopCategoryVO1.getCid());
                    return svo;
                }).collect(Collectors.toList()));
            }
            return vo;
        }).collect(Collectors.toList());
    }

    /**
     * 查类目路径
     * @return
     */
    public String selCatPath(Long cid){
        ShiguJdcat st=shiguJdcatMapper.selectByPrimaryKey(cid);
        if(st!=null){
            if(st.getParentCname()!=null){
                return st.getParentCname()+" > "+st.getCname();
            }else{
                return st.getCname();
            }
        }
        return "";
    }



    public PropsVO selProps(Long goodsId,Long jdCid,Long jdUserId,Item item) throws Main4Exception, CloneNotSupportedException, IOException, ClassNotFoundException {
        PropsVO tbPropsVO=propsService.selProps(item.getCid());
        tbPropsVO=propsService.importValue(tbPropsVO,item.getPropsName(), BeanMapper.mapList(item.getItemImgs(), PropImg.class),item.getPropertyAlias(),item
                .getInputStr(),item.getInputPids());
        PropsVO prop=find(item,jdUserId,jdCid);
        fillPropValue(prop.getColor(),tbPropsVO.getColor());
        fillProp(prop.getSaleProps(),tbPropsVO.getSaleProps());
        fillProp(prop.getProperties(),tbPropsVO.getProperties());
        for(PropertyItemVO p:prop.getProperties()){
            if("颜色".equals(p.getName())&&!p.getType().equals(PropType.INPUT)){
                fillPropValue(p,tbPropsVO.getColor());
                break;
            }
        }
        fillProp(prop.getProperties(),tbPropsVO.getSaleProps());
        fillProp(prop.getSpecification(),tbPropsVO.getProperties());
        prop.setSkus(propsService.calculateSku(prop.getColor(),prop.getSaleProps()));
        return prop;
    }


    private PropsVO find(Item item,Long jdUserId,Long jdCid) throws Main4Exception {
        Cache cache=ehCacheManager.getCache("jdProps");
        PropsVO prop=cache.get("jdprop_"+jdUserId+"_"+item.getCid(),PropsVO.class);
        if(prop!=null){
            return prop;
        }
        prop=new PropsVO();
        JdItemPropExample jdItemPropExample=new JdItemPropExample();
        jdItemPropExample.createCriteria().andCidEqualTo(jdCid);
        List<JdItemProp> jdItemProps=jdItemPropMapper.selectByExample(jdItemPropExample);
        jdItemProps.sort(Comparator.comparingLong(JdItemProp::getSortOrder));

        JdPropValueExample jdPropValueExample=new JdPropValueExample();
        jdPropValueExample.createCriteria().andCidEqualTo(jdCid);
        List<JdPropValue> jdPropValues=jdPropValueMapper.selectByExample(jdPropValueExample);
        Map<Long,List<JdPropValue>> jdPropValueMap=jdPropValues.stream().collect(Collectors.groupingBy(JdPropValue::getPid));

        prop.setCid(item.getCid());
        List<PropertyItemVO> saleProps=new ArrayList<>();
        List<PropertyItemVO> properties=new ArrayList<>();
        List<PropertyItemVO> specProps=new ArrayList<>();
        for(JdItemProp jdItemProp:jdItemProps){
            List<JdPropValue> values=jdPropValueMap.get(jdItemProp.getPid());
            if((jdItemProp.getIsEnumProp()==1&&(values==null||values.size()==0))||jdItemProp.getIsSaleProp()==1){
                List<JdCategoryAttrValueJosVO> values1=jdCategoryService.getCategoryReadFindValuesByAttrId(jdUserId,jdItemProp.getPid());
                values=values1.stream().map(jdCategoryAttrValueJosVO -> {
                    JdPropValue v=new JdPropValue();
                    v.setCid(jdItemProp.getCid());
                    v.setIsParent(0);
                    v.setName(jdCategoryAttrValueJosVO.getAttrValue());
                    v.setPid(jdItemProp.getPid());
                    v.setPropName(jdItemProp.getName());
                    v.setVid(jdCategoryAttrValueJosVO.getAttrValueId());
                    v.setStatus("1");
                    v.setSortOrder(jdCategoryAttrValueJosVO.getAttrValueIndexId().longValue());
                    return v;
                }).collect(Collectors.toList());
                if(values==null||values.size()==0){
                    continue;
                }
                jdPropValueMap.put(jdItemProp.getPid(),values);
            }
            if(jdItemProp.getIsSaleProp()==1){
                jdItemProp.setIsAllowAlias(1);
            }
            PropertyItemVO pv=new PropertyItemVO();
            pv.setCanAlias(jdItemProp.getIsAllowAlias()==1);
            pv.setMustHave(jdItemProp.getMust()==1);
            pv.setName(jdItemProp.getName());
            pv.setPid(jdItemProp.getPid());
            if(jdItemProp.getIsEnumProp()==1){
                if(jdItemProp.getMulti()==1){
                    pv.setType(PropType.CHECKBOX);
                }else{
                    pv.setType(PropType.SELECT);
                }
            }else{
                pv.setType(PropType.INPUT);
            }
            if(jdItemProp.getIsBrand()!=1&&values!=null){
                pv.addPropValueList(values.stream().map(jdPropValue -> {
                    PropertyValueVO propertyValueVO=new PropertyValueVO();
                    propertyValueVO.setName(jdPropValue.getName());
                    propertyValueVO.setVid(jdPropValue.getVid());
                    propertyValueVO.setSelected(false);
                    return propertyValueVO;
                }).collect(Collectors.toList()));
            }
            if(jdItemProp.getIsSaleProp()==1){
                if(jdItemProp.getIsColorProp()==1){
                    prop.setColor(pv);
                    continue;
                }
                if("款式".equals(jdItemProp.getName())){
                    properties.add(pv);
                    continue;
                }
                saleProps.add(pv);
                continue;
            }
            if(jdItemProp.getIsBrand()==1){
                List<JdVenderBrandPubInfoVO> allBrand = jdCategoryService.getAllBrand(jdUserId);
                pv.addPropValueList(allBrand.stream().map(jdVenderBrandPubInfoVO -> {
                    PropertyValueVO vv=new PropertyValueVO();
                    vv.setVid(new Long(jdVenderBrandPubInfoVO.getErpBrandId()));
                    vv.setName(jdVenderBrandPubInfoVO.getBrandName());
                    return vv;
                }).collect(Collectors.toList()));
                prop.setPingpai(pv);
                continue;
            }
            if(jdItemProp.getIsItemProp()==1){
                specProps.add(pv);
                continue;
            }
            properties.add(pv);
        };

        prop.setProperties(properties);
        prop.setSaleProps(saleProps);
        prop.setSpecification(specProps);
        cache.put("jdprop_"+jdUserId+"_"+item.getCid(),prop);
        return prop;
    }


    private void fillProp(List<PropertyItemVO> jdVS,List<PropertyItemVO> tbVS){
        for(PropertyItemVO jdV:jdVS){
            for(PropertyItemVO tbV:tbVS){
                if(tbV.getName().equals(jdV.getName())){
                    if(jdV.getType().equals(PropType.INPUT)){
                        if(tbV.getValues().size()>0){
                            if(tbV.getType().equals(PropType.INPUT)){
                                PropertyValueVO propertyValueVO=tbV.getValues().get(0);
                                if(!StringUtils.isEmpty(propertyValueVO.getName())){
                                    PropertyValueVO pp = new PropertyValueVO();
                                    pp.setName(propertyValueVO.getName());
                                    pp.setVid(-1L);
                                    jdV.addPropValue(pp);
                                    break;
                                }
                            }else{
                                List<PropertyValueVO> tbvvs=tbV.getValues().stream().filter(propertyValueVO ->
                                    propertyValueVO.isSelected()&&!StringUtils.isEmpty(propertyValueVO.getName())
                                ).collect(Collectors.toList());
                                if(tbvvs.size()>0){
                                    PropertyValueVO pp = new PropertyValueVO();
                                    pp.setName(tbvvs.get(0).getName());
                                    pp.setVid(-1L);
                                    jdV.addPropValue(pp);
                                    break;
                                }
                            }
                        }
                        break;
                    }
                    fillPropValue(jdV,tbV);
                }
            }
        }
    }
    private void fillPropValue(PropertyItemVO jdV,PropertyItemVO tbV){
        List<PropertyValueVO> jdValues=jdV.getValues();
        Map<Long,PropertyValueVO> tbMap=new HashMap<>();
        Set<Long> removeKey=new HashSet<>();
        for(PropertyValueVO tb:tbV.getValues()){
            if(tb.isSelected()){
                if(jdV.isCanAlias()){
                    tbMap.put(tb.getVid(),tb);
                }
                for(PropertyValueVO jd:jdValues){
                    if(tb.getOldName()==null){
                        break;
                    }
                    if(tb.getOldName().equals(jd.getName())||(jd.getName().replace("型","").equals(tb.getOldName()))){
                        jd.setSelected(true);
                        if(!jdV.getType().equals(PropType.SELECT)){
                            jd.setName(tb.getName());
                        }
                        jd.setImgUrl(tb.getImgUrl());
                        tbMap.remove(tb.getVid());
                        removeKey.add(jd.getVid());
                        break;
                    }
                }
            }
        }
        if(tbMap.size()>0){
            List<PropertyValueVO> tbs= new ArrayList<>(tbMap.values());
            for(PropertyValueVO jd:jdValues){
                if(removeKey.contains(jd.getVid())){
                    continue;
                }
                PropertyValueVO tb=tbs.get(0);
                jd.setName(tb.getName());
                jd.setSelected(true);
                jd.setImgUrl(tb.getImgUrl());
                tbs.remove(0);
                if(tbs.size()==0){
                    break;
                }
            }
        }
    }
    private Item parseGoodsTinyToItem(Item it,ShiguGoodsTiny sgt){
        it.setDetailUrl(sgt.getDetailUrl());
        it.setNumIid(sgt.getNumIid());
        it.setTitle(sgt.getTitle());
        it.setNick(sgt.getNick());
        it.setType(sgt.getType());
        it.setCreated(sgt.getCreated());

        it.setValidThru(sgt.getValidThru());
        it.setOuterId(sgt.getOuterId());
        it.setCid(sgt.getCid());
        it.setSellerCids(sgt.getCidAll());
        it.setPicUrl(sgt.getPicUrl());
        it.setNum(sgt.getNum());
        it.setListTime(sgt.getListTime());
        it.setDelistTime(sgt.getDelistTime());
        it.setStuffStatus(sgt.getStuffStatus());
        it.setPrice(sgt.getPriceString());
        it.setPostFee(sgt.getPostFee());
        it.setExpressFee(sgt.getExpressFee());
        it.setEmsFee(sgt.getEmsFee());

        it.setModified(sgt.getModified());

        Location loc=new Location();
        loc.setCity(sgt.getCity());
        loc.setState(sgt.getProv());
        it.setLocation(loc);
        return it;
    }
    /**
     * 转化goodsExtends信息到item
     * @param it
     * @param sge
     * @return
     */
    private Item parseGoodsExtendsToItem(Item it,ShiguGoodsExtends sge){
        it.setDesc(sge.getGoodsDesc());
        it.setPropsName(sge.getPropsName());
        //it.setAuctionPoint(auctionPoint)
        it.setPropertyAlias(sge.getPropertyAlias());
        it.setTemplateId(sge.getTemplateId());
        it.setAfterSaleId(sge.getAfterSaleId());
        it.setSubStock(sge.getSubStock());
        it.setInnerShopAuctionTemplateId(sge.getInnerShopAuctionTemplateId());
        it.setOuterShopAuctionTemplateId(sge.getOuterShopAuctionTemplateId());
        it.setFeatures(sge.getFeatures());
        it.setItemWeight(sge.getItemWeight());
        it.setItemSize(sge.getItemSize());
        it.setWithHoldQuantity(sge.getWithHoldQuantity());
        it.setCustomMadeTypeId(sge.getCustomMadeTypeId());
        it.setWirelessDesc(sge.getWirelessDesc());
        it.setSellerCids(sge.getSellerCids());
        it.setProps(sge.getProps());
        it.setInputPids(sge.getInputPids());
        it.setInputStr(sge.getInputStr());
        //**处理5个首图
        if(!"".equals(sge.getImages())&&sge.getImages()!=null){
            String[] imgs=sge.getImages().split(",");
            List<ItemImg> itemImgs=new ArrayList<ItemImg>();
            for(String im:imgs){
                ItemImg ii=new ItemImg();
                ii.setUrl(im);
                itemImgs.add(ii);
            }
            it.setItemImgs(itemImgs);
        }
        if("true".equals(sge.getIsTaobao())){
            it.setIsTaobao(true);
        }

        it.setWapDesc(sge.getWapDesc());
        it.setWapDetailUrl(sge.getWapDetailUrl());
        it.setCodPostageId(sge.getCodPostageId());

        return it;
    }
    private List<TaobaoPropimg> selNewPropimg(Long goodsId){
        ShiguPropImgsExample example=new ShiguPropImgsExample();
        example.createCriteria().andItemIdEqualTo(goodsId);
        List<ShiguPropImgs> propImgses=shiguPropImgsMapper.selectByExample(example);
        if(propImgses.size()>0){
            List<TaobaoPropimg> propimgs=new ArrayList<>();
            ShiguPropImgs imgs=propImgses.get(0);
            String propimgstr=imgs.getPropimgs();
            if(propimgstr==null||"".equals(propimgstr)){
                return new ArrayList<>();
            }
            String[] proparr=propimgstr.split(";");
            for(String p:proparr){
                if(!p.contains("##")) continue;
                String[] parr=p.split("##");
                TaobaoPropimg tp=new TaobaoPropimg();
                tp.setProperties(parr[0]);
                tp.setUrl(parr[1]);
                propimgs.add(tp);
            }
            return propimgs;
        }else{
            return new ArrayList<>();
        }
    }
    /**
     * 转化属性图到Item
     * @param it
     * @param imgList
     * @return
     */
    private Item parsePropImgToItem(Item it,List<TaobaoPropimg> imgList){
        if(imgList!=null&&imgList.size()>0){
            List<PropImg> prolist=new ArrayList<PropImg>();
            for(TaobaoPropimg tp:imgList){
                PropImg pi=new PropImg();
                pi.setCreated(tp.getCreateTime());
                pi.setId(tp.getId());
                pi.setPosition(tp.getPosition()!=null?tp.getPosition().longValue():null);
                pi.setProperties(tp.getProperties());
                pi.setUrl(tp.getUrl());
                prolist.add(pi);
            }
            it.setPropImgs(prolist);
        }
        return it;
    }
    /**
     * 静态包装数据
     * @param sgt
     * @return
     */
    private Item staticGoods(ShiguGoodsTiny sgt){
        Item it=new Item();
        //把微表数据奉上
        it=parseGoodsTinyToItem(it, sgt);
        //把扩展表数据奉上
        ShiguGoodsExtends sge=new ShiguGoodsExtends();
        sge.setGoodsId(sgt.getGoodsId());
        sge.setWebSite(sgt.getWebSite());
        sge=shiguGoodsExtendsMapper.selectByPrimaryKey(sge);
        it=parseGoodsExtendsToItem(it, sge);
        //把属性图数据奉上,有numIid的商品有资格取这个
        if(sgt.getNumIid()!=null){
            List<TaobaoPropimg> list=selNewPropimg(sgt.getGoodsId());
            if(list.size()>0){
                it=parsePropImgToItem(it, list);
            }
        }
        return it;
    }
}
