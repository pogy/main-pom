package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class LogisticsTemplateCompanyExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<LogisticsTemplateCompanyExample.Criteria> oredCriteria = new ArrayList();

    public LogisticsTemplateCompanyExample() {
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

    public List<LogisticsTemplateCompanyExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(LogisticsTemplateCompanyExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public LogisticsTemplateCompanyExample.Criteria or() {
        LogisticsTemplateCompanyExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public LogisticsTemplateCompanyExample.Criteria createCriteria() {
        LogisticsTemplateCompanyExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected LogisticsTemplateCompanyExample.Criteria createCriteriaInternal() {
        LogisticsTemplateCompanyExample.Criteria criteria = new LogisticsTemplateCompanyExample.Criteria();
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

    public static class Criteria extends LogisticsTemplateCompanyExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<LogisticsTemplateCompanyExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<LogisticsTemplateCompanyExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<LogisticsTemplateCompanyExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new LogisticsTemplateCompanyExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new LogisticsTemplateCompanyExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new LogisticsTemplateCompanyExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public LogisticsTemplateCompanyExample.Criteria andRuleIdIsNull() {
            this.addCriterion("ruleId is null");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andRuleIdIsNotNull() {
            this.addCriterion("ruleId is not null");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andRuleIdEqualTo(String value) {
            this.addCriterion("ruleId =", value, "rule_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andRuleIdNotEqualTo(String value) {
            this.addCriterion("ruleId <>", value, "rule_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andRuleIdGreaterThan(String value) {
            this.addCriterion("ruleId >", value, "rule_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andRuleIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("ruleId >=", value, "rule_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andRuleIdLessThan(String value) {
            this.addCriterion("ruleId <", value, "rule_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andRuleIdLessThanOrEqualTo(String value) {
            this.addCriterion("ruleId <=", value, "rule_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andRuleIdLike(String value) {
            this.addCriterion("ruleId like", value, "rule_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andRuleIdNotLike(String value) {
            this.addCriterion("ruleId not like", value, "rule_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }        public LogisticsTemplateCompanyExample.Criteria andRuleIdIn(List<String> values) {
            this.addCriterion("ruleId in", values, "rule_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andRuleIdNotIn(List<String> values) {
            this.addCriterion("ruleId not in", values, "rule_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andRuleIdBetween(String value1, String value2) {
            this.addCriterion("ruleId between", value1, value2, "rule_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andRuleIdNotBetween(String value1, String value2) {
            this.addCriterion("ruleId not between", value1, value2, "rule_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdIsNull() {
            this.addCriterion("companyId is null");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdIsNotNull() {
            this.addCriterion("companyId is not null");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdEqualTo(String value) {
            this.addCriterion("companyId =", value, "company_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdNotEqualTo(String value) {
            this.addCriterion("companyId <>", value, "company_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdGreaterThan(String value) {
            this.addCriterion("companyId >", value, "company_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("companyId >=", value, "company_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdLessThan(String value) {
            this.addCriterion("companyId <", value, "company_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdLessThanOrEqualTo(String value) {
            this.addCriterion("companyId <=", value, "company_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdLike(String value) {
            this.addCriterion("companyId like", value, "company_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdNotLike(String value) {
            this.addCriterion("companyId not like", value, "company_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }        public LogisticsTemplateCompanyExample.Criteria andCompanyIdIn(List<String> values) {
            this.addCriterion("companyId in", values, "company_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdNotIn(List<String> values) {
            this.addCriterion("companyId not in", values, "company_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdBetween(String value1, String value2) {
            this.addCriterion("companyId between", value1, value2, "company_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andCompanyIdNotBetween(String value1, String value2) {
            this.addCriterion("companyId not between", value1, value2, "company_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTcIdIsNull() {
            this.addCriterion("tcId is null");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTcIdIsNotNull() {
            this.addCriterion("tcId is not null");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTcIdEqualTo(String value) {
            this.addCriterion("tcId =", value, "tc_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTcIdNotEqualTo(String value) {
            this.addCriterion("tcId <>", value, "tc_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTcIdGreaterThan(String value) {
            this.addCriterion("tcId >", value, "tc_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTcIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("tcId >=", value, "tc_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTcIdLessThan(String value) {
            this.addCriterion("tcId <", value, "tc_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTcIdLessThanOrEqualTo(String value) {
            this.addCriterion("tcId <=", value, "tc_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTcIdLike(String value) {
            this.addCriterion("tcId like", value, "tc_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTcIdNotLike(String value) {
            this.addCriterion("tcId not like", value, "tc_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }        public LogisticsTemplateCompanyExample.Criteria andTcIdIn(List<String> values) {
            this.addCriterion("tcId in", values, "tc_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTcIdNotIn(List<String> values) {
            this.addCriterion("tcId not in", values, "tc_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTcIdBetween(String value1, String value2) {
            this.addCriterion("tcId between", value1, value2, "tc_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTcIdNotBetween(String value1, String value2) {
            this.addCriterion("tcId not between", value1, value2, "tc_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTemplateIdIsNull() {
            this.addCriterion("templateId is null");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTemplateIdIsNotNull() {
            this.addCriterion("templateId is not null");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTemplateIdEqualTo(String value) {
            this.addCriterion("templateId =", value, "template_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTemplateIdNotEqualTo(String value) {
            this.addCriterion("templateId <>", value, "template_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTemplateIdGreaterThan(String value) {
            this.addCriterion("templateId >", value, "template_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTemplateIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("templateId >=", value, "template_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTemplateIdLessThan(String value) {
            this.addCriterion("templateId <", value, "template_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTemplateIdLessThanOrEqualTo(String value) {
            this.addCriterion("templateId <=", value, "template_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTemplateIdLike(String value) {
            this.addCriterion("templateId like", value, "template_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTemplateIdNotLike(String value) {
            this.addCriterion("templateId not like", value, "template_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }        public LogisticsTemplateCompanyExample.Criteria andTemplateIdIn(List<String> values) {
            this.addCriterion("templateId in", values, "template_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTemplateIdNotIn(List<String> values) {
            this.addCriterion("templateId not in", values, "template_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTemplateIdBetween(String value1, String value2) {
            this.addCriterion("templateId between", value1, value2, "template_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }

        public LogisticsTemplateCompanyExample.Criteria andTemplateIdNotBetween(String value1, String value2) {
            this.addCriterion("templateId not between", value1, value2, "template_id");
            return (LogisticsTemplateCompanyExample.Criteria)this;
        }
    }
}
