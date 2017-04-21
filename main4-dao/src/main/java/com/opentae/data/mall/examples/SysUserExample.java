package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class SysUserExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<SysUserExample.Criteria> oredCriteria = new ArrayList();

    public SysUserExample() {
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

    public List<SysUserExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(SysUserExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public SysUserExample.Criteria or() {
        SysUserExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public SysUserExample.Criteria createCriteria() {
        SysUserExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected SysUserExample.Criteria createCriteriaInternal() {
        SysUserExample.Criteria criteria = new SysUserExample.Criteria();
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

    public static class Criteria extends SysUserExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<SysUserExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<SysUserExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<SysUserExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new SysUserExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new SysUserExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new SysUserExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public SysUserExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNoIsNull() {
            this.addCriterion("user_no is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNoIsNotNull() {
            this.addCriterion("user_no is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNoEqualTo(String value) {
            this.addCriterion("user_no =", value, "userNo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNoNotEqualTo(String value) {
            this.addCriterion("user_no <>", value, "userNo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNoGreaterThan(String value) {
            this.addCriterion("user_no >", value, "userNo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNoGreaterThanOrEqualTo(String value) {
            this.addCriterion("user_no >=", value, "userNo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNoLessThan(String value) {
            this.addCriterion("user_no <", value, "userNo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNoLessThanOrEqualTo(String value) {
            this.addCriterion("user_no <=", value, "userNo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNoLike(String value) {
            this.addCriterion("user_no like", value, "userNo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNoNotLike(String value) {
            this.addCriterion("user_no not like", value, "userNo");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andUserNoIn(List<String> values) {
            this.addCriterion("user_no in", values, "userNo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNoNotIn(List<String> values) {
            this.addCriterion("user_no not in", values, "userNo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNoBetween(String value1, String value2) {
            this.addCriterion("user_no between", value1, value2, "userNo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNoNotBetween(String value1, String value2) {
            this.addCriterion("user_no not between", value1, value2, "userNo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andOrgIdIsNull() {
            this.addCriterion("org_id is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andOrgIdIsNotNull() {
            this.addCriterion("org_id is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andOrgIdEqualTo(Long value) {
            this.addCriterion("org_id =", value, "orgId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andOrgIdNotEqualTo(Long value) {
            this.addCriterion("org_id <>", value, "orgId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andOrgIdGreaterThan(Long value) {
            this.addCriterion("org_id >", value, "orgId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andOrgIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("org_id >=", value, "orgId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andOrgIdLessThan(Long value) {
            this.addCriterion("org_id <", value, "orgId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andOrgIdLessThanOrEqualTo(Long value) {
            this.addCriterion("org_id <=", value, "orgId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andOrgIdLike(String value) {
            this.addCriterion("org_id like", value, "orgId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andOrgIdNotLike(String value) {
            this.addCriterion("org_id not like", value, "orgId");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andOrgIdIn(List<Long> values) {
            this.addCriterion("org_id in", values, "orgId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andOrgIdNotIn(List<Long> values) {
            this.addCriterion("org_id not in", values, "orgId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andOrgIdBetween(Long value1, Long value2) {
            this.addCriterion("org_id between", value1, value2, "orgId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andOrgIdNotBetween(Long value1, Long value2) {
            this.addCriterion("org_id not between", value1, value2, "orgId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginNameIsNull() {
            this.addCriterion("login_name is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginNameIsNotNull() {
            this.addCriterion("login_name is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginNameEqualTo(String value) {
            this.addCriterion("login_name =", value, "loginName");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginNameNotEqualTo(String value) {
            this.addCriterion("login_name <>", value, "loginName");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginNameGreaterThan(String value) {
            this.addCriterion("login_name >", value, "loginName");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("login_name >=", value, "loginName");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginNameLessThan(String value) {
            this.addCriterion("login_name <", value, "loginName");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginNameLessThanOrEqualTo(String value) {
            this.addCriterion("login_name <=", value, "loginName");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginNameLike(String value) {
            this.addCriterion("login_name like", value, "loginName");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginNameNotLike(String value) {
            this.addCriterion("login_name not like", value, "loginName");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andLoginNameIn(List<String> values) {
            this.addCriterion("login_name in", values, "loginName");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginNameNotIn(List<String> values) {
            this.addCriterion("login_name not in", values, "loginName");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginNameBetween(String value1, String value2) {
            this.addCriterion("login_name between", value1, value2, "loginName");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginNameNotBetween(String value1, String value2) {
            this.addCriterion("login_name not between", value1, value2, "loginName");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginPwdIsNull() {
            this.addCriterion("login_pwd is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginPwdIsNotNull() {
            this.addCriterion("login_pwd is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginPwdEqualTo(String value) {
            this.addCriterion("login_pwd =", value, "loginPwd");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginPwdNotEqualTo(String value) {
            this.addCriterion("login_pwd <>", value, "loginPwd");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginPwdGreaterThan(String value) {
            this.addCriterion("login_pwd >", value, "loginPwd");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginPwdGreaterThanOrEqualTo(String value) {
            this.addCriterion("login_pwd >=", value, "loginPwd");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginPwdLessThan(String value) {
            this.addCriterion("login_pwd <", value, "loginPwd");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginPwdLessThanOrEqualTo(String value) {
            this.addCriterion("login_pwd <=", value, "loginPwd");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginPwdLike(String value) {
            this.addCriterion("login_pwd like", value, "loginPwd");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginPwdNotLike(String value) {
            this.addCriterion("login_pwd not like", value, "loginPwd");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andLoginPwdIn(List<String> values) {
            this.addCriterion("login_pwd in", values, "loginPwd");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginPwdNotIn(List<String> values) {
            this.addCriterion("login_pwd not in", values, "loginPwd");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginPwdBetween(String value1, String value2) {
            this.addCriterion("login_pwd between", value1, value2, "loginPwd");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginPwdNotBetween(String value1, String value2) {
            this.addCriterion("login_pwd not between", value1, value2, "loginPwd");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNameIsNull() {
            this.addCriterion("user_name is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNameIsNotNull() {
            this.addCriterion("user_name is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNameEqualTo(String value) {
            this.addCriterion("user_name =", value, "userName");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNameNotEqualTo(String value) {
            this.addCriterion("user_name <>", value, "userName");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNameGreaterThan(String value) {
            this.addCriterion("user_name >", value, "userName");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("user_name >=", value, "userName");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNameLessThan(String value) {
            this.addCriterion("user_name <", value, "userName");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNameLessThanOrEqualTo(String value) {
            this.addCriterion("user_name <=", value, "userName");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNameLike(String value) {
            this.addCriterion("user_name like", value, "userName");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNameNotLike(String value) {
            this.addCriterion("user_name not like", value, "userName");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andUserNameIn(List<String> values) {
            this.addCriterion("user_name in", values, "userName");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNameNotIn(List<String> values) {
            this.addCriterion("user_name not in", values, "userName");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNameBetween(String value1, String value2) {
            this.addCriterion("user_name between", value1, value2, "userName");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUserNameNotBetween(String value1, String value2) {
            this.addCriterion("user_name not between", value1, value2, "userName");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andNativesIsNull() {
            this.addCriterion("natives is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andNativesIsNotNull() {
            this.addCriterion("natives is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andNativesEqualTo(String value) {
            this.addCriterion("natives =", value, "natives");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andNativesNotEqualTo(String value) {
            this.addCriterion("natives <>", value, "natives");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andNativesGreaterThan(String value) {
            this.addCriterion("natives >", value, "natives");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andNativesGreaterThanOrEqualTo(String value) {
            this.addCriterion("natives >=", value, "natives");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andNativesLessThan(String value) {
            this.addCriterion("natives <", value, "natives");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andNativesLessThanOrEqualTo(String value) {
            this.addCriterion("natives <=", value, "natives");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andNativesLike(String value) {
            this.addCriterion("natives like", value, "natives");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andNativesNotLike(String value) {
            this.addCriterion("natives not like", value, "natives");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andNativesIn(List<String> values) {
            this.addCriterion("natives in", values, "natives");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andNativesNotIn(List<String> values) {
            this.addCriterion("natives not in", values, "natives");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andNativesBetween(String value1, String value2) {
            this.addCriterion("natives between", value1, value2, "natives");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andNativesNotBetween(String value1, String value2) {
            this.addCriterion("natives not between", value1, value2, "natives");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andWorkdutyIsNull() {
            this.addCriterion("workduty is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andWorkdutyIsNotNull() {
            this.addCriterion("workduty is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andWorkdutyEqualTo(String value) {
            this.addCriterion("workduty =", value, "workduty");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andWorkdutyNotEqualTo(String value) {
            this.addCriterion("workduty <>", value, "workduty");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andWorkdutyGreaterThan(String value) {
            this.addCriterion("workduty >", value, "workduty");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andWorkdutyGreaterThanOrEqualTo(String value) {
            this.addCriterion("workduty >=", value, "workduty");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andWorkdutyLessThan(String value) {
            this.addCriterion("workduty <", value, "workduty");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andWorkdutyLessThanOrEqualTo(String value) {
            this.addCriterion("workduty <=", value, "workduty");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andWorkdutyLike(String value) {
            this.addCriterion("workduty like", value, "workduty");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andWorkdutyNotLike(String value) {
            this.addCriterion("workduty not like", value, "workduty");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andWorkdutyIn(List<String> values) {
            this.addCriterion("workduty in", values, "workduty");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andWorkdutyNotIn(List<String> values) {
            this.addCriterion("workduty not in", values, "workduty");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andWorkdutyBetween(String value1, String value2) {
            this.addCriterion("workduty between", value1, value2, "workduty");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andWorkdutyNotBetween(String value1, String value2) {
            this.addCriterion("workduty not between", value1, value2, "workduty");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSexIsNull() {
            this.addCriterion("sex is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSexIsNotNull() {
            this.addCriterion("sex is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSexEqualTo(String value) {
            this.addCriterion("sex =", value, "sex");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSexNotEqualTo(String value) {
            this.addCriterion("sex <>", value, "sex");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSexGreaterThan(String value) {
            this.addCriterion("sex >", value, "sex");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSexGreaterThanOrEqualTo(String value) {
            this.addCriterion("sex >=", value, "sex");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSexLessThan(String value) {
            this.addCriterion("sex <", value, "sex");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSexLessThanOrEqualTo(String value) {
            this.addCriterion("sex <=", value, "sex");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSexLike(String value) {
            this.addCriterion("sex like", value, "sex");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSexNotLike(String value) {
            this.addCriterion("sex not like", value, "sex");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andSexIn(List<String> values) {
            this.addCriterion("sex in", values, "sex");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSexNotIn(List<String> values) {
            this.addCriterion("sex not in", values, "sex");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSexBetween(String value1, String value2) {
            this.addCriterion("sex between", value1, value2, "sex");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSexNotBetween(String value1, String value2) {
            this.addCriterion("sex not between", value1, value2, "sex");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andHomephoneIsNull() {
            this.addCriterion("homephone is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andHomephoneIsNotNull() {
            this.addCriterion("homephone is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andHomephoneEqualTo(String value) {
            this.addCriterion("homephone =", value, "homephone");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andHomephoneNotEqualTo(String value) {
            this.addCriterion("homephone <>", value, "homephone");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andHomephoneGreaterThan(String value) {
            this.addCriterion("homephone >", value, "homephone");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andHomephoneGreaterThanOrEqualTo(String value) {
            this.addCriterion("homephone >=", value, "homephone");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andHomephoneLessThan(String value) {
            this.addCriterion("homephone <", value, "homephone");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andHomephoneLessThanOrEqualTo(String value) {
            this.addCriterion("homephone <=", value, "homephone");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andHomephoneLike(String value) {
            this.addCriterion("homephone like", value, "homephone");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andHomephoneNotLike(String value) {
            this.addCriterion("homephone not like", value, "homephone");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andHomephoneIn(List<String> values) {
            this.addCriterion("homephone in", values, "homephone");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andHomephoneNotIn(List<String> values) {
            this.addCriterion("homephone not in", values, "homephone");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andHomephoneBetween(String value1, String value2) {
            this.addCriterion("homephone between", value1, value2, "homephone");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andHomephoneNotBetween(String value1, String value2) {
            this.addCriterion("homephone not between", value1, value2, "homephone");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andEmailIsNull() {
            this.addCriterion("email is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andEmailIsNotNull() {
            this.addCriterion("email is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andEmailEqualTo(String value) {
            this.addCriterion("email =", value, "email");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andEmailNotEqualTo(String value) {
            this.addCriterion("email <>", value, "email");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andEmailGreaterThan(String value) {
            this.addCriterion("email >", value, "email");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andEmailGreaterThanOrEqualTo(String value) {
            this.addCriterion("email >=", value, "email");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andEmailLessThan(String value) {
            this.addCriterion("email <", value, "email");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andEmailLessThanOrEqualTo(String value) {
            this.addCriterion("email <=", value, "email");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andEmailLike(String value) {
            this.addCriterion("email like", value, "email");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andEmailNotLike(String value) {
            this.addCriterion("email not like", value, "email");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andEmailIn(List<String> values) {
            this.addCriterion("email in", values, "email");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andEmailNotIn(List<String> values) {
            this.addCriterion("email not in", values, "email");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andEmailBetween(String value1, String value2) {
            this.addCriterion("email between", value1, value2, "email");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andEmailNotBetween(String value1, String value2) {
            this.addCriterion("email not between", value1, value2, "email");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAddressIsNull() {
            this.addCriterion("address is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAddressIsNotNull() {
            this.addCriterion("address is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAddressEqualTo(String value) {
            this.addCriterion("address =", value, "address");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAddressNotEqualTo(String value) {
            this.addCriterion("address <>", value, "address");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAddressGreaterThan(String value) {
            this.addCriterion("address >", value, "address");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAddressGreaterThanOrEqualTo(String value) {
            this.addCriterion("address >=", value, "address");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAddressLessThan(String value) {
            this.addCriterion("address <", value, "address");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAddressLessThanOrEqualTo(String value) {
            this.addCriterion("address <=", value, "address");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAddressLike(String value) {
            this.addCriterion("address like", value, "address");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAddressNotLike(String value) {
            this.addCriterion("address not like", value, "address");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andAddressIn(List<String> values) {
            this.addCriterion("address in", values, "address");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAddressNotIn(List<String> values) {
            this.addCriterion("address not in", values, "address");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAddressBetween(String value1, String value2) {
            this.addCriterion("address between", value1, value2, "address");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAddressNotBetween(String value1, String value2) {
            this.addCriterion("address not between", value1, value2, "address");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andPhoneIsNull() {
            this.addCriterion("phone is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andPhoneIsNotNull() {
            this.addCriterion("phone is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andPhoneEqualTo(String value) {
            this.addCriterion("phone =", value, "phone");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andPhoneNotEqualTo(String value) {
            this.addCriterion("phone <>", value, "phone");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andPhoneGreaterThan(String value) {
            this.addCriterion("phone >", value, "phone");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andPhoneGreaterThanOrEqualTo(String value) {
            this.addCriterion("phone >=", value, "phone");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andPhoneLessThan(String value) {
            this.addCriterion("phone <", value, "phone");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andPhoneLessThanOrEqualTo(String value) {
            this.addCriterion("phone <=", value, "phone");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andPhoneLike(String value) {
            this.addCriterion("phone like", value, "phone");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andPhoneNotLike(String value) {
            this.addCriterion("phone not like", value, "phone");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andPhoneIn(List<String> values) {
            this.addCriterion("phone in", values, "phone");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andPhoneNotIn(List<String> values) {
            this.addCriterion("phone not in", values, "phone");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andPhoneBetween(String value1, String value2) {
            this.addCriterion("phone between", value1, value2, "phone");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andPhoneNotBetween(String value1, String value2) {
            this.addCriterion("phone not between", value1, value2, "phone");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCreateDateIsNull() {
            this.addCriterion("create_date is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCreateDateIsNotNull() {
            this.addCriterion("create_date is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCreateDateEqualTo(Date value) {
            this.addCriterion("create_date =", value, "createDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCreateDateNotEqualTo(Date value) {
            this.addCriterion("create_date <>", value, "createDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCreateDateGreaterThan(Date value) {
            this.addCriterion("create_date >", value, "createDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_date >=", value, "createDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCreateDateLessThan(Date value) {
            this.addCriterion("create_date <", value, "createDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCreateDateLessThanOrEqualTo(Date value) {
            this.addCriterion("create_date <=", value, "createDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCreateDateLike(String value) {
            this.addCriterion("create_date like", value, "createDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCreateDateNotLike(String value) {
            this.addCriterion("create_date not like", value, "createDate");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andCreateDateIn(List<Date> values) {
            this.addCriterion("create_date in", values, "createDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCreateDateNotIn(List<Date> values) {
            this.addCriterion("create_date not in", values, "createDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCreateDateBetween(Date value1, Date value2) {
            this.addCriterion("create_date between", value1, value2, "createDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCreateDateNotBetween(Date value1, Date value2) {
            this.addCriterion("create_date not between", value1, value2, "createDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andModifyDateIsNull() {
            this.addCriterion("modify_date is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andModifyDateIsNotNull() {
            this.addCriterion("modify_date is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andModifyDateEqualTo(Date value) {
            this.addCriterion("modify_date =", value, "modifyDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andModifyDateNotEqualTo(Date value) {
            this.addCriterion("modify_date <>", value, "modifyDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andModifyDateGreaterThan(Date value) {
            this.addCriterion("modify_date >", value, "modifyDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
            this.addCriterion("modify_date >=", value, "modifyDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andModifyDateLessThan(Date value) {
            this.addCriterion("modify_date <", value, "modifyDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andModifyDateLessThanOrEqualTo(Date value) {
            this.addCriterion("modify_date <=", value, "modifyDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andModifyDateLike(String value) {
            this.addCriterion("modify_date like", value, "modifyDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andModifyDateNotLike(String value) {
            this.addCriterion("modify_date not like", value, "modifyDate");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andModifyDateIn(List<Date> values) {
            this.addCriterion("modify_date in", values, "modifyDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andModifyDateNotIn(List<Date> values) {
            this.addCriterion("modify_date not in", values, "modifyDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andModifyDateBetween(Date value1, Date value2) {
            this.addCriterion("modify_date between", value1, value2, "modifyDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andModifyDateNotBetween(Date value1, Date value2) {
            this.addCriterion("modify_date not between", value1, value2, "modifyDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLastLoginDateIsNull() {
            this.addCriterion("last_login_date is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLastLoginDateIsNotNull() {
            this.addCriterion("last_login_date is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLastLoginDateEqualTo(Date value) {
            this.addCriterion("last_login_date =", value, "lastLoginDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLastLoginDateNotEqualTo(Date value) {
            this.addCriterion("last_login_date <>", value, "lastLoginDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLastLoginDateGreaterThan(Date value) {
            this.addCriterion("last_login_date >", value, "lastLoginDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLastLoginDateGreaterThanOrEqualTo(Date value) {
            this.addCriterion("last_login_date >=", value, "lastLoginDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLastLoginDateLessThan(Date value) {
            this.addCriterion("last_login_date <", value, "lastLoginDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLastLoginDateLessThanOrEqualTo(Date value) {
            this.addCriterion("last_login_date <=", value, "lastLoginDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLastLoginDateLike(String value) {
            this.addCriterion("last_login_date like", value, "lastLoginDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLastLoginDateNotLike(String value) {
            this.addCriterion("last_login_date not like", value, "lastLoginDate");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andLastLoginDateIn(List<Date> values) {
            this.addCriterion("last_login_date in", values, "lastLoginDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLastLoginDateNotIn(List<Date> values) {
            this.addCriterion("last_login_date not in", values, "lastLoginDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLastLoginDateBetween(Date value1, Date value2) {
            this.addCriterion("last_login_date between", value1, value2, "lastLoginDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLastLoginDateNotBetween(Date value1, Date value2) {
            this.addCriterion("last_login_date not between", value1, value2, "lastLoginDate");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginTimesIsNull() {
            this.addCriterion("login_times is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginTimesIsNotNull() {
            this.addCriterion("login_times is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginTimesEqualTo(Long value) {
            this.addCriterion("login_times =", value, "loginTimes");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginTimesNotEqualTo(Long value) {
            this.addCriterion("login_times <>", value, "loginTimes");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginTimesGreaterThan(Long value) {
            this.addCriterion("login_times >", value, "loginTimes");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginTimesGreaterThanOrEqualTo(Long value) {
            this.addCriterion("login_times >=", value, "loginTimes");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginTimesLessThan(Long value) {
            this.addCriterion("login_times <", value, "loginTimes");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginTimesLessThanOrEqualTo(Long value) {
            this.addCriterion("login_times <=", value, "loginTimes");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginTimesLike(String value) {
            this.addCriterion("login_times like", value, "loginTimes");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginTimesNotLike(String value) {
            this.addCriterion("login_times not like", value, "loginTimes");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andLoginTimesIn(List<Long> values) {
            this.addCriterion("login_times in", values, "loginTimes");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginTimesNotIn(List<Long> values) {
            this.addCriterion("login_times not in", values, "loginTimes");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginTimesBetween(Long value1, Long value2) {
            this.addCriterion("login_times between", value1, value2, "loginTimes");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLoginTimesNotBetween(Long value1, Long value2) {
            this.addCriterion("login_times not between", value1, value2, "loginTimes");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUsesStatusIsNull() {
            this.addCriterion("uses_status is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUsesStatusIsNotNull() {
            this.addCriterion("uses_status is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUsesStatusEqualTo(Integer value) {
            this.addCriterion("uses_status =", value, "usesStatus");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUsesStatusNotEqualTo(Integer value) {
            this.addCriterion("uses_status <>", value, "usesStatus");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUsesStatusGreaterThan(Integer value) {
            this.addCriterion("uses_status >", value, "usesStatus");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUsesStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("uses_status >=", value, "usesStatus");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUsesStatusLessThan(Integer value) {
            this.addCriterion("uses_status <", value, "usesStatus");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUsesStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("uses_status <=", value, "usesStatus");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUsesStatusLike(String value) {
            this.addCriterion("uses_status like", value, "usesStatus");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUsesStatusNotLike(String value) {
            this.addCriterion("uses_status not like", value, "usesStatus");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andUsesStatusIn(List<Integer> values) {
            this.addCriterion("uses_status in", values, "usesStatus");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUsesStatusNotIn(List<Integer> values) {
            this.addCriterion("uses_status not in", values, "usesStatus");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUsesStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("uses_status between", value1, value2, "usesStatus");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andUsesStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("uses_status not between", value1, value2, "usesStatus");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andDescInfoIsNull() {
            this.addCriterion("desc_info is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andDescInfoIsNotNull() {
            this.addCriterion("desc_info is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andDescInfoEqualTo(String value) {
            this.addCriterion("desc_info =", value, "descInfo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andDescInfoNotEqualTo(String value) {
            this.addCriterion("desc_info <>", value, "descInfo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andDescInfoGreaterThan(String value) {
            this.addCriterion("desc_info >", value, "descInfo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andDescInfoGreaterThanOrEqualTo(String value) {
            this.addCriterion("desc_info >=", value, "descInfo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andDescInfoLessThan(String value) {
            this.addCriterion("desc_info <", value, "descInfo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andDescInfoLessThanOrEqualTo(String value) {
            this.addCriterion("desc_info <=", value, "descInfo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andDescInfoLike(String value) {
            this.addCriterion("desc_info like", value, "descInfo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andDescInfoNotLike(String value) {
            this.addCriterion("desc_info not like", value, "descInfo");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andDescInfoIn(List<String> values) {
            this.addCriterion("desc_info in", values, "descInfo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andDescInfoNotIn(List<String> values) {
            this.addCriterion("desc_info not in", values, "descInfo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andDescInfoBetween(String value1, String value2) {
            this.addCriterion("desc_info between", value1, value2, "descInfo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andDescInfoNotBetween(String value1, String value2) {
            this.addCriterion("desc_info not between", value1, value2, "descInfo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLevelNumIsNull() {
            this.addCriterion("level_num is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLevelNumIsNotNull() {
            this.addCriterion("level_num is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLevelNumEqualTo(Long value) {
            this.addCriterion("level_num =", value, "levelNum");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLevelNumNotEqualTo(Long value) {
            this.addCriterion("level_num <>", value, "levelNum");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLevelNumGreaterThan(Long value) {
            this.addCriterion("level_num >", value, "levelNum");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLevelNumGreaterThanOrEqualTo(Long value) {
            this.addCriterion("level_num >=", value, "levelNum");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLevelNumLessThan(Long value) {
            this.addCriterion("level_num <", value, "levelNum");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLevelNumLessThanOrEqualTo(Long value) {
            this.addCriterion("level_num <=", value, "levelNum");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLevelNumLike(String value) {
            this.addCriterion("level_num like", value, "levelNum");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLevelNumNotLike(String value) {
            this.addCriterion("level_num not like", value, "levelNum");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andLevelNumIn(List<Long> values) {
            this.addCriterion("level_num in", values, "levelNum");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLevelNumNotIn(List<Long> values) {
            this.addCriterion("level_num not in", values, "levelNum");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLevelNumBetween(Long value1, Long value2) {
            this.addCriterion("level_num between", value1, value2, "levelNum");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andLevelNumNotBetween(Long value1, Long value2) {
            this.addCriterion("level_num not between", value1, value2, "levelNum");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSortOrderIsNull() {
            this.addCriterion("sort_order is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSortOrderIsNotNull() {
            this.addCriterion("sort_order is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSortOrderEqualTo(Long value) {
            this.addCriterion("sort_order =", value, "sortOrder");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSortOrderNotEqualTo(Long value) {
            this.addCriterion("sort_order <>", value, "sortOrder");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSortOrderGreaterThan(Long value) {
            this.addCriterion("sort_order >", value, "sortOrder");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSortOrderGreaterThanOrEqualTo(Long value) {
            this.addCriterion("sort_order >=", value, "sortOrder");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSortOrderLessThan(Long value) {
            this.addCriterion("sort_order <", value, "sortOrder");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSortOrderLessThanOrEqualTo(Long value) {
            this.addCriterion("sort_order <=", value, "sortOrder");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSortOrderLike(String value) {
            this.addCriterion("sort_order like", value, "sortOrder");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSortOrderNotLike(String value) {
            this.addCriterion("sort_order not like", value, "sortOrder");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andSortOrderIn(List<Long> values) {
            this.addCriterion("sort_order in", values, "sortOrder");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSortOrderNotIn(List<Long> values) {
            this.addCriterion("sort_order not in", values, "sortOrder");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSortOrderBetween(Long value1, Long value2) {
            this.addCriterion("sort_order between", value1, value2, "sortOrder");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andSortOrderNotBetween(Long value1, Long value2) {
            this.addCriterion("sort_order not between", value1, value2, "sortOrder");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImSkypeIsNull() {
            this.addCriterion("im_skype is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImSkypeIsNotNull() {
            this.addCriterion("im_skype is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImSkypeEqualTo(String value) {
            this.addCriterion("im_skype =", value, "imSkype");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImSkypeNotEqualTo(String value) {
            this.addCriterion("im_skype <>", value, "imSkype");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImSkypeGreaterThan(String value) {
            this.addCriterion("im_skype >", value, "imSkype");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImSkypeGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_skype >=", value, "imSkype");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImSkypeLessThan(String value) {
            this.addCriterion("im_skype <", value, "imSkype");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImSkypeLessThanOrEqualTo(String value) {
            this.addCriterion("im_skype <=", value, "imSkype");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImSkypeLike(String value) {
            this.addCriterion("im_skype like", value, "imSkype");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImSkypeNotLike(String value) {
            this.addCriterion("im_skype not like", value, "imSkype");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andImSkypeIn(List<String> values) {
            this.addCriterion("im_skype in", values, "imSkype");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImSkypeNotIn(List<String> values) {
            this.addCriterion("im_skype not in", values, "imSkype");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImSkypeBetween(String value1, String value2) {
            this.addCriterion("im_skype between", value1, value2, "imSkype");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImSkypeNotBetween(String value1, String value2) {
            this.addCriterion("im_skype not between", value1, value2, "imSkype");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImWeixinIsNull() {
            this.addCriterion("im_weixin is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImWeixinIsNotNull() {
            this.addCriterion("im_weixin is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImWeixinEqualTo(String value) {
            this.addCriterion("im_weixin =", value, "imWeixin");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImWeixinNotEqualTo(String value) {
            this.addCriterion("im_weixin <>", value, "imWeixin");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImWeixinGreaterThan(String value) {
            this.addCriterion("im_weixin >", value, "imWeixin");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImWeixinGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_weixin >=", value, "imWeixin");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImWeixinLessThan(String value) {
            this.addCriterion("im_weixin <", value, "imWeixin");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImWeixinLessThanOrEqualTo(String value) {
            this.addCriterion("im_weixin <=", value, "imWeixin");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImWeixinLike(String value) {
            this.addCriterion("im_weixin like", value, "imWeixin");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImWeixinNotLike(String value) {
            this.addCriterion("im_weixin not like", value, "imWeixin");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andImWeixinIn(List<String> values) {
            this.addCriterion("im_weixin in", values, "imWeixin");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImWeixinNotIn(List<String> values) {
            this.addCriterion("im_weixin not in", values, "imWeixin");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImWeixinBetween(String value1, String value2) {
            this.addCriterion("im_weixin between", value1, value2, "imWeixin");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImWeixinNotBetween(String value1, String value2) {
            this.addCriterion("im_weixin not between", value1, value2, "imWeixin");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImAliwwIsNull() {
            this.addCriterion("im_aliww is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImAliwwIsNotNull() {
            this.addCriterion("im_aliww is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImAliwwEqualTo(String value) {
            this.addCriterion("im_aliww =", value, "imAliww");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImAliwwNotEqualTo(String value) {
            this.addCriterion("im_aliww <>", value, "imAliww");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImAliwwGreaterThan(String value) {
            this.addCriterion("im_aliww >", value, "imAliww");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImAliwwGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_aliww >=", value, "imAliww");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImAliwwLessThan(String value) {
            this.addCriterion("im_aliww <", value, "imAliww");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImAliwwLessThanOrEqualTo(String value) {
            this.addCriterion("im_aliww <=", value, "imAliww");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImAliwwLike(String value) {
            this.addCriterion("im_aliww like", value, "imAliww");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImAliwwNotLike(String value) {
            this.addCriterion("im_aliww not like", value, "imAliww");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andImAliwwIn(List<String> values) {
            this.addCriterion("im_aliww in", values, "imAliww");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImAliwwNotIn(List<String> values) {
            this.addCriterion("im_aliww not in", values, "imAliww");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImAliwwBetween(String value1, String value2) {
            this.addCriterion("im_aliww between", value1, value2, "imAliww");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImAliwwNotBetween(String value1, String value2) {
            this.addCriterion("im_aliww not between", value1, value2, "imAliww");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImYahooWeiboIsNull() {
            this.addCriterion("im_yahoo_weibo is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImYahooWeiboIsNotNull() {
            this.addCriterion("im_yahoo_weibo is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImYahooWeiboEqualTo(String value) {
            this.addCriterion("im_yahoo_weibo =", value, "imYahooWeibo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImYahooWeiboNotEqualTo(String value) {
            this.addCriterion("im_yahoo_weibo <>", value, "imYahooWeibo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImYahooWeiboGreaterThan(String value) {
            this.addCriterion("im_yahoo_weibo >", value, "imYahooWeibo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImYahooWeiboGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_yahoo_weibo >=", value, "imYahooWeibo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImYahooWeiboLessThan(String value) {
            this.addCriterion("im_yahoo_weibo <", value, "imYahooWeibo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImYahooWeiboLessThanOrEqualTo(String value) {
            this.addCriterion("im_yahoo_weibo <=", value, "imYahooWeibo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImYahooWeiboLike(String value) {
            this.addCriterion("im_yahoo_weibo like", value, "imYahooWeibo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImYahooWeiboNotLike(String value) {
            this.addCriterion("im_yahoo_weibo not like", value, "imYahooWeibo");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andImYahooWeiboIn(List<String> values) {
            this.addCriterion("im_yahoo_weibo in", values, "imYahooWeibo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImYahooWeiboNotIn(List<String> values) {
            this.addCriterion("im_yahoo_weibo not in", values, "imYahooWeibo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImYahooWeiboBetween(String value1, String value2) {
            this.addCriterion("im_yahoo_weibo between", value1, value2, "imYahooWeibo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImYahooWeiboNotBetween(String value1, String value2) {
            this.addCriterion("im_yahoo_weibo not between", value1, value2, "imYahooWeibo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqWeiboIsNull() {
            this.addCriterion("im_qq_weibo is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqWeiboIsNotNull() {
            this.addCriterion("im_qq_weibo is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqWeiboEqualTo(String value) {
            this.addCriterion("im_qq_weibo =", value, "imQqWeibo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqWeiboNotEqualTo(String value) {
            this.addCriterion("im_qq_weibo <>", value, "imQqWeibo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqWeiboGreaterThan(String value) {
            this.addCriterion("im_qq_weibo >", value, "imQqWeibo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqWeiboGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_qq_weibo >=", value, "imQqWeibo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqWeiboLessThan(String value) {
            this.addCriterion("im_qq_weibo <", value, "imQqWeibo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqWeiboLessThanOrEqualTo(String value) {
            this.addCriterion("im_qq_weibo <=", value, "imQqWeibo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqWeiboLike(String value) {
            this.addCriterion("im_qq_weibo like", value, "imQqWeibo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqWeiboNotLike(String value) {
            this.addCriterion("im_qq_weibo not like", value, "imQqWeibo");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andImQqWeiboIn(List<String> values) {
            this.addCriterion("im_qq_weibo in", values, "imQqWeibo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqWeiboNotIn(List<String> values) {
            this.addCriterion("im_qq_weibo not in", values, "imQqWeibo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqWeiboBetween(String value1, String value2) {
            this.addCriterion("im_qq_weibo between", value1, value2, "imQqWeibo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqWeiboNotBetween(String value1, String value2) {
            this.addCriterion("im_qq_weibo not between", value1, value2, "imQqWeibo");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqIsNull() {
            this.addCriterion("im_qq is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqIsNotNull() {
            this.addCriterion("im_qq is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqEqualTo(String value) {
            this.addCriterion("im_qq =", value, "imQq");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqNotEqualTo(String value) {
            this.addCriterion("im_qq <>", value, "imQq");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqGreaterThan(String value) {
            this.addCriterion("im_qq >", value, "imQq");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_qq >=", value, "imQq");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqLessThan(String value) {
            this.addCriterion("im_qq <", value, "imQq");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqLessThanOrEqualTo(String value) {
            this.addCriterion("im_qq <=", value, "imQq");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqLike(String value) {
            this.addCriterion("im_qq like", value, "imQq");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqNotLike(String value) {
            this.addCriterion("im_qq not like", value, "imQq");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andImQqIn(List<String> values) {
            this.addCriterion("im_qq in", values, "imQq");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqNotIn(List<String> values) {
            this.addCriterion("im_qq not in", values, "imQq");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqBetween(String value1, String value2) {
            this.addCriterion("im_qq between", value1, value2, "imQq");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andImQqNotBetween(String value1, String value2) {
            this.addCriterion("im_qq not between", value1, value2, "imQq");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBirthdayIsNull() {
            this.addCriterion("birthday is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBirthdayIsNotNull() {
            this.addCriterion("birthday is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBirthdayEqualTo(Date value) {
            this.addCriterion("birthday =", value, "birthday");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBirthdayNotEqualTo(Date value) {
            this.addCriterion("birthday <>", value, "birthday");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBirthdayGreaterThan(Date value) {
            this.addCriterion("birthday >", value, "birthday");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            this.addCriterion("birthday >=", value, "birthday");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBirthdayLessThan(Date value) {
            this.addCriterion("birthday <", value, "birthday");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBirthdayLessThanOrEqualTo(Date value) {
            this.addCriterion("birthday <=", value, "birthday");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBirthdayLike(String value) {
            this.addCriterion("birthday like", value, "birthday");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBirthdayNotLike(String value) {
            this.addCriterion("birthday not like", value, "birthday");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andBirthdayIn(List<Date> values) {
            this.addCriterion("birthday in", values, "birthday");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBirthdayNotIn(List<Date> values) {
            this.addCriterion("birthday not in", values, "birthday");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBirthdayBetween(Date value1, Date value2) {
            this.addCriterion("birthday between", value1, value2, "birthday");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBirthdayNotBetween(Date value1, Date value2) {
            this.addCriterion("birthday not between", value1, value2, "birthday");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCompanyIdIsNull() {
            this.addCriterion("company_id is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCompanyIdIsNotNull() {
            this.addCriterion("company_id is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCompanyIdEqualTo(Long value) {
            this.addCriterion("company_id =", value, "companyId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCompanyIdNotEqualTo(Long value) {
            this.addCriterion("company_id <>", value, "companyId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCompanyIdGreaterThan(Long value) {
            this.addCriterion("company_id >", value, "companyId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCompanyIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("company_id >=", value, "companyId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCompanyIdLessThan(Long value) {
            this.addCriterion("company_id <", value, "companyId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCompanyIdLessThanOrEqualTo(Long value) {
            this.addCriterion("company_id <=", value, "companyId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCompanyIdLike(String value) {
            this.addCriterion("company_id like", value, "companyId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCompanyIdNotLike(String value) {
            this.addCriterion("company_id not like", value, "companyId");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andCompanyIdIn(List<Long> values) {
            this.addCriterion("company_id in", values, "companyId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCompanyIdNotIn(List<Long> values) {
            this.addCriterion("company_id not in", values, "companyId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCompanyIdBetween(Long value1, Long value2) {
            this.addCriterion("company_id between", value1, value2, "companyId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andCompanyIdNotBetween(Long value1, Long value2) {
            this.addCriterion("company_id not between", value1, value2, "companyId");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andIdCardIsNull() {
            this.addCriterion("id_card is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andIdCardIsNotNull() {
            this.addCriterion("id_card is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andIdCardEqualTo(String value) {
            this.addCriterion("id_card =", value, "idCard");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andIdCardNotEqualTo(String value) {
            this.addCriterion("id_card <>", value, "idCard");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andIdCardGreaterThan(String value) {
            this.addCriterion("id_card >", value, "idCard");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andIdCardGreaterThanOrEqualTo(String value) {
            this.addCriterion("id_card >=", value, "idCard");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andIdCardLessThan(String value) {
            this.addCriterion("id_card <", value, "idCard");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andIdCardLessThanOrEqualTo(String value) {
            this.addCriterion("id_card <=", value, "idCard");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andIdCardLike(String value) {
            this.addCriterion("id_card like", value, "idCard");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andIdCardNotLike(String value) {
            this.addCriterion("id_card not like", value, "idCard");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andIdCardIn(List<String> values) {
            this.addCriterion("id_card in", values, "idCard");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andIdCardNotIn(List<String> values) {
            this.addCriterion("id_card not in", values, "idCard");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andIdCardBetween(String value1, String value2) {
            this.addCriterion("id_card between", value1, value2, "idCard");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andIdCardNotBetween(String value1, String value2) {
            this.addCriterion("id_card not between", value1, value2, "idCard");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAccountIsNull() {
            this.addCriterion("account is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAccountIsNotNull() {
            this.addCriterion("account is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAccountEqualTo(String value) {
            this.addCriterion("account =", value, "account");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAccountNotEqualTo(String value) {
            this.addCriterion("account <>", value, "account");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAccountGreaterThan(String value) {
            this.addCriterion("account >", value, "account");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAccountGreaterThanOrEqualTo(String value) {
            this.addCriterion("account >=", value, "account");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAccountLessThan(String value) {
            this.addCriterion("account <", value, "account");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAccountLessThanOrEqualTo(String value) {
            this.addCriterion("account <=", value, "account");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAccountLike(String value) {
            this.addCriterion("account like", value, "account");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAccountNotLike(String value) {
            this.addCriterion("account not like", value, "account");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andAccountIn(List<String> values) {
            this.addCriterion("account in", values, "account");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAccountNotIn(List<String> values) {
            this.addCriterion("account not in", values, "account");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAccountBetween(String value1, String value2) {
            this.addCriterion("account between", value1, value2, "account");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andAccountNotBetween(String value1, String value2) {
            this.addCriterion("account not between", value1, value2, "account");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBalanceIsNull() {
            this.addCriterion("balance is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBalanceIsNotNull() {
            this.addCriterion("balance is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBalanceEqualTo(String value) {
            this.addCriterion("balance =", value, "balance");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBalanceNotEqualTo(String value) {
            this.addCriterion("balance <>", value, "balance");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBalanceGreaterThan(String value) {
            this.addCriterion("balance >", value, "balance");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBalanceGreaterThanOrEqualTo(String value) {
            this.addCriterion("balance >=", value, "balance");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBalanceLessThan(String value) {
            this.addCriterion("balance <", value, "balance");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBalanceLessThanOrEqualTo(String value) {
            this.addCriterion("balance <=", value, "balance");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBalanceLike(String value) {
            this.addCriterion("balance like", value, "balance");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBalanceNotLike(String value) {
            this.addCriterion("balance not like", value, "balance");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andBalanceIn(List<String> values) {
            this.addCriterion("balance in", values, "balance");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBalanceNotIn(List<String> values) {
            this.addCriterion("balance not in", values, "balance");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBalanceBetween(String value1, String value2) {
            this.addCriterion("balance between", value1, value2, "balance");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andBalanceNotBetween(String value1, String value2) {
            this.addCriterion("balance not between", value1, value2, "balance");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (SysUserExample.Criteria)this;
        }        public SysUserExample.Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (SysUserExample.Criteria)this;
        }

        public SysUserExample.Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (SysUserExample.Criteria)this;
        }
    }
}
