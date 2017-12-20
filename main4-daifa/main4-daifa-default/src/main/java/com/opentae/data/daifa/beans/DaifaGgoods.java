package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：DaifaGgoods.java
 *@文件路径：com.opentae.data.daifa.beans.DaifaGgoods
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-09 04:19:03
 *@comments:
 *
 *=========================================================
 */
public class DaifaGgoods implements Serializable {
	
	/**ID*/
	@Id
@GeneratedValue(generator="JDBC")
	private Long takeGoodsId;
	/**拿货清单ID@统一打款编码: nh{日期}_{拿货人ID}_次数,已分配的时候才会有,拿货人ID指拿货人的account账户ID，可以根据拿货人的支付宝账户,日期格式为yyyyMMdd*/
	private String ggoodsCode;
	/**代发机构ID*/
	private Long sellerId;
	/**拿货人ID@从daifa_worker中取得(原拿货人ID)*/
	private Long daifaWorkerId;
	/**拿货人@从daifa_worker中取得(原拿货人ID)*/
	private String daifaWorker;
	/**创建日期@ YYYYMMDD*/
	private String createDate;
	/**创建时间*/
	private java.util.Date createTime;
	/**拿到货的日期@ YYYYMMDD*/
	private String takeGoodsDate;
	/**拿到货的时间*/
	private java.util.Date takeGoodsTime;
	/**代发ID*/
	private Long dfTradeId;
	/**子订单ID@从daifa_order中获得*/
	private Long dfOrderId;
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
	/**批发价@单位元*/
	private String singlePiPrice;
	/**零售价@单位元*/
	private String singlePrice;
	/**真实拿货价@单位元*/
	private String realTakePrice;
	/**商品数量*/
	private Integer goodsNum;
	/**拿货状态@1未拿2已拿3缺货（默认为1）*/
	private Integer takeGoodsStatus;
	/**退款状态@0非退款状态1申请退款2已退款（默认为0）*/
	private Integer returnStatus;
	/**状态@1可用0不可用（默认为1）*/
	private Integer useStatus;
	/**每天第几次打印@YYYYMMdd_n*/
	private String printBatch;
	/**拿货条码打印状态@1未打印2已打印（默认为1）*/
	private Integer printBarcodeStatus;
	/**拿货识别码*/
	private String cdkey;
	/***/
	private String remark;
	/**是否下架@0可售1下架*/
	private Integer delistIs;
	/**是否操作过@1已经操作过*/
	private Integer operateIs;
	/**缺货原因*/
	private String stockoutReason;
	/**退款原因*/
	private String refundReason;
	/**有货日期*/
	private java.util.Date youhuoDate;
	/**礼品类型*/
	private String giftCode;
	/**退款外部ID*/
	private Long refundId;
	/**备用1*/
	private String remark1;
	/**备用2*/
	private String remark2;
	 
	 //*************************get/set*****************************
    	/**
  	* 
	*get方法
  	*ID
 	*自动生成
  	*/
    public Long getTakeGoodsId() {
        return takeGoodsId;
    }

    /**
  	* 
  	*set方法
	*ID
 	*自动生成
  	*/
    public void setTakeGoodsId(Long takeGoodsId) {
        this.takeGoodsId = takeGoodsId;
    }
	/**
  	* 
	*get方法
  	*拿货清单ID@统一打款编码: nh{日期}_{拿货人ID}_次数,已分配的时候才会有,拿货人ID指拿货人的account账户ID，可以根据拿货人的支付宝账户,日期格式为yyyyMMdd
 	*自动生成
  	*/
    public String getGgoodsCode() {
        return ggoodsCode;
    }

    /**
  	* 
  	*set方法
	*拿货清单ID@统一打款编码: nh{日期}_{拿货人ID}_次数,已分配的时候才会有,拿货人ID指拿货人的account账户ID，可以根据拿货人的支付宝账户,日期格式为yyyyMMdd
 	*自动生成
  	*/
    public void setGgoodsCode(String ggoodsCode) {
        this.ggoodsCode = ggoodsCode;
    }
	/**
  	* 
	*get方法
  	*代发机构ID
 	*自动生成
  	*/
    public Long getSellerId() {
        return sellerId;
    }

    /**
  	* 
  	*set方法
	*代发机构ID
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
  	*拿到货的日期@ YYYYMMDD
 	*自动生成
  	*/
    public String getTakeGoodsDate() {
        return takeGoodsDate;
    }

    /**
  	* 
  	*set方法
	*拿到货的日期@ YYYYMMDD
 	*自动生成
  	*/
    public void setTakeGoodsDate(String takeGoodsDate) {
        this.takeGoodsDate = takeGoodsDate;
    }
	/**
  	* 
	*get方法
  	*拿到货的时间
 	*自动生成
  	*/
    public java.util.Date getTakeGoodsTime() {
        return takeGoodsTime;
    }

    /**
  	* 
  	*set方法
	*拿到货的时间
 	*自动生成
  	*/
    public void setTakeGoodsTime(java.util.Date takeGoodsTime) {
        this.takeGoodsTime = takeGoodsTime;
    }
	/**
  	* 
	*get方法
  	*代发ID
 	*自动生成
  	*/
    public Long getDfTradeId() {
        return dfTradeId;
    }

    /**
  	* 
  	*set方法
	*代发ID
 	*自动生成
  	*/
    public void setDfTradeId(Long dfTradeId) {
        this.dfTradeId = dfTradeId;
    }
	/**
  	* 
	*get方法
  	*子订单ID@从daifa_order中获得
 	*自动生成
  	*/
    public Long getDfOrderId() {
        return dfOrderId;
    }

    /**
  	* 
  	*set方法
	*子订单ID@从daifa_order中获得
 	*自动生成
  	*/
    public void setDfOrderId(Long dfOrderId) {
        this.dfOrderId = dfOrderId;
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
  	*批发价@单位元
 	*自动生成
  	*/
    public String getSinglePiPrice() {
        return singlePiPrice;
    }

    /**
  	* 
  	*set方法
	*批发价@单位元
 	*自动生成
  	*/
    public void setSinglePiPrice(String singlePiPrice) {
        this.singlePiPrice = singlePiPrice;
    }
	/**
  	* 
	*get方法
  	*零售价@单位元
 	*自动生成
  	*/
    public String getSinglePrice() {
        return singlePrice;
    }

    /**
  	* 
  	*set方法
	*零售价@单位元
 	*自动生成
  	*/
    public void setSinglePrice(String singlePrice) {
        this.singlePrice = singlePrice;
    }
	/**
  	* 
	*get方法
  	*真实拿货价@单位元
 	*自动生成
  	*/
    public String getRealTakePrice() {
        return realTakePrice;
    }

    /**
  	* 
  	*set方法
	*真实拿货价@单位元
 	*自动生成
  	*/
    public void setRealTakePrice(String realTakePrice) {
        this.realTakePrice = realTakePrice;
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
  	*拿货状态@1未拿2已拿3缺货（默认为1）
 	*自动生成
  	*/
    public Integer getTakeGoodsStatus() {
        return takeGoodsStatus;
    }

    /**
  	* 
  	*set方法
	*拿货状态@1未拿2已拿3缺货（默认为1）
 	*自动生成
  	*/
    public void setTakeGoodsStatus(Integer takeGoodsStatus) {
        this.takeGoodsStatus = takeGoodsStatus;
    }
	/**
  	* 
	*get方法
  	*退款状态@0非退款状态1申请退款2已退款（默认为0）
 	*自动生成
  	*/
    public Integer getReturnStatus() {
        return returnStatus;
    }

    /**
  	* 
  	*set方法
	*退款状态@0非退款状态1申请退款2已退款（默认为0）
 	*自动生成
  	*/
    public void setReturnStatus(Integer returnStatus) {
        this.returnStatus = returnStatus;
    }
	/**
  	* 
	*get方法
  	*状态@1可用0不可用（默认为1）
 	*自动生成
  	*/
    public Integer getUseStatus() {
        return useStatus;
    }

    /**
  	* 
  	*set方法
	*状态@1可用0不可用（默认为1）
 	*自动生成
  	*/
    public void setUseStatus(Integer useStatus) {
        this.useStatus = useStatus;
    }
	/**
  	* 
	*get方法
  	*每天第几次打印@YYYYMMdd_n
 	*自动生成
  	*/
    public String getPrintBatch() {
        return printBatch;
    }

    /**
  	* 
  	*set方法
	*每天第几次打印@YYYYMMdd_n
 	*自动生成
  	*/
    public void setPrintBatch(String printBatch) {
        this.printBatch = printBatch;
    }
	/**
  	* 
	*get方法
  	*拿货条码打印状态@1未打印2已打印（默认为1）
 	*自动生成
  	*/
    public Integer getPrintBarcodeStatus() {
        return printBarcodeStatus;
    }

    /**
  	* 
  	*set方法
	*拿货条码打印状态@1未打印2已打印（默认为1）
 	*自动生成
  	*/
    public void setPrintBarcodeStatus(Integer printBarcodeStatus) {
        this.printBarcodeStatus = printBarcodeStatus;
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
  	*
 	*自动生成
  	*/
    public String getRemark() {
        return remark;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setRemark(String remark) {
        this.remark = remark;
    }
	/**
  	* 
	*get方法
  	*是否下架@0可售1下架
 	*自动生成
  	*/
    public Integer getDelistIs() {
        return delistIs;
    }

    /**
  	* 
  	*set方法
	*是否下架@0可售1下架
 	*自动生成
  	*/
    public void setDelistIs(Integer delistIs) {
        this.delistIs = delistIs;
    }
	/**
  	* 
	*get方法
  	*是否操作过@1已经操作过
 	*自动生成
  	*/
    public Integer getOperateIs() {
        return operateIs;
    }

    /**
  	* 
  	*set方法
	*是否操作过@1已经操作过
 	*自动生成
  	*/
    public void setOperateIs(Integer operateIs) {
        this.operateIs = operateIs;
    }
	/**
  	* 
	*get方法
  	*缺货原因
 	*自动生成
  	*/
    public String getStockoutReason() {
        return stockoutReason;
    }

    /**
  	* 
  	*set方法
	*缺货原因
 	*自动生成
  	*/
    public void setStockoutReason(String stockoutReason) {
        this.stockoutReason = stockoutReason;
    }
	/**
  	* 
	*get方法
  	*退款原因
 	*自动生成
  	*/
    public String getRefundReason() {
        return refundReason;
    }

    /**
  	* 
  	*set方法
	*退款原因
 	*自动生成
  	*/
    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }
	/**
  	* 
	*get方法
  	*有货日期
 	*自动生成
  	*/
    public java.util.Date getYouhuoDate() {
        return youhuoDate;
    }

    /**
  	* 
  	*set方法
	*有货日期
 	*自动生成
  	*/
    public void setYouhuoDate(java.util.Date youhuoDate) {
        this.youhuoDate = youhuoDate;
    }
	/**
  	* 
	*get方法
  	*礼品类型
 	*自动生成
  	*/
    public String getGiftCode() {
        return giftCode;
    }

    /**
  	* 
  	*set方法
	*礼品类型
 	*自动生成
  	*/
    public void setGiftCode(String giftCode) {
        this.giftCode = giftCode;
    }
	/**
  	* 
	*get方法
  	*退款外部ID
 	*自动生成
  	*/
    public Long getRefundId() {
        return refundId;
    }

    /**
  	* 
  	*set方法
	*退款外部ID
 	*自动生成
  	*/
    public void setRefundId(Long refundId) {
        this.refundId = refundId;
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
}
