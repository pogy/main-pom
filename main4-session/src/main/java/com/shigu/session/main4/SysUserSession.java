package com.shigu.session.main4;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wxc on 2017/1/6.
 *
 * @author wxc
 * @version main-site3.2_session 3.0.0
 * @since main-site3.2_session 3.0.0
 */
public class SysUserSession implements Serializable {

    private static final long serialVersionUID = 7309031691362490071L;

    private Long userId;
    private String userNo;
    private Long orgId;
    private String loginName;
    private String loginPwd;
    private String userName;
    private String natives;
    private String workduty;
    private String sex;
    private String homephone;
    private String email;
    private String address;
    private String phone;
    private Date createDate;
    private Date modifyDate;
    private Date lastLoginDate;
    private Long loginTimes;
    private Integer usesStatus;
    private String descInfo;
    private Long levelNum;
    private Long sortOrder;
    private String imSkype;
    private String imWeixin;
    private String imAliww;
    private String imYahooWeibo;
    private String imQqWeibo;
    private String imQq;
    private Date birthday;
    private Long companyId;
    private String idCard;
    private String account;
    private String balance;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNatives() {
        return natives;
    }

    public void setNatives(String natives) {
        this.natives = natives;
    }

    public String getWorkduty() {
        return workduty;
    }

    public void setWorkduty(String workduty) {
        this.workduty = workduty;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHomephone() {
        return homephone;
    }

    public void setHomephone(String homephone) {
        this.homephone = homephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Long getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(Long loginTimes) {
        this.loginTimes = loginTimes;
    }

    public Integer getUsesStatus() {
        return usesStatus;
    }

    public void setUsesStatus(Integer usesStatus) {
        this.usesStatus = usesStatus;
    }

    public String getDescInfo() {
        return descInfo;
    }

    public void setDescInfo(String descInfo) {
        this.descInfo = descInfo;
    }

    public Long getLevelNum() {
        return levelNum;
    }

    public void setLevelNum(Long levelNum) {
        this.levelNum = levelNum;
    }

    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getImSkype() {
        return imSkype;
    }

    public void setImSkype(String imSkype) {
        this.imSkype = imSkype;
    }

    public String getImWeixin() {
        return imWeixin;
    }

    public void setImWeixin(String imWeixin) {
        this.imWeixin = imWeixin;
    }

    public String getImAliww() {
        return imAliww;
    }

    public void setImAliww(String imAliww) {
        this.imAliww = imAliww;
    }

    public String getImYahooWeibo() {
        return imYahooWeibo;
    }

    public void setImYahooWeibo(String imYahooWeibo) {
        this.imYahooWeibo = imYahooWeibo;
    }

    public String getImQqWeibo() {
        return imQqWeibo;
    }

    public void setImQqWeibo(String imQqWeibo) {
        this.imQqWeibo = imQqWeibo;
    }

    public String getImQq() {
        return imQq;
    }

    public void setImQq(String imQq) {
        this.imQq = imQq;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    public String getRemark5() {
        return remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }

    public String getRemark6() {
        return remark6;
    }

    public void setRemark6(String remark6) {
        this.remark6 = remark6;
    }

    public String getRemark7() {
        return remark7;
    }

    public void setRemark7(String remark7) {
        this.remark7 = remark7;
    }

    public String getRemark8() {
        return remark8;
    }

    public void setRemark8(String remark8) {
        this.remark8 = remark8;
    }

    public String getRemark9() {
        return remark9;
    }

    public void setRemark9(String remark9) {
        this.remark9 = remark9;
    }

    public String getRemark10() {
        return remark10;
    }

    public void setRemark10(String remark10) {
        this.remark10 = remark10;
    }
}
