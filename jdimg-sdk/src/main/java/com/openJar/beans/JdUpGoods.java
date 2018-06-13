package com.openJar.beans;

import com.openJar.utils.OpenBean;

/**
 * Created By admin on 2017/12/11/17:33
 * FBP是商家商品从发货到售后都是京东处理，意思就是和自营商品差不多，
 * soph是第三方商家用自己的物流自己发货及售后处理。
 */
public class JdUpGoods extends OpenBean{

    /**流水号*/
    private String tradeNo;
    /**产地*/
    private String wareLocation;
    /**类目id*/
//    @NotEmpty(message = "类目id不能为空")
    private String cid;
    /**
     * 自定义店内分类，通过360buy.sellercats.get获取店铺分类的parent_id及cid，
     * 按“parent_id-cid"格式传入，同时设置多个以分号（;）分隔即可。
     * 店内分类，格式:206-208;207-208 206(一级)-208(二级);207(一级)-207(一级)
     *
     */
    private String shopCategory;
    /**商品标题*/
//    @NotEmpty(message = "商品标题不能为空")
    private String title;
    /**UPC编码*/
    private String upcCode;
    /**操作类型 现只支持：offsale 或onsale,默认为下架状态*/
    private String optionType;
    /**外部商品编号，对应商家后台货号*/
    private String itemNum;
    /**库存*/
//    @NotEmpty(message = "库存不能为空")
    private String stockNum;
    /**生产厂商*/
    private String producter;
    /**包装规格*/
    private String wrap;
    /**长(单位:mm)*/
//    @NotEmpty(message = "商品长度不能为空")
    private String length;
    /**宽(单位:mm)*/
//    @NotEmpty(message = "商品宽度不能为空")
    private String wide;
    /**高(单位:mm)*/
//    @NotEmpty(message = "商品高度不能为空")
    private String high;
    /**重量(单位:kg)*/
//    @NotEmpty(message = "商品重量不能为空")
    private String weight;
    /**进货价,精确到2位小数，单位:元*/
    private String costPrice;
    /**市场价, 精确到2位小数，单位:元*/
//    @NotEmpty(message = "市场价不能为空")
    private String marketPrice;
    /**京东价,精确到2位小数，单位:元*/
//    @NotEmpty(message = "京东价不能为空")
    private String jdPrice;
    /**描述（最多支持3万个英文字符）*/
//    @NotEmpty(message = "描述信息不能为空")
//    @Size(max=30000,message = "描述信息过长,最多支持3万个英文字符")
    private String notes;
    /**图片信息（图片尺寸为800*800，单张大小不超过 1024K）*/
    private String wareImageUrl;
    /**包装清单*/
    private String packListing;
    /**售后服务*/
    private String service;
    /**
     * sku 属性,一组sku 属性之间用^分隔，
     * 多组用|分隔格式:aid:vid^aid1:vid2|aid3:vid3^aid4:vid4 （需要从类目服务接口获取）
     */
    private String skuProperties;
    /**
     * 商品属性列表,多组之间用|分隔，
     * 格式:aid:vid 或 aid:vid|aid1:vid1 或 aid1:vid1（需要从类目服务接口获取）
     * 如输入类型input_type为1或2，则attributes为必填属性；
     * 如输入类型input_type为3，则用字段input_str填入属性的值
     */
    private String attributes;
    /**sku 价格,多组之间用‘|’分隔，格式:p1|p2*/
    private String skuPrices;
    /**sku 库存,多组之间用‘|’分隔， 格式:s1|s2*/
    private String skuStocks;
    /**
     * 自定义属性值别名： 属性ID:属性值ID:别名 ，多组之间用^ 分开，如aid:vid:别名^ aid1:vid1:别名1
     */
    private String propertyAlias;
    /**
     * SKU外部ID，对个之间用‘|’分隔格，比如：sdf|sds
     * （支持没有sku的情况下，可以输入外部id，并将外部id绑定在默认生成的sku上），
     * 对应商家后台‘商家skuid’
     */
    private String outerId;
    /**
     * 是否先款后货 , false为否，true为是
     */
    private String payFirst;
    /**
     * 发票限制：非必须输入，true为限制，false为不限制开增值税发票，FBP、LBP、SOPL、SOP类型商品均可输入
     */
    private String canVAT;
    /**
     * 是否进口商品：非必须输入，false为否，true为是，FBP类型商品可输入
     */
    private String imported;
    /**
     * 用户自行输入的类目属性ID串结构：‘pid1|pid2|pid3’,
     * 属性的pid调用360buy.ware.get.attribute取得, 输入类型input_type=3即输入
     */
    private String inputPids;
    /**
     * 用户自行输入的属性值,结构:
     * ‘输入值|输入值2|输入值3’
     * 图书品类输入值规则：
     *      ISBN：数字、字母格式
     *      出版时间：日期格式“yyyy-mm-dd”
     *      版次：数字格式 印刷时间：日期格式“yyyy-mm-dd”
     *      印次：数字格式
     *      页数：数字格式
     *      字数：数字格式
     *      套装数量：数字格式
     *      附件数量：数字格式
     */
    private String inputStrs;
    /**
     * 是否输入验证码 true:是;false:否
     */
    private String hasCheckCode;
    /**
     * 广告词内容最大支持45个字符
     */
//    @Size(max = 45,message = "广告词内容最大支持45个字符")
    private String adContent;
    /**
     * 定时上架时间 时间格式：yyyy-MM-dd HH:mm:ss;规则是大于当前时间，10天内。
     */
    private String listTime;
    private String wareBigSmallModel;
    private String warePackType;

    /**流水号*/
    public String getTradeNo() {
        return this.tradeNo;
    }

    /**流水号*/
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    /**产地*/
    public String getWareLocation() {
        return this.wareLocation;
    }

    /**产地*/
    public void setWareLocation(String wareLocation) {
        this.wareLocation = wareLocation;
    }

    /**类目id*/
    public String getCid() {
        return this.cid;
    }

    /**类目id*/
    public void setCid(String cid) {
        this.cid = cid;
    }

    /**
     * 自定义店内分类，通过360buy.sellercats.get获取店铺分类的parent_id及cid，
     * 按“parent_id-cid"格式传入，同时设置多个以分号（;）分隔即可。
     * 店内分类，格式:206-208;207-208 206(一级)-208(二级);207(一级)-207(一级)
     *
     */
    public String getShopCategory() {
        return this.shopCategory;
    }

    /**
     * 自定义店内分类，通过360buy.sellercats.get获取店铺分类的parent_id及cid，
     * 按“parent_id-cid"格式传入，同时设置多个以分号（;）分隔即可。
     * 店内分类，格式:206-208;207-208 206(一级)-208(二级);207(一级)-207(一级)
     *
     */
    public void setShopCategory(String shopCategory) {
        this.shopCategory = shopCategory;
    }

    /**商品标题*/
    public String getTitle() {
        return this.title;
    }

    /**商品标题*/
    public void setTitle(String title) {
        this.title = title;
    }

    /**UPC编码*/
    public String getUpcCode() {
        return this.upcCode;
    }

    /**UPC编码*/
    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
    }

    /**操作类型 现只支持：offsale 或onsale,默认为下架状态*/
    public String getOptionType() {
        return this.optionType;
    }

    /**操作类型 现只支持：offsale 或onsale,默认为下架状态*/
    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }

    /**外部商品编号，对应商家后台货号*/
    public String getItemNum() {
        return this.itemNum;
    }

    /**外部商品编号，对应商家后台货号*/
    public void setItemNum(String itemNum) {
        this.itemNum = itemNum;
    }

    /**库存*/
    public String getStockNum() {
        return this.stockNum;
    }

    /**库存*/
    public void setStockNum(String stockNum) {
        this.stockNum = stockNum;
    }

    /**生产厂商*/
    public String getProducter() {
        return this.producter;
    }

    /**生产厂商*/
    public void setProducter(String producter) {
        this.producter = producter;
    }

    /**包装规格*/
    public String getWrap() {
        return this.wrap;
    }

    /**包装规格*/
    public void setWrap(String wrap) {
        this.wrap = wrap;
    }

    /**长(单位:mm)*/
    public String getLength() {
        return this.length;
    }

    /**长(单位:mm)*/
    public void setLength(String length) {
        this.length = length;
    }

    /**宽(单位:mm)*/
    public String getWide() {
        return this.wide;
    }

    /**宽(单位:mm)*/
    public void setWide(String wide) {
        this.wide = wide;
    }

    /**高(单位:mm)*/
    public String getHigh() {
        return this.high;
    }

    /**高(单位:mm)*/
    public void setHigh(String high) {
        this.high = high;
    }

    /**重量(单位:kg)*/
    public String getWeight() {
        return this.weight;
    }

    /**重量(单位:kg)*/
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**进货价,精确到2位小数，单位:元*/
    public String getCostPrice() {
        return this.costPrice;
    }

    /**进货价,精确到2位小数，单位:元*/
    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    /**市场价, 精确到2位小数，单位:元*/
    public String getMarketPrice() {
        return this.marketPrice;
    }

    /**市场价, 精确到2位小数，单位:元*/
    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**京东价,精确到2位小数，单位:元*/
    public String getJdPrice() {
        return this.jdPrice;
    }

    /**京东价,精确到2位小数，单位:元*/
    public void setJdPrice(String jdPrice) {
        this.jdPrice = jdPrice;
    }

    /**描述（最多支持3万个英文字符）*/
    public String getNotes() {
        return this.notes;
    }

    /**描述（最多支持3万个英文字符）*/
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**图片信息（图片尺寸为800*800，单张大小不超过 1024K）*/
    public String getWareImageUrl() {
        return this.wareImageUrl;
    }

    /**图片信息（图片尺寸为800*800，单张大小不超过 1024K）*/
    public void setWareImageUrl(String wareImageUrl) {
        this.wareImageUrl = wareImageUrl;
    }

    /**包装清单*/
    public String getPackListing() {
        return this.packListing;
    }

    /**包装清单*/
    public void setPackListing(String packListing) {
        this.packListing = packListing;
    }

    /**售后服务*/
    public String getService() {
        return this.service;
    }

    /**售后服务*/
    public void setService(String service) {
        this.service = service;
    }

    /**
     * sku 属性,一组sku 属性之间用^分隔，
     * 多组用|分隔格式:aid:vid^aid1:vid2|aid3:vid3^aid4:vid4 （需要从类目服务接口获取）
     */
    public String getSkuProperties() {
        return this.skuProperties;
    }

    /**
     * sku 属性,一组sku 属性之间用^分隔，
     * 多组用|分隔格式:aid:vid^aid1:vid2|aid3:vid3^aid4:vid4 （需要从类目服务接口获取）
     */
    public void setSkuProperties(String skuProperties) {
        this.skuProperties = skuProperties;
    }

    /**
     * 商品属性列表,多组之间用|分隔，
     * 格式:aid:vid 或 aid:vid|aid1:vid1 或 aid1:vid1（需要从类目服务接口获取）
     * 如输入类型input_type为1或2，则attributes为必填属性；
     * 如输入类型input_type为3，则用字段input_str填入属性的值
     */
    public String getAttributes() {
        return this.attributes;
    }

    /**
     * 商品属性列表,多组之间用|分隔，
     * 格式:aid:vid 或 aid:vid|aid1:vid1 或 aid1:vid1（需要从类目服务接口获取）
     * 如输入类型input_type为1或2，则attributes为必填属性；
     * 如输入类型input_type为3，则用字段input_str填入属性的值
     */
    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    /**sku 价格,多组之间用‘|’分隔，格式:p1|p2*/
    public String getSkuPrices() {
        return this.skuPrices;
    }

    /**sku 价格,多组之间用‘|’分隔，格式:p1|p2*/
    public void setSkuPrices(String skuPrices) {
        this.skuPrices = skuPrices;
    }

    /**sku 库存,多组之间用‘|’分隔， 格式:s1|s2*/
    public String getSkuStocks() {
        return this.skuStocks;
    }

    /**sku 库存,多组之间用‘|’分隔， 格式:s1|s2*/
    public void setSkuStocks(String skuStocks) {
        this.skuStocks = skuStocks;
    }

    /**
     * 获取 自定义属性值别名： 属性ID:属性值ID:别名 ，多组之间用^ 分开，如aid:vid:别名^ aid1:vid1:别名1
     */
    public String getPropertyAlias() {
        return this.propertyAlias;
    }

    /**
     * 设置 自定义属性值别名： 属性ID:属性值ID:别名 ，多组之间用^ 分开，如aid:vid:别名^ aid1:vid1:别名1
     */
    public void setPropertyAlias(String propertyAlias) {
        this.propertyAlias = propertyAlias;
    }

    /**
     * SKU外部ID，对个之间用‘|’分隔格，比如：sdf|sds
     * （支持没有sku的情况下，可以输入外部id，并将外部id绑定在默认生成的sku上），
     * 对应商家后台‘商家skuid’
     */
    public String getOuterId() {
        return this.outerId;
    }

    /**
     * SKU外部ID，对个之间用‘|’分隔格，比如：sdf|sds
     * （支持没有sku的情况下，可以输入外部id，并将外部id绑定在默认生成的sku上），
     * 对应商家后台‘商家skuid’
     */
    public void setOuterId(String outerId) {
        this.outerId = outerId;
    }

    /**
     * 获取 是否先款后货 , false为否，true为是
     */
    public String getPayFirst() {
        return this.payFirst;
    }

    /**
     * 设置 是否先款后货 , false为否，true为是
     */
    public void setPayFirst(String payFirst) {
        this.payFirst = payFirst;
    }

    /**
     * 获取 发票限制：非必须输入，true为限制，false为不限制开增值税发票，FBP、LBP、SOPL、SOP类型商品均可输入
     */
    public String getCanVAT() {
        return this.canVAT;
    }

    /**
     * 设置 发票限制：非必须输入，true为限制，false为不限制开增值税发票，FBP、LBP、SOPL、SOP类型商品均可输入
     */
    public void setCanVAT(String canVAT) {
        this.canVAT = canVAT;
    }

    /**
     * 获取 是否进口商品：非必须输入，false为否，true为是，FBP类型商品可输入
     */
    public String getImported() {
        return this.imported;
    }

    /**
     * 设置 是否进口商品：非必须输入，false为否，true为是，FBP类型商品可输入
     */
    public void setImported(String imported) {
        this.imported = imported;
    }

    /**
     * 用户自行输入的类目属性ID串结构：‘pid1|pid2|pid3’,
     * 属性的pid调用360buy.ware.get.attribute取得, 输入类型input_type=3即输入
     */
    public String getInputPids() {
        return this.inputPids;
    }

    /**
     * 用户自行输入的类目属性ID串结构：‘pid1|pid2|pid3’,
     * 属性的pid调用360buy.ware.get.attribute取得, 输入类型input_type=3即输入
     */
    public void setInputPids(String inputPids) {
        this.inputPids = inputPids;
    }

    /**
     * 用户自行输入的属性值,结构:
     * ‘输入值|输入值2|输入值3’
     * 图书品类输入值规则：
     *      ISBN：数字、字母格式
     *      出版时间：日期格式“yyyy-mm-dd”
     *      版次：数字格式 印刷时间：日期格式“yyyy-mm-dd”
     *      印次：数字格式
     *      页数：数字格式
     *      字数：数字格式
     *      套装数量：数字格式
     *      附件数量：数字格式
     */
    public String getInputStrs() {
        return this.inputStrs;
    }

    /**
     * 用户自行输入的属性值,结构:
     * ‘输入值|输入值2|输入值3’
     * 图书品类输入值规则：
     *      ISBN：数字、字母格式
     *      出版时间：日期格式“yyyy-mm-dd”
     *      版次：数字格式 印刷时间：日期格式“yyyy-mm-dd”
     *      印次：数字格式
     *      页数：数字格式
     *      字数：数字格式
     *      套装数量：数字格式
     *      附件数量：数字格式
     */
    public void setInputStrs(String inputStrs) {
        this.inputStrs = inputStrs;
    }

    /**
     * 获取 是否输入验证码 true:是;false:否
     */
    public String getHasCheckCode() {
        return this.hasCheckCode;
    }

    /**
     * 设置 是否输入验证码 true:是;false:否
     */
    public void setHasCheckCode(String hasCheckCode) {
        this.hasCheckCode = hasCheckCode;
    }

    /**
     * 获取 广告词内容最大支持45个字符
     */
    public String getAdContent() {
        return this.adContent;
    }

    /**
     * 设置 广告词内容最大支持45个字符
     */
    public void setAdContent(String adContent) {
        this.adContent = adContent;
    }

    /**
     * 获取 定时上架时间 时间格式：yyyy-MM-dd HH:mm:ss;规则是大于当前时间，10天内。
     */
    public String getListTime() {
        return this.listTime;
    }

    /**
     * 设置 定时上架时间 时间格式：yyyy-MM-dd HH:mm:ss;规则是大于当前时间，10天内。
     */
    public void setListTime(String listTime) {
        this.listTime = listTime;
    }

    public String getWareBigSmallModel() {
        return this.wareBigSmallModel;
    }

    public void setWareBigSmallModel(String wareBigSmallModel) {
        this.wareBigSmallModel = wareBigSmallModel;
    }

    public String getWarePackType() {
        return this.warePackType;
    }

    public void setWarePackType(String warePackType) {
        this.warePackType = warePackType;
    }

}
