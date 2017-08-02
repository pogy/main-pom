package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShiguActivityApplyExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguActivityApplyExample.Criteria> oredCriteria = new ArrayList();

    public ShiguActivityApplyExample() {
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

    public List<ShiguActivityApplyExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguActivityApplyExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguActivityApplyExample.Criteria or() {
        ShiguActivityApplyExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguActivityApplyExample.Criteria createCriteria() {
        ShiguActivityApplyExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguActivityApplyExample.Criteria createCriteriaInternal() {
        ShiguActivityApplyExample.Criteria criteria = new ShiguActivityApplyExample.Criteria();
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

    public static class Criteria extends ShiguActivityApplyExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguActivityApplyExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguActivityApplyExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguActivityApplyExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguActivityApplyExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguActivityApplyExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguActivityApplyExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguActivityApplyExample.Criteria andShopIdIsNull() {
            this.addCriterion("shop_id is null");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andShopIdIsNotNull() {
            this.addCriterion("shop_id is not null");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andShopIdEqualTo(Long value) {
            this.addCriterion("shop_id =", value, "shopId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andShopIdNotEqualTo(Long value) {
            this.addCriterion("shop_id <>", value, "shopId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andShopIdGreaterThan(Long value) {
            this.addCriterion("shop_id >", value, "shopId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("shop_id >=", value, "shopId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andShopIdLessThan(Long value) {
            this.addCriterion("shop_id <", value, "shopId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            this.addCriterion("shop_id <=", value, "shopId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andShopIdLike(String value) {
            this.addCriterion("shop_id like", value, "shopId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andShopIdNotLike(String value) {
            this.addCriterion("shop_id not like", value, "shopId");
            return (ShiguActivityApplyExample.Criteria)this;
        }        public ShiguActivityApplyExample.Criteria andShopIdIn(List<Long> values) {
            this.addCriterion("shop_id in", values, "shopId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andShopIdNotIn(List<Long> values) {
            this.addCriterion("shop_id not in", values, "shopId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andShopIdBetween(Long value1, Long value2) {
            this.addCriterion("shop_id between", value1, value2, "shopId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            this.addCriterion("shop_id not between", value1, value2, "shopId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (ShiguActivityApplyExample.Criteria)this;
        }        public ShiguActivityApplyExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andPhoneIsNull() {
            this.addCriterion("phone is null");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andPhoneIsNotNull() {
            this.addCriterion("phone is not null");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andPhoneEqualTo(String value) {
            this.addCriterion("phone =", value, "phone");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andPhoneNotEqualTo(String value) {
            this.addCriterion("phone <>", value, "phone");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andPhoneGreaterThan(String value) {
            this.addCriterion("phone >", value, "phone");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andPhoneGreaterThanOrEqualTo(String value) {
            this.addCriterion("phone >=", value, "phone");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andPhoneLessThan(String value) {
            this.addCriterion("phone <", value, "phone");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andPhoneLessThanOrEqualTo(String value) {
            this.addCriterion("phone <=", value, "phone");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andPhoneLike(String value) {
            this.addCriterion("phone like", value, "phone");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andPhoneNotLike(String value) {
            this.addCriterion("phone not like", value, "phone");
            return (ShiguActivityApplyExample.Criteria)this;
        }        public ShiguActivityApplyExample.Criteria andPhoneIn(List<String> values) {
            this.addCriterion("phone in", values, "phone");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andPhoneNotIn(List<String> values) {
            this.addCriterion("phone not in", values, "phone");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andPhoneBetween(String value1, String value2) {
            this.addCriterion("phone between", value1, value2, "phone");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andPhoneNotBetween(String value1, String value2) {
            this.addCriterion("phone not between", value1, value2, "phone");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andActivityIdIsNull() {
            this.addCriterion("activity_id is null");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andActivityIdIsNotNull() {
            this.addCriterion("activity_id is not null");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andActivityIdEqualTo(Long value) {
            this.addCriterion("activity_id =", value, "activityId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andActivityIdNotEqualTo(Long value) {
            this.addCriterion("activity_id <>", value, "activityId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andActivityIdGreaterThan(Long value) {
            this.addCriterion("activity_id >", value, "activityId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andActivityIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("activity_id >=", value, "activityId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andActivityIdLessThan(Long value) {
            this.addCriterion("activity_id <", value, "activityId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andActivityIdLessThanOrEqualTo(Long value) {
            this.addCriterion("activity_id <=", value, "activityId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andActivityIdLike(String value) {
            this.addCriterion("activity_id like", value, "activityId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andActivityIdNotLike(String value) {
            this.addCriterion("activity_id not like", value, "activityId");
            return (ShiguActivityApplyExample.Criteria)this;
        }        public ShiguActivityApplyExample.Criteria andActivityIdIn(List<Long> values) {
            this.addCriterion("activity_id in", values, "activityId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andActivityIdNotIn(List<Long> values) {
            this.addCriterion("activity_id not in", values, "activityId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andActivityIdBetween(Long value1, Long value2) {
            this.addCriterion("activity_id between", value1, value2, "activityId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andActivityIdNotBetween(Long value1, Long value2) {
            this.addCriterion("activity_id not between", value1, value2, "activityId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andApplyIdIsNull() {
            this.addCriterion("apply_id is null");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andApplyIdIsNotNull() {
            this.addCriterion("apply_id is not null");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andApplyIdEqualTo(Long value) {
            this.addCriterion("apply_id =", value, "applyId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andApplyIdNotEqualTo(Long value) {
            this.addCriterion("apply_id <>", value, "applyId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andApplyIdGreaterThan(Long value) {
            this.addCriterion("apply_id >", value, "applyId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andApplyIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("apply_id >=", value, "applyId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andApplyIdLessThan(Long value) {
            this.addCriterion("apply_id <", value, "applyId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andApplyIdLessThanOrEqualTo(Long value) {
            this.addCriterion("apply_id <=", value, "applyId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andApplyIdLike(String value) {
            this.addCriterion("apply_id like", value, "applyId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andApplyIdNotLike(String value) {
            this.addCriterion("apply_id not like", value, "applyId");
            return (ShiguActivityApplyExample.Criteria)this;
        }        public ShiguActivityApplyExample.Criteria andApplyIdIn(List<Long> values) {
            this.addCriterion("apply_id in", values, "applyId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andApplyIdNotIn(List<Long> values) {
            this.addCriterion("apply_id not in", values, "applyId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andApplyIdBetween(Long value1, Long value2) {
            this.addCriterion("apply_id between", value1, value2, "applyId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andApplyIdNotBetween(Long value1, Long value2) {
            this.addCriterion("apply_id not between", value1, value2, "applyId");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andChooseIsNull() {
            this.addCriterion("choose is null");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andChooseIsNotNull() {
            this.addCriterion("choose is not null");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andChooseEqualTo(Integer value) {
            this.addCriterion("choose =", value, "choose");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andChooseNotEqualTo(Integer value) {
            this.addCriterion("choose <>", value, "choose");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andChooseGreaterThan(Integer value) {
            this.addCriterion("choose >", value, "choose");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andChooseGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("choose >=", value, "choose");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andChooseLessThan(Integer value) {
            this.addCriterion("choose <", value, "choose");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andChooseLessThanOrEqualTo(Integer value) {
            this.addCriterion("choose <=", value, "choose");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andChooseLike(String value) {
            this.addCriterion("choose like", value, "choose");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andChooseNotLike(String value) {
            this.addCriterion("choose not like", value, "choose");
            return (ShiguActivityApplyExample.Criteria)this;
        }        public ShiguActivityApplyExample.Criteria andChooseIn(List<Integer> values) {
            this.addCriterion("choose in", values, "choose");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andChooseNotIn(List<Integer> values) {
            this.addCriterion("choose not in", values, "choose");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andChooseBetween(Integer value1, Integer value2) {
            this.addCriterion("choose between", value1, value2, "choose");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andChooseNotBetween(Integer value1, Integer value2) {
            this.addCriterion("choose not between", value1, value2, "choose");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andItemsIsNull() {
            this.addCriterion("items is null");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andItemsIsNotNull() {
            this.addCriterion("items is not null");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andItemsEqualTo(String value) {
            this.addCriterion("items =", value, "items");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andItemsNotEqualTo(String value) {
            this.addCriterion("items <>", value, "items");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andItemsGreaterThan(String value) {
            this.addCriterion("items >", value, "items");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andItemsGreaterThanOrEqualTo(String value) {
            this.addCriterion("items >=", value, "items");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andItemsLessThan(String value) {
            this.addCriterion("items <", value, "items");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andItemsLessThanOrEqualTo(String value) {
            this.addCriterion("items <=", value, "items");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andItemsLike(String value) {
            this.addCriterion("items like", value, "items");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andItemsNotLike(String value) {
            this.addCriterion("items not like", value, "items");
            return (ShiguActivityApplyExample.Criteria)this;
        }        public ShiguActivityApplyExample.Criteria andItemsIn(List<String> values) {
            this.addCriterion("items in", values, "items");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andItemsNotIn(List<String> values) {
            this.addCriterion("items not in", values, "items");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andItemsBetween(String value1, String value2) {
            this.addCriterion("items between", value1, value2, "items");
            return (ShiguActivityApplyExample.Criteria)this;
        }

        public ShiguActivityApplyExample.Criteria andItemsNotBetween(String value1, String value2) {
            this.addCriterion("items not between", value1, value2, "items");
            return (ShiguActivityApplyExample.Criteria)this;
        }
    }
}
