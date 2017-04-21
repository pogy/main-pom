package com.opentae.data.mana.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagerPermissionExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<ManagerPermissionExample.Criteria> oredCriteria = new ArrayList();

    public ManagerPermissionExample() {
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

    public List<ManagerPermissionExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ManagerPermissionExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ManagerPermissionExample.Criteria or() {
        ManagerPermissionExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ManagerPermissionExample.Criteria createCriteria() {
        ManagerPermissionExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ManagerPermissionExample.Criteria createCriteriaInternal() {
        ManagerPermissionExample.Criteria criteria = new ManagerPermissionExample.Criteria();
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

    public static class Criteria extends ManagerPermissionExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ManagerPermissionExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ManagerPermissionExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ManagerPermissionExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ManagerPermissionExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ManagerPermissionExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ManagerPermissionExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ManagerPermissionExample.Criteria andPermissionIdIsNull() {
            this.addCriterion("permission_id is null");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionIdIsNotNull() {
            this.addCriterion("permission_id is not null");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionIdEqualTo(Long value) {
            this.addCriterion("permission_id =", value, "permissionId");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionIdNotEqualTo(Long value) {
            this.addCriterion("permission_id <>", value, "permissionId");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionIdGreaterThan(Long value) {
            this.addCriterion("permission_id >", value, "permissionId");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("permission_id >=", value, "permissionId");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionIdLessThan(Long value) {
            this.addCriterion("permission_id <", value, "permissionId");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionIdLessThanOrEqualTo(Long value) {
            this.addCriterion("permission_id <=", value, "permissionId");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionIdLike(String value) {
            this.addCriterion("permission_id like", value, "permissionId");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionIdNotLike(String value) {
            this.addCriterion("permission_id not like", value, "permissionId");
            return (ManagerPermissionExample.Criteria)this;
        }        public ManagerPermissionExample.Criteria andPermissionIdIn(List<Long> values) {
            this.addCriterion("permission_id in", values, "permissionId");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionIdNotIn(List<Long> values) {
            this.addCriterion("permission_id not in", values, "permissionId");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionIdBetween(Long value1, Long value2) {
            this.addCriterion("permission_id between", value1, value2, "permissionId");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionIdNotBetween(Long value1, Long value2) {
            this.addCriterion("permission_id not between", value1, value2, "permissionId");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andNamespaceIsNull() {
            this.addCriterion("namespace is null");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andNamespaceIsNotNull() {
            this.addCriterion("namespace is not null");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andNamespaceEqualTo(String value) {
            this.addCriterion("namespace =", value, "namespace");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andNamespaceNotEqualTo(String value) {
            this.addCriterion("namespace <>", value, "namespace");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andNamespaceGreaterThan(String value) {
            this.addCriterion("namespace >", value, "namespace");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andNamespaceGreaterThanOrEqualTo(String value) {
            this.addCriterion("namespace >=", value, "namespace");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andNamespaceLessThan(String value) {
            this.addCriterion("namespace <", value, "namespace");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andNamespaceLessThanOrEqualTo(String value) {
            this.addCriterion("namespace <=", value, "namespace");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andNamespaceLike(String value) {
            this.addCriterion("namespace like", value, "namespace");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andNamespaceNotLike(String value) {
            this.addCriterion("namespace not like", value, "namespace");
            return (ManagerPermissionExample.Criteria)this;
        }        public ManagerPermissionExample.Criteria andNamespaceIn(List<String> values) {
            this.addCriterion("namespace in", values, "namespace");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andNamespaceNotIn(List<String> values) {
            this.addCriterion("namespace not in", values, "namespace");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andNamespaceBetween(String value1, String value2) {
            this.addCriterion("namespace between", value1, value2, "namespace");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andNamespaceNotBetween(String value1, String value2) {
            this.addCriterion("namespace not between", value1, value2, "namespace");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionTagIsNull() {
            this.addCriterion("permission_tag is null");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionTagIsNotNull() {
            this.addCriterion("permission_tag is not null");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionTagEqualTo(String value) {
            this.addCriterion("permission_tag =", value, "permissionTag");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionTagNotEqualTo(String value) {
            this.addCriterion("permission_tag <>", value, "permissionTag");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionTagGreaterThan(String value) {
            this.addCriterion("permission_tag >", value, "permissionTag");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionTagGreaterThanOrEqualTo(String value) {
            this.addCriterion("permission_tag >=", value, "permissionTag");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionTagLessThan(String value) {
            this.addCriterion("permission_tag <", value, "permissionTag");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionTagLessThanOrEqualTo(String value) {
            this.addCriterion("permission_tag <=", value, "permissionTag");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionTagLike(String value) {
            this.addCriterion("permission_tag like", value, "permissionTag");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionTagNotLike(String value) {
            this.addCriterion("permission_tag not like", value, "permissionTag");
            return (ManagerPermissionExample.Criteria)this;
        }        public ManagerPermissionExample.Criteria andPermissionTagIn(List<String> values) {
            this.addCriterion("permission_tag in", values, "permissionTag");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionTagNotIn(List<String> values) {
            this.addCriterion("permission_tag not in", values, "permissionTag");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionTagBetween(String value1, String value2) {
            this.addCriterion("permission_tag between", value1, value2, "permissionTag");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionTagNotBetween(String value1, String value2) {
            this.addCriterion("permission_tag not between", value1, value2, "permissionTag");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (ManagerPermissionExample.Criteria)this;
        }        public ManagerPermissionExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateUserIdIsNull() {
            this.addCriterion("create_user_id is null");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateUserIdIsNotNull() {
            this.addCriterion("create_user_id is not null");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateUserIdEqualTo(Long value) {
            this.addCriterion("create_user_id =", value, "createUserId");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateUserIdNotEqualTo(Long value) {
            this.addCriterion("create_user_id <>", value, "createUserId");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateUserIdGreaterThan(Long value) {
            this.addCriterion("create_user_id >", value, "createUserId");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("create_user_id >=", value, "createUserId");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateUserIdLessThan(Long value) {
            this.addCriterion("create_user_id <", value, "createUserId");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("create_user_id <=", value, "createUserId");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateUserIdLike(String value) {
            this.addCriterion("create_user_id like", value, "createUserId");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateUserIdNotLike(String value) {
            this.addCriterion("create_user_id not like", value, "createUserId");
            return (ManagerPermissionExample.Criteria)this;
        }        public ManagerPermissionExample.Criteria andCreateUserIdIn(List<Long> values) {
            this.addCriterion("create_user_id in", values, "createUserId");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateUserIdNotIn(List<Long> values) {
            this.addCriterion("create_user_id not in", values, "createUserId");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateUserIdBetween(Long value1, Long value2) {
            this.addCriterion("create_user_id between", value1, value2, "createUserId");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andCreateUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andStatusIsNull() {
            this.addCriterion("status is null");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andStatusIsNotNull() {
            this.addCriterion("status is not null");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andStatusEqualTo(Integer value) {
            this.addCriterion("status =", value, "status");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andStatusNotEqualTo(Integer value) {
            this.addCriterion("status <>", value, "status");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andStatusGreaterThan(Integer value) {
            this.addCriterion("status >", value, "status");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("status >=", value, "status");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andStatusLessThan(Integer value) {
            this.addCriterion("status <", value, "status");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("status <=", value, "status");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andStatusLike(String value) {
            this.addCriterion("status like", value, "status");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andStatusNotLike(String value) {
            this.addCriterion("status not like", value, "status");
            return (ManagerPermissionExample.Criteria)this;
        }        public ManagerPermissionExample.Criteria andStatusIn(List<Integer> values) {
            this.addCriterion("status in", values, "status");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andStatusNotIn(List<Integer> values) {
            this.addCriterion("status not in", values, "status");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("status between", value1, value2, "status");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("status not between", value1, value2, "status");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionCommentIsNull() {
            this.addCriterion("permission_comment is null");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionCommentIsNotNull() {
            this.addCriterion("permission_comment is not null");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionCommentEqualTo(String value) {
            this.addCriterion("permission_comment =", value, "permissionComment");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionCommentNotEqualTo(String value) {
            this.addCriterion("permission_comment <>", value, "permissionComment");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionCommentGreaterThan(String value) {
            this.addCriterion("permission_comment >", value, "permissionComment");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionCommentGreaterThanOrEqualTo(String value) {
            this.addCriterion("permission_comment >=", value, "permissionComment");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionCommentLessThan(String value) {
            this.addCriterion("permission_comment <", value, "permissionComment");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionCommentLessThanOrEqualTo(String value) {
            this.addCriterion("permission_comment <=", value, "permissionComment");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionCommentLike(String value) {
            this.addCriterion("permission_comment like", value, "permissionComment");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionCommentNotLike(String value) {
            this.addCriterion("permission_comment not like", value, "permissionComment");
            return (ManagerPermissionExample.Criteria)this;
        }        public ManagerPermissionExample.Criteria andPermissionCommentIn(List<String> values) {
            this.addCriterion("permission_comment in", values, "permissionComment");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionCommentNotIn(List<String> values) {
            this.addCriterion("permission_comment not in", values, "permissionComment");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionCommentBetween(String value1, String value2) {
            this.addCriterion("permission_comment between", value1, value2, "permissionComment");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andPermissionCommentNotBetween(String value1, String value2) {
            this.addCriterion("permission_comment not between", value1, value2, "permissionComment");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andParentPidIsNull() {
            this.addCriterion("parent_pid is null");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andParentPidIsNotNull() {
            this.addCriterion("parent_pid is not null");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andParentPidEqualTo(Long value) {
            this.addCriterion("parent_pid =", value, "parentPid");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andParentPidNotEqualTo(Long value) {
            this.addCriterion("parent_pid <>", value, "parentPid");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andParentPidGreaterThan(Long value) {
            this.addCriterion("parent_pid >", value, "parentPid");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andParentPidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("parent_pid >=", value, "parentPid");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andParentPidLessThan(Long value) {
            this.addCriterion("parent_pid <", value, "parentPid");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andParentPidLessThanOrEqualTo(Long value) {
            this.addCriterion("parent_pid <=", value, "parentPid");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andParentPidLike(String value) {
            this.addCriterion("parent_pid like", value, "parentPid");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andParentPidNotLike(String value) {
            this.addCriterion("parent_pid not like", value, "parentPid");
            return (ManagerPermissionExample.Criteria)this;
        }        public ManagerPermissionExample.Criteria andParentPidIn(List<Long> values) {
            this.addCriterion("parent_pid in", values, "parentPid");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andParentPidNotIn(List<Long> values) {
            this.addCriterion("parent_pid not in", values, "parentPid");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andParentPidBetween(Long value1, Long value2) {
            this.addCriterion("parent_pid between", value1, value2, "parentPid");
            return (ManagerPermissionExample.Criteria)this;
        }

        public ManagerPermissionExample.Criteria andParentPidNotBetween(Long value1, Long value2) {
            this.addCriterion("parent_pid not between", value1, value2, "parentPid");
            return (ManagerPermissionExample.Criteria)this;
        }
    }
}
