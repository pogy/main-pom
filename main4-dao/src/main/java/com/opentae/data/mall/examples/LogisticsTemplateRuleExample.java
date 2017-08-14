package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class LogisticsTemplateRuleExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<LogisticsTemplateRuleExample.Criteria> oredCriteria = new ArrayList();

    public LogisticsTemplateRuleExample() {
    }

    private Integer startIndex;
    private Integer endIndex;
    private String fields;
    protected String sqlStirng;
    private String webSite;

    public String getWebSite() {
        return this.webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getSqlStirng() {
        return this.sqlStirng;
    }

    public void setSqlStirng(String sqlStirng) {
        this.sqlStirng = sqlStirng;
    }

    public Integer getStartIndex() {
        return this.startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getEndIndex() {
        return this.endIndex;
    }

    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
    }

    public String getFields() {
        return this.fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return this.orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return this.distinct;
    }

    public List<LogisticsTemplateRuleExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(LogisticsTemplateRuleExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public LogisticsTemplateRuleExample.Criteria or() {
        LogisticsTemplateRuleExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public LogisticsTemplateRuleExample.Criteria createCriteria() {
        LogisticsTemplateRuleExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected LogisticsTemplateRuleExample.Criteria createCriteriaInternal() {
        LogisticsTemplateRuleExample.Criteria criteria = new LogisticsTemplateRuleExample.Criteria();
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static class Criterion {
        private String condition;
        private Object value;
        private Object secondValue;
        private boolean noValue;
        private boolean singleValue;
        private boolean betweenValue;
        private boolean listValue;
        private String typeHandler;

        public String getCondition() {
            return this.condition;
        }

        public Object getValue() {
            return this.value;
        }

        public Object getSecondValue() {
            return this.secondValue;
        }

        public boolean isNoValue() {
            return this.noValue;
        }

        public boolean isSingleValue() {
            return this.singleValue;
        }

        public boolean isBetweenValue() {
            return this.betweenValue;
        }

        public boolean isListValue() {
            return this.listValue;
        }

        public String getTypeHandler() {
            return this.typeHandler;
        }

        protected Criterion(String condition) {
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if(value instanceof List) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }

        }

        protected Criterion(String condition, Object value) {
            this(condition, value, (String)null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, (String)null);
        }
    }

    public static class Criteria extends LogisticsTemplateRuleExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<LogisticsTemplateRuleExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<LogisticsTemplateRuleExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<LogisticsTemplateRuleExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new LogisticsTemplateRuleExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new LogisticsTemplateRuleExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new LogisticsTemplateRuleExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public LogisticsTemplateRuleExample.Criteria andRuleIdIsNull() {
            this.addCriterion("rule_id is null");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andRuleIdIsNotNull() {
            this.addCriterion("rule_id is not null");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andRuleIdEqualTo(Long value) {
            this.addCriterion("rule_id =", value, "ruleId");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andRuleIdNotEqualTo(Long value) {
            this.addCriterion("rule_id <>", value, "ruleId");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andRuleIdGreaterThan(Long value) {
            this.addCriterion("rule_id >", value, "ruleId");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andRuleIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("rule_id >=", value, "ruleId");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andRuleIdLessThan(Long value) {
            this.addCriterion("rule_id <", value, "ruleId");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andRuleIdLessThanOrEqualTo(Long value) {
            this.addCriterion("rule_id <=", value, "ruleId");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andRuleIdLike(String value) {
            this.addCriterion("rule_id like", value, "ruleId");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andRuleIdNotLike(String value) {
            this.addCriterion("rule_id not like", value, "ruleId");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }        public LogisticsTemplateRuleExample.Criteria andRuleIdIn(List<Long> values) {
            this.addCriterion("rule_id in", values, "ruleId");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andRuleIdNotIn(List<Long> values) {
            this.addCriterion("rule_id not in", values, "ruleId");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andRuleIdBetween(Long value1, Long value2) {
            this.addCriterion("rule_id between", value1, value2, "ruleId");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andRuleIdNotBetween(Long value1, Long value2) {
            this.addCriterion("rule_id not between", value1, value2, "ruleId");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andImDefaultIsNull() {
            this.addCriterion("im_default is null");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andImDefaultIsNotNull() {
            this.addCriterion("im_default is not null");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andImDefaultEqualTo(Boolean value) {
            this.addCriterion("im_default =", value, "imDefault");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andImDefaultNotEqualTo(Boolean value) {
            this.addCriterion("im_default <>", value, "imDefault");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andImDefaultGreaterThan(Boolean value) {
            this.addCriterion("im_default >", value, "imDefault");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andImDefaultGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("im_default >=", value, "imDefault");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andImDefaultLessThan(Boolean value) {
            this.addCriterion("im_default <", value, "imDefault");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andImDefaultLessThanOrEqualTo(Boolean value) {
            this.addCriterion("im_default <=", value, "imDefault");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andImDefaultLike(String value) {
            this.addCriterion("im_default like", value, "imDefault");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andImDefaultNotLike(String value) {
            this.addCriterion("im_default not like", value, "imDefault");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }        public LogisticsTemplateRuleExample.Criteria andImDefaultIn(List<Boolean> values) {
            this.addCriterion("im_default in", values, "imDefault");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andImDefaultNotIn(List<Boolean> values) {
            this.addCriterion("im_default not in", values, "imDefault");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andImDefaultBetween(Boolean value1, Boolean value2) {
            this.addCriterion("im_default between", value1, value2, "imDefault");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andImDefaultNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("im_default not between", value1, value2, "imDefault");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerFeeIsNull() {
            this.addCriterion("per_fee is null");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerFeeIsNotNull() {
            this.addCriterion("per_fee is not null");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerFeeEqualTo(Long value) {
            this.addCriterion("per_fee =", value, "perFee");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerFeeNotEqualTo(Long value) {
            this.addCriterion("per_fee <>", value, "perFee");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerFeeGreaterThan(Long value) {
            this.addCriterion("per_fee >", value, "perFee");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerFeeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("per_fee >=", value, "perFee");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerFeeLessThan(Long value) {
            this.addCriterion("per_fee <", value, "perFee");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerFeeLessThanOrEqualTo(Long value) {
            this.addCriterion("per_fee <=", value, "perFee");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerFeeLike(String value) {
            this.addCriterion("per_fee like", value, "perFee");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerFeeNotLike(String value) {
            this.addCriterion("per_fee not like", value, "perFee");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }        public LogisticsTemplateRuleExample.Criteria andPerFeeIn(List<Long> values) {
            this.addCriterion("per_fee in", values, "perFee");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerFeeNotIn(List<Long> values) {
            this.addCriterion("per_fee not in", values, "perFee");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerFeeBetween(Long value1, Long value2) {
            this.addCriterion("per_fee between", value1, value2, "perFee");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerFeeNotBetween(Long value1, Long value2) {
            this.addCriterion("per_fee not between", value1, value2, "perFee");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstFeeIsNull() {
            this.addCriterion("first_fee is null");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstFeeIsNotNull() {
            this.addCriterion("first_fee is not null");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstFeeEqualTo(Long value) {
            this.addCriterion("first_fee =", value, "firstFee");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstFeeNotEqualTo(Long value) {
            this.addCriterion("first_fee <>", value, "firstFee");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstFeeGreaterThan(Long value) {
            this.addCriterion("first_fee >", value, "firstFee");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstFeeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("first_fee >=", value, "firstFee");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstFeeLessThan(Long value) {
            this.addCriterion("first_fee <", value, "firstFee");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstFeeLessThanOrEqualTo(Long value) {
            this.addCriterion("first_fee <=", value, "firstFee");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstFeeLike(String value) {
            this.addCriterion("first_fee like", value, "firstFee");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstFeeNotLike(String value) {
            this.addCriterion("first_fee not like", value, "firstFee");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }        public LogisticsTemplateRuleExample.Criteria andFirstFeeIn(List<Long> values) {
            this.addCriterion("first_fee in", values, "firstFee");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstFeeNotIn(List<Long> values) {
            this.addCriterion("first_fee not in", values, "firstFee");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstFeeBetween(Long value1, Long value2) {
            this.addCriterion("first_fee between", value1, value2, "firstFee");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstFeeNotBetween(Long value1, Long value2) {
            this.addCriterion("first_fee not between", value1, value2, "firstFee");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitIsNull() {
            this.addCriterion("per_unit is null");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitIsNotNull() {
            this.addCriterion("per_unit is not null");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitEqualTo(Integer value) {
            this.addCriterion("per_unit =", value, "perUnit");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitNotEqualTo(Integer value) {
            this.addCriterion("per_unit <>", value, "perUnit");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitGreaterThan(Integer value) {
            this.addCriterion("per_unit >", value, "perUnit");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("per_unit >=", value, "perUnit");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitLessThan(Integer value) {
            this.addCriterion("per_unit <", value, "perUnit");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitLessThanOrEqualTo(Integer value) {
            this.addCriterion("per_unit <=", value, "perUnit");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitLike(String value) {
            this.addCriterion("per_unit like", value, "perUnit");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitNotLike(String value) {
            this.addCriterion("per_unit not like", value, "perUnit");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }        public LogisticsTemplateRuleExample.Criteria andPerUnitIn(List<Integer> values) {
            this.addCriterion("per_unit in", values, "perUnit");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitNotIn(List<Integer> values) {
            this.addCriterion("per_unit not in", values, "perUnit");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitBetween(Integer value1, Integer value2) {
            this.addCriterion("per_unit between", value1, value2, "perUnit");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andPerUnitNotBetween(Integer value1, Integer value2) {
            this.addCriterion("per_unit not between", value1, value2, "perUnit");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstUnitIsNull() {
            this.addCriterion("first_unit is null");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstUnitIsNotNull() {
            this.addCriterion("first_unit is not null");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstUnitEqualTo(Integer value) {
            this.addCriterion("first_unit =", value, "firstUnit");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstUnitNotEqualTo(Integer value) {
            this.addCriterion("first_unit <>", value, "firstUnit");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstUnitGreaterThan(Integer value) {
            this.addCriterion("first_unit >", value, "firstUnit");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstUnitGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("first_unit >=", value, "firstUnit");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstUnitLessThan(Integer value) {
            this.addCriterion("first_unit <", value, "firstUnit");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstUnitLessThanOrEqualTo(Integer value) {
            this.addCriterion("first_unit <=", value, "firstUnit");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstUnitLike(String value) {
            this.addCriterion("first_unit like", value, "firstUnit");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstUnitNotLike(String value) {
            this.addCriterion("first_unit not like", value, "firstUnit");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }        public LogisticsTemplateRuleExample.Criteria andFirstUnitIn(List<Integer> values) {
            this.addCriterion("first_unit in", values, "firstUnit");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstUnitNotIn(List<Integer> values) {
            this.addCriterion("first_unit not in", values, "firstUnit");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstUnitBetween(Integer value1, Integer value2) {
            this.addCriterion("first_unit between", value1, value2, "firstUnit");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andFirstUnitNotBetween(Integer value1, Integer value2) {
            this.addCriterion("first_unit not between", value1, value2, "firstUnit");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTemplateIdIsNull() {
            this.addCriterion("template_id is null");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTemplateIdIsNotNull() {
            this.addCriterion("template_id is not null");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTemplateIdEqualTo(Long value) {
            this.addCriterion("template_id =", value, "templateId");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTemplateIdNotEqualTo(Long value) {
            this.addCriterion("template_id <>", value, "templateId");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTemplateIdGreaterThan(Long value) {
            this.addCriterion("template_id >", value, "templateId");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTemplateIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("template_id >=", value, "templateId");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTemplateIdLessThan(Long value) {
            this.addCriterion("template_id <", value, "templateId");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTemplateIdLessThanOrEqualTo(Long value) {
            this.addCriterion("template_id <=", value, "templateId");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTemplateIdLike(String value) {
            this.addCriterion("template_id like", value, "templateId");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTemplateIdNotLike(String value) {
            this.addCriterion("template_id not like", value, "templateId");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }        public LogisticsTemplateRuleExample.Criteria andTemplateIdIn(List<Long> values) {
            this.addCriterion("template_id in", values, "templateId");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTemplateIdNotIn(List<Long> values) {
            this.addCriterion("template_id not in", values, "templateId");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTemplateIdBetween(Long value1, Long value2) {
            this.addCriterion("template_id between", value1, value2, "templateId");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTemplateIdNotBetween(Long value1, Long value2) {
            this.addCriterion("template_id not between", value1, value2, "templateId");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTypeIsNull() {
            this.addCriterion("type is null");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTypeIsNotNull() {
            this.addCriterion("type is not null");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTypeEqualTo(Integer value) {
            this.addCriterion("type =", value, "type");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTypeNotEqualTo(Integer value) {
            this.addCriterion("type <>", value, "type");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTypeGreaterThan(Integer value) {
            this.addCriterion("type >", value, "type");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("type >=", value, "type");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTypeLessThan(Integer value) {
            this.addCriterion("type <", value, "type");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("type <=", value, "type");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTypeLike(String value) {
            this.addCriterion("type like", value, "type");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTypeNotLike(String value) {
            this.addCriterion("type not like", value, "type");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }        public LogisticsTemplateRuleExample.Criteria andTypeIn(List<Integer> values) {
            this.addCriterion("type in", values, "type");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTypeNotIn(List<Integer> values) {
            this.addCriterion("type not in", values, "type");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("type between", value1, value2, "type");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }

        public LogisticsTemplateRuleExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("type not between", value1, value2, "type");
            return (LogisticsTemplateRuleExample.Criteria)this;
        }
    }
}
