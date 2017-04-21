package com.opentae.data.mall.examples;

import com.opentae.common.beans.MoreSiteExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Deprecated
public class ShiguStoreExample extends MoreSiteExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguStoreExample.Criteria> oredCriteria = new ArrayList();

    public ShiguStoreExample() {
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

    public List<ShiguStoreExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguStoreExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguStoreExample.Criteria or() {
        ShiguStoreExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguStoreExample.Criteria createCriteria() {
        ShiguStoreExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguStoreExample.Criteria createCriteriaInternal() {
        ShiguStoreExample.Criteria criteria = new ShiguStoreExample.Criteria();
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

    public static class Criteria extends ShiguStoreExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguStoreExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguStoreExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguStoreExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguStoreExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguStoreExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguStoreExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguStoreExample.Criteria andStoreIdIsNull() {
            this.addCriterion("store_id is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreIdIsNotNull() {
            this.addCriterion("store_id is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreIdEqualTo(Long value) {
            this.addCriterion("store_id =", value, "storeId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreIdNotEqualTo(Long value) {
            this.addCriterion("store_id <>", value, "storeId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreIdGreaterThan(Long value) {
            this.addCriterion("store_id >", value, "storeId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("store_id >=", value, "storeId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreIdLessThan(Long value) {
            this.addCriterion("store_id <", value, "storeId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            this.addCriterion("store_id <=", value, "storeId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreIdLike(String value) {
            this.addCriterion("store_id like", value, "storeId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreIdNotLike(String value) {
            this.addCriterion("store_id not like", value, "storeId");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andStoreIdIn(List<Long> values) {
            this.addCriterion("store_id in", values, "storeId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreIdNotIn(List<Long> values) {
            this.addCriterion("store_id not in", values, "storeId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            this.addCriterion("store_id between", value1, value2, "storeId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            this.addCriterion("store_id not between", value1, value2, "storeId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNameIsNull() {
            this.addCriterion("store_name is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNameIsNotNull() {
            this.addCriterion("store_name is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNameEqualTo(String value) {
            this.addCriterion("store_name =", value, "storeName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNameNotEqualTo(String value) {
            this.addCriterion("store_name <>", value, "storeName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNameGreaterThan(String value) {
            this.addCriterion("store_name >", value, "storeName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("store_name >=", value, "storeName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNameLessThan(String value) {
            this.addCriterion("store_name <", value, "storeName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNameLessThanOrEqualTo(String value) {
            this.addCriterion("store_name <=", value, "storeName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNameLike(String value) {
            this.addCriterion("store_name like", value, "storeName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNameNotLike(String value) {
            this.addCriterion("store_name not like", value, "storeName");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andStoreNameIn(List<String> values) {
            this.addCriterion("store_name in", values, "storeName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNameNotIn(List<String> values) {
            this.addCriterion("store_name not in", values, "storeName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNameBetween(String value1, String value2) {
            this.addCriterion("store_name between", value1, value2, "storeName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNameNotBetween(String value1, String value2) {
            this.addCriterion("store_name not between", value1, value2, "storeName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUrlIsNull() {
            this.addCriterion("taobao_url is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUrlIsNotNull() {
            this.addCriterion("taobao_url is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUrlEqualTo(String value) {
            this.addCriterion("taobao_url =", value, "taobaoUrl");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUrlNotEqualTo(String value) {
            this.addCriterion("taobao_url <>", value, "taobaoUrl");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUrlGreaterThan(String value) {
            this.addCriterion("taobao_url >", value, "taobaoUrl");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("taobao_url >=", value, "taobaoUrl");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUrlLessThan(String value) {
            this.addCriterion("taobao_url <", value, "taobaoUrl");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUrlLessThanOrEqualTo(String value) {
            this.addCriterion("taobao_url <=", value, "taobaoUrl");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUrlLike(String value) {
            this.addCriterion("taobao_url like", value, "taobaoUrl");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUrlNotLike(String value) {
            this.addCriterion("taobao_url not like", value, "taobaoUrl");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andTaobaoUrlIn(List<String> values) {
            this.addCriterion("taobao_url in", values, "taobaoUrl");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUrlNotIn(List<String> values) {
            this.addCriterion("taobao_url not in", values, "taobaoUrl");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUrlBetween(String value1, String value2) {
            this.addCriterion("taobao_url between", value1, value2, "taobaoUrl");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUrlNotBetween(String value1, String value2) {
            this.addCriterion("taobao_url not between", value1, value2, "taobaoUrl");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMainBusIsNull() {
            this.addCriterion("main_bus is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMainBusIsNotNull() {
            this.addCriterion("main_bus is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMainBusEqualTo(String value) {
            this.addCriterion("main_bus =", value, "mainBus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMainBusNotEqualTo(String value) {
            this.addCriterion("main_bus <>", value, "mainBus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMainBusGreaterThan(String value) {
            this.addCriterion("main_bus >", value, "mainBus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMainBusGreaterThanOrEqualTo(String value) {
            this.addCriterion("main_bus >=", value, "mainBus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMainBusLessThan(String value) {
            this.addCriterion("main_bus <", value, "mainBus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMainBusLessThanOrEqualTo(String value) {
            this.addCriterion("main_bus <=", value, "mainBus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMainBusLike(String value) {
            this.addCriterion("main_bus like", value, "mainBus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMainBusNotLike(String value) {
            this.addCriterion("main_bus not like", value, "mainBus");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andMainBusIn(List<String> values) {
            this.addCriterion("main_bus in", values, "mainBus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMainBusNotIn(List<String> values) {
            this.addCriterion("main_bus not in", values, "mainBus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMainBusBetween(String value1, String value2) {
            this.addCriterion("main_bus between", value1, value2, "mainBus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMainBusNotBetween(String value1, String value2) {
            this.addCriterion("main_bus not between", value1, value2, "mainBus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNickIsNull() {
            this.addCriterion("nick is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNickIsNotNull() {
            this.addCriterion("nick is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNickEqualTo(String value) {
            this.addCriterion("nick =", value, "nick");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNickNotEqualTo(String value) {
            this.addCriterion("nick <>", value, "nick");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNickGreaterThan(String value) {
            this.addCriterion("nick >", value, "nick");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNickGreaterThanOrEqualTo(String value) {
            this.addCriterion("nick >=", value, "nick");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNickLessThan(String value) {
            this.addCriterion("nick <", value, "nick");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNickLessThanOrEqualTo(String value) {
            this.addCriterion("nick <=", value, "nick");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNickLike(String value) {
            this.addCriterion("nick like", value, "nick");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNickNotLike(String value) {
            this.addCriterion("nick not like", value, "nick");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andNickIn(List<String> values) {
            this.addCriterion("nick in", values, "nick");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNickNotIn(List<String> values) {
            this.addCriterion("nick not in", values, "nick");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNickBetween(String value1, String value2) {
            this.addCriterion("nick between", value1, value2, "nick");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNickNotBetween(String value1, String value2) {
            this.addCriterion("nick not between", value1, value2, "nick");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBuycityIdIsNull() {
            this.addCriterion("buycity_id is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBuycityIdIsNotNull() {
            this.addCriterion("buycity_id is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBuycityIdEqualTo(Long value) {
            this.addCriterion("buycity_id =", value, "buycityId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBuycityIdNotEqualTo(Long value) {
            this.addCriterion("buycity_id <>", value, "buycityId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBuycityIdGreaterThan(Long value) {
            this.addCriterion("buycity_id >", value, "buycityId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBuycityIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("buycity_id >=", value, "buycityId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBuycityIdLessThan(Long value) {
            this.addCriterion("buycity_id <", value, "buycityId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBuycityIdLessThanOrEqualTo(Long value) {
            this.addCriterion("buycity_id <=", value, "buycityId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBuycityIdLike(String value) {
            this.addCriterion("buycity_id like", value, "buycityId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBuycityIdNotLike(String value) {
            this.addCriterion("buycity_id not like", value, "buycityId");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andBuycityIdIn(List<Long> values) {
            this.addCriterion("buycity_id in", values, "buycityId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBuycityIdNotIn(List<Long> values) {
            this.addCriterion("buycity_id not in", values, "buycityId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBuycityIdBetween(Long value1, Long value2) {
            this.addCriterion("buycity_id between", value1, value2, "buycityId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBuycityIdNotBetween(Long value1, Long value2) {
            this.addCriterion("buycity_id not between", value1, value2, "buycityId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketIdIsNull() {
            this.addCriterion("market_id is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketIdIsNotNull() {
            this.addCriterion("market_id is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketIdEqualTo(Long value) {
            this.addCriterion("market_id =", value, "marketId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketIdNotEqualTo(Long value) {
            this.addCriterion("market_id <>", value, "marketId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketIdGreaterThan(Long value) {
            this.addCriterion("market_id >", value, "marketId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("market_id >=", value, "marketId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketIdLessThan(Long value) {
            this.addCriterion("market_id <", value, "marketId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            this.addCriterion("market_id <=", value, "marketId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketIdLike(String value) {
            this.addCriterion("market_id like", value, "marketId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketIdNotLike(String value) {
            this.addCriterion("market_id not like", value, "marketId");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andMarketIdIn(List<Long> values) {
            this.addCriterion("market_id in", values, "marketId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketIdNotIn(List<Long> values) {
            this.addCriterion("market_id not in", values, "marketId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            this.addCriterion("market_id between", value1, value2, "marketId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            this.addCriterion("market_id not between", value1, value2, "marketId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketIsNull() {
            this.addCriterion("market is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketIsNotNull() {
            this.addCriterion("market is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketEqualTo(String value) {
            this.addCriterion("market =", value, "market");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketNotEqualTo(String value) {
            this.addCriterion("market <>", value, "market");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketGreaterThan(String value) {
            this.addCriterion("market >", value, "market");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketGreaterThanOrEqualTo(String value) {
            this.addCriterion("market >=", value, "market");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketLessThan(String value) {
            this.addCriterion("market <", value, "market");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketLessThanOrEqualTo(String value) {
            this.addCriterion("market <=", value, "market");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketLike(String value) {
            this.addCriterion("market like", value, "market");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketNotLike(String value) {
            this.addCriterion("market not like", value, "market");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andMarketIn(List<String> values) {
            this.addCriterion("market in", values, "market");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketNotIn(List<String> values) {
            this.addCriterion("market not in", values, "market");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketBetween(String value1, String value2) {
            this.addCriterion("market between", value1, value2, "market");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andMarketNotBetween(String value1, String value2) {
            this.addCriterion("market not between", value1, value2, "market");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketIdIsNull() {
            this.addCriterion("parent_market_id is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketIdIsNotNull() {
            this.addCriterion("parent_market_id is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketIdEqualTo(Long value) {
            this.addCriterion("parent_market_id =", value, "parentMarketId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketIdNotEqualTo(Long value) {
            this.addCriterion("parent_market_id <>", value, "parentMarketId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketIdGreaterThan(Long value) {
            this.addCriterion("parent_market_id >", value, "parentMarketId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("parent_market_id >=", value, "parentMarketId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketIdLessThan(Long value) {
            this.addCriterion("parent_market_id <", value, "parentMarketId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketIdLessThanOrEqualTo(Long value) {
            this.addCriterion("parent_market_id <=", value, "parentMarketId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketIdLike(String value) {
            this.addCriterion("parent_market_id like", value, "parentMarketId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketIdNotLike(String value) {
            this.addCriterion("parent_market_id not like", value, "parentMarketId");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andParentMarketIdIn(List<Long> values) {
            this.addCriterion("parent_market_id in", values, "parentMarketId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketIdNotIn(List<Long> values) {
            this.addCriterion("parent_market_id not in", values, "parentMarketId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketIdBetween(Long value1, Long value2) {
            this.addCriterion("parent_market_id between", value1, value2, "parentMarketId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketIdNotBetween(Long value1, Long value2) {
            this.addCriterion("parent_market_id not between", value1, value2, "parentMarketId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketIsNull() {
            this.addCriterion("parent_market is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketIsNotNull() {
            this.addCriterion("parent_market is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketEqualTo(String value) {
            this.addCriterion("parent_market =", value, "parentMarket");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketNotEqualTo(String value) {
            this.addCriterion("parent_market <>", value, "parentMarket");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketGreaterThan(String value) {
            this.addCriterion("parent_market >", value, "parentMarket");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketGreaterThanOrEqualTo(String value) {
            this.addCriterion("parent_market >=", value, "parentMarket");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketLessThan(String value) {
            this.addCriterion("parent_market <", value, "parentMarket");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketLessThanOrEqualTo(String value) {
            this.addCriterion("parent_market <=", value, "parentMarket");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketLike(String value) {
            this.addCriterion("parent_market like", value, "parentMarket");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketNotLike(String value) {
            this.addCriterion("parent_market not like", value, "parentMarket");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andParentMarketIn(List<String> values) {
            this.addCriterion("parent_market in", values, "parentMarket");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketNotIn(List<String> values) {
            this.addCriterion("parent_market not in", values, "parentMarket");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketBetween(String value1, String value2) {
            this.addCriterion("parent_market between", value1, value2, "parentMarket");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andParentMarketNotBetween(String value1, String value2) {
            this.addCriterion("parent_market not between", value1, value2, "parentMarket");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTodayGoodsnumIsNull() {
            this.addCriterion("today_goodsnum is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTodayGoodsnumIsNotNull() {
            this.addCriterion("today_goodsnum is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTodayGoodsnumEqualTo(Long value) {
            this.addCriterion("today_goodsnum =", value, "todayGoodsnum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTodayGoodsnumNotEqualTo(Long value) {
            this.addCriterion("today_goodsnum <>", value, "todayGoodsnum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTodayGoodsnumGreaterThan(Long value) {
            this.addCriterion("today_goodsnum >", value, "todayGoodsnum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTodayGoodsnumGreaterThanOrEqualTo(Long value) {
            this.addCriterion("today_goodsnum >=", value, "todayGoodsnum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTodayGoodsnumLessThan(Long value) {
            this.addCriterion("today_goodsnum <", value, "todayGoodsnum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTodayGoodsnumLessThanOrEqualTo(Long value) {
            this.addCriterion("today_goodsnum <=", value, "todayGoodsnum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTodayGoodsnumLike(String value) {
            this.addCriterion("today_goodsnum like", value, "todayGoodsnum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTodayGoodsnumNotLike(String value) {
            this.addCriterion("today_goodsnum not like", value, "todayGoodsnum");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andTodayGoodsnumIn(List<Long> values) {
            this.addCriterion("today_goodsnum in", values, "todayGoodsnum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTodayGoodsnumNotIn(List<Long> values) {
            this.addCriterion("today_goodsnum not in", values, "todayGoodsnum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTodayGoodsnumBetween(Long value1, Long value2) {
            this.addCriterion("today_goodsnum between", value1, value2, "todayGoodsnum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTodayGoodsnumNotBetween(Long value1, Long value2) {
            this.addCriterion("today_goodsnum not between", value1, value2, "todayGoodsnum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastGoodsDateIsNull() {
            this.addCriterion("last_goods_date is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastGoodsDateIsNotNull() {
            this.addCriterion("last_goods_date is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastGoodsDateEqualTo(Date value) {
            this.addCriterion("last_goods_date =", value, "lastGoodsDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastGoodsDateNotEqualTo(Date value) {
            this.addCriterion("last_goods_date <>", value, "lastGoodsDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastGoodsDateGreaterThan(Date value) {
            this.addCriterion("last_goods_date >", value, "lastGoodsDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastGoodsDateGreaterThanOrEqualTo(Date value) {
            this.addCriterion("last_goods_date >=", value, "lastGoodsDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastGoodsDateLessThan(Date value) {
            this.addCriterion("last_goods_date <", value, "lastGoodsDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastGoodsDateLessThanOrEqualTo(Date value) {
            this.addCriterion("last_goods_date <=", value, "lastGoodsDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastGoodsDateLike(String value) {
            this.addCriterion("last_goods_date like", value, "lastGoodsDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastGoodsDateNotLike(String value) {
            this.addCriterion("last_goods_date not like", value, "lastGoodsDate");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andLastGoodsDateIn(List<Date> values) {
            this.addCriterion("last_goods_date in", values, "lastGoodsDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastGoodsDateNotIn(List<Date> values) {
            this.addCriterion("last_goods_date not in", values, "lastGoodsDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastGoodsDateBetween(Date value1, Date value2) {
            this.addCriterion("last_goods_date between", value1, value2, "lastGoodsDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastGoodsDateNotBetween(Date value1, Date value2) {
            this.addCriterion("last_goods_date not between", value1, value2, "lastGoodsDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceRoleIsNull() {
            this.addCriterion("price_role is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceRoleIsNotNull() {
            this.addCriterion("price_role is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceRoleEqualTo(String value) {
            this.addCriterion("price_role =", value, "priceRole");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceRoleNotEqualTo(String value) {
            this.addCriterion("price_role <>", value, "priceRole");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceRoleGreaterThan(String value) {
            this.addCriterion("price_role >", value, "priceRole");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceRoleGreaterThanOrEqualTo(String value) {
            this.addCriterion("price_role >=", value, "priceRole");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceRoleLessThan(String value) {
            this.addCriterion("price_role <", value, "priceRole");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceRoleLessThanOrEqualTo(String value) {
            this.addCriterion("price_role <=", value, "priceRole");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceRoleLike(String value) {
            this.addCriterion("price_role like", value, "priceRole");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceRoleNotLike(String value) {
            this.addCriterion("price_role not like", value, "priceRole");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andPriceRoleIn(List<String> values) {
            this.addCriterion("price_role in", values, "priceRole");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceRoleNotIn(List<String> values) {
            this.addCriterion("price_role not in", values, "priceRole");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceRoleBetween(String value1, String value2) {
            this.addCriterion("price_role between", value1, value2, "priceRole");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceRoleNotBetween(String value1, String value2) {
            this.addCriterion("price_role not between", value1, value2, "priceRole");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNumIsNull() {
            this.addCriterion("store_num is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNumIsNotNull() {
            this.addCriterion("store_num is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNumEqualTo(String value) {
            this.addCriterion("store_num =", value, "storeNum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNumNotEqualTo(String value) {
            this.addCriterion("store_num <>", value, "storeNum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNumGreaterThan(String value) {
            this.addCriterion("store_num >", value, "storeNum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNumGreaterThanOrEqualTo(String value) {
            this.addCriterion("store_num >=", value, "storeNum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNumLessThan(String value) {
            this.addCriterion("store_num <", value, "storeNum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNumLessThanOrEqualTo(String value) {
            this.addCriterion("store_num <=", value, "storeNum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNumLike(String value) {
            this.addCriterion("store_num like", value, "storeNum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNumNotLike(String value) {
            this.addCriterion("store_num not like", value, "storeNum");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andStoreNumIn(List<String> values) {
            this.addCriterion("store_num in", values, "storeNum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNumNotIn(List<String> values) {
            this.addCriterion("store_num not in", values, "storeNum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNumBetween(String value1, String value2) {
            this.addCriterion("store_num between", value1, value2, "storeNum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreNumNotBetween(String value1, String value2) {
            this.addCriterion("store_num not between", value1, value2, "storeNum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andAddressIsNull() {
            this.addCriterion("address is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andAddressIsNotNull() {
            this.addCriterion("address is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andAddressEqualTo(String value) {
            this.addCriterion("address =", value, "address");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andAddressNotEqualTo(String value) {
            this.addCriterion("address <>", value, "address");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andAddressGreaterThan(String value) {
            this.addCriterion("address >", value, "address");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andAddressGreaterThanOrEqualTo(String value) {
            this.addCriterion("address >=", value, "address");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andAddressLessThan(String value) {
            this.addCriterion("address <", value, "address");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andAddressLessThanOrEqualTo(String value) {
            this.addCriterion("address <=", value, "address");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andAddressLike(String value) {
            this.addCriterion("address like", value, "address");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andAddressNotLike(String value) {
            this.addCriterion("address not like", value, "address");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andAddressIn(List<String> values) {
            this.addCriterion("address in", values, "address");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andAddressNotIn(List<String> values) {
            this.addCriterion("address not in", values, "address");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andAddressBetween(String value1, String value2) {
            this.addCriterion("address between", value1, value2, "address");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andAddressNotBetween(String value1, String value2) {
            this.addCriterion("address not between", value1, value2, "address");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andZipcodeIsNull() {
            this.addCriterion("zipcode is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andZipcodeIsNotNull() {
            this.addCriterion("zipcode is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andZipcodeEqualTo(String value) {
            this.addCriterion("zipcode =", value, "zipcode");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andZipcodeNotEqualTo(String value) {
            this.addCriterion("zipcode <>", value, "zipcode");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andZipcodeGreaterThan(String value) {
            this.addCriterion("zipcode >", value, "zipcode");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andZipcodeGreaterThanOrEqualTo(String value) {
            this.addCriterion("zipcode >=", value, "zipcode");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andZipcodeLessThan(String value) {
            this.addCriterion("zipcode <", value, "zipcode");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andZipcodeLessThanOrEqualTo(String value) {
            this.addCriterion("zipcode <=", value, "zipcode");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andZipcodeLike(String value) {
            this.addCriterion("zipcode like", value, "zipcode");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andZipcodeNotLike(String value) {
            this.addCriterion("zipcode not like", value, "zipcode");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andZipcodeIn(List<String> values) {
            this.addCriterion("zipcode in", values, "zipcode");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andZipcodeNotIn(List<String> values) {
            this.addCriterion("zipcode not in", values, "zipcode");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andZipcodeBetween(String value1, String value2) {
            this.addCriterion("zipcode between", value1, value2, "zipcode");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andZipcodeNotBetween(String value1, String value2) {
            this.addCriterion("zipcode not between", value1, value2, "zipcode");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTelephoneIsNull() {
            this.addCriterion("telephone is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTelephoneIsNotNull() {
            this.addCriterion("telephone is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTelephoneEqualTo(String value) {
            this.addCriterion("telephone =", value, "telephone");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTelephoneNotEqualTo(String value) {
            this.addCriterion("telephone <>", value, "telephone");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTelephoneGreaterThan(String value) {
            this.addCriterion("telephone >", value, "telephone");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            this.addCriterion("telephone >=", value, "telephone");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTelephoneLessThan(String value) {
            this.addCriterion("telephone <", value, "telephone");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTelephoneLessThanOrEqualTo(String value) {
            this.addCriterion("telephone <=", value, "telephone");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTelephoneLike(String value) {
            this.addCriterion("telephone like", value, "telephone");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTelephoneNotLike(String value) {
            this.addCriterion("telephone not like", value, "telephone");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andTelephoneIn(List<String> values) {
            this.addCriterion("telephone in", values, "telephone");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTelephoneNotIn(List<String> values) {
            this.addCriterion("telephone not in", values, "telephone");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTelephoneBetween(String value1, String value2) {
            this.addCriterion("telephone between", value1, value2, "telephone");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTelephoneNotBetween(String value1, String value2) {
            this.addCriterion("telephone not between", value1, value2, "telephone");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneIsNull() {
            this.addCriterion("phone is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneIsNotNull() {
            this.addCriterion("phone is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneEqualTo(String value) {
            this.addCriterion("phone =", value, "phone");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneNotEqualTo(String value) {
            this.addCriterion("phone <>", value, "phone");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneGreaterThan(String value) {
            this.addCriterion("phone >", value, "phone");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneGreaterThanOrEqualTo(String value) {
            this.addCriterion("phone >=", value, "phone");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneLessThan(String value) {
            this.addCriterion("phone <", value, "phone");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneLessThanOrEqualTo(String value) {
            this.addCriterion("phone <=", value, "phone");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneLike(String value) {
            this.addCriterion("phone like", value, "phone");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneNotLike(String value) {
            this.addCriterion("phone not like", value, "phone");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andPhoneIn(List<String> values) {
            this.addCriterion("phone in", values, "phone");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneNotIn(List<String> values) {
            this.addCriterion("phone not in", values, "phone");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneBetween(String value1, String value2) {
            this.addCriterion("phone between", value1, value2, "phone");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneNotBetween(String value1, String value2) {
            this.addCriterion("phone not between", value1, value2, "phone");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImQqIsNull() {
            this.addCriterion("im_qq is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImQqIsNotNull() {
            this.addCriterion("im_qq is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImQqEqualTo(String value) {
            this.addCriterion("im_qq =", value, "imQq");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImQqNotEqualTo(String value) {
            this.addCriterion("im_qq <>", value, "imQq");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImQqGreaterThan(String value) {
            this.addCriterion("im_qq >", value, "imQq");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImQqGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_qq >=", value, "imQq");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImQqLessThan(String value) {
            this.addCriterion("im_qq <", value, "imQq");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImQqLessThanOrEqualTo(String value) {
            this.addCriterion("im_qq <=", value, "imQq");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImQqLike(String value) {
            this.addCriterion("im_qq like", value, "imQq");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImQqNotLike(String value) {
            this.addCriterion("im_qq not like", value, "imQq");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andImQqIn(List<String> values) {
            this.addCriterion("im_qq in", values, "imQq");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImQqNotIn(List<String> values) {
            this.addCriterion("im_qq not in", values, "imQq");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImQqBetween(String value1, String value2) {
            this.addCriterion("im_qq between", value1, value2, "imQq");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImQqNotBetween(String value1, String value2) {
            this.addCriterion("im_qq not between", value1, value2, "imQq");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImAliwwIsNull() {
            this.addCriterion("im_aliww is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImAliwwIsNotNull() {
            this.addCriterion("im_aliww is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImAliwwEqualTo(String value) {
            this.addCriterion("im_aliww =", value, "imAliww");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImAliwwNotEqualTo(String value) {
            this.addCriterion("im_aliww <>", value, "imAliww");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImAliwwGreaterThan(String value) {
            this.addCriterion("im_aliww >", value, "imAliww");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImAliwwGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_aliww >=", value, "imAliww");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImAliwwLessThan(String value) {
            this.addCriterion("im_aliww <", value, "imAliww");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImAliwwLessThanOrEqualTo(String value) {
            this.addCriterion("im_aliww <=", value, "imAliww");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImAliwwLike(String value) {
            this.addCriterion("im_aliww like", value, "imAliww");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImAliwwNotLike(String value) {
            this.addCriterion("im_aliww not like", value, "imAliww");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andImAliwwIn(List<String> values) {
            this.addCriterion("im_aliww in", values, "imAliww");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImAliwwNotIn(List<String> values) {
            this.addCriterion("im_aliww not in", values, "imAliww");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImAliwwBetween(String value1, String value2) {
            this.addCriterion("im_aliww between", value1, value2, "imAliww");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andImAliwwNotBetween(String value1, String value2) {
            this.addCriterion("im_aliww not between", value1, value2, "imAliww");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andInfoFromIsNull() {
            this.addCriterion("info_from is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andInfoFromIsNotNull() {
            this.addCriterion("info_from is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andInfoFromEqualTo(String value) {
            this.addCriterion("info_from =", value, "infoFrom");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andInfoFromNotEqualTo(String value) {
            this.addCriterion("info_from <>", value, "infoFrom");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andInfoFromGreaterThan(String value) {
            this.addCriterion("info_from >", value, "infoFrom");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andInfoFromGreaterThanOrEqualTo(String value) {
            this.addCriterion("info_from >=", value, "infoFrom");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andInfoFromLessThan(String value) {
            this.addCriterion("info_from <", value, "infoFrom");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andInfoFromLessThanOrEqualTo(String value) {
            this.addCriterion("info_from <=", value, "infoFrom");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andInfoFromLike(String value) {
            this.addCriterion("info_from like", value, "infoFrom");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andInfoFromNotLike(String value) {
            this.addCriterion("info_from not like", value, "infoFrom");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andInfoFromIn(List<String> values) {
            this.addCriterion("info_from in", values, "infoFrom");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andInfoFromNotIn(List<String> values) {
            this.addCriterion("info_from not in", values, "infoFrom");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andInfoFromBetween(String value1, String value2) {
            this.addCriterion("info_from between", value1, value2, "infoFrom");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andInfoFromNotBetween(String value1, String value2) {
            this.addCriterion("info_from not between", value1, value2, "infoFrom");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andServersIsNull() {
            this.addCriterion("servers is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andServersIsNotNull() {
            this.addCriterion("servers is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andServersEqualTo(String value) {
            this.addCriterion("servers =", value, "servers");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andServersNotEqualTo(String value) {
            this.addCriterion("servers <>", value, "servers");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andServersGreaterThan(String value) {
            this.addCriterion("servers >", value, "servers");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andServersGreaterThanOrEqualTo(String value) {
            this.addCriterion("servers >=", value, "servers");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andServersLessThan(String value) {
            this.addCriterion("servers <", value, "servers");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andServersLessThanOrEqualTo(String value) {
            this.addCriterion("servers <=", value, "servers");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andServersLike(String value) {
            this.addCriterion("servers like", value, "servers");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andServersNotLike(String value) {
            this.addCriterion("servers not like", value, "servers");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andServersIn(List<String> values) {
            this.addCriterion("servers in", values, "servers");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andServersNotIn(List<String> values) {
            this.addCriterion("servers not in", values, "servers");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andServersBetween(String value1, String value2) {
            this.addCriterion("servers between", value1, value2, "servers");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andServersNotBetween(String value1, String value2) {
            this.addCriterion("servers not between", value1, value2, "servers");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andDomainIsNull() {
            this.addCriterion("domain is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andDomainIsNotNull() {
            this.addCriterion("domain is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andDomainEqualTo(String value) {
            this.addCriterion("domain =", value, "domain");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andDomainNotEqualTo(String value) {
            this.addCriterion("domain <>", value, "domain");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andDomainGreaterThan(String value) {
            this.addCriterion("domain >", value, "domain");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andDomainGreaterThanOrEqualTo(String value) {
            this.addCriterion("domain >=", value, "domain");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andDomainLessThan(String value) {
            this.addCriterion("domain <", value, "domain");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andDomainLessThanOrEqualTo(String value) {
            this.addCriterion("domain <=", value, "domain");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andDomainLike(String value) {
            this.addCriterion("domain like", value, "domain");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andDomainNotLike(String value) {
            this.addCriterion("domain not like", value, "domain");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andDomainIn(List<String> values) {
            this.addCriterion("domain in", values, "domain");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andDomainNotIn(List<String> values) {
            this.addCriterion("domain not in", values, "domain");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andDomainBetween(String value1, String value2) {
            this.addCriterion("domain between", value1, value2, "domain");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andDomainNotBetween(String value1, String value2) {
            this.addCriterion("domain not between", value1, value2, "domain");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreErweiIsNull() {
            this.addCriterion("store_erwei is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreErweiIsNotNull() {
            this.addCriterion("store_erwei is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreErweiEqualTo(String value) {
            this.addCriterion("store_erwei =", value, "storeErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreErweiNotEqualTo(String value) {
            this.addCriterion("store_erwei <>", value, "storeErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreErweiGreaterThan(String value) {
            this.addCriterion("store_erwei >", value, "storeErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreErweiGreaterThanOrEqualTo(String value) {
            this.addCriterion("store_erwei >=", value, "storeErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreErweiLessThan(String value) {
            this.addCriterion("store_erwei <", value, "storeErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreErweiLessThanOrEqualTo(String value) {
            this.addCriterion("store_erwei <=", value, "storeErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreErweiLike(String value) {
            this.addCriterion("store_erwei like", value, "storeErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreErweiNotLike(String value) {
            this.addCriterion("store_erwei not like", value, "storeErwei");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andStoreErweiIn(List<String> values) {
            this.addCriterion("store_erwei in", values, "storeErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreErweiNotIn(List<String> values) {
            this.addCriterion("store_erwei not in", values, "storeErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreErweiBetween(String value1, String value2) {
            this.addCriterion("store_erwei between", value1, value2, "storeErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreErweiNotBetween(String value1, String value2) {
            this.addCriterion("store_erwei not between", value1, value2, "storeErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneErweiIsNull() {
            this.addCriterion("phone_erwei is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneErweiIsNotNull() {
            this.addCriterion("phone_erwei is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneErweiEqualTo(String value) {
            this.addCriterion("phone_erwei =", value, "phoneErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneErweiNotEqualTo(String value) {
            this.addCriterion("phone_erwei <>", value, "phoneErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneErweiGreaterThan(String value) {
            this.addCriterion("phone_erwei >", value, "phoneErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneErweiGreaterThanOrEqualTo(String value) {
            this.addCriterion("phone_erwei >=", value, "phoneErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneErweiLessThan(String value) {
            this.addCriterion("phone_erwei <", value, "phoneErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneErweiLessThanOrEqualTo(String value) {
            this.addCriterion("phone_erwei <=", value, "phoneErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneErweiLike(String value) {
            this.addCriterion("phone_erwei like", value, "phoneErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneErweiNotLike(String value) {
            this.addCriterion("phone_erwei not like", value, "phoneErwei");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andPhoneErweiIn(List<String> values) {
            this.addCriterion("phone_erwei in", values, "phoneErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneErweiNotIn(List<String> values) {
            this.addCriterion("phone_erwei not in", values, "phoneErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneErweiBetween(String value1, String value2) {
            this.addCriterion("phone_erwei between", value1, value2, "phoneErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPhoneErweiNotBetween(String value1, String value2) {
            this.addCriterion("phone_erwei not between", value1, value2, "phoneErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPcErweiIsNull() {
            this.addCriterion("pc_erwei is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPcErweiIsNotNull() {
            this.addCriterion("pc_erwei is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPcErweiEqualTo(String value) {
            this.addCriterion("pc_erwei =", value, "pcErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPcErweiNotEqualTo(String value) {
            this.addCriterion("pc_erwei <>", value, "pcErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPcErweiGreaterThan(String value) {
            this.addCriterion("pc_erwei >", value, "pcErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPcErweiGreaterThanOrEqualTo(String value) {
            this.addCriterion("pc_erwei >=", value, "pcErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPcErweiLessThan(String value) {
            this.addCriterion("pc_erwei <", value, "pcErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPcErweiLessThanOrEqualTo(String value) {
            this.addCriterion("pc_erwei <=", value, "pcErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPcErweiLike(String value) {
            this.addCriterion("pc_erwei like", value, "pcErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPcErweiNotLike(String value) {
            this.addCriterion("pc_erwei not like", value, "pcErwei");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andPcErweiIn(List<String> values) {
            this.addCriterion("pc_erwei in", values, "pcErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPcErweiNotIn(List<String> values) {
            this.addCriterion("pc_erwei not in", values, "pcErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPcErweiBetween(String value1, String value2) {
            this.addCriterion("pc_erwei between", value1, value2, "pcErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPcErweiNotBetween(String value1, String value2) {
            this.addCriterion("pc_erwei not between", value1, value2, "pcErwei");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserNameIsNull() {
            this.addCriterion("user_name is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserNameIsNotNull() {
            this.addCriterion("user_name is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserNameEqualTo(String value) {
            this.addCriterion("user_name =", value, "userName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserNameNotEqualTo(String value) {
            this.addCriterion("user_name <>", value, "userName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserNameGreaterThan(String value) {
            this.addCriterion("user_name >", value, "userName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("user_name >=", value, "userName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserNameLessThan(String value) {
            this.addCriterion("user_name <", value, "userName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserNameLessThanOrEqualTo(String value) {
            this.addCriterion("user_name <=", value, "userName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserNameLike(String value) {
            this.addCriterion("user_name like", value, "userName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserNameNotLike(String value) {
            this.addCriterion("user_name not like", value, "userName");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andUserNameIn(List<String> values) {
            this.addCriterion("user_name in", values, "userName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserNameNotIn(List<String> values) {
            this.addCriterion("user_name not in", values, "userName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserNameBetween(String value1, String value2) {
            this.addCriterion("user_name between", value1, value2, "userName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUserNameNotBetween(String value1, String value2) {
            this.addCriterion("user_name not between", value1, value2, "userName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUseStatusIsNull() {
            this.addCriterion("use_status is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUseStatusIsNotNull() {
            this.addCriterion("use_status is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUseStatusEqualTo(Integer value) {
            this.addCriterion("use_status =", value, "useStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUseStatusNotEqualTo(Integer value) {
            this.addCriterion("use_status <>", value, "useStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUseStatusGreaterThan(Integer value) {
            this.addCriterion("use_status >", value, "useStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("use_status >=", value, "useStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUseStatusLessThan(Integer value) {
            this.addCriterion("use_status <", value, "useStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("use_status <=", value, "useStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUseStatusLike(String value) {
            this.addCriterion("use_status like", value, "useStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUseStatusNotLike(String value) {
            this.addCriterion("use_status not like", value, "useStatus");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andUseStatusIn(List<Integer> values) {
            this.addCriterion("use_status in", values, "useStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUseStatusNotIn(List<Integer> values) {
            this.addCriterion("use_status not in", values, "useStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUseStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("use_status between", value1, value2, "useStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("use_status not between", value1, value2, "useStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNoCheckReasonIsNull() {
            this.addCriterion("no_check_reason is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNoCheckReasonIsNotNull() {
            this.addCriterion("no_check_reason is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNoCheckReasonEqualTo(String value) {
            this.addCriterion("no_check_reason =", value, "noCheckReason");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNoCheckReasonNotEqualTo(String value) {
            this.addCriterion("no_check_reason <>", value, "noCheckReason");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNoCheckReasonGreaterThan(String value) {
            this.addCriterion("no_check_reason >", value, "noCheckReason");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNoCheckReasonGreaterThanOrEqualTo(String value) {
            this.addCriterion("no_check_reason >=", value, "noCheckReason");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNoCheckReasonLessThan(String value) {
            this.addCriterion("no_check_reason <", value, "noCheckReason");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNoCheckReasonLessThanOrEqualTo(String value) {
            this.addCriterion("no_check_reason <=", value, "noCheckReason");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNoCheckReasonLike(String value) {
            this.addCriterion("no_check_reason like", value, "noCheckReason");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNoCheckReasonNotLike(String value) {
            this.addCriterion("no_check_reason not like", value, "noCheckReason");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andNoCheckReasonIn(List<String> values) {
            this.addCriterion("no_check_reason in", values, "noCheckReason");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNoCheckReasonNotIn(List<String> values) {
            this.addCriterion("no_check_reason not in", values, "noCheckReason");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNoCheckReasonBetween(String value1, String value2) {
            this.addCriterion("no_check_reason between", value1, value2, "noCheckReason");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andNoCheckReasonNotBetween(String value1, String value2) {
            this.addCriterion("no_check_reason not between", value1, value2, "noCheckReason");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindTimeIsNull() {
            this.addCriterion("bind_time is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindTimeIsNotNull() {
            this.addCriterion("bind_time is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindTimeEqualTo(Date value) {
            this.addCriterion("bind_time =", value, "bindTime");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindTimeNotEqualTo(Date value) {
            this.addCriterion("bind_time <>", value, "bindTime");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindTimeGreaterThan(Date value) {
            this.addCriterion("bind_time >", value, "bindTime");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("bind_time >=", value, "bindTime");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindTimeLessThan(Date value) {
            this.addCriterion("bind_time <", value, "bindTime");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("bind_time <=", value, "bindTime");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindTimeLike(String value) {
            this.addCriterion("bind_time like", value, "bindTime");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindTimeNotLike(String value) {
            this.addCriterion("bind_time not like", value, "bindTime");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andBindTimeIn(List<Date> values) {
            this.addCriterion("bind_time in", values, "bindTime");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindTimeNotIn(List<Date> values) {
            this.addCriterion("bind_time not in", values, "bindTime");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindTimeBetween(Date value1, Date value2) {
            this.addCriterion("bind_time between", value1, value2, "bindTime");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("bind_time not between", value1, value2, "bindTime");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindStatusIsNull() {
            this.addCriterion("bind_status is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindStatusIsNotNull() {
            this.addCriterion("bind_status is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindStatusEqualTo(Integer value) {
            this.addCriterion("bind_status =", value, "bindStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindStatusNotEqualTo(Integer value) {
            this.addCriterion("bind_status <>", value, "bindStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindStatusGreaterThan(Integer value) {
            this.addCriterion("bind_status >", value, "bindStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("bind_status >=", value, "bindStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindStatusLessThan(Integer value) {
            this.addCriterion("bind_status <", value, "bindStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("bind_status <=", value, "bindStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindStatusLike(String value) {
            this.addCriterion("bind_status like", value, "bindStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindStatusNotLike(String value) {
            this.addCriterion("bind_status not like", value, "bindStatus");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andBindStatusIn(List<Integer> values) {
            this.addCriterion("bind_status in", values, "bindStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindStatusNotIn(List<Integer> values) {
            this.addCriterion("bind_status not in", values, "bindStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("bind_status between", value1, value2, "bindStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBindStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("bind_status not between", value1, value2, "bindStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andVisitSumIsNull() {
            this.addCriterion("visit_sum is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andVisitSumIsNotNull() {
            this.addCriterion("visit_sum is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andVisitSumEqualTo(Long value) {
            this.addCriterion("visit_sum =", value, "visitSum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andVisitSumNotEqualTo(Long value) {
            this.addCriterion("visit_sum <>", value, "visitSum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andVisitSumGreaterThan(Long value) {
            this.addCriterion("visit_sum >", value, "visitSum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andVisitSumGreaterThanOrEqualTo(Long value) {
            this.addCriterion("visit_sum >=", value, "visitSum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andVisitSumLessThan(Long value) {
            this.addCriterion("visit_sum <", value, "visitSum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andVisitSumLessThanOrEqualTo(Long value) {
            this.addCriterion("visit_sum <=", value, "visitSum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andVisitSumLike(String value) {
            this.addCriterion("visit_sum like", value, "visitSum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andVisitSumNotLike(String value) {
            this.addCriterion("visit_sum not like", value, "visitSum");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andVisitSumIn(List<Long> values) {
            this.addCriterion("visit_sum in", values, "visitSum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andVisitSumNotIn(List<Long> values) {
            this.addCriterion("visit_sum not in", values, "visitSum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andVisitSumBetween(Long value1, Long value2) {
            this.addCriterion("visit_sum between", value1, value2, "visitSum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andVisitSumNotBetween(Long value1, Long value2) {
            this.addCriterion("visit_sum not between", value1, value2, "visitSum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreStatusIsNull() {
            this.addCriterion("store_status is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreStatusIsNotNull() {
            this.addCriterion("store_status is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreStatusEqualTo(Integer value) {
            this.addCriterion("store_status =", value, "storeStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreStatusNotEqualTo(Integer value) {
            this.addCriterion("store_status <>", value, "storeStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreStatusGreaterThan(Integer value) {
            this.addCriterion("store_status >", value, "storeStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("store_status >=", value, "storeStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreStatusLessThan(Integer value) {
            this.addCriterion("store_status <", value, "storeStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("store_status <=", value, "storeStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreStatusLike(String value) {
            this.addCriterion("store_status like", value, "storeStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreStatusNotLike(String value) {
            this.addCriterion("store_status not like", value, "storeStatus");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andStoreStatusIn(List<Integer> values) {
            this.addCriterion("store_status in", values, "storeStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreStatusNotIn(List<Integer> values) {
            this.addCriterion("store_status not in", values, "storeStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("store_status between", value1, value2, "storeStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("store_status not between", value1, value2, "storeStatus");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCloseReasonIsNull() {
            this.addCriterion("close_reason is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCloseReasonIsNotNull() {
            this.addCriterion("close_reason is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCloseReasonEqualTo(String value) {
            this.addCriterion("close_reason =", value, "closeReason");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCloseReasonNotEqualTo(String value) {
            this.addCriterion("close_reason <>", value, "closeReason");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCloseReasonGreaterThan(String value) {
            this.addCriterion("close_reason >", value, "closeReason");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCloseReasonGreaterThanOrEqualTo(String value) {
            this.addCriterion("close_reason >=", value, "closeReason");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCloseReasonLessThan(String value) {
            this.addCriterion("close_reason <", value, "closeReason");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCloseReasonLessThanOrEqualTo(String value) {
            this.addCriterion("close_reason <=", value, "closeReason");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCloseReasonLike(String value) {
            this.addCriterion("close_reason like", value, "closeReason");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCloseReasonNotLike(String value) {
            this.addCriterion("close_reason not like", value, "closeReason");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andCloseReasonIn(List<String> values) {
            this.addCriterion("close_reason in", values, "closeReason");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCloseReasonNotIn(List<String> values) {
            this.addCriterion("close_reason not in", values, "closeReason");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCloseReasonBetween(String value1, String value2) {
            this.addCriterion("close_reason between", value1, value2, "closeReason");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCloseReasonNotBetween(String value1, String value2) {
            this.addCriterion("close_reason not between", value1, value2, "closeReason");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCreateDateIsNull() {
            this.addCriterion("create_date is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCreateDateIsNotNull() {
            this.addCriterion("create_date is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCreateDateEqualTo(Date value) {
            this.addCriterion("create_date =", value, "createDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCreateDateNotEqualTo(Date value) {
            this.addCriterion("create_date <>", value, "createDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCreateDateGreaterThan(Date value) {
            this.addCriterion("create_date >", value, "createDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_date >=", value, "createDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCreateDateLessThan(Date value) {
            this.addCriterion("create_date <", value, "createDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCreateDateLessThanOrEqualTo(Date value) {
            this.addCriterion("create_date <=", value, "createDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCreateDateLike(String value) {
            this.addCriterion("create_date like", value, "createDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCreateDateNotLike(String value) {
            this.addCriterion("create_date not like", value, "createDate");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andCreateDateIn(List<Date> values) {
            this.addCriterion("create_date in", values, "createDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCreateDateNotIn(List<Date> values) {
            this.addCriterion("create_date not in", values, "createDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCreateDateBetween(Date value1, Date value2) {
            this.addCriterion("create_date between", value1, value2, "createDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andCreateDateNotBetween(Date value1, Date value2) {
            this.addCriterion("create_date not between", value1, value2, "createDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andEndDateIsNull() {
            this.addCriterion("end_date is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andEndDateIsNotNull() {
            this.addCriterion("end_date is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andEndDateEqualTo(Date value) {
            this.addCriterion("end_date =", value, "endDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andEndDateNotEqualTo(Date value) {
            this.addCriterion("end_date <>", value, "endDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andEndDateGreaterThan(Date value) {
            this.addCriterion("end_date >", value, "endDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            this.addCriterion("end_date >=", value, "endDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andEndDateLessThan(Date value) {
            this.addCriterion("end_date <", value, "endDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andEndDateLessThanOrEqualTo(Date value) {
            this.addCriterion("end_date <=", value, "endDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andEndDateLike(String value) {
            this.addCriterion("end_date like", value, "endDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andEndDateNotLike(String value) {
            this.addCriterion("end_date not like", value, "endDate");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andEndDateIn(List<Date> values) {
            this.addCriterion("end_date in", values, "endDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andEndDateNotIn(List<Date> values) {
            this.addCriterion("end_date not in", values, "endDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andEndDateBetween(Date value1, Date value2) {
            this.addCriterion("end_date between", value1, value2, "endDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andEndDateNotBetween(Date value1, Date value2) {
            this.addCriterion("end_date not between", value1, value2, "endDate");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andSortOrderIsNull() {
            this.addCriterion("sort_order is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andSortOrderIsNotNull() {
            this.addCriterion("sort_order is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andSortOrderEqualTo(Long value) {
            this.addCriterion("sort_order =", value, "sortOrder");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andSortOrderNotEqualTo(Long value) {
            this.addCriterion("sort_order <>", value, "sortOrder");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andSortOrderGreaterThan(Long value) {
            this.addCriterion("sort_order >", value, "sortOrder");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andSortOrderGreaterThanOrEqualTo(Long value) {
            this.addCriterion("sort_order >=", value, "sortOrder");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andSortOrderLessThan(Long value) {
            this.addCriterion("sort_order <", value, "sortOrder");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andSortOrderLessThanOrEqualTo(Long value) {
            this.addCriterion("sort_order <=", value, "sortOrder");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andSortOrderLike(String value) {
            this.addCriterion("sort_order like", value, "sortOrder");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andSortOrderNotLike(String value) {
            this.addCriterion("sort_order not like", value, "sortOrder");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andSortOrderIn(List<Long> values) {
            this.addCriterion("sort_order in", values, "sortOrder");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andSortOrderNotIn(List<Long> values) {
            this.addCriterion("sort_order not in", values, "sortOrder");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andSortOrderBetween(Long value1, Long value2) {
            this.addCriterion("sort_order between", value1, value2, "sortOrder");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andSortOrderNotBetween(Long value1, Long value2) {
            this.addCriterion("sort_order not between", value1, value2, "sortOrder");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoShopIdIsNull() {
            this.addCriterion("taobao_shop_id is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoShopIdIsNotNull() {
            this.addCriterion("taobao_shop_id is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoShopIdEqualTo(Long value) {
            this.addCriterion("taobao_shop_id =", value, "taobaoShopId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoShopIdNotEqualTo(Long value) {
            this.addCriterion("taobao_shop_id <>", value, "taobaoShopId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoShopIdGreaterThan(Long value) {
            this.addCriterion("taobao_shop_id >", value, "taobaoShopId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoShopIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("taobao_shop_id >=", value, "taobaoShopId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoShopIdLessThan(Long value) {
            this.addCriterion("taobao_shop_id <", value, "taobaoShopId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoShopIdLessThanOrEqualTo(Long value) {
            this.addCriterion("taobao_shop_id <=", value, "taobaoShopId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoShopIdLike(String value) {
            this.addCriterion("taobao_shop_id like", value, "taobaoShopId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoShopIdNotLike(String value) {
            this.addCriterion("taobao_shop_id not like", value, "taobaoShopId");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andTaobaoShopIdIn(List<Long> values) {
            this.addCriterion("taobao_shop_id in", values, "taobaoShopId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoShopIdNotIn(List<Long> values) {
            this.addCriterion("taobao_shop_id not in", values, "taobaoShopId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoShopIdBetween(Long value1, Long value2) {
            this.addCriterion("taobao_shop_id between", value1, value2, "taobaoShopId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoShopIdNotBetween(Long value1, Long value2) {
            this.addCriterion("taobao_shop_id not between", value1, value2, "taobaoShopId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUserIdIsNull() {
            this.addCriterion("taobao_user_id is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUserIdIsNotNull() {
            this.addCriterion("taobao_user_id is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUserIdEqualTo(Long value) {
            this.addCriterion("taobao_user_id =", value, "taobaoUserId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUserIdNotEqualTo(Long value) {
            this.addCriterion("taobao_user_id <>", value, "taobaoUserId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUserIdGreaterThan(Long value) {
            this.addCriterion("taobao_user_id >", value, "taobaoUserId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("taobao_user_id >=", value, "taobaoUserId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUserIdLessThan(Long value) {
            this.addCriterion("taobao_user_id <", value, "taobaoUserId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("taobao_user_id <=", value, "taobaoUserId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUserIdLike(String value) {
            this.addCriterion("taobao_user_id like", value, "taobaoUserId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUserIdNotLike(String value) {
            this.addCriterion("taobao_user_id not like", value, "taobaoUserId");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andTaobaoUserIdIn(List<Long> values) {
            this.addCriterion("taobao_user_id in", values, "taobaoUserId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUserIdNotIn(List<Long> values) {
            this.addCriterion("taobao_user_id not in", values, "taobaoUserId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUserIdBetween(Long value1, Long value2) {
            this.addCriterion("taobao_user_id between", value1, value2, "taobaoUserId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("taobao_user_id not between", value1, value2, "taobaoUserId");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoKeyIsNull() {
            this.addCriterion("taobao_key is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoKeyIsNotNull() {
            this.addCriterion("taobao_key is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoKeyEqualTo(String value) {
            this.addCriterion("taobao_key =", value, "taobaoKey");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoKeyNotEqualTo(String value) {
            this.addCriterion("taobao_key <>", value, "taobaoKey");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoKeyGreaterThan(String value) {
            this.addCriterion("taobao_key >", value, "taobaoKey");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoKeyGreaterThanOrEqualTo(String value) {
            this.addCriterion("taobao_key >=", value, "taobaoKey");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoKeyLessThan(String value) {
            this.addCriterion("taobao_key <", value, "taobaoKey");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoKeyLessThanOrEqualTo(String value) {
            this.addCriterion("taobao_key <=", value, "taobaoKey");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoKeyLike(String value) {
            this.addCriterion("taobao_key like", value, "taobaoKey");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoKeyNotLike(String value) {
            this.addCriterion("taobao_key not like", value, "taobaoKey");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andTaobaoKeyIn(List<String> values) {
            this.addCriterion("taobao_key in", values, "taobaoKey");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoKeyNotIn(List<String> values) {
            this.addCriterion("taobao_key not in", values, "taobaoKey");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoKeyBetween(String value1, String value2) {
            this.addCriterion("taobao_key between", value1, value2, "taobaoKey");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoKeyNotBetween(String value1, String value2) {
            this.addCriterion("taobao_key not between", value1, value2, "taobaoKey");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSecIsNull() {
            this.addCriterion("taobao_sec is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSecIsNotNull() {
            this.addCriterion("taobao_sec is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSecEqualTo(String value) {
            this.addCriterion("taobao_sec =", value, "taobaoSec");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSecNotEqualTo(String value) {
            this.addCriterion("taobao_sec <>", value, "taobaoSec");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSecGreaterThan(String value) {
            this.addCriterion("taobao_sec >", value, "taobaoSec");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSecGreaterThanOrEqualTo(String value) {
            this.addCriterion("taobao_sec >=", value, "taobaoSec");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSecLessThan(String value) {
            this.addCriterion("taobao_sec <", value, "taobaoSec");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSecLessThanOrEqualTo(String value) {
            this.addCriterion("taobao_sec <=", value, "taobaoSec");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSecLike(String value) {
            this.addCriterion("taobao_sec like", value, "taobaoSec");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSecNotLike(String value) {
            this.addCriterion("taobao_sec not like", value, "taobaoSec");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andTaobaoSecIn(List<String> values) {
            this.addCriterion("taobao_sec in", values, "taobaoSec");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSecNotIn(List<String> values) {
            this.addCriterion("taobao_sec not in", values, "taobaoSec");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSecBetween(String value1, String value2) {
            this.addCriterion("taobao_sec between", value1, value2, "taobaoSec");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSecNotBetween(String value1, String value2) {
            this.addCriterion("taobao_sec not between", value1, value2, "taobaoSec");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSessionIsNull() {
            this.addCriterion("taobao_session is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSessionIsNotNull() {
            this.addCriterion("taobao_session is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSessionEqualTo(String value) {
            this.addCriterion("taobao_session =", value, "taobaoSession");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSessionNotEqualTo(String value) {
            this.addCriterion("taobao_session <>", value, "taobaoSession");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSessionGreaterThan(String value) {
            this.addCriterion("taobao_session >", value, "taobaoSession");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSessionGreaterThanOrEqualTo(String value) {
            this.addCriterion("taobao_session >=", value, "taobaoSession");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSessionLessThan(String value) {
            this.addCriterion("taobao_session <", value, "taobaoSession");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSessionLessThanOrEqualTo(String value) {
            this.addCriterion("taobao_session <=", value, "taobaoSession");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSessionLike(String value) {
            this.addCriterion("taobao_session like", value, "taobaoSession");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSessionNotLike(String value) {
            this.addCriterion("taobao_session not like", value, "taobaoSession");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andTaobaoSessionIn(List<String> values) {
            this.addCriterion("taobao_session in", values, "taobaoSession");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSessionNotIn(List<String> values) {
            this.addCriterion("taobao_session not in", values, "taobaoSession");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSessionBetween(String value1, String value2) {
            this.addCriterion("taobao_session between", value1, value2, "taobaoSession");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoSessionNotBetween(String value1, String value2) {
            this.addCriterion("taobao_session not between", value1, value2, "taobaoSession");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoNiceIsNull() {
            this.addCriterion("taobao_nice is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoNiceIsNotNull() {
            this.addCriterion("taobao_nice is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoNiceEqualTo(String value) {
            this.addCriterion("taobao_nice =", value, "taobaoNice");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoNiceNotEqualTo(String value) {
            this.addCriterion("taobao_nice <>", value, "taobaoNice");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoNiceGreaterThan(String value) {
            this.addCriterion("taobao_nice >", value, "taobaoNice");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoNiceGreaterThanOrEqualTo(String value) {
            this.addCriterion("taobao_nice >=", value, "taobaoNice");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoNiceLessThan(String value) {
            this.addCriterion("taobao_nice <", value, "taobaoNice");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoNiceLessThanOrEqualTo(String value) {
            this.addCriterion("taobao_nice <=", value, "taobaoNice");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoNiceLike(String value) {
            this.addCriterion("taobao_nice like", value, "taobaoNice");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoNiceNotLike(String value) {
            this.addCriterion("taobao_nice not like", value, "taobaoNice");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andTaobaoNiceIn(List<String> values) {
            this.addCriterion("taobao_nice in", values, "taobaoNice");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoNiceNotIn(List<String> values) {
            this.addCriterion("taobao_nice not in", values, "taobaoNice");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoNiceBetween(String value1, String value2) {
            this.addCriterion("taobao_nice between", value1, value2, "taobaoNice");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andTaobaoNiceNotBetween(String value1, String value2) {
            this.addCriterion("taobao_nice not between", value1, value2, "taobaoNice");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerNameIsNull() {
            this.addCriterion("owner_name is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerNameIsNotNull() {
            this.addCriterion("owner_name is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerNameEqualTo(String value) {
            this.addCriterion("owner_name =", value, "ownerName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerNameNotEqualTo(String value) {
            this.addCriterion("owner_name <>", value, "ownerName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerNameGreaterThan(String value) {
            this.addCriterion("owner_name >", value, "ownerName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("owner_name >=", value, "ownerName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerNameLessThan(String value) {
            this.addCriterion("owner_name <", value, "ownerName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerNameLessThanOrEqualTo(String value) {
            this.addCriterion("owner_name <=", value, "ownerName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerNameLike(String value) {
            this.addCriterion("owner_name like", value, "ownerName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerNameNotLike(String value) {
            this.addCriterion("owner_name not like", value, "ownerName");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andOwnerNameIn(List<String> values) {
            this.addCriterion("owner_name in", values, "ownerName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerNameNotIn(List<String> values) {
            this.addCriterion("owner_name not in", values, "ownerName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerNameBetween(String value1, String value2) {
            this.addCriterion("owner_name between", value1, value2, "ownerName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerNameNotBetween(String value1, String value2) {
            this.addCriterion("owner_name not between", value1, value2, "ownerName");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerCardIsNull() {
            this.addCriterion("owner_card is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerCardIsNotNull() {
            this.addCriterion("owner_card is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerCardEqualTo(String value) {
            this.addCriterion("owner_card =", value, "ownerCard");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerCardNotEqualTo(String value) {
            this.addCriterion("owner_card <>", value, "ownerCard");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerCardGreaterThan(String value) {
            this.addCriterion("owner_card >", value, "ownerCard");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerCardGreaterThanOrEqualTo(String value) {
            this.addCriterion("owner_card >=", value, "ownerCard");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerCardLessThan(String value) {
            this.addCriterion("owner_card <", value, "ownerCard");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerCardLessThanOrEqualTo(String value) {
            this.addCriterion("owner_card <=", value, "ownerCard");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerCardLike(String value) {
            this.addCriterion("owner_card like", value, "ownerCard");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerCardNotLike(String value) {
            this.addCriterion("owner_card not like", value, "ownerCard");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andOwnerCardIn(List<String> values) {
            this.addCriterion("owner_card in", values, "ownerCard");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerCardNotIn(List<String> values) {
            this.addCriterion("owner_card not in", values, "ownerCard");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerCardBetween(String value1, String value2) {
            this.addCriterion("owner_card between", value1, value2, "ownerCard");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andOwnerCardNotBetween(String value1, String value2) {
            this.addCriterion("owner_card not between", value1, value2, "ownerCard");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreModelIsNull() {
            this.addCriterion("store_model is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreModelIsNotNull() {
            this.addCriterion("store_model is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreModelEqualTo(Integer value) {
            this.addCriterion("store_model =", value, "storeModel");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreModelNotEqualTo(Integer value) {
            this.addCriterion("store_model <>", value, "storeModel");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreModelGreaterThan(Integer value) {
            this.addCriterion("store_model >", value, "storeModel");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreModelGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("store_model >=", value, "storeModel");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreModelLessThan(Integer value) {
            this.addCriterion("store_model <", value, "storeModel");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreModelLessThanOrEqualTo(Integer value) {
            this.addCriterion("store_model <=", value, "storeModel");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreModelLike(String value) {
            this.addCriterion("store_model like", value, "storeModel");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreModelNotLike(String value) {
            this.addCriterion("store_model not like", value, "storeModel");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andStoreModelIn(List<Integer> values) {
            this.addCriterion("store_model in", values, "storeModel");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreModelNotIn(List<Integer> values) {
            this.addCriterion("store_model not in", values, "storeModel");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreModelBetween(Integer value1, Integer value2) {
            this.addCriterion("store_model between", value1, value2, "storeModel");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStoreModelNotBetween(Integer value1, Integer value2) {
            this.addCriterion("store_model not between", value1, value2, "storeModel");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPacketUrlIsNull() {
            this.addCriterion("packet_url is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPacketUrlIsNotNull() {
            this.addCriterion("packet_url is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPacketUrlEqualTo(String value) {
            this.addCriterion("packet_url =", value, "packetUrl");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPacketUrlNotEqualTo(String value) {
            this.addCriterion("packet_url <>", value, "packetUrl");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPacketUrlGreaterThan(String value) {
            this.addCriterion("packet_url >", value, "packetUrl");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPacketUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("packet_url >=", value, "packetUrl");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPacketUrlLessThan(String value) {
            this.addCriterion("packet_url <", value, "packetUrl");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPacketUrlLessThanOrEqualTo(String value) {
            this.addCriterion("packet_url <=", value, "packetUrl");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPacketUrlLike(String value) {
            this.addCriterion("packet_url like", value, "packetUrl");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPacketUrlNotLike(String value) {
            this.addCriterion("packet_url not like", value, "packetUrl");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andPacketUrlIn(List<String> values) {
            this.addCriterion("packet_url in", values, "packetUrl");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPacketUrlNotIn(List<String> values) {
            this.addCriterion("packet_url not in", values, "packetUrl");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPacketUrlBetween(String value1, String value2) {
            this.addCriterion("packet_url between", value1, value2, "packetUrl");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPacketUrlNotBetween(String value1, String value2) {
            this.addCriterion("packet_url not between", value1, value2, "packetUrl");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark11IsNull() {
            this.addCriterion("remark11 is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark11IsNotNull() {
            this.addCriterion("remark11 is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark11EqualTo(String value) {
            this.addCriterion("remark11 =", value, "remark11");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark11NotEqualTo(String value) {
            this.addCriterion("remark11 <>", value, "remark11");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark11GreaterThan(String value) {
            this.addCriterion("remark11 >", value, "remark11");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark11GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark11 >=", value, "remark11");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark11LessThan(String value) {
            this.addCriterion("remark11 <", value, "remark11");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark11LessThanOrEqualTo(String value) {
            this.addCriterion("remark11 <=", value, "remark11");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark11Like(String value) {
            this.addCriterion("remark11 like", value, "remark11");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark11NotLike(String value) {
            this.addCriterion("remark11 not like", value, "remark11");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andRemark11In(List<String> values) {
            this.addCriterion("remark11 in", values, "remark11");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark11NotIn(List<String> values) {
            this.addCriterion("remark11 not in", values, "remark11");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark11Between(String value1, String value2) {
            this.addCriterion("remark11 between", value1, value2, "remark11");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark11NotBetween(String value1, String value2) {
            this.addCriterion("remark11 not between", value1, value2, "remark11");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark12IsNull() {
            this.addCriterion("remark12 is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark12IsNotNull() {
            this.addCriterion("remark12 is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark12EqualTo(String value) {
            this.addCriterion("remark12 =", value, "remark12");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark12NotEqualTo(String value) {
            this.addCriterion("remark12 <>", value, "remark12");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark12GreaterThan(String value) {
            this.addCriterion("remark12 >", value, "remark12");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark12GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark12 >=", value, "remark12");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark12LessThan(String value) {
            this.addCriterion("remark12 <", value, "remark12");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark12LessThanOrEqualTo(String value) {
            this.addCriterion("remark12 <=", value, "remark12");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark12Like(String value) {
            this.addCriterion("remark12 like", value, "remark12");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark12NotLike(String value) {
            this.addCriterion("remark12 not like", value, "remark12");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andRemark12In(List<String> values) {
            this.addCriterion("remark12 in", values, "remark12");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark12NotIn(List<String> values) {
            this.addCriterion("remark12 not in", values, "remark12");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark12Between(String value1, String value2) {
            this.addCriterion("remark12 between", value1, value2, "remark12");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark12NotBetween(String value1, String value2) {
            this.addCriterion("remark12 not between", value1, value2, "remark12");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark13IsNull() {
            this.addCriterion("remark13 is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark13IsNotNull() {
            this.addCriterion("remark13 is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark13EqualTo(String value) {
            this.addCriterion("remark13 =", value, "remark13");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark13NotEqualTo(String value) {
            this.addCriterion("remark13 <>", value, "remark13");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark13GreaterThan(String value) {
            this.addCriterion("remark13 >", value, "remark13");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark13GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark13 >=", value, "remark13");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark13LessThan(String value) {
            this.addCriterion("remark13 <", value, "remark13");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark13LessThanOrEqualTo(String value) {
            this.addCriterion("remark13 <=", value, "remark13");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark13Like(String value) {
            this.addCriterion("remark13 like", value, "remark13");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark13NotLike(String value) {
            this.addCriterion("remark13 not like", value, "remark13");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andRemark13In(List<String> values) {
            this.addCriterion("remark13 in", values, "remark13");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark13NotIn(List<String> values) {
            this.addCriterion("remark13 not in", values, "remark13");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark13Between(String value1, String value2) {
            this.addCriterion("remark13 between", value1, value2, "remark13");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark13NotBetween(String value1, String value2) {
            this.addCriterion("remark13 not between", value1, value2, "remark13");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark14IsNull() {
            this.addCriterion("remark14 is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark14IsNotNull() {
            this.addCriterion("remark14 is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark14EqualTo(String value) {
            this.addCriterion("remark14 =", value, "remark14");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark14NotEqualTo(String value) {
            this.addCriterion("remark14 <>", value, "remark14");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark14GreaterThan(String value) {
            this.addCriterion("remark14 >", value, "remark14");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark14GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark14 >=", value, "remark14");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark14LessThan(String value) {
            this.addCriterion("remark14 <", value, "remark14");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark14LessThanOrEqualTo(String value) {
            this.addCriterion("remark14 <=", value, "remark14");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark14Like(String value) {
            this.addCriterion("remark14 like", value, "remark14");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark14NotLike(String value) {
            this.addCriterion("remark14 not like", value, "remark14");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andRemark14In(List<String> values) {
            this.addCriterion("remark14 in", values, "remark14");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark14NotIn(List<String> values) {
            this.addCriterion("remark14 not in", values, "remark14");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark14Between(String value1, String value2) {
            this.addCriterion("remark14 between", value1, value2, "remark14");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark14NotBetween(String value1, String value2) {
            this.addCriterion("remark14 not between", value1, value2, "remark14");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark15IsNull() {
            this.addCriterion("remark15 is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark15IsNotNull() {
            this.addCriterion("remark15 is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark15EqualTo(String value) {
            this.addCriterion("remark15 =", value, "remark15");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark15NotEqualTo(String value) {
            this.addCriterion("remark15 <>", value, "remark15");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark15GreaterThan(String value) {
            this.addCriterion("remark15 >", value, "remark15");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark15GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark15 >=", value, "remark15");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark15LessThan(String value) {
            this.addCriterion("remark15 <", value, "remark15");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark15LessThanOrEqualTo(String value) {
            this.addCriterion("remark15 <=", value, "remark15");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark15Like(String value) {
            this.addCriterion("remark15 like", value, "remark15");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark15NotLike(String value) {
            this.addCriterion("remark15 not like", value, "remark15");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andRemark15In(List<String> values) {
            this.addCriterion("remark15 in", values, "remark15");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark15NotIn(List<String> values) {
            this.addCriterion("remark15 not in", values, "remark15");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark15Between(String value1, String value2) {
            this.addCriterion("remark15 between", value1, value2, "remark15");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark15NotBetween(String value1, String value2) {
            this.addCriterion("remark15 not between", value1, value2, "remark15");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark16IsNull() {
            this.addCriterion("remark16 is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark16IsNotNull() {
            this.addCriterion("remark16 is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark16EqualTo(String value) {
            this.addCriterion("remark16 =", value, "remark16");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark16NotEqualTo(String value) {
            this.addCriterion("remark16 <>", value, "remark16");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark16GreaterThan(String value) {
            this.addCriterion("remark16 >", value, "remark16");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark16GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark16 >=", value, "remark16");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark16LessThan(String value) {
            this.addCriterion("remark16 <", value, "remark16");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark16LessThanOrEqualTo(String value) {
            this.addCriterion("remark16 <=", value, "remark16");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark16Like(String value) {
            this.addCriterion("remark16 like", value, "remark16");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark16NotLike(String value) {
            this.addCriterion("remark16 not like", value, "remark16");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andRemark16In(List<String> values) {
            this.addCriterion("remark16 in", values, "remark16");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark16NotIn(List<String> values) {
            this.addCriterion("remark16 not in", values, "remark16");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark16Between(String value1, String value2) {
            this.addCriterion("remark16 between", value1, value2, "remark16");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark16NotBetween(String value1, String value2) {
            this.addCriterion("remark16 not between", value1, value2, "remark16");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark17IsNull() {
            this.addCriterion("remark17 is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark17IsNotNull() {
            this.addCriterion("remark17 is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark17EqualTo(String value) {
            this.addCriterion("remark17 =", value, "remark17");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark17NotEqualTo(String value) {
            this.addCriterion("remark17 <>", value, "remark17");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark17GreaterThan(String value) {
            this.addCriterion("remark17 >", value, "remark17");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark17GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark17 >=", value, "remark17");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark17LessThan(String value) {
            this.addCriterion("remark17 <", value, "remark17");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark17LessThanOrEqualTo(String value) {
            this.addCriterion("remark17 <=", value, "remark17");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark17Like(String value) {
            this.addCriterion("remark17 like", value, "remark17");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark17NotLike(String value) {
            this.addCriterion("remark17 not like", value, "remark17");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andRemark17In(List<String> values) {
            this.addCriterion("remark17 in", values, "remark17");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark17NotIn(List<String> values) {
            this.addCriterion("remark17 not in", values, "remark17");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark17Between(String value1, String value2) {
            this.addCriterion("remark17 between", value1, value2, "remark17");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark17NotBetween(String value1, String value2) {
            this.addCriterion("remark17 not between", value1, value2, "remark17");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark18IsNull() {
            this.addCriterion("remark18 is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark18IsNotNull() {
            this.addCriterion("remark18 is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark18EqualTo(String value) {
            this.addCriterion("remark18 =", value, "remark18");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark18NotEqualTo(String value) {
            this.addCriterion("remark18 <>", value, "remark18");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark18GreaterThan(String value) {
            this.addCriterion("remark18 >", value, "remark18");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark18GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark18 >=", value, "remark18");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark18LessThan(String value) {
            this.addCriterion("remark18 <", value, "remark18");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark18LessThanOrEqualTo(String value) {
            this.addCriterion("remark18 <=", value, "remark18");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark18Like(String value) {
            this.addCriterion("remark18 like", value, "remark18");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark18NotLike(String value) {
            this.addCriterion("remark18 not like", value, "remark18");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andRemark18In(List<String> values) {
            this.addCriterion("remark18 in", values, "remark18");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark18NotIn(List<String> values) {
            this.addCriterion("remark18 not in", values, "remark18");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark18Between(String value1, String value2) {
            this.addCriterion("remark18 between", value1, value2, "remark18");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark18NotBetween(String value1, String value2) {
            this.addCriterion("remark18 not between", value1, value2, "remark18");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark19IsNull() {
            this.addCriterion("remark19 is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark19IsNotNull() {
            this.addCriterion("remark19 is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark19EqualTo(String value) {
            this.addCriterion("remark19 =", value, "remark19");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark19NotEqualTo(String value) {
            this.addCriterion("remark19 <>", value, "remark19");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark19GreaterThan(String value) {
            this.addCriterion("remark19 >", value, "remark19");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark19GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark19 >=", value, "remark19");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark19LessThan(String value) {
            this.addCriterion("remark19 <", value, "remark19");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark19LessThanOrEqualTo(String value) {
            this.addCriterion("remark19 <=", value, "remark19");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark19Like(String value) {
            this.addCriterion("remark19 like", value, "remark19");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark19NotLike(String value) {
            this.addCriterion("remark19 not like", value, "remark19");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andRemark19In(List<String> values) {
            this.addCriterion("remark19 in", values, "remark19");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark19NotIn(List<String> values) {
            this.addCriterion("remark19 not in", values, "remark19");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark19Between(String value1, String value2) {
            this.addCriterion("remark19 between", value1, value2, "remark19");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark19NotBetween(String value1, String value2) {
            this.addCriterion("remark19 not between", value1, value2, "remark19");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark20IsNull() {
            this.addCriterion("remark20 is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark20IsNotNull() {
            this.addCriterion("remark20 is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark20EqualTo(String value) {
            this.addCriterion("remark20 =", value, "remark20");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark20NotEqualTo(String value) {
            this.addCriterion("remark20 <>", value, "remark20");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark20GreaterThan(String value) {
            this.addCriterion("remark20 >", value, "remark20");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark20GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark20 >=", value, "remark20");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark20LessThan(String value) {
            this.addCriterion("remark20 <", value, "remark20");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark20LessThanOrEqualTo(String value) {
            this.addCriterion("remark20 <=", value, "remark20");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark20Like(String value) {
            this.addCriterion("remark20 like", value, "remark20");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark20NotLike(String value) {
            this.addCriterion("remark20 not like", value, "remark20");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andRemark20In(List<String> values) {
            this.addCriterion("remark20 in", values, "remark20");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark20NotIn(List<String> values) {
            this.addCriterion("remark20 not in", values, "remark20");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark20Between(String value1, String value2) {
            this.addCriterion("remark20 between", value1, value2, "remark20");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andRemark20NotBetween(String value1, String value2) {
            this.addCriterion("remark20 not between", value1, value2, "remark20");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andIdCardImgIsNull() {
            this.addCriterion("id_card_img is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andIdCardImgIsNotNull() {
            this.addCriterion("id_card_img is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andIdCardImgEqualTo(String value) {
            this.addCriterion("id_card_img =", value, "idCardImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andIdCardImgNotEqualTo(String value) {
            this.addCriterion("id_card_img <>", value, "idCardImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andIdCardImgGreaterThan(String value) {
            this.addCriterion("id_card_img >", value, "idCardImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andIdCardImgGreaterThanOrEqualTo(String value) {
            this.addCriterion("id_card_img >=", value, "idCardImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andIdCardImgLessThan(String value) {
            this.addCriterion("id_card_img <", value, "idCardImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andIdCardImgLessThanOrEqualTo(String value) {
            this.addCriterion("id_card_img <=", value, "idCardImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andIdCardImgLike(String value) {
            this.addCriterion("id_card_img like", value, "idCardImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andIdCardImgNotLike(String value) {
            this.addCriterion("id_card_img not like", value, "idCardImg");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andIdCardImgIn(List<String> values) {
            this.addCriterion("id_card_img in", values, "idCardImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andIdCardImgNotIn(List<String> values) {
            this.addCriterion("id_card_img not in", values, "idCardImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andIdCardImgBetween(String value1, String value2) {
            this.addCriterion("id_card_img between", value1, value2, "idCardImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andIdCardImgNotBetween(String value1, String value2) {
            this.addCriterion("id_card_img not between", value1, value2, "idCardImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBusinessLicenseImgIsNull() {
            this.addCriterion("business_license_img is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBusinessLicenseImgIsNotNull() {
            this.addCriterion("business_license_img is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBusinessLicenseImgEqualTo(String value) {
            this.addCriterion("business_license_img =", value, "businessLicenseImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBusinessLicenseImgNotEqualTo(String value) {
            this.addCriterion("business_license_img <>", value, "businessLicenseImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBusinessLicenseImgGreaterThan(String value) {
            this.addCriterion("business_license_img >", value, "businessLicenseImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBusinessLicenseImgGreaterThanOrEqualTo(String value) {
            this.addCriterion("business_license_img >=", value, "businessLicenseImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBusinessLicenseImgLessThan(String value) {
            this.addCriterion("business_license_img <", value, "businessLicenseImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBusinessLicenseImgLessThanOrEqualTo(String value) {
            this.addCriterion("business_license_img <=", value, "businessLicenseImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBusinessLicenseImgLike(String value) {
            this.addCriterion("business_license_img like", value, "businessLicenseImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBusinessLicenseImgNotLike(String value) {
            this.addCriterion("business_license_img not like", value, "businessLicenseImg");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andBusinessLicenseImgIn(List<String> values) {
            this.addCriterion("business_license_img in", values, "businessLicenseImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBusinessLicenseImgNotIn(List<String> values) {
            this.addCriterion("business_license_img not in", values, "businessLicenseImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBusinessLicenseImgBetween(String value1, String value2) {
            this.addCriterion("business_license_img between", value1, value2, "businessLicenseImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andBusinessLicenseImgNotBetween(String value1, String value2) {
            this.addCriterion("business_license_img not between", value1, value2, "businessLicenseImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andContractOfTenancyImgIsNull() {
            this.addCriterion("contract_of_tenancy_img is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andContractOfTenancyImgIsNotNull() {
            this.addCriterion("contract_of_tenancy_img is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andContractOfTenancyImgEqualTo(String value) {
            this.addCriterion("contract_of_tenancy_img =", value, "contractOfTenancyImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andContractOfTenancyImgNotEqualTo(String value) {
            this.addCriterion("contract_of_tenancy_img <>", value, "contractOfTenancyImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andContractOfTenancyImgGreaterThan(String value) {
            this.addCriterion("contract_of_tenancy_img >", value, "contractOfTenancyImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andContractOfTenancyImgGreaterThanOrEqualTo(String value) {
            this.addCriterion("contract_of_tenancy_img >=", value, "contractOfTenancyImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andContractOfTenancyImgLessThan(String value) {
            this.addCriterion("contract_of_tenancy_img <", value, "contractOfTenancyImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andContractOfTenancyImgLessThanOrEqualTo(String value) {
            this.addCriterion("contract_of_tenancy_img <=", value, "contractOfTenancyImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andContractOfTenancyImgLike(String value) {
            this.addCriterion("contract_of_tenancy_img like", value, "contractOfTenancyImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andContractOfTenancyImgNotLike(String value) {
            this.addCriterion("contract_of_tenancy_img not like", value, "contractOfTenancyImg");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andContractOfTenancyImgIn(List<String> values) {
            this.addCriterion("contract_of_tenancy_img in", values, "contractOfTenancyImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andContractOfTenancyImgNotIn(List<String> values) {
            this.addCriterion("contract_of_tenancy_img not in", values, "contractOfTenancyImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andContractOfTenancyImgBetween(String value1, String value2) {
            this.addCriterion("contract_of_tenancy_img between", value1, value2, "contractOfTenancyImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andContractOfTenancyImgNotBetween(String value1, String value2) {
            this.addCriterion("contract_of_tenancy_img not between", value1, value2, "contractOfTenancyImg");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceMatcherRuleIsNull() {
            this.addCriterion("price_matcher_rule is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceMatcherRuleIsNotNull() {
            this.addCriterion("price_matcher_rule is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceMatcherRuleEqualTo(String value) {
            this.addCriterion("price_matcher_rule =", value, "priceMatcherRule");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceMatcherRuleNotEqualTo(String value) {
            this.addCriterion("price_matcher_rule <>", value, "priceMatcherRule");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceMatcherRuleGreaterThan(String value) {
            this.addCriterion("price_matcher_rule >", value, "priceMatcherRule");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceMatcherRuleGreaterThanOrEqualTo(String value) {
            this.addCriterion("price_matcher_rule >=", value, "priceMatcherRule");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceMatcherRuleLessThan(String value) {
            this.addCriterion("price_matcher_rule <", value, "priceMatcherRule");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceMatcherRuleLessThanOrEqualTo(String value) {
            this.addCriterion("price_matcher_rule <=", value, "priceMatcherRule");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceMatcherRuleLike(String value) {
            this.addCriterion("price_matcher_rule like", value, "priceMatcherRule");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceMatcherRuleNotLike(String value) {
            this.addCriterion("price_matcher_rule not like", value, "priceMatcherRule");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andPriceMatcherRuleIn(List<String> values) {
            this.addCriterion("price_matcher_rule in", values, "priceMatcherRule");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceMatcherRuleNotIn(List<String> values) {
            this.addCriterion("price_matcher_rule not in", values, "priceMatcherRule");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceMatcherRuleBetween(String value1, String value2) {
            this.addCriterion("price_matcher_rule between", value1, value2, "priceMatcherRule");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andPriceMatcherRuleNotBetween(String value1, String value2) {
            this.addCriterion("price_matcher_rule not between", value1, value2, "priceMatcherRule");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStarNumIsNull() {
            this.addCriterion("star_num is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStarNumIsNotNull() {
            this.addCriterion("star_num is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStarNumEqualTo(Long value) {
            this.addCriterion("star_num =", value, "starNum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStarNumNotEqualTo(Long value) {
            this.addCriterion("star_num <>", value, "starNum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStarNumGreaterThan(Long value) {
            this.addCriterion("star_num >", value, "starNum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStarNumGreaterThanOrEqualTo(Long value) {
            this.addCriterion("star_num >=", value, "starNum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStarNumLessThan(Long value) {
            this.addCriterion("star_num <", value, "starNum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStarNumLessThanOrEqualTo(Long value) {
            this.addCriterion("star_num <=", value, "starNum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStarNumLike(String value) {
            this.addCriterion("star_num like", value, "starNum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStarNumNotLike(String value) {
            this.addCriterion("star_num not like", value, "starNum");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andStarNumIn(List<Long> values) {
            this.addCriterion("star_num in", values, "starNum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStarNumNotIn(List<Long> values) {
            this.addCriterion("star_num not in", values, "starNum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStarNumBetween(Long value1, Long value2) {
            this.addCriterion("star_num between", value1, value2, "starNum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andStarNumNotBetween(Long value1, Long value2) {
            this.addCriterion("star_num not between", value1, value2, "starNum");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastModifyTimeIsNull() {
            this.addCriterion("last_modify_time is null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastModifyTimeIsNotNull() {
            this.addCriterion("last_modify_time is not null");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastModifyTimeEqualTo(Date value) {
            this.addCriterion("last_modify_time =", value, "lastModifyTime");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastModifyTimeNotEqualTo(Date value) {
            this.addCriterion("last_modify_time <>", value, "lastModifyTime");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastModifyTimeGreaterThan(Date value) {
            this.addCriterion("last_modify_time >", value, "lastModifyTime");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("last_modify_time >=", value, "lastModifyTime");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastModifyTimeLessThan(Date value) {
            this.addCriterion("last_modify_time <", value, "lastModifyTime");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("last_modify_time <=", value, "lastModifyTime");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastModifyTimeLike(String value) {
            this.addCriterion("last_modify_time like", value, "lastModifyTime");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastModifyTimeNotLike(String value) {
            this.addCriterion("last_modify_time not like", value, "lastModifyTime");
            return (ShiguStoreExample.Criteria)this;
        }        public ShiguStoreExample.Criteria andLastModifyTimeIn(List<Date> values) {
            this.addCriterion("last_modify_time in", values, "lastModifyTime");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastModifyTimeNotIn(List<Date> values) {
            this.addCriterion("last_modify_time not in", values, "lastModifyTime");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            this.addCriterion("last_modify_time between", value1, value2, "lastModifyTime");
            return (ShiguStoreExample.Criteria)this;
        }

        public ShiguStoreExample.Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("last_modify_time not between", value1, value2, "lastModifyTime");
            return (ShiguStoreExample.Criteria)this;
        }
    }
}
