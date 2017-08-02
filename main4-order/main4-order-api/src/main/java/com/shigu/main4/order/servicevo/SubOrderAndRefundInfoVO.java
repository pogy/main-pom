package com.shigu.main4.order.servicevo;

import java.util.List;

/**
 * Created by wanghaoxiang on 2017/8/2 0002.
 */
public class SubOrderAndRefundInfoVO {

    /**
     * 子单对象封装
     */
    private SubOrderBoxingVO subOrder;

    /**
     * 子单退单信息封装
     */
    private List<SubOrderRefundBoxingVO> refunds;

    public SubOrderBoxingVO getSubOrder() {
        return subOrder;
    }

    public void setSubOrder(SubOrderBoxingVO subOrder) {
        this.subOrder = subOrder;
    }

    public List<SubOrderRefundBoxingVO> getRefunds() {
        return refunds;
    }

    public void setRefunds(List<SubOrderRefundBoxingVO> refunds) {
        this.refunds = refunds;
    }
}
