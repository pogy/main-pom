package com.shigu.main4.pay.exceptions;

import com.openJar.exceptions.OpenException;
import com.shigu.main4.pay.enums.XzbPayTradeError;

/**
 * 类名：XzbPayException
 * 类路径： com.shigu.main4.pay.exceptions.XzbPayException
 * 创建者： whx
 * 创建时间： 8/9/18 5:16 PM
 * 项目： main-pom
 * 描述：
 */
public class XzbPayException extends OpenException {
    private String code;
    private String msg;

    private Long payId;
    private Long totalFee;

    private String useVolumes;

    /**
     * 交易类型，1充值，2买入，3退款，4提现，5系统扣款，6打拿货款，7打邮费，8打代发费
     */
    private Integer tradeType;

    /**
     * 扣款种类，1支付宝扣款，2星座宝扣款，3微信扣款，4抵价卷扣款，5星座宝卷混合付款
     */
    private Integer tradedebitType;

    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }

    public Integer getTradeType() {
        return tradeType;
    }

    public void setTradeType(Integer tradeType) {
        this.tradeType = tradeType;
    }

    public Integer getTradedebitType() {
        return tradedebitType;
    }

    public void setTradedebitType(Integer tradedebitType) {
        this.tradedebitType = tradedebitType;
    }

    public XzbPayException() {
    }

    public XzbPayException(XzbPayTradeError err) {
        this.code=err.getCode();
        this.msg=err.getMsg();
    }

    public Long getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Long totalFee) {
        this.totalFee = totalFee;
    }

    public String getUseVolumes() {
        return useVolumes;
    }

    public void setUseVolumes(String useVolumes) {
        this.useVolumes = useVolumes;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
