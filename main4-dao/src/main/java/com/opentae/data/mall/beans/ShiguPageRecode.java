package com.opentae.data.mall.beans;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Deprecated
public class ShiguPageRecode {
    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long id;
    private String webSite;
    private Long pageId;
    private String pageName;
    private String pageUrl;
    private String clientIp;
    private String clientBrower;
    private String clientBrowerVersion;
    private String clientOs;
    private Date inTime;
    private Date outTime;
    private String fromPageUrl;
    private Long fromPageId;
    private String fromPageName;
    private String cookieId;
    private String browerUrl;
    private String remark1;
    private String remark2;
    private String remark3;
    private String remark4;
    private String remark5;
    private String remark6;
    private String remark7;
    private String remark8;
    private String remark9;
    private String remark10;

    public ShiguPageRecode() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWebSite() {
        return this.webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Long getPageId() {
        return this.pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public String getPageName() {
        return this.pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getPageUrl() {
        return this.pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getClientBrower() {
        return this.clientBrower;
    }

    public void setClientBrower(String clientBrower) {
        this.clientBrower = clientBrower;
    }

    public String getClientBrowerVersion() {
        return this.clientBrowerVersion;
    }

    public void setClientBrowerVersion(String clientBrowerVersion) {
        this.clientBrowerVersion = clientBrowerVersion;
    }

    public String getClientOs() {
        return this.clientOs;
    }

    public void setClientOs(String clientOs) {
        this.clientOs = clientOs;
    }

    public Date getInTime() {
        return this.inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return this.outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getFromPageUrl() {
        return this.fromPageUrl;
    }

    public void setFromPageUrl(String fromPageUrl) {
        this.fromPageUrl = fromPageUrl;
    }

    public Long getFromPageId() {
        return this.fromPageId;
    }

    public void setFromPageId(Long fromPageId) {
        this.fromPageId = fromPageId;
    }

    public String getFromPageName() {
        return this.fromPageName;
    }

    public void setFromPageName(String fromPageName) {
        this.fromPageName = fromPageName;
    }

    public String getCookieId() {
        return this.cookieId;
    }

    public void setCookieId(String cookieId) {
        this.cookieId = cookieId;
    }

    public String getBrowerUrl() {
        return this.browerUrl;
    }

    public void setBrowerUrl(String browerUrl) {
        this.browerUrl = browerUrl;
    }

    public String getRemark1() {
        return this.remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return this.remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return this.remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark4() {
        return this.remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    public String getRemark5() {
        return this.remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }

    public String getRemark6() {
        return this.remark6;
    }

    public void setRemark6(String remark6) {
        this.remark6 = remark6;
    }

    public String getRemark7() {
        return this.remark7;
    }

    public void setRemark7(String remark7) {
        this.remark7 = remark7;
    }

    public String getRemark8() {
        return this.remark8;
    }

    public void setRemark8(String remark8) {
        this.remark8 = remark8;
    }

    public String getRemark9() {
        return this.remark9;
    }

    public void setRemark9(String remark9) {
        this.remark9 = remark9;
    }

    public String getRemark10() {
        return this.remark10;
    }

    public void setRemark10(String remark10) {
        this.remark10 = remark10;
    }
}
