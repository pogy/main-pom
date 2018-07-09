package com.shigu.goodsup.sn.service;

import com.openJar.beans.SnShopCategory;
import com.openJar.requests.api.SnFreightTemplateRequest;
import com.openJar.requests.api.SnItemParametersRequest;
import com.openJar.requests.api.SnShopCategoryRequest;
import com.openJar.responses.api.SnFreightTemplateResponse;
import com.openJar.responses.api.SnItemParametersResponse;
import com.openJar.responses.api.SnShopCategoryResponse;
import com.opentae.data.mall.beans.ShiguGoodsExtends;
import com.opentae.data.mall.beans.ShiguGoodsIdGenerator;
import com.opentae.data.mall.beans.ShiguGoodsTiny;
import com.opentae.data.mall.beans.ShopNumAndMarket;
import com.opentae.data.mall.interfaces.*;
import com.shigu.goodsup.jd.exceptions.AuthOverException;
import com.shigu.goodsup.jd.exceptions.CustomException;
import com.shigu.goodsup.jd.service.JdUpItemService;
import com.shigu.goodsup.jd.service.PropsService;
import com.shigu.goodsup.jd.util.XzJdSdkSend;
import com.shigu.goodsup.jd.vo.StoreCatVO;
import com.shigu.goodsup.sn.vo.PropItemVo;
import com.shigu.goodsup.sn.vo.PropValueVo;
import com.shigu.goodsup.sn.vo.SnPageItem;
import com.shigu.goodsup.sn.vo.SnPropsVo;
import com.shigu.tb.finder.vo.PropType;
import com.shigu.tools.KeyWordsUtil;
import com.suning.api.entity.custom.NewbrandQueryResponse;
import com.suning.api.entity.item.ItemparametersQueryResponse;
import com.suning.api.entity.sale.FreighttemplateQueryResponse;
import com.taobao.api.domain.DeliveryTemplate;
import com.taobao.api.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SnUpItemService {

    @Autowired
    ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;
    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;
    @Autowired
    ShiguShopMapper shiguShopMapper;
    @Autowired
    JdUpItemService jdUpItemService;
    @Autowired
    XzJdSdkSend xzJdSdkSend;
    @Autowired
    PropsService propsService;
    @Autowired
    ShiguGoodsExtendsMapper shiguGoodsExtendsMapper;
    @Autowired
    TaobaoPropValueMapper taobaoPropValueMapper;

    public SnPageItem findGoods(Long goodsId) throws CustomException {
        ShiguGoodsTiny shiguGoodsTiny = selTiny(goodsId);
        SnPageItem snPageItem = new SnPageItem();
        snPageItem.setNumIid(shiguGoodsTiny.getNumIid());
        snPageItem.setStoreId(shiguGoodsTiny.getStoreId());
        snPageItem.setWebSite(shiguGoodsTiny.getWebSite());
        snPageItem.setGoodsId(shiguGoodsTiny.getGoodsId());
        snPageItem.setHuohao(shiguGoodsTiny.getGoodsNo());
        snPageItem.setGoodsId(goodsId);
        snPageItem.setPiPrice(shiguGoodsTiny.getPiPriceString());
        if (shiguGoodsTiny.getStoreId() != null) {
            List<Long> storeIds = new ArrayList<>();
            storeIds.add(shiguGoodsTiny.getStoreId());
            List<ShopNumAndMarket> gmi = shiguShopMapper.selShopNumAndMarkets(storeIds);
            if (gmi.size() > 0) {
                snPageItem.setParentMarketName(gmi.get(0).getMarket());
                snPageItem.setStoreNum(gmi.get(0).getShopNum());
            }
        }
        Item item = jdUpItemService.staticGoods(shiguGoodsTiny);
        item.setTitle(KeyWordsUtil.duleKeyWords(item.getTitle()));
        item.setDesc(KeyWordsUtil.duleKeyWords(item.getDesc()));
        snPageItem.setItem(item);
        if (shiguGoodsTiny.getNumIid() == null) {
            snPageItem.setGoodsType(2);
        } else {
            snPageItem.setGoodsType(1);
        }
        snPageItem.setDataType(2);

        return snPageItem;
    }

    public ShiguGoodsTiny selTiny(Long goodsId) throws CustomException {
        ShiguGoodsIdGenerator shiguGoodsIdGenerator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(goodsId);
        if (shiguGoodsIdGenerator == null) {
            throw new CustomException(goodsId + " goodsId生成表没找到");
        }
        ShiguGoodsTiny shiguGoodsTiny = new ShiguGoodsTiny();
        shiguGoodsTiny.setGoodsId(goodsId);
        shiguGoodsTiny.setWebSite(shiguGoodsIdGenerator.getWebSite());
        shiguGoodsTiny = shiguGoodsTinyMapper.selectByPrimaryKey(shiguGoodsTiny);
        if (shiguGoodsTiny == null) {
            throw new CustomException(goodsId + " goodsTiny表没找到");
        }
        return shiguGoodsTiny;
    }

    /**
     * 获取运费模板
     *
     * @param username
     * @return
     * @throws AuthOverException
     * @throws CustomException
     */
    public List<DeliveryTemplate> selPostModel(String username) throws AuthOverException, CustomException {
        List<DeliveryTemplate> vs = new ArrayList<>();
        DeliveryTemplate v1 = new DeliveryTemplate();
        v1.setTemplateId(-1L);
        v1.setName("不使用运费模版");
        vs.add(v1);
        SnFreightTemplateRequest request = new SnFreightTemplateRequest();
        request.setUsername(username);
        SnFreightTemplateResponse response = xzJdSdkSend.send(request);
        if (!response.isSuccess()) {
            return vs;
        }
        List<FreighttemplateQueryResponse.QueryFreighttemplate> list = response.getQueryFreighttemplateList();
        if (list == null) {
            return vs;
        } else {
            vs.addAll(list.stream().map(l -> {
                DeliveryTemplate v = new DeliveryTemplate();
                v.setTemplateId(Long.valueOf(l.getFreighttemplateid()));
                v.setName(l.getFreighttemplatename());
                return v;
            }).collect(Collectors.toList()));
            return vs;
        }
    }

    public List<StoreCatVO> selShopCats(String username) throws AuthOverException, CustomException {
        SnShopCategoryRequest request = new SnShopCategoryRequest();
        request.setUsername(username);
        SnShopCategoryResponse response = xzJdSdkSend.send(request);
        if (!response.isSuccess()) {
            return new ArrayList<>();
        }
        List<SnShopCategory> shopCategories = response.getSnShopCategories();
        if (shopCategories == null) {
            return null;
        } else {
            Map<Integer, List<SnShopCategory>> map = shopCategories.stream().collect(Collectors.groupingBy(SnShopCategory::getIsFirst));
            return map.get(0).stream().map(shopCategory -> {
                StoreCatVO vo = new StoreCatVO();
                vo.setCatId(Long.valueOf(shopCategory.getCategoryCode()));
                vo.setName(shopCategory.getCategoryName());
                vo.setSubCat(map.get(1).stream().map(shopCategory1 -> {
                    StoreCatVO svo = new StoreCatVO();
                    svo.setName(shopCategory1.getCategoryName());
                    svo.setCatId(Long.valueOf(shopCategory1.getCategoryCode()));
                    return svo;
                }).collect(Collectors.toList()));
                return vo;
            }).collect(Collectors.toList());
        }
    }

    public SnPropsVo selProps(Long goodId, String categoryCode, String username, List<NewbrandQueryResponse.QueryNewbrand> brands) throws AuthOverException, CustomException {
        //PropsVO tbPropsVO=propsService.selProps(item.getCid());
        /*List<PropImg> propImgs=item.getPropImgs();
        if (propImgs == null) {
            propImgs=new ArrayList<>();
        }
        tbPropsVO=propsService.importValue(tbPropsVO,item.getPropsName(), BeanMapper.mapList(propImgs, PropImg.class),item.getPropertyAlias(),item
                .getInputStr(),item.getInputPids());
        PropsVO prop=new PropsVO();
        jdUpItemService.fillPropValue(prop.getColor(),tbPropsVO.getColor());
        jdUpItemService.fillProp(prop.getSaleProps(),tbPropsVO.getSaleProps());
        jdUpItemService.fillProp(prop.getProperties(),tbPropsVO.getProperties());
        for(PropertyItemVO p:prop.getProperties()){
            if("颜色".equals(p.getName())&&p.getType().equals(PropType.CHECKBOX)){
                jdUpItemService.fillPropValue(p,tbPropsVO.getColor());
                break;
            }
        }
        jdUpItemService.fillProp(prop.getProperties(),tbPropsVO.getSaleProps());
        jdUpItemService.fillProp(prop.getSpecification(),tbPropsVO.getProperties());
        prop.setSkus(propsService.calculateSku(prop.getColor(),prop.getSaleProps()));*/
        PropItemVo pivBrand = new PropItemVo();
        pivBrand.setMustHave(true);
        List<PropValueVo> values = new ArrayList<>();
        PropValueVo propertyValueVO = new PropValueVo();
        propertyValueVO.setName(brands.get(0).getBrandName());
        propertyValueVO.setSelected(true);
        propertyValueVO.setFid(2);
        propertyValueVO.setSubPropItem(null);
        propertyValueVO.setSnId(brands.get(0).getBrandCode());
        values.add(propertyValueVO);
        pivBrand.setValues(values);
        SnItemParametersRequest reqeust = new SnItemParametersRequest();
        reqeust.setUsername(username);
        reqeust.setCategoryCode(categoryCode);
        SnItemParametersResponse response = xzJdSdkSend.send(reqeust);
        List<ItemparametersQueryResponse.ItemparametersQuery> list = response.getItemparametersQueries();
        SnPropsVo pv = new SnPropsVo();
        pv.setPingpai(pivBrand);
        pv.setProperties(fillProp(list, "", goodId,0));
        pv.setColor(fillProp(list, "common", goodId,1).get(0));
        pv.setSaleProps(fillProp(list,"common",goodId,2));
        return pv;
    }

    private List<PropItemVo> fillProp(List<ItemparametersQueryResponse.ItemparametersQuery> list, String type, Long goodId,int status) throws CustomException {
        List<PropItemVo> pv = new ArrayList<>();
        ShiguGoodsIdGenerator shiguGoodsIdGenerator = new ShiguGoodsIdGenerator();
        shiguGoodsIdGenerator.setGoodId(goodId);
        shiguGoodsIdGenerator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(shiguGoodsIdGenerator);
        if (shiguGoodsIdGenerator == null) {
            throw new CustomException("商品id不存在");
        }
        ShiguGoodsExtends shiguGoodsExtends = new ShiguGoodsExtends();
        shiguGoodsExtends.setGoodsId(goodId);
        shiguGoodsExtends.setWebSite(shiguGoodsIdGenerator.getWebSite());
        shiguGoodsExtends = shiguGoodsExtendsMapper.selectByPrimaryKey(shiguGoodsExtends);
        if (shiguGoodsExtends == null) {
            throw new CustomException("商品详情不存在");
        }
        Map<String, String> propMap = new HashMap<>();
        if (shiguGoodsExtends.getPropsName() == null) {
            propMap = null;
        }
        propMap = changeProp(shiguGoodsExtends.getPropsName());
        PropItemVo p = new PropItemVo();
        PropItemVo p1=new PropItemVo();
        for (ItemparametersQueryResponse.ItemparametersQuery itemparametersQuery : list) {
            String snType = itemparametersQuery.getParaTemplateCode();
            if (snType.equals("basic")) {
                continue;
            }
            boolean flag = true;
            if (type.equals("common")) {
                flag = false;
            }
            if (flag && !snType.equals("common")) {
                pv.add(addProp(itemparametersQuery, propMap));
            } else if (snType.equals(type)) {
                if(status==1) {
                    if (itemparametersQuery.getParName().equals("色卡")) {
                        p = addProp(itemparametersQuery, propMap);
                    }
                    if (itemparametersQuery.getParName().equals("颜色")) {
                        p1 = addProp(itemparametersQuery, propMap);
                    }
                }else if(status==2){
                    if (!itemparametersQuery.getParCode().equals("G00000")&&!itemparametersQuery.getParCode().equals("G00001")&&!itemparametersQuery.getParCode().equals("G00002")) {
                        p = addProp(itemparametersQuery, propMap);
                    }
                    if (itemparametersQuery.getParName().equals("尺码")) {
                        p1 = addProp(itemparametersQuery, propMap);
                    }
                }
            }
        }
        if(!type.equals("")) {
            p1.addPropValueList(p.getValues());
            pv.add(p1);
        }
        return pv;
    }

    private Map<String, String> changeProp(String propName) {
        if (propName.equals("")) {
            return null;
        }
        Map<String, String> map = new HashMap<>();
        String[] props = propName.split(";");
        for (String s : props) {
            String[] prop = s.split(":");
            map.put(prop[2], prop[3]);
        }
        return map;
    }

    private PropItemVo addProp(ItemparametersQueryResponse.ItemparametersQuery itemparametersQuery, Map<String, String> propMap) {
        PropItemVo propItemVo = new PropItemVo();
        if (itemparametersQuery.getIsMust().equals("X")) {
            propItemVo.setMustHave(true);
        } else {
            propItemVo.setMustHave(false);
        }
        if (itemparametersQuery.getParType().equals("1")) {
            propItemVo.setType(PropType.SELECT);
        } else if (itemparametersQuery.getParType().equals("2")) {
            propItemVo.setType(PropType.CHECKBOX);
        } else if (itemparametersQuery.getParType().equals("3")) {
            propItemVo.setType(PropType.INPUT);
        }
        propItemVo.setCanAlias(false);
        propItemVo.setName(itemparametersQuery.getParName());
        List<PropValueVo> propValueVos = new ArrayList<>();
        List<ItemparametersQueryResponse.ParOption> parOptions = itemparametersQuery.getParOption();
        if (parOptions == null) {
            propItemVo.setValues(null);
        } else {
            fill(propMap,parOptions,propValueVos,propItemVo);
        }
        propItemVo.setSnCode(itemparametersQuery.getParCode());
        propItemVo.setValues(propValueVos);
        return propItemVo;
    }

    private void fill(Map<String, String> propMap,List<ItemparametersQueryResponse.ParOption> parOptions,List<PropValueVo> propValueVos,PropItemVo propItemVo){
        if (propMap == null) {
            for (ItemparametersQueryResponse.ParOption p : parOptions) {
                PropValueVo propValueVo = new PropValueVo();
                propValueVo.setName(p.getParOptionDesc());
                propValueVo.setSnId(p.getParOptionCode());
                propValueVo.setSelected(false);
                propValueVos.add(propValueVo);
            }
        } else {
            String propName = propMap.get(propItemVo.getName());
            for (ItemparametersQueryResponse.ParOption p : parOptions) {
                PropValueVo propValueVo = new PropValueVo();
                propValueVo.setName(p.getParOptionDesc());
                if (propValueVo.getName().equals(propName)) {
                    propValueVo.setSelected(true);
                }
                propValueVo.setSnId(p.getParOptionCode());
                propValueVos.add(propValueVo);
            }
        }
    }
}
