package com.shigu.main4.order.mq.msg;

import java.io.Serializable;
import java.util.List;

/**
 * 退款子单信息
 * Created by bugzy on 2017/8/14 0014.
 */
public class SubOrderMessage implements Serializable {

    /**
     * 子单id
     */
    private Long soid;

    private List<Long> soidps;

    /**
     * 退货数量
     */
    private Integer num;
    /**
     * 单价，单件 退款，仅在退货中使用
     */
    private Long singleMoney;

    public Long getSoid() {
        return soid;
    }

    public void setSoid(Long soid) {
        this.soid = soid;
    }

    public Long getSingleMoney() {
        return singleMoney;
    }

    public void setSingleMoney(Long singleMoney) {
        this.singleMoney = singleMoney;
    }

    public List<Long> getSoidps() {
        return soidps;
    }

    public void setSoidps(List<Long> soidps) {
        this.soidps = soidps;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
