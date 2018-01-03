package com.shigu.buyer.bo;

import javax.validation.constraints.NotNull;

/**
 * 描述：用户支付宝绑定申请,和前端请求字段一致
 * 工程：main-pom
 * 类路径：com.shigu.buyer.bo.MemberAlipayBindBO
 * 创建人：wanghaoxiang 17-12-14 下午5:40
 */
public class MemberAlipayBindBO {

    //支付宝账号
    @NotNull(message = "请输入支付宝帐号")
    private String aliAccount;
    //支付宝真实姓名
    @NotNull(message = "请输入真实姓名")
    private String userRealName;
    //手机验证码
    @NotNull(message = "请输入手机验证码")
    private String teleValidateCode;

    public String getAliAccount() {
        return aliAccount;
    }

    public void setAliAccount(String aliAccount) {
        this.aliAccount = aliAccount;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getTeleValidateCode() {
        return teleValidateCode;
    }

    public void setTeleValidateCode(String teleValidateCode) {
        this.teleValidateCode = teleValidateCode;
    }
}
