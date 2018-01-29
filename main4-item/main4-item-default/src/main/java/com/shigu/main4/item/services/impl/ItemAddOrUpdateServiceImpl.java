package com.shigu.main4.item.services.impl;

import com.alibaba.druid.sql.visitor.functions.If;
import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.*;
import com.opentae.data.mall.interfaces.*;
import com.searchtool.configs.ElasticConfiguration;
import com.searchtool.domain.SimpleElaBean;
import com.searchtool.mappers.ElasticRepository;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.exceptions.*;
import com.shigu.main4.item.services.ItemAddOrUpdateService;
import com.shigu.main4.item.services.PriceCalculateService;
import com.shigu.main4.item.tools.GoodsAddToRedis;
import com.shigu.main4.item.tools.ItemCache;
import com.shigu.main4.item.tools.ItemHelper;
import com.shigu.main4.item.tools.OSSUtil;
import com.shigu.main4.item.vo.GoodsShelfInfoForEs;
import com.shigu.main4.item.vo.ImgToSearch;
import com.shigu.main4.item.vo.NowItemInfo;
import com.shigu.main4.item.vo.SynItem;
import com.shigu.main4.tools.RedisIO;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.Client;
import org.omg.CosNaming.NamingContextPackage.NotFoundReasonHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.shigu.main4.item.exceptions.ItemUpdateException.ItemUpdateExceptionEnum.*;
import static com.shigu.main4.item.exceptions.ItemUpdateException.ItemUpdateExceptionEnum.IllegalArgumentException;
import static com.shigu.main4.item.exceptions.SystemSynItemException.SynItemExceptionEnum.ES_SYN_HAS_ERROR;

/**
 * Created by wxc on 2017/2/25.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@Service("itemAddOrUpdateService")
public class ItemAddOrUpdateServiceImpl implements ItemAddOrUpdateService {

    private static final Logger logger = LoggerFactory.getLogger(ItemAddOrUpdateServiceImpl.class);

    @Resource(name = "tae_mall_shiguGoodsIdGeneratorMapper")
    private ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;

    @Resource(name = "tae_mall_shiguGoodsTinyMapper")
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Resource(name = "tae_mall_shiguGoodsSoldoutMapper")
    private ShiguGoodsSoldoutMapper shiguGoodsSoldoutMapper;

    @Resource(name = "tae_mall_shiguGoodsExtendsMapper")
    private ShiguGoodsExtendsMapper shiguGoodsExtendsMapper;

    @Resource(name = "tae_mall_shiguGoodsModifiedMapper")
    private ShiguGoodsModifiedMapper shiguGoodsModifiedMapper;

    @Resource(name = "tae_mall_shiguGoodsUnlicenseMapper")
    private ShiguGoodsUnlicenseMapper shiguGoodsUnlicenseMapper;

    @Resource(name = "tae_mall_shiguPropImgsMapper")
    private ShiguPropImgsMapper shiguPropImgsMapper;

    @Resource(name = "tae_mall_shiguShopMapper")
    private ShiguShopMapper shiguShopMapper;

    @Autowired
    private PriceCalculateService priceCalculateService;

    @Autowired
    private SameItemUtil sameItemUtil;

    @Autowired
    private EsGoodsServiceImpl esGoodsServiceImpl;

    @Autowired
    private ItemCache itemCache;

    @Autowired
    GoodsAddToRedis goodsAddToRedis;

    @Autowired
    RedisIO redisIO;

    @Autowired
    private ShiguSiteMapper shiguSiteMapper;

    @Autowired
    private ShiguGoodsStyleMapper shiguGoodsStyleMapper;

    @Autowired
    private ItemProductMapper itemProductMapper;

    @Autowired
    private GoodsCountForsearchMapper goodsCountForsearchMapper;

    @Autowired
    private ShiguCustomerStyleMapper shiguCustomerStyleMapper;

    @Autowired
    private SearchCategorySubMapper searchCategorySubMapper;

    /**
     * 系统上架一款商品
     * <p>
     *
     * @param itemId 商品主键
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void systemUpItem(Long itemId) throws ItemModifyException {
        if (itemId == null) {
            throw new ItemUpException(ItemUpException.ItemUpExceptionEnum.ITEM_DOES_NOT_EXIST, null);
        }
        //1、按item_id,查询表shigu_goods_modified,如果has_mod_instock=1(说明是用户自己操作下架的)，扔出异常
        ShiguGoodsModified modified = new ShiguGoodsModified();
        modified.setItemId(itemId);
        modified = shiguGoodsModifiedMapper.selectOne(modified);
        if (modified != null && modified.getHasModInstock() == 1)
            throw new ItemUpException(ItemUpException.ItemUpExceptionEnum.SYSTEM_UP_ERROR, itemId);
        upItem(itemId);
    }

    /**
     * 上架商品
     *
     * @param itemId 商品ID
     *
     * @throws ItemUpException 上架异常
     */
    @Transactional(rollbackFor = Exception.class)
    protected void upItem(Long itemId) throws ItemModifyException {
        ShiguGoodsIdGenerator generator;
        if (itemId == null || (generator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(itemId)) == null) {
            throw new ItemUpException(ItemUpException.ItemUpExceptionEnum.ITEM_DOES_NOT_EXIST, itemId);
        }
        String webSite = generator.getWebSite();

        ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
        tinyExample.setWebSite(webSite);
        tinyExample.createCriteria().andGoodsIdEqualTo(itemId);
        // 统计架上商品
        if (shiguGoodsTinyMapper.countByExample(tinyExample) > 0) {
            throw new ItemUpException(ItemUpException.ItemUpExceptionEnum.ITEM_ALREADY_UP, itemId);
        }

        ShiguGoodsSoldout soldout = new ShiguGoodsSoldout();
        soldout.setGoodsId(itemId);
        soldout.setWebSite(webSite);
        soldout = shiguGoodsSoldoutMapper.selectByPrimaryKey(soldout);
        if (soldout == null) {
            throw new ItemUpException(ItemUpException.ItemUpExceptionEnum.ITEM_DOES_NOT_EXIST, itemId);
        }

        //2、查出shigu_goods_soldout中数据，以最大匹配(BeanMapper)转化成shigu_goods_tiny对象，
        ShiguGoodsTiny tiny = BeanMapper.map(soldout, ShiguGoodsTiny.class);

        //3、如果is_closed=1（关店状态），查询一下当前店铺状态(shigu_shop.shop_status),按店铺状态重新设置值
        if (tiny.getIsClosed() == 1L) {
            ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(tiny.getStoreId());
            tiny.setIsClosed(Long.valueOf(shiguShop.getShopStatus()));
        }
        //4、如果3中，店铺状态为开店，修改es中is_off=0
        if (tiny.getIsClosed() == 0) {
//            new ElasticRepository().insert(
//                    new SimpleElaBean(
//                            "goods",
//                            webSite,
//                            tiny.getGoodsId().toString(),
//                            JSON.toJSONStringWithDateFormat(esGoodsService.createEsGoods(tiny), "yyyy-MM-dd HH:mm:ss")
//                    )
//            );
            goodsAddToRedis.addToRedis(new SimpleElaBean(
                            "goods",
                            webSite,
                            tiny.getGoodsId().toString(),
                            JSON.toJSONStringWithDateFormat(esGoodsServiceImpl.createEsGoods(tiny), "yyyy-MM-dd HH:mm:ss")
                    ));

        }
        //设置默认参数 & 上架时间
        tiny.setLoadDate(new Date());
        if (tiny.getPiPrice() == null || StringUtils.isEmpty(tiny.getPiPriceString())) {
            Long price = tiny.getPrice();
            if (price == null) {
                String priceString = tiny.getPriceString();
                if (priceString != null) {
                    Double ps = Double.valueOf(priceString) * 100;
                    price = ps.longValue();
                    tiny.setPrice(price);
                }
            }
            if (price != null) {
                tiny.setPiPrice(priceCalculateService.pickPipriceFromTitle(tiny.getStoreId(), price, tiny.getTitle(), tiny.getGoodsNo(), tiny.getOuterId()));
                tiny.setPiPriceString(String.format("%.2f", tiny.getPiPrice() * .01));
            }
        }
        try {
            //插入shigu_goods_tiny表
            shiguGoodsTinyMapper.insertSelective(tiny);
        } catch (Exception e) {
            tiny.setGoodsId(itemId);
            shiguGoodsTinyMapper.updateByPrimaryKeySelective(tiny);
        }
        //5、删除shigu_goods_soldout数据，以上所有需要在同一个事务中进行
        shiguGoodsSoldoutMapper.deleteByPrimaryKey(soldout);

        //6、调用商品重排com.shigu.main4.item.services.impl.SameItemUtil#addItem
        sameItemUtilAddRemove(tiny, true);

        //7、商品操作清除缓存
        cleanItemCache(itemId);

        //8、图搜首图添加
        addImgToSearch(itemId,webSite, null ,tiny.getPicUrl(), 1);
        GoodsShelfInfoForEs shelfInfo = new GoodsShelfInfoForEs();
        shelfInfo.setGoodsId(itemId);
        shelfInfo.setModified(tiny.getLoadDate());
        shelfInfo.setOnShelfIs(true);
        goodsAddToRedis.addGoodsOnShelfInfoToRedis(shelfInfo);
    }

    private void cleanItemCache(Long itemId) {
        itemCache.cleanItemCache(itemId);
    }

    /**
     * 用户上架一款商品
     *
     * @param itemId 商品ID
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void userUpItem(Long itemId) throws ItemModifyException {
        upItem(itemId);
        // 修改shigu_goods_modified中数据，如果存在把has_mod_instock=0。以上所有需要在同一个事务中进行
        setGoodsModifiedHasModInstock(itemId, 0);
    }

    private void setGoodsModifiedHasModInstock(Long itemId, Integer hasModInstock) {
        ShiguGoodsModified modified = new ShiguGoodsModified();
        modified.setItemId(itemId);
        modified = shiguGoodsModifiedMapper.selectOne(modified);
        if (modified != null) {
            modified.setHasModInstock(hasModInstock);
            shiguGoodsModifiedMapper.updateByPrimaryKeySelective(modified);
        } else {
            modified = new ShiguGoodsModified();
            modified.setItemId(itemId);
            modified.setHasModInstock(hasModInstock);
            shiguGoodsModifiedMapper.insertSelective(modified);
        }
    }

    /**
     * 系统下架一款商品
     *
     * @param itemId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void systemDownItem(Long itemId) throws ItemModifyException {
        downItem(itemId);
    }

    /**
     * 用户下架一款商品
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void userDownItem(Long itemId) throws ItemModifyException {
        ShiguGoodsIdGenerator generator;

        // 验证参数，并查询分站存在
        if (itemId == null || (generator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(itemId)) == null) {
            throw new ItemDownException(ItemDownException.ItemDownExceptionEnum.ITEM_DOES_NOT_EXIST, itemId);
        }
        String webSite = generator.getWebSite();

        // 获取出售中商品
        ShiguGoodsTiny tiny = new ShiguGoodsTiny();
        tiny.setGoodsId(itemId);
        tiny.setWebSite(webSite);
        if ((tiny = shiguGoodsTinyMapper.selectByPrimaryKey(tiny)) == null) {
            throw new ItemDownException(ItemDownException.ItemDownExceptionEnum.ITEM_DOES_NOT_EXIST, itemId);
        }
        if (tiny.getIsExcelImp() == 0) {
            throw new ItemDownException(ItemDownException.ItemDownExceptionEnum.TB_ITEM_NOT_ALLOW_DOWN, itemId);
        }
        downItem(itemId);
        // 设置has_mod_instock=1
        setGoodsModifiedHasModInstock(itemId, 1);
    }

    /**
     * 商品下架逻辑
     *      <doc>http://open.571xz.com/document.htm?did=455</doc>
     * @param itemId 商品ID
     * @throws ItemDownException 下架异常
     */
    @Transactional(rollbackFor = Exception.class)
    protected void downItem(Long itemId) throws ItemModifyException {
        ShiguGoodsIdGenerator generator;

        // 验证参数，并查询分站存在
        if (itemId == null || (generator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(itemId)) == null) {
            throw new ItemDownException(ItemDownException.ItemDownExceptionEnum.ITEM_DOES_NOT_EXIST, itemId);
        }
        String webSite = generator.getWebSite();

        // 获取出售中商品
        ShiguGoodsTiny tiny = new ShiguGoodsTiny();
        tiny.setGoodsId(itemId);
        tiny.setWebSite(webSite);
        if ((tiny = shiguGoodsTinyMapper.selectByPrimaryKey(tiny)) == null) {
            throw new ItemDownException(ItemDownException.ItemDownExceptionEnum.ITEM_DOES_NOT_EXIST, itemId);
        }

        // 查询仓库中是否有
        ShiguGoodsSoldoutExample soldoutExample = new ShiguGoodsSoldoutExample();
        soldoutExample.setWebSite(webSite);
        soldoutExample.createCriteria().andGoodsIdEqualTo(itemId);
        if (shiguGoodsSoldoutMapper.countByExample(soldoutExample) > 0) {
            throw new ItemDownException(ItemDownException.ItemDownExceptionEnum.ITEM_ALREADY_DOWN, itemId);
        }

        //2、查出shigu_goods_tiny中数据，以最大匹配(BeanMapper)转化成shigu_goods_soldout对象，
        ShiguGoodsSoldout soldout = BeanMapper.map(tiny, ShiguGoodsSoldout.class);

        //按2找到es中goods设置is_off=1
//        new ElasticRepository().insert(
//                new SimpleElaBean(
//                        "goods",
//                        webSite,
//                        tiny.getGoodsId().toString(),
//                        JSON.toJSONStringWithDateFormat(esGoodsService.createEsGoods(soldout), "yyyy-MM-dd HH:mm:ss")
//                )
//        );
        goodsAddToRedis.addToRedis(new SimpleElaBean(
                "goods",
                webSite,
                tiny.getGoodsId().toString(),
                JSON.toJSONStringWithDateFormat(esGoodsServiceImpl.createEsGoods(soldout), "yyyy-MM-dd HH:mm:ss")
        ));
        // 设置下架时间
        soldout.setSoldoutTime(new Date());
        try {
            //插入shigu_goods_soldout表
            shiguGoodsSoldoutMapper.insertSelective(soldout);
        } catch (Exception e) {
            soldout.setGoodsId(itemId);
            shiguGoodsSoldoutMapper.updateByPrimaryKeySelective(soldout);
        }

        //5、删除shigu_goods_tiny数据，以上所有需要在同一个事务中进行
        shiguGoodsTinyMapper.deleteByPrimaryKey(tiny);

        //6、调用商品重排com.shigu.main4.item.services.impl.SameItemUtil#addItem

        sameItemUtilAddRemove(tiny, false);

        //7、商品操作清除缓存
        cleanItemCache(itemId);

        //8、图搜主图删除
        addImgToSearch(itemId,webSite,null, tiny.getPicUrl(), 0);
        GoodsShelfInfoForEs info = new GoodsShelfInfoForEs();
        info.setGoodsId(itemId);
        info.setModified(soldout.getSoldoutTime());
        info.setOnShelfIs(false);
        goodsAddToRedis.addGoodsOnShelfInfoToRedis(info);
    }

    /**
     * 商品重排 方法
     * @param tiny      商品数据
     * @param isNew add Or remove
     * @throws ItemModifyException
     */
    private void sameItemUtilAddRemove(ShiguGoodsTiny tiny, boolean isNew)  {
        NowItemInfo item = new NowItemInfo();
        item.setWebSite(tiny.getWebSite());
        item.setCid(tiny.getCid());
        item.setCreated(tiny.getCreated());
        item.setGoodsLevel(tiny.getGoodsLevel());
        item.setItemId(tiny.getGoodsId());
        item.setPiPrice(tiny.getPiPrice().toString());
        item.setRelationLevelId(tiny.getRelationLevelId());
        item.setStoreId(tiny.getStoreId());
        item.setTitle(tiny.getTitle());
        try {
            if (isNew)
                sameItemUtil.addItem(item);
            else
                sameItemUtil.removeItem(item);
        } catch (SameItemException e) {
            logger.error("商品重排错误：", e);
        }
    }

    /**
     * 系统删除一款商品
     * <task>http://gz.571xz.com:32100/issue/MAIN_SITE4-59</task>
     * <doc>http://open.571xz.com/document.htm?did=438</doc>
     * <p>
     *
     * @param itemId 商品ID
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void systemDeleteItem(Long itemId) throws ItemModifyException {
        ShiguGoodsIdGenerator generator;
        String webSite;
        Long numIid = null;
        boolean isSoldout=false;//是否下架的
        if (itemId != null && (generator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(itemId)) != null
                && StringUtils.isNotEmpty(webSite = generator.getWebSite())) {

            // 存储OSS图片链接，准备删除
            List<String> ossImgs = new ArrayList<>();

            //1、删除shigu_goods_id_generator表对应数据，按主键
            shiguGoodsIdGeneratorMapper.deleteByPrimaryKey(itemId);

            //2、删除shigu_goods_tiny表对应数据，按主键
            ShiguGoodsTiny tiny = new ShiguGoodsTiny();
            tiny.setWebSite(webSite);
            tiny.setGoodsId(itemId);
            ShiguGoodsTiny goodsTiny
                    = shiguGoodsTinyMapper.selectByPrimaryKey(tiny);
            String picUrl;
            if (goodsTiny != null) {
                //9.4
                picUrl=goodsTiny.getPicUrl();
                ossImgs.add(goodsTiny.getPicUrl());
                numIid = goodsTiny.getNumIid();
                shiguGoodsTinyMapper.deleteByPrimaryKey(tiny);
            }else{
                ShiguGoodsSoldout goodsSoldout=shiguGoodsSoldoutMapper.selectByPrimaryKey(tiny);
                //删除下架的
                isSoldout=true;
                picUrl=goodsSoldout.getPicUrl();
                ossImgs.add(goodsSoldout.getPicUrl());
                numIid = goodsSoldout.getNumIid();
                shiguGoodsSoldoutMapper.deleteByPrimaryKey(tiny);
            }

            //3、删除shigu_goods_extends表对应数据，按主键
            ShiguGoodsExtends goodsExtends = new ShiguGoodsExtends();
            goodsExtends.setWebSite(webSite);
            goodsExtends.setGoodsId(itemId);
            // 查询图片
            ShiguGoodsExtends anExtends = shiguGoodsExtendsMapper.selectByPrimaryKey(goodsExtends);
            if (anExtends != null) {
                // 9.2,9.3
                ossImgs.add(anExtends.getGoodsDesc());
                ossImgs.add(anExtends.getImages());
                shiguGoodsExtendsMapper.deleteByPrimaryKey(goodsExtends);
            }

            //4、删除shigu_goods_modified表对应数据，按goods_id
            ShiguGoodsModifiedExample modifiedExample = new ShiguGoodsModifiedExample();
            modifiedExample.createCriteria().andItemIdEqualTo(itemId);
            shiguGoodsModifiedMapper.deleteByExample(modifiedExample);

            //5、删除shigu_goods_unlicense表对应数据，按goods_id
            ShiguGoodsUnlicenseExample unlicenseExample = new ShiguGoodsUnlicenseExample();
            unlicenseExample.createCriteria().andGoodsIdEqualTo(itemId);
            shiguGoodsUnlicenseMapper.deleteByExample(unlicenseExample);

            if (numIid != null) {
                // 9.1 查询设计图片，存进集合
                ShiguPropImgsExample imgsExample = new ShiguPropImgsExample();
                imgsExample.createCriteria().andItemIdEqualTo(itemId);
                for (ShiguPropImgs taobaoPropimg : shiguPropImgsMapper.selectByExample(imgsExample))
                    ossImgs.add(taobaoPropimg.getPropimgs());

                //7、删除shigu_prop_imgs对应数据,按item_id
                shiguPropImgsMapper.deleteByExample(imgsExample);

                //8、删除taobao_sku对应数据，按goods_id   该条取消
//                TaobaoSkuExample skuExample = new TaobaoSkuExample();
//                skuExample.createCriteria().andNumIidEqualTo(numIid);
//                taobaoSkuMapper.deleteByExample(skuExample);
            }

            //6、删除es中goods下对应数据
            SimpleElaBean seb = new SimpleElaBean("goods", webSite, itemId + "");
            new ElasticRepository().deleteByKey(seb);

            //9、删除商品在OSS中的所有图片，包含如下
            // 9.1 taobao_propimg中图片
            // 9.2 shigu_goods_extends.description中图片
            // 9.3 shigu_goods_extends.images中图片
            // 9.4 shigu_goods_tiny.pic_url中图片
            for (String ossImg : ossImgs) {
                // 疑似图片地址都丢进去，正则支持 .jpg|.png|.gif
                if(ossImg==null||"".equals(ossImg)||!ossImg.contains("/")){//空的没/的都不算地址,是不行的
                    continue;
                }
                proccessDeleteOssImage(ossImg);
            }

            //10、商品重拍,没下架的需要重排
            if (!isSoldout) {
                sameItemUtilAddRemove(goodsTiny, false);
            }
            //11、商品操作清除缓存
            cleanItemCache(itemId);

            //12、图搜主图删除
            addImgToSearch(itemId,webSite,null, picUrl, 0);
        }
    }

    private static final Pattern ossPattern = Pattern.compile("((http|https):)?(//)?(imgs.571xz.net|shigu.oss-cn-hangzhou.aliyuncs.com)(:\\d+)?(/[^#()?&=]+)+.(jpg|png|gif)");

    public void proccessDeleteOssImage(String text) {
        Matcher matcher = ossPattern.matcher(text);
        // 遍历文本中的OSS图片地址
        while (matcher.find()) {
            String url = matcher.group();
            //截取KEY
            url = url.replace("https:", "").replace("http:", "");
            int path = url.indexOf("/", url.startsWith("//") ? 2 : 0);
            if (path != -1) {
                String key = url.substring(path + 1);
                logger.debug("find key: " + key);
                OSSUtil.deleteObject(key);
            }
        }
    }

    /**
     * 用户删除一款商品
     *
     * @param itemId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void userDeleteItem(Long itemId) throws ItemModifyException {
        systemDeleteItem(itemId);
    }

    /**
     * 系统添加一款商品
     *
     * @param item 通讯对象
     *
     * @return 商品ID
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long systemAddItem(SynItem item) throws ItemModifyException {
        return addItem(item, true);
    }

    /**
     * 商品添加
     *      <doc>http://open.571xz.com/document.htm?did=451</doc>
     *      <task>http://gz.571xz.com:32100/issue/MAIN_SITE4-80</task>
     * @param item  通讯对象
     * @param isSys 是否系统添加
     *
     * @return 商品ID
     */
    @Transactional(rollbackFor = Exception.class)
    protected Long addItem(SynItem item, boolean isSys) throws ItemModifyException {
        if (item == null || StringUtils.isEmpty(item.getWebSite()) || item.getShopId() == null)
            throw new ItemAddException(ItemAddException.ItemAddExceptionEnum.IllegalArgumentException, null);
        //1.添加shigu_goods_id_generator  //下面简称generator

        // 更新批发价 只有系统添加才会自动应用批发价
        if (isSys && item.getPriceString() != null) {
            updatePiPrice(item, item.getTitle(), item.getGoodsNo(), item.getOuterId());
        }

        if (item.getNumIid() != null) {
            // 为店铺内商品做一些检查，预防一些错误
            ShiguGoodsTiny tiny = new ShiguGoodsTiny();
            tiny.setNumIid(item.getNumIid());
            tiny.setWebSite(item.getWebSite());
            tiny.setStoreId(item.getShopId());
            if (shiguGoodsTinyMapper.selectCount(tiny) > 0) {
                throw new ItemAddException(ItemAddException.ItemAddExceptionEnum.ITEM_ALREADY_EXIST, item.getNumIid());
            }

            ShiguGoodsSoldout soldout = new ShiguGoodsSoldout();
            soldout.setWebSite(item.getWebSite());
            soldout.setNumIid(item.getNumIid());
            soldout.setStoreId(item.getShopId());
            if (shiguGoodsSoldoutMapper.selectCount(soldout) > 0) {
                throw new ItemAddException(ItemAddException.ItemAddExceptionEnum.ITEM_ALREADY_INSTOCK, item.getNumIid());
            }
        }

        ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(item.getShopId());
        if (shiguShop == null)
            throw new ItemAddException(ItemAddException.ItemAddExceptionEnum.SHOP_DOES_NOT_EXIST, item.getShopId());

        ShiguGoodsIdGenerator idGenerator = new ShiguGoodsIdGenerator();
        idGenerator.setWebSite(item.getWebSite());
        shiguGoodsIdGeneratorMapper.insertSelective(idGenerator);

        Date now = new Date();

        //2.添加shigu_goods_tiny    //下面简称tiny
        ItemHelper.SynItemContainer container = ItemHelper.helpMe(item);
        ShiguGoodsTiny tiny = container.getTiny();
        tiny.setGoodsId(idGenerator.getGoodId());
        tiny.setCreated(item.getCreated());
        tiny.setDetailUrl("http://item.taobao.com/item.htm?id=" + tiny.getNumIid());
        tiny.setNick(shiguShop.getTbNick());
//        tiny.setCidAll();
        tiny.setLoadDate(now);
        tiny.setListTime(item.getListTime());
        tiny.setDelistTime(item.getDelistTime());
        tiny.setModified(item.getModified());

        ShiguSiteExample siteExample = new ShiguSiteExample();
        siteExample.createCriteria().andCitySiteEqualTo(tiny.getWebSite());
        List<ShiguSite> shiguSiteList = shiguSiteMapper.selectByExample(siteExample);
        ShiguSite shiguSite = new ShiguSite();
        if(shiguSiteList.size() > 0){
            shiguSite = shiguSiteList.get(0);
        }
        if (StringUtils.isEmpty(tiny.getProv())) {
            tiny.setProv(shiguSite.getProvinceName());
        }
        if (StringUtils.isEmpty(tiny.getCity())) {
            tiny.setCity(shiguSite.getCityName());
        }
        try {
            shiguGoodsTinyMapper.insertSelective(tiny);
        } catch (Exception e) {
            throw new ItemModifyException(item.getNumIid()+"_"+item.getShopId()+" 重复插入");
        }


        //3.添加shigu_goods_extends //下面简称extends
        ShiguGoodsExtends goodsExtends = container.getGoodsExtends();
        goodsExtends.setGoodsId(tiny.getGoodsId());
        goodsExtends.setLoadDate(now);
        goodsExtends.setLastModifyTime(now);
        shiguGoodsExtendsMapper.insertSelective(goodsExtends);

        //4.添加shigu_prop_img   //下面简称propimg
        ShiguPropImgs shiguPropImgs = container.getShiguPropImgs();
        shiguPropImgs.setItemId(tiny.getGoodsId());
        shiguPropImgsMapper.insertSelective(shiguPropImgs);
        GoodsCountForsearch goodsCountForsearch = new GoodsCountForsearch();
        goodsCountForsearch.setGoodsId(tiny.getGoodsId());
        goodsCountForsearch.setWebSite(item.getWebSite());
        goodsCountForsearch.setFabric(item.getFabric());
        goodsCountForsearch.setInfabric(item.getInFabric());
        goodsCountForsearchMapper.insertSelective(goodsCountForsearch);
        ShiguGoodsModified shiguGoodsModified = new ShiguGoodsModified();
        shiguGoodsModified.setItemId(tiny.getGoodsId());
        if (item.getPriceString() != null &&!item.getPriceString().equals(item.getPiPriceString())) {
            shiguGoodsModified.setHasSetPrice(1);
        }
        shiguGoodsModifiedMapper.insertSelective(shiguGoodsModified);

        //5.添加es中goods数据
        ESGoods goods = esGoodsServiceImpl.createEsGoods(tiny);
        //ElasticRepository repository = new ElasticRepository();
        SimpleElaBean seb = new SimpleElaBean("goods", tiny.getWebSite(), tiny.getGoodsId().toString());
        seb.setSource(JSON.toJSONStringWithDateFormat(goods, "yyyy-MM-dd HH:mm:ss"));
        //repository.insert(seb);
        goodsAddToRedis.addToRedis(seb);
        sameItemUtilAddRemove(tiny, true);
        //添加首图到图搜
        addImgToSearch(tiny.getGoodsId(),tiny.getWebSite(),null,tiny.getPicUrl(),1);

        return tiny.getGoodsId();
    }

    /**
     * 系统同步一批商品
     *      限制该批商品必须在统一分站、
     *      不限制是否上架商品
     *
     * @param items
     */
    @Override
    public void systemSynSomeItems(List<SynItem> items) throws SystemSynItemException {
        items = items.stream().filter(item -> item != null).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(items)) {
            String webSite = items.get(0).getWebSite();
            Client client = ElasticConfiguration.client;
            BulkRequestBuilder bulk = client.prepareBulk();

            List<ShiguGoodsTiny> shiguGoodsTinies;
            try {
                List<Long> goodsIds = BeanMapper.getFieldList(items, "goodsId", Long.class);

                ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
                tinyExample.setWebSite(webSite);
                tinyExample.createCriteria().andGoodsIdIn(goodsIds);
                shiguGoodsTinies = shiguGoodsTinyMapper.selectByExample(tinyExample);

                ShiguGoodsSoldoutExample soldoutExample = new ShiguGoodsSoldoutExample();
                soldoutExample.setWebSite(webSite);
                soldoutExample.createCriteria().andGoodsIdIn(goodsIds);
                shiguGoodsTinies.addAll(
                        BeanMapper.mapList(
                                shiguGoodsSoldoutMapper.selectByExample(soldoutExample),
                                ShiguGoodsTiny.class
                        )
                );
            } catch (Exception e) {
                shiguGoodsTinies = Collections.emptyList();
            }
            for (ShiguGoodsTiny tiny : shiguGoodsTinies) {
                ESGoods esGoods = esGoodsServiceImpl.createEsGoods(tiny);
                if (esGoods != null) {
                    bulk.add(
                            client.prepareUpdate("goods", tiny.getWebSite(), tiny.getGoodsId().toString())
                                    .setDoc(JSON.toJSONStringWithDateFormat(esGoods, "yyyy-MM-dd HH:mm:ss"))
                    );
                }
                addImgToSearch(tiny.getGoodsId(),tiny.getWebSite(),null,tiny.getPicUrl(),1);
            }
            if (bulk.numberOfActions() > 0) {
                BulkResponse bulkResponse = bulk.get();
                if (bulkResponse.hasFailures())
                    throw new SystemSynItemException(ES_SYN_HAS_ERROR);
            }
        }
    }

    /**
     * 用户添加一款商品
     *
     * @param item
     *
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long userAddItem(SynItem item) throws ItemModifyException {
        return addItem(item, false);
    }

    /**
     * 系统更新一款商品
     *          <doc>http://open.571xz.com/document.htm?did=443</doc>
     *          <task>http://gz.571xz.com:32100/issue/MAIN_SITE4-73</task>
     *
     * @param item 商品对象
     *
     *             · 入参不能为null，为null无意义。
     *             · item.goodsId 不能为null，更新商品必须明确指定本地商品ID
     *             · item.shopId 不能为null，
     *             · item.numIid 不能为null，系统更新依据 shopId & numIid 查询本地商品数据，查询不到则直接返回0
     *
     *
     * @return 是否成功 1：成功更新一个商品，0：无修改
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int systemUpdateItem(SynItem item) throws ItemModifyException {
        if (item == null || item.getGoodsId() == null)
            throw new ItemUpdateException(IllegalArgumentException, null);
        ShiguGoodsModified modified = new ShiguGoodsModified();
        modified.setItemId(item.getGoodsId());
        modified = shiguGoodsModifiedMapper.selectOne(modified);
        Map<String, Boolean> ignore = new HashMap<>();
        if (modified == null) {
            modified = new ShiguGoodsModified();
            modified.setHasModInstock(0);
            modified.setHasSetPiprice(0);
            modified.setHasSetGoodsno(0);
            modified.setHasSetPrice(0);
            modified.setHasSetTitle(0);
        }

        ignore.put("title", modified.getHasSetTitle() == 1);
        ignore.put("goodsNo", modified.getHasSetGoodsno() == 1);
        ignore.put("priceString", modified.getHasSetPrice() == 1);
        ignore.put("piPriceString", modified.getHasSetPiprice() == 1);

        // 表里数据
        ShiguGoodsSoldout soldout = new ShiguGoodsSoldout();
        soldout.setGoodsId(item.getGoodsId());
        soldout.setWebSite(item.getWebSite());
        if (soldout.getWebSite() == null)
            soldout.setWebSite("hz");
        if (shiguGoodsSoldoutMapper.selectCount(soldout) > 0) {
            throw new ItemUpdateException(ITEM_ALREADY_DOWN_SET, item.getGoodsId());
        }

        Class<SynItem> clazz = SynItem.class;
        SynItem synItem = selItemWithSynItem(item.getNumIid(), item.getShopId());
        if (synItem == null)
            throw new ItemUpdateException(ITEM_DOES_NOT_EXIST, item.getGoodsId());//本地数据库无商品

        // 更新批发价
        if (item.getPriceString() != null) {
            updatePiPrice(item, synItem.getTitle(), synItem.getGoodsNo(), synItem.getOuterId());
        }
        boolean changed = false;
        boolean picChange = false;
        for (Field field : clazz.getDeclaredFields()) {
            // 忽略比较字段
            Boolean ignored = ignore.get(field.getName());
            if (ignored != null && ignored)
                continue;

            // 比较
            try {
                field.setAccessible(true);
                Object o = field.get(item);//所有比较过程中，null默认跳过，空字条串认为有内容
                if (o != null && !o.equals(field.get(synItem))) {
                    changed = true;
                    field.set(synItem, o);
                    if (field.getName().equals("picUrl")) {
                        picChange = true;
                    }
                }
            } catch (IllegalAccessException e) {
                logger.error("商品更新操作->对象比较失败.字段" + field.getName() + "无法访问.", e);
            }
        }
        if (changed){
            if (picChange) {
                //查询一下图片有没有修改
                addImgToSearch(synItem.getGoodsId(),item.getWebSite(),synItem.getPicUrl(),item.getPicUrl(), 1);
            }
            return updateItem(synItem);
        }
        return 0;
    }

    /**
     * 更新数据库，更新ES
     *
     * @param synItem 通讯对象
     */
    @Transactional(rollbackFor = Exception.class)
    protected int updateItem(SynItem synItem) {
        //3、更新shigu_goods_tiny表数据、shigu_goods_extends表数据，shigu_prop_imgs表数据。
        ItemHelper.SynItemContainer container = ItemHelper.helpMe(synItem);
        ShiguGoodsTiny goodsTiny = container.getTiny();
        goodsTiny.setCreated(null);//更新的时候不更新创建时间
        if (objectIsNotBlank(goodsTiny)){
            shiguGoodsTinyMapper.updateByPrimaryKeySelective(goodsTiny);
        }
        ShiguGoodsExtends goodsExtends = container.getGoodsExtends();
        if (objectIsNotBlank(goodsExtends))
            shiguGoodsExtendsMapper.updateByPrimaryKeySelective(goodsExtends);

        ShiguPropImgs shiguPropImgs = container.getShiguPropImgs();
        if (objectIsNotBlank(shiguPropImgs)) {
            ShiguPropImgsExample propImgsExample = new ShiguPropImgsExample();
            propImgsExample.createCriteria().andItemIdEqualTo(synItem.getGoodsId());
            shiguPropImgsMapper.updateByExampleSelective(shiguPropImgs, propImgsExample);
        }

        //4、更新es中对应goods数据，以上所有，需要在1个事务中进行
        ShiguGoodsTiny tiny = new ShiguGoodsTiny();
        tiny.setWebSite(goodsTiny.getWebSite());
        tiny.setGoodsId(goodsTiny.getGoodsId());
        tiny = shiguGoodsTinyMapper.selectByPrimaryKey(tiny);

//        ElasticRepository repository = new ElasticRepository();
        SimpleElaBean seb = new SimpleElaBean("goods", tiny.getWebSite(), tiny.getGoodsId().toString());
        seb.setSource(JSON.toJSONStringWithDateFormat(esGoodsServiceImpl.createEsGoods(tiny), "yyyy-MM-dd HH:mm:ss"));
//        repository.insert(seb);
        goodsAddToRedis.addToRedis(seb);

        //5、商品操作清除缓存
        cleanItemCache(synItem.getGoodsId());

        //6、更新代发的产品表
        try {
            if (synItem.getGoodsId()!=null&&StringUtils.isNotEmpty(synItem.getPiPriceString())) {
                ItemProductExample productExample=new ItemProductExample();
                productExample.createCriteria().andGoodsIdEqualTo(synItem.getGoodsId());
                ItemProduct itemProduct=new ItemProduct();
                Double priceDouble=Double.parseDouble(synItem.getPiPriceString())*100;
                itemProduct.setPrice(priceDouble.longValue());
                itemProductMapper.updateByExampleSelective(itemProduct,productExample);
            }
        } catch (Exception e) {
            logger.error("更新订单中product价格信息失败",e);
        }
        return 1;
    }

    /**
     * 检测对象内部各个成员变量是否为null
     * website 忽略， 主键忽略, Transient 忽略，不是纯private修饰的忽略
     * @param o obj
     * @return true/false
     */
    public boolean objectIsNotBlank(Object o) {
        Class<?> clazz = o.getClass();
        next:
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getModifiers() != 2)
                continue;
            String name = field.getName();
            if (name.equalsIgnoreCase("website")) {
                continue;
            }
            Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
            if (declaredAnnotations != null) {
                for (Annotation annotation : declaredAnnotations) {
                    if (annotation.annotationType() == Id.class
                            || annotation.annotationType() == Transient.class) {
                        continue next;
                    }
                }
            }
            field.setAccessible(true);
            try {
                if (field.get(o) != null) {
                    return true;
                }
            } catch (IllegalAccessException e) {
            }
        }
        return false;
    }

    /**
     * 用户更新一款商品
     *
     * @param item 商品通讯对象
     *             <doc>http://open.571xz.com/document.htm?did=443</doc>
     *             <task>http://gz.571xz.com:32100/issue/MAIN_SITE4-74</task>
     *
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int userUpdateItem(SynItem item) throws ItemModifyException {
        if (item == null || item.getGoodsId() == null || item.getWebSite() == null || item.getShopId() == null)
            throw new ItemUpdateException(ItemUpdateException.ItemUpdateExceptionEnum.IllegalArgumentException, null);
        SynItem synItem = selItemByGoodsId(item.getGoodsId(), item.getWebSite());
        if (synItem == null)
            throw new ItemUpdateException(ITEM_DOES_NOT_EXIST, item.getGoodsId());

        // 以下字段修改需记录 --> shigu_goods_modified
        Map<String, Boolean> modifiedMap = new HashMap<>();
        modifiedMap.put("title", false);
        modifiedMap.put("goodsNo", false);
        modifiedMap.put("priceString", false);
        modifiedMap.put("piPriceString", false);
        // 商品无(false)修改
        boolean modify = false;
        // shigu_goods_modified 中的字段无(false)修改
        boolean modifield = false;
        // 主图更新？
        boolean picModifild = false;
        // 比较
        try {
            for (Field field : item.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object o = field.get(item);//所有比较过程中，null默认跳过，空字条串认为有内容
                if (o != null && !o.equals(field.get(synItem))) {
                    if (field.getName().equals("picUrl")) {
                        picModifild = true;
                    }
                    modify = true;
                    for (Map.Entry<String, Boolean> entry : modifiedMap.entrySet()) {
                        if (entry.getKey().equals(field.getName())) {
                            entry.setValue(modifield = true);
                            break;
                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {
            logger.error("商品更新操作->对象比较失败.字段无法访问.", e);
        }

        // 商品修改
        if (modify) {
            // shigu_goods_modified 中的字段修改
            if (modifield) {
                ShiguGoodsModified goodsModified = new ShiguGoodsModified();
                goodsModified.setItemId(item.getGoodsId());
                goodsModified = shiguGoodsModifiedMapper.selectOne(goodsModified);
                if (goodsModified == null) {
                    goodsModified = new ShiguGoodsModified();
                    goodsModified.setItemId(synItem.getGoodsId());
                    shiguGoodsModifiedMapper.insertSelective(goodsModified);
                }
                if (modifiedMap.get("title"))
                    goodsModified.setHasSetTitle(1);
                if (modifiedMap.get("goodsNo"))
                    goodsModified.setHasSetGoodsno(1);
                if (modifiedMap.get("priceString"))
                    goodsModified.setHasSetPrice(1);
                if (modifiedMap.get("piPriceString"))
                    goodsModified.setHasSetPiprice(1);
                shiguGoodsModifiedMapper.updateByPrimaryKeySelective(goodsModified);
            }
            if (picModifild) {
                addImgToSearch(synItem.getGoodsId(),item.getWebSite(), synItem.getPicUrl(),item.getPicUrl(), 1);
            }
            return updateItem(item);
        }
        return 0;
    }

    /**
     * 按淘宝numIid查商品
     *
     * @param numIid
     *
     * @return
     */
    @Override
    public SynItem selItemWithSynItem(Long numIid,Long shopId) {
        ShiguShop shiguShop;
        if (numIid != null && shopId != null && (shiguShop = shiguShopMapper.selectByPrimaryKey(shopId)) != null) {
            ShiguGoodsTiny tiny = new ShiguGoodsTiny();
            tiny.setWebSite(shiguShop.getWebSite());
            tiny.setStoreId(shopId);
            tiny.setNumIid(numIid);
            List<ShiguGoodsTiny> select = shiguGoodsTinyMapper.select(tiny);
            if (!select.isEmpty()) {
                // 查询商品数据
                tiny = select.get(0);

                // 查询商品扩展
                ShiguGoodsExtends goodsExtends = new ShiguGoodsExtends();
                goodsExtends.setWebSite(shiguShop.getWebSite());
                goodsExtends.setGoodsId(tiny.getGoodsId());
                goodsExtends = shiguGoodsExtendsMapper.selectByPrimaryKey(goodsExtends);

                // 查询商品属性图
                ShiguPropImgs propImgs = new ShiguPropImgs();
                propImgs.setItemId(tiny.getGoodsId());
                propImgs = shiguPropImgsMapper.selectOne(propImgs);

                return ItemHelper.toSynItem(tiny, goodsExtends, propImgs);
            }
        }
        return null;
    }

    public SynItem selItemByGoodsId(Long goodsId, String webSite) {
        if (goodsId != null && StringUtils.isNotEmpty(webSite)) {
            ShiguGoodsTiny tiny = new ShiguGoodsTiny();
            tiny.setGoodsId(goodsId);
            tiny.setWebSite(webSite);
            tiny = shiguGoodsTinyMapper.selectByPrimaryKey(tiny);
            if (tiny != null) {
                // 查询商品扩展
                ShiguGoodsExtends goodsExtends = new ShiguGoodsExtends();
                goodsExtends.setWebSite(webSite);
                goodsExtends.setGoodsId(tiny.getGoodsId());
                goodsExtends = shiguGoodsExtendsMapper.selectByPrimaryKey(goodsExtends);

                // 查询商品属性图
                ShiguPropImgs propImgs = new ShiguPropImgs();
                propImgs.setItemId(tiny.getGoodsId());
                propImgs = shiguPropImgsMapper.selectOne(propImgs);

                return ItemHelper.toSynItem(tiny, goodsExtends, propImgs);
            }
        }
        return null;
    }

    /**
     * 查询是否有更新
     *
     * @param item
     *
     * @return
     */
    @Override
    public boolean hasUpdated(SynItem item) {
        return false;
    }

    @Override
    public void addImgToSearch(Long goodsId,String webSite,String oldUrl, String url, int type) {
        if(goodsId!=null&&StringUtils.isNotEmpty(url)){
            ImgToSearch imgToSearch=new ImgToSearch(goodsId,webSite,oldUrl,url,type);
            redisIO.rpush("update_del_img_search",imgToSearch);
        }
    }

    /**
     * 更新商品对象的批发价，
     * @param item 商品
     * @param strs 批发价来源
     */
    private void updatePiPrice(SynItem item, String ... strs) {
        // 应用批发价
        Long price = new Double(Double.valueOf(item.getPriceString()) * 100).longValue();
        Long piPrice = priceCalculateService.pickPipriceFromTitle(
                item.getShopId(),
                price,
                strs
        );
        item.setPiPriceString(String.format("%.2f", piPrice / 100.0));
    }

    /**
     * 修改商品风格
     * @param goodsId 商品ID
     * @param webSite 分站
     * @param sids 风格ID
     */
    public void addGoodsStyle(Long goodsId, String webSite, String sids) throws ItemUpdateException {
        ShiguGoodsTiny tiny = new ShiguGoodsTiny();
        tiny.setGoodsId(goodsId);
        tiny.setWebSite(webSite);
        tiny = shiguGoodsTinyMapper.selectByPrimaryKey(tiny);
        if (tiny == null) {
            throw new ItemUpdateException(ItemUpdateException.ItemUpdateExceptionEnum.ITEM_DOES_NOT_EXIST, goodsId);
        }

        ShiguGoodsStyle goodsStyle;
        ShiguGoodsStyle style = new ShiguGoodsStyle();
        style.setGoodsId(goodsId);
        if ((goodsStyle = shiguGoodsStyleMapper.selectOne(style)) != null) {
            if (!Objects.equals(sids, goodsStyle.getSids())) {
                goodsStyle.setSids(sids);
                shiguGoodsStyleMapper.updateByPrimaryKey(goodsStyle);
            }
        } else {
            style.setSids(sids);
            shiguGoodsStyleMapper.insertSelective(style);
        }

        ESGoods goods = esGoodsServiceImpl.createEsGoods(tiny);
        SimpleElaBean seb = new SimpleElaBean("goods", tiny.getWebSite(), tiny.getGoodsId().toString());
        seb.setSource(JSON.toJSONStringWithDateFormat(goods, "yyyy-MM-dd HH:mm:ss"));
        new ElasticRepository().insert(seb);
    }

    @Override
    public void setCustomStyle(Long goodsId, Integer sid, String webSite) {
            GoodsCountForsearch goodsCountForsearch = new GoodsCountForsearch();
            goodsCountForsearch.setGoodsId(goodsId);
            goodsCountForsearch=  goodsCountForsearchMapper.selectOne(goodsCountForsearch);
            if(goodsCountForsearch != null) {
                goodsCountForsearch.setGoodsId(goodsId);
                goodsCountForsearch.setHadStyle(1);
                goodsCountForsearch.setSid(sid);
                if(sid<=2000){
                    SearchCategorySub searchCategorySub = new SearchCategorySub();
                    searchCategorySub.setSubId(Long.valueOf(sid));
                    searchCategorySub=searchCategorySubMapper.selectOne(searchCategorySub);
                    goodsCountForsearch.setStyleName(searchCategorySub.getCateName());
                }else{
                    goodsCountForsearch.setStyleName(null);
                }
                goodsCountForsearchMapper.updateByPrimaryKey(goodsCountForsearch);
            }else{
                GoodsCountForsearch goodsCountForsearch1 = new GoodsCountForsearch();
                goodsCountForsearch1.setGoodsId(goodsId);
                goodsCountForsearch1.setHadStyle(1);
                goodsCountForsearch1.setSid(sid);
                if(sid<=2000){
                    SearchCategorySub searchCategorySub = new SearchCategorySub();
                    searchCategorySub.setSubId(Long.valueOf(sid));
                    searchCategorySub=searchCategorySubMapper.selectOne(searchCategorySub);
                    goodsCountForsearch1.setStyleName(searchCategorySub.getCateName());
                }else{
                    goodsCountForsearch1.setStyleName(null);
                }
                goodsCountForsearch1.setWebSite(webSite);
                goodsCountForsearch1.setUp(0L);
                goodsCountForsearch1.setUpMan(0L);
                goodsCountForsearch1.setClick(0L);
                goodsCountForsearch1.setClickIp(0L);
                goodsCountForsearch1.setHadGoat(0);
                goodsCountForsearch1.setTrade(0L);
                goodsCountForsearch1.setHadBigzip(0);
                goodsCountForsearch1.setHadVideo(0);

                goodsCountForsearchMapper.insert(goodsCountForsearch1);
            }

    }

    @Override
    public Long addCustomerStyle(Long categoryId, String goodsStyleName, Long userId) {
        if (goodsStyleName != null && StringUtils.isNotEmpty(goodsStyleName) && goodsStyleName.length() < 45) {
            ShiguCustomerStyleExample example = new ShiguCustomerStyleExample();
            example.createCriteria().andUserIdEqualTo(userId).andStyleNameEqualTo(goodsStyleName);
            List<ShiguCustomerStyle> shiguCustomerStyles = shiguCustomerStyleMapper.selectByExample(example);
            //判断是否已存在
            if (shiguCustomerStyles == null||shiguCustomerStyles.isEmpty()) {
                ShiguCustomerStyle shiguCustomerStyle = new ShiguCustomerStyle();
                shiguCustomerStyle.setCId(categoryId);
                shiguCustomerStyle.setStyleName(goodsStyleName);
                shiguCustomerStyle.setUserId(userId);
                shiguCustomerStyleMapper.insert(shiguCustomerStyle);
                //设置排序数值为
                ShiguCustomerStyleExample shiguCustomerStyleExample = new ShiguCustomerStyleExample();
                shiguCustomerStyleExample.createCriteria().andUserIdEqualTo(userId);
                int i = shiguCustomerStyleMapper.countByExample(shiguCustomerStyleExample);
                shiguCustomerStyle.setSort(i);
                shiguCustomerStyleMapper.updateByPrimaryKey(shiguCustomerStyle);
                return shiguCustomerStyle.getStyleId();
            }
        }
            return 0L;
    }



    @Override
    public Long updateCustomerStyle(Long categoryId, Long goodsStyleId, String goodsStyleName, Long userId) {
        if(goodsStyleId!=null&&categoryId!=null&&StringUtils.isNotEmpty(goodsStyleName)&&goodsStyleName.length()<45){
            ShiguCustomerStyleExample shiguCustomerStyleExample = new ShiguCustomerStyleExample();
            shiguCustomerStyleExample.createCriteria().andUserIdEqualTo(userId).andStyleNameEqualTo(goodsStyleName).andCIdEqualTo(categoryId);
            List<ShiguCustomerStyle> shiguCustomerStyles = shiguCustomerStyleMapper.selectByExample(shiguCustomerStyleExample);
            //判断是否已存在
            if(shiguCustomerStyles!=null&& shiguCustomerStyles.size()>0){
                return 0L;
            }
            shiguCustomerStyleExample.clear();
            shiguCustomerStyleExample.createCriteria().andStyleIdEqualTo(goodsStyleId);
            List<ShiguCustomerStyle> list = shiguCustomerStyleMapper.selectByExample(shiguCustomerStyleExample);
            if(list!=null && list.size()>0){
                ShiguCustomerStyle shiguCustomerStyle =list.get(0);
                shiguCustomerStyle.setCId(categoryId);
                shiguCustomerStyle.setStyleName(goodsStyleName);
                return  Long.valueOf(shiguCustomerStyleMapper.updateByPrimaryKey(shiguCustomerStyle));
            }
        }
        return 0L;
    }

    @Override
    public void deleteCustomerStyle(Long goodsStyleId, Long userId, String website, Long shopId) {
        if (goodsStyleId!=null){
            ShiguCustomerStyleExample shiguCustomerStyleExample = new ShiguCustomerStyleExample();
            shiguCustomerStyleExample.createCriteria().andStyleIdEqualTo(goodsStyleId);
            shiguCustomerStyleMapper.deleteByExample(shiguCustomerStyleExample);
            //查当前风格的goods，并设置
            GoodsCountForsearchExample goodsCountForsearchExample = new GoodsCountForsearchExample();
            goodsCountForsearchExample.createCriteria().andWebSiteEqualTo(website).andSidEqualTo(goodsStyleId);
            List<GoodsCountForsearch> goodsCountForsearches = goodsCountForsearchMapper.selectByExample(goodsCountForsearchExample);
            if(goodsCountForsearches != null && goodsCountForsearches.size()>0){
                for (GoodsCountForsearch goodsCountForsearch: goodsCountForsearches){
                    goodsCountForsearch.setHadStyle(0);
                    goodsCountForsearch.setSid(null);
                    goodsCountForsearch.setStyleName(null);
                    goodsCountForsearchMapper.updateByPrimaryKey(goodsCountForsearch);
                }
            }
        }

    }

    @Override
    public void moveSortCustomerStyle(Long goodsStyleId, Integer sortType) {
        ShiguCustomerStyleExample shiguCustomerStyleExample = new ShiguCustomerStyleExample();
        shiguCustomerStyleExample.createCriteria().andStyleIdEqualTo(goodsStyleId);
        List<ShiguCustomerStyle> shiguCustomerStyles = shiguCustomerStyleMapper.selectByExample(shiguCustomerStyleExample);
        if (shiguCustomerStyles.size()>0&&shiguCustomerStyles!=null){
            ShiguCustomerStyle shiguCustomerStyle =shiguCustomerStyles.get(0);
            int sort1=shiguCustomerStyle.getSort();//调整前的序号
            int sort=shiguCustomerStyle.getSort()+sortType;//调整后的序号
            ShiguCustomerStyleExample shiguCustomerStyleExample1 = new ShiguCustomerStyleExample();
            shiguCustomerStyleExample1.createCriteria().andSortEqualTo(sort);
            List<ShiguCustomerStyle> shiguCustomerStyles1 = shiguCustomerStyleMapper.selectByExample(shiguCustomerStyleExample1);
            //调换序号
            if(shiguCustomerStyles1.size()>0&&shiguCustomerStyles1!=null){
                shiguCustomerStyle.setSort(sort);
                shiguCustomerStyles1.get(0).setSort(sort1);
                shiguCustomerStyleMapper.updateByPrimaryKey(shiguCustomerStyle);
                shiguCustomerStyleMapper.updateByPrimaryKey(shiguCustomerStyles1.get(0));
            }
        }
    }
}
