package com.shigu.daifa.vo;

import java.io.Serializable;

/**
 * Created by pc on 2017-08-23.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class OrderStatisticsVO implements Serializable {
    /**
     * 今日订单总数
     */
    private Integer totalNumber;
    /**
     * 今日订单总金额
     */
    private String totalMoney;
    /**
     * 今日发货数量
     */
    private Integer sendNumber;
    /**
     *发货金额
     */
    private String sendMoney;

    /**
     * 今日缺货件数
     */
    private Integer stockoutNumber;

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getSendNumber() {
        return sendNumber;
    }

    public void setSendNumber(Integer sendNumber) {
        this.sendNumber = sendNumber;
    }

    public String getSendMoney() {
        return sendMoney;
    }

    public void setSendMoney(String sendMoney) {
        this.sendMoney = sendMoney;
    }

    public Integer getStockoutNumber() {
        return stockoutNumber;
    }

    public void setStockoutNumber(Integer stockoutNumber) {
        this.stockoutNumber = stockoutNumber;
    }
}
