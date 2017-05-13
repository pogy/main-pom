package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ActiveDrawGoodsExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ActiveDrawGoodsExample.Criteria> oredCriteria = new ArrayList();

    public ActiveDrawGoodsExample() {
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

    public List<ActiveDrawGoodsExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ActiveDrawGoodsExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ActiveDrawGoodsExample.Criteria or() {
        ActiveDrawGoodsExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ActiveDrawGoodsExample.Criteria createCriteria() {
        ActiveDrawGoodsExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ActiveDrawGoodsExample.Criteria createCriteriaInternal() {
        ActiveDrawGoodsExample.Criteria criteria = new ActiveDrawGoodsExample.Criteria();
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

    public static class Criteria extends ActiveDrawGoodsExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ActiveDrawGoodsExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ActiveDrawGoodsExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ActiveDrawGoodsExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ActiveDrawGoodsExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ActiveDrawGoodsExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ActiveDrawGoodsExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ActiveDrawGoodsExample.Criteria andIdIsNull() {
            this.addCriterion("id is null");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andIdIsNotNull() {
            this.addCriterion("id is not null");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andIdEqualTo(Long value) {
            this.addCriterion("id =", value, "id");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andIdNotEqualTo(Long value) {
            this.addCriterion("id <>", value, "id");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andIdGreaterThan(Long value) {
            this.addCriterion("id >", value, "id");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("id >=", value, "id");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andIdLessThan(Long value) {
            this.addCriterion("id <", value, "id");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andIdLessThanOrEqualTo(Long value) {
            this.addCriterion("id <=", value, "id");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andIdLike(String value) {
            this.addCriterion("id like", value, "id");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andIdNotLike(String value) {
            this.addCriterion("id not like", value, "id");
            return (ActiveDrawGoodsExample.Criteria)this;
        }        public ActiveDrawGoodsExample.Criteria andIdIn(List<Long> values) {
            this.addCriterion("id in", values, "id");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andIdNotIn(List<Long> values) {
            this.addCriterion("id not in", values, "id");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andIdBetween(Long value1, Long value2) {
            this.addCriterion("id between", value1, value2, "id");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andIdNotBetween(Long value1, Long value2) {
            this.addCriterion("id not between", value1, value2, "id");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andGoodsIdIsNull() {
            this.addCriterion("goods_id is null");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andGoodsIdIsNotNull() {
            this.addCriterion("goods_id is not null");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andGoodsIdEqualTo(Long value) {
            this.addCriterion("goods_id =", value, "goodsId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andGoodsIdNotEqualTo(Long value) {
            this.addCriterion("goods_id <>", value, "goodsId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andGoodsIdGreaterThan(Long value) {
            this.addCriterion("goods_id >", value, "goodsId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("goods_id >=", value, "goodsId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andGoodsIdLessThan(Long value) {
            this.addCriterion("goods_id <", value, "goodsId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            this.addCriterion("goods_id <=", value, "goodsId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andGoodsIdLike(String value) {
            this.addCriterion("goods_id like", value, "goodsId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andGoodsIdNotLike(String value) {
            this.addCriterion("goods_id not like", value, "goodsId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }        public ActiveDrawGoodsExample.Criteria andGoodsIdIn(List<Long> values) {
            this.addCriterion("goods_id in", values, "goodsId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andGoodsIdNotIn(List<Long> values) {
            this.addCriterion("goods_id not in", values, "goodsId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            this.addCriterion("goods_id between", value1, value2, "goodsId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            this.addCriterion("goods_id not between", value1, value2, "goodsId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPemIdIsNull() {
            this.addCriterion("pem_id is null");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPemIdIsNotNull() {
            this.addCriterion("pem_id is not null");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPemIdEqualTo(Long value) {
            this.addCriterion("pem_id =", value, "pemId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPemIdNotEqualTo(Long value) {
            this.addCriterion("pem_id <>", value, "pemId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPemIdGreaterThan(Long value) {
            this.addCriterion("pem_id >", value, "pemId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPemIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("pem_id >=", value, "pemId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPemIdLessThan(Long value) {
            this.addCriterion("pem_id <", value, "pemId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPemIdLessThanOrEqualTo(Long value) {
            this.addCriterion("pem_id <=", value, "pemId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPemIdLike(String value) {
            this.addCriterion("pem_id like", value, "pemId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPemIdNotLike(String value) {
            this.addCriterion("pem_id not like", value, "pemId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }        public ActiveDrawGoodsExample.Criteria andPemIdIn(List<Long> values) {
            this.addCriterion("pem_id in", values, "pemId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPemIdNotIn(List<Long> values) {
            this.addCriterion("pem_id not in", values, "pemId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPemIdBetween(Long value1, Long value2) {
            this.addCriterion("pem_id between", value1, value2, "pemId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPemIdNotBetween(Long value1, Long value2) {
            this.addCriterion("pem_id not between", value1, value2, "pemId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andTypeIsNull() {
            this.addCriterion("type is null");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andTypeIsNotNull() {
            this.addCriterion("type is not null");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andTypeEqualTo(String value) {
            this.addCriterion("type =", value, "type");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andTypeNotEqualTo(String value) {
            this.addCriterion("type <>", value, "type");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andTypeGreaterThan(String value) {
            this.addCriterion("type >", value, "type");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andTypeGreaterThanOrEqualTo(String value) {
            this.addCriterion("type >=", value, "type");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andTypeLessThan(String value) {
            this.addCriterion("type <", value, "type");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andTypeLessThanOrEqualTo(String value) {
            this.addCriterion("type <=", value, "type");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andTypeLike(String value) {
            this.addCriterion("type like", value, "type");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andTypeNotLike(String value) {
            this.addCriterion("type not like", value, "type");
            return (ActiveDrawGoodsExample.Criteria)this;
        }        public ActiveDrawGoodsExample.Criteria andTypeIn(List<String> values) {
            this.addCriterion("type in", values, "type");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andTypeNotIn(List<String> values) {
            this.addCriterion("type not in", values, "type");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andTypeBetween(String value1, String value2) {
            this.addCriterion("type between", value1, value2, "type");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andTypeNotBetween(String value1, String value2) {
            this.addCriterion("type not between", value1, value2, "type");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andSortIsNull() {
            this.addCriterion("sort is null");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andSortIsNotNull() {
            this.addCriterion("sort is not null");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andSortEqualTo(Integer value) {
            this.addCriterion("sort =", value, "sort");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andSortNotEqualTo(Integer value) {
            this.addCriterion("sort <>", value, "sort");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andSortGreaterThan(Integer value) {
            this.addCriterion("sort >", value, "sort");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andSortGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("sort >=", value, "sort");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andSortLessThan(Integer value) {
            this.addCriterion("sort <", value, "sort");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andSortLessThanOrEqualTo(Integer value) {
            this.addCriterion("sort <=", value, "sort");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andSortLike(String value) {
            this.addCriterion("sort like", value, "sort");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andSortNotLike(String value) {
            this.addCriterion("sort not like", value, "sort");
            return (ActiveDrawGoodsExample.Criteria)this;
        }        public ActiveDrawGoodsExample.Criteria andSortIn(List<Integer> values) {
            this.addCriterion("sort in", values, "sort");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andSortNotIn(List<Integer> values) {
            this.addCriterion("sort not in", values, "sort");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andSortBetween(Integer value1, Integer value2) {
            this.addCriterion("sort between", value1, value2, "sort");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andSortNotBetween(Integer value1, Integer value2) {
            this.addCriterion("sort not between", value1, value2, "sort");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPitIdIsNull() {
            this.addCriterion("pit_id is null");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPitIdIsNotNull() {
            this.addCriterion("pit_id is not null");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPitIdEqualTo(Long value) {
            this.addCriterion("pit_id =", value, "pitId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPitIdNotEqualTo(Long value) {
            this.addCriterion("pit_id <>", value, "pitId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPitIdGreaterThan(Long value) {
            this.addCriterion("pit_id >", value, "pitId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPitIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("pit_id >=", value, "pitId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPitIdLessThan(Long value) {
            this.addCriterion("pit_id <", value, "pitId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPitIdLessThanOrEqualTo(Long value) {
            this.addCriterion("pit_id <=", value, "pitId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPitIdLike(String value) {
            this.addCriterion("pit_id like", value, "pitId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPitIdNotLike(String value) {
            this.addCriterion("pit_id not like", value, "pitId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }        public ActiveDrawGoodsExample.Criteria andPitIdIn(List<Long> values) {
            this.addCriterion("pit_id in", values, "pitId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPitIdNotIn(List<Long> values) {
            this.addCriterion("pit_id not in", values, "pitId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPitIdBetween(Long value1, Long value2) {
            this.addCriterion("pit_id between", value1, value2, "pitId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andPitIdNotBetween(Long value1, Long value2) {
            this.addCriterion("pit_id not between", value1, value2, "pitId");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (ActiveDrawGoodsExample.Criteria)this;
        }        public ActiveDrawGoodsExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeIsNull() {
            this.addCriterion("modify_time is null");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeIsNotNull() {
            this.addCriterion("modify_time is not null");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeEqualTo(Date value) {
            this.addCriterion("modify_time =", value, "modifyTime");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeNotEqualTo(Date value) {
            this.addCriterion("modify_time <>", value, "modifyTime");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeGreaterThan(Date value) {
            this.addCriterion("modify_time >", value, "modifyTime");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("modify_time >=", value, "modifyTime");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeLessThan(Date value) {
            this.addCriterion("modify_time <", value, "modifyTime");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("modify_time <=", value, "modifyTime");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeLike(String value) {
            this.addCriterion("modify_time like", value, "modifyTime");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeNotLike(String value) {
            this.addCriterion("modify_time not like", value, "modifyTime");
            return (ActiveDrawGoodsExample.Criteria)this;
        }        public ActiveDrawGoodsExample.Criteria andModifyTimeIn(List<Date> values) {
            this.addCriterion("modify_time in", values, "modifyTime");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeNotIn(List<Date> values) {
            this.addCriterion("modify_time not in", values, "modifyTime");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeBetween(Date value1, Date value2) {
            this.addCriterion("modify_time between", value1, value2, "modifyTime");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andEnabledIsNull() {
            this.addCriterion("enabled is null");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andEnabledIsNotNull() {
            this.addCriterion("enabled is not null");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andEnabledEqualTo(Boolean value) {
            this.addCriterion("enabled =", value, "enabled");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andEnabledNotEqualTo(Boolean value) {
            this.addCriterion("enabled <>", value, "enabled");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andEnabledGreaterThan(Boolean value) {
            this.addCriterion("enabled >", value, "enabled");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andEnabledGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("enabled >=", value, "enabled");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andEnabledLessThan(Boolean value) {
            this.addCriterion("enabled <", value, "enabled");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andEnabledLessThanOrEqualTo(Boolean value) {
            this.addCriterion("enabled <=", value, "enabled");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andEnabledLike(String value) {
            this.addCriterion("enabled like", value, "enabled");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andEnabledNotLike(String value) {
            this.addCriterion("enabled not like", value, "enabled");
            return (ActiveDrawGoodsExample.Criteria)this;
        }        public ActiveDrawGoodsExample.Criteria andEnabledIn(List<Boolean> values) {
            this.addCriterion("enabled in", values, "enabled");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andEnabledNotIn(List<Boolean> values) {
            this.addCriterion("enabled not in", values, "enabled");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andEnabledBetween(Boolean value1, Boolean value2) {
            this.addCriterion("enabled between", value1, value2, "enabled");
            return (ActiveDrawGoodsExample.Criteria)this;
        }

        public ActiveDrawGoodsExample.Criteria andEnabledNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("enabled not between", value1, value2, "enabled");
            return (ActiveDrawGoodsExample.Criteria)this;
        }
    }
}
