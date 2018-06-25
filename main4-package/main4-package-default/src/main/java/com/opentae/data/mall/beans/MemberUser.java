package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;
import java.io.Serializable;

public class MemberUser implements Serializable {

	private static final long serialVersionUID = 7469958078155472372L;
    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long userId;

    /**
     * 用户名
     */
	private String userName;

    /**
     * 用户昵称
     */
	private String userNick;

    /**
     * 可登陆邮箱
     */
	private String loginEmail;

    /**
     * 可登陆手机号
     */
	private String loginPhone;

    /**
     * email
     */
	private String email;

    /**
     * 密码
     */
	private String password;

    /**
     * 真实姓名
     */
	private String realName;

    /**
     * 买家等级：0普通用户1大客户，2，3vip客户
     */
	private Long buyerGrade;

    /**
     * 卖家等级
     */
	private Long sellerGrade;

    /**
     * 卖家VIP等级@付费等级
     */
	private Long sellerVipGrade;

    /**
     * 生日
     */
	private Date birthday;

    /**
     * 生日月日@格式MM-dd
     */
	private String birthdayMonthDay;

    /**
     * 身份证号
     */
	private String idCard;

    /**
     * 电话号@多个号码之间用“/”分隔
     */
	private String phoneTel;

    /**
     * 手机号@多个号码之间用“/”分隔
     */
	private String phoneMob;

    /**
     * 联系QQ@多个号码之间用“/”分隔
     */
	private String imQq;

    /**
     * 联系skype@多个号码之间用“/”分隔
     */
	private String imSkype;

    /**
     * 联系微信
     */
	private String imWeixin;

    /**
     * 联系旺旺
     */
	private String imAliww;

    /**
     * 联系微博yahoo
     */
	private String imYahooWeibo;

    /**
     * 联系微博腾讯
     */
	private String imQqWeibo;

    /**
     * 注册时间
     */
	private Date regTime;

    /**
     * 最后一次登陆时间
     */
	private Date lastTime;

    /**
     * 最后一次登陆的IP
     */
	private String lastIp;

    /**
     * 登录次数
     */
	private Long logins;

    /**
     * 最后一次登陆所使用的账号类型
     */
	private Integer accountType;

    /**
     * 最后一次登陆的帐号
     */
	private String accountName;

    /**
     * 最后一次登陆的账户ID
     */
	private Long accountId;

    /**
     * 照片存储地址
     */
	private String portraitSavepath;

    /**
     * 照片访问地址
     */
	private String portraitUrl;

    /**
     * 状态@0待审核1审核通过2审核不通过
     */
	private Long useStatus;

    /**
     * 是否已经开店@0未开店1已开店@在后台里在页面上店铺管理还是我要开店的按钮
     */
	private Integer isOpenStore;

    /**
     * 备用1
     */
	private String remark1;

    /**
     * 备用2
     */
	private String remark2;

    /**
     * 备用3
     */
	private String remark3;

    /**
     * 备用4
     */
	private String remark4;

    /**
     * 备用5
     */
	private String remark5;

    /**
     * 备用6
     */
	private String remark6;

    /**
     * 备用7
     */
	private String remark7;

    /**
     * 是否拉黑1：是
     */
	private String remark8;

    /**
     * 拉黑代发理由
     */
	private String remark9;

    /**
     * 备用10
     */
	private String remark10;

    /**
     * 备用11
     */
	private String remark11;

    /**
     * 备用12
     */
	private String remark12;

    /**
     * 备用13
     */
	private String remark13;

    /**
     * 最后抓取商品时间
     */
	private String remark14;

    /**
     * 备用15
     */
	private String remark15;

    /**
     * 备用16
     */
	private String remark16;

    /**
     * 备用17
     */
	private String remark17;

    /**
     * remark18   1加过account没加过Im  2加过Im 没加过account  3两者都加过
     */
	private String remark18;

    /**
     * 备用19
     */
	private String remark19;

    /**
     * 备用20
     */
	private String remark20;

    /**
     * 
     */
	private String sex;

    /**
     * 。是否实名认证0:否，1:是2:审核不通过
     */
	private Integer isNameValidate;

    /**
     * 。密码安全强度指数，1-100
     */
	private Integer passwordStrength;

    /**
     * 
     */
	private Integer isMailValidate;

    /**
     * 。手机是否绑定0:否，1:是
     */
	private Integer isPhoneMob;

    /**
     * 。是否设置支付密码0：否，1：是
     */
	private Integer isPayPassword;

    /**
     * 身份证复印件地址
     */
	private String idCardImg;

    /**
     * 注册来源@1页面2手机端
     */
	private Long registerSource;

    /**
     * 代发退款默认支付宝账号
     */
	private String zfbAccount;

    /**
     * 支付密码
     */
	private String payPassword;

	@Transient
	private String subUserNameGroups;

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getUserNick() {
		return this.userNick;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getLoginEmail() {
		return this.loginEmail;
	}

	public void setLoginPhone(String loginPhone) {
		this.loginPhone = loginPhone;
	}

	public String getLoginPhone() {
		return this.loginPhone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getRealName() {
		return this.realName;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthdayMonthDay(String birthdayMonthDay) {
		this.birthdayMonthDay = birthdayMonthDay;
	}

	public String getBirthdayMonthDay() {
		return this.birthdayMonthDay;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setPhoneTel(String phoneTel) {
		this.phoneTel = phoneTel;
	}

	public String getPhoneTel() {
		return this.phoneTel;
	}

	public void setPhoneMob(String phoneMob) {
		this.phoneMob = phoneMob;
	}

	public String getPhoneMob() {
		return this.phoneMob;
	}

	public void setImQq(String imQq) {
		this.imQq = imQq;
	}

	public String getImQq() {
		return this.imQq;
	}

	public void setImSkype(String imSkype) {
		this.imSkype = imSkype;
	}

	public String getImSkype() {
		return this.imSkype;
	}

	public void setImWeixin(String imWeixin) {
		this.imWeixin = imWeixin;
	}

	public String getImWeixin() {
		return this.imWeixin;
	}

	public void setImAliww(String imAliww) {
		this.imAliww = imAliww;
	}

	public String getImAliww() {
		return this.imAliww;
	}

	public void setImYahooWeibo(String imYahooWeibo) {
		this.imYahooWeibo = imYahooWeibo;
	}

	public String getImYahooWeibo() {
		return this.imYahooWeibo;
	}

	public void setImQqWeibo(String imQqWeibo) {
		this.imQqWeibo = imQqWeibo;
	}

	public String getImQqWeibo() {
		return this.imQqWeibo;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public Date getRegTime() {
		return this.regTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public Date getLastTime() {
		return this.lastTime;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	public String getLastIp() {
		return this.lastIp;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	public Integer getAccountType() {
		return this.accountType;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getAccountId() {
		return this.accountId;
	}

	public void setPortraitSavepath(String portraitSavepath) {
		this.portraitSavepath = portraitSavepath;
	}

	public String getPortraitSavepath() {
		return this.portraitSavepath;
	}

	public void setPortraitUrl(String portraitUrl) {
		this.portraitUrl = portraitUrl;
	}

	public String getPortraitUrl() {
		return this.portraitUrl;
	}


	public void setIsOpenStore(Integer isOpenStore) {
		this.isOpenStore = isOpenStore;
	}

	public Integer getIsOpenStore() {
		return this.isOpenStore;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark1() {
		return this.remark1;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark2() {
		return this.remark2;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	public String getRemark3() {
		return this.remark3;
	}

	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	public String getRemark4() {
		return this.remark4;
	}

	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}

	public String getRemark5() {
		return this.remark5;
	}

	public void setRemark6(String remark6) {
		this.remark6 = remark6;
	}

	public String getRemark6() {
		return this.remark6;
	}

	public void setRemark7(String remark7) {
		this.remark7 = remark7;
	}

	public String getRemark7() {
		return this.remark7;
	}

	public void setRemark8(String remark8) {
		this.remark8 = remark8;
	}

	public String getRemark8() {
		return this.remark8;
	}

	public void setRemark9(String remark9) {
		this.remark9 = remark9;
	}

	public String getRemark9() {
		return this.remark9;
	}

	public void setRemark10(String remark10) {
		this.remark10 = remark10;
	}

	public String getRemark10() {
		return this.remark10;
	}

	public void setRemark11(String remark11) {
		this.remark11 = remark11;
	}

	public String getRemark11() {
		return this.remark11;
	}

	public void setRemark12(String remark12) {
		this.remark12 = remark12;
	}

	public String getRemark12() {
		return this.remark12;
	}

	public void setRemark13(String remark13) {
		this.remark13 = remark13;
	}

	public String getRemark13() {
		return this.remark13;
	}

	public void setRemark14(String remark14) {
		this.remark14 = remark14;
	}

	public String getRemark14() {
		return this.remark14;
	}

	public void setRemark15(String remark15) {
		this.remark15 = remark15;
	}

	public String getRemark15() {
		return this.remark15;
	}

	public void setRemark16(String remark16) {
		this.remark16 = remark16;
	}

	public String getRemark16() {
		return this.remark16;
	}

	public void setRemark17(String remark17) {
		this.remark17 = remark17;
	}

	public String getRemark17() {
		return this.remark17;
	}

	public void setRemark18(String remark18) {
		this.remark18 = remark18;
	}

	public String getRemark18() {
		return this.remark18;
	}

	public void setRemark19(String remark19) {
		this.remark19 = remark19;
	}

	public String getRemark19() {
		return this.remark19;
	}

	public void setRemark20(String remark20) {
		this.remark20 = remark20;
	}

	public String getRemark20() {
		return this.remark20;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return this.sex;
	}

	public void setIsNameValidate(Integer isNameValidate) {
		this.isNameValidate = isNameValidate;
	}

	public Integer getIsNameValidate() {
		return this.isNameValidate;
	}

	public void setPasswordStrength(Integer passwordStrength) {
		this.passwordStrength = passwordStrength;
	}

	public Integer getPasswordStrength() {
		return this.passwordStrength;
	}

	public void setIsMailValidate(Integer isMailValidate) {
		this.isMailValidate = isMailValidate;
	}

	public Integer getIsMailValidate() {
		return this.isMailValidate;
	}

	public void setIsPhoneMob(Integer isPhoneMob) {
		this.isPhoneMob = isPhoneMob;
	}

	public Integer getIsPhoneMob() {
		return this.isPhoneMob;
	}

	public void setIsPayPassword(Integer isPayPassword) {
		this.isPayPassword = isPayPassword;
	}

	public Integer getIsPayPassword() {
		return this.isPayPassword;
	}

	public void setIdCardImg(String idCardImg) {
		this.idCardImg = idCardImg;
	}

	public String getIdCardImg() {
		return this.idCardImg;
	}



	public void setZfbAccount(String zfbAccount) {
		this.zfbAccount = zfbAccount;
	}

	public String getZfbAccount() {
		return this.zfbAccount;
	}

	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}

	public String getPayPassword() {
		return this.payPassword;
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

	public Long getLogins() {
		return logins;
	}

	public void setLogins(Long logins) {
		this.logins = logins;
	}

	public Long getUseStatus() {
		return useStatus;
	}

	public void setUseStatus(Long useStatus) {
		this.useStatus = useStatus;
	}

	public Long getRegisterSource() {
		return registerSource;
	}

	public void setRegisterSource(Long registerSource) {
		this.registerSource = registerSource;
	}

	public String getSubUserNameGroups() {
		return subUserNameGroups;
	}

	public void setSubUserNameGroups(String subUserNameGroups) {
		this.subUserNameGroups = subUserNameGroups;
	}
}