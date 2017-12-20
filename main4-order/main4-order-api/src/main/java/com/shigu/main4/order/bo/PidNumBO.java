package com.shigu.main4.order.bo;

import java.io.Serializable;

/**
 * 产品id带数量
 * Created by zhaohongbo on 17/6/2.
 */
public class PidNumBO implements Serializable{

    private Long pid;

    private Integer num;

    private Long weight;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }
}
