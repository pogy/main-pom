package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShiguUserLastloginshopExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguUserLastloginshopExample.Criteria> oredCriteria = new ArrayList();

    public ShiguUserLastloginshopExample() {
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

    public List<ShiguUserLastloginshopExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguUserLastloginshopExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguUserLastloginshopExample.Criteria or() {
        ShiguUserLastloginshopExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguUserLastloginshopExample.Criteria createCriteria() {
        ShiguUserLastloginshopExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguUserLastloginshopExample.Criteria createCriteriaInternal() {
        ShiguUserLastloginshopExample.Criteria criteria = new ShiguUserLastloginshopExample.Criteria();
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

    public static class Criteria extends ShiguUserLastloginshopExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguUserLastloginshopExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguUserLastloginshopExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguUserLastloginshopExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguUserLastloginshopExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguUserLastloginshopExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguUserLastloginshopExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguUserLastloginshopExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }        public ShiguUserLastloginshopExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdIsNull() {
            this.addCriterion("shop_id is null");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdIsNotNull() {
            this.addCriterion("shop_id is not null");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdEqualTo(Long value) {
            this.addCriterion("shop_id =", value, "shopId");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdNotEqualTo(Long value) {
            this.addCriterion("shop_id <>", value, "shopId");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdGreaterThan(Long value) {
            this.addCriterion("shop_id >", value, "shopId");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("shop_id >=", value, "shopId");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdLessThan(Long value) {
            this.addCriterion("shop_id <", value, "shopId");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            this.addCriterion("shop_id <=", value, "shopId");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdLike(String value) {
            this.addCriterion("shop_id like", value, "shopId");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdNotLike(String value) {
            this.addCriterion("shop_id not like", value, "shopId");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }        public ShiguUserLastloginshopExample.Criteria andShopIdIn(List<Long> values) {
            this.addCriterion("shop_id in", values, "shopId");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdNotIn(List<Long> values) {
            this.addCriterion("shop_id not in", values, "shopId");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdBetween(Long value1, Long value2) {
            this.addCriterion("shop_id between", value1, value2, "shopId");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            this.addCriterion("shop_id not between", value1, value2, "shopId");
            return (ShiguUserLastloginshopExample.Criteria)this;
        }
    }
}
