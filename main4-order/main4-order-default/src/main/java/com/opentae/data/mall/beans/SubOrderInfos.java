package com.opentae.data.mall.beans;

import java.util.List;

/**
 * Created by Administrator on 2017/7/28 0028.
 */
public class SubOrderInfos extends ItemOrderSub{

    private List<ItemOrderRefund> itemOrderRefund;

    public List<ItemOrderRefund> getItemOrderRefund() {
        return itemOrderRefund;
    }

    public void setItemOrderRefund(List<ItemOrderRefund> itemOrderRefund) {
        this.itemOrderRefund = itemOrderRefund;
    }
}
