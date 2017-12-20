package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：DaifaSendOrder.java
 *@文件路径：com.opentae.data.daifa.beans.DaifaSendOrder
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-09 04:19:32
 *@comments:
 *
 *=========================================================
 */
public class DaifaSendOrder implements Serializable {
	
	/**ID*/
	@Id
@GeneratedValue(generator="JDBC")
	private Long sendoId;
	/**ID*/
	private Long sendId;
	/**拿货清单ID@统一打款编码: nh{日期}_{拿货人ID}_次数,已分配的时候才会有,,拿货人ID指拿货人的account账户ID，可以根据拿货人的支付宝账户,由分配表里来（如果由当天拿到的就要有这个值）日期格式为yyyyMMdd*/
	private String ggoodsCode;
	/**交易Id*/
	private Long dfTradeId;
	/**订单ID*/
	private Long dfOrderId;
	/**代发ID*/
	private Long sellerId;
	/**拿货人ID@从daifa_worker中取得(原拿货人ID)*/
	private Long daifaWorkerId;
	/**拿货人@从daifa_worker中取得(原拿货人ID)*/
	private String daifaWorker;
	/**发货状态@2已发货*/
	private Integer sendStatus;
	/**退款状态@0基本状态1待退款2已退款*/
	private Integer refundStatus;
	/**有货状态@2有货3缺货*/
	private Integer takeGoodsStatus;
	/**创建日期@ YYYYMMDD*/
	private String createDate;
	/**创建时间*/
	private java.util.Date createTime;
	/**市场ID*/
	private Long marketId;
	/**市场名*/
	private String marketName;
	/**楼层Id*/
	private Long floorId;
	/**楼层*/
	private String floorName;
	/**店铺ID*/
	private Long storeId;
	/**档口号*/
	private String storeNum;
	/**商品ID*/
	private Long goodsId;
	/**货号*/
	private String goodsCode;
	/**商家编码*/
	private String storeGoodsCode;
	/**标题*/
	private String title;
	/**站点*/
	private String webSite;
	/**颜色尺码*/
	private String propStr;
	/**图片地址*/
	private String picPath;
	/**批发价*/
	private String singlePiPrice;
	/**零售价*/
	private String singlePrice;
	/**商品数量*/
	private Integer goodsNum;
	/**拿货识别码*/
	private String cdkey;
	/**子订单ID*/
	private String orderCode;
	/**礼品类型@礼物用gift*/
	private String giftCode;
	/**外部退货单号*/
	private Long refundId;
	/**卖家备注*/
	private String remark;
	/**备用1*/
	private String remark1;
	/**备用2*/
	private String remark2;
	/**已拿数量*/
	private Integer hasNum;
	/**淘宝类目ID*/
	private Long cid;
	/**淘宝商品id*/
	private Long goodsNummiid;
	/**缺货处理协议@1有货先发2缺货不发*/
	private Integer aggrement;
	 
	 //*************************get/set*****************************
    	/**
  	* 
	*get方法
  	*ID
 	*自动生成
  	*/
    public Long getSendoId() {
        return sendoId;
    }

    /**
  	* 
  	*set方法
	*ID
 	*自动生成
  	*/
    public void setSendoId(Long sendoId) {
        this.sendoId = sendoId;
    }
	/**
  	* 
	*get方法
  	*ID
 	*自动生成
  	*/
    public Long getSendId() {
        return sendId;
    }

    /**
  	* 
  	*set方法
	*ID
 	*自动生成
  	*/
    public void setSendId(Long sendId) {
        this.sendId = sendId;
    }
	/**
  	* 
	*get方法
  	*拿货清单ID@统一打款编码: nh{日期}_{拿货人ID}_次数,已分配的时候才会有,,拿货人ID指拿货人的account账户ID，可以根据拿货人的支付宝账户,由分配表里来（如果由当天拿到的就要有这个值）日期格式为yyyyMMdd
 	*自动生成
  	*/
    public String getGgoodsCode() {
        return ggoodsCode;
    }

    /**
  	* 
  	*set方法
	*拿货清单ID@统一打款编码: nh{日期}_{拿货人ID}_次数,已分配的时候才会有,,拿货人ID指拿货人的account账户ID，可以根据拿货人的支付宝账户,由分配表里来（如果由当天拿到的就要有这个值）日期格式为yyyyMMdd
 	*自动生成
  	*/
    public void setGgoodsCode(String ggoodsCode) {
        this.ggoodsCode = ggoodsCode;
    }
	/**
  	* 
	*get方法
  	*交易Id
 	*自动生成
  	*/
    public Long getDfTradeId() {
        return dfTradeId;
    }

    /**
  	* 
  	*set方法
	*交易Id
 	*自动生成
  	*/
    public void setDfTradeId(Long dfTradeId) {
        this.dfTradeId = dfTradeId;
    }
	/**
  	* 
	*get方法
  	*订单ID
 	*自动生成
  	*/
    public Long getDfOrderId() {
        return dfOrderId;
    }

    /**
  	* 
  	*set方法
	*订单ID
 	*自动生成
  	*/
    public void setDfOrderId(Long dfOrderId) {
        this.dfOrderId = dfOrderId;
    }
	/**
  	* 
	*get方法
  	*代发ID
 	*自动生成
  	*/
    public Long getSellerId() {
        return sellerId;
    }

    /**
  	* 
  	*set方法
	*代发ID
 	*自动生成
  	*/
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
	/**
  	* 
	*get方法
  	*拿货人ID@从daifa_worker中取得(原拿货人ID)
 	*自动生成
  	*/
    public Long getDaifaWorkerId() {
        return daifaWorkerId;
    }

    /**
  	* 
  	*set方法
	*拿货人ID@从daifa_worker中取得(原拿货人ID)
 	*自动生成
  	*/
    public void setDaifaWorkerId(Long daifaWorkerId) {
        this.daifaWorkerId = daifaWorkerId;
    }
	/**
  	* 
	*get方法
  	*拿货人@从daifa_worker中取得(原拿货人ID)
 	*自动生成
  	*/
    public String getDaifaWorker() {
        return daifaWorker;
    }

    /**
  	* 
  	*set方法
	*拿货人@从daifa_worker中取得(原拿货人ID)
 	*自动生成
  	*/
    public void setDaifaWorker(String daifaWorker) {
        this.daifaWorker = daifaWorker;
    }
	/**
  	* 
	*get方法
  	*发货状态@2已发货
 	*自动生成
  	*/
    public Integer getSendStatus() {
        return sendStatus;
    }

    /**
  	* 
  	*set方法
	*发货状态@2已发货
 	*自动生成
  	*/
    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }
	/**
  	* 
	*get方法
  	*退款状态@0基本状态1待退款2已退款
 	*自动生成
  	*/
    public Integer getRefundStatus() {
        return refundStatus;
    }

    /**
  	* 
  	*set方法
	*退款状态@0基本状态1待退款2已退款
 	*自动生成
  	*/
    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }
	/**
  	* 
	*get方法
  	*有货状态@2有货3缺货
 	*自动生成
  	*/
    public Integer getTakeGoodsStatus() {
        return takeGoodsStatus;
    }

    /**
  	* 
  	*set方法
	*有货状态@2有货3缺货
 	*自动生成
  	*/
    public void setTakeGoodsStatus(Integer takeGoodsStatus) {
        this.takeGoodsStatus = takeGoodsStatus;
    }
	/**
  	* 
	*get方法
  	*创建日期@ YYYYMMDD
 	*自动生成
  	*/
    public String getCreateDate() {
        return createDate;
    }

    /**
  	* 
  	*set方法
	*创建日期@ YYYYMMDD
 	*自动生成
  	*/
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
	/**
  	* 
	*get方法
  	*创建时间
 	*自动生成
  	*/
    public java.util.Date getCreateTime() {
        return createTime;
    }

    /**
  	* 
  	*set方法
	*创建时间
 	*自动生成
  	*/
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
	/**
  	* 
	*get方法
  	*市场ID
 	*自动生成
  	*/
    public Long getMarketId() {
        return marketId;
    }

    /**
  	* 
  	*set方法
	*市场ID
 	*自动生成
  	*/
    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }
	/**
  	* 
	*get方法
  	*市场名
 	*自动生成
  	*/
    public String getMarketName() {
        return marketName;
    }

    /**
  	* 
  	*set方法
	*市场名
 	*自动生成
  	*/
    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }
	/**
  	* 
	*get方法
  	*楼层Id
 	*自动生成
  	*/
    public Long getFloorId() {
        return floorId;
    }

    /**
  	* 
  	*set方法
	*楼层Id
 	*自动生成
  	*/
    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }
	/**
  	* 
	*get方法
  	*楼层
 	*自动生成
  	*/
    public String getFloorName() {
        return floorName;
    }

    /**
  	* 
  	*set方法
	*楼层
 	*自动生成
  	*/
    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }
	/**
  	* 
	*get方法
  	*店铺ID
 	*自动生成
  	*/
    public Long getStoreId() {
        return storeId;
    }

    /**
  	* 
  	*set方法
	*店铺ID
 	*自动生成
  	*/
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
	/**
  	* 
	*get方法
  	*档口号
 	*自动生成
  	*/
    public String getStoreNum() {
        return storeNum;
    }

    /**
  	* 
  	*set方法
	*档口号
 	*自动生成
  	*/
    public void setStoreNum(String storeNum) {
        this.storeNum = storeNum;
    }
	/**
  	* 
	*get方法
  	*商品ID
 	*自动生成
  	*/
    public Long getGoodsId() {
        return goodsId;
    }

    /**
  	* 
  	*set方法
	*商品ID
 	*自动生成
  	*/
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
	/**
  	* 
	*get方法
  	*货号
 	*自动生成
  	*/
    public String getGoodsCode() {
        return goodsCode;
    }

    /**
  	* 
  	*set方法
	*货号
 	*自动生成
  	*/
    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }
	/**
  	* 
	*get方法
  	*商家编码
 	*自动生成
  	*/
    public String getStoreGoodsCode() {
        return storeGoodsCode;
    }

    /**
  	* 
  	*set方法
	*商家编码
 	*自动生成
  	*/
    public void setStoreGoodsCode(String storeGoodsCode) {
        this.storeGoodsCode = storeGoodsCode;
    }
	/**
  	* 
	*get方法
  	*标题
 	*自动生成
  	*/
    public String getTitle() {
        return title;
    }

    /**
  	* 
  	*set方法
	*标题
 	*自动生成
  	*/
    public void setTitle(String title) {
        this.title = title;
    }
	/**
  	* 
	*get方法
  	*站点
 	*自动生成
  	*/
    public String getWebSite() {
        return webSite;
    }

    /**
  	* 
  	*set方法
	*站点
 	*自动生成
  	*/
    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
	/**
  	* 
	*get方法
  	*颜色尺码
 	*自动生成
  	*/
    public String getPropStr() {
        return propStr;
    }

    /**
  	* 
  	*set方法
	*颜色尺码
 	*自动生成
  	*/
    public void setPropStr(String propStr) {
        this.propStr = propStr;
    }
	/**
  	* 
	*get方法
  	*图片地址
 	*自动生成
  	*/
    public String getPicPath() {
        return picPath;
    }

    /**
  	* 
  	*set方法
	*图片地址
 	*自动生成
  	*/
    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
	/**
  	* 
	*get方法
  	*批发价
 	*自动生成
  	*/
    public String getSinglePiPrice() {
        return singlePiPrice;
    }

    /**
  	* 
  	*set方法
	*批发价
 	*自动生成
  	*/
    public void setSinglePiPrice(String singlePiPrice) {
        this.singlePiPrice = singlePiPrice;
    }
	/**
  	* 
	*get方法
  	*零售价
 	*自动生成
  	*/
    public String getSinglePrice() {
        return singlePrice;
    }

    /**
  	* 
  	*set方法
	*零售价
 	*自动生成
  	*/
    public void setSinglePrice(String singlePrice) {
        this.singlePrice = singlePrice;
    }
	/**
  	* 
	*get方法
  	*商品数量
 	*自动生成
  	*/
    public Integer getGoodsNum() {
        return goodsNum;
    }

    /**
  	* 
  	*set方法
	*商品数量
 	*自动生成
  	*/
    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }
	/**
  	* 
	*get方法
  	*拿货识别码
 	*自动生成
  	*/
    public String getCdkey() {
        return cdkey;
    }

    /**
  	* 
  	*set方法
	*拿货识别码
 	*自动生成
  	*/
    public void setCdkey(String cdkey) {
        this.cdkey = cdkey;
    }
	/**
  	* 
	*get方法
  	*子订单ID
 	*自动生成
  	*/
    public String getOrderCode() {
        return orderCode;
    }

    /**
  	* 
  	*set方法
	*子订单ID
 	*自动生成
  	*/
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
	/**
  	* 
	*get方法
  	*礼品类型@礼物用gift
 	*自动生成
  	*/
    public String getGiftCode() {
        return giftCode;
    }

    /**
  	* 
  	*set方法
	*礼品类型@礼物用gift
 	*自动生成
  	*/
    public void setGiftCode(String giftCode) {
        this.giftCode = giftCode;
    }
	/**
  	* 
	*get方法
  	*外部退货单号
 	*自动生成
  	*/
    public Long getRefundId() {
        return refundId;
    }

    /**
  	* 
  	*set方法
	*外部退货单号
 	*自动生成
  	*/
    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }
	/**
  	* 
	*get方法
  	*卖家备注
 	*自动生成
  	*/
    public String getRemark() {
        return remark;
    }

    /**
  	* 
  	*set方法
	*卖家备注
 	*自动生成
  	*/
    public void setRemark(String remark) {
        this.remark = remark;
    }
	/**
  	* 
	*get方法
  	*备用1
 	*自动生成
  	*/
    public String getRemark1() {
        return remark1;
    }

    /**
  	* 
  	*set方法
	*备用1
 	*自动生成
  	*/
    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }
	/**
  	* 
	*get方法
  	*备用2
 	*自动生成
  	*/
    public String getRemark2() {
        return remark2;
    }

    /**
  	* 
  	*set方法
	*备用2
 	*自动生成
  	*/
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }
	/**
  	* 
	*get方法
  	*已拿数量
 	*自动生成
  	*/
    public Integer getHasNum() {
        return hasNum;
    }

    /**
  	* 
  	*set方法
	*已拿数量
 	*自动生成
  	*/
    public void setHasNum(Integer hasNum) {
        this.hasNum = hasNum;
    }
	/**
  	* 
	*get方法
  	*淘宝类目ID
 	*自动生成
  	*/
    public Long getCid() {
        return cid;
    }

    /**
  	* 
  	*set方法
	*淘宝类目ID
 	*自动生成
  	*/
    public void setCid(Long cid) {
        this.cid = cid;
    }
	/**
  	* 
	*get方法
  	*淘宝商品id
 	*自动生成
  	*/
    public Long getGoodsNummiid() {
        return goodsNummiid;
    }

    /**
  	* 
  	*set方法
	*淘宝商品id
 	*自动生成
  	*/
    public void setGoodsNummiid(Long goodsNummiid) {
        this.goodsNummiid = goodsNummiid;
    }
	/**
  	* 
	*get方法
  	*缺货处理协议@1有货先发2缺货不发
 	*自动生成
  	*/
    public Integer getAggrement() {
        return aggrement;
    }

    /**
  	* 
  	*set方法
	*缺货处理协议@1有货先发2缺货不发
 	*自动生成
  	*/
    public void setAggrement(Integer aggrement) {
        this.aggrement = aggrement;
    }
}
