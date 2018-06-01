package com.shigu.main4.item.newservice.impl;

import com.alibaba.fastjson.JSON;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.ShiguSiteExample;
import com.opentae.data.mall.interfaces.*;
import com.searchtool.domain.SimpleElaBean;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.item.bo.news.NewPushSynItemBO;
import com.shigu.main4.item.exceptions.ItemAddException;
import com.shigu.main4.item.exceptions.ItemModifyException;
import com.shigu.main4.item.model.ItemSkuModel;
import com.shigu.main4.item.newservice.NewItemAddOrUpdateService;
import com.shigu.main4.item.services.PriceCalculateService;
import com.shigu.main4.item.services.impl.EsGoodsServiceImpl;
import com.shigu.main4.item.services.impl.ItemAddOrUpdateServiceImpl;
import com.shigu.main4.item.services.impl.SameItemUtil;
import com.shigu.main4.item.tools.GoodsAddToRedis;
import com.shigu.main4.item.tools.ItemCache;
import com.shigu.main4.item.tools.ItemHelper;
import com.shigu.main4.item.vo.news.NewPullSynItemVO;
import com.shigu.main4.item.vo.SynItem;
import com.shigu.main4.tools.RedisIO;
import com.shigu.main4.tools.SpringBeanFactory;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by wxc on 2017/2/25.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@Service("newItemAddOrUpdateService")
public class NewItemAddOrUpdateServiceImpl extends ItemAddOrUpdateServiceImpl implements NewItemAddOrUpdateService {

    private static final Logger logger = LoggerFactory.getLogger(NewItemAddOrUpdateServiceImpl.class);

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long systemAddItem(NewPushSynItemBO item) throws ItemModifyException {
        return addItem(item, true);
    }

    /**
     * 商品添加
     * <doc>http://open.571xz.com/document.htm?did=451</doc>
     * <task>http://gz.571xz.com:32100/issue/MAIN_SITE4-80</task>
     *
     * @param item  通讯对象
     * @param isSys 是否系统添加
     * @return 商品ID
     */
    @Transactional(rollbackFor = Exception.class)
    protected Long addItem(NewPushSynItemBO item, boolean isSys) throws ItemModifyException {
        if (item == null || StringUtils.isEmpty(item.getWebSite()) || item.getShopId() == null) {
            throw new ItemAddException(ItemAddException.ItemAddExceptionEnum.IllegalArgumentException, null);
        }
        //1.添加shigu_goods_id_generator  //下面简称generator
        if (item.getListTime() == null) {
            item.setListTime(item.getModified());
        }
        if (item.getDelistTime() == null) {
            item.setDelistTime(item.getModified());
        }
        // 更新批发价 只有系统添加才会自动应用批发价
        if (isSys && item.getPriceString() != null) {
            super.updatePiPrice(item, item.getTitle(), item.getGoodsNo(), item.getOuterId());
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
                throw new ItemAddException(ItemAddException.ItemAddExceptionEnum.ITEM_ALREADY_INSTOCK, item
                        .getNumIid());
            }
        }

        ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(item.getShopId());
        if (shiguShop == null) {
            throw new ItemAddException(ItemAddException.ItemAddExceptionEnum.SHOP_DOES_NOT_EXIST, item.getShopId());
        }

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
        if (shiguSiteList.size() > 0) {
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
            throw new ItemModifyException(item.getNumIid() + "_" + item.getShopId() + " 重复插入");
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

        //添加独立sku
        SpringBeanFactory.getBean(ItemSkuModel.class, tiny.getGoodsId()).push(item.getSingleSkus());

        //添加搜索辅表
        GoodsCountForsearch goodsCountForsearch = new GoodsCountForsearch();
        goodsCountForsearch.setGoodsId(tiny.getGoodsId());
        goodsCountForsearch.setWebSite(item.getWebSite());
        goodsCountForsearch.setFabric(item.getFabric());
        goodsCountForsearch.setInfabric(item.getInFabric());
        goodsCountForsearchMapper.insertSelective(goodsCountForsearch);
        ShiguGoodsModified shiguGoodsModified = new ShiguGoodsModified();
        shiguGoodsModified.setItemId(tiny.getGoodsId());
//        if (item.getPriceString() != null &&!item.getPriceString().equals(item.getPiPriceString())) {
//            shiguGoodsModified.setHasSetPrice(1);
//        }
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
        addImgToSearch(tiny.getGoodsId(), tiny.getWebSite(), null, tiny.getPicUrl(), 1);
        return tiny.getGoodsId();
    }

    @Override
    public Long userAddItem(NewPushSynItemBO item) throws ItemModifyException {
        return addItem(item, false);
    }

    @Override
    public int systemUpdateItem(NewPushSynItemBO item) throws ItemModifyException {
        int i = super.systemUpdateItem(item);
        if (i > 0 && item.getSingleSkus() != null) {
            SpringBeanFactory.getBean(ItemSkuModel.class, item.getGoodsId()).push(item.getSingleSkus());
        }
        return i;
    }

    @Override
    public int officeUpdateItem(NewPushSynItemBO item) throws ItemModifyException {
        int i = super.officeUpdateItem(item);
        if (i > 0 && item.getSingleSkus() != null) {
            SpringBeanFactory.getBean(ItemSkuModel.class, item.getGoodsId()).push(item.getSingleSkus());
        }
        return i;
    }

    @Override
    public int userUpdateItem(NewPushSynItemBO item) throws ItemModifyException {
        int i = super.userUpdateItem(item);
        if (i > 0 && item.getSingleSkus() != null) {
            SpringBeanFactory.getBean(ItemSkuModel.class, item.getGoodsId()).push(item.getSingleSkus());
        }
        return i;
    }

    @Override
    public int userUpdateItem(NewPushSynItemBO item, Boolean updatePrice) throws ItemModifyException {
        int i = super.userUpdateItem(item,updatePrice);
        if (i > 0 && item.getSingleSkus() != null) {
            SpringBeanFactory.getBean(ItemSkuModel.class, item.getGoodsId()).push(item.getSingleSkus());
        }
        return i;
    }

    @Override
    public NewPullSynItemVO selItemByGoodsId(Long goodsId, String webSite) {
        SynItem synItem = super.selItemByGoodsId(goodsId, webSite);
        if(synItem!=null){
            NewPullSynItemVO vo=BeanMapper.map(synItem,NewPullSynItemVO.class);
            vo.setSingleSkus(SpringBeanFactory.getBean(ItemSkuModel.class, synItem.getGoodsId()).pull());
        }
        return null;
    }

    @Override
    public NewPullSynItemVO selItemWithSynItem(Long numIid, Long shopId) {
        SynItem synItem = super.selItemWithSynItem(numIid, shopId);
        if(synItem!=null){
            NewPullSynItemVO vo=BeanMapper.map(synItem,NewPullSynItemVO.class);
            vo.setSingleSkus(SpringBeanFactory.getBean(ItemSkuModel.class, synItem.getGoodsId()).pull());
        }
        return null;
    }
}
