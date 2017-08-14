package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ItemCidWeightExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

    public ItemCidWeightExample() {
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

        public Criteria andWeightIsNull() {
            this.addCriterion("weight is null");
            return (Criteria)this;
        }

        public Criteria andWeightIsNotNull() {
            this.addCriterion("weight is not null");
            return (Criteria)this;
        }

        public Criteria andWeightEqualTo(Long value) {
            this.addCriterion("weight =", value, "weight");
            return (Criteria)this;
        }

        public Criteria andWeightNotEqualTo(Long value) {
            this.addCriterion("weight <>", value, "weight");
            return (Criteria)this;
        }

        public Criteria andWeightGreaterThan(Long value) {
            this.addCriterion("weight >", value, "weight");
            return (Criteria)this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Long value) {
            this.addCriterion("weight >=", value, "weight");
            return (Criteria)this;
        }

        public Criteria andWeightLessThan(Long value) {
            this.addCriterion("weight <", value, "weight");
            return (Criteria)this;
        }

        public Criteria andWeightLessThanOrEqualTo(Long value) {
            this.addCriterion("weight <=", value, "weight");
            return (Criteria)this;
        }

        public Criteria andWeightLike(String value) {
            this.addCriterion("weight like", value, "weight");
            return (Criteria)this;
        }

        public Criteria andWeightNotLike(String value) {
            this.addCriterion("weight not like", value, "weight");
            return (Criteria)this;
        }        public Criteria andWeightIn(List<Long> values) {
            this.addCriterion("weight in", values, "weight");
            return (Criteria)this;
        }

        public Criteria andWeightNotIn(List<Long> values) {
            this.addCriterion("weight not in", values, "weight");
            return (Criteria)this;
        }

        public Criteria andWeightBetween(Long value1, Long value2) {
            this.addCriterion("weight between", value1, value2, "weight");
            return (Criteria)this;
        }

        public Criteria andWeightNotBetween(Long value1, Long value2) {
            this.addCriterion("weight not between", value1, value2, "weight");
            return (Criteria)this;
        }

        public Criteria andCwIdIsNull() {
            this.addCriterion("cw_id is null");
            return (Criteria)this;
        }

        public Criteria andCwIdIsNotNull() {
            this.addCriterion("cw_id is not null");
            return (Criteria)this;
        }

        public Criteria andCwIdEqualTo(Long value) {
            this.addCriterion("cw_id =", value, "cwId");
            return (Criteria)this;
        }

        public Criteria andCwIdNotEqualTo(Long value) {
            this.addCriterion("cw_id <>", value, "cwId");
            return (Criteria)this;
        }

        public Criteria andCwIdGreaterThan(Long value) {
            this.addCriterion("cw_id >", value, "cwId");
            return (Criteria)this;
        }

        public Criteria andCwIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("cw_id >=", value, "cwId");
            return (Criteria)this;
        }

        public Criteria andCwIdLessThan(Long value) {
            this.addCriterion("cw_id <", value, "cwId");
            return (Criteria)this;
        }

        public Criteria andCwIdLessThanOrEqualTo(Long value) {
            this.addCriterion("cw_id <=", value, "cwId");
            return (Criteria)this;
        }

        public Criteria andCwIdLike(String value) {
            this.addCriterion("cw_id like", value, "cwId");
            return (Criteria)this;
        }

        public Criteria andCwIdNotLike(String value) {
            this.addCriterion("cw_id not like", value, "cwId");
            return (Criteria)this;
        }        public Criteria andCwIdIn(List<Long> values) {
            this.addCriterion("cw_id in", values, "cwId");
            return (Criteria)this;
        }

        public Criteria andCwIdNotIn(List<Long> values) {
            this.addCriterion("cw_id not in", values, "cwId");
            return (Criteria)this;
        }

        public Criteria andCwIdBetween(Long value1, Long value2) {
            this.addCriterion("cw_id between", value1, value2, "cwId");
            return (Criteria)this;
        }

        public Criteria andCwIdNotBetween(Long value1, Long value2) {
            this.addCriterion("cw_id not between", value1, value2, "cwId");
            return (Criteria)this;
        }

        public Criteria andCidIsNull() {
            this.addCriterion("cid is null");
            return (Criteria)this;
        }

        public Criteria andCidIsNotNull() {
            this.addCriterion("cid is not null");
            return (Criteria)this;
        }

        public Criteria andCidEqualTo(Long value) {
            this.addCriterion("cid =", value, "cid");
            return (Criteria)this;
        }

        public Criteria andCidNotEqualTo(Long value) {
            this.addCriterion("cid <>", value, "cid");
            return (Criteria)this;
        }

        public Criteria andCidGreaterThan(Long value) {
            this.addCriterion("cid >", value, "cid");
            return (Criteria)this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("cid >=", value, "cid");
            return (Criteria)this;
        }

        public Criteria andCidLessThan(Long value) {
            this.addCriterion("cid <", value, "cid");
            return (Criteria)this;
        }

        public Criteria andCidLessThanOrEqualTo(Long value) {
            this.addCriterion("cid <=", value, "cid");
            return (Criteria)this;
        }

        public Criteria andCidLike(String value) {
            this.addCriterion("cid like", value, "cid");
            return (Criteria)this;
        }

        public Criteria andCidNotLike(String value) {
            this.addCriterion("cid not like", value, "cid");
            return (Criteria)this;
        }        public Criteria andCidIn(List<Long> values) {
            this.addCriterion("cid in", values, "cid");
            return (Criteria)this;
        }

        public Criteria andCidNotIn(List<Long> values) {
            this.addCriterion("cid not in", values, "cid");
            return (Criteria)this;
        }

        public Criteria andCidBetween(Long value1, Long value2) {
            this.addCriterion("cid between", value1, value2, "cid");
            return (Criteria)this;
        }

        public Criteria andCidNotBetween(Long value1, Long value2) {
            this.addCriterion("cid not between", value1, value2, "cid");
            return (Criteria)this;
        }
    }
}
