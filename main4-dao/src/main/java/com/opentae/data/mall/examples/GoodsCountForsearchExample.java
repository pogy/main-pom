package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class GoodsCountForsearchExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<GoodsCountForsearchExample.Criteria> oredCriteria = new ArrayList();

    public GoodsCountForsearchExample() {
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

    public List<GoodsCountForsearchExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(GoodsCountForsearchExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public GoodsCountForsearchExample.Criteria or() {
        GoodsCountForsearchExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public GoodsCountForsearchExample.Criteria createCriteria() {
        GoodsCountForsearchExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected GoodsCountForsearchExample.Criteria createCriteriaInternal() {
        GoodsCountForsearchExample.Criteria criteria = new GoodsCountForsearchExample.Criteria();
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

    public static class Criteria extends GoodsCountForsearchExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<GoodsCountForsearchExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<GoodsCountForsearchExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<GoodsCountForsearchExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new GoodsCountForsearchExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new GoodsCountForsearchExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new GoodsCountForsearchExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public GoodsCountForsearchExample.Criteria andSearchIdIsNull() {
            this.addCriterion("search_id is null");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andSearchIdIsNotNull() {
            this.addCriterion("search_id is not null");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andSearchIdEqualTo(Long value) {
            this.addCriterion("search_id =", value, "searchId");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andSearchIdNotEqualTo(Long value) {
            this.addCriterion("search_id <>", value, "searchId");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andSearchIdGreaterThan(Long value) {
            this.addCriterion("search_id >", value, "searchId");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andSearchIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("search_id >=", value, "searchId");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andSearchIdLessThan(Long value) {
            this.addCriterion("search_id <", value, "searchId");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andSearchIdLessThanOrEqualTo(Long value) {
            this.addCriterion("search_id <=", value, "searchId");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andSearchIdLike(String value) {
            this.addCriterion("search_id like", value, "searchId");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andSearchIdNotLike(String value) {
            this.addCriterion("search_id not like", value, "searchId");
            return (GoodsCountForsearchExample.Criteria)this;
        }        public GoodsCountForsearchExample.Criteria andSearchIdIn(List<Long> values) {
            this.addCriterion("search_id in", values, "searchId");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andSearchIdNotIn(List<Long> values) {
            this.addCriterion("search_id not in", values, "searchId");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andSearchIdBetween(Long value1, Long value2) {
            this.addCriterion("search_id between", value1, value2, "searchId");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andSearchIdNotBetween(Long value1, Long value2) {
            this.addCriterion("search_id not between", value1, value2, "searchId");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andGoodsIdIsNull() {
            this.addCriterion("goods_id is null");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andGoodsIdIsNotNull() {
            this.addCriterion("goods_id is not null");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andGoodsIdEqualTo(Long value) {
            this.addCriterion("goods_id =", value, "goodsId");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andGoodsIdNotEqualTo(Long value) {
            this.addCriterion("goods_id <>", value, "goodsId");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andGoodsIdGreaterThan(Long value) {
            this.addCriterion("goods_id >", value, "goodsId");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("goods_id >=", value, "goodsId");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andGoodsIdLessThan(Long value) {
            this.addCriterion("goods_id <", value, "goodsId");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            this.addCriterion("goods_id <=", value, "goodsId");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andGoodsIdLike(String value) {
            this.addCriterion("goods_id like", value, "goodsId");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andGoodsIdNotLike(String value) {
            this.addCriterion("goods_id not like", value, "goodsId");
            return (GoodsCountForsearchExample.Criteria)this;
        }        public GoodsCountForsearchExample.Criteria andGoodsIdIn(List<Long> values) {
            this.addCriterion("goods_id in", values, "goodsId");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andGoodsIdNotIn(List<Long> values) {
            this.addCriterion("goods_id not in", values, "goodsId");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            this.addCriterion("goods_id between", value1, value2, "goodsId");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            this.addCriterion("goods_id not between", value1, value2, "goodsId");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickIsNull() {
            this.addCriterion("click is null");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickIsNotNull() {
            this.addCriterion("click is not null");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickEqualTo(Long value) {
            this.addCriterion("click =", value, "click");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickNotEqualTo(Long value) {
            this.addCriterion("click <>", value, "click");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickGreaterThan(Long value) {
            this.addCriterion("click >", value, "click");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickGreaterThanOrEqualTo(Long value) {
            this.addCriterion("click >=", value, "click");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickLessThan(Long value) {
            this.addCriterion("click <", value, "click");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickLessThanOrEqualTo(Long value) {
            this.addCriterion("click <=", value, "click");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickLike(String value) {
            this.addCriterion("click like", value, "click");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickNotLike(String value) {
            this.addCriterion("click not like", value, "click");
            return (GoodsCountForsearchExample.Criteria)this;
        }        public GoodsCountForsearchExample.Criteria andClickIn(List<Long> values) {
            this.addCriterion("click in", values, "click");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickNotIn(List<Long> values) {
            this.addCriterion("click not in", values, "click");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickBetween(Long value1, Long value2) {
            this.addCriterion("click between", value1, value2, "click");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickNotBetween(Long value1, Long value2) {
            this.addCriterion("click not between", value1, value2, "click");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickIpIsNull() {
            this.addCriterion("click_ip is null");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickIpIsNotNull() {
            this.addCriterion("click_ip is not null");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickIpEqualTo(Long value) {
            this.addCriterion("click_ip =", value, "clickIp");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickIpNotEqualTo(Long value) {
            this.addCriterion("click_ip <>", value, "clickIp");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickIpGreaterThan(Long value) {
            this.addCriterion("click_ip >", value, "clickIp");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickIpGreaterThanOrEqualTo(Long value) {
            this.addCriterion("click_ip >=", value, "clickIp");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickIpLessThan(Long value) {
            this.addCriterion("click_ip <", value, "clickIp");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickIpLessThanOrEqualTo(Long value) {
            this.addCriterion("click_ip <=", value, "clickIp");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickIpLike(String value) {
            this.addCriterion("click_ip like", value, "clickIp");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickIpNotLike(String value) {
            this.addCriterion("click_ip not like", value, "clickIp");
            return (GoodsCountForsearchExample.Criteria)this;
        }        public GoodsCountForsearchExample.Criteria andClickIpIn(List<Long> values) {
            this.addCriterion("click_ip in", values, "clickIp");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickIpNotIn(List<Long> values) {
            this.addCriterion("click_ip not in", values, "clickIp");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickIpBetween(Long value1, Long value2) {
            this.addCriterion("click_ip between", value1, value2, "clickIp");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andClickIpNotBetween(Long value1, Long value2) {
            this.addCriterion("click_ip not between", value1, value2, "clickIp");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andTradeIsNull() {
            this.addCriterion("trade is null");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andTradeIsNotNull() {
            this.addCriterion("trade is not null");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andTradeEqualTo(Long value) {
            this.addCriterion("trade =", value, "trade");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andTradeNotEqualTo(Long value) {
            this.addCriterion("trade <>", value, "trade");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andTradeGreaterThan(Long value) {
            this.addCriterion("trade >", value, "trade");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andTradeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("trade >=", value, "trade");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andTradeLessThan(Long value) {
            this.addCriterion("trade <", value, "trade");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andTradeLessThanOrEqualTo(Long value) {
            this.addCriterion("trade <=", value, "trade");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andTradeLike(String value) {
            this.addCriterion("trade like", value, "trade");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andTradeNotLike(String value) {
            this.addCriterion("trade not like", value, "trade");
            return (GoodsCountForsearchExample.Criteria)this;
        }        public GoodsCountForsearchExample.Criteria andTradeIn(List<Long> values) {
            this.addCriterion("trade in", values, "trade");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andTradeNotIn(List<Long> values) {
            this.addCriterion("trade not in", values, "trade");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andTradeBetween(Long value1, Long value2) {
            this.addCriterion("trade between", value1, value2, "trade");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andTradeNotBetween(Long value1, Long value2) {
            this.addCriterion("trade not between", value1, value2, "trade");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpIsNull() {
            this.addCriterion("up is null");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpIsNotNull() {
            this.addCriterion("up is not null");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpEqualTo(Long value) {
            this.addCriterion("up =", value, "up");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpNotEqualTo(Long value) {
            this.addCriterion("up <>", value, "up");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpGreaterThan(Long value) {
            this.addCriterion("up >", value, "up");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpGreaterThanOrEqualTo(Long value) {
            this.addCriterion("up >=", value, "up");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpLessThan(Long value) {
            this.addCriterion("up <", value, "up");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpLessThanOrEqualTo(Long value) {
            this.addCriterion("up <=", value, "up");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpLike(String value) {
            this.addCriterion("up like", value, "up");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpNotLike(String value) {
            this.addCriterion("up not like", value, "up");
            return (GoodsCountForsearchExample.Criteria)this;
        }        public GoodsCountForsearchExample.Criteria andUpIn(List<Long> values) {
            this.addCriterion("up in", values, "up");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpNotIn(List<Long> values) {
            this.addCriterion("up not in", values, "up");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpBetween(Long value1, Long value2) {
            this.addCriterion("up between", value1, value2, "up");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpNotBetween(Long value1, Long value2) {
            this.addCriterion("up not between", value1, value2, "up");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpManIsNull() {
            this.addCriterion("up_man is null");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpManIsNotNull() {
            this.addCriterion("up_man is not null");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpManEqualTo(Long value) {
            this.addCriterion("up_man =", value, "upMan");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpManNotEqualTo(Long value) {
            this.addCriterion("up_man <>", value, "upMan");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpManGreaterThan(Long value) {
            this.addCriterion("up_man >", value, "upMan");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpManGreaterThanOrEqualTo(Long value) {
            this.addCriterion("up_man >=", value, "upMan");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpManLessThan(Long value) {
            this.addCriterion("up_man <", value, "upMan");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpManLessThanOrEqualTo(Long value) {
            this.addCriterion("up_man <=", value, "upMan");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpManLike(String value) {
            this.addCriterion("up_man like", value, "upMan");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpManNotLike(String value) {
            this.addCriterion("up_man not like", value, "upMan");
            return (GoodsCountForsearchExample.Criteria)this;
        }        public GoodsCountForsearchExample.Criteria andUpManIn(List<Long> values) {
            this.addCriterion("up_man in", values, "upMan");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpManNotIn(List<Long> values) {
            this.addCriterion("up_man not in", values, "upMan");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpManBetween(Long value1, Long value2) {
            this.addCriterion("up_man between", value1, value2, "upMan");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andUpManNotBetween(Long value1, Long value2) {
            this.addCriterion("up_man not between", value1, value2, "upMan");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadGoatIsNull() {
            this.addCriterion("had_goat is null");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadGoatIsNotNull() {
            this.addCriterion("had_goat is not null");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadGoatEqualTo(Integer value) {
            this.addCriterion("had_goat =", value, "hadGoat");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadGoatNotEqualTo(Integer value) {
            this.addCriterion("had_goat <>", value, "hadGoat");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadGoatGreaterThan(Integer value) {
            this.addCriterion("had_goat >", value, "hadGoat");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadGoatGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("had_goat >=", value, "hadGoat");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadGoatLessThan(Integer value) {
            this.addCriterion("had_goat <", value, "hadGoat");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadGoatLessThanOrEqualTo(Integer value) {
            this.addCriterion("had_goat <=", value, "hadGoat");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadGoatLike(String value) {
            this.addCriterion("had_goat like", value, "hadGoat");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadGoatNotLike(String value) {
            this.addCriterion("had_goat not like", value, "hadGoat");
            return (GoodsCountForsearchExample.Criteria)this;
        }        public GoodsCountForsearchExample.Criteria andHadGoatIn(List<Integer> values) {
            this.addCriterion("had_goat in", values, "hadGoat");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadGoatNotIn(List<Integer> values) {
            this.addCriterion("had_goat not in", values, "hadGoat");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadGoatBetween(Integer value1, Integer value2) {
            this.addCriterion("had_goat between", value1, value2, "hadGoat");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadGoatNotBetween(Integer value1, Integer value2) {
            this.addCriterion("had_goat not between", value1, value2, "hadGoat");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andWebSiteIsNull() {
            this.addCriterion("web_site is null");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andWebSiteIsNotNull() {
            this.addCriterion("web_site is not null");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("web_site =", value, "webSite");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("web_site <>", value, "webSite");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("web_site >", value, "webSite");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("web_site >=", value, "webSite");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andWebSiteLessThan(String value) {
            this.addCriterion("web_site <", value, "webSite");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("web_site <=", value, "webSite");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andWebSiteLike(String value) {
            this.addCriterion("web_site like", value, "webSite");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andWebSiteNotLike(String value) {
            this.addCriterion("web_site not like", value, "webSite");
            return (GoodsCountForsearchExample.Criteria)this;
        }        public GoodsCountForsearchExample.Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("web_site in", values, "webSite");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("web_site not in", values, "webSite");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("web_site between", value1, value2, "webSite");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("web_site not between", value1, value2, "webSite");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeIsNull() {
            this.addCriterion("flow_fixed_time is null");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeIsNotNull() {
            this.addCriterion("flow_fixed_time is not null");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeEqualTo(Date value) {
            this.addCriterion("flow_fixed_time =", value, "flowFixedTime");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeNotEqualTo(Date value) {
            this.addCriterion("flow_fixed_time <>", value, "flowFixedTime");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeGreaterThan(Date value) {
            this.addCriterion("flow_fixed_time >", value, "flowFixedTime");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("flow_fixed_time >=", value, "flowFixedTime");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeLessThan(Date value) {
            this.addCriterion("flow_fixed_time <", value, "flowFixedTime");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("flow_fixed_time <=", value, "flowFixedTime");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeLike(String value) {
            this.addCriterion("flow_fixed_time like", value, "flowFixedTime");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeNotLike(String value) {
            this.addCriterion("flow_fixed_time not like", value, "flowFixedTime");
            return (GoodsCountForsearchExample.Criteria)this;
        }        public GoodsCountForsearchExample.Criteria andFlowFixedTimeIn(List<Date> values) {
            this.addCriterion("flow_fixed_time in", values, "flowFixedTime");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeNotIn(List<Date> values) {
            this.addCriterion("flow_fixed_time not in", values, "flowFixedTime");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeBetween(Date value1, Date value2) {
            this.addCriterion("flow_fixed_time between", value1, value2, "flowFixedTime");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("flow_fixed_time not between", value1, value2, "flowFixedTime");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadBigzipIsNull() {
            this.addCriterion("had_bigzip is null");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadBigzipIsNotNull() {
            this.addCriterion("had_bigzip is not null");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadBigzipEqualTo(Integer value) {
            this.addCriterion("had_bigzip =", value, "hadBigzip");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadBigzipNotEqualTo(Integer value) {
            this.addCriterion("had_bigzip <>", value, "hadBigzip");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadBigzipGreaterThan(Integer value) {
            this.addCriterion("had_bigzip >", value, "hadBigzip");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadBigzipGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("had_bigzip >=", value, "hadBigzip");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadBigzipLessThan(Integer value) {
            this.addCriterion("had_bigzip <", value, "hadBigzip");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadBigzipLessThanOrEqualTo(Integer value) {
            this.addCriterion("had_bigzip <=", value, "hadBigzip");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadBigzipLike(String value) {
            this.addCriterion("had_bigzip like", value, "hadBigzip");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadBigzipNotLike(String value) {
            this.addCriterion("had_bigzip not like", value, "hadBigzip");
            return (GoodsCountForsearchExample.Criteria)this;
        }        public GoodsCountForsearchExample.Criteria andHadBigzipIn(List<Integer> values) {
            this.addCriterion("had_bigzip in", values, "hadBigzip");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadBigzipNotIn(List<Integer> values) {
            this.addCriterion("had_bigzip not in", values, "hadBigzip");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadBigzipBetween(Integer value1, Integer value2) {
            this.addCriterion("had_bigzip between", value1, value2, "hadBigzip");
            return (GoodsCountForsearchExample.Criteria)this;
        }

        public GoodsCountForsearchExample.Criteria andHadBigzipNotBetween(Integer value1, Integer value2) {
            this.addCriterion("had_bigzip not between", value1, value2, "hadBigzip");
            return (GoodsCountForsearchExample.Criteria)this;
        }
    }
}
