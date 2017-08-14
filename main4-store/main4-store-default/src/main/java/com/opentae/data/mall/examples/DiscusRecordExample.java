package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiscusRecordExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<DiscusRecordExample.Criteria> oredCriteria = new ArrayList();

    public DiscusRecordExample() {
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

    public List<DiscusRecordExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(DiscusRecordExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public DiscusRecordExample.Criteria or() {
        DiscusRecordExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public DiscusRecordExample.Criteria createCriteria() {
        DiscusRecordExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected DiscusRecordExample.Criteria createCriteriaInternal() {
        DiscusRecordExample.Criteria criteria = new DiscusRecordExample.Criteria();
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

    public static class Criteria extends DiscusRecordExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<DiscusRecordExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<DiscusRecordExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<DiscusRecordExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new DiscusRecordExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new DiscusRecordExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new DiscusRecordExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public DiscusRecordExample.Criteria andRecordIdIsNull() {
            this.addCriterion("record_id is null");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andRecordIdIsNotNull() {
            this.addCriterion("record_id is not null");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andRecordIdEqualTo(Long value) {
            this.addCriterion("record_id =", value, "recordId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andRecordIdNotEqualTo(Long value) {
            this.addCriterion("record_id <>", value, "recordId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andRecordIdGreaterThan(Long value) {
            this.addCriterion("record_id >", value, "recordId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andRecordIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("record_id >=", value, "recordId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andRecordIdLessThan(Long value) {
            this.addCriterion("record_id <", value, "recordId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andRecordIdLessThanOrEqualTo(Long value) {
            this.addCriterion("record_id <=", value, "recordId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andRecordIdLike(String value) {
            this.addCriterion("record_id like", value, "recordId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andRecordIdNotLike(String value) {
            this.addCriterion("record_id not like", value, "recordId");
            return (DiscusRecordExample.Criteria)this;
        }        public DiscusRecordExample.Criteria andRecordIdIn(List<Long> values) {
            this.addCriterion("record_id in", values, "recordId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andRecordIdNotIn(List<Long> values) {
            this.addCriterion("record_id not in", values, "recordId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andRecordIdBetween(Long value1, Long value2) {
            this.addCriterion("record_id between", value1, value2, "recordId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andRecordIdNotBetween(Long value1, Long value2) {
            this.addCriterion("record_id not between", value1, value2, "recordId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andCreatedTimeIsNull() {
            this.addCriterion("created_time is null");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andCreatedTimeIsNotNull() {
            this.addCriterion("created_time is not null");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andCreatedTimeEqualTo(Date value) {
            this.addCriterion("created_time =", value, "createdTime");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andCreatedTimeNotEqualTo(Date value) {
            this.addCriterion("created_time <>", value, "createdTime");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andCreatedTimeGreaterThan(Date value) {
            this.addCriterion("created_time >", value, "createdTime");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("created_time >=", value, "createdTime");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andCreatedTimeLessThan(Date value) {
            this.addCriterion("created_time <", value, "createdTime");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("created_time <=", value, "createdTime");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andCreatedTimeLike(String value) {
            this.addCriterion("created_time like", value, "createdTime");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andCreatedTimeNotLike(String value) {
            this.addCriterion("created_time not like", value, "createdTime");
            return (DiscusRecordExample.Criteria)this;
        }        public DiscusRecordExample.Criteria andCreatedTimeIn(List<Date> values) {
            this.addCriterion("created_time in", values, "createdTime");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andCreatedTimeNotIn(List<Date> values) {
            this.addCriterion("created_time not in", values, "createdTime");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andCreatedTimeBetween(Date value1, Date value2) {
            this.addCriterion("created_time between", value1, value2, "createdTime");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("created_time not between", value1, value2, "createdTime");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andMsgContextIsNull() {
            this.addCriterion("msg_context is null");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andMsgContextIsNotNull() {
            this.addCriterion("msg_context is not null");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andMsgContextEqualTo(String value) {
            this.addCriterion("msg_context =", value, "msgContext");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andMsgContextNotEqualTo(String value) {
            this.addCriterion("msg_context <>", value, "msgContext");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andMsgContextGreaterThan(String value) {
            this.addCriterion("msg_context >", value, "msgContext");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andMsgContextGreaterThanOrEqualTo(String value) {
            this.addCriterion("msg_context >=", value, "msgContext");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andMsgContextLessThan(String value) {
            this.addCriterion("msg_context <", value, "msgContext");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andMsgContextLessThanOrEqualTo(String value) {
            this.addCriterion("msg_context <=", value, "msgContext");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andMsgContextLike(String value) {
            this.addCriterion("msg_context like", value, "msgContext");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andMsgContextNotLike(String value) {
            this.addCriterion("msg_context not like", value, "msgContext");
            return (DiscusRecordExample.Criteria)this;
        }        public DiscusRecordExample.Criteria andMsgContextIn(List<String> values) {
            this.addCriterion("msg_context in", values, "msgContext");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andMsgContextNotIn(List<String> values) {
            this.addCriterion("msg_context not in", values, "msgContext");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andMsgContextBetween(String value1, String value2) {
            this.addCriterion("msg_context between", value1, value2, "msgContext");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andMsgContextNotBetween(String value1, String value2) {
            this.addCriterion("msg_context not between", value1, value2, "msgContext");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andStoreIdIsNull() {
            this.addCriterion("store_id is null");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andStoreIdIsNotNull() {
            this.addCriterion("store_id is not null");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andStoreIdEqualTo(Long value) {
            this.addCriterion("store_id =", value, "storeId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andStoreIdNotEqualTo(Long value) {
            this.addCriterion("store_id <>", value, "storeId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andStoreIdGreaterThan(Long value) {
            this.addCriterion("store_id >", value, "storeId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("store_id >=", value, "storeId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andStoreIdLessThan(Long value) {
            this.addCriterion("store_id <", value, "storeId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            this.addCriterion("store_id <=", value, "storeId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andStoreIdLike(String value) {
            this.addCriterion("store_id like", value, "storeId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andStoreIdNotLike(String value) {
            this.addCriterion("store_id not like", value, "storeId");
            return (DiscusRecordExample.Criteria)this;
        }        public DiscusRecordExample.Criteria andStoreIdIn(List<Long> values) {
            this.addCriterion("store_id in", values, "storeId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andStoreIdNotIn(List<Long> values) {
            this.addCriterion("store_id not in", values, "storeId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            this.addCriterion("store_id between", value1, value2, "storeId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            this.addCriterion("store_id not between", value1, value2, "storeId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (DiscusRecordExample.Criteria)this;
        }        public DiscusRecordExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andDoLocationIsNull() {
            this.addCriterion("do_location is null");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andDoLocationIsNotNull() {
            this.addCriterion("do_location is not null");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andDoLocationEqualTo(String value) {
            this.addCriterion("do_location =", value, "doLocation");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andDoLocationNotEqualTo(String value) {
            this.addCriterion("do_location <>", value, "doLocation");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andDoLocationGreaterThan(String value) {
            this.addCriterion("do_location >", value, "doLocation");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andDoLocationGreaterThanOrEqualTo(String value) {
            this.addCriterion("do_location >=", value, "doLocation");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andDoLocationLessThan(String value) {
            this.addCriterion("do_location <", value, "doLocation");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andDoLocationLessThanOrEqualTo(String value) {
            this.addCriterion("do_location <=", value, "doLocation");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andDoLocationLike(String value) {
            this.addCriterion("do_location like", value, "doLocation");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andDoLocationNotLike(String value) {
            this.addCriterion("do_location not like", value, "doLocation");
            return (DiscusRecordExample.Criteria)this;
        }        public DiscusRecordExample.Criteria andDoLocationIn(List<String> values) {
            this.addCriterion("do_location in", values, "doLocation");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andDoLocationNotIn(List<String> values) {
            this.addCriterion("do_location not in", values, "doLocation");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andDoLocationBetween(String value1, String value2) {
            this.addCriterion("do_location between", value1, value2, "doLocation");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andDoLocationNotBetween(String value1, String value2) {
            this.addCriterion("do_location not between", value1, value2, "doLocation");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andPicsIsNull() {
            this.addCriterion("pics is null");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andPicsIsNotNull() {
            this.addCriterion("pics is not null");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andPicsEqualTo(String value) {
            this.addCriterion("pics =", value, "pics");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andPicsNotEqualTo(String value) {
            this.addCriterion("pics <>", value, "pics");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andPicsGreaterThan(String value) {
            this.addCriterion("pics >", value, "pics");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andPicsGreaterThanOrEqualTo(String value) {
            this.addCriterion("pics >=", value, "pics");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andPicsLessThan(String value) {
            this.addCriterion("pics <", value, "pics");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andPicsLessThanOrEqualTo(String value) {
            this.addCriterion("pics <=", value, "pics");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andPicsLike(String value) {
            this.addCriterion("pics like", value, "pics");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andPicsNotLike(String value) {
            this.addCriterion("pics not like", value, "pics");
            return (DiscusRecordExample.Criteria)this;
        }        public DiscusRecordExample.Criteria andPicsIn(List<String> values) {
            this.addCriterion("pics in", values, "pics");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andPicsNotIn(List<String> values) {
            this.addCriterion("pics not in", values, "pics");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andPicsBetween(String value1, String value2) {
            this.addCriterion("pics between", value1, value2, "pics");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andPicsNotBetween(String value1, String value2) {
            this.addCriterion("pics not between", value1, value2, "pics");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andTitleIsNull() {
            this.addCriterion("title is null");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andTitleIsNotNull() {
            this.addCriterion("title is not null");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andTitleEqualTo(String value) {
            this.addCriterion("title =", value, "title");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andTitleNotEqualTo(String value) {
            this.addCriterion("title <>", value, "title");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andTitleGreaterThan(String value) {
            this.addCriterion("title >", value, "title");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            this.addCriterion("title >=", value, "title");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andTitleLessThan(String value) {
            this.addCriterion("title <", value, "title");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andTitleLessThanOrEqualTo(String value) {
            this.addCriterion("title <=", value, "title");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andTitleLike(String value) {
            this.addCriterion("title like", value, "title");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andTitleNotLike(String value) {
            this.addCriterion("title not like", value, "title");
            return (DiscusRecordExample.Criteria)this;
        }        public DiscusRecordExample.Criteria andTitleIn(List<String> values) {
            this.addCriterion("title in", values, "title");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andTitleNotIn(List<String> values) {
            this.addCriterion("title not in", values, "title");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andTitleBetween(String value1, String value2) {
            this.addCriterion("title between", value1, value2, "title");
            return (DiscusRecordExample.Criteria)this;
        }

        public DiscusRecordExample.Criteria andTitleNotBetween(String value1, String value2) {
            this.addCriterion("title not between", value1, value2, "title");
            return (DiscusRecordExample.Criteria)this;
        }
    }
}
