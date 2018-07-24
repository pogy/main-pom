package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ExpressRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class ExpressRuleExample extends SgExample<ExpressRuleExample.Criteria> {
    public static final Class<ExpressRule> beanClass = ExpressRule.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn isDefault;
    public static EntityColumn thresholdFree;
    public static EntityColumn isParentRule;
    public static EntityColumn etId;
    public static EntityColumn ruleType;
    public static EntityColumn parentRuleId;
    public static EntityColumn threshold;
    public static EntityColumn attribute;
    public static EntityColumn ruleTile;
    public static EntityColumn ruleStatus;
    public static EntityColumn rId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        isDefault = listMap.get("isDefault");
        thresholdFree = listMap.get("thresholdFree");
        isParentRule = listMap.get("isParentRule");
        etId = listMap.get("etId");
        ruleType = listMap.get("ruleType");
        parentRuleId = listMap.get("parentRuleId");
        threshold = listMap.get("threshold");
        attribute = listMap.get("attribute");
        ruleTile = listMap.get("ruleTile");
        ruleStatus = listMap.get("ruleStatus");
        rId = listMap.get("rId");
        }

    public ExpressRuleExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ExpressRuleExample.Criteria createCriteriaInternal() {
        return new ExpressRuleExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ExpressRuleExample.Criteria andIsDefaultIsNull() {
            return isNull(isDefault);
        }

        public ExpressRuleExample.Criteria andIsDefaultIsNotNull() {
            return isNotNull(isDefault);
        }

        public ExpressRuleExample.Criteria andIsDefaultEqualTo(Integer value) {
            return equalTo(isDefault, value);
        }

        public ExpressRuleExample.Criteria andIsDefaultNotEqualTo(Integer value) {
            return notEqualTo(isDefault, value);
        }

        public ExpressRuleExample.Criteria andIsDefaultGreaterThan(Integer value) {
            return greaterThan(isDefault, value);
        }

        public ExpressRuleExample.Criteria andIsDefaultGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isDefault, value);
        }

        public ExpressRuleExample.Criteria andIsDefaultLessThan(Integer value) {
            return lessThan(isDefault, value);
        }

        public ExpressRuleExample.Criteria andIsDefaultLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isDefault, value);
        }

        public ExpressRuleExample.Criteria andIsDefaultIn(List<Integer> values) {
            return in(isDefault, values);
        }

        public ExpressRuleExample.Criteria andIsDefaultNotIn(List<Integer> values) {
            return notIn(isDefault, values);
        }

        public ExpressRuleExample.Criteria andIsDefaultBetween(Integer value1, Integer value2) {
            return between(isDefault, value1, value2);
        }

        public ExpressRuleExample.Criteria andIsDefaultNotBetween(Integer value1, Integer value2) {
            return notBetween(isDefault, value1, value2);
        }
        public ExpressRuleExample.Criteria andThresholdFreeIsNull() {
            return isNull(thresholdFree);
        }

        public ExpressRuleExample.Criteria andThresholdFreeIsNotNull() {
            return isNotNull(thresholdFree);
        }

        public ExpressRuleExample.Criteria andThresholdFreeEqualTo(Integer value) {
            return equalTo(thresholdFree, value);
        }

        public ExpressRuleExample.Criteria andThresholdFreeNotEqualTo(Integer value) {
            return notEqualTo(thresholdFree, value);
        }

        public ExpressRuleExample.Criteria andThresholdFreeGreaterThan(Integer value) {
            return greaterThan(thresholdFree, value);
        }

        public ExpressRuleExample.Criteria andThresholdFreeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(thresholdFree, value);
        }

        public ExpressRuleExample.Criteria andThresholdFreeLessThan(Integer value) {
            return lessThan(thresholdFree, value);
        }

        public ExpressRuleExample.Criteria andThresholdFreeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(thresholdFree, value);
        }

        public ExpressRuleExample.Criteria andThresholdFreeIn(List<Integer> values) {
            return in(thresholdFree, values);
        }

        public ExpressRuleExample.Criteria andThresholdFreeNotIn(List<Integer> values) {
            return notIn(thresholdFree, values);
        }

        public ExpressRuleExample.Criteria andThresholdFreeBetween(Integer value1, Integer value2) {
            return between(thresholdFree, value1, value2);
        }

        public ExpressRuleExample.Criteria andThresholdFreeNotBetween(Integer value1, Integer value2) {
            return notBetween(thresholdFree, value1, value2);
        }
        public ExpressRuleExample.Criteria andIsParentRuleIsNull() {
            return isNull(isParentRule);
        }

        public ExpressRuleExample.Criteria andIsParentRuleIsNotNull() {
            return isNotNull(isParentRule);
        }

        public ExpressRuleExample.Criteria andIsParentRuleEqualTo(Integer value) {
            return equalTo(isParentRule, value);
        }

        public ExpressRuleExample.Criteria andIsParentRuleNotEqualTo(Integer value) {
            return notEqualTo(isParentRule, value);
        }

        public ExpressRuleExample.Criteria andIsParentRuleGreaterThan(Integer value) {
            return greaterThan(isParentRule, value);
        }

        public ExpressRuleExample.Criteria andIsParentRuleGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isParentRule, value);
        }

        public ExpressRuleExample.Criteria andIsParentRuleLessThan(Integer value) {
            return lessThan(isParentRule, value);
        }

        public ExpressRuleExample.Criteria andIsParentRuleLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isParentRule, value);
        }

        public ExpressRuleExample.Criteria andIsParentRuleIn(List<Integer> values) {
            return in(isParentRule, values);
        }

        public ExpressRuleExample.Criteria andIsParentRuleNotIn(List<Integer> values) {
            return notIn(isParentRule, values);
        }

        public ExpressRuleExample.Criteria andIsParentRuleBetween(Integer value1, Integer value2) {
            return between(isParentRule, value1, value2);
        }

        public ExpressRuleExample.Criteria andIsParentRuleNotBetween(Integer value1, Integer value2) {
            return notBetween(isParentRule, value1, value2);
        }
        public ExpressRuleExample.Criteria andEtIdIsNull() {
            return isNull(etId);
        }

        public ExpressRuleExample.Criteria andEtIdIsNotNull() {
            return isNotNull(etId);
        }

        public ExpressRuleExample.Criteria andEtIdEqualTo(Long value) {
            return equalTo(etId, value);
        }

        public ExpressRuleExample.Criteria andEtIdNotEqualTo(Long value) {
            return notEqualTo(etId, value);
        }

        public ExpressRuleExample.Criteria andEtIdGreaterThan(Long value) {
            return greaterThan(etId, value);
        }

        public ExpressRuleExample.Criteria andEtIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(etId, value);
        }

        public ExpressRuleExample.Criteria andEtIdLessThan(Long value) {
            return lessThan(etId, value);
        }

        public ExpressRuleExample.Criteria andEtIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(etId, value);
        }

        public ExpressRuleExample.Criteria andEtIdIn(List<Long> values) {
            return in(etId, values);
        }

        public ExpressRuleExample.Criteria andEtIdNotIn(List<Long> values) {
            return notIn(etId, values);
        }

        public ExpressRuleExample.Criteria andEtIdBetween(Long value1, Long value2) {
            return between(etId, value1, value2);
        }

        public ExpressRuleExample.Criteria andEtIdNotBetween(Long value1, Long value2) {
            return notBetween(etId, value1, value2);
        }
        public ExpressRuleExample.Criteria andRuleTypeIsNull() {
            return isNull(ruleType);
        }

        public ExpressRuleExample.Criteria andRuleTypeIsNotNull() {
            return isNotNull(ruleType);
        }

        public ExpressRuleExample.Criteria andRuleTypeEqualTo(Integer value) {
            return equalTo(ruleType, value);
        }

        public ExpressRuleExample.Criteria andRuleTypeNotEqualTo(Integer value) {
            return notEqualTo(ruleType, value);
        }

        public ExpressRuleExample.Criteria andRuleTypeGreaterThan(Integer value) {
            return greaterThan(ruleType, value);
        }

        public ExpressRuleExample.Criteria andRuleTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(ruleType, value);
        }

        public ExpressRuleExample.Criteria andRuleTypeLessThan(Integer value) {
            return lessThan(ruleType, value);
        }

        public ExpressRuleExample.Criteria andRuleTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(ruleType, value);
        }

        public ExpressRuleExample.Criteria andRuleTypeIn(List<Integer> values) {
            return in(ruleType, values);
        }

        public ExpressRuleExample.Criteria andRuleTypeNotIn(List<Integer> values) {
            return notIn(ruleType, values);
        }

        public ExpressRuleExample.Criteria andRuleTypeBetween(Integer value1, Integer value2) {
            return between(ruleType, value1, value2);
        }

        public ExpressRuleExample.Criteria andRuleTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(ruleType, value1, value2);
        }
        public ExpressRuleExample.Criteria andParentRuleIdIsNull() {
            return isNull(parentRuleId);
        }

        public ExpressRuleExample.Criteria andParentRuleIdIsNotNull() {
            return isNotNull(parentRuleId);
        }

        public ExpressRuleExample.Criteria andParentRuleIdEqualTo(Long value) {
            return equalTo(parentRuleId, value);
        }

        public ExpressRuleExample.Criteria andParentRuleIdNotEqualTo(Long value) {
            return notEqualTo(parentRuleId, value);
        }

        public ExpressRuleExample.Criteria andParentRuleIdGreaterThan(Long value) {
            return greaterThan(parentRuleId, value);
        }

        public ExpressRuleExample.Criteria andParentRuleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentRuleId, value);
        }

        public ExpressRuleExample.Criteria andParentRuleIdLessThan(Long value) {
            return lessThan(parentRuleId, value);
        }

        public ExpressRuleExample.Criteria andParentRuleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentRuleId, value);
        }

        public ExpressRuleExample.Criteria andParentRuleIdIn(List<Long> values) {
            return in(parentRuleId, values);
        }

        public ExpressRuleExample.Criteria andParentRuleIdNotIn(List<Long> values) {
            return notIn(parentRuleId, values);
        }

        public ExpressRuleExample.Criteria andParentRuleIdBetween(Long value1, Long value2) {
            return between(parentRuleId, value1, value2);
        }

        public ExpressRuleExample.Criteria andParentRuleIdNotBetween(Long value1, Long value2) {
            return notBetween(parentRuleId, value1, value2);
        }
        public ExpressRuleExample.Criteria andThresholdIsNull() {
            return isNull(threshold);
        }

        public ExpressRuleExample.Criteria andThresholdIsNotNull() {
            return isNotNull(threshold);
        }

        public ExpressRuleExample.Criteria andThresholdEqualTo(Integer value) {
            return equalTo(threshold, value);
        }

        public ExpressRuleExample.Criteria andThresholdNotEqualTo(Integer value) {
            return notEqualTo(threshold, value);
        }

        public ExpressRuleExample.Criteria andThresholdGreaterThan(Integer value) {
            return greaterThan(threshold, value);
        }

        public ExpressRuleExample.Criteria andThresholdGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(threshold, value);
        }

        public ExpressRuleExample.Criteria andThresholdLessThan(Integer value) {
            return lessThan(threshold, value);
        }

        public ExpressRuleExample.Criteria andThresholdLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(threshold, value);
        }

        public ExpressRuleExample.Criteria andThresholdIn(List<Integer> values) {
            return in(threshold, values);
        }

        public ExpressRuleExample.Criteria andThresholdNotIn(List<Integer> values) {
            return notIn(threshold, values);
        }

        public ExpressRuleExample.Criteria andThresholdBetween(Integer value1, Integer value2) {
            return between(threshold, value1, value2);
        }

        public ExpressRuleExample.Criteria andThresholdNotBetween(Integer value1, Integer value2) {
            return notBetween(threshold, value1, value2);
        }
        public ExpressRuleExample.Criteria andAttributeIsNull() {
            return isNull(attribute);
        }

        public ExpressRuleExample.Criteria andAttributeIsNotNull() {
            return isNotNull(attribute);
        }

        public ExpressRuleExample.Criteria andAttributeEqualTo(String value) {
            return equalTo(attribute, value);
        }

        public ExpressRuleExample.Criteria andAttributeNotEqualTo(String value) {
            return notEqualTo(attribute, value);
        }

        public ExpressRuleExample.Criteria andAttributeGreaterThan(String value) {
            return greaterThan(attribute, value);
        }

        public ExpressRuleExample.Criteria andAttributeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(attribute, value);
        }

        public ExpressRuleExample.Criteria andAttributeLessThan(String value) {
            return lessThan(attribute, value);
        }

        public ExpressRuleExample.Criteria andAttributeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(attribute, value);
        }

        public ExpressRuleExample.Criteria andAttributeLike(String value) {
            return like(attribute, value);
        }

        public ExpressRuleExample.Criteria andAttributeNotLike(String value) {
            return notLike(attribute, value);
        }

        public ExpressRuleExample.Criteria andAttributeIn(List<String> values) {
            return in(attribute, values);
        }

        public ExpressRuleExample.Criteria andAttributeNotIn(List<String> values) {
            return notIn(attribute, values);
        }

        public ExpressRuleExample.Criteria andAttributeBetween(String value1, String value2) {
            return between(attribute, value1, value2);
        }

        public ExpressRuleExample.Criteria andAttributeNotBetween(String value1, String value2) {
            return notBetween(attribute, value1, value2);
        }
        public ExpressRuleExample.Criteria andRuleTileIsNull() {
            return isNull(ruleTile);
        }

        public ExpressRuleExample.Criteria andRuleTileIsNotNull() {
            return isNotNull(ruleTile);
        }

        public ExpressRuleExample.Criteria andRuleTileEqualTo(String value) {
            return equalTo(ruleTile, value);
        }

        public ExpressRuleExample.Criteria andRuleTileNotEqualTo(String value) {
            return notEqualTo(ruleTile, value);
        }

        public ExpressRuleExample.Criteria andRuleTileGreaterThan(String value) {
            return greaterThan(ruleTile, value);
        }

        public ExpressRuleExample.Criteria andRuleTileGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(ruleTile, value);
        }

        public ExpressRuleExample.Criteria andRuleTileLessThan(String value) {
            return lessThan(ruleTile, value);
        }

        public ExpressRuleExample.Criteria andRuleTileLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(ruleTile, value);
        }

        public ExpressRuleExample.Criteria andRuleTileLike(String value) {
            return like(ruleTile, value);
        }

        public ExpressRuleExample.Criteria andRuleTileNotLike(String value) {
            return notLike(ruleTile, value);
        }

        public ExpressRuleExample.Criteria andRuleTileIn(List<String> values) {
            return in(ruleTile, values);
        }

        public ExpressRuleExample.Criteria andRuleTileNotIn(List<String> values) {
            return notIn(ruleTile, values);
        }

        public ExpressRuleExample.Criteria andRuleTileBetween(String value1, String value2) {
            return between(ruleTile, value1, value2);
        }

        public ExpressRuleExample.Criteria andRuleTileNotBetween(String value1, String value2) {
            return notBetween(ruleTile, value1, value2);
        }
        public ExpressRuleExample.Criteria andRuleStatusIsNull() {
            return isNull(ruleStatus);
        }

        public ExpressRuleExample.Criteria andRuleStatusIsNotNull() {
            return isNotNull(ruleStatus);
        }

        public ExpressRuleExample.Criteria andRuleStatusEqualTo(Integer value) {
            return equalTo(ruleStatus, value);
        }

        public ExpressRuleExample.Criteria andRuleStatusNotEqualTo(Integer value) {
            return notEqualTo(ruleStatus, value);
        }

        public ExpressRuleExample.Criteria andRuleStatusGreaterThan(Integer value) {
            return greaterThan(ruleStatus, value);
        }

        public ExpressRuleExample.Criteria andRuleStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(ruleStatus, value);
        }

        public ExpressRuleExample.Criteria andRuleStatusLessThan(Integer value) {
            return lessThan(ruleStatus, value);
        }

        public ExpressRuleExample.Criteria andRuleStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(ruleStatus, value);
        }

        public ExpressRuleExample.Criteria andRuleStatusIn(List<Integer> values) {
            return in(ruleStatus, values);
        }

        public ExpressRuleExample.Criteria andRuleStatusNotIn(List<Integer> values) {
            return notIn(ruleStatus, values);
        }

        public ExpressRuleExample.Criteria andRuleStatusBetween(Integer value1, Integer value2) {
            return between(ruleStatus, value1, value2);
        }

        public ExpressRuleExample.Criteria andRuleStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(ruleStatus, value1, value2);
        }
        public ExpressRuleExample.Criteria andRIdIsNull() {
            return isNull(rId);
        }

        public ExpressRuleExample.Criteria andRIdIsNotNull() {
            return isNotNull(rId);
        }

        public ExpressRuleExample.Criteria andRIdEqualTo(Long value) {
            return equalTo(rId, value);
        }

        public ExpressRuleExample.Criteria andRIdNotEqualTo(Long value) {
            return notEqualTo(rId, value);
        }

        public ExpressRuleExample.Criteria andRIdGreaterThan(Long value) {
            return greaterThan(rId, value);
        }

        public ExpressRuleExample.Criteria andRIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(rId, value);
        }

        public ExpressRuleExample.Criteria andRIdLessThan(Long value) {
            return lessThan(rId, value);
        }

        public ExpressRuleExample.Criteria andRIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(rId, value);
        }

        public ExpressRuleExample.Criteria andRIdIn(List<Long> values) {
            return in(rId, values);
        }

        public ExpressRuleExample.Criteria andRIdNotIn(List<Long> values) {
            return notIn(rId, values);
        }

        public ExpressRuleExample.Criteria andRIdBetween(Long value1, Long value2) {
            return between(rId, value1, value2);
        }

        public ExpressRuleExample.Criteria andRIdNotBetween(Long value1, Long value2) {
            return notBetween(rId, value1, value2);
        }
    }
}