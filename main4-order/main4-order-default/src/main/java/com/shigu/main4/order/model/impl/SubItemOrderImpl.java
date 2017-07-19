package com.shigu.main4.order.model.impl;

import com.shigu.main4.order.model.SubItemOrder;
import com.shigu.main4.order.vo.SubItemOrderVO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by zhaohongbo on 17/7/19.
 */
@Service
@Scope("prototype")
public class SubItemOrderImpl implements SubItemOrder{

    private Long subOrderId;

    @Override
    public void sended() {

    }

    @Override
    public void closed() {

    }

    @Override
    public void refund(Long money) {

    }

    @Override
    public void addMark(String msg) {

    }

    @Override
    public SubItemOrderVO subOrderInfo() {
        return null;
    }

    public Long getSubOrderId() {
        return subOrderId;
    }

    public void setSubOrderId(Long subOrderId) {
        this.subOrderId = subOrderId;
    }
}
