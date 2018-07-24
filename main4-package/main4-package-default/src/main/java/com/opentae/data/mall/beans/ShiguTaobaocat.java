package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：ShiguTaobaocat.java
 *@文件路径：com.opentae.data.mall.beans.ShiguTaobaocat
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-11-03 02:22:10
 *@comments:
 *
 *=========================================================
 */
public class ShiguTaobaocat implements Serializable{
	
	/**类目ID*/
	@Id
@GeneratedValue(generator="JDBC")
	private Long cid;
	/**类目名*/
	private String cname;
	/**父类目ID*/
	private Long parentCid;
	/**父类目*/
	private String parentCname;
	/**是否是顶级类目*/
	private Long isParent;
	/**示显排序*/
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
	/**备用11*/
	private String remark11;
	/**备用12*/
	private String remark12;
	/**备用13*/
	private String remark13;
	/**备用14*/
	private String remark14;
	/**备用15*/
	private String remark15;
	 
	 //*************************get/set*****************************
    	/**
  	* 
	*get方法
  	*类目ID
 	*自动生成
  	*/
    public Long getCid() {
        return cid;
    }

    /**
  	* 
  	*set方法
	*类目ID
 	*自动生成
  	*/
    public void setCid(Long cid) {
        this.cid = cid;
    }
	/**
  	* 
	*get方法
  	*类目名
 	*自动生成
  	*/
    public String getCname() {
        return cname;
    }

    /**
  	* 
  	*set方法
	*类目名
 	*自动生成
  	*/
    public void setCname(String cname) {
        this.cname = cname;
    }
	/**
  	* 
	*get方法
  	*父类目ID
 	*自动生成
  	*/
    public Long getParentCid() {
        return parentCid;
    }

    /**
  	* 
  	*set方法
	*父类目ID
 	*自动生成
  	*/
    public void setParentCid(Long parentCid) {
        this.parentCid = parentCid;
    }
	/**
  	* 
	*get方法
  	*父类目
 	*自动生成
  	*/
    public String getParentCname() {
        return parentCname;
    }

    /**
  	* 
  	*set方法
	*父类目
 	*自动生成
  	*/
    public void setParentCname(String parentCname) {
        this.parentCname = parentCname;
    }
	/**
  	* 
	*get方法
  	*是否是顶级类目
 	*自动生成
  	*/
    public Long getIsParent() {
        return isParent;
    }

    /**
  	* 
  	*set方法
	*是否是顶级类目
 	*自动生成
  	*/
    public void setIsParent(Long isParent) {
        this.isParent = isParent;
    }
	/**
  	* 
	*get方法
  	*示显排序
 	*自动生成
  	*/
    public String getRemark1() {
        return remark1;
    }

    /**
  	* 
  	*set方法
	*示显排序
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
	/**
  	* 
	*get方法
  	*备用11
 	*自动生成
  	*/
    public String getRemark11() {
        return remark11;
    }

    /**
  	* 
  	*set方法
	*备用11
 	*自动生成
  	*/
    public void setRemark11(String remark11) {
        this.remark11 = remark11;
    }
	/**
  	* 
	*get方法
  	*备用12
 	*自动生成
  	*/
    public String getRemark12() {
        return remark12;
    }

    /**
  	* 
  	*set方法
	*备用12
 	*自动生成
  	*/
    public void setRemark12(String remark12) {
        this.remark12 = remark12;
    }
	/**
  	* 
	*get方法
  	*备用13
 	*自动生成
  	*/
    public String getRemark13() {
        return remark13;
    }

    /**
  	* 
  	*set方法
	*备用13
 	*自动生成
  	*/
    public void setRemark13(String remark13) {
        this.remark13 = remark13;
    }
	/**
  	* 
	*get方法
  	*备用14
 	*自动生成
  	*/
    public String getRemark14() {
        return remark14;
    }

    /**
  	* 
  	*set方法
	*备用14
 	*自动生成
  	*/
    public void setRemark14(String remark14) {
        this.remark14 = remark14;
    }
	/**
  	* 
	*get方法
  	*备用15
 	*自动生成
  	*/
    public String getRemark15() {
        return remark15;
    }

    /**
  	* 
  	*set方法
	*备用15
 	*自动生成
  	*/
    public void setRemark15(String remark15) {
        this.remark15 = remark15;
    }
}
