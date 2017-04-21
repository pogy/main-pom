package com.opentae.data.mall.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *==========================================================
 *TODO
 *@类编号：
 *@类名称：TaobaoSessionMap.java
 *@文件路径：com.shigu.mall.beans.TaobaoSessionMap
 *@内容摘要：
 *@编码作者：自动生成
 *@完成日期：
 *@Date2015-05-20 02:50:00
 *@comments:
 *
 *=========================================================
 */
public class TaobaoSessionMap implements Serializable{


	private static final long serialVersionUID = 2369017188959238326L;
	@Id
	@GeneratedValue(
			generator = "JDBC"
	)
	private Long tsmId;//
	private String nick;//
	private String appkey;//
	private String secret;//
	private String session;//
	private Long shopId;//
	private Long userId;//
	private String refreshToken;//
	private java.util.Date freshTime;//
	private Long reExpiresIn;//RefreshToken过期时间
	private String tokenType;//Access类型
	private Long expiresIn;//Access过期时间
	private Long r1ExpiresIn;//R1过期时间
	private Long r2ExpiresIn;//R2过期时间
	private Long w1ExpiresIn;//W1过期时间
	private Long w2ExpiresIn;//W2过期时间
	private Long subTaobaoUserId;//子账号用户ID
	private String subTaobaoUserNick;//子账号nick
	private String remark;//
	private String remark10;//
	private String remark9;//
	private String remark8;//
	private String remark7;//
	private String remark6;//
	private String remark5;//
	private String remark4;//
	private String remark3;//
	private String remark1;//
	private String remark2;//

	 //*************************get/set*****************************
    	/**
  	*
  	*=========================================================
	*@get方法
  	*@
 	*@自动生成
 	*=========================================================
  	*/
    public Long getTsmId() {
        return tsmId;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@
 	*@自动生成
 	*=========================================================
  	*/
    public void setTsmId(Long tsmId) {
        this.tsmId = tsmId;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@
 	*@自动生成
 	*=========================================================
  	*/
    public String getNick() {
        return nick;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@
 	*@自动生成
 	*=========================================================
  	*/
    public void setNick(String nick) {
        this.nick = nick;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@
 	*@自动生成
 	*=========================================================
  	*/
    public String getAppkey() {
        return appkey;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@
 	*@自动生成
 	*=========================================================
  	*/
    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@
 	*@自动生成
 	*=========================================================
  	*/
    public String getSecret() {
        return secret;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@
 	*@自动生成
 	*=========================================================
  	*/
    public void setSecret(String secret) {
        this.secret = secret;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@
 	*@自动生成
 	*=========================================================
  	*/
    public String getSession() {
        return session;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@
 	*@自动生成
 	*=========================================================
  	*/
    public void setSession(String session) {
        this.session = session;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@
 	*@自动生成
 	*=========================================================
  	*/
    public Long getShopId() {
        return shopId;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@
 	*@自动生成
 	*=========================================================
  	*/
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@
 	*@自动生成
 	*=========================================================
  	*/
    public Long getUserId() {
        return userId;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@
 	*@自动生成
 	*=========================================================
  	*/
    public void setUserId(Long userId) {
        this.userId = userId;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@
 	*@自动生成
 	*=========================================================
  	*/
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@
 	*@自动生成
 	*=========================================================
  	*/
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@
 	*@自动生成
 	*=========================================================
  	*/
    public java.util.Date getFreshTime() {
        return freshTime;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@
 	*@自动生成
 	*=========================================================
  	*/
    public void setFreshTime(java.util.Date freshTime) {
        this.freshTime = freshTime;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@RefreshToken过期时间
 	*@自动生成
 	*=========================================================
  	*/
    public Long getReExpiresIn() {
        return reExpiresIn;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@RefreshToken过期时间
 	*@自动生成
 	*=========================================================
  	*/
    public void setReExpiresIn(Long reExpiresIn) {
        this.reExpiresIn = reExpiresIn;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@Access类型
 	*@自动生成
 	*=========================================================
  	*/
    public String getTokenType() {
        return tokenType;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@Access类型
 	*@自动生成
 	*=========================================================
  	*/
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@Access过期时间
 	*@自动生成
 	*=========================================================
  	*/
    public Long getExpiresIn() {
        return expiresIn;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@Access过期时间
 	*@自动生成
 	*=========================================================
  	*/
    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@R1过期时间
 	*@自动生成
 	*=========================================================
  	*/
    public Long getR1ExpiresIn() {
        return r1ExpiresIn;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@R1过期时间
 	*@自动生成
 	*=========================================================
  	*/
    public void setR1ExpiresIn(Long r1ExpiresIn) {
        this.r1ExpiresIn = r1ExpiresIn;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@R2过期时间
 	*@自动生成
 	*=========================================================
  	*/
    public Long getR2ExpiresIn() {
        return r2ExpiresIn;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@R2过期时间
 	*@自动生成
 	*=========================================================
  	*/
    public void setR2ExpiresIn(Long r2ExpiresIn) {
        this.r2ExpiresIn = r2ExpiresIn;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@W1过期时间
 	*@自动生成
 	*=========================================================
  	*/
    public Long getW1ExpiresIn() {
        return w1ExpiresIn;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@W1过期时间
 	*@自动生成
 	*=========================================================
  	*/
    public void setW1ExpiresIn(Long w1ExpiresIn) {
        this.w1ExpiresIn = w1ExpiresIn;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@W2过期时间
 	*@自动生成
 	*=========================================================
  	*/
    public Long getW2ExpiresIn() {
        return w2ExpiresIn;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@W2过期时间
 	*@自动生成
 	*=========================================================
  	*/
    public void setW2ExpiresIn(Long w2ExpiresIn) {
        this.w2ExpiresIn = w2ExpiresIn;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@子账号用户ID
 	*@自动生成
 	*=========================================================
  	*/
    public Long getSubTaobaoUserId() {
        return subTaobaoUserId;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@子账号用户ID
 	*@自动生成
 	*=========================================================
  	*/
    public void setSubTaobaoUserId(Long subTaobaoUserId) {
        this.subTaobaoUserId = subTaobaoUserId;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@子账号nick
 	*@自动生成
 	*=========================================================
  	*/
    public String getSubTaobaoUserNick() {
        return subTaobaoUserNick;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@子账号nick
 	*@自动生成
 	*=========================================================
  	*/
    public void setSubTaobaoUserNick(String subTaobaoUserNick) {
        this.subTaobaoUserNick = subTaobaoUserNick;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@
 	*@自动生成
 	*=========================================================
  	*/
    public String getRemark() {
        return remark;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@
 	*@自动生成
 	*=========================================================
  	*/
    public void setRemark(String remark) {
        this.remark = remark;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@
 	*@自动生成
 	*=========================================================
  	*/
    public String getRemark10() {
        return remark10;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@
 	*@自动生成
 	*=========================================================
  	*/
    public void setRemark10(String remark10) {
        this.remark10 = remark10;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@
 	*@自动生成
 	*=========================================================
  	*/
    public String getRemark9() {
        return remark9;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@
 	*@自动生成
 	*=========================================================
  	*/
    public void setRemark9(String remark9) {
        this.remark9 = remark9;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@
 	*@自动生成
 	*=========================================================
  	*/
    public String getRemark8() {
        return remark8;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@
 	*@自动生成
 	*=========================================================
  	*/
    public void setRemark8(String remark8) {
        this.remark8 = remark8;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@
 	*@自动生成
 	*=========================================================
  	*/
    public String getRemark7() {
        return remark7;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@
 	*@自动生成
 	*=========================================================
  	*/
    public void setRemark7(String remark7) {
        this.remark7 = remark7;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@
 	*@自动生成
 	*=========================================================
  	*/
    public String getRemark6() {
        return remark6;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@
 	*@自动生成
 	*=========================================================
  	*/
    public void setRemark6(String remark6) {
        this.remark6 = remark6;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@
 	*@自动生成
 	*=========================================================
  	*/
    public String getRemark5() {
        return remark5;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@
 	*@自动生成
 	*=========================================================
  	*/
    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@
 	*@自动生成
 	*=========================================================
  	*/
    public String getRemark4() {
        return remark4;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@
 	*@自动生成
 	*=========================================================
  	*/
    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@
 	*@自动生成
 	*=========================================================
  	*/
    public String getRemark3() {
        return remark3;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@
 	*@自动生成
 	*=========================================================
  	*/
    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@
 	*@自动生成
 	*=========================================================
  	*/
    public String getRemark1() {
        return remark1;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@
 	*@自动生成
 	*=========================================================
  	*/
    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }
	/**
  	*
  	*=========================================================
	*@get方法
  	*@
 	*@自动生成
 	*=========================================================
  	*/
    public String getRemark2() {
        return remark2;
    }

    /**
  	*
  	*=========================================================
  	*@set方法
	*@
 	*@自动生成
 	*=========================================================
  	*/
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }
}
