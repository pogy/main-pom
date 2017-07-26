package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/12.
 */
public class ShiguActivityCategoryExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguActivityCategoryExample.Criteria> oredCriteria = new ArrayList();

    public ShiguActivityCategoryExample() {
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

    public List<ShiguActivityCategoryExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguActivityCategoryExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguActivityCategoryExample.Criteria or() {
        ShiguActivityCategoryExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguActivityCategoryExample.Criteria createCriteria() {
        ShiguActivityCategoryExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguActivityCategoryExample.Criteria createCriteriaInternal() {
        ShiguActivityCategoryExample.Criteria criteria = new ShiguActivityCategoryExample.Criteria();
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

    public static class Criteria extends ShiguActivityCategoryExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguActivityCategoryExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguActivityCategoryExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguActivityCategoryExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguActivityCategoryExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguActivityCategoryExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguActivityCategoryExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguActivityCategoryExample.Criteria andApplyIdIsNull() {
            this.addCriterion("apply_id is null");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andApplyIdIsNotNull() {
            this.addCriterion("apply_id is not null");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andApplyIdEqualTo(Long value) {
            this.addCriterion("apply_id =", value, "applyId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andApplyIdNotEqualTo(Long value) {
            this.addCriterion("apply_id <>", value, "applyId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andApplyIdGreaterThan(Long value) {
            this.addCriterion("apply_id >", value, "applyId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andApplyIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("apply_id >=", value, "applyId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andApplyIdLessThan(Long value) {
            this.addCriterion("apply_id <", value, "applyId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andApplyIdLessThanOrEqualTo(Long value) {
            this.addCriterion("apply_id <=", value, "applyId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andApplyIdLike(String value) {
            this.addCriterion("apply_id like", value, "applyId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andApplyIdNotLike(String value) {
            this.addCriterion("apply_id not like", value, "applyId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }        public ShiguActivityCategoryExample.Criteria andApplyIdIn(List<Long> values) {
            this.addCriterion("apply_id in", values, "applyId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andApplyIdNotIn(List<Long> values) {
            this.addCriterion("apply_id not in", values, "applyId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andApplyIdBetween(Long value1, Long value2) {
            this.addCriterion("apply_id between", value1, value2, "applyId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andApplyIdNotBetween(Long value1, Long value2) {
            this.addCriterion("apply_id not between", value1, value2, "applyId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActivityIdIsNull() {
            this.addCriterion("activity_id is null");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActivityIdIsNotNull() {
            this.addCriterion("activity_id is not null");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActivityIdEqualTo(Long value) {
            this.addCriterion("activity_id =", value, "activityId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActivityIdNotEqualTo(Long value) {
            this.addCriterion("activity_id <>", value, "activityId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActivityIdGreaterThan(Long value) {
            this.addCriterion("activity_id >", value, "activityId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActivityIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("activity_id >=", value, "activityId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActivityIdLessThan(Long value) {
            this.addCriterion("activity_id <", value, "activityId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActivityIdLessThanOrEqualTo(Long value) {
            this.addCriterion("activity_id <=", value, "activityId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActivityIdLike(String value) {
            this.addCriterion("activity_id like", value, "activityId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActivityIdNotLike(String value) {
            this.addCriterion("activity_id not like", value, "activityId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }        public ShiguActivityCategoryExample.Criteria andActivityIdIn(List<Long> values) {
            this.addCriterion("activity_id in", values, "activityId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActivityIdNotIn(List<Long> values) {
            this.addCriterion("activity_id not in", values, "activityId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActivityIdBetween(Long value1, Long value2) {
            this.addCriterion("activity_id between", value1, value2, "activityId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andActivityIdNotBetween(Long value1, Long value2) {
            this.addCriterion("activity_id not between", value1, value2, "activityId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andChooseIsNull() {
            this.addCriterion("choose is null");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andChooseIsNotNull() {
            this.addCriterion("choose is not null");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andChooseEqualTo(Integer value) {
            this.addCriterion("choose =", value, "choose");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andChooseNotEqualTo(Integer value) {
            this.addCriterion("choose <>", value, "choose");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andChooseGreaterThan(Integer value) {
            this.addCriterion("choose >", value, "choose");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andChooseGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("choose >=", value, "choose");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andChooseLessThan(Integer value) {
            this.addCriterion("choose <", value, "choose");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andChooseLessThanOrEqualTo(Integer value) {
            this.addCriterion("choose <=", value, "choose");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andChooseLike(String value) {
            this.addCriterion("choose like", value, "choose");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andChooseNotLike(String value) {
            this.addCriterion("choose not like", value, "choose");
            return (ShiguActivityCategoryExample.Criteria)this;
        }        public ShiguActivityCategoryExample.Criteria andChooseIn(List<Integer> values) {
            this.addCriterion("choose in", values, "choose");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andChooseNotIn(List<Integer> values) {
            this.addCriterion("choose not in", values, "choose");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andChooseBetween(Integer value1, Integer value2) {
            this.addCriterion("choose between", value1, value2, "choose");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andChooseNotBetween(Integer value1, Integer value2) {
            this.addCriterion("choose not between", value1, value2, "choose");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andShopIdIsNull() {
            this.addCriterion("shop_id is null");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andShopIdIsNotNull() {
            this.addCriterion("shop_id is not null");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andShopIdEqualTo(Long value) {
            this.addCriterion("shop_id =", value, "shopId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andShopIdNotEqualTo(Long value) {
            this.addCriterion("shop_id <>", value, "shopId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andShopIdGreaterThan(Long value) {
            this.addCriterion("shop_id >", value, "shopId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("shop_id >=", value, "shopId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andShopIdLessThan(Long value) {
            this.addCriterion("shop_id <", value, "shopId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            this.addCriterion("shop_id <=", value, "shopId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andShopIdLike(String value) {
            this.addCriterion("shop_id like", value, "shopId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andShopIdNotLike(String value) {
            this.addCriterion("shop_id not like", value, "shopId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }        public ShiguActivityCategoryExample.Criteria andShopIdIn(List<Long> values) {
            this.addCriterion("shop_id in", values, "shopId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andShopIdNotIn(List<Long> values) {
            this.addCriterion("shop_id not in", values, "shopId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andShopIdBetween(Long value1, Long value2) {
            this.addCriterion("shop_id between", value1, value2, "shopId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            this.addCriterion("shop_id not between", value1, value2, "shopId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andItemsIsNull() {
            this.addCriterion("items is null");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andItemsIsNotNull() {
            this.addCriterion("items is not null");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andItemsEqualTo(String value) {
            this.addCriterion("items =", value, "items");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andItemsNotEqualTo(String value) {
            this.addCriterion("items <>", value, "items");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andItemsGreaterThan(String value) {
            this.addCriterion("items >", value, "items");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andItemsGreaterThanOrEqualTo(String value) {
            this.addCriterion("items >=", value, "items");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andItemsLessThan(String value) {
            this.addCriterion("items <", value, "items");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andItemsLessThanOrEqualTo(String value) {
            this.addCriterion("items <=", value, "items");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andItemsLike(String value) {
            this.addCriterion("items like", value, "items");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andItemsNotLike(String value) {
            this.addCriterion("items not like", value, "items");
            return (ShiguActivityCategoryExample.Criteria)this;
        }        public ShiguActivityCategoryExample.Criteria andItemsIn(List<String> values) {
            this.addCriterion("items in", values, "items");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andItemsNotIn(List<String> values) {
            this.addCriterion("items not in", values, "items");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andItemsBetween(String value1, String value2) {
            this.addCriterion("items between", value1, value2, "items");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andItemsNotBetween(String value1, String value2) {
            this.addCriterion("items not between", value1, value2, "items");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }        public ShiguActivityCategoryExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andPhoneIsNull() {
            this.addCriterion("phone is null");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andPhoneIsNotNull() {
            this.addCriterion("phone is not null");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andPhoneEqualTo(String value) {
            this.addCriterion("phone =", value, "phone");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andPhoneNotEqualTo(String value) {
            this.addCriterion("phone <>", value, "phone");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andPhoneGreaterThan(String value) {
            this.addCriterion("phone >", value, "phone");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andPhoneGreaterThanOrEqualTo(String value) {
            this.addCriterion("phone >=", value, "phone");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andPhoneLessThan(String value) {
            this.addCriterion("phone <", value, "phone");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andPhoneLessThanOrEqualTo(String value) {
            this.addCriterion("phone <=", value, "phone");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andPhoneLike(String value) {
            this.addCriterion("phone like", value, "phone");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andPhoneNotLike(String value) {
            this.addCriterion("phone not like", value, "phone");
            return (ShiguActivityCategoryExample.Criteria)this;
        }        public ShiguActivityCategoryExample.Criteria andPhoneIn(List<String> values) {
            this.addCriterion("phone in", values, "phone");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andPhoneNotIn(List<String> values) {
            this.addCriterion("phone not in", values, "phone");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andPhoneBetween(String value1, String value2) {
            this.addCriterion("phone between", value1, value2, "phone");
            return (ShiguActivityCategoryExample.Criteria)this;
        }

        public ShiguActivityCategoryExample.Criteria andPhoneNotBetween(String value1, String value2) {
            this.addCriterion("phone not between", value1, value2, "phone");
            return (ShiguActivityCategoryExample.Criteria)this;
        }
    }
}
