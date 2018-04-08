package com.shigu.main4.daifa.vo;

import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.daifa.vo
 * @ClassName: ParentRuleGroup
 * @Author: sy
 * @CreateDate: 2018/4/4 0004 17:13
 */
public class ParentRuleGroup {
    private Long groupId;
    private String provs;
    private String provIds;
    private List<CostFeeRuleVo> costFeeList;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getProvs() {
        return provs;
    }

    public void setProvs(String provs) {
        this.provs = provs;
    }

    public String getProvIds() {
        return provIds;
    }

    public void setProvIds(String provIds) {
        this.provIds = provIds;
    }

    public List<CostFeeRuleVo> getCostFeeList() {
        return costFeeList;
    }

    public void setCostFeeList(List<CostFeeRuleVo> costFeeList) {
        this.costFeeList = costFeeList;
    }
}
