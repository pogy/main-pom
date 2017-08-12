package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class LogisticsTemplateRuleExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

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

    public List<Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
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

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public Criteria andRuleIdIsNull() {
            this.addCriterion("rule_id is null");
            return (Criteria)this;
        }

        public Criteria andRuleIdIsNotNull() {
            this.addCriterion("rule_id is not null");
            return (Criteria)this;
        }

        public Criteria andRuleIdEqualTo(Long value) {
            this.addCriterion("rule_id =", value, "ruleId");
            return (Criteria)this;
        }

        public Criteria andRuleIdNotEqualTo(Long value) {
            this.addCriterion("rule_id <>", value, "ruleId");
            return (Criteria)this;
        }

        public Criteria andRuleIdGreaterThan(Long value) {
            this.addCriterion("rule_id >", value, "ruleId");
            return (Criteria)this;
        }

        public Criteria andRuleIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("rule_id >=", value, "ruleId");
            return (Criteria)this;
        }

        public Criteria andRuleIdLessThan(Long value) {
            this.addCriterion("rule_id <", value, "ruleId");
            return (Criteria)this;
        }

        public Criteria andRuleIdLessThanOrEqualTo(Long value) {
            this.addCriterion("rule_id <=", value, "ruleId");
            return (Criteria)this;
        }

        public Criteria andRuleIdLike(String value) {
            this.addCriterion("rule_id like", value, "ruleId");
            return (Criteria)this;
        }

        public Criteria andRuleIdNotLike(String value) {
            this.addCriterion("rule_id not like", value, "ruleId");
            return (Criteria)this;
        }        public Criteria andRuleIdIn(List<Long> values) {
            this.addCriterion("rule_id in", values, "ruleId");
            return (Criteria)this;
        }

        public Criteria andRuleIdNotIn(List<Long> values) {
            this.addCriterion("rule_id not in", values, "ruleId");
            return (Criteria)this;
        }

        public Criteria andRuleIdBetween(Long value1, Long value2) {
            this.addCriterion("rule_id between", value1, value2, "ruleId");
            return (Criteria)this;
        }

        public Criteria andRuleIdNotBetween(Long value1, Long value2) {
            this.addCriterion("rule_id not between", value1, value2, "ruleId");
            return (Criteria)this;
        }

        public Criteria andImDefaultIsNull() {
            this.addCriterion("im_default is null");
            return (Criteria)this;
        }

        public Criteria andImDefaultIsNotNull() {
            this.addCriterion("im_default is not null");
            return (Criteria)this;
        }

        public Criteria andImDefaultEqualTo(Boolean value) {
            this.addCriterion("im_default =", value, "imDefault");
            return (Criteria)this;
        }

        public Criteria andImDefaultNotEqualTo(Boolean value) {
            this.addCriterion("im_default <>", value, "imDefault");
            return (Criteria)this;
        }

        public Criteria andImDefaultGreaterThan(Boolean value) {
            this.addCriterion("im_default >", value, "imDefault");
            return (Criteria)this;
        }

        public Criteria andImDefaultGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("im_default >=", value, "imDefault");
            return (Criteria)this;
        }

        public Criteria andImDefaultLessThan(Boolean value) {
            this.addCriterion("im_default <", value, "imDefault");
            return (Criteria)this;
        }

        public Criteria andImDefaultLessThanOrEqualTo(Boolean value) {
            this.addCriterion("im_default <=", value, "imDefault");
            return (Criteria)this;
        }

        public Criteria andImDefaultLike(String value) {
            this.addCriterion("im_default like", value, "imDefault");
            return (Criteria)this;
        }

        public Criteria andImDefaultNotLike(String value) {
            this.addCriterion("im_default not like", value, "imDefault");
            return (Criteria)this;
        }        public Criteria andImDefaultIn(List<Boolean> values) {
            this.addCriterion("im_default in", values, "imDefault");
            return (Criteria)this;
        }

        public Criteria andImDefaultNotIn(List<Boolean> values) {
            this.addCriterion("im_default not in", values, "imDefault");
            return (Criteria)this;
        }

        public Criteria andImDefaultBetween(Boolean value1, Boolean value2) {
            this.addCriterion("im_default between", value1, value2, "imDefault");
            return (Criteria)this;
        }

        public Criteria andImDefaultNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("im_default not between", value1, value2, "imDefault");
            return (Criteria)this;
        }

        public Criteria andPerFeeIsNull() {
            this.addCriterion("per_fee is null");
            return (Criteria)this;
        }

        public Criteria andPerFeeIsNotNull() {
            this.addCriterion("per_fee is not null");
            return (Criteria)this;
        }

        public Criteria andPerFeeEqualTo(Long value) {
            this.addCriterion("per_fee =", value, "perFee");
            return (Criteria)this;
        }

        public Criteria andPerFeeNotEqualTo(Long value) {
            this.addCriterion("per_fee <>", value, "perFee");
            return (Criteria)this;
        }

        public Criteria andPerFeeGreaterThan(Long value) {
            this.addCriterion("per_fee >", value, "perFee");
            return (Criteria)this;
        }

        public Criteria andPerFeeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("per_fee >=", value, "perFee");
            return (Criteria)this;
        }

        public Criteria andPerFeeLessThan(Long value) {
            this.addCriterion("per_fee <", value, "perFee");
            return (Criteria)this;
        }

        public Criteria andPerFeeLessThanOrEqualTo(Long value) {
            this.addCriterion("per_fee <=", value, "perFee");
            return (Criteria)this;
        }

        public Criteria andPerFeeLike(String value) {
            this.addCriterion("per_fee like", value, "perFee");
            return (Criteria)this;
        }

        public Criteria andPerFeeNotLike(String value) {
            this.addCriterion("per_fee not like", value, "perFee");
            return (Criteria)this;
        }        public Criteria andPerFeeIn(List<Long> values) {
            this.addCriterion("per_fee in", values, "perFee");
            return (Criteria)this;
        }

        public Criteria andPerFeeNotIn(List<Long> values) {
            this.addCriterion("per_fee not in", values, "perFee");
            return (Criteria)this;
        }

        public Criteria andPerFeeBetween(Long value1, Long value2) {
            this.addCriterion("per_fee between", value1, value2, "perFee");
            return (Criteria)this;
        }

        public Criteria andPerFeeNotBetween(Long value1, Long value2) {
            this.addCriterion("per_fee not between", value1, value2, "perFee");
            return (Criteria)this;
        }

        public Criteria andFirstFeeIsNull() {
            this.addCriterion("first_fee is null");
            return (Criteria)this;
        }

        public Criteria andFirstFeeIsNotNull() {
            this.addCriterion("first_fee is not null");
            return (Criteria)this;
        }

        public Criteria andFirstFeeEqualTo(Long value) {
            this.addCriterion("first_fee =", value, "firstFee");
            return (Criteria)this;
        }

        public Criteria andFirstFeeNotEqualTo(Long value) {
            this.addCriterion("first_fee <>", value, "firstFee");
            return (Criteria)this;
        }

        public Criteria andFirstFeeGreaterThan(Long value) {
            this.addCriterion("first_fee >", value, "firstFee");
            return (Criteria)this;
        }

        public Criteria andFirstFeeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("first_fee >=", value, "firstFee");
            return (Criteria)this;
        }

        public Criteria andFirstFeeLessThan(Long value) {
            this.addCriterion("first_fee <", value, "firstFee");
            return (Criteria)this;
        }

        public Criteria andFirstFeeLessThanOrEqualTo(Long value) {
            this.addCriterion("first_fee <=", value, "firstFee");
            return (Criteria)this;
        }

        public Criteria andFirstFeeLike(String value) {
            this.addCriterion("first_fee like", value, "firstFee");
            return (Criteria)this;
        }

        public Criteria andFirstFeeNotLike(String value) {
            this.addCriterion("first_fee not like", value, "firstFee");
            return (Criteria)this;
        }        public Criteria andFirstFeeIn(List<Long> values) {
            this.addCriterion("first_fee in", values, "firstFee");
            return (Criteria)this;
        }

        public Criteria andFirstFeeNotIn(List<Long> values) {
            this.addCriterion("first_fee not in", values, "firstFee");
            return (Criteria)this;
        }

        public Criteria andFirstFeeBetween(Long value1, Long value2) {
            this.addCriterion("first_fee between", value1, value2, "firstFee");
            return (Criteria)this;
        }

        public Criteria andFirstFeeNotBetween(Long value1, Long value2) {
            this.addCriterion("first_fee not between", value1, value2, "firstFee");
            return (Criteria)this;
        }

        public Criteria andPerUnitIsNull() {
            this.addCriterion("per_unit is null");
            return (Criteria)this;
        }

        public Criteria andPerUnitIsNotNull() {
            this.addCriterion("per_unit is not null");
            return (Criteria)this;
        }

        public Criteria andPerUnitEqualTo(Integer value) {
            this.addCriterion("per_unit =", value, "perUnit");
            return (Criteria)this;
        }

        public Criteria andPerUnitNotEqualTo(Integer value) {
            this.addCriterion("per_unit <>", value, "perUnit");
            return (Criteria)this;
        }

        public Criteria andPerUnitGreaterThan(Integer value) {
            this.addCriterion("per_unit >", value, "perUnit");
            return (Criteria)this;
        }

        public Criteria andPerUnitGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("per_unit >=", value, "perUnit");
            return (Criteria)this;
        }

        public Criteria andPerUnitLessThan(Integer value) {
            this.addCriterion("per_unit <", value, "perUnit");
            return (Criteria)this;
        }

        public Criteria andPerUnitLessThanOrEqualTo(Integer value) {
            this.addCriterion("per_unit <=", value, "perUnit");
            return (Criteria)this;
        }

        public Criteria andPerUnitLike(String value) {
            this.addCriterion("per_unit like", value, "perUnit");
            return (Criteria)this;
        }

        public Criteria andPerUnitNotLike(String value) {
            this.addCriterion("per_unit not like", value, "perUnit");
            return (Criteria)this;
        }        public Criteria andPerUnitIn(List<Integer> values) {
            this.addCriterion("per_unit in", values, "perUnit");
            return (Criteria)this;
        }

        public Criteria andPerUnitNotIn(List<Integer> values) {
            this.addCriterion("per_unit not in", values, "perUnit");
            return (Criteria)this;
        }

        public Criteria andPerUnitBetween(Integer value1, Integer value2) {
            this.addCriterion("per_unit between", value1, value2, "perUnit");
            return (Criteria)this;
        }

        public Criteria andPerUnitNotBetween(Integer value1, Integer value2) {
            this.addCriterion("per_unit not between", value1, value2, "perUnit");
            return (Criteria)this;
        }

        public Criteria andFirstUnitIsNull() {
            this.addCriterion("first_unit is null");
            return (Criteria)this;
        }

        public Criteria andFirstUnitIsNotNull() {
            this.addCriterion("first_unit is not null");
            return (Criteria)this;
        }

        public Criteria andFirstUnitEqualTo(Integer value) {
            this.addCriterion("first_unit =", value, "firstUnit");
            return (Criteria)this;
        }

        public Criteria andFirstUnitNotEqualTo(Integer value) {
            this.addCriterion("first_unit <>", value, "firstUnit");
            return (Criteria)this;
        }

        public Criteria andFirstUnitGreaterThan(Integer value) {
            this.addCriterion("first_unit >", value, "firstUnit");
            return (Criteria)this;
        }

        public Criteria andFirstUnitGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("first_unit >=", value, "firstUnit");
            return (Criteria)this;
        }

        public Criteria andFirstUnitLessThan(Integer value) {
            this.addCriterion("first_unit <", value, "firstUnit");
            return (Criteria)this;
        }

        public Criteria andFirstUnitLessThanOrEqualTo(Integer value) {
            this.addCriterion("first_unit <=", value, "firstUnit");
            return (Criteria)this;
        }

        public Criteria andFirstUnitLike(String value) {
            this.addCriterion("first_unit like", value, "firstUnit");
            return (Criteria)this;
        }

        public Criteria andFirstUnitNotLike(String value) {
            this.addCriterion("first_unit not like", value, "firstUnit");
            return (Criteria)this;
        }        public Criteria andFirstUnitIn(List<Integer> values) {
            this.addCriterion("first_unit in", values, "firstUnit");
            return (Criteria)this;
        }

        public Criteria andFirstUnitNotIn(List<Integer> values) {
            this.addCriterion("first_unit not in", values, "firstUnit");
            return (Criteria)this;
        }

        public Criteria andFirstUnitBetween(Integer value1, Integer value2) {
            this.addCriterion("first_unit between", value1, value2, "firstUnit");
            return (Criteria)this;
        }

        public Criteria andFirstUnitNotBetween(Integer value1, Integer value2) {
            this.addCriterion("first_unit not between", value1, value2, "firstUnit");
            return (Criteria)this;
        }

        public Criteria andTemplateIdIsNull() {
            this.addCriterion("template_id is null");
            return (Criteria)this;
        }

        public Criteria andTemplateIdIsNotNull() {
            this.addCriterion("template_id is not null");
            return (Criteria)this;
        }

        public Criteria andTemplateIdEqualTo(Long value) {
            this.addCriterion("template_id =", value, "templateId");
            return (Criteria)this;
        }

        public Criteria andTemplateIdNotEqualTo(Long value) {
            this.addCriterion("template_id <>", value, "templateId");
            return (Criteria)this;
        }

        public Criteria andTemplateIdGreaterThan(Long value) {
            this.addCriterion("template_id >", value, "templateId");
            return (Criteria)this;
        }

        public Criteria andTemplateIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("template_id >=", value, "templateId");
            return (Criteria)this;
        }

        public Criteria andTemplateIdLessThan(Long value) {
            this.addCriterion("template_id <", value, "templateId");
            return (Criteria)this;
        }

        public Criteria andTemplateIdLessThanOrEqualTo(Long value) {
            this.addCriterion("template_id <=", value, "templateId");
            return (Criteria)this;
        }

        public Criteria andTemplateIdLike(String value) {
            this.addCriterion("template_id like", value, "templateId");
            return (Criteria)this;
        }

        public Criteria andTemplateIdNotLike(String value) {
            this.addCriterion("template_id not like", value, "templateId");
            return (Criteria)this;
        }        public Criteria andTemplateIdIn(List<Long> values) {
            this.addCriterion("template_id in", values, "templateId");
            return (Criteria)this;
        }

        public Criteria andTemplateIdNotIn(List<Long> values) {
            this.addCriterion("template_id not in", values, "templateId");
            return (Criteria)this;
        }

        public Criteria andTemplateIdBetween(Long value1, Long value2) {
            this.addCriterion("template_id between", value1, value2, "templateId");
            return (Criteria)this;
        }

        public Criteria andTemplateIdNotBetween(Long value1, Long value2) {
            this.addCriterion("template_id not between", value1, value2, "templateId");
            return (Criteria)this;
        }

        public Criteria andTypeIsNull() {
            this.addCriterion("type is null");
            return (Criteria)this;
        }

        public Criteria andTypeIsNotNull() {
            this.addCriterion("type is not null");
            return (Criteria)this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            this.addCriterion("type =", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            this.addCriterion("type <>", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            this.addCriterion("type >", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("type >=", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeLessThan(Integer value) {
            this.addCriterion("type <", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("type <=", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeLike(String value) {
            this.addCriterion("type like", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotLike(String value) {
            this.addCriterion("type not like", value, "type");
            return (Criteria)this;
        }        public Criteria andTypeIn(List<Integer> values) {
            this.addCriterion("type in", values, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            this.addCriterion("type not in", values, "type");
            return (Criteria)this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("type between", value1, value2, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("type not between", value1, value2, "type");
            return (Criteria)this;
        }
    }
}
