package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ItemCidWeightExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ItemCidWeightExample.Criteria> oredCriteria = new ArrayList();

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

    public List<ItemCidWeightExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ItemCidWeightExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ItemCidWeightExample.Criteria or() {
        ItemCidWeightExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ItemCidWeightExample.Criteria createCriteria() {
        ItemCidWeightExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ItemCidWeightExample.Criteria createCriteriaInternal() {
        ItemCidWeightExample.Criteria criteria = new ItemCidWeightExample.Criteria();
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

    public static class Criteria extends ItemCidWeightExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ItemCidWeightExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ItemCidWeightExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ItemCidWeightExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ItemCidWeightExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ItemCidWeightExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ItemCidWeightExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ItemCidWeightExample.Criteria andCwIdIsNull() {
            this.addCriterion("cw_id is null");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCwIdIsNotNull() {
            this.addCriterion("cw_id is not null");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCwIdEqualTo(Long value) {
            this.addCriterion("cw_id =", value, "cwId");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCwIdNotEqualTo(Long value) {
            this.addCriterion("cw_id <>", value, "cwId");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCwIdGreaterThan(Long value) {
            this.addCriterion("cw_id >", value, "cwId");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCwIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("cw_id >=", value, "cwId");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCwIdLessThan(Long value) {
            this.addCriterion("cw_id <", value, "cwId");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCwIdLessThanOrEqualTo(Long value) {
            this.addCriterion("cw_id <=", value, "cwId");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCwIdLike(String value) {
            this.addCriterion("cw_id like", value, "cwId");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCwIdNotLike(String value) {
            this.addCriterion("cw_id not like", value, "cwId");
            return (ItemCidWeightExample.Criteria)this;
        }        public ItemCidWeightExample.Criteria andCwIdIn(List<Long> values) {
            this.addCriterion("cw_id in", values, "cwId");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCwIdNotIn(List<Long> values) {
            this.addCriterion("cw_id not in", values, "cwId");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCwIdBetween(Long value1, Long value2) {
            this.addCriterion("cw_id between", value1, value2, "cwId");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCwIdNotBetween(Long value1, Long value2) {
            this.addCriterion("cw_id not between", value1, value2, "cwId");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andWeightIsNull() {
            this.addCriterion("weight is null");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andWeightIsNotNull() {
            this.addCriterion("weight is not null");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andWeightEqualTo(Long value) {
            this.addCriterion("weight =", value, "weight");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andWeightNotEqualTo(Long value) {
            this.addCriterion("weight <>", value, "weight");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andWeightGreaterThan(Long value) {
            this.addCriterion("weight >", value, "weight");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andWeightGreaterThanOrEqualTo(Long value) {
            this.addCriterion("weight >=", value, "weight");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andWeightLessThan(Long value) {
            this.addCriterion("weight <", value, "weight");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andWeightLessThanOrEqualTo(Long value) {
            this.addCriterion("weight <=", value, "weight");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andWeightLike(String value) {
            this.addCriterion("weight like", value, "weight");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andWeightNotLike(String value) {
            this.addCriterion("weight not like", value, "weight");
            return (ItemCidWeightExample.Criteria)this;
        }        public ItemCidWeightExample.Criteria andWeightIn(List<Long> values) {
            this.addCriterion("weight in", values, "weight");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andWeightNotIn(List<Long> values) {
            this.addCriterion("weight not in", values, "weight");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andWeightBetween(Long value1, Long value2) {
            this.addCriterion("weight between", value1, value2, "weight");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andWeightNotBetween(Long value1, Long value2) {
            this.addCriterion("weight not between", value1, value2, "weight");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCidIsNull() {
            this.addCriterion("cid is null");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCidIsNotNull() {
            this.addCriterion("cid is not null");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCidEqualTo(Long value) {
            this.addCriterion("cid =", value, "cid");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCidNotEqualTo(Long value) {
            this.addCriterion("cid <>", value, "cid");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCidGreaterThan(Long value) {
            this.addCriterion("cid >", value, "cid");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("cid >=", value, "cid");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCidLessThan(Long value) {
            this.addCriterion("cid <", value, "cid");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCidLessThanOrEqualTo(Long value) {
            this.addCriterion("cid <=", value, "cid");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCidLike(String value) {
            this.addCriterion("cid like", value, "cid");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCidNotLike(String value) {
            this.addCriterion("cid not like", value, "cid");
            return (ItemCidWeightExample.Criteria)this;
        }        public ItemCidWeightExample.Criteria andCidIn(List<Long> values) {
            this.addCriterion("cid in", values, "cid");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCidNotIn(List<Long> values) {
            this.addCriterion("cid not in", values, "cid");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCidBetween(Long value1, Long value2) {
            this.addCriterion("cid between", value1, value2, "cid");
            return (ItemCidWeightExample.Criteria)this;
        }

        public ItemCidWeightExample.Criteria andCidNotBetween(Long value1, Long value2) {
            this.addCriterion("cid not between", value1, value2, "cid");
            return (ItemCidWeightExample.Criteria)this;
        }
    }
}
