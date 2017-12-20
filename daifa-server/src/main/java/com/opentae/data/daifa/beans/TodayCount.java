package com.opentae.data.daifa.beans;

import javax.persistence.Column;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * Created by pc on 2017-08-23.
 *
 * @author pc
 * @version 3.0.0-SNAPSHOT
 * @description
 * @since 3.0.0-SNAPSHOT
 */
public class TodayCount implements Serializable{
    @Transient
    private static final long serialVersionUID = -5098696473623754789L;
    private Integer totalNumber;
    private String totalMoney;

    private Integer sendNumber;
    private String sendMoney;

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
}
