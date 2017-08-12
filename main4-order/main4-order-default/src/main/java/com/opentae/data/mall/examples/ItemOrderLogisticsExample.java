package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ItemOrderLogisticsExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

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

    public List<Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
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

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public Criteria andCourierNumberIsNull() {
            this.addCriterion("courier_number is null");
            return (Criteria)this;
        }

        public Criteria andCourierNumberIsNotNull() {
            this.addCriterion("courier_number is not null");
            return (Criteria)this;
        }

        public Criteria andCourierNumberEqualTo(String value) {
            this.addCriterion("courier_number =", value, "courierNumber");
            return (Criteria)this;
        }

        public Criteria andCourierNumberNotEqualTo(String value) {
            this.addCriterion("courier_number <>", value, "courierNumber");
            return (Criteria)this;
        }

        public Criteria andCourierNumberGreaterThan(String value) {
            this.addCriterion("courier_number >", value, "courierNumber");
            return (Criteria)this;
        }

        public Criteria andCourierNumberGreaterThanOrEqualTo(String value) {
            this.addCriterion("courier_number >=", value, "courierNumber");
            return (Criteria)this;
        }

        public Criteria andCourierNumberLessThan(String value) {
            this.addCriterion("courier_number <", value, "courierNumber");
            return (Criteria)this;
        }

        public Criteria andCourierNumberLessThanOrEqualTo(String value) {
            this.addCriterion("courier_number <=", value, "courierNumber");
            return (Criteria)this;
        }

        public Criteria andCourierNumberLike(String value) {
            this.addCriterion("courier_number like", value, "courierNumber");
            return (Criteria)this;
        }

        public Criteria andCourierNumberNotLike(String value) {
            this.addCriterion("courier_number not like", value, "courierNumber");
            return (Criteria)this;
        }        public Criteria andCourierNumberIn(List<String> values) {
            this.addCriterion("courier_number in", values, "courierNumber");
            return (Criteria)this;
        }

        public Criteria andCourierNumberNotIn(List<String> values) {
            this.addCriterion("courier_number not in", values, "courierNumber");
            return (Criteria)this;
        }

        public Criteria andCourierNumberBetween(String value1, String value2) {
            this.addCriterion("courier_number between", value1, value2, "courierNumber");
            return (Criteria)this;
        }

        public Criteria andCourierNumberNotBetween(String value1, String value2) {
            this.addCriterion("courier_number not between", value1, value2, "courierNumber");
            return (Criteria)this;
        }

        public Criteria andAddressIsNull() {
            this.addCriterion("address is null");
            return (Criteria)this;
        }

        public Criteria andAddressIsNotNull() {
            this.addCriterion("address is not null");
            return (Criteria)this;
        }

        public Criteria andAddressEqualTo(String value) {
            this.addCriterion("address =", value, "address");
            return (Criteria)this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            this.addCriterion("address <>", value, "address");
            return (Criteria)this;
        }

        public Criteria andAddressGreaterThan(String value) {
            this.addCriterion("address >", value, "address");
            return (Criteria)this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            this.addCriterion("address >=", value, "address");
            return (Criteria)this;
        }

        public Criteria andAddressLessThan(String value) {
            this.addCriterion("address <", value, "address");
            return (Criteria)this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            this.addCriterion("address <=", value, "address");
            return (Criteria)this;
        }

        public Criteria andAddressLike(String value) {
            this.addCriterion("address like", value, "address");
            return (Criteria)this;
        }

        public Criteria andAddressNotLike(String value) {
            this.addCriterion("address not like", value, "address");
            return (Criteria)this;
        }        public Criteria andAddressIn(List<String> values) {
            this.addCriterion("address in", values, "address");
            return (Criteria)this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            this.addCriterion("address not in", values, "address");
            return (Criteria)this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            this.addCriterion("address between", value1, value2, "address");
            return (Criteria)this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            this.addCriterion("address not between", value1, value2, "address");
            return (Criteria)this;
        }

        public Criteria andCompanyIdIsNull() {
            this.addCriterion("company_id is null");
            return (Criteria)this;
        }

        public Criteria andCompanyIdIsNotNull() {
            this.addCriterion("company_id is not null");
            return (Criteria)this;
        }

        public Criteria andCompanyIdEqualTo(Long value) {
            this.addCriterion("company_id =", value, "companyId");
            return (Criteria)this;
        }

        public Criteria andCompanyIdNotEqualTo(Long value) {
            this.addCriterion("company_id <>", value, "companyId");
            return (Criteria)this;
        }

        public Criteria andCompanyIdGreaterThan(Long value) {
            this.addCriterion("company_id >", value, "companyId");
            return (Criteria)this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("company_id >=", value, "companyId");
            return (Criteria)this;
        }

        public Criteria andCompanyIdLessThan(Long value) {
            this.addCriterion("company_id <", value, "companyId");
            return (Criteria)this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Long value) {
            this.addCriterion("company_id <=", value, "companyId");
            return (Criteria)this;
        }

        public Criteria andCompanyIdLike(String value) {
            this.addCriterion("company_id like", value, "companyId");
            return (Criteria)this;
        }

        public Criteria andCompanyIdNotLike(String value) {
            this.addCriterion("company_id not like", value, "companyId");
            return (Criteria)this;
        }        public Criteria andCompanyIdIn(List<Long> values) {
            this.addCriterion("company_id in", values, "companyId");
            return (Criteria)this;
        }

        public Criteria andCompanyIdNotIn(List<Long> values) {
            this.addCriterion("company_id not in", values, "companyId");
            return (Criteria)this;
        }

        public Criteria andCompanyIdBetween(Long value1, Long value2) {
            this.addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria)this;
        }

        public Criteria andCompanyIdNotBetween(Long value1, Long value2) {
            this.addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria)this;
        }

        public Criteria andMoneyIsNull() {
            this.addCriterion("money is null");
            return (Criteria)this;
        }

        public Criteria andMoneyIsNotNull() {
            this.addCriterion("money is not null");
            return (Criteria)this;
        }

        public Criteria andMoneyEqualTo(Long value) {
            this.addCriterion("money =", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyNotEqualTo(Long value) {
            this.addCriterion("money <>", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyGreaterThan(Long value) {
            this.addCriterion("money >", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Long value) {
            this.addCriterion("money >=", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyLessThan(Long value) {
            this.addCriterion("money <", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Long value) {
            this.addCriterion("money <=", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyLike(String value) {
            this.addCriterion("money like", value, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyNotLike(String value) {
            this.addCriterion("money not like", value, "money");
            return (Criteria)this;
        }        public Criteria andMoneyIn(List<Long> values) {
            this.addCriterion("money in", values, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyNotIn(List<Long> values) {
            this.addCriterion("money not in", values, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyBetween(Long value1, Long value2) {
            this.addCriterion("money between", value1, value2, "money");
            return (Criteria)this;
        }

        public Criteria andMoneyNotBetween(Long value1, Long value2) {
            this.addCriterion("money not between", value1, value2, "money");
            return (Criteria)this;
        }

        public Criteria andProvIdIsNull() {
            this.addCriterion("prov_id is null");
            return (Criteria)this;
        }

        public Criteria andProvIdIsNotNull() {
            this.addCriterion("prov_id is not null");
            return (Criteria)this;
        }

        public Criteria andProvIdEqualTo(Long value) {
            this.addCriterion("prov_id =", value, "provId");
            return (Criteria)this;
        }

        public Criteria andProvIdNotEqualTo(Long value) {
            this.addCriterion("prov_id <>", value, "provId");
            return (Criteria)this;
        }

        public Criteria andProvIdGreaterThan(Long value) {
            this.addCriterion("prov_id >", value, "provId");
            return (Criteria)this;
        }

        public Criteria andProvIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("prov_id >=", value, "provId");
            return (Criteria)this;
        }

        public Criteria andProvIdLessThan(Long value) {
            this.addCriterion("prov_id <", value, "provId");
            return (Criteria)this;
        }

        public Criteria andProvIdLessThanOrEqualTo(Long value) {
            this.addCriterion("prov_id <=", value, "provId");
            return (Criteria)this;
        }

        public Criteria andProvIdLike(String value) {
            this.addCriterion("prov_id like", value, "provId");
            return (Criteria)this;
        }

        public Criteria andProvIdNotLike(String value) {
            this.addCriterion("prov_id not like", value, "provId");
            return (Criteria)this;
        }        public Criteria andProvIdIn(List<Long> values) {
            this.addCriterion("prov_id in", values, "provId");
            return (Criteria)this;
        }

        public Criteria andProvIdNotIn(List<Long> values) {
            this.addCriterion("prov_id not in", values, "provId");
            return (Criteria)this;
        }

        public Criteria andProvIdBetween(Long value1, Long value2) {
            this.addCriterion("prov_id between", value1, value2, "provId");
            return (Criteria)this;
        }

        public Criteria andProvIdNotBetween(Long value1, Long value2) {
            this.addCriterion("prov_id not between", value1, value2, "provId");
            return (Criteria)this;
        }

        public Criteria andTownIdIsNull() {
            this.addCriterion("town_id is null");
            return (Criteria)this;
        }

        public Criteria andTownIdIsNotNull() {
            this.addCriterion("town_id is not null");
            return (Criteria)this;
        }

        public Criteria andTownIdEqualTo(Long value) {
            this.addCriterion("town_id =", value, "townId");
            return (Criteria)this;
        }

        public Criteria andTownIdNotEqualTo(Long value) {
            this.addCriterion("town_id <>", value, "townId");
            return (Criteria)this;
        }

        public Criteria andTownIdGreaterThan(Long value) {
            this.addCriterion("town_id >", value, "townId");
            return (Criteria)this;
        }

        public Criteria andTownIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("town_id >=", value, "townId");
            return (Criteria)this;
        }

        public Criteria andTownIdLessThan(Long value) {
            this.addCriterion("town_id <", value, "townId");
            return (Criteria)this;
        }

        public Criteria andTownIdLessThanOrEqualTo(Long value) {
            this.addCriterion("town_id <=", value, "townId");
            return (Criteria)this;
        }

        public Criteria andTownIdLike(String value) {
            this.addCriterion("town_id like", value, "townId");
            return (Criteria)this;
        }

        public Criteria andTownIdNotLike(String value) {
            this.addCriterion("town_id not like", value, "townId");
            return (Criteria)this;
        }        public Criteria andTownIdIn(List<Long> values) {
            this.addCriterion("town_id in", values, "townId");
            return (Criteria)this;
        }

        public Criteria andTownIdNotIn(List<Long> values) {
            this.addCriterion("town_id not in", values, "townId");
            return (Criteria)this;
        }

        public Criteria andTownIdBetween(Long value1, Long value2) {
            this.addCriterion("town_id between", value1, value2, "townId");
            return (Criteria)this;
        }

        public Criteria andTownIdNotBetween(Long value1, Long value2) {
            this.addCriterion("town_id not between", value1, value2, "townId");
            return (Criteria)this;
        }

        public Criteria andNameIsNull() {
            this.addCriterion("name is null");
            return (Criteria)this;
        }

        public Criteria andNameIsNotNull() {
            this.addCriterion("name is not null");
            return (Criteria)this;
        }

        public Criteria andNameEqualTo(String value) {
            this.addCriterion("name =", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameNotEqualTo(String value) {
            this.addCriterion("name <>", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameGreaterThan(String value) {
            this.addCriterion("name >", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("name >=", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameLessThan(String value) {
            this.addCriterion("name <", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            this.addCriterion("name <=", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameLike(String value) {
            this.addCriterion("name like", value, "name");
            return (Criteria)this;
        }

        public Criteria andNameNotLike(String value) {
            this.addCriterion("name not like", value, "name");
            return (Criteria)this;
        }        public Criteria andNameIn(List<String> values) {
            this.addCriterion("name in", values, "name");
            return (Criteria)this;
        }

        public Criteria andNameNotIn(List<String> values) {
            this.addCriterion("name not in", values, "name");
            return (Criteria)this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            this.addCriterion("name between", value1, value2, "name");
            return (Criteria)this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            this.addCriterion("name not between", value1, value2, "name");
            return (Criteria)this;
        }

        public Criteria andTelephoneIsNull() {
            this.addCriterion("telephone is null");
            return (Criteria)this;
        }

        public Criteria andTelephoneIsNotNull() {
            this.addCriterion("telephone is not null");
            return (Criteria)this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            this.addCriterion("telephone =", value, "telephone");
            return (Criteria)this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            this.addCriterion("telephone <>", value, "telephone");
            return (Criteria)this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            this.addCriterion("telephone >", value, "telephone");
            return (Criteria)this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            this.addCriterion("telephone >=", value, "telephone");
            return (Criteria)this;
        }

        public Criteria andTelephoneLessThan(String value) {
            this.addCriterion("telephone <", value, "telephone");
            return (Criteria)this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            this.addCriterion("telephone <=", value, "telephone");
            return (Criteria)this;
        }

        public Criteria andTelephoneLike(String value) {
            this.addCriterion("telephone like", value, "telephone");
            return (Criteria)this;
        }

        public Criteria andTelephoneNotLike(String value) {
            this.addCriterion("telephone not like", value, "telephone");
            return (Criteria)this;
        }        public Criteria andTelephoneIn(List<String> values) {
            this.addCriterion("telephone in", values, "telephone");
            return (Criteria)this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            this.addCriterion("telephone not in", values, "telephone");
            return (Criteria)this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            this.addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria)this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            this.addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria)this;
        }

        public Criteria andIdIsNull() {
            this.addCriterion("id is null");
            return (Criteria)this;
        }

        public Criteria andIdIsNotNull() {
            this.addCriterion("id is not null");
            return (Criteria)this;
        }

        public Criteria andIdEqualTo(Long value) {
            this.addCriterion("id =", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            this.addCriterion("id <>", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdGreaterThan(Long value) {
            this.addCriterion("id >", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("id >=", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdLessThan(Long value) {
            this.addCriterion("id <", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            this.addCriterion("id <=", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdLike(String value) {
            this.addCriterion("id like", value, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotLike(String value) {
            this.addCriterion("id not like", value, "id");
            return (Criteria)this;
        }        public Criteria andIdIn(List<Long> values) {
            this.addCriterion("id in", values, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            this.addCriterion("id not in", values, "id");
            return (Criteria)this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            this.addCriterion("id between", value1, value2, "id");
            return (Criteria)this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            this.addCriterion("id not between", value1, value2, "id");
            return (Criteria)this;
        }

        public Criteria andOidIsNull() {
            this.addCriterion("oid is null");
            return (Criteria)this;
        }

        public Criteria andOidIsNotNull() {
            this.addCriterion("oid is not null");
            return (Criteria)this;
        }

        public Criteria andOidEqualTo(Long value) {
            this.addCriterion("oid =", value, "oid");
            return (Criteria)this;
        }

        public Criteria andOidNotEqualTo(Long value) {
            this.addCriterion("oid <>", value, "oid");
            return (Criteria)this;
        }

        public Criteria andOidGreaterThan(Long value) {
            this.addCriterion("oid >", value, "oid");
            return (Criteria)this;
        }

        public Criteria andOidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("oid >=", value, "oid");
            return (Criteria)this;
        }

        public Criteria andOidLessThan(Long value) {
            this.addCriterion("oid <", value, "oid");
            return (Criteria)this;
        }

        public Criteria andOidLessThanOrEqualTo(Long value) {
            this.addCriterion("oid <=", value, "oid");
            return (Criteria)this;
        }

        public Criteria andOidLike(String value) {
            this.addCriterion("oid like", value, "oid");
            return (Criteria)this;
        }

        public Criteria andOidNotLike(String value) {
            this.addCriterion("oid not like", value, "oid");
            return (Criteria)this;
        }        public Criteria andOidIn(List<Long> values) {
            this.addCriterion("oid in", values, "oid");
            return (Criteria)this;
        }

        public Criteria andOidNotIn(List<Long> values) {
            this.addCriterion("oid not in", values, "oid");
            return (Criteria)this;
        }

        public Criteria andOidBetween(Long value1, Long value2) {
            this.addCriterion("oid between", value1, value2, "oid");
            return (Criteria)this;
        }

        public Criteria andOidNotBetween(Long value1, Long value2) {
            this.addCriterion("oid not between", value1, value2, "oid");
            return (Criteria)this;
        }

        public Criteria andZipCodeIsNull() {
            this.addCriterion("zip_code is null");
            return (Criteria)this;
        }

        public Criteria andZipCodeIsNotNull() {
            this.addCriterion("zip_code is not null");
            return (Criteria)this;
        }

        public Criteria andZipCodeEqualTo(String value) {
            this.addCriterion("zip_code =", value, "zipCode");
            return (Criteria)this;
        }

        public Criteria andZipCodeNotEqualTo(String value) {
            this.addCriterion("zip_code <>", value, "zipCode");
            return (Criteria)this;
        }

        public Criteria andZipCodeGreaterThan(String value) {
            this.addCriterion("zip_code >", value, "zipCode");
            return (Criteria)this;
        }

        public Criteria andZipCodeGreaterThanOrEqualTo(String value) {
            this.addCriterion("zip_code >=", value, "zipCode");
            return (Criteria)this;
        }

        public Criteria andZipCodeLessThan(String value) {
            this.addCriterion("zip_code <", value, "zipCode");
            return (Criteria)this;
        }

        public Criteria andZipCodeLessThanOrEqualTo(String value) {
            this.addCriterion("zip_code <=", value, "zipCode");
            return (Criteria)this;
        }

        public Criteria andZipCodeLike(String value) {
            this.addCriterion("zip_code like", value, "zipCode");
            return (Criteria)this;
        }

        public Criteria andZipCodeNotLike(String value) {
            this.addCriterion("zip_code not like", value, "zipCode");
            return (Criteria)this;
        }        public Criteria andZipCodeIn(List<String> values) {
            this.addCriterion("zip_code in", values, "zipCode");
            return (Criteria)this;
        }

        public Criteria andZipCodeNotIn(List<String> values) {
            this.addCriterion("zip_code not in", values, "zipCode");
            return (Criteria)this;
        }

        public Criteria andZipCodeBetween(String value1, String value2) {
            this.addCriterion("zip_code between", value1, value2, "zipCode");
            return (Criteria)this;
        }

        public Criteria andZipCodeNotBetween(String value1, String value2) {
            this.addCriterion("zip_code not between", value1, value2, "zipCode");
            return (Criteria)this;
        }

        public Criteria andCityIdIsNull() {
            this.addCriterion("city_id is null");
            return (Criteria)this;
        }

        public Criteria andCityIdIsNotNull() {
            this.addCriterion("city_id is not null");
            return (Criteria)this;
        }

        public Criteria andCityIdEqualTo(Long value) {
            this.addCriterion("city_id =", value, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdNotEqualTo(Long value) {
            this.addCriterion("city_id <>", value, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdGreaterThan(Long value) {
            this.addCriterion("city_id >", value, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("city_id >=", value, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdLessThan(Long value) {
            this.addCriterion("city_id <", value, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdLessThanOrEqualTo(Long value) {
            this.addCriterion("city_id <=", value, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdLike(String value) {
            this.addCriterion("city_id like", value, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdNotLike(String value) {
            this.addCriterion("city_id not like", value, "cityId");
            return (Criteria)this;
        }        public Criteria andCityIdIn(List<Long> values) {
            this.addCriterion("city_id in", values, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdNotIn(List<Long> values) {
            this.addCriterion("city_id not in", values, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdBetween(Long value1, Long value2) {
            this.addCriterion("city_id between", value1, value2, "cityId");
            return (Criteria)this;
        }

        public Criteria andCityIdNotBetween(Long value1, Long value2) {
            this.addCriterion("city_id not between", value1, value2, "cityId");
            return (Criteria)this;
        }
    }
}
