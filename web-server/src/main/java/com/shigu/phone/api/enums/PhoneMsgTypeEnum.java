package com.shigu.phone.api.enums;

/**
 * 类名：PhoneMsgTypeEnum
 * 类路径：com.shigu.phone.api.enums.PhoneMsgTypeEnum
 * 创建者：王浩翔
 * 创建时间：2017-09-18 16:28
 * 项目：main-pom
 * 描述：移动端验证码
 */
public enum PhoneMsgTypeEnum {
    PHONE_REGIST_TYPE_MSG("移动端注册验证码","phone_regist_type_msg_")
    ,PHONE_LOGIN_TYPE_MSG("移动端登陆验证码","phone_login_type_msg_")
    ,PHONE_BIND_TYPE_MSG("移动端绑定手机验证码","phone_bind_type_msg_")
    ,PHONE_RDS3_TEMP_USER_TYPE_MSG("移动端第三方登陆信息","phone_rd3_temp_user_type_msg_")
    ,;
    private final String title;
    private final String type;

    PhoneMsgTypeEnum(String title, String type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }
}
