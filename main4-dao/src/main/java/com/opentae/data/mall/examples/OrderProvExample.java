package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class OrderProvExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<OrderProvExample.Criteria> oredCriteria = new ArrayList();

    public OrderProvExample() {
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

    public List<OrderProvExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(OrderProvExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public OrderProvExample.Criteria or() {
        OrderProvExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public OrderProvExample.Criteria createCriteria() {
        OrderProvExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected OrderProvExample.Criteria createCriteriaInternal() {
        OrderProvExample.Criteria criteria = new OrderProvExample.Criteria();
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

    public static class Criteria extends OrderProvExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<OrderProvExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<OrderProvExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<OrderProvExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new OrderProvExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new OrderProvExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new OrderProvExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public OrderProvExample.Criteria andProvIdIsNull() {
            this.addCriterion("prov_id is null");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvIdIsNotNull() {
            this.addCriterion("prov_id is not null");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvIdEqualTo(Long value) {
            this.addCriterion("prov_id =", value, "provId");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvIdNotEqualTo(Long value) {
            this.addCriterion("prov_id <>", value, "provId");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvIdGreaterThan(Long value) {
            this.addCriterion("prov_id >", value, "provId");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("prov_id >=", value, "provId");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvIdLessThan(Long value) {
            this.addCriterion("prov_id <", value, "provId");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvIdLessThanOrEqualTo(Long value) {
            this.addCriterion("prov_id <=", value, "provId");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvIdLike(String value) {
            this.addCriterion("prov_id like", value, "provId");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvIdNotLike(String value) {
            this.addCriterion("prov_id not like", value, "provId");
            return (OrderProvExample.Criteria)this;
        }        public OrderProvExample.Criteria andProvIdIn(List<Long> values) {
            this.addCriterion("prov_id in", values, "provId");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvIdNotIn(List<Long> values) {
            this.addCriterion("prov_id not in", values, "provId");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvIdBetween(Long value1, Long value2) {
            this.addCriterion("prov_id between", value1, value2, "provId");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvIdNotBetween(Long value1, Long value2) {
            this.addCriterion("prov_id not between", value1, value2, "provId");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvNameIsNull() {
            this.addCriterion("prov_name is null");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvNameIsNotNull() {
            this.addCriterion("prov_name is not null");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvNameEqualTo(String value) {
            this.addCriterion("prov_name =", value, "provName");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvNameNotEqualTo(String value) {
            this.addCriterion("prov_name <>", value, "provName");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvNameGreaterThan(String value) {
            this.addCriterion("prov_name >", value, "provName");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("prov_name >=", value, "provName");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvNameLessThan(String value) {
            this.addCriterion("prov_name <", value, "provName");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvNameLessThanOrEqualTo(String value) {
            this.addCriterion("prov_name <=", value, "provName");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvNameLike(String value) {
            this.addCriterion("prov_name like", value, "provName");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvNameNotLike(String value) {
            this.addCriterion("prov_name not like", value, "provName");
            return (OrderProvExample.Criteria)this;
        }        public OrderProvExample.Criteria andProvNameIn(List<String> values) {
            this.addCriterion("prov_name in", values, "provName");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvNameNotIn(List<String> values) {
            this.addCriterion("prov_name not in", values, "provName");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvNameBetween(String value1, String value2) {
            this.addCriterion("prov_name between", value1, value2, "provName");
            return (OrderProvExample.Criteria)this;
        }

        public OrderProvExample.Criteria andProvNameNotBetween(String value1, String value2) {
            this.addCriterion("prov_name not between", value1, value2, "provName");
            return (OrderProvExample.Criteria)this;
        }
    }
}
