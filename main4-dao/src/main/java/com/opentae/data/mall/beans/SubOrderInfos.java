package com.opentae.data.mall.beans;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28 0028.
 */
public class SubOrderInfos{

    private ItemOrderSub itemOrderSub;
    private List<ItemOrderRefund> itemOrderRefund;

    public ItemOrderSub getItemOrderSub() {
        return itemOrderSub;
    }

    public void setItemOrderSub(ItemOrderSub itemOrderSub) {
        this.itemOrderSub = itemOrderSub;
    }

    public List<ItemOrderRefund> getItemOrderRefund() {
        return itemOrderRefund;
    }

    public void setItemOrderRefund(List<ItemOrderRefund> itemOrderRefund) {
        this.itemOrderRefund = itemOrderRefund;
    }
}
