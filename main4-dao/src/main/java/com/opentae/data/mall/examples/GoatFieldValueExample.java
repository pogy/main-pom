package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class GoatFieldValueExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<GoatFieldValueExample.Criteria> oredCriteria = new ArrayList();

    public GoatFieldValueExample() {
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

    public List<GoatFieldValueExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(GoatFieldValueExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public GoatFieldValueExample.Criteria or() {
        GoatFieldValueExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public GoatFieldValueExample.Criteria createCriteria() {
        GoatFieldValueExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected GoatFieldValueExample.Criteria createCriteriaInternal() {
        GoatFieldValueExample.Criteria criteria = new GoatFieldValueExample.Criteria();
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

    public static class Criteria extends GoatFieldValueExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<GoatFieldValueExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<GoatFieldValueExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<GoatFieldValueExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new GoatFieldValueExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new GoatFieldValueExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new GoatFieldValueExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public GoatFieldValueExample.Criteria andVidIsNull() {
            this.addCriterion("vid is null");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andVidIsNotNull() {
            this.addCriterion("vid is not null");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andVidEqualTo(Long value) {
            this.addCriterion("vid =", value, "vid");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andVidNotEqualTo(Long value) {
            this.addCriterion("vid <>", value, "vid");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andVidGreaterThan(Long value) {
            this.addCriterion("vid >", value, "vid");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andVidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("vid >=", value, "vid");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andVidLessThan(Long value) {
            this.addCriterion("vid <", value, "vid");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andVidLessThanOrEqualTo(Long value) {
            this.addCriterion("vid <=", value, "vid");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andVidLike(String value) {
            this.addCriterion("vid like", value, "vid");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andVidNotLike(String value) {
            this.addCriterion("vid not like", value, "vid");
            return (GoatFieldValueExample.Criteria)this;
        }        public GoatFieldValueExample.Criteria andVidIn(List<Long> values) {
            this.addCriterion("vid in", values, "vid");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andVidNotIn(List<Long> values) {
            this.addCriterion("vid not in", values, "vid");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andVidBetween(Long value1, Long value2) {
            this.addCriterion("vid between", value1, value2, "vid");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andVidNotBetween(Long value1, Long value2) {
            this.addCriterion("vid not between", value1, value2, "vid");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andFidIsNull() {
            this.addCriterion("fid is null");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andFidIsNotNull() {
            this.addCriterion("fid is not null");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andFidEqualTo(Long value) {
            this.addCriterion("fid =", value, "fid");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andFidNotEqualTo(Long value) {
            this.addCriterion("fid <>", value, "fid");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andFidGreaterThan(Long value) {
            this.addCriterion("fid >", value, "fid");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andFidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("fid >=", value, "fid");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andFidLessThan(Long value) {
            this.addCriterion("fid <", value, "fid");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andFidLessThanOrEqualTo(Long value) {
            this.addCriterion("fid <=", value, "fid");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andFidLike(String value) {
            this.addCriterion("fid like", value, "fid");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andFidNotLike(String value) {
            this.addCriterion("fid not like", value, "fid");
            return (GoatFieldValueExample.Criteria)this;
        }        public GoatFieldValueExample.Criteria andFidIn(List<Long> values) {
            this.addCriterion("fid in", values, "fid");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andFidNotIn(List<Long> values) {
            this.addCriterion("fid not in", values, "fid");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andFidBetween(Long value1, Long value2) {
            this.addCriterion("fid between", value1, value2, "fid");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andFidNotBetween(Long value1, Long value2) {
            this.addCriterion("fid not between", value1, value2, "fid");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andGoatIdIsNull() {
            this.addCriterion("goat_id is null");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andGoatIdIsNotNull() {
            this.addCriterion("goat_id is not null");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andGoatIdEqualTo(Long value) {
            this.addCriterion("goat_id =", value, "goatId");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andGoatIdNotEqualTo(Long value) {
            this.addCriterion("goat_id <>", value, "goatId");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andGoatIdGreaterThan(Long value) {
            this.addCriterion("goat_id >", value, "goatId");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andGoatIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("goat_id >=", value, "goatId");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andGoatIdLessThan(Long value) {
            this.addCriterion("goat_id <", value, "goatId");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andGoatIdLessThanOrEqualTo(Long value) {
            this.addCriterion("goat_id <=", value, "goatId");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andGoatIdLike(String value) {
            this.addCriterion("goat_id like", value, "goatId");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andGoatIdNotLike(String value) {
            this.addCriterion("goat_id not like", value, "goatId");
            return (GoatFieldValueExample.Criteria)this;
        }        public GoatFieldValueExample.Criteria andGoatIdIn(List<Long> values) {
            this.addCriterion("goat_id in", values, "goatId");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andGoatIdNotIn(List<Long> values) {
            this.addCriterion("goat_id not in", values, "goatId");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andGoatIdBetween(Long value1, Long value2) {
            this.addCriterion("goat_id between", value1, value2, "goatId");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andGoatIdNotBetween(Long value1, Long value2) {
            this.addCriterion("goat_id not between", value1, value2, "goatId");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andValueIsNull() {
            this.addCriterion("value is null");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andValueIsNotNull() {
            this.addCriterion("value is not null");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andValueEqualTo(String value) {
            this.addCriterion("value =", value, "value");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andValueNotEqualTo(String value) {
            this.addCriterion("value <>", value, "value");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andValueGreaterThan(String value) {
            this.addCriterion("value >", value, "value");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andValueGreaterThanOrEqualTo(String value) {
            this.addCriterion("value >=", value, "value");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andValueLessThan(String value) {
            this.addCriterion("value <", value, "value");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andValueLessThanOrEqualTo(String value) {
            this.addCriterion("value <=", value, "value");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andValueLike(String value) {
            this.addCriterion("value like", value, "value");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andValueNotLike(String value) {
            this.addCriterion("value not like", value, "value");
            return (GoatFieldValueExample.Criteria)this;
        }        public GoatFieldValueExample.Criteria andValueIn(List<String> values) {
            this.addCriterion("value in", values, "value");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andValueNotIn(List<String> values) {
            this.addCriterion("value not in", values, "value");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andValueBetween(String value1, String value2) {
            this.addCriterion("value between", value1, value2, "value");
            return (GoatFieldValueExample.Criteria)this;
        }

        public GoatFieldValueExample.Criteria andValueNotBetween(String value1, String value2) {
            this.addCriterion("value not between", value1, value2, "value");
            return (GoatFieldValueExample.Criteria)this;
        }
    }
}
