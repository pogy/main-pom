package com.shigu.main4.cdn.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ItemTradeForbidExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.examples.ShiguTempExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.cdn.bo.ScGoodsBO;
import com.shigu.main4.cdn.bo.ScStoreBO;
import com.shigu.main4.cdn.exceptions.CdnException;
import com.shigu.main4.cdn.vo.CatPolyFormatVO;
import com.shigu.main4.cdn.vo.ShopIconCopyrightVO;
import com.shigu.main4.cdn.vo.ShopShowVO;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.enums.ShopLicenseTypeEnum;
import com.shigu.main4.item.services.ShowForCdnService;
import com.shigu.main4.item.vo.CdnItem;
import com.shigu.main4.item.vo.NormalProp;
import com.shigu.main4.item.vo.SaleProp;
import com.shigu.main4.monitor.services.ItemBrowerService;
import com.shigu.main4.newcdn.vo.*;
import com.shigu.main4.order.process.ItemProductProcess;
import com.shigu.main4.storeservices.ShopBaseService;
import com.shigu.main4.storeservices.ShopForCdnService;
import com.shigu.main4.storeservices.ShopLicenseService;
import com.shigu.main4.storeservices.StoreRelationService;
import com.shigu.main4.ucenter.exceptions.ItemCollectionException;
import com.shigu.main4.ucenter.exceptions.ShopCollectionException;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.main4.ucenter.vo.ItemCollect;
import com.shigu.main4.ucenter.vo.ShopCollect;
import com.shigu.main4.ucenter.webvo.ShopCollectVO;
import com.shigu.main4.vo.*;
import com.shigu.seller.services.GoodsFileService;
import com.shigu.seller.services.ShopDesignService;
import com.shigu.tools.HtmlImgsLazyLoad;
import freemarker.template.TemplateException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * cdn服务
 * Created by zhaohongbo on 17/3/7.
 */
@Service
public class CdnService {

    @Autowired
    UserCollectService userCollectService;

    @Autowired
    ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;

    @Autowired
    ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    ShiguShopMapper shiguShopMapper;

    @Autowired
    ShopForCdnService shopForCdnService;

    @Autowired
    ShopBaseService shopBaseService;

    @Autowired
    StoreRelationService storeRelationService;

    @Autowired
    ShopLicenseService shopLicenseService;

    @Autowired
    ShopDesignService shopDesignService;
    @Autowired
    ShowForCdnService showForCdnService;
    @Autowired
    ItemBrowerService itemBrowerService;
    @Autowired
    ShiguShopLicenseMapper shiguShopLicenseMapper;
    @Autowired
    GoodsFileService goodsFileService;
    @Autowired
    ItemProductProcess itemProductProcess;

    @Autowired
    ShiguTempMapper shiguTempMapper;

    /**
     * 禁止销售的
     */
    @Autowired
    ItemTradeForbidMapper itemTradeForbidMapper;

    /**
     * banner部分的html
     * @param shopId
     * @return
     */
    public String bannerHtml(Long shopId,String webSite) throws IOException, TemplateException {
        return shopDesignService.selHeadModuleWithData(shopId,webSite,false).getHtml();
    }

    /**
     * 重组聚合数据
     * @param shopId
     * @return
     */
    public List<CatPolymerization> formatCatPoly(Long shopId){
        List<CatPolymerization> cats=shopForCdnService.selCatRolymerizations(shopId);
        List<CatPolyFormatVO> polys=new ArrayList<>();
        for(CatPolymerization c:cats){
            polys.add(new CatPolyFormatVO(c));
        }
        Collections.sort(polys);
        List<CatPolymerization> result=new ArrayList<>();
        CatPolymerization other=new CatPolymerization();
        other.setCid(404L);
        other.setName("其它");
        other.setSubPolymerizations(new ArrayList<CatPolymerization>());
        for(int i=0;i<polys.size();i++){
            if(i>1){
                List<CatPolymerization> sub=other.getSubPolymerizations();
                if(sub.size()<10){
                    CatPolymerization me=polys.get(i).getCatpoly();
                    if(me.getSubPolymerizations()==null){
                        sub.add(me);
                    }else{
                        List<CatPolymerization> mesub=me.getSubPolymerizations();
                        sub.addAll(mesub);
                    }
                }
            }else{
                result.add(polys.get(i).getCatpoly());
            }
        }
        if(polys.size()>2){
            result.add(other);
        }
        return result;
    }


    /**
     * 收藏商品
     * @param userId
     * @param bo
     * @return
     */
    public boolean addItemCollect(Long userId,ScGoodsBO bo){
        ItemCollect itemCollect=new ItemCollect();
        itemCollect.setUserId(userId);
        //查出店、webSite
        ShiguGoodsIdGenerator sgig=shiguGoodsIdGeneratorMapper.selectByPrimaryKey(bo.getGoodsId());
        if(sgig==null){
            return false;
        }
        ShiguGoodsTiny sgt=new ShiguGoodsTiny();
        sgt.setGoodsId(bo.getGoodsId());
        sgt.setWebSite(sgig.getWebSite());
        sgt=shiguGoodsTinyMapper.selectFieldsByPrimaryKey(sgt, FieldUtil.codeFields("goods_id,store_id"));
        if(sgt==null){
            return false;
        }
        itemCollect.setItemId(bo.getGoodsId());
        itemCollect.setStoreId(sgt.getStoreId());
        itemCollect.setWebsite(sgig.getWebSite());
        try {
            userCollectService.addItemCollection(itemCollect);
        } catch (ItemCollectionException e) {
            return false;
        }
        return true;
    }

    /**
     * 收藏店铺
     * @param userId
     * @param bo
     * @return
     */
    public boolean addShopCollect(Long userId, ScStoreBO bo){
        ShopCollect shopCollect=new ShopCollect();
        ShiguShop shop=shiguShopMapper.selectFieldsByPrimaryKey(bo.getStore_id(),
                FieldUtil.codeFields("shop_id,web_site"));
        if(shop==null){
            return false;
        }
        shopCollect.setWebsite(shop.getWebSite());
        shopCollect.setUserId(userId);
        shopCollect.setShopId(shop.getShopId());
        try {
            userCollectService.addShopCollection(shopCollect);
        } catch (ShopCollectionException e) {
            return false;
        }
        return true;
    }

    /**
     * 店铺页面基本信息
     * @param shopId
     * @return
     */
    public ShopShowVO shopSimpleVo(Long shopId){
        ShopShowVO shopShowVO=new ShopShowVO();
        shopShowVO.setOther(shopForCdnService.selShopBase(shopId));
        shopShowVO.setDomain(shopBaseService.selDomain(shopId));
        shopShowVO.setHasAuth(shopBaseService.shopAuthState(shopId));
        shopShowVO.setStoreRelation(storeRelationService.selRelationById(shopId));
//        shopShowVO.setShopCats(shopForCdnService.selShopCatsById(bo.getId()));
        //查商品
        shopShowVO.setShopLicenses(shopLicenseService.selShopLicenses(shopId));
        //得到商品ID
        shopShowVO.setGoodsNum(shopForCdnService.selItemNumberById(shopId,shopShowVO.getStoreRelation().getWebSite()));
        Long starNum=shopForCdnService.selShopStarById(shopId);
        starNum=starNum==null?0:starNum;
        shopShowVO.setStarNum(starNum);
        return shopShowVO;
    }

    /**
     * 查询店内最新几件商品
     * @param shopId
     * @param number
     * @return
     */
    public List<ItemShowBlock> selShopNew(Long shopId,String webSite,Integer number){
        ShiguGoodsTinyExample example=new ShiguGoodsTinyExample();
        example.createCriteria().andStoreIdEqualTo(shopId).andIsClosedEqualTo(0L);
        example.setStartIndex(0);
        example.setEndIndex(number);
        example.setWebSite(webSite);
        example.setOrderByClause("created desc");
        List<ShiguGoodsTiny> tinyList=shiguGoodsTinyMapper.selectFieldsByConditionList(example,
                FieldUtil.codeFields("pic_url,title,goods_id,pi_price,web_site,goods_no"));
        List<ItemShowBlock> blocks=new ArrayList<>();
        for(ShiguGoodsTiny tiny:tinyList){
            ItemShowBlock isb=new ItemShowBlock();
            isb.setWebSite(tiny.getWebSite());
            isb.setShopId(tiny.getStoreId());
            isb.setGoodsNo(tiny.getGoodsNo());
            isb.setItemId(tiny.getGoodsId());
            isb.setImgUrl(tiny.getPicUrl());
            isb.setPrice(isb.parsePrice(tiny.getPiPrice()==null?null:tiny.getPiPrice()));
            isb.setTitle(tiny.getTitle());
            blocks.add(isb);
        }
        return blocks;
    }





//===================================================20170725张峰=======================================================

    /**
     * 检测是否可销售
     * @param marketId
     * @param storeId
     * @param goodsId
     * @param webSite
     * @return
     */
    public boolean canSale(Long marketId,Long storeId,Long goodsId,String webSite){
        if (!webSite.equals("hz")){
            return false;
        }
        ItemTradeForbidExample example=new ItemTradeForbidExample();
        example.createCriteria().andTypeEqualTo(1).andTargetIdEqualTo(marketId);//市场的
        example.or().andTypeEqualTo(2).andTargetIdEqualTo(storeId);//按店来
        example.or().andTypeEqualTo(3).andTargetIdEqualTo(goodsId);//按商品
//        example.or().andTypeEqualTo(4).andTargetIdEqualTo(cid);//按类目
        return itemTradeForbidMapper.countByExample(example)==0;
    }

    /**
     * 商品详情页,商品数据
     * @param goodsId
     * @return
     * @throws CdnException
     */
    public CdnGoodsInfoVO cdnGoodsInfo(Long goodsId) throws CdnException {
        CdnGoodsInfoVO vo=new CdnGoodsInfoVO();
        CdnItem cdnItem=showForCdnService.selItemById(goodsId);
        vo.setOnSale(cdnItem!=null&&cdnItem.getOnsale());
        if(cdnItem==null){//已经下架
            cdnItem=showForCdnService.selItemInstockById(goodsId);
        }
        if(cdnItem==null){//商品不存在
            throw new CdnException("商品不存在");
        }
        vo.setOnlineSale(itemProductProcess.canSale(cdnItem.getMarketId(),cdnItem.getFloorId(),cdnItem.getShopId(),goodsId,cdnItem.getWebSite()));
        vo.setGoodsId(goodsId);
        vo.setGoodsNo(cdnItem.getHuohao());
        vo.setImgUrls(cdnItem.getImgUrl());
        vo.setLiPrice(cdnItem.getPrice());
        vo.setPiPrice(cdnItem.getPiPrice());
        vo.setShopId(cdnItem.getShopId());
        vo.setWebSite(cdnItem.getWebSite());
        vo.setPostTime(cdnItem.getListTime());
        vo.setTitle(cdnItem.getTitle());
        vo.setTbGoodsId(cdnItem.getTbNumIid());
        vo.setViewNum(itemBrowerService.selItemBrower(goodsId));
        if(cdnItem.getDescription()!=null){
            vo.setDescHtml(HtmlImgsLazyLoad.replaceLazyLoad(cdnItem.getDescription()).replace("<script ","")
                    .replace("<script>","")
                    .replace("</script>",""));
        }
        List<NormalProp> nps=cdnItem.getNormalProps();
        List<CdnGoodsPropVO> props=new ArrayList<>();
        for(NormalProp np:nps){
            CdnGoodsPropVO prop=new CdnGoodsPropVO();
            prop.setName(np.getPname());
            prop.setValue(np.getValue());
            props.add(prop);
        }
        vo.setNormalAttrs(props);
        List<String> qys=showForCdnService.selItemLicenses(goodsId,cdnItem.getShopId());
        vo.setServices(qys);

        List<SaleProp> colors=cdnItem.getColors();
        if(colors==null){
            colors=new ArrayList<>();
            SaleProp c=new SaleProp();
            c.setValue("图片色");
            colors.add(c);
        }
        JSONArray array = new JSONArray();
        for(SaleProp c:colors){
            array.add(new JSONObject().element("text", c.getValue()).element("imgSrc", c.getImgUrl()));
        }
        vo.setColorsMeta(array.toString());

        List<SaleProp> sizes=cdnItem.getSizes();
        if(sizes==null){
            sizes=new ArrayList<>();
            SaleProp s=new SaleProp();
            s.setValue("均码");
            sizes.add(s);
        }
        List<String> ss=new ArrayList<>();
        for(SaleProp s:sizes){
            ss.add(s.getValue());
        }
        vo.setSizesMeta(JSONArray.fromObject(ss).toString());
        vo.setHasOriginalPic(goodsFileService.hasDatu(goodsId)+"");

        return vo;
    }

    /**
     * 商品详情页,档口数据
     * @param shopId
     * @return
     * @throws IOException
     * @throws TemplateException
     */
    public CdnShopInfoVO cdnShopInfo(Long shopId) throws IOException, TemplateException {
        CdnShopInfoVO vo=new CdnShopInfoVO();
        StoreRelation shop=storeRelationService.selRelationById(shopId);
        if(shop==null){
            return null;
        }
        vo.setFloor(shop.getFloor());
        vo.setImQq(shop.getImQq());
        vo.setImWw(shop.getImWw());
        vo.setMarketName(shop.getMarketName());
        vo.setShopId(shopId);
        vo.setShopNo(shop.getStoreNum());
        vo.setMobile(shop.getTelephone());
        //星星数
        Long starNum=shopForCdnService.selShopStarById(shopId);
        starNum=starNum==null?0:starNum;
        vo.setStarNum(starNum);
        //其他信息
        ShopBaseForCdn other=shopForCdnService.selShopBase(shopId);
        if(other!=null){
            vo.setOpenTime(other.getOpenTime());
            vo.setMainBus(other.getMainBus());
            vo.setTbUrl(other.getTaobaoUrl());
        }
        //是否实体认证
        ShiguShopLicense license = new ShiguShopLicense();
        license.setLicenseType(ShopLicenseTypeEnum.TAGS.ordinal());
        license.setShopId(shopId);
        license.setLicenseFailure(0);//有效
        license.setLicenseType(3);
        int count = shiguShopLicenseMapper.selectCount(license);
        vo.setIsStrz(count>0);
        //授权状态
        vo.setTbAuthState(shopBaseService.shopAuthState(shopId));
        //二级域名
        vo.setDomain(shopBaseService.selDomain(shopId));
        return vo;
    }
    /**
     * 店内类目
     * @param shopId
     * @return
     */
    public List<CdnShopCatVO> cdnShopCat(Long shopId){
        List<ShopCat> cats=shopForCdnService.selShopCatsById(shopId);
        List<CdnShopCatVO> cdnCats= BeanMapper.mapList(cats,CdnShopCatVO.class);
        return cdnCats;
    }

    /**
     * 看了有看
     * @param shopId
     * @return
     */
    public List<CdnSimpleGoodsVO> cdnSimpleGoods(Long shopId, String webSite){
        ShiguPager<ItemShowBlock> pager= shopForCdnService.searchItemOnsale(null,shopId,webSite,"common",1,3);
        List<CdnSimpleGoodsVO> list=new ArrayList<>();
        for(ItemShowBlock item:pager.getContent()){
            CdnSimpleGoodsVO v=new CdnSimpleGoodsVO();
            v.setGoodsId(item.getItemId());
            v.setImgSrc(item.getImgUrl());
            v.setPrice(item.getPrice());
            v.setTitle(item.getTitle());
            list.add(v);
        }
        return list;
    }

    /**
     * 商品详情页,我收藏的店铺
     * @param userId
     * @param webSite
     * @return
     */
    public List<CdnCollectShopVO> colloectShop(Long userId,String webSite){
        ShiguPager<ShopCollectVO> pager=userCollectService.selShopCollections(userId,webSite,1,6);
        List<CdnCollectShopVO> vos=new ArrayList<>();
        for(ShopCollectVO p:pager.getContent()){
            CdnCollectShopVO vo=new CdnCollectShopVO();
            vo.setId(p.getShopId());
            vo.setName(p.getMarket()+p.getShopNum());
            vos.add(vo);
        }
        return vos;
    }

    /**
     * 店铺权益信息获取
     * @param page 页数
     * @param size 每页条数
     * @return
     */
    public ShiguPager<ShopIconCopyrightVO> shopCopyrights(Integer page, Integer size){
        final String FLAG="shop_copyright";//shigu_temp表中的flag，key1=图片链接，key2=店铺ID
        if (page == null) {
            page=1;
        }
        if (size == null) {
            size=100;
        }
        ShiguTempExample example=new ShiguTempExample();
        example.createCriteria().andFlagEqualTo(FLAG);
        example.setStartIndex((page-1)*size);
        example.setEndIndex(size);
        List<ShiguTemp> copyrights=shiguTempMapper.selectByConditionList(example);
        List<Long> shopIds=new ArrayList<>();
        for(ShiguTemp temp:copyrights){
            shopIds.add(Long.valueOf(temp.getKey2()));
        }
        final Map<Long,ShopNumAndMarket> shopMap=new HashMap<>();
        if (shopIds.size()>0) {
            List<ShopNumAndMarket> shops = shiguShopMapper.selShopNumAndMarkets(shopIds);
            shopMap.putAll(BeanMapper.list2Map(shops,"shopId",Long.class));
        }
        ShiguPager<ShopIconCopyrightVO> pager=new ShiguPager<>();
        pager.setNumber(page);
        pager.setTotalCount(shiguTempMapper.countByExample(example));
        List<ShopIconCopyrightVO> content=new ArrayList<>();
        pager.setContent(content);
        copyrights.forEach(cr ->{
            ShopIconCopyrightVO vo=new ShopIconCopyrightVO();
            vo.setImgSrc(cr.getKey1());
            Long shopId=Long.valueOf(cr.getKey2());
            vo.setShopId(shopId);
            vo.setShopName(shopMap.get(shopId).getMarket()+" "+shopMap.get(shopId).getShopNum());
            content.add(vo);
        });
        return pager;
    }

    /**
     * 根据goodsId获取对应站点信息
     * @return
     */
    public String getWebsite(Long goodsId){
        ShiguGoodsIdGenerator shiguGoodsIdGenerator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(goodsId);
        if (shiguGoodsIdGenerator == null) {
            return null;
        }
        return shiguGoodsIdGenerator.getWebSite();
    }

    /**
     * 按商品ID查cid
     * @param goodsId
     * @param webSite
     * @return
     */
    public Long getCid(Long goodsId,String webSite){
        ShiguGoodsTiny tiny=new ShiguGoodsTiny();
        tiny.setGoodsId(goodsId);
        tiny.setWebSite(webSite);
        tiny=shiguGoodsTinyMapper.selectFieldsByPrimaryKey(tiny,FieldUtil.codeFields("goods_id,cid"));
        if (tiny != null) {
            return tiny.getCid();
        }else{
            return null;
        }
    }
}
