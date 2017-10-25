package com.shigu.main4.item.services;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.MultipleExample;
import com.opentae.core.mybatis.example.MultipleExampleBuilder;
import com.opentae.core.mybatis.mapper.MultipleMapper;
import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.GoodsCountForsearchExample;
import com.opentae.data.mall.examples.ShiguGoodsModifiedExample;
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
import com.shigu.main4.item.exceptions.ItemException;
import com.shigu.main4.item.exceptions.ShopsItemException;
import com.shigu.main4.item.services.utils.ElasticCountUtil;
import com.shigu.main4.item.services.utils.FileImgsUtil;
import com.shigu.main4.item.services.utils.OnsaleInstockReader;
import com.shigu.main4.item.services.utils.SelIOItemsUtil;
import com.shigu.main4.item.vo.*;
import com.shigu.main4.tools.OssIO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    private ShowForCdnService showForCdnService;

    @Autowired
    private ShiguMarketMapper shiguMarketMapper;

    @Autowired
    private ElasticCountUtil elasticCountUtil;

    @Autowired
    private MultipleMapper tae_mall_multipleMapper;

    @Autowired
    OssIO ossIO;

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

    /**
     * 获取店内未设置大图、材质、最低零售价统计
     * @param shopId
     * @param webSite
     * @return
     */
    @Override
    public ShopUnprocessItemCount selShopUnprocessItemCount(Long shopId, String webSite) {
        ShopUnprocessItemCount countResult = new ShopUnprocessItemCount();
        StoreGoodsListSearchBO bo = new StoreGoodsListSearchBO();
        countResult.setNoBigPicGoodsNum(tae_mall_multipleMapper.countByMultipleExample(selNoBigPic(shopId, webSite,bo)));
        countResult.setNolowestLsjNum(tae_mall_multipleMapper.countByMultipleExample(selNoLowPrice(shopId, webSite,bo)));
        countResult.setNoConstituentNum(tae_mall_multipleMapper.countByMultipleExample(selNoConstituent(shopId, webSite,bo)));
        return countResult;
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
        MultipleExample goodsExample;
        if (bo.getState() == null) {
            goodsExample = selDefaultGoods(shopId, webSite, bo);
        } else {
            switch (bo.getState()) {
                case 1:
                    goodsExample = selNoLowPrice(shopId, webSite, bo);
                    break;
                case 2:
                    goodsExample = selNoBigPic(shopId, webSite, bo);
                    break;
                case 3:
                    goodsExample = selNoConstituent(shopId, webSite, bo);
                    break;
                default:
                    goodsExample = selDefaultGoods(shopId, webSite, bo);
                    break;
            }
        }
        goodsExample.setWebSite(webSite);
        int totalCount = tae_mall_multipleMapper.countByMultipleExample(goodsExample);
        pager.calPages(totalCount,pageSize);

        goodsExample.setStartIndex((pageNo-1)*pageSize);
        goodsExample.setEndIndex(pageSize);
        List<GoodsInfoVO> goodsInfoVOS = tae_mall_multipleMapper.selectFieldsByMultipleExample(goodsExample, GoodsInfoVO.class);
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
                GoodsAggsVO otherInfo = goodsOtherInfoMap.get(item.getItemId().toString());
                if (otherInfo != null) {
                    //设置材质时必须设置面料为必填项
                    if (StringUtils.isNotBlank(otherInfo.getFabric())) {
                        item.setConstituentType(2);
                    }
                    item.setGoodsUpNum(otherInfo.getGoodsUpNum());
                    item.setSaleCount(otherInfo.getSaleCount());
                    item.setFabric(otherInfo.getFabric());
                    item.setInFabric(otherInfo.getInFabric());
                }
                onsaleItems.add(item);
            });
        }
        return pager;
    }

    /**
     * 出售中的商品，无大图商品
     * 所有参数非空
     * @param shopId
     * @param webSite
     * @param bo
     * @return
     */
    private MultipleExample selNoBigPic(Long shopId, String webSite, StoreGoodsListSearchBO bo) {
        ShiguGoodsTinyExample noBigPicGoodsExample = shopGoodsExample(shopId, webSite,bo);
        GoodsCountForsearchExample goodsCountForsearchExample = new GoodsCountForsearchExample();
        goodsCountForsearchExample.createCriteria().andHadBigzipEqualTo(1);
        return MultipleExampleBuilder.from(noBigPicGoodsExample).innerJoin(goodsCountForsearchExample).on(noBigPicGoodsExample.createCriteria().equalTo(ShiguGoodsTinyExample.goodsId, GoodsCountForsearchExample.goodsId)).build();
    }

    /**
     * 出售中的商品，无最低零售价
     * 所有参数非空
     * @param shopId
     * @param webSite
     * @param bo
     * @return
     */
    private MultipleExample selNoLowPrice(Long shopId, String webSite,StoreGoodsListSearchBO bo) {
        ShiguGoodsTinyExample noLowPriceGoodsExample = shopGoodsExample(shopId, webSite,bo);
        ShiguGoodsModifiedExample shiguGoodsModifiedExample = new ShiguGoodsModifiedExample();
        shiguGoodsModifiedExample.createCriteria().andHasSetPriceEqualTo(1);
        return MultipleExampleBuilder.from(noLowPriceGoodsExample).innerJoin(shiguGoodsModifiedExample).on(noLowPriceGoodsExample.createCriteria().andPriceIsNotNull().equalTo(ShiguGoodsTinyExample.goodsId, ShiguGoodsModifiedExample.itemId)).build();
    }

    /**
     * 出售中的商品，无材料成分
     * 所有参数非空
     * @param shopId
     * @param webSite
     * @param bo
     * @return
     */
    private MultipleExample selNoConstituent(Long shopId, String webSite,StoreGoodsListSearchBO bo) {
        ShiguGoodsTinyExample noConstituentGoodsExample = shopGoodsExample(shopId, webSite,bo);
        GoodsCountForsearchExample goodsCountForsearchExample = new GoodsCountForsearchExample();
        goodsCountForsearchExample.createCriteria().andFabricIsNull();
        return MultipleExampleBuilder.from(noConstituentGoodsExample).innerJoin(goodsCountForsearchExample).on(noConstituentGoodsExample.createCriteria().equalTo(ShiguGoodsTinyExample.goodsId, GoodsCountForsearchExample.goodsId)).build();
    }

    /**
     * 出售中的商品，全部商品
     * 所有参数非空
     * @param shopId
     * @param webSite
     * @param bo
     * @return
     */
    private MultipleExample selDefaultGoods(Long shopId, String webSite,StoreGoodsListSearchBO bo) {
        ShiguGoodsTinyExample example = shopGoodsExample(shopId, webSite, bo);
        return MultipleExampleBuilder.from(example).build();
    }

    /**
     * 档口的goodsTinyExample获取
     * 所有参数非空
     * @param shopId
     * @param webSite
     * @return
     */
    private ShiguGoodsTinyExample shopGoodsExample(Long shopId, String webSite,StoreGoodsListSearchBO bo) {
        ShiguGoodsTinyExample example = new ShiguGoodsTinyExample();
        example.setWebSite(webSite);
        ShiguGoodsTinyExample.Criteria criteria = example.createCriteria().andStoreIdEqualTo(shopId);
        if (StringUtils.isNotBlank(bo.getKeyword())) {
            criteria.andTitleLike('%'+bo.getKeyword()+'%');
        }
        if (StringUtils.isNotBlank(bo.getGoodsNo())) {
            criteria.andTitleLike('%'+bo.getGoodsNo()+'%');
        }
        if (bo.getNumIid() != null) {
            criteria.andNumIidEqualTo(bo.getNumIid());
        }
        return example;
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
    public void setConstituent(Long goodsId, Long shopId, String webSite, String fabricStr, String inFabricStr) throws JsonErrException {
        ShiguGoodsTiny shiguGoodsTiny = new ShiguGoodsTiny();
        shiguGoodsTiny.setWebSite(webSite);
        shiguGoodsTiny.setGoodsId(goodsId);
        shiguGoodsTiny = shiguGoodsTinyMapper.selectByPrimaryKey(shiguGoodsTiny);
        if (shiguGoodsTiny == null || !shopId.equals(shiguGoodsTiny.getStoreId())) {
            throw new JsonErrException("只能操作自己店内的商品");
        }
        GoodsCountForsearch goodsCountForsearch = new GoodsCountForsearch();
        goodsCountForsearch.setGoodsId(shiguGoodsTiny.getGoodsId());
        goodsCountForsearch.setFabric(fabricStr);
        goodsCountForsearch.setInfabric(inFabricStr);
        goodsCountForsearchMapper.updateByPrimaryKeySelective(goodsCountForsearch);
    }
}
