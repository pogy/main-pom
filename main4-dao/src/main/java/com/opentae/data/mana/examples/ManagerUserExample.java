package com.opentae.data.mana.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagerUserExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<ManagerUserExample.Criteria> oredCriteria = new ArrayList();

    public ManagerUserExample() {
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

    public List<ManagerUserExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ManagerUserExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ManagerUserExample.Criteria or() {
        ManagerUserExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ManagerUserExample.Criteria createCriteria() {
        ManagerUserExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ManagerUserExample.Criteria createCriteriaInternal() {
        ManagerUserExample.Criteria criteria = new ManagerUserExample.Criteria();
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

    public static class Criteria extends ManagerUserExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ManagerUserExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ManagerUserExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ManagerUserExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ManagerUserExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ManagerUserExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ManagerUserExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ManagerUserExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (ManagerUserExample.Criteria)this;
        }        public ManagerUserExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andNickIsNull() {
            this.addCriterion("nick is null");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andNickIsNotNull() {
            this.addCriterion("nick is not null");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andNickEqualTo(String value) {
            this.addCriterion("nick =", value, "nick");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andNickNotEqualTo(String value) {
            this.addCriterion("nick <>", value, "nick");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andNickGreaterThan(String value) {
            this.addCriterion("nick >", value, "nick");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andNickGreaterThanOrEqualTo(String value) {
            this.addCriterion("nick >=", value, "nick");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andNickLessThan(String value) {
            this.addCriterion("nick <", value, "nick");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andNickLessThanOrEqualTo(String value) {
            this.addCriterion("nick <=", value, "nick");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andNickLike(String value) {
            this.addCriterion("nick like", value, "nick");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andNickNotLike(String value) {
            this.addCriterion("nick not like", value, "nick");
            return (ManagerUserExample.Criteria)this;
        }        public ManagerUserExample.Criteria andNickIn(List<String> values) {
            this.addCriterion("nick in", values, "nick");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andNickNotIn(List<String> values) {
            this.addCriterion("nick not in", values, "nick");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andNickBetween(String value1, String value2) {
            this.addCriterion("nick between", value1, value2, "nick");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andNickNotBetween(String value1, String value2) {
            this.addCriterion("nick not between", value1, value2, "nick");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLoginNameIsNull() {
            this.addCriterion("login_name is null");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLoginNameIsNotNull() {
            this.addCriterion("login_name is not null");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLoginNameEqualTo(String value) {
            this.addCriterion("login_name =", value, "loginName");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLoginNameNotEqualTo(String value) {
            this.addCriterion("login_name <>", value, "loginName");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLoginNameGreaterThan(String value) {
            this.addCriterion("login_name >", value, "loginName");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLoginNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("login_name >=", value, "loginName");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLoginNameLessThan(String value) {
            this.addCriterion("login_name <", value, "loginName");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLoginNameLessThanOrEqualTo(String value) {
            this.addCriterion("login_name <=", value, "loginName");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLoginNameLike(String value) {
            this.addCriterion("login_name like", value, "loginName");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLoginNameNotLike(String value) {
            this.addCriterion("login_name not like", value, "loginName");
            return (ManagerUserExample.Criteria)this;
        }        public ManagerUserExample.Criteria andLoginNameIn(List<String> values) {
            this.addCriterion("login_name in", values, "loginName");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLoginNameNotIn(List<String> values) {
            this.addCriterion("login_name not in", values, "loginName");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLoginNameBetween(String value1, String value2) {
            this.addCriterion("login_name between", value1, value2, "loginName");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLoginNameNotBetween(String value1, String value2) {
            this.addCriterion("login_name not between", value1, value2, "loginName");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andPasswordIsNull() {
            this.addCriterion("password is null");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andPasswordIsNotNull() {
            this.addCriterion("password is not null");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andPasswordEqualTo(String value) {
            this.addCriterion("password =", value, "password");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andPasswordNotEqualTo(String value) {
            this.addCriterion("password <>", value, "password");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andPasswordGreaterThan(String value) {
            this.addCriterion("password >", value, "password");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andPasswordGreaterThanOrEqualTo(String value) {
            this.addCriterion("password >=", value, "password");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andPasswordLessThan(String value) {
            this.addCriterion("password <", value, "password");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andPasswordLessThanOrEqualTo(String value) {
            this.addCriterion("password <=", value, "password");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andPasswordLike(String value) {
            this.addCriterion("password like", value, "password");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andPasswordNotLike(String value) {
            this.addCriterion("password not like", value, "password");
            return (ManagerUserExample.Criteria)this;
        }        public ManagerUserExample.Criteria andPasswordIn(List<String> values) {
            this.addCriterion("password in", values, "password");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andPasswordNotIn(List<String> values) {
            this.addCriterion("password not in", values, "password");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andPasswordBetween(String value1, String value2) {
            this.addCriterion("password between", value1, value2, "password");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andPasswordNotBetween(String value1, String value2) {
            this.addCriterion("password not between", value1, value2, "password");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (ManagerUserExample.Criteria)this;
        }        public ManagerUserExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andStatusIsNull() {
            this.addCriterion("status is null");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andStatusIsNotNull() {
            this.addCriterion("status is not null");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andStatusEqualTo(Integer value) {
            this.addCriterion("status =", value, "status");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andStatusNotEqualTo(Integer value) {
            this.addCriterion("status <>", value, "status");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andStatusGreaterThan(Integer value) {
            this.addCriterion("status >", value, "status");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("status >=", value, "status");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andStatusLessThan(Integer value) {
            this.addCriterion("status <", value, "status");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("status <=", value, "status");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andStatusLike(String value) {
            this.addCriterion("status like", value, "status");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andStatusNotLike(String value) {
            this.addCriterion("status not like", value, "status");
            return (ManagerUserExample.Criteria)this;
        }        public ManagerUserExample.Criteria andStatusIn(List<Integer> values) {
            this.addCriterion("status in", values, "status");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andStatusNotIn(List<Integer> values) {
            this.addCriterion("status not in", values, "status");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("status between", value1, value2, "status");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("status not between", value1, value2, "status");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andHeadUrlIsNull() {
            this.addCriterion("head_url is null");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andHeadUrlIsNotNull() {
            this.addCriterion("head_url is not null");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andHeadUrlEqualTo(String value) {
            this.addCriterion("head_url =", value, "headUrl");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andHeadUrlNotEqualTo(String value) {
            this.addCriterion("head_url <>", value, "headUrl");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andHeadUrlGreaterThan(String value) {
            this.addCriterion("head_url >", value, "headUrl");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andHeadUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("head_url >=", value, "headUrl");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andHeadUrlLessThan(String value) {
            this.addCriterion("head_url <", value, "headUrl");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andHeadUrlLessThanOrEqualTo(String value) {
            this.addCriterion("head_url <=", value, "headUrl");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andHeadUrlLike(String value) {
            this.addCriterion("head_url like", value, "headUrl");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andHeadUrlNotLike(String value) {
            this.addCriterion("head_url not like", value, "headUrl");
            return (ManagerUserExample.Criteria)this;
        }        public ManagerUserExample.Criteria andHeadUrlIn(List<String> values) {
            this.addCriterion("head_url in", values, "headUrl");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andHeadUrlNotIn(List<String> values) {
            this.addCriterion("head_url not in", values, "headUrl");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andHeadUrlBetween(String value1, String value2) {
            this.addCriterion("head_url between", value1, value2, "headUrl");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andHeadUrlNotBetween(String value1, String value2) {
            this.addCriterion("head_url not between", value1, value2, "headUrl");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLastLoginIpIsNull() {
            this.addCriterion("last_login_ip is null");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLastLoginIpIsNotNull() {
            this.addCriterion("last_login_ip is not null");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLastLoginIpEqualTo(String value) {
            this.addCriterion("last_login_ip =", value, "lastLoginIp");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLastLoginIpNotEqualTo(String value) {
            this.addCriterion("last_login_ip <>", value, "lastLoginIp");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLastLoginIpGreaterThan(String value) {
            this.addCriterion("last_login_ip >", value, "lastLoginIp");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLastLoginIpGreaterThanOrEqualTo(String value) {
            this.addCriterion("last_login_ip >=", value, "lastLoginIp");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLastLoginIpLessThan(String value) {
            this.addCriterion("last_login_ip <", value, "lastLoginIp");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLastLoginIpLessThanOrEqualTo(String value) {
            this.addCriterion("last_login_ip <=", value, "lastLoginIp");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLastLoginIpLike(String value) {
            this.addCriterion("last_login_ip like", value, "lastLoginIp");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLastLoginIpNotLike(String value) {
            this.addCriterion("last_login_ip not like", value, "lastLoginIp");
            return (ManagerUserExample.Criteria)this;
        }        public ManagerUserExample.Criteria andLastLoginIpIn(List<String> values) {
            this.addCriterion("last_login_ip in", values, "lastLoginIp");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLastLoginIpNotIn(List<String> values) {
            this.addCriterion("last_login_ip not in", values, "lastLoginIp");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLastLoginIpBetween(String value1, String value2) {
            this.addCriterion("last_login_ip between", value1, value2, "lastLoginIp");
            return (ManagerUserExample.Criteria)this;
        }

        public ManagerUserExample.Criteria andLastLoginIpNotBetween(String value1, String value2) {
            this.addCriterion("last_login_ip not between", value1, value2, "lastLoginIp");
            return (ManagerUserExample.Criteria)this;
        }
    }
}
