package com.shigu.main4.pay.dtos;

import java.io.Serializable;

/**
 * 类名：UserFreeCashInfo
 * 类路径： com.shigu.main4.pay.dtos.UserFreeCashInfo
 * 创建者： whx
 * 创建时间： 8/10/18 3:40 PM
 * 项目： main-pom
 * 描述：
 */
public class UserFreeCashInfo implements Serializable {
    //提现记录ID
    private Long cashId;
    //提现金额
    private Long cashMoney;

    public Long getCashId() {
        return cashId;
    }

    public void setCashId(Long cashId) {
        this.cashId = cashId;
    }

    public Long getCashMoney() {
        return cashMoney;
    }

    public void setCashMoney(Long cashMoney) {
        this.cashMoney = cashMoney;
    }
}