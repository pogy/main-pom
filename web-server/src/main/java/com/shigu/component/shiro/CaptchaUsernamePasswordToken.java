package com.shigu.component.shiro;



import com.shigu.component.shiro.enums.UserType;
import com.shigu.session.main4.enums.LoginFromType;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 自定义登陆令牌
 * @author zjb
 */
public class CaptchaUsernamePasswordToken extends UsernamePasswordToken {
	/** 描述 */
	private static final long serialVersionUID = -3178260335127476542L;

	private String loginname;
	/**
	 * 验证码
	 */
	private String captcha;
	/**
	 * 登陆方式
	 * 管理员用户,或者普通用户
	 */
	private UserType loginType;
	/**
	 * 登陆来源,淘宝、阿里、微信、QQ、星座网、手机验证码
	 */
	private LoginFromType loginFromType;
	/**
	 * 如果是第三方登陆，传个key
	 */
	private String subKey;

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getSubKey() {
		return subKey;
	}

	public void setSubKey(String subKey) {
		this.subKey = subKey;
	}

	public LoginFromType getLoginFromType() {
		return loginFromType;
	}

	public void setLoginFromType(LoginFromType loginFromType) {
		this.loginFromType = loginFromType;
	}

	public UserType getLoginType() {
		return loginType;
	}

	public void setLoginType(UserType loginType) {
		this.loginType = loginType;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public CaptchaUsernamePasswordToken() {
		super();
	}


	public CaptchaUsernamePasswordToken(String username,
										boolean rememberMe, String host, String subkey) {
		super(username, "".toCharArray(), rememberMe, host);
		this.subKey = subkey;
	}

	public CaptchaUsernamePasswordToken(String username, String password,
			boolean rememberMe, String host, String captcha) {
		super(username, password, rememberMe, host);
		this.captcha = captcha;
	}

	public CaptchaUsernamePasswordToken(String username, String password, boolean rememberMe, String host, UserType loginType) {
		super(username, password, rememberMe, host);
		this.loginType = loginType;
	}

	public CaptchaUsernamePasswordToken(String username, String password, boolean rememberMe, String host, String captcha, UserType loginType) {
		super(username, password, rememberMe, host);
		this.captcha = captcha;
		this.loginType = loginType;
	}

	public CaptchaUsernamePasswordToken(String loginname,String username, String password, boolean rememberMe, String host, String captcha, UserType loginType) {
		super(username, password, rememberMe, host);
		this.loginname = loginname;
		this.captcha = captcha;
		this.loginType = loginType;
	}
}
