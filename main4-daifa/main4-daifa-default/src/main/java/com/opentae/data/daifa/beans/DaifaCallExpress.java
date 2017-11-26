package com.opentae.data.daifa.beans;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;
import java.io.Serializable;
/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：DaifaCallExpress.java
 *@文件路径：com.opentae.data.xzOrder.beans.DaifaCallExpress
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-09 05:46:03
 *@comments:
 *
 *=========================================================
 */
public class DaifaCallExpress implements Serializable{
	
	/**代发订单ID*/
	@Id
@GeneratedValue(generator="JDBC")
	private Long dfTradeId;
	/**代发机构ID*/
	private Long sellerId;
	/**快递ID*/
	private Long expressId;
	/**快递单号*/
	private String expressCode;
	/**三段码*/
	private String markDestination;
	/**集包地*/
	private String packageName;

	private String packageCode;//集包码

	//private String packageCode;//集包编码
	/**调用快递鸟回来的所有数据的json格式*/
	private String jsonData;
	/**创建时间*/
	private java.util.Date createTime;
	 
	 //*************************get/set*****************************
    	/**
  	* 
	*get方法
  	*代发订单ID
 	*自动生成
  	*/
    public Long getDfTradeId() {
        return dfTradeId;
    }

    /**
  	* 
  	*set方法
	*代发订单ID
 	*自动生成
  	*/
    public void setDfTradeId(Long dfTradeId) {
        this.dfTradeId = dfTradeId;
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
  	*快递ID
 	*自动生成
  	*/
    public Long getExpressId() {
        return expressId;
    }

    /**
  	* 
  	*set方法
	*快递ID
 	*自动生成
  	*/
    public void setExpressId(Long expressId) {
        this.expressId = expressId;
    }
	/**
  	* 
	*get方法
  	*快递单号
 	*自动生成
  	*/
    public String getExpressCode() {
        return expressCode;
    }

    /**
  	* 
  	*set方法
	*快递单号
 	*自动生成
  	*/
    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }
	/**
  	* 
	*get方法
  	*三段码
 	*自动生成
  	*/
    public String getMarkDestination() {
        return markDestination;
    }

    /**
  	* 
  	*set方法
	*三段码
 	*自动生成
  	*/
    public void setMarkDestination(String markDestination) {
        this.markDestination = markDestination;
    }
	/**
  	* 
	*get方法
  	*集包地
 	*自动生成
  	*/
    public String getPackageName() {
        return packageName;
    }

    /**
  	* 
  	*set方法
	*集包地
 	*自动生成
  	*/
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
	/**
  	* 
	*get方法
  	*调用快递鸟回来的所有数据的json格式
 	*自动生成
  	*/
    public String getJsonData() {
        return jsonData;
    }

    /**
  	* 
  	*set方法
	*调用快递鸟回来的所有数据的json格式
 	*自动生成
  	*/
    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
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

	public String getPackageCode () {
		return packageCode;
	}

	public void setPackageCode (String packageCode) {
		this.packageCode = packageCode;
	}
}
