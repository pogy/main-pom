package com.opentae.data.mana.examples;

import java.util.ArrayList;
import java.util.List;

public class ManagerWhiteipExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<ManagerWhiteipExample.Criteria> oredCriteria = new ArrayList();

    public ManagerWhiteipExample() {
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

    public List<ManagerWhiteipExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ManagerWhiteipExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ManagerWhiteipExample.Criteria or() {
        ManagerWhiteipExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ManagerWhiteipExample.Criteria createCriteria() {
        ManagerWhiteipExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ManagerWhiteipExample.Criteria createCriteriaInternal() {
        ManagerWhiteipExample.Criteria criteria = new ManagerWhiteipExample.Criteria();
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

    public static class Criteria extends ManagerWhiteipExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ManagerWhiteipExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ManagerWhiteipExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ManagerWhiteipExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ManagerWhiteipExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ManagerWhiteipExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ManagerWhiteipExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ManagerWhiteipExample.Criteria andWipIdIsNull() {
            this.addCriterion("wip_id is null");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWipIdIsNotNull() {
            this.addCriterion("wip_id is not null");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWipIdEqualTo(Long value) {
            this.addCriterion("wip_id =", value, "wipId");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWipIdNotEqualTo(Long value) {
            this.addCriterion("wip_id <>", value, "wipId");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWipIdGreaterThan(Long value) {
            this.addCriterion("wip_id >", value, "wipId");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWipIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("wip_id >=", value, "wipId");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWipIdLessThan(Long value) {
            this.addCriterion("wip_id <", value, "wipId");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWipIdLessThanOrEqualTo(Long value) {
            this.addCriterion("wip_id <=", value, "wipId");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWipIdLike(String value) {
            this.addCriterion("wip_id like", value, "wipId");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWipIdNotLike(String value) {
            this.addCriterion("wip_id not like", value, "wipId");
            return (ManagerWhiteipExample.Criteria)this;
        }        public ManagerWhiteipExample.Criteria andWipIdIn(List<Long> values) {
            this.addCriterion("wip_id in", values, "wipId");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWipIdNotIn(List<Long> values) {
            this.addCriterion("wip_id not in", values, "wipId");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWipIdBetween(Long value1, Long value2) {
            this.addCriterion("wip_id between", value1, value2, "wipId");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWipIdNotBetween(Long value1, Long value2) {
            this.addCriterion("wip_id not between", value1, value2, "wipId");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andJkIdIsNull() {
            this.addCriterion("jk_id is null");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andJkIdIsNotNull() {
            this.addCriterion("jk_id is not null");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andJkIdEqualTo(Long value) {
            this.addCriterion("jk_id =", value, "jkId");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andJkIdNotEqualTo(Long value) {
            this.addCriterion("jk_id <>", value, "jkId");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andJkIdGreaterThan(Long value) {
            this.addCriterion("jk_id >", value, "jkId");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andJkIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("jk_id >=", value, "jkId");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andJkIdLessThan(Long value) {
            this.addCriterion("jk_id <", value, "jkId");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andJkIdLessThanOrEqualTo(Long value) {
            this.addCriterion("jk_id <=", value, "jkId");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andJkIdLike(String value) {
            this.addCriterion("jk_id like", value, "jkId");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andJkIdNotLike(String value) {
            this.addCriterion("jk_id not like", value, "jkId");
            return (ManagerWhiteipExample.Criteria)this;
        }        public ManagerWhiteipExample.Criteria andJkIdIn(List<Long> values) {
            this.addCriterion("jk_id in", values, "jkId");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andJkIdNotIn(List<Long> values) {
            this.addCriterion("jk_id not in", values, "jkId");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andJkIdBetween(Long value1, Long value2) {
            this.addCriterion("jk_id between", value1, value2, "jkId");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andJkIdNotBetween(Long value1, Long value2) {
            this.addCriterion("jk_id not between", value1, value2, "jkId");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWhiteIpIsNull() {
            this.addCriterion("white_ip is null");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWhiteIpIsNotNull() {
            this.addCriterion("white_ip is not null");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWhiteIpEqualTo(String value) {
            this.addCriterion("white_ip =", value, "whiteIp");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWhiteIpNotEqualTo(String value) {
            this.addCriterion("white_ip <>", value, "whiteIp");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWhiteIpGreaterThan(String value) {
            this.addCriterion("white_ip >", value, "whiteIp");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWhiteIpGreaterThanOrEqualTo(String value) {
            this.addCriterion("white_ip >=", value, "whiteIp");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWhiteIpLessThan(String value) {
            this.addCriterion("white_ip <", value, "whiteIp");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWhiteIpLessThanOrEqualTo(String value) {
            this.addCriterion("white_ip <=", value, "whiteIp");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWhiteIpLike(String value) {
            this.addCriterion("white_ip like", value, "whiteIp");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWhiteIpNotLike(String value) {
            this.addCriterion("white_ip not like", value, "whiteIp");
            return (ManagerWhiteipExample.Criteria)this;
        }        public ManagerWhiteipExample.Criteria andWhiteIpIn(List<String> values) {
            this.addCriterion("white_ip in", values, "whiteIp");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWhiteIpNotIn(List<String> values) {
            this.addCriterion("white_ip not in", values, "whiteIp");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWhiteIpBetween(String value1, String value2) {
            this.addCriterion("white_ip between", value1, value2, "whiteIp");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andWhiteIpNotBetween(String value1, String value2) {
            this.addCriterion("white_ip not between", value1, value2, "whiteIp");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andOnlineIsNull() {
            this.addCriterion("online is null");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andOnlineIsNotNull() {
            this.addCriterion("online is not null");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andOnlineEqualTo(Integer value) {
            this.addCriterion("online =", value, "online");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andOnlineNotEqualTo(Integer value) {
            this.addCriterion("online <>", value, "online");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andOnlineGreaterThan(Integer value) {
            this.addCriterion("online >", value, "online");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andOnlineGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("online >=", value, "online");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andOnlineLessThan(Integer value) {
            this.addCriterion("online <", value, "online");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andOnlineLessThanOrEqualTo(Integer value) {
            this.addCriterion("online <=", value, "online");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andOnlineLike(String value) {
            this.addCriterion("online like", value, "online");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andOnlineNotLike(String value) {
            this.addCriterion("online not like", value, "online");
            return (ManagerWhiteipExample.Criteria)this;
        }        public ManagerWhiteipExample.Criteria andOnlineIn(List<Integer> values) {
            this.addCriterion("online in", values, "online");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andOnlineNotIn(List<Integer> values) {
            this.addCriterion("online not in", values, "online");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andOnlineBetween(Integer value1, Integer value2) {
            this.addCriterion("online between", value1, value2, "online");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andOnlineNotBetween(Integer value1, Integer value2) {
            this.addCriterion("online not between", value1, value2, "online");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andTaeServerIsNull() {
            this.addCriterion("tae_server is null");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andTaeServerIsNotNull() {
            this.addCriterion("tae_server is not null");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andTaeServerEqualTo(Integer value) {
            this.addCriterion("tae_server =", value, "taeServer");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andTaeServerNotEqualTo(Integer value) {
            this.addCriterion("tae_server <>", value, "taeServer");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andTaeServerGreaterThan(Integer value) {
            this.addCriterion("tae_server >", value, "taeServer");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andTaeServerGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("tae_server >=", value, "taeServer");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andTaeServerLessThan(Integer value) {
            this.addCriterion("tae_server <", value, "taeServer");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andTaeServerLessThanOrEqualTo(Integer value) {
            this.addCriterion("tae_server <=", value, "taeServer");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andTaeServerLike(String value) {
            this.addCriterion("tae_server like", value, "taeServer");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andTaeServerNotLike(String value) {
            this.addCriterion("tae_server not like", value, "taeServer");
            return (ManagerWhiteipExample.Criteria)this;
        }        public ManagerWhiteipExample.Criteria andTaeServerIn(List<Integer> values) {
            this.addCriterion("tae_server in", values, "taeServer");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andTaeServerNotIn(List<Integer> values) {
            this.addCriterion("tae_server not in", values, "taeServer");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andTaeServerBetween(Integer value1, Integer value2) {
            this.addCriterion("tae_server between", value1, value2, "taeServer");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andTaeServerNotBetween(Integer value1, Integer value2) {
            this.addCriterion("tae_server not between", value1, value2, "taeServer");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andRemarkIsNull() {
            this.addCriterion("remark is null");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andRemarkIsNotNull() {
            this.addCriterion("remark is not null");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andRemarkEqualTo(String value) {
            this.addCriterion("remark =", value, "remark");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andRemarkNotEqualTo(String value) {
            this.addCriterion("remark <>", value, "remark");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andRemarkGreaterThan(String value) {
            this.addCriterion("remark >", value, "remark");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
            this.addCriterion("remark >=", value, "remark");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andRemarkLessThan(String value) {
            this.addCriterion("remark <", value, "remark");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andRemarkLessThanOrEqualTo(String value) {
            this.addCriterion("remark <=", value, "remark");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andRemarkLike(String value) {
            this.addCriterion("remark like", value, "remark");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andRemarkNotLike(String value) {
            this.addCriterion("remark not like", value, "remark");
            return (ManagerWhiteipExample.Criteria)this;
        }        public ManagerWhiteipExample.Criteria andRemarkIn(List<String> values) {
            this.addCriterion("remark in", values, "remark");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andRemarkNotIn(List<String> values) {
            this.addCriterion("remark not in", values, "remark");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andRemarkBetween(String value1, String value2) {
            this.addCriterion("remark between", value1, value2, "remark");
            return (ManagerWhiteipExample.Criteria)this;
        }

        public ManagerWhiteipExample.Criteria andRemarkNotBetween(String value1, String value2) {
            this.addCriterion("remark not between", value1, value2, "remark");
            return (ManagerWhiteipExample.Criteria)this;
        }
    }
}
