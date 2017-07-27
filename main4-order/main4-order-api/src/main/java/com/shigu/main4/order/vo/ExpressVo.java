package com.shigu.main4.order.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @类编号
 * @类名称：ExpressVo
 * @文件路径：com.shigu.main4.order.vo.ExpressVo
 * @内容摘要：
 * @编码作者：gzy
 * @创建日期：2017/7/14 17:32
 * @version: main-pom
 * @since: main-pom
 * @commonents:
 */
public class ExpressVo implements Serializable{
    /**
     * 快递ID
     */
    private Long expressId;
    /**
     * 快递名
     */
    private String expressName;
    /**
     * 退回快递填写的时间戳
     */
    private Long returnableExpressTime;

    /**
     * 获取 快递ID
     */
    public Long getExpressId() {
        return this.expressId;
    }

    /**
     * 设置 快递ID
     */
    public void setExpressId(Long expressId) {
        this.expressId = expressId;
    }

    /**
     * 获取 快递名
     */
    public String getExpressName() {
        return this.expressName;
    }

    /**
     * 设置 快递名
     */
    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    /**
     * 获取 退回快递填写的时间戳
     */
    public Long getReturnableExpressTime() {
        return this.returnableExpressTime;
    }

    /**
     * 设置 退回快递填写的时间戳
     */
    public void setReturnableExpressTime(Long returnableExpressTime) {
        this.returnableExpressTime = returnableExpressTime;
    }
}
