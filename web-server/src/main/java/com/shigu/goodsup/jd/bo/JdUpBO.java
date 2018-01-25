package com.shigu.goodsup.jd.bo;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created By admin on 2017/12/11/17:33
 * FBP是商家商品从发货到售后都是京东处理，意思就是和自营商品差不多，
 * soph是第三方商家用自己的物流自己发货及售后处理。
 */
public class JdUpBO implements Serializable{

    private static final long serialVersionUID = 133421250747350692L;

    /**流水号*/
    private String tradeNo;
    /**产地*/
    private String wareLocation;
    /**类目id*/
    @NotEmpty(message = "类目id不能为空")
    private String cid;
    /**
     * 自定义店内分类，通过360buy.sellercats.get获取店铺分类的parent_id及cid，
     * 按“parent_id-cid"格式传入，同时设置多个以分号（;）分隔即可。
     * 店内分类，格式:206-208;207-208 206(一级)-208(二级);207(一级)-207(一级)
     *
     */
    private String shopCategory;
    /**商品标题*/
    @NotEmpty(message = "商品标题不能为空")
    private String title;
    /**UPC编码*/
    private String upcCode;
    /**操作类型 现只支持：offsale 或onsale,默认为下架状态*/
    private String optionType;
    /**外部商品编号，对应商家后台货号*/
    private String itemNum;
    /**库存*/
    @NotEmpty(message = "库存不能为空")
    private String stockNum;
    /**生产厂商*/
    private String producter;
    /**包装规格*/
    private String wrap;
    /**长(单位:mm)*/
    @NotEmpty(message = "商品长度不能为空")
    private String length;
    /**宽(单位:mm)*/
    @NotEmpty(message = "商品宽度不能为空")
    private String wide;
    /**高(单位:mm)*/
    @NotEmpty(message = "商品高度不能为空")
    private String high;
    /**重量(单位:kg)*/
    @NotEmpty(message = "商品重量不能为空")
    private String weight;
    /**进货价,精确到2位小数，单位:元*/
    private String costPrice;
    /**市场价, 精确到2位小数，单位:元*/
    @NotEmpty(message = "市场价不能为空")
    private String marketPrice;
    /**京东价,精确到2位小数，单位:元*/
    @NotEmpty(message = "京东价不能为空")
    private String jdPrice;
    /**描述（最多支持3万个英文字符）*/
    @NotEmpty(message = "描述信息不能为空")
    @Size(max=30000,message = "描述信息过长,最多支持3万个英文字符")
    private String notes;
    /**图片信息（图片尺寸为800*800，单张大小不超过 1024K）*/
    private byte[] wareImage;
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
    private String isPayFirst;
    /**
     * 发票限制：非必须输入，true为限制，false为不限制开增值税发票，FBP、LBP、SOPL、SOP类型商品均可输入
     */
    private String isCanVAT;
    /**
     * 是否进口商品：非必须输入，false为否，true为是，FBP类型商品可输入
     */
    private String isImported;
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
    @Size(max = 45,message = "广告词内容最大支持45个字符")
    private String adContent;
    /**
     * 定时上架时间 时间格式：yyyy-MM-dd HH:mm:ss;规则是大于当前时间，10天内。
     */
    private String listTime;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getWareLocation() {
        return wareLocation;
    }

    public void setWareLocation(String wareLocation) {
        this.wareLocation = wareLocation;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getShopCategory() {
        return shopCategory;
    }

    public void setShopCategory(String shopCategory) {
        this.shopCategory = shopCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
    }

    public String getOptionType() {
        return optionType;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }

    public String getItemNum() {
        return itemNum;
    }

    public void setItemNum(String itemNum) {
        this.itemNum = itemNum;
    }

    public String getStockNum() {
        return stockNum;
    }

    public void setStockNum(String stockNum) {
        this.stockNum = stockNum;
    }

    public String getProducter() {
        return producter;
    }

    public void setProducter(String producter) {
        this.producter = producter;
    }

    public String getWrap() {
        return wrap;
    }

    public void setWrap(String wrap) {
        this.wrap = wrap;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWide() {
        return wide;
    }

    public void setWide(String wide) {
        this.wide = wide;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getJdPrice() {
        return jdPrice;
    }

    public void setJdPrice(String jdPrice) {
        this.jdPrice = jdPrice;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public byte[] getWareImage() {
        return wareImage;
    }

    public void setWareImage(byte[] wareImage) {
        this.wareImage = wareImage;
    }

    public String getPackListing() {
        return packListing;
    }

    public void setPackListing(String packListing) {
        this.packListing = packListing;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getSkuProperties() {
        return skuProperties;
    }

    public void setSkuProperties(String skuProperties) {
        this.skuProperties = skuProperties;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public String getSkuPrices() {
        return skuPrices;
    }

    public void setSkuPrices(String skuPrices) {
        this.skuPrices = skuPrices;
    }

    public String getSkuStocks() {
        return skuStocks;
    }

    public void setSkuStocks(String skuStocks) {
        this.skuStocks = skuStocks;
    }

    public String getPropertyAlias() {
        return propertyAlias;
    }

    public void setPropertyAlias(String propertyAlias) {
        this.propertyAlias = propertyAlias;
    }

    public String getOuterId() {
        return outerId;
    }

    public void setOuterId(String outerId) {
        this.outerId = outerId;
    }

    public String getIsPayFirst() {
        return isPayFirst;
    }

    public void setIsPayFirst(String isPayFirst) {
        this.isPayFirst = isPayFirst;
    }

    public String getIsCanVAT() {
        return isCanVAT;
    }

    public void setIsCanVAT(String isCanVAT) {
        this.isCanVAT = isCanVAT;
    }

    public String getIsImported() {
        return isImported;
    }

    public void setIsImported(String isImported) {
        this.isImported = isImported;
    }

    public String getInputPids() {
        return inputPids;
    }

    public void setInputPids(String inputPids) {
        this.inputPids = inputPids;
    }

    public String getInputStrs() {
        return inputStrs;
    }

    public void setInputStrs(String inputStrs) {
        this.inputStrs = inputStrs;
    }

    public String getHasCheckCode() {
        return hasCheckCode;
    }

    public void setHasCheckCode(String hasCheckCode) {
        this.hasCheckCode = hasCheckCode;
    }

    public String getAdContent() {
        return adContent;
    }

    public void setAdContent(String adContent) {
        this.adContent = adContent;
    }

    public String getListTime() {
        return listTime;
    }

    public void setListTime(String listTime) {
        this.listTime = listTime;
    }
}
