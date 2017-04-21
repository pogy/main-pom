package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class GoatModelExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<GoatModelExample.Criteria> oredCriteria = new ArrayList();

    public GoatModelExample() {
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

    public List<GoatModelExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(GoatModelExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public GoatModelExample.Criteria or() {
        GoatModelExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public GoatModelExample.Criteria createCriteria() {
        GoatModelExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected GoatModelExample.Criteria createCriteriaInternal() {
        GoatModelExample.Criteria criteria = new GoatModelExample.Criteria();
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

    public static class Criteria extends GoatModelExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<GoatModelExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<GoatModelExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<GoatModelExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new GoatModelExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new GoatModelExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new GoatModelExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public GoatModelExample.Criteria andModelIdIsNull() {
            this.addCriterion("model_id is null");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelIdIsNotNull() {
            this.addCriterion("model_id is not null");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelIdEqualTo(Long value) {
            this.addCriterion("model_id =", value, "modelId");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelIdNotEqualTo(Long value) {
            this.addCriterion("model_id <>", value, "modelId");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelIdGreaterThan(Long value) {
            this.addCriterion("model_id >", value, "modelId");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("model_id >=", value, "modelId");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelIdLessThan(Long value) {
            this.addCriterion("model_id <", value, "modelId");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelIdLessThanOrEqualTo(Long value) {
            this.addCriterion("model_id <=", value, "modelId");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelIdLike(String value) {
            this.addCriterion("model_id like", value, "modelId");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelIdNotLike(String value) {
            this.addCriterion("model_id not like", value, "modelId");
            return (GoatModelExample.Criteria)this;
        }        public GoatModelExample.Criteria andModelIdIn(List<Long> values) {
            this.addCriterion("model_id in", values, "modelId");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelIdNotIn(List<Long> values) {
            this.addCriterion("model_id not in", values, "modelId");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelIdBetween(Long value1, Long value2) {
            this.addCriterion("model_id between", value1, value2, "modelId");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelIdNotBetween(Long value1, Long value2) {
            this.addCriterion("model_id not between", value1, value2, "modelId");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelHtmlIsNull() {
            this.addCriterion("model_html is null");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelHtmlIsNotNull() {
            this.addCriterion("model_html is not null");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelHtmlEqualTo(String value) {
            this.addCriterion("model_html =", value, "modelHtml");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelHtmlNotEqualTo(String value) {
            this.addCriterion("model_html <>", value, "modelHtml");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelHtmlGreaterThan(String value) {
            this.addCriterion("model_html >", value, "modelHtml");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelHtmlGreaterThanOrEqualTo(String value) {
            this.addCriterion("model_html >=", value, "modelHtml");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelHtmlLessThan(String value) {
            this.addCriterion("model_html <", value, "modelHtml");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelHtmlLessThanOrEqualTo(String value) {
            this.addCriterion("model_html <=", value, "modelHtml");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelHtmlLike(String value) {
            this.addCriterion("model_html like", value, "modelHtml");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelHtmlNotLike(String value) {
            this.addCriterion("model_html not like", value, "modelHtml");
            return (GoatModelExample.Criteria)this;
        }        public GoatModelExample.Criteria andModelHtmlIn(List<String> values) {
            this.addCriterion("model_html in", values, "modelHtml");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelHtmlNotIn(List<String> values) {
            this.addCriterion("model_html not in", values, "modelHtml");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelHtmlBetween(String value1, String value2) {
            this.addCriterion("model_html between", value1, value2, "modelHtml");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andModelHtmlNotBetween(String value1, String value2) {
            this.addCriterion("model_html not between", value1, value2, "modelHtml");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andLocationIdIsNull() {
            this.addCriterion("location_id is null");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andLocationIdIsNotNull() {
            this.addCriterion("location_id is not null");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andLocationIdEqualTo(Long value) {
            this.addCriterion("location_id =", value, "locationId");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andLocationIdNotEqualTo(Long value) {
            this.addCriterion("location_id <>", value, "locationId");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andLocationIdGreaterThan(Long value) {
            this.addCriterion("location_id >", value, "locationId");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andLocationIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("location_id >=", value, "locationId");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andLocationIdLessThan(Long value) {
            this.addCriterion("location_id <", value, "locationId");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andLocationIdLessThanOrEqualTo(Long value) {
            this.addCriterion("location_id <=", value, "locationId");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andLocationIdLike(String value) {
            this.addCriterion("location_id like", value, "locationId");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andLocationIdNotLike(String value) {
            this.addCriterion("location_id not like", value, "locationId");
            return (GoatModelExample.Criteria)this;
        }        public GoatModelExample.Criteria andLocationIdIn(List<Long> values) {
            this.addCriterion("location_id in", values, "locationId");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andLocationIdNotIn(List<Long> values) {
            this.addCriterion("location_id not in", values, "locationId");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andLocationIdBetween(Long value1, Long value2) {
            this.addCriterion("location_id between", value1, value2, "locationId");
            return (GoatModelExample.Criteria)this;
        }

        public GoatModelExample.Criteria andLocationIdNotBetween(Long value1, Long value2) {
            this.addCriterion("location_id not between", value1, value2, "locationId");
            return (GoatModelExample.Criteria)this;
        }
    }
}
