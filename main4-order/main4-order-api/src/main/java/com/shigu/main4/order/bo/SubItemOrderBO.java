package com.shigu.main4.order.bo;

import com.shigu.main4.order.vo.ItemProductVO;

import java.io.Serializable;

/**
 * 子订单参数
 * Created by zhaohongbo on 17/6/1.
 */
public class SubItemOrderBO implements Serializable{
    /**
     * 产品
     */
    private ItemProductVO productVO;
    /**
     * 产品数量
     */
    private Integer num;
    /**
     * 备注
     */
    private String mark;

    public ItemProductVO getProductVO() {
        return productVO;
    }

    public void setProductVO(ItemProductVO productVO) {
        this.productVO = productVO;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
