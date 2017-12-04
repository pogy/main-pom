package com.shigu.main4.ucenter.enums;

/**
 * 用户权益类别
 * Created by zhaohongbo on 17/3/1.
 */
public enum MemberLicenseType {
    REAL_NAME("实名认证",1),EMAIL("邮箱认证",2),
    PASSWORD_SAFE("密码安全",3),PHONE_BIND("手机绑定",4),SCORE("会员积分",5),
    MORE_ORDER("淘宝批量下单和订单批量操作",6),
    MEMBER_VIP("分销商VIP用户",7),;

    MemberLicenseType(String title, int value) {
        this.title = title;
        this.value = value;
    }

    /**
     * 获取用户权益类别
     * @param licenseType
     * @return
     */
    public static MemberLicenseType getMemberLicenseType(int licenseType) {
        for (MemberLicenseType c : MemberLicenseType.values()) {
            if (c.getValue() == licenseType) {
                return c;
            }
        }
        return null;
    }

    private String title;

    private int value;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
