package com.shigu.buyer.bo;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 描述：新提现请求BO
 * 工程：main-pom
 * 类路径：com.shigu.buyer.bo.NewCashApplyBO
 * 创建人：wanghaoxiang 17-12-15 下午4:45
 */
public class NewCashApplyBO implements Serializable {

    //用户支付宝绑定id
    @NotNull(message = "请求数据错误")
    private Long alipayId;
    //申请提现金额（元）
    @NotNull(message = "申请金额错误")
    private Double paynum;
    //支付密码
    @NotNull(message = "支付密码错误")
    private String payPassword;

    public Long getAlipayId() {
        return alipayId;
    }

    public void setAlipayId(Long alipayId) {
        this.alipayId = alipayId;
    }

    public Double getPaynum() {
        return paynum;
    }

    public void setPaynum(Double paynum) {
        this.paynum = paynum;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }
}
