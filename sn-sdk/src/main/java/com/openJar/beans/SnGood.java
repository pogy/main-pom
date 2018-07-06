package com.openJar.beans;

import com.openJar.utils.OpenBean;

public class SnGood extends OpenBean {
    //苏宁采购目录编码
    private String categoryCode;
    //苏宁品牌编码
    private String brandCode;
    //商品名，不能与苏宁现有商品重复
    private String productName;
    //商品卖点
    private String sellPoint;
    //运费模板编码
    private String freightTemplateId;
    //商家商品编码
    private String itemCode;
    //主商品价格（含有子商品，不填）
    private String price;
    //主商品库存（含有子商品，不填）
    private String invQty;
    //主商品库存预警
    private String alertQty;
    //商家商品介绍
    private String introduction;
    //售后服务
    private String afterSaleServiceDec;
    //销售设定 1:立即 0：设定日期 2：放入仓库
    private String saleSet;
    //设定为0时  销售日期
    private String saleDate;
    //店铺商品分类ID
    private String assortCode;
    //商品参数 pid:vid;pid:vid;格式
    private String pars;
    //条形码图片地址
    private String barpic;
    //装箱清单 name:value;name:value;格式
    private String packingList;
    //商品标题
    private String cmTitle;
    //竖图
    private String verticalPic;
    //销售渠道 01:线上；10：线下；11：线上线下
    private String sellChannel;
    //价格类型 01:一口价；02：O2O特权定金
    private String priceType;
    //分阶段支付模板
    private String payTemplate;
    //抵扣金额
    private String deductiblePrice;
    //提取方式 01：快递上门；10：电子凭证
    private String extractMode;
    //有效期
    private String effectiveDay;
    //预约到店 0：不支持；1：支持
    private String bookingShop;
    //核销打款 0：不支持；1：支持
    private String wirteoffPayment;
    //过期自动退款 0：不支持 1：支持
    private String autoRefund;
    //售中退款(0:不支持 1:支持)
    private String insaleRefund;
    //核销门店组
    private String wirteoffShop;
    //商品视频编码
    private String videoCode;
    //主图视频编码
    private String mainPicVideoCode;

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public String getFreightTemplateId() {
        return freightTemplateId;
    }

    public void setFreightTemplateId(String freightTemplateId) {
        this.freightTemplateId = freightTemplateId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getInvQty() {
        return invQty;
    }

    public void setInvQty(String invQty) {
        this.invQty = invQty;
    }

    public String getAlertQty() {
        return alertQty;
    }

    public void setAlertQty(String alertQty) {
        this.alertQty = alertQty;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAfterSaleServiceDec() {
        return afterSaleServiceDec;
    }

    public void setAfterSaleServiceDec(String afterSaleServiceDec) {
        this.afterSaleServiceDec = afterSaleServiceDec;
    }

    public String getSaleSet() {
        return saleSet;
    }

    public void setSaleSet(String saleSet) {
        this.saleSet = saleSet;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public String getAssortCode() {
        return assortCode;
    }

    public void setAssortCode(String assortCode) {
        this.assortCode = assortCode;
    }

    public String getPars() {
        return pars;
    }

    public void setPars(String pars) {
        this.pars = pars;
    }

    public String getBarpic() {
        return barpic;
    }

    public void setBarpic(String barpic) {
        this.barpic = barpic;
    }

    public String getPackingList() {
        return packingList;
    }

    public void setPackingList(String packingList) {
        this.packingList = packingList;
    }

    public String getCmTitle() {
        return cmTitle;
    }

    public void setCmTitle(String cmTitle) {
        this.cmTitle = cmTitle;
    }

    public String getVerticalPic() {
        return verticalPic;
    }

    public void setVerticalPic(String verticalPic) {
        this.verticalPic = verticalPic;
    }

    public String getSellChannel() {
        return sellChannel;
    }

    public void setSellChannel(String sellChannel) {
        this.sellChannel = sellChannel;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public String getPayTemplate() {
        return payTemplate;
    }

    public void setPayTemplate(String payTemplate) {
        this.payTemplate = payTemplate;
    }

    public String getDeductiblePrice() {
        return deductiblePrice;
    }

    public void setDeductiblePrice(String deductiblePrice) {
        this.deductiblePrice = deductiblePrice;
    }

    public String getExtractMode() {
        return extractMode;
    }

    public void setExtractMode(String extractMode) {
        this.extractMode = extractMode;
    }

    public String getEffectiveDay() {
        return effectiveDay;
    }

    public void setEffectiveDay(String effectiveDay) {
        this.effectiveDay = effectiveDay;
    }

    public String getBookingShop() {
        return bookingShop;
    }

    public void setBookingShop(String bookingShop) {
        this.bookingShop = bookingShop;
    }

    public String getWirteoffPayment() {
        return wirteoffPayment;
    }

    public void setWirteoffPayment(String wirteoffPayment) {
        this.wirteoffPayment = wirteoffPayment;
    }

    public String getAutoRefund() {
        return autoRefund;
    }

    public void setAutoRefund(String autoRefund) {
        this.autoRefund = autoRefund;
    }

    public String getInsaleRefund() {
        return insaleRefund;
    }

    public void setInsaleRefund(String insaleRefund) {
        this.insaleRefund = insaleRefund;
    }

    public String getWirteoffShop() {
        return wirteoffShop;
    }

    public void setWirteoffShop(String wirteoffShop) {
        this.wirteoffShop = wirteoffShop;
    }

    public String getVideoCode() {
        return videoCode;
    }

    public void setVideoCode(String videoCode) {
        this.videoCode = videoCode;
    }

    public String getMainPicVideoCode() {
        return mainPicVideoCode;
    }

    public void setMainPicVideoCode(String mainPicVideoCode) {
        this.mainPicVideoCode = mainPicVideoCode;
    }
}
