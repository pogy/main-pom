package com.opentae.data.mana.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 白名单管理
 * Created by zhaohongbo on 16/5/20.
 */
public class ManagerWhiteip {

    /**
     * 唯一主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long wipId;
    /**
     * 接口ID
     */
    private Long jkId;
    /**
     * 白名单IP
     */
    private String whiteIp;
    /**
     * 是否线上服务器，1是0不是
     */
    private Integer online;
    /**
     * 是否聚石塔服务器，1是0不是
     */
    private Integer taeServer;

    /**
     * 备注
     */
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getWipId() {
        return wipId;
    }

    public void setWipId(Long wipId) {
        this.wipId = wipId;
    }

    public Long getJkId() {
        return jkId;
    }

    public void setJkId(Long jkId) {
        this.jkId = jkId;
    }

    public String getWhiteIp() {
        return whiteIp;
    }

    public void setWhiteIp(String whiteIp) {
        this.whiteIp = whiteIp;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    public Integer getTaeServer() {
        return taeServer;
    }

    public void setTaeServer(Integer taeServer) {
        this.taeServer = taeServer;
    }
}
