package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShiguTempExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguTempExample.Criteria> oredCriteria = new ArrayList();

    public ShiguTempExample() {
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

    public List<ShiguTempExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguTempExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguTempExample.Criteria or() {
        ShiguTempExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguTempExample.Criteria createCriteria() {
        ShiguTempExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguTempExample.Criteria createCriteriaInternal() {
        ShiguTempExample.Criteria criteria = new ShiguTempExample.Criteria();
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

    public static class Criteria extends ShiguTempExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguTempExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguTempExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguTempExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguTempExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguTempExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguTempExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguTempExample.Criteria andIdIsNull() {
            this.addCriterion("id is null");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andIdIsNotNull() {
            this.addCriterion("id is not null");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andIdEqualTo(Long value) {
            this.addCriterion("id =", value, "id");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andIdNotEqualTo(Long value) {
            this.addCriterion("id <>", value, "id");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andIdGreaterThan(Long value) {
            this.addCriterion("id >", value, "id");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("id >=", value, "id");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andIdLessThan(Long value) {
            this.addCriterion("id <", value, "id");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andIdLessThanOrEqualTo(Long value) {
            this.addCriterion("id <=", value, "id");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andIdLike(String value) {
            this.addCriterion("id like", value, "id");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andIdNotLike(String value) {
            this.addCriterion("id not like", value, "id");
            return (ShiguTempExample.Criteria)this;
        }        public ShiguTempExample.Criteria andIdIn(List<Long> values) {
            this.addCriterion("id in", values, "id");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andIdNotIn(List<Long> values) {
            this.addCriterion("id not in", values, "id");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andIdBetween(Long value1, Long value2) {
            this.addCriterion("id between", value1, value2, "id");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andIdNotBetween(Long value1, Long value2) {
            this.addCriterion("id not between", value1, value2, "id");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey3IsNull() {
            this.addCriterion("key3 is null");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey3IsNotNull() {
            this.addCriterion("key3 is not null");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey3EqualTo(String value) {
            this.addCriterion("key3 =", value, "key3");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey3NotEqualTo(String value) {
            this.addCriterion("key3 <>", value, "key3");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey3GreaterThan(String value) {
            this.addCriterion("key3 >", value, "key3");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey3GreaterThanOrEqualTo(String value) {
            this.addCriterion("key3 >=", value, "key3");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey3LessThan(String value) {
            this.addCriterion("key3 <", value, "key3");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey3LessThanOrEqualTo(String value) {
            this.addCriterion("key3 <=", value, "key3");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey3Like(String value) {
            this.addCriterion("key3 like", value, "key3");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey3NotLike(String value) {
            this.addCriterion("key3 not like", value, "key3");
            return (ShiguTempExample.Criteria)this;
        }        public ShiguTempExample.Criteria andKey3In(List<String> values) {
            this.addCriterion("key3 in", values, "key3");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey3NotIn(List<String> values) {
            this.addCriterion("key3 not in", values, "key3");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey3Between(String value1, String value2) {
            this.addCriterion("key3 between", value1, value2, "key3");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey3NotBetween(String value1, String value2) {
            this.addCriterion("key3 not between", value1, value2, "key3");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andFlagIsNull() {
            this.addCriterion("flag is null");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andFlagIsNotNull() {
            this.addCriterion("flag is not null");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andFlagEqualTo(String value) {
            this.addCriterion("flag =", value, "flag");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andFlagNotEqualTo(String value) {
            this.addCriterion("flag <>", value, "flag");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andFlagGreaterThan(String value) {
            this.addCriterion("flag >", value, "flag");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andFlagGreaterThanOrEqualTo(String value) {
            this.addCriterion("flag >=", value, "flag");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andFlagLessThan(String value) {
            this.addCriterion("flag <", value, "flag");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andFlagLessThanOrEqualTo(String value) {
            this.addCriterion("flag <=", value, "flag");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andFlagLike(String value) {
            this.addCriterion("flag like", value, "flag");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andFlagNotLike(String value) {
            this.addCriterion("flag not like", value, "flag");
            return (ShiguTempExample.Criteria)this;
        }        public ShiguTempExample.Criteria andFlagIn(List<String> values) {
            this.addCriterion("flag in", values, "flag");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andFlagNotIn(List<String> values) {
            this.addCriterion("flag not in", values, "flag");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andFlagBetween(String value1, String value2) {
            this.addCriterion("flag between", value1, value2, "flag");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andFlagNotBetween(String value1, String value2) {
            this.addCriterion("flag not between", value1, value2, "flag");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey2IsNull() {
            this.addCriterion("key2 is null");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey2IsNotNull() {
            this.addCriterion("key2 is not null");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey2EqualTo(String value) {
            this.addCriterion("key2 =", value, "key2");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey2NotEqualTo(String value) {
            this.addCriterion("key2 <>", value, "key2");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey2GreaterThan(String value) {
            this.addCriterion("key2 >", value, "key2");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey2GreaterThanOrEqualTo(String value) {
            this.addCriterion("key2 >=", value, "key2");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey2LessThan(String value) {
            this.addCriterion("key2 <", value, "key2");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey2LessThanOrEqualTo(String value) {
            this.addCriterion("key2 <=", value, "key2");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey2Like(String value) {
            this.addCriterion("key2 like", value, "key2");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey2NotLike(String value) {
            this.addCriterion("key2 not like", value, "key2");
            return (ShiguTempExample.Criteria)this;
        }        public ShiguTempExample.Criteria andKey2In(List<String> values) {
            this.addCriterion("key2 in", values, "key2");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey2NotIn(List<String> values) {
            this.addCriterion("key2 not in", values, "key2");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey2Between(String value1, String value2) {
            this.addCriterion("key2 between", value1, value2, "key2");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey2NotBetween(String value1, String value2) {
            this.addCriterion("key2 not between", value1, value2, "key2");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey1IsNull() {
            this.addCriterion("key1 is null");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey1IsNotNull() {
            this.addCriterion("key1 is not null");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey1EqualTo(String value) {
            this.addCriterion("key1 =", value, "key1");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey1NotEqualTo(String value) {
            this.addCriterion("key1 <>", value, "key1");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey1GreaterThan(String value) {
            this.addCriterion("key1 >", value, "key1");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey1GreaterThanOrEqualTo(String value) {
            this.addCriterion("key1 >=", value, "key1");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey1LessThan(String value) {
            this.addCriterion("key1 <", value, "key1");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey1LessThanOrEqualTo(String value) {
            this.addCriterion("key1 <=", value, "key1");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey1Like(String value) {
            this.addCriterion("key1 like", value, "key1");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey1NotLike(String value) {
            this.addCriterion("key1 not like", value, "key1");
            return (ShiguTempExample.Criteria)this;
        }        public ShiguTempExample.Criteria andKey1In(List<String> values) {
            this.addCriterion("key1 in", values, "key1");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey1NotIn(List<String> values) {
            this.addCriterion("key1 not in", values, "key1");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey1Between(String value1, String value2) {
            this.addCriterion("key1 between", value1, value2, "key1");
            return (ShiguTempExample.Criteria)this;
        }

        public ShiguTempExample.Criteria andKey1NotBetween(String value1, String value2) {
            this.addCriterion("key1 not between", value1, value2, "key1");
            return (ShiguTempExample.Criteria)this;
        }
    }
}
