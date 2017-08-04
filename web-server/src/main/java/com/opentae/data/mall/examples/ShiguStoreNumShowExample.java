package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShiguStoreNumShowExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguStoreNumShowExample.Criteria> oredCriteria = new ArrayList();

    public ShiguStoreNumShowExample() {
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

    public List<ShiguStoreNumShowExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguStoreNumShowExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguStoreNumShowExample.Criteria or() {
        ShiguStoreNumShowExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguStoreNumShowExample.Criteria createCriteria() {
        ShiguStoreNumShowExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguStoreNumShowExample.Criteria createCriteriaInternal() {
        ShiguStoreNumShowExample.Criteria criteria = new ShiguStoreNumShowExample.Criteria();
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

    public static class Criteria extends ShiguStoreNumShowExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguStoreNumShowExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguStoreNumShowExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguStoreNumShowExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguStoreNumShowExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguStoreNumShowExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguStoreNumShowExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguStoreNumShowExample.Criteria andLastModifyTimeIsNull() {
            this.addCriterion("last_modify_time is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andLastModifyTimeIsNotNull() {
            this.addCriterion("last_modify_time is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andLastModifyTimeEqualTo(Date value) {
            this.addCriterion("last_modify_time =", value, "lastModifyTime");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andLastModifyTimeNotEqualTo(Date value) {
            this.addCriterion("last_modify_time <>", value, "lastModifyTime");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andLastModifyTimeGreaterThan(Date value) {
            this.addCriterion("last_modify_time >", value, "lastModifyTime");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("last_modify_time >=", value, "lastModifyTime");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andLastModifyTimeLessThan(Date value) {
            this.addCriterion("last_modify_time <", value, "lastModifyTime");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("last_modify_time <=", value, "lastModifyTime");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andLastModifyTimeLike(String value) {
            this.addCriterion("last_modify_time like", value, "lastModifyTime");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andLastModifyTimeNotLike(String value) {
            this.addCriterion("last_modify_time not like", value, "lastModifyTime");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andLastModifyTimeIn(List<Date> values) {
            this.addCriterion("last_modify_time in", values, "lastModifyTime");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andLastModifyTimeNotIn(List<Date> values) {
            this.addCriterion("last_modify_time not in", values, "lastModifyTime");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            this.addCriterion("last_modify_time between", value1, value2, "lastModifyTime");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("last_modify_time not between", value1, value2, "lastModifyTime");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andUseStatusIsNull() {
            this.addCriterion("use_status is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andUseStatusIsNotNull() {
            this.addCriterion("use_status is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andUseStatusEqualTo(Integer value) {
            this.addCriterion("use_status =", value, "useStatus");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andUseStatusNotEqualTo(Integer value) {
            this.addCriterion("use_status <>", value, "useStatus");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andUseStatusGreaterThan(Integer value) {
            this.addCriterion("use_status >", value, "useStatus");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("use_status >=", value, "useStatus");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andUseStatusLessThan(Integer value) {
            this.addCriterion("use_status <", value, "useStatus");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("use_status <=", value, "useStatus");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andUseStatusLike(String value) {
            this.addCriterion("use_status like", value, "useStatus");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andUseStatusNotLike(String value) {
            this.addCriterion("use_status not like", value, "useStatus");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andUseStatusIn(List<Integer> values) {
            this.addCriterion("use_status in", values, "useStatus");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andUseStatusNotIn(List<Integer> values) {
            this.addCriterion("use_status not in", values, "useStatus");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andUseStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("use_status between", value1, value2, "useStatus");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("use_status not between", value1, value2, "useStatus");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketIsNull() {
            this.addCriterion("display_market is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketIsNotNull() {
            this.addCriterion("display_market is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketEqualTo(Integer value) {
            this.addCriterion("display_market =", value, "displayMarket");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketNotEqualTo(Integer value) {
            this.addCriterion("display_market <>", value, "displayMarket");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketGreaterThan(Integer value) {
            this.addCriterion("display_market >", value, "displayMarket");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("display_market >=", value, "displayMarket");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketLessThan(Integer value) {
            this.addCriterion("display_market <", value, "displayMarket");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketLessThanOrEqualTo(Integer value) {
            this.addCriterion("display_market <=", value, "displayMarket");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketLike(String value) {
            this.addCriterion("display_market like", value, "displayMarket");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketNotLike(String value) {
            this.addCriterion("display_market not like", value, "displayMarket");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andDisplayMarketIn(List<Integer> values) {
            this.addCriterion("display_market in", values, "displayMarket");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketNotIn(List<Integer> values) {
            this.addCriterion("display_market not in", values, "displayMarket");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketBetween(Integer value1, Integer value2) {
            this.addCriterion("display_market between", value1, value2, "displayMarket");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDisplayMarketNotBetween(Integer value1, Integer value2) {
            this.addCriterion("display_market not between", value1, value2, "displayMarket");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeIsNull() {
            this.addCriterion("main_type is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeIsNotNull() {
            this.addCriterion("main_type is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeEqualTo(String value) {
            this.addCriterion("main_type =", value, "mainType");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeNotEqualTo(String value) {
            this.addCriterion("main_type <>", value, "mainType");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeGreaterThan(String value) {
            this.addCriterion("main_type >", value, "mainType");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeGreaterThanOrEqualTo(String value) {
            this.addCriterion("main_type >=", value, "mainType");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeLessThan(String value) {
            this.addCriterion("main_type <", value, "mainType");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeLessThanOrEqualTo(String value) {
            this.addCriterion("main_type <=", value, "mainType");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeLike(String value) {
            this.addCriterion("main_type like", value, "mainType");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeNotLike(String value) {
            this.addCriterion("main_type not like", value, "mainType");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andMainTypeIn(List<String> values) {
            this.addCriterion("main_type in", values, "mainType");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeNotIn(List<String> values) {
            this.addCriterion("main_type not in", values, "mainType");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeBetween(String value1, String value2) {
            this.addCriterion("main_type between", value1, value2, "mainType");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMainTypeNotBetween(String value1, String value2) {
            this.addCriterion("main_type not between", value1, value2, "mainType");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andBuycityIdIsNull() {
            this.addCriterion("buycity_id is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andBuycityIdIsNotNull() {
            this.addCriterion("buycity_id is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andBuycityIdEqualTo(Long value) {
            this.addCriterion("buycity_id =", value, "buycityId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andBuycityIdNotEqualTo(Long value) {
            this.addCriterion("buycity_id <>", value, "buycityId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andBuycityIdGreaterThan(Long value) {
            this.addCriterion("buycity_id >", value, "buycityId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andBuycityIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("buycity_id >=", value, "buycityId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andBuycityIdLessThan(Long value) {
            this.addCriterion("buycity_id <", value, "buycityId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andBuycityIdLessThanOrEqualTo(Long value) {
            this.addCriterion("buycity_id <=", value, "buycityId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andBuycityIdLike(String value) {
            this.addCriterion("buycity_id like", value, "buycityId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andBuycityIdNotLike(String value) {
            this.addCriterion("buycity_id not like", value, "buycityId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andBuycityIdIn(List<Long> values) {
            this.addCriterion("buycity_id in", values, "buycityId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andBuycityIdNotIn(List<Long> values) {
            this.addCriterion("buycity_id not in", values, "buycityId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andBuycityIdBetween(Long value1, Long value2) {
            this.addCriterion("buycity_id between", value1, value2, "buycityId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andBuycityIdNotBetween(Long value1, Long value2) {
            this.addCriterion("buycity_id not between", value1, value2, "buycityId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIdIsNull() {
            this.addCriterion("store_num_id is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIdIsNotNull() {
            this.addCriterion("store_num_id is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIdEqualTo(Long value) {
            this.addCriterion("store_num_id =", value, "storeNumId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIdNotEqualTo(Long value) {
            this.addCriterion("store_num_id <>", value, "storeNumId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIdGreaterThan(Long value) {
            this.addCriterion("store_num_id >", value, "storeNumId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("store_num_id >=", value, "storeNumId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIdLessThan(Long value) {
            this.addCriterion("store_num_id <", value, "storeNumId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIdLessThanOrEqualTo(Long value) {
            this.addCriterion("store_num_id <=", value, "storeNumId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIdLike(String value) {
            this.addCriterion("store_num_id like", value, "storeNumId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIdNotLike(String value) {
            this.addCriterion("store_num_id not like", value, "storeNumId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andStoreNumIdIn(List<Long> values) {
            this.addCriterion("store_num_id in", values, "storeNumId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIdNotIn(List<Long> values) {
            this.addCriterion("store_num_id not in", values, "storeNumId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIdBetween(Long value1, Long value2) {
            this.addCriterion("store_num_id between", value1, value2, "storeNumId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIdNotBetween(Long value1, Long value2) {
            this.addCriterion("store_num_id not between", value1, value2, "storeNumId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIdIsNull() {
            this.addCriterion("parent_market_id is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIdIsNotNull() {
            this.addCriterion("parent_market_id is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIdEqualTo(Long value) {
            this.addCriterion("parent_market_id =", value, "parentMarketId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIdNotEqualTo(Long value) {
            this.addCriterion("parent_market_id <>", value, "parentMarketId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIdGreaterThan(Long value) {
            this.addCriterion("parent_market_id >", value, "parentMarketId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("parent_market_id >=", value, "parentMarketId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIdLessThan(Long value) {
            this.addCriterion("parent_market_id <", value, "parentMarketId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIdLessThanOrEqualTo(Long value) {
            this.addCriterion("parent_market_id <=", value, "parentMarketId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIdLike(String value) {
            this.addCriterion("parent_market_id like", value, "parentMarketId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIdNotLike(String value) {
            this.addCriterion("parent_market_id not like", value, "parentMarketId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andParentMarketIdIn(List<Long> values) {
            this.addCriterion("parent_market_id in", values, "parentMarketId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIdNotIn(List<Long> values) {
            this.addCriterion("parent_market_id not in", values, "parentMarketId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIdBetween(Long value1, Long value2) {
            this.addCriterion("parent_market_id between", value1, value2, "parentMarketId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIdNotBetween(Long value1, Long value2) {
            this.addCriterion("parent_market_id not between", value1, value2, "parentMarketId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIsNull() {
            this.addCriterion("parent_market is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketIsNotNull() {
            this.addCriterion("parent_market is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketEqualTo(String value) {
            this.addCriterion("parent_market =", value, "parentMarket");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketNotEqualTo(String value) {
            this.addCriterion("parent_market <>", value, "parentMarket");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketGreaterThan(String value) {
            this.addCriterion("parent_market >", value, "parentMarket");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketGreaterThanOrEqualTo(String value) {
            this.addCriterion("parent_market >=", value, "parentMarket");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketLessThan(String value) {
            this.addCriterion("parent_market <", value, "parentMarket");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketLessThanOrEqualTo(String value) {
            this.addCriterion("parent_market <=", value, "parentMarket");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketLike(String value) {
            this.addCriterion("parent_market like", value, "parentMarket");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketNotLike(String value) {
            this.addCriterion("parent_market not like", value, "parentMarket");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andParentMarketIn(List<String> values) {
            this.addCriterion("parent_market in", values, "parentMarket");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketNotIn(List<String> values) {
            this.addCriterion("parent_market not in", values, "parentMarket");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketBetween(String value1, String value2) {
            this.addCriterion("parent_market between", value1, value2, "parentMarket");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andParentMarketNotBetween(String value1, String value2) {
            this.addCriterion("parent_market not between", value1, value2, "parentMarket");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendSortIsNull() {
            this.addCriterion("recommend_sort is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendSortIsNotNull() {
            this.addCriterion("recommend_sort is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendSortEqualTo(Integer value) {
            this.addCriterion("recommend_sort =", value, "recommendSort");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendSortNotEqualTo(Integer value) {
            this.addCriterion("recommend_sort <>", value, "recommendSort");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendSortGreaterThan(Integer value) {
            this.addCriterion("recommend_sort >", value, "recommendSort");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendSortGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("recommend_sort >=", value, "recommendSort");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendSortLessThan(Integer value) {
            this.addCriterion("recommend_sort <", value, "recommendSort");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendSortLessThanOrEqualTo(Integer value) {
            this.addCriterion("recommend_sort <=", value, "recommendSort");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendSortLike(String value) {
            this.addCriterion("recommend_sort like", value, "recommendSort");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendSortNotLike(String value) {
            this.addCriterion("recommend_sort not like", value, "recommendSort");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andRecommendSortIn(List<Integer> values) {
            this.addCriterion("recommend_sort in", values, "recommendSort");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendSortNotIn(List<Integer> values) {
            this.addCriterion("recommend_sort not in", values, "recommendSort");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendSortBetween(Integer value1, Integer value2) {
            this.addCriterion("recommend_sort between", value1, value2, "recommendSort");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendSortNotBetween(Integer value1, Integer value2) {
            this.addCriterion("recommend_sort not between", value1, value2, "recommendSort");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderIsNull() {
            this.addCriterion("sort_order is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderIsNotNull() {
            this.addCriterion("sort_order is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderEqualTo(String value) {
            this.addCriterion("sort_order =", value, "sortOrder");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderNotEqualTo(String value) {
            this.addCriterion("sort_order <>", value, "sortOrder");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderGreaterThan(String value) {
            this.addCriterion("sort_order >", value, "sortOrder");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderGreaterThanOrEqualTo(String value) {
            this.addCriterion("sort_order >=", value, "sortOrder");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderLessThan(String value) {
            this.addCriterion("sort_order <", value, "sortOrder");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderLessThanOrEqualTo(String value) {
            this.addCriterion("sort_order <=", value, "sortOrder");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderLike(String value) {
            this.addCriterion("sort_order like", value, "sortOrder");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderNotLike(String value) {
            this.addCriterion("sort_order not like", value, "sortOrder");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andSortOrderIn(List<String> values) {
            this.addCriterion("sort_order in", values, "sortOrder");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderNotIn(List<String> values) {
            this.addCriterion("sort_order not in", values, "sortOrder");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderBetween(String value1, String value2) {
            this.addCriterion("sort_order between", value1, value2, "sortOrder");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andSortOrderNotBetween(String value1, String value2) {
            this.addCriterion("sort_order not between", value1, value2, "sortOrder");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreIdIsNull() {
            this.addCriterion("store_id is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreIdIsNotNull() {
            this.addCriterion("store_id is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreIdEqualTo(Long value) {
            this.addCriterion("store_id =", value, "storeId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreIdNotEqualTo(Long value) {
            this.addCriterion("store_id <>", value, "storeId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreIdGreaterThan(Long value) {
            this.addCriterion("store_id >", value, "storeId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("store_id >=", value, "storeId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreIdLessThan(Long value) {
            this.addCriterion("store_id <", value, "storeId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            this.addCriterion("store_id <=", value, "storeId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreIdLike(String value) {
            this.addCriterion("store_id like", value, "storeId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreIdNotLike(String value) {
            this.addCriterion("store_id not like", value, "storeId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andStoreIdIn(List<Long> values) {
            this.addCriterion("store_id in", values, "storeId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreIdNotIn(List<Long> values) {
            this.addCriterion("store_id not in", values, "storeId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            this.addCriterion("store_id between", value1, value2, "storeId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            this.addCriterion("store_id not between", value1, value2, "storeId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDealDateIsNull() {
            this.addCriterion("deal_date is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDealDateIsNotNull() {
            this.addCriterion("deal_date is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDealDateEqualTo(Date value) {
            this.addCriterion("deal_date =", value, "dealDate");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDealDateNotEqualTo(Date value) {
            this.addCriterion("deal_date <>", value, "dealDate");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDealDateGreaterThan(Date value) {
            this.addCriterion("deal_date >", value, "dealDate");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDealDateGreaterThanOrEqualTo(Date value) {
            this.addCriterion("deal_date >=", value, "dealDate");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDealDateLessThan(Date value) {
            this.addCriterion("deal_date <", value, "dealDate");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDealDateLessThanOrEqualTo(Date value) {
            this.addCriterion("deal_date <=", value, "dealDate");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDealDateLike(String value) {
            this.addCriterion("deal_date like", value, "dealDate");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDealDateNotLike(String value) {
            this.addCriterion("deal_date not like", value, "dealDate");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andDealDateIn(List<Date> values) {
            this.addCriterion("deal_date in", values, "dealDate");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDealDateNotIn(List<Date> values) {
            this.addCriterion("deal_date not in", values, "dealDate");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDealDateBetween(Date value1, Date value2) {
            this.addCriterion("deal_date between", value1, value2, "dealDate");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andDealDateNotBetween(Date value1, Date value2) {
            this.addCriterion("deal_date not between", value1, value2, "dealDate");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketIdIsNull() {
            this.addCriterion("market_id is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketIdIsNotNull() {
            this.addCriterion("market_id is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketIdEqualTo(Long value) {
            this.addCriterion("market_id =", value, "marketId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketIdNotEqualTo(Long value) {
            this.addCriterion("market_id <>", value, "marketId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketIdGreaterThan(Long value) {
            this.addCriterion("market_id >", value, "marketId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("market_id >=", value, "marketId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketIdLessThan(Long value) {
            this.addCriterion("market_id <", value, "marketId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            this.addCriterion("market_id <=", value, "marketId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketIdLike(String value) {
            this.addCriterion("market_id like", value, "marketId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketIdNotLike(String value) {
            this.addCriterion("market_id not like", value, "marketId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andMarketIdIn(List<Long> values) {
            this.addCriterion("market_id in", values, "marketId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketIdNotIn(List<Long> values) {
            this.addCriterion("market_id not in", values, "marketId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            this.addCriterion("market_id between", value1, value2, "marketId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            this.addCriterion("market_id not between", value1, value2, "marketId");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescIsNull() {
            this.addCriterion("store_num_desc is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescIsNotNull() {
            this.addCriterion("store_num_desc is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescEqualTo(String value) {
            this.addCriterion("store_num_desc =", value, "storeNumDesc");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescNotEqualTo(String value) {
            this.addCriterion("store_num_desc <>", value, "storeNumDesc");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescGreaterThan(String value) {
            this.addCriterion("store_num_desc >", value, "storeNumDesc");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescGreaterThanOrEqualTo(String value) {
            this.addCriterion("store_num_desc >=", value, "storeNumDesc");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescLessThan(String value) {
            this.addCriterion("store_num_desc <", value, "storeNumDesc");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescLessThanOrEqualTo(String value) {
            this.addCriterion("store_num_desc <=", value, "storeNumDesc");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescLike(String value) {
            this.addCriterion("store_num_desc like", value, "storeNumDesc");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescNotLike(String value) {
            this.addCriterion("store_num_desc not like", value, "storeNumDesc");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andStoreNumDescIn(List<String> values) {
            this.addCriterion("store_num_desc in", values, "storeNumDesc");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescNotIn(List<String> values) {
            this.addCriterion("store_num_desc not in", values, "storeNumDesc");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescBetween(String value1, String value2) {
            this.addCriterion("store_num_desc between", value1, value2, "storeNumDesc");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumDescNotBetween(String value1, String value2) {
            this.addCriterion("store_num_desc not between", value1, value2, "storeNumDesc");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andServicesIsNull() {
            this.addCriterion("services is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andServicesIsNotNull() {
            this.addCriterion("services is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andServicesEqualTo(String value) {
            this.addCriterion("services =", value, "services");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andServicesNotEqualTo(String value) {
            this.addCriterion("services <>", value, "services");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andServicesGreaterThan(String value) {
            this.addCriterion("services >", value, "services");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andServicesGreaterThanOrEqualTo(String value) {
            this.addCriterion("services >=", value, "services");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andServicesLessThan(String value) {
            this.addCriterion("services <", value, "services");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andServicesLessThanOrEqualTo(String value) {
            this.addCriterion("services <=", value, "services");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andServicesLike(String value) {
            this.addCriterion("services like", value, "services");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andServicesNotLike(String value) {
            this.addCriterion("services not like", value, "services");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andServicesIn(List<String> values) {
            this.addCriterion("services in", values, "services");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andServicesNotIn(List<String> values) {
            this.addCriterion("services not in", values, "services");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andServicesBetween(String value1, String value2) {
            this.addCriterion("services between", value1, value2, "services");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andServicesNotBetween(String value1, String value2) {
            this.addCriterion("services not between", value1, value2, "services");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendIsIsNull() {
            this.addCriterion("recommend_is is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendIsIsNotNull() {
            this.addCriterion("recommend_is is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendIsEqualTo(Integer value) {
            this.addCriterion("recommend_is =", value, "recommendIs");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendIsNotEqualTo(Integer value) {
            this.addCriterion("recommend_is <>", value, "recommendIs");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendIsGreaterThan(Integer value) {
            this.addCriterion("recommend_is >", value, "recommendIs");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendIsGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("recommend_is >=", value, "recommendIs");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendIsLessThan(Integer value) {
            this.addCriterion("recommend_is <", value, "recommendIs");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendIsLessThanOrEqualTo(Integer value) {
            this.addCriterion("recommend_is <=", value, "recommendIs");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendIsLike(String value) {
            this.addCriterion("recommend_is like", value, "recommendIs");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendIsNotLike(String value) {
            this.addCriterion("recommend_is not like", value, "recommendIs");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andRecommendIsIn(List<Integer> values) {
            this.addCriterion("recommend_is in", values, "recommendIs");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendIsNotIn(List<Integer> values) {
            this.addCriterion("recommend_is not in", values, "recommendIs");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendIsBetween(Integer value1, Integer value2) {
            this.addCriterion("recommend_is between", value1, value2, "recommendIs");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRecommendIsNotBetween(Integer value1, Integer value2) {
            this.addCriterion("recommend_is not between", value1, value2, "recommendIs");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketIsNull() {
            this.addCriterion("market is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketIsNotNull() {
            this.addCriterion("market is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketEqualTo(String value) {
            this.addCriterion("market =", value, "market");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketNotEqualTo(String value) {
            this.addCriterion("market <>", value, "market");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketGreaterThan(String value) {
            this.addCriterion("market >", value, "market");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketGreaterThanOrEqualTo(String value) {
            this.addCriterion("market >=", value, "market");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketLessThan(String value) {
            this.addCriterion("market <", value, "market");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketLessThanOrEqualTo(String value) {
            this.addCriterion("market <=", value, "market");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketLike(String value) {
            this.addCriterion("market like", value, "market");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketNotLike(String value) {
            this.addCriterion("market not like", value, "market");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andMarketIn(List<String> values) {
            this.addCriterion("market in", values, "market");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketNotIn(List<String> values) {
            this.addCriterion("market not in", values, "market");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketBetween(String value1, String value2) {
            this.addCriterion("market between", value1, value2, "market");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andMarketNotBetween(String value1, String value2) {
            this.addCriterion("market not between", value1, value2, "market");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlIsNull() {
            this.addCriterion("visit_url is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlIsNotNull() {
            this.addCriterion("visit_url is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlEqualTo(String value) {
            this.addCriterion("visit_url =", value, "visitUrl");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlNotEqualTo(String value) {
            this.addCriterion("visit_url <>", value, "visitUrl");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlGreaterThan(String value) {
            this.addCriterion("visit_url >", value, "visitUrl");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("visit_url >=", value, "visitUrl");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlLessThan(String value) {
            this.addCriterion("visit_url <", value, "visitUrl");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlLessThanOrEqualTo(String value) {
            this.addCriterion("visit_url <=", value, "visitUrl");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlLike(String value) {
            this.addCriterion("visit_url like", value, "visitUrl");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlNotLike(String value) {
            this.addCriterion("visit_url not like", value, "visitUrl");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andVisitUrlIn(List<String> values) {
            this.addCriterion("visit_url in", values, "visitUrl");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlNotIn(List<String> values) {
            this.addCriterion("visit_url not in", values, "visitUrl");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlBetween(String value1, String value2) {
            this.addCriterion("visit_url between", value1, value2, "visitUrl");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andVisitUrlNotBetween(String value1, String value2) {
            this.addCriterion("visit_url not between", value1, value2, "visitUrl");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIsNull() {
            this.addCriterion("store_num is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumIsNotNull() {
            this.addCriterion("store_num is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumEqualTo(String value) {
            this.addCriterion("store_num =", value, "storeNum");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumNotEqualTo(String value) {
            this.addCriterion("store_num <>", value, "storeNum");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumGreaterThan(String value) {
            this.addCriterion("store_num >", value, "storeNum");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumGreaterThanOrEqualTo(String value) {
            this.addCriterion("store_num >=", value, "storeNum");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumLessThan(String value) {
            this.addCriterion("store_num <", value, "storeNum");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumLessThanOrEqualTo(String value) {
            this.addCriterion("store_num <=", value, "storeNum");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumLike(String value) {
            this.addCriterion("store_num like", value, "storeNum");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumNotLike(String value) {
            this.addCriterion("store_num not like", value, "storeNum");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andStoreNumIn(List<String> values) {
            this.addCriterion("store_num in", values, "storeNum");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumNotIn(List<String> values) {
            this.addCriterion("store_num not in", values, "storeNum");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumBetween(String value1, String value2) {
            this.addCriterion("store_num between", value1, value2, "storeNum");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andStoreNumNotBetween(String value1, String value2) {
            this.addCriterion("store_num not between", value1, value2, "storeNum");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteIsNull() {
            this.addCriterion("web_site is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteIsNotNull() {
            this.addCriterion("web_site is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("web_site =", value, "webSite");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("web_site <>", value, "webSite");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("web_site >", value, "webSite");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("web_site >=", value, "webSite");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteLessThan(String value) {
            this.addCriterion("web_site <", value, "webSite");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("web_site <=", value, "webSite");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteLike(String value) {
            this.addCriterion("web_site like", value, "webSite");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteNotLike(String value) {
            this.addCriterion("web_site not like", value, "webSite");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("web_site in", values, "webSite");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("web_site not in", values, "webSite");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("web_site between", value1, value2, "webSite");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("web_site not between", value1, value2, "webSite");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (ShiguStoreNumShowExample.Criteria)this;
        }        public ShiguStoreNumShowExample.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (ShiguStoreNumShowExample.Criteria)this;
        }

        public ShiguStoreNumShowExample.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (ShiguStoreNumShowExample.Criteria)this;
        }
    }
}
