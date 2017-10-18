package com.shigu.phone.basebo;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created By pc on 2017-10-18/9:43
 */
public class BindUserBO implements Serializable {
    //临时ID，第三方登陆以后能过链接返回	必须
    private String tempId;
    //手机号	必须
    private String telephone;
    //验证码	必须
    private String code;
    //绑定类型:淘宝&nbsp;TAOBAO,qq&nbsp;QQ,微信&nbsp;WX,阿里&nbsp;ALI,星座&nbsp;XZ,手机&nbsp;PHONE	必须
    private String type;
    //第三方用户名
    private String userNick;

    String remoteAddr;

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }
}
