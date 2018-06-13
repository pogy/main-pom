package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.order.vo
 * @ClassName: OrderSubMoney
 * @Author: sy
 * @CreateDate: 2018/5/25 0025 14:32
 */
public class OrderSubMoney implements Serializable{
    private Integer num;
    private Long price;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
