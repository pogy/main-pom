package com.shigu.buyer.vo;

/**
 * 描述：用户绑定支付宝信息
 * 工程：main-pom
 * 类路径：com.shigu.buyer.vo.UserAlipayBindVO
 * 创建人：wanghaoxiang 17-12-14 下午3:06
 */
public class UserAlipayBindVO {
    //用户支付宝绑定id
    private Long aliAccountId;
    //支付宝帐号
    private String aliAccount;
    //绑定支付宝真名
    private String userRealName;

    public Long getAliAccountId() {
        return aliAccountId;
    }

    public void setAliAccountId(Long aliAccountId) {
        this.aliAccountId = aliAccountId;
    }

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
}
