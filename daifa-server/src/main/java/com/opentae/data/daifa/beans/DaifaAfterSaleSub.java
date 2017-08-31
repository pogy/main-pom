package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.io.Serializable;

public class DaifaAfterSaleSub implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long afterSaleSubId;

    /**
     * ID
     */
	private Long afterSaleId;

    /**
     * 交易Id
     */
	private Long dfTradeId;

    /**
     * 订单ID
     */
	private Long dfOrderId;

    /**
     * 代发ID
     */
	private Long sellerId;

    /**
     * 代发名称
     */
	private String sellerName;

    /**
     * 发货状态@2已发货
     */
	private Integer sendStatus;

    /**
     * 创建日期@ YYYYMMDD
     */
	private String createDate;

    /**
     * 创建时间
     */
	private Date createTime;

    /**
     * 退货状态@1申请退货2退货入库3退货成功4已结算5退货失败不支持6退货失败发回客户7已退款8退货失败等待发回客户
     */
	private Integer returnStatus;

    /**
     * 换货状态@1申请换货2换货入库3换货成功4换货成功发回客户5换货失败6换货失败已寄回客户7已退款8不支持
     */
	private Integer changeStatus;

    /**
     * 发货日期@ YYYYMMDD
     */
	private String sendDate;

    /**
     * 发货时间
     */
	private Date sendTime;

    /**
     * 寄回的快递名@退换货信息
     */
	private String returnPostNama;

    /**
     * 寄回的快递号@退换货信息
     */
	private String returnPostCode;

    /**
     * 要发回的快递ID
     */
	private Long postId;

    /**
     * 要发回的快递名
     */
	private String postName;

    /**
     * 要发回的快递单号
     */
	private String postCode;

    /**
     * 市场ID
     */
	private Long parentMarketId;

    /**
     * 市场名
     */
	private String parentMarketName;

    /**
     * 楼层Id
     */
	private Long marketId;

    /**
     * 楼层
     */
	private String marketName;

    /**
     * 店铺ID
     */
	private Long storeId;

    /**
     * 档口号
     */
	private String storeNum;

    /**
     * 商品ID
     */
	private Long goodsId;

    /**
     * 商家编码
     */
	private String storeGoodsCode;

    /**
     * 货号
     */
	private String goodsCode;

    /**
     * 标题
     */
	private String title;

    /**
     * 
     */
	private String webSite;

    /**
     * 颜色尺码
     */
	private String propStr;

    /**
     * 图片地址
     */
	private String picPath;

    /**
     * 批发价
     */
	private String singlePiPrice;

    /**
     * 零售价
     */
	private String singlePrice;

    /**
     * 商品数量
     */
	private Integer goodsNum;

    /**
     * 已拿数量
     */
	private Integer hasNum;

    /**
     * 拿货识别码
     */
	private String cdkey;

    /**
     * 淘宝类目ID
     */
	private Long cid;

    /**
     * 淘宝商品id
     */
	private Long goodsNummIid;

    /**
     * 卖家备注
     */
	private String remark;

    /**
     * 买家ID
     */
	private Integer buyerId;

    /**
     * 买家姓名
     */
	private String buyerName;

    /**
     * 买家电话
     */
	private String buyerTelephone;

    /**
     * 买家QQ
     */
	private String buyerQq;

    /**
     * 买家旺旺
     */
	private String buyerWw;

    /**
     * 备用1
     */
	private String remark1;

    /**
     * 备用2
     */
	private String remark2;

    /**
     * 备用3
     */
	private String remark3;

    /**
     * 备用4
     */
	private String remark4;

    /**
     * 备用5
     */
	private String remark5;

    /**
     * 备用6
     */
	private String remark6;

    /**
     * 备用7
     */
	private String remark7;

    /**
     * 备用8
     */
	private String remark8;

    /**
     * 备用9
     */
	private String remark9;

    /**
     * 备用10
     */
	private String remark10;

	public void setAfterSaleSubId(Long afterSaleSubId) {
		this.afterSaleSubId = afterSaleSubId;
	}

	public Long getAfterSaleSubId() {
		return this.afterSaleSubId;
	}

	public void setAfterSaleId(Long afterSaleId) {
		this.afterSaleId = afterSaleId;
	}

	public Long getAfterSaleId() {
		return this.afterSaleId;
	}

	public void setDfTradeId(Long dfTradeId) {
		this.dfTradeId = dfTradeId;
	}

	public Long getDfTradeId() {
		return this.dfTradeId;
	}

	public void setDfOrderId(Long dfOrderId) {
		this.dfOrderId = dfOrderId;
	}

	public Long getDfOrderId() {
		return this.dfOrderId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getSellerId() {
		return this.sellerId;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerName() {
		return this.sellerName;
	}

	public void setSendStatus(Integer sendStatus) {
		this.sendStatus = sendStatus;
	}

	public Integer getSendStatus() {
		return this.sendStatus;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setReturnStatus(Integer returnStatus) {
		this.returnStatus = returnStatus;
	}

	public Integer getReturnStatus() {
		return this.returnStatus;
	}

	public void setChangeStatus(Integer changeStatus) {
		this.changeStatus = changeStatus;
	}

	public Integer getChangeStatus() {
		return this.changeStatus;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public String getSendDate() {
		return this.sendDate;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getSendTime() {
		return this.sendTime;
	}

	public void setReturnPostNama(String returnPostNama) {
		this.returnPostNama = returnPostNama;
	}

	public String getReturnPostNama() {
		return this.returnPostNama;
	}

	public void setReturnPostCode(String returnPostCode) {
		this.returnPostCode = returnPostCode;
	}

	public String getReturnPostCode() {
		return this.returnPostCode;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public Long getPostId() {
		return this.postId;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getPostName() {
		return this.postName;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public void setParentMarketId(Long parentMarketId) {
		this.parentMarketId = parentMarketId;
	}

	public Long getParentMarketId() {
		return this.parentMarketId;
	}

	public void setParentMarketName(String parentMarketName) {
		this.parentMarketName = parentMarketName;
	}

	public String getParentMarketName() {
		return this.parentMarketName;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public Long getMarketId() {
		return this.marketId;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getMarketName() {
		return this.marketName;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getStoreId() {
		return this.storeId;
	}

	public void setStoreNum(String storeNum) {
		this.storeNum = storeNum;
	}

	public String getStoreNum() {
		return this.storeNum;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setStoreGoodsCode(String storeGoodsCode) {
		this.storeGoodsCode = storeGoodsCode;
	}

	public String getStoreGoodsCode() {
		return this.storeGoodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getGoodsCode() {
		return this.goodsCode;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSite() {
		return this.webSite;
	}

	public void setPropStr(String propStr) {
		this.propStr = propStr;
	}

	public String getPropStr() {
		return this.propStr;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getPicPath() {
		return this.picPath;
	}

	public void setSinglePiPrice(String singlePiPrice) {
		this.singlePiPrice = singlePiPrice;
	}

	public String getSinglePiPrice() {
		return this.singlePiPrice;
	}

	public void setSinglePrice(String singlePrice) {
		this.singlePrice = singlePrice;
	}

	public String getSinglePrice() {
		return this.singlePrice;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	public Integer getGoodsNum() {
		return this.goodsNum;
	}

	public void setHasNum(Integer hasNum) {
		this.hasNum = hasNum;
	}

	public Integer getHasNum() {
		return this.hasNum;
	}

	public void setCdkey(String cdkey) {
		this.cdkey = cdkey;
	}

	public String getCdkey() {
		return this.cdkey;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getCid() {
		return this.cid;
	}

	public void setGoodsNummIid(Long goodsNummIid) {
		this.goodsNummIid = goodsNummIid;
	}

	public Long getGoodsNummIid() {
		return this.goodsNummIid;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public Integer getBuyerId() {
		return this.buyerId;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerName() {
		return this.buyerName;
	}

	public void setBuyerTelephone(String buyerTelephone) {
		this.buyerTelephone = buyerTelephone;
	}

	public String getBuyerTelephone() {
		return this.buyerTelephone;
	}

	public void setBuyerQq(String buyerQq) {
		this.buyerQq = buyerQq;
	}

	public String getBuyerQq() {
		return this.buyerQq;
	}

	public void setBuyerWw(String buyerWw) {
		this.buyerWw = buyerWw;
	}

	public String getBuyerWw() {
		return this.buyerWw;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark1() {
		return this.remark1;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark2() {
		return this.remark2;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	public String getRemark3() {
		return this.remark3;
	}

	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	public String getRemark4() {
		return this.remark4;
	}

	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}

	public String getRemark5() {
		return this.remark5;
	}

	public void setRemark6(String remark6) {
		this.remark6 = remark6;
	}

	public String getRemark6() {
		return this.remark6;
	}

	public void setRemark7(String remark7) {
		this.remark7 = remark7;
	}

	public String getRemark7() {
		return this.remark7;
	}

	public void setRemark8(String remark8) {
		this.remark8 = remark8;
	}

	public String getRemark8() {
		return this.remark8;
	}

	public void setRemark9(String remark9) {
		this.remark9 = remark9;
	}

	public String getRemark9() {
		return this.remark9;
	}

	public void setRemark10(String remark10) {
		this.remark10 = remark10;
	}

	public String getRemark10() {
		return this.remark10;
	}

}