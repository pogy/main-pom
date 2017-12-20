package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：DataDictionaryValue.java
 *@文件路径：com.opentae.data.daifa.beans.DataDictionaryValue
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-09 04:20:30
 *@comments:
 *
 *=========================================================
 */
public class DataDictionaryValue implements Serializable {
	
	/***/
	@Id
@GeneratedValue(generator="JDBC")
	private Long ddvId;
	/**主表ID*/
	private Long ddId;
	/**字典值*/
	private String dataDictionaryValue;
	/**字典值的类型*/
	private String dataDictionaryValueRemark;
	 
	 //*************************get/set*****************************
    	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public Long getDdvId() {
        return ddvId;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setDdvId(Long ddvId) {
        this.ddvId = ddvId;
    }
	/**
  	* 
	*get方法
  	*主表ID
 	*自动生成
  	*/
    public Long getDdId() {
        return ddId;
    }

    /**
  	* 
  	*set方法
	*主表ID
 	*自动生成
  	*/
    public void setDdId(Long ddId) {
        this.ddId = ddId;
    }
	/**
  	* 
	*get方法
  	*字典值
 	*自动生成
  	*/
    public String getDataDictionaryValue() {
        return dataDictionaryValue;
    }

    /**
  	* 
  	*set方法
	*字典值
 	*自动生成
  	*/
    public void setDataDictionaryValue(String dataDictionaryValue) {
        this.dataDictionaryValue = dataDictionaryValue;
    }
	/**
  	* 
	*get方法
  	*字典值的类型
 	*自动生成
  	*/
    public String getDataDictionaryValueRemark() {
        return dataDictionaryValueRemark;
    }

    /**
  	* 
  	*set方法
	*字典值的类型
 	*自动生成
  	*/
    public void setDataDictionaryValueRemark(String dataDictionaryValueRemark) {
        this.dataDictionaryValueRemark = dataDictionaryValueRemark;
    }
}
