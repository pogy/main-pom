package com.shigu.main4.pay.responses;

import java.io.Serializable;

/**
 * 类名：XzbDisposeLimitResponse
 * 类路径： com.shigu.main4.pay.responses.XzbDisposeLimitResponse
 * 创建者： whx
 * 创建时间： 8/8/18 3:08 PM
 * 项目： main-pom
 * 描述：
 */
public class XzbDisposeLimitResponse extends XzbResponse implements Serializable {

    //本月免费提现次数
    private Integer freeWithdrawNum;
    //每次提现上限
    private String withdrawUpperLimit;

    public Integer getFreeWithdrawNum() {
        return freeWithdrawNum;
    }

    public void setFreeWithdrawNum(Integer freeWithdrawNum) {
        this.freeWithdrawNum = freeWithdrawNum;
    }

    public String getWithdrawUpperLimit() {
        return withdrawUpperLimit;
    }

    public void setWithdrawUpperLimit(String withdrawUpperLimit) {
        this.withdrawUpperLimit = withdrawUpperLimit;
    }
}
