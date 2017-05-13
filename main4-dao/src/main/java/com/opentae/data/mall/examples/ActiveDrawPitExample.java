package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ActiveDrawPitExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ActiveDrawPitExample.Criteria> oredCriteria = new ArrayList();

    public ActiveDrawPitExample() {
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

    public List<ActiveDrawPitExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ActiveDrawPitExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ActiveDrawPitExample.Criteria or() {
        ActiveDrawPitExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ActiveDrawPitExample.Criteria createCriteria() {
        ActiveDrawPitExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ActiveDrawPitExample.Criteria createCriteriaInternal() {
        ActiveDrawPitExample.Criteria criteria = new ActiveDrawPitExample.Criteria();
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

    public static class Criteria extends ActiveDrawPitExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ActiveDrawPitExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ActiveDrawPitExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ActiveDrawPitExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ActiveDrawPitExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ActiveDrawPitExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ActiveDrawPitExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ActiveDrawPitExample.Criteria andIdIsNull() {
            this.addCriterion("id is null");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andIdIsNotNull() {
            this.addCriterion("id is not null");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andIdEqualTo(Long value) {
            this.addCriterion("id =", value, "id");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andIdNotEqualTo(Long value) {
            this.addCriterion("id <>", value, "id");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andIdGreaterThan(Long value) {
            this.addCriterion("id >", value, "id");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("id >=", value, "id");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andIdLessThan(Long value) {
            this.addCriterion("id <", value, "id");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andIdLessThanOrEqualTo(Long value) {
            this.addCriterion("id <=", value, "id");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andIdLike(String value) {
            this.addCriterion("id like", value, "id");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andIdNotLike(String value) {
            this.addCriterion("id not like", value, "id");
            return (ActiveDrawPitExample.Criteria)this;
        }        public ActiveDrawPitExample.Criteria andIdIn(List<Long> values) {
            this.addCriterion("id in", values, "id");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andIdNotIn(List<Long> values) {
            this.addCriterion("id not in", values, "id");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andIdBetween(Long value1, Long value2) {
            this.addCriterion("id between", value1, value2, "id");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andIdNotBetween(Long value1, Long value2) {
            this.addCriterion("id not between", value1, value2, "id");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andNumIsNull() {
            this.addCriterion("num is null");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andNumIsNotNull() {
            this.addCriterion("num is not null");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andNumEqualTo(Integer value) {
            this.addCriterion("num =", value, "num");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andNumNotEqualTo(Integer value) {
            this.addCriterion("num <>", value, "num");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andNumGreaterThan(Integer value) {
            this.addCriterion("num >", value, "num");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andNumGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("num >=", value, "num");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andNumLessThan(Integer value) {
            this.addCriterion("num <", value, "num");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andNumLessThanOrEqualTo(Integer value) {
            this.addCriterion("num <=", value, "num");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andNumLike(String value) {
            this.addCriterion("num like", value, "num");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andNumNotLike(String value) {
            this.addCriterion("num not like", value, "num");
            return (ActiveDrawPitExample.Criteria)this;
        }        public ActiveDrawPitExample.Criteria andNumIn(List<Integer> values) {
            this.addCriterion("num in", values, "num");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andNumNotIn(List<Integer> values) {
            this.addCriterion("num not in", values, "num");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andNumBetween(Integer value1, Integer value2) {
            this.addCriterion("num between", value1, value2, "num");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andNumNotBetween(Integer value1, Integer value2) {
            this.addCriterion("num not between", value1, value2, "num");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andTypeIsNull() {
            this.addCriterion("type is null");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andTypeIsNotNull() {
            this.addCriterion("type is not null");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andTypeEqualTo(String value) {
            this.addCriterion("type =", value, "type");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andTypeNotEqualTo(String value) {
            this.addCriterion("type <>", value, "type");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andTypeGreaterThan(String value) {
            this.addCriterion("type >", value, "type");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andTypeGreaterThanOrEqualTo(String value) {
            this.addCriterion("type >=", value, "type");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andTypeLessThan(String value) {
            this.addCriterion("type <", value, "type");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andTypeLessThanOrEqualTo(String value) {
            this.addCriterion("type <=", value, "type");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andTypeLike(String value) {
            this.addCriterion("type like", value, "type");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andTypeNotLike(String value) {
            this.addCriterion("type not like", value, "type");
            return (ActiveDrawPitExample.Criteria)this;
        }        public ActiveDrawPitExample.Criteria andTypeIn(List<String> values) {
            this.addCriterion("type in", values, "type");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andTypeNotIn(List<String> values) {
            this.addCriterion("type not in", values, "type");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andTypeBetween(String value1, String value2) {
            this.addCriterion("type between", value1, value2, "type");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andTypeNotBetween(String value1, String value2) {
            this.addCriterion("type not between", value1, value2, "type");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeIsNull() {
            this.addCriterion("goods_type is null");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeIsNotNull() {
            this.addCriterion("goods_type is not null");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeEqualTo(String value) {
            this.addCriterion("goods_type =", value, "goodsType");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeNotEqualTo(String value) {
            this.addCriterion("goods_type <>", value, "goodsType");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeGreaterThan(String value) {
            this.addCriterion("goods_type >", value, "goodsType");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeGreaterThanOrEqualTo(String value) {
            this.addCriterion("goods_type >=", value, "goodsType");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeLessThan(String value) {
            this.addCriterion("goods_type <", value, "goodsType");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeLessThanOrEqualTo(String value) {
            this.addCriterion("goods_type <=", value, "goodsType");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeLike(String value) {
            this.addCriterion("goods_type like", value, "goodsType");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeNotLike(String value) {
            this.addCriterion("goods_type not like", value, "goodsType");
            return (ActiveDrawPitExample.Criteria)this;
        }        public ActiveDrawPitExample.Criteria andGoodsTypeIn(List<String> values) {
            this.addCriterion("goods_type in", values, "goodsType");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeNotIn(List<String> values) {
            this.addCriterion("goods_type not in", values, "goodsType");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeBetween(String value1, String value2) {
            this.addCriterion("goods_type between", value1, value2, "goodsType");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andGoodsTypeNotBetween(String value1, String value2) {
            this.addCriterion("goods_type not between", value1, value2, "goodsType");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (ActiveDrawPitExample.Criteria)this;
        }        public ActiveDrawPitExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (ActiveDrawPitExample.Criteria)this;
        }

        public ActiveDrawPitExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (ActiveDrawPitExample.Criteria)this;
        }
    }
}
