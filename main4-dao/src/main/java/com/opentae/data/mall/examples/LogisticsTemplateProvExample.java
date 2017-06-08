package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class LogisticsTemplateProvExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<LogisticsTemplateProvExample.Criteria> oredCriteria = new ArrayList();

    public LogisticsTemplateProvExample() {
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

    public List<LogisticsTemplateProvExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(LogisticsTemplateProvExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public LogisticsTemplateProvExample.Criteria or() {
        LogisticsTemplateProvExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public LogisticsTemplateProvExample.Criteria createCriteria() {
        LogisticsTemplateProvExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected LogisticsTemplateProvExample.Criteria createCriteriaInternal() {
        LogisticsTemplateProvExample.Criteria criteria = new LogisticsTemplateProvExample.Criteria();
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

    public static class Criteria extends LogisticsTemplateProvExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<LogisticsTemplateProvExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<LogisticsTemplateProvExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<LogisticsTemplateProvExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new LogisticsTemplateProvExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new LogisticsTemplateProvExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new LogisticsTemplateProvExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public LogisticsTemplateProvExample.Criteria andRuleIdIsNull() {
            this.addCriterion("ruleId is null");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andRuleIdIsNotNull() {
            this.addCriterion("ruleId is not null");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andRuleIdEqualTo(Long value) {
            this.addCriterion("ruleId =", value, "rule_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andRuleIdNotEqualTo(Long value) {
            this.addCriterion("ruleId <>", value, "rule_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andRuleIdGreaterThan(Long value) {
            this.addCriterion("ruleId >", value, "rule_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andRuleIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("ruleId >=", value, "rule_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andRuleIdLessThan(Long value) {
            this.addCriterion("ruleId <", value, "rule_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andRuleIdLessThanOrEqualTo(Long value) {
            this.addCriterion("ruleId <=", value, "rule_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andRuleIdLike(String value) {
            this.addCriterion("ruleId like", value, "rule_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andRuleIdNotLike(String value) {
            this.addCriterion("ruleId not like", value, "rule_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }        public LogisticsTemplateProvExample.Criteria andRuleIdIn(List<Long> values) {
            this.addCriterion("ruleId in", values, "rule_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andRuleIdNotIn(List<Long> values) {
            this.addCriterion("ruleId not in", values, "rule_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andRuleIdBetween(Long value1, Long value2) {
            this.addCriterion("ruleId between", value1, value2, "rule_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andRuleIdNotBetween(Long value1, Long value2) {
            this.addCriterion("ruleId not between", value1, value2, "rule_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andProvIdIsNull() {
            this.addCriterion("provId is null");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andProvIdIsNotNull() {
            this.addCriterion("provId is not null");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andProvIdEqualTo(Long value) {
            this.addCriterion("provId =", value, "prov_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andProvIdNotEqualTo(Long value) {
            this.addCriterion("provId <>", value, "prov_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andProvIdGreaterThan(Long value) {
            this.addCriterion("provId >", value, "prov_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andProvIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("provId >=", value, "prov_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andProvIdLessThan(Long value) {
            this.addCriterion("provId <", value, "prov_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andProvIdLessThanOrEqualTo(Long value) {
            this.addCriterion("provId <=", value, "prov_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andProvIdLike(String value) {
            this.addCriterion("provId like", value, "prov_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andProvIdNotLike(String value) {
            this.addCriterion("provId not like", value, "prov_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }        public LogisticsTemplateProvExample.Criteria andProvIdIn(List<Long> values) {
            this.addCriterion("provId in", values, "prov_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andProvIdNotIn(List<Long> values) {
            this.addCriterion("provId not in", values, "prov_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andProvIdBetween(Long value1, Long value2) {
            this.addCriterion("provId between", value1, value2, "prov_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andProvIdNotBetween(Long value1, Long value2) {
            this.addCriterion("provId not between", value1, value2, "prov_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTpIdIsNull() {
            this.addCriterion("tpId is null");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTpIdIsNotNull() {
            this.addCriterion("tpId is not null");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTpIdEqualTo(Long value) {
            this.addCriterion("tpId =", value, "tp_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTpIdNotEqualTo(Long value) {
            this.addCriterion("tpId <>", value, "tp_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTpIdGreaterThan(Long value) {
            this.addCriterion("tpId >", value, "tp_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTpIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("tpId >=", value, "tp_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTpIdLessThan(Long value) {
            this.addCriterion("tpId <", value, "tp_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTpIdLessThanOrEqualTo(Long value) {
            this.addCriterion("tpId <=", value, "tp_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTpIdLike(String value) {
            this.addCriterion("tpId like", value, "tp_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTpIdNotLike(String value) {
            this.addCriterion("tpId not like", value, "tp_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }        public LogisticsTemplateProvExample.Criteria andTpIdIn(List<Long> values) {
            this.addCriterion("tpId in", values, "tp_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTpIdNotIn(List<Long> values) {
            this.addCriterion("tpId not in", values, "tp_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTpIdBetween(Long value1, Long value2) {
            this.addCriterion("tpId between", value1, value2, "tp_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTpIdNotBetween(Long value1, Long value2) {
            this.addCriterion("tpId not between", value1, value2, "tp_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTemplateIdIsNull() {
            this.addCriterion("templateId is null");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTemplateIdIsNotNull() {
            this.addCriterion("templateId is not null");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTemplateIdEqualTo(Long value) {
            this.addCriterion("templateId =", value, "template_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTemplateIdNotEqualTo(Long value) {
            this.addCriterion("templateId <>", value, "template_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTemplateIdGreaterThan(Long value) {
            this.addCriterion("templateId >", value, "template_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTemplateIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("templateId >=", value, "template_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTemplateIdLessThan(Long value) {
            this.addCriterion("templateId <", value, "template_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTemplateIdLessThanOrEqualTo(Long value) {
            this.addCriterion("templateId <=", value, "template_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTemplateIdLike(String value) {
            this.addCriterion("templateId like", value, "template_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTemplateIdNotLike(String value) {
            this.addCriterion("templateId not like", value, "template_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }        public LogisticsTemplateProvExample.Criteria andTemplateIdIn(List<Long> values) {
            this.addCriterion("templateId in", values, "template_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTemplateIdNotIn(List<Long> values) {
            this.addCriterion("templateId not in", values, "template_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTemplateIdBetween(Long value1, Long value2) {
            this.addCriterion("templateId between", value1, value2, "template_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }

        public LogisticsTemplateProvExample.Criteria andTemplateIdNotBetween(Long value1, Long value2) {
            this.addCriterion("templateId not between", value1, value2, "template_id");
            return (LogisticsTemplateProvExample.Criteria)this;
        }
    }
}
