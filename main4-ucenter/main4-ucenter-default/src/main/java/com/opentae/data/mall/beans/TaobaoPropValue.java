package com.opentae.data.mall.beans;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;
import java.io.Serializable;
/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：TaobaoPropValue.java
 *@文件路径：com.opentae.data.mall.beans.TaobaoPropValue
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-11-03 06:01:29
 *@comments:
 *
 *=========================================================
 */
public class TaobaoPropValue implements Serializable{
	
	/***/
	@Id
@GeneratedValue(generator="JDBC")
	private Long tbVid;
	/***/
	private Long cid;
	/***/
	private Long pid;
	/***/
	private String propName;
	/***/
	private Long vid;
	/***/
	private String name;
	/***/
	private String nameAlias;
	/**1是true0是false*/
	private Integer isParent;
	/***/
	private String status;
	/***/
	private Long sortOrder;
	/***/
	private String remark10;
	/***/
	private String remark9;
	/***/
	private String remark8;
	/***/
	private String remark7;
	/***/
	private String remark6;
	/***/
	private String remark5;
	/***/
	private String remark4;
	/***/
	private String remark3;
	/***/
	private String remark1;
	/***/
	private String remark2;
	 
	 //*************************get/set*****************************
    	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public Long getTbVid() {
        return tbVid;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setTbVid(Long tbVid) {
        this.tbVid = tbVid;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public Long getCid() {
        return cid;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setCid(Long cid) {
        this.cid = cid;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public Long getPid() {
        return pid;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setPid(Long pid) {
        this.pid = pid;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getPropName() {
        return propName;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setPropName(String propName) {
        this.propName = propName;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public Long getVid() {
        return vid;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setVid(Long vid) {
        this.vid = vid;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getName() {
        return name;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setName(String name) {
        this.name = name;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getNameAlias() {
        return nameAlias;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setNameAlias(String nameAlias) {
        this.nameAlias = nameAlias;
    }
	/**
  	* 
	*get方法
  	*1是true0是false
 	*自动生成
  	*/
    public Integer getIsParent() {
        return isParent;
    }

    /**
  	* 
  	*set方法
	*1是true0是false
 	*自动生成
  	*/
    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getStatus() {
        return status;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setStatus(String status) {
        this.status = status;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public Long getSortOrder() {
        return sortOrder;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getRemark10() {
        return remark10;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setRemark10(String remark10) {
        this.remark10 = remark10;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getRemark9() {
        return remark9;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setRemark9(String remark9) {
        this.remark9 = remark9;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getRemark8() {
        return remark8;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setRemark8(String remark8) {
        this.remark8 = remark8;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getRemark7() {
        return remark7;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setRemark7(String remark7) {
        this.remark7 = remark7;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getRemark6() {
        return remark6;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setRemark6(String remark6) {
        this.remark6 = remark6;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getRemark5() {
        return remark5;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getRemark4() {
        return remark4;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getRemark3() {
        return remark3;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getRemark1() {
        return remark1;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }
	/**
  	* 
	*get方法
  	*
 	*自动生成
  	*/
    public String getRemark2() {
        return remark2;
    }

    /**
  	* 
  	*set方法
	*
 	*自动生成
  	*/
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }
}
