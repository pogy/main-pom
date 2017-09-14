package com.opentae.data.daifa.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：DaifaListDeal.java
 *@文件路径：com.opentae.data.daifa.beans.DaifaListDeal
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-08-09 04:19:10
 *@comments:
 *
 *=========================================================
 */
public class DaifaListDeal implements Serializable {
	
	/**次数@主键*/
	@Id
@GeneratedValue(generator="JDBC")
	private Long listId;
	/**yyyyMMdd*/
	private String createDate;
	/**代发ID*/
	private Long sellerId;
	/**用户ID */
	private Long userId;
	/**清单类型：ggoods_code（拿货清单ID），daifa_send_code（已发编码），daifa_send_code（已发编码），stock_code（入库清单ID），tk_code（退货清单）*/
	private String type;
	/**次数(每天按seller_id, create_date, user_id, type这四个字段来处理)*/
	private Integer num;
	/**nh{日期}_{拿货人ID}_次数,fh{日期},ck{日期}_次数,tk{日期}_{退货员ID}_次数*/
	private String listCode;
	/**备用1*/
	private String remark1;
	/**备用2*/
	private String remark2;
	/**备用3*/
	private String remark3;
	/**备用4*/
	private String remark4;
	/**备用5*/
	private String remark5;
	/**备用6*/
	private String remark6;
	/**备用7*/
	private String remark7;
	/**备用8*/
	private String remark8;
	/**备用9*/
	private String remark9;
	/**备用10*/
	private String remark10;
	 
	 //*************************get/set*****************************
    	/**
  	* 
	*get方法
  	*次数@主键
 	*自动生成
  	*/
    public Long getListId() {
        return listId;
    }

    /**
  	* 
  	*set方法
	*次数@主键
 	*自动生成
  	*/
    public void setListId(Long listId) {
        this.listId = listId;
    }
	/**
  	* 
	*get方法
  	*yyyyMMdd
 	*自动生成
  	*/
    public String getCreateDate() {
        return createDate;
    }

    /**
  	* 
  	*set方法
	*yyyyMMdd
 	*自动生成
  	*/
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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
  	*用户ID 
 	*自动生成
  	*/
    public Long getUserId() {
        return userId;
    }

    /**
  	* 
  	*set方法
	*用户ID 
 	*自动生成
  	*/
    public void setUserId(Long userId) {
        this.userId = userId;
    }
	/**
  	* 
	*get方法
  	*清单类型：ggoods_code（拿货清单ID），daifa_send_code（已发编码），daifa_send_code（已发编码），stock_code（入库清单ID），tk_code（退货清单）
 	*自动生成
  	*/
    public String getType() {
        return type;
    }

    /**
  	* 
  	*set方法
	*清单类型：ggoods_code（拿货清单ID），daifa_send_code（已发编码），daifa_send_code（已发编码），stock_code（入库清单ID），tk_code（退货清单）
 	*自动生成
  	*/
    public void setType(String type) {
        this.type = type;
    }
	/**
  	* 
	*get方法
  	*次数(每天按seller_id, create_date, user_id, type这四个字段来处理)
 	*自动生成
  	*/
    public Integer getNum() {
        return num;
    }

    /**
  	* 
  	*set方法
	*次数(每天按seller_id, create_date, user_id, type这四个字段来处理)
 	*自动生成
  	*/
    public void setNum(Integer num) {
        this.num = num;
    }
	/**
  	* 
	*get方法
  	*nh{日期}_{拿货人ID}_次数,fh{日期},ck{日期}_次数,tk{日期}_{退货员ID}_次数
 	*自动生成
  	*/
    public String getListCode() {
        return listCode;
    }

    /**
  	* 
  	*set方法
	*nh{日期}_{拿货人ID}_次数,fh{日期},ck{日期}_次数,tk{日期}_{退货员ID}_次数
 	*自动生成
  	*/
    public void setListCode(String listCode) {
        this.listCode = listCode;
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
  	*备用3
 	*自动生成
  	*/
    public String getRemark3() {
        return remark3;
    }

    /**
  	* 
  	*set方法
	*备用3
 	*自动生成
  	*/
    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }
	/**
  	* 
	*get方法
  	*备用4
 	*自动生成
  	*/
    public String getRemark4() {
        return remark4;
    }

    /**
  	* 
  	*set方法
	*备用4
 	*自动生成
  	*/
    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }
	/**
  	* 
	*get方法
  	*备用5
 	*自动生成
  	*/
    public String getRemark5() {
        return remark5;
    }

    /**
  	* 
  	*set方法
	*备用5
 	*自动生成
  	*/
    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }
	/**
  	* 
	*get方法
  	*备用6
 	*自动生成
  	*/
    public String getRemark6() {
        return remark6;
    }

    /**
  	* 
  	*set方法
	*备用6
 	*自动生成
  	*/
    public void setRemark6(String remark6) {
        this.remark6 = remark6;
    }
	/**
  	* 
	*get方法
  	*备用7
 	*自动生成
  	*/
    public String getRemark7() {
        return remark7;
    }

    /**
  	* 
  	*set方法
	*备用7
 	*自动生成
  	*/
    public void setRemark7(String remark7) {
        this.remark7 = remark7;
    }
	/**
  	* 
	*get方法
  	*备用8
 	*自动生成
  	*/
    public String getRemark8() {
        return remark8;
    }

    /**
  	* 
  	*set方法
	*备用8
 	*自动生成
  	*/
    public void setRemark8(String remark8) {
        this.remark8 = remark8;
    }
	/**
  	* 
	*get方法
  	*备用9
 	*自动生成
  	*/
    public String getRemark9() {
        return remark9;
    }

    /**
  	* 
  	*set方法
	*备用9
 	*自动生成
  	*/
    public void setRemark9(String remark9) {
        this.remark9 = remark9;
    }
	/**
  	* 
	*get方法
  	*备用10
 	*自动生成
  	*/
    public String getRemark10() {
        return remark10;
    }

    /**
  	* 
  	*set方法
	*备用10
 	*自动生成
  	*/
    public void setRemark10(String remark10) {
        this.remark10 = remark10;
    }
}
