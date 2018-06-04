package com.shigu.main4.order.vo;

import java.io.Serializable;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.daifa.vo
 * @ClassName: CourierShowVo
 * @Author: sy
 * @CreateDate: 2018/4/4 0004 14:29
 */
public class CourierShowVo implements Serializable{
    private String text;
    private Double freight;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }
}
