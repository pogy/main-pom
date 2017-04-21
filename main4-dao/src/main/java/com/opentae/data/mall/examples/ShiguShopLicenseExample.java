package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShiguShopLicenseExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguShopLicenseExample.Criteria> oredCriteria = new ArrayList();

    public ShiguShopLicenseExample() {
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

    public List<ShiguShopLicenseExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguShopLicenseExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguShopLicenseExample.Criteria or() {
        ShiguShopLicenseExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguShopLicenseExample.Criteria createCriteria() {
        ShiguShopLicenseExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguShopLicenseExample.Criteria createCriteriaInternal() {
        ShiguShopLicenseExample.Criteria criteria = new ShiguShopLicenseExample.Criteria();
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

    public static class Criteria extends ShiguShopLicenseExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguShopLicenseExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguShopLicenseExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguShopLicenseExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguShopLicenseExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguShopLicenseExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguShopLicenseExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguShopLicenseExample.Criteria andLicenseIdIsNull() {
            this.addCriterion("license_id is null");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseIdIsNotNull() {
            this.addCriterion("license_id is not null");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseIdEqualTo(Long value) {
            this.addCriterion("license_id =", value, "licenseId");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseIdNotEqualTo(Long value) {
            this.addCriterion("license_id <>", value, "licenseId");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseIdGreaterThan(Long value) {
            this.addCriterion("license_id >", value, "licenseId");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("license_id >=", value, "licenseId");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseIdLessThan(Long value) {
            this.addCriterion("license_id <", value, "licenseId");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseIdLessThanOrEqualTo(Long value) {
            this.addCriterion("license_id <=", value, "licenseId");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseIdLike(String value) {
            this.addCriterion("license_id like", value, "licenseId");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseIdNotLike(String value) {
            this.addCriterion("license_id not like", value, "licenseId");
            return (ShiguShopLicenseExample.Criteria)this;
        }        public ShiguShopLicenseExample.Criteria andLicenseIdIn(List<Long> values) {
            this.addCriterion("license_id in", values, "licenseId");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseIdNotIn(List<Long> values) {
            this.addCriterion("license_id not in", values, "licenseId");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseIdBetween(Long value1, Long value2) {
            this.addCriterion("license_id between", value1, value2, "licenseId");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseIdNotBetween(Long value1, Long value2) {
            this.addCriterion("license_id not between", value1, value2, "licenseId");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andShopIdIsNull() {
            this.addCriterion("shop_id is null");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andShopIdIsNotNull() {
            this.addCriterion("shop_id is not null");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andShopIdEqualTo(Long value) {
            this.addCriterion("shop_id =", value, "shopId");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andShopIdNotEqualTo(Long value) {
            this.addCriterion("shop_id <>", value, "shopId");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andShopIdGreaterThan(Long value) {
            this.addCriterion("shop_id >", value, "shopId");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("shop_id >=", value, "shopId");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andShopIdLessThan(Long value) {
            this.addCriterion("shop_id <", value, "shopId");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            this.addCriterion("shop_id <=", value, "shopId");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andShopIdLike(String value) {
            this.addCriterion("shop_id like", value, "shopId");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andShopIdNotLike(String value) {
            this.addCriterion("shop_id not like", value, "shopId");
            return (ShiguShopLicenseExample.Criteria)this;
        }        public ShiguShopLicenseExample.Criteria andShopIdIn(List<Long> values) {
            this.addCriterion("shop_id in", values, "shopId");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andShopIdNotIn(List<Long> values) {
            this.addCriterion("shop_id not in", values, "shopId");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andShopIdBetween(Long value1, Long value2) {
            this.addCriterion("shop_id between", value1, value2, "shopId");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            this.addCriterion("shop_id not between", value1, value2, "shopId");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeIsNull() {
            this.addCriterion("license_type is null");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeIsNotNull() {
            this.addCriterion("license_type is not null");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeEqualTo(Integer value) {
            this.addCriterion("license_type =", value, "licenseType");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeNotEqualTo(Integer value) {
            this.addCriterion("license_type <>", value, "licenseType");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeGreaterThan(Integer value) {
            this.addCriterion("license_type >", value, "licenseType");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("license_type >=", value, "licenseType");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeLessThan(Integer value) {
            this.addCriterion("license_type <", value, "licenseType");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("license_type <=", value, "licenseType");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeLike(String value) {
            this.addCriterion("license_type like", value, "licenseType");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeNotLike(String value) {
            this.addCriterion("license_type not like", value, "licenseType");
            return (ShiguShopLicenseExample.Criteria)this;
        }        public ShiguShopLicenseExample.Criteria andLicenseTypeIn(List<Integer> values) {
            this.addCriterion("license_type in", values, "licenseType");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeNotIn(List<Integer> values) {
            this.addCriterion("license_type not in", values, "licenseType");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("license_type between", value1, value2, "licenseType");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("license_type not between", value1, value2, "licenseType");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andContextIsNull() {
            this.addCriterion("context is null");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andContextIsNotNull() {
            this.addCriterion("context is not null");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andContextEqualTo(String value) {
            this.addCriterion("context =", value, "context");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andContextNotEqualTo(String value) {
            this.addCriterion("context <>", value, "context");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andContextGreaterThan(String value) {
            this.addCriterion("context >", value, "context");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andContextGreaterThanOrEqualTo(String value) {
            this.addCriterion("context >=", value, "context");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andContextLessThan(String value) {
            this.addCriterion("context <", value, "context");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andContextLessThanOrEqualTo(String value) {
            this.addCriterion("context <=", value, "context");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andContextLike(String value) {
            this.addCriterion("context like", value, "context");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andContextNotLike(String value) {
            this.addCriterion("context not like", value, "context");
            return (ShiguShopLicenseExample.Criteria)this;
        }        public ShiguShopLicenseExample.Criteria andContextIn(List<String> values) {
            this.addCriterion("context in", values, "context");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andContextNotIn(List<String> values) {
            this.addCriterion("context not in", values, "context");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andContextBetween(String value1, String value2) {
            this.addCriterion("context between", value1, value2, "context");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andContextNotBetween(String value1, String value2) {
            this.addCriterion("context not between", value1, value2, "context");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseFailureIsNull() {
            this.addCriterion("license_failure is null");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseFailureIsNotNull() {
            this.addCriterion("license_failure is not null");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseFailureEqualTo(Integer value) {
            this.addCriterion("license_failure =", value, "licenseFailure");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseFailureNotEqualTo(Integer value) {
            this.addCriterion("license_failure <>", value, "licenseFailure");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseFailureGreaterThan(Integer value) {
            this.addCriterion("license_failure >", value, "licenseFailure");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseFailureGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("license_failure >=", value, "licenseFailure");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseFailureLessThan(Integer value) {
            this.addCriterion("license_failure <", value, "licenseFailure");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseFailureLessThanOrEqualTo(Integer value) {
            this.addCriterion("license_failure <=", value, "licenseFailure");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseFailureLike(String value) {
            this.addCriterion("license_failure like", value, "licenseFailure");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseFailureNotLike(String value) {
            this.addCriterion("license_failure not like", value, "licenseFailure");
            return (ShiguShopLicenseExample.Criteria)this;
        }        public ShiguShopLicenseExample.Criteria andLicenseFailureIn(List<Integer> values) {
            this.addCriterion("license_failure in", values, "licenseFailure");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseFailureNotIn(List<Integer> values) {
            this.addCriterion("license_failure not in", values, "licenseFailure");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseFailureBetween(Integer value1, Integer value2) {
            this.addCriterion("license_failure between", value1, value2, "licenseFailure");
            return (ShiguShopLicenseExample.Criteria)this;
        }

        public ShiguShopLicenseExample.Criteria andLicenseFailureNotBetween(Integer value1, Integer value2) {
            this.addCriterion("license_failure not between", value1, value2, "licenseFailure");
            return (ShiguShopLicenseExample.Criteria)this;
        }
    }
}
