package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberUserExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

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

        public Criteria andUserNameIsNull() {
            this.addCriterion("user_name is null");
            return (Criteria)this;
        }

        public Criteria andUserNameIsNotNull() {
            this.addCriterion("user_name is not null");
            return (Criteria)this;
        }

        public Criteria andUserNameEqualTo(String value) {
            this.addCriterion("user_name =", value, "userName");
            return (Criteria)this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            this.addCriterion("user_name <>", value, "userName");
            return (Criteria)this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            this.addCriterion("user_name >", value, "userName");
            return (Criteria)this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("user_name >=", value, "userName");
            return (Criteria)this;
        }

        public Criteria andUserNameLessThan(String value) {
            this.addCriterion("user_name <", value, "userName");
            return (Criteria)this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            this.addCriterion("user_name <=", value, "userName");
            return (Criteria)this;
        }

        public Criteria andUserNameLike(String value) {
            this.addCriterion("user_name like", value, "userName");
            return (Criteria)this;
        }

        public Criteria andUserNameNotLike(String value) {
            this.addCriterion("user_name not like", value, "userName");
            return (Criteria)this;
        }        public Criteria andUserNameIn(List<String> values) {
            this.addCriterion("user_name in", values, "userName");
            return (Criteria)this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            this.addCriterion("user_name not in", values, "userName");
            return (Criteria)this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            this.addCriterion("user_name between", value1, value2, "userName");
            return (Criteria)this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            this.addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria)this;
        }

        public Criteria andUserNickIsNull() {
            this.addCriterion("user_nick is null");
            return (Criteria)this;
        }

        public Criteria andUserNickIsNotNull() {
            this.addCriterion("user_nick is not null");
            return (Criteria)this;
        }

        public Criteria andUserNickEqualTo(String value) {
            this.addCriterion("user_nick =", value, "userNick");
            return (Criteria)this;
        }

        public Criteria andUserNickNotEqualTo(String value) {
            this.addCriterion("user_nick <>", value, "userNick");
            return (Criteria)this;
        }

        public Criteria andUserNickGreaterThan(String value) {
            this.addCriterion("user_nick >", value, "userNick");
            return (Criteria)this;
        }

        public Criteria andUserNickGreaterThanOrEqualTo(String value) {
            this.addCriterion("user_nick >=", value, "userNick");
            return (Criteria)this;
        }

        public Criteria andUserNickLessThan(String value) {
            this.addCriterion("user_nick <", value, "userNick");
            return (Criteria)this;
        }

        public Criteria andUserNickLessThanOrEqualTo(String value) {
            this.addCriterion("user_nick <=", value, "userNick");
            return (Criteria)this;
        }

        public Criteria andUserNickLike(String value) {
            this.addCriterion("user_nick like", value, "userNick");
            return (Criteria)this;
        }

        public Criteria andUserNickNotLike(String value) {
            this.addCriterion("user_nick not like", value, "userNick");
            return (Criteria)this;
        }        public Criteria andUserNickIn(List<String> values) {
            this.addCriterion("user_nick in", values, "userNick");
            return (Criteria)this;
        }

        public Criteria andUserNickNotIn(List<String> values) {
            this.addCriterion("user_nick not in", values, "userNick");
            return (Criteria)this;
        }

        public Criteria andUserNickBetween(String value1, String value2) {
            this.addCriterion("user_nick between", value1, value2, "userNick");
            return (Criteria)this;
        }

        public Criteria andUserNickNotBetween(String value1, String value2) {
            this.addCriterion("user_nick not between", value1, value2, "userNick");
            return (Criteria)this;
        }

        public Criteria andLoginEmailIsNull() {
            this.addCriterion("login_email is null");
            return (Criteria)this;
        }

        public Criteria andLoginEmailIsNotNull() {
            this.addCriterion("login_email is not null");
            return (Criteria)this;
        }

        public Criteria andLoginEmailEqualTo(String value) {
            this.addCriterion("login_email =", value, "loginEmail");
            return (Criteria)this;
        }

        public Criteria andLoginEmailNotEqualTo(String value) {
            this.addCriterion("login_email <>", value, "loginEmail");
            return (Criteria)this;
        }

        public Criteria andLoginEmailGreaterThan(String value) {
            this.addCriterion("login_email >", value, "loginEmail");
            return (Criteria)this;
        }

        public Criteria andLoginEmailGreaterThanOrEqualTo(String value) {
            this.addCriterion("login_email >=", value, "loginEmail");
            return (Criteria)this;
        }

        public Criteria andLoginEmailLessThan(String value) {
            this.addCriterion("login_email <", value, "loginEmail");
            return (Criteria)this;
        }

        public Criteria andLoginEmailLessThanOrEqualTo(String value) {
            this.addCriterion("login_email <=", value, "loginEmail");
            return (Criteria)this;
        }

        public Criteria andLoginEmailLike(String value) {
            this.addCriterion("login_email like", value, "loginEmail");
            return (Criteria)this;
        }

        public Criteria andLoginEmailNotLike(String value) {
            this.addCriterion("login_email not like", value, "loginEmail");
            return (Criteria)this;
        }        public Criteria andLoginEmailIn(List<String> values) {
            this.addCriterion("login_email in", values, "loginEmail");
            return (Criteria)this;
        }

        public Criteria andLoginEmailNotIn(List<String> values) {
            this.addCriterion("login_email not in", values, "loginEmail");
            return (Criteria)this;
        }

        public Criteria andLoginEmailBetween(String value1, String value2) {
            this.addCriterion("login_email between", value1, value2, "loginEmail");
            return (Criteria)this;
        }

        public Criteria andLoginEmailNotBetween(String value1, String value2) {
            this.addCriterion("login_email not between", value1, value2, "loginEmail");
            return (Criteria)this;
        }

        public Criteria andLoginPhoneIsNull() {
            this.addCriterion("login_phone is null");
            return (Criteria)this;
        }

        public Criteria andLoginPhoneIsNotNull() {
            this.addCriterion("login_phone is not null");
            return (Criteria)this;
        }

        public Criteria andLoginPhoneEqualTo(String value) {
            this.addCriterion("login_phone =", value, "loginPhone");
            return (Criteria)this;
        }

        public Criteria andLoginPhoneNotEqualTo(String value) {
            this.addCriterion("login_phone <>", value, "loginPhone");
            return (Criteria)this;
        }

        public Criteria andLoginPhoneGreaterThan(String value) {
            this.addCriterion("login_phone >", value, "loginPhone");
            return (Criteria)this;
        }

        public Criteria andLoginPhoneGreaterThanOrEqualTo(String value) {
            this.addCriterion("login_phone >=", value, "loginPhone");
            return (Criteria)this;
        }

        public Criteria andLoginPhoneLessThan(String value) {
            this.addCriterion("login_phone <", value, "loginPhone");
            return (Criteria)this;
        }

        public Criteria andLoginPhoneLessThanOrEqualTo(String value) {
            this.addCriterion("login_phone <=", value, "loginPhone");
            return (Criteria)this;
        }

        public Criteria andLoginPhoneLike(String value) {
            this.addCriterion("login_phone like", value, "loginPhone");
            return (Criteria)this;
        }

        public Criteria andLoginPhoneNotLike(String value) {
            this.addCriterion("login_phone not like", value, "loginPhone");
            return (Criteria)this;
        }        public Criteria andLoginPhoneIn(List<String> values) {
            this.addCriterion("login_phone in", values, "loginPhone");
            return (Criteria)this;
        }

        public Criteria andLoginPhoneNotIn(List<String> values) {
            this.addCriterion("login_phone not in", values, "loginPhone");
            return (Criteria)this;
        }

        public Criteria andLoginPhoneBetween(String value1, String value2) {
            this.addCriterion("login_phone between", value1, value2, "loginPhone");
            return (Criteria)this;
        }

        public Criteria andLoginPhoneNotBetween(String value1, String value2) {
            this.addCriterion("login_phone not between", value1, value2, "loginPhone");
            return (Criteria)this;
        }

        public Criteria andEmailIsNull() {
            this.addCriterion("email is null");
            return (Criteria)this;
        }

        public Criteria andEmailIsNotNull() {
            this.addCriterion("email is not null");
            return (Criteria)this;
        }

        public Criteria andEmailEqualTo(String value) {
            this.addCriterion("email =", value, "email");
            return (Criteria)this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            this.addCriterion("email <>", value, "email");
            return (Criteria)this;
        }

        public Criteria andEmailGreaterThan(String value) {
            this.addCriterion("email >", value, "email");
            return (Criteria)this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            this.addCriterion("email >=", value, "email");
            return (Criteria)this;
        }

        public Criteria andEmailLessThan(String value) {
            this.addCriterion("email <", value, "email");
            return (Criteria)this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            this.addCriterion("email <=", value, "email");
            return (Criteria)this;
        }

        public Criteria andEmailLike(String value) {
            this.addCriterion("email like", value, "email");
            return (Criteria)this;
        }

        public Criteria andEmailNotLike(String value) {
            this.addCriterion("email not like", value, "email");
            return (Criteria)this;
        }        public Criteria andEmailIn(List<String> values) {
            this.addCriterion("email in", values, "email");
            return (Criteria)this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            this.addCriterion("email not in", values, "email");
            return (Criteria)this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            this.addCriterion("email between", value1, value2, "email");
            return (Criteria)this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            this.addCriterion("email not between", value1, value2, "email");
            return (Criteria)this;
        }

        public Criteria andPasswordIsNull() {
            this.addCriterion("password is null");
            return (Criteria)this;
        }

        public Criteria andPasswordIsNotNull() {
            this.addCriterion("password is not null");
            return (Criteria)this;
        }

        public Criteria andPasswordEqualTo(String value) {
            this.addCriterion("password =", value, "password");
            return (Criteria)this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            this.addCriterion("password <>", value, "password");
            return (Criteria)this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            this.addCriterion("password >", value, "password");
            return (Criteria)this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            this.addCriterion("password >=", value, "password");
            return (Criteria)this;
        }

        public Criteria andPasswordLessThan(String value) {
            this.addCriterion("password <", value, "password");
            return (Criteria)this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            this.addCriterion("password <=", value, "password");
            return (Criteria)this;
        }

        public Criteria andPasswordLike(String value) {
            this.addCriterion("password like", value, "password");
            return (Criteria)this;
        }

        public Criteria andPasswordNotLike(String value) {
            this.addCriterion("password not like", value, "password");
            return (Criteria)this;
        }        public Criteria andPasswordIn(List<String> values) {
            this.addCriterion("password in", values, "password");
            return (Criteria)this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            this.addCriterion("password not in", values, "password");
            return (Criteria)this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            this.addCriterion("password between", value1, value2, "password");
            return (Criteria)this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            this.addCriterion("password not between", value1, value2, "password");
            return (Criteria)this;
        }

        public Criteria andRealNameIsNull() {
            this.addCriterion("real_name is null");
            return (Criteria)this;
        }

        public Criteria andRealNameIsNotNull() {
            this.addCriterion("real_name is not null");
            return (Criteria)this;
        }

        public Criteria andRealNameEqualTo(String value) {
            this.addCriterion("real_name =", value, "realName");
            return (Criteria)this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            this.addCriterion("real_name <>", value, "realName");
            return (Criteria)this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            this.addCriterion("real_name >", value, "realName");
            return (Criteria)this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("real_name >=", value, "realName");
            return (Criteria)this;
        }

        public Criteria andRealNameLessThan(String value) {
            this.addCriterion("real_name <", value, "realName");
            return (Criteria)this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            this.addCriterion("real_name <=", value, "realName");
            return (Criteria)this;
        }

        public Criteria andRealNameLike(String value) {
            this.addCriterion("real_name like", value, "realName");
            return (Criteria)this;
        }

        public Criteria andRealNameNotLike(String value) {
            this.addCriterion("real_name not like", value, "realName");
            return (Criteria)this;
        }        public Criteria andRealNameIn(List<String> values) {
            this.addCriterion("real_name in", values, "realName");
            return (Criteria)this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            this.addCriterion("real_name not in", values, "realName");
            return (Criteria)this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            this.addCriterion("real_name between", value1, value2, "realName");
            return (Criteria)this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            this.addCriterion("real_name not between", value1, value2, "realName");
            return (Criteria)this;
        }

        public Criteria andBuyerGradeIsNull() {
            this.addCriterion("buyer_grade is null");
            return (Criteria)this;
        }

        public Criteria andBuyerGradeIsNotNull() {
            this.addCriterion("buyer_grade is not null");
            return (Criteria)this;
        }

        public Criteria andBuyerGradeEqualTo(Long value) {
            this.addCriterion("buyer_grade =", value, "buyerGrade");
            return (Criteria)this;
        }

        public Criteria andBuyerGradeNotEqualTo(Long value) {
            this.addCriterion("buyer_grade <>", value, "buyerGrade");
            return (Criteria)this;
        }

        public Criteria andBuyerGradeGreaterThan(Long value) {
            this.addCriterion("buyer_grade >", value, "buyerGrade");
            return (Criteria)this;
        }

        public Criteria andBuyerGradeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("buyer_grade >=", value, "buyerGrade");
            return (Criteria)this;
        }

        public Criteria andBuyerGradeLessThan(Long value) {
            this.addCriterion("buyer_grade <", value, "buyerGrade");
            return (Criteria)this;
        }

        public Criteria andBuyerGradeLessThanOrEqualTo(Long value) {
            this.addCriterion("buyer_grade <=", value, "buyerGrade");
            return (Criteria)this;
        }

        public Criteria andBuyerGradeLike(String value) {
            this.addCriterion("buyer_grade like", value, "buyerGrade");
            return (Criteria)this;
        }

        public Criteria andBuyerGradeNotLike(String value) {
            this.addCriterion("buyer_grade not like", value, "buyerGrade");
            return (Criteria)this;
        }        public Criteria andBuyerGradeIn(List<Long> values) {
            this.addCriterion("buyer_grade in", values, "buyerGrade");
            return (Criteria)this;
        }

        public Criteria andBuyerGradeNotIn(List<Long> values) {
            this.addCriterion("buyer_grade not in", values, "buyerGrade");
            return (Criteria)this;
        }

        public Criteria andBuyerGradeBetween(Long value1, Long value2) {
            this.addCriterion("buyer_grade between", value1, value2, "buyerGrade");
            return (Criteria)this;
        }

        public Criteria andBuyerGradeNotBetween(Long value1, Long value2) {
            this.addCriterion("buyer_grade not between", value1, value2, "buyerGrade");
            return (Criteria)this;
        }

        public Criteria andSellerGradeIsNull() {
            this.addCriterion("seller_grade is null");
            return (Criteria)this;
        }

        public Criteria andSellerGradeIsNotNull() {
            this.addCriterion("seller_grade is not null");
            return (Criteria)this;
        }

        public Criteria andSellerGradeEqualTo(Long value) {
            this.addCriterion("seller_grade =", value, "sellerGrade");
            return (Criteria)this;
        }

        public Criteria andSellerGradeNotEqualTo(Long value) {
            this.addCriterion("seller_grade <>", value, "sellerGrade");
            return (Criteria)this;
        }

        public Criteria andSellerGradeGreaterThan(Long value) {
            this.addCriterion("seller_grade >", value, "sellerGrade");
            return (Criteria)this;
        }

        public Criteria andSellerGradeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("seller_grade >=", value, "sellerGrade");
            return (Criteria)this;
        }

        public Criteria andSellerGradeLessThan(Long value) {
            this.addCriterion("seller_grade <", value, "sellerGrade");
            return (Criteria)this;
        }

        public Criteria andSellerGradeLessThanOrEqualTo(Long value) {
            this.addCriterion("seller_grade <=", value, "sellerGrade");
            return (Criteria)this;
        }

        public Criteria andSellerGradeLike(String value) {
            this.addCriterion("seller_grade like", value, "sellerGrade");
            return (Criteria)this;
        }

        public Criteria andSellerGradeNotLike(String value) {
            this.addCriterion("seller_grade not like", value, "sellerGrade");
            return (Criteria)this;
        }        public Criteria andSellerGradeIn(List<Long> values) {
            this.addCriterion("seller_grade in", values, "sellerGrade");
            return (Criteria)this;
        }

        public Criteria andSellerGradeNotIn(List<Long> values) {
            this.addCriterion("seller_grade not in", values, "sellerGrade");
            return (Criteria)this;
        }

        public Criteria andSellerGradeBetween(Long value1, Long value2) {
            this.addCriterion("seller_grade between", value1, value2, "sellerGrade");
            return (Criteria)this;
        }

        public Criteria andSellerGradeNotBetween(Long value1, Long value2) {
            this.addCriterion("seller_grade not between", value1, value2, "sellerGrade");
            return (Criteria)this;
        }

        public Criteria andSellerVipGradeIsNull() {
            this.addCriterion("seller_vip_grade is null");
            return (Criteria)this;
        }

        public Criteria andSellerVipGradeIsNotNull() {
            this.addCriterion("seller_vip_grade is not null");
            return (Criteria)this;
        }

        public Criteria andSellerVipGradeEqualTo(Long value) {
            this.addCriterion("seller_vip_grade =", value, "sellerVipGrade");
            return (Criteria)this;
        }

        public Criteria andSellerVipGradeNotEqualTo(Long value) {
            this.addCriterion("seller_vip_grade <>", value, "sellerVipGrade");
            return (Criteria)this;
        }

        public Criteria andSellerVipGradeGreaterThan(Long value) {
            this.addCriterion("seller_vip_grade >", value, "sellerVipGrade");
            return (Criteria)this;
        }

        public Criteria andSellerVipGradeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("seller_vip_grade >=", value, "sellerVipGrade");
            return (Criteria)this;
        }

        public Criteria andSellerVipGradeLessThan(Long value) {
            this.addCriterion("seller_vip_grade <", value, "sellerVipGrade");
            return (Criteria)this;
        }

        public Criteria andSellerVipGradeLessThanOrEqualTo(Long value) {
            this.addCriterion("seller_vip_grade <=", value, "sellerVipGrade");
            return (Criteria)this;
        }

        public Criteria andSellerVipGradeLike(String value) {
            this.addCriterion("seller_vip_grade like", value, "sellerVipGrade");
            return (Criteria)this;
        }

        public Criteria andSellerVipGradeNotLike(String value) {
            this.addCriterion("seller_vip_grade not like", value, "sellerVipGrade");
            return (Criteria)this;
        }        public Criteria andSellerVipGradeIn(List<Long> values) {
            this.addCriterion("seller_vip_grade in", values, "sellerVipGrade");
            return (Criteria)this;
        }

        public Criteria andSellerVipGradeNotIn(List<Long> values) {
            this.addCriterion("seller_vip_grade not in", values, "sellerVipGrade");
            return (Criteria)this;
        }

        public Criteria andSellerVipGradeBetween(Long value1, Long value2) {
            this.addCriterion("seller_vip_grade between", value1, value2, "sellerVipGrade");
            return (Criteria)this;
        }

        public Criteria andSellerVipGradeNotBetween(Long value1, Long value2) {
            this.addCriterion("seller_vip_grade not between", value1, value2, "sellerVipGrade");
            return (Criteria)this;
        }

        public Criteria andBirthdayIsNull() {
            this.addCriterion("birthday is null");
            return (Criteria)this;
        }

        public Criteria andBirthdayIsNotNull() {
            this.addCriterion("birthday is not null");
            return (Criteria)this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            this.addCriterion("birthday =", value, "birthday");
            return (Criteria)this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            this.addCriterion("birthday <>", value, "birthday");
            return (Criteria)this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            this.addCriterion("birthday >", value, "birthday");
            return (Criteria)this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            this.addCriterion("birthday >=", value, "birthday");
            return (Criteria)this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            this.addCriterion("birthday <", value, "birthday");
            return (Criteria)this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            this.addCriterion("birthday <=", value, "birthday");
            return (Criteria)this;
        }

        public Criteria andBirthdayLike(String value) {
            this.addCriterion("birthday like", value, "birthday");
            return (Criteria)this;
        }

        public Criteria andBirthdayNotLike(String value) {
            this.addCriterion("birthday not like", value, "birthday");
            return (Criteria)this;
        }        public Criteria andBirthdayIn(List<Date> values) {
            this.addCriterion("birthday in", values, "birthday");
            return (Criteria)this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            this.addCriterion("birthday not in", values, "birthday");
            return (Criteria)this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            this.addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria)this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            this.addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria)this;
        }

        public Criteria andBirthdayMonthDayIsNull() {
            this.addCriterion("birthday_month_day is null");
            return (Criteria)this;
        }

        public Criteria andBirthdayMonthDayIsNotNull() {
            this.addCriterion("birthday_month_day is not null");
            return (Criteria)this;
        }

        public Criteria andBirthdayMonthDayEqualTo(String value) {
            this.addCriterion("birthday_month_day =", value, "birthdayMonthDay");
            return (Criteria)this;
        }

        public Criteria andBirthdayMonthDayNotEqualTo(String value) {
            this.addCriterion("birthday_month_day <>", value, "birthdayMonthDay");
            return (Criteria)this;
        }

        public Criteria andBirthdayMonthDayGreaterThan(String value) {
            this.addCriterion("birthday_month_day >", value, "birthdayMonthDay");
            return (Criteria)this;
        }

        public Criteria andBirthdayMonthDayGreaterThanOrEqualTo(String value) {
            this.addCriterion("birthday_month_day >=", value, "birthdayMonthDay");
            return (Criteria)this;
        }

        public Criteria andBirthdayMonthDayLessThan(String value) {
            this.addCriterion("birthday_month_day <", value, "birthdayMonthDay");
            return (Criteria)this;
        }

        public Criteria andBirthdayMonthDayLessThanOrEqualTo(String value) {
            this.addCriterion("birthday_month_day <=", value, "birthdayMonthDay");
            return (Criteria)this;
        }

        public Criteria andBirthdayMonthDayLike(String value) {
            this.addCriterion("birthday_month_day like", value, "birthdayMonthDay");
            return (Criteria)this;
        }

        public Criteria andBirthdayMonthDayNotLike(String value) {
            this.addCriterion("birthday_month_day not like", value, "birthdayMonthDay");
            return (Criteria)this;
        }        public Criteria andBirthdayMonthDayIn(List<String> values) {
            this.addCriterion("birthday_month_day in", values, "birthdayMonthDay");
            return (Criteria)this;
        }

        public Criteria andBirthdayMonthDayNotIn(List<String> values) {
            this.addCriterion("birthday_month_day not in", values, "birthdayMonthDay");
            return (Criteria)this;
        }

        public Criteria andBirthdayMonthDayBetween(String value1, String value2) {
            this.addCriterion("birthday_month_day between", value1, value2, "birthdayMonthDay");
            return (Criteria)this;
        }

        public Criteria andBirthdayMonthDayNotBetween(String value1, String value2) {
            this.addCriterion("birthday_month_day not between", value1, value2, "birthdayMonthDay");
            return (Criteria)this;
        }

        public Criteria andIdCardIsNull() {
            this.addCriterion("id_card is null");
            return (Criteria)this;
        }

        public Criteria andIdCardIsNotNull() {
            this.addCriterion("id_card is not null");
            return (Criteria)this;
        }

        public Criteria andIdCardEqualTo(String value) {
            this.addCriterion("id_card =", value, "idCard");
            return (Criteria)this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            this.addCriterion("id_card <>", value, "idCard");
            return (Criteria)this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            this.addCriterion("id_card >", value, "idCard");
            return (Criteria)this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            this.addCriterion("id_card >=", value, "idCard");
            return (Criteria)this;
        }

        public Criteria andIdCardLessThan(String value) {
            this.addCriterion("id_card <", value, "idCard");
            return (Criteria)this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            this.addCriterion("id_card <=", value, "idCard");
            return (Criteria)this;
        }

        public Criteria andIdCardLike(String value) {
            this.addCriterion("id_card like", value, "idCard");
            return (Criteria)this;
        }

        public Criteria andIdCardNotLike(String value) {
            this.addCriterion("id_card not like", value, "idCard");
            return (Criteria)this;
        }        public Criteria andIdCardIn(List<String> values) {
            this.addCriterion("id_card in", values, "idCard");
            return (Criteria)this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            this.addCriterion("id_card not in", values, "idCard");
            return (Criteria)this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            this.addCriterion("id_card between", value1, value2, "idCard");
            return (Criteria)this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            this.addCriterion("id_card not between", value1, value2, "idCard");
            return (Criteria)this;
        }

        public Criteria andPhoneTelIsNull() {
            this.addCriterion("phone_tel is null");
            return (Criteria)this;
        }

        public Criteria andPhoneTelIsNotNull() {
            this.addCriterion("phone_tel is not null");
            return (Criteria)this;
        }

        public Criteria andPhoneTelEqualTo(String value) {
            this.addCriterion("phone_tel =", value, "phoneTel");
            return (Criteria)this;
        }

        public Criteria andPhoneTelNotEqualTo(String value) {
            this.addCriterion("phone_tel <>", value, "phoneTel");
            return (Criteria)this;
        }

        public Criteria andPhoneTelGreaterThan(String value) {
            this.addCriterion("phone_tel >", value, "phoneTel");
            return (Criteria)this;
        }

        public Criteria andPhoneTelGreaterThanOrEqualTo(String value) {
            this.addCriterion("phone_tel >=", value, "phoneTel");
            return (Criteria)this;
        }

        public Criteria andPhoneTelLessThan(String value) {
            this.addCriterion("phone_tel <", value, "phoneTel");
            return (Criteria)this;
        }

        public Criteria andPhoneTelLessThanOrEqualTo(String value) {
            this.addCriterion("phone_tel <=", value, "phoneTel");
            return (Criteria)this;
        }

        public Criteria andPhoneTelLike(String value) {
            this.addCriterion("phone_tel like", value, "phoneTel");
            return (Criteria)this;
        }

        public Criteria andPhoneTelNotLike(String value) {
            this.addCriterion("phone_tel not like", value, "phoneTel");
            return (Criteria)this;
        }        public Criteria andPhoneTelIn(List<String> values) {
            this.addCriterion("phone_tel in", values, "phoneTel");
            return (Criteria)this;
        }

        public Criteria andPhoneTelNotIn(List<String> values) {
            this.addCriterion("phone_tel not in", values, "phoneTel");
            return (Criteria)this;
        }

        public Criteria andPhoneTelBetween(String value1, String value2) {
            this.addCriterion("phone_tel between", value1, value2, "phoneTel");
            return (Criteria)this;
        }

        public Criteria andPhoneTelNotBetween(String value1, String value2) {
            this.addCriterion("phone_tel not between", value1, value2, "phoneTel");
            return (Criteria)this;
        }

        public Criteria andPhoneMobIsNull() {
            this.addCriterion("phone_mob is null");
            return (Criteria)this;
        }

        public Criteria andPhoneMobIsNotNull() {
            this.addCriterion("phone_mob is not null");
            return (Criteria)this;
        }

        public Criteria andPhoneMobEqualTo(String value) {
            this.addCriterion("phone_mob =", value, "phoneMob");
            return (Criteria)this;
        }

        public Criteria andPhoneMobNotEqualTo(String value) {
            this.addCriterion("phone_mob <>", value, "phoneMob");
            return (Criteria)this;
        }

        public Criteria andPhoneMobGreaterThan(String value) {
            this.addCriterion("phone_mob >", value, "phoneMob");
            return (Criteria)this;
        }

        public Criteria andPhoneMobGreaterThanOrEqualTo(String value) {
            this.addCriterion("phone_mob >=", value, "phoneMob");
            return (Criteria)this;
        }

        public Criteria andPhoneMobLessThan(String value) {
            this.addCriterion("phone_mob <", value, "phoneMob");
            return (Criteria)this;
        }

        public Criteria andPhoneMobLessThanOrEqualTo(String value) {
            this.addCriterion("phone_mob <=", value, "phoneMob");
            return (Criteria)this;
        }

        public Criteria andPhoneMobLike(String value) {
            this.addCriterion("phone_mob like", value, "phoneMob");
            return (Criteria)this;
        }

        public Criteria andPhoneMobNotLike(String value) {
            this.addCriterion("phone_mob not like", value, "phoneMob");
            return (Criteria)this;
        }        public Criteria andPhoneMobIn(List<String> values) {
            this.addCriterion("phone_mob in", values, "phoneMob");
            return (Criteria)this;
        }

        public Criteria andPhoneMobNotIn(List<String> values) {
            this.addCriterion("phone_mob not in", values, "phoneMob");
            return (Criteria)this;
        }

        public Criteria andPhoneMobBetween(String value1, String value2) {
            this.addCriterion("phone_mob between", value1, value2, "phoneMob");
            return (Criteria)this;
        }

        public Criteria andPhoneMobNotBetween(String value1, String value2) {
            this.addCriterion("phone_mob not between", value1, value2, "phoneMob");
            return (Criteria)this;
        }

        public Criteria andImQqIsNull() {
            this.addCriterion("im_qq is null");
            return (Criteria)this;
        }

        public Criteria andImQqIsNotNull() {
            this.addCriterion("im_qq is not null");
            return (Criteria)this;
        }

        public Criteria andImQqEqualTo(String value) {
            this.addCriterion("im_qq =", value, "imQq");
            return (Criteria)this;
        }

        public Criteria andImQqNotEqualTo(String value) {
            this.addCriterion("im_qq <>", value, "imQq");
            return (Criteria)this;
        }

        public Criteria andImQqGreaterThan(String value) {
            this.addCriterion("im_qq >", value, "imQq");
            return (Criteria)this;
        }

        public Criteria andImQqGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_qq >=", value, "imQq");
            return (Criteria)this;
        }

        public Criteria andImQqLessThan(String value) {
            this.addCriterion("im_qq <", value, "imQq");
            return (Criteria)this;
        }

        public Criteria andImQqLessThanOrEqualTo(String value) {
            this.addCriterion("im_qq <=", value, "imQq");
            return (Criteria)this;
        }

        public Criteria andImQqLike(String value) {
            this.addCriterion("im_qq like", value, "imQq");
            return (Criteria)this;
        }

        public Criteria andImQqNotLike(String value) {
            this.addCriterion("im_qq not like", value, "imQq");
            return (Criteria)this;
        }        public Criteria andImQqIn(List<String> values) {
            this.addCriterion("im_qq in", values, "imQq");
            return (Criteria)this;
        }

        public Criteria andImQqNotIn(List<String> values) {
            this.addCriterion("im_qq not in", values, "imQq");
            return (Criteria)this;
        }

        public Criteria andImQqBetween(String value1, String value2) {
            this.addCriterion("im_qq between", value1, value2, "imQq");
            return (Criteria)this;
        }

        public Criteria andImQqNotBetween(String value1, String value2) {
            this.addCriterion("im_qq not between", value1, value2, "imQq");
            return (Criteria)this;
        }

        public Criteria andImSkypeIsNull() {
            this.addCriterion("im_skype is null");
            return (Criteria)this;
        }

        public Criteria andImSkypeIsNotNull() {
            this.addCriterion("im_skype is not null");
            return (Criteria)this;
        }

        public Criteria andImSkypeEqualTo(String value) {
            this.addCriterion("im_skype =", value, "imSkype");
            return (Criteria)this;
        }

        public Criteria andImSkypeNotEqualTo(String value) {
            this.addCriterion("im_skype <>", value, "imSkype");
            return (Criteria)this;
        }

        public Criteria andImSkypeGreaterThan(String value) {
            this.addCriterion("im_skype >", value, "imSkype");
            return (Criteria)this;
        }

        public Criteria andImSkypeGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_skype >=", value, "imSkype");
            return (Criteria)this;
        }

        public Criteria andImSkypeLessThan(String value) {
            this.addCriterion("im_skype <", value, "imSkype");
            return (Criteria)this;
        }

        public Criteria andImSkypeLessThanOrEqualTo(String value) {
            this.addCriterion("im_skype <=", value, "imSkype");
            return (Criteria)this;
        }

        public Criteria andImSkypeLike(String value) {
            this.addCriterion("im_skype like", value, "imSkype");
            return (Criteria)this;
        }

        public Criteria andImSkypeNotLike(String value) {
            this.addCriterion("im_skype not like", value, "imSkype");
            return (Criteria)this;
        }        public Criteria andImSkypeIn(List<String> values) {
            this.addCriterion("im_skype in", values, "imSkype");
            return (Criteria)this;
        }

        public Criteria andImSkypeNotIn(List<String> values) {
            this.addCriterion("im_skype not in", values, "imSkype");
            return (Criteria)this;
        }

        public Criteria andImSkypeBetween(String value1, String value2) {
            this.addCriterion("im_skype between", value1, value2, "imSkype");
            return (Criteria)this;
        }

        public Criteria andImSkypeNotBetween(String value1, String value2) {
            this.addCriterion("im_skype not between", value1, value2, "imSkype");
            return (Criteria)this;
        }

        public Criteria andImWeixinIsNull() {
            this.addCriterion("im_weixin is null");
            return (Criteria)this;
        }

        public Criteria andImWeixinIsNotNull() {
            this.addCriterion("im_weixin is not null");
            return (Criteria)this;
        }

        public Criteria andImWeixinEqualTo(String value) {
            this.addCriterion("im_weixin =", value, "imWeixin");
            return (Criteria)this;
        }

        public Criteria andImWeixinNotEqualTo(String value) {
            this.addCriterion("im_weixin <>", value, "imWeixin");
            return (Criteria)this;
        }

        public Criteria andImWeixinGreaterThan(String value) {
            this.addCriterion("im_weixin >", value, "imWeixin");
            return (Criteria)this;
        }

        public Criteria andImWeixinGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_weixin >=", value, "imWeixin");
            return (Criteria)this;
        }

        public Criteria andImWeixinLessThan(String value) {
            this.addCriterion("im_weixin <", value, "imWeixin");
            return (Criteria)this;
        }

        public Criteria andImWeixinLessThanOrEqualTo(String value) {
            this.addCriterion("im_weixin <=", value, "imWeixin");
            return (Criteria)this;
        }

        public Criteria andImWeixinLike(String value) {
            this.addCriterion("im_weixin like", value, "imWeixin");
            return (Criteria)this;
        }

        public Criteria andImWeixinNotLike(String value) {
            this.addCriterion("im_weixin not like", value, "imWeixin");
            return (Criteria)this;
        }        public Criteria andImWeixinIn(List<String> values) {
            this.addCriterion("im_weixin in", values, "imWeixin");
            return (Criteria)this;
        }

        public Criteria andImWeixinNotIn(List<String> values) {
            this.addCriterion("im_weixin not in", values, "imWeixin");
            return (Criteria)this;
        }

        public Criteria andImWeixinBetween(String value1, String value2) {
            this.addCriterion("im_weixin between", value1, value2, "imWeixin");
            return (Criteria)this;
        }

        public Criteria andImWeixinNotBetween(String value1, String value2) {
            this.addCriterion("im_weixin not between", value1, value2, "imWeixin");
            return (Criteria)this;
        }

        public Criteria andImAliwwIsNull() {
            this.addCriterion("im_aliww is null");
            return (Criteria)this;
        }

        public Criteria andImAliwwIsNotNull() {
            this.addCriterion("im_aliww is not null");
            return (Criteria)this;
        }

        public Criteria andImAliwwEqualTo(String value) {
            this.addCriterion("im_aliww =", value, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwNotEqualTo(String value) {
            this.addCriterion("im_aliww <>", value, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwGreaterThan(String value) {
            this.addCriterion("im_aliww >", value, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_aliww >=", value, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwLessThan(String value) {
            this.addCriterion("im_aliww <", value, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwLessThanOrEqualTo(String value) {
            this.addCriterion("im_aliww <=", value, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwLike(String value) {
            this.addCriterion("im_aliww like", value, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwNotLike(String value) {
            this.addCriterion("im_aliww not like", value, "imAliww");
            return (Criteria)this;
        }        public Criteria andImAliwwIn(List<String> values) {
            this.addCriterion("im_aliww in", values, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwNotIn(List<String> values) {
            this.addCriterion("im_aliww not in", values, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwBetween(String value1, String value2) {
            this.addCriterion("im_aliww between", value1, value2, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwNotBetween(String value1, String value2) {
            this.addCriterion("im_aliww not between", value1, value2, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImYahooWeiboIsNull() {
            this.addCriterion("im_yahoo_weibo is null");
            return (Criteria)this;
        }

        public Criteria andImYahooWeiboIsNotNull() {
            this.addCriterion("im_yahoo_weibo is not null");
            return (Criteria)this;
        }

        public Criteria andImYahooWeiboEqualTo(String value) {
            this.addCriterion("im_yahoo_weibo =", value, "imYahooWeibo");
            return (Criteria)this;
        }

        public Criteria andImYahooWeiboNotEqualTo(String value) {
            this.addCriterion("im_yahoo_weibo <>", value, "imYahooWeibo");
            return (Criteria)this;
        }

        public Criteria andImYahooWeiboGreaterThan(String value) {
            this.addCriterion("im_yahoo_weibo >", value, "imYahooWeibo");
            return (Criteria)this;
        }

        public Criteria andImYahooWeiboGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_yahoo_weibo >=", value, "imYahooWeibo");
            return (Criteria)this;
        }

        public Criteria andImYahooWeiboLessThan(String value) {
            this.addCriterion("im_yahoo_weibo <", value, "imYahooWeibo");
            return (Criteria)this;
        }

        public Criteria andImYahooWeiboLessThanOrEqualTo(String value) {
            this.addCriterion("im_yahoo_weibo <=", value, "imYahooWeibo");
            return (Criteria)this;
        }

        public Criteria andImYahooWeiboLike(String value) {
            this.addCriterion("im_yahoo_weibo like", value, "imYahooWeibo");
            return (Criteria)this;
        }

        public Criteria andImYahooWeiboNotLike(String value) {
            this.addCriterion("im_yahoo_weibo not like", value, "imYahooWeibo");
            return (Criteria)this;
        }        public Criteria andImYahooWeiboIn(List<String> values) {
            this.addCriterion("im_yahoo_weibo in", values, "imYahooWeibo");
            return (Criteria)this;
        }

        public Criteria andImYahooWeiboNotIn(List<String> values) {
            this.addCriterion("im_yahoo_weibo not in", values, "imYahooWeibo");
            return (Criteria)this;
        }

        public Criteria andImYahooWeiboBetween(String value1, String value2) {
            this.addCriterion("im_yahoo_weibo between", value1, value2, "imYahooWeibo");
            return (Criteria)this;
        }

        public Criteria andImYahooWeiboNotBetween(String value1, String value2) {
            this.addCriterion("im_yahoo_weibo not between", value1, value2, "imYahooWeibo");
            return (Criteria)this;
        }

        public Criteria andImQqWeiboIsNull() {
            this.addCriterion("im_qq_weibo is null");
            return (Criteria)this;
        }

        public Criteria andImQqWeiboIsNotNull() {
            this.addCriterion("im_qq_weibo is not null");
            return (Criteria)this;
        }

        public Criteria andImQqWeiboEqualTo(String value) {
            this.addCriterion("im_qq_weibo =", value, "imQqWeibo");
            return (Criteria)this;
        }

        public Criteria andImQqWeiboNotEqualTo(String value) {
            this.addCriterion("im_qq_weibo <>", value, "imQqWeibo");
            return (Criteria)this;
        }

        public Criteria andImQqWeiboGreaterThan(String value) {
            this.addCriterion("im_qq_weibo >", value, "imQqWeibo");
            return (Criteria)this;
        }

        public Criteria andImQqWeiboGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_qq_weibo >=", value, "imQqWeibo");
            return (Criteria)this;
        }

        public Criteria andImQqWeiboLessThan(String value) {
            this.addCriterion("im_qq_weibo <", value, "imQqWeibo");
            return (Criteria)this;
        }

        public Criteria andImQqWeiboLessThanOrEqualTo(String value) {
            this.addCriterion("im_qq_weibo <=", value, "imQqWeibo");
            return (Criteria)this;
        }

        public Criteria andImQqWeiboLike(String value) {
            this.addCriterion("im_qq_weibo like", value, "imQqWeibo");
            return (Criteria)this;
        }

        public Criteria andImQqWeiboNotLike(String value) {
            this.addCriterion("im_qq_weibo not like", value, "imQqWeibo");
            return (Criteria)this;
        }        public Criteria andImQqWeiboIn(List<String> values) {
            this.addCriterion("im_qq_weibo in", values, "imQqWeibo");
            return (Criteria)this;
        }

        public Criteria andImQqWeiboNotIn(List<String> values) {
            this.addCriterion("im_qq_weibo not in", values, "imQqWeibo");
            return (Criteria)this;
        }

        public Criteria andImQqWeiboBetween(String value1, String value2) {
            this.addCriterion("im_qq_weibo between", value1, value2, "imQqWeibo");
            return (Criteria)this;
        }

        public Criteria andImQqWeiboNotBetween(String value1, String value2) {
            this.addCriterion("im_qq_weibo not between", value1, value2, "imQqWeibo");
            return (Criteria)this;
        }

        public Criteria andRegTimeIsNull() {
            this.addCriterion("reg_time is null");
            return (Criteria)this;
        }

        public Criteria andRegTimeIsNotNull() {
            this.addCriterion("reg_time is not null");
            return (Criteria)this;
        }

        public Criteria andRegTimeEqualTo(Date value) {
            this.addCriterion("reg_time =", value, "regTime");
            return (Criteria)this;
        }

        public Criteria andRegTimeNotEqualTo(Date value) {
            this.addCriterion("reg_time <>", value, "regTime");
            return (Criteria)this;
        }

        public Criteria andRegTimeGreaterThan(Date value) {
            this.addCriterion("reg_time >", value, "regTime");
            return (Criteria)this;
        }

        public Criteria andRegTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("reg_time >=", value, "regTime");
            return (Criteria)this;
        }

        public Criteria andRegTimeLessThan(Date value) {
            this.addCriterion("reg_time <", value, "regTime");
            return (Criteria)this;
        }

        public Criteria andRegTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("reg_time <=", value, "regTime");
            return (Criteria)this;
        }

        public Criteria andRegTimeLike(String value) {
            this.addCriterion("reg_time like", value, "regTime");
            return (Criteria)this;
        }

        public Criteria andRegTimeNotLike(String value) {
            this.addCriterion("reg_time not like", value, "regTime");
            return (Criteria)this;
        }        public Criteria andRegTimeIn(List<Date> values) {
            this.addCriterion("reg_time in", values, "regTime");
            return (Criteria)this;
        }

        public Criteria andRegTimeNotIn(List<Date> values) {
            this.addCriterion("reg_time not in", values, "regTime");
            return (Criteria)this;
        }

        public Criteria andRegTimeBetween(Date value1, Date value2) {
            this.addCriterion("reg_time between", value1, value2, "regTime");
            return (Criteria)this;
        }

        public Criteria andRegTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("reg_time not between", value1, value2, "regTime");
            return (Criteria)this;
        }

        public Criteria andLastTimeIsNull() {
            this.addCriterion("last_time is null");
            return (Criteria)this;
        }

        public Criteria andLastTimeIsNotNull() {
            this.addCriterion("last_time is not null");
            return (Criteria)this;
        }

        public Criteria andLastTimeEqualTo(Date value) {
            this.addCriterion("last_time =", value, "lastTime");
            return (Criteria)this;
        }

        public Criteria andLastTimeNotEqualTo(Date value) {
            this.addCriterion("last_time <>", value, "lastTime");
            return (Criteria)this;
        }

        public Criteria andLastTimeGreaterThan(Date value) {
            this.addCriterion("last_time >", value, "lastTime");
            return (Criteria)this;
        }

        public Criteria andLastTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("last_time >=", value, "lastTime");
            return (Criteria)this;
        }

        public Criteria andLastTimeLessThan(Date value) {
            this.addCriterion("last_time <", value, "lastTime");
            return (Criteria)this;
        }

        public Criteria andLastTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("last_time <=", value, "lastTime");
            return (Criteria)this;
        }

        public Criteria andLastTimeLike(String value) {
            this.addCriterion("last_time like", value, "lastTime");
            return (Criteria)this;
        }

        public Criteria andLastTimeNotLike(String value) {
            this.addCriterion("last_time not like", value, "lastTime");
            return (Criteria)this;
        }        public Criteria andLastTimeIn(List<Date> values) {
            this.addCriterion("last_time in", values, "lastTime");
            return (Criteria)this;
        }

        public Criteria andLastTimeNotIn(List<Date> values) {
            this.addCriterion("last_time not in", values, "lastTime");
            return (Criteria)this;
        }

        public Criteria andLastTimeBetween(Date value1, Date value2) {
            this.addCriterion("last_time between", value1, value2, "lastTime");
            return (Criteria)this;
        }

        public Criteria andLastTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("last_time not between", value1, value2, "lastTime");
            return (Criteria)this;
        }

        public Criteria andLastIpIsNull() {
            this.addCriterion("last_ip is null");
            return (Criteria)this;
        }

        public Criteria andLastIpIsNotNull() {
            this.addCriterion("last_ip is not null");
            return (Criteria)this;
        }

        public Criteria andLastIpEqualTo(String value) {
            this.addCriterion("last_ip =", value, "lastIp");
            return (Criteria)this;
        }

        public Criteria andLastIpNotEqualTo(String value) {
            this.addCriterion("last_ip <>", value, "lastIp");
            return (Criteria)this;
        }

        public Criteria andLastIpGreaterThan(String value) {
            this.addCriterion("last_ip >", value, "lastIp");
            return (Criteria)this;
        }

        public Criteria andLastIpGreaterThanOrEqualTo(String value) {
            this.addCriterion("last_ip >=", value, "lastIp");
            return (Criteria)this;
        }

        public Criteria andLastIpLessThan(String value) {
            this.addCriterion("last_ip <", value, "lastIp");
            return (Criteria)this;
        }

        public Criteria andLastIpLessThanOrEqualTo(String value) {
            this.addCriterion("last_ip <=", value, "lastIp");
            return (Criteria)this;
        }

        public Criteria andLastIpLike(String value) {
            this.addCriterion("last_ip like", value, "lastIp");
            return (Criteria)this;
        }

        public Criteria andLastIpNotLike(String value) {
            this.addCriterion("last_ip not like", value, "lastIp");
            return (Criteria)this;
        }        public Criteria andLastIpIn(List<String> values) {
            this.addCriterion("last_ip in", values, "lastIp");
            return (Criteria)this;
        }

        public Criteria andLastIpNotIn(List<String> values) {
            this.addCriterion("last_ip not in", values, "lastIp");
            return (Criteria)this;
        }

        public Criteria andLastIpBetween(String value1, String value2) {
            this.addCriterion("last_ip between", value1, value2, "lastIp");
            return (Criteria)this;
        }

        public Criteria andLastIpNotBetween(String value1, String value2) {
            this.addCriterion("last_ip not between", value1, value2, "lastIp");
            return (Criteria)this;
        }

        public Criteria andLoginsIsNull() {
            this.addCriterion("logins is null");
            return (Criteria)this;
        }

        public Criteria andLoginsIsNotNull() {
            this.addCriterion("logins is not null");
            return (Criteria)this;
        }

        public Criteria andLoginsEqualTo(Long value) {
            this.addCriterion("logins =", value, "logins");
            return (Criteria)this;
        }

        public Criteria andLoginsNotEqualTo(Long value) {
            this.addCriterion("logins <>", value, "logins");
            return (Criteria)this;
        }

        public Criteria andLoginsGreaterThan(Long value) {
            this.addCriterion("logins >", value, "logins");
            return (Criteria)this;
        }

        public Criteria andLoginsGreaterThanOrEqualTo(Long value) {
            this.addCriterion("logins >=", value, "logins");
            return (Criteria)this;
        }

        public Criteria andLoginsLessThan(Long value) {
            this.addCriterion("logins <", value, "logins");
            return (Criteria)this;
        }

        public Criteria andLoginsLessThanOrEqualTo(Long value) {
            this.addCriterion("logins <=", value, "logins");
            return (Criteria)this;
        }

        public Criteria andLoginsLike(String value) {
            this.addCriterion("logins like", value, "logins");
            return (Criteria)this;
        }

        public Criteria andLoginsNotLike(String value) {
            this.addCriterion("logins not like", value, "logins");
            return (Criteria)this;
        }        public Criteria andLoginsIn(List<Long> values) {
            this.addCriterion("logins in", values, "logins");
            return (Criteria)this;
        }

        public Criteria andLoginsNotIn(List<Long> values) {
            this.addCriterion("logins not in", values, "logins");
            return (Criteria)this;
        }

        public Criteria andLoginsBetween(Long value1, Long value2) {
            this.addCriterion("logins between", value1, value2, "logins");
            return (Criteria)this;
        }

        public Criteria andLoginsNotBetween(Long value1, Long value2) {
            this.addCriterion("logins not between", value1, value2, "logins");
            return (Criteria)this;
        }

        public Criteria andAccountTypeIsNull() {
            this.addCriterion("account_type is null");
            return (Criteria)this;
        }

        public Criteria andAccountTypeIsNotNull() {
            this.addCriterion("account_type is not null");
            return (Criteria)this;
        }

        public Criteria andAccountTypeEqualTo(Integer value) {
            this.addCriterion("account_type =", value, "accountType");
            return (Criteria)this;
        }

        public Criteria andAccountTypeNotEqualTo(Integer value) {
            this.addCriterion("account_type <>", value, "accountType");
            return (Criteria)this;
        }

        public Criteria andAccountTypeGreaterThan(Integer value) {
            this.addCriterion("account_type >", value, "accountType");
            return (Criteria)this;
        }

        public Criteria andAccountTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("account_type >=", value, "accountType");
            return (Criteria)this;
        }

        public Criteria andAccountTypeLessThan(Integer value) {
            this.addCriterion("account_type <", value, "accountType");
            return (Criteria)this;
        }

        public Criteria andAccountTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("account_type <=", value, "accountType");
            return (Criteria)this;
        }

        public Criteria andAccountTypeLike(String value) {
            this.addCriterion("account_type like", value, "accountType");
            return (Criteria)this;
        }

        public Criteria andAccountTypeNotLike(String value) {
            this.addCriterion("account_type not like", value, "accountType");
            return (Criteria)this;
        }        public Criteria andAccountTypeIn(List<Integer> values) {
            this.addCriterion("account_type in", values, "accountType");
            return (Criteria)this;
        }

        public Criteria andAccountTypeNotIn(List<Integer> values) {
            this.addCriterion("account_type not in", values, "accountType");
            return (Criteria)this;
        }

        public Criteria andAccountTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("account_type between", value1, value2, "accountType");
            return (Criteria)this;
        }

        public Criteria andAccountTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("account_type not between", value1, value2, "accountType");
            return (Criteria)this;
        }

        public Criteria andAccountNameIsNull() {
            this.addCriterion("account_name is null");
            return (Criteria)this;
        }

        public Criteria andAccountNameIsNotNull() {
            this.addCriterion("account_name is not null");
            return (Criteria)this;
        }

        public Criteria andAccountNameEqualTo(String value) {
            this.addCriterion("account_name =", value, "accountName");
            return (Criteria)this;
        }

        public Criteria andAccountNameNotEqualTo(String value) {
            this.addCriterion("account_name <>", value, "accountName");
            return (Criteria)this;
        }

        public Criteria andAccountNameGreaterThan(String value) {
            this.addCriterion("account_name >", value, "accountName");
            return (Criteria)this;
        }

        public Criteria andAccountNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("account_name >=", value, "accountName");
            return (Criteria)this;
        }

        public Criteria andAccountNameLessThan(String value) {
            this.addCriterion("account_name <", value, "accountName");
            return (Criteria)this;
        }

        public Criteria andAccountNameLessThanOrEqualTo(String value) {
            this.addCriterion("account_name <=", value, "accountName");
            return (Criteria)this;
        }

        public Criteria andAccountNameLike(String value) {
            this.addCriterion("account_name like", value, "accountName");
            return (Criteria)this;
        }

        public Criteria andAccountNameNotLike(String value) {
            this.addCriterion("account_name not like", value, "accountName");
            return (Criteria)this;
        }        public Criteria andAccountNameIn(List<String> values) {
            this.addCriterion("account_name in", values, "accountName");
            return (Criteria)this;
        }

        public Criteria andAccountNameNotIn(List<String> values) {
            this.addCriterion("account_name not in", values, "accountName");
            return (Criteria)this;
        }

        public Criteria andAccountNameBetween(String value1, String value2) {
            this.addCriterion("account_name between", value1, value2, "accountName");
            return (Criteria)this;
        }

        public Criteria andAccountNameNotBetween(String value1, String value2) {
            this.addCriterion("account_name not between", value1, value2, "accountName");
            return (Criteria)this;
        }

        public Criteria andAccountIdIsNull() {
            this.addCriterion("account_id is null");
            return (Criteria)this;
        }

        public Criteria andAccountIdIsNotNull() {
            this.addCriterion("account_id is not null");
            return (Criteria)this;
        }

        public Criteria andAccountIdEqualTo(Long value) {
            this.addCriterion("account_id =", value, "accountId");
            return (Criteria)this;
        }

        public Criteria andAccountIdNotEqualTo(Long value) {
            this.addCriterion("account_id <>", value, "accountId");
            return (Criteria)this;
        }

        public Criteria andAccountIdGreaterThan(Long value) {
            this.addCriterion("account_id >", value, "accountId");
            return (Criteria)this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("account_id >=", value, "accountId");
            return (Criteria)this;
        }

        public Criteria andAccountIdLessThan(Long value) {
            this.addCriterion("account_id <", value, "accountId");
            return (Criteria)this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(Long value) {
            this.addCriterion("account_id <=", value, "accountId");
            return (Criteria)this;
        }

        public Criteria andAccountIdLike(String value) {
            this.addCriterion("account_id like", value, "accountId");
            return (Criteria)this;
        }

        public Criteria andAccountIdNotLike(String value) {
            this.addCriterion("account_id not like", value, "accountId");
            return (Criteria)this;
        }        public Criteria andAccountIdIn(List<Long> values) {
            this.addCriterion("account_id in", values, "accountId");
            return (Criteria)this;
        }

        public Criteria andAccountIdNotIn(List<Long> values) {
            this.addCriterion("account_id not in", values, "accountId");
            return (Criteria)this;
        }

        public Criteria andAccountIdBetween(Long value1, Long value2) {
            this.addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria)this;
        }

        public Criteria andAccountIdNotBetween(Long value1, Long value2) {
            this.addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria)this;
        }

        public Criteria andPortraitSavepathIsNull() {
            this.addCriterion("portrait_savepath is null");
            return (Criteria)this;
        }

        public Criteria andPortraitSavepathIsNotNull() {
            this.addCriterion("portrait_savepath is not null");
            return (Criteria)this;
        }

        public Criteria andPortraitSavepathEqualTo(String value) {
            this.addCriterion("portrait_savepath =", value, "portraitSavepath");
            return (Criteria)this;
        }

        public Criteria andPortraitSavepathNotEqualTo(String value) {
            this.addCriterion("portrait_savepath <>", value, "portraitSavepath");
            return (Criteria)this;
        }

        public Criteria andPortraitSavepathGreaterThan(String value) {
            this.addCriterion("portrait_savepath >", value, "portraitSavepath");
            return (Criteria)this;
        }

        public Criteria andPortraitSavepathGreaterThanOrEqualTo(String value) {
            this.addCriterion("portrait_savepath >=", value, "portraitSavepath");
            return (Criteria)this;
        }

        public Criteria andPortraitSavepathLessThan(String value) {
            this.addCriterion("portrait_savepath <", value, "portraitSavepath");
            return (Criteria)this;
        }

        public Criteria andPortraitSavepathLessThanOrEqualTo(String value) {
            this.addCriterion("portrait_savepath <=", value, "portraitSavepath");
            return (Criteria)this;
        }

        public Criteria andPortraitSavepathLike(String value) {
            this.addCriterion("portrait_savepath like", value, "portraitSavepath");
            return (Criteria)this;
        }

        public Criteria andPortraitSavepathNotLike(String value) {
            this.addCriterion("portrait_savepath not like", value, "portraitSavepath");
            return (Criteria)this;
        }        public Criteria andPortraitSavepathIn(List<String> values) {
            this.addCriterion("portrait_savepath in", values, "portraitSavepath");
            return (Criteria)this;
        }

        public Criteria andPortraitSavepathNotIn(List<String> values) {
            this.addCriterion("portrait_savepath not in", values, "portraitSavepath");
            return (Criteria)this;
        }

        public Criteria andPortraitSavepathBetween(String value1, String value2) {
            this.addCriterion("portrait_savepath between", value1, value2, "portraitSavepath");
            return (Criteria)this;
        }

        public Criteria andPortraitSavepathNotBetween(String value1, String value2) {
            this.addCriterion("portrait_savepath not between", value1, value2, "portraitSavepath");
            return (Criteria)this;
        }

        public Criteria andPortraitUrlIsNull() {
            this.addCriterion("portrait_url is null");
            return (Criteria)this;
        }

        public Criteria andPortraitUrlIsNotNull() {
            this.addCriterion("portrait_url is not null");
            return (Criteria)this;
        }

        public Criteria andPortraitUrlEqualTo(String value) {
            this.addCriterion("portrait_url =", value, "portraitUrl");
            return (Criteria)this;
        }

        public Criteria andPortraitUrlNotEqualTo(String value) {
            this.addCriterion("portrait_url <>", value, "portraitUrl");
            return (Criteria)this;
        }

        public Criteria andPortraitUrlGreaterThan(String value) {
            this.addCriterion("portrait_url >", value, "portraitUrl");
            return (Criteria)this;
        }

        public Criteria andPortraitUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("portrait_url >=", value, "portraitUrl");
            return (Criteria)this;
        }

        public Criteria andPortraitUrlLessThan(String value) {
            this.addCriterion("portrait_url <", value, "portraitUrl");
            return (Criteria)this;
        }

        public Criteria andPortraitUrlLessThanOrEqualTo(String value) {
            this.addCriterion("portrait_url <=", value, "portraitUrl");
            return (Criteria)this;
        }

        public Criteria andPortraitUrlLike(String value) {
            this.addCriterion("portrait_url like", value, "portraitUrl");
            return (Criteria)this;
        }

        public Criteria andPortraitUrlNotLike(String value) {
            this.addCriterion("portrait_url not like", value, "portraitUrl");
            return (Criteria)this;
        }        public Criteria andPortraitUrlIn(List<String> values) {
            this.addCriterion("portrait_url in", values, "portraitUrl");
            return (Criteria)this;
        }

        public Criteria andPortraitUrlNotIn(List<String> values) {
            this.addCriterion("portrait_url not in", values, "portraitUrl");
            return (Criteria)this;
        }

        public Criteria andPortraitUrlBetween(String value1, String value2) {
            this.addCriterion("portrait_url between", value1, value2, "portraitUrl");
            return (Criteria)this;
        }

        public Criteria andPortraitUrlNotBetween(String value1, String value2) {
            this.addCriterion("portrait_url not between", value1, value2, "portraitUrl");
            return (Criteria)this;
        }

        public Criteria andUseStatusIsNull() {
            this.addCriterion("use_status is null");
            return (Criteria)this;
        }

        public Criteria andUseStatusIsNotNull() {
            this.addCriterion("use_status is not null");
            return (Criteria)this;
        }

        public Criteria andUseStatusEqualTo(Long value) {
            this.addCriterion("use_status =", value, "useStatus");
            return (Criteria)this;
        }

        public Criteria andUseStatusNotEqualTo(Long value) {
            this.addCriterion("use_status <>", value, "useStatus");
            return (Criteria)this;
        }

        public Criteria andUseStatusGreaterThan(Long value) {
            this.addCriterion("use_status >", value, "useStatus");
            return (Criteria)this;
        }

        public Criteria andUseStatusGreaterThanOrEqualTo(Long value) {
            this.addCriterion("use_status >=", value, "useStatus");
            return (Criteria)this;
        }

        public Criteria andUseStatusLessThan(Long value) {
            this.addCriterion("use_status <", value, "useStatus");
            return (Criteria)this;
        }

        public Criteria andUseStatusLessThanOrEqualTo(Long value) {
            this.addCriterion("use_status <=", value, "useStatus");
            return (Criteria)this;
        }

        public Criteria andUseStatusLike(String value) {
            this.addCriterion("use_status like", value, "useStatus");
            return (Criteria)this;
        }

        public Criteria andUseStatusNotLike(String value) {
            this.addCriterion("use_status not like", value, "useStatus");
            return (Criteria)this;
        }        public Criteria andUseStatusIn(List<Long> values) {
            this.addCriterion("use_status in", values, "useStatus");
            return (Criteria)this;
        }

        public Criteria andUseStatusNotIn(List<Long> values) {
            this.addCriterion("use_status not in", values, "useStatus");
            return (Criteria)this;
        }

        public Criteria andUseStatusBetween(Long value1, Long value2) {
            this.addCriterion("use_status between", value1, value2, "useStatus");
            return (Criteria)this;
        }

        public Criteria andUseStatusNotBetween(Long value1, Long value2) {
            this.addCriterion("use_status not between", value1, value2, "useStatus");
            return (Criteria)this;
        }

        public Criteria andIsOpenStoreIsNull() {
            this.addCriterion("is_open_store is null");
            return (Criteria)this;
        }

        public Criteria andIsOpenStoreIsNotNull() {
            this.addCriterion("is_open_store is not null");
            return (Criteria)this;
        }

        public Criteria andIsOpenStoreEqualTo(Integer value) {
            this.addCriterion("is_open_store =", value, "isOpenStore");
            return (Criteria)this;
        }

        public Criteria andIsOpenStoreNotEqualTo(Integer value) {
            this.addCriterion("is_open_store <>", value, "isOpenStore");
            return (Criteria)this;
        }

        public Criteria andIsOpenStoreGreaterThan(Integer value) {
            this.addCriterion("is_open_store >", value, "isOpenStore");
            return (Criteria)this;
        }

        public Criteria andIsOpenStoreGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_open_store >=", value, "isOpenStore");
            return (Criteria)this;
        }

        public Criteria andIsOpenStoreLessThan(Integer value) {
            this.addCriterion("is_open_store <", value, "isOpenStore");
            return (Criteria)this;
        }

        public Criteria andIsOpenStoreLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_open_store <=", value, "isOpenStore");
            return (Criteria)this;
        }

        public Criteria andIsOpenStoreLike(String value) {
            this.addCriterion("is_open_store like", value, "isOpenStore");
            return (Criteria)this;
        }

        public Criteria andIsOpenStoreNotLike(String value) {
            this.addCriterion("is_open_store not like", value, "isOpenStore");
            return (Criteria)this;
        }        public Criteria andIsOpenStoreIn(List<Integer> values) {
            this.addCriterion("is_open_store in", values, "isOpenStore");
            return (Criteria)this;
        }

        public Criteria andIsOpenStoreNotIn(List<Integer> values) {
            this.addCriterion("is_open_store not in", values, "isOpenStore");
            return (Criteria)this;
        }

        public Criteria andIsOpenStoreBetween(Integer value1, Integer value2) {
            this.addCriterion("is_open_store between", value1, value2, "isOpenStore");
            return (Criteria)this;
        }

        public Criteria andIsOpenStoreNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_open_store not between", value1, value2, "isOpenStore");
            return (Criteria)this;
        }

        public Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (Criteria)this;
        }

        public Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (Criteria)this;
        }        public Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (Criteria)this;
        }

        public Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (Criteria)this;
        }        public Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (Criteria)this;
        }

        public Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (Criteria)this;
        }        public Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (Criteria)this;
        }

        public Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (Criteria)this;
        }        public Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (Criteria)this;
        }

        public Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (Criteria)this;
        }        public Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (Criteria)this;
        }

        public Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (Criteria)this;
        }        public Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (Criteria)this;
        }

        public Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (Criteria)this;
        }        public Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (Criteria)this;
        }

        public Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (Criteria)this;
        }        public Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (Criteria)this;
        }

        public Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (Criteria)this;
        }        public Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (Criteria)this;
        }

        public Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (Criteria)this;
        }        public Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark11IsNull() {
            this.addCriterion("remark11 is null");
            return (Criteria)this;
        }

        public Criteria andRemark11IsNotNull() {
            this.addCriterion("remark11 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark11EqualTo(String value) {
            this.addCriterion("remark11 =", value, "remark11");
            return (Criteria)this;
        }

        public Criteria andRemark11NotEqualTo(String value) {
            this.addCriterion("remark11 <>", value, "remark11");
            return (Criteria)this;
        }

        public Criteria andRemark11GreaterThan(String value) {
            this.addCriterion("remark11 >", value, "remark11");
            return (Criteria)this;
        }

        public Criteria andRemark11GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark11 >=", value, "remark11");
            return (Criteria)this;
        }

        public Criteria andRemark11LessThan(String value) {
            this.addCriterion("remark11 <", value, "remark11");
            return (Criteria)this;
        }

        public Criteria andRemark11LessThanOrEqualTo(String value) {
            this.addCriterion("remark11 <=", value, "remark11");
            return (Criteria)this;
        }

        public Criteria andRemark11Like(String value) {
            this.addCriterion("remark11 like", value, "remark11");
            return (Criteria)this;
        }

        public Criteria andRemark11NotLike(String value) {
            this.addCriterion("remark11 not like", value, "remark11");
            return (Criteria)this;
        }        public Criteria andRemark11In(List<String> values) {
            this.addCriterion("remark11 in", values, "remark11");
            return (Criteria)this;
        }

        public Criteria andRemark11NotIn(List<String> values) {
            this.addCriterion("remark11 not in", values, "remark11");
            return (Criteria)this;
        }

        public Criteria andRemark11Between(String value1, String value2) {
            this.addCriterion("remark11 between", value1, value2, "remark11");
            return (Criteria)this;
        }

        public Criteria andRemark11NotBetween(String value1, String value2) {
            this.addCriterion("remark11 not between", value1, value2, "remark11");
            return (Criteria)this;
        }

        public Criteria andRemark12IsNull() {
            this.addCriterion("remark12 is null");
            return (Criteria)this;
        }

        public Criteria andRemark12IsNotNull() {
            this.addCriterion("remark12 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark12EqualTo(String value) {
            this.addCriterion("remark12 =", value, "remark12");
            return (Criteria)this;
        }

        public Criteria andRemark12NotEqualTo(String value) {
            this.addCriterion("remark12 <>", value, "remark12");
            return (Criteria)this;
        }

        public Criteria andRemark12GreaterThan(String value) {
            this.addCriterion("remark12 >", value, "remark12");
            return (Criteria)this;
        }

        public Criteria andRemark12GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark12 >=", value, "remark12");
            return (Criteria)this;
        }

        public Criteria andRemark12LessThan(String value) {
            this.addCriterion("remark12 <", value, "remark12");
            return (Criteria)this;
        }

        public Criteria andRemark12LessThanOrEqualTo(String value) {
            this.addCriterion("remark12 <=", value, "remark12");
            return (Criteria)this;
        }

        public Criteria andRemark12Like(String value) {
            this.addCriterion("remark12 like", value, "remark12");
            return (Criteria)this;
        }

        public Criteria andRemark12NotLike(String value) {
            this.addCriterion("remark12 not like", value, "remark12");
            return (Criteria)this;
        }        public Criteria andRemark12In(List<String> values) {
            this.addCriterion("remark12 in", values, "remark12");
            return (Criteria)this;
        }

        public Criteria andRemark12NotIn(List<String> values) {
            this.addCriterion("remark12 not in", values, "remark12");
            return (Criteria)this;
        }

        public Criteria andRemark12Between(String value1, String value2) {
            this.addCriterion("remark12 between", value1, value2, "remark12");
            return (Criteria)this;
        }

        public Criteria andRemark12NotBetween(String value1, String value2) {
            this.addCriterion("remark12 not between", value1, value2, "remark12");
            return (Criteria)this;
        }

        public Criteria andRemark13IsNull() {
            this.addCriterion("remark13 is null");
            return (Criteria)this;
        }

        public Criteria andRemark13IsNotNull() {
            this.addCriterion("remark13 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark13EqualTo(String value) {
            this.addCriterion("remark13 =", value, "remark13");
            return (Criteria)this;
        }

        public Criteria andRemark13NotEqualTo(String value) {
            this.addCriterion("remark13 <>", value, "remark13");
            return (Criteria)this;
        }

        public Criteria andRemark13GreaterThan(String value) {
            this.addCriterion("remark13 >", value, "remark13");
            return (Criteria)this;
        }

        public Criteria andRemark13GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark13 >=", value, "remark13");
            return (Criteria)this;
        }

        public Criteria andRemark13LessThan(String value) {
            this.addCriterion("remark13 <", value, "remark13");
            return (Criteria)this;
        }

        public Criteria andRemark13LessThanOrEqualTo(String value) {
            this.addCriterion("remark13 <=", value, "remark13");
            return (Criteria)this;
        }

        public Criteria andRemark13Like(String value) {
            this.addCriterion("remark13 like", value, "remark13");
            return (Criteria)this;
        }

        public Criteria andRemark13NotLike(String value) {
            this.addCriterion("remark13 not like", value, "remark13");
            return (Criteria)this;
        }        public Criteria andRemark13In(List<String> values) {
            this.addCriterion("remark13 in", values, "remark13");
            return (Criteria)this;
        }

        public Criteria andRemark13NotIn(List<String> values) {
            this.addCriterion("remark13 not in", values, "remark13");
            return (Criteria)this;
        }

        public Criteria andRemark13Between(String value1, String value2) {
            this.addCriterion("remark13 between", value1, value2, "remark13");
            return (Criteria)this;
        }

        public Criteria andRemark13NotBetween(String value1, String value2) {
            this.addCriterion("remark13 not between", value1, value2, "remark13");
            return (Criteria)this;
        }

        public Criteria andRemark14IsNull() {
            this.addCriterion("remark14 is null");
            return (Criteria)this;
        }

        public Criteria andRemark14IsNotNull() {
            this.addCriterion("remark14 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark14EqualTo(String value) {
            this.addCriterion("remark14 =", value, "remark14");
            return (Criteria)this;
        }

        public Criteria andRemark14NotEqualTo(String value) {
            this.addCriterion("remark14 <>", value, "remark14");
            return (Criteria)this;
        }

        public Criteria andRemark14GreaterThan(String value) {
            this.addCriterion("remark14 >", value, "remark14");
            return (Criteria)this;
        }

        public Criteria andRemark14GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark14 >=", value, "remark14");
            return (Criteria)this;
        }

        public Criteria andRemark14LessThan(String value) {
            this.addCriterion("remark14 <", value, "remark14");
            return (Criteria)this;
        }

        public Criteria andRemark14LessThanOrEqualTo(String value) {
            this.addCriterion("remark14 <=", value, "remark14");
            return (Criteria)this;
        }

        public Criteria andRemark14Like(String value) {
            this.addCriterion("remark14 like", value, "remark14");
            return (Criteria)this;
        }

        public Criteria andRemark14NotLike(String value) {
            this.addCriterion("remark14 not like", value, "remark14");
            return (Criteria)this;
        }        public Criteria andRemark14In(List<String> values) {
            this.addCriterion("remark14 in", values, "remark14");
            return (Criteria)this;
        }

        public Criteria andRemark14NotIn(List<String> values) {
            this.addCriterion("remark14 not in", values, "remark14");
            return (Criteria)this;
        }

        public Criteria andRemark14Between(String value1, String value2) {
            this.addCriterion("remark14 between", value1, value2, "remark14");
            return (Criteria)this;
        }

        public Criteria andRemark14NotBetween(String value1, String value2) {
            this.addCriterion("remark14 not between", value1, value2, "remark14");
            return (Criteria)this;
        }

        public Criteria andRemark15IsNull() {
            this.addCriterion("remark15 is null");
            return (Criteria)this;
        }

        public Criteria andRemark15IsNotNull() {
            this.addCriterion("remark15 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark15EqualTo(String value) {
            this.addCriterion("remark15 =", value, "remark15");
            return (Criteria)this;
        }

        public Criteria andRemark15NotEqualTo(String value) {
            this.addCriterion("remark15 <>", value, "remark15");
            return (Criteria)this;
        }

        public Criteria andRemark15GreaterThan(String value) {
            this.addCriterion("remark15 >", value, "remark15");
            return (Criteria)this;
        }

        public Criteria andRemark15GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark15 >=", value, "remark15");
            return (Criteria)this;
        }

        public Criteria andRemark15LessThan(String value) {
            this.addCriterion("remark15 <", value, "remark15");
            return (Criteria)this;
        }

        public Criteria andRemark15LessThanOrEqualTo(String value) {
            this.addCriterion("remark15 <=", value, "remark15");
            return (Criteria)this;
        }

        public Criteria andRemark15Like(String value) {
            this.addCriterion("remark15 like", value, "remark15");
            return (Criteria)this;
        }

        public Criteria andRemark15NotLike(String value) {
            this.addCriterion("remark15 not like", value, "remark15");
            return (Criteria)this;
        }        public Criteria andRemark15In(List<String> values) {
            this.addCriterion("remark15 in", values, "remark15");
            return (Criteria)this;
        }

        public Criteria andRemark15NotIn(List<String> values) {
            this.addCriterion("remark15 not in", values, "remark15");
            return (Criteria)this;
        }

        public Criteria andRemark15Between(String value1, String value2) {
            this.addCriterion("remark15 between", value1, value2, "remark15");
            return (Criteria)this;
        }

        public Criteria andRemark15NotBetween(String value1, String value2) {
            this.addCriterion("remark15 not between", value1, value2, "remark15");
            return (Criteria)this;
        }

        public Criteria andRemark16IsNull() {
            this.addCriterion("remark16 is null");
            return (Criteria)this;
        }

        public Criteria andRemark16IsNotNull() {
            this.addCriterion("remark16 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark16EqualTo(String value) {
            this.addCriterion("remark16 =", value, "remark16");
            return (Criteria)this;
        }

        public Criteria andRemark16NotEqualTo(String value) {
            this.addCriterion("remark16 <>", value, "remark16");
            return (Criteria)this;
        }

        public Criteria andRemark16GreaterThan(String value) {
            this.addCriterion("remark16 >", value, "remark16");
            return (Criteria)this;
        }

        public Criteria andRemark16GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark16 >=", value, "remark16");
            return (Criteria)this;
        }

        public Criteria andRemark16LessThan(String value) {
            this.addCriterion("remark16 <", value, "remark16");
            return (Criteria)this;
        }

        public Criteria andRemark16LessThanOrEqualTo(String value) {
            this.addCriterion("remark16 <=", value, "remark16");
            return (Criteria)this;
        }

        public Criteria andRemark16Like(String value) {
            this.addCriterion("remark16 like", value, "remark16");
            return (Criteria)this;
        }

        public Criteria andRemark16NotLike(String value) {
            this.addCriterion("remark16 not like", value, "remark16");
            return (Criteria)this;
        }        public Criteria andRemark16In(List<String> values) {
            this.addCriterion("remark16 in", values, "remark16");
            return (Criteria)this;
        }

        public Criteria andRemark16NotIn(List<String> values) {
            this.addCriterion("remark16 not in", values, "remark16");
            return (Criteria)this;
        }

        public Criteria andRemark16Between(String value1, String value2) {
            this.addCriterion("remark16 between", value1, value2, "remark16");
            return (Criteria)this;
        }

        public Criteria andRemark16NotBetween(String value1, String value2) {
            this.addCriterion("remark16 not between", value1, value2, "remark16");
            return (Criteria)this;
        }

        public Criteria andRemark17IsNull() {
            this.addCriterion("remark17 is null");
            return (Criteria)this;
        }

        public Criteria andRemark17IsNotNull() {
            this.addCriterion("remark17 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark17EqualTo(String value) {
            this.addCriterion("remark17 =", value, "remark17");
            return (Criteria)this;
        }

        public Criteria andRemark17NotEqualTo(String value) {
            this.addCriterion("remark17 <>", value, "remark17");
            return (Criteria)this;
        }

        public Criteria andRemark17GreaterThan(String value) {
            this.addCriterion("remark17 >", value, "remark17");
            return (Criteria)this;
        }

        public Criteria andRemark17GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark17 >=", value, "remark17");
            return (Criteria)this;
        }

        public Criteria andRemark17LessThan(String value) {
            this.addCriterion("remark17 <", value, "remark17");
            return (Criteria)this;
        }

        public Criteria andRemark17LessThanOrEqualTo(String value) {
            this.addCriterion("remark17 <=", value, "remark17");
            return (Criteria)this;
        }

        public Criteria andRemark17Like(String value) {
            this.addCriterion("remark17 like", value, "remark17");
            return (Criteria)this;
        }

        public Criteria andRemark17NotLike(String value) {
            this.addCriterion("remark17 not like", value, "remark17");
            return (Criteria)this;
        }        public Criteria andRemark17In(List<String> values) {
            this.addCriterion("remark17 in", values, "remark17");
            return (Criteria)this;
        }

        public Criteria andRemark17NotIn(List<String> values) {
            this.addCriterion("remark17 not in", values, "remark17");
            return (Criteria)this;
        }

        public Criteria andRemark17Between(String value1, String value2) {
            this.addCriterion("remark17 between", value1, value2, "remark17");
            return (Criteria)this;
        }

        public Criteria andRemark17NotBetween(String value1, String value2) {
            this.addCriterion("remark17 not between", value1, value2, "remark17");
            return (Criteria)this;
        }

        public Criteria andRemark18IsNull() {
            this.addCriterion("remark18 is null");
            return (Criteria)this;
        }

        public Criteria andRemark18IsNotNull() {
            this.addCriterion("remark18 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark18EqualTo(String value) {
            this.addCriterion("remark18 =", value, "remark18");
            return (Criteria)this;
        }

        public Criteria andRemark18NotEqualTo(String value) {
            this.addCriterion("remark18 <>", value, "remark18");
            return (Criteria)this;
        }

        public Criteria andRemark18GreaterThan(String value) {
            this.addCriterion("remark18 >", value, "remark18");
            return (Criteria)this;
        }

        public Criteria andRemark18GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark18 >=", value, "remark18");
            return (Criteria)this;
        }

        public Criteria andRemark18LessThan(String value) {
            this.addCriterion("remark18 <", value, "remark18");
            return (Criteria)this;
        }

        public Criteria andRemark18LessThanOrEqualTo(String value) {
            this.addCriterion("remark18 <=", value, "remark18");
            return (Criteria)this;
        }

        public Criteria andRemark18Like(String value) {
            this.addCriterion("remark18 like", value, "remark18");
            return (Criteria)this;
        }

        public Criteria andRemark18NotLike(String value) {
            this.addCriterion("remark18 not like", value, "remark18");
            return (Criteria)this;
        }        public Criteria andRemark18In(List<String> values) {
            this.addCriterion("remark18 in", values, "remark18");
            return (Criteria)this;
        }

        public Criteria andRemark18NotIn(List<String> values) {
            this.addCriterion("remark18 not in", values, "remark18");
            return (Criteria)this;
        }

        public Criteria andRemark18Between(String value1, String value2) {
            this.addCriterion("remark18 between", value1, value2, "remark18");
            return (Criteria)this;
        }

        public Criteria andRemark18NotBetween(String value1, String value2) {
            this.addCriterion("remark18 not between", value1, value2, "remark18");
            return (Criteria)this;
        }

        public Criteria andRemark19IsNull() {
            this.addCriterion("remark19 is null");
            return (Criteria)this;
        }

        public Criteria andRemark19IsNotNull() {
            this.addCriterion("remark19 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark19EqualTo(String value) {
            this.addCriterion("remark19 =", value, "remark19");
            return (Criteria)this;
        }

        public Criteria andRemark19NotEqualTo(String value) {
            this.addCriterion("remark19 <>", value, "remark19");
            return (Criteria)this;
        }

        public Criteria andRemark19GreaterThan(String value) {
            this.addCriterion("remark19 >", value, "remark19");
            return (Criteria)this;
        }

        public Criteria andRemark19GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark19 >=", value, "remark19");
            return (Criteria)this;
        }

        public Criteria andRemark19LessThan(String value) {
            this.addCriterion("remark19 <", value, "remark19");
            return (Criteria)this;
        }

        public Criteria andRemark19LessThanOrEqualTo(String value) {
            this.addCriterion("remark19 <=", value, "remark19");
            return (Criteria)this;
        }

        public Criteria andRemark19Like(String value) {
            this.addCriterion("remark19 like", value, "remark19");
            return (Criteria)this;
        }

        public Criteria andRemark19NotLike(String value) {
            this.addCriterion("remark19 not like", value, "remark19");
            return (Criteria)this;
        }        public Criteria andRemark19In(List<String> values) {
            this.addCriterion("remark19 in", values, "remark19");
            return (Criteria)this;
        }

        public Criteria andRemark19NotIn(List<String> values) {
            this.addCriterion("remark19 not in", values, "remark19");
            return (Criteria)this;
        }

        public Criteria andRemark19Between(String value1, String value2) {
            this.addCriterion("remark19 between", value1, value2, "remark19");
            return (Criteria)this;
        }

        public Criteria andRemark19NotBetween(String value1, String value2) {
            this.addCriterion("remark19 not between", value1, value2, "remark19");
            return (Criteria)this;
        }

        public Criteria andRemark20IsNull() {
            this.addCriterion("remark20 is null");
            return (Criteria)this;
        }

        public Criteria andRemark20IsNotNull() {
            this.addCriterion("remark20 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark20EqualTo(String value) {
            this.addCriterion("remark20 =", value, "remark20");
            return (Criteria)this;
        }

        public Criteria andRemark20NotEqualTo(String value) {
            this.addCriterion("remark20 <>", value, "remark20");
            return (Criteria)this;
        }

        public Criteria andRemark20GreaterThan(String value) {
            this.addCriterion("remark20 >", value, "remark20");
            return (Criteria)this;
        }

        public Criteria andRemark20GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark20 >=", value, "remark20");
            return (Criteria)this;
        }

        public Criteria andRemark20LessThan(String value) {
            this.addCriterion("remark20 <", value, "remark20");
            return (Criteria)this;
        }

        public Criteria andRemark20LessThanOrEqualTo(String value) {
            this.addCriterion("remark20 <=", value, "remark20");
            return (Criteria)this;
        }

        public Criteria andRemark20Like(String value) {
            this.addCriterion("remark20 like", value, "remark20");
            return (Criteria)this;
        }

        public Criteria andRemark20NotLike(String value) {
            this.addCriterion("remark20 not like", value, "remark20");
            return (Criteria)this;
        }        public Criteria andRemark20In(List<String> values) {
            this.addCriterion("remark20 in", values, "remark20");
            return (Criteria)this;
        }

        public Criteria andRemark20NotIn(List<String> values) {
            this.addCriterion("remark20 not in", values, "remark20");
            return (Criteria)this;
        }

        public Criteria andRemark20Between(String value1, String value2) {
            this.addCriterion("remark20 between", value1, value2, "remark20");
            return (Criteria)this;
        }

        public Criteria andRemark20NotBetween(String value1, String value2) {
            this.addCriterion("remark20 not between", value1, value2, "remark20");
            return (Criteria)this;
        }

        public Criteria andSexIsNull() {
            this.addCriterion("sex is null");
            return (Criteria)this;
        }

        public Criteria andSexIsNotNull() {
            this.addCriterion("sex is not null");
            return (Criteria)this;
        }

        public Criteria andSexEqualTo(String value) {
            this.addCriterion("sex =", value, "sex");
            return (Criteria)this;
        }

        public Criteria andSexNotEqualTo(String value) {
            this.addCriterion("sex <>", value, "sex");
            return (Criteria)this;
        }

        public Criteria andSexGreaterThan(String value) {
            this.addCriterion("sex >", value, "sex");
            return (Criteria)this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            this.addCriterion("sex >=", value, "sex");
            return (Criteria)this;
        }

        public Criteria andSexLessThan(String value) {
            this.addCriterion("sex <", value, "sex");
            return (Criteria)this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            this.addCriterion("sex <=", value, "sex");
            return (Criteria)this;
        }

        public Criteria andSexLike(String value) {
            this.addCriterion("sex like", value, "sex");
            return (Criteria)this;
        }

        public Criteria andSexNotLike(String value) {
            this.addCriterion("sex not like", value, "sex");
            return (Criteria)this;
        }        public Criteria andSexIn(List<String> values) {
            this.addCriterion("sex in", values, "sex");
            return (Criteria)this;
        }

        public Criteria andSexNotIn(List<String> values) {
            this.addCriterion("sex not in", values, "sex");
            return (Criteria)this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            this.addCriterion("sex between", value1, value2, "sex");
            return (Criteria)this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            this.addCriterion("sex not between", value1, value2, "sex");
            return (Criteria)this;
        }

        public Criteria andIsNameValidateIsNull() {
            this.addCriterion("is_name_validate is null");
            return (Criteria)this;
        }

        public Criteria andIsNameValidateIsNotNull() {
            this.addCriterion("is_name_validate is not null");
            return (Criteria)this;
        }

        public Criteria andIsNameValidateEqualTo(Integer value) {
            this.addCriterion("is_name_validate =", value, "isNameValidate");
            return (Criteria)this;
        }

        public Criteria andIsNameValidateNotEqualTo(Integer value) {
            this.addCriterion("is_name_validate <>", value, "isNameValidate");
            return (Criteria)this;
        }

        public Criteria andIsNameValidateGreaterThan(Integer value) {
            this.addCriterion("is_name_validate >", value, "isNameValidate");
            return (Criteria)this;
        }

        public Criteria andIsNameValidateGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_name_validate >=", value, "isNameValidate");
            return (Criteria)this;
        }

        public Criteria andIsNameValidateLessThan(Integer value) {
            this.addCriterion("is_name_validate <", value, "isNameValidate");
            return (Criteria)this;
        }

        public Criteria andIsNameValidateLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_name_validate <=", value, "isNameValidate");
            return (Criteria)this;
        }

        public Criteria andIsNameValidateLike(String value) {
            this.addCriterion("is_name_validate like", value, "isNameValidate");
            return (Criteria)this;
        }

        public Criteria andIsNameValidateNotLike(String value) {
            this.addCriterion("is_name_validate not like", value, "isNameValidate");
            return (Criteria)this;
        }        public Criteria andIsNameValidateIn(List<Integer> values) {
            this.addCriterion("is_name_validate in", values, "isNameValidate");
            return (Criteria)this;
        }

        public Criteria andIsNameValidateNotIn(List<Integer> values) {
            this.addCriterion("is_name_validate not in", values, "isNameValidate");
            return (Criteria)this;
        }

        public Criteria andIsNameValidateBetween(Integer value1, Integer value2) {
            this.addCriterion("is_name_validate between", value1, value2, "isNameValidate");
            return (Criteria)this;
        }

        public Criteria andIsNameValidateNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_name_validate not between", value1, value2, "isNameValidate");
            return (Criteria)this;
        }

        public Criteria andPasswordStrengthIsNull() {
            this.addCriterion("password_strength is null");
            return (Criteria)this;
        }

        public Criteria andPasswordStrengthIsNotNull() {
            this.addCriterion("password_strength is not null");
            return (Criteria)this;
        }

        public Criteria andPasswordStrengthEqualTo(Integer value) {
            this.addCriterion("password_strength =", value, "passwordStrength");
            return (Criteria)this;
        }

        public Criteria andPasswordStrengthNotEqualTo(Integer value) {
            this.addCriterion("password_strength <>", value, "passwordStrength");
            return (Criteria)this;
        }

        public Criteria andPasswordStrengthGreaterThan(Integer value) {
            this.addCriterion("password_strength >", value, "passwordStrength");
            return (Criteria)this;
        }

        public Criteria andPasswordStrengthGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("password_strength >=", value, "passwordStrength");
            return (Criteria)this;
        }

        public Criteria andPasswordStrengthLessThan(Integer value) {
            this.addCriterion("password_strength <", value, "passwordStrength");
            return (Criteria)this;
        }

        public Criteria andPasswordStrengthLessThanOrEqualTo(Integer value) {
            this.addCriterion("password_strength <=", value, "passwordStrength");
            return (Criteria)this;
        }

        public Criteria andPasswordStrengthLike(String value) {
            this.addCriterion("password_strength like", value, "passwordStrength");
            return (Criteria)this;
        }

        public Criteria andPasswordStrengthNotLike(String value) {
            this.addCriterion("password_strength not like", value, "passwordStrength");
            return (Criteria)this;
        }        public Criteria andPasswordStrengthIn(List<Integer> values) {
            this.addCriterion("password_strength in", values, "passwordStrength");
            return (Criteria)this;
        }

        public Criteria andPasswordStrengthNotIn(List<Integer> values) {
            this.addCriterion("password_strength not in", values, "passwordStrength");
            return (Criteria)this;
        }

        public Criteria andPasswordStrengthBetween(Integer value1, Integer value2) {
            this.addCriterion("password_strength between", value1, value2, "passwordStrength");
            return (Criteria)this;
        }

        public Criteria andPasswordStrengthNotBetween(Integer value1, Integer value2) {
            this.addCriterion("password_strength not between", value1, value2, "passwordStrength");
            return (Criteria)this;
        }

        public Criteria andIsMailValidateIsNull() {
            this.addCriterion("is_mail_validate is null");
            return (Criteria)this;
        }

        public Criteria andIsMailValidateIsNotNull() {
            this.addCriterion("is_mail_validate is not null");
            return (Criteria)this;
        }

        public Criteria andIsMailValidateEqualTo(Integer value) {
            this.addCriterion("is_mail_validate =", value, "isMailValidate");
            return (Criteria)this;
        }

        public Criteria andIsMailValidateNotEqualTo(Integer value) {
            this.addCriterion("is_mail_validate <>", value, "isMailValidate");
            return (Criteria)this;
        }

        public Criteria andIsMailValidateGreaterThan(Integer value) {
            this.addCriterion("is_mail_validate >", value, "isMailValidate");
            return (Criteria)this;
        }

        public Criteria andIsMailValidateGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_mail_validate >=", value, "isMailValidate");
            return (Criteria)this;
        }

        public Criteria andIsMailValidateLessThan(Integer value) {
            this.addCriterion("is_mail_validate <", value, "isMailValidate");
            return (Criteria)this;
        }

        public Criteria andIsMailValidateLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_mail_validate <=", value, "isMailValidate");
            return (Criteria)this;
        }

        public Criteria andIsMailValidateLike(String value) {
            this.addCriterion("is_mail_validate like", value, "isMailValidate");
            return (Criteria)this;
        }

        public Criteria andIsMailValidateNotLike(String value) {
            this.addCriterion("is_mail_validate not like", value, "isMailValidate");
            return (Criteria)this;
        }        public Criteria andIsMailValidateIn(List<Integer> values) {
            this.addCriterion("is_mail_validate in", values, "isMailValidate");
            return (Criteria)this;
        }

        public Criteria andIsMailValidateNotIn(List<Integer> values) {
            this.addCriterion("is_mail_validate not in", values, "isMailValidate");
            return (Criteria)this;
        }

        public Criteria andIsMailValidateBetween(Integer value1, Integer value2) {
            this.addCriterion("is_mail_validate between", value1, value2, "isMailValidate");
            return (Criteria)this;
        }

        public Criteria andIsMailValidateNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_mail_validate not between", value1, value2, "isMailValidate");
            return (Criteria)this;
        }

        public Criteria andIsPhoneMobIsNull() {
            this.addCriterion("is_phone_mob is null");
            return (Criteria)this;
        }

        public Criteria andIsPhoneMobIsNotNull() {
            this.addCriterion("is_phone_mob is not null");
            return (Criteria)this;
        }

        public Criteria andIsPhoneMobEqualTo(Integer value) {
            this.addCriterion("is_phone_mob =", value, "isPhoneMob");
            return (Criteria)this;
        }

        public Criteria andIsPhoneMobNotEqualTo(Integer value) {
            this.addCriterion("is_phone_mob <>", value, "isPhoneMob");
            return (Criteria)this;
        }

        public Criteria andIsPhoneMobGreaterThan(Integer value) {
            this.addCriterion("is_phone_mob >", value, "isPhoneMob");
            return (Criteria)this;
        }

        public Criteria andIsPhoneMobGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_phone_mob >=", value, "isPhoneMob");
            return (Criteria)this;
        }

        public Criteria andIsPhoneMobLessThan(Integer value) {
            this.addCriterion("is_phone_mob <", value, "isPhoneMob");
            return (Criteria)this;
        }

        public Criteria andIsPhoneMobLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_phone_mob <=", value, "isPhoneMob");
            return (Criteria)this;
        }

        public Criteria andIsPhoneMobLike(String value) {
            this.addCriterion("is_phone_mob like", value, "isPhoneMob");
            return (Criteria)this;
        }

        public Criteria andIsPhoneMobNotLike(String value) {
            this.addCriterion("is_phone_mob not like", value, "isPhoneMob");
            return (Criteria)this;
        }        public Criteria andIsPhoneMobIn(List<Integer> values) {
            this.addCriterion("is_phone_mob in", values, "isPhoneMob");
            return (Criteria)this;
        }

        public Criteria andIsPhoneMobNotIn(List<Integer> values) {
            this.addCriterion("is_phone_mob not in", values, "isPhoneMob");
            return (Criteria)this;
        }

        public Criteria andIsPhoneMobBetween(Integer value1, Integer value2) {
            this.addCriterion("is_phone_mob between", value1, value2, "isPhoneMob");
            return (Criteria)this;
        }

        public Criteria andIsPhoneMobNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_phone_mob not between", value1, value2, "isPhoneMob");
            return (Criteria)this;
        }

        public Criteria andIsPayPasswordIsNull() {
            this.addCriterion("is_pay_password is null");
            return (Criteria)this;
        }

        public Criteria andIsPayPasswordIsNotNull() {
            this.addCriterion("is_pay_password is not null");
            return (Criteria)this;
        }

        public Criteria andIsPayPasswordEqualTo(Integer value) {
            this.addCriterion("is_pay_password =", value, "isPayPassword");
            return (Criteria)this;
        }

        public Criteria andIsPayPasswordNotEqualTo(Integer value) {
            this.addCriterion("is_pay_password <>", value, "isPayPassword");
            return (Criteria)this;
        }

        public Criteria andIsPayPasswordGreaterThan(Integer value) {
            this.addCriterion("is_pay_password >", value, "isPayPassword");
            return (Criteria)this;
        }

        public Criteria andIsPayPasswordGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_pay_password >=", value, "isPayPassword");
            return (Criteria)this;
        }

        public Criteria andIsPayPasswordLessThan(Integer value) {
            this.addCriterion("is_pay_password <", value, "isPayPassword");
            return (Criteria)this;
        }

        public Criteria andIsPayPasswordLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_pay_password <=", value, "isPayPassword");
            return (Criteria)this;
        }

        public Criteria andIsPayPasswordLike(String value) {
            this.addCriterion("is_pay_password like", value, "isPayPassword");
            return (Criteria)this;
        }

        public Criteria andIsPayPasswordNotLike(String value) {
            this.addCriterion("is_pay_password not like", value, "isPayPassword");
            return (Criteria)this;
        }        public Criteria andIsPayPasswordIn(List<Integer> values) {
            this.addCriterion("is_pay_password in", values, "isPayPassword");
            return (Criteria)this;
        }

        public Criteria andIsPayPasswordNotIn(List<Integer> values) {
            this.addCriterion("is_pay_password not in", values, "isPayPassword");
            return (Criteria)this;
        }

        public Criteria andIsPayPasswordBetween(Integer value1, Integer value2) {
            this.addCriterion("is_pay_password between", value1, value2, "isPayPassword");
            return (Criteria)this;
        }

        public Criteria andIsPayPasswordNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_pay_password not between", value1, value2, "isPayPassword");
            return (Criteria)this;
        }

        public Criteria andIdCardImgIsNull() {
            this.addCriterion("id_card_img is null");
            return (Criteria)this;
        }

        public Criteria andIdCardImgIsNotNull() {
            this.addCriterion("id_card_img is not null");
            return (Criteria)this;
        }

        public Criteria andIdCardImgEqualTo(String value) {
            this.addCriterion("id_card_img =", value, "idCardImg");
            return (Criteria)this;
        }

        public Criteria andIdCardImgNotEqualTo(String value) {
            this.addCriterion("id_card_img <>", value, "idCardImg");
            return (Criteria)this;
        }

        public Criteria andIdCardImgGreaterThan(String value) {
            this.addCriterion("id_card_img >", value, "idCardImg");
            return (Criteria)this;
        }

        public Criteria andIdCardImgGreaterThanOrEqualTo(String value) {
            this.addCriterion("id_card_img >=", value, "idCardImg");
            return (Criteria)this;
        }

        public Criteria andIdCardImgLessThan(String value) {
            this.addCriterion("id_card_img <", value, "idCardImg");
            return (Criteria)this;
        }

        public Criteria andIdCardImgLessThanOrEqualTo(String value) {
            this.addCriterion("id_card_img <=", value, "idCardImg");
            return (Criteria)this;
        }

        public Criteria andIdCardImgLike(String value) {
            this.addCriterion("id_card_img like", value, "idCardImg");
            return (Criteria)this;
        }

        public Criteria andIdCardImgNotLike(String value) {
            this.addCriterion("id_card_img not like", value, "idCardImg");
            return (Criteria)this;
        }        public Criteria andIdCardImgIn(List<String> values) {
            this.addCriterion("id_card_img in", values, "idCardImg");
            return (Criteria)this;
        }

        public Criteria andIdCardImgNotIn(List<String> values) {
            this.addCriterion("id_card_img not in", values, "idCardImg");
            return (Criteria)this;
        }

        public Criteria andIdCardImgBetween(String value1, String value2) {
            this.addCriterion("id_card_img between", value1, value2, "idCardImg");
            return (Criteria)this;
        }

        public Criteria andIdCardImgNotBetween(String value1, String value2) {
            this.addCriterion("id_card_img not between", value1, value2, "idCardImg");
            return (Criteria)this;
        }

        public Criteria andRegisterSourceIsNull() {
            this.addCriterion("register_source is null");
            return (Criteria)this;
        }

        public Criteria andRegisterSourceIsNotNull() {
            this.addCriterion("register_source is not null");
            return (Criteria)this;
        }

        public Criteria andRegisterSourceEqualTo(Long value) {
            this.addCriterion("register_source =", value, "registerSource");
            return (Criteria)this;
        }

        public Criteria andRegisterSourceNotEqualTo(Long value) {
            this.addCriterion("register_source <>", value, "registerSource");
            return (Criteria)this;
        }

        public Criteria andRegisterSourceGreaterThan(Long value) {
            this.addCriterion("register_source >", value, "registerSource");
            return (Criteria)this;
        }

        public Criteria andRegisterSourceGreaterThanOrEqualTo(Long value) {
            this.addCriterion("register_source >=", value, "registerSource");
            return (Criteria)this;
        }

        public Criteria andRegisterSourceLessThan(Long value) {
            this.addCriterion("register_source <", value, "registerSource");
            return (Criteria)this;
        }

        public Criteria andRegisterSourceLessThanOrEqualTo(Long value) {
            this.addCriterion("register_source <=", value, "registerSource");
            return (Criteria)this;
        }

        public Criteria andRegisterSourceLike(String value) {
            this.addCriterion("register_source like", value, "registerSource");
            return (Criteria)this;
        }

        public Criteria andRegisterSourceNotLike(String value) {
            this.addCriterion("register_source not like", value, "registerSource");
            return (Criteria)this;
        }        public Criteria andRegisterSourceIn(List<Long> values) {
            this.addCriterion("register_source in", values, "registerSource");
            return (Criteria)this;
        }

        public Criteria andRegisterSourceNotIn(List<Long> values) {
            this.addCriterion("register_source not in", values, "registerSource");
            return (Criteria)this;
        }

        public Criteria andRegisterSourceBetween(Long value1, Long value2) {
            this.addCriterion("register_source between", value1, value2, "registerSource");
            return (Criteria)this;
        }

        public Criteria andRegisterSourceNotBetween(Long value1, Long value2) {
            this.addCriterion("register_source not between", value1, value2, "registerSource");
            return (Criteria)this;
        }

        public Criteria andZfbAccountIsNull() {
            this.addCriterion("zfb_account is null");
            return (Criteria)this;
        }

        public Criteria andZfbAccountIsNotNull() {
            this.addCriterion("zfb_account is not null");
            return (Criteria)this;
        }

        public Criteria andZfbAccountEqualTo(String value) {
            this.addCriterion("zfb_account =", value, "zfbAccount");
            return (Criteria)this;
        }

        public Criteria andZfbAccountNotEqualTo(String value) {
            this.addCriterion("zfb_account <>", value, "zfbAccount");
            return (Criteria)this;
        }

        public Criteria andZfbAccountGreaterThan(String value) {
            this.addCriterion("zfb_account >", value, "zfbAccount");
            return (Criteria)this;
        }

        public Criteria andZfbAccountGreaterThanOrEqualTo(String value) {
            this.addCriterion("zfb_account >=", value, "zfbAccount");
            return (Criteria)this;
        }

        public Criteria andZfbAccountLessThan(String value) {
            this.addCriterion("zfb_account <", value, "zfbAccount");
            return (Criteria)this;
        }

        public Criteria andZfbAccountLessThanOrEqualTo(String value) {
            this.addCriterion("zfb_account <=", value, "zfbAccount");
            return (Criteria)this;
        }

        public Criteria andZfbAccountLike(String value) {
            this.addCriterion("zfb_account like", value, "zfbAccount");
            return (Criteria)this;
        }

        public Criteria andZfbAccountNotLike(String value) {
            this.addCriterion("zfb_account not like", value, "zfbAccount");
            return (Criteria)this;
        }        public Criteria andZfbAccountIn(List<String> values) {
            this.addCriterion("zfb_account in", values, "zfbAccount");
            return (Criteria)this;
        }

        public Criteria andZfbAccountNotIn(List<String> values) {
            this.addCriterion("zfb_account not in", values, "zfbAccount");
            return (Criteria)this;
        }

        public Criteria andZfbAccountBetween(String value1, String value2) {
            this.addCriterion("zfb_account between", value1, value2, "zfbAccount");
            return (Criteria)this;
        }

        public Criteria andZfbAccountNotBetween(String value1, String value2) {
            this.addCriterion("zfb_account not between", value1, value2, "zfbAccount");
            return (Criteria)this;
        }
    }
}
