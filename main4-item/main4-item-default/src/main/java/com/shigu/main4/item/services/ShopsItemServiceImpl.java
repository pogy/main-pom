package com.shigu.main4.item.services;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.GoodsCountForsearchExample;
import com.opentae.data.mall.examples.ShiguGoodsSoldoutExample;
import com.opentae.data.mall.examples.ShiguGoodsTinyExample;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.exceptions.JsonErrException;
import com.shigu.main4.common.exceptions.Main4Exception;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.FileUtil;
import com.shigu.main4.item.beans.GoodsInfoVO;
import com.shigu.main4.item.beans.GoodsupLongTerms;
import com.shigu.main4.item.bo.StoreGoodsListSearchBO;
import com.shigu.main4.item.enums.ItemFrom;
import com.shigu.main4.item.enums.ShopCountRedisCacheEnum;
import com.shigu.main4.item.exceptions.ItemException;
import com.shigu.main4.item.exceptions.ShopsItemException;
import com.shigu.main4.item.services.utils.ElasticCountUtil;
import com.shigu.main4.item.services.utils.FileImgsUtil;
import com.shigu.main4.item.services.utils.OnsaleInstockReader;
import com.shigu.main4.item.services.utils.SelIOItemsUtil;
import com.shigu.main4.item.tools.ItemCache;
import com.shigu.main4.item.vo.*;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.tools.RedisIO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by wxc on 2017/3/2.
 * 店内宝贝服务
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@Service("shopsItemService")
public class ShopsItemServiceImpl implements ShopsItemService {

    private static final Logger logger = LoggerFactory.getLogger(ShopsItemServiceImpl.class);

    @Autowired
    private ShiguShopMapper shiguShopMapper;
    @Autowired
    SelIOItemsUtil selIOItems;
    @Autowired
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Autowired
    private ShiguGoodsSoldoutMapper shiguGoodsSoldoutMapper;

    @Autowired
    private GoodsCountForsearchMapper goodsCountForsearchMapper;

    @Autowired
    private ShiguGoodsModifiedMapper shiguGoodsModifiedMapper;

    @Autowired
    private ShowForCdnService showForCdnService;

    @Autowired
    private ShiguMarketMapper shiguMarketMapper;

    @Autowired
    private ShiguStyleMapper shiguStyleMapper;

    @Autowired
    private ElasticCountUtil elasticCountUtil;

    @Autowired
    private ItemCache itemCache;
    @Autowired
    private RedisIO redisIO;

    @Autowired
    OssIO ossIO;

    private static final String SHOP_STYLE_HANDLER_QUEUE_INDEX = "shop_style_handler_queue_";

    /**
     * 查出售中的商品
     *
     * @param keyword  宝贝名称
     * @param goodsNo  货号
     * @param numIid   淘宝ID
     * @param shopId   店铺ID
     * @param pageNo   当前页
     * @param pageSize 每页条数
     * @return 分页查询
     */
    @Override
    public ShiguPager<OnsaleItem> selOnsaleItems(final String keyword, final String goodsNo, final Long numIid, Long shopId, final int pageNo, int pageSize)
            throws ItemException {
        return selIOItems.selIOItems(new OnsaleInstockReader<OnsaleItem>(shopId) {
            @Override
            protected SgExample makeExample(String webSite, int pageNo, int pageSize) {
                ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
                tinyExample.setWebSite(webSite);
                tinyExample.setStartIndex((pageNo - 1) * pageSize);
                tinyExample.setEndIndex(pageSize);
                tinyExample.setOrderByClause("created DESC");

                ShiguGoodsTinyExample.Criteria criteria = tinyExample.createCriteria()
                        .andStoreIdEqualTo(getShopId())
                        .andIsClosedEqualTo(0L);//TODO: 店铺中的 is_closed = 0 ??

                if (StringUtils.isNotEmpty(keyword))
                    criteria.andTitleLike("%" + keyword + "%");
                if (StringUtils.isNotEmpty(goodsNo))
                    criteria.andGoodsNoLike("%" + goodsNo + "%");
                if (numIid != null)
                    criteria.andNumIidEqualTo(numIid);
                return tinyExample;
            }

            @Override
            protected int countByExample(SgExample example) {
                return shiguGoodsTinyMapper.countByExample(example);
            }

            @Override
            protected List<OnsaleItem> selectByExample(SgExample example) {
                List<ShiguGoodsTiny> shiguGoodsTinies = shiguGoodsTinyMapper.selectByConditionList(example);
                GoodsupLongTerms<GoodsAggsVO> countAgg = elasticCountUtil.selItemCountData(shiguGoodsTinies.stream().map(ShiguGoodsTiny::getGoodsId).collect(Collectors.toList()));
                List<OnsaleItem> onsaleItems = new ArrayList<>();
                for (ShiguGoodsTiny tiny : shiguGoodsTinies) {
                    OnsaleItem item = new OnsaleItem();
                    onsaleItems.add(item);
                    if (tiny.getIsExcelImp() != null)
                        item.setItemFrom(ItemFrom.values()[tiny.getIsExcelImp()]);
                    item.setPiPrice(tiny.getPiPriceString());
                    item.setPrice(tiny.getPriceString());
                    item.setTitle(tiny.getTitle());
                    item.setGoodsNo(tiny.getGoodsNo());
                    item.setPicUrl(tiny.getPicUrl());
                    item.setCreated(tiny.getCreated());
                    item.setWebSite(tiny.getWebSite());
                    item.setItemId(tiny.getGoodsId());
                    item.setIsShowCase(tiny.getIsShowcase());
                    item.setGoodsUpNum(0);
                    item.setSaleCount(0);
                    item.setConstituentType(1);
                    GoodsAggsVO goodsAggsVO;
                    if (countAgg != null && ((goodsAggsVO = countAgg.get(item.getItemId().toString())) != null)) {
                        item.setGoodsUpNum(goodsAggsVO.getGoodsUpNum());
                        item.setSaleCount(goodsAggsVO.getSaleCount());
                        item.setFabric(goodsAggsVO.getFabric());
                        item.setInFabric(goodsAggsVO.getInFabric());
                        if (StringUtils.isNotBlank(goodsAggsVO.getFabric())) {
                            item.setConstituentType(2);
                        }
                    }
                }
                return onsaleItems;
            }

            @Override
            protected String selWebSite(Long shopId) throws ItemException {
                return selShopWebSite(shopId);
            }
        }, pageNo, pageSize);
    }

    /**
     * 给修复宝贝提供数据
     *
     * @param keyword
     * @param goodsId
     * @param shopId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public ShiguPager<XiufuItem> selXiufuItem(final String keyword, final Long goodsId, Long shopId, int pageNo, int pageSize) throws ItemException {
        return selIOItems.selIOItems(new OnsaleInstockReader<XiufuItem>(shopId) {
            @Override
            protected SgExample makeExample(String webSite, int pageNo, int pageSize) {
                ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
                tinyExample.setWebSite(webSite);
                tinyExample.setStartIndex((pageNo - 1) * pageSize);
                tinyExample.setEndIndex(pageSize);
                tinyExample.setOrderByClause("created DESC");

                ShiguGoodsTinyExample.Criteria criteria = tinyExample.createCriteria()
                        .andStoreIdEqualTo(getShopId()).andNumIidIsNotNull()
                        .andIsClosedEqualTo(0L);//TODO: 店铺中的 is_closed = 0 ??

                if (StringUtils.isNotEmpty(keyword))
                    criteria.andTitleLike("%" + keyword + "%");
                if (goodsId != null)
                    criteria.andGoodsIdEqualTo(goodsId);
                criteria.andIsExcelImpEqualTo(0);
                return tinyExample;
            }

            @Override
            protected int countByExample(SgExample example) {
                return shiguGoodsTinyMapper.countByExample(example);
            }

            @Override
            protected List<XiufuItem> selectByExample(SgExample example) {
                List<ShiguGoodsTiny> shiguGoodsTinies = shiguGoodsTinyMapper.selectByConditionList(example);
                GoodsupLongTerms<Integer> countAgg = elasticCountUtil.countItemUp(shiguGoodsTinies);

                List<XiufuItem> onsaleItems = new ArrayList<>();
                for (ShiguGoodsTiny tiny : shiguGoodsTinies) {
                    XiufuItem item = new XiufuItem();
                    onsaleItems.add(item);
                    if (tiny.getIsExcelImp() != null)
                        item.setItemFrom(ItemFrom.values()[tiny.getIsExcelImp()]);
                    item.setPiPrice(tiny.getPiPriceString());
                    item.setPrice(tiny.getPriceString());
                    item.setTitle(tiny.getTitle());
                    item.setGoodsNo(tiny.getGoodsNo());
                    item.setPicUrl(tiny.getPicUrl());
                    item.setCreated(tiny.getCreated());
                    item.setWebSite(tiny.getWebSite());
                    item.setItemId(tiny.getGoodsId());
                    item.setIsShowCase(tiny.getIsShowcase());
                    item.setGoodsUpNum(0);
                    if (countAgg != null && countAgg.get(item.getItemId().toString()) != null) {
                        item.setGoodsUpNum(countAgg.get(item.getItemId().toString()));
                    }
                }
                return onsaleItems;
            }

            @Override
            protected String selWebSite(Long shopId) throws ItemException {
                return selShopWebSite(shopId);
            }
        }, pageNo, pageSize);
    }

    /**
     * 查仓库中的商品
     *
     * @param keyword  宝贝名称
     * @param goodsNo  货号
     * @param numIid   淘宝宝贝ID
     * @param shopId   店铺ID
     * @param pageNo   当前页
     * @param pageSize 每页条数
     * @return
     */
    @Override
    public ShiguPager<InstockItem> selInstockItems(final String keyword, final String goodsNo, final Long numIid, Long shopId, int pageNo, int pageSize)
            throws ItemException {
        return selIOItems.selIOItems(new OnsaleInstockReader<InstockItem>(shopId) {
            @Override
            protected SgExample makeExample(String webSite, int pageNo, int pageSize) {
                ShiguGoodsSoldoutExample soldoutExample = new ShiguGoodsSoldoutExample();
                soldoutExample.setWebSite(webSite);
                soldoutExample.setStartIndex((pageNo - 1) * pageSize);
                soldoutExample.setEndIndex(pageSize);
                soldoutExample.setOrderByClause("soldout_time DESC");

                ShiguGoodsSoldoutExample.Criteria criteria = soldoutExample.createCriteria()
                        .andStoreIdEqualTo(getShopId());

                if (StringUtils.isNotEmpty(keyword))
                    criteria.andTitleLike("%" + keyword + "%");
                if (StringUtils.isNotEmpty(goodsNo))
                    criteria.andGoodsNoLike("%" + goodsNo + "%");
                if (numIid != null)
                    criteria.andNumIidEqualTo(numIid);
                return soldoutExample;
            }

            @Override
            protected int countByExample(SgExample example) {
                return shiguGoodsSoldoutMapper.countByExample(example);
            }

            @Override
            protected List<InstockItem> selectByExample(SgExample example) {
                List<ShiguGoodsSoldout> shiguGoodsTinies = shiguGoodsSoldoutMapper.selectByConditionList(example);
                List<InstockItem> instockItems = new ArrayList<>();
                for (ShiguGoodsSoldout soldout : shiguGoodsTinies) {
                    InstockItem item = new InstockItem();
                    instockItems.add(item);
                    if (soldout.getIsExcelImp() != null)
                        item.setItemFrom(ItemFrom.values()[soldout.getIsExcelImp()]);
                    item.setPiPrice(soldout.getPiPriceString());
                    item.setTitle(soldout.getTitle());
                    item.setGoodsNo(soldout.getGoodsNo());
                    item.setPicUrl(soldout.getPicUrl());
                    //实际应该放下架时间
                    item.setCreated(soldout.getSoldoutTime());
                    item.setWebSite(soldout.getWebSite());
                    item.setItemId(soldout.getGoodsId());
                    if (soldout.getIsExcelImp() != null)
                        item.setItemFrom(ItemFrom.values()[soldout.getIsExcelImp()]);
                }
                return instockItems;
            }

            @Override
            protected String selWebSite(Long shopId) throws ItemException {
                return selShopWebSite(shopId);
            }
        }, pageNo, pageSize);
    }


    /**
     * 店内商品统计
     *
     * @param shopId 店铺ID
     * @return 统计结果
     */
    @Override
    public ItemCount selItemCount(Long shopId) throws ItemException {
        String webSite = selShopWebSite(shopId);
        ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
        tinyExample.setWebSite(webSite);
        ShiguGoodsTinyExample.Criteria criteria = tinyExample.createCriteria().andStoreIdEqualTo(shopId).andIsClosedEqualTo(0L);
        int onsaleNum = shiguGoodsTinyMapper.countByExample(tinyExample);
        criteria.andIsShowcaseEqualTo(1);
        int showcaseNum = shiguGoodsTinyMapper.countByExample(tinyExample);
        ShiguGoodsSoldoutExample soldoutExample = new ShiguGoodsSoldoutExample();
        soldoutExample.setWebSite(webSite);
        soldoutExample.createCriteria().andStoreIdEqualTo(shopId);
        int instockNum = shiguGoodsSoldoutMapper.countByExample(soldoutExample);
        ItemCount count = new ItemCount();
        count.setInstock(instockNum);
        count.setOnsale(onsaleNum);
        count.setShowcase(showcaseNum);

        return count;
    }

    /**
     * 根据店铺ID查询分站
     *
     * @param shopId 店铺ID
     * @return 分站
     * @throws ItemException 店铺不存在
     */
    protected String selShopWebSite(Long shopId) throws ItemException {
        ShiguShop shiguShop;
        if (shopId == null || (shiguShop = shiguShopMapper.selectFieldsByPrimaryKey(shopId, FieldUtil.codeFields("shop_id,web_site"))) == null)
            throw new ShopsItemException(ShopsItemException.ShopsItemExceptionEnum.SHOP_DOES_NOT_EXIST);
        return shiguShop.getWebSite();
    }

    /**
     * 图片压缩包
     *
     * @param goodsId
     * @return
     */
    @Override
    public String itemImgzipUrl(Long goodsId) {

        CdnItem cdnItem = showForCdnService.selItemById(goodsId);
        if (cdnItem == null) {
            return null;
        }

        String tmpdirPath = System.getProperty("java.io.tmpdir");
        if (StringUtils.isEmpty(tmpdirPath)) {
            return null;
        }

        ShiguShop shiguShop = shiguShopMapper.selectByPrimaryKey(cdnItem.getShopId());
        ShiguMarket shiguMarket = shiguMarketMapper.selectByPrimaryKey(shiguShop.getMarketId());

        String yearMm = DateUtil.dateToString(new Date(), "yyyyMM");

        if (StringUtils.isEmpty(cdnItem.getHuohao())) {
            cdnItem.setHuohao("");
        }

        String fileFolder = shiguMarket.getMarketName() + "-" + shiguShop.getShopNum() + "-" + cdnItem.getHuohao() + "-P"
                + Double.valueOf(cdnItem.getPiPrice()).intValue() + "-" + goodsId;

        String savePath = tmpdirPath + "/" + yearMm + "/" + fileFolder;

        String filePath = "imgzip/" + fileFolder + ".zip";

        if (ossIO.fileExist(filePath)) {
            return ossIO.getDomain() + filePath;
        }

        File file = new File(savePath);
        if (!file.exists()) {
            file.mkdirs();
        }

        // 商品详情图
        String goodsDesc = cdnItem.getDescription();
        FileImgsUtil.addDescpic(savePath + "/详情图/", goodsDesc);

        // 商品主图
        List<String> mainImgsUrlList = cdnItem.getImgUrl();
        for (int i = 0; i < mainImgsUrlList.size(); i++) {
            FileImgsUtil.addpic(savePath + "/主图/", mainImgsUrlList.get(i), String.valueOf(i + 1));
        }

        // 商品属性图
        List<SaleProp> salePropList = cdnItem.getColors();
        for (int j = 0; j < salePropList.size(); j++) {
            SaleProp saleProp = salePropList.get(j);
            if (saleProp != null && !StringUtils.isEmpty(saleProp.getImgUrl())) {
                FileImgsUtil.addpic(savePath + "/属性图/", saleProp.getImgUrl(), saleProp.getValue());
            }
        }

        // 打包成zip
        try {
            String zipUrl = tmpdirPath + "/" + yearMm + "/" + fileFolder + ".zip";
            FileImgsUtil.zip(savePath + "/", zipUrl);
            File zipFile = new File(zipUrl);
            String uploadurl = ossIO.uploadFile(zipFile, filePath);
            // 删除文件夹
            FileUtil.deleteDir(file);
            zipFile.delete();
            return uploadurl;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ShiguPager<OnsaleItem> selOnsaleItems(Long shopId, String webSite, StoreGoodsListSearchBO bo, int pageNo, int pageSize) throws Main4Exception {
        if (shopId == null || webSite == null) {
            throw new Main4Exception("只有档口可以查看店铺出售中的商品");
        }
        if (bo == null) {
            bo = new StoreGoodsListSearchBO();
        }
        ShiguPager<OnsaleItem> pager = new ShiguPager<>();
        pager.setNumber(pageNo);
        int totalCount = shiguGoodsTinyMapper.countOnsaleGoods(shopId, webSite, bo);
        pager.calPages(totalCount,pageSize);
        List<GoodsInfoVO> goodsInfoVOS = shiguGoodsTinyMapper.selOnsaleGoodsInfo(shopId, webSite, bo, (pageNo-1)*pageSize,pageSize);
        List<OnsaleItem> onsaleItems = new ArrayList<>(goodsInfoVOS.size());
        pager.setContent(onsaleItems);
        if (goodsInfoVOS.size()>0) {
            List<Long> goodsIds = goodsInfoVOS.stream().map(GoodsInfoVO::getItemId).collect(Collectors.toList());
            GoodsupLongTerms<GoodsAggsVO> goodsOtherInfoMap = elasticCountUtil.selItemCountData(goodsIds);
            goodsInfoVOS.forEach(o->{
                OnsaleItem item = BeanMapper.map(o, OnsaleItem.class);
                if (o.getIsExcelImp() != null) {
                    item.setItemFrom(ItemFrom.values()[o.getIsExcelImp()]);
                }
                //一些其他表获取的信息的默认值
                item.setGoodsUpNum(0);
                item.setSaleCount(0);
                item.setConstituentType(1);
                item.setHasRetailPriceSet(false);
                GoodsAggsVO otherInfo = goodsOtherInfoMap.get(item.getItemId().toString());
                if (otherInfo != null) {
                    //设置材质时必须设置面料为必填项
                    item.setGoodsUpNum(otherInfo.getGoodsUpNum());
                    item.setSaleCount(otherInfo.getSaleCount());
                    if(!StringUtils.isBlank(otherInfo.getFabric())){
                        item.setConstituentType(2);
                    }
                    item.setFabric(otherInfo.getFabric());
                    item.setInFabric(otherInfo.getInFabric());
                    item.setGoodsVideoUrl(otherInfo.getVideoUrl());
                    item.setHasRetailPriceSet(otherInfo.getHasRetailPriceSet()!=null&&otherInfo.getHasRetailPriceSet()==1);
                    item.setStyleId(otherInfo.getStyleId());
                    // TODO: 18-1-23 兼容旧版，等新版风格上线后去掉goodsStyleId
                    item.setGoodsStyleId(otherInfo.getGoodsStyleId());
                    item.setGoodsStyleName(otherInfo.getGoodsStyleName());
                }
                onsaleItems.add(item);
            });
        }
        return pager;
    }

    /**
     * 更新材质信息
     * @param goodsId
     * @param shopId
     * @param webSite
     * @param fabricStr
     * @param inFabricStr
     * @throws JsonErrException
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void setConstituent(Long goodsId, Long shopId,Boolean isChecked, String webSite, String fabricStr, String inFabricStr) throws JsonErrException {
//        ShiguGoodsTiny shiguGoodsTiny = new ShiguGoodsTiny();
//        shiguGoodsTiny.setWebSite(webSite);
//        shiguGoodsTiny.setGoodsId(goodsId);
//        shiguGoodsTiny = shiguGoodsTinyMapper.selectByPrimaryKey(shiguGoodsTiny);
//        if (shiguGoodsTiny == null || !shopId.equals(shiguGoodsTiny.getStoreId())) {
//            throw new JsonErrException("只能操作自己店内的商品");
//        }
//        GoodsCountForsearch goodsCountForsearch = new GoodsCountForsearch();
//        goodsCountForsearch.setGoodsId(shiguGoodsTiny.getGoodsId());
//        GoodsCountForsearch searchResult = goodsCountForsearchMapper.selectOne(goodsCountForsearch);
//        if (searchResult != null) {
//            goodsCountForsearch = searchResult;
//        }
//        goodsCountForsearch.setFabric(fabricStr);
//        goodsCountForsearch.setInfabric(inFabricStr);
//        if (searchResult == null) {
//            goodsCountForsearchMapper.insertSelective(goodsCountForsearch);
//        } else {
//            goodsCountForsearchMapper.updateByPrimaryKeySelective(goodsCountForsearch);
//        }
//        itemCache.cleanItemCache(goodsId);

        ShiguGoodsTiny shiguGoodsTiny = new ShiguGoodsTiny();
        shiguGoodsTiny.setWebSite(webSite);
        shiguGoodsTiny.setGoodsId(goodsId);
        shiguGoodsTiny = shiguGoodsTinyMapper.selectByPrimaryKey(shiguGoodsTiny);
        if (shiguGoodsTiny == null || !shopId.equals(shiguGoodsTiny.getStoreId())) {
            throw new JsonErrException("只能操作自己店内的商品");
        }
        if (shiguGoodsTiny.getGoodsNo() == null || shiguGoodsTiny.getGoodsNo() == ""){
            isChecked = false;
        }
        if (isChecked){
            ShiguGoodsTinyExample shiguGoodsTinyExample = new ShiguGoodsTinyExample();
            shiguGoodsTinyExample.setWebSite(webSite);
            shiguGoodsTinyExample.createCriteria().andGoodsNoEqualTo(shiguGoodsTiny.getGoodsNo()).andStoreIdEqualTo(shopId);
            List<ShiguGoodsTiny> shiguGoodsTinyList = shiguGoodsTinyMapper.selectByExample(shiguGoodsTinyExample);
            if (shiguGoodsTinyList.size() >0){
                for (int i = 0; i < shiguGoodsTinyList.size(); i++) {
                    GoodsCountForsearch goodsCountForsearch = new GoodsCountForsearch();
                    goodsCountForsearch.setGoodsId(shiguGoodsTinyList.get(i).getGoodsId());
                    GoodsCountForsearch searchResult = goodsCountForsearchMapper.selectOne(goodsCountForsearch);
                    if (searchResult != null) {
                        goodsCountForsearch = searchResult;
                    }
                    goodsCountForsearch.setFabric(fabricStr);
                    goodsCountForsearch.setInfabric(inFabricStr);
                    if (searchResult == null) {
                        goodsCountForsearchMapper.insertSelective(goodsCountForsearch);
                    } else {
                        goodsCountForsearchMapper.updateByPrimaryKeySelective(goodsCountForsearch);
                    }
                    itemCache.cleanItemCache(shiguGoodsTinyList.get(i).getGoodsId());
                }
            }
        }else {
            GoodsCountForsearch goodsCountForsearch = new GoodsCountForsearch();
            goodsCountForsearch.setGoodsId(shiguGoodsTiny.getGoodsId());
            GoodsCountForsearch searchResult = goodsCountForsearchMapper.selectOne(goodsCountForsearch);
            if (searchResult != null) {
                goodsCountForsearch = searchResult;
            }
            goodsCountForsearch.setFabric(fabricStr);
            goodsCountForsearch.setInfabric(inFabricStr);
            if (searchResult == null) {
                goodsCountForsearchMapper.insertSelective(goodsCountForsearch);
            } else {
                goodsCountForsearchMapper.updateByPrimaryKeySelective(goodsCountForsearch);
            }
            itemCache.cleanItemCache(goodsId);
        }
    }

    /**
     * 获取出售中商品部分统计数据
     * @return
     */
    public int countOnsaleGoodsAggrNum(Long shopId,String webSite,ShopCountRedisCacheEnum aggrType){
        String cacheIndex = String.format("%s%d", aggrType.cacheName, shopId);
        Integer aggrNum = redisIO.get(cacheIndex, Integer.class);
        if (aggrNum != null) {
            return aggrNum;
        }
        StoreGoodsListSearchBO bo = new StoreGoodsListSearchBO();
        bo.setState(aggrType.state);
        aggrNum = shiguGoodsTinyMapper.countOnsaleGoods(shopId,webSite,bo);
        return aggrNum;
    }
    @Override
    public void clearShopCountCache(Long shopId, ShopCountRedisCacheEnum type) {
        String cacheIndex = String.format("%s%d", type.cacheName, shopId);
        redisIO.del(cacheIndex);
    }

    @Override
    public boolean checkHasLowestLiPriceSet(Long goodsId) throws Main4Exception {
        if (goodsId == null) {
            throw new Main4Exception("商品不存在");
        }
        ShiguGoodsModified hasModified = new ShiguGoodsModified();
        hasModified.setItemId(goodsId);
        //修改过零售价
        hasModified.setHasSetPrice(1);
        return shiguGoodsModifiedMapper.selectOne(hasModified)!=null;
    }

    @Override
    public void setGoodsVideo(Long shopId, String webSite, Long goodsId, String goodsVideoUrl, boolean linkSameGoodsNo) throws JsonErrException {
        ShiguGoodsTiny tiny = new ShiguGoodsTiny();
        tiny.setGoodsId(goodsId);
        tiny.setWebSite(webSite);
        tiny.setStoreId(shopId);
        tiny = shiguGoodsTinyMapper.selectByPrimaryKey(tiny);
        List<Long> goodsIds = new ArrayList<>();
        if (tiny != null) {
            if (!tiny.getStoreId().equals(shopId)) {
                throw new JsonErrException("只能操作本店铺商品");
            }
            if (linkSameGoodsNo && StringUtils.isNotBlank(tiny.getGoodsNo())) {
                ShiguGoodsTinyExample example = new ShiguGoodsTinyExample();
                example.createCriteria().andStoreIdEqualTo(shopId).andGoodsNoEqualTo(tiny.getGoodsNo());
                example.setWebSite(webSite);
                goodsIds.addAll(shiguGoodsTinyMapper.selectByExample(example).stream().map(ShiguGoodsTiny::getGoodsId).collect(Collectors.toList()));
            } else {
                goodsIds.add(goodsId);
            }
        }
        GoodsCountForsearch goodsCountForsearch = new GoodsCountForsearch();
        goodsCountForsearch.setVideoUrl(goodsVideoUrl);
        goodsCountForsearch.setHadVideo(1);
        GoodsCountForsearchExample example = new GoodsCountForsearchExample();
        example.createCriteria().andGoodsIdIn(goodsIds);
        goodsCountForsearchMapper.updateByExampleSelective(goodsCountForsearch,example);
        List<Long> existedGoodsIds = goodsCountForsearchMapper.selectByExample(example).stream().map(GoodsCountForsearch::getGoodsId).collect(Collectors.toList());
        goodsIds.removeAll(existedGoodsIds);
        if (goodsIds.size()>0) {
            goodsCountForsearch.setWebSite(webSite);
            goodsCountForsearch.setClick(0L);
            goodsCountForsearch.setClickIp(0L);
            goodsCountForsearch.setTrade(0L);
            goodsCountForsearch.setUp(0L);
            goodsCountForsearch.setUpMan(0L);
            goodsCountForsearch.setHadGoat(0);
            goodsCountForsearch.setHadBigzip(0);
            List<GoodsCountForsearch> insertSearch = new ArrayList<>(goodsIds.size());
            for (Long id : goodsIds) {
                GoodsCountForsearch copy = BeanMapper.map(goodsCountForsearch,GoodsCountForsearch.class);
                copy.setGoodsId(id);
                insertSearch.add(copy);
            }
            goodsCountForsearchMapper.insertListNoId(insertSearch);
        }
        itemCache.cleanItemCache(goodsId);
    }

    @Override
    public String setGoodsStyle(Set<Long> goodsIds, Long styleId, String webSite) {
        if (0 == goodsIds.size()) {
            return "没有要更改风格的商品";
        }
        if (StringUtils.isBlank(webSite)) {
            return "没有站点信息";
        }
        List<Long> ids = new ArrayList<>(goodsIds);
        GoodsCountForsearchExample example = new GoodsCountForsearchExample();
        example.createCriteria().andGoodsIdIn(ids);
        List<Long> countGoodsIds = goodsCountForsearchMapper.selectByExample(example).stream().map(GoodsCountForsearch::getGoodsId).collect(Collectors.toList());
        if (countGoodsIds.size() < goodsIds.size()) {
            ids.removeAll(countGoodsIds);
            List<GoodsCountForsearch> insertList = new ArrayList<>();
            for (Long id : ids) {
                GoodsCountForsearch val = new GoodsCountForsearch();
                val.setGoodsId(id);
                val.setWebSite(webSite);
                val.setClick(0L);
                val.setClickIp(0L);
                val.setUp(0L);
                val.setUpMan(0L);
                val.setTrade(0L);
                val.setHadGoat(0);
                insertList.add(val);
            }
            goodsCountForsearchMapper.insertListNoId(insertList);
        }
        ShiguStyle shiguStyle = shiguStyleMapper.selectByPrimaryKey(styleId);
        if (shiguStyle == null) {
            return "不存在的风格";
        }
        //只能设置子级风格
        if (!Objects.equals(0,shiguStyle.getIsParent())) {
            return "只能设置具体风格";
        }
        GoodsCountForsearch updateVal = new GoodsCountForsearch();
        updateVal.setStyleId(styleId);
        updateVal.setStyleSearchScore(0L);
        updateVal.setStyleSearchScoreAdded(0L);
        updateVal.setParentStyleId(shiguStyle.getParentStyleId());
        updateVal.setStyleName(shiguStyle.getStyleName());
        GoodsCountForsearchExample updateExample = new GoodsCountForsearchExample();
        updateExample.createCriteria().andGoodsIdIn(new ArrayList<>(goodsIds)).andStyleIdIsNull().or().andGoodsIdIn(new ArrayList<>(goodsIds)).andStyleIdNotEqualTo(styleId);
        goodsCountForsearchMapper.updateByExampleSelective(updateVal,updateExample);
        return "success";
    }

    @Override
    public void delGoodsStyle(Long goodsId, Long shopId) {
        if (goodsId == null || shopId == null) {
            return;
        }
        CdnItem cdnItem = showForCdnService.selItemById(goodsId);
        if (cdnItem == null) {
            return;
        }
        if (!shopId.equals(cdnItem.getShopId())) {
            return;
        }
        GoodsCountForsearch goodsCountForsearch = new GoodsCountForsearch();
        goodsCountForsearch.setGoodsId(goodsId);
        goodsCountForsearch = goodsCountForsearchMapper.selectOne(goodsCountForsearch);
        if (goodsCountForsearch == null) {
            return;
        }
        goodsCountForsearch.setStyleId(null);
        goodsCountForsearch.setParentStyleId(null);
        //风格搜索分在风格设置时清空
        goodsCountForsearchMapper.updateByPrimaryKey(goodsCountForsearch);
    }
}
