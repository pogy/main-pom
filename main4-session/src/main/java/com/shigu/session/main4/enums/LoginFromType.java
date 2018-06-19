package com.shigu.session.main4.enums;

/**
 * 登陆类型
 * Created by zhaohongbo on 17/2/20.
 */
public enum LoginFromType {
    TAOBAO("淘宝","taobao",3),
    QQ("微信","qq",4),
    WX("微信","wx",5),
    XZ("星座网账号","xz",7),
    ALI("阿里","ali",6),
    PHONE("手机验证码","phone",7),
    SUPER("超级权限无密登陆","supper",-1),
    JD("京东","jd",8),
    PDD("拼多多","pdd",9)

    ;


    LoginFromType(String title, String value,int type) {
        this.title = title;
        this.value = value;
        this.accountType=type;
    }

    /**
     * 标题
     */
    private String title;
    /**
     * 值
     */
    private String value;
    /**
     * 网站里存的标志
     */
    private int accountType;

    // 普通方法
    public static LoginFromType getLoginFromType(int accountType) {
        for (LoginFromType c : LoginFromType.values()) {
            if (c.getAccountType() == accountType) {
                return c;
            }
        }
        return null;
    }


    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

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
