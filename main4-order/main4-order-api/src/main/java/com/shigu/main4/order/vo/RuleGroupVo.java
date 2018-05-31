package com.shigu.main4.order.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: main-pom
 * @Package: com.shigu.main4.daifa.vo
 * @ClassName: RuleGroupVo
 * @Author: sy
 * @CreateDate: 2018/4/4 0004 9:19
 */
public class RuleGroupVo implements Serializable{

    private Long groupId;
    private List<CostFeeRuleVo> costFeeList;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public List<CostFeeRuleVo> getCostFeeList() {
        return costFeeList;
    }

    public void setCostFeeList(List<CostFeeRuleVo> costFeeList) {
        this.costFeeList = costFeeList;
    }
}
