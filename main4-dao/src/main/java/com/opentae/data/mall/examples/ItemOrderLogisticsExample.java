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

        public ItemOrderLogisticsExample.Criteria andCourierNumberIsNull() {
            this.addCriterion("courierNumber is null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberIsNotNull() {
            this.addCriterion("courierNumber is not null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberEqualTo(String value) {
            this.addCriterion("courierNumber =", value, "courier_number");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberNotEqualTo(String value) {
            this.addCriterion("courierNumber <>", value, "courier_number");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberGreaterThan(String value) {
            this.addCriterion("courierNumber >", value, "courier_number");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberGreaterThanOrEqualTo(String value) {
            this.addCriterion("courierNumber >=", value, "courier_number");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberLessThan(String value) {
            this.addCriterion("courierNumber <", value, "courier_number");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberLessThanOrEqualTo(String value) {
            this.addCriterion("courierNumber <=", value, "courier_number");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberLike(String value) {
            this.addCriterion("courierNumber like", value, "courier_number");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberNotLike(String value) {
            this.addCriterion("courierNumber not like", value, "courier_number");
            return (ItemOrderLogisticsExample.Criteria)this;
        }        public ItemOrderLogisticsExample.Criteria andCourierNumberIn(List<String> values) {
            this.addCriterion("courierNumber in", values, "courier_number");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberNotIn(List<String> values) {
            this.addCriterion("courierNumber not in", values, "courier_number");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberBetween(String value1, String value2) {
            this.addCriterion("courierNumber between", value1, value2, "courier_number");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCourierNumberNotBetween(String value1, String value2) {
            this.addCriterion("courierNumber not between", value1, value2, "courier_number");
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

        public ItemOrderLogisticsExample.Criteria andCompanyIdIsNull() {
            this.addCriterion("companyId is null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdIsNotNull() {
            this.addCriterion("companyId is not null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdEqualTo(Long value) {
            this.addCriterion("companyId =", value, "company_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdNotEqualTo(Long value) {
            this.addCriterion("companyId <>", value, "company_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdGreaterThan(Long value) {
            this.addCriterion("companyId >", value, "company_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("companyId >=", value, "company_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdLessThan(Long value) {
            this.addCriterion("companyId <", value, "company_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdLessThanOrEqualTo(Long value) {
            this.addCriterion("companyId <=", value, "company_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdLike(String value) {
            this.addCriterion("companyId like", value, "company_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdNotLike(String value) {
            this.addCriterion("companyId not like", value, "company_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }        public ItemOrderLogisticsExample.Criteria andCompanyIdIn(List<Long> values) {
            this.addCriterion("companyId in", values, "company_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdNotIn(List<Long> values) {
            this.addCriterion("companyId not in", values, "company_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdBetween(Long value1, Long value2) {
            this.addCriterion("companyId between", value1, value2, "company_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCompanyIdNotBetween(Long value1, Long value2) {
            this.addCriterion("companyId not between", value1, value2, "company_id");
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

        public ItemOrderLogisticsExample.Criteria andProvIdIsNull() {
            this.addCriterion("provId is null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdIsNotNull() {
            this.addCriterion("provId is not null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdEqualTo(Long value) {
            this.addCriterion("provId =", value, "prov_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdNotEqualTo(Long value) {
            this.addCriterion("provId <>", value, "prov_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdGreaterThan(Long value) {
            this.addCriterion("provId >", value, "prov_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("provId >=", value, "prov_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdLessThan(Long value) {
            this.addCriterion("provId <", value, "prov_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdLessThanOrEqualTo(Long value) {
            this.addCriterion("provId <=", value, "prov_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdLike(String value) {
            this.addCriterion("provId like", value, "prov_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdNotLike(String value) {
            this.addCriterion("provId not like", value, "prov_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }        public ItemOrderLogisticsExample.Criteria andProvIdIn(List<Long> values) {
            this.addCriterion("provId in", values, "prov_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdNotIn(List<Long> values) {
            this.addCriterion("provId not in", values, "prov_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdBetween(Long value1, Long value2) {
            this.addCriterion("provId between", value1, value2, "prov_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andProvIdNotBetween(Long value1, Long value2) {
            this.addCriterion("provId not between", value1, value2, "prov_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdIsNull() {
            this.addCriterion("townId is null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdIsNotNull() {
            this.addCriterion("townId is not null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdEqualTo(Long value) {
            this.addCriterion("townId =", value, "town_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdNotEqualTo(Long value) {
            this.addCriterion("townId <>", value, "town_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdGreaterThan(Long value) {
            this.addCriterion("townId >", value, "town_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("townId >=", value, "town_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdLessThan(Long value) {
            this.addCriterion("townId <", value, "town_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdLessThanOrEqualTo(Long value) {
            this.addCriterion("townId <=", value, "town_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdLike(String value) {
            this.addCriterion("townId like", value, "town_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdNotLike(String value) {
            this.addCriterion("townId not like", value, "town_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }        public ItemOrderLogisticsExample.Criteria andTownIdIn(List<Long> values) {
            this.addCriterion("townId in", values, "town_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdNotIn(List<Long> values) {
            this.addCriterion("townId not in", values, "town_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdBetween(Long value1, Long value2) {
            this.addCriterion("townId between", value1, value2, "town_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andTownIdNotBetween(Long value1, Long value2) {
            this.addCriterion("townId not between", value1, value2, "town_id");
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

        public ItemOrderLogisticsExample.Criteria andZipCodeIsNull() {
            this.addCriterion("zipCode is null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeIsNotNull() {
            this.addCriterion("zipCode is not null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeEqualTo(String value) {
            this.addCriterion("zipCode =", value, "zip_code");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeNotEqualTo(String value) {
            this.addCriterion("zipCode <>", value, "zip_code");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeGreaterThan(String value) {
            this.addCriterion("zipCode >", value, "zip_code");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeGreaterThanOrEqualTo(String value) {
            this.addCriterion("zipCode >=", value, "zip_code");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeLessThan(String value) {
            this.addCriterion("zipCode <", value, "zip_code");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeLessThanOrEqualTo(String value) {
            this.addCriterion("zipCode <=", value, "zip_code");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeLike(String value) {
            this.addCriterion("zipCode like", value, "zip_code");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeNotLike(String value) {
            this.addCriterion("zipCode not like", value, "zip_code");
            return (ItemOrderLogisticsExample.Criteria)this;
        }        public ItemOrderLogisticsExample.Criteria andZipCodeIn(List<String> values) {
            this.addCriterion("zipCode in", values, "zip_code");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeNotIn(List<String> values) {
            this.addCriterion("zipCode not in", values, "zip_code");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeBetween(String value1, String value2) {
            this.addCriterion("zipCode between", value1, value2, "zip_code");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andZipCodeNotBetween(String value1, String value2) {
            this.addCriterion("zipCode not between", value1, value2, "zip_code");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdIsNull() {
            this.addCriterion("cityId is null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdIsNotNull() {
            this.addCriterion("cityId is not null");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdEqualTo(Long value) {
            this.addCriterion("cityId =", value, "city_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdNotEqualTo(Long value) {
            this.addCriterion("cityId <>", value, "city_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdGreaterThan(Long value) {
            this.addCriterion("cityId >", value, "city_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("cityId >=", value, "city_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdLessThan(Long value) {
            this.addCriterion("cityId <", value, "city_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdLessThanOrEqualTo(Long value) {
            this.addCriterion("cityId <=", value, "city_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdLike(String value) {
            this.addCriterion("cityId like", value, "city_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdNotLike(String value) {
            this.addCriterion("cityId not like", value, "city_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }        public ItemOrderLogisticsExample.Criteria andCityIdIn(List<Long> values) {
            this.addCriterion("cityId in", values, "city_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdNotIn(List<Long> values) {
            this.addCriterion("cityId not in", values, "city_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdBetween(Long value1, Long value2) {
            this.addCriterion("cityId between", value1, value2, "city_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }

        public ItemOrderLogisticsExample.Criteria andCityIdNotBetween(Long value1, Long value2) {
            this.addCriterion("cityId not between", value1, value2, "city_id");
            return (ItemOrderLogisticsExample.Criteria)this;
        }
    }
}
