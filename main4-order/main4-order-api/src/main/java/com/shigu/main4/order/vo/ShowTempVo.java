package com.shigu.main4.order.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.daifa.vo
 * @ClassName: ShowTempVo
 * @Author: sy
 * @CreateDate: 2018/4/4 0004 14:36
 */
public class ShowTempVo implements Serializable{
    private Long tempId;
    private Long courierId;
    private String courierName;
    private Boolean initiateIs;
    private List<CourierRuleVo> provsListByTemp;

    public Long getTempId() {
        return tempId;
    }

    public void setTempId(Long tempId) {
        this.tempId = tempId;
    }

    public Long getCourierId() {
        return courierId;
    }

    public void setCourierId(Long courierId) {
        this.courierId = courierId;
    }

    public String getCourierName() {
        return courierName;
    }

    public void setCourierName(String courierName) {
        this.courierName = courierName;
    }

    public Boolean getInitiateIs() {
        return initiateIs;
    }

    public void setInitiateIs(Boolean initiateIs) {
        this.initiateIs = initiateIs;
    }

    public List<CourierRuleVo> getProvsListByTemp() {
        return provsListByTemp;
    }

    public void setProvsListByTemp(List<CourierRuleVo> provsListByTemp) {
        this.provsListByTemp = provsListByTemp;
    }
}
