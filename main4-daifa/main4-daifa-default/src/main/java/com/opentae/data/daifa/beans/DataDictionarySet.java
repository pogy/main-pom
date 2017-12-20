package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：DataDictionarySet.java
 *@文件路径：com.opentae.data.daifa.beans.DataDictionarySet
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-09 04:20:24
 *@comments:
 *
 *=========================================================
 */
public class DataDictionarySet implements Serializable {
	
	/**代发数据字典ID*/
	@Id
@GeneratedValue(generator="JDBC")
	private Long dataDictionaryId;
	/**使用的地方@先分为：1前端，2后台*/
	private String useType;
	/**具体服务ID*/
	private Long serviceId;
	/**字典名*/
	private String dataDictionaryName;
	/**字典数据类型@Integer,Long,String*/
	private String dataDictionaryType;
	/**字典key@就是字段名*/
	private String dataDictionaryKey;
	/**字典说明*/
	private String dataDictionaryRemark;
	 
	 //*************************get/set*****************************
    	/**
  	* 
	*get方法
  	*代发数据字典ID
 	*自动生成
  	*/
    public Long getDataDictionaryId() {
        return dataDictionaryId;
    }

    /**
  	* 
  	*set方法
	*代发数据字典ID
 	*自动生成
  	*/
    public void setDataDictionaryId(Long dataDictionaryId) {
        this.dataDictionaryId = dataDictionaryId;
    }
	/**
  	* 
	*get方法
  	*使用的地方@先分为：1前端，2后台
 	*自动生成
  	*/
    public String getUseType() {
        return useType;
    }

    /**
  	* 
  	*set方法
	*使用的地方@先分为：1前端，2后台
 	*自动生成
  	*/
    public void setUseType(String useType) {
        this.useType = useType;
    }
	/**
  	* 
	*get方法
  	*具体服务ID
 	*自动生成
  	*/
    public Long getServiceId() {
        return serviceId;
    }

    /**
  	* 
  	*set方法
	*具体服务ID
 	*自动生成
  	*/
    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
	/**
  	* 
	*get方法
  	*字典名
 	*自动生成
  	*/
    public String getDataDictionaryName() {
        return dataDictionaryName;
    }

    /**
  	* 
  	*set方法
	*字典名
 	*自动生成
  	*/
    public void setDataDictionaryName(String dataDictionaryName) {
        this.dataDictionaryName = dataDictionaryName;
    }
	/**
  	* 
	*get方法
  	*字典数据类型@Integer,Long,String
 	*自动生成
  	*/
    public String getDataDictionaryType() {
        return dataDictionaryType;
    }

    /**
  	* 
  	*set方法
	*字典数据类型@Integer,Long,String
 	*自动生成
  	*/
    public void setDataDictionaryType(String dataDictionaryType) {
        this.dataDictionaryType = dataDictionaryType;
    }
	/**
  	* 
	*get方法
  	*字典key@就是字段名
 	*自动生成
  	*/
    public String getDataDictionaryKey() {
        return dataDictionaryKey;
    }

    /**
  	* 
  	*set方法
	*字典key@就是字段名
 	*自动生成
  	*/
    public void setDataDictionaryKey(String dataDictionaryKey) {
        this.dataDictionaryKey = dataDictionaryKey;
    }
	/**
  	* 
	*get方法
  	*字典说明
 	*自动生成
  	*/
    public String getDataDictionaryRemark() {
        return dataDictionaryRemark;
    }

    /**
  	* 
  	*set方法
	*字典说明
 	*自动生成
  	*/
    public void setDataDictionaryRemark(String dataDictionaryRemark) {
        this.dataDictionaryRemark = dataDictionaryRemark;
    }
}
