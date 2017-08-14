package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberLicenseApplyExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

    public MemberLicenseApplyExample() {
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

        public Criteria andApplyIdIsNull() {
            this.addCriterion("apply_id is null");
            return (Criteria)this;
        }

        public Criteria andApplyIdIsNotNull() {
            this.addCriterion("apply_id is not null");
            return (Criteria)this;
        }

        public Criteria andApplyIdEqualTo(Long value) {
            this.addCriterion("apply_id =", value, "applyId");
            return (Criteria)this;
        }

        public Criteria andApplyIdNotEqualTo(Long value) {
            this.addCriterion("apply_id <>", value, "applyId");
            return (Criteria)this;
        }

        public Criteria andApplyIdGreaterThan(Long value) {
            this.addCriterion("apply_id >", value, "applyId");
            return (Criteria)this;
        }

        public Criteria andApplyIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("apply_id >=", value, "applyId");
            return (Criteria)this;
        }

        public Criteria andApplyIdLessThan(Long value) {
            this.addCriterion("apply_id <", value, "applyId");
            return (Criteria)this;
        }

        public Criteria andApplyIdLessThanOrEqualTo(Long value) {
            this.addCriterion("apply_id <=", value, "applyId");
            return (Criteria)this;
        }

        public Criteria andApplyIdLike(String value) {
            this.addCriterion("apply_id like", value, "applyId");
            return (Criteria)this;
        }

        public Criteria andApplyIdNotLike(String value) {
            this.addCriterion("apply_id not like", value, "applyId");
            return (Criteria)this;
        }        public Criteria andApplyIdIn(List<Long> values) {
            this.addCriterion("apply_id in", values, "applyId");
            return (Criteria)this;
        }

        public Criteria andApplyIdNotIn(List<Long> values) {
            this.addCriterion("apply_id not in", values, "applyId");
            return (Criteria)this;
        }

        public Criteria andApplyIdBetween(Long value1, Long value2) {
            this.addCriterion("apply_id between", value1, value2, "applyId");
            return (Criteria)this;
        }

        public Criteria andApplyIdNotBetween(Long value1, Long value2) {
            this.addCriterion("apply_id not between", value1, value2, "applyId");
            return (Criteria)this;
        }

        public Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (Criteria)this;
        }

        public Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (Criteria)this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (Criteria)this;
        }        public Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (Criteria)this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria)this;
        }

        public Criteria andLicenseTypeIsNull() {
            this.addCriterion("license_type is null");
            return (Criteria)this;
        }

        public Criteria andLicenseTypeIsNotNull() {
            this.addCriterion("license_type is not null");
            return (Criteria)this;
        }

        public Criteria andLicenseTypeEqualTo(Integer value) {
            this.addCriterion("license_type =", value, "licenseType");
            return (Criteria)this;
        }

        public Criteria andLicenseTypeNotEqualTo(Integer value) {
            this.addCriterion("license_type <>", value, "licenseType");
            return (Criteria)this;
        }

        public Criteria andLicenseTypeGreaterThan(Integer value) {
            this.addCriterion("license_type >", value, "licenseType");
            return (Criteria)this;
        }

        public Criteria andLicenseTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("license_type >=", value, "licenseType");
            return (Criteria)this;
        }

        public Criteria andLicenseTypeLessThan(Integer value) {
            this.addCriterion("license_type <", value, "licenseType");
            return (Criteria)this;
        }

        public Criteria andLicenseTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("license_type <=", value, "licenseType");
            return (Criteria)this;
        }

        public Criteria andLicenseTypeLike(String value) {
            this.addCriterion("license_type like", value, "licenseType");
            return (Criteria)this;
        }

        public Criteria andLicenseTypeNotLike(String value) {
            this.addCriterion("license_type not like", value, "licenseType");
            return (Criteria)this;
        }        public Criteria andLicenseTypeIn(List<Integer> values) {
            this.addCriterion("license_type in", values, "licenseType");
            return (Criteria)this;
        }

        public Criteria andLicenseTypeNotIn(List<Integer> values) {
            this.addCriterion("license_type not in", values, "licenseType");
            return (Criteria)this;
        }

        public Criteria andLicenseTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("license_type between", value1, value2, "licenseType");
            return (Criteria)this;
        }

        public Criteria andLicenseTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("license_type not between", value1, value2, "licenseType");
            return (Criteria)this;
        }

        public Criteria andContextIsNull() {
            this.addCriterion("context is null");
            return (Criteria)this;
        }

        public Criteria andContextIsNotNull() {
            this.addCriterion("context is not null");
            return (Criteria)this;
        }

        public Criteria andContextEqualTo(String value) {
            this.addCriterion("context =", value, "context");
            return (Criteria)this;
        }

        public Criteria andContextNotEqualTo(String value) {
            this.addCriterion("context <>", value, "context");
            return (Criteria)this;
        }

        public Criteria andContextGreaterThan(String value) {
            this.addCriterion("context >", value, "context");
            return (Criteria)this;
        }

        public Criteria andContextGreaterThanOrEqualTo(String value) {
            this.addCriterion("context >=", value, "context");
            return (Criteria)this;
        }

        public Criteria andContextLessThan(String value) {
            this.addCriterion("context <", value, "context");
            return (Criteria)this;
        }

        public Criteria andContextLessThanOrEqualTo(String value) {
            this.addCriterion("context <=", value, "context");
            return (Criteria)this;
        }

        public Criteria andContextLike(String value) {
            this.addCriterion("context like", value, "context");
            return (Criteria)this;
        }

        public Criteria andContextNotLike(String value) {
            this.addCriterion("context not like", value, "context");
            return (Criteria)this;
        }        public Criteria andContextIn(List<String> values) {
            this.addCriterion("context in", values, "context");
            return (Criteria)this;
        }

        public Criteria andContextNotIn(List<String> values) {
            this.addCriterion("context not in", values, "context");
            return (Criteria)this;
        }

        public Criteria andContextBetween(String value1, String value2) {
            this.addCriterion("context between", value1, value2, "context");
            return (Criteria)this;
        }

        public Criteria andContextNotBetween(String value1, String value2) {
            this.addCriterion("context not between", value1, value2, "context");
            return (Criteria)this;
        }

        public Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (Criteria)this;
        }

        public Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (Criteria)this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (Criteria)this;
        }        public Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria)this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria)this;
        }

        public Criteria andApplyStatusIsNull() {
            this.addCriterion("apply_status is null");
            return (Criteria)this;
        }

        public Criteria andApplyStatusIsNotNull() {
            this.addCriterion("apply_status is not null");
            return (Criteria)this;
        }

        public Criteria andApplyStatusEqualTo(Integer value) {
            this.addCriterion("apply_status =", value, "applyStatus");
            return (Criteria)this;
        }

        public Criteria andApplyStatusNotEqualTo(Integer value) {
            this.addCriterion("apply_status <>", value, "applyStatus");
            return (Criteria)this;
        }

        public Criteria andApplyStatusGreaterThan(Integer value) {
            this.addCriterion("apply_status >", value, "applyStatus");
            return (Criteria)this;
        }

        public Criteria andApplyStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("apply_status >=", value, "applyStatus");
            return (Criteria)this;
        }

        public Criteria andApplyStatusLessThan(Integer value) {
            this.addCriterion("apply_status <", value, "applyStatus");
            return (Criteria)this;
        }

        public Criteria andApplyStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("apply_status <=", value, "applyStatus");
            return (Criteria)this;
        }

        public Criteria andApplyStatusLike(String value) {
            this.addCriterion("apply_status like", value, "applyStatus");
            return (Criteria)this;
        }

        public Criteria andApplyStatusNotLike(String value) {
            this.addCriterion("apply_status not like", value, "applyStatus");
            return (Criteria)this;
        }        public Criteria andApplyStatusIn(List<Integer> values) {
            this.addCriterion("apply_status in", values, "applyStatus");
            return (Criteria)this;
        }

        public Criteria andApplyStatusNotIn(List<Integer> values) {
            this.addCriterion("apply_status not in", values, "applyStatus");
            return (Criteria)this;
        }

        public Criteria andApplyStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("apply_status between", value1, value2, "applyStatus");
            return (Criteria)this;
        }

        public Criteria andApplyStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("apply_status not between", value1, value2, "applyStatus");
            return (Criteria)this;
        }

        public Criteria andReasonIsNull() {
            this.addCriterion("reason is null");
            return (Criteria)this;
        }

        public Criteria andReasonIsNotNull() {
            this.addCriterion("reason is not null");
            return (Criteria)this;
        }

        public Criteria andReasonEqualTo(String value) {
            this.addCriterion("reason =", value, "reason");
            return (Criteria)this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            this.addCriterion("reason <>", value, "reason");
            return (Criteria)this;
        }

        public Criteria andReasonGreaterThan(String value) {
            this.addCriterion("reason >", value, "reason");
            return (Criteria)this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            this.addCriterion("reason >=", value, "reason");
            return (Criteria)this;
        }

        public Criteria andReasonLessThan(String value) {
            this.addCriterion("reason <", value, "reason");
            return (Criteria)this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            this.addCriterion("reason <=", value, "reason");
            return (Criteria)this;
        }

        public Criteria andReasonLike(String value) {
            this.addCriterion("reason like", value, "reason");
            return (Criteria)this;
        }

        public Criteria andReasonNotLike(String value) {
            this.addCriterion("reason not like", value, "reason");
            return (Criteria)this;
        }        public Criteria andReasonIn(List<String> values) {
            this.addCriterion("reason in", values, "reason");
            return (Criteria)this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            this.addCriterion("reason not in", values, "reason");
            return (Criteria)this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            this.addCriterion("reason between", value1, value2, "reason");
            return (Criteria)this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            this.addCriterion("reason not between", value1, value2, "reason");
            return (Criteria)this;
        }
    }
}
