package com.shigu.main4.order.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.order.vo
 * @ClassName: editExpressTemplate
 * @Author: sy
 * @CreateDate: 2018/4/8 0008 18:00
 */
public class editExpressTemplate implements Serializable{

    Long courierId;
    Boolean initiateIs;
    List<editDefaultRuleVo> editDefaultRuleVos;
    List<ParentRuleGroup> parentRuleGroups;

    public Long getCourierId() {
        return courierId;
    }

    public void setCourierId(Long courierId) {
        this.courierId = courierId;
    }

    public Boolean getInitiateIs() {
        return initiateIs;
    }

    public void setInitiateIs(Boolean initiateIs) {
        this.initiateIs = initiateIs;
    }

    public List<editDefaultRuleVo> getEditDefaultRuleVos() {
        return editDefaultRuleVos;
    }

    public void setEditDefaultRuleVos(List<editDefaultRuleVo> editDefaultRuleVos) {
        this.editDefaultRuleVos = editDefaultRuleVos;
    }

    public List<ParentRuleGroup> getParentRuleGroups() {
        return parentRuleGroups;
    }

    public void setParentRuleGroups(List<ParentRuleGroup> parentRuleGroups) {
        this.parentRuleGroups = parentRuleGroups;
    }
}
