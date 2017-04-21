package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberLoginRecordExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<MemberLoginRecordExample.Criteria> oredCriteria = new ArrayList();

    public MemberLoginRecordExample() {
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

    public List<MemberLoginRecordExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(MemberLoginRecordExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public MemberLoginRecordExample.Criteria or() {
        MemberLoginRecordExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public MemberLoginRecordExample.Criteria createCriteria() {
        MemberLoginRecordExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected MemberLoginRecordExample.Criteria createCriteriaInternal() {
        MemberLoginRecordExample.Criteria criteria = new MemberLoginRecordExample.Criteria();
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

    public static class Criteria extends MemberLoginRecordExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<MemberLoginRecordExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<MemberLoginRecordExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<MemberLoginRecordExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new MemberLoginRecordExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new MemberLoginRecordExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new MemberLoginRecordExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public MemberLoginRecordExample.Criteria andLoginRecordIdIsNull() {
            this.addCriterion("login_record_id is null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLoginRecordIdIsNotNull() {
            this.addCriterion("login_record_id is not null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLoginRecordIdEqualTo(Long value) {
            this.addCriterion("login_record_id =", value, "loginRecordId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLoginRecordIdNotEqualTo(Long value) {
            this.addCriterion("login_record_id <>", value, "loginRecordId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLoginRecordIdGreaterThan(Long value) {
            this.addCriterion("login_record_id >", value, "loginRecordId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLoginRecordIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("login_record_id >=", value, "loginRecordId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLoginRecordIdLessThan(Long value) {
            this.addCriterion("login_record_id <", value, "loginRecordId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLoginRecordIdLessThanOrEqualTo(Long value) {
            this.addCriterion("login_record_id <=", value, "loginRecordId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLoginRecordIdLike(String value) {
            this.addCriterion("login_record_id like", value, "loginRecordId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLoginRecordIdNotLike(String value) {
            this.addCriterion("login_record_id not like", value, "loginRecordId");
            return (MemberLoginRecordExample.Criteria)this;
        }        public MemberLoginRecordExample.Criteria andLoginRecordIdIn(List<Long> values) {
            this.addCriterion("login_record_id in", values, "loginRecordId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLoginRecordIdNotIn(List<Long> values) {
            this.addCriterion("login_record_id not in", values, "loginRecordId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLoginRecordIdBetween(Long value1, Long value2) {
            this.addCriterion("login_record_id between", value1, value2, "loginRecordId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLoginRecordIdNotBetween(Long value1, Long value2) {
            this.addCriterion("login_record_id not between", value1, value2, "loginRecordId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserIdIsNull() {
            this.addCriterion("sub_user_id is null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserIdIsNotNull() {
            this.addCriterion("sub_user_id is not null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserIdEqualTo(Long value) {
            this.addCriterion("sub_user_id =", value, "subUserId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserIdNotEqualTo(Long value) {
            this.addCriterion("sub_user_id <>", value, "subUserId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserIdGreaterThan(Long value) {
            this.addCriterion("sub_user_id >", value, "subUserId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("sub_user_id >=", value, "subUserId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserIdLessThan(Long value) {
            this.addCriterion("sub_user_id <", value, "subUserId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("sub_user_id <=", value, "subUserId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserIdLike(String value) {
            this.addCriterion("sub_user_id like", value, "subUserId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserIdNotLike(String value) {
            this.addCriterion("sub_user_id not like", value, "subUserId");
            return (MemberLoginRecordExample.Criteria)this;
        }        public MemberLoginRecordExample.Criteria andSubUserIdIn(List<Long> values) {
            this.addCriterion("sub_user_id in", values, "subUserId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserIdNotIn(List<Long> values) {
            this.addCriterion("sub_user_id not in", values, "subUserId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserIdBetween(Long value1, Long value2) {
            this.addCriterion("sub_user_id between", value1, value2, "subUserId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("sub_user_id not between", value1, value2, "subUserId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (MemberLoginRecordExample.Criteria)this;
        }        public MemberLoginRecordExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserNameIsNull() {
            this.addCriterion("sub_user_name is null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserNameIsNotNull() {
            this.addCriterion("sub_user_name is not null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserNameEqualTo(String value) {
            this.addCriterion("sub_user_name =", value, "subUserName");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserNameNotEqualTo(String value) {
            this.addCriterion("sub_user_name <>", value, "subUserName");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserNameGreaterThan(String value) {
            this.addCriterion("sub_user_name >", value, "subUserName");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("sub_user_name >=", value, "subUserName");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserNameLessThan(String value) {
            this.addCriterion("sub_user_name <", value, "subUserName");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserNameLessThanOrEqualTo(String value) {
            this.addCriterion("sub_user_name <=", value, "subUserName");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserNameLike(String value) {
            this.addCriterion("sub_user_name like", value, "subUserName");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserNameNotLike(String value) {
            this.addCriterion("sub_user_name not like", value, "subUserName");
            return (MemberLoginRecordExample.Criteria)this;
        }        public MemberLoginRecordExample.Criteria andSubUserNameIn(List<String> values) {
            this.addCriterion("sub_user_name in", values, "subUserName");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserNameNotIn(List<String> values) {
            this.addCriterion("sub_user_name not in", values, "subUserName");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserNameBetween(String value1, String value2) {
            this.addCriterion("sub_user_name between", value1, value2, "subUserName");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserNameNotBetween(String value1, String value2) {
            this.addCriterion("sub_user_name not between", value1, value2, "subUserName");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordIsNull() {
            this.addCriterion("sub_user_password is null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordIsNotNull() {
            this.addCriterion("sub_user_password is not null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordEqualTo(String value) {
            this.addCriterion("sub_user_password =", value, "subUserPassword");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordNotEqualTo(String value) {
            this.addCriterion("sub_user_password <>", value, "subUserPassword");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordGreaterThan(String value) {
            this.addCriterion("sub_user_password >", value, "subUserPassword");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordGreaterThanOrEqualTo(String value) {
            this.addCriterion("sub_user_password >=", value, "subUserPassword");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordLessThan(String value) {
            this.addCriterion("sub_user_password <", value, "subUserPassword");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordLessThanOrEqualTo(String value) {
            this.addCriterion("sub_user_password <=", value, "subUserPassword");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordLike(String value) {
            this.addCriterion("sub_user_password like", value, "subUserPassword");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordNotLike(String value) {
            this.addCriterion("sub_user_password not like", value, "subUserPassword");
            return (MemberLoginRecordExample.Criteria)this;
        }        public MemberLoginRecordExample.Criteria andSubUserPasswordIn(List<String> values) {
            this.addCriterion("sub_user_password in", values, "subUserPassword");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordNotIn(List<String> values) {
            this.addCriterion("sub_user_password not in", values, "subUserPassword");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordBetween(String value1, String value2) {
            this.addCriterion("sub_user_password between", value1, value2, "subUserPassword");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserPasswordNotBetween(String value1, String value2) {
            this.addCriterion("sub_user_password not between", value1, value2, "subUserPassword");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyIsNull() {
            this.addCriterion("sub_user_key is null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyIsNotNull() {
            this.addCriterion("sub_user_key is not null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyEqualTo(String value) {
            this.addCriterion("sub_user_key =", value, "subUserKey");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyNotEqualTo(String value) {
            this.addCriterion("sub_user_key <>", value, "subUserKey");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyGreaterThan(String value) {
            this.addCriterion("sub_user_key >", value, "subUserKey");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyGreaterThanOrEqualTo(String value) {
            this.addCriterion("sub_user_key >=", value, "subUserKey");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyLessThan(String value) {
            this.addCriterion("sub_user_key <", value, "subUserKey");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyLessThanOrEqualTo(String value) {
            this.addCriterion("sub_user_key <=", value, "subUserKey");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyLike(String value) {
            this.addCriterion("sub_user_key like", value, "subUserKey");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyNotLike(String value) {
            this.addCriterion("sub_user_key not like", value, "subUserKey");
            return (MemberLoginRecordExample.Criteria)this;
        }        public MemberLoginRecordExample.Criteria andSubUserKeyIn(List<String> values) {
            this.addCriterion("sub_user_key in", values, "subUserKey");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyNotIn(List<String> values) {
            this.addCriterion("sub_user_key not in", values, "subUserKey");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyBetween(String value1, String value2) {
            this.addCriterion("sub_user_key between", value1, value2, "subUserKey");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andSubUserKeyNotBetween(String value1, String value2) {
            this.addCriterion("sub_user_key not between", value1, value2, "subUserKey");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andAccountTypeIsNull() {
            this.addCriterion("account_type is null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andAccountTypeIsNotNull() {
            this.addCriterion("account_type is not null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andAccountTypeEqualTo(Integer value) {
            this.addCriterion("account_type =", value, "accountType");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andAccountTypeNotEqualTo(Integer value) {
            this.addCriterion("account_type <>", value, "accountType");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andAccountTypeGreaterThan(Integer value) {
            this.addCriterion("account_type >", value, "accountType");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andAccountTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("account_type >=", value, "accountType");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andAccountTypeLessThan(Integer value) {
            this.addCriterion("account_type <", value, "accountType");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andAccountTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("account_type <=", value, "accountType");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andAccountTypeLike(String value) {
            this.addCriterion("account_type like", value, "accountType");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andAccountTypeNotLike(String value) {
            this.addCriterion("account_type not like", value, "accountType");
            return (MemberLoginRecordExample.Criteria)this;
        }        public MemberLoginRecordExample.Criteria andAccountTypeIn(List<Integer> values) {
            this.addCriterion("account_type in", values, "accountType");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andAccountTypeNotIn(List<Integer> values) {
            this.addCriterion("account_type not in", values, "accountType");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andAccountTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("account_type between", value1, value2, "accountType");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andAccountTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("account_type not between", value1, value2, "accountType");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastTimeIsNull() {
            this.addCriterion("last_time is null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastTimeIsNotNull() {
            this.addCriterion("last_time is not null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastTimeEqualTo(Date value) {
            this.addCriterion("last_time =", value, "lastTime");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastTimeNotEqualTo(Date value) {
            this.addCriterion("last_time <>", value, "lastTime");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastTimeGreaterThan(Date value) {
            this.addCriterion("last_time >", value, "lastTime");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("last_time >=", value, "lastTime");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastTimeLessThan(Date value) {
            this.addCriterion("last_time <", value, "lastTime");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("last_time <=", value, "lastTime");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastTimeLike(String value) {
            this.addCriterion("last_time like", value, "lastTime");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastTimeNotLike(String value) {
            this.addCriterion("last_time not like", value, "lastTime");
            return (MemberLoginRecordExample.Criteria)this;
        }        public MemberLoginRecordExample.Criteria andLastTimeIn(List<Date> values) {
            this.addCriterion("last_time in", values, "lastTime");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastTimeNotIn(List<Date> values) {
            this.addCriterion("last_time not in", values, "lastTime");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastTimeBetween(Date value1, Date value2) {
            this.addCriterion("last_time between", value1, value2, "lastTime");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("last_time not between", value1, value2, "lastTime");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastIpIsNull() {
            this.addCriterion("last_ip is null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastIpIsNotNull() {
            this.addCriterion("last_ip is not null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastIpEqualTo(String value) {
            this.addCriterion("last_ip =", value, "lastIp");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastIpNotEqualTo(String value) {
            this.addCriterion("last_ip <>", value, "lastIp");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastIpGreaterThan(String value) {
            this.addCriterion("last_ip >", value, "lastIp");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastIpGreaterThanOrEqualTo(String value) {
            this.addCriterion("last_ip >=", value, "lastIp");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastIpLessThan(String value) {
            this.addCriterion("last_ip <", value, "lastIp");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastIpLessThanOrEqualTo(String value) {
            this.addCriterion("last_ip <=", value, "lastIp");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastIpLike(String value) {
            this.addCriterion("last_ip like", value, "lastIp");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastIpNotLike(String value) {
            this.addCriterion("last_ip not like", value, "lastIp");
            return (MemberLoginRecordExample.Criteria)this;
        }        public MemberLoginRecordExample.Criteria andLastIpIn(List<String> values) {
            this.addCriterion("last_ip in", values, "lastIp");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastIpNotIn(List<String> values) {
            this.addCriterion("last_ip not in", values, "lastIp");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastIpBetween(String value1, String value2) {
            this.addCriterion("last_ip between", value1, value2, "lastIp");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andLastIpNotBetween(String value1, String value2) {
            this.addCriterion("last_ip not between", value1, value2, "lastIp");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (MemberLoginRecordExample.Criteria)this;
        }        public MemberLoginRecordExample.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (MemberLoginRecordExample.Criteria)this;
        }        public MemberLoginRecordExample.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (MemberLoginRecordExample.Criteria)this;
        }        public MemberLoginRecordExample.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (MemberLoginRecordExample.Criteria)this;
        }        public MemberLoginRecordExample.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (MemberLoginRecordExample.Criteria)this;
        }        public MemberLoginRecordExample.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (MemberLoginRecordExample.Criteria)this;
        }        public MemberLoginRecordExample.Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (MemberLoginRecordExample.Criteria)this;
        }        public MemberLoginRecordExample.Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (MemberLoginRecordExample.Criteria)this;
        }        public MemberLoginRecordExample.Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (MemberLoginRecordExample.Criteria)this;
        }        public MemberLoginRecordExample.Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (MemberLoginRecordExample.Criteria)this;
        }        public MemberLoginRecordExample.Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (MemberLoginRecordExample.Criteria)this;
        }

        public MemberLoginRecordExample.Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (MemberLoginRecordExample.Criteria)this;
        }
    }
}
