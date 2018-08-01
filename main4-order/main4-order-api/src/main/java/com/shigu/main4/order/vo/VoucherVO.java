package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * 类名：VoucherVO
 * 类路径： com.shigu.main4.order.vo.VoucherVO
 * 创建者： whx
 * 创建时间： 7/20/18 2:39 PM
 * 项目： main-pom
 * 描述：
 */
public class VoucherVO implements Serializable {

    // 优惠券id
    public Long voucherId;

    // 优惠信息
    public String voucherInfo;

    // 优惠金额
    public Long voucherAmount;


    public Long getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Long voucherId) {
        this.voucherId = voucherId;
    }

    public String getVoucherInfo() {
        return voucherInfo;
    }

    public void setVoucherInfo(String voucherInfo) {
        this.voucherInfo = voucherInfo;
    }

    public Long getVoucherAmount() {
        return voucherAmount;
    }

    public void setVoucherAmount(Long voucherAmount) {
        this.voucherAmount = voucherAmount;
    }
}
