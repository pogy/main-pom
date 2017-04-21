package com.shigu.main4.example.test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by sean on 2017-02-13-0013.
 */
public abstract class SggExample<E extends SggExample.GeneratedCriteria> {
    private String orderByClause;
    private boolean distinct;
    private List<E> oredCriteria = new ArrayList<>();

    private Integer startIndex;
    private Integer endIndex;
    private String fields;
    private String sqlStirng;
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

    public List<? extends GeneratedCriteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(E criteria) {
        this.oredCriteria.add(criteria);
    }

    public E or() {
        E criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public E createCriteria() {
        E criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected abstract E createCriteriaInternal();

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
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }

    protected abstract static class GeneratedCriteria<T extends GeneratedCriteria> {
        protected List<Criterion> criteria = new ArrayList<>();

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
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new SggExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new SggExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 != null && value2 != null) {
                this.criteria.add(new SggExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public T isNull(String field) {
            this.addCriterion(field + " is null");
            return (T)this;
        }

        public T isNotNull(String field) {
            this.addCriterion(field + " is not null");
            return (T)this;
        }

        public T equalTo(String field, Object value) {
            this.addCriterion(field + " =", value, field);
            return (T)this;
        }

        public T notEqualTo(String field, Object value) {
            this.addCriterion(field + " <>", value, field);
            return (T)this;
        }

        public T greaterThan(String field, Object value) {
            this.addCriterion(field + " >", value, field);
            return (T)this;
        }

        public T greaterThanOrEqualTo(String field, Object value) {
            this.addCriterion(field + " >=", value, field);
            return (T)this;
        }

        public T lessThan(String field, Object value) {
            this.addCriterion(field + " <", value, field);
            return (T)this;
        }

        public T lessThanOrEqualTo(String field, Object value) {
            this.addCriterion(field + " <=", value, field);
            return (T)this;
        }

        public T like(String field, String value) {
            this.addCriterion(field + " like", value, field);
            return (T)this;
        }

        public T notLike(String field, String value) {
            this.addCriterion(field + " not like", value, field);
            return (T)this;
        }

        public T in(String field, List<? extends Object> values) {
            this.addCriterion(field + " in", values, field);
            return (T)this;
        }

        public T notIn(String field, List<? extends Object> values) {
            this.addCriterion(field + " not in", values, field);
            return (T)this;
        }

        public T between(String field, Object value1, Object value2) {
            this.addCriterion(field + " between", value1, value2, field);
            return (T)this;
        }

        public T notBetween(String field, Object value1, Object value2) {
            this.addCriterion(field + " not between", value1, value2, field);
            return (T)this;
        }
    }
}
