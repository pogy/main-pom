package com.opentae.data.mall.beans;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;
import java.io.Serializable;
/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：ShiguSite.java
 *@文件路径：com.opentae.data.mall.beans.ShiguSite
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2017-11-03 01:22:22
 *@comments:
 *
 *=========================================================
 */
public class ShiguSite implements Serializable{
	
	/**站点ID(主键)*/
	@Id
@GeneratedValue(generator="JDBC")
	private Long buycityId;
	/**站点名*/
	private String siteName;
	/**站点域名*/
	private String domain;
	/**站点IP*/
	private String siteIp;
	/**拼音*/
	private String citySite;
	/**排序*/
	private Long sortOrder;
	/**省份ID*/
	private Long provinceId;
	/**省份*/
	private String provinceName;
	/**城市ID*/
	private Long cityId;
	/**城市*/
	private String cityName;
	/**1是开通的,0是不开通*/
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
	/**备用16*/
	private String remark16;
	/**备用17*/
	private String remark17;
	/**备用18*/
	private String remark18;
	/**备用19*/
	private String remark19;
	/**备用20*/
	private String remark20;
	 
	 //*************************get/set*****************************
    	/**
  	* 
	*get方法
  	*站点ID(主键)
 	*自动生成
  	*/
    public Long getBuycityId() {
        return buycityId;
    }

    /**
  	* 
  	*set方法
	*站点ID(主键)
 	*自动生成
  	*/
    public void setBuycityId(Long buycityId) {
        this.buycityId = buycityId;
    }
	/**
  	* 
	*get方法
  	*站点名
 	*自动生成
  	*/
    public String getSiteName() {
        return siteName;
    }

    /**
  	* 
  	*set方法
	*站点名
 	*自动生成
  	*/
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
	/**
  	* 
	*get方法
  	*站点域名
 	*自动生成
  	*/
    public String getDomain() {
        return domain;
    }

    /**
  	* 
  	*set方法
	*站点域名
 	*自动生成
  	*/
    public void setDomain(String domain) {
        this.domain = domain;
    }
	/**
  	* 
	*get方法
  	*站点IP
 	*自动生成
  	*/
    public String getSiteIp() {
        return siteIp;
    }

    /**
  	* 
  	*set方法
	*站点IP
 	*自动生成
  	*/
    public void setSiteIp(String siteIp) {
        this.siteIp = siteIp;
    }
	/**
  	* 
	*get方法
  	*拼音
 	*自动生成
  	*/
    public String getCitySite() {
        return citySite;
    }

    /**
  	* 
  	*set方法
	*拼音
 	*自动生成
  	*/
    public void setCitySite(String citySite) {
        this.citySite = citySite;
    }
	/**
  	* 
	*get方法
  	*排序
 	*自动生成
  	*/
    public Long getSortOrder() {
        return sortOrder;
    }

    /**
  	* 
  	*set方法
	*排序
 	*自动生成
  	*/
    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }
	/**
  	* 
	*get方法
  	*省份ID
 	*自动生成
  	*/
    public Long getProvinceId() {
        return provinceId;
    }

    /**
  	* 
  	*set方法
	*省份ID
 	*自动生成
  	*/
    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }
	/**
  	* 
	*get方法
  	*省份
 	*自动生成
  	*/
    public String getProvinceName() {
        return provinceName;
    }

    /**
  	* 
  	*set方法
	*省份
 	*自动生成
  	*/
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
	/**
  	* 
	*get方法
  	*城市ID
 	*自动生成
  	*/
    public Long getCityId() {
        return cityId;
    }

    /**
  	* 
  	*set方法
	*城市ID
 	*自动生成
  	*/
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
	/**
  	* 
	*get方法
  	*城市
 	*自动生成
  	*/
    public String getCityName() {
        return cityName;
    }

    /**
  	* 
  	*set方法
	*城市
 	*自动生成
  	*/
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
	/**
  	* 
	*get方法
  	*1是开通的,0是不开通
 	*自动生成
  	*/
    public String getRemark1() {
        return remark1;
    }

    /**
  	* 
  	*set方法
	*1是开通的,0是不开通
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
	/**
  	* 
	*get方法
  	*备用16
 	*自动生成
  	*/
    public String getRemark16() {
        return remark16;
    }

    /**
  	* 
  	*set方法
	*备用16
 	*自动生成
  	*/
    public void setRemark16(String remark16) {
        this.remark16 = remark16;
    }
	/**
  	* 
	*get方法
  	*备用17
 	*自动生成
  	*/
    public String getRemark17() {
        return remark17;
    }

    /**
  	* 
  	*set方法
	*备用17
 	*自动生成
  	*/
    public void setRemark17(String remark17) {
        this.remark17 = remark17;
    }
	/**
  	* 
	*get方法
  	*备用18
 	*自动生成
  	*/
    public String getRemark18() {
        return remark18;
    }

    /**
  	* 
  	*set方法
	*备用18
 	*自动生成
  	*/
    public void setRemark18(String remark18) {
        this.remark18 = remark18;
    }
	/**
  	* 
	*get方法
  	*备用19
 	*自动生成
  	*/
    public String getRemark19() {
        return remark19;
    }

    /**
  	* 
  	*set方法
	*备用19
 	*自动生成
  	*/
    public void setRemark19(String remark19) {
        this.remark19 = remark19;
    }
	/**
  	* 
	*get方法
  	*备用20
 	*自动生成
  	*/
    public String getRemark20() {
        return remark20;
    }

    /**
  	* 
  	*set方法
	*备用20
 	*自动生成
  	*/
    public void setRemark20(String remark20) {
        this.remark20 = remark20;
    }
}
