package com.opentae.data.mall.beans;

/**
 * Created by Administrator on 2017/7/28 0028.
 */
public class SubOrderInfos extends ItemOrderSub{

    private ItemOrderRefund itemOrderRefund;

    public ItemOrderRefund getItemOrderRefund() {
        return itemOrderRefund;
    }

    public void setItemOrderRefund(ItemOrderRefund itemOrderRefund) {
        this.itemOrderRefund = itemOrderRefund;
    }
}
