package com.shigu.main4.order.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.daifa.vo
 * @ClassName: ExpressTemplateSaveVo
 * @Author: sy
 * @CreateDate: 2018/4/4 0004 9:43
 */
public class ExpressTemplateSaveVo implements Serializable{

    private Long tempId;
    private Long courierId;
    private boolean initiateIs;
    private List<defaultRule> freightList;
    private List<RuleGroupVo> groupList;

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

    public boolean isInitiateIs() {
        return initiateIs;
    }

    public void setInitiateIs(boolean initiateIs) {
        this.initiateIs = initiateIs;
    }

    public List<defaultRule> getFreightList() {
        return freightList;
    }

    public void setFreightList(List<defaultRule> freightList) {
        this.freightList = freightList;
    }

    public List<RuleGroupVo> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<RuleGroupVo> groupList) {
        this.groupList = groupList;
    }
}
