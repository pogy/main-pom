package com.opentae.data.mana.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagerRolePermissionExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<ManagerRolePermissionExample.Criteria> oredCriteria = new ArrayList();

    public ManagerRolePermissionExample() {
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

    public List<ManagerRolePermissionExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ManagerRolePermissionExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ManagerRolePermissionExample.Criteria or() {
        ManagerRolePermissionExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ManagerRolePermissionExample.Criteria createCriteria() {
        ManagerRolePermissionExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ManagerRolePermissionExample.Criteria createCriteriaInternal() {
        ManagerRolePermissionExample.Criteria criteria = new ManagerRolePermissionExample.Criteria();
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

    public static class Criteria extends ManagerRolePermissionExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ManagerRolePermissionExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ManagerRolePermissionExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ManagerRolePermissionExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ManagerRolePermissionExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ManagerRolePermissionExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ManagerRolePermissionExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ManagerRolePermissionExample.Criteria andRolePermissionIdIsNull() {
            this.addCriterion("role_permission_id is null");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRolePermissionIdIsNotNull() {
            this.addCriterion("role_permission_id is not null");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRolePermissionIdEqualTo(Long value) {
            this.addCriterion("role_permission_id =", value, "rolePermissionId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRolePermissionIdNotEqualTo(Long value) {
            this.addCriterion("role_permission_id <>", value, "rolePermissionId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRolePermissionIdGreaterThan(Long value) {
            this.addCriterion("role_permission_id >", value, "rolePermissionId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRolePermissionIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("role_permission_id >=", value, "rolePermissionId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRolePermissionIdLessThan(Long value) {
            this.addCriterion("role_permission_id <", value, "rolePermissionId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRolePermissionIdLessThanOrEqualTo(Long value) {
            this.addCriterion("role_permission_id <=", value, "rolePermissionId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRolePermissionIdLike(String value) {
            this.addCriterion("role_permission_id like", value, "rolePermissionId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRolePermissionIdNotLike(String value) {
            this.addCriterion("role_permission_id not like", value, "rolePermissionId");
            return (ManagerRolePermissionExample.Criteria)this;
        }        public ManagerRolePermissionExample.Criteria andRolePermissionIdIn(List<Long> values) {
            this.addCriterion("role_permission_id in", values, "rolePermissionId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRolePermissionIdNotIn(List<Long> values) {
            this.addCriterion("role_permission_id not in", values, "rolePermissionId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRolePermissionIdBetween(Long value1, Long value2) {
            this.addCriterion("role_permission_id between", value1, value2, "rolePermissionId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRolePermissionIdNotBetween(Long value1, Long value2) {
            this.addCriterion("role_permission_id not between", value1, value2, "rolePermissionId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRoleIdIsNull() {
            this.addCriterion("role_id is null");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRoleIdIsNotNull() {
            this.addCriterion("role_id is not null");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRoleIdEqualTo(Long value) {
            this.addCriterion("role_id =", value, "roleId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRoleIdNotEqualTo(Long value) {
            this.addCriterion("role_id <>", value, "roleId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRoleIdGreaterThan(Long value) {
            this.addCriterion("role_id >", value, "roleId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRoleIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("role_id >=", value, "roleId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRoleIdLessThan(Long value) {
            this.addCriterion("role_id <", value, "roleId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRoleIdLessThanOrEqualTo(Long value) {
            this.addCriterion("role_id <=", value, "roleId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRoleIdLike(String value) {
            this.addCriterion("role_id like", value, "roleId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRoleIdNotLike(String value) {
            this.addCriterion("role_id not like", value, "roleId");
            return (ManagerRolePermissionExample.Criteria)this;
        }        public ManagerRolePermissionExample.Criteria andRoleIdIn(List<Long> values) {
            this.addCriterion("role_id in", values, "roleId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRoleIdNotIn(List<Long> values) {
            this.addCriterion("role_id not in", values, "roleId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRoleIdBetween(Long value1, Long value2) {
            this.addCriterion("role_id between", value1, value2, "roleId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andRoleIdNotBetween(Long value1, Long value2) {
            this.addCriterion("role_id not between", value1, value2, "roleId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andPermissionIdIsNull() {
            this.addCriterion("permission_id is null");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andPermissionIdIsNotNull() {
            this.addCriterion("permission_id is not null");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andPermissionIdEqualTo(Long value) {
            this.addCriterion("permission_id =", value, "permissionId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andPermissionIdNotEqualTo(Long value) {
            this.addCriterion("permission_id <>", value, "permissionId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andPermissionIdGreaterThan(Long value) {
            this.addCriterion("permission_id >", value, "permissionId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andPermissionIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("permission_id >=", value, "permissionId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andPermissionIdLessThan(Long value) {
            this.addCriterion("permission_id <", value, "permissionId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andPermissionIdLessThanOrEqualTo(Long value) {
            this.addCriterion("permission_id <=", value, "permissionId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andPermissionIdLike(String value) {
            this.addCriterion("permission_id like", value, "permissionId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andPermissionIdNotLike(String value) {
            this.addCriterion("permission_id not like", value, "permissionId");
            return (ManagerRolePermissionExample.Criteria)this;
        }        public ManagerRolePermissionExample.Criteria andPermissionIdIn(List<Long> values) {
            this.addCriterion("permission_id in", values, "permissionId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andPermissionIdNotIn(List<Long> values) {
            this.addCriterion("permission_id not in", values, "permissionId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andPermissionIdBetween(Long value1, Long value2) {
            this.addCriterion("permission_id between", value1, value2, "permissionId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andPermissionIdNotBetween(Long value1, Long value2) {
            this.addCriterion("permission_id not between", value1, value2, "permissionId");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (ManagerRolePermissionExample.Criteria)this;
        }        public ManagerRolePermissionExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andLastModifyTimeIsNull() {
            this.addCriterion("last_modify_time is null");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andLastModifyTimeIsNotNull() {
            this.addCriterion("last_modify_time is not null");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andLastModifyTimeEqualTo(Date value) {
            this.addCriterion("last_modify_time =", value, "lastModifyTime");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andLastModifyTimeNotEqualTo(Date value) {
            this.addCriterion("last_modify_time <>", value, "lastModifyTime");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andLastModifyTimeGreaterThan(Date value) {
            this.addCriterion("last_modify_time >", value, "lastModifyTime");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("last_modify_time >=", value, "lastModifyTime");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andLastModifyTimeLessThan(Date value) {
            this.addCriterion("last_modify_time <", value, "lastModifyTime");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("last_modify_time <=", value, "lastModifyTime");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andLastModifyTimeLike(String value) {
            this.addCriterion("last_modify_time like", value, "lastModifyTime");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andLastModifyTimeNotLike(String value) {
            this.addCriterion("last_modify_time not like", value, "lastModifyTime");
            return (ManagerRolePermissionExample.Criteria)this;
        }        public ManagerRolePermissionExample.Criteria andLastModifyTimeIn(List<Date> values) {
            this.addCriterion("last_modify_time in", values, "lastModifyTime");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andLastModifyTimeNotIn(List<Date> values) {
            this.addCriterion("last_modify_time not in", values, "lastModifyTime");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            this.addCriterion("last_modify_time between", value1, value2, "lastModifyTime");
            return (ManagerRolePermissionExample.Criteria)this;
        }

        public ManagerRolePermissionExample.Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("last_modify_time not between", value1, value2, "lastModifyTime");
            return (ManagerRolePermissionExample.Criteria)this;
        }
    }
}
