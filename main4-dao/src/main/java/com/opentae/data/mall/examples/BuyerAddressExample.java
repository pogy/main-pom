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

        public BuyerAddressExample.Criteria andProvIdIsNull() {
            this.addCriterion("provId is null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdIsNotNull() {
            this.addCriterion("provId is not null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdEqualTo(Long value) {
            this.addCriterion("provId =", value, "prov_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdNotEqualTo(Long value) {
            this.addCriterion("provId <>", value, "prov_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdGreaterThan(Long value) {
            this.addCriterion("provId >", value, "prov_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("provId >=", value, "prov_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdLessThan(Long value) {
            this.addCriterion("provId <", value, "prov_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdLessThanOrEqualTo(Long value) {
            this.addCriterion("provId <=", value, "prov_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdLike(String value) {
            this.addCriterion("provId like", value, "prov_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdNotLike(String value) {
            this.addCriterion("provId not like", value, "prov_id");
            return (BuyerAddressExample.Criteria)this;
        }        public BuyerAddressExample.Criteria andProvIdIn(List<Long> values) {
            this.addCriterion("provId in", values, "prov_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdNotIn(List<Long> values) {
            this.addCriterion("provId not in", values, "prov_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdBetween(Long value1, Long value2) {
            this.addCriterion("provId between", value1, value2, "prov_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andProvIdNotBetween(Long value1, Long value2) {
            this.addCriterion("provId not between", value1, value2, "prov_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdIsNull() {
            this.addCriterion("townId is null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdIsNotNull() {
            this.addCriterion("townId is not null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdEqualTo(Long value) {
            this.addCriterion("townId =", value, "town_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdNotEqualTo(Long value) {
            this.addCriterion("townId <>", value, "town_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdGreaterThan(Long value) {
            this.addCriterion("townId >", value, "town_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("townId >=", value, "town_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdLessThan(Long value) {
            this.addCriterion("townId <", value, "town_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdLessThanOrEqualTo(Long value) {
            this.addCriterion("townId <=", value, "town_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdLike(String value) {
            this.addCriterion("townId like", value, "town_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdNotLike(String value) {
            this.addCriterion("townId not like", value, "town_id");
            return (BuyerAddressExample.Criteria)this;
        }        public BuyerAddressExample.Criteria andTownIdIn(List<Long> values) {
            this.addCriterion("townId in", values, "town_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdNotIn(List<Long> values) {
            this.addCriterion("townId not in", values, "town_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdBetween(Long value1, Long value2) {
            this.addCriterion("townId between", value1, value2, "town_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andTownIdNotBetween(Long value1, Long value2) {
            this.addCriterion("townId not between", value1, value2, "town_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdIsNull() {
            this.addCriterion("userId is null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("userId is not null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("userId =", value, "user_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("userId <>", value, "user_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("userId >", value, "user_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("userId >=", value, "user_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("userId <", value, "user_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("userId <=", value, "user_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdLike(String value) {
            this.addCriterion("userId like", value, "user_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("userId not like", value, "user_id");
            return (BuyerAddressExample.Criteria)this;
        }        public BuyerAddressExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("userId in", values, "user_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("userId not in", values, "user_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("userId between", value1, value2, "user_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("userId not between", value1, value2, "user_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdIsNull() {
            this.addCriterion("addressId is null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdIsNotNull() {
            this.addCriterion("addressId is not null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdEqualTo(Long value) {
            this.addCriterion("addressId =", value, "address_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdNotEqualTo(Long value) {
            this.addCriterion("addressId <>", value, "address_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdGreaterThan(Long value) {
            this.addCriterion("addressId >", value, "address_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("addressId >=", value, "address_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdLessThan(Long value) {
            this.addCriterion("addressId <", value, "address_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdLessThanOrEqualTo(Long value) {
            this.addCriterion("addressId <=", value, "address_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdLike(String value) {
            this.addCriterion("addressId like", value, "address_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdNotLike(String value) {
            this.addCriterion("addressId not like", value, "address_id");
            return (BuyerAddressExample.Criteria)this;
        }        public BuyerAddressExample.Criteria andAddressIdIn(List<Long> values) {
            this.addCriterion("addressId in", values, "address_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdNotIn(List<Long> values) {
            this.addCriterion("addressId not in", values, "address_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdBetween(Long value1, Long value2) {
            this.addCriterion("addressId between", value1, value2, "address_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andAddressIdNotBetween(Long value1, Long value2) {
            this.addCriterion("addressId not between", value1, value2, "address_id");
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

        public BuyerAddressExample.Criteria andZipCodeIsNull() {
            this.addCriterion("zipCode is null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeIsNotNull() {
            this.addCriterion("zipCode is not null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeEqualTo(String value) {
            this.addCriterion("zipCode =", value, "zip_code");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeNotEqualTo(String value) {
            this.addCriterion("zipCode <>", value, "zip_code");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeGreaterThan(String value) {
            this.addCriterion("zipCode >", value, "zip_code");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeGreaterThanOrEqualTo(String value) {
            this.addCriterion("zipCode >=", value, "zip_code");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeLessThan(String value) {
            this.addCriterion("zipCode <", value, "zip_code");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeLessThanOrEqualTo(String value) {
            this.addCriterion("zipCode <=", value, "zip_code");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeLike(String value) {
            this.addCriterion("zipCode like", value, "zip_code");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeNotLike(String value) {
            this.addCriterion("zipCode not like", value, "zip_code");
            return (BuyerAddressExample.Criteria)this;
        }        public BuyerAddressExample.Criteria andZipCodeIn(List<String> values) {
            this.addCriterion("zipCode in", values, "zip_code");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeNotIn(List<String> values) {
            this.addCriterion("zipCode not in", values, "zip_code");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeBetween(String value1, String value2) {
            this.addCriterion("zipCode between", value1, value2, "zip_code");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andZipCodeNotBetween(String value1, String value2) {
            this.addCriterion("zipCode not between", value1, value2, "zip_code");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdIsNull() {
            this.addCriterion("cityId is null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdIsNotNull() {
            this.addCriterion("cityId is not null");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdEqualTo(Long value) {
            this.addCriterion("cityId =", value, "city_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdNotEqualTo(Long value) {
            this.addCriterion("cityId <>", value, "city_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdGreaterThan(Long value) {
            this.addCriterion("cityId >", value, "city_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("cityId >=", value, "city_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdLessThan(Long value) {
            this.addCriterion("cityId <", value, "city_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdLessThanOrEqualTo(Long value) {
            this.addCriterion("cityId <=", value, "city_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdLike(String value) {
            this.addCriterion("cityId like", value, "city_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdNotLike(String value) {
            this.addCriterion("cityId not like", value, "city_id");
            return (BuyerAddressExample.Criteria)this;
        }        public BuyerAddressExample.Criteria andCityIdIn(List<Long> values) {
            this.addCriterion("cityId in", values, "city_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdNotIn(List<Long> values) {
            this.addCriterion("cityId not in", values, "city_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdBetween(Long value1, Long value2) {
            this.addCriterion("cityId between", value1, value2, "city_id");
            return (BuyerAddressExample.Criteria)this;
        }

        public BuyerAddressExample.Criteria andCityIdNotBetween(Long value1, Long value2) {
            this.addCriterion("cityId not between", value1, value2, "city_id");
            return (BuyerAddressExample.Criteria)this;
        }
    }
}
