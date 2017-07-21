package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户主表
 * Created by zhaohongbo on 17/2/15.
 */
public class MemberUser implements Serializable{

    private static final long serialVersionUID = 7469958078155472372L;
    @Id
    @GeneratedValue(
            generator = "JDBC"
    )
    private Long userId;
    private String userName;
    private String userNick;
    private String loginEmail;
    private String loginPhone;
    private String email;
    private String password;
    private String realName;
    private Long buyerGrade;
    private Long sellerGrade;
    private Long sellerVipGrade;
    private Date birthday;
    private String birthdayMonthDay;
    private String idCard;
    private String phoneTel;
    private String phoneMob;
    private String imQq;
    private String imSkype;
    private String imWeixin;
    private String imAliww;
    private String imYahooWeibo;
    private String imQqWeibo;
    private Date regTime;
    private Date lastTime;
    private String lastIp;
    private Long logins;
    private Integer accountType;
    private String accountName;
    private Long accountId;
    private String portraitSavepath;
    private String portraitUrl;
    private Long useStatus;
    private Integer isOpenStore;
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
    private String remark11;
    private String remark12;
    private String remark13;
    private String remark14;
    private String remark15;
    private String remark16;
    private String remark17;
    private String remark18;
    private String remark19;
    private String remark20;
    private String sex;
    private Integer isNameValidate;
    private Integer passwordStrength;
    private Integer isMailValidate;
    private Integer isPhoneMob;
    private Integer isPayPassword;
    private String idCardImg;
    private Long registerSource;
    private String zfbAccount;
    private String payPassword;

    @Transient
    private String subUserNameGroups;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public String getLoginPhone() {
        return loginPhone;
    }

    public void setLoginPhone(String loginPhone) {
        this.loginPhone = loginPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Long getBuyerGrade() {
        return buyerGrade;
    }

    public void setBuyerGrade(Long buyerGrade) {
        this.buyerGrade = buyerGrade;
    }

    public Long getSellerGrade() {
        return sellerGrade;
    }

    public void setSellerGrade(Long sellerGrade) {
        this.sellerGrade = sellerGrade;
    }

    public Long getSellerVipGrade() {
        return sellerVipGrade;
    }

    public void setSellerVipGrade(Long sellerVipGrade) {
        this.sellerVipGrade = sellerVipGrade;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBirthdayMonthDay() {
        return birthdayMonthDay;
    }

    public void setBirthdayMonthDay(String birthdayMonthDay) {
        this.birthdayMonthDay = birthdayMonthDay;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneTel() {
        return phoneTel;
    }

    public void setPhoneTel(String phoneTel) {
        this.phoneTel = phoneTel;
    }

    public String getPhoneMob() {
        return phoneMob;
    }

    public void setPhoneMob(String phoneMob) {
        this.phoneMob = phoneMob;
    }

    public String getImQq() {
        return imQq;
    }

    public void setImQq(String imQq) {
        this.imQq = imQq;
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

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public Long getLogins() {
        return logins;
    }

    public void setLogins(Long logins) {
        this.logins = logins;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getPortraitSavepath() {
        return portraitSavepath;
    }

    public void setPortraitSavepath(String portraitSavepath) {
        this.portraitSavepath = portraitSavepath;
    }

    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
    }

    public Long getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(Long useStatus) {
        this.useStatus = useStatus;
    }

    public Integer getIsOpenStore() {
        return isOpenStore;
    }

    public void setIsOpenStore(Integer isOpenStore) {
        this.isOpenStore = isOpenStore;
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

    public String getRemark11() {
        return remark11;
    }

    public void setRemark11(String remark11) {
        this.remark11 = remark11;
    }

    public String getRemark12() {
        return remark12;
    }

    public void setRemark12(String remark12) {
        this.remark12 = remark12;
    }

    public String getRemark13() {
        return remark13;
    }

    public void setRemark13(String remark13) {
        this.remark13 = remark13;
    }

    public String getRemark14() {
        return remark14;
    }

    public void setRemark14(String remark14) {
        this.remark14 = remark14;
    }

    public String getRemark15() {
        return remark15;
    }

    public void setRemark15(String remark15) {
        this.remark15 = remark15;
    }

    public String getRemark16() {
        return remark16;
    }

    public void setRemark16(String remark16) {
        this.remark16 = remark16;
    }

    public String getRemark17() {
        return remark17;
    }

    public void setRemark17(String remark17) {
        this.remark17 = remark17;
    }

    public String getRemark18() {
        return remark18;
    }

    public void setRemark18(String remark18) {
        this.remark18 = remark18;
    }

    public String getRemark19() {
        return remark19;
    }

    public void setRemark19(String remark19) {
        this.remark19 = remark19;
    }

    public String getRemark20() {
        return remark20;
    }

    public void setRemark20(String remark20) {
        this.remark20 = remark20;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getIsNameValidate() {
        return isNameValidate;
    }

    public void setIsNameValidate(Integer isNameValidate) {
        this.isNameValidate = isNameValidate;
    }

    public Integer getPasswordStrength() {
        return passwordStrength;
    }

    public void setPasswordStrength(Integer passwordStrength) {
        this.passwordStrength = passwordStrength;
    }

    public Integer getIsMailValidate() {
        return isMailValidate;
    }

    public void setIsMailValidate(Integer isMailValidate) {
        this.isMailValidate = isMailValidate;
    }

    public Integer getIsPhoneMob() {
        return isPhoneMob;
    }

    public void setIsPhoneMob(Integer isPhoneMob) {
        this.isPhoneMob = isPhoneMob;
    }

    public Integer getIsPayPassword() {
        return isPayPassword;
    }

    public void setIsPayPassword(Integer isPayPassword) {
        this.isPayPassword = isPayPassword;
    }

    public String getIdCardImg() {
        return idCardImg;
    }

    public void setIdCardImg(String idCardImg) {
        this.idCardImg = idCardImg;
    }

    public Long getRegisterSource() {
        return registerSource;
    }

    public void setRegisterSource(Long registerSource) {
        this.registerSource = registerSource;
    }

    public String getZfbAccount() {
        return zfbAccount;
    }

    public void setZfbAccount(String zfbAccount) {
        this.zfbAccount = zfbAccount;
    }

    public String getSubUserNameGroups() {
        return subUserNameGroups;
    }

    public void setSubUserNameGroups(String subUserNameGroups) {
        this.subUserNameGroups = subUserNameGroups;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }
}
