package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class BuyerAddressExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<BuyerAddressExample.Criteria> oredCriteria = new ArrayList();

    public BuyerAddressExample() {
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

    public List<BuyerAddressExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(BuyerAddressExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public BuyerAddressExample.Criteria or() {
        BuyerAddressExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public BuyerAddressExample.Criteria createCriteria() {
        BuyerAddressExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected BuyerAddressExample.Criteria createCriteriaInternal() {
        BuyerAddressExample.Criteria criteria = new BuyerAddressExample.Criteria();
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

    public static class Criteria extends BuyerAddressExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<BuyerAddressExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<BuyerAddressExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<BuyerAddressExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new BuyerAddressExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new BuyerAddressExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new BuyerAddressExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public BuyerAddressExample.Criteria andCityIdIsNull() {
            this.addCriterion("city_id is null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdIsNotNull() {
            this.addCriterion("city_id is not null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdEqualTo(Long value) {
            this.addCriterion("city_id =", value, "cityId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdNotEqualTo(Long value) {
            this.addCriterion("city_id <>", value, "cityId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdGreaterThan(Long value) {
            this.addCriterion("city_id >", value, "cityId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("city_id >=", value, "cityId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdLessThan(Long value) {
            this.addCriterion("city_id <", value, "cityId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdLessThanOrEqualTo(Long value) {
            this.addCriterion("city_id <=", value, "cityId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdLike(String value) {
            this.addCriterion("city_id like", value, "cityId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdNotLike(String value) {
            this.addCriterion("city_id not like", value, "cityId");
            return (BuyerAddressExample.Criteria)this;
        }        public BuyerAddressExample.Criteria andCityIdIn(List<Long> values) {
            this.addCriterion("city_id in", values, "cityId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdNotIn(List<Long> values) {
            this.addCriterion("city_id not in", values, "cityId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdBetween(Long value1, Long value2) {
            this.addCriterion("city_id between", value1, value2, "cityId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdNotBetween(Long value1, Long value2) {
            this.addCriterion("city_id not between", value1, value2, "cityId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdIsNull() {
            this.addCriterion("town_id is null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdIsNotNull() {
            this.addCriterion("town_id is not null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdEqualTo(Long value) {
            this.addCriterion("town_id =", value, "townId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdNotEqualTo(Long value) {
            this.addCriterion("town_id <>", value, "townId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdGreaterThan(Long value) {
            this.addCriterion("town_id >", value, "townId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("town_id >=", value, "townId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdLessThan(Long value) {
            this.addCriterion("town_id <", value, "townId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdLessThanOrEqualTo(Long value) {
            this.addCriterion("town_id <=", value, "townId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdLike(String value) {
            this.addCriterion("town_id like", value, "townId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdNotLike(String value) {
            this.addCriterion("town_id not like", value, "townId");
            return (BuyerAddressExample.Criteria)this;
        }        public BuyerAddressExample.Criteria andTownIdIn(List<Long> values) {
            this.addCriterion("town_id in", values, "townId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdNotIn(List<Long> values) {
            this.addCriterion("town_id not in", values, "townId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdBetween(Long value1, Long value2) {
            this.addCriterion("town_id between", value1, value2, "townId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdNotBetween(Long value1, Long value2) {
            this.addCriterion("town_id not between", value1, value2, "townId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityNameIsNull() {
            this.addCriterion("city_name is null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityNameIsNotNull() {
            this.addCriterion("city_name is not null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityNameEqualTo(String value) {
            this.addCriterion("city_name =", value, "cityName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityNameNotEqualTo(String value) {
            this.addCriterion("city_name <>", value, "cityName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityNameGreaterThan(String value) {
            this.addCriterion("city_name >", value, "cityName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("city_name >=", value, "cityName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityNameLessThan(String value) {
            this.addCriterion("city_name <", value, "cityName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityNameLessThanOrEqualTo(String value) {
            this.addCriterion("city_name <=", value, "cityName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityNameLike(String value) {
            this.addCriterion("city_name like", value, "cityName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityNameNotLike(String value) {
            this.addCriterion("city_name not like", value, "cityName");
            return (BuyerAddressExample.Criteria)this;
        }        public BuyerAddressExample.Criteria andCityNameIn(List<String> values) {
            this.addCriterion("city_name in", values, "cityName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityNameNotIn(List<String> values) {
            this.addCriterion("city_name not in", values, "cityName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityNameBetween(String value1, String value2) {
            this.addCriterion("city_name between", value1, value2, "cityName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityNameNotBetween(String value1, String value2) {
            this.addCriterion("city_name not between", value1, value2, "cityName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownNameIsNull() {
            this.addCriterion("town_name is null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownNameIsNotNull() {
            this.addCriterion("town_name is not null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownNameEqualTo(String value) {
            this.addCriterion("town_name =", value, "townName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownNameNotEqualTo(String value) {
            this.addCriterion("town_name <>", value, "townName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownNameGreaterThan(String value) {
            this.addCriterion("town_name >", value, "townName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("town_name >=", value, "townName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownNameLessThan(String value) {
            this.addCriterion("town_name <", value, "townName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownNameLessThanOrEqualTo(String value) {
            this.addCriterion("town_name <=", value, "townName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownNameLike(String value) {
            this.addCriterion("town_name like", value, "townName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownNameNotLike(String value) {
            this.addCriterion("town_name not like", value, "townName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownNameIn(List<String> values) {
            this.addCriterion("town_name in", values, "townName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownNameNotIn(List<String> values) {
            this.addCriterion("town_name not in", values, "townName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownNameBetween(String value1, String value2) {
            this.addCriterion("town_name between", value1, value2, "townName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownNameNotBetween(String value1, String value2) {
            this.addCriterion("town_name not between", value1, value2, "townName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeIsNull() {
            this.addCriterion("zip_code is null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeIsNotNull() {
            this.addCriterion("zip_code is not null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeEqualTo(String value) {
            this.addCriterion("zip_code =", value, "zipCode");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeNotEqualTo(String value) {
            this.addCriterion("zip_code <>", value, "zipCode");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeGreaterThan(String value) {
            this.addCriterion("zip_code >", value, "zipCode");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeGreaterThanOrEqualTo(String value) {
            this.addCriterion("zip_code >=", value, "zipCode");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeLessThan(String value) {
            this.addCriterion("zip_code <", value, "zipCode");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeLessThanOrEqualTo(String value) {
            this.addCriterion("zip_code <=", value, "zipCode");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeLike(String value) {
            this.addCriterion("zip_code like", value, "zipCode");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeNotLike(String value) {
            this.addCriterion("zip_code not like", value, "zipCode");
            return (BuyerAddressExample.Criteria)this;
        }        public BuyerAddressExample.Criteria andZipCodeIn(List<String> values) {
            this.addCriterion("zip_code in", values, "zipCode");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeNotIn(List<String> values) {
            this.addCriterion("zip_code not in", values, "zipCode");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeBetween(String value1, String value2) {
            this.addCriterion("zip_code between", value1, value2, "zipCode");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeNotBetween(String value1, String value2) {
            this.addCriterion("zip_code not between", value1, value2, "zipCode");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIsNull() {
            this.addCriterion("address is null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIsNotNull() {
            this.addCriterion("address is not null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressEqualTo(String value) {
            this.addCriterion("address =", value, "address");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressNotEqualTo(String value) {
            this.addCriterion("address <>", value, "address");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressGreaterThan(String value) {
            this.addCriterion("address >", value, "address");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressGreaterThanOrEqualTo(String value) {
            this.addCriterion("address >=", value, "address");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressLessThan(String value) {
            this.addCriterion("address <", value, "address");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressLessThanOrEqualTo(String value) {
            this.addCriterion("address <=", value, "address");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressLike(String value) {
            this.addCriterion("address like", value, "address");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressNotLike(String value) {
            this.addCriterion("address not like", value, "address");
            return (BuyerAddressExample.Criteria)this;
        }        public BuyerAddressExample.Criteria andAddressIn(List<String> values) {
            this.addCriterion("address in", values, "address");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressNotIn(List<String> values) {
            this.addCriterion("address not in", values, "address");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressBetween(String value1, String value2) {
            this.addCriterion("address between", value1, value2, "address");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressNotBetween(String value1, String value2) {
            this.addCriterion("address not between", value1, value2, "address");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdIsNull() {
            this.addCriterion("address_id is null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdIsNotNull() {
            this.addCriterion("address_id is not null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdEqualTo(Long value) {
            this.addCriterion("address_id =", value, "addressId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdNotEqualTo(Long value) {
            this.addCriterion("address_id <>", value, "addressId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdGreaterThan(Long value) {
            this.addCriterion("address_id >", value, "addressId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("address_id >=", value, "addressId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdLessThan(Long value) {
            this.addCriterion("address_id <", value, "addressId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdLessThanOrEqualTo(Long value) {
            this.addCriterion("address_id <=", value, "addressId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdLike(String value) {
            this.addCriterion("address_id like", value, "addressId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdNotLike(String value) {
            this.addCriterion("address_id not like", value, "addressId");
            return (BuyerAddressExample.Criteria)this;
        }        public BuyerAddressExample.Criteria andAddressIdIn(List<Long> values) {
            this.addCriterion("address_id in", values, "addressId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdNotIn(List<Long> values) {
            this.addCriterion("address_id not in", values, "addressId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdBetween(Long value1, Long value2) {
            this.addCriterion("address_id between", value1, value2, "addressId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdNotBetween(Long value1, Long value2) {
            this.addCriterion("address_id not between", value1, value2, "addressId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andNameIsNull() {
            this.addCriterion("name is null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andNameIsNotNull() {
            this.addCriterion("name is not null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andNameEqualTo(String value) {
            this.addCriterion("name =", value, "name");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andNameNotEqualTo(String value) {
            this.addCriterion("name <>", value, "name");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andNameGreaterThan(String value) {
            this.addCriterion("name >", value, "name");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("name >=", value, "name");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andNameLessThan(String value) {
            this.addCriterion("name <", value, "name");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andNameLessThanOrEqualTo(String value) {
            this.addCriterion("name <=", value, "name");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andNameLike(String value) {
            this.addCriterion("name like", value, "name");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andNameNotLike(String value) {
            this.addCriterion("name not like", value, "name");
            return (BuyerAddressExample.Criteria)this;
        }        public BuyerAddressExample.Criteria andNameIn(List<String> values) {
            this.addCriterion("name in", values, "name");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andNameNotIn(List<String> values) {
            this.addCriterion("name not in", values, "name");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andNameBetween(String value1, String value2) {
            this.addCriterion("name between", value1, value2, "name");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andNameNotBetween(String value1, String value2) {
            this.addCriterion("name not between", value1, value2, "name");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvNameIsNull() {
            this.addCriterion("prov_name is null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvNameIsNotNull() {
            this.addCriterion("prov_name is not null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvNameEqualTo(String value) {
            this.addCriterion("prov_name =", value, "provName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvNameNotEqualTo(String value) {
            this.addCriterion("prov_name <>", value, "provName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvNameGreaterThan(String value) {
            this.addCriterion("prov_name >", value, "provName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("prov_name >=", value, "provName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvNameLessThan(String value) {
            this.addCriterion("prov_name <", value, "provName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvNameLessThanOrEqualTo(String value) {
            this.addCriterion("prov_name <=", value, "provName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvNameLike(String value) {
            this.addCriterion("prov_name like", value, "provName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvNameNotLike(String value) {
            this.addCriterion("prov_name not like", value, "provName");
            return (BuyerAddressExample.Criteria)this;
        }        public BuyerAddressExample.Criteria andProvNameIn(List<String> values) {
            this.addCriterion("prov_name in", values, "provName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvNameNotIn(List<String> values) {
            this.addCriterion("prov_name not in", values, "provName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvNameBetween(String value1, String value2) {
            this.addCriterion("prov_name between", value1, value2, "provName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvNameNotBetween(String value1, String value2) {
            this.addCriterion("prov_name not between", value1, value2, "provName");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (BuyerAddressExample.Criteria)this;
        }        public BuyerAddressExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTelephoneIsNull() {
            this.addCriterion("telephone is null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTelephoneIsNotNull() {
            this.addCriterion("telephone is not null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTelephoneEqualTo(String value) {
            this.addCriterion("telephone =", value, "telephone");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTelephoneNotEqualTo(String value) {
            this.addCriterion("telephone <>", value, "telephone");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTelephoneGreaterThan(String value) {
            this.addCriterion("telephone >", value, "telephone");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            this.addCriterion("telephone >=", value, "telephone");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTelephoneLessThan(String value) {
            this.addCriterion("telephone <", value, "telephone");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTelephoneLessThanOrEqualTo(String value) {
            this.addCriterion("telephone <=", value, "telephone");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTelephoneLike(String value) {
            this.addCriterion("telephone like", value, "telephone");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTelephoneNotLike(String value) {
            this.addCriterion("telephone not like", value, "telephone");
            return (BuyerAddressExample.Criteria)this;
        }        public BuyerAddressExample.Criteria andTelephoneIn(List<String> values) {
            this.addCriterion("telephone in", values, "telephone");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTelephoneNotIn(List<String> values) {
            this.addCriterion("telephone not in", values, "telephone");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTelephoneBetween(String value1, String value2) {
            this.addCriterion("telephone between", value1, value2, "telephone");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTelephoneNotBetween(String value1, String value2) {
            this.addCriterion("telephone not between", value1, value2, "telephone");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdIsNull() {
            this.addCriterion("prov_id is null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdIsNotNull() {
            this.addCriterion("prov_id is not null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdEqualTo(Long value) {
            this.addCriterion("prov_id =", value, "provId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdNotEqualTo(Long value) {
            this.addCriterion("prov_id <>", value, "provId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdGreaterThan(Long value) {
            this.addCriterion("prov_id >", value, "provId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("prov_id >=", value, "provId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdLessThan(Long value) {
            this.addCriterion("prov_id <", value, "provId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdLessThanOrEqualTo(Long value) {
            this.addCriterion("prov_id <=", value, "provId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdLike(String value) {
            this.addCriterion("prov_id like", value, "provId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdNotLike(String value) {
            this.addCriterion("prov_id not like", value, "provId");
            return (BuyerAddressExample.Criteria)this;
        }        public BuyerAddressExample.Criteria andProvIdIn(List<Long> values) {
            this.addCriterion("prov_id in", values, "provId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdNotIn(List<Long> values) {
            this.addCriterion("prov_id not in", values, "provId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdBetween(Long value1, Long value2) {
            this.addCriterion("prov_id between", value1, value2, "provId");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdNotBetween(Long value1, Long value2) {
            this.addCriterion("prov_id not between", value1, value2, "provId");
            return (BuyerAddressExample.Criteria)this;
        }
    }
}
