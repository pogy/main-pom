package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class GoodsupNorealExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<GoodsupNorealExample.Criteria> oredCriteria = new ArrayList();

    public GoodsupNorealExample() {
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

    public List<GoodsupNorealExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(GoodsupNorealExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public GoodsupNorealExample.Criteria or() {
        GoodsupNorealExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public GoodsupNorealExample.Criteria createCriteria() {
        GoodsupNorealExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected GoodsupNorealExample.Criteria createCriteriaInternal() {
        GoodsupNorealExample.Criteria criteria = new GoodsupNorealExample.Criteria();
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

    public static class Criteria extends GoodsupNorealExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<GoodsupNorealExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<GoodsupNorealExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<GoodsupNorealExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new GoodsupNorealExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new GoodsupNorealExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new GoodsupNorealExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public GoodsupNorealExample.Criteria andActiveNumIsNull() {
            this.addCriterion("active_num is null");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andActiveNumIsNotNull() {
            this.addCriterion("active_num is not null");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andActiveNumEqualTo(Integer value) {
            this.addCriterion("active_num =", value, "activeNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andActiveNumNotEqualTo(Integer value) {
            this.addCriterion("active_num <>", value, "activeNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andActiveNumGreaterThan(Integer value) {
            this.addCriterion("active_num >", value, "activeNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andActiveNumGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("active_num >=", value, "activeNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andActiveNumLessThan(Integer value) {
            this.addCriterion("active_num <", value, "activeNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andActiveNumLessThanOrEqualTo(Integer value) {
            this.addCriterion("active_num <=", value, "activeNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andActiveNumLike(String value) {
            this.addCriterion("active_num like", value, "activeNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andActiveNumNotLike(String value) {
            this.addCriterion("active_num not like", value, "activeNum");
            return (GoodsupNorealExample.Criteria)this;
        }        public GoodsupNorealExample.Criteria andActiveNumIn(List<Integer> values) {
            this.addCriterion("active_num in", values, "activeNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andActiveNumNotIn(List<Integer> values) {
            this.addCriterion("active_num not in", values, "activeNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andActiveNumBetween(Integer value1, Integer value2) {
            this.addCriterion("active_num between", value1, value2, "activeNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andActiveNumNotBetween(Integer value1, Integer value2) {
            this.addCriterion("active_num not between", value1, value2, "activeNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andItemIdIsNull() {
            this.addCriterion("item_id is null");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andItemIdIsNotNull() {
            this.addCriterion("item_id is not null");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andItemIdEqualTo(Long value) {
            this.addCriterion("item_id =", value, "itemId");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andItemIdNotEqualTo(Long value) {
            this.addCriterion("item_id <>", value, "itemId");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andItemIdGreaterThan(Long value) {
            this.addCriterion("item_id >", value, "itemId");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andItemIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("item_id >=", value, "itemId");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andItemIdLessThan(Long value) {
            this.addCriterion("item_id <", value, "itemId");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andItemIdLessThanOrEqualTo(Long value) {
            this.addCriterion("item_id <=", value, "itemId");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andItemIdLike(String value) {
            this.addCriterion("item_id like", value, "itemId");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andItemIdNotLike(String value) {
            this.addCriterion("item_id not like", value, "itemId");
            return (GoodsupNorealExample.Criteria)this;
        }        public GoodsupNorealExample.Criteria andItemIdIn(List<Long> values) {
            this.addCriterion("item_id in", values, "itemId");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andItemIdNotIn(List<Long> values) {
            this.addCriterion("item_id not in", values, "itemId");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andItemIdBetween(Long value1, Long value2) {
            this.addCriterion("item_id between", value1, value2, "itemId");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andItemIdNotBetween(Long value1, Long value2) {
            this.addCriterion("item_id not between", value1, value2, "itemId");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andRealNumIsNull() {
            this.addCriterion("real_num is null");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andRealNumIsNotNull() {
            this.addCriterion("real_num is not null");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andRealNumEqualTo(Integer value) {
            this.addCriterion("real_num =", value, "realNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andRealNumNotEqualTo(Integer value) {
            this.addCriterion("real_num <>", value, "realNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andRealNumGreaterThan(Integer value) {
            this.addCriterion("real_num >", value, "realNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andRealNumGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("real_num >=", value, "realNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andRealNumLessThan(Integer value) {
            this.addCriterion("real_num <", value, "realNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andRealNumLessThanOrEqualTo(Integer value) {
            this.addCriterion("real_num <=", value, "realNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andRealNumLike(String value) {
            this.addCriterion("real_num like", value, "realNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andRealNumNotLike(String value) {
            this.addCriterion("real_num not like", value, "realNum");
            return (GoodsupNorealExample.Criteria)this;
        }        public GoodsupNorealExample.Criteria andRealNumIn(List<Integer> values) {
            this.addCriterion("real_num in", values, "realNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andRealNumNotIn(List<Integer> values) {
            this.addCriterion("real_num not in", values, "realNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andRealNumBetween(Integer value1, Integer value2) {
            this.addCriterion("real_num between", value1, value2, "realNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andRealNumNotBetween(Integer value1, Integer value2) {
            this.addCriterion("real_num not between", value1, value2, "realNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andAddNumIsNull() {
            this.addCriterion("add_num is null");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andAddNumIsNotNull() {
            this.addCriterion("add_num is not null");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andAddNumEqualTo(Integer value) {
            this.addCriterion("add_num =", value, "addNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andAddNumNotEqualTo(Integer value) {
            this.addCriterion("add_num <>", value, "addNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andAddNumGreaterThan(Integer value) {
            this.addCriterion("add_num >", value, "addNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andAddNumGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("add_num >=", value, "addNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andAddNumLessThan(Integer value) {
            this.addCriterion("add_num <", value, "addNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andAddNumLessThanOrEqualTo(Integer value) {
            this.addCriterion("add_num <=", value, "addNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andAddNumLike(String value) {
            this.addCriterion("add_num like", value, "addNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andAddNumNotLike(String value) {
            this.addCriterion("add_num not like", value, "addNum");
            return (GoodsupNorealExample.Criteria)this;
        }        public GoodsupNorealExample.Criteria andAddNumIn(List<Integer> values) {
            this.addCriterion("add_num in", values, "addNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andAddNumNotIn(List<Integer> values) {
            this.addCriterion("add_num not in", values, "addNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andAddNumBetween(Integer value1, Integer value2) {
            this.addCriterion("add_num between", value1, value2, "addNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andAddNumNotBetween(Integer value1, Integer value2) {
            this.addCriterion("add_num not between", value1, value2, "addNum");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andNorealIdIsNull() {
            this.addCriterion("noreal_id is null");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andNorealIdIsNotNull() {
            this.addCriterion("noreal_id is not null");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andNorealIdEqualTo(Long value) {
            this.addCriterion("noreal_id =", value, "norealId");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andNorealIdNotEqualTo(Long value) {
            this.addCriterion("noreal_id <>", value, "norealId");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andNorealIdGreaterThan(Long value) {
            this.addCriterion("noreal_id >", value, "norealId");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andNorealIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("noreal_id >=", value, "norealId");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andNorealIdLessThan(Long value) {
            this.addCriterion("noreal_id <", value, "norealId");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andNorealIdLessThanOrEqualTo(Long value) {
            this.addCriterion("noreal_id <=", value, "norealId");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andNorealIdLike(String value) {
            this.addCriterion("noreal_id like", value, "norealId");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andNorealIdNotLike(String value) {
            this.addCriterion("noreal_id not like", value, "norealId");
            return (GoodsupNorealExample.Criteria)this;
        }        public GoodsupNorealExample.Criteria andNorealIdIn(List<Long> values) {
            this.addCriterion("noreal_id in", values, "norealId");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andNorealIdNotIn(List<Long> values) {
            this.addCriterion("noreal_id not in", values, "norealId");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andNorealIdBetween(Long value1, Long value2) {
            this.addCriterion("noreal_id between", value1, value2, "norealId");
            return (GoodsupNorealExample.Criteria)this;
        }

        public GoodsupNorealExample.Criteria andNorealIdNotBetween(Long value1, Long value2) {
            this.addCriterion("noreal_id not between", value1, value2, "norealId");
            return (GoodsupNorealExample.Criteria)this;
        }
    }
}
