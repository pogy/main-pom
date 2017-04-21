package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberUserExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<MemberUserExample.Criteria> oredCriteria = new ArrayList();

    public MemberUserExample() {

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

    public List<MemberUserExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(MemberUserExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public MemberUserExample.Criteria or() {
        MemberUserExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public MemberUserExample.Criteria createCriteria() {
        MemberUserExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected MemberUserExample.Criteria createCriteriaInternal() {
        MemberUserExample.Criteria criteria = new MemberUserExample.Criteria();
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

    public static class Criteria extends MemberUserExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<MemberUserExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<MemberUserExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<MemberUserExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new MemberUserExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new MemberUserExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new MemberUserExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public MemberUserExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (MemberUserExample.Criteria)this;
        }


        public MemberUserExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNameIsNull() {
            this.addCriterion("user_name is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNameIsNotNull() {
            this.addCriterion("user_name is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNameEqualTo(String value) {
            this.addCriterion("user_name =", value, "userName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNameNotEqualTo(String value) {
            this.addCriterion("user_name <>", value, "userName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNameGreaterThan(String value) {
            this.addCriterion("user_name >", value, "userName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("user_name >=", value, "userName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNameLessThan(String value) {
            this.addCriterion("user_name <", value, "userName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNameLessThanOrEqualTo(String value) {
            this.addCriterion("user_name <=", value, "userName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNameLike(String value) {
            this.addCriterion("user_name like", value, "userName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNameNotLike(String value) {
            this.addCriterion("user_name not like", value, "userName");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andUserNameIn(List<String> values) {
            this.addCriterion("user_name in", values, "userName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNameNotIn(List<String> values) {
            this.addCriterion("user_name not in", values, "userName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNameBetween(String value1, String value2) {
            this.addCriterion("user_name between", value1, value2, "userName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNameNotBetween(String value1, String value2) {
            this.addCriterion("user_name not between", value1, value2, "userName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNickIsNull() {
            this.addCriterion("user_nick is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNickIsNotNull() {
            this.addCriterion("user_nick is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNickEqualTo(String value) {
            this.addCriterion("user_nick =", value, "userNick");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNickNotEqualTo(String value) {
            this.addCriterion("user_nick <>", value, "userNick");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNickGreaterThan(String value) {
            this.addCriterion("user_nick >", value, "userNick");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNickGreaterThanOrEqualTo(String value) {
            this.addCriterion("user_nick >=", value, "userNick");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNickLessThan(String value) {
            this.addCriterion("user_nick <", value, "userNick");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNickLessThanOrEqualTo(String value) {
            this.addCriterion("user_nick <=", value, "userNick");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNickLike(String value) {
            this.addCriterion("user_nick like", value, "userNick");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNickNotLike(String value) {
            this.addCriterion("user_nick not like", value, "userNick");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andUserNickIn(List<String> values) {
            this.addCriterion("user_nick in", values, "userNick");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNickNotIn(List<String> values) {
            this.addCriterion("user_nick not in", values, "userNick");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNickBetween(String value1, String value2) {
            this.addCriterion("user_nick between", value1, value2, "userNick");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUserNickNotBetween(String value1, String value2) {
            this.addCriterion("user_nick not between", value1, value2, "userNick");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginEmailIsNull() {
            this.addCriterion("login_email is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginEmailIsNotNull() {
            this.addCriterion("login_email is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginEmailEqualTo(String value) {
            this.addCriterion("login_email =", value, "loginEmail");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginEmailNotEqualTo(String value) {
            this.addCriterion("login_email <>", value, "loginEmail");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginEmailGreaterThan(String value) {
            this.addCriterion("login_email >", value, "loginEmail");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginEmailGreaterThanOrEqualTo(String value) {
            this.addCriterion("login_email >=", value, "loginEmail");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginEmailLessThan(String value) {
            this.addCriterion("login_email <", value, "loginEmail");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginEmailLessThanOrEqualTo(String value) {
            this.addCriterion("login_email <=", value, "loginEmail");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginEmailLike(String value) {
            this.addCriterion("login_email like", value, "loginEmail");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginEmailNotLike(String value) {
            this.addCriterion("login_email not like", value, "loginEmail");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andLoginEmailIn(List<String> values) {
            this.addCriterion("login_email in", values, "loginEmail");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginEmailNotIn(List<String> values) {
            this.addCriterion("login_email not in", values, "loginEmail");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginEmailBetween(String value1, String value2) {
            this.addCriterion("login_email between", value1, value2, "loginEmail");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginEmailNotBetween(String value1, String value2) {
            this.addCriterion("login_email not between", value1, value2, "loginEmail");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginPhoneIsNull() {
            this.addCriterion("login_phone is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginPhoneIsNotNull() {
            this.addCriterion("login_phone is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginPhoneEqualTo(String value) {
            this.addCriterion("login_phone =", value, "loginPhone");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginPhoneNotEqualTo(String value) {
            this.addCriterion("login_phone <>", value, "loginPhone");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginPhoneGreaterThan(String value) {
            this.addCriterion("login_phone >", value, "loginPhone");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginPhoneGreaterThanOrEqualTo(String value) {
            this.addCriterion("login_phone >=", value, "loginPhone");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginPhoneLessThan(String value) {
            this.addCriterion("login_phone <", value, "loginPhone");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginPhoneLessThanOrEqualTo(String value) {
            this.addCriterion("login_phone <=", value, "loginPhone");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginPhoneLike(String value) {
            this.addCriterion("login_phone like", value, "loginPhone");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginPhoneNotLike(String value) {
            this.addCriterion("login_phone not like", value, "loginPhone");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andLoginPhoneIn(List<String> values) {
            this.addCriterion("login_phone in", values, "loginPhone");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginPhoneNotIn(List<String> values) {
            this.addCriterion("login_phone not in", values, "loginPhone");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginPhoneBetween(String value1, String value2) {
            this.addCriterion("login_phone between", value1, value2, "loginPhone");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginPhoneNotBetween(String value1, String value2) {
            this.addCriterion("login_phone not between", value1, value2, "loginPhone");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andEmailIsNull() {
            this.addCriterion("email is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andEmailIsNotNull() {
            this.addCriterion("email is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andEmailEqualTo(String value) {
            this.addCriterion("email =", value, "email");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andEmailNotEqualTo(String value) {
            this.addCriterion("email <>", value, "email");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andEmailGreaterThan(String value) {
            this.addCriterion("email >", value, "email");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andEmailGreaterThanOrEqualTo(String value) {
            this.addCriterion("email >=", value, "email");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andEmailLessThan(String value) {
            this.addCriterion("email <", value, "email");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andEmailLessThanOrEqualTo(String value) {
            this.addCriterion("email <=", value, "email");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andEmailLike(String value) {
            this.addCriterion("email like", value, "email");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andEmailNotLike(String value) {
            this.addCriterion("email not like", value, "email");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andEmailIn(List<String> values) {
            this.addCriterion("email in", values, "email");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andEmailNotIn(List<String> values) {
            this.addCriterion("email not in", values, "email");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andEmailBetween(String value1, String value2) {
            this.addCriterion("email between", value1, value2, "email");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andEmailNotBetween(String value1, String value2) {
            this.addCriterion("email not between", value1, value2, "email");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordIsNull() {
            this.addCriterion("password is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordIsNotNull() {
            this.addCriterion("password is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordEqualTo(String value) {
            this.addCriterion("password =", value, "password");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordNotEqualTo(String value) {
            this.addCriterion("password <>", value, "password");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordGreaterThan(String value) {
            this.addCriterion("password >", value, "password");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordGreaterThanOrEqualTo(String value) {
            this.addCriterion("password >=", value, "password");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordLessThan(String value) {
            this.addCriterion("password <", value, "password");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordLessThanOrEqualTo(String value) {
            this.addCriterion("password <=", value, "password");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordLike(String value) {
            this.addCriterion("password like", value, "password");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordNotLike(String value) {
            this.addCriterion("password not like", value, "password");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andPasswordIn(List<String> values) {
            this.addCriterion("password in", values, "password");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordNotIn(List<String> values) {
            this.addCriterion("password not in", values, "password");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordBetween(String value1, String value2) {
            this.addCriterion("password between", value1, value2, "password");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordNotBetween(String value1, String value2) {
            this.addCriterion("password not between", value1, value2, "password");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRealNameIsNull() {
            this.addCriterion("real_name is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRealNameIsNotNull() {
            this.addCriterion("real_name is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRealNameEqualTo(String value) {
            this.addCriterion("real_name =", value, "realName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRealNameNotEqualTo(String value) {
            this.addCriterion("real_name <>", value, "realName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRealNameGreaterThan(String value) {
            this.addCriterion("real_name >", value, "realName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRealNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("real_name >=", value, "realName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRealNameLessThan(String value) {
            this.addCriterion("real_name <", value, "realName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRealNameLessThanOrEqualTo(String value) {
            this.addCriterion("real_name <=", value, "realName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRealNameLike(String value) {
            this.addCriterion("real_name like", value, "realName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRealNameNotLike(String value) {
            this.addCriterion("real_name not like", value, "realName");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andRealNameIn(List<String> values) {
            this.addCriterion("real_name in", values, "realName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRealNameNotIn(List<String> values) {
            this.addCriterion("real_name not in", values, "realName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRealNameBetween(String value1, String value2) {
            this.addCriterion("real_name between", value1, value2, "realName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRealNameNotBetween(String value1, String value2) {
            this.addCriterion("real_name not between", value1, value2, "realName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBuyerGradeIsNull() {
            this.addCriterion("buyer_grade is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBuyerGradeIsNotNull() {
            this.addCriterion("buyer_grade is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBuyerGradeEqualTo(Long value) {
            this.addCriterion("buyer_grade =", value, "buyerGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBuyerGradeNotEqualTo(Long value) {
            this.addCriterion("buyer_grade <>", value, "buyerGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBuyerGradeGreaterThan(Long value) {
            this.addCriterion("buyer_grade >", value, "buyerGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBuyerGradeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("buyer_grade >=", value, "buyerGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBuyerGradeLessThan(Long value) {
            this.addCriterion("buyer_grade <", value, "buyerGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBuyerGradeLessThanOrEqualTo(Long value) {
            this.addCriterion("buyer_grade <=", value, "buyerGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBuyerGradeLike(String value) {
            this.addCriterion("buyer_grade like", value, "buyerGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBuyerGradeNotLike(String value) {
            this.addCriterion("buyer_grade not like", value, "buyerGrade");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andBuyerGradeIn(List<Long> values) {
            this.addCriterion("buyer_grade in", values, "buyerGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBuyerGradeNotIn(List<Long> values) {
            this.addCriterion("buyer_grade not in", values, "buyerGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBuyerGradeBetween(Long value1, Long value2) {
            this.addCriterion("buyer_grade between", value1, value2, "buyerGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBuyerGradeNotBetween(Long value1, Long value2) {
            this.addCriterion("buyer_grade not between", value1, value2, "buyerGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerGradeIsNull() {
            this.addCriterion("seller_grade is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerGradeIsNotNull() {
            this.addCriterion("seller_grade is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerGradeEqualTo(Long value) {
            this.addCriterion("seller_grade =", value, "sellerGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerGradeNotEqualTo(Long value) {
            this.addCriterion("seller_grade <>", value, "sellerGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerGradeGreaterThan(Long value) {
            this.addCriterion("seller_grade >", value, "sellerGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerGradeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("seller_grade >=", value, "sellerGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerGradeLessThan(Long value) {
            this.addCriterion("seller_grade <", value, "sellerGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerGradeLessThanOrEqualTo(Long value) {
            this.addCriterion("seller_grade <=", value, "sellerGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerGradeLike(String value) {
            this.addCriterion("seller_grade like", value, "sellerGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerGradeNotLike(String value) {
            this.addCriterion("seller_grade not like", value, "sellerGrade");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andSellerGradeIn(List<Long> values) {
            this.addCriterion("seller_grade in", values, "sellerGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerGradeNotIn(List<Long> values) {
            this.addCriterion("seller_grade not in", values, "sellerGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerGradeBetween(Long value1, Long value2) {
            this.addCriterion("seller_grade between", value1, value2, "sellerGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerGradeNotBetween(Long value1, Long value2) {
            this.addCriterion("seller_grade not between", value1, value2, "sellerGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerVipGradeIsNull() {
            this.addCriterion("seller_vip_grade is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerVipGradeIsNotNull() {
            this.addCriterion("seller_vip_grade is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerVipGradeEqualTo(Long value) {
            this.addCriterion("seller_vip_grade =", value, "sellerVipGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerVipGradeNotEqualTo(Long value) {
            this.addCriterion("seller_vip_grade <>", value, "sellerVipGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerVipGradeGreaterThan(Long value) {
            this.addCriterion("seller_vip_grade >", value, "sellerVipGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerVipGradeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("seller_vip_grade >=", value, "sellerVipGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerVipGradeLessThan(Long value) {
            this.addCriterion("seller_vip_grade <", value, "sellerVipGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerVipGradeLessThanOrEqualTo(Long value) {
            this.addCriterion("seller_vip_grade <=", value, "sellerVipGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerVipGradeLike(String value) {
            this.addCriterion("seller_vip_grade like", value, "sellerVipGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerVipGradeNotLike(String value) {
            this.addCriterion("seller_vip_grade not like", value, "sellerVipGrade");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andSellerVipGradeIn(List<Long> values) {
            this.addCriterion("seller_vip_grade in", values, "sellerVipGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerVipGradeNotIn(List<Long> values) {
            this.addCriterion("seller_vip_grade not in", values, "sellerVipGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerVipGradeBetween(Long value1, Long value2) {
            this.addCriterion("seller_vip_grade between", value1, value2, "sellerVipGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSellerVipGradeNotBetween(Long value1, Long value2) {
            this.addCriterion("seller_vip_grade not between", value1, value2, "sellerVipGrade");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayIsNull() {
            this.addCriterion("birthday is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayIsNotNull() {
            this.addCriterion("birthday is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayEqualTo(Date value) {
            this.addCriterion("birthday =", value, "birthday");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayNotEqualTo(Date value) {
            this.addCriterion("birthday <>", value, "birthday");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayGreaterThan(Date value) {
            this.addCriterion("birthday >", value, "birthday");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            this.addCriterion("birthday >=", value, "birthday");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayLessThan(Date value) {
            this.addCriterion("birthday <", value, "birthday");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayLessThanOrEqualTo(Date value) {
            this.addCriterion("birthday <=", value, "birthday");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayLike(String value) {
            this.addCriterion("birthday like", value, "birthday");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayNotLike(String value) {
            this.addCriterion("birthday not like", value, "birthday");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andBirthdayIn(List<Date> values) {
            this.addCriterion("birthday in", values, "birthday");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayNotIn(List<Date> values) {
            this.addCriterion("birthday not in", values, "birthday");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayBetween(Date value1, Date value2) {
            this.addCriterion("birthday between", value1, value2, "birthday");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayNotBetween(Date value1, Date value2) {
            this.addCriterion("birthday not between", value1, value2, "birthday");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayMonthDayIsNull() {
            this.addCriterion("birthday_month_day is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayMonthDayIsNotNull() {
            this.addCriterion("birthday_month_day is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayMonthDayEqualTo(String value) {
            this.addCriterion("birthday_month_day =", value, "birthdayMonthDay");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayMonthDayNotEqualTo(String value) {
            this.addCriterion("birthday_month_day <>", value, "birthdayMonthDay");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayMonthDayGreaterThan(String value) {
            this.addCriterion("birthday_month_day >", value, "birthdayMonthDay");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayMonthDayGreaterThanOrEqualTo(String value) {
            this.addCriterion("birthday_month_day >=", value, "birthdayMonthDay");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayMonthDayLessThan(String value) {
            this.addCriterion("birthday_month_day <", value, "birthdayMonthDay");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayMonthDayLessThanOrEqualTo(String value) {
            this.addCriterion("birthday_month_day <=", value, "birthdayMonthDay");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayMonthDayLike(String value) {
            this.addCriterion("birthday_month_day like", value, "birthdayMonthDay");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayMonthDayNotLike(String value) {
            this.addCriterion("birthday_month_day not like", value, "birthdayMonthDay");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andBirthdayMonthDayIn(List<String> values) {
            this.addCriterion("birthday_month_day in", values, "birthdayMonthDay");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayMonthDayNotIn(List<String> values) {
            this.addCriterion("birthday_month_day not in", values, "birthdayMonthDay");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayMonthDayBetween(String value1, String value2) {
            this.addCriterion("birthday_month_day between", value1, value2, "birthdayMonthDay");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andBirthdayMonthDayNotBetween(String value1, String value2) {
            this.addCriterion("birthday_month_day not between", value1, value2, "birthdayMonthDay");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardIsNull() {
            this.addCriterion("id_card is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardIsNotNull() {
            this.addCriterion("id_card is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardEqualTo(String value) {
            this.addCriterion("id_card =", value, "idCard");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardNotEqualTo(String value) {
            this.addCriterion("id_card <>", value, "idCard");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardGreaterThan(String value) {
            this.addCriterion("id_card >", value, "idCard");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardGreaterThanOrEqualTo(String value) {
            this.addCriterion("id_card >=", value, "idCard");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardLessThan(String value) {
            this.addCriterion("id_card <", value, "idCard");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardLessThanOrEqualTo(String value) {
            this.addCriterion("id_card <=", value, "idCard");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardLike(String value) {
            this.addCriterion("id_card like", value, "idCard");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardNotLike(String value) {
            this.addCriterion("id_card not like", value, "idCard");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andIdCardIn(List<String> values) {
            this.addCriterion("id_card in", values, "idCard");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardNotIn(List<String> values) {
            this.addCriterion("id_card not in", values, "idCard");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardBetween(String value1, String value2) {
            this.addCriterion("id_card between", value1, value2, "idCard");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardNotBetween(String value1, String value2) {
            this.addCriterion("id_card not between", value1, value2, "idCard");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneTelIsNull() {
            this.addCriterion("phone_tel is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneTelIsNotNull() {
            this.addCriterion("phone_tel is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneTelEqualTo(String value) {
            this.addCriterion("phone_tel =", value, "phoneTel");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneTelNotEqualTo(String value) {
            this.addCriterion("phone_tel <>", value, "phoneTel");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneTelGreaterThan(String value) {
            this.addCriterion("phone_tel >", value, "phoneTel");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneTelGreaterThanOrEqualTo(String value) {
            this.addCriterion("phone_tel >=", value, "phoneTel");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneTelLessThan(String value) {
            this.addCriterion("phone_tel <", value, "phoneTel");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneTelLessThanOrEqualTo(String value) {
            this.addCriterion("phone_tel <=", value, "phoneTel");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneTelLike(String value) {
            this.addCriterion("phone_tel like", value, "phoneTel");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneTelNotLike(String value) {
            this.addCriterion("phone_tel not like", value, "phoneTel");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andPhoneTelIn(List<String> values) {
            this.addCriterion("phone_tel in", values, "phoneTel");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneTelNotIn(List<String> values) {
            this.addCriterion("phone_tel not in", values, "phoneTel");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneTelBetween(String value1, String value2) {
            this.addCriterion("phone_tel between", value1, value2, "phoneTel");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneTelNotBetween(String value1, String value2) {
            this.addCriterion("phone_tel not between", value1, value2, "phoneTel");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneMobIsNull() {
            this.addCriterion("phone_mob is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneMobIsNotNull() {
            this.addCriterion("phone_mob is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneMobEqualTo(String value) {
            this.addCriterion("phone_mob =", value, "phoneMob");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneMobNotEqualTo(String value) {
            this.addCriterion("phone_mob <>", value, "phoneMob");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneMobGreaterThan(String value) {
            this.addCriterion("phone_mob >", value, "phoneMob");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneMobGreaterThanOrEqualTo(String value) {
            this.addCriterion("phone_mob >=", value, "phoneMob");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneMobLessThan(String value) {
            this.addCriterion("phone_mob <", value, "phoneMob");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneMobLessThanOrEqualTo(String value) {
            this.addCriterion("phone_mob <=", value, "phoneMob");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneMobLike(String value) {
            this.addCriterion("phone_mob like", value, "phoneMob");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneMobNotLike(String value) {
            this.addCriterion("phone_mob not like", value, "phoneMob");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andPhoneMobIn(List<String> values) {
            this.addCriterion("phone_mob in", values, "phoneMob");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneMobNotIn(List<String> values) {
            this.addCriterion("phone_mob not in", values, "phoneMob");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneMobBetween(String value1, String value2) {
            this.addCriterion("phone_mob between", value1, value2, "phoneMob");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPhoneMobNotBetween(String value1, String value2) {
            this.addCriterion("phone_mob not between", value1, value2, "phoneMob");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqIsNull() {
            this.addCriterion("im_qq is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqIsNotNull() {
            this.addCriterion("im_qq is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqEqualTo(String value) {
            this.addCriterion("im_qq =", value, "imQq");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqNotEqualTo(String value) {
            this.addCriterion("im_qq <>", value, "imQq");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqGreaterThan(String value) {
            this.addCriterion("im_qq >", value, "imQq");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_qq >=", value, "imQq");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqLessThan(String value) {
            this.addCriterion("im_qq <", value, "imQq");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqLessThanOrEqualTo(String value) {
            this.addCriterion("im_qq <=", value, "imQq");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqLike(String value) {
            this.addCriterion("im_qq like", value, "imQq");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqNotLike(String value) {
            this.addCriterion("im_qq not like", value, "imQq");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andImQqIn(List<String> values) {
            this.addCriterion("im_qq in", values, "imQq");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqNotIn(List<String> values) {
            this.addCriterion("im_qq not in", values, "imQq");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqBetween(String value1, String value2) {
            this.addCriterion("im_qq between", value1, value2, "imQq");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqNotBetween(String value1, String value2) {
            this.addCriterion("im_qq not between", value1, value2, "imQq");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImSkypeIsNull() {
            this.addCriterion("im_skype is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImSkypeIsNotNull() {
            this.addCriterion("im_skype is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImSkypeEqualTo(String value) {
            this.addCriterion("im_skype =", value, "imSkype");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImSkypeNotEqualTo(String value) {
            this.addCriterion("im_skype <>", value, "imSkype");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImSkypeGreaterThan(String value) {
            this.addCriterion("im_skype >", value, "imSkype");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImSkypeGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_skype >=", value, "imSkype");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImSkypeLessThan(String value) {
            this.addCriterion("im_skype <", value, "imSkype");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImSkypeLessThanOrEqualTo(String value) {
            this.addCriterion("im_skype <=", value, "imSkype");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImSkypeLike(String value) {
            this.addCriterion("im_skype like", value, "imSkype");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImSkypeNotLike(String value) {
            this.addCriterion("im_skype not like", value, "imSkype");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andImSkypeIn(List<String> values) {
            this.addCriterion("im_skype in", values, "imSkype");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImSkypeNotIn(List<String> values) {
            this.addCriterion("im_skype not in", values, "imSkype");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImSkypeBetween(String value1, String value2) {
            this.addCriterion("im_skype between", value1, value2, "imSkype");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImSkypeNotBetween(String value1, String value2) {
            this.addCriterion("im_skype not between", value1, value2, "imSkype");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImWeixinIsNull() {
            this.addCriterion("im_weixin is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImWeixinIsNotNull() {
            this.addCriterion("im_weixin is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImWeixinEqualTo(String value) {
            this.addCriterion("im_weixin =", value, "imWeixin");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImWeixinNotEqualTo(String value) {
            this.addCriterion("im_weixin <>", value, "imWeixin");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImWeixinGreaterThan(String value) {
            this.addCriterion("im_weixin >", value, "imWeixin");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImWeixinGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_weixin >=", value, "imWeixin");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImWeixinLessThan(String value) {
            this.addCriterion("im_weixin <", value, "imWeixin");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImWeixinLessThanOrEqualTo(String value) {
            this.addCriterion("im_weixin <=", value, "imWeixin");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImWeixinLike(String value) {
            this.addCriterion("im_weixin like", value, "imWeixin");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImWeixinNotLike(String value) {
            this.addCriterion("im_weixin not like", value, "imWeixin");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andImWeixinIn(List<String> values) {
            this.addCriterion("im_weixin in", values, "imWeixin");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImWeixinNotIn(List<String> values) {
            this.addCriterion("im_weixin not in", values, "imWeixin");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImWeixinBetween(String value1, String value2) {
            this.addCriterion("im_weixin between", value1, value2, "imWeixin");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImWeixinNotBetween(String value1, String value2) {
            this.addCriterion("im_weixin not between", value1, value2, "imWeixin");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImAliwwIsNull() {
            this.addCriterion("im_aliww is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImAliwwIsNotNull() {
            this.addCriterion("im_aliww is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImAliwwEqualTo(String value) {
            this.addCriterion("im_aliww =", value, "imAliww");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImAliwwNotEqualTo(String value) {
            this.addCriterion("im_aliww <>", value, "imAliww");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImAliwwGreaterThan(String value) {
            this.addCriterion("im_aliww >", value, "imAliww");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImAliwwGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_aliww >=", value, "imAliww");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImAliwwLessThan(String value) {
            this.addCriterion("im_aliww <", value, "imAliww");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImAliwwLessThanOrEqualTo(String value) {
            this.addCriterion("im_aliww <=", value, "imAliww");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImAliwwLike(String value) {
            this.addCriterion("im_aliww like", value, "imAliww");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImAliwwNotLike(String value) {
            this.addCriterion("im_aliww not like", value, "imAliww");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andImAliwwIn(List<String> values) {
            this.addCriterion("im_aliww in", values, "imAliww");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImAliwwNotIn(List<String> values) {
            this.addCriterion("im_aliww not in", values, "imAliww");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImAliwwBetween(String value1, String value2) {
            this.addCriterion("im_aliww between", value1, value2, "imAliww");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImAliwwNotBetween(String value1, String value2) {
            this.addCriterion("im_aliww not between", value1, value2, "imAliww");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImYahooWeiboIsNull() {
            this.addCriterion("im_yahoo_weibo is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImYahooWeiboIsNotNull() {
            this.addCriterion("im_yahoo_weibo is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImYahooWeiboEqualTo(String value) {
            this.addCriterion("im_yahoo_weibo =", value, "imYahooWeibo");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImYahooWeiboNotEqualTo(String value) {
            this.addCriterion("im_yahoo_weibo <>", value, "imYahooWeibo");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImYahooWeiboGreaterThan(String value) {
            this.addCriterion("im_yahoo_weibo >", value, "imYahooWeibo");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImYahooWeiboGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_yahoo_weibo >=", value, "imYahooWeibo");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImYahooWeiboLessThan(String value) {
            this.addCriterion("im_yahoo_weibo <", value, "imYahooWeibo");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImYahooWeiboLessThanOrEqualTo(String value) {
            this.addCriterion("im_yahoo_weibo <=", value, "imYahooWeibo");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImYahooWeiboLike(String value) {
            this.addCriterion("im_yahoo_weibo like", value, "imYahooWeibo");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImYahooWeiboNotLike(String value) {
            this.addCriterion("im_yahoo_weibo not like", value, "imYahooWeibo");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andImYahooWeiboIn(List<String> values) {
            this.addCriterion("im_yahoo_weibo in", values, "imYahooWeibo");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImYahooWeiboNotIn(List<String> values) {
            this.addCriterion("im_yahoo_weibo not in", values, "imYahooWeibo");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImYahooWeiboBetween(String value1, String value2) {
            this.addCriterion("im_yahoo_weibo between", value1, value2, "imYahooWeibo");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImYahooWeiboNotBetween(String value1, String value2) {
            this.addCriterion("im_yahoo_weibo not between", value1, value2, "imYahooWeibo");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqWeiboIsNull() {
            this.addCriterion("im_qq_weibo is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqWeiboIsNotNull() {
            this.addCriterion("im_qq_weibo is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqWeiboEqualTo(String value) {
            this.addCriterion("im_qq_weibo =", value, "imQqWeibo");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqWeiboNotEqualTo(String value) {
            this.addCriterion("im_qq_weibo <>", value, "imQqWeibo");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqWeiboGreaterThan(String value) {
            this.addCriterion("im_qq_weibo >", value, "imQqWeibo");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqWeiboGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_qq_weibo >=", value, "imQqWeibo");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqWeiboLessThan(String value) {
            this.addCriterion("im_qq_weibo <", value, "imQqWeibo");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqWeiboLessThanOrEqualTo(String value) {
            this.addCriterion("im_qq_weibo <=", value, "imQqWeibo");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqWeiboLike(String value) {
            this.addCriterion("im_qq_weibo like", value, "imQqWeibo");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqWeiboNotLike(String value) {
            this.addCriterion("im_qq_weibo not like", value, "imQqWeibo");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andImQqWeiboIn(List<String> values) {
            this.addCriterion("im_qq_weibo in", values, "imQqWeibo");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqWeiboNotIn(List<String> values) {
            this.addCriterion("im_qq_weibo not in", values, "imQqWeibo");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqWeiboBetween(String value1, String value2) {
            this.addCriterion("im_qq_weibo between", value1, value2, "imQqWeibo");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andImQqWeiboNotBetween(String value1, String value2) {
            this.addCriterion("im_qq_weibo not between", value1, value2, "imQqWeibo");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegTimeIsNull() {
            this.addCriterion("reg_time is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegTimeIsNotNull() {
            this.addCriterion("reg_time is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegTimeEqualTo(Date value) {
            this.addCriterion("reg_time =", value, "regTime");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegTimeNotEqualTo(Date value) {
            this.addCriterion("reg_time <>", value, "regTime");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegTimeGreaterThan(Date value) {
            this.addCriterion("reg_time >", value, "regTime");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("reg_time >=", value, "regTime");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegTimeLessThan(Date value) {
            this.addCriterion("reg_time <", value, "regTime");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("reg_time <=", value, "regTime");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegTimeLike(String value) {
            this.addCriterion("reg_time like", value, "regTime");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegTimeNotLike(String value) {
            this.addCriterion("reg_time not like", value, "regTime");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andRegTimeIn(List<Date> values) {
            this.addCriterion("reg_time in", values, "regTime");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegTimeNotIn(List<Date> values) {
            this.addCriterion("reg_time not in", values, "regTime");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegTimeBetween(Date value1, Date value2) {
            this.addCriterion("reg_time between", value1, value2, "regTime");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("reg_time not between", value1, value2, "regTime");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastTimeIsNull() {
            this.addCriterion("last_time is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastTimeIsNotNull() {
            this.addCriterion("last_time is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastTimeEqualTo(Date value) {
            this.addCriterion("last_time =", value, "lastTime");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastTimeNotEqualTo(Date value) {
            this.addCriterion("last_time <>", value, "lastTime");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastTimeGreaterThan(Date value) {
            this.addCriterion("last_time >", value, "lastTime");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("last_time >=", value, "lastTime");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastTimeLessThan(Date value) {
            this.addCriterion("last_time <", value, "lastTime");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("last_time <=", value, "lastTime");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastTimeLike(String value) {
            this.addCriterion("last_time like", value, "lastTime");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastTimeNotLike(String value) {
            this.addCriterion("last_time not like", value, "lastTime");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andLastTimeIn(List<Date> values) {
            this.addCriterion("last_time in", values, "lastTime");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastTimeNotIn(List<Date> values) {
            this.addCriterion("last_time not in", values, "lastTime");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastTimeBetween(Date value1, Date value2) {
            this.addCriterion("last_time between", value1, value2, "lastTime");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("last_time not between", value1, value2, "lastTime");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastIpIsNull() {
            this.addCriterion("last_ip is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastIpIsNotNull() {
            this.addCriterion("last_ip is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastIpEqualTo(String value) {
            this.addCriterion("last_ip =", value, "lastIp");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastIpNotEqualTo(String value) {
            this.addCriterion("last_ip <>", value, "lastIp");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastIpGreaterThan(String value) {
            this.addCriterion("last_ip >", value, "lastIp");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastIpGreaterThanOrEqualTo(String value) {
            this.addCriterion("last_ip >=", value, "lastIp");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastIpLessThan(String value) {
            this.addCriterion("last_ip <", value, "lastIp");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastIpLessThanOrEqualTo(String value) {
            this.addCriterion("last_ip <=", value, "lastIp");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastIpLike(String value) {
            this.addCriterion("last_ip like", value, "lastIp");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastIpNotLike(String value) {
            this.addCriterion("last_ip not like", value, "lastIp");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andLastIpIn(List<String> values) {
            this.addCriterion("last_ip in", values, "lastIp");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastIpNotIn(List<String> values) {
            this.addCriterion("last_ip not in", values, "lastIp");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastIpBetween(String value1, String value2) {
            this.addCriterion("last_ip between", value1, value2, "lastIp");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLastIpNotBetween(String value1, String value2) {
            this.addCriterion("last_ip not between", value1, value2, "lastIp");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginsIsNull() {
            this.addCriterion("logins is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginsIsNotNull() {
            this.addCriterion("logins is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginsEqualTo(Long value) {
            this.addCriterion("logins =", value, "logins");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginsNotEqualTo(Long value) {
            this.addCriterion("logins <>", value, "logins");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginsGreaterThan(Long value) {
            this.addCriterion("logins >", value, "logins");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginsGreaterThanOrEqualTo(Long value) {
            this.addCriterion("logins >=", value, "logins");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginsLessThan(Long value) {
            this.addCriterion("logins <", value, "logins");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginsLessThanOrEqualTo(Long value) {
            this.addCriterion("logins <=", value, "logins");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginsLike(String value) {
            this.addCriterion("logins like", value, "logins");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginsNotLike(String value) {
            this.addCriterion("logins not like", value, "logins");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andLoginsIn(List<Long> values) {
            this.addCriterion("logins in", values, "logins");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginsNotIn(List<Long> values) {
            this.addCriterion("logins not in", values, "logins");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginsBetween(Long value1, Long value2) {
            this.addCriterion("logins between", value1, value2, "logins");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andLoginsNotBetween(Long value1, Long value2) {
            this.addCriterion("logins not between", value1, value2, "logins");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountTypeIsNull() {
            this.addCriterion("account_type is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountTypeIsNotNull() {
            this.addCriterion("account_type is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountTypeEqualTo(Integer value) {
            this.addCriterion("account_type =", value, "accountType");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountTypeNotEqualTo(Integer value) {
            this.addCriterion("account_type <>", value, "accountType");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountTypeGreaterThan(Integer value) {
            this.addCriterion("account_type >", value, "accountType");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("account_type >=", value, "accountType");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountTypeLessThan(Integer value) {
            this.addCriterion("account_type <", value, "accountType");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("account_type <=", value, "accountType");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountTypeLike(String value) {
            this.addCriterion("account_type like", value, "accountType");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountTypeNotLike(String value) {
            this.addCriterion("account_type not like", value, "accountType");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andAccountTypeIn(List<Integer> values) {
            this.addCriterion("account_type in", values, "accountType");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountTypeNotIn(List<Integer> values) {
            this.addCriterion("account_type not in", values, "accountType");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("account_type between", value1, value2, "accountType");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("account_type not between", value1, value2, "accountType");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountNameIsNull() {
            this.addCriterion("account_name is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountNameIsNotNull() {
            this.addCriterion("account_name is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountNameEqualTo(String value) {
            this.addCriterion("account_name =", value, "accountName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountNameNotEqualTo(String value) {
            this.addCriterion("account_name <>", value, "accountName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountNameGreaterThan(String value) {
            this.addCriterion("account_name >", value, "accountName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("account_name >=", value, "accountName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountNameLessThan(String value) {
            this.addCriterion("account_name <", value, "accountName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountNameLessThanOrEqualTo(String value) {
            this.addCriterion("account_name <=", value, "accountName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountNameLike(String value) {
            this.addCriterion("account_name like", value, "accountName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountNameNotLike(String value) {
            this.addCriterion("account_name not like", value, "accountName");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andAccountNameIn(List<String> values) {
            this.addCriterion("account_name in", values, "accountName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountNameNotIn(List<String> values) {
            this.addCriterion("account_name not in", values, "accountName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountNameBetween(String value1, String value2) {
            this.addCriterion("account_name between", value1, value2, "accountName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountNameNotBetween(String value1, String value2) {
            this.addCriterion("account_name not between", value1, value2, "accountName");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountIdIsNull() {
            this.addCriterion("account_id is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountIdIsNotNull() {
            this.addCriterion("account_id is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountIdEqualTo(Long value) {
            this.addCriterion("account_id =", value, "accountId");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountIdNotEqualTo(Long value) {
            this.addCriterion("account_id <>", value, "accountId");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountIdGreaterThan(Long value) {
            this.addCriterion("account_id >", value, "accountId");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("account_id >=", value, "accountId");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountIdLessThan(Long value) {
            this.addCriterion("account_id <", value, "accountId");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountIdLessThanOrEqualTo(Long value) {
            this.addCriterion("account_id <=", value, "accountId");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountIdLike(String value) {
            this.addCriterion("account_id like", value, "accountId");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountIdNotLike(String value) {
            this.addCriterion("account_id not like", value, "accountId");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andAccountIdIn(List<Long> values) {
            this.addCriterion("account_id in", values, "accountId");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountIdNotIn(List<Long> values) {
            this.addCriterion("account_id not in", values, "accountId");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountIdBetween(Long value1, Long value2) {
            this.addCriterion("account_id between", value1, value2, "accountId");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andAccountIdNotBetween(Long value1, Long value2) {
            this.addCriterion("account_id not between", value1, value2, "accountId");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitSavepathIsNull() {
            this.addCriterion("portrait_savepath is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitSavepathIsNotNull() {
            this.addCriterion("portrait_savepath is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitSavepathEqualTo(String value) {
            this.addCriterion("portrait_savepath =", value, "portraitSavepath");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitSavepathNotEqualTo(String value) {
            this.addCriterion("portrait_savepath <>", value, "portraitSavepath");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitSavepathGreaterThan(String value) {
            this.addCriterion("portrait_savepath >", value, "portraitSavepath");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitSavepathGreaterThanOrEqualTo(String value) {
            this.addCriterion("portrait_savepath >=", value, "portraitSavepath");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitSavepathLessThan(String value) {
            this.addCriterion("portrait_savepath <", value, "portraitSavepath");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitSavepathLessThanOrEqualTo(String value) {
            this.addCriterion("portrait_savepath <=", value, "portraitSavepath");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitSavepathLike(String value) {
            this.addCriterion("portrait_savepath like", value, "portraitSavepath");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitSavepathNotLike(String value) {
            this.addCriterion("portrait_savepath not like", value, "portraitSavepath");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andPortraitSavepathIn(List<String> values) {
            this.addCriterion("portrait_savepath in", values, "portraitSavepath");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitSavepathNotIn(List<String> values) {
            this.addCriterion("portrait_savepath not in", values, "portraitSavepath");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitSavepathBetween(String value1, String value2) {
            this.addCriterion("portrait_savepath between", value1, value2, "portraitSavepath");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitSavepathNotBetween(String value1, String value2) {
            this.addCriterion("portrait_savepath not between", value1, value2, "portraitSavepath");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitUrlIsNull() {
            this.addCriterion("portrait_url is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitUrlIsNotNull() {
            this.addCriterion("portrait_url is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitUrlEqualTo(String value) {
            this.addCriterion("portrait_url =", value, "portraitUrl");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitUrlNotEqualTo(String value) {
            this.addCriterion("portrait_url <>", value, "portraitUrl");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitUrlGreaterThan(String value) {
            this.addCriterion("portrait_url >", value, "portraitUrl");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("portrait_url >=", value, "portraitUrl");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitUrlLessThan(String value) {
            this.addCriterion("portrait_url <", value, "portraitUrl");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitUrlLessThanOrEqualTo(String value) {
            this.addCriterion("portrait_url <=", value, "portraitUrl");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitUrlLike(String value) {
            this.addCriterion("portrait_url like", value, "portraitUrl");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitUrlNotLike(String value) {
            this.addCriterion("portrait_url not like", value, "portraitUrl");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andPortraitUrlIn(List<String> values) {
            this.addCriterion("portrait_url in", values, "portraitUrl");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitUrlNotIn(List<String> values) {
            this.addCriterion("portrait_url not in", values, "portraitUrl");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitUrlBetween(String value1, String value2) {
            this.addCriterion("portrait_url between", value1, value2, "portraitUrl");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPortraitUrlNotBetween(String value1, String value2) {
            this.addCriterion("portrait_url not between", value1, value2, "portraitUrl");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUseStatusIsNull() {
            this.addCriterion("use_status is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUseStatusIsNotNull() {
            this.addCriterion("use_status is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUseStatusEqualTo(Long value) {
            this.addCriterion("use_status =", value, "useStatus");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUseStatusNotEqualTo(Long value) {
            this.addCriterion("use_status <>", value, "useStatus");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUseStatusGreaterThan(Long value) {
            this.addCriterion("use_status >", value, "useStatus");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUseStatusGreaterThanOrEqualTo(Long value) {
            this.addCriterion("use_status >=", value, "useStatus");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUseStatusLessThan(Long value) {
            this.addCriterion("use_status <", value, "useStatus");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUseStatusLessThanOrEqualTo(Long value) {
            this.addCriterion("use_status <=", value, "useStatus");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUseStatusLike(String value) {
            this.addCriterion("use_status like", value, "useStatus");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUseStatusNotLike(String value) {
            this.addCriterion("use_status not like", value, "useStatus");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andUseStatusIn(List<Long> values) {
            this.addCriterion("use_status in", values, "useStatus");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUseStatusNotIn(List<Long> values) {
            this.addCriterion("use_status not in", values, "useStatus");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUseStatusBetween(Long value1, Long value2) {
            this.addCriterion("use_status between", value1, value2, "useStatus");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andUseStatusNotBetween(Long value1, Long value2) {
            this.addCriterion("use_status not between", value1, value2, "useStatus");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsOpenStoreIsNull() {
            this.addCriterion("is_open_store is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsOpenStoreIsNotNull() {
            this.addCriterion("is_open_store is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsOpenStoreEqualTo(Integer value) {
            this.addCriterion("is_open_store =", value, "isOpenStore");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsOpenStoreNotEqualTo(Integer value) {
            this.addCriterion("is_open_store <>", value, "isOpenStore");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsOpenStoreGreaterThan(Integer value) {
            this.addCriterion("is_open_store >", value, "isOpenStore");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsOpenStoreGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_open_store >=", value, "isOpenStore");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsOpenStoreLessThan(Integer value) {
            this.addCriterion("is_open_store <", value, "isOpenStore");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsOpenStoreLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_open_store <=", value, "isOpenStore");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsOpenStoreLike(String value) {
            this.addCriterion("is_open_store like", value, "isOpenStore");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsOpenStoreNotLike(String value) {
            this.addCriterion("is_open_store not like", value, "isOpenStore");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andIsOpenStoreIn(List<Integer> values) {
            this.addCriterion("is_open_store in", values, "isOpenStore");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsOpenStoreNotIn(List<Integer> values) {
            this.addCriterion("is_open_store not in", values, "isOpenStore");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsOpenStoreBetween(Integer value1, Integer value2) {
            this.addCriterion("is_open_store between", value1, value2, "isOpenStore");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsOpenStoreNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_open_store not between", value1, value2, "isOpenStore");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark11IsNull() {
            this.addCriterion("remark11 is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark11IsNotNull() {
            this.addCriterion("remark11 is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark11EqualTo(String value) {
            this.addCriterion("remark11 =", value, "remark11");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark11NotEqualTo(String value) {
            this.addCriterion("remark11 <>", value, "remark11");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark11GreaterThan(String value) {
            this.addCriterion("remark11 >", value, "remark11");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark11GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark11 >=", value, "remark11");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark11LessThan(String value) {
            this.addCriterion("remark11 <", value, "remark11");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark11LessThanOrEqualTo(String value) {
            this.addCriterion("remark11 <=", value, "remark11");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark11Like(String value) {
            this.addCriterion("remark11 like", value, "remark11");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark11NotLike(String value) {
            this.addCriterion("remark11 not like", value, "remark11");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andRemark11In(List<String> values) {
            this.addCriterion("remark11 in", values, "remark11");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark11NotIn(List<String> values) {
            this.addCriterion("remark11 not in", values, "remark11");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark11Between(String value1, String value2) {
            this.addCriterion("remark11 between", value1, value2, "remark11");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark11NotBetween(String value1, String value2) {
            this.addCriterion("remark11 not between", value1, value2, "remark11");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark12IsNull() {
            this.addCriterion("remark12 is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark12IsNotNull() {
            this.addCriterion("remark12 is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark12EqualTo(String value) {
            this.addCriterion("remark12 =", value, "remark12");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark12NotEqualTo(String value) {
            this.addCriterion("remark12 <>", value, "remark12");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark12GreaterThan(String value) {
            this.addCriterion("remark12 >", value, "remark12");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark12GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark12 >=", value, "remark12");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark12LessThan(String value) {
            this.addCriterion("remark12 <", value, "remark12");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark12LessThanOrEqualTo(String value) {
            this.addCriterion("remark12 <=", value, "remark12");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark12Like(String value) {
            this.addCriterion("remark12 like", value, "remark12");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark12NotLike(String value) {
            this.addCriterion("remark12 not like", value, "remark12");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andRemark12In(List<String> values) {
            this.addCriterion("remark12 in", values, "remark12");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark12NotIn(List<String> values) {
            this.addCriterion("remark12 not in", values, "remark12");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark12Between(String value1, String value2) {
            this.addCriterion("remark12 between", value1, value2, "remark12");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark12NotBetween(String value1, String value2) {
            this.addCriterion("remark12 not between", value1, value2, "remark12");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark13IsNull() {
            this.addCriterion("remark13 is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark13IsNotNull() {
            this.addCriterion("remark13 is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark13EqualTo(String value) {
            this.addCriterion("remark13 =", value, "remark13");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark13NotEqualTo(String value) {
            this.addCriterion("remark13 <>", value, "remark13");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark13GreaterThan(String value) {
            this.addCriterion("remark13 >", value, "remark13");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark13GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark13 >=", value, "remark13");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark13LessThan(String value) {
            this.addCriterion("remark13 <", value, "remark13");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark13LessThanOrEqualTo(String value) {
            this.addCriterion("remark13 <=", value, "remark13");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark13Like(String value) {
            this.addCriterion("remark13 like", value, "remark13");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark13NotLike(String value) {
            this.addCriterion("remark13 not like", value, "remark13");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andRemark13In(List<String> values) {
            this.addCriterion("remark13 in", values, "remark13");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark13NotIn(List<String> values) {
            this.addCriterion("remark13 not in", values, "remark13");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark13Between(String value1, String value2) {
            this.addCriterion("remark13 between", value1, value2, "remark13");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark13NotBetween(String value1, String value2) {
            this.addCriterion("remark13 not between", value1, value2, "remark13");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark14IsNull() {
            this.addCriterion("remark14 is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark14IsNotNull() {
            this.addCriterion("remark14 is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark14EqualTo(String value) {
            this.addCriterion("remark14 =", value, "remark14");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark14NotEqualTo(String value) {
            this.addCriterion("remark14 <>", value, "remark14");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark14GreaterThan(String value) {
            this.addCriterion("remark14 >", value, "remark14");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark14GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark14 >=", value, "remark14");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark14LessThan(String value) {
            this.addCriterion("remark14 <", value, "remark14");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark14LessThanOrEqualTo(String value) {
            this.addCriterion("remark14 <=", value, "remark14");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark14Like(String value) {
            this.addCriterion("remark14 like", value, "remark14");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark14NotLike(String value) {
            this.addCriterion("remark14 not like", value, "remark14");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andRemark14In(List<String> values) {
            this.addCriterion("remark14 in", values, "remark14");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark14NotIn(List<String> values) {
            this.addCriterion("remark14 not in", values, "remark14");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark14Between(String value1, String value2) {
            this.addCriterion("remark14 between", value1, value2, "remark14");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark14NotBetween(String value1, String value2) {
            this.addCriterion("remark14 not between", value1, value2, "remark14");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark15IsNull() {
            this.addCriterion("remark15 is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark15IsNotNull() {
            this.addCriterion("remark15 is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark15EqualTo(String value) {
            this.addCriterion("remark15 =", value, "remark15");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark15NotEqualTo(String value) {
            this.addCriterion("remark15 <>", value, "remark15");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark15GreaterThan(String value) {
            this.addCriterion("remark15 >", value, "remark15");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark15GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark15 >=", value, "remark15");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark15LessThan(String value) {
            this.addCriterion("remark15 <", value, "remark15");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark15LessThanOrEqualTo(String value) {
            this.addCriterion("remark15 <=", value, "remark15");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark15Like(String value) {
            this.addCriterion("remark15 like", value, "remark15");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark15NotLike(String value) {
            this.addCriterion("remark15 not like", value, "remark15");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andRemark15In(List<String> values) {
            this.addCriterion("remark15 in", values, "remark15");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark15NotIn(List<String> values) {
            this.addCriterion("remark15 not in", values, "remark15");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark15Between(String value1, String value2) {
            this.addCriterion("remark15 between", value1, value2, "remark15");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark15NotBetween(String value1, String value2) {
            this.addCriterion("remark15 not between", value1, value2, "remark15");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark16IsNull() {
            this.addCriterion("remark16 is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark16IsNotNull() {
            this.addCriterion("remark16 is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark16EqualTo(String value) {
            this.addCriterion("remark16 =", value, "remark16");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark16NotEqualTo(String value) {
            this.addCriterion("remark16 <>", value, "remark16");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark16GreaterThan(String value) {
            this.addCriterion("remark16 >", value, "remark16");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark16GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark16 >=", value, "remark16");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark16LessThan(String value) {
            this.addCriterion("remark16 <", value, "remark16");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark16LessThanOrEqualTo(String value) {
            this.addCriterion("remark16 <=", value, "remark16");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark16Like(String value) {
            this.addCriterion("remark16 like", value, "remark16");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark16NotLike(String value) {
            this.addCriterion("remark16 not like", value, "remark16");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andRemark16In(List<String> values) {
            this.addCriterion("remark16 in", values, "remark16");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark16NotIn(List<String> values) {
            this.addCriterion("remark16 not in", values, "remark16");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark16Between(String value1, String value2) {
            this.addCriterion("remark16 between", value1, value2, "remark16");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark16NotBetween(String value1, String value2) {
            this.addCriterion("remark16 not between", value1, value2, "remark16");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark17IsNull() {
            this.addCriterion("remark17 is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark17IsNotNull() {
            this.addCriterion("remark17 is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark17EqualTo(String value) {
            this.addCriterion("remark17 =", value, "remark17");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark17NotEqualTo(String value) {
            this.addCriterion("remark17 <>", value, "remark17");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark17GreaterThan(String value) {
            this.addCriterion("remark17 >", value, "remark17");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark17GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark17 >=", value, "remark17");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark17LessThan(String value) {
            this.addCriterion("remark17 <", value, "remark17");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark17LessThanOrEqualTo(String value) {
            this.addCriterion("remark17 <=", value, "remark17");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark17Like(String value) {
            this.addCriterion("remark17 like", value, "remark17");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark17NotLike(String value) {
            this.addCriterion("remark17 not like", value, "remark17");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andRemark17In(List<String> values) {
            this.addCriterion("remark17 in", values, "remark17");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark17NotIn(List<String> values) {
            this.addCriterion("remark17 not in", values, "remark17");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark17Between(String value1, String value2) {
            this.addCriterion("remark17 between", value1, value2, "remark17");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark17NotBetween(String value1, String value2) {
            this.addCriterion("remark17 not between", value1, value2, "remark17");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark18IsNull() {
            this.addCriterion("remark18 is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark18IsNotNull() {
            this.addCriterion("remark18 is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark18EqualTo(String value) {
            this.addCriterion("remark18 =", value, "remark18");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark18NotEqualTo(String value) {
            this.addCriterion("remark18 <>", value, "remark18");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark18GreaterThan(String value) {
            this.addCriterion("remark18 >", value, "remark18");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark18GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark18 >=", value, "remark18");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark18LessThan(String value) {
            this.addCriterion("remark18 <", value, "remark18");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark18LessThanOrEqualTo(String value) {
            this.addCriterion("remark18 <=", value, "remark18");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark18Like(String value) {
            this.addCriterion("remark18 like", value, "remark18");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark18NotLike(String value) {
            this.addCriterion("remark18 not like", value, "remark18");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andRemark18In(List<String> values) {
            this.addCriterion("remark18 in", values, "remark18");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark18NotIn(List<String> values) {
            this.addCriterion("remark18 not in", values, "remark18");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark18Between(String value1, String value2) {
            this.addCriterion("remark18 between", value1, value2, "remark18");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark18NotBetween(String value1, String value2) {
            this.addCriterion("remark18 not between", value1, value2, "remark18");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark19IsNull() {
            this.addCriterion("remark19 is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark19IsNotNull() {
            this.addCriterion("remark19 is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark19EqualTo(String value) {
            this.addCriterion("remark19 =", value, "remark19");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark19NotEqualTo(String value) {
            this.addCriterion("remark19 <>", value, "remark19");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark19GreaterThan(String value) {
            this.addCriterion("remark19 >", value, "remark19");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark19GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark19 >=", value, "remark19");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark19LessThan(String value) {
            this.addCriterion("remark19 <", value, "remark19");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark19LessThanOrEqualTo(String value) {
            this.addCriterion("remark19 <=", value, "remark19");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark19Like(String value) {
            this.addCriterion("remark19 like", value, "remark19");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark19NotLike(String value) {
            this.addCriterion("remark19 not like", value, "remark19");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andRemark19In(List<String> values) {
            this.addCriterion("remark19 in", values, "remark19");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark19NotIn(List<String> values) {
            this.addCriterion("remark19 not in", values, "remark19");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark19Between(String value1, String value2) {
            this.addCriterion("remark19 between", value1, value2, "remark19");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark19NotBetween(String value1, String value2) {
            this.addCriterion("remark19 not between", value1, value2, "remark19");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark20IsNull() {
            this.addCriterion("remark20 is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark20IsNotNull() {
            this.addCriterion("remark20 is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark20EqualTo(String value) {
            this.addCriterion("remark20 =", value, "remark20");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark20NotEqualTo(String value) {
            this.addCriterion("remark20 <>", value, "remark20");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark20GreaterThan(String value) {
            this.addCriterion("remark20 >", value, "remark20");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark20GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark20 >=", value, "remark20");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark20LessThan(String value) {
            this.addCriterion("remark20 <", value, "remark20");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark20LessThanOrEqualTo(String value) {
            this.addCriterion("remark20 <=", value, "remark20");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark20Like(String value) {
            this.addCriterion("remark20 like", value, "remark20");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark20NotLike(String value) {
            this.addCriterion("remark20 not like", value, "remark20");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andRemark20In(List<String> values) {
            this.addCriterion("remark20 in", values, "remark20");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark20NotIn(List<String> values) {
            this.addCriterion("remark20 not in", values, "remark20");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark20Between(String value1, String value2) {
            this.addCriterion("remark20 between", value1, value2, "remark20");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRemark20NotBetween(String value1, String value2) {
            this.addCriterion("remark20 not between", value1, value2, "remark20");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSexIsNull() {
            this.addCriterion("sex is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSexIsNotNull() {
            this.addCriterion("sex is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSexEqualTo(String value) {
            this.addCriterion("sex =", value, "sex");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSexNotEqualTo(String value) {
            this.addCriterion("sex <>", value, "sex");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSexGreaterThan(String value) {
            this.addCriterion("sex >", value, "sex");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSexGreaterThanOrEqualTo(String value) {
            this.addCriterion("sex >=", value, "sex");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSexLessThan(String value) {
            this.addCriterion("sex <", value, "sex");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSexLessThanOrEqualTo(String value) {
            this.addCriterion("sex <=", value, "sex");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSexLike(String value) {
            this.addCriterion("sex like", value, "sex");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSexNotLike(String value) {
            this.addCriterion("sex not like", value, "sex");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andSexIn(List<String> values) {
            this.addCriterion("sex in", values, "sex");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSexNotIn(List<String> values) {
            this.addCriterion("sex not in", values, "sex");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSexBetween(String value1, String value2) {
            this.addCriterion("sex between", value1, value2, "sex");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andSexNotBetween(String value1, String value2) {
            this.addCriterion("sex not between", value1, value2, "sex");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsNameValidateIsNull() {
            this.addCriterion("is_name_validate is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsNameValidateIsNotNull() {
            this.addCriterion("is_name_validate is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsNameValidateEqualTo(Integer value) {
            this.addCriterion("is_name_validate =", value, "isNameValidate");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsNameValidateNotEqualTo(Integer value) {
            this.addCriterion("is_name_validate <>", value, "isNameValidate");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsNameValidateGreaterThan(Integer value) {
            this.addCriterion("is_name_validate >", value, "isNameValidate");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsNameValidateGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_name_validate >=", value, "isNameValidate");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsNameValidateLessThan(Integer value) {
            this.addCriterion("is_name_validate <", value, "isNameValidate");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsNameValidateLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_name_validate <=", value, "isNameValidate");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsNameValidateLike(String value) {
            this.addCriterion("is_name_validate like", value, "isNameValidate");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsNameValidateNotLike(String value) {
            this.addCriterion("is_name_validate not like", value, "isNameValidate");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andIsNameValidateIn(List<Integer> values) {
            this.addCriterion("is_name_validate in", values, "isNameValidate");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsNameValidateNotIn(List<Integer> values) {
            this.addCriterion("is_name_validate not in", values, "isNameValidate");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsNameValidateBetween(Integer value1, Integer value2) {
            this.addCriterion("is_name_validate between", value1, value2, "isNameValidate");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsNameValidateNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_name_validate not between", value1, value2, "isNameValidate");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordStrengthIsNull() {
            this.addCriterion("password_strength is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordStrengthIsNotNull() {
            this.addCriterion("password_strength is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordStrengthEqualTo(Integer value) {
            this.addCriterion("password_strength =", value, "passwordStrength");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordStrengthNotEqualTo(Integer value) {
            this.addCriterion("password_strength <>", value, "passwordStrength");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordStrengthGreaterThan(Integer value) {
            this.addCriterion("password_strength >", value, "passwordStrength");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordStrengthGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("password_strength >=", value, "passwordStrength");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordStrengthLessThan(Integer value) {
            this.addCriterion("password_strength <", value, "passwordStrength");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordStrengthLessThanOrEqualTo(Integer value) {
            this.addCriterion("password_strength <=", value, "passwordStrength");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordStrengthLike(String value) {
            this.addCriterion("password_strength like", value, "passwordStrength");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordStrengthNotLike(String value) {
            this.addCriterion("password_strength not like", value, "passwordStrength");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andPasswordStrengthIn(List<Integer> values) {
            this.addCriterion("password_strength in", values, "passwordStrength");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordStrengthNotIn(List<Integer> values) {
            this.addCriterion("password_strength not in", values, "passwordStrength");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordStrengthBetween(Integer value1, Integer value2) {
            this.addCriterion("password_strength between", value1, value2, "passwordStrength");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andPasswordStrengthNotBetween(Integer value1, Integer value2) {
            this.addCriterion("password_strength not between", value1, value2, "passwordStrength");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsMailValidateIsNull() {
            this.addCriterion("is_mail_validate is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsMailValidateIsNotNull() {
            this.addCriterion("is_mail_validate is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsMailValidateEqualTo(Integer value) {
            this.addCriterion("is_mail_validate =", value, "isMailValidate");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsMailValidateNotEqualTo(Integer value) {
            this.addCriterion("is_mail_validate <>", value, "isMailValidate");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsMailValidateGreaterThan(Integer value) {
            this.addCriterion("is_mail_validate >", value, "isMailValidate");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsMailValidateGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_mail_validate >=", value, "isMailValidate");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsMailValidateLessThan(Integer value) {
            this.addCriterion("is_mail_validate <", value, "isMailValidate");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsMailValidateLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_mail_validate <=", value, "isMailValidate");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsMailValidateLike(String value) {
            this.addCriterion("is_mail_validate like", value, "isMailValidate");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsMailValidateNotLike(String value) {
            this.addCriterion("is_mail_validate not like", value, "isMailValidate");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andIsMailValidateIn(List<Integer> values) {
            this.addCriterion("is_mail_validate in", values, "isMailValidate");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsMailValidateNotIn(List<Integer> values) {
            this.addCriterion("is_mail_validate not in", values, "isMailValidate");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsMailValidateBetween(Integer value1, Integer value2) {
            this.addCriterion("is_mail_validate between", value1, value2, "isMailValidate");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsMailValidateNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_mail_validate not between", value1, value2, "isMailValidate");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPhoneMobIsNull() {
            this.addCriterion("is_phone_mob is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPhoneMobIsNotNull() {
            this.addCriterion("is_phone_mob is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPhoneMobEqualTo(Integer value) {
            this.addCriterion("is_phone_mob =", value, "isPhoneMob");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPhoneMobNotEqualTo(Integer value) {
            this.addCriterion("is_phone_mob <>", value, "isPhoneMob");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPhoneMobGreaterThan(Integer value) {
            this.addCriterion("is_phone_mob >", value, "isPhoneMob");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPhoneMobGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_phone_mob >=", value, "isPhoneMob");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPhoneMobLessThan(Integer value) {
            this.addCriterion("is_phone_mob <", value, "isPhoneMob");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPhoneMobLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_phone_mob <=", value, "isPhoneMob");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPhoneMobLike(String value) {
            this.addCriterion("is_phone_mob like", value, "isPhoneMob");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPhoneMobNotLike(String value) {
            this.addCriterion("is_phone_mob not like", value, "isPhoneMob");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andIsPhoneMobIn(List<Integer> values) {
            this.addCriterion("is_phone_mob in", values, "isPhoneMob");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPhoneMobNotIn(List<Integer> values) {
            this.addCriterion("is_phone_mob not in", values, "isPhoneMob");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPhoneMobBetween(Integer value1, Integer value2) {
            this.addCriterion("is_phone_mob between", value1, value2, "isPhoneMob");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPhoneMobNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_phone_mob not between", value1, value2, "isPhoneMob");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPayPasswordIsNull() {
            this.addCriterion("is_pay_password is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPayPasswordIsNotNull() {
            this.addCriterion("is_pay_password is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPayPasswordEqualTo(Integer value) {
            this.addCriterion("is_pay_password =", value, "isPayPassword");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPayPasswordNotEqualTo(Integer value) {
            this.addCriterion("is_pay_password <>", value, "isPayPassword");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPayPasswordGreaterThan(Integer value) {
            this.addCriterion("is_pay_password >", value, "isPayPassword");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPayPasswordGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_pay_password >=", value, "isPayPassword");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPayPasswordLessThan(Integer value) {
            this.addCriterion("is_pay_password <", value, "isPayPassword");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPayPasswordLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_pay_password <=", value, "isPayPassword");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPayPasswordLike(String value) {
            this.addCriterion("is_pay_password like", value, "isPayPassword");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPayPasswordNotLike(String value) {
            this.addCriterion("is_pay_password not like", value, "isPayPassword");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andIsPayPasswordIn(List<Integer> values) {
            this.addCriterion("is_pay_password in", values, "isPayPassword");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPayPasswordNotIn(List<Integer> values) {
            this.addCriterion("is_pay_password not in", values, "isPayPassword");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPayPasswordBetween(Integer value1, Integer value2) {
            this.addCriterion("is_pay_password between", value1, value2, "isPayPassword");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIsPayPasswordNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_pay_password not between", value1, value2, "isPayPassword");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardImgIsNull() {
            this.addCriterion("id_card_img is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardImgIsNotNull() {
            this.addCriterion("id_card_img is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardImgEqualTo(String value) {
            this.addCriterion("id_card_img =", value, "idCardImg");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardImgNotEqualTo(String value) {
            this.addCriterion("id_card_img <>", value, "idCardImg");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardImgGreaterThan(String value) {
            this.addCriterion("id_card_img >", value, "idCardImg");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardImgGreaterThanOrEqualTo(String value) {
            this.addCriterion("id_card_img >=", value, "idCardImg");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardImgLessThan(String value) {
            this.addCriterion("id_card_img <", value, "idCardImg");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardImgLessThanOrEqualTo(String value) {
            this.addCriterion("id_card_img <=", value, "idCardImg");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardImgLike(String value) {
            this.addCriterion("id_card_img like", value, "idCardImg");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardImgNotLike(String value) {
            this.addCriterion("id_card_img not like", value, "idCardImg");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andIdCardImgIn(List<String> values) {
            this.addCriterion("id_card_img in", values, "idCardImg");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardImgNotIn(List<String> values) {
            this.addCriterion("id_card_img not in", values, "idCardImg");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardImgBetween(String value1, String value2) {
            this.addCriterion("id_card_img between", value1, value2, "idCardImg");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andIdCardImgNotBetween(String value1, String value2) {
            this.addCriterion("id_card_img not between", value1, value2, "idCardImg");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegisterSourceIsNull() {
            this.addCriterion("register_source is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegisterSourceIsNotNull() {
            this.addCriterion("register_source is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegisterSourceEqualTo(Long value) {
            this.addCriterion("register_source =", value, "registerSource");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegisterSourceNotEqualTo(Long value) {
            this.addCriterion("register_source <>", value, "registerSource");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegisterSourceGreaterThan(Long value) {
            this.addCriterion("register_source >", value, "registerSource");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegisterSourceGreaterThanOrEqualTo(Long value) {
            this.addCriterion("register_source >=", value, "registerSource");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegisterSourceLessThan(Long value) {
            this.addCriterion("register_source <", value, "registerSource");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegisterSourceLessThanOrEqualTo(Long value) {
            this.addCriterion("register_source <=", value, "registerSource");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegisterSourceLike(String value) {
            this.addCriterion("register_source like", value, "registerSource");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegisterSourceNotLike(String value) {
            this.addCriterion("register_source not like", value, "registerSource");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andRegisterSourceIn(List<Long> values) {
            this.addCriterion("register_source in", values, "registerSource");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegisterSourceNotIn(List<Long> values) {
            this.addCriterion("register_source not in", values, "registerSource");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegisterSourceBetween(Long value1, Long value2) {
            this.addCriterion("register_source between", value1, value2, "registerSource");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andRegisterSourceNotBetween(Long value1, Long value2) {
            this.addCriterion("register_source not between", value1, value2, "registerSource");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andZfbAccountIsNull() {
            this.addCriterion("zfb_account is null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andZfbAccountIsNotNull() {
            this.addCriterion("zfb_account is not null");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andZfbAccountEqualTo(String value) {
            this.addCriterion("zfb_account =", value, "zfbAccount");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andZfbAccountNotEqualTo(String value) {
            this.addCriterion("zfb_account <>", value, "zfbAccount");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andZfbAccountGreaterThan(String value) {
            this.addCriterion("zfb_account >", value, "zfbAccount");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andZfbAccountGreaterThanOrEqualTo(String value) {
            this.addCriterion("zfb_account >=", value, "zfbAccount");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andZfbAccountLessThan(String value) {
            this.addCriterion("zfb_account <", value, "zfbAccount");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andZfbAccountLessThanOrEqualTo(String value) {
            this.addCriterion("zfb_account <=", value, "zfbAccount");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andZfbAccountLike(String value) {
            this.addCriterion("zfb_account like", value, "zfbAccount");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andZfbAccountNotLike(String value) {
            this.addCriterion("zfb_account not like", value, "zfbAccount");
            return (MemberUserExample.Criteria)this;
        }        public MemberUserExample.Criteria andZfbAccountIn(List<String> values) {
            this.addCriterion("zfb_account in", values, "zfbAccount");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andZfbAccountNotIn(List<String> values) {
            this.addCriterion("zfb_account not in", values, "zfbAccount");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andZfbAccountBetween(String value1, String value2) {
            this.addCriterion("zfb_account between", value1, value2, "zfbAccount");
            return (MemberUserExample.Criteria)this;
        }

        public MemberUserExample.Criteria andZfbAccountNotBetween(String value1, String value2) {
            this.addCriterion("zfb_account not between", value1, value2, "zfbAccount");
            return (MemberUserExample.Criteria)this;
        }
    }
}
