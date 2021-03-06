package com.shigu.main4.order.bo;

import java.io.Serializable;

/**
 * 类名：VoucherBO
 * 类路径： com.shigu.main4.order.bo.VoucherBO
 * 创建者： whx
 * 创建时间： 7/18/18 4:59 PM
 * 项目： main-pom
 * 描述： 用以生成优惠券/代金券
 */
public class VoucherBO implements Serializable {

    /**
     * 获得优惠券的用户 必须
     */
    private Long userId;

    /**
     * 优惠券识别标识，代表代金券来源并防止重复生成优惠券，可以为赠送优惠券的活动标记或代金券号码等 必须
     */
    private String voucherTag;

    /**
     * 优惠券金额，分为单位 必须
     */
    private Long voucherAmount;

    /**
     * 有效期，天为单位 默认为30天
     */
    private Integer guaranteePeriod;

    /**
     * 惠券信息 在前端显示给用户优惠信息 如填写邀请码注册首单减免 必须
     */
    private String voucherInfo;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getVoucherTag() {
        return voucherTag;
    }

    public void setVoucherTag(String voucherTag) {
        this.voucherTag = voucherTag;
    }

    public Long getVoucherAmount() {
        if (voucherAmount == null || voucherAmount < 0L) {
            voucherAmount = 0L;
        }
        return voucherAmount;
    }

    public void setVoucherAmount(Long voucherAmount) {
        this.voucherAmount = voucherAmount;
    }

    public Integer getGuaranteePeriod() {
        if (guaranteePeriod == null || guaranteePeriod < 0) {
            guaranteePeriod = 30;
        }
        return guaranteePeriod;
    }

    public void setGuaranteePeriod(Integer guaranteePeriod) {
        this.guaranteePeriod = guaranteePeriod;
    }

    public String getVoucherInfo() {
        return voucherInfo;
    }

    public void setVoucherInfo(String voucherInfo) {
        this.voucherInfo = voucherInfo;
    }
}
