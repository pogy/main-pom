package com.shigu.main4.order.mq.msg;

import java.io.Serializable;

/**
 * 类名：HaveTimeMessage
 * 类路径：com.shigu.main4.order.mq.msg.HaveTimeMessage
 * 创建者：王浩翔
 * 创建时间：2017-09-30 10:25
 * 项目：main-pom
 * 描述：设置有货时间消息
 */
public class HaveTimeMessage implements Serializable {

    // 订单系统拆单ID
    private Long psoid;
    // 有货时间yyyy-MM-dd
    private String day;

    public Long getPsoid() {
        return psoid;
    }

    public void setPsoid(Long psoid) {
        this.psoid = psoid;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
