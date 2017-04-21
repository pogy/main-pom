package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class MemberLicenseExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<MemberLicenseExample.Criteria> oredCriteria = new ArrayList();

    public MemberLicenseExample() {
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

    public List<MemberLicenseExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(MemberLicenseExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public MemberLicenseExample.Criteria or() {
        MemberLicenseExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public MemberLicenseExample.Criteria createCriteria() {
        MemberLicenseExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected MemberLicenseExample.Criteria createCriteriaInternal() {
        MemberLicenseExample.Criteria criteria = new MemberLicenseExample.Criteria();
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

    public static class Criteria extends MemberLicenseExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<MemberLicenseExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<MemberLicenseExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<MemberLicenseExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new MemberLicenseExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new MemberLicenseExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new MemberLicenseExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public MemberLicenseExample.Criteria andUserLicenseIdIsNull() {
            this.addCriterion("user_license_id is null");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserLicenseIdIsNotNull() {
            this.addCriterion("user_license_id is not null");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserLicenseIdEqualTo(Long value) {
            this.addCriterion("user_license_id =", value, "userLicenseId");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserLicenseIdNotEqualTo(Long value) {
            this.addCriterion("user_license_id <>", value, "userLicenseId");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserLicenseIdGreaterThan(Long value) {
            this.addCriterion("user_license_id >", value, "userLicenseId");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserLicenseIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_license_id >=", value, "userLicenseId");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserLicenseIdLessThan(Long value) {
            this.addCriterion("user_license_id <", value, "userLicenseId");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserLicenseIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_license_id <=", value, "userLicenseId");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserLicenseIdLike(String value) {
            this.addCriterion("user_license_id like", value, "userLicenseId");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserLicenseIdNotLike(String value) {
            this.addCriterion("user_license_id not like", value, "userLicenseId");
            return (MemberLicenseExample.Criteria)this;
        }        public MemberLicenseExample.Criteria andUserLicenseIdIn(List<Long> values) {
            this.addCriterion("user_license_id in", values, "userLicenseId");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserLicenseIdNotIn(List<Long> values) {
            this.addCriterion("user_license_id not in", values, "userLicenseId");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserLicenseIdBetween(Long value1, Long value2) {
            this.addCriterion("user_license_id between", value1, value2, "userLicenseId");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserLicenseIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_license_id not between", value1, value2, "userLicenseId");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (MemberLicenseExample.Criteria)this;
        }        public MemberLicenseExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseTypeIsNull() {
            this.addCriterion("license_type is null");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseTypeIsNotNull() {
            this.addCriterion("license_type is not null");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseTypeEqualTo(Integer value) {
            this.addCriterion("license_type =", value, "licenseType");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseTypeNotEqualTo(Integer value) {
            this.addCriterion("license_type <>", value, "licenseType");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseTypeGreaterThan(Integer value) {
            this.addCriterion("license_type >", value, "licenseType");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("license_type >=", value, "licenseType");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseTypeLessThan(Integer value) {
            this.addCriterion("license_type <", value, "licenseType");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("license_type <=", value, "licenseType");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseTypeLike(String value) {
            this.addCriterion("license_type like", value, "licenseType");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseTypeNotLike(String value) {
            this.addCriterion("license_type not like", value, "licenseType");
            return (MemberLicenseExample.Criteria)this;
        }        public MemberLicenseExample.Criteria andLicenseTypeIn(List<Integer> values) {
            this.addCriterion("license_type in", values, "licenseType");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseTypeNotIn(List<Integer> values) {
            this.addCriterion("license_type not in", values, "licenseType");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("license_type between", value1, value2, "licenseType");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("license_type not between", value1, value2, "licenseType");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andContextIsNull() {
            this.addCriterion("context is null");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andContextIsNotNull() {
            this.addCriterion("context is not null");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andContextEqualTo(String value) {
            this.addCriterion("context =", value, "context");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andContextNotEqualTo(String value) {
            this.addCriterion("context <>", value, "context");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andContextGreaterThan(String value) {
            this.addCriterion("context >", value, "context");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andContextGreaterThanOrEqualTo(String value) {
            this.addCriterion("context >=", value, "context");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andContextLessThan(String value) {
            this.addCriterion("context <", value, "context");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andContextLessThanOrEqualTo(String value) {
            this.addCriterion("context <=", value, "context");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andContextLike(String value) {
            this.addCriterion("context like", value, "context");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andContextNotLike(String value) {
            this.addCriterion("context not like", value, "context");
            return (MemberLicenseExample.Criteria)this;
        }        public MemberLicenseExample.Criteria andContextIn(List<String> values) {
            this.addCriterion("context in", values, "context");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andContextNotIn(List<String> values) {
            this.addCriterion("context not in", values, "context");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andContextBetween(String value1, String value2) {
            this.addCriterion("context between", value1, value2, "context");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andContextNotBetween(String value1, String value2) {
            this.addCriterion("context not between", value1, value2, "context");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseFailureIsNull() {
            this.addCriterion("license_failure is null");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseFailureIsNotNull() {
            this.addCriterion("license_failure is not null");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseFailureEqualTo(Integer value) {
            this.addCriterion("license_failure =", value, "licenseFailure");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseFailureNotEqualTo(Integer value) {
            this.addCriterion("license_failure <>", value, "licenseFailure");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseFailureGreaterThan(Integer value) {
            this.addCriterion("license_failure >", value, "licenseFailure");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseFailureGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("license_failure >=", value, "licenseFailure");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseFailureLessThan(Integer value) {
            this.addCriterion("license_failure <", value, "licenseFailure");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseFailureLessThanOrEqualTo(Integer value) {
            this.addCriterion("license_failure <=", value, "licenseFailure");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseFailureLike(String value) {
            this.addCriterion("license_failure like", value, "licenseFailure");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseFailureNotLike(String value) {
            this.addCriterion("license_failure not like", value, "licenseFailure");
            return (MemberLicenseExample.Criteria)this;
        }        public MemberLicenseExample.Criteria andLicenseFailureIn(List<Integer> values) {
            this.addCriterion("license_failure in", values, "licenseFailure");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseFailureNotIn(List<Integer> values) {
            this.addCriterion("license_failure not in", values, "licenseFailure");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseFailureBetween(Integer value1, Integer value2) {
            this.addCriterion("license_failure between", value1, value2, "licenseFailure");
            return (MemberLicenseExample.Criteria)this;
        }

        public MemberLicenseExample.Criteria andLicenseFailureNotBetween(Integer value1, Integer value2) {
            this.addCriterion("license_failure not between", value1, value2, "licenseFailure");
            return (MemberLicenseExample.Criteria)this;
        }
    }
}
