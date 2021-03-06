package com.shigu.main4.item.services;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.TaobaoItemPropExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.enums.ShopLicenseTypeEnum;
import com.shigu.main4.item.enums.ItemFrom;
import com.shigu.main4.item.model.ItemSkuModel;
import com.shigu.main4.item.services.utils.SkuCheckUtil;
import com.shigu.main4.item.tools.CacheUtil;
import com.shigu.main4.item.tools.ItemCache;
import com.shigu.main4.item.vo.CdnItem;
import com.shigu.main4.item.vo.NormalProp;
import com.shigu.main4.item.vo.SaleProp;
import com.shigu.main4.item.vo.news.NewCdnItem;
import com.shigu.main4.item.vo.news.SingleSkuVO;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 分站点显示用服务
 * Created by zhaohongbo on 17/2/16.
 */
@Service("showForCdnService")
public class ShowForCdnServiceImpl extends ItemServiceImpl implements ShowForCdnService {

    private static final Logger logger = LoggerFactory.getLogger(ShowForCdnServiceImpl.class);

    @Resource(name = "tae_mall_shiguGoodsIdGeneratorMapper")
    private ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;

    @Resource(name = "tae_mall_shiguGoodsTinyMapper")
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Resource(name = "tae_mall_shiguGoodsSoldoutMapper")
    private ShiguGoodsSoldoutMapper shiguGoodsSoldoutMapper;

    @Resource(name = "tae_mall_shiguGoodsExtendsMapper")
    private ShiguGoodsExtendsMapper shiguGoodsExtendsMapper;

    @Resource(name = "tae_mall_shiguShopLicenseMapper")
    private ShiguShopLicenseMapper shiguShopLicenseMapper;

    @Resource(name = "tae_mall_shiguGoodsUnlicenseMapper")
    private ShiguGoodsUnlicenseMapper shiguGoodsUnlicenseMapper;
    @Autowired
    private TaobaoItemPropMapper taobaoItemPropMapper;

    @Autowired
    private GoodsCountForsearchMapper goodsCountForsearchMapper;

    @Autowired
    private ShiguPropImgsMapper shiguPropImgsMapper;

    @Autowired
    private ShiguGoodsSingleSkuMapper shiguGoodsSingleSkuMapper;

    @Autowired
    private RedisIO redisIO;

    private TinyItemSelector tinyItemSelector = new TinyItemSelector();

    private SoldoutItemSelector soldoutItemSelector = new SoldoutItemSelector();

    private static final String ITEM_DUBBO_CACHE_SYNCHRONIZED = "item_dubbo_cache_synchronized";

    @Autowired
    private ItemCache itemCache;

    /**
     * 按商品ID查商品
     *
     * @param id 商品主键
     *
     * @return CdnItem
     */
    @Override
    public CdnItem selItemById(Long id) {
        return tinyItemSelector.selectItemById(id,null);
    }

    /**
     * 按商品ID和分站标识查商品
     *
     * @param id      商品主键
     * @param webSite 分站点
     *
     * @return CdnItem
     */
    @Override
    public CdnItem selItemById(Long id, String webSite) {
        return tinyItemSelector.selectItemById(id, webSite);
    }

    /**
     * 查询仓库中的商品信息,按商品ID
     *
     * @param id 商品ID
     *
     * @return 商品信息
     */
    @Override
    public CdnItem selItemInstockById(Long id) {
        return soldoutItemSelector.selectItemById(id,null);
    }

    /**
     * 查询仓库中的商品信息,按商品ID,webSite
     *
     * @param id      商品ID
     * @param webSite 分站标识
     *
     * @return 商品信息
     */
    @Override
    public CdnItem selItemInstockById(Long id, String webSite) {
        return soldoutItemSelector.selectItemById(id, webSite);
    }

    /**
     * 商品权益
     *
     * @param id 商品ID
     *
     * @return 权益的value
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<String> selItemLicenses(Long id) {
        CdnItem item = tinyItemSelector.selectItemById(id,null);
        if (item != null)
            return selItemLicenses(id, item.getShopId());
        return Collections.EMPTY_LIST;
    }

    /**
     * 商品权益
     *
     * @param id     商品ID
     * @param shopId 店铺ID
     *
     * @return 权益的value
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<String> selItemLicenses(Long id, Long shopId) {
        ShiguShopLicense license = new ShiguShopLicense();
        license.setLicenseType(ShopLicenseTypeEnum.TAGS.ordinal());
        license.setShopId(shopId);
        license.setLicenseFailure(0);//有效
        license = shiguShopLicenseMapper.selectOne(license);

        String shopLicense;
        if (license == null || StringUtils.isEmpty(shopLicense = license.getContext()))
            return Collections.EMPTY_LIST;

        // 得到店铺权益列表
        List<String> shopLicensesList = new ArrayList<>(Arrays.asList(shopLicense.split(",")));

        ShiguGoodsUnlicense shiguGoodsUnlicense = new ShiguGoodsUnlicense();
        shiguGoodsUnlicense.setGoodsId(id);
        shiguGoodsUnlicense = shiguGoodsUnlicenseMapper.selectOne(shiguGoodsUnlicense);

        String goodsUnlicense;
        if (shiguGoodsUnlicense == null
                || StringUtils.isEmpty(goodsUnlicense = shiguGoodsUnlicense.getUnlicenseContext()))
            return shopLicensesList;

        shopLicensesList.removeAll(Arrays.asList(goodsUnlicense.split(",")));
        return shopLicensesList;
    }

    @Override
    public Integer updateSkuPriceStock(List<SingleSkuVO> skus,String webSite) {
        Integer b = 0;
        for (SingleSkuVO sku : skus) {
            ShiguGoodsSingleSku singleSku = new ShiguGoodsSingleSku();
            singleSku.setStockNum(sku.getStockNum());
            singleSku.setPriceString(sku.getPriceString());
            singleSku.setSkuId(sku.getSkuId());
            singleSku.setWebSite(webSite);
            b=shiguGoodsSingleSkuMapper.updateByPrimaryKeySelective(singleSku);
            if (b<=0){
                break;
            }
        }
        if (skus != null && skus.get(0) != null && skus.get(0).getGoodsId() != null)
           itemCache.cleanItemCache(skus.get(0).getGoodsId());
        return b;
    }

    /**
     * 商品查询
     */
    private class TinyItemSelector extends AbstractCdnItemSelector<ShiguGoodsTiny> {
        @Override
        protected ShiguGoodsTiny getItemSource(Long id, String webSite) {
            ShiguGoodsTiny tiny = new ShiguGoodsTiny();
            tiny.setGoodsId(id);
            tiny.setWebSite(webSite);
            return shiguGoodsTinyMapper.selectByPrimaryKey(tiny);
        }
    }

    /**
     * 仓库中的商品信息
     */
    private class SoldoutItemSelector extends AbstractCdnItemSelector<ShiguGoodsSoldout> {
        @Override
        protected ShiguGoodsSoldout getItemSource(Long id, String webSite) {
            ShiguGoodsSoldout soldout = new ShiguGoodsSoldout();
            soldout.setGoodsId(id);
            soldout.setWebSite(webSite);
            return shiguGoodsSoldoutMapper.selectByPrimaryKey(soldout);
        }
    }


    /**
     * 抽象CdnItem 商品获取类 ,提供了商品对象以及下架商品对CdnItem的映射封装，以及cache
     * <p>
     * 本类允许 商品对象 和 下架商品对象 作为泛型参数， 其他类型将直接返回null
     *
     * @param <E> only allow type
     *
     * @see com.opentae.data.mall.beans.ShiguGoodsTiny
     * @see com.opentae.data.mall.beans.ShiguGoodsSoldout
     */
    private abstract class AbstractCdnItemSelector<E> {

        /**
         * CdnItem字段映射到其他类的某字段
         */
        private Map<String, String> cdnMapper;

        AbstractCdnItemSelector() {
            cdnMapper = new HashMap<>();
            cdnMapper.put("shopId", "storeId");
            cdnMapper.put("tbNumIid", "numIid");
            cdnMapper.put("listTime", "created");
            cdnMapper.put("huohao", "goodsNo");
        }

        /**
         * 允许的类型
         *
         * @param e 抽象实例
         *
         * @return 判定 结果
         */
        private boolean allowType(E e) {
            return e instanceof ShiguGoodsTiny || e instanceof ShiguGoodsSoldout;
        }

        /**
         * 实现该方法 以获取商品原始对象（数据库对象）
         *
         * @param id      商品原始ID
         * @param webSite 分站
         *
         * @return E
         */
        protected abstract E getItemSource(Long id, String webSite);

//        NewCdnItem selectItemById(Long id) {
//            if (id == null)
//                return null;
//
//            Cache cdnItemCache = cacheManager.getCache("cdnItemCache");
//            NewCdnItem cdnItem = cdnItemCache.get(id, NewCdnItem.class);
//            if (cdnItem == null ) {
//                ShiguGoodsIdGenerator shiguGoodsIdGenerator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(id);
//                if (shiguGoodsIdGenerator != null) {
//                    cdnItem = selectItemById(id, shiguGoodsIdGenerator.getWebSite());
//                }
//            }
//            return cdnItem;
//        }

        /**
         * 默认规则：
         *      字段同名同类型直接注入, null值抛弃
         *      CdnItem     E.value     handle
         *      String      Date        DateFormat("yyyy-MM-dd", value)
         *      String      Long        conta
         *      String      Other       value.toString()
         *      Long        String      Long.valueOf(value)
         *
         * @param e
         * @return
         */
        private NewCdnItem newCdnItem(E e) {
            NewCdnItem cdnItem = new NewCdnItem();
            Class<?> clazz = e.getClass();
            for (Field field : CdnItem.class.getDeclaredFields()) {
                if (field.getModifiers() != Modifier.PRIVATE) {
                    continue;
                }
                String name = field.getName();
                try {

                    Field eField = null;
                    try {
                        eField = clazz.getDeclaredField(name);
                    }catch (Exception ignore){}
                    if (eField == null) {
                        String targetFieldName = cdnMapper.get(name);
                        if (targetFieldName != null)
                            try {eField = clazz.getDeclaredField(targetFieldName);}catch (Exception ignore){}
                        if (eField == null)
                            continue;
                    }
                    field.setAccessible(true);
                    eField.setAccessible(true);
                    Class<?> fieldType = field.getType();
                    Class<?> eFieldType = eField.getType();
                    Object value = eField.get(e);
                    if (value != null) {
                        //TODO：类型继续判断下去

                        if (fieldType != eFieldType) {
                            if (fieldType == String.class) {
                                if (eFieldType == Date.class) {
                                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                    value = sdf.format(value);
                                } else if (eFieldType == Long.class && name.toLowerCase().contains("price")) {
                                    value = String.format("%.2f", (Long) value / 100.00);
                                }
                                value = value.toString();
                            } else if (fieldType == Long.class && eFieldType == String.class) {
                                value = Long.valueOf((String) value);
                            }

                        }

                        field.set(cdnItem, value);
                    }
                } catch (IllegalAccessException | NumberFormatException e1) {
                    logger.warn(e1.getMessage());
                }
            }
            return cdnItem;
        }

        NewCdnItem selectItemById(Long id, String webSite) {
            if (id == null)
                return null;

            String redisTimestamp = redisIO.hget(ITEM_DUBBO_CACHE_SYNCHRONIZED, id.toString());
            Cache cdnItemCache = cacheManager.getCache("cdnItemCache");
            NewCdnItem cdnItem = cdnItemCache.get(id, NewCdnItem.class);
            Integer cacheChang = CacheUtil.comparisonTimestamp(cdnItem==null?null:cdnItem.getTimestamp(),redisTimestamp==null?null:Long.valueOf(redisTimestamp));
            if (cdnItem == null || cacheChang > 0) {
                if (StringUtils.isEmpty(webSite)) {
                    ShiguGoodsIdGenerator shiguGoodsIdGenerator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(id);
                    if (shiguGoodsIdGenerator == null || StringUtils.isEmpty(shiguGoodsIdGenerator.getWebSite()))
                        return null;
                    webSite = shiguGoodsIdGenerator.getWebSite();
                }
                E e = getItemSource(id, webSite);

                if (e == null || !allowType(e))
                    return null;

                // 基础数据 处理
                cdnItem = newCdnItem(e);
                boolean callSkus=true;
                // 一些特殊的处理
                if (e instanceof ShiguGoodsTiny) {
                    ShiguGoodsTiny tiny = (ShiguGoodsTiny) e;
                    Integer from = tiny.getIsExcelImp();
                    cdnItem.setItemFrom(from == null ? ItemFrom.NONE : ItemFrom.values()[from]);
                    cdnItem.setSendFrom(tiny.getProv() + tiny.getCity());
                    // Tiny 商品价格和批发价是 以分为单位的Long值，需格式化成以元为单位的小数字符串
//                    NumberFormat instance = NumberFormat.getInstance();
//                    instance.setMaximumFractionDigits(2);//这种方法可以得到保留两位的值,但不能得到保留两位的格式
                    cdnItem.setMarketId(tiny.getParentMarketId());
                    cdnItem.setFloorId(tiny.getMarketId());
                    cdnItem.setListTime(DateFormatUtils.format(tiny.getCreated(), "yyyy-MM-dd"));
                    cdnItem.setOnsale(tiny.getIsClosed()!=null&&tiny.getIsClosed()==0L);
                } else if (e instanceof ShiguGoodsSoldout) {
                    callSkus=false;
                    ShiguGoodsSoldout soldout = (ShiguGoodsSoldout) e;
                    Integer from = soldout.getIsExcelImp();
                    cdnItem.setItemFrom(from == null ? ItemFrom.NONE : ItemFrom.values()[from]);
                    cdnItem.setSendFrom(soldout.getProv() + soldout.getCity());
                    cdnItem.setFloorId(soldout.getMarketId());
                    cdnItem.setListTime(DateFormatUtils.format(soldout.getCreated(), "yyyy-MM-dd"));
                    // 仓库中商品价格 和 批发价可能不在
                    cdnItem.setOnsale(false);
                }

                // 商品扩展信息
                ShiguGoodsExtends shiguGoodsExtends = new ShiguGoodsExtends();
                shiguGoodsExtends.setWebSite(webSite);
                shiguGoodsExtends.setGoodsId(id);
                ShiguGoodsExtends goodsExtends = shiguGoodsExtendsMapper.selectByPrimaryKey(shiguGoodsExtends);

                if (goodsExtends != null) {
                    cdnItem.setDescription(goodsExtends.getGoodsDesc());
                    String images = goodsExtends.getImages();
                    if (!StringUtils.isEmpty(images))
                        cdnItem.setImgUrl(Arrays.asList(images.split(",")));
                    cdnItem.setColors(new ArrayList<SaleProp>());
                    cdnItem.setSizes(new ArrayList<SaleProp>());
                    cdnItem.setNormalProps(new ArrayList<NormalProp>());

                    // 分析属性
                    String propsName = goodsExtends.getPropsName();
                    if (!StringUtils.isEmpty(propsName)) {
                        String propertyAlias = goodsExtends.getPropertyAlias();
                        // 构造属性别名Map 规则 K = pid:vid, V = alias
                        Map<String, String> alias = new HashMap<>();
                        if (!StringUtils.isEmpty(propertyAlias)) {
                            for (String s : propertyAlias.split(";")) {
                                int index = s.lastIndexOf(":");
                                if (index != -1)
                                    alias.put(s.substring(0, index), s.substring(index + 1));
                            }
                        }

                        // 颜色属性图片Map
                        Map<String, String> propImgMap = new HashMap<>();
                        ShiguPropImgs propImgs = new ShiguPropImgs();
                        propImgs.setItemId(id);
                        propImgs = shiguPropImgsMapper.selectOne(propImgs);

                        if (propImgs != null) {
                            String propimgs = propImgs.getPropimgs();
                            if (!StringUtils.isEmpty(propimgs)) {
                                for (String s : propimgs.split(";")) {
                                    String[] split = s.split("##");
                                    if (split.length == 2) { // 格式不符合的不处理
                                        //[0]: pv, [1]:url
                                        propImgMap.put(split[0], split[1]);
                                    }
                                }
                            }
                        }
                        List<String> salePids=new ArrayList<>();
                        try {
                            TaobaoItemPropExample taobaoItemPropExample=new TaobaoItemPropExample();
                            taobaoItemPropExample.createCriteria().andCidEqualTo(cdnItem.getCid()).andIsSalePropEqualTo(1);
                            salePids= taobaoItemPropMapper.selectFieldsByExample(taobaoItemPropExample, FieldUtil.codeFields("tipid,pid"))
                                    .stream().map(taobaoItemProp -> taobaoItemProp.getPid().toString()).collect(Collectors.toList());
                        } catch (Exception ignored) {
                        }
                        // 解构 prop
                        for (String prop : propsName.split(";")) {
                            String[] pv = prop.split(":");
                            if (pv.length == 4) {//只认长度为4的
                                String pid = pv[0];
                                String vid = pv[1];
                                String pname = pv[2];
                                String value = pv[3];

                                String pvid = pid + ":" + vid;
                                // 处理属性别名
                                String s = alias.get(pvid);
                                if (!StringUtils.isEmpty(s)){
                                    value = s;
                                }
                                boolean isSale=false;
                                //如果salePids长度为0,意味着数据查询失败,暂定用原来的读取方式
                                if(salePids.size()==0 || salePids.contains(pid)){
                                    isSale=true;
                                }

                                // color & size or normal prop dispatcher
                                if (isSale&&(SkuCheckUtil.isColorProp(pid, pname) || SkuCheckUtil.isSizeProp(pid, pname))) {
                                    SaleProp saleProp = new SaleProp();
                                    saleProp.setPid(Long.valueOf(pid));
                                    saleProp.setVid(Long.valueOf(vid));
                                    saleProp.setPname(pname);
                                    saleProp.setValue(value);
                                    if (SkuCheckUtil.isColorProp(pid, pname)) {
                                        // 只有颜色属性可能带图
                                        saleProp.setImgUrl(propImgMap.get(pvid));
                                        cdnItem.getColors().add(saleProp);
                                    } else {
                                        cdnItem.getSizes().add(saleProp);
                                    }
                                } else { // normal prop
                                    NormalProp normalProp = new NormalProp();
                                    normalProp.setPname(pname);
                                    normalProp.setValue(value);
                                    cdnItem.getNormalProps().add(normalProp);
                                } // 属性分发完毕 end
                            } // 判断合法属性 end
                        } // 属性处理循环 end
                    } //可用属性处理 end
                } // 商品扩展信息处理 end
                GoodsCountForsearch goodsCountForsearch = new GoodsCountForsearch();
                goodsCountForsearch.setGoodsId(id);
                goodsCountForsearch = goodsCountForsearchMapper.selectOne(goodsCountForsearch);
                if (goodsCountForsearch != null) {
                    cdnItem.setFabric(goodsCountForsearch.getFabric());
                    cdnItem.setInFabric(goodsCountForsearch.getInfabric());
                    cdnItem.setGoodsVideoUrl(goodsCountForsearch.getVideoUrl());
                }
                cdnItem.setSingleSkus(new ArrayList<>());
                //补充独立sku
                if(callSkus) {
                    try {
                        cdnItem.setSingleSkus(SpringBeanFactory.getBean(ItemSkuModel.class, id).pull());
                    } catch (Exception e1) {
                        logger.error("商品独立sku失败,id=" + id);
                    }
                }
                //时间戳
                if (redisTimestamp == null) {
                    Long timestamp = System.currentTimeMillis();
                    cdnItem.setTimestamp(timestamp);
                    redisIO.hset(ITEM_DUBBO_CACHE_SYNCHRONIZED,id.toString(),timestamp);
                }else {
                    cdnItem.setTimestamp(Long.valueOf(redisTimestamp));
                }
                // cache this item
                cdnItemCache.put(id, cdnItem);
            }else if (cdnItem != null && cacheChang < 0){
                redisIO.hset(ITEM_DUBBO_CACHE_SYNCHRONIZED,id.toString(),cdnItem.getTimestamp());
            }// 缓存未命中处理 end
            return cdnItem;
        }
    }
}
