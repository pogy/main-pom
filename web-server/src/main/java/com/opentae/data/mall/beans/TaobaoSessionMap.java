package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

public class TaobaoSessionMap implements Serializable {
    /**
     * 
     */
    @Id
    @GeneratedValue(generator = "JDBC")
	private Long tsmId;

    /**
     * 
     */
	private String nick;

    /**
     * 
     */
	private String appkey;

    /**
     * 
     */
	private String secret;

    /**
     * 
     */
	private String session;

    /**
     * 
     */
	private Long shopId;

    /**
     * 
     */
	private Long userId;

    /**
     * 
     */
	private String refreshToken;

    /**
     * 
     */
	private Date freshTime;

    /**
     * RefreshToken过期时间
     */
	private Long reExpiresIn;

    /**
     * Access类型
     */
	private String tokenType;

    /**
     * Access过期时间
     */
	private Long expiresIn;

    /**
     * R1过期时间
     */
	private Long r1ExpiresIn;

    /**
     * R2过期时间
     */
	private Long r2ExpiresIn;

    /**
     * W1过期时间
     */
	private Long w1ExpiresIn;

    /**
     * W2过期时间
     */
	private Long w2ExpiresIn;

    /**
     * 子账号用户ID
     */
	private Long subTaobaoUserId;

    /**
     * 子账号nick
     */
	private String subTaobaoUserNick;

    /**
     * 
     */
	private String remark;

    /**
     * 
     */
	private String remark10;

    /**
     * 0正常，1过期了发过短信，2过期了没手机号
     */
	private String remark9;

    /**
     * 1表示失效，null或2表示有效
     */
	private String remark8;

    /**
     * 
     */
	private String remark7;

    /**
     * 所加rds名称信息的json
     */
	private String remark6;

    /**
     * 
     */
	private String remark5;

    /**
     * good_num 收到的好评总条数。取值范围:大于零的整数
     */
	private String remark4;

    /**
     * total_num 收到的评价总条数。取值范围:大于零的整数
     */
	private String remark3;

    /**
     * level 信用等级（是根据score生成的），信用等级：淘宝会员在淘宝网上的信用度，分为20个级别，级别如：level = 1 时，表示一心；level = 2 时，表示二心
     */
	private String remark1;

    /**
     * score 信用总分（“好评”加一分，“中评”不加分，“差评”扣一分。分越高，等级越高）
     */
	private String remark2;

	public void setTsmId(Long tsmId) {
		this.tsmId = tsmId;
	}

	public Long getTsmId() {
		return this.tsmId;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNick() {
		return this.nick;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	public String getAppkey() {
		return this.appkey;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getSecret() {
		return this.secret;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getSession() {
		return this.session;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getShopId() {
		return this.shopId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getRefreshToken() {
		return this.refreshToken;
	}

	public void setFreshTime(Date freshTime) {
		this.freshTime = freshTime;
	}

	public Date getFreshTime() {
		return this.freshTime;
	}

	public void setReExpiresIn(Long reExpiresIn) {
		this.reExpiresIn = reExpiresIn;
	}

	public Long getReExpiresIn() {
		return this.reExpiresIn;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getTokenType() {
		return this.tokenType;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public Long getExpiresIn() {
		return this.expiresIn;
	}

	public void setR1ExpiresIn(Long r1ExpiresIn) {
		this.r1ExpiresIn = r1ExpiresIn;
	}

	public Long getR1ExpiresIn() {
		return this.r1ExpiresIn;
	}

	public void setR2ExpiresIn(Long r2ExpiresIn) {
		this.r2ExpiresIn = r2ExpiresIn;
	}

	public Long getR2ExpiresIn() {
		return this.r2ExpiresIn;
	}

	public void setW1ExpiresIn(Long w1ExpiresIn) {
		this.w1ExpiresIn = w1ExpiresIn;
	}

	public Long getW1ExpiresIn() {
		return this.w1ExpiresIn;
	}

	public void setW2ExpiresIn(Long w2ExpiresIn) {
		this.w2ExpiresIn = w2ExpiresIn;
	}

	public Long getW2ExpiresIn() {
		return this.w2ExpiresIn;
	}

	public void setSubTaobaoUserId(Long subTaobaoUserId) {
		this.subTaobaoUserId = subTaobaoUserId;
	}

	public Long getSubTaobaoUserId() {
		return this.subTaobaoUserId;
	}

	public void setSubTaobaoUserNick(String subTaobaoUserNick) {
		this.subTaobaoUserNick = subTaobaoUserNick;
	}

	public String getSubTaobaoUserNick() {
		return this.subTaobaoUserNick;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark10(String remark10) {
		this.remark10 = remark10;
	}

	public String getRemark10() {
		return this.remark10;
	}

	public void setRemark9(String remark9) {
		this.remark9 = remark9;
	}

	public String getRemark9() {
		return this.remark9;
	}

	public void setRemark8(String remark8) {
		this.remark8 = remark8;
	}

	public String getRemark8() {
		return this.remark8;
	}

	public void setRemark7(String remark7) {
		this.remark7 = remark7;
	}

	public String getRemark7() {
		return this.remark7;
	}

	public void setRemark6(String remark6) {
		this.remark6 = remark6;
	}

	public String getRemark6() {
		return this.remark6;
	}

	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}

	public String getRemark5() {
		return this.remark5;
	}

	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	public String getRemark4() {
		return this.remark4;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	public String getRemark3() {
		return this.remark3;
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

}