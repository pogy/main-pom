package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class MemberUserCopy2Example {
    protected String orderByClause;
    protected boolean distinct;
    protected List<MemberUserCopy2Example.Criteria> oredCriteria = new ArrayList<>();

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

    public List<MemberUserCopy2Example.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(MemberUserCopy2Example.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public MemberUserCopy2Example.Criteria or() {
        MemberUserCopy2Example.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public MemberUserCopy2Example.Criteria createCriteria() {
        MemberUserCopy2Example.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected MemberUserCopy2Example.Criteria createCriteriaInternal() {
        MemberUserCopy2Example.Criteria criteria = new MemberUserCopy2Example.Criteria();
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

    public static class Criteria extends MemberUserCopy2Example.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<MemberUserCopy2Example.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<MemberUserCopy2Example.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<MemberUserCopy2Example.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new MemberUserCopy2Example.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new MemberUserCopy2Example.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new MemberUserCopy2Example.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public MemberUserCopy2Example.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNameIsNull() {
            this.addCriterion("user_name is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNameIsNotNull() {
            this.addCriterion("user_name is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNameEqualTo(String value) {
            this.addCriterion("user_name =", value, "userName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNameNotEqualTo(String value) {
            this.addCriterion("user_name <>", value, "userName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNameGreaterThan(String value) {
            this.addCriterion("user_name >", value, "userName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("user_name >=", value, "userName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNameLessThan(String value) {
            this.addCriterion("user_name <", value, "userName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNameLessThanOrEqualTo(String value) {
            this.addCriterion("user_name <=", value, "userName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNameLike(String value) {
            this.addCriterion("user_name like", value, "userName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNameNotLike(String value) {
            this.addCriterion("user_name not like", value, "userName");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andUserNameIn(List<String> values) {
            this.addCriterion("user_name in", values, "userName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNameNotIn(List<String> values) {
            this.addCriterion("user_name not in", values, "userName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNameBetween(String value1, String value2) {
            this.addCriterion("user_name between", value1, value2, "userName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNameNotBetween(String value1, String value2) {
            this.addCriterion("user_name not between", value1, value2, "userName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNickIsNull() {
            this.addCriterion("user_nick is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNickIsNotNull() {
            this.addCriterion("user_nick is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNickEqualTo(String value) {
            this.addCriterion("user_nick =", value, "userNick");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNickNotEqualTo(String value) {
            this.addCriterion("user_nick <>", value, "userNick");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNickGreaterThan(String value) {
            this.addCriterion("user_nick >", value, "userNick");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNickGreaterThanOrEqualTo(String value) {
            this.addCriterion("user_nick >=", value, "userNick");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNickLessThan(String value) {
            this.addCriterion("user_nick <", value, "userNick");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNickLessThanOrEqualTo(String value) {
            this.addCriterion("user_nick <=", value, "userNick");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNickLike(String value) {
            this.addCriterion("user_nick like", value, "userNick");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNickNotLike(String value) {
            this.addCriterion("user_nick not like", value, "userNick");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andUserNickIn(List<String> values) {
            this.addCriterion("user_nick in", values, "userNick");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNickNotIn(List<String> values) {
            this.addCriterion("user_nick not in", values, "userNick");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNickBetween(String value1, String value2) {
            this.addCriterion("user_nick between", value1, value2, "userNick");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUserNickNotBetween(String value1, String value2) {
            this.addCriterion("user_nick not between", value1, value2, "userNick");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginEmailIsNull() {
            this.addCriterion("login_email is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginEmailIsNotNull() {
            this.addCriterion("login_email is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginEmailEqualTo(String value) {
            this.addCriterion("login_email =", value, "loginEmail");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginEmailNotEqualTo(String value) {
            this.addCriterion("login_email <>", value, "loginEmail");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginEmailGreaterThan(String value) {
            this.addCriterion("login_email >", value, "loginEmail");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginEmailGreaterThanOrEqualTo(String value) {
            this.addCriterion("login_email >=", value, "loginEmail");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginEmailLessThan(String value) {
            this.addCriterion("login_email <", value, "loginEmail");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginEmailLessThanOrEqualTo(String value) {
            this.addCriterion("login_email <=", value, "loginEmail");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginEmailLike(String value) {
            this.addCriterion("login_email like", value, "loginEmail");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginEmailNotLike(String value) {
            this.addCriterion("login_email not like", value, "loginEmail");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andLoginEmailIn(List<String> values) {
            this.addCriterion("login_email in", values, "loginEmail");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginEmailNotIn(List<String> values) {
            this.addCriterion("login_email not in", values, "loginEmail");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginEmailBetween(String value1, String value2) {
            this.addCriterion("login_email between", value1, value2, "loginEmail");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginEmailNotBetween(String value1, String value2) {
            this.addCriterion("login_email not between", value1, value2, "loginEmail");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneIsNull() {
            this.addCriterion("login_phone is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneIsNotNull() {
            this.addCriterion("login_phone is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneEqualTo(String value) {
            this.addCriterion("login_phone =", value, "loginPhone");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneNotEqualTo(String value) {
            this.addCriterion("login_phone <>", value, "loginPhone");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneGreaterThan(String value) {
            this.addCriterion("login_phone >", value, "loginPhone");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneGreaterThanOrEqualTo(String value) {
            this.addCriterion("login_phone >=", value, "loginPhone");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneLessThan(String value) {
            this.addCriterion("login_phone <", value, "loginPhone");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneLessThanOrEqualTo(String value) {
            this.addCriterion("login_phone <=", value, "loginPhone");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneLike(String value) {
            this.addCriterion("login_phone like", value, "loginPhone");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneNotLike(String value) {
            this.addCriterion("login_phone not like", value, "loginPhone");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andLoginPhoneIn(List<String> values) {
            this.addCriterion("login_phone in", values, "loginPhone");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneNotIn(List<String> values) {
            this.addCriterion("login_phone not in", values, "loginPhone");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneBetween(String value1, String value2) {
            this.addCriterion("login_phone between", value1, value2, "loginPhone");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginPhoneNotBetween(String value1, String value2) {
            this.addCriterion("login_phone not between", value1, value2, "loginPhone");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andEmailIsNull() {
            this.addCriterion("email is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andEmailIsNotNull() {
            this.addCriterion("email is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andEmailEqualTo(String value) {
            this.addCriterion("email =", value, "email");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andEmailNotEqualTo(String value) {
            this.addCriterion("email <>", value, "email");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andEmailGreaterThan(String value) {
            this.addCriterion("email >", value, "email");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andEmailGreaterThanOrEqualTo(String value) {
            this.addCriterion("email >=", value, "email");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andEmailLessThan(String value) {
            this.addCriterion("email <", value, "email");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andEmailLessThanOrEqualTo(String value) {
            this.addCriterion("email <=", value, "email");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andEmailLike(String value) {
            this.addCriterion("email like", value, "email");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andEmailNotLike(String value) {
            this.addCriterion("email not like", value, "email");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andEmailIn(List<String> values) {
            this.addCriterion("email in", values, "email");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andEmailNotIn(List<String> values) {
            this.addCriterion("email not in", values, "email");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andEmailBetween(String value1, String value2) {
            this.addCriterion("email between", value1, value2, "email");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andEmailNotBetween(String value1, String value2) {
            this.addCriterion("email not between", value1, value2, "email");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordIsNull() {
            this.addCriterion("password is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordIsNotNull() {
            this.addCriterion("password is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordEqualTo(String value) {
            this.addCriterion("password =", value, "password");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordNotEqualTo(String value) {
            this.addCriterion("password <>", value, "password");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordGreaterThan(String value) {
            this.addCriterion("password >", value, "password");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordGreaterThanOrEqualTo(String value) {
            this.addCriterion("password >=", value, "password");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordLessThan(String value) {
            this.addCriterion("password <", value, "password");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordLessThanOrEqualTo(String value) {
            this.addCriterion("password <=", value, "password");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordLike(String value) {
            this.addCriterion("password like", value, "password");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordNotLike(String value) {
            this.addCriterion("password not like", value, "password");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andPasswordIn(List<String> values) {
            this.addCriterion("password in", values, "password");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordNotIn(List<String> values) {
            this.addCriterion("password not in", values, "password");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordBetween(String value1, String value2) {
            this.addCriterion("password between", value1, value2, "password");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordNotBetween(String value1, String value2) {
            this.addCriterion("password not between", value1, value2, "password");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRealNameIsNull() {
            this.addCriterion("real_name is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRealNameIsNotNull() {
            this.addCriterion("real_name is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRealNameEqualTo(String value) {
            this.addCriterion("real_name =", value, "realName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRealNameNotEqualTo(String value) {
            this.addCriterion("real_name <>", value, "realName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRealNameGreaterThan(String value) {
            this.addCriterion("real_name >", value, "realName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRealNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("real_name >=", value, "realName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRealNameLessThan(String value) {
            this.addCriterion("real_name <", value, "realName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRealNameLessThanOrEqualTo(String value) {
            this.addCriterion("real_name <=", value, "realName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRealNameLike(String value) {
            this.addCriterion("real_name like", value, "realName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRealNameNotLike(String value) {
            this.addCriterion("real_name not like", value, "realName");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andRealNameIn(List<String> values) {
            this.addCriterion("real_name in", values, "realName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRealNameNotIn(List<String> values) {
            this.addCriterion("real_name not in", values, "realName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRealNameBetween(String value1, String value2) {
            this.addCriterion("real_name between", value1, value2, "realName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRealNameNotBetween(String value1, String value2) {
            this.addCriterion("real_name not between", value1, value2, "realName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBuyerGradeIsNull() {
            this.addCriterion("buyer_grade is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBuyerGradeIsNotNull() {
            this.addCriterion("buyer_grade is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBuyerGradeEqualTo(Long value) {
            this.addCriterion("buyer_grade =", value, "buyerGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBuyerGradeNotEqualTo(Long value) {
            this.addCriterion("buyer_grade <>", value, "buyerGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBuyerGradeGreaterThan(Long value) {
            this.addCriterion("buyer_grade >", value, "buyerGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBuyerGradeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("buyer_grade >=", value, "buyerGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBuyerGradeLessThan(Long value) {
            this.addCriterion("buyer_grade <", value, "buyerGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBuyerGradeLessThanOrEqualTo(Long value) {
            this.addCriterion("buyer_grade <=", value, "buyerGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBuyerGradeLike(String value) {
            this.addCriterion("buyer_grade like", value, "buyerGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBuyerGradeNotLike(String value) {
            this.addCriterion("buyer_grade not like", value, "buyerGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andBuyerGradeIn(List<Long> values) {
            this.addCriterion("buyer_grade in", values, "buyerGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBuyerGradeNotIn(List<Long> values) {
            this.addCriterion("buyer_grade not in", values, "buyerGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBuyerGradeBetween(Long value1, Long value2) {
            this.addCriterion("buyer_grade between", value1, value2, "buyerGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBuyerGradeNotBetween(Long value1, Long value2) {
            this.addCriterion("buyer_grade not between", value1, value2, "buyerGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerGradeIsNull() {
            this.addCriterion("seller_grade is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerGradeIsNotNull() {
            this.addCriterion("seller_grade is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerGradeEqualTo(Long value) {
            this.addCriterion("seller_grade =", value, "sellerGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerGradeNotEqualTo(Long value) {
            this.addCriterion("seller_grade <>", value, "sellerGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerGradeGreaterThan(Long value) {
            this.addCriterion("seller_grade >", value, "sellerGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerGradeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("seller_grade >=", value, "sellerGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerGradeLessThan(Long value) {
            this.addCriterion("seller_grade <", value, "sellerGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerGradeLessThanOrEqualTo(Long value) {
            this.addCriterion("seller_grade <=", value, "sellerGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerGradeLike(String value) {
            this.addCriterion("seller_grade like", value, "sellerGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerGradeNotLike(String value) {
            this.addCriterion("seller_grade not like", value, "sellerGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andSellerGradeIn(List<Long> values) {
            this.addCriterion("seller_grade in", values, "sellerGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerGradeNotIn(List<Long> values) {
            this.addCriterion("seller_grade not in", values, "sellerGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerGradeBetween(Long value1, Long value2) {
            this.addCriterion("seller_grade between", value1, value2, "sellerGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerGradeNotBetween(Long value1, Long value2) {
            this.addCriterion("seller_grade not between", value1, value2, "sellerGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerVipGradeIsNull() {
            this.addCriterion("seller_vip_grade is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerVipGradeIsNotNull() {
            this.addCriterion("seller_vip_grade is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerVipGradeEqualTo(Long value) {
            this.addCriterion("seller_vip_grade =", value, "sellerVipGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerVipGradeNotEqualTo(Long value) {
            this.addCriterion("seller_vip_grade <>", value, "sellerVipGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerVipGradeGreaterThan(Long value) {
            this.addCriterion("seller_vip_grade >", value, "sellerVipGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerVipGradeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("seller_vip_grade >=", value, "sellerVipGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerVipGradeLessThan(Long value) {
            this.addCriterion("seller_vip_grade <", value, "sellerVipGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerVipGradeLessThanOrEqualTo(Long value) {
            this.addCriterion("seller_vip_grade <=", value, "sellerVipGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerVipGradeLike(String value) {
            this.addCriterion("seller_vip_grade like", value, "sellerVipGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerVipGradeNotLike(String value) {
            this.addCriterion("seller_vip_grade not like", value, "sellerVipGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andSellerVipGradeIn(List<Long> values) {
            this.addCriterion("seller_vip_grade in", values, "sellerVipGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerVipGradeNotIn(List<Long> values) {
            this.addCriterion("seller_vip_grade not in", values, "sellerVipGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerVipGradeBetween(Long value1, Long value2) {
            this.addCriterion("seller_vip_grade between", value1, value2, "sellerVipGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSellerVipGradeNotBetween(Long value1, Long value2) {
            this.addCriterion("seller_vip_grade not between", value1, value2, "sellerVipGrade");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayIsNull() {
            this.addCriterion("birthday is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayIsNotNull() {
            this.addCriterion("birthday is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayEqualTo(Date value) {
            this.addCriterion("birthday =", value, "birthday");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayNotEqualTo(Date value) {
            this.addCriterion("birthday <>", value, "birthday");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayGreaterThan(Date value) {
            this.addCriterion("birthday >", value, "birthday");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            this.addCriterion("birthday >=", value, "birthday");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayLessThan(Date value) {
            this.addCriterion("birthday <", value, "birthday");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayLessThanOrEqualTo(Date value) {
            this.addCriterion("birthday <=", value, "birthday");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayLike(String value) {
            this.addCriterion("birthday like", value, "birthday");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayNotLike(String value) {
            this.addCriterion("birthday not like", value, "birthday");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andBirthdayIn(List<Date> values) {
            this.addCriterion("birthday in", values, "birthday");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayNotIn(List<Date> values) {
            this.addCriterion("birthday not in", values, "birthday");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayBetween(Date value1, Date value2) {
            this.addCriterion("birthday between", value1, value2, "birthday");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayNotBetween(Date value1, Date value2) {
            this.addCriterion("birthday not between", value1, value2, "birthday");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayIsNull() {
            this.addCriterion("birthday_month_day is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayIsNotNull() {
            this.addCriterion("birthday_month_day is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayEqualTo(String value) {
            this.addCriterion("birthday_month_day =", value, "birthdayMonthDay");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayNotEqualTo(String value) {
            this.addCriterion("birthday_month_day <>", value, "birthdayMonthDay");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayGreaterThan(String value) {
            this.addCriterion("birthday_month_day >", value, "birthdayMonthDay");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayGreaterThanOrEqualTo(String value) {
            this.addCriterion("birthday_month_day >=", value, "birthdayMonthDay");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayLessThan(String value) {
            this.addCriterion("birthday_month_day <", value, "birthdayMonthDay");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayLessThanOrEqualTo(String value) {
            this.addCriterion("birthday_month_day <=", value, "birthdayMonthDay");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayLike(String value) {
            this.addCriterion("birthday_month_day like", value, "birthdayMonthDay");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayNotLike(String value) {
            this.addCriterion("birthday_month_day not like", value, "birthdayMonthDay");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andBirthdayMonthDayIn(List<String> values) {
            this.addCriterion("birthday_month_day in", values, "birthdayMonthDay");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayNotIn(List<String> values) {
            this.addCriterion("birthday_month_day not in", values, "birthdayMonthDay");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayBetween(String value1, String value2) {
            this.addCriterion("birthday_month_day between", value1, value2, "birthdayMonthDay");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andBirthdayMonthDayNotBetween(String value1, String value2) {
            this.addCriterion("birthday_month_day not between", value1, value2, "birthdayMonthDay");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardIsNull() {
            this.addCriterion("id_card is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardIsNotNull() {
            this.addCriterion("id_card is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardEqualTo(String value) {
            this.addCriterion("id_card =", value, "idCard");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardNotEqualTo(String value) {
            this.addCriterion("id_card <>", value, "idCard");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardGreaterThan(String value) {
            this.addCriterion("id_card >", value, "idCard");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardGreaterThanOrEqualTo(String value) {
            this.addCriterion("id_card >=", value, "idCard");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardLessThan(String value) {
            this.addCriterion("id_card <", value, "idCard");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardLessThanOrEqualTo(String value) {
            this.addCriterion("id_card <=", value, "idCard");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardLike(String value) {
            this.addCriterion("id_card like", value, "idCard");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardNotLike(String value) {
            this.addCriterion("id_card not like", value, "idCard");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andIdCardIn(List<String> values) {
            this.addCriterion("id_card in", values, "idCard");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardNotIn(List<String> values) {
            this.addCriterion("id_card not in", values, "idCard");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardBetween(String value1, String value2) {
            this.addCriterion("id_card between", value1, value2, "idCard");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardNotBetween(String value1, String value2) {
            this.addCriterion("id_card not between", value1, value2, "idCard");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneTelIsNull() {
            this.addCriterion("phone_tel is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneTelIsNotNull() {
            this.addCriterion("phone_tel is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneTelEqualTo(String value) {
            this.addCriterion("phone_tel =", value, "phoneTel");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneTelNotEqualTo(String value) {
            this.addCriterion("phone_tel <>", value, "phoneTel");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneTelGreaterThan(String value) {
            this.addCriterion("phone_tel >", value, "phoneTel");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneTelGreaterThanOrEqualTo(String value) {
            this.addCriterion("phone_tel >=", value, "phoneTel");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneTelLessThan(String value) {
            this.addCriterion("phone_tel <", value, "phoneTel");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneTelLessThanOrEqualTo(String value) {
            this.addCriterion("phone_tel <=", value, "phoneTel");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneTelLike(String value) {
            this.addCriterion("phone_tel like", value, "phoneTel");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneTelNotLike(String value) {
            this.addCriterion("phone_tel not like", value, "phoneTel");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andPhoneTelIn(List<String> values) {
            this.addCriterion("phone_tel in", values, "phoneTel");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneTelNotIn(List<String> values) {
            this.addCriterion("phone_tel not in", values, "phoneTel");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneTelBetween(String value1, String value2) {
            this.addCriterion("phone_tel between", value1, value2, "phoneTel");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneTelNotBetween(String value1, String value2) {
            this.addCriterion("phone_tel not between", value1, value2, "phoneTel");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneMobIsNull() {
            this.addCriterion("phone_mob is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneMobIsNotNull() {
            this.addCriterion("phone_mob is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneMobEqualTo(String value) {
            this.addCriterion("phone_mob =", value, "phoneMob");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneMobNotEqualTo(String value) {
            this.addCriterion("phone_mob <>", value, "phoneMob");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneMobGreaterThan(String value) {
            this.addCriterion("phone_mob >", value, "phoneMob");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneMobGreaterThanOrEqualTo(String value) {
            this.addCriterion("phone_mob >=", value, "phoneMob");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneMobLessThan(String value) {
            this.addCriterion("phone_mob <", value, "phoneMob");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneMobLessThanOrEqualTo(String value) {
            this.addCriterion("phone_mob <=", value, "phoneMob");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneMobLike(String value) {
            this.addCriterion("phone_mob like", value, "phoneMob");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneMobNotLike(String value) {
            this.addCriterion("phone_mob not like", value, "phoneMob");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andPhoneMobIn(List<String> values) {
            this.addCriterion("phone_mob in", values, "phoneMob");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneMobNotIn(List<String> values) {
            this.addCriterion("phone_mob not in", values, "phoneMob");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneMobBetween(String value1, String value2) {
            this.addCriterion("phone_mob between", value1, value2, "phoneMob");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPhoneMobNotBetween(String value1, String value2) {
            this.addCriterion("phone_mob not between", value1, value2, "phoneMob");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqIsNull() {
            this.addCriterion("im_qq is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqIsNotNull() {
            this.addCriterion("im_qq is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqEqualTo(String value) {
            this.addCriterion("im_qq =", value, "imQq");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqNotEqualTo(String value) {
            this.addCriterion("im_qq <>", value, "imQq");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqGreaterThan(String value) {
            this.addCriterion("im_qq >", value, "imQq");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_qq >=", value, "imQq");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqLessThan(String value) {
            this.addCriterion("im_qq <", value, "imQq");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqLessThanOrEqualTo(String value) {
            this.addCriterion("im_qq <=", value, "imQq");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqLike(String value) {
            this.addCriterion("im_qq like", value, "imQq");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqNotLike(String value) {
            this.addCriterion("im_qq not like", value, "imQq");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andImQqIn(List<String> values) {
            this.addCriterion("im_qq in", values, "imQq");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqNotIn(List<String> values) {
            this.addCriterion("im_qq not in", values, "imQq");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqBetween(String value1, String value2) {
            this.addCriterion("im_qq between", value1, value2, "imQq");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqNotBetween(String value1, String value2) {
            this.addCriterion("im_qq not between", value1, value2, "imQq");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImSkypeIsNull() {
            this.addCriterion("im_skype is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImSkypeIsNotNull() {
            this.addCriterion("im_skype is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImSkypeEqualTo(String value) {
            this.addCriterion("im_skype =", value, "imSkype");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImSkypeNotEqualTo(String value) {
            this.addCriterion("im_skype <>", value, "imSkype");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImSkypeGreaterThan(String value) {
            this.addCriterion("im_skype >", value, "imSkype");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImSkypeGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_skype >=", value, "imSkype");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImSkypeLessThan(String value) {
            this.addCriterion("im_skype <", value, "imSkype");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImSkypeLessThanOrEqualTo(String value) {
            this.addCriterion("im_skype <=", value, "imSkype");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImSkypeLike(String value) {
            this.addCriterion("im_skype like", value, "imSkype");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImSkypeNotLike(String value) {
            this.addCriterion("im_skype not like", value, "imSkype");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andImSkypeIn(List<String> values) {
            this.addCriterion("im_skype in", values, "imSkype");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImSkypeNotIn(List<String> values) {
            this.addCriterion("im_skype not in", values, "imSkype");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImSkypeBetween(String value1, String value2) {
            this.addCriterion("im_skype between", value1, value2, "imSkype");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImSkypeNotBetween(String value1, String value2) {
            this.addCriterion("im_skype not between", value1, value2, "imSkype");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImWeixinIsNull() {
            this.addCriterion("im_weixin is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImWeixinIsNotNull() {
            this.addCriterion("im_weixin is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImWeixinEqualTo(String value) {
            this.addCriterion("im_weixin =", value, "imWeixin");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImWeixinNotEqualTo(String value) {
            this.addCriterion("im_weixin <>", value, "imWeixin");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImWeixinGreaterThan(String value) {
            this.addCriterion("im_weixin >", value, "imWeixin");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImWeixinGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_weixin >=", value, "imWeixin");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImWeixinLessThan(String value) {
            this.addCriterion("im_weixin <", value, "imWeixin");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImWeixinLessThanOrEqualTo(String value) {
            this.addCriterion("im_weixin <=", value, "imWeixin");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImWeixinLike(String value) {
            this.addCriterion("im_weixin like", value, "imWeixin");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImWeixinNotLike(String value) {
            this.addCriterion("im_weixin not like", value, "imWeixin");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andImWeixinIn(List<String> values) {
            this.addCriterion("im_weixin in", values, "imWeixin");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImWeixinNotIn(List<String> values) {
            this.addCriterion("im_weixin not in", values, "imWeixin");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImWeixinBetween(String value1, String value2) {
            this.addCriterion("im_weixin between", value1, value2, "imWeixin");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImWeixinNotBetween(String value1, String value2) {
            this.addCriterion("im_weixin not between", value1, value2, "imWeixin");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImAliwwIsNull() {
            this.addCriterion("im_aliww is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImAliwwIsNotNull() {
            this.addCriterion("im_aliww is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImAliwwEqualTo(String value) {
            this.addCriterion("im_aliww =", value, "imAliww");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImAliwwNotEqualTo(String value) {
            this.addCriterion("im_aliww <>", value, "imAliww");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImAliwwGreaterThan(String value) {
            this.addCriterion("im_aliww >", value, "imAliww");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImAliwwGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_aliww >=", value, "imAliww");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImAliwwLessThan(String value) {
            this.addCriterion("im_aliww <", value, "imAliww");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImAliwwLessThanOrEqualTo(String value) {
            this.addCriterion("im_aliww <=", value, "imAliww");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImAliwwLike(String value) {
            this.addCriterion("im_aliww like", value, "imAliww");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImAliwwNotLike(String value) {
            this.addCriterion("im_aliww not like", value, "imAliww");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andImAliwwIn(List<String> values) {
            this.addCriterion("im_aliww in", values, "imAliww");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImAliwwNotIn(List<String> values) {
            this.addCriterion("im_aliww not in", values, "imAliww");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImAliwwBetween(String value1, String value2) {
            this.addCriterion("im_aliww between", value1, value2, "imAliww");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImAliwwNotBetween(String value1, String value2) {
            this.addCriterion("im_aliww not between", value1, value2, "imAliww");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboIsNull() {
            this.addCriterion("im_yahoo_weibo is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboIsNotNull() {
            this.addCriterion("im_yahoo_weibo is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboEqualTo(String value) {
            this.addCriterion("im_yahoo_weibo =", value, "imYahooWeibo");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboNotEqualTo(String value) {
            this.addCriterion("im_yahoo_weibo <>", value, "imYahooWeibo");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboGreaterThan(String value) {
            this.addCriterion("im_yahoo_weibo >", value, "imYahooWeibo");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_yahoo_weibo >=", value, "imYahooWeibo");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboLessThan(String value) {
            this.addCriterion("im_yahoo_weibo <", value, "imYahooWeibo");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboLessThanOrEqualTo(String value) {
            this.addCriterion("im_yahoo_weibo <=", value, "imYahooWeibo");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboLike(String value) {
            this.addCriterion("im_yahoo_weibo like", value, "imYahooWeibo");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboNotLike(String value) {
            this.addCriterion("im_yahoo_weibo not like", value, "imYahooWeibo");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andImYahooWeiboIn(List<String> values) {
            this.addCriterion("im_yahoo_weibo in", values, "imYahooWeibo");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboNotIn(List<String> values) {
            this.addCriterion("im_yahoo_weibo not in", values, "imYahooWeibo");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboBetween(String value1, String value2) {
            this.addCriterion("im_yahoo_weibo between", value1, value2, "imYahooWeibo");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImYahooWeiboNotBetween(String value1, String value2) {
            this.addCriterion("im_yahoo_weibo not between", value1, value2, "imYahooWeibo");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboIsNull() {
            this.addCriterion("im_qq_weibo is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboIsNotNull() {
            this.addCriterion("im_qq_weibo is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboEqualTo(String value) {
            this.addCriterion("im_qq_weibo =", value, "imQqWeibo");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboNotEqualTo(String value) {
            this.addCriterion("im_qq_weibo <>", value, "imQqWeibo");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboGreaterThan(String value) {
            this.addCriterion("im_qq_weibo >", value, "imQqWeibo");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_qq_weibo >=", value, "imQqWeibo");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboLessThan(String value) {
            this.addCriterion("im_qq_weibo <", value, "imQqWeibo");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboLessThanOrEqualTo(String value) {
            this.addCriterion("im_qq_weibo <=", value, "imQqWeibo");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboLike(String value) {
            this.addCriterion("im_qq_weibo like", value, "imQqWeibo");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboNotLike(String value) {
            this.addCriterion("im_qq_weibo not like", value, "imQqWeibo");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andImQqWeiboIn(List<String> values) {
            this.addCriterion("im_qq_weibo in", values, "imQqWeibo");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboNotIn(List<String> values) {
            this.addCriterion("im_qq_weibo not in", values, "imQqWeibo");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboBetween(String value1, String value2) {
            this.addCriterion("im_qq_weibo between", value1, value2, "imQqWeibo");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andImQqWeiboNotBetween(String value1, String value2) {
            this.addCriterion("im_qq_weibo not between", value1, value2, "imQqWeibo");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegTimeIsNull() {
            this.addCriterion("reg_time is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegTimeIsNotNull() {
            this.addCriterion("reg_time is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegTimeEqualTo(Date value) {
            this.addCriterion("reg_time =", value, "regTime");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegTimeNotEqualTo(Date value) {
            this.addCriterion("reg_time <>", value, "regTime");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegTimeGreaterThan(Date value) {
            this.addCriterion("reg_time >", value, "regTime");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("reg_time >=", value, "regTime");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegTimeLessThan(Date value) {
            this.addCriterion("reg_time <", value, "regTime");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("reg_time <=", value, "regTime");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegTimeLike(String value) {
            this.addCriterion("reg_time like", value, "regTime");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegTimeNotLike(String value) {
            this.addCriterion("reg_time not like", value, "regTime");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andRegTimeIn(List<Date> values) {
            this.addCriterion("reg_time in", values, "regTime");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegTimeNotIn(List<Date> values) {
            this.addCriterion("reg_time not in", values, "regTime");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegTimeBetween(Date value1, Date value2) {
            this.addCriterion("reg_time between", value1, value2, "regTime");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("reg_time not between", value1, value2, "regTime");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastTimeIsNull() {
            this.addCriterion("last_time is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastTimeIsNotNull() {
            this.addCriterion("last_time is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastTimeEqualTo(Date value) {
            this.addCriterion("last_time =", value, "lastTime");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastTimeNotEqualTo(Date value) {
            this.addCriterion("last_time <>", value, "lastTime");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastTimeGreaterThan(Date value) {
            this.addCriterion("last_time >", value, "lastTime");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("last_time >=", value, "lastTime");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastTimeLessThan(Date value) {
            this.addCriterion("last_time <", value, "lastTime");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("last_time <=", value, "lastTime");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastTimeLike(String value) {
            this.addCriterion("last_time like", value, "lastTime");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastTimeNotLike(String value) {
            this.addCriterion("last_time not like", value, "lastTime");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andLastTimeIn(List<Date> values) {
            this.addCriterion("last_time in", values, "lastTime");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastTimeNotIn(List<Date> values) {
            this.addCriterion("last_time not in", values, "lastTime");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastTimeBetween(Date value1, Date value2) {
            this.addCriterion("last_time between", value1, value2, "lastTime");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("last_time not between", value1, value2, "lastTime");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastIpIsNull() {
            this.addCriterion("last_ip is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastIpIsNotNull() {
            this.addCriterion("last_ip is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastIpEqualTo(String value) {
            this.addCriterion("last_ip =", value, "lastIp");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastIpNotEqualTo(String value) {
            this.addCriterion("last_ip <>", value, "lastIp");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastIpGreaterThan(String value) {
            this.addCriterion("last_ip >", value, "lastIp");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastIpGreaterThanOrEqualTo(String value) {
            this.addCriterion("last_ip >=", value, "lastIp");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastIpLessThan(String value) {
            this.addCriterion("last_ip <", value, "lastIp");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastIpLessThanOrEqualTo(String value) {
            this.addCriterion("last_ip <=", value, "lastIp");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastIpLike(String value) {
            this.addCriterion("last_ip like", value, "lastIp");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastIpNotLike(String value) {
            this.addCriterion("last_ip not like", value, "lastIp");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andLastIpIn(List<String> values) {
            this.addCriterion("last_ip in", values, "lastIp");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastIpNotIn(List<String> values) {
            this.addCriterion("last_ip not in", values, "lastIp");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastIpBetween(String value1, String value2) {
            this.addCriterion("last_ip between", value1, value2, "lastIp");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLastIpNotBetween(String value1, String value2) {
            this.addCriterion("last_ip not between", value1, value2, "lastIp");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginsIsNull() {
            this.addCriterion("logins is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginsIsNotNull() {
            this.addCriterion("logins is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginsEqualTo(Long value) {
            this.addCriterion("logins =", value, "logins");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginsNotEqualTo(Long value) {
            this.addCriterion("logins <>", value, "logins");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginsGreaterThan(Long value) {
            this.addCriterion("logins >", value, "logins");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginsGreaterThanOrEqualTo(Long value) {
            this.addCriterion("logins >=", value, "logins");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginsLessThan(Long value) {
            this.addCriterion("logins <", value, "logins");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginsLessThanOrEqualTo(Long value) {
            this.addCriterion("logins <=", value, "logins");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginsLike(String value) {
            this.addCriterion("logins like", value, "logins");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginsNotLike(String value) {
            this.addCriterion("logins not like", value, "logins");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andLoginsIn(List<Long> values) {
            this.addCriterion("logins in", values, "logins");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginsNotIn(List<Long> values) {
            this.addCriterion("logins not in", values, "logins");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginsBetween(Long value1, Long value2) {
            this.addCriterion("logins between", value1, value2, "logins");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andLoginsNotBetween(Long value1, Long value2) {
            this.addCriterion("logins not between", value1, value2, "logins");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountTypeIsNull() {
            this.addCriterion("account_type is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountTypeIsNotNull() {
            this.addCriterion("account_type is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountTypeEqualTo(Integer value) {
            this.addCriterion("account_type =", value, "accountType");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountTypeNotEqualTo(Integer value) {
            this.addCriterion("account_type <>", value, "accountType");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountTypeGreaterThan(Integer value) {
            this.addCriterion("account_type >", value, "accountType");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("account_type >=", value, "accountType");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountTypeLessThan(Integer value) {
            this.addCriterion("account_type <", value, "accountType");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("account_type <=", value, "accountType");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountTypeLike(String value) {
            this.addCriterion("account_type like", value, "accountType");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountTypeNotLike(String value) {
            this.addCriterion("account_type not like", value, "accountType");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andAccountTypeIn(List<Integer> values) {
            this.addCriterion("account_type in", values, "accountType");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountTypeNotIn(List<Integer> values) {
            this.addCriterion("account_type not in", values, "accountType");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("account_type between", value1, value2, "accountType");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("account_type not between", value1, value2, "accountType");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountNameIsNull() {
            this.addCriterion("account_name is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountNameIsNotNull() {
            this.addCriterion("account_name is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountNameEqualTo(String value) {
            this.addCriterion("account_name =", value, "accountName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountNameNotEqualTo(String value) {
            this.addCriterion("account_name <>", value, "accountName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountNameGreaterThan(String value) {
            this.addCriterion("account_name >", value, "accountName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("account_name >=", value, "accountName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountNameLessThan(String value) {
            this.addCriterion("account_name <", value, "accountName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountNameLessThanOrEqualTo(String value) {
            this.addCriterion("account_name <=", value, "accountName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountNameLike(String value) {
            this.addCriterion("account_name like", value, "accountName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountNameNotLike(String value) {
            this.addCriterion("account_name not like", value, "accountName");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andAccountNameIn(List<String> values) {
            this.addCriterion("account_name in", values, "accountName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountNameNotIn(List<String> values) {
            this.addCriterion("account_name not in", values, "accountName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountNameBetween(String value1, String value2) {
            this.addCriterion("account_name between", value1, value2, "accountName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountNameNotBetween(String value1, String value2) {
            this.addCriterion("account_name not between", value1, value2, "accountName");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountIdIsNull() {
            this.addCriterion("account_id is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountIdIsNotNull() {
            this.addCriterion("account_id is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountIdEqualTo(Long value) {
            this.addCriterion("account_id =", value, "accountId");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountIdNotEqualTo(Long value) {
            this.addCriterion("account_id <>", value, "accountId");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountIdGreaterThan(Long value) {
            this.addCriterion("account_id >", value, "accountId");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("account_id >=", value, "accountId");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountIdLessThan(Long value) {
            this.addCriterion("account_id <", value, "accountId");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountIdLessThanOrEqualTo(Long value) {
            this.addCriterion("account_id <=", value, "accountId");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountIdLike(String value) {
            this.addCriterion("account_id like", value, "accountId");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountIdNotLike(String value) {
            this.addCriterion("account_id not like", value, "accountId");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andAccountIdIn(List<Long> values) {
            this.addCriterion("account_id in", values, "accountId");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountIdNotIn(List<Long> values) {
            this.addCriterion("account_id not in", values, "accountId");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountIdBetween(Long value1, Long value2) {
            this.addCriterion("account_id between", value1, value2, "accountId");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andAccountIdNotBetween(Long value1, Long value2) {
            this.addCriterion("account_id not between", value1, value2, "accountId");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathIsNull() {
            this.addCriterion("portrait_savepath is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathIsNotNull() {
            this.addCriterion("portrait_savepath is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathEqualTo(String value) {
            this.addCriterion("portrait_savepath =", value, "portraitSavepath");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathNotEqualTo(String value) {
            this.addCriterion("portrait_savepath <>", value, "portraitSavepath");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathGreaterThan(String value) {
            this.addCriterion("portrait_savepath >", value, "portraitSavepath");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathGreaterThanOrEqualTo(String value) {
            this.addCriterion("portrait_savepath >=", value, "portraitSavepath");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathLessThan(String value) {
            this.addCriterion("portrait_savepath <", value, "portraitSavepath");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathLessThanOrEqualTo(String value) {
            this.addCriterion("portrait_savepath <=", value, "portraitSavepath");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathLike(String value) {
            this.addCriterion("portrait_savepath like", value, "portraitSavepath");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathNotLike(String value) {
            this.addCriterion("portrait_savepath not like", value, "portraitSavepath");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andPortraitSavepathIn(List<String> values) {
            this.addCriterion("portrait_savepath in", values, "portraitSavepath");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathNotIn(List<String> values) {
            this.addCriterion("portrait_savepath not in", values, "portraitSavepath");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathBetween(String value1, String value2) {
            this.addCriterion("portrait_savepath between", value1, value2, "portraitSavepath");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitSavepathNotBetween(String value1, String value2) {
            this.addCriterion("portrait_savepath not between", value1, value2, "portraitSavepath");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlIsNull() {
            this.addCriterion("portrait_url is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlIsNotNull() {
            this.addCriterion("portrait_url is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlEqualTo(String value) {
            this.addCriterion("portrait_url =", value, "portraitUrl");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlNotEqualTo(String value) {
            this.addCriterion("portrait_url <>", value, "portraitUrl");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlGreaterThan(String value) {
            this.addCriterion("portrait_url >", value, "portraitUrl");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("portrait_url >=", value, "portraitUrl");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlLessThan(String value) {
            this.addCriterion("portrait_url <", value, "portraitUrl");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlLessThanOrEqualTo(String value) {
            this.addCriterion("portrait_url <=", value, "portraitUrl");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlLike(String value) {
            this.addCriterion("portrait_url like", value, "portraitUrl");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlNotLike(String value) {
            this.addCriterion("portrait_url not like", value, "portraitUrl");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andPortraitUrlIn(List<String> values) {
            this.addCriterion("portrait_url in", values, "portraitUrl");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlNotIn(List<String> values) {
            this.addCriterion("portrait_url not in", values, "portraitUrl");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlBetween(String value1, String value2) {
            this.addCriterion("portrait_url between", value1, value2, "portraitUrl");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPortraitUrlNotBetween(String value1, String value2) {
            this.addCriterion("portrait_url not between", value1, value2, "portraitUrl");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUseStatusIsNull() {
            this.addCriterion("use_status is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUseStatusIsNotNull() {
            this.addCriterion("use_status is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUseStatusEqualTo(Long value) {
            this.addCriterion("use_status =", value, "useStatus");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUseStatusNotEqualTo(Long value) {
            this.addCriterion("use_status <>", value, "useStatus");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUseStatusGreaterThan(Long value) {
            this.addCriterion("use_status >", value, "useStatus");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUseStatusGreaterThanOrEqualTo(Long value) {
            this.addCriterion("use_status >=", value, "useStatus");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUseStatusLessThan(Long value) {
            this.addCriterion("use_status <", value, "useStatus");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUseStatusLessThanOrEqualTo(Long value) {
            this.addCriterion("use_status <=", value, "useStatus");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUseStatusLike(String value) {
            this.addCriterion("use_status like", value, "useStatus");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUseStatusNotLike(String value) {
            this.addCriterion("use_status not like", value, "useStatus");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andUseStatusIn(List<Long> values) {
            this.addCriterion("use_status in", values, "useStatus");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUseStatusNotIn(List<Long> values) {
            this.addCriterion("use_status not in", values, "useStatus");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUseStatusBetween(Long value1, Long value2) {
            this.addCriterion("use_status between", value1, value2, "useStatus");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andUseStatusNotBetween(Long value1, Long value2) {
            this.addCriterion("use_status not between", value1, value2, "useStatus");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsOpenStoreIsNull() {
            this.addCriterion("is_open_store is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsOpenStoreIsNotNull() {
            this.addCriterion("is_open_store is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsOpenStoreEqualTo(Integer value) {
            this.addCriterion("is_open_store =", value, "isOpenStore");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsOpenStoreNotEqualTo(Integer value) {
            this.addCriterion("is_open_store <>", value, "isOpenStore");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsOpenStoreGreaterThan(Integer value) {
            this.addCriterion("is_open_store >", value, "isOpenStore");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsOpenStoreGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_open_store >=", value, "isOpenStore");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsOpenStoreLessThan(Integer value) {
            this.addCriterion("is_open_store <", value, "isOpenStore");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsOpenStoreLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_open_store <=", value, "isOpenStore");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsOpenStoreLike(String value) {
            this.addCriterion("is_open_store like", value, "isOpenStore");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsOpenStoreNotLike(String value) {
            this.addCriterion("is_open_store not like", value, "isOpenStore");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andIsOpenStoreIn(List<Integer> values) {
            this.addCriterion("is_open_store in", values, "isOpenStore");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsOpenStoreNotIn(List<Integer> values) {
            this.addCriterion("is_open_store not in", values, "isOpenStore");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsOpenStoreBetween(Integer value1, Integer value2) {
            this.addCriterion("is_open_store between", value1, value2, "isOpenStore");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsOpenStoreNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_open_store not between", value1, value2, "isOpenStore");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark11IsNull() {
            this.addCriterion("remark11 is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark11IsNotNull() {
            this.addCriterion("remark11 is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark11EqualTo(String value) {
            this.addCriterion("remark11 =", value, "remark11");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark11NotEqualTo(String value) {
            this.addCriterion("remark11 <>", value, "remark11");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark11GreaterThan(String value) {
            this.addCriterion("remark11 >", value, "remark11");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark11GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark11 >=", value, "remark11");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark11LessThan(String value) {
            this.addCriterion("remark11 <", value, "remark11");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark11LessThanOrEqualTo(String value) {
            this.addCriterion("remark11 <=", value, "remark11");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark11Like(String value) {
            this.addCriterion("remark11 like", value, "remark11");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark11NotLike(String value) {
            this.addCriterion("remark11 not like", value, "remark11");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andRemark11In(List<String> values) {
            this.addCriterion("remark11 in", values, "remark11");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark11NotIn(List<String> values) {
            this.addCriterion("remark11 not in", values, "remark11");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark11Between(String value1, String value2) {
            this.addCriterion("remark11 between", value1, value2, "remark11");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark11NotBetween(String value1, String value2) {
            this.addCriterion("remark11 not between", value1, value2, "remark11");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark12IsNull() {
            this.addCriterion("remark12 is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark12IsNotNull() {
            this.addCriterion("remark12 is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark12EqualTo(String value) {
            this.addCriterion("remark12 =", value, "remark12");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark12NotEqualTo(String value) {
            this.addCriterion("remark12 <>", value, "remark12");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark12GreaterThan(String value) {
            this.addCriterion("remark12 >", value, "remark12");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark12GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark12 >=", value, "remark12");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark12LessThan(String value) {
            this.addCriterion("remark12 <", value, "remark12");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark12LessThanOrEqualTo(String value) {
            this.addCriterion("remark12 <=", value, "remark12");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark12Like(String value) {
            this.addCriterion("remark12 like", value, "remark12");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark12NotLike(String value) {
            this.addCriterion("remark12 not like", value, "remark12");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andRemark12In(List<String> values) {
            this.addCriterion("remark12 in", values, "remark12");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark12NotIn(List<String> values) {
            this.addCriterion("remark12 not in", values, "remark12");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark12Between(String value1, String value2) {
            this.addCriterion("remark12 between", value1, value2, "remark12");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark12NotBetween(String value1, String value2) {
            this.addCriterion("remark12 not between", value1, value2, "remark12");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark13IsNull() {
            this.addCriterion("remark13 is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark13IsNotNull() {
            this.addCriterion("remark13 is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark13EqualTo(String value) {
            this.addCriterion("remark13 =", value, "remark13");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark13NotEqualTo(String value) {
            this.addCriterion("remark13 <>", value, "remark13");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark13GreaterThan(String value) {
            this.addCriterion("remark13 >", value, "remark13");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark13GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark13 >=", value, "remark13");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark13LessThan(String value) {
            this.addCriterion("remark13 <", value, "remark13");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark13LessThanOrEqualTo(String value) {
            this.addCriterion("remark13 <=", value, "remark13");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark13Like(String value) {
            this.addCriterion("remark13 like", value, "remark13");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark13NotLike(String value) {
            this.addCriterion("remark13 not like", value, "remark13");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andRemark13In(List<String> values) {
            this.addCriterion("remark13 in", values, "remark13");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark13NotIn(List<String> values) {
            this.addCriterion("remark13 not in", values, "remark13");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark13Between(String value1, String value2) {
            this.addCriterion("remark13 between", value1, value2, "remark13");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark13NotBetween(String value1, String value2) {
            this.addCriterion("remark13 not between", value1, value2, "remark13");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark14IsNull() {
            this.addCriterion("remark14 is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark14IsNotNull() {
            this.addCriterion("remark14 is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark14EqualTo(String value) {
            this.addCriterion("remark14 =", value, "remark14");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark14NotEqualTo(String value) {
            this.addCriterion("remark14 <>", value, "remark14");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark14GreaterThan(String value) {
            this.addCriterion("remark14 >", value, "remark14");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark14GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark14 >=", value, "remark14");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark14LessThan(String value) {
            this.addCriterion("remark14 <", value, "remark14");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark14LessThanOrEqualTo(String value) {
            this.addCriterion("remark14 <=", value, "remark14");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark14Like(String value) {
            this.addCriterion("remark14 like", value, "remark14");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark14NotLike(String value) {
            this.addCriterion("remark14 not like", value, "remark14");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andRemark14In(List<String> values) {
            this.addCriterion("remark14 in", values, "remark14");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark14NotIn(List<String> values) {
            this.addCriterion("remark14 not in", values, "remark14");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark14Between(String value1, String value2) {
            this.addCriterion("remark14 between", value1, value2, "remark14");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark14NotBetween(String value1, String value2) {
            this.addCriterion("remark14 not between", value1, value2, "remark14");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark15IsNull() {
            this.addCriterion("remark15 is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark15IsNotNull() {
            this.addCriterion("remark15 is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark15EqualTo(String value) {
            this.addCriterion("remark15 =", value, "remark15");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark15NotEqualTo(String value) {
            this.addCriterion("remark15 <>", value, "remark15");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark15GreaterThan(String value) {
            this.addCriterion("remark15 >", value, "remark15");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark15GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark15 >=", value, "remark15");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark15LessThan(String value) {
            this.addCriterion("remark15 <", value, "remark15");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark15LessThanOrEqualTo(String value) {
            this.addCriterion("remark15 <=", value, "remark15");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark15Like(String value) {
            this.addCriterion("remark15 like", value, "remark15");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark15NotLike(String value) {
            this.addCriterion("remark15 not like", value, "remark15");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andRemark15In(List<String> values) {
            this.addCriterion("remark15 in", values, "remark15");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark15NotIn(List<String> values) {
            this.addCriterion("remark15 not in", values, "remark15");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark15Between(String value1, String value2) {
            this.addCriterion("remark15 between", value1, value2, "remark15");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark15NotBetween(String value1, String value2) {
            this.addCriterion("remark15 not between", value1, value2, "remark15");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark16IsNull() {
            this.addCriterion("remark16 is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark16IsNotNull() {
            this.addCriterion("remark16 is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark16EqualTo(String value) {
            this.addCriterion("remark16 =", value, "remark16");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark16NotEqualTo(String value) {
            this.addCriterion("remark16 <>", value, "remark16");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark16GreaterThan(String value) {
            this.addCriterion("remark16 >", value, "remark16");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark16GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark16 >=", value, "remark16");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark16LessThan(String value) {
            this.addCriterion("remark16 <", value, "remark16");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark16LessThanOrEqualTo(String value) {
            this.addCriterion("remark16 <=", value, "remark16");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark16Like(String value) {
            this.addCriterion("remark16 like", value, "remark16");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark16NotLike(String value) {
            this.addCriterion("remark16 not like", value, "remark16");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andRemark16In(List<String> values) {
            this.addCriterion("remark16 in", values, "remark16");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark16NotIn(List<String> values) {
            this.addCriterion("remark16 not in", values, "remark16");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark16Between(String value1, String value2) {
            this.addCriterion("remark16 between", value1, value2, "remark16");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark16NotBetween(String value1, String value2) {
            this.addCriterion("remark16 not between", value1, value2, "remark16");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark17IsNull() {
            this.addCriterion("remark17 is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark17IsNotNull() {
            this.addCriterion("remark17 is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark17EqualTo(String value) {
            this.addCriterion("remark17 =", value, "remark17");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark17NotEqualTo(String value) {
            this.addCriterion("remark17 <>", value, "remark17");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark17GreaterThan(String value) {
            this.addCriterion("remark17 >", value, "remark17");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark17GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark17 >=", value, "remark17");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark17LessThan(String value) {
            this.addCriterion("remark17 <", value, "remark17");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark17LessThanOrEqualTo(String value) {
            this.addCriterion("remark17 <=", value, "remark17");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark17Like(String value) {
            this.addCriterion("remark17 like", value, "remark17");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark17NotLike(String value) {
            this.addCriterion("remark17 not like", value, "remark17");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andRemark17In(List<String> values) {
            this.addCriterion("remark17 in", values, "remark17");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark17NotIn(List<String> values) {
            this.addCriterion("remark17 not in", values, "remark17");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark17Between(String value1, String value2) {
            this.addCriterion("remark17 between", value1, value2, "remark17");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark17NotBetween(String value1, String value2) {
            this.addCriterion("remark17 not between", value1, value2, "remark17");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark18IsNull() {
            this.addCriterion("remark18 is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark18IsNotNull() {
            this.addCriterion("remark18 is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark18EqualTo(String value) {
            this.addCriterion("remark18 =", value, "remark18");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark18NotEqualTo(String value) {
            this.addCriterion("remark18 <>", value, "remark18");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark18GreaterThan(String value) {
            this.addCriterion("remark18 >", value, "remark18");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark18GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark18 >=", value, "remark18");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark18LessThan(String value) {
            this.addCriterion("remark18 <", value, "remark18");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark18LessThanOrEqualTo(String value) {
            this.addCriterion("remark18 <=", value, "remark18");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark18Like(String value) {
            this.addCriterion("remark18 like", value, "remark18");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark18NotLike(String value) {
            this.addCriterion("remark18 not like", value, "remark18");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andRemark18In(List<String> values) {
            this.addCriterion("remark18 in", values, "remark18");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark18NotIn(List<String> values) {
            this.addCriterion("remark18 not in", values, "remark18");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark18Between(String value1, String value2) {
            this.addCriterion("remark18 between", value1, value2, "remark18");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark18NotBetween(String value1, String value2) {
            this.addCriterion("remark18 not between", value1, value2, "remark18");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark19IsNull() {
            this.addCriterion("remark19 is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark19IsNotNull() {
            this.addCriterion("remark19 is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark19EqualTo(String value) {
            this.addCriterion("remark19 =", value, "remark19");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark19NotEqualTo(String value) {
            this.addCriterion("remark19 <>", value, "remark19");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark19GreaterThan(String value) {
            this.addCriterion("remark19 >", value, "remark19");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark19GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark19 >=", value, "remark19");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark19LessThan(String value) {
            this.addCriterion("remark19 <", value, "remark19");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark19LessThanOrEqualTo(String value) {
            this.addCriterion("remark19 <=", value, "remark19");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark19Like(String value) {
            this.addCriterion("remark19 like", value, "remark19");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark19NotLike(String value) {
            this.addCriterion("remark19 not like", value, "remark19");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andRemark19In(List<String> values) {
            this.addCriterion("remark19 in", values, "remark19");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark19NotIn(List<String> values) {
            this.addCriterion("remark19 not in", values, "remark19");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark19Between(String value1, String value2) {
            this.addCriterion("remark19 between", value1, value2, "remark19");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark19NotBetween(String value1, String value2) {
            this.addCriterion("remark19 not between", value1, value2, "remark19");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark20IsNull() {
            this.addCriterion("remark20 is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark20IsNotNull() {
            this.addCriterion("remark20 is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark20EqualTo(String value) {
            this.addCriterion("remark20 =", value, "remark20");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark20NotEqualTo(String value) {
            this.addCriterion("remark20 <>", value, "remark20");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark20GreaterThan(String value) {
            this.addCriterion("remark20 >", value, "remark20");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark20GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark20 >=", value, "remark20");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark20LessThan(String value) {
            this.addCriterion("remark20 <", value, "remark20");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark20LessThanOrEqualTo(String value) {
            this.addCriterion("remark20 <=", value, "remark20");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark20Like(String value) {
            this.addCriterion("remark20 like", value, "remark20");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark20NotLike(String value) {
            this.addCriterion("remark20 not like", value, "remark20");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andRemark20In(List<String> values) {
            this.addCriterion("remark20 in", values, "remark20");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark20NotIn(List<String> values) {
            this.addCriterion("remark20 not in", values, "remark20");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark20Between(String value1, String value2) {
            this.addCriterion("remark20 between", value1, value2, "remark20");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRemark20NotBetween(String value1, String value2) {
            this.addCriterion("remark20 not between", value1, value2, "remark20");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSexIsNull() {
            this.addCriterion("sex is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSexIsNotNull() {
            this.addCriterion("sex is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSexEqualTo(String value) {
            this.addCriterion("sex =", value, "sex");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSexNotEqualTo(String value) {
            this.addCriterion("sex <>", value, "sex");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSexGreaterThan(String value) {
            this.addCriterion("sex >", value, "sex");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSexGreaterThanOrEqualTo(String value) {
            this.addCriterion("sex >=", value, "sex");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSexLessThan(String value) {
            this.addCriterion("sex <", value, "sex");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSexLessThanOrEqualTo(String value) {
            this.addCriterion("sex <=", value, "sex");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSexLike(String value) {
            this.addCriterion("sex like", value, "sex");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSexNotLike(String value) {
            this.addCriterion("sex not like", value, "sex");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andSexIn(List<String> values) {
            this.addCriterion("sex in", values, "sex");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSexNotIn(List<String> values) {
            this.addCriterion("sex not in", values, "sex");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSexBetween(String value1, String value2) {
            this.addCriterion("sex between", value1, value2, "sex");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andSexNotBetween(String value1, String value2) {
            this.addCriterion("sex not between", value1, value2, "sex");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsNameValidateIsNull() {
            this.addCriterion("is_name_validate is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsNameValidateIsNotNull() {
            this.addCriterion("is_name_validate is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsNameValidateEqualTo(Integer value) {
            this.addCriterion("is_name_validate =", value, "isNameValidate");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsNameValidateNotEqualTo(Integer value) {
            this.addCriterion("is_name_validate <>", value, "isNameValidate");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsNameValidateGreaterThan(Integer value) {
            this.addCriterion("is_name_validate >", value, "isNameValidate");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsNameValidateGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_name_validate >=", value, "isNameValidate");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsNameValidateLessThan(Integer value) {
            this.addCriterion("is_name_validate <", value, "isNameValidate");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsNameValidateLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_name_validate <=", value, "isNameValidate");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsNameValidateLike(String value) {
            this.addCriterion("is_name_validate like", value, "isNameValidate");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsNameValidateNotLike(String value) {
            this.addCriterion("is_name_validate not like", value, "isNameValidate");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andIsNameValidateIn(List<Integer> values) {
            this.addCriterion("is_name_validate in", values, "isNameValidate");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsNameValidateNotIn(List<Integer> values) {
            this.addCriterion("is_name_validate not in", values, "isNameValidate");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsNameValidateBetween(Integer value1, Integer value2) {
            this.addCriterion("is_name_validate between", value1, value2, "isNameValidate");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsNameValidateNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_name_validate not between", value1, value2, "isNameValidate");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordStrengthIsNull() {
            this.addCriterion("password_strength is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordStrengthIsNotNull() {
            this.addCriterion("password_strength is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordStrengthEqualTo(Integer value) {
            this.addCriterion("password_strength =", value, "passwordStrength");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordStrengthNotEqualTo(Integer value) {
            this.addCriterion("password_strength <>", value, "passwordStrength");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordStrengthGreaterThan(Integer value) {
            this.addCriterion("password_strength >", value, "passwordStrength");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordStrengthGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("password_strength >=", value, "passwordStrength");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordStrengthLessThan(Integer value) {
            this.addCriterion("password_strength <", value, "passwordStrength");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordStrengthLessThanOrEqualTo(Integer value) {
            this.addCriterion("password_strength <=", value, "passwordStrength");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordStrengthLike(String value) {
            this.addCriterion("password_strength like", value, "passwordStrength");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordStrengthNotLike(String value) {
            this.addCriterion("password_strength not like", value, "passwordStrength");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andPasswordStrengthIn(List<Integer> values) {
            this.addCriterion("password_strength in", values, "passwordStrength");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordStrengthNotIn(List<Integer> values) {
            this.addCriterion("password_strength not in", values, "passwordStrength");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordStrengthBetween(Integer value1, Integer value2) {
            this.addCriterion("password_strength between", value1, value2, "passwordStrength");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andPasswordStrengthNotBetween(Integer value1, Integer value2) {
            this.addCriterion("password_strength not between", value1, value2, "passwordStrength");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsMailValidateIsNull() {
            this.addCriterion("is_mail_validate is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsMailValidateIsNotNull() {
            this.addCriterion("is_mail_validate is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsMailValidateEqualTo(Integer value) {
            this.addCriterion("is_mail_validate =", value, "isMailValidate");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsMailValidateNotEqualTo(Integer value) {
            this.addCriterion("is_mail_validate <>", value, "isMailValidate");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsMailValidateGreaterThan(Integer value) {
            this.addCriterion("is_mail_validate >", value, "isMailValidate");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsMailValidateGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_mail_validate >=", value, "isMailValidate");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsMailValidateLessThan(Integer value) {
            this.addCriterion("is_mail_validate <", value, "isMailValidate");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsMailValidateLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_mail_validate <=", value, "isMailValidate");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsMailValidateLike(String value) {
            this.addCriterion("is_mail_validate like", value, "isMailValidate");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsMailValidateNotLike(String value) {
            this.addCriterion("is_mail_validate not like", value, "isMailValidate");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andIsMailValidateIn(List<Integer> values) {
            this.addCriterion("is_mail_validate in", values, "isMailValidate");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsMailValidateNotIn(List<Integer> values) {
            this.addCriterion("is_mail_validate not in", values, "isMailValidate");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsMailValidateBetween(Integer value1, Integer value2) {
            this.addCriterion("is_mail_validate between", value1, value2, "isMailValidate");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsMailValidateNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_mail_validate not between", value1, value2, "isMailValidate");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPhoneMobIsNull() {
            this.addCriterion("is_phone_mob is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPhoneMobIsNotNull() {
            this.addCriterion("is_phone_mob is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPhoneMobEqualTo(Integer value) {
            this.addCriterion("is_phone_mob =", value, "isPhoneMob");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPhoneMobNotEqualTo(Integer value) {
            this.addCriterion("is_phone_mob <>", value, "isPhoneMob");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPhoneMobGreaterThan(Integer value) {
            this.addCriterion("is_phone_mob >", value, "isPhoneMob");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPhoneMobGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_phone_mob >=", value, "isPhoneMob");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPhoneMobLessThan(Integer value) {
            this.addCriterion("is_phone_mob <", value, "isPhoneMob");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPhoneMobLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_phone_mob <=", value, "isPhoneMob");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPhoneMobLike(String value) {
            this.addCriterion("is_phone_mob like", value, "isPhoneMob");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPhoneMobNotLike(String value) {
            this.addCriterion("is_phone_mob not like", value, "isPhoneMob");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andIsPhoneMobIn(List<Integer> values) {
            this.addCriterion("is_phone_mob in", values, "isPhoneMob");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPhoneMobNotIn(List<Integer> values) {
            this.addCriterion("is_phone_mob not in", values, "isPhoneMob");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPhoneMobBetween(Integer value1, Integer value2) {
            this.addCriterion("is_phone_mob between", value1, value2, "isPhoneMob");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPhoneMobNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_phone_mob not between", value1, value2, "isPhoneMob");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPayPasswordIsNull() {
            this.addCriterion("is_pay_password is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPayPasswordIsNotNull() {
            this.addCriterion("is_pay_password is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPayPasswordEqualTo(Integer value) {
            this.addCriterion("is_pay_password =", value, "isPayPassword");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPayPasswordNotEqualTo(Integer value) {
            this.addCriterion("is_pay_password <>", value, "isPayPassword");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPayPasswordGreaterThan(Integer value) {
            this.addCriterion("is_pay_password >", value, "isPayPassword");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPayPasswordGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_pay_password >=", value, "isPayPassword");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPayPasswordLessThan(Integer value) {
            this.addCriterion("is_pay_password <", value, "isPayPassword");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPayPasswordLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_pay_password <=", value, "isPayPassword");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPayPasswordLike(String value) {
            this.addCriterion("is_pay_password like", value, "isPayPassword");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPayPasswordNotLike(String value) {
            this.addCriterion("is_pay_password not like", value, "isPayPassword");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andIsPayPasswordIn(List<Integer> values) {
            this.addCriterion("is_pay_password in", values, "isPayPassword");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPayPasswordNotIn(List<Integer> values) {
            this.addCriterion("is_pay_password not in", values, "isPayPassword");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPayPasswordBetween(Integer value1, Integer value2) {
            this.addCriterion("is_pay_password between", value1, value2, "isPayPassword");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIsPayPasswordNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_pay_password not between", value1, value2, "isPayPassword");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardImgIsNull() {
            this.addCriterion("id_card_img is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardImgIsNotNull() {
            this.addCriterion("id_card_img is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardImgEqualTo(String value) {
            this.addCriterion("id_card_img =", value, "idCardImg");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardImgNotEqualTo(String value) {
            this.addCriterion("id_card_img <>", value, "idCardImg");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardImgGreaterThan(String value) {
            this.addCriterion("id_card_img >", value, "idCardImg");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardImgGreaterThanOrEqualTo(String value) {
            this.addCriterion("id_card_img >=", value, "idCardImg");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardImgLessThan(String value) {
            this.addCriterion("id_card_img <", value, "idCardImg");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardImgLessThanOrEqualTo(String value) {
            this.addCriterion("id_card_img <=", value, "idCardImg");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardImgLike(String value) {
            this.addCriterion("id_card_img like", value, "idCardImg");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardImgNotLike(String value) {
            this.addCriterion("id_card_img not like", value, "idCardImg");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andIdCardImgIn(List<String> values) {
            this.addCriterion("id_card_img in", values, "idCardImg");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardImgNotIn(List<String> values) {
            this.addCriterion("id_card_img not in", values, "idCardImg");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardImgBetween(String value1, String value2) {
            this.addCriterion("id_card_img between", value1, value2, "idCardImg");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andIdCardImgNotBetween(String value1, String value2) {
            this.addCriterion("id_card_img not between", value1, value2, "idCardImg");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegisterSourceIsNull() {
            this.addCriterion("register_source is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegisterSourceIsNotNull() {
            this.addCriterion("register_source is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegisterSourceEqualTo(Long value) {
            this.addCriterion("register_source =", value, "registerSource");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegisterSourceNotEqualTo(Long value) {
            this.addCriterion("register_source <>", value, "registerSource");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegisterSourceGreaterThan(Long value) {
            this.addCriterion("register_source >", value, "registerSource");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegisterSourceGreaterThanOrEqualTo(Long value) {
            this.addCriterion("register_source >=", value, "registerSource");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegisterSourceLessThan(Long value) {
            this.addCriterion("register_source <", value, "registerSource");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegisterSourceLessThanOrEqualTo(Long value) {
            this.addCriterion("register_source <=", value, "registerSource");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegisterSourceLike(String value) {
            this.addCriterion("register_source like", value, "registerSource");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegisterSourceNotLike(String value) {
            this.addCriterion("register_source not like", value, "registerSource");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andRegisterSourceIn(List<Long> values) {
            this.addCriterion("register_source in", values, "registerSource");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegisterSourceNotIn(List<Long> values) {
            this.addCriterion("register_source not in", values, "registerSource");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegisterSourceBetween(Long value1, Long value2) {
            this.addCriterion("register_source between", value1, value2, "registerSource");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andRegisterSourceNotBetween(Long value1, Long value2) {
            this.addCriterion("register_source not between", value1, value2, "registerSource");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andZfbAccountIsNull() {
            this.addCriterion("zfb_account is null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andZfbAccountIsNotNull() {
            this.addCriterion("zfb_account is not null");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andZfbAccountEqualTo(String value) {
            this.addCriterion("zfb_account =", value, "zfbAccount");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andZfbAccountNotEqualTo(String value) {
            this.addCriterion("zfb_account <>", value, "zfbAccount");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andZfbAccountGreaterThan(String value) {
            this.addCriterion("zfb_account >", value, "zfbAccount");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andZfbAccountGreaterThanOrEqualTo(String value) {
            this.addCriterion("zfb_account >=", value, "zfbAccount");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andZfbAccountLessThan(String value) {
            this.addCriterion("zfb_account <", value, "zfbAccount");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andZfbAccountLessThanOrEqualTo(String value) {
            this.addCriterion("zfb_account <=", value, "zfbAccount");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andZfbAccountLike(String value) {
            this.addCriterion("zfb_account like", value, "zfbAccount");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andZfbAccountNotLike(String value) {
            this.addCriterion("zfb_account not like", value, "zfbAccount");
            return (MemberUserCopy2Example.Criteria)this;
        }        public MemberUserCopy2Example.Criteria andZfbAccountIn(List<String> values) {
            this.addCriterion("zfb_account in", values, "zfbAccount");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andZfbAccountNotIn(List<String> values) {
            this.addCriterion("zfb_account not in", values, "zfbAccount");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andZfbAccountBetween(String value1, String value2) {
            this.addCriterion("zfb_account between", value1, value2, "zfbAccount");
            return (MemberUserCopy2Example.Criteria)this;
        }

        public MemberUserCopy2Example.Criteria andZfbAccountNotBetween(String value1, String value2) {
            this.addCriterion("zfb_account not between", value1, value2, "zfbAccount");
            return (MemberUserCopy2Example.Criteria)this;
        }
    }
}
