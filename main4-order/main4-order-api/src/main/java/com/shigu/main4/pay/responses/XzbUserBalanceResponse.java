package com.shigu.main4.pay.responses;

import java.io.Serializable;

/**
 * 类名：XzbUserBalanceResponse
 * 类路径： com.shigu.main4.pay.responses.XzbUserBalanceResponse
 * 创建者： whx
 * 创建时间： 8/7/18 3:34 PM
 * 项目： main-pom
 * 描述： 用户余额查询
 */
public class XzbUserBalanceResponse extends XzbResponse implements Serializable {
    private String balance;

    private String blockMoney;

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getBlockMoney() {
        return blockMoney;
    }

    public void setBlockMoney(String blockMoney) {
        this.blockMoney = blockMoney;
    }
}
