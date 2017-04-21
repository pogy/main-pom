package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class MemberUserSubCopy2Example {
    protected String orderByClause;
    protected boolean distinct;
    protected List<MemberUserSubCopy2Example.Criteria> oredCriteria = new ArrayList<>();

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

    public List<MemberUserSubCopy2Example.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(MemberUserSubCopy2Example.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public MemberUserSubCopy2Example.Criteria or() {
        MemberUserSubCopy2Example.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public MemberUserSubCopy2Example.Criteria createCriteria() {
        MemberUserSubCopy2Example.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected MemberUserSubCopy2Example.Criteria createCriteriaInternal() {
        MemberUserSubCopy2Example.Criteria criteria = new MemberUserSubCopy2Example.Criteria();
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

    public static class Criteria extends MemberUserSubCopy2Example.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<MemberUserSubCopy2Example.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<MemberUserSubCopy2Example.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<MemberUserSubCopy2Example.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new MemberUserSubCopy2Example.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new MemberUserSubCopy2Example.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new MemberUserSubCopy2Example.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public MemberUserSubCopy2Example.Criteria andSubUserIdIsNull() {
            this.addCriterion("sub_user_id is null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserIdIsNotNull() {
            this.addCriterion("sub_user_id is not null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserIdEqualTo(Long value) {
            this.addCriterion("sub_user_id =", value, "subUserId");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserIdNotEqualTo(Long value) {
            this.addCriterion("sub_user_id <>", value, "subUserId");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserIdGreaterThan(Long value) {
            this.addCriterion("sub_user_id >", value, "subUserId");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("sub_user_id >=", value, "subUserId");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserIdLessThan(Long value) {
            this.addCriterion("sub_user_id <", value, "subUserId");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("sub_user_id <=", value, "subUserId");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserIdLike(String value) {
            this.addCriterion("sub_user_id like", value, "subUserId");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserIdNotLike(String value) {
            this.addCriterion("sub_user_id not like", value, "subUserId");
            return (MemberUserSubCopy2Example.Criteria)this;
        }        public MemberUserSubCopy2Example.Criteria andSubUserIdIn(List<Long> values) {
            this.addCriterion("sub_user_id in", values, "subUserId");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserIdNotIn(List<Long> values) {
            this.addCriterion("sub_user_id not in", values, "subUserId");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserIdBetween(Long value1, Long value2) {
            this.addCriterion("sub_user_id between", value1, value2, "subUserId");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("sub_user_id not between", value1, value2, "subUserId");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (MemberUserSubCopy2Example.Criteria)this;
        }        public MemberUserSubCopy2Example.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameIsNull() {
            this.addCriterion("sub_user_name is null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameIsNotNull() {
            this.addCriterion("sub_user_name is not null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameEqualTo(String value) {
            this.addCriterion("sub_user_name =", value, "subUserName");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameNotEqualTo(String value) {
            this.addCriterion("sub_user_name <>", value, "subUserName");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameGreaterThan(String value) {
            this.addCriterion("sub_user_name >", value, "subUserName");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("sub_user_name >=", value, "subUserName");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameLessThan(String value) {
            this.addCriterion("sub_user_name <", value, "subUserName");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameLessThanOrEqualTo(String value) {
            this.addCriterion("sub_user_name <=", value, "subUserName");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameLike(String value) {
            this.addCriterion("sub_user_name like", value, "subUserName");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameNotLike(String value) {
            this.addCriterion("sub_user_name not like", value, "subUserName");
            return (MemberUserSubCopy2Example.Criteria)this;
        }        public MemberUserSubCopy2Example.Criteria andSubUserNameIn(List<String> values) {
            this.addCriterion("sub_user_name in", values, "subUserName");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameNotIn(List<String> values) {
            this.addCriterion("sub_user_name not in", values, "subUserName");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameBetween(String value1, String value2) {
            this.addCriterion("sub_user_name between", value1, value2, "subUserName");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserNameNotBetween(String value1, String value2) {
            this.addCriterion("sub_user_name not between", value1, value2, "subUserName");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordIsNull() {
            this.addCriterion("sub_user_password is null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordIsNotNull() {
            this.addCriterion("sub_user_password is not null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordEqualTo(String value) {
            this.addCriterion("sub_user_password =", value, "subUserPassword");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordNotEqualTo(String value) {
            this.addCriterion("sub_user_password <>", value, "subUserPassword");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordGreaterThan(String value) {
            this.addCriterion("sub_user_password >", value, "subUserPassword");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordGreaterThanOrEqualTo(String value) {
            this.addCriterion("sub_user_password >=", value, "subUserPassword");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordLessThan(String value) {
            this.addCriterion("sub_user_password <", value, "subUserPassword");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordLessThanOrEqualTo(String value) {
            this.addCriterion("sub_user_password <=", value, "subUserPassword");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordLike(String value) {
            this.addCriterion("sub_user_password like", value, "subUserPassword");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordNotLike(String value) {
            this.addCriterion("sub_user_password not like", value, "subUserPassword");
            return (MemberUserSubCopy2Example.Criteria)this;
        }        public MemberUserSubCopy2Example.Criteria andSubUserPasswordIn(List<String> values) {
            this.addCriterion("sub_user_password in", values, "subUserPassword");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordNotIn(List<String> values) {
            this.addCriterion("sub_user_password not in", values, "subUserPassword");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordBetween(String value1, String value2) {
            this.addCriterion("sub_user_password between", value1, value2, "subUserPassword");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserPasswordNotBetween(String value1, String value2) {
            this.addCriterion("sub_user_password not between", value1, value2, "subUserPassword");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyIsNull() {
            this.addCriterion("sub_user_key is null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyIsNotNull() {
            this.addCriterion("sub_user_key is not null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyEqualTo(String value) {
            this.addCriterion("sub_user_key =", value, "subUserKey");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyNotEqualTo(String value) {
            this.addCriterion("sub_user_key <>", value, "subUserKey");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyGreaterThan(String value) {
            this.addCriterion("sub_user_key >", value, "subUserKey");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyGreaterThanOrEqualTo(String value) {
            this.addCriterion("sub_user_key >=", value, "subUserKey");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyLessThan(String value) {
            this.addCriterion("sub_user_key <", value, "subUserKey");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyLessThanOrEqualTo(String value) {
            this.addCriterion("sub_user_key <=", value, "subUserKey");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyLike(String value) {
            this.addCriterion("sub_user_key like", value, "subUserKey");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyNotLike(String value) {
            this.addCriterion("sub_user_key not like", value, "subUserKey");
            return (MemberUserSubCopy2Example.Criteria)this;
        }        public MemberUserSubCopy2Example.Criteria andSubUserKeyIn(List<String> values) {
            this.addCriterion("sub_user_key in", values, "subUserKey");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyNotIn(List<String> values) {
            this.addCriterion("sub_user_key not in", values, "subUserKey");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyBetween(String value1, String value2) {
            this.addCriterion("sub_user_key between", value1, value2, "subUserKey");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andSubUserKeyNotBetween(String value1, String value2) {
            this.addCriterion("sub_user_key not between", value1, value2, "subUserKey");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andAccountTypeIsNull() {
            this.addCriterion("account_type is null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andAccountTypeIsNotNull() {
            this.addCriterion("account_type is not null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andAccountTypeEqualTo(Integer value) {
            this.addCriterion("account_type =", value, "accountType");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andAccountTypeNotEqualTo(Integer value) {
            this.addCriterion("account_type <>", value, "accountType");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andAccountTypeGreaterThan(Integer value) {
            this.addCriterion("account_type >", value, "accountType");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andAccountTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("account_type >=", value, "accountType");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andAccountTypeLessThan(Integer value) {
            this.addCriterion("account_type <", value, "accountType");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andAccountTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("account_type <=", value, "accountType");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andAccountTypeLike(String value) {
            this.addCriterion("account_type like", value, "accountType");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andAccountTypeNotLike(String value) {
            this.addCriterion("account_type not like", value, "accountType");
            return (MemberUserSubCopy2Example.Criteria)this;
        }        public MemberUserSubCopy2Example.Criteria andAccountTypeIn(List<Integer> values) {
            this.addCriterion("account_type in", values, "accountType");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andAccountTypeNotIn(List<Integer> values) {
            this.addCriterion("account_type not in", values, "accountType");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andAccountTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("account_type between", value1, value2, "accountType");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andAccountTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("account_type not between", value1, value2, "accountType");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andLoginsIsNull() {
            this.addCriterion("logins is null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andLoginsIsNotNull() {
            this.addCriterion("logins is not null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andLoginsEqualTo(Long value) {
            this.addCriterion("logins =", value, "logins");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andLoginsNotEqualTo(Long value) {
            this.addCriterion("logins <>", value, "logins");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andLoginsGreaterThan(Long value) {
            this.addCriterion("logins >", value, "logins");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andLoginsGreaterThanOrEqualTo(Long value) {
            this.addCriterion("logins >=", value, "logins");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andLoginsLessThan(Long value) {
            this.addCriterion("logins <", value, "logins");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andLoginsLessThanOrEqualTo(Long value) {
            this.addCriterion("logins <=", value, "logins");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andLoginsLike(String value) {
            this.addCriterion("logins like", value, "logins");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andLoginsNotLike(String value) {
            this.addCriterion("logins not like", value, "logins");
            return (MemberUserSubCopy2Example.Criteria)this;
        }        public MemberUserSubCopy2Example.Criteria andLoginsIn(List<Long> values) {
            this.addCriterion("logins in", values, "logins");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andLoginsNotIn(List<Long> values) {
            this.addCriterion("logins not in", values, "logins");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andLoginsBetween(Long value1, Long value2) {
            this.addCriterion("logins between", value1, value2, "logins");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andLoginsNotBetween(Long value1, Long value2) {
            this.addCriterion("logins not between", value1, value2, "logins");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUseStatusIsNull() {
            this.addCriterion("use_status is null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUseStatusIsNotNull() {
            this.addCriterion("use_status is not null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUseStatusEqualTo(Long value) {
            this.addCriterion("use_status =", value, "useStatus");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUseStatusNotEqualTo(Long value) {
            this.addCriterion("use_status <>", value, "useStatus");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUseStatusGreaterThan(Long value) {
            this.addCriterion("use_status >", value, "useStatus");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUseStatusGreaterThanOrEqualTo(Long value) {
            this.addCriterion("use_status >=", value, "useStatus");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUseStatusLessThan(Long value) {
            this.addCriterion("use_status <", value, "useStatus");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUseStatusLessThanOrEqualTo(Long value) {
            this.addCriterion("use_status <=", value, "useStatus");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUseStatusLike(String value) {
            this.addCriterion("use_status like", value, "useStatus");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUseStatusNotLike(String value) {
            this.addCriterion("use_status not like", value, "useStatus");
            return (MemberUserSubCopy2Example.Criteria)this;
        }        public MemberUserSubCopy2Example.Criteria andUseStatusIn(List<Long> values) {
            this.addCriterion("use_status in", values, "useStatus");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUseStatusNotIn(List<Long> values) {
            this.addCriterion("use_status not in", values, "useStatus");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUseStatusBetween(Long value1, Long value2) {
            this.addCriterion("use_status between", value1, value2, "useStatus");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andUseStatusNotBetween(Long value1, Long value2) {
            this.addCriterion("use_status not between", value1, value2, "useStatus");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (MemberUserSubCopy2Example.Criteria)this;
        }        public MemberUserSubCopy2Example.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (MemberUserSubCopy2Example.Criteria)this;
        }        public MemberUserSubCopy2Example.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (MemberUserSubCopy2Example.Criteria)this;
        }        public MemberUserSubCopy2Example.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (MemberUserSubCopy2Example.Criteria)this;
        }        public MemberUserSubCopy2Example.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (MemberUserSubCopy2Example.Criteria)this;
        }        public MemberUserSubCopy2Example.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (MemberUserSubCopy2Example.Criteria)this;
        }        public MemberUserSubCopy2Example.Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (MemberUserSubCopy2Example.Criteria)this;
        }        public MemberUserSubCopy2Example.Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (MemberUserSubCopy2Example.Criteria)this;
        }        public MemberUserSubCopy2Example.Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (MemberUserSubCopy2Example.Criteria)this;
        }        public MemberUserSubCopy2Example.Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (MemberUserSubCopy2Example.Criteria)this;
        }        public MemberUserSubCopy2Example.Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andIsOpenStoreIsNull() {
            this.addCriterion("is_open_store is null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andIsOpenStoreIsNotNull() {
            this.addCriterion("is_open_store is not null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andIsOpenStoreEqualTo(Integer value) {
            this.addCriterion("is_open_store =", value, "isOpenStore");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andIsOpenStoreNotEqualTo(Integer value) {
            this.addCriterion("is_open_store <>", value, "isOpenStore");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andIsOpenStoreGreaterThan(Integer value) {
            this.addCriterion("is_open_store >", value, "isOpenStore");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andIsOpenStoreGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_open_store >=", value, "isOpenStore");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andIsOpenStoreLessThan(Integer value) {
            this.addCriterion("is_open_store <", value, "isOpenStore");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andIsOpenStoreLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_open_store <=", value, "isOpenStore");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andIsOpenStoreLike(String value) {
            this.addCriterion("is_open_store like", value, "isOpenStore");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andIsOpenStoreNotLike(String value) {
            this.addCriterion("is_open_store not like", value, "isOpenStore");
            return (MemberUserSubCopy2Example.Criteria)this;
        }        public MemberUserSubCopy2Example.Criteria andIsOpenStoreIn(List<Integer> values) {
            this.addCriterion("is_open_store in", values, "isOpenStore");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andIsOpenStoreNotIn(List<Integer> values) {
            this.addCriterion("is_open_store not in", values, "isOpenStore");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andIsOpenStoreBetween(Integer value1, Integer value2) {
            this.addCriterion("is_open_store between", value1, value2, "isOpenStore");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andIsOpenStoreNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_open_store not between", value1, value2, "isOpenStore");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (MemberUserSubCopy2Example.Criteria)this;
        }        public MemberUserSubCopy2Example.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (MemberUserSubCopy2Example.Criteria)this;
        }

        public MemberUserSubCopy2Example.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (MemberUserSubCopy2Example.Criteria)this;
        }
    }
}
