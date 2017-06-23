package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class GoatLicenseExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<GoatLicenseExample.Criteria> oredCriteria = new ArrayList();

    public GoatLicenseExample() {
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

    public List<GoatLicenseExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(GoatLicenseExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public GoatLicenseExample.Criteria or() {
        GoatLicenseExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public GoatLicenseExample.Criteria createCriteria() {
        GoatLicenseExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected GoatLicenseExample.Criteria createCriteriaInternal() {
        GoatLicenseExample.Criteria criteria = new GoatLicenseExample.Criteria();
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

    public static class Criteria extends GoatLicenseExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<GoatLicenseExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<GoatLicenseExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<GoatLicenseExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new GoatLicenseExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new GoatLicenseExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new GoatLicenseExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public GoatLicenseExample.Criteria andGoatIdIsNull() {
            this.addCriterion("goat_id is null");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andGoatIdIsNotNull() {
            this.addCriterion("goat_id is not null");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andGoatIdEqualTo(Long value) {
            this.addCriterion("goat_id =", value, "goatId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andGoatIdNotEqualTo(Long value) {
            this.addCriterion("goat_id <>", value, "goatId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andGoatIdGreaterThan(Long value) {
            this.addCriterion("goat_id >", value, "goatId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andGoatIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("goat_id >=", value, "goatId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andGoatIdLessThan(Long value) {
            this.addCriterion("goat_id <", value, "goatId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andGoatIdLessThanOrEqualTo(Long value) {
            this.addCriterion("goat_id <=", value, "goatId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andGoatIdLike(String value) {
            this.addCriterion("goat_id like", value, "goatId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andGoatIdNotLike(String value) {
            this.addCriterion("goat_id not like", value, "goatId");
            return (GoatLicenseExample.Criteria)this;
        }        public GoatLicenseExample.Criteria andGoatIdIn(List<Long> values) {
            this.addCriterion("goat_id in", values, "goatId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andGoatIdNotIn(List<Long> values) {
            this.addCriterion("goat_id not in", values, "goatId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andGoatIdBetween(Long value1, Long value2) {
            this.addCriterion("goat_id between", value1, value2, "goatId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andGoatIdNotBetween(Long value1, Long value2) {
            this.addCriterion("goat_id not between", value1, value2, "goatId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadFromTimeIsNull() {
            this.addCriterion("spread_from_time is null");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadFromTimeIsNotNull() {
            this.addCriterion("spread_from_time is not null");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadFromTimeEqualTo(Date value) {
            this.addCriterion("spread_from_time =", value, "spreadFromTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadFromTimeNotEqualTo(Date value) {
            this.addCriterion("spread_from_time <>", value, "spreadFromTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadFromTimeGreaterThan(Date value) {
            this.addCriterion("spread_from_time >", value, "spreadFromTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadFromTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("spread_from_time >=", value, "spreadFromTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadFromTimeLessThan(Date value) {
            this.addCriterion("spread_from_time <", value, "spreadFromTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadFromTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("spread_from_time <=", value, "spreadFromTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadFromTimeLike(String value) {
            this.addCriterion("spread_from_time like", value, "spreadFromTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadFromTimeNotLike(String value) {
            this.addCriterion("spread_from_time not like", value, "spreadFromTime");
            return (GoatLicenseExample.Criteria)this;
        }        public GoatLicenseExample.Criteria andSpreadFromTimeIn(List<Date> values) {
            this.addCriterion("spread_from_time in", values, "spreadFromTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadFromTimeNotIn(List<Date> values) {
            this.addCriterion("spread_from_time not in", values, "spreadFromTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadFromTimeBetween(Date value1, Date value2) {
            this.addCriterion("spread_from_time between", value1, value2, "spreadFromTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadFromTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("spread_from_time not between", value1, value2, "spreadFromTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseFromTimeIsNull() {
            this.addCriterion("license_from_time is null");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseFromTimeIsNotNull() {
            this.addCriterion("license_from_time is not null");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseFromTimeEqualTo(Date value) {
            this.addCriterion("license_from_time =", value, "licenseFromTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseFromTimeNotEqualTo(Date value) {
            this.addCriterion("license_from_time <>", value, "licenseFromTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseFromTimeGreaterThan(Date value) {
            this.addCriterion("license_from_time >", value, "licenseFromTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseFromTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("license_from_time >=", value, "licenseFromTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseFromTimeLessThan(Date value) {
            this.addCriterion("license_from_time <", value, "licenseFromTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseFromTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("license_from_time <=", value, "licenseFromTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseFromTimeLike(String value) {
            this.addCriterion("license_from_time like", value, "licenseFromTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseFromTimeNotLike(String value) {
            this.addCriterion("license_from_time not like", value, "licenseFromTime");
            return (GoatLicenseExample.Criteria)this;
        }        public GoatLicenseExample.Criteria andLicenseFromTimeIn(List<Date> values) {
            this.addCriterion("license_from_time in", values, "licenseFromTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseFromTimeNotIn(List<Date> values) {
            this.addCriterion("license_from_time not in", values, "licenseFromTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseFromTimeBetween(Date value1, Date value2) {
            this.addCriterion("license_from_time between", value1, value2, "licenseFromTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseFromTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("license_from_time not between", value1, value2, "licenseFromTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andShopIdIsNull() {
            this.addCriterion("shop_id is null");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andShopIdIsNotNull() {
            this.addCriterion("shop_id is not null");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andShopIdEqualTo(Long value) {
            this.addCriterion("shop_id =", value, "shopId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andShopIdNotEqualTo(Long value) {
            this.addCriterion("shop_id <>", value, "shopId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andShopIdGreaterThan(Long value) {
            this.addCriterion("shop_id >", value, "shopId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("shop_id >=", value, "shopId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andShopIdLessThan(Long value) {
            this.addCriterion("shop_id <", value, "shopId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            this.addCriterion("shop_id <=", value, "shopId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andShopIdLike(String value) {
            this.addCriterion("shop_id like", value, "shopId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andShopIdNotLike(String value) {
            this.addCriterion("shop_id not like", value, "shopId");
            return (GoatLicenseExample.Criteria)this;
        }        public GoatLicenseExample.Criteria andShopIdIn(List<Long> values) {
            this.addCriterion("shop_id in", values, "shopId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andShopIdNotIn(List<Long> values) {
            this.addCriterion("shop_id not in", values, "shopId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andShopIdBetween(Long value1, Long value2) {
            this.addCriterion("shop_id between", value1, value2, "shopId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            this.addCriterion("shop_id not between", value1, value2, "shopId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseToTimeIsNull() {
            this.addCriterion("license_to_time is null");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseToTimeIsNotNull() {
            this.addCriterion("license_to_time is not null");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseToTimeEqualTo(Date value) {
            this.addCriterion("license_to_time =", value, "licenseToTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseToTimeNotEqualTo(Date value) {
            this.addCriterion("license_to_time <>", value, "licenseToTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseToTimeGreaterThan(Date value) {
            this.addCriterion("license_to_time >", value, "licenseToTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseToTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("license_to_time >=", value, "licenseToTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseToTimeLessThan(Date value) {
            this.addCriterion("license_to_time <", value, "licenseToTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseToTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("license_to_time <=", value, "licenseToTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseToTimeLike(String value) {
            this.addCriterion("license_to_time like", value, "licenseToTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseToTimeNotLike(String value) {
            this.addCriterion("license_to_time not like", value, "licenseToTime");
            return (GoatLicenseExample.Criteria)this;
        }        public GoatLicenseExample.Criteria andLicenseToTimeIn(List<Date> values) {
            this.addCriterion("license_to_time in", values, "licenseToTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseToTimeNotIn(List<Date> values) {
            this.addCriterion("license_to_time not in", values, "licenseToTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseToTimeBetween(Date value1, Date value2) {
            this.addCriterion("license_to_time between", value1, value2, "licenseToTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseToTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("license_to_time not between", value1, value2, "licenseToTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseIdIsNull() {
            this.addCriterion("license_id is null");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseIdIsNotNull() {
            this.addCriterion("license_id is not null");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseIdEqualTo(Long value) {
            this.addCriterion("license_id =", value, "licenseId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseIdNotEqualTo(Long value) {
            this.addCriterion("license_id <>", value, "licenseId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseIdGreaterThan(Long value) {
            this.addCriterion("license_id >", value, "licenseId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("license_id >=", value, "licenseId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseIdLessThan(Long value) {
            this.addCriterion("license_id <", value, "licenseId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseIdLessThanOrEqualTo(Long value) {
            this.addCriterion("license_id <=", value, "licenseId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseIdLike(String value) {
            this.addCriterion("license_id like", value, "licenseId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseIdNotLike(String value) {
            this.addCriterion("license_id not like", value, "licenseId");
            return (GoatLicenseExample.Criteria)this;
        }        public GoatLicenseExample.Criteria andLicenseIdIn(List<Long> values) {
            this.addCriterion("license_id in", values, "licenseId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseIdNotIn(List<Long> values) {
            this.addCriterion("license_id not in", values, "licenseId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseIdBetween(Long value1, Long value2) {
            this.addCriterion("license_id between", value1, value2, "licenseId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andLicenseIdNotBetween(Long value1, Long value2) {
            this.addCriterion("license_id not between", value1, value2, "licenseId");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadToTimeIsNull() {
            this.addCriterion("spread_to_time is null");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadToTimeIsNotNull() {
            this.addCriterion("spread_to_time is not null");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadToTimeEqualTo(Date value) {
            this.addCriterion("spread_to_time =", value, "spreadToTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadToTimeNotEqualTo(Date value) {
            this.addCriterion("spread_to_time <>", value, "spreadToTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadToTimeGreaterThan(Date value) {
            this.addCriterion("spread_to_time >", value, "spreadToTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadToTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("spread_to_time >=", value, "spreadToTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadToTimeLessThan(Date value) {
            this.addCriterion("spread_to_time <", value, "spreadToTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadToTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("spread_to_time <=", value, "spreadToTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadToTimeLike(String value) {
            this.addCriterion("spread_to_time like", value, "spreadToTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadToTimeNotLike(String value) {
            this.addCriterion("spread_to_time not like", value, "spreadToTime");
            return (GoatLicenseExample.Criteria)this;
        }        public GoatLicenseExample.Criteria andSpreadToTimeIn(List<Date> values) {
            this.addCriterion("spread_to_time in", values, "spreadToTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadToTimeNotIn(List<Date> values) {
            this.addCriterion("spread_to_time not in", values, "spreadToTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadToTimeBetween(Date value1, Date value2) {
            this.addCriterion("spread_to_time between", value1, value2, "spreadToTime");
            return (GoatLicenseExample.Criteria)this;
        }

        public GoatLicenseExample.Criteria andSpreadToTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("spread_to_time not between", value1, value2, "spreadToTime");
            return (GoatLicenseExample.Criteria)this;
        }
    }
}
