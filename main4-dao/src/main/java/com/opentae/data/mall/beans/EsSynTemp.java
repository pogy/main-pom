package com.opentae.data.mall.beans;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
/**
 *@author 自动生成
 *@see EsSynTemp
 *@docRoot com.opentae.data.mall.beans.EsSynTemp
 *@remark 自动生成
 *生成日期：2017-03-27 11:17:24
 *完成日期：
 *内容摘要：
 *
 */
public class EsSynTemp {

	/***/
	@Id
@GeneratedValue(generator="JDBC")
	private java.lang.Long tempId;
	/**最后执行的ID*/
	private java.lang.Long synId;
	/**1:商品,2:下架商品*/
	private java.lang.Integer synType;
	/***/
	private java.lang.String webSite;

	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public java.lang.Long getTempId() {
        return tempId;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setTempId(java.lang.Long tempId) {
        this.tempId = tempId;
    }
	/**
  	* 
	*get方法
  	*最后执行的ID
 	*自动生成
  	*/
    public java.lang.Long getSynId() {
        return synId;
    }

    /**
  	* 
  	*set方法
	*最后执行的ID
 	*自动生成
  	*/
    public void setSynId(java.lang.Long synId) {
        this.synId = synId;
    }
	/**
  	* 
	*get方法
  	*1:商品,2:下架商品
 	*自动生成
  	*/
    public java.lang.Integer getSynType() {
        return synType;
    }

    /**
  	* 
  	*set方法
	*1:商品,2:下架商品
 	*自动生成
  	*/
    public void setSynType(java.lang.Integer synType) {
        this.synType = synType;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public java.lang.String getWebSite() {
        return webSite;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setWebSite(java.lang.String webSite) {
        this.webSite = webSite;
    }
}
