package com.shigu.main4.cdn.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.*;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.cdn.bo.ScGoodsBO;
import com.shigu.main4.cdn.bo.ScStoreBO;
import com.shigu.main4.cdn.exceptions.CdnException;
import com.shigu.main4.cdn.vo.*;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.MoneyUtil;
import com.shigu.main4.enums.ShopLicenseTypeEnum;
import com.shigu.main4.item.newservice.NewShowForCdnService;
import com.shigu.main4.item.services.ItemCatService;
import com.shigu.main4.item.services.ShopsItemService;
import com.shigu.main4.item.services.ShowForCdnService;
import com.shigu.main4.item.vo.NormalProp;
import com.shigu.main4.item.vo.SaleProp;
import com.shigu.main4.item.vo.news.NewCdnItem;
import com.shigu.main4.item.vo.news.SingleSkuVO;
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
import com.shigu.seller.vo.ModuleVO;
import com.shigu.spread.enums.SpreadEnum;
import com.shigu.tools.DateParseUtil;
import com.shigu.tools.HtmlImgsLazyLoad;
import com.shigu.tools.KeyWordsUtil;
import freemarker.template.TemplateException;
import net.sf.json.JSONArray;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * cdn服务
 * Created by zhaohongbo on 17/3/7.
 */
@Service
public class CdnService {
    private final static Map<String, Integer> SIZE_SORT;

    static {
        SIZE_SORT = new HashMap<>();
        SIZE_SORT.put("XXS", -1);
        SIZE_SORT.put("2XS", -1);
        SIZE_SORT.put("XS", 0);
        SIZE_SORT.put("S", 1);
        SIZE_SORT.put("M", 2);
        SIZE_SORT.put("L", 3);
        SIZE_SORT.put("XL", 4);
        SIZE_SORT.put("XXL", 5);
        SIZE_SORT.put("2XL", 5);
        SIZE_SORT.put("XXXL", 6);
        SIZE_SORT.put("3XL", 6);
        SIZE_SORT.put("XXXL", 7);
        SIZE_SORT.put("4XL", 7);
        SIZE_SORT.put("XXXXL", 8);
        SIZE_SORT.put("5XL", 8);
        SIZE_SORT.put("XXXXXL", 9);
        SIZE_SORT.put("6XL", 9);
        SIZE_SORT.put("XXXXXXL", 10);
        SIZE_SORT.put("7XL", 10);
        SIZE_SORT.put("XXXXXXXL", 11);
        SIZE_SORT.put("8XL", 11);
    }

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
    ShopsItemService shopsItemService;

    @Autowired
    ShiguGoodsTodayMapper shiguGoodsTodayMapper;

    @Autowired
    ShiguTempMapper shiguTempMapper;
    @Autowired
    ItemCatService itemCatService;
    @Autowired
    NewShowForCdnService newShowForCdnService;
    @Autowired
    ShiguGoodsTinyCreatedQzMapper shiguGoodsTinyCreatedQzMapper;


    /**
     * 禁止销售的
     */
    @Autowired
    ItemTradeForbidMapper itemTradeForbidMapper;
    @Autowired
    ItemOrderSenderMapper itemOrderSenderMapper;

    /**
     * banner部分的html
     *
     * @param shopId
     * @return
     */
    public String bannerHtml(Long shopId, String webSite) throws IOException, TemplateException {
        ModuleVO moduleVO = shopDesignService.selHeadModuleWithData(shopId, webSite, false);
        if (moduleVO == null) {
            return "";
        }
        return moduleVO.getHtml();
    }

    /**
     * 重组聚合数据
     *
     * @param shopId
     * @return
     */
    public List<CatPolymerization> formatCatPoly(Long shopId) {
        List<CatPolymerization> cats = shopForCdnService.selCatRolymerizations(shopId);
        if (cats == null || 0 == cats.size()) {
            cats = new ArrayList<>();
        }
        List<CatPolyFormatVO> polys = new ArrayList<>();
        for (CatPolymerization c : cats) {
            polys.add(new CatPolyFormatVO(c));
        }
        Collections.sort(polys);
        List<CatPolymerization> result = new ArrayList<>();
        CatPolymerization other = new CatPolymerization();
        other.setCid(404L);
        other.setName("其它");
        other.setSubPolymerizations(new ArrayList<CatPolymerization>());
        for (int i = 0; i < polys.size(); i++) {
            if (i > 1) {
                List<CatPolymerization> sub = other.getSubPolymerizations();
                if (sub.size() < 10) {
                    CatPolymerization me = polys.get(i).getCatpoly();
                    if (me.getSubPolymerizations() == null) {
                        sub.add(me);
                    } else {
                        List<CatPolymerization> mesub = me.getSubPolymerizations();
                        sub.addAll(mesub);
                    }
                }
            } else {
                result.add(polys.get(i).getCatpoly());
            }
        }
        if (polys.size() > 2) {
            result.add(other);
        }
        return result;
    }


    /**
     * 添加到收藏/数据包
     *
     * @param userId
     * @param bo
     * @param type   类型：1.数据包，2.收藏
     * @return
     */
    public String addItemCollect(Long userId, ScGoodsBO bo, int type) {
        ItemCollect itemCollect = new ItemCollect();
        itemCollect.setUserId(userId);
        //查出店、webSite
        ShiguGoodsIdGenerator sgig = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(bo.getGoodsId());
        if (sgig == null) {
            return "商品不存在";
        }
        ShiguGoodsTiny sgt = new ShiguGoodsTiny();
        sgt.setGoodsId(bo.getGoodsId());
        sgt.setWebSite(sgig.getWebSite());
        sgt = shiguGoodsTinyMapper.selectFieldsByPrimaryKey(sgt, FieldUtil.codeFields("goods_id,store_id,title,type"));
        if (sgt == null) {
            return "商品不存在";
        }
        itemCollect.setItemId(bo.getGoodsId());
        itemCollect.setStoreId(sgt.getStoreId());
        itemCollect.setWebsite(sgig.getWebSite());
        itemCollect.setTitle(sgt.getTitle());
        itemCollect.setType(type);
        try {
            userCollectService.addItemCollection(itemCollect);
        } catch (ItemCollectionException e) {
            if ("已收藏该商品".equals(e.getMessage())) {
                return "2";
            }
            return e.getMessage();
        }
        return "success";
    }

    /**
     * 收藏店铺
     *
     * @param userId
     * @param bo
     * @return
     */
    public boolean addShopCollect(Long userId, ScStoreBO bo) {
        ShopCollect shopCollect = new ShopCollect();
        ShiguShop shop = shiguShopMapper.selectFieldsByPrimaryKey(bo.getStore_id(),
                FieldUtil.codeFields("shop_id,web_site"));
        if (shop == null) {
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
     *
     * @param shopId
     * @return
     */
    public ShopShowVO shopSimpleVo(Long shopId) {
        ShopShowVO shopShowVO = new ShopShowVO();
        if (shopId == null) {
            return shopShowVO;
        }
        shopShowVO.setOther(shopForCdnService.selShopBase(shopId));
        shopShowVO.setDomain(shopBaseService.selDomain(shopId));
        shopShowVO.setHasAuth(shopBaseService.shopAuthState(shopId));
        shopShowVO.setStoreRelation(storeRelationService.selRelationById(shopId));
//        shopShowVO.setShopCats(shopForCdnService.selShopCatsById(bo.getId()));
        //查商品
        shopShowVO.setShopLicenses(shopLicenseService.selShopLicenses(shopId));
        //得到商品ID
        StoreRelation storeRelation = shopShowVO.getStoreRelation();
        if (storeRelation != null) {
            String webSite = storeRelation.getWebSite();
            shopShowVO.setGoodsNum(shopForCdnService.selItemNumberById(shopId, webSite));
        }
        Long starNum = shopForCdnService.selShopStarById(shopId);
        if (starNum == null) {
            starNum = 0L;
        }
        shopShowVO.setStarNum(starNum);
        return shopShowVO;
    }

    /**
     * 查询店内最新几件商品
     *
     * @param shopId
     * @param number
     * @return
     */
    public List<ItemShowBlock> selShopNew(Long shopId, String webSite, Integer number) {
        ShiguGoodsTinyExample example = new ShiguGoodsTinyExample();
        example.createCriteria().andStoreIdEqualTo(shopId).andIsClosedEqualTo(0L);
        example.setStartIndex(0);
        example.setEndIndex(number);
        example.setWebSite(webSite);
        example.setOrderByClause("created desc");
        List<ShiguGoodsTiny> tinyList = shiguGoodsTinyMapper.selectFieldsByConditionList(example,
                FieldUtil.codeFields("pic_url,title,goods_id,pi_price,web_site,goods_no"));
        List<ItemShowBlock> blocks = new ArrayList<>();
        for (ShiguGoodsTiny tiny : tinyList) {
            ItemShowBlock isb = new ItemShowBlock();
            isb.setWebSite(tiny.getWebSite());
            isb.setShopId(tiny.getStoreId());
            isb.setGoodsNo(tiny.getGoodsNo());
            isb.setItemId(tiny.getGoodsId());
            isb.setImgUrl(tiny.getPicUrl());
            isb.setPrice(isb.parsePrice(tiny.getPiPrice() == null ? null : tiny.getPiPrice()));
            isb.setTitle(tiny.getTitle());
            blocks.add(isb);
        }
        return blocks;
    }


//===================================================20170725张峰=======================================================

    /**
     * 检测是否可销售
     *
     * @param marketId
     * @param storeId
     * @param goodsId
     * @param webSite
     * @return
     */
    public boolean canSale(Long marketId, Long storeId, Long goodsId, String webSite) {
        if (!webSite.equals("hz")) {
            return false;
        }
        ItemTradeForbidExample example = new ItemTradeForbidExample();
        example.createCriteria().andTypeEqualTo(1).andTargetIdEqualTo(marketId);//市场的
        example.or().andTypeEqualTo(2).andTargetIdEqualTo(storeId);//按店来
        example.or().andTypeEqualTo(3).andTargetIdEqualTo(goodsId);//按商品
//        example.or().andTypeEqualTo(4).andTargetIdEqualTo(cid);//按类目
        return itemTradeForbidMapper.countByExample(example) == 0;
    }


    /**
     * 商品详情页,商品数据
     *
     * @param goodsId
     * @return
     * @throws CdnException
     */
    public CdnGoodsInfoVO cdnGoodsInfo(Long goodsId) throws Main4Exception {
        CdnGoodsInfoVO vo = new CdnGoodsInfoVO();
        NewCdnItem cdnItem = newShowForCdnService.selItemById(goodsId);
        vo.setOnSale(cdnItem != null && cdnItem.getOnsale());
        if (cdnItem == null) {//已经下架
            cdnItem = newShowForCdnService.selItemInstockById(goodsId);
        }
        if (cdnItem == null) {//商品不存在
            throw new CdnException("商品不存在");
        }
        vo.setOnlineSale(itemProductProcess
                .canSale(cdnItem.getMarketId(), cdnItem.getFloorId(), cdnItem.getShopId(), goodsId, cdnItem
                        .getWebSite()));
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
        vo.setGoodsVideoUrl(cdnItem.getGoodsVideoUrl());
        //vo.setViewNum(itemBrowerService.selItemBrower(goodsId));
        vo.setFabric(cdnItem.getFabric());
        vo.setInFabric(cdnItem.getInFabric());

        String cdnItemDescription = cdnItem.getDescription();
        if (StringUtils.isNotBlank(cdnItemDescription)) {
            cdnItemDescription = KeyWordsUtil.duleKeyWords(cdnItemDescription);
            vo.setDescHtml(HtmlImgsLazyLoad.replaceLazyLoad(cdnItemDescription).replace("<script ", "")
                    .replace("<script>", "")
                    .replace("</script>", ""));
        }
        List<NormalProp> nps = cdnItem.getNormalProps();
        List<CdnGoodsPropVO> props = new ArrayList<>();
        if (nps != null && !nps.isEmpty()) {
            for (NormalProp np : nps) {
                CdnGoodsPropVO prop = new CdnGoodsPropVO();
                prop.setName(np.getPname());
                prop.setValue(np.getValue());
                props.add(prop);
            }
        }

        vo.setNormalAttrs(props);
        if (shopsItemService.checkHasLowestLiPriceSet(goodsId)) {
            vo.setLowestLiPrice(vo.getLiPrice());
        }
        List<String> qys = showForCdnService.selItemLicenses(goodsId, cdnItem.getShopId());
        vo.setServices(qys);
        vo.setHasOriginalPic(goodsFileService.hasDatu(goodsId) + "");

        List<SingleSkuVO> singleSkus = cdnItem.getSingleSkus();
        Map<String, List<SingleSkuVO>> skus = singleSkus.stream().collect(Collectors.groupingBy(SingleSkuVO::getThisColor));
        List<SaleProp> colors = cdnItem.getColors();
        if (colors == null) {
            colors = new ArrayList<>();
        }
        Map<String, String> propImgMap = colors.stream().collect(Collectors
                .toMap(SaleProp::getValue, saleProp -> StringUtils.isNotBlank(saleProp.getImgUrl()) ? saleProp
                        .getImgUrl() : ""));

        List<String> colorMetas = new ArrayList<>(skus.keySet());
        colorMetas.sort(Comparator.comparing(o -> o));
        List<String> priceSort = new ArrayList<>();
        List<SkuMetaVO> skuMetaVOS = colorMetas.stream().map(s -> {
            SkuMetaVO skuMetaVO = new SkuMetaVO();
            skuMetaVO.setText(s);
            skuMetaVO.setImgSrc(propImgMap.get(s));
            List<SingleSkuVO> sizes = skus.get(s);
            List<SingleSkuVO> hasSizes = sizes.stream().filter(singleSkuVO -> SIZE_SORT.get(singleSkuVO.getThisSize().toUpperCase()) != null).collect(Collectors.toList());
            hasSizes.sort(Comparator.comparingInt(o -> SIZE_SORT.get(o.getThisSize().toUpperCase())));
            List<SingleSkuVO> notSizes = sizes.stream().filter(singleSkuVO -> SIZE_SORT.get(singleSkuVO.getThisSize().toUpperCase()) == null).collect(Collectors.toList());
            notSizes.sort(Comparator.comparing(SingleSkuVO::getThisSize));
            sizes.clear();
            sizes.addAll(hasSizes);
            sizes.addAll(notSizes);
            skuMetaVO.setSizes(sizes.stream().map(singleSkuVO -> {
                SkuSizeMetaVO skuSizeMetaVO = new SkuSizeMetaVO();
                skuSizeMetaVO.setNum(singleSkuVO.getStockNum());
                skuSizeMetaVO.setPrice(singleSkuVO.getPriceString());
                skuSizeMetaVO.setText(singleSkuVO.getThisSize());
                if (skuSizeMetaVO.getNum() != 0) {
                    priceSort.add(singleSkuVO.getPriceString());
                }
                return skuSizeMetaVO;
            }).collect(Collectors.toList()));
            return skuMetaVO;
        }).collect(Collectors.toList());
        vo.setSkusMeta(JSONArray.fromObject(skuMetaVOS).toString());
        if (priceSort.size() > 0) {
            priceSort.sort(Comparator.comparingLong(MoneyUtil::StringToLong));
            if (!priceSort.get(0).equals(priceSort.get(priceSort.size() - 1))) {
                vo.setPiPrice(priceSort.get(0) + "-" + priceSort.get(priceSort.size() - 1));
            }
        }
        return vo;
    }

    /**
     * 商品详情页,档口数据
     *
     * @param shopId
     * @return
     * @throws IOException
     * @throws TemplateException
     */
    public CdnShopInfoVO cdnShopInfo(Long shopId) throws IOException, TemplateException {
        CdnShopInfoVO vo = new CdnShopInfoVO();
        StoreRelation shop = storeRelationService.selRelationById(shopId);
        if (shop == null) {
            return null;
        }
        vo.setMarketId(shop.getMarketId());
        vo.setFloor(shop.getFloor());
        vo.setImQq(shop.getImQq());
        vo.setImWw(shop.getImWw());
        vo.setMarketName(shop.getMarketName());
        vo.setShopId(shopId);
        vo.setShopNo(shop.getStoreNum());
        vo.setMobile(shop.getTelephone());
        //星星数
        Long starNum = shopForCdnService.selShopStarById(shopId);
        if (starNum == null) {
            starNum = 0L;
        }
        vo.setStarNum(starNum);
        //其他信息
        ShopBaseForCdn other = shopForCdnService.selShopBase(shopId);
        if (other != null) {
            vo.setOpenTime(other.getOpenTime());
            vo.setMainBus(other.getMainBus());
            vo.setTbUrl(other.getTaobaoUrl());
            vo.setType(other.getType());
        }
        //是否实体认证
        ShiguShopLicense license = new ShiguShopLicense();
        license.setLicenseType(ShopLicenseTypeEnum.TAGS.ordinal());
        license.setShopId(shopId);
        license.setLicenseFailure(0);//有效
        license.setLicenseType(3);
        int count = shiguShopLicenseMapper.selectCount(license);
        vo.setIsStrz(count > 0);
        //授权状态
        vo.setTbAuthState(shopBaseService.shopAuthState(shopId));
        //二级域名
        vo.setDomain(shopBaseService.selDomain(shopId));
        //微信同号，咨询电话
        List<LinceseVo> voList = selShopLIcense(shopId);
        if (voList.size() > 0) {
            LinceseVo vo1 = voList.get(0);

            if (vo1.getIsWx() != null && vo1.getIsWx() == 0) {
                    vo.setExistWx(0);
                    vo.setMobile(vo.getMobile() + "（微信同号）");
            }
            if (vo1.getIsZx() != null && vo1.getIsZx() == 0){
                    vo.setAdvisoryMobile(voList.get(0).getContext());
                    vo.setIsZx(0);
            }
        }
        // TODO: 微信同号，咨询电话

        return vo;
    }
    private List<LinceseVo> selShopLIcense(Long shopIds) {
        List<Long> longs = new ArrayList<>();
        longs.add(shopIds);
        return shopLicenseService.selShopLIcenseByIds(longs);
    }
    /**
     * 店内类目
     *
     * @param shopId
     * @return
     */
    public List<CdnShopCatVO> cdnShopCat(Long shopId) {
        List<ShopCat> cats = shopForCdnService.selShopCatsById(shopId);
        List<CdnShopCatVO> cdnCats = BeanMapper.mapList(cats, CdnShopCatVO.class);
        return cdnCats;
    }

    /**
     * 看了有看
     *
     * @param shopId
     * @return
     */
    public List<CdnSimpleGoodsVO> cdnSimpleGoods(Long shopId, String webSite) {
        return shiguGoodsTinyMapper.selForSee(webSite, shopId).stream().map(o -> {
            CdnSimpleGoodsVO v = new CdnSimpleGoodsVO();
            v.setGoodsId(o.getGoodsId());
            v.setImgSrc(o.getPicUrl());
            v.setPrice(o.getPiPriceString());
            v.setTitle(o.getTitle());
            return v;
        }).collect(Collectors.toList());
    }

    /**
     * 商品详情页,我收藏的店铺
     *
     * @param userId
     * @param webSite
     * @return
     */
    public List<CdnCollectShopVO> colloectShop(Long userId, String webSite) {
        if (webSite == null) {
            webSite = "hz";
        }
        ShiguPager<ShopCollectVO> pager = userCollectService.selShopCollections(userId, webSite, 1, 6);
        List<CdnCollectShopVO> vos = new ArrayList<>();
        for (ShopCollectVO p : pager.getContent()) {
            CdnCollectShopVO vo = new CdnCollectShopVO();
            vo.setId(p.getShopId());
            vo.setName(p.getMarketName() + p.getShopNum());
            vos.add(vo);
        }
        return vos;
    }

    /**
     * 店铺权益信息获取
     *
     * @param page 页数
     * @param size 每页条数
     * @return
     */
    public ShiguPager<ShopIconCopyrightVO> shopCopyrights(Integer page, Integer size) {
        final String FLAG = "shop_copyright";//shigu_temp表中的flag，key1=图片链接，key2=店铺ID
        if (page == null) {
            page = 1;
        }
        if (size == null) {
            size = 100;
        }
        ShiguTempExample example = new ShiguTempExample();
        example.createCriteria().andFlagEqualTo(FLAG);
        example.setStartIndex((page - 1) * size);
        example.setEndIndex(size);
        example.setOrderByClause(" id DESC");
        List<ShiguTemp> copyrights = shiguTempMapper.selectByConditionList(example);
        List<Long> shopIds = new ArrayList<>();
        for (ShiguTemp temp : copyrights) {
            shopIds.add(Long.valueOf(temp.getKey2()));
        }
        final Map<Long, ShopNumAndMarket> shopMap = new HashMap<>();
        if (shopIds.size() > 0) {
            List<ShopNumAndMarket> shops = shiguShopMapper.selShopNumAndMarkets(shopIds);
            shopMap.putAll(BeanMapper.list2Map(shops, "shopId", Long.class));
        }
        ShiguPager<ShopIconCopyrightVO> pager = new ShiguPager<>();
        pager.setNumber(page);
        pager.setTotalCount(shiguTempMapper.countByExample(example));
        List<ShopIconCopyrightVO> content = new ArrayList<>();
        pager.setContent(content);
        copyrights.forEach(cr -> {
            ShopIconCopyrightVO vo = new ShopIconCopyrightVO();
            vo.setImgSrc(cr.getKey1());
            Long shopId = Long.valueOf(cr.getKey2());
            vo.setShopId(shopId);
            vo.setShopName(shopMap.get(shopId).getMarket() + " " + shopMap.get(shopId).getShopNum());
            content.add(vo);
        });
        return pager;
    }

    /**
     * 根据goodsId获取对应站点信息
     *
     * @return
     */
    public String getWebsite(Long goodsId) {
        ShiguGoodsIdGenerator shiguGoodsIdGenerator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(goodsId);
        if (shiguGoodsIdGenerator == null) {
            return null;
        }
        return shiguGoodsIdGenerator.getWebSite();
    }

    /**
     * 按商品ID查cid
     *
     * @param goodsId
     * @param webSite
     * @return
     */
    public Long getCid(Long goodsId, String webSite) {
        ShiguGoodsTiny tiny = new ShiguGoodsTiny();
        tiny.setGoodsId(goodsId);
        tiny.setWebSite(webSite);
        tiny = shiguGoodsTinyMapper.selectFieldsByPrimaryKey(tiny, FieldUtil.codeFields("goods_id,cid"));
        if (tiny != null) {
            return tiny.getCid();
        } else {
            return null;
        }
    }

    /**
     * @param cid
     * @param webSite
     * @param type    1:商品详情左侧,2:下方
     * @return
     */
    public SpreadEnum getGoodsDetailSpreadSpreadEnum(Long cid, String webSite, int type) {
        if ("qz".equalsIgnoreCase(webSite)) {
            return type == 1 ? SpreadEnum.QZ_ITEM_GOAT : SpreadEnum.QZ_BOTTOM_ITEM_GOAT;
        }
        boolean instanOfWoman = itemCatService.instanOfWoman(cid);
        if("cz".equals(webSite)){
            if (instanOfWoman) {//父级或父父级cid=16的为女装
                return type==1?SpreadEnum.CZ_ITEM_GOAT_WOMAN:SpreadEnum.CZ_ITEM_BOTTOM_GOAT_WOMAN;
            } else {
                return type==1?SpreadEnum.CZ_ITEM_GOAT_MAN:SpreadEnum.CZ_ITEM_BOTTOM_GOAT_MAN;
            }
        }
        if (instanOfWoman) {//父级或父父级cid=16的为女装
            return type == 1 ? SpreadEnum.ITEM_GOAT_WOMAN : SpreadEnum.ITEM_BOTTOM_GOAT_WOMAN;
        } else {
            return type == 1 ? SpreadEnum.ITEM_GOAT_MAN : SpreadEnum.ITEM_BOTTOM_GOAT_MAN;
        }
    }

    /**
     * 查询星帮代发联系电话
     */
    public String selDaifaPhoneNo() {
        ItemOrderSender itemOrderSender = itemOrderSenderMapper.selectByPrimaryKey(999999990L);
        return itemOrderSender == null ? null : itemOrderSender.getTelephone();
    }

    @Transactional
    public int setNewGoods(Long goodsId) {
        ShiguGoodsTiny tiny = new ShiguGoodsTiny();
        tiny.setGoodsId(goodsId);
        tiny.setWebSite("qz");
        tiny = shiguGoodsTinyMapper.selectFieldsByPrimaryKey(tiny, FieldUtil.codeFields("goods_id,created,store_id"));
        if (tiny != null) {
            ShiguGoodsTinyCreatedQz shiguGoodsTinyCreatedQz = new ShiguGoodsTinyCreatedQz();
            shiguGoodsTinyCreatedQz.setGoodsId(goodsId);
            shiguGoodsTinyCreatedQz.setOldCreated(tiny.getCreated());
            ShiguGoodsTinyCreatedQz tinyCreated = shiguGoodsTinyCreatedQzMapper.selectByPrimaryKey(shiguGoodsTinyCreatedQz);
            String nowTime = DateParseUtil.parseDate("yyyy-MM-dd", new Date());
            String[] nowTimes = nowTime.split("-");
            ShiguShopExample shiguShopExample = new ShiguShopExample();
            shiguShopExample.createCriteria().andShopIdEqualTo(tiny.getStoreId());
            List<ShiguShop> list = shiguShopMapper.selectByExample(shiguShopExample);
            if (list.size() != 0) {
                Long userId = list.get(0).getUserId();
                ShiguGoodsToday shiguGoodsToday = new ShiguGoodsToday();
                ShiguGoodsTodayExample shiguGoodsTodayExample = new ShiguGoodsTodayExample();
                shiguGoodsTodayExample.createCriteria().andUserIdEqualTo(userId);
                List<ShiguGoodsToday> shiguGoodsTodays = shiguGoodsTodayMapper.selectByExample(shiguGoodsTodayExample);
                ShiguGoodsToday shiguGoodsToday1=new ShiguGoodsToday();
                if (shiguGoodsTodays.size() == 0) {
                    shiguGoodsToday.setUserId(userId);
                    shiguGoodsToday.setNum(1);
                    shiguGoodsToday.setCreated(DateParseUtil.parseDate("yyyy-MM-dd", new Date()));
                    shiguGoodsTodayMapper.save(shiguGoodsToday);
                } else {
                    shiguGoodsToday1 = shiguGoodsTodays.get(0);
                    int num = shiguGoodsToday1.getNum();
                    String time = shiguGoodsToday1.getCreated();
                    String[] times = time.split("-");
                    if (!times[2].equals(nowTimes[2])) {
                        num = 0;
                        shiguGoodsToday1.setCreated(nowTime);
                    } else if (!times[1].equals(nowTimes[1])) {
                        num = 0;
                        shiguGoodsToday1.setCreated(nowTime);
                    }else if(!times[0].equals(nowTimes[0])){
                        num =0;
                        shiguGoodsToday1.setCreated(nowTime);
                    }
                    if (num < 3) {
                        shiguGoodsToday1.setNum(num + 1);
                    } else {
                        return 1;
                    }
                }
                if (tinyCreated == null) {
                    shiguGoodsTinyMapper.saveCreated(shiguGoodsTinyCreatedQz);
                }else{
                    String modifTime = DateParseUtil.parseDate("yyyy-MM-dd", tinyCreated.getGmtModif());
                    String[] modif = modifTime.split("-");
                    if(modif[2].equals(nowTimes[2])){
                        if(modif[1].equals(nowTimes[1])){
                            if(modif[0].equals(nowTimes[0])){
                                return 4;
                            }else{
                                tinyCreated.setGmtModif(new Date());
                                shiguGoodsTinyMapper.update(tinyCreated);
                            }
                        }else{
                            tinyCreated.setGmtModif(new Date());
                            shiguGoodsTinyMapper.update(tinyCreated);
                        }
                    }else{
                        tinyCreated.setGmtModif(new Date());
                        shiguGoodsTinyMapper.update(tinyCreated);
                    }
                    shiguGoodsTodayMapper.update(shiguGoodsToday1);
                }
                tiny.setWebSite("qz");
                tiny.setCreated(new Date());
                shiguGoodsTinyMapper.updateCreated(tiny);
                return 0;
            } else {
                return 2;
            }
        } else {
            return 3;
        }
    }
}
