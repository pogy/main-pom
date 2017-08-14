package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShiguMarketExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguMarketExample.Criteria> oredCriteria = new ArrayList();

    public ShiguMarketExample() {
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

    public List<ShiguMarketExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguMarketExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguMarketExample.Criteria or() {
        ShiguMarketExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguMarketExample.Criteria createCriteria() {
        ShiguMarketExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguMarketExample.Criteria createCriteriaInternal() {
        ShiguMarketExample.Criteria criteria = new ShiguMarketExample.Criteria();
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

    public static class Criteria extends ShiguMarketExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguMarketExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguMarketExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguMarketExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguMarketExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguMarketExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguMarketExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguMarketExample.Criteria andMarketIdIsNull() {
            this.addCriterion("market_id is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketIdIsNotNull() {
            this.addCriterion("market_id is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketIdEqualTo(Long value) {
            this.addCriterion("market_id =", value, "marketId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketIdNotEqualTo(Long value) {
            this.addCriterion("market_id <>", value, "marketId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketIdGreaterThan(Long value) {
            this.addCriterion("market_id >", value, "marketId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("market_id >=", value, "marketId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketIdLessThan(Long value) {
            this.addCriterion("market_id <", value, "marketId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            this.addCriterion("market_id <=", value, "marketId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketIdLike(String value) {
            this.addCriterion("market_id like", value, "marketId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketIdNotLike(String value) {
            this.addCriterion("market_id not like", value, "marketId");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andMarketIdIn(List<Long> values) {
            this.addCriterion("market_id in", values, "marketId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketIdNotIn(List<Long> values) {
            this.addCriterion("market_id not in", values, "marketId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            this.addCriterion("market_id between", value1, value2, "marketId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            this.addCriterion("market_id not between", value1, value2, "marketId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketNameIsNull() {
            this.addCriterion("market_name is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketNameIsNotNull() {
            this.addCriterion("market_name is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketNameEqualTo(String value) {
            this.addCriterion("market_name =", value, "marketName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketNameNotEqualTo(String value) {
            this.addCriterion("market_name <>", value, "marketName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketNameGreaterThan(String value) {
            this.addCriterion("market_name >", value, "marketName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("market_name >=", value, "marketName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketNameLessThan(String value) {
            this.addCriterion("market_name <", value, "marketName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketNameLessThanOrEqualTo(String value) {
            this.addCriterion("market_name <=", value, "marketName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketNameLike(String value) {
            this.addCriterion("market_name like", value, "marketName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketNameNotLike(String value) {
            this.addCriterion("market_name not like", value, "marketName");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andMarketNameIn(List<String> values) {
            this.addCriterion("market_name in", values, "marketName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketNameNotIn(List<String> values) {
            this.addCriterion("market_name not in", values, "marketName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketNameBetween(String value1, String value2) {
            this.addCriterion("market_name between", value1, value2, "marketName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketNameNotBetween(String value1, String value2) {
            this.addCriterion("market_name not between", value1, value2, "marketName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketIdIsNull() {
            this.addCriterion("parent_market_id is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketIdIsNotNull() {
            this.addCriterion("parent_market_id is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketIdEqualTo(Long value) {
            this.addCriterion("parent_market_id =", value, "parentMarketId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketIdNotEqualTo(Long value) {
            this.addCriterion("parent_market_id <>", value, "parentMarketId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketIdGreaterThan(Long value) {
            this.addCriterion("parent_market_id >", value, "parentMarketId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("parent_market_id >=", value, "parentMarketId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketIdLessThan(Long value) {
            this.addCriterion("parent_market_id <", value, "parentMarketId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketIdLessThanOrEqualTo(Long value) {
            this.addCriterion("parent_market_id <=", value, "parentMarketId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketIdLike(String value) {
            this.addCriterion("parent_market_id like", value, "parentMarketId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketIdNotLike(String value) {
            this.addCriterion("parent_market_id not like", value, "parentMarketId");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andParentMarketIdIn(List<Long> values) {
            this.addCriterion("parent_market_id in", values, "parentMarketId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketIdNotIn(List<Long> values) {
            this.addCriterion("parent_market_id not in", values, "parentMarketId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketIdBetween(Long value1, Long value2) {
            this.addCriterion("parent_market_id between", value1, value2, "parentMarketId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketIdNotBetween(Long value1, Long value2) {
            this.addCriterion("parent_market_id not between", value1, value2, "parentMarketId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketNameIsNull() {
            this.addCriterion("parent_market_name is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketNameIsNotNull() {
            this.addCriterion("parent_market_name is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketNameEqualTo(String value) {
            this.addCriterion("parent_market_name =", value, "parentMarketName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketNameNotEqualTo(String value) {
            this.addCriterion("parent_market_name <>", value, "parentMarketName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketNameGreaterThan(String value) {
            this.addCriterion("parent_market_name >", value, "parentMarketName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("parent_market_name >=", value, "parentMarketName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketNameLessThan(String value) {
            this.addCriterion("parent_market_name <", value, "parentMarketName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketNameLessThanOrEqualTo(String value) {
            this.addCriterion("parent_market_name <=", value, "parentMarketName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketNameLike(String value) {
            this.addCriterion("parent_market_name like", value, "parentMarketName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketNameNotLike(String value) {
            this.addCriterion("parent_market_name not like", value, "parentMarketName");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andParentMarketNameIn(List<String> values) {
            this.addCriterion("parent_market_name in", values, "parentMarketName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketNameNotIn(List<String> values) {
            this.addCriterion("parent_market_name not in", values, "parentMarketName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketNameBetween(String value1, String value2) {
            this.addCriterion("parent_market_name between", value1, value2, "parentMarketName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andParentMarketNameNotBetween(String value1, String value2) {
            this.addCriterion("parent_market_name not between", value1, value2, "parentMarketName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andIsParentIsNull() {
            this.addCriterion("is_parent is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andIsParentIsNotNull() {
            this.addCriterion("is_parent is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andIsParentEqualTo(Long value) {
            this.addCriterion("is_parent =", value, "isParent");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andIsParentNotEqualTo(Long value) {
            this.addCriterion("is_parent <>", value, "isParent");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andIsParentGreaterThan(Long value) {
            this.addCriterion("is_parent >", value, "isParent");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andIsParentGreaterThanOrEqualTo(Long value) {
            this.addCriterion("is_parent >=", value, "isParent");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andIsParentLessThan(Long value) {
            this.addCriterion("is_parent <", value, "isParent");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andIsParentLessThanOrEqualTo(Long value) {
            this.addCriterion("is_parent <=", value, "isParent");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andIsParentLike(String value) {
            this.addCriterion("is_parent like", value, "isParent");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andIsParentNotLike(String value) {
            this.addCriterion("is_parent not like", value, "isParent");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andIsParentIn(List<Long> values) {
            this.addCriterion("is_parent in", values, "isParent");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andIsParentNotIn(List<Long> values) {
            this.addCriterion("is_parent not in", values, "isParent");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andIsParentBetween(Long value1, Long value2) {
            this.addCriterion("is_parent between", value1, value2, "isParent");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andIsParentNotBetween(Long value1, Long value2) {
            this.addCriterion("is_parent not between", value1, value2, "isParent");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andBuycityIdIsNull() {
            this.addCriterion("buycity_id is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andBuycityIdIsNotNull() {
            this.addCriterion("buycity_id is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andBuycityIdEqualTo(Long value) {
            this.addCriterion("buycity_id =", value, "buycityId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andBuycityIdNotEqualTo(Long value) {
            this.addCriterion("buycity_id <>", value, "buycityId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andBuycityIdGreaterThan(Long value) {
            this.addCriterion("buycity_id >", value, "buycityId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andBuycityIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("buycity_id >=", value, "buycityId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andBuycityIdLessThan(Long value) {
            this.addCriterion("buycity_id <", value, "buycityId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andBuycityIdLessThanOrEqualTo(Long value) {
            this.addCriterion("buycity_id <=", value, "buycityId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andBuycityIdLike(String value) {
            this.addCriterion("buycity_id like", value, "buycityId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andBuycityIdNotLike(String value) {
            this.addCriterion("buycity_id not like", value, "buycityId");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andBuycityIdIn(List<Long> values) {
            this.addCriterion("buycity_id in", values, "buycityId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andBuycityIdNotIn(List<Long> values) {
            this.addCriterion("buycity_id not in", values, "buycityId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andBuycityIdBetween(Long value1, Long value2) {
            this.addCriterion("buycity_id between", value1, value2, "buycityId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andBuycityIdNotBetween(Long value1, Long value2) {
            this.addCriterion("buycity_id not between", value1, value2, "buycityId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceIdIsNull() {
            this.addCriterion("province_id is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceIdIsNotNull() {
            this.addCriterion("province_id is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceIdEqualTo(Long value) {
            this.addCriterion("province_id =", value, "provinceId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceIdNotEqualTo(Long value) {
            this.addCriterion("province_id <>", value, "provinceId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceIdGreaterThan(Long value) {
            this.addCriterion("province_id >", value, "provinceId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("province_id >=", value, "provinceId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceIdLessThan(Long value) {
            this.addCriterion("province_id <", value, "provinceId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceIdLessThanOrEqualTo(Long value) {
            this.addCriterion("province_id <=", value, "provinceId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceIdLike(String value) {
            this.addCriterion("province_id like", value, "provinceId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceIdNotLike(String value) {
            this.addCriterion("province_id not like", value, "provinceId");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andProvinceIdIn(List<Long> values) {
            this.addCriterion("province_id in", values, "provinceId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceIdNotIn(List<Long> values) {
            this.addCriterion("province_id not in", values, "provinceId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceIdBetween(Long value1, Long value2) {
            this.addCriterion("province_id between", value1, value2, "provinceId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceIdNotBetween(Long value1, Long value2) {
            this.addCriterion("province_id not between", value1, value2, "provinceId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceNameIsNull() {
            this.addCriterion("province_name is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceNameIsNotNull() {
            this.addCriterion("province_name is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceNameEqualTo(String value) {
            this.addCriterion("province_name =", value, "provinceName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceNameNotEqualTo(String value) {
            this.addCriterion("province_name <>", value, "provinceName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceNameGreaterThan(String value) {
            this.addCriterion("province_name >", value, "provinceName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("province_name >=", value, "provinceName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceNameLessThan(String value) {
            this.addCriterion("province_name <", value, "provinceName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceNameLessThanOrEqualTo(String value) {
            this.addCriterion("province_name <=", value, "provinceName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceNameLike(String value) {
            this.addCriterion("province_name like", value, "provinceName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceNameNotLike(String value) {
            this.addCriterion("province_name not like", value, "provinceName");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andProvinceNameIn(List<String> values) {
            this.addCriterion("province_name in", values, "provinceName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceNameNotIn(List<String> values) {
            this.addCriterion("province_name not in", values, "provinceName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceNameBetween(String value1, String value2) {
            this.addCriterion("province_name between", value1, value2, "provinceName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andProvinceNameNotBetween(String value1, String value2) {
            this.addCriterion("province_name not between", value1, value2, "provinceName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityIdIsNull() {
            this.addCriterion("city_id is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityIdIsNotNull() {
            this.addCriterion("city_id is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityIdEqualTo(Long value) {
            this.addCriterion("city_id =", value, "cityId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityIdNotEqualTo(Long value) {
            this.addCriterion("city_id <>", value, "cityId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityIdGreaterThan(Long value) {
            this.addCriterion("city_id >", value, "cityId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("city_id >=", value, "cityId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityIdLessThan(Long value) {
            this.addCriterion("city_id <", value, "cityId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityIdLessThanOrEqualTo(Long value) {
            this.addCriterion("city_id <=", value, "cityId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityIdLike(String value) {
            this.addCriterion("city_id like", value, "cityId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityIdNotLike(String value) {
            this.addCriterion("city_id not like", value, "cityId");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andCityIdIn(List<Long> values) {
            this.addCriterion("city_id in", values, "cityId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityIdNotIn(List<Long> values) {
            this.addCriterion("city_id not in", values, "cityId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityIdBetween(Long value1, Long value2) {
            this.addCriterion("city_id between", value1, value2, "cityId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityIdNotBetween(Long value1, Long value2) {
            this.addCriterion("city_id not between", value1, value2, "cityId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityNameIsNull() {
            this.addCriterion("city_name is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityNameIsNotNull() {
            this.addCriterion("city_name is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityNameEqualTo(String value) {
            this.addCriterion("city_name =", value, "cityName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityNameNotEqualTo(String value) {
            this.addCriterion("city_name <>", value, "cityName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityNameGreaterThan(String value) {
            this.addCriterion("city_name >", value, "cityName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("city_name >=", value, "cityName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityNameLessThan(String value) {
            this.addCriterion("city_name <", value, "cityName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityNameLessThanOrEqualTo(String value) {
            this.addCriterion("city_name <=", value, "cityName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityNameLike(String value) {
            this.addCriterion("city_name like", value, "cityName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityNameNotLike(String value) {
            this.addCriterion("city_name not like", value, "cityName");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andCityNameIn(List<String> values) {
            this.addCriterion("city_name in", values, "cityName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityNameNotIn(List<String> values) {
            this.addCriterion("city_name not in", values, "cityName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityNameBetween(String value1, String value2) {
            this.addCriterion("city_name between", value1, value2, "cityName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCityNameNotBetween(String value1, String value2) {
            this.addCriterion("city_name not between", value1, value2, "cityName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketAddrIsNull() {
            this.addCriterion("market_addr is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketAddrIsNotNull() {
            this.addCriterion("market_addr is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketAddrEqualTo(String value) {
            this.addCriterion("market_addr =", value, "marketAddr");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketAddrNotEqualTo(String value) {
            this.addCriterion("market_addr <>", value, "marketAddr");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketAddrGreaterThan(String value) {
            this.addCriterion("market_addr >", value, "marketAddr");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketAddrGreaterThanOrEqualTo(String value) {
            this.addCriterion("market_addr >=", value, "marketAddr");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketAddrLessThan(String value) {
            this.addCriterion("market_addr <", value, "marketAddr");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketAddrLessThanOrEqualTo(String value) {
            this.addCriterion("market_addr <=", value, "marketAddr");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketAddrLike(String value) {
            this.addCriterion("market_addr like", value, "marketAddr");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketAddrNotLike(String value) {
            this.addCriterion("market_addr not like", value, "marketAddr");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andMarketAddrIn(List<String> values) {
            this.addCriterion("market_addr in", values, "marketAddr");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketAddrNotIn(List<String> values) {
            this.addCriterion("market_addr not in", values, "marketAddr");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketAddrBetween(String value1, String value2) {
            this.addCriterion("market_addr between", value1, value2, "marketAddr");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketAddrNotBetween(String value1, String value2) {
            this.addCriterion("market_addr not between", value1, value2, "marketAddr");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andSortOrderIsNull() {
            this.addCriterion("sort_order is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andSortOrderIsNotNull() {
            this.addCriterion("sort_order is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andSortOrderEqualTo(Long value) {
            this.addCriterion("sort_order =", value, "sortOrder");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andSortOrderNotEqualTo(Long value) {
            this.addCriterion("sort_order <>", value, "sortOrder");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andSortOrderGreaterThan(Long value) {
            this.addCriterion("sort_order >", value, "sortOrder");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andSortOrderGreaterThanOrEqualTo(Long value) {
            this.addCriterion("sort_order >=", value, "sortOrder");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andSortOrderLessThan(Long value) {
            this.addCriterion("sort_order <", value, "sortOrder");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andSortOrderLessThanOrEqualTo(Long value) {
            this.addCriterion("sort_order <=", value, "sortOrder");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andSortOrderLike(String value) {
            this.addCriterion("sort_order like", value, "sortOrder");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andSortOrderNotLike(String value) {
            this.addCriterion("sort_order not like", value, "sortOrder");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andSortOrderIn(List<Long> values) {
            this.addCriterion("sort_order in", values, "sortOrder");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andSortOrderNotIn(List<Long> values) {
            this.addCriterion("sort_order not in", values, "sortOrder");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andSortOrderBetween(Long value1, Long value2) {
            this.addCriterion("sort_order between", value1, value2, "sortOrder");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andSortOrderNotBetween(Long value1, Long value2) {
            this.addCriterion("sort_order not between", value1, value2, "sortOrder");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark11IsNull() {
            this.addCriterion("remark11 is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark11IsNotNull() {
            this.addCriterion("remark11 is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark11EqualTo(String value) {
            this.addCriterion("remark11 =", value, "remark11");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark11NotEqualTo(String value) {
            this.addCriterion("remark11 <>", value, "remark11");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark11GreaterThan(String value) {
            this.addCriterion("remark11 >", value, "remark11");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark11GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark11 >=", value, "remark11");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark11LessThan(String value) {
            this.addCriterion("remark11 <", value, "remark11");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark11LessThanOrEqualTo(String value) {
            this.addCriterion("remark11 <=", value, "remark11");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark11Like(String value) {
            this.addCriterion("remark11 like", value, "remark11");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark11NotLike(String value) {
            this.addCriterion("remark11 not like", value, "remark11");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andRemark11In(List<String> values) {
            this.addCriterion("remark11 in", values, "remark11");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark11NotIn(List<String> values) {
            this.addCriterion("remark11 not in", values, "remark11");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark11Between(String value1, String value2) {
            this.addCriterion("remark11 between", value1, value2, "remark11");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark11NotBetween(String value1, String value2) {
            this.addCriterion("remark11 not between", value1, value2, "remark11");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark12IsNull() {
            this.addCriterion("remark12 is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark12IsNotNull() {
            this.addCriterion("remark12 is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark12EqualTo(String value) {
            this.addCriterion("remark12 =", value, "remark12");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark12NotEqualTo(String value) {
            this.addCriterion("remark12 <>", value, "remark12");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark12GreaterThan(String value) {
            this.addCriterion("remark12 >", value, "remark12");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark12GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark12 >=", value, "remark12");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark12LessThan(String value) {
            this.addCriterion("remark12 <", value, "remark12");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark12LessThanOrEqualTo(String value) {
            this.addCriterion("remark12 <=", value, "remark12");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark12Like(String value) {
            this.addCriterion("remark12 like", value, "remark12");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark12NotLike(String value) {
            this.addCriterion("remark12 not like", value, "remark12");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andRemark12In(List<String> values) {
            this.addCriterion("remark12 in", values, "remark12");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark12NotIn(List<String> values) {
            this.addCriterion("remark12 not in", values, "remark12");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark12Between(String value1, String value2) {
            this.addCriterion("remark12 between", value1, value2, "remark12");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark12NotBetween(String value1, String value2) {
            this.addCriterion("remark12 not between", value1, value2, "remark12");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark13IsNull() {
            this.addCriterion("remark13 is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark13IsNotNull() {
            this.addCriterion("remark13 is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark13EqualTo(String value) {
            this.addCriterion("remark13 =", value, "remark13");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark13NotEqualTo(String value) {
            this.addCriterion("remark13 <>", value, "remark13");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark13GreaterThan(String value) {
            this.addCriterion("remark13 >", value, "remark13");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark13GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark13 >=", value, "remark13");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark13LessThan(String value) {
            this.addCriterion("remark13 <", value, "remark13");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark13LessThanOrEqualTo(String value) {
            this.addCriterion("remark13 <=", value, "remark13");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark13Like(String value) {
            this.addCriterion("remark13 like", value, "remark13");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark13NotLike(String value) {
            this.addCriterion("remark13 not like", value, "remark13");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andRemark13In(List<String> values) {
            this.addCriterion("remark13 in", values, "remark13");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark13NotIn(List<String> values) {
            this.addCriterion("remark13 not in", values, "remark13");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark13Between(String value1, String value2) {
            this.addCriterion("remark13 between", value1, value2, "remark13");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark13NotBetween(String value1, String value2) {
            this.addCriterion("remark13 not between", value1, value2, "remark13");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark14IsNull() {
            this.addCriterion("remark14 is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark14IsNotNull() {
            this.addCriterion("remark14 is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark14EqualTo(String value) {
            this.addCriterion("remark14 =", value, "remark14");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark14NotEqualTo(String value) {
            this.addCriterion("remark14 <>", value, "remark14");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark14GreaterThan(String value) {
            this.addCriterion("remark14 >", value, "remark14");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark14GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark14 >=", value, "remark14");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark14LessThan(String value) {
            this.addCriterion("remark14 <", value, "remark14");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark14LessThanOrEqualTo(String value) {
            this.addCriterion("remark14 <=", value, "remark14");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark14Like(String value) {
            this.addCriterion("remark14 like", value, "remark14");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark14NotLike(String value) {
            this.addCriterion("remark14 not like", value, "remark14");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andRemark14In(List<String> values) {
            this.addCriterion("remark14 in", values, "remark14");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark14NotIn(List<String> values) {
            this.addCriterion("remark14 not in", values, "remark14");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark14Between(String value1, String value2) {
            this.addCriterion("remark14 between", value1, value2, "remark14");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark14NotBetween(String value1, String value2) {
            this.addCriterion("remark14 not between", value1, value2, "remark14");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark15IsNull() {
            this.addCriterion("remark15 is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark15IsNotNull() {
            this.addCriterion("remark15 is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark15EqualTo(String value) {
            this.addCriterion("remark15 =", value, "remark15");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark15NotEqualTo(String value) {
            this.addCriterion("remark15 <>", value, "remark15");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark15GreaterThan(String value) {
            this.addCriterion("remark15 >", value, "remark15");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark15GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark15 >=", value, "remark15");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark15LessThan(String value) {
            this.addCriterion("remark15 <", value, "remark15");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark15LessThanOrEqualTo(String value) {
            this.addCriterion("remark15 <=", value, "remark15");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark15Like(String value) {
            this.addCriterion("remark15 like", value, "remark15");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark15NotLike(String value) {
            this.addCriterion("remark15 not like", value, "remark15");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andRemark15In(List<String> values) {
            this.addCriterion("remark15 in", values, "remark15");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark15NotIn(List<String> values) {
            this.addCriterion("remark15 not in", values, "remark15");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark15Between(String value1, String value2) {
            this.addCriterion("remark15 between", value1, value2, "remark15");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark15NotBetween(String value1, String value2) {
            this.addCriterion("remark15 not between", value1, value2, "remark15");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark16IsNull() {
            this.addCriterion("remark16 is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark16IsNotNull() {
            this.addCriterion("remark16 is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark16EqualTo(String value) {
            this.addCriterion("remark16 =", value, "remark16");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark16NotEqualTo(String value) {
            this.addCriterion("remark16 <>", value, "remark16");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark16GreaterThan(String value) {
            this.addCriterion("remark16 >", value, "remark16");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark16GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark16 >=", value, "remark16");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark16LessThan(String value) {
            this.addCriterion("remark16 <", value, "remark16");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark16LessThanOrEqualTo(String value) {
            this.addCriterion("remark16 <=", value, "remark16");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark16Like(String value) {
            this.addCriterion("remark16 like", value, "remark16");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark16NotLike(String value) {
            this.addCriterion("remark16 not like", value, "remark16");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andRemark16In(List<String> values) {
            this.addCriterion("remark16 in", values, "remark16");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark16NotIn(List<String> values) {
            this.addCriterion("remark16 not in", values, "remark16");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark16Between(String value1, String value2) {
            this.addCriterion("remark16 between", value1, value2, "remark16");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark16NotBetween(String value1, String value2) {
            this.addCriterion("remark16 not between", value1, value2, "remark16");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark17IsNull() {
            this.addCriterion("remark17 is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark17IsNotNull() {
            this.addCriterion("remark17 is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark17EqualTo(String value) {
            this.addCriterion("remark17 =", value, "remark17");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark17NotEqualTo(String value) {
            this.addCriterion("remark17 <>", value, "remark17");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark17GreaterThan(String value) {
            this.addCriterion("remark17 >", value, "remark17");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark17GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark17 >=", value, "remark17");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark17LessThan(String value) {
            this.addCriterion("remark17 <", value, "remark17");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark17LessThanOrEqualTo(String value) {
            this.addCriterion("remark17 <=", value, "remark17");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark17Like(String value) {
            this.addCriterion("remark17 like", value, "remark17");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark17NotLike(String value) {
            this.addCriterion("remark17 not like", value, "remark17");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andRemark17In(List<String> values) {
            this.addCriterion("remark17 in", values, "remark17");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark17NotIn(List<String> values) {
            this.addCriterion("remark17 not in", values, "remark17");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark17Between(String value1, String value2) {
            this.addCriterion("remark17 between", value1, value2, "remark17");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark17NotBetween(String value1, String value2) {
            this.addCriterion("remark17 not between", value1, value2, "remark17");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark18IsNull() {
            this.addCriterion("remark18 is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark18IsNotNull() {
            this.addCriterion("remark18 is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark18EqualTo(String value) {
            this.addCriterion("remark18 =", value, "remark18");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark18NotEqualTo(String value) {
            this.addCriterion("remark18 <>", value, "remark18");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark18GreaterThan(String value) {
            this.addCriterion("remark18 >", value, "remark18");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark18GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark18 >=", value, "remark18");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark18LessThan(String value) {
            this.addCriterion("remark18 <", value, "remark18");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark18LessThanOrEqualTo(String value) {
            this.addCriterion("remark18 <=", value, "remark18");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark18Like(String value) {
            this.addCriterion("remark18 like", value, "remark18");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark18NotLike(String value) {
            this.addCriterion("remark18 not like", value, "remark18");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andRemark18In(List<String> values) {
            this.addCriterion("remark18 in", values, "remark18");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark18NotIn(List<String> values) {
            this.addCriterion("remark18 not in", values, "remark18");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark18Between(String value1, String value2) {
            this.addCriterion("remark18 between", value1, value2, "remark18");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark18NotBetween(String value1, String value2) {
            this.addCriterion("remark18 not between", value1, value2, "remark18");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark19IsNull() {
            this.addCriterion("remark19 is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark19IsNotNull() {
            this.addCriterion("remark19 is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark19EqualTo(String value) {
            this.addCriterion("remark19 =", value, "remark19");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark19NotEqualTo(String value) {
            this.addCriterion("remark19 <>", value, "remark19");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark19GreaterThan(String value) {
            this.addCriterion("remark19 >", value, "remark19");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark19GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark19 >=", value, "remark19");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark19LessThan(String value) {
            this.addCriterion("remark19 <", value, "remark19");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark19LessThanOrEqualTo(String value) {
            this.addCriterion("remark19 <=", value, "remark19");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark19Like(String value) {
            this.addCriterion("remark19 like", value, "remark19");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark19NotLike(String value) {
            this.addCriterion("remark19 not like", value, "remark19");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andRemark19In(List<String> values) {
            this.addCriterion("remark19 in", values, "remark19");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark19NotIn(List<String> values) {
            this.addCriterion("remark19 not in", values, "remark19");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark19Between(String value1, String value2) {
            this.addCriterion("remark19 between", value1, value2, "remark19");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark19NotBetween(String value1, String value2) {
            this.addCriterion("remark19 not between", value1, value2, "remark19");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark20IsNull() {
            this.addCriterion("remark20 is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark20IsNotNull() {
            this.addCriterion("remark20 is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark20EqualTo(String value) {
            this.addCriterion("remark20 =", value, "remark20");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark20NotEqualTo(String value) {
            this.addCriterion("remark20 <>", value, "remark20");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark20GreaterThan(String value) {
            this.addCriterion("remark20 >", value, "remark20");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark20GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark20 >=", value, "remark20");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark20LessThan(String value) {
            this.addCriterion("remark20 <", value, "remark20");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark20LessThanOrEqualTo(String value) {
            this.addCriterion("remark20 <=", value, "remark20");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark20Like(String value) {
            this.addCriterion("remark20 like", value, "remark20");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark20NotLike(String value) {
            this.addCriterion("remark20 not like", value, "remark20");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andRemark20In(List<String> values) {
            this.addCriterion("remark20 in", values, "remark20");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark20NotIn(List<String> values) {
            this.addCriterion("remark20 not in", values, "remark20");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark20Between(String value1, String value2) {
            this.addCriterion("remark20 between", value1, value2, "remark20");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andRemark20NotBetween(String value1, String value2) {
            this.addCriterion("remark20 not between", value1, value2, "remark20");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaIdIsNull() {
            this.addCriterion("area_id is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaIdIsNotNull() {
            this.addCriterion("area_id is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaIdEqualTo(Long value) {
            this.addCriterion("area_id =", value, "areaId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaIdNotEqualTo(Long value) {
            this.addCriterion("area_id <>", value, "areaId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaIdGreaterThan(Long value) {
            this.addCriterion("area_id >", value, "areaId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("area_id >=", value, "areaId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaIdLessThan(Long value) {
            this.addCriterion("area_id <", value, "areaId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaIdLessThanOrEqualTo(Long value) {
            this.addCriterion("area_id <=", value, "areaId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaIdLike(String value) {
            this.addCriterion("area_id like", value, "areaId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaIdNotLike(String value) {
            this.addCriterion("area_id not like", value, "areaId");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andAreaIdIn(List<Long> values) {
            this.addCriterion("area_id in", values, "areaId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaIdNotIn(List<Long> values) {
            this.addCriterion("area_id not in", values, "areaId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaIdBetween(Long value1, Long value2) {
            this.addCriterion("area_id between", value1, value2, "areaId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaIdNotBetween(Long value1, Long value2) {
            this.addCriterion("area_id not between", value1, value2, "areaId");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaNameIsNull() {
            this.addCriterion("area_name is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaNameIsNotNull() {
            this.addCriterion("area_name is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaNameEqualTo(String value) {
            this.addCriterion("area_name =", value, "areaName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaNameNotEqualTo(String value) {
            this.addCriterion("area_name <>", value, "areaName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaNameGreaterThan(String value) {
            this.addCriterion("area_name >", value, "areaName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("area_name >=", value, "areaName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaNameLessThan(String value) {
            this.addCriterion("area_name <", value, "areaName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaNameLessThanOrEqualTo(String value) {
            this.addCriterion("area_name <=", value, "areaName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaNameLike(String value) {
            this.addCriterion("area_name like", value, "areaName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaNameNotLike(String value) {
            this.addCriterion("area_name not like", value, "areaName");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andAreaNameIn(List<String> values) {
            this.addCriterion("area_name in", values, "areaName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaNameNotIn(List<String> values) {
            this.addCriterion("area_name not in", values, "areaName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaNameBetween(String value1, String value2) {
            this.addCriterion("area_name between", value1, value2, "areaName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andAreaNameNotBetween(String value1, String value2) {
            this.addCriterion("area_name not between", value1, value2, "areaName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketFullNameIsNull() {
            this.addCriterion("market_full_name is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketFullNameIsNotNull() {
            this.addCriterion("market_full_name is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketFullNameEqualTo(String value) {
            this.addCriterion("market_full_name =", value, "marketFullName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketFullNameNotEqualTo(String value) {
            this.addCriterion("market_full_name <>", value, "marketFullName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketFullNameGreaterThan(String value) {
            this.addCriterion("market_full_name >", value, "marketFullName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketFullNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("market_full_name >=", value, "marketFullName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketFullNameLessThan(String value) {
            this.addCriterion("market_full_name <", value, "marketFullName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketFullNameLessThanOrEqualTo(String value) {
            this.addCriterion("market_full_name <=", value, "marketFullName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketFullNameLike(String value) {
            this.addCriterion("market_full_name like", value, "marketFullName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketFullNameNotLike(String value) {
            this.addCriterion("market_full_name not like", value, "marketFullName");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andMarketFullNameIn(List<String> values) {
            this.addCriterion("market_full_name in", values, "marketFullName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketFullNameNotIn(List<String> values) {
            this.addCriterion("market_full_name not in", values, "marketFullName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketFullNameBetween(String value1, String value2) {
            this.addCriterion("market_full_name between", value1, value2, "marketFullName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketFullNameNotBetween(String value1, String value2) {
            this.addCriterion("market_full_name not between", value1, value2, "marketFullName");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andNatureIsNull() {
            this.addCriterion("nature is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andNatureIsNotNull() {
            this.addCriterion("nature is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andNatureEqualTo(String value) {
            this.addCriterion("nature =", value, "nature");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andNatureNotEqualTo(String value) {
            this.addCriterion("nature <>", value, "nature");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andNatureGreaterThan(String value) {
            this.addCriterion("nature >", value, "nature");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andNatureGreaterThanOrEqualTo(String value) {
            this.addCriterion("nature >=", value, "nature");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andNatureLessThan(String value) {
            this.addCriterion("nature <", value, "nature");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andNatureLessThanOrEqualTo(String value) {
            this.addCriterion("nature <=", value, "nature");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andNatureLike(String value) {
            this.addCriterion("nature like", value, "nature");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andNatureNotLike(String value) {
            this.addCriterion("nature not like", value, "nature");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andNatureIn(List<String> values) {
            this.addCriterion("nature in", values, "nature");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andNatureNotIn(List<String> values) {
            this.addCriterion("nature not in", values, "nature");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andNatureBetween(String value1, String value2) {
            this.addCriterion("nature between", value1, value2, "nature");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andNatureNotBetween(String value1, String value2) {
            this.addCriterion("nature not between", value1, value2, "nature");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andFloorsIsNull() {
            this.addCriterion("floors is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andFloorsIsNotNull() {
            this.addCriterion("floors is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andFloorsEqualTo(String value) {
            this.addCriterion("floors =", value, "floors");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andFloorsNotEqualTo(String value) {
            this.addCriterion("floors <>", value, "floors");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andFloorsGreaterThan(String value) {
            this.addCriterion("floors >", value, "floors");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andFloorsGreaterThanOrEqualTo(String value) {
            this.addCriterion("floors >=", value, "floors");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andFloorsLessThan(String value) {
            this.addCriterion("floors <", value, "floors");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andFloorsLessThanOrEqualTo(String value) {
            this.addCriterion("floors <=", value, "floors");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andFloorsLike(String value) {
            this.addCriterion("floors like", value, "floors");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andFloorsNotLike(String value) {
            this.addCriterion("floors not like", value, "floors");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andFloorsIn(List<String> values) {
            this.addCriterion("floors in", values, "floors");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andFloorsNotIn(List<String> values) {
            this.addCriterion("floors not in", values, "floors");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andFloorsBetween(String value1, String value2) {
            this.addCriterion("floors between", value1, value2, "floors");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andFloorsNotBetween(String value1, String value2) {
            this.addCriterion("floors not between", value1, value2, "floors");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andStoreInTotalIsNull() {
            this.addCriterion("store_in_total is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andStoreInTotalIsNotNull() {
            this.addCriterion("store_in_total is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andStoreInTotalEqualTo(Integer value) {
            this.addCriterion("store_in_total =", value, "storeInTotal");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andStoreInTotalNotEqualTo(Integer value) {
            this.addCriterion("store_in_total <>", value, "storeInTotal");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andStoreInTotalGreaterThan(Integer value) {
            this.addCriterion("store_in_total >", value, "storeInTotal");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andStoreInTotalGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("store_in_total >=", value, "storeInTotal");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andStoreInTotalLessThan(Integer value) {
            this.addCriterion("store_in_total <", value, "storeInTotal");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andStoreInTotalLessThanOrEqualTo(Integer value) {
            this.addCriterion("store_in_total <=", value, "storeInTotal");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andStoreInTotalLike(String value) {
            this.addCriterion("store_in_total like", value, "storeInTotal");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andStoreInTotalNotLike(String value) {
            this.addCriterion("store_in_total not like", value, "storeInTotal");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andStoreInTotalIn(List<Integer> values) {
            this.addCriterion("store_in_total in", values, "storeInTotal");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andStoreInTotalNotIn(List<Integer> values) {
            this.addCriterion("store_in_total not in", values, "storeInTotal");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andStoreInTotalBetween(Integer value1, Integer value2) {
            this.addCriterion("store_in_total between", value1, value2, "storeInTotal");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andStoreInTotalNotBetween(Integer value1, Integer value2) {
            this.addCriterion("store_in_total not between", value1, value2, "storeInTotal");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketPingyinIsNull() {
            this.addCriterion("market_pingyin is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketPingyinIsNotNull() {
            this.addCriterion("market_pingyin is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketPingyinEqualTo(String value) {
            this.addCriterion("market_pingyin =", value, "marketPingyin");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketPingyinNotEqualTo(String value) {
            this.addCriterion("market_pingyin <>", value, "marketPingyin");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketPingyinGreaterThan(String value) {
            this.addCriterion("market_pingyin >", value, "marketPingyin");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketPingyinGreaterThanOrEqualTo(String value) {
            this.addCriterion("market_pingyin >=", value, "marketPingyin");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketPingyinLessThan(String value) {
            this.addCriterion("market_pingyin <", value, "marketPingyin");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketPingyinLessThanOrEqualTo(String value) {
            this.addCriterion("market_pingyin <=", value, "marketPingyin");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketPingyinLike(String value) {
            this.addCriterion("market_pingyin like", value, "marketPingyin");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketPingyinNotLike(String value) {
            this.addCriterion("market_pingyin not like", value, "marketPingyin");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andMarketPingyinIn(List<String> values) {
            this.addCriterion("market_pingyin in", values, "marketPingyin");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketPingyinNotIn(List<String> values) {
            this.addCriterion("market_pingyin not in", values, "marketPingyin");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketPingyinBetween(String value1, String value2) {
            this.addCriterion("market_pingyin between", value1, value2, "marketPingyin");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andMarketPingyinNotBetween(String value1, String value2) {
            this.addCriterion("market_pingyin not between", value1, value2, "marketPingyin");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCanRegistIsNull() {
            this.addCriterion("can_regist is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCanRegistIsNotNull() {
            this.addCriterion("can_regist is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCanRegistEqualTo(Integer value) {
            this.addCriterion("can_regist =", value, "canRegist");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCanRegistNotEqualTo(Integer value) {
            this.addCriterion("can_regist <>", value, "canRegist");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCanRegistGreaterThan(Integer value) {
            this.addCriterion("can_regist >", value, "canRegist");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCanRegistGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("can_regist >=", value, "canRegist");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCanRegistLessThan(Integer value) {
            this.addCriterion("can_regist <", value, "canRegist");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCanRegistLessThanOrEqualTo(Integer value) {
            this.addCriterion("can_regist <=", value, "canRegist");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCanRegistLike(String value) {
            this.addCriterion("can_regist like", value, "canRegist");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCanRegistNotLike(String value) {
            this.addCriterion("can_regist not like", value, "canRegist");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andCanRegistIn(List<Integer> values) {
            this.addCriterion("can_regist in", values, "canRegist");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCanRegistNotIn(List<Integer> values) {
            this.addCriterion("can_regist not in", values, "canRegist");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCanRegistBetween(Integer value1, Integer value2) {
            this.addCriterion("can_regist between", value1, value2, "canRegist");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andCanRegistNotBetween(Integer value1, Integer value2) {
            this.addCriterion("can_regist not between", value1, value2, "canRegist");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andWebSiteIsNull() {
            this.addCriterion("web_site is null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andWebSiteIsNotNull() {
            this.addCriterion("web_site is not null");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("web_site =", value, "webSite");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("web_site <>", value, "webSite");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("web_site >", value, "webSite");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("web_site >=", value, "webSite");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andWebSiteLessThan(String value) {
            this.addCriterion("web_site <", value, "webSite");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("web_site <=", value, "webSite");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andWebSiteLike(String value) {
            this.addCriterion("web_site like", value, "webSite");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andWebSiteNotLike(String value) {
            this.addCriterion("web_site not like", value, "webSite");
            return (ShiguMarketExample.Criteria)this;
        }        public ShiguMarketExample.Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("web_site in", values, "webSite");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("web_site not in", values, "webSite");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("web_site between", value1, value2, "webSite");
            return (ShiguMarketExample.Criteria)this;
        }

        public ShiguMarketExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("web_site not between", value1, value2, "webSite");
            return (ShiguMarketExample.Criteria)this;
        }
    }
}
