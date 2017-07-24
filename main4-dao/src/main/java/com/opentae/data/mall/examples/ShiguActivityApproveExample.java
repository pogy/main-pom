package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/12.
 */
public class ShiguActivityApproveExample implements SgExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguActivityApproveExample.Criteria> oredCriteria = new ArrayList();

    public ShiguActivityApproveExample() {
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

    public List<ShiguActivityApproveExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguActivityApproveExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguActivityApproveExample.Criteria or() {
        ShiguActivityApproveExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguActivityApproveExample.Criteria createCriteria() {
        ShiguActivityApproveExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguActivityApproveExample.Criteria createCriteriaInternal() {
        ShiguActivityApproveExample.Criteria criteria = new ShiguActivityApproveExample.Criteria();
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

    public static class Criteria extends ShiguActivityApproveExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguActivityApproveExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguActivityApproveExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguActivityApproveExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguActivityApproveExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguActivityApproveExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguActivityApproveExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguActivityApproveExample.Criteria andApplyIdIsNull() {
            this.addCriterion("apply_id is null");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andApplyIdIsNotNull() {
            this.addCriterion("apply_id is not null");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andApplyIdEqualTo(Long value) {
            this.addCriterion("apply_id =", value, "applyId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andApplyIdNotEqualTo(Long value) {
            this.addCriterion("apply_id <>", value, "applyId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andApplyIdGreaterThan(Long value) {
            this.addCriterion("apply_id >", value, "applyId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andApplyIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("apply_id >=", value, "applyId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andApplyIdLessThan(Long value) {
            this.addCriterion("apply_id <", value, "applyId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andApplyIdLessThanOrEqualTo(Long value) {
            this.addCriterion("apply_id <=", value, "applyId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andApplyIdLike(String value) {
            this.addCriterion("apply_id like", value, "applyId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andApplyIdNotLike(String value) {
            this.addCriterion("apply_id not like", value, "applyId");
            return (ShiguActivityApproveExample.Criteria)this;
        }        public ShiguActivityApproveExample.Criteria andApplyIdIn(List<Long> values) {
            this.addCriterion("apply_id in", values, "applyId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andApplyIdNotIn(List<Long> values) {
            this.addCriterion("apply_id not in", values, "applyId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andApplyIdBetween(Long value1, Long value2) {
            this.addCriterion("apply_id between", value1, value2, "applyId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andApplyIdNotBetween(Long value1, Long value2) {
            this.addCriterion("apply_id not between", value1, value2, "applyId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andActivityIdIsNull() {
            this.addCriterion("activity_id is null");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andActivityIdIsNotNull() {
            this.addCriterion("activity_id is not null");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andActivityIdEqualTo(Long value) {
            this.addCriterion("activity_id =", value, "activityId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andActivityIdNotEqualTo(Long value) {
            this.addCriterion("activity_id <>", value, "activityId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andActivityIdGreaterThan(Long value) {
            this.addCriterion("activity_id >", value, "activityId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andActivityIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("activity_id >=", value, "activityId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andActivityIdLessThan(Long value) {
            this.addCriterion("activity_id <", value, "activityId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andActivityIdLessThanOrEqualTo(Long value) {
            this.addCriterion("activity_id <=", value, "activityId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andActivityIdLike(String value) {
            this.addCriterion("activity_id like", value, "activityId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andActivityIdNotLike(String value) {
            this.addCriterion("activity_id not like", value, "activityId");
            return (ShiguActivityApproveExample.Criteria)this;
        }        public ShiguActivityApproveExample.Criteria andActivityIdIn(List<Long> values) {
            this.addCriterion("activity_id in", values, "activityId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andActivityIdNotIn(List<Long> values) {
            this.addCriterion("activity_id not in", values, "activityId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andActivityIdBetween(Long value1, Long value2) {
            this.addCriterion("activity_id between", value1, value2, "activityId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andActivityIdNotBetween(Long value1, Long value2) {
            this.addCriterion("activity_id not between", value1, value2, "activityId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andChooseIsNull() {
            this.addCriterion("choose is null");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andChooseIsNotNull() {
            this.addCriterion("choose is not null");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andChooseEqualTo(Integer value) {
            this.addCriterion("choose =", value, "choose");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andChooseNotEqualTo(Integer value) {
            this.addCriterion("choose <>", value, "choose");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andChooseGreaterThan(Integer value) {
            this.addCriterion("choose >", value, "choose");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andChooseGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("choose >=", value, "choose");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andChooseLessThan(Integer value) {
            this.addCriterion("choose <", value, "choose");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andChooseLessThanOrEqualTo(Integer value) {
            this.addCriterion("choose <=", value, "choose");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andChooseLike(String value) {
            this.addCriterion("choose like", value, "choose");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andChooseNotLike(String value) {
            this.addCriterion("choose not like", value, "choose");
            return (ShiguActivityApproveExample.Criteria)this;
        }        public ShiguActivityApproveExample.Criteria andChooseIn(List<Integer> values) {
            this.addCriterion("choose in", values, "choose");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andChooseNotIn(List<Integer> values) {
            this.addCriterion("choose not in", values, "choose");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andChooseBetween(Integer value1, Integer value2) {
            this.addCriterion("choose between", value1, value2, "choose");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andChooseNotBetween(Integer value1, Integer value2) {
            this.addCriterion("choose not between", value1, value2, "choose");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andShopIdIsNull() {
            this.addCriterion("shop_id is null");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andShopIdIsNotNull() {
            this.addCriterion("shop_id is not null");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andShopIdEqualTo(Long value) {
            this.addCriterion("shop_id =", value, "shopId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andShopIdNotEqualTo(Long value) {
            this.addCriterion("shop_id <>", value, "shopId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andShopIdGreaterThan(Long value) {
            this.addCriterion("shop_id >", value, "shopId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("shop_id >=", value, "shopId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andShopIdLessThan(Long value) {
            this.addCriterion("shop_id <", value, "shopId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            this.addCriterion("shop_id <=", value, "shopId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andShopIdLike(String value) {
            this.addCriterion("shop_id like", value, "shopId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andShopIdNotLike(String value) {
            this.addCriterion("shop_id not like", value, "shopId");
            return (ShiguActivityApproveExample.Criteria)this;
        }        public ShiguActivityApproveExample.Criteria andShopIdIn(List<Long> values) {
            this.addCriterion("shop_id in", values, "shopId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andShopIdNotIn(List<Long> values) {
            this.addCriterion("shop_id not in", values, "shopId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andShopIdBetween(Long value1, Long value2) {
            this.addCriterion("shop_id between", value1, value2, "shopId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            this.addCriterion("shop_id not between", value1, value2, "shopId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andItemsIsNull() {
            this.addCriterion("items is null");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andItemsIsNotNull() {
            this.addCriterion("items is not null");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andItemsEqualTo(String value) {
            this.addCriterion("items =", value, "items");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andItemsNotEqualTo(String value) {
            this.addCriterion("items <>", value, "items");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andItemsGreaterThan(String value) {
            this.addCriterion("items >", value, "items");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andItemsGreaterThanOrEqualTo(String value) {
            this.addCriterion("items >=", value, "items");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andItemsLessThan(String value) {
            this.addCriterion("items <", value, "items");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andItemsLessThanOrEqualTo(String value) {
            this.addCriterion("items <=", value, "items");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andItemsLike(String value) {
            this.addCriterion("items like", value, "items");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andItemsNotLike(String value) {
            this.addCriterion("items not like", value, "items");
            return (ShiguActivityApproveExample.Criteria)this;
        }        public ShiguActivityApproveExample.Criteria andItemsIn(List<String> values) {
            this.addCriterion("items in", values, "items");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andItemsNotIn(List<String> values) {
            this.addCriterion("items not in", values, "items");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andItemsBetween(String value1, String value2) {
            this.addCriterion("items between", value1, value2, "items");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andItemsNotBetween(String value1, String value2) {
            this.addCriterion("items not between", value1, value2, "items");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (ShiguActivityApproveExample.Criteria)this;
        }        public ShiguActivityApproveExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andPhoneIsNull() {
            this.addCriterion("phone is null");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andPhoneIsNotNull() {
            this.addCriterion("phone is not null");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andPhoneEqualTo(String value) {
            this.addCriterion("phone =", value, "phone");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andPhoneNotEqualTo(String value) {
            this.addCriterion("phone <>", value, "phone");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andPhoneGreaterThan(String value) {
            this.addCriterion("phone >", value, "phone");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andPhoneGreaterThanOrEqualTo(String value) {
            this.addCriterion("phone >=", value, "phone");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andPhoneLessThan(String value) {
            this.addCriterion("phone <", value, "phone");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andPhoneLessThanOrEqualTo(String value) {
            this.addCriterion("phone <=", value, "phone");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andPhoneLike(String value) {
            this.addCriterion("phone like", value, "phone");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andPhoneNotLike(String value) {
            this.addCriterion("phone not like", value, "phone");
            return (ShiguActivityApproveExample.Criteria)this;
        }        public ShiguActivityApproveExample.Criteria andPhoneIn(List<String> values) {
            this.addCriterion("phone in", values, "phone");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andPhoneNotIn(List<String> values) {
            this.addCriterion("phone not in", values, "phone");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andPhoneBetween(String value1, String value2) {
            this.addCriterion("phone between", value1, value2, "phone");
            return (ShiguActivityApproveExample.Criteria)this;
        }

        public ShiguActivityApproveExample.Criteria andPhoneNotBetween(String value1, String value2) {
            this.addCriterion("phone not between", value1, value2, "phone");
            return (ShiguActivityApproveExample.Criteria)this;
        }
    }
}
