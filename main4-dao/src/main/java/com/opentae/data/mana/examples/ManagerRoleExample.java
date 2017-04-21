package com.opentae.data.mana.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagerRoleExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<ManagerRoleExample.Criteria> oredCriteria = new ArrayList();

    public ManagerRoleExample() {
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

    public List<ManagerRoleExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ManagerRoleExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ManagerRoleExample.Criteria or() {
        ManagerRoleExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ManagerRoleExample.Criteria createCriteria() {
        ManagerRoleExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ManagerRoleExample.Criteria createCriteriaInternal() {
        ManagerRoleExample.Criteria criteria = new ManagerRoleExample.Criteria();
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

    public static class Criteria extends ManagerRoleExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ManagerRoleExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ManagerRoleExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ManagerRoleExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ManagerRoleExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ManagerRoleExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ManagerRoleExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ManagerRoleExample.Criteria andRoleIdIsNull() {
            this.addCriterion("role_id is null");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleIdIsNotNull() {
            this.addCriterion("role_id is not null");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleIdEqualTo(Long value) {
            this.addCriterion("role_id =", value, "roleId");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleIdNotEqualTo(Long value) {
            this.addCriterion("role_id <>", value, "roleId");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleIdGreaterThan(Long value) {
            this.addCriterion("role_id >", value, "roleId");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("role_id >=", value, "roleId");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleIdLessThan(Long value) {
            this.addCriterion("role_id <", value, "roleId");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleIdLessThanOrEqualTo(Long value) {
            this.addCriterion("role_id <=", value, "roleId");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleIdLike(String value) {
            this.addCriterion("role_id like", value, "roleId");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleIdNotLike(String value) {
            this.addCriterion("role_id not like", value, "roleId");
            return (ManagerRoleExample.Criteria)this;
        }        public ManagerRoleExample.Criteria andRoleIdIn(List<Long> values) {
            this.addCriterion("role_id in", values, "roleId");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleIdNotIn(List<Long> values) {
            this.addCriterion("role_id not in", values, "roleId");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleIdBetween(Long value1, Long value2) {
            this.addCriterion("role_id between", value1, value2, "roleId");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleIdNotBetween(Long value1, Long value2) {
            this.addCriterion("role_id not between", value1, value2, "roleId");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleNameIsNull() {
            this.addCriterion("role_name is null");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleNameIsNotNull() {
            this.addCriterion("role_name is not null");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleNameEqualTo(String value) {
            this.addCriterion("role_name =", value, "roleName");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleNameNotEqualTo(String value) {
            this.addCriterion("role_name <>", value, "roleName");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleNameGreaterThan(String value) {
            this.addCriterion("role_name >", value, "roleName");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("role_name >=", value, "roleName");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleNameLessThan(String value) {
            this.addCriterion("role_name <", value, "roleName");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleNameLessThanOrEqualTo(String value) {
            this.addCriterion("role_name <=", value, "roleName");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleNameLike(String value) {
            this.addCriterion("role_name like", value, "roleName");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleNameNotLike(String value) {
            this.addCriterion("role_name not like", value, "roleName");
            return (ManagerRoleExample.Criteria)this;
        }        public ManagerRoleExample.Criteria andRoleNameIn(List<String> values) {
            this.addCriterion("role_name in", values, "roleName");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleNameNotIn(List<String> values) {
            this.addCriterion("role_name not in", values, "roleName");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleNameBetween(String value1, String value2) {
            this.addCriterion("role_name between", value1, value2, "roleName");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleNameNotBetween(String value1, String value2) {
            this.addCriterion("role_name not between", value1, value2, "roleName");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleTagIsNull() {
            this.addCriterion("role_tag is null");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleTagIsNotNull() {
            this.addCriterion("role_tag is not null");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleTagEqualTo(String value) {
            this.addCriterion("role_tag =", value, "roleTag");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleTagNotEqualTo(String value) {
            this.addCriterion("role_tag <>", value, "roleTag");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleTagGreaterThan(String value) {
            this.addCriterion("role_tag >", value, "roleTag");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleTagGreaterThanOrEqualTo(String value) {
            this.addCriterion("role_tag >=", value, "roleTag");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleTagLessThan(String value) {
            this.addCriterion("role_tag <", value, "roleTag");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleTagLessThanOrEqualTo(String value) {
            this.addCriterion("role_tag <=", value, "roleTag");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleTagLike(String value) {
            this.addCriterion("role_tag like", value, "roleTag");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleTagNotLike(String value) {
            this.addCriterion("role_tag not like", value, "roleTag");
            return (ManagerRoleExample.Criteria)this;
        }        public ManagerRoleExample.Criteria andRoleTagIn(List<String> values) {
            this.addCriterion("role_tag in", values, "roleTag");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleTagNotIn(List<String> values) {
            this.addCriterion("role_tag not in", values, "roleTag");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleTagBetween(String value1, String value2) {
            this.addCriterion("role_tag between", value1, value2, "roleTag");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleTagNotBetween(String value1, String value2) {
            this.addCriterion("role_tag not between", value1, value2, "roleTag");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (ManagerRoleExample.Criteria)this;
        }        public ManagerRoleExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleCommentIsNull() {
            this.addCriterion("role_comment is null");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleCommentIsNotNull() {
            this.addCriterion("role_comment is not null");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleCommentEqualTo(String value) {
            this.addCriterion("role_comment =", value, "roleComment");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleCommentNotEqualTo(String value) {
            this.addCriterion("role_comment <>", value, "roleComment");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleCommentGreaterThan(String value) {
            this.addCriterion("role_comment >", value, "roleComment");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleCommentGreaterThanOrEqualTo(String value) {
            this.addCriterion("role_comment >=", value, "roleComment");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleCommentLessThan(String value) {
            this.addCriterion("role_comment <", value, "roleComment");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleCommentLessThanOrEqualTo(String value) {
            this.addCriterion("role_comment <=", value, "roleComment");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleCommentLike(String value) {
            this.addCriterion("role_comment like", value, "roleComment");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleCommentNotLike(String value) {
            this.addCriterion("role_comment not like", value, "roleComment");
            return (ManagerRoleExample.Criteria)this;
        }        public ManagerRoleExample.Criteria andRoleCommentIn(List<String> values) {
            this.addCriterion("role_comment in", values, "roleComment");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleCommentNotIn(List<String> values) {
            this.addCriterion("role_comment not in", values, "roleComment");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleCommentBetween(String value1, String value2) {
            this.addCriterion("role_comment between", value1, value2, "roleComment");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andRoleCommentNotBetween(String value1, String value2) {
            this.addCriterion("role_comment not between", value1, value2, "roleComment");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateUserIdIsNull() {
            this.addCriterion("create_user_id is null");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateUserIdIsNotNull() {
            this.addCriterion("create_user_id is not null");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateUserIdEqualTo(Long value) {
            this.addCriterion("create_user_id =", value, "createUserId");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateUserIdNotEqualTo(Long value) {
            this.addCriterion("create_user_id <>", value, "createUserId");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateUserIdGreaterThan(Long value) {
            this.addCriterion("create_user_id >", value, "createUserId");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("create_user_id >=", value, "createUserId");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateUserIdLessThan(Long value) {
            this.addCriterion("create_user_id <", value, "createUserId");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("create_user_id <=", value, "createUserId");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateUserIdLike(String value) {
            this.addCriterion("create_user_id like", value, "createUserId");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateUserIdNotLike(String value) {
            this.addCriterion("create_user_id not like", value, "createUserId");
            return (ManagerRoleExample.Criteria)this;
        }        public ManagerRoleExample.Criteria andCreateUserIdIn(List<Long> values) {
            this.addCriterion("create_user_id in", values, "createUserId");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateUserIdNotIn(List<Long> values) {
            this.addCriterion("create_user_id not in", values, "createUserId");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateUserIdBetween(Long value1, Long value2) {
            this.addCriterion("create_user_id between", value1, value2, "createUserId");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andCreateUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andStatusIsNull() {
            this.addCriterion("status is null");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andStatusIsNotNull() {
            this.addCriterion("status is not null");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andStatusEqualTo(Integer value) {
            this.addCriterion("status =", value, "status");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andStatusNotEqualTo(Integer value) {
            this.addCriterion("status <>", value, "status");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andStatusGreaterThan(Integer value) {
            this.addCriterion("status >", value, "status");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("status >=", value, "status");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andStatusLessThan(Integer value) {
            this.addCriterion("status <", value, "status");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("status <=", value, "status");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andStatusLike(String value) {
            this.addCriterion("status like", value, "status");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andStatusNotLike(String value) {
            this.addCriterion("status not like", value, "status");
            return (ManagerRoleExample.Criteria)this;
        }        public ManagerRoleExample.Criteria andStatusIn(List<Integer> values) {
            this.addCriterion("status in", values, "status");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andStatusNotIn(List<Integer> values) {
            this.addCriterion("status not in", values, "status");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("status between", value1, value2, "status");
            return (ManagerRoleExample.Criteria)this;
        }

        public ManagerRoleExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("status not between", value1, value2, "status");
            return (ManagerRoleExample.Criteria)this;
        }
    }
}
