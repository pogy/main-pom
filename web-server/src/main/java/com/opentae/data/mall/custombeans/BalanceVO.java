package com.opentae.data.mall.custombeans;

import java.io.Serializable;

/**
 * 描述：用户余额
 * 项目：main-pom
 * 类路径： com.opentae.data.mall.custombeans.BalanceVO
 * 创建人：wanghaoxiang
 * 时间： 18-1-17 下午2:14
 **/
public class BalanceVO implements Serializable {

    /**
     * 用户可用余额
     */
    private Long money;
    /**
     * 用户冻结余额
     */
    private Long blockMoney;

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Long getBlockMoney() {
        return blockMoney;
    }

    public void setBlockMoney(Long blockMoney) {
        this.blockMoney = blockMoney;
    }
}