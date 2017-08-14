package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class LogisticsTemplateCompanyExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

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

        public Criteria andCompanyIdIsNull() {
            this.addCriterion("company_id is null");
            return (Criteria)this;
        }

        public Criteria andCompanyIdIsNotNull() {
            this.addCriterion("company_id is not null");
            return (Criteria)this;
        }

        public Criteria andCompanyIdEqualTo(Long value) {
            this.addCriterion("company_id =", value, "companyId");
            return (Criteria)this;
        }

        public Criteria andCompanyIdNotEqualTo(Long value) {
            this.addCriterion("company_id <>", value, "companyId");
            return (Criteria)this;
        }

        public Criteria andCompanyIdGreaterThan(Long value) {
            this.addCriterion("company_id >", value, "companyId");
            return (Criteria)this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("company_id >=", value, "companyId");
            return (Criteria)this;
        }

        public Criteria andCompanyIdLessThan(Long value) {
            this.addCriterion("company_id <", value, "companyId");
            return (Criteria)this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Long value) {
            this.addCriterion("company_id <=", value, "companyId");
            return (Criteria)this;
        }

        public Criteria andCompanyIdLike(String value) {
            this.addCriterion("company_id like", value, "companyId");
            return (Criteria)this;
        }

        public Criteria andCompanyIdNotLike(String value) {
            this.addCriterion("company_id not like", value, "companyId");
            return (Criteria)this;
        }        public Criteria andCompanyIdIn(List<Long> values) {
            this.addCriterion("company_id in", values, "companyId");
            return (Criteria)this;
        }

        public Criteria andCompanyIdNotIn(List<Long> values) {
            this.addCriterion("company_id not in", values, "companyId");
            return (Criteria)this;
        }

        public Criteria andCompanyIdBetween(Long value1, Long value2) {
            this.addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria)this;
        }

        public Criteria andCompanyIdNotBetween(Long value1, Long value2) {
            this.addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria)this;
        }

        public Criteria andTcIdIsNull() {
            this.addCriterion("tc_id is null");
            return (Criteria)this;
        }

        public Criteria andTcIdIsNotNull() {
            this.addCriterion("tc_id is not null");
            return (Criteria)this;
        }

        public Criteria andTcIdEqualTo(Long value) {
            this.addCriterion("tc_id =", value, "tcId");
            return (Criteria)this;
        }

        public Criteria andTcIdNotEqualTo(Long value) {
            this.addCriterion("tc_id <>", value, "tcId");
            return (Criteria)this;
        }

        public Criteria andTcIdGreaterThan(Long value) {
            this.addCriterion("tc_id >", value, "tcId");
            return (Criteria)this;
        }

        public Criteria andTcIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("tc_id >=", value, "tcId");
            return (Criteria)this;
        }

        public Criteria andTcIdLessThan(Long value) {
            this.addCriterion("tc_id <", value, "tcId");
            return (Criteria)this;
        }

        public Criteria andTcIdLessThanOrEqualTo(Long value) {
            this.addCriterion("tc_id <=", value, "tcId");
            return (Criteria)this;
        }

        public Criteria andTcIdLike(String value) {
            this.addCriterion("tc_id like", value, "tcId");
            return (Criteria)this;
        }

        public Criteria andTcIdNotLike(String value) {
            this.addCriterion("tc_id not like", value, "tcId");
            return (Criteria)this;
        }        public Criteria andTcIdIn(List<Long> values) {
            this.addCriterion("tc_id in", values, "tcId");
            return (Criteria)this;
        }

        public Criteria andTcIdNotIn(List<Long> values) {
            this.addCriterion("tc_id not in", values, "tcId");
            return (Criteria)this;
        }

        public Criteria andTcIdBetween(Long value1, Long value2) {
            this.addCriterion("tc_id between", value1, value2, "tcId");
            return (Criteria)this;
        }

        public Criteria andTcIdNotBetween(Long value1, Long value2) {
            this.addCriterion("tc_id not between", value1, value2, "tcId");
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
    }
}
