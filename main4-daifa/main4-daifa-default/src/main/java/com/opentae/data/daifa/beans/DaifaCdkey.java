package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：DaifaCdkey.java
 *@文件路径：com.opentae.data.daifa.beans.DaifaCdkey
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-10 01:45:29
 *@comments:
 *
 *=========================================================
 */
public class DaifaCdkey implements Serializable {
	
	/***/
	@Id
@GeneratedValue(generator="JDBC")
	private Long cdkId;
	/**日期*/
	private java.util.Date date;
	/**cdkey（识别码）里要添加值：具体规则：日期两位-具体的商品数编码

具体的第一个值为A1  然后数据增加，但到A999的的下一值就应该是B1

到Y999后的下一个就变成AA1再增加

字母里I,O,Z这三个字母不要加进去

比如今天生成后的识别码例子  1208-A1,....1208-A999,1208-B1......1208-B999,1208-C1,

1208-H999,1208-J1,....1208-J999....1208-N999,1208-P1,....120*/
	private String cdkey;
	/**创建日期*/
	private java.util.Date createTime;
	 
	 //*************************get/set*****************************
    	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public Long getCdkId() {
        return cdkId;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setCdkId(Long cdkId) {
        this.cdkId = cdkId;
    }
	/**
  	* 
	*get方法
  	*日期
 	*自动生成
  	*/
    public java.util.Date getDate() {
        return date;
    }

    /**
  	* 
  	*set方法
	*日期
 	*自动生成
  	*/
    public void setDate(java.util.Date date) {
        this.date = date;
    }
	/**
  	* 
	*get方法
  	*cdkey（识别码）里要添加值：具体规则：日期两位-具体的商品数编码

具体的第一个值为A1  然后数据增加，但到A999的的下一值就应该是B1

到Y999后的下一个就变成AA1再增加

字母里I,O,Z这三个字母不要加进去

比如今天生成后的识别码例子  1208-A1,....1208-A999,1208-B1......1208-B999,1208-C1,

1208-H999,1208-J1,....1208-J999....1208-N999,1208-P1,....120
 	*自动生成
  	*/
    public String getCdkey() {
        return cdkey;
    }

    /**
  	* 
  	*set方法
	*cdkey（识别码）里要添加值：具体规则：日期两位-具体的商品数编码

具体的第一个值为A1  然后数据增加，但到A999的的下一值就应该是B1

到Y999后的下一个就变成AA1再增加

字母里I,O,Z这三个字母不要加进去

比如今天生成后的识别码例子  1208-A1,....1208-A999,1208-B1......1208-B999,1208-C1,

1208-H999,1208-J1,....1208-J999....1208-N999,1208-P1,....120
 	*自动生成
  	*/
    public void setCdkey(String cdkey) {
        this.cdkey = cdkey;
    }
	/**
  	* 
	*get方法
  	*创建日期
 	*自动生成
  	*/
    public java.util.Date getCreateTime() {
        return createTime;
    }

    /**
  	* 
  	*set方法
	*创建日期
 	*自动生成
  	*/
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
}
