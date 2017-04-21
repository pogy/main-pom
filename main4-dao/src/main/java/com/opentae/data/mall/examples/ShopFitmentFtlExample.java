package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShopFitmentFtlExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShopFitmentFtlExample.Criteria> oredCriteria = new ArrayList();

    public ShopFitmentFtlExample() {
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

    public List<ShopFitmentFtlExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShopFitmentFtlExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShopFitmentFtlExample.Criteria or() {
        ShopFitmentFtlExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShopFitmentFtlExample.Criteria createCriteria() {
        ShopFitmentFtlExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShopFitmentFtlExample.Criteria createCriteriaInternal() {
        ShopFitmentFtlExample.Criteria criteria = new ShopFitmentFtlExample.Criteria();
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

    public static class Criteria extends ShopFitmentFtlExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShopFitmentFtlExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShopFitmentFtlExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShopFitmentFtlExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShopFitmentFtlExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShopFitmentFtlExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShopFitmentFtlExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShopFitmentFtlExample.Criteria andFtlIdIsNull() {
            this.addCriterion("ftl_id is null");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andFtlIdIsNotNull() {
            this.addCriterion("ftl_id is not null");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andFtlIdEqualTo(Long value) {
            this.addCriterion("ftl_id =", value, "ftlId");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andFtlIdNotEqualTo(Long value) {
            this.addCriterion("ftl_id <>", value, "ftlId");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andFtlIdGreaterThan(Long value) {
            this.addCriterion("ftl_id >", value, "ftlId");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andFtlIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("ftl_id >=", value, "ftlId");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andFtlIdLessThan(Long value) {
            this.addCriterion("ftl_id <", value, "ftlId");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andFtlIdLessThanOrEqualTo(Long value) {
            this.addCriterion("ftl_id <=", value, "ftlId");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andFtlIdLike(String value) {
            this.addCriterion("ftl_id like", value, "ftlId");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andFtlIdNotLike(String value) {
            this.addCriterion("ftl_id not like", value, "ftlId");
            return (ShopFitmentFtlExample.Criteria)this;
        }        public ShopFitmentFtlExample.Criteria andFtlIdIn(List<Long> values) {
            this.addCriterion("ftl_id in", values, "ftlId");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andFtlIdNotIn(List<Long> values) {
            this.addCriterion("ftl_id not in", values, "ftlId");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andFtlIdBetween(Long value1, Long value2) {
            this.addCriterion("ftl_id between", value1, value2, "ftlId");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andFtlIdNotBetween(Long value1, Long value2) {
            this.addCriterion("ftl_id not between", value1, value2, "ftlId");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andPageIdIsNull() {
            this.addCriterion("page_id is null");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andPageIdIsNotNull() {
            this.addCriterion("page_id is not null");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andPageIdEqualTo(Long value) {
            this.addCriterion("page_id =", value, "pageId");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andPageIdNotEqualTo(Long value) {
            this.addCriterion("page_id <>", value, "pageId");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andPageIdGreaterThan(Long value) {
            this.addCriterion("page_id >", value, "pageId");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andPageIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("page_id >=", value, "pageId");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andPageIdLessThan(Long value) {
            this.addCriterion("page_id <", value, "pageId");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andPageIdLessThanOrEqualTo(Long value) {
            this.addCriterion("page_id <=", value, "pageId");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andPageIdLike(String value) {
            this.addCriterion("page_id like", value, "pageId");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andPageIdNotLike(String value) {
            this.addCriterion("page_id not like", value, "pageId");
            return (ShopFitmentFtlExample.Criteria)this;
        }        public ShopFitmentFtlExample.Criteria andPageIdIn(List<Long> values) {
            this.addCriterion("page_id in", values, "pageId");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andPageIdNotIn(List<Long> values) {
            this.addCriterion("page_id not in", values, "pageId");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andPageIdBetween(Long value1, Long value2) {
            this.addCriterion("page_id between", value1, value2, "pageId");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andPageIdNotBetween(Long value1, Long value2) {
            this.addCriterion("page_id not between", value1, value2, "pageId");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andContextIsNull() {
            this.addCriterion("context is null");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andContextIsNotNull() {
            this.addCriterion("context is not null");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andContextEqualTo(String value) {
            this.addCriterion("context =", value, "context");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andContextNotEqualTo(String value) {
            this.addCriterion("context <>", value, "context");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andContextGreaterThan(String value) {
            this.addCriterion("context >", value, "context");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andContextGreaterThanOrEqualTo(String value) {
            this.addCriterion("context >=", value, "context");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andContextLessThan(String value) {
            this.addCriterion("context <", value, "context");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andContextLessThanOrEqualTo(String value) {
            this.addCriterion("context <=", value, "context");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andContextLike(String value) {
            this.addCriterion("context like", value, "context");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andContextNotLike(String value) {
            this.addCriterion("context not like", value, "context");
            return (ShopFitmentFtlExample.Criteria)this;
        }        public ShopFitmentFtlExample.Criteria andContextIn(List<String> values) {
            this.addCriterion("context in", values, "context");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andContextNotIn(List<String> values) {
            this.addCriterion("context not in", values, "context");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andContextBetween(String value1, String value2) {
            this.addCriterion("context between", value1, value2, "context");
            return (ShopFitmentFtlExample.Criteria)this;
        }

        public ShopFitmentFtlExample.Criteria andContextNotBetween(String value1, String value2) {
            this.addCriterion("context not between", value1, value2, "context");
            return (ShopFitmentFtlExample.Criteria)this;
        }
    }
}
