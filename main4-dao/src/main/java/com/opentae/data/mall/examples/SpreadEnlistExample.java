package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class SpreadEnlistExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<SpreadEnlistExample.Criteria> oredCriteria = new ArrayList();

    public SpreadEnlistExample() {
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

    public List<SpreadEnlistExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(SpreadEnlistExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public SpreadEnlistExample.Criteria or() {
        SpreadEnlistExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public SpreadEnlistExample.Criteria createCriteria() {
        SpreadEnlistExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected SpreadEnlistExample.Criteria createCriteriaInternal() {
        SpreadEnlistExample.Criteria criteria = new SpreadEnlistExample.Criteria();
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

    public static class Criteria extends SpreadEnlistExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<SpreadEnlistExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<SpreadEnlistExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<SpreadEnlistExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new SpreadEnlistExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new SpreadEnlistExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new SpreadEnlistExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public SpreadEnlistExample.Criteria andEnlistIdIsNull() {
            this.addCriterion("enlist_id is null");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andEnlistIdIsNotNull() {
            this.addCriterion("enlist_id is not null");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andEnlistIdEqualTo(Long value) {
            this.addCriterion("enlist_id =", value, "enlistId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andEnlistIdNotEqualTo(Long value) {
            this.addCriterion("enlist_id <>", value, "enlistId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andEnlistIdGreaterThan(Long value) {
            this.addCriterion("enlist_id >", value, "enlistId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andEnlistIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("enlist_id >=", value, "enlistId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andEnlistIdLessThan(Long value) {
            this.addCriterion("enlist_id <", value, "enlistId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andEnlistIdLessThanOrEqualTo(Long value) {
            this.addCriterion("enlist_id <=", value, "enlistId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andEnlistIdLike(String value) {
            this.addCriterion("enlist_id like", value, "enlistId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andEnlistIdNotLike(String value) {
            this.addCriterion("enlist_id not like", value, "enlistId");
            return (SpreadEnlistExample.Criteria)this;
        }        public SpreadEnlistExample.Criteria andEnlistIdIn(List<Long> values) {
            this.addCriterion("enlist_id in", values, "enlistId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andEnlistIdNotIn(List<Long> values) {
            this.addCriterion("enlist_id not in", values, "enlistId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andEnlistIdBetween(Long value1, Long value2) {
            this.addCriterion("enlist_id between", value1, value2, "enlistId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andEnlistIdNotBetween(Long value1, Long value2) {
            this.addCriterion("enlist_id not between", value1, value2, "enlistId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andNameIsNull() {
            this.addCriterion("name is null");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andNameIsNotNull() {
            this.addCriterion("name is not null");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andNameEqualTo(String value) {
            this.addCriterion("name =", value, "name");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andNameNotEqualTo(String value) {
            this.addCriterion("name <>", value, "name");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andNameGreaterThan(String value) {
            this.addCriterion("name >", value, "name");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("name >=", value, "name");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andNameLessThan(String value) {
            this.addCriterion("name <", value, "name");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andNameLessThanOrEqualTo(String value) {
            this.addCriterion("name <=", value, "name");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andNameLike(String value) {
            this.addCriterion("name like", value, "name");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andNameNotLike(String value) {
            this.addCriterion("name not like", value, "name");
            return (SpreadEnlistExample.Criteria)this;
        }        public SpreadEnlistExample.Criteria andNameIn(List<String> values) {
            this.addCriterion("name in", values, "name");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andNameNotIn(List<String> values) {
            this.addCriterion("name not in", values, "name");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andNameBetween(String value1, String value2) {
            this.addCriterion("name between", value1, value2, "name");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andNameNotBetween(String value1, String value2) {
            this.addCriterion("name not between", value1, value2, "name");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andTelephoneIsNull() {
            this.addCriterion("telephone is null");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andTelephoneIsNotNull() {
            this.addCriterion("telephone is not null");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andTelephoneEqualTo(String value) {
            this.addCriterion("telephone =", value, "telephone");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andTelephoneNotEqualTo(String value) {
            this.addCriterion("telephone <>", value, "telephone");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andTelephoneGreaterThan(String value) {
            this.addCriterion("telephone >", value, "telephone");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            this.addCriterion("telephone >=", value, "telephone");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andTelephoneLessThan(String value) {
            this.addCriterion("telephone <", value, "telephone");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andTelephoneLessThanOrEqualTo(String value) {
            this.addCriterion("telephone <=", value, "telephone");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andTelephoneLike(String value) {
            this.addCriterion("telephone like", value, "telephone");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andTelephoneNotLike(String value) {
            this.addCriterion("telephone not like", value, "telephone");
            return (SpreadEnlistExample.Criteria)this;
        }        public SpreadEnlistExample.Criteria andTelephoneIn(List<String> values) {
            this.addCriterion("telephone in", values, "telephone");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andTelephoneNotIn(List<String> values) {
            this.addCriterion("telephone not in", values, "telephone");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andTelephoneBetween(String value1, String value2) {
            this.addCriterion("telephone between", value1, value2, "telephone");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andTelephoneNotBetween(String value1, String value2) {
            this.addCriterion("telephone not between", value1, value2, "telephone");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (SpreadEnlistExample.Criteria)this;
        }        public SpreadEnlistExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andShopIdIsNull() {
            this.addCriterion("shop_id is null");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andShopIdIsNotNull() {
            this.addCriterion("shop_id is not null");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andShopIdEqualTo(Long value) {
            this.addCriterion("shop_id =", value, "shopId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andShopIdNotEqualTo(Long value) {
            this.addCriterion("shop_id <>", value, "shopId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andShopIdGreaterThan(Long value) {
            this.addCriterion("shop_id >", value, "shopId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("shop_id >=", value, "shopId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andShopIdLessThan(Long value) {
            this.addCriterion("shop_id <", value, "shopId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            this.addCriterion("shop_id <=", value, "shopId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andShopIdLike(String value) {
            this.addCriterion("shop_id like", value, "shopId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andShopIdNotLike(String value) {
            this.addCriterion("shop_id not like", value, "shopId");
            return (SpreadEnlistExample.Criteria)this;
        }        public SpreadEnlistExample.Criteria andShopIdIn(List<Long> values) {
            this.addCriterion("shop_id in", values, "shopId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andShopIdNotIn(List<Long> values) {
            this.addCriterion("shop_id not in", values, "shopId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andShopIdBetween(Long value1, Long value2) {
            this.addCriterion("shop_id between", value1, value2, "shopId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            this.addCriterion("shop_id not between", value1, value2, "shopId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andDrawIsNull() {
            this.addCriterion("draw is null");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andDrawIsNotNull() {
            this.addCriterion("draw is not null");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andDrawEqualTo(Integer value) {
            this.addCriterion("draw =", value, "draw");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andDrawNotEqualTo(Integer value) {
            this.addCriterion("draw <>", value, "draw");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andDrawGreaterThan(Integer value) {
            this.addCriterion("draw >", value, "draw");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andDrawGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("draw >=", value, "draw");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andDrawLessThan(Integer value) {
            this.addCriterion("draw <", value, "draw");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andDrawLessThanOrEqualTo(Integer value) {
            this.addCriterion("draw <=", value, "draw");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andDrawLike(String value) {
            this.addCriterion("draw like", value, "draw");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andDrawNotLike(String value) {
            this.addCriterion("draw not like", value, "draw");
            return (SpreadEnlistExample.Criteria)this;
        }        public SpreadEnlistExample.Criteria andDrawIn(List<Integer> values) {
            this.addCriterion("draw in", values, "draw");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andDrawNotIn(List<Integer> values) {
            this.addCriterion("draw not in", values, "draw");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andDrawBetween(Integer value1, Integer value2) {
            this.addCriterion("draw between", value1, value2, "draw");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andDrawNotBetween(Integer value1, Integer value2) {
            this.addCriterion("draw not between", value1, value2, "draw");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andActivityIdIsNull() {
            this.addCriterion("activity_id is null");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andActivityIdIsNotNull() {
            this.addCriterion("activity_id is not null");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andActivityIdEqualTo(Long value) {
            this.addCriterion("activity_id =", value, "activityId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andActivityIdNotEqualTo(Long value) {
            this.addCriterion("activity_id <>", value, "activityId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andActivityIdGreaterThan(Long value) {
            this.addCriterion("activity_id >", value, "activityId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andActivityIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("activity_id >=", value, "activityId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andActivityIdLessThan(Long value) {
            this.addCriterion("activity_id <", value, "activityId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andActivityIdLessThanOrEqualTo(Long value) {
            this.addCriterion("activity_id <=", value, "activityId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andActivityIdLike(String value) {
            this.addCriterion("activity_id like", value, "activityId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andActivityIdNotLike(String value) {
            this.addCriterion("activity_id not like", value, "activityId");
            return (SpreadEnlistExample.Criteria)this;
        }        public SpreadEnlistExample.Criteria andActivityIdIn(List<Long> values) {
            this.addCriterion("activity_id in", values, "activityId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andActivityIdNotIn(List<Long> values) {
            this.addCriterion("activity_id not in", values, "activityId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andActivityIdBetween(Long value1, Long value2) {
            this.addCriterion("activity_id between", value1, value2, "activityId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andActivityIdNotBetween(Long value1, Long value2) {
            this.addCriterion("activity_id not between", value1, value2, "activityId");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (SpreadEnlistExample.Criteria)this;
        }        public SpreadEnlistExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (SpreadEnlistExample.Criteria)this;
        }

        public SpreadEnlistExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (SpreadEnlistExample.Criteria)this;
        }
    }
}
