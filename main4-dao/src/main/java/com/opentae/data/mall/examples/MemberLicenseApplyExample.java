package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class MemberLicenseApplyExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<MemberLicenseApplyExample.Criteria> oredCriteria = new ArrayList();

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

    public List<MemberLicenseApplyExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(MemberLicenseApplyExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public MemberLicenseApplyExample.Criteria or() {
        MemberLicenseApplyExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public MemberLicenseApplyExample.Criteria createCriteria() {
        MemberLicenseApplyExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected MemberLicenseApplyExample.Criteria createCriteriaInternal() {
        MemberLicenseApplyExample.Criteria criteria = new MemberLicenseApplyExample.Criteria();
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

    public static class Criteria extends MemberLicenseApplyExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<MemberLicenseApplyExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<MemberLicenseApplyExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<MemberLicenseApplyExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new MemberLicenseApplyExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new MemberLicenseApplyExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new MemberLicenseApplyExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public MemberLicenseApplyExample.Criteria andApplyIdIsNull() {
            this.addCriterion("apply_id is null");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyIdIsNotNull() {
            this.addCriterion("apply_id is not null");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyIdEqualTo(Long value) {
            this.addCriterion("apply_id =", value, "applyId");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyIdNotEqualTo(Long value) {
            this.addCriterion("apply_id <>", value, "applyId");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyIdGreaterThan(Long value) {
            this.addCriterion("apply_id >", value, "applyId");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("apply_id >=", value, "applyId");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyIdLessThan(Long value) {
            this.addCriterion("apply_id <", value, "applyId");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyIdLessThanOrEqualTo(Long value) {
            this.addCriterion("apply_id <=", value, "applyId");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyIdLike(String value) {
            this.addCriterion("apply_id like", value, "applyId");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyIdNotLike(String value) {
            this.addCriterion("apply_id not like", value, "applyId");
            return (MemberLicenseApplyExample.Criteria)this;
        }        public MemberLicenseApplyExample.Criteria andApplyIdIn(List<Long> values) {
            this.addCriterion("apply_id in", values, "applyId");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyIdNotIn(List<Long> values) {
            this.addCriterion("apply_id not in", values, "applyId");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyIdBetween(Long value1, Long value2) {
            this.addCriterion("apply_id between", value1, value2, "applyId");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyIdNotBetween(Long value1, Long value2) {
            this.addCriterion("apply_id not between", value1, value2, "applyId");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (MemberLicenseApplyExample.Criteria)this;
        }        public MemberLicenseApplyExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andLicenseTypeIsNull() {
            this.addCriterion("license_type is null");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andLicenseTypeIsNotNull() {
            this.addCriterion("license_type is not null");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andLicenseTypeEqualTo(Integer value) {
            this.addCriterion("license_type =", value, "licenseType");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andLicenseTypeNotEqualTo(Integer value) {
            this.addCriterion("license_type <>", value, "licenseType");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andLicenseTypeGreaterThan(Integer value) {
            this.addCriterion("license_type >", value, "licenseType");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andLicenseTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("license_type >=", value, "licenseType");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andLicenseTypeLessThan(Integer value) {
            this.addCriterion("license_type <", value, "licenseType");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andLicenseTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("license_type <=", value, "licenseType");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andLicenseTypeLike(String value) {
            this.addCriterion("license_type like", value, "licenseType");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andLicenseTypeNotLike(String value) {
            this.addCriterion("license_type not like", value, "licenseType");
            return (MemberLicenseApplyExample.Criteria)this;
        }        public MemberLicenseApplyExample.Criteria andLicenseTypeIn(List<Integer> values) {
            this.addCriterion("license_type in", values, "licenseType");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andLicenseTypeNotIn(List<Integer> values) {
            this.addCriterion("license_type not in", values, "licenseType");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andLicenseTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("license_type between", value1, value2, "licenseType");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andLicenseTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("license_type not between", value1, value2, "licenseType");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andContextIsNull() {
            this.addCriterion("context is null");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andContextIsNotNull() {
            this.addCriterion("context is not null");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andContextEqualTo(String value) {
            this.addCriterion("context =", value, "context");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andContextNotEqualTo(String value) {
            this.addCriterion("context <>", value, "context");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andContextGreaterThan(String value) {
            this.addCriterion("context >", value, "context");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andContextGreaterThanOrEqualTo(String value) {
            this.addCriterion("context >=", value, "context");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andContextLessThan(String value) {
            this.addCriterion("context <", value, "context");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andContextLessThanOrEqualTo(String value) {
            this.addCriterion("context <=", value, "context");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andContextLike(String value) {
            this.addCriterion("context like", value, "context");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andContextNotLike(String value) {
            this.addCriterion("context not like", value, "context");
            return (MemberLicenseApplyExample.Criteria)this;
        }        public MemberLicenseApplyExample.Criteria andContextIn(List<String> values) {
            this.addCriterion("context in", values, "context");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andContextNotIn(List<String> values) {
            this.addCriterion("context not in", values, "context");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andContextBetween(String value1, String value2) {
            this.addCriterion("context between", value1, value2, "context");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andContextNotBetween(String value1, String value2) {
            this.addCriterion("context not between", value1, value2, "context");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (MemberLicenseApplyExample.Criteria)this;
        }        public MemberLicenseApplyExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyStatusIsNull() {
            this.addCriterion("apply_status is null");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyStatusIsNotNull() {
            this.addCriterion("apply_status is not null");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyStatusEqualTo(Integer value) {
            this.addCriterion("apply_status =", value, "applyStatus");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyStatusNotEqualTo(Integer value) {
            this.addCriterion("apply_status <>", value, "applyStatus");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyStatusGreaterThan(Integer value) {
            this.addCriterion("apply_status >", value, "applyStatus");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("apply_status >=", value, "applyStatus");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyStatusLessThan(Integer value) {
            this.addCriterion("apply_status <", value, "applyStatus");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("apply_status <=", value, "applyStatus");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyStatusLike(String value) {
            this.addCriterion("apply_status like", value, "applyStatus");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyStatusNotLike(String value) {
            this.addCriterion("apply_status not like", value, "applyStatus");
            return (MemberLicenseApplyExample.Criteria)this;
        }        public MemberLicenseApplyExample.Criteria andApplyStatusIn(List<Integer> values) {
            this.addCriterion("apply_status in", values, "applyStatus");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyStatusNotIn(List<Integer> values) {
            this.addCriterion("apply_status not in", values, "applyStatus");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("apply_status between", value1, value2, "applyStatus");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andApplyStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("apply_status not between", value1, value2, "applyStatus");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andReasonIsNull() {
            this.addCriterion("reason is null");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andReasonIsNotNull() {
            this.addCriterion("reason is not null");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andReasonEqualTo(String value) {
            this.addCriterion("reason =", value, "reason");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andReasonNotEqualTo(String value) {
            this.addCriterion("reason <>", value, "reason");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andReasonGreaterThan(String value) {
            this.addCriterion("reason >", value, "reason");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andReasonGreaterThanOrEqualTo(String value) {
            this.addCriterion("reason >=", value, "reason");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andReasonLessThan(String value) {
            this.addCriterion("reason <", value, "reason");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andReasonLessThanOrEqualTo(String value) {
            this.addCriterion("reason <=", value, "reason");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andReasonLike(String value) {
            this.addCriterion("reason like", value, "reason");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andReasonNotLike(String value) {
            this.addCriterion("reason not like", value, "reason");
            return (MemberLicenseApplyExample.Criteria)this;
        }        public MemberLicenseApplyExample.Criteria andReasonIn(List<String> values) {
            this.addCriterion("reason in", values, "reason");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andReasonNotIn(List<String> values) {
            this.addCriterion("reason not in", values, "reason");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andReasonBetween(String value1, String value2) {
            this.addCriterion("reason between", value1, value2, "reason");
            return (MemberLicenseApplyExample.Criteria)this;
        }

        public MemberLicenseApplyExample.Criteria andReasonNotBetween(String value1, String value2) {
            this.addCriterion("reason not between", value1, value2, "reason");
            return (MemberLicenseApplyExample.Criteria)this;
        }
    }
}
