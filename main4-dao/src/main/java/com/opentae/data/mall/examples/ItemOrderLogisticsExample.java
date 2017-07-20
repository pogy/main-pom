package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ItemOrderLogisticsExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ItemOrderLogisticsExample.Criteria> oredCriteria = new ArrayList();

    public ItemOrderLogisticsExample() {
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

    public List<ItemOrderLogisticsExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ItemOrderLogisticsExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ItemOrderLogisticsExample.Criteria or() {
        ItemOrderLogisticsExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ItemOrderLogisticsExample.Criteria createCriteria() {
        ItemOrderLogisticsExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ItemOrderLogisticsExample.Criteria createCriteriaInternal() {
        ItemOrderLogisticsExample.Criteria criteria = new ItemOrderLogisticsExample.Criteria();
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

    public static class Criteria extends ItemOrderLogisticsExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ItemOrderLogisticsExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ItemOrderLogisticsExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ItemOrderLogisticsExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ItemOrderLogisticsExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ItemOrderLogisticsExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ItemOrderLogisticsExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ItemOrderLogisticsExample.Criteria andCityIdIsNull() {
            this.addCriterion("city_id is null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdIsNotNull() {
            this.addCriterion("city_id is not null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdEqualTo(Long value) {
            this.addCriterion("city_id =", value, "cityId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdNotEqualTo(Long value) {
            this.addCriterion("city_id <>", value, "cityId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdGreaterThan(Long value) {
            this.addCriterion("city_id >", value, "cityId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("city_id >=", value, "cityId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdLessThan(Long value) {
            this.addCriterion("city_id <", value, "cityId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdLessThanOrEqualTo(Long value) {
            this.addCriterion("city_id <=", value, "cityId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdLike(String value) {
            this.addCriterion("city_id like", value, "cityId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdNotLike(String value) {
            this.addCriterion("city_id not like", value, "cityId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }        public ItemOrderLogisticsExample.Criteria andCityIdIn(List<Long> values) {
            this.addCriterion("city_id in", values, "cityId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdNotIn(List<Long> values) {
            this.addCriterion("city_id not in", values, "cityId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdBetween(Long value1, Long value2) {
            this.addCriterion("city_id between", value1, value2, "cityId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdNotBetween(Long value1, Long value2) {
            this.addCriterion("city_id not between", value1, value2, "cityId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andIdIsNull() {
            this.addCriterion("id is null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andIdIsNotNull() {
            this.addCriterion("id is not null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andIdEqualTo(Long value) {
            this.addCriterion("id =", value, "id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andIdNotEqualTo(Long value) {
            this.addCriterion("id <>", value, "id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andIdGreaterThan(Long value) {
            this.addCriterion("id >", value, "id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("id >=", value, "id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andIdLessThan(Long value) {
            this.addCriterion("id <", value, "id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andIdLessThanOrEqualTo(Long value) {
            this.addCriterion("id <=", value, "id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andIdLike(String value) {
            this.addCriterion("id like", value, "id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andIdNotLike(String value) {
            this.addCriterion("id not like", value, "id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }        public ItemOrderLogisticsExample.Criteria andIdIn(List<Long> values) {
            this.addCriterion("id in", values, "id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andIdNotIn(List<Long> values) {
            this.addCriterion("id not in", values, "id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andIdBetween(Long value1, Long value2) {
            this.addCriterion("id between", value1, value2, "id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andIdNotBetween(Long value1, Long value2) {
            this.addCriterion("id not between", value1, value2, "id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdIsNull() {
            this.addCriterion("town_id is null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdIsNotNull() {
            this.addCriterion("town_id is not null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdEqualTo(Long value) {
            this.addCriterion("town_id =", value, "townId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdNotEqualTo(Long value) {
            this.addCriterion("town_id <>", value, "townId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdGreaterThan(Long value) {
            this.addCriterion("town_id >", value, "townId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("town_id >=", value, "townId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdLessThan(Long value) {
            this.addCriterion("town_id <", value, "townId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdLessThanOrEqualTo(Long value) {
            this.addCriterion("town_id <=", value, "townId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdLike(String value) {
            this.addCriterion("town_id like", value, "townId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdNotLike(String value) {
            this.addCriterion("town_id not like", value, "townId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }        public ItemOrderLogisticsExample.Criteria andTownIdIn(List<Long> values) {
            this.addCriterion("town_id in", values, "townId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdNotIn(List<Long> values) {
            this.addCriterion("town_id not in", values, "townId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdBetween(Long value1, Long value2) {
            this.addCriterion("town_id between", value1, value2, "townId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdNotBetween(Long value1, Long value2) {
            this.addCriterion("town_id not between", value1, value2, "townId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdIsNull() {
            this.addCriterion("company_id is null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdIsNotNull() {
            this.addCriterion("company_id is not null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdEqualTo(Long value) {
            this.addCriterion("company_id =", value, "companyId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdNotEqualTo(Long value) {
            this.addCriterion("company_id <>", value, "companyId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdGreaterThan(Long value) {
            this.addCriterion("company_id >", value, "companyId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("company_id >=", value, "companyId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdLessThan(Long value) {
            this.addCriterion("company_id <", value, "companyId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdLessThanOrEqualTo(Long value) {
            this.addCriterion("company_id <=", value, "companyId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdLike(String value) {
            this.addCriterion("company_id like", value, "companyId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdNotLike(String value) {
            this.addCriterion("company_id not like", value, "companyId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }        public ItemOrderLogisticsExample.Criteria andCompanyIdIn(List<Long> values) {
            this.addCriterion("company_id in", values, "companyId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdNotIn(List<Long> values) {
            this.addCriterion("company_id not in", values, "companyId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdBetween(Long value1, Long value2) {
            this.addCriterion("company_id between", value1, value2, "companyId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdNotBetween(Long value1, Long value2) {
            this.addCriterion("company_id not between", value1, value2, "companyId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeIsNull() {
            this.addCriterion("zip_code is null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeIsNotNull() {
            this.addCriterion("zip_code is not null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeEqualTo(String value) {
            this.addCriterion("zip_code =", value, "zipCode");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeNotEqualTo(String value) {
            this.addCriterion("zip_code <>", value, "zipCode");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeGreaterThan(String value) {
            this.addCriterion("zip_code >", value, "zipCode");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeGreaterThanOrEqualTo(String value) {
            this.addCriterion("zip_code >=", value, "zipCode");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeLessThan(String value) {
            this.addCriterion("zip_code <", value, "zipCode");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeLessThanOrEqualTo(String value) {
            this.addCriterion("zip_code <=", value, "zipCode");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeLike(String value) {
            this.addCriterion("zip_code like", value, "zipCode");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeNotLike(String value) {
            this.addCriterion("zip_code not like", value, "zipCode");
            return (ItemOrderLogisticsExample.Criteria)this;
        }        public ItemOrderLogisticsExample.Criteria andZipCodeIn(List<String> values) {
            this.addCriterion("zip_code in", values, "zipCode");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeNotIn(List<String> values) {
            this.addCriterion("zip_code not in", values, "zipCode");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeBetween(String value1, String value2) {
            this.addCriterion("zip_code between", value1, value2, "zipCode");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeNotBetween(String value1, String value2) {
            this.addCriterion("zip_code not between", value1, value2, "zipCode");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andAddressIsNull() {
            this.addCriterion("address is null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andAddressIsNotNull() {
            this.addCriterion("address is not null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andAddressEqualTo(String value) {
            this.addCriterion("address =", value, "address");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andAddressNotEqualTo(String value) {
            this.addCriterion("address <>", value, "address");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andAddressGreaterThan(String value) {
            this.addCriterion("address >", value, "address");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andAddressGreaterThanOrEqualTo(String value) {
            this.addCriterion("address >=", value, "address");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andAddressLessThan(String value) {
            this.addCriterion("address <", value, "address");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andAddressLessThanOrEqualTo(String value) {
            this.addCriterion("address <=", value, "address");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andAddressLike(String value) {
            this.addCriterion("address like", value, "address");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andAddressNotLike(String value) {
            this.addCriterion("address not like", value, "address");
            return (ItemOrderLogisticsExample.Criteria)this;
        }        public ItemOrderLogisticsExample.Criteria andAddressIn(List<String> values) {
            this.addCriterion("address in", values, "address");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andAddressNotIn(List<String> values) {
            this.addCriterion("address not in", values, "address");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andAddressBetween(String value1, String value2) {
            this.addCriterion("address between", value1, value2, "address");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andAddressNotBetween(String value1, String value2) {
            this.addCriterion("address not between", value1, value2, "address");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andOidIsNull() {
            this.addCriterion("oid is null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andOidIsNotNull() {
            this.addCriterion("oid is not null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andOidEqualTo(Long value) {
            this.addCriterion("oid =", value, "oid");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andOidNotEqualTo(Long value) {
            this.addCriterion("oid <>", value, "oid");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andOidGreaterThan(Long value) {
            this.addCriterion("oid >", value, "oid");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andOidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("oid >=", value, "oid");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andOidLessThan(Long value) {
            this.addCriterion("oid <", value, "oid");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andOidLessThanOrEqualTo(Long value) {
            this.addCriterion("oid <=", value, "oid");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andOidLike(String value) {
            this.addCriterion("oid like", value, "oid");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andOidNotLike(String value) {
            this.addCriterion("oid not like", value, "oid");
            return (ItemOrderLogisticsExample.Criteria)this;
        }        public ItemOrderLogisticsExample.Criteria andOidIn(List<Long> values) {
            this.addCriterion("oid in", values, "oid");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andOidNotIn(List<Long> values) {
            this.addCriterion("oid not in", values, "oid");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andOidBetween(Long value1, Long value2) {
            this.addCriterion("oid between", value1, value2, "oid");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andOidNotBetween(Long value1, Long value2) {
            this.addCriterion("oid not between", value1, value2, "oid");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andNameIsNull() {
            this.addCriterion("name is null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andNameIsNotNull() {
            this.addCriterion("name is not null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andNameEqualTo(String value) {
            this.addCriterion("name =", value, "name");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andNameNotEqualTo(String value) {
            this.addCriterion("name <>", value, "name");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andNameGreaterThan(String value) {
            this.addCriterion("name >", value, "name");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("name >=", value, "name");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andNameLessThan(String value) {
            this.addCriterion("name <", value, "name");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andNameLessThanOrEqualTo(String value) {
            this.addCriterion("name <=", value, "name");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andNameLike(String value) {
            this.addCriterion("name like", value, "name");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andNameNotLike(String value) {
            this.addCriterion("name not like", value, "name");
            return (ItemOrderLogisticsExample.Criteria)this;
        }        public ItemOrderLogisticsExample.Criteria andNameIn(List<String> values) {
            this.addCriterion("name in", values, "name");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andNameNotIn(List<String> values) {
            this.addCriterion("name not in", values, "name");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andNameBetween(String value1, String value2) {
            this.addCriterion("name between", value1, value2, "name");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andNameNotBetween(String value1, String value2) {
            this.addCriterion("name not between", value1, value2, "name");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andMoneyIsNull() {
            this.addCriterion("money is null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andMoneyIsNotNull() {
            this.addCriterion("money is not null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andMoneyEqualTo(Long value) {
            this.addCriterion("money =", value, "money");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andMoneyNotEqualTo(Long value) {
            this.addCriterion("money <>", value, "money");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andMoneyGreaterThan(Long value) {
            this.addCriterion("money >", value, "money");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andMoneyGreaterThanOrEqualTo(Long value) {
            this.addCriterion("money >=", value, "money");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andMoneyLessThan(Long value) {
            this.addCriterion("money <", value, "money");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andMoneyLessThanOrEqualTo(Long value) {
            this.addCriterion("money <=", value, "money");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andMoneyLike(String value) {
            this.addCriterion("money like", value, "money");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andMoneyNotLike(String value) {
            this.addCriterion("money not like", value, "money");
            return (ItemOrderLogisticsExample.Criteria)this;
        }        public ItemOrderLogisticsExample.Criteria andMoneyIn(List<Long> values) {
            this.addCriterion("money in", values, "money");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andMoneyNotIn(List<Long> values) {
            this.addCriterion("money not in", values, "money");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andMoneyBetween(Long value1, Long value2) {
            this.addCriterion("money between", value1, value2, "money");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andMoneyNotBetween(Long value1, Long value2) {
            this.addCriterion("money not between", value1, value2, "money");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberIsNull() {
            this.addCriterion("courier_number is null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberIsNotNull() {
            this.addCriterion("courier_number is not null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberEqualTo(String value) {
            this.addCriterion("courier_number =", value, "courierNumber");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberNotEqualTo(String value) {
            this.addCriterion("courier_number <>", value, "courierNumber");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberGreaterThan(String value) {
            this.addCriterion("courier_number >", value, "courierNumber");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberGreaterThanOrEqualTo(String value) {
            this.addCriterion("courier_number >=", value, "courierNumber");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberLessThan(String value) {
            this.addCriterion("courier_number <", value, "courierNumber");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberLessThanOrEqualTo(String value) {
            this.addCriterion("courier_number <=", value, "courierNumber");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberLike(String value) {
            this.addCriterion("courier_number like", value, "courierNumber");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberNotLike(String value) {
            this.addCriterion("courier_number not like", value, "courierNumber");
            return (ItemOrderLogisticsExample.Criteria)this;
        }        public ItemOrderLogisticsExample.Criteria andCourierNumberIn(List<String> values) {
            this.addCriterion("courier_number in", values, "courierNumber");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberNotIn(List<String> values) {
            this.addCriterion("courier_number not in", values, "courierNumber");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberBetween(String value1, String value2) {
            this.addCriterion("courier_number between", value1, value2, "courierNumber");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberNotBetween(String value1, String value2) {
            this.addCriterion("courier_number not between", value1, value2, "courierNumber");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneIsNull() {
            this.addCriterion("telephone is null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneIsNotNull() {
            this.addCriterion("telephone is not null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneEqualTo(String value) {
            this.addCriterion("telephone =", value, "telephone");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneNotEqualTo(String value) {
            this.addCriterion("telephone <>", value, "telephone");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneGreaterThan(String value) {
            this.addCriterion("telephone >", value, "telephone");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            this.addCriterion("telephone >=", value, "telephone");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneLessThan(String value) {
            this.addCriterion("telephone <", value, "telephone");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneLessThanOrEqualTo(String value) {
            this.addCriterion("telephone <=", value, "telephone");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneLike(String value) {
            this.addCriterion("telephone like", value, "telephone");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneNotLike(String value) {
            this.addCriterion("telephone not like", value, "telephone");
            return (ItemOrderLogisticsExample.Criteria)this;
        }        public ItemOrderLogisticsExample.Criteria andTelephoneIn(List<String> values) {
            this.addCriterion("telephone in", values, "telephone");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneNotIn(List<String> values) {
            this.addCriterion("telephone not in", values, "telephone");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneBetween(String value1, String value2) {
            this.addCriterion("telephone between", value1, value2, "telephone");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTelephoneNotBetween(String value1, String value2) {
            this.addCriterion("telephone not between", value1, value2, "telephone");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdIsNull() {
            this.addCriterion("prov_id is null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdIsNotNull() {
            this.addCriterion("prov_id is not null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdEqualTo(Long value) {
            this.addCriterion("prov_id =", value, "provId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdNotEqualTo(Long value) {
            this.addCriterion("prov_id <>", value, "provId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdGreaterThan(Long value) {
            this.addCriterion("prov_id >", value, "provId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("prov_id >=", value, "provId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdLessThan(Long value) {
            this.addCriterion("prov_id <", value, "provId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdLessThanOrEqualTo(Long value) {
            this.addCriterion("prov_id <=", value, "provId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdLike(String value) {
            this.addCriterion("prov_id like", value, "provId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdNotLike(String value) {
            this.addCriterion("prov_id not like", value, "provId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }        public ItemOrderLogisticsExample.Criteria andProvIdIn(List<Long> values) {
            this.addCriterion("prov_id in", values, "provId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdNotIn(List<Long> values) {
            this.addCriterion("prov_id not in", values, "provId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdBetween(Long value1, Long value2) {
            this.addCriterion("prov_id between", value1, value2, "provId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdNotBetween(Long value1, Long value2) {
            this.addCriterion("prov_id not between", value1, value2, "provId");
            return (ItemOrderLogisticsExample.Criteria)this;
        }
    }
}
