package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class OrderIdGeneratorExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<OrderIdGeneratorExample.Criteria> oredCriteria = new ArrayList();

    public OrderIdGeneratorExample() {
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

    public List<OrderIdGeneratorExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(OrderIdGeneratorExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public OrderIdGeneratorExample.Criteria or() {
        OrderIdGeneratorExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public OrderIdGeneratorExample.Criteria createCriteria() {
        OrderIdGeneratorExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected OrderIdGeneratorExample.Criteria createCriteriaInternal() {
        OrderIdGeneratorExample.Criteria criteria = new OrderIdGeneratorExample.Criteria();
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

    public static class Criteria extends OrderIdGeneratorExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<OrderIdGeneratorExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<OrderIdGeneratorExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<OrderIdGeneratorExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new OrderIdGeneratorExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new OrderIdGeneratorExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new OrderIdGeneratorExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public OrderIdGeneratorExample.Criteria andOidIsNull() {
            this.addCriterion("oid is null");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andOidIsNotNull() {
            this.addCriterion("oid is not null");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andOidEqualTo(Long value) {
            this.addCriterion("oid =", value, "oid");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andOidNotEqualTo(Long value) {
            this.addCriterion("oid <>", value, "oid");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andOidGreaterThan(Long value) {
            this.addCriterion("oid >", value, "oid");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andOidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("oid >=", value, "oid");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andOidLessThan(Long value) {
            this.addCriterion("oid <", value, "oid");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andOidLessThanOrEqualTo(Long value) {
            this.addCriterion("oid <=", value, "oid");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andOidLike(String value) {
            this.addCriterion("oid like", value, "oid");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andOidNotLike(String value) {
            this.addCriterion("oid not like", value, "oid");
            return (OrderIdGeneratorExample.Criteria)this;
        }        public OrderIdGeneratorExample.Criteria andOidIn(List<Long> values) {
            this.addCriterion("oid in", values, "oid");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andOidNotIn(List<Long> values) {
            this.addCriterion("oid not in", values, "oid");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andOidBetween(Long value1, Long value2) {
            this.addCriterion("oid between", value1, value2, "oid");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andOidNotBetween(Long value1, Long value2) {
            this.addCriterion("oid not between", value1, value2, "oid");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andTypeIsNull() {
            this.addCriterion("type is null");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andTypeIsNotNull() {
            this.addCriterion("type is not null");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andTypeEqualTo(Integer value) {
            this.addCriterion("type =", value, "type");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andTypeNotEqualTo(Integer value) {
            this.addCriterion("type <>", value, "type");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andTypeGreaterThan(Integer value) {
            this.addCriterion("type >", value, "type");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("type >=", value, "type");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andTypeLessThan(Integer value) {
            this.addCriterion("type <", value, "type");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("type <=", value, "type");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andTypeLike(String value) {
            this.addCriterion("type like", value, "type");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andTypeNotLike(String value) {
            this.addCriterion("type not like", value, "type");
            return (OrderIdGeneratorExample.Criteria)this;
        }        public OrderIdGeneratorExample.Criteria andTypeIn(List<Integer> values) {
            this.addCriterion("type in", values, "type");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andTypeNotIn(List<Integer> values) {
            this.addCriterion("type not in", values, "type");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("type between", value1, value2, "type");
            return (OrderIdGeneratorExample.Criteria)this;
        }

        public OrderIdGeneratorExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("type not between", value1, value2, "type");
            return (OrderIdGeneratorExample.Criteria)this;
        }
    }
}
