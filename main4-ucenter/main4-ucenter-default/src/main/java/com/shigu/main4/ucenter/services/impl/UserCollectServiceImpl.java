package com.shigu.main4.ucenter.services.impl;

import com.google.common.collect.Lists;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.*;
import com.opentae.data.mall.interfaces.*;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.BeanMapper;
import com.shigu.main4.common.tools.StringUtil;
import com.shigu.main4.common.util.FileUtil;
import com.shigu.main4.common.util.TypeConvert;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.ucenter.exceptions.ItemCollectionException;
import com.shigu.main4.ucenter.exceptions.ShopCollectionException;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.main4.ucenter.util.DataPackageUtil;
import com.shigu.main4.ucenter.util.FileOperator;
import com.shigu.main4.ucenter.util.FilePathConstant;
import com.shigu.main4.ucenter.util.UtilCharacter;
import com.shigu.main4.ucenter.vo.*;
import com.shigu.main4.ucenter.vo.DataPackage;
import com.shigu.main4.ucenter.vo.ItemCollect;
import com.shigu.main4.ucenter.vo.PackageItem;
import com.shigu.main4.ucenter.vo.ShopCollect;
import com.shigu.main4.ucenter.webvo.*;
import com.shigu.main4.ucenter.webvo.ItemCollectVO;
import com.shigu.main4.ucenter.webvo.NewGoodsCollectVO;
import com.shigu.main4.ucenter.webvo.ShopCollectVO;
import com.shigu.main4.ucenter.webvo.ShopInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wxc on 2017/2/25.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@Service("userCollectService")
public class UserCollectServiceImpl implements UserCollectService {

    private static final Logger logger = LoggerFactory.getLogger(UserCollectServiceImpl.class);

    @Resource(name = "tae_mall_shiguGoodsCollectMapper")
    private ShiguGoodsCollectMapper shiguGoodsCollectMapper;

    @Resource(name = "tae_mall_shiguGoodsTinyMapper")
    private ShiguGoodsTinyMapper shiguGoodsTinyMapper;

    @Resource(name = "tae_mall_shiguGoodsExtendsMapper")
    private ShiguGoodsExtendsMapper shiguGoodsExtendsMapper;

    @Resource(name = "tae_mall_taobaoSkuMapper")
    private TaobaoSkuMapper taobaoSkuMapper;

    @Resource(name = "tae_mall_shiguGoodsDataPackageMapper")
    private ShiguGoodsDataPackageMapper shiguGoodsDataPackageMapper;

    @Resource(name = "tae_mall_shiguGoodsIdGeneratorMapper")
    private ShiguGoodsIdGeneratorMapper shiguGoodsIdGeneratorMapper;

    @Resource(name = "tae_mall_shiguGoodsSoldoutMapper")
    private ShiguGoodsSoldoutMapper shiguGoodsSoldoutMapper;

    @Autowired
    private ShiguStoreCollectMapper shiguStoreCollectMapper;

    @Autowired
    private ShiguShopMapper shiguShopMapper;

    @Autowired
    private ShiguMarketMapper shiguMarketMapper;

    @Autowired
    OssIO ossIO;

    /**
     * 查询本店收藏的宝贝
     *
     * @param userId   用户ID
     * @param webSite  分站标识
     * @param pageNo   当前页码
     * @param pageSize 每页条数
     * @return
     */
    @Override
    public ShiguPager<ItemCollectVO> selItemCollections(Long userId, String keyword, String webSite, int pageNo, int pageSize) {
        ShiguPager<ItemCollectVO> pager = new ShiguPager<>();
        if (pageNo < 1)
            pageNo = 1;
        if (pageSize < 1)
            pageSize = 10;
        if (StringUtils.isEmpty(webSite))
            webSite = "hz";
        pager.setNumber(pageNo);

        if (userId == null)
            return pager;

        int count = shiguGoodsCollectMapper.countTinyGoodsCollect(userId, keyword, webSite);
        pager.calPages(count, pageSize);
        if (count > 0) {
            List<TinyItemCollect> shiguGoodsCollects
                    = shiguGoodsCollectMapper.tinyGoodsCollect(
                    userId, keyword, webSite, (pageNo - 1) * pageSize, pageSize);
            pager.setContent(BeanMapper.mapList(shiguGoodsCollects, ItemCollectVO.class));
        }
        return pager;
    }

    @Override
    public ShiguPager<NewGoodsCollectVO> selItemCollectionsByType(Long userId, String keyword, String webSite, int pageNo, int pageSize, int type) {
        ShiguPager<NewGoodsCollectVO> pager = new ShiguPager<>();
        if (pageNo < 1)
            pageNo = 1;
        if (pageSize < 1)
            pageSize = 10;
        if (StringUtils.isEmpty(webSite))
            webSite = "hz";
        pager.setNumber(pageNo);

        if (userId == null)
            return pager;
        List<NewGoodsCollectVO> context = new ArrayList<>(pageSize);
        pager.setContent(context);
        ShiguGoodsCollectExample shiguGoodsCollectExample = new ShiguGoodsCollectExample();
        shiguGoodsCollectExample.createCriteria().andUserIdEqualTo(userId).andWebsiteEqualTo(webSite).andTypeEqualTo(type);
        if (StringUtils.isNotBlank(keyword)) {
            //新收藏，存收藏时title
            shiguGoodsCollectExample.createCriteria().andRemark1Like(keyword);
        }
        int count = shiguGoodsCollectMapper.countByExample(shiguGoodsCollectExample);
        pager.calPages(count, pageSize);
        if (count > 0) {
            shiguGoodsCollectExample.setStartIndex((pageNo - 1) * pageSize);
            shiguGoodsCollectExample.setEndIndex(pageSize);
            List<ShiguGoodsCollect> shiguGoodsCollects = shiguGoodsCollectMapper.selectByConditionList(shiguGoodsCollectExample);
            List<Long> goodsIds = new ArrayList<>(shiguGoodsCollects.size());
            List<Long> shopIds = new ArrayList<>(shiguGoodsCollects.size());
            for (ShiguGoodsCollect shiguGoodsCollect : shiguGoodsCollects) {
                goodsIds.add(shiguGoodsCollect.getGoodsId());
                shopIds.add(shiguGoodsCollect.getStoreId());
            }
            Map<Long, CollectSimpleGoodsInfo> goodsIdInfoMap = BeanMapper.list2Map(selSimpleCollectGoodsInfoList(goodsIds, webSite), "goodsId", Long.class);
            if (shopIds.size()>0) {
                Map<Long, ShopInfo> shopIdInfoMap = BeanMapper.list2Map(selShopInfoByShopIds(shopIds), "shopId", Long.class);
                for (ShiguGoodsCollect shiguGoodsCollect : shiguGoodsCollects) {
                    NewGoodsCollectVO newGoodsCollectVO = new NewGoodsCollectVO();
                    newGoodsCollectVO.setCollId(shiguGoodsCollect.getGoodsCollectId());
                    newGoodsCollectVO.setGoodsId(shiguGoodsCollect.getGoodsId());
                    try {
                        CollectSimpleGoodsInfo goodsInfo = goodsIdInfoMap.get(shiguGoodsCollect.getGoodsId());
                        newGoodsCollectVO.setGoodsNo(goodsInfo.getGoodsNo());
                        newGoodsCollectVO.setTitle(goodsInfo.getTitle());
                        newGoodsCollectVO.setImgSrc(goodsInfo.getPicUrl());
                        newGoodsCollectVO.setPiprice(goodsInfo.getPiPriceString());
                        newGoodsCollectVO.setOnSaleIs(goodsInfo.getOnSaleIs());
                    } catch (Exception e) {
                        newGoodsCollectVO.setGoodsNo("此商品已被删除");
                    }
                    ShopInfo shopInfo = shopIdInfoMap.get(shiguGoodsCollect.getStoreId());
                    newGoodsCollectVO.setShopId(shiguGoodsCollect.getStoreId());
                    newGoodsCollectVO.setMarketName(shopInfo.getMarketName());
                    newGoodsCollectVO.setShopNum(shopInfo.getShopNum());
                    newGoodsCollectVO.setImQq(shopInfo.getImQq());
                    newGoodsCollectVO.setImWw(shopInfo.getImWw());
                    context.add(newGoodsCollectVO);
                }
            }
        }
        return pager;
    }

    private List<CollectSimpleGoodsInfo> selSimpleCollectGoodsInfoList(List<Long> goodsIds, String webSite) {
        List<CollectSimpleGoodsInfo> simpleGoodsInfos = Lists.newArrayList();
        ShiguGoodsTinyExample tinyExample = new ShiguGoodsTinyExample();
        tinyExample.setWebSite(webSite);
        tinyExample.createCriteria().andGoodsIdIn(goodsIds);
        for (ShiguGoodsTiny tiny : shiguGoodsTinyMapper.selectByExample(tinyExample)) {
            CollectSimpleGoodsInfo goodsInfo = BeanMapper.map(tiny, CollectSimpleGoodsInfo.class);
            goodsInfo.setOnSaleIs(true);
            simpleGoodsInfos.add(goodsInfo);
        }
        if (goodsIds.size() > simpleGoodsInfos.size()) {
            ShiguGoodsSoldoutExample shiguGoodsSoldoutExample = new ShiguGoodsSoldoutExample();
            shiguGoodsSoldoutExample.setWebSite(webSite);
            shiguGoodsSoldoutExample.createCriteria().andGoodsIdIn(goodsIds);
            for (ShiguGoodsSoldout soldout : shiguGoodsSoldoutMapper.selectByExample(shiguGoodsSoldoutExample)) {
                CollectSimpleGoodsInfo goodsInfo = BeanMapper.map(soldout, CollectSimpleGoodsInfo.class);
                goodsInfo.setOnSaleIs(false);
                simpleGoodsInfos.add(goodsInfo);
            }
        }
        return simpleGoodsInfos;
    }

    /**
     * 查询本收藏该宝贝信息
     * @param userId 用户ID
     * @param goodsId 商品ID
     * @param webSite 分站标识
     * @return
     */
    public ItemCollectInfoVO selItemCollectionInfo(Long userId, Long goodsId, String webSite) {
        if (userId == null || goodsId == null) {
            if(logger.isErrorEnabled()){
                logger.error("查询店铺收藏的宝贝信息失败: [userId="+userId+" , goodsId="+goodsId+" , webSite="+webSite+"]");
            }
        }
        ShiguGoodsCollect shiguGoodsCollect = new ShiguGoodsCollect();
        shiguGoodsCollect.setUserId(userId);
        shiguGoodsCollect.setGoodsId(goodsId);
        if(!StringUtil.isNull(webSite)){
            shiguGoodsCollect.setWebsite(webSite);
        }
        shiguGoodsCollect =  shiguGoodsCollectMapper.selectOne(shiguGoodsCollect);
        if ( shiguGoodsCollect == null) {
            return null;
        }
        return BeanMapper.map(shiguGoodsCollect,ItemCollectInfoVO.class);
    }

    /**
     * 按条件查询收藏商品
     * @param userId
     * @param goodsId
     * @param useStatus
     * @param storeId
     * @param webSite
     * @return
     */
    public List<ItemCollectInfoVO> selItemCollection(Long userId, Long goodsId, Integer useStatus, Long storeId, String webSite) {
        ShiguGoodsCollectExample collectExample = new ShiguGoodsCollectExample();
        ShiguGoodsCollectExample.Criteria criteria = collectExample.createCriteria();
        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if (goodsId != null) {
            criteria.andGoodsIdEqualTo(goodsId);
        }
        if (useStatus != null) {
            criteria.andUseStatusEqualTo(useStatus);
        }
        if (storeId != null) {
            criteria.andStoreIdEqualTo(storeId);
        }
        if (!StringUtil.isNull(webSite)) {
            criteria.andWebsiteEqualTo(webSite);
        }
        List<ShiguGoodsCollect> shiguGoodsCollects = shiguGoodsCollectMapper.selectByExample(collectExample);
        if (shiguGoodsCollects == null || shiguGoodsCollects.isEmpty())return null;
        return BeanMapper.mapList(shiguGoodsCollects,ItemCollectInfoVO.class);
    }

    /**
     * 按主键批量删除收藏记录
     *
     * @param userId     用户IDs
     * @param collectIds 主键
     */
    @Override
    public void delItemCollection(Long userId, List<Long> collectIds) {
        if (userId == null || collectIds == null || collectIds.isEmpty())
            return;
        ShiguGoodsCollectExample collectExample = new ShiguGoodsCollectExample();
        collectExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andGoodsCollectIdIn(collectIds);
        shiguGoodsCollectMapper.deleteByExample(collectExample);
    }

    /**
     * 添加商品收藏
     *
     * @param collect 收藏
     */
    @Override
    public void addItemCollection(ItemCollect collect) throws ItemCollectionException {
        if (collect == null || collect.getUserId() == null || collect.getItemId() == null || collect.getStoreId() == null) {
            throw new ItemCollectionException(ItemCollectionException.ItemCollecExcpEnum.IllegalArgumentException);
        }
        ShiguGoodsCollectExample collectExample = new ShiguGoodsCollectExample();
        collectExample.createCriteria().andGoodsIdEqualTo(collect.getItemId())
                .andUserIdEqualTo(collect.getUserId());
        List<ShiguGoodsCollect> shiguGoodsCollects = shiguGoodsCollectMapper.selectByExample(collectExample);
        if (shiguGoodsCollects.isEmpty()) {
            ShiguGoodsCollect goodsCollect = BeanMapper.map(collect, ShiguGoodsCollect.class);
            goodsCollect.setGoodsId(collect.getItemId());
            goodsCollect.setRemark1(collect.getTitle());
            goodsCollect.setType(collect.getType());
            shiguGoodsCollectMapper.insertSelective(goodsCollect);
        } else
            throw new ItemCollectionException(ItemCollectionException.ItemCollecExcpEnum.CollectionAlreadyExist);
    }

    /**
     * 单个数据包str组成
     *
     * @param userId
     * @param itemId
     * @param dataPackageAddr
     * @param relativePath
     * @param relativePath1
     * @return
     */
    public Map<String, String> createDataPackagestr(Long userId, Long itemId, String dataPackageAddr, String relativePath, String relativePath1) {
        ShiguGoodsIdGenerator shiguGoodsIdGenerator = new ShiguGoodsIdGenerator();
        shiguGoodsIdGenerator.setGoodId(itemId);
        shiguGoodsIdGenerator = shiguGoodsIdGeneratorMapper.selectOne(shiguGoodsIdGenerator);
        if (shiguGoodsIdGenerator == null) {
            return null;
        }
        ShiguGoodsTiny goods = new ShiguGoodsTiny();
        goods.setGoodsId(itemId);
        goods.setWebSite(shiguGoodsIdGenerator.getWebSite());
        goods = shiguGoodsTinyMapper.selectByPrimaryKey(goods);
        ShiguGoodsExtends sge = new ShiguGoodsExtends();
        sge.setGoodsId(itemId);
        sge.setWebSite(shiguGoodsIdGenerator.getWebSite());
        sge = shiguGoodsExtendsMapper.selectByPrimaryKey(sge);
        if (goods == null) {
            return null;
        }
        Long shopId = goods.getStoreId();


        String xinpin = "1";
        if ("false".equals(goods.getIsXinpin())) {
            xinpin = "3";
        }
        String item_type = "1";//出售方式
        String auction_increment = "0";//加价幅度
        String valid_thru = "7";//有效期
        String freight_payer = "2";//运费承担

        String has_invoice = "1"; //发票
        if ("false".equals(sge.getHasInvoice())) {
            has_invoice = "0";
        }
        String has_warranty = "1";//保修
        if ("false".equals(sge.getHasWarranty())) {
            has_warranty = "0";
        }
        String approve_status = "1";//放入仓库
        if ("instock".equals(sge.getApproveStatus())) {
            approve_status = "0";
        }
        String has_showcase = "1";//橱窗推荐
        if ("false".equals(goods.getHasShowcase())) {
            has_showcase = "0";
        }
        String postage_id = "0";//邮费模版ID
        String has_discount = "1";//会员打折
        if ("false".equals(goods.getHasDiscount())) {
            has_discount = "0";
        }

        String modified = "";//修改时间
        String upload_fail_msg = "";//上传状态
        String picture_status = "";//图片状态
        String auction_point = "0";//返点比例
        String goodsdesc = sge.getGoodsDesc();//
        goodsdesc = goodsdesc.replaceAll("\"", "'").replace("\n", "");


        //多图
        String subimageString = DataPackageUtil.addpic(relativePath + UtilCharacter.UNIX_FILE_SEPARATOR + "571sjb" + UtilCharacter.UNIX_FILE_SEPARATOR, sge.getImages());
        DataPackageUtil.addDescpic(relativePath + UtilCharacter.UNIX_FILE_SEPARATOR + "xiangqing" + UtilCharacter.UNIX_FILE_SEPARATOR, goodsdesc);
        String picture = subimageString;//新图片
        String video = "";//视频
        TaobaoSkuExample example_ts = new TaobaoSkuExample();
        example_ts.createCriteria().andNumIidEqualTo(goods.getNumIid()).andRemark1IsNull();
        example_ts.or().andNumIidEqualTo(goods.getNumIid()).andRemark1NotEqualTo("delete");
        example_ts.setOrderByClause("properties asc");
        // 销售属性组合
        StringBuffer skuProps = new StringBuffer();//sku组合属性
        List<TaobaoSku> list_ts = taobaoSkuMapper.selectByExample(example_ts);////淘宝SKU
        String input_custom_cpv = "";//自定义属性

        if (list_ts.size() > 0) {
            for (int i = 0; i < list_ts.size(); i++) {
                skuProps.append(list_ts.get(i).getPrice()).append(':').append(list_ts.get(i).getQuantity()).append(':').append(':').append(list_ts.get(i).getProperties()).append(';');
            }
        } else {
            String props = sge.getProps();
            if (!props.contains("20509") || !props.contains("1627207")) {
                return null;
            }
            //获取尺码属性
            List<String> sizePropList = matchHelp("20509:\\d+",props);
            List<String> colorPropList = matchHelp("1627207:\\d+",props);
            String[] sizes = sizePropList.toArray(new String[0]);
            String[] colors = colorPropList.toArray(new String[0]);
            for (int i = 1; i < colors.length; i++) {
                for (int j = 1; j < sizes.length; j++) {
                    skuProps.append(goods.getPriceString()).append(':').append("100").append(':').append(':');
                    skuProps.append(colors[i]).append(';');
                    skuProps.append(sizes[j]).append(';');
                }
            }
        }
        String inputPids = "";//用户输入ID串@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        String inputValues = "";//用户输入名-值对@@@@@@@@@@@@@@@@@@@@@@@

        String auto_fill = "0";//代充类型
        String num_id = "0";//数字ID
        String local_cid = "0";//本地ID
        String navigation_type = "1";//宝贝分类
        String user_name = "";//用户名称
        String syncStatus = "2";//宝贝状态
        String is_lighting_consigment = "0";//闪电发货

        String is_xinpin = "0";//新品
        String foodparame = "";//食品专项
        String features = "mysize_tp:-1";//尺码库
        String buyareatype = "";//采购地
        String global_stock_type = "";//库存类型
        String global_stock_country = "";//国家地区
        String sub_stock_type = "";//库存计数
        String qualification = "";//商品资质
        String item_size = "";//物流体积
        String item_weight = "";//物流重量
        String sell_promise = "0";//退换货承诺
        String custom_design_flag = "";//定制工具
        String wireless_desc = "";//无线详情
        String barcode = "";//商品条形码
        String sku_barcode = "";//sku 条形码
        String newprepay = "";//7天退货
        String subtitle = "";//宝贝卖点
        String cpv_memo = "";//属性备注
        String add_qualification = "";//增加商品资质
        String o2o_bind_service = "";//关联线下服务
        String tmall_extend = "";//tmall扩展
        String product_combine = "";//产品组合
        String tmall_item_prop_combine = "";//tmall属性组合
        String taoschema_extend = "";//taoschema扩展字段
        //查询商品扩展
        String stuff_status = "1";
        String list_time = TypeConvert.formatDate(goods.getListTime());
        if ("second".equals(goods.getStuffStatus())) {
            stuff_status = "3";
        }
        StringBuffer contentsString = new StringBuffer();
        contentsString.append(goods.getTitle()).append('\t').append(goods.getCid()).append('\t').append(goods.getCidAll()).append('\t').append(stuff_status).append('\t').append(goods.getProv()).append('\t').append(goods.getCity()).append('\t').append(item_type).append('\t').append(goods.getPriceString()).append('\t').append(auction_increment).append('\t');
        contentsString.append(goods.getNum()).append('\t').append(valid_thru).append('\t').append(freight_payer).append('\t').append('0').append('\t').append('0').append('\t').append('0').append('\t').append(has_invoice).append('\t').append(has_warranty).append('\t').append(approve_status).append('\t').append(has_showcase).append('\t');
        contentsString.append(list_time).append('\t').append("\"").append(goodsdesc).append("\"").append('\t').append(sge.getProps()).append('\t').append(postage_id).append('\t').append(has_discount).append('\t').append(modified).append('\t').append(upload_fail_msg).append('\t').append(picture_status).append('\t').append(auction_point).append('\t');
        contentsString.append(picture).append('\t').append(video).append('\t').append(skuProps.toString()).append('\t').append(inputPids).append('\t').append(inputValues).append('\t').append(goods.getOuterId()).append('\t').append(sge.getPropertyAlias()).append('\t').append(auto_fill).append('\t').append(num_id).append('\t').append(local_cid).append('\t').append(navigation_type).append('\t');
        contentsString.append(user_name).append('\t').append(syncStatus).append('\t').append(is_lighting_consigment).append('\t').append(is_xinpin).append('\t').append(foodparame).append('\t').append(features).append('\t').append(buyareatype).append('\t').append(global_stock_type).append('\t').append(global_stock_country).append('\t').append(sub_stock_type).append('\t').append(item_size).append('\t');
        contentsString.append(item_weight).append('\t').append(sell_promise).append('\t').append(custom_design_flag).append('\t').append(wireless_desc).append('\t').append(barcode).append('\t').append(sku_barcode).append('\t').append(newprepay).append('\t').append(subtitle).append('\t').append(cpv_memo).append('\t').append(input_custom_cpv).append('\t').append(qualification).append('\t');
        contentsString.append(add_qualification).append('\t').append(o2o_bind_service).append('\t').append(tmall_extend).append('\t').append(product_combine).append('\t').append(tmall_item_prop_combine).append('\t').append(taoschema_extend).append('\r').append('\n');

        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("contents", contentsString.toString());
        hashMap.put("shopId", shopId.toString());
        return hashMap;
    }


    /**
     * 数据包生成
     *
     * @param userId
     * @param itemIds
     * @return
     */
    @Override
    public boolean createDataPackage(Long userId, List<Long> itemIds) {
        // 包头         
        String date_package = "";
        // 版本号         
        String version = "version 1.00";
        // 英文标题栏         
        String title_EString = "title" + '\t' + "cid" + '\t' + "seller_cids" + '\t' + "stuff_status" + '\t' + "location_state" + '\t' +
                "location_city" + '\t' + "item_type" + '\t' + "price" + '\t' + "auction_increment" + '\t' + "num" + '\t' + "valid_thru" + '\t'
                + "freight_payer" + '\t' + "post_fee" + '\t' + "ems_fee" + '\t' + "express_fee" + '\t' + "has_invoice" + '\t' + "has_warranty"
                + '\t' + "approve_status" + '\t' + "has_showcase" + '\t' + "list_time" + '\t' + "description" + '\t' + "cateProps" + '\t' + "postage_id"
                + '\t' + "has_discount" + '\t' + "modified" + '\t' + "upload_fail_msg" + '\t' + "picture_status" + '\t' + "auction_point" + '\t' + "picture" +
                '\t' + "video" + '\t' + "skuProps" + '\t' + "inputPids" + '\t' + "inputValues" + '\t' + "outer_id" + '\t' + "propAlias" + '\t' + "auto_fill" + '\t'
                + "num_id" + '\t' + "local_cid" + '\t' + "navigation_type" + '\t' + "user_name" + '\t' + "syncStatus" + '\t' + "is_lighting_consigment" + '\t'
                + "is_xinpin" + '\t' + "foodparame" + '\t' + "features" + '\t' + "buyareatype" + '\t' + "global_stock_type" + '\t' + "global_stock_country" + '\t'
                + "sub_stock_type" + '\t' + "item_size" + '\t' + "item_weight" + '\t' + "sell_promise" + '\t' + "custom_design_flag" + '\t'
                + "wireless_desc" + '\t' + "barcode" + '\t' + "sku_barcode" + '\t' + "newprepay" + '\t' + "subtitle" + '\t' + "cpv_memo" + '\t' + "input_custom_cpv" + '\t'
                + "qualification" + '\t' + "add_qualification" + '\t' + "o2o_bind_service" + '\t' + "tmall_extend" + '\t' + "product_combine" + '\t' + "tmall_item_prop_combine" + '\t'
                + "taoschema_extend";
        // 中文标题栏         
        String title_CString = "宝贝名称" + '\t' + "宝贝类目" + '\t' + "店铺类目" + '\t' + "新旧程度" + '\t' + "省" + '\t' + "城市" + '\t' + "出售方式" + '\t' + "宝贝价格"
                + '\t' + "加价幅度" + '\t' + "宝贝数量" + '\t' + "有效期" + '\t' + "运费承担" + '\t' + "平邮" + '\t' + "EMS" + '\t' + "快递" + '\t' + "发票" + '\t' + "保修"
                + '\t' + "放入仓库" + '\t' + "橱窗推荐" + '\t' + "开始时间" + '\t' + "宝贝描述" + '\t' + "宝贝属性" + '\t' + "邮费模版ID" + '\t' + "会员打折" + '\t'
                + "修改时间" + '\t' + "上传状态" + '\t' + "图片状态" + '\t' + "返点比例" + '\t' + "新图片" + '\t' + "视频" + '\t' + "销售属性组合" + '\t' + "用户输入ID串"
                + '\t' + "用户输入名-值对" + '\t' + "商家编码" + '\t' + "销售属性别名" + '\t' + "代充类型" + '\t' + "数字ID" + '\t' + "本地ID" + '\t' + "宝贝分类"
                + '\t' + "用户名称" + '\t' + "宝贝状态" + '\t' + "闪电发货" + '\t' + "新品" + '\t' + "食品专项" + '\t' + "尺码库" + '\t' + "采购地" + '\t' + "库存类型" + '\t' + "国家地区"
                + '\t' + "库存计数" + '\t' + "物流体积" + '\t' + "物流重量" + '\t' + "退换货承诺" + '\t' + "定制工具" + '\t' + "无线详情" + '\t' + "商品条形码" + '\t' + "sku 条形码"
                + '\t' + "7天退货" + '\t' + "宝贝卖点" + '\t' + "属性值备注" + '\t' + "自定义属性" + '\t' + "商品资质" + '\t' + "增加商品资质" + '\t' + "关联线下服务" + '\t' + "tmall属性组合"
                + '\t' + "taoschema扩展字段";

        String DATA_PACKAGE_ADDR = FilePathConstant.ITEM_COLLECT_PACKAGE_PATH_URL;

        String folder_yyyyMM = TypeConvert.formatDateyyyyMM(new Date()) + UtilCharacter.UNIX_FILE_SEPARATOR + userId;
        String relativePath = DATA_PACKAGE_ADDR + "/dataupload" + UtilCharacter.UNIX_FILE_SEPARATOR + folder_yyyyMM
                + UtilCharacter.UNIX_FILE_SEPARATOR + "571sjb";
        String relativePath1 = DATA_PACKAGE_ADDR + "/dataupload" + UtilCharacter.UNIX_FILE_SEPARATOR + folder_yyyyMM;

        if (!FileOperator.isExistingFolder(relativePath)) {
            FileOperator.createDirectory(relativePath);
        }
        if (!FileOperator.isExistingFolder(relativePath1)) {
            FileOperator.createDirectory(relativePath1);
        }

        StringBuffer contentBuffer = new StringBuffer();
        StringBuffer shopBuffer = new StringBuffer();


        Long shopId = null;
        for (int i = 0; i < itemIds.size(); i++) {
            Map<String, String> hashMap = createDataPackagestr(userId, itemIds.get(i), DATA_PACKAGE_ADDR, relativePath, relativePath1);
            if (hashMap == null) {
                continue;
            }
            contentBuffer.append(hashMap.get("contents"));
            shopBuffer.append(hashMap.get("shopId"));
            if (i != itemIds.size() && i != 0) {
                shopBuffer.append(',');
            }
            if (i == 0) {
                shopId = Long.valueOf(hashMap.get("shopId"));
            }
        }

        String itemds = StringUtils.join(itemIds.toArray(), ",");

        // 生成文件数据
        date_package = version + "\r\n" + title_EString + "\r\n" + title_CString + "\r\n" + contentBuffer.toString();

        String s = date_package;
        String savepath = relativePath + UtilCharacter.UNIX_FILE_SEPARATOR + "571sjb.csv";

        //生成csv文件
        DataPackageUtil.printContent(savepath, date_package);

        //打包
        String uuidString = UUID.randomUUID().toString().replace("-", "");
        String zipFileName = relativePath1 + UtilCharacter.UNIX_FILE_SEPARATOR + uuidString + ".zip";
        try {
            DataPackageUtil.zip(relativePath + UtilCharacter.UNIX_FILE_SEPARATOR, zipFileName);
            File cvs = new File(relativePath);
            FileUtil.deleteDir(cvs);
            File file = new File(zipFileName);
            String fileName = "datapackage/" + folder_yyyyMM + "/" + uuidString + ".zip";
            String packageUrl = ossIO.uploadFile(file, fileName);

            logger.info("生成数据包成功：" + packageUrl);
            // 删除本地zip
            file.delete();

            // 写入数据包的表
            ShiguGoodsDataPackage sgdp = new ShiguGoodsDataPackage();
            sgdp.setDataPackageSavePath(fileName);
            sgdp.setDataPackageUrl(packageUrl);
            sgdp.setGoodsId(itemIds.get(0));
            sgdp.setUseStatus(1);
            sgdp.setSortOrder(999L);
            sgdp.setStoreId(shopId);
            sgdp.setUserId(userId);
            sgdp.setRemark3(itemds);//多个商品的ID
            sgdp.setRemark2(shopBuffer.toString());//多个店铺ID
            sgdp.setRemark4(fileName);// oss key
            sgdp.setRemark20(uuidString + ".zip");
            sgdp.setRemark1(TypeConvert.formatDateTime(new Date()));
            shiguGoodsDataPackageMapper.insertSelective(sgdp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 生成数据包 数据包IDS
     *
     * @param userId
     * @param collectIdList
     * @return
     */
    @Override
    public boolean createDataPackageByCoolectIds(Long userId, List<Long> collectIdList) {
        if (userId == null) {
            return false;
        }
        if (collectIdList == null || collectIdList.size() == 0) {
            return false;
        }
        // TODO:待优化
        List<Long> goodsList = new ArrayList<Long>();
        for (int i = 0; i < collectIdList.size(); i++) {
            ShiguGoodsCollect shiguGoodsCollect = new ShiguGoodsCollect();
            shiguGoodsCollect.setGoodsCollectId(collectIdList.get(i));
            shiguGoodsCollect = shiguGoodsCollectMapper.selectOne(shiguGoodsCollect);
            if (shiguGoodsCollect == null) {
                continue;
            }
            goodsList.add(shiguGoodsCollect.getGoodsId());
        }
        boolean pans = createDataPackage(userId, goodsList);
        return pans;
    }

    /**
     * 查询数据包
     *
     * @param userId   用户ID
     * @param pageNo   当前页
     * @param pageSize 总页
     * @return
     */
    @Override
    public ShiguPager<DataPackage> selPackages(Long userId, int pageNo, int pageSize) {
        if (userId == null) {
            return new ShiguPager<DataPackage>();
        }
        if (pageNo == 0) {
            pageNo = 1;
        }
        if (pageSize == 0) {
            pageSize = 10;
        }
        int startIndx = (pageNo - 1) * pageSize;
        ShiguGoodsDataPackageExample example = new ShiguGoodsDataPackageExample();
        example.createCriteria().andUserIdEqualTo(userId);
        example.setStartIndex(startIndx);
        example.setEndIndex(pageSize);
        List<ShiguGoodsDataPackage> shiguGoodsDataPackageList = shiguGoodsDataPackageMapper.selectByConditionList(example);
        if (shiguGoodsDataPackageList.size() == 0) {
            return new ShiguPager<DataPackage>();
        }
        List<DataPackage> dataPackageList = new ArrayList<DataPackage>();
        for (int i = 0; i < shiguGoodsDataPackageList.size(); i++) {
            ShiguGoodsDataPackage shiguGoodsDataPackage = shiguGoodsDataPackageList.get(i);
            DataPackage dataPackage = new DataPackage();
            dataPackage.setCreateTime(shiguGoodsDataPackage.getRemark1());
            dataPackage.setDataPackageId(shiguGoodsDataPackage.getDataPackageId());
            String dataPackageUrl = shiguGoodsDataPackage.getDataPackageUrl();

            if (StringUtils.isEmpty(shiguGoodsDataPackage.getRemark4())) {
                // 没有OSS KEY
                dataPackageUrl = "http://www.571xz.com/" + dataPackageUrl;
            }

            dataPackage.setDataPackageUrl(dataPackageUrl);

            String itemIdStrs = shiguGoodsDataPackage.getRemark3();
            if (StringUtils.isEmpty(itemIdStrs) && shiguGoodsDataPackage.getGoodsId() != null) {
                itemIdStrs = shiguGoodsDataPackage.getGoodsId().toString();
            }

            String[] itemIds = itemIdStrs.split(",");

            List<PackageItem> packageItemsList = new ArrayList<PackageItem>();
            for (int j = 0; j < itemIds.length; j++) {
                Long goodsId = Long.valueOf(itemIds[j]);
                ShiguGoodsIdGenerator shiguGoodsIdGenerator = shiguGoodsIdGeneratorMapper.selectByPrimaryKey(goodsId);
                if (shiguGoodsIdGenerator == null) {
                    continue;
                }
                ShiguGoodsTiny shiguGoodsTiny = new ShiguGoodsTiny();
                shiguGoodsTiny.setWebSite(shiguGoodsIdGenerator.getWebSite());
                shiguGoodsTiny.setGoodsId(goodsId);
                shiguGoodsTiny = shiguGoodsTinyMapper.selectByPrimaryKey(shiguGoodsTiny);
                PackageItem packageItem = new PackageItem();
                if (shiguGoodsTiny != null) {
                    packageItem.setId(shiguGoodsTiny.getGoodsId());
                    packageItem.setTitle(shiguGoodsTiny.getTitle());
                    packageItem.setPicUrl(shiguGoodsTiny.getPicUrl());
                    packageItemsList.add(packageItem);
                    continue;
                }
                // 下架商品区查找
                ShiguGoodsSoldout shiguGoodsSoldout = new ShiguGoodsSoldout();
                shiguGoodsSoldout.setGoodsId(goodsId);
                shiguGoodsSoldout.setWebSite(shiguGoodsIdGenerator.getWebSite());
                shiguGoodsSoldout = shiguGoodsSoldoutMapper.selectByPrimaryKey(shiguGoodsSoldout);
                if (shiguGoodsSoldout != null) {
                    packageItem.setId(shiguGoodsSoldout.getGoodsId());
                    packageItem.setPicUrl(shiguGoodsSoldout.getPicUrl());
                    packageItem.setTitle(shiguGoodsSoldout.getTitle());
                    packageItemsList.add(packageItem);
                }
            }
            if (packageItemsList.size() == 0) {
                continue;
            }
            dataPackage.setGoods(packageItemsList);
            dataPackageList.add(dataPackage);
        }
        ShiguGoodsDataPackageExample packageExample = new ShiguGoodsDataPackageExample();
        packageExample.createCriteria().andUserIdEqualTo(userId);
        int dataPackageInt = shiguGoodsDataPackageMapper.countByExample(packageExample);
        ShiguPager<DataPackage> dataPackageShiguPager = new ShiguPager<DataPackage>();
        dataPackageShiguPager.setContent(dataPackageList);
        dataPackageShiguPager.setNumber(pageNo);
        dataPackageShiguPager.calPages(dataPackageInt, pageSize);
        return dataPackageShiguPager;
    }

    /**
     * 删除数据包
     *
     * @param packageIds
     */
    @Override
    public void delPackagesById(Long userId, List<Long> packageIds) {
        if (packageIds == null || packageIds.size() == 0) {
            logger.error("删除数据包>>入参数据为空");
        }
        ShiguGoodsDataPackageExample packageExample = new ShiguGoodsDataPackageExample();
        packageExample.createCriteria().andDataPackageIdIn(packageIds);
        List<ShiguGoodsDataPackage> shiguGoodsDataPackageList = shiguGoodsDataPackageMapper.selectByExample(packageExample);
        if (shiguGoodsDataPackageList.size() == 0) {
            return;
        }
        for (int i = 0; i < shiguGoodsDataPackageList.size(); i++) {
            ShiguGoodsDataPackage shiguGoodsDataPackage = shiguGoodsDataPackageList.get(i);
            if (shiguGoodsDataPackage.getUserId().intValue() != userId.intValue()) {
                continue;
            }
            String key = shiguGoodsDataPackage.getRemark4();
            if (!StringUtils.isEmpty(key) && shiguGoodsDataPackage.getDataPackageUrl().contains(ossIO.getDomain())) {
                // 删除OSS数据包
                try {
                    ossIO.deleteFile(key);
                } catch (Exception e) {
                    logger.error("删除OSS数据包失败>>error:" + e.toString());
                    e.printStackTrace();
                }
            }
            shiguGoodsDataPackageMapper.deleteByPrimaryKey(shiguGoodsDataPackage.getDataPackageId());
        }
    }

    @Override
    public ShiguPager<ShopCollectVO> selShopCollections(Long userId, String webSite, int pageNo, int pageSize) {
        ShiguPager<ShopCollectVO> pager = new ShiguPager<>();
        if (pageNo < 1)
            pageNo = 1;
        if (pageSize < 1)
            pageSize = 10;
        pager.setNumber(pageNo);
        if (userId == null)
            return pager;
        ShiguStoreCollectExample collectExample = new ShiguStoreCollectExample();
        collectExample.setOrderByClause("store_collect_id DESC");
        collectExample.setStartIndex((pageNo - 1) * pageSize);
        collectExample.setEndIndex(pageSize);
        collectExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andWebSiteEqualTo(webSite);
        int count = shiguStoreCollectMapper.countByExample(collectExample);
        pager.calPages(count, pageSize);
        if (count > 0) {
            List<ShiguStoreCollect> shiguStoreCollects = shiguStoreCollectMapper.selectByConditionList(collectExample);
            List<ShopCollectVO> vos = new ArrayList<>(shiguStoreCollects.size());
            pager.setContent(vos);
            if (shiguStoreCollects.size() > 0) {
                Map<Long, ShopInfo> shopIdInfoMap = BeanMapper.list2Map(selShopInfoByShopIds(BeanMapper.getFieldList(shiguStoreCollects, "storeId", Long.class)), "shopId", Long.class);
                for (ShiguStoreCollect shiguStoreCollect : shiguStoreCollects) {
                    try {
                        ShopInfo shopInfo = shopIdInfoMap.get(shiguStoreCollect.getStoreId());
                        if (shopInfo == null) {
                            //过滤一些遗留的测试数据（没有对应的档口）
                            continue;
                        }
                        ShopCollectVO shopCollect = BeanMapper.map(shopInfo, ShopCollectVO.class);
                        shopCollect.setCollId(shiguStoreCollect.getStoreCollectId());
                        shopCollect.setWebSite(shiguStoreCollect.getWebSite());
                        vos.add(shopCollect);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        return pager;
    }

    /**
     * 按主键删除店铺收藏
     *
     * @param userId     用户
     * @param collectIds 收藏ID
     */
    @Override
    public void delShopCollection(Long userId, List<Long> collectIds) {
        if (userId == null || collectIds == null || collectIds.isEmpty())
            return;
        ShiguStoreCollectExample collectExample = new ShiguStoreCollectExample();
        collectExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andStoreCollectIdIn(collectIds);
        shiguStoreCollectMapper.deleteByExample(collectExample);
    }

    /**
     * 按店铺id删除
     * @param userId
     * @param shopIds
     */
    public void delShopCollectionByShopIds(Long userId, List<Long> shopIds) {
        if (userId == null || shopIds == null || shopIds.isEmpty()){
            return;
        }
        ShiguStoreCollectExample example = new ShiguStoreCollectExample();
        example.createCriteria().andUserIdEqualTo(userId).andStoreIdIn(shopIds);
        shiguStoreCollectMapper.deleteByExample(example);
    }

    /**
     * 添加店铺收藏
     *
     * @param collect 店铺收藏
     */
    @Override
    public void addShopCollection(ShopCollect collect) throws ShopCollectionException {
        if (collect == null || collect.getUserId() == null || collect.getShopId() == null) {
            throw new ShopCollectionException(ShopCollectionException.ShopCollecExcpEnum.IllegalArgumentException);
        }
        ShiguStoreCollectExample collectExample = new ShiguStoreCollectExample();
        collectExample.createCriteria().andStoreIdEqualTo(collect.getShopId())
                .andUserIdEqualTo(collect.getUserId());
        List<ShiguStoreCollect> shiguStoreCollects = shiguStoreCollectMapper.selectByExample(collectExample);
        if (shiguStoreCollects.isEmpty()) {
            ShiguStoreCollect storeCollect = BeanMapper.map(collect, ShiguStoreCollect.class);
            storeCollect.setStoreId(collect.getShopId());
            storeCollect.setWebSite(collect.getWebsite());
            shiguStoreCollectMapper.insertSelective(storeCollect);
        } else
            throw new ShopCollectionException(ShopCollectionException.ShopCollecExcpEnum.CollectionAlreadyExist);
    }

    @Override
    public List<ShopInfo> selShopInfoByShopIds(List<Long> shopIds) {
        String defaultShopImgUrl = "";
        List<ShopInfo> shopInfoList = Lists.newArrayList();
        ShiguShopExample shopExample = new ShiguShopExample();
        shopExample.createCriteria().andShopIdIn(shopIds);
        List<ShiguShop> shiguShops = shiguShopMapper.selectByExample(shopExample);
        List<Long> marketIds = Lists.newArrayList();
        for (ShiguShop shiguShop : shiguShops) {
            marketIds.add(shiguShop.getMarketId());
        }
        if (marketIds.size() > 0) {
            ShiguMarketExample marketExample = new ShiguMarketExample();
            marketExample.createCriteria().andMarketIdIn(marketIds);
            Map<Long, ShiguMarket> marketIdInfoMap = BeanMapper.list2Map(shiguMarketMapper.selectByExample(marketExample), "marketId", Long.class);
            for (ShiguShop shiguShop : shiguShops) {
                ShopInfo shopInfo = new ShopInfo();
                shopInfo.setShopId(shiguShop.getShopId());
                shopInfo.setShopNum(shiguShop.getShopNum());
                shopInfo.setImWw(shiguShop.getImAliww());
                shopInfo.setImQq(shiguShop.getImQq());
                //todo 暂时没有店铺图片
                shopInfo.setShopImgSrc(defaultShopImgUrl);
                shopInfo.setMarketName(marketIdInfoMap.get(shiguShop.getMarketId()).getMarketName());
                shopInfoList.add(shopInfo);
            }
        }
        return shopInfoList;
    }

    /**
     * 获取字符串中所有符合规则的子串
     * @param regex 正则表达式
     * @param source 源字符串
     * @return
     */
    private List<String> matchHelp(String regex,String source){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        List<String> resultList = new ArrayList<>();
        while (matcher.find()) {
            resultList.add(matcher.group());
        }
        return resultList;
    }
}
