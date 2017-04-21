package com.opentae.data.mana.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagerUserRoleExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<ManagerUserRoleExample.Criteria> oredCriteria = new ArrayList();

    public ManagerUserRoleExample() {
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

    public List<ManagerUserRoleExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ManagerUserRoleExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ManagerUserRoleExample.Criteria or() {
        ManagerUserRoleExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ManagerUserRoleExample.Criteria createCriteria() {
        ManagerUserRoleExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ManagerUserRoleExample.Criteria createCriteriaInternal() {
        ManagerUserRoleExample.Criteria criteria = new ManagerUserRoleExample.Criteria();
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

    public static class Criteria extends ManagerUserRoleExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ManagerUserRoleExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ManagerUserRoleExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ManagerUserRoleExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ManagerUserRoleExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ManagerUserRoleExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ManagerUserRoleExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ManagerUserRoleExample.Criteria andUserRoleIdIsNull() {
            this.addCriterion("user_role_id is null");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserRoleIdIsNotNull() {
            this.addCriterion("user_role_id is not null");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserRoleIdEqualTo(Long value) {
            this.addCriterion("user_role_id =", value, "userRoleId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserRoleIdNotEqualTo(Long value) {
            this.addCriterion("user_role_id <>", value, "userRoleId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserRoleIdGreaterThan(Long value) {
            this.addCriterion("user_role_id >", value, "userRoleId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserRoleIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_role_id >=", value, "userRoleId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserRoleIdLessThan(Long value) {
            this.addCriterion("user_role_id <", value, "userRoleId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserRoleIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_role_id <=", value, "userRoleId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserRoleIdLike(String value) {
            this.addCriterion("user_role_id like", value, "userRoleId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserRoleIdNotLike(String value) {
            this.addCriterion("user_role_id not like", value, "userRoleId");
            return (ManagerUserRoleExample.Criteria)this;
        }        public ManagerUserRoleExample.Criteria andUserRoleIdIn(List<Long> values) {
            this.addCriterion("user_role_id in", values, "userRoleId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserRoleIdNotIn(List<Long> values) {
            this.addCriterion("user_role_id not in", values, "userRoleId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserRoleIdBetween(Long value1, Long value2) {
            this.addCriterion("user_role_id between", value1, value2, "userRoleId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserRoleIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_role_id not between", value1, value2, "userRoleId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (ManagerUserRoleExample.Criteria)this;
        }        public ManagerUserRoleExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andRoleIdIsNull() {
            this.addCriterion("role_id is null");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andRoleIdIsNotNull() {
            this.addCriterion("role_id is not null");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andRoleIdEqualTo(Long value) {
            this.addCriterion("role_id =", value, "roleId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andRoleIdNotEqualTo(Long value) {
            this.addCriterion("role_id <>", value, "roleId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andRoleIdGreaterThan(Long value) {
            this.addCriterion("role_id >", value, "roleId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andRoleIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("role_id >=", value, "roleId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andRoleIdLessThan(Long value) {
            this.addCriterion("role_id <", value, "roleId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andRoleIdLessThanOrEqualTo(Long value) {
            this.addCriterion("role_id <=", value, "roleId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andRoleIdLike(String value) {
            this.addCriterion("role_id like", value, "roleId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andRoleIdNotLike(String value) {
            this.addCriterion("role_id not like", value, "roleId");
            return (ManagerUserRoleExample.Criteria)this;
        }        public ManagerUserRoleExample.Criteria andRoleIdIn(List<Long> values) {
            this.addCriterion("role_id in", values, "roleId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andRoleIdNotIn(List<Long> values) {
            this.addCriterion("role_id not in", values, "roleId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andRoleIdBetween(Long value1, Long value2) {
            this.addCriterion("role_id between", value1, value2, "roleId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andRoleIdNotBetween(Long value1, Long value2) {
            this.addCriterion("role_id not between", value1, value2, "roleId");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (ManagerUserRoleExample.Criteria)this;
        }        public ManagerUserRoleExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (ManagerUserRoleExample.Criteria)this;
        }

        public ManagerUserRoleExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (ManagerUserRoleExample.Criteria)this;
        }
    }
}
