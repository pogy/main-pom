package com.shigu.main4.pay.configs;

/**
 * 类名：DisposeBean
 * 类路径： com.shigu.main4.pay.configs.DisposeBean
 * 创建者： whx
 * 创建时间： 8/8/18 3:01 PM
 * 项目： main-pom
 * 描述：提现配置信息
 */
public class DisposeBean {
    //每月最大免费提现次数
    private Integer maxFreeTimes;
    //单笔提现最大金额(分)
    private Long maxCashMoney;


    public Integer getMaxFreeTimes() {
        if (maxFreeTimes == null) {
            return 0;
        }
        return maxFreeTimes;
    }

    public void setMaxFreeTimes(Integer maxFreeTimes) {
        this.maxFreeTimes = maxFreeTimes;
    }

    public Long getMaxCashMoney() {
        if (maxCashMoney == null) {
            return 200000L;
        }
        return maxCashMoney;
    }

    public void setMaxCashMoney(Long maxCashMoney) {
        this.maxCashMoney = maxCashMoney;
    }
}
