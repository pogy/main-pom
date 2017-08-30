package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：CountTrans.java
 *@文件路径：com.opentae.data.daifa.beans.CountTrans
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-11 02:07:47
 *@comments:
 *
 *=========================================================
 */
public class CountTrans implements Serializable {
	
	/***/
	@Id
@GeneratedValue(generator="JDBC")
	private Long id;
	/**最后展示*/
	private String finalShow;
	/**最后展示数字*/
	private Long finalNumber;
	/**创建日期*/
	private String createDate;
	/**创建时间*/
	private java.util.Date createTime;
	/**应用情形*/
	private String useSituation;
	/**当天第几批次*/
	private Integer batch;
	 
	 //*************************get/set*****************************
    	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public Long getId() {
        return id;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setId(Long id) {
        this.id = id;
    }
	/**
  	* 
	*get方法
  	*最后展示
 	*自动生成
  	*/
    public String getFinalShow() {
        return finalShow;
    }

    /**
  	* 
  	*set方法
	*最后展示
 	*自动生成
  	*/
    public void setFinalShow(String finalShow) {
        this.finalShow = finalShow;
    }
	/**
  	* 
	*get方法
  	*最后展示数字
 	*自动生成
  	*/
    public Long getFinalNumber() {
        return finalNumber;
    }

    /**
  	* 
  	*set方法
	*最后展示数字
 	*自动生成
  	*/
    public void setFinalNumber(Long finalNumber) {
        this.finalNumber = finalNumber;
    }
	/**
  	* 
	*get方法
  	*创建日期
 	*自动生成
  	*/
    public String getCreateDate() {
        return createDate;
    }

    /**
  	* 
  	*set方法
	*创建日期
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
  	*应用情形
 	*自动生成
  	*/
    public String getUseSituation() {
        return useSituation;
    }

    /**
  	* 
  	*set方法
	*应用情形
 	*自动生成
  	*/
    public void setUseSituation(String useSituation) {
        this.useSituation = useSituation;
    }
	/**
  	* 
	*get方法
  	*当天第几批次
 	*自动生成
  	*/
    public Integer getBatch() {
        return batch;
    }

    /**
  	* 
  	*set方法
	*当天第几批次
 	*自动生成
  	*/
    public void setBatch(Integer batch) {
        this.batch = batch;
    }
}
