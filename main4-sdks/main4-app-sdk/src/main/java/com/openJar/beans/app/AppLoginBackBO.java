package com.openJar.beans.app;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 类名：AppLoginBackBO
 * 类路径：com.openJar.beans.app.AppLoginBackBO
 * 创建者：任真飞
 * 创建时间：2017-10-20 13:21
 * 项目：main-pom
 * 描述：
 */
public class AppLoginBackBO {
    /**
     * 第三方用户名
     */
    @NotEmpty(message = "第三方用户名不能为空")
    private String nick;
    /**
     * 第三方唯一码
     */
    private String key;
    /**
     * 验签
     */
    @NotEmpty(message = "验证不能为空")
    private String sign;
    /**
     * 类型
     * 1----tb  淘宝
     *
     *2--- wx   微信
     */
    @NotEmpty(message = "第三方登陆类型不能为空")
    private Integer type;
    /**
     *flag值:0为订阅服务,1订阅服务
     */

    private Integer flag;

    public AppLoginBackBO() {
    }

    public AppLoginBackBO( String nick, String key, String sign, Integer type, Integer flag ) {

        this.nick = nick;
        this.key = key;
        this.sign = sign;
        this.type = type;
        this.flag = flag;
    }

    public String getNick() {
        return nick;
    }

    public void setNick( String nick ) {
        this.nick = nick;
    }

    public String getKey() {
        return key;
    }

    public void setKey( String key ) {
        this.key = key;
    }

    public String getSign() {
        return sign;
    }

    public void setSign( String sign ) {
        this.sign = sign;
    }

    public Integer getType() {
        return type;
    }

    public void setType( Integer type ) {
        this.type = type;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag( Integer flag ) {
        this.flag = flag;
    }
}