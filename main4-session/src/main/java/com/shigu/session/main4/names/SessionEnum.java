package com.shigu.session.main4.names;

/**
 * session的枚举
 * Created by zhaohongbo on 17/2/15.
 */
public enum SessionEnum {

    LOGIN_SESSION_USER("用户登陆的session","session_user_redis__"),
    SYS_USER("系统登陆用户session","sysuser_redis__"),
    PHONE_LOGIN_SESSION("手机号码登陆时，验证码存放session","phone_login_session"),
    PHONE_FORGET_MSG("忘记密码时，验证码存放session","phone_forget_msg"),
    PHONE_REGISTER_MSG("注册手机验证","phone_register_msg"),
    PHONE_BIND_MSG("第三方绑定,短信验证","phone_bind_msg"),
    PHONE_LOGIN_MSG("手机登陆,短信内容","phone_login_msg"),
    SEND_REGISTER_MSG("发送短信前验证码","send_register_msg"),
    RDS3_TEMPUSER("第3方登陆成功以后，用户不存在，临时存储","rds3_tempuser"),
    OTHEER_LOGIN_CALLBACK("第三方用户登陆时的回调地址 ，本来不想放这里，但不放要改的系统太多","other_login_callback"),

    ITEM_GOODS_ID("请求商品详情页面时暂存商品ID","ITEM_GOODS_ID");

    SessionEnum(String title, String value) {
        this.title = title;
        this.value = value;
    }

    /**
     * 标题
     */
    private String title;
    /**
     * 值
     */
    private String value;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
