package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberUserSubExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<MemberUserSubExample.Criteria> oredCriteria = new ArrayList();

    public MemberUserSubExample() {
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

    public List<MemberUserSubExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(MemberUserSubExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public MemberUserSubExample.Criteria or() {
        MemberUserSubExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public MemberUserSubExample.Criteria createCriteria() {
        MemberUserSubExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected MemberUserSubExample.Criteria createCriteriaInternal() {
        MemberUserSubExample.Criteria criteria = new MemberUserSubExample.Criteria();
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

    public static class Criteria extends MemberUserSubExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<MemberUserSubExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<MemberUserSubExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<MemberUserSubExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new MemberUserSubExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new MemberUserSubExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new MemberUserSubExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public MemberUserSubExample.Criteria andSubUserIdIsNull() {
            this.addCriterion("sub_user_id is null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserIdIsNotNull() {
            this.addCriterion("sub_user_id is not null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserIdEqualTo(Long value) {
            this.addCriterion("sub_user_id =", value, "subUserId");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserIdNotEqualTo(Long value) {
            this.addCriterion("sub_user_id <>", value, "subUserId");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserIdGreaterThan(Long value) {
            this.addCriterion("sub_user_id >", value, "subUserId");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("sub_user_id >=", value, "subUserId");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserIdLessThan(Long value) {
            this.addCriterion("sub_user_id <", value, "subUserId");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("sub_user_id <=", value, "subUserId");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserIdLike(String value) {
            this.addCriterion("sub_user_id like", value, "subUserId");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserIdNotLike(String value) {
            this.addCriterion("sub_user_id not like", value, "subUserId");
            return (MemberUserSubExample.Criteria)this;
        }        public MemberUserSubExample.Criteria andSubUserIdIn(List<Long> values) {
            this.addCriterion("sub_user_id in", values, "subUserId");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserIdNotIn(List<Long> values) {
            this.addCriterion("sub_user_id not in", values, "subUserId");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserIdBetween(Long value1, Long value2) {
            this.addCriterion("sub_user_id between", value1, value2, "subUserId");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("sub_user_id not between", value1, value2, "subUserId");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (MemberUserSubExample.Criteria)this;
        }        public MemberUserSubExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserNameIsNull() {
            this.addCriterion("sub_user_name is null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserNameIsNotNull() {
            this.addCriterion("sub_user_name is not null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserNameEqualTo(String value) {
            this.addCriterion("sub_user_name =", value, "subUserName");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserNameNotEqualTo(String value) {
            this.addCriterion("sub_user_name <>", value, "subUserName");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserNameGreaterThan(String value) {
            this.addCriterion("sub_user_name >", value, "subUserName");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("sub_user_name >=", value, "subUserName");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserNameLessThan(String value) {
            this.addCriterion("sub_user_name <", value, "subUserName");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserNameLessThanOrEqualTo(String value) {
            this.addCriterion("sub_user_name <=", value, "subUserName");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserNameLike(String value) {
            this.addCriterion("sub_user_name like", value, "subUserName");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserNameNotLike(String value) {
            this.addCriterion("sub_user_name not like", value, "subUserName");
            return (MemberUserSubExample.Criteria)this;
        }        public MemberUserSubExample.Criteria andSubUserNameIn(List<String> values) {
            this.addCriterion("sub_user_name in", values, "subUserName");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserNameNotIn(List<String> values) {
            this.addCriterion("sub_user_name not in", values, "subUserName");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserNameBetween(String value1, String value2) {
            this.addCriterion("sub_user_name between", value1, value2, "subUserName");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserNameNotBetween(String value1, String value2) {
            this.addCriterion("sub_user_name not between", value1, value2, "subUserName");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserPasswordIsNull() {
            this.addCriterion("sub_user_password is null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserPasswordIsNotNull() {
            this.addCriterion("sub_user_password is not null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserPasswordEqualTo(String value) {
            this.addCriterion("sub_user_password =", value, "subUserPassword");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserPasswordNotEqualTo(String value) {
            this.addCriterion("sub_user_password <>", value, "subUserPassword");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserPasswordGreaterThan(String value) {
            this.addCriterion("sub_user_password >", value, "subUserPassword");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserPasswordGreaterThanOrEqualTo(String value) {
            this.addCriterion("sub_user_password >=", value, "subUserPassword");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserPasswordLessThan(String value) {
            this.addCriterion("sub_user_password <", value, "subUserPassword");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserPasswordLessThanOrEqualTo(String value) {
            this.addCriterion("sub_user_password <=", value, "subUserPassword");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserPasswordLike(String value) {
            this.addCriterion("sub_user_password like", value, "subUserPassword");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserPasswordNotLike(String value) {
            this.addCriterion("sub_user_password not like", value, "subUserPassword");
            return (MemberUserSubExample.Criteria)this;
        }        public MemberUserSubExample.Criteria andSubUserPasswordIn(List<String> values) {
            this.addCriterion("sub_user_password in", values, "subUserPassword");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserPasswordNotIn(List<String> values) {
            this.addCriterion("sub_user_password not in", values, "subUserPassword");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserPasswordBetween(String value1, String value2) {
            this.addCriterion("sub_user_password between", value1, value2, "subUserPassword");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserPasswordNotBetween(String value1, String value2) {
            this.addCriterion("sub_user_password not between", value1, value2, "subUserPassword");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserKeyIsNull() {
            this.addCriterion("sub_user_key is null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserKeyIsNotNull() {
            this.addCriterion("sub_user_key is not null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserKeyEqualTo(String value) {
            this.addCriterion("sub_user_key =", value, "subUserKey");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserKeyNotEqualTo(String value) {
            this.addCriterion("sub_user_key <>", value, "subUserKey");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserKeyGreaterThan(String value) {
            this.addCriterion("sub_user_key >", value, "subUserKey");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserKeyGreaterThanOrEqualTo(String value) {
            this.addCriterion("sub_user_key >=", value, "subUserKey");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserKeyLessThan(String value) {
            this.addCriterion("sub_user_key <", value, "subUserKey");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserKeyLessThanOrEqualTo(String value) {
            this.addCriterion("sub_user_key <=", value, "subUserKey");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserKeyLike(String value) {
            this.addCriterion("sub_user_key like", value, "subUserKey");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserKeyNotLike(String value) {
            this.addCriterion("sub_user_key not like", value, "subUserKey");
            return (MemberUserSubExample.Criteria)this;
        }        public MemberUserSubExample.Criteria andSubUserKeyIn(List<String> values) {
            this.addCriterion("sub_user_key in", values, "subUserKey");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserKeyNotIn(List<String> values) {
            this.addCriterion("sub_user_key not in", values, "subUserKey");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserKeyBetween(String value1, String value2) {
            this.addCriterion("sub_user_key between", value1, value2, "subUserKey");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andSubUserKeyNotBetween(String value1, String value2) {
            this.addCriterion("sub_user_key not between", value1, value2, "subUserKey");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andAccountTypeIsNull() {
            this.addCriterion("account_type is null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andAccountTypeIsNotNull() {
            this.addCriterion("account_type is not null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andAccountTypeEqualTo(Integer value) {
            this.addCriterion("account_type =", value, "accountType");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andAccountTypeNotEqualTo(Integer value) {
            this.addCriterion("account_type <>", value, "accountType");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andAccountTypeGreaterThan(Integer value) {
            this.addCriterion("account_type >", value, "accountType");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andAccountTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("account_type >=", value, "accountType");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andAccountTypeLessThan(Integer value) {
            this.addCriterion("account_type <", value, "accountType");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andAccountTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("account_type <=", value, "accountType");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andAccountTypeLike(String value) {
            this.addCriterion("account_type like", value, "accountType");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andAccountTypeNotLike(String value) {
            this.addCriterion("account_type not like", value, "accountType");
            return (MemberUserSubExample.Criteria)this;
        }        public MemberUserSubExample.Criteria andAccountTypeIn(List<Integer> values) {
            this.addCriterion("account_type in", values, "accountType");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andAccountTypeNotIn(List<Integer> values) {
            this.addCriterion("account_type not in", values, "accountType");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andAccountTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("account_type between", value1, value2, "accountType");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andAccountTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("account_type not between", value1, value2, "accountType");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andLoginsIsNull() {
            this.addCriterion("logins is null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andLoginsIsNotNull() {
            this.addCriterion("logins is not null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andLoginsEqualTo(Long value) {
            this.addCriterion("logins =", value, "logins");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andLoginsNotEqualTo(Long value) {
            this.addCriterion("logins <>", value, "logins");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andLoginsGreaterThan(Long value) {
            this.addCriterion("logins >", value, "logins");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andLoginsGreaterThanOrEqualTo(Long value) {
            this.addCriterion("logins >=", value, "logins");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andLoginsLessThan(Long value) {
            this.addCriterion("logins <", value, "logins");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andLoginsLessThanOrEqualTo(Long value) {
            this.addCriterion("logins <=", value, "logins");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andLoginsLike(String value) {
            this.addCriterion("logins like", value, "logins");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andLoginsNotLike(String value) {
            this.addCriterion("logins not like", value, "logins");
            return (MemberUserSubExample.Criteria)this;
        }        public MemberUserSubExample.Criteria andLoginsIn(List<Long> values) {
            this.addCriterion("logins in", values, "logins");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andLoginsNotIn(List<Long> values) {
            this.addCriterion("logins not in", values, "logins");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andLoginsBetween(Long value1, Long value2) {
            this.addCriterion("logins between", value1, value2, "logins");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andLoginsNotBetween(Long value1, Long value2) {
            this.addCriterion("logins not between", value1, value2, "logins");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUseStatusIsNull() {
            this.addCriterion("use_status is null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUseStatusIsNotNull() {
            this.addCriterion("use_status is not null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUseStatusEqualTo(Long value) {
            this.addCriterion("use_status =", value, "useStatus");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUseStatusNotEqualTo(Long value) {
            this.addCriterion("use_status <>", value, "useStatus");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUseStatusGreaterThan(Long value) {
            this.addCriterion("use_status >", value, "useStatus");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUseStatusGreaterThanOrEqualTo(Long value) {
            this.addCriterion("use_status >=", value, "useStatus");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUseStatusLessThan(Long value) {
            this.addCriterion("use_status <", value, "useStatus");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUseStatusLessThanOrEqualTo(Long value) {
            this.addCriterion("use_status <=", value, "useStatus");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUseStatusLike(String value) {
            this.addCriterion("use_status like", value, "useStatus");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUseStatusNotLike(String value) {
            this.addCriterion("use_status not like", value, "useStatus");
            return (MemberUserSubExample.Criteria)this;
        }        public MemberUserSubExample.Criteria andUseStatusIn(List<Long> values) {
            this.addCriterion("use_status in", values, "useStatus");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUseStatusNotIn(List<Long> values) {
            this.addCriterion("use_status not in", values, "useStatus");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUseStatusBetween(Long value1, Long value2) {
            this.addCriterion("use_status between", value1, value2, "useStatus");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andUseStatusNotBetween(Long value1, Long value2) {
            this.addCriterion("use_status not between", value1, value2, "useStatus");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (MemberUserSubExample.Criteria)this;
        }        public MemberUserSubExample.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (MemberUserSubExample.Criteria)this;
        }        public MemberUserSubExample.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (MemberUserSubExample.Criteria)this;
        }        public MemberUserSubExample.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (MemberUserSubExample.Criteria)this;
        }        public MemberUserSubExample.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (MemberUserSubExample.Criteria)this;
        }        public MemberUserSubExample.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (MemberUserSubExample.Criteria)this;
        }        public MemberUserSubExample.Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (MemberUserSubExample.Criteria)this;
        }        public MemberUserSubExample.Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (MemberUserSubExample.Criteria)this;
        }        public MemberUserSubExample.Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (MemberUserSubExample.Criteria)this;
        }        public MemberUserSubExample.Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (MemberUserSubExample.Criteria)this;
        }        public MemberUserSubExample.Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andIsOpenStoreIsNull() {
            this.addCriterion("is_open_store is null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andIsOpenStoreIsNotNull() {
            this.addCriterion("is_open_store is not null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andIsOpenStoreEqualTo(Integer value) {
            this.addCriterion("is_open_store =", value, "isOpenStore");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andIsOpenStoreNotEqualTo(Integer value) {
            this.addCriterion("is_open_store <>", value, "isOpenStore");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andIsOpenStoreGreaterThan(Integer value) {
            this.addCriterion("is_open_store >", value, "isOpenStore");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andIsOpenStoreGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_open_store >=", value, "isOpenStore");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andIsOpenStoreLessThan(Integer value) {
            this.addCriterion("is_open_store <", value, "isOpenStore");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andIsOpenStoreLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_open_store <=", value, "isOpenStore");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andIsOpenStoreLike(String value) {
            this.addCriterion("is_open_store like", value, "isOpenStore");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andIsOpenStoreNotLike(String value) {
            this.addCriterion("is_open_store not like", value, "isOpenStore");
            return (MemberUserSubExample.Criteria)this;
        }        public MemberUserSubExample.Criteria andIsOpenStoreIn(List<Integer> values) {
            this.addCriterion("is_open_store in", values, "isOpenStore");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andIsOpenStoreNotIn(List<Integer> values) {
            this.addCriterion("is_open_store not in", values, "isOpenStore");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andIsOpenStoreBetween(Integer value1, Integer value2) {
            this.addCriterion("is_open_store between", value1, value2, "isOpenStore");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andIsOpenStoreNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_open_store not between", value1, value2, "isOpenStore");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (MemberUserSubExample.Criteria)this;
        }        public MemberUserSubExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (MemberUserSubExample.Criteria)this;
        }

        public MemberUserSubExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (MemberUserSubExample.Criteria)this;
        }
    }
}
