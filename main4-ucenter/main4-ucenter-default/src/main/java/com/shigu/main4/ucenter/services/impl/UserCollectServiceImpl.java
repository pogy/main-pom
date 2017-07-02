package com.shigu.main4.ucenter.services.impl;

import com.opentae.core.mybatis.utils.FieldUtil;
import com.opentae.data.mall.beans.*;
import com.opentae.data.mall.examples.*;
import com.opentae.data.mall.interfaces.*;
import com.shigu.component.config.FilePathConstant;
import com.shigu.component.util.*;
import com.shigu.main4.common.tools.ShiguPager;
import com.shigu.main4.common.util.DateUtil;
import com.shigu.main4.common.util.TypeConvert;
import com.shigu.main4.tools.OssIO;
import com.shigu.main4.ucenter.exceptions.ItemCollectionException;
import com.shigu.main4.ucenter.exceptions.ShopCollectionException;
import com.shigu.main4.ucenter.services.UserCollectService;
import com.shigu.main4.ucenter.vo.DataPackage;
import com.shigu.main4.ucenter.vo.ItemCollect;
import com.shigu.main4.ucenter.vo.PackageItem;
import com.shigu.main4.ucenter.vo.ShopCollect;
import com.shigu.main4.ucenter.webvo.ItemCollectVO;
import com.shigu.main4.ucenter.webvo.ShopCollectVO;
import com.shigu.session.main4.tool.BeanMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

/**
 * Created by wxc on 2017/2/25.
 *
 * @author wxc
 * @version domwiki 4.0.0
 * @since domwiki 4.0.0
 */
@Service
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
        if (collect == null || collect.getUserId() == null || collect.getItemId() == null) {
            throw new ItemCollectionException(ItemCollectionException.ItemCollecExcpEnum.IllegalArgumentException);
        }
        ShiguGoodsCollectExample collectExample = new ShiguGoodsCollectExample();
        collectExample.createCriteria().andGoodsIdEqualTo(collect.getItemId())
                .andUserIdEqualTo(collect.getUserId());
        List<ShiguGoodsCollect> shiguGoodsCollects = shiguGoodsCollectMapper.selectByExample(collectExample);
        if (shiguGoodsCollects.isEmpty()) {
            ShiguGoodsCollect goodsCollect = BeanMapper.map(collect, ShiguGoodsCollect.class);
            goodsCollect.setGoodsId(collect.getItemId());
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
        ShiguGoodsTiny goods = shiguGoodsTinyMapper.selectGoodsById(shiguGoodsIdGenerator.getWebSite(), itemId);
        ShiguGoodsExtends sge = shiguGoodsExtendsMapper.selectGoodsExtendsById(shiguGoodsIdGenerator.getWebSite(), itemId);
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
                skuProps.append(list_ts.get(i).getPrice() + ":" + list_ts.get(i).getQuantity() + ":" + "" + ":" + list_ts.get(i).getProperties() + ";");
            }
        } else {
            String props = sge.getProps();
            if (!props.contains("20509") || !props.contains("1627207")) {
                return null;
            }
            String substring = props.substring(props.indexOf("1627207"));
            String colorStr = substring.substring(0, substring.indexOf("20509:"));
            String sizeStr = substring.substring(substring.indexOf("20509:"), substring.lastIndexOf("20509:"));
            String s = substring.replace(colorStr, "").replace(sizeStr, "");
            String s1 = null;
            if (s.endsWith(";")) {
                s1 = s.substring(s.indexOf("20509:"), s.indexOf(";") + 1);
            } else {
                if (s.split(":").length > 2) {
                    s1 = s.substring(s.indexOf("20509:"), s.indexOf(";") + 1);
                } else {
                    s1 = s.substring(s.indexOf("20509:")) + ";";
                }
            }
            sizeStr += s1;

            String[] sizes = sizeStr.split("20509:");
            String[] colors = colorStr.split("1627207:");

            for (int i = 1; i < colors.length; i++) {
                for (int j = 1; j < sizes.length; j++) {
                    skuProps.append(goods.getPriceString() + ":" + "100" + ":" + "" + ":");
                    skuProps.append("1627207:" + colors[i]);
                    skuProps.append("20509:" + sizes[j]);
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

        String contentsString = "";
        contentsString += goods.getTitle() + '\t' + goods.getCid() + '\t' + goods.getCidAll() + '\t' + stuff_status + '\t' + goods.getProv() + '\t' + goods.getCity() + '\t' + item_type + '\t' + goods.getPriceString() + '\t' + auction_increment + '\t';
        contentsString += goods.getNum() + "" + '\t' + valid_thru + '\t' + freight_payer + '\t' + "0" + '\t' + "0" + '\t' + "0" + '\t' + has_invoice + '\t' + has_warranty + '\t' + approve_status + '\t' + has_showcase + '\t';
        contentsString += list_time + '\t' + "\"" + goodsdesc + "\"" + '\t' + sge.getProps() + '\t' + postage_id + '\t' + has_discount + '\t' + modified + '\t' + upload_fail_msg + '\t' + picture_status + '\t' + auction_point + '\t';
        contentsString += picture + '\t' + video + '\t' + skuProps.toString() + '\t' + inputPids + '\t' + inputValues + '\t' + goods.getOuterId() + '\t' + sge.getPropertyAlias() + '\t' + auto_fill + '\t' + num_id + '\t' + local_cid + '\t' + navigation_type + '\t';
        contentsString += user_name + '\t' + syncStatus + '\t' + is_lighting_consigment + '\t' + is_xinpin + '\t' + foodparame + '\t' + features + '\t' + buyareatype + '\t' + global_stock_type + '\t' + global_stock_country + '\t' + sub_stock_type + '\t' + item_size + '\t';
        contentsString += item_weight + '\t' + sell_promise + '\t' + custom_design_flag + '\t' + wireless_desc + '\t' + barcode + '\t' + sku_barcode + '\t' + newprepay + '\t' + subtitle + '\t' + cpv_memo + '\t' + input_custom_cpv + '\t' + qualification + '\t';
        contentsString += add_qualification + '\t' + o2o_bind_service + '\t' + tmall_extend + '\t' + product_combine + '\t' + tmall_item_prop_combine + '\t' + taoschema_extend + '\r' + '\n';

        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("contents", contentsString);
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
                shopBuffer.append(",");
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
        List<ShiguGoodsDataPackage> shiguGoodsDataPackageList = shiguGoodsDataPackageMapper.selGoodsPackageList(userId, startIndx, pageSize);
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
                ShiguGoodsTiny shiguGoodsTiny = shiguGoodsTinyMapper.selectGoodsById(shiguGoodsIdGenerator.getWebSite(),
                        goodsId);
                PackageItem packageItem = new PackageItem();
                if (shiguGoodsTiny != null) {
                    packageItem.setId(shiguGoodsTiny.getGoodsId());
                    packageItem.setTitle(shiguGoodsTiny.getTitle());
                    packageItem.setPicUrl(shiguGoodsTiny.getPicUrl());
                    packageItemsList.add(packageItem);
                    continue;
                }
                // 下架商品区查找
                ShiguGoodsSoldout shiguGoodsSoldout = shiguGoodsSoldoutMapper.selectGoodsSoldoutById(goodsId,
                        shiguGoodsIdGenerator.getWebSite());
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
        int dataPackageInt = shiguGoodsDataPackageMapper.selGoodsPackageCount(userId);
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
        List<ShiguGoodsDataPackage> shiguGoodsDataPackageList = shiguGoodsDataPackageMapper.selGoodsPackageListByIds(packageIds);
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

            Map<Long, ShiguShop> goodsTinyMap = Collections.EMPTY_MAP;
            Map<Long, ShiguMarket> marketMap = Collections.EMPTY_MAP;
            List<ShiguShop> shiguShops = Collections.EMPTY_LIST;
            try {
                //准备店铺数据
                List<Long> storeIds = BeanMapper.getFieldList(shiguStoreCollects, "storeId", Long.TYPE);
                if (storeIds.size() > 0) {
                    ShiguShopExample shopExample = new ShiguShopExample();
                    shopExample.setWebSite(webSite);
                    shopExample.createCriteria().andShopIdIn(storeIds);
                    shiguShops = shiguShopMapper.selectByExample(shopExample);
                    goodsTinyMap = BeanMapper.list2Map(shiguShops, "shopId", Long.class);
                }
            } catch (Exception e) {
                logger.warn("店铺数据准备失败", e);
            }
            try {
                //准备市场数据
                List<Long> marketIds = BeanMapper.getFieldList(shiguShops, "marketId", Long.TYPE);
                marketIds.addAll(BeanMapper.getFieldList(shiguShops, "floorId", Long.TYPE));
                if (marketIds.size() > 0) {
                    ShiguMarketExample marketExample = new ShiguMarketExample();
                    marketExample.setWebSite(webSite);
                    marketExample.createCriteria().andMarketIdIn(marketIds);
                    marketMap = BeanMapper.list2Map(
                            shiguMarketMapper.selectFieldsByExample(
                                    marketExample,
                                    FieldUtil.codeFields("market_id,market_name")
                            ),
                            "marketId",
                            Long.class
                    );
                }
            } catch (Exception e) {
                logger.warn("店铺数据准备失败", e);
            }

            List<ShopCollectVO> vos = new ArrayList<>(shiguStoreCollects.size());
            pager.setContent(vos);

            for (ShiguStoreCollect storeCollect : shiguStoreCollects) {
                ShopCollectVO vo = new ShopCollectVO();
                vo.setId(storeCollect.getStoreCollectId());
                vo.setShopId(storeCollect.getStoreId());
                vo.setWebsite(webSite);
                ShiguShop shop = goodsTinyMap.get(storeCollect.getStoreId());
                if (shop != null) {
                    vo.setAddress(shop.getAddress());
                    vo.setMainBus(shop.getMainBus());
                    vo.setShopName(shop.getShopName());
                    vo.setShopNum(shop.getShopNum());
                    ShiguMarket market = marketMap.get(shop.getMarketId());
                    if (market != null) {
                        vo.setMarket(market.getMarketName());
                    }
                    ShiguMarket floor = marketMap.get(shop.getFloorId());
                    if (floor != null) {
                        String voMarket = vo.getMarket();
                        if (voMarket == null)
                            voMarket = "";
                        vo.setMarket(voMarket + floor.getMarketName());
                    }
                }
                vos.add(vo);
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
}
