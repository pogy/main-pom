package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShiguGoodsSoldoutExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguGoodsSoldoutExample.Criteria> oredCriteria = new ArrayList();

    public ShiguGoodsSoldoutExample() {
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

    public List<ShiguGoodsSoldoutExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguGoodsSoldoutExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguGoodsSoldoutExample.Criteria or() {
        ShiguGoodsSoldoutExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguGoodsSoldoutExample.Criteria createCriteria() {
        ShiguGoodsSoldoutExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguGoodsSoldoutExample.Criteria createCriteriaInternal() {
        ShiguGoodsSoldoutExample.Criteria criteria = new ShiguGoodsSoldoutExample.Criteria();
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

    public static class Criteria extends ShiguGoodsSoldoutExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguGoodsSoldoutExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguGoodsSoldoutExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguGoodsSoldoutExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguGoodsSoldoutExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguGoodsSoldoutExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguGoodsSoldoutExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsIdIsNull() {
            this.addCriterion("goods_id is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsIdIsNotNull() {
            this.addCriterion("goods_id is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsIdEqualTo(Long value) {
            this.addCriterion("goods_id =", value, "goodsId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsIdNotEqualTo(Long value) {
            this.addCriterion("goods_id <>", value, "goodsId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsIdGreaterThan(Long value) {
            this.addCriterion("goods_id >", value, "goodsId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("goods_id >=", value, "goodsId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsIdLessThan(Long value) {
            this.addCriterion("goods_id <", value, "goodsId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            this.addCriterion("goods_id <=", value, "goodsId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsIdLike(String value) {
            this.addCriterion("goods_id like", value, "goodsId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsIdNotLike(String value) {
            this.addCriterion("goods_id not like", value, "goodsId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andGoodsIdIn(List<Long> values) {
            this.addCriterion("goods_id in", values, "goodsId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsIdNotIn(List<Long> values) {
            this.addCriterion("goods_id not in", values, "goodsId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            this.addCriterion("goods_id between", value1, value2, "goodsId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            this.addCriterion("goods_id not between", value1, value2, "goodsId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIidIsNull() {
            this.addCriterion("num_iid is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIidIsNotNull() {
            this.addCriterion("num_iid is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIidEqualTo(Long value) {
            this.addCriterion("num_iid =", value, "numIid");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIidNotEqualTo(Long value) {
            this.addCriterion("num_iid <>", value, "numIid");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIidGreaterThan(Long value) {
            this.addCriterion("num_iid >", value, "numIid");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("num_iid >=", value, "numIid");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIidLessThan(Long value) {
            this.addCriterion("num_iid <", value, "numIid");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIidLessThanOrEqualTo(Long value) {
            this.addCriterion("num_iid <=", value, "numIid");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIidLike(String value) {
            this.addCriterion("num_iid like", value, "numIid");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIidNotLike(String value) {
            this.addCriterion("num_iid not like", value, "numIid");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andNumIidIn(List<Long> values) {
            this.addCriterion("num_iid in", values, "numIid");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIidNotIn(List<Long> values) {
            this.addCriterion("num_iid not in", values, "numIid");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIidBetween(Long value1, Long value2) {
            this.addCriterion("num_iid between", value1, value2, "numIid");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIidNotBetween(Long value1, Long value2) {
            this.addCriterion("num_iid not between", value1, value2, "numIid");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlIsNull() {
            this.addCriterion("detail_url is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlIsNotNull() {
            this.addCriterion("detail_url is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlEqualTo(String value) {
            this.addCriterion("detail_url =", value, "detailUrl");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlNotEqualTo(String value) {
            this.addCriterion("detail_url <>", value, "detailUrl");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlGreaterThan(String value) {
            this.addCriterion("detail_url >", value, "detailUrl");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("detail_url >=", value, "detailUrl");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlLessThan(String value) {
            this.addCriterion("detail_url <", value, "detailUrl");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlLessThanOrEqualTo(String value) {
            this.addCriterion("detail_url <=", value, "detailUrl");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlLike(String value) {
            this.addCriterion("detail_url like", value, "detailUrl");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlNotLike(String value) {
            this.addCriterion("detail_url not like", value, "detailUrl");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andDetailUrlIn(List<String> values) {
            this.addCriterion("detail_url in", values, "detailUrl");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlNotIn(List<String> values) {
            this.addCriterion("detail_url not in", values, "detailUrl");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlBetween(String value1, String value2) {
            this.addCriterion("detail_url between", value1, value2, "detailUrl");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDetailUrlNotBetween(String value1, String value2) {
            this.addCriterion("detail_url not between", value1, value2, "detailUrl");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleIsNull() {
            this.addCriterion("title is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleIsNotNull() {
            this.addCriterion("title is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleEqualTo(String value) {
            this.addCriterion("title =", value, "title");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleNotEqualTo(String value) {
            this.addCriterion("title <>", value, "title");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleGreaterThan(String value) {
            this.addCriterion("title >", value, "title");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            this.addCriterion("title >=", value, "title");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleLessThan(String value) {
            this.addCriterion("title <", value, "title");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleLessThanOrEqualTo(String value) {
            this.addCriterion("title <=", value, "title");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleLike(String value) {
            this.addCriterion("title like", value, "title");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleNotLike(String value) {
            this.addCriterion("title not like", value, "title");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andTitleIn(List<String> values) {
            this.addCriterion("title in", values, "title");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleNotIn(List<String> values) {
            this.addCriterion("title not in", values, "title");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleBetween(String value1, String value2) {
            this.addCriterion("title between", value1, value2, "title");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTitleNotBetween(String value1, String value2) {
            this.addCriterion("title not between", value1, value2, "title");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNickIsNull() {
            this.addCriterion("nick is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNickIsNotNull() {
            this.addCriterion("nick is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNickEqualTo(String value) {
            this.addCriterion("nick =", value, "nick");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNickNotEqualTo(String value) {
            this.addCriterion("nick <>", value, "nick");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNickGreaterThan(String value) {
            this.addCriterion("nick >", value, "nick");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNickGreaterThanOrEqualTo(String value) {
            this.addCriterion("nick >=", value, "nick");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNickLessThan(String value) {
            this.addCriterion("nick <", value, "nick");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNickLessThanOrEqualTo(String value) {
            this.addCriterion("nick <=", value, "nick");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNickLike(String value) {
            this.addCriterion("nick like", value, "nick");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNickNotLike(String value) {
            this.addCriterion("nick not like", value, "nick");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andNickIn(List<String> values) {
            this.addCriterion("nick in", values, "nick");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNickNotIn(List<String> values) {
            this.addCriterion("nick not in", values, "nick");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNickBetween(String value1, String value2) {
            this.addCriterion("nick between", value1, value2, "nick");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNickNotBetween(String value1, String value2) {
            this.addCriterion("nick not between", value1, value2, "nick");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeIsNull() {
            this.addCriterion("type is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeIsNotNull() {
            this.addCriterion("type is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeEqualTo(String value) {
            this.addCriterion("type =", value, "type");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeNotEqualTo(String value) {
            this.addCriterion("type <>", value, "type");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeGreaterThan(String value) {
            this.addCriterion("type >", value, "type");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeGreaterThanOrEqualTo(String value) {
            this.addCriterion("type >=", value, "type");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeLessThan(String value) {
            this.addCriterion("type <", value, "type");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeLessThanOrEqualTo(String value) {
            this.addCriterion("type <=", value, "type");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeLike(String value) {
            this.addCriterion("type like", value, "type");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeNotLike(String value) {
            this.addCriterion("type not like", value, "type");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andTypeIn(List<String> values) {
            this.addCriterion("type in", values, "type");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeNotIn(List<String> values) {
            this.addCriterion("type not in", values, "type");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeBetween(String value1, String value2) {
            this.addCriterion("type between", value1, value2, "type");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andTypeNotBetween(String value1, String value2) {
            this.addCriterion("type not between", value1, value2, "type");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCreatedIsNull() {
            this.addCriterion("created is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCreatedIsNotNull() {
            this.addCriterion("created is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCreatedEqualTo(Date value) {
            this.addCriterion("created =", value, "created");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCreatedNotEqualTo(Date value) {
            this.addCriterion("created <>", value, "created");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCreatedGreaterThan(Date value) {
            this.addCriterion("created >", value, "created");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            this.addCriterion("created >=", value, "created");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCreatedLessThan(Date value) {
            this.addCriterion("created <", value, "created");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCreatedLessThanOrEqualTo(Date value) {
            this.addCriterion("created <=", value, "created");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCreatedLike(String value) {
            this.addCriterion("created like", value, "created");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCreatedNotLike(String value) {
            this.addCriterion("created not like", value, "created");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andCreatedIn(List<Date> values) {
            this.addCriterion("created in", values, "created");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCreatedNotIn(List<Date> values) {
            this.addCriterion("created not in", values, "created");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCreatedBetween(Date value1, Date value2) {
            this.addCriterion("created between", value1, value2, "created");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCreatedNotBetween(Date value1, Date value2) {
            this.addCriterion("created not between", value1, value2, "created");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentIsNull() {
            this.addCriterion("is_lightning_consignment is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentIsNotNull() {
            this.addCriterion("is_lightning_consignment is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentEqualTo(String value) {
            this.addCriterion("is_lightning_consignment =", value, "isLightningConsignment");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentNotEqualTo(String value) {
            this.addCriterion("is_lightning_consignment <>", value, "isLightningConsignment");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentGreaterThan(String value) {
            this.addCriterion("is_lightning_consignment >", value, "isLightningConsignment");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentGreaterThanOrEqualTo(String value) {
            this.addCriterion("is_lightning_consignment >=", value, "isLightningConsignment");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentLessThan(String value) {
            this.addCriterion("is_lightning_consignment <", value, "isLightningConsignment");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentLessThanOrEqualTo(String value) {
            this.addCriterion("is_lightning_consignment <=", value, "isLightningConsignment");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentLike(String value) {
            this.addCriterion("is_lightning_consignment like", value, "isLightningConsignment");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentNotLike(String value) {
            this.addCriterion("is_lightning_consignment not like", value, "isLightningConsignment");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentIn(List<String> values) {
            this.addCriterion("is_lightning_consignment in", values, "isLightningConsignment");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentNotIn(List<String> values) {
            this.addCriterion("is_lightning_consignment not in", values, "isLightningConsignment");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentBetween(String value1, String value2) {
            this.addCriterion("is_lightning_consignment between", value1, value2, "isLightningConsignment");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsLightningConsignmentNotBetween(String value1, String value2) {
            this.addCriterion("is_lightning_consignment not between", value1, value2, "isLightningConsignment");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoIsNull() {
            this.addCriterion("is_fenxiao is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoIsNotNull() {
            this.addCriterion("is_fenxiao is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoEqualTo(Long value) {
            this.addCriterion("is_fenxiao =", value, "isFenxiao");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoNotEqualTo(Long value) {
            this.addCriterion("is_fenxiao <>", value, "isFenxiao");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoGreaterThan(Long value) {
            this.addCriterion("is_fenxiao >", value, "isFenxiao");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoGreaterThanOrEqualTo(Long value) {
            this.addCriterion("is_fenxiao >=", value, "isFenxiao");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoLessThan(Long value) {
            this.addCriterion("is_fenxiao <", value, "isFenxiao");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoLessThanOrEqualTo(Long value) {
            this.addCriterion("is_fenxiao <=", value, "isFenxiao");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoLike(String value) {
            this.addCriterion("is_fenxiao like", value, "isFenxiao");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoNotLike(String value) {
            this.addCriterion("is_fenxiao not like", value, "isFenxiao");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoIn(List<Long> values) {
            this.addCriterion("is_fenxiao in", values, "isFenxiao");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoNotIn(List<Long> values) {
            this.addCriterion("is_fenxiao not in", values, "isFenxiao");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoBetween(Long value1, Long value2) {
            this.addCriterion("is_fenxiao between", value1, value2, "isFenxiao");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsFenxiaoNotBetween(Long value1, Long value2) {
            this.addCriterion("is_fenxiao not between", value1, value2, "isFenxiao");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinIsNull() {
            this.addCriterion("is_xinpin is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinIsNotNull() {
            this.addCriterion("is_xinpin is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinEqualTo(String value) {
            this.addCriterion("is_xinpin =", value, "isXinpin");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinNotEqualTo(String value) {
            this.addCriterion("is_xinpin <>", value, "isXinpin");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinGreaterThan(String value) {
            this.addCriterion("is_xinpin >", value, "isXinpin");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinGreaterThanOrEqualTo(String value) {
            this.addCriterion("is_xinpin >=", value, "isXinpin");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinLessThan(String value) {
            this.addCriterion("is_xinpin <", value, "isXinpin");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinLessThanOrEqualTo(String value) {
            this.addCriterion("is_xinpin <=", value, "isXinpin");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinLike(String value) {
            this.addCriterion("is_xinpin like", value, "isXinpin");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinNotLike(String value) {
            this.addCriterion("is_xinpin not like", value, "isXinpin");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andIsXinpinIn(List<String> values) {
            this.addCriterion("is_xinpin in", values, "isXinpin");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinNotIn(List<String> values) {
            this.addCriterion("is_xinpin not in", values, "isXinpin");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinBetween(String value1, String value2) {
            this.addCriterion("is_xinpin between", value1, value2, "isXinpin");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsXinpinNotBetween(String value1, String value2) {
            this.addCriterion("is_xinpin not between", value1, value2, "isXinpin");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruIsNull() {
            this.addCriterion("valid_thru is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruIsNotNull() {
            this.addCriterion("valid_thru is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruEqualTo(Long value) {
            this.addCriterion("valid_thru =", value, "validThru");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruNotEqualTo(Long value) {
            this.addCriterion("valid_thru <>", value, "validThru");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruGreaterThan(Long value) {
            this.addCriterion("valid_thru >", value, "validThru");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruGreaterThanOrEqualTo(Long value) {
            this.addCriterion("valid_thru >=", value, "validThru");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruLessThan(Long value) {
            this.addCriterion("valid_thru <", value, "validThru");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruLessThanOrEqualTo(Long value) {
            this.addCriterion("valid_thru <=", value, "validThru");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruLike(String value) {
            this.addCriterion("valid_thru like", value, "validThru");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruNotLike(String value) {
            this.addCriterion("valid_thru not like", value, "validThru");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andValidThruIn(List<Long> values) {
            this.addCriterion("valid_thru in", values, "validThru");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruNotIn(List<Long> values) {
            this.addCriterion("valid_thru not in", values, "validThru");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruBetween(Long value1, Long value2) {
            this.addCriterion("valid_thru between", value1, value2, "validThru");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andValidThruNotBetween(Long value1, Long value2) {
            this.addCriterion("valid_thru not between", value1, value2, "validThru");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdIsNull() {
            this.addCriterion("outer_id is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdIsNotNull() {
            this.addCriterion("outer_id is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdEqualTo(String value) {
            this.addCriterion("outer_id =", value, "outerId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdNotEqualTo(String value) {
            this.addCriterion("outer_id <>", value, "outerId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdGreaterThan(String value) {
            this.addCriterion("outer_id >", value, "outerId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("outer_id >=", value, "outerId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdLessThan(String value) {
            this.addCriterion("outer_id <", value, "outerId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdLessThanOrEqualTo(String value) {
            this.addCriterion("outer_id <=", value, "outerId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdLike(String value) {
            this.addCriterion("outer_id like", value, "outerId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdNotLike(String value) {
            this.addCriterion("outer_id not like", value, "outerId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andOuterIdIn(List<String> values) {
            this.addCriterion("outer_id in", values, "outerId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdNotIn(List<String> values) {
            this.addCriterion("outer_id not in", values, "outerId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdBetween(String value1, String value2) {
            this.addCriterion("outer_id between", value1, value2, "outerId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andOuterIdNotBetween(String value1, String value2) {
            this.addCriterion("outer_id not between", value1, value2, "outerId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidIsNull() {
            this.addCriterion("cid is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidIsNotNull() {
            this.addCriterion("cid is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidEqualTo(Long value) {
            this.addCriterion("cid =", value, "cid");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidNotEqualTo(Long value) {
            this.addCriterion("cid <>", value, "cid");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidGreaterThan(Long value) {
            this.addCriterion("cid >", value, "cid");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("cid >=", value, "cid");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidLessThan(Long value) {
            this.addCriterion("cid <", value, "cid");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidLessThanOrEqualTo(Long value) {
            this.addCriterion("cid <=", value, "cid");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidLike(String value) {
            this.addCriterion("cid like", value, "cid");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidNotLike(String value) {
            this.addCriterion("cid not like", value, "cid");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andCidIn(List<Long> values) {
            this.addCriterion("cid in", values, "cid");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidNotIn(List<Long> values) {
            this.addCriterion("cid not in", values, "cid");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidBetween(Long value1, Long value2) {
            this.addCriterion("cid between", value1, value2, "cid");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidNotBetween(Long value1, Long value2) {
            this.addCriterion("cid not between", value1, value2, "cid");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllIsNull() {
            this.addCriterion("cid_all is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllIsNotNull() {
            this.addCriterion("cid_all is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllEqualTo(String value) {
            this.addCriterion("cid_all =", value, "cidAll");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllNotEqualTo(String value) {
            this.addCriterion("cid_all <>", value, "cidAll");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllGreaterThan(String value) {
            this.addCriterion("cid_all >", value, "cidAll");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllGreaterThanOrEqualTo(String value) {
            this.addCriterion("cid_all >=", value, "cidAll");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllLessThan(String value) {
            this.addCriterion("cid_all <", value, "cidAll");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllLessThanOrEqualTo(String value) {
            this.addCriterion("cid_all <=", value, "cidAll");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllLike(String value) {
            this.addCriterion("cid_all like", value, "cidAll");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllNotLike(String value) {
            this.addCriterion("cid_all not like", value, "cidAll");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andCidAllIn(List<String> values) {
            this.addCriterion("cid_all in", values, "cidAll");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllNotIn(List<String> values) {
            this.addCriterion("cid_all not in", values, "cidAll");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllBetween(String value1, String value2) {
            this.addCriterion("cid_all between", value1, value2, "cidAll");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCidAllNotBetween(String value1, String value2) {
            this.addCriterion("cid_all not between", value1, value2, "cidAll");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlIsNull() {
            this.addCriterion("pic_url is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlIsNotNull() {
            this.addCriterion("pic_url is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlEqualTo(String value) {
            this.addCriterion("pic_url =", value, "picUrl");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlNotEqualTo(String value) {
            this.addCriterion("pic_url <>", value, "picUrl");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlGreaterThan(String value) {
            this.addCriterion("pic_url >", value, "picUrl");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("pic_url >=", value, "picUrl");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlLessThan(String value) {
            this.addCriterion("pic_url <", value, "picUrl");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlLessThanOrEqualTo(String value) {
            this.addCriterion("pic_url <=", value, "picUrl");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlLike(String value) {
            this.addCriterion("pic_url like", value, "picUrl");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlNotLike(String value) {
            this.addCriterion("pic_url not like", value, "picUrl");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andPicUrlIn(List<String> values) {
            this.addCriterion("pic_url in", values, "picUrl");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlNotIn(List<String> values) {
            this.addCriterion("pic_url not in", values, "picUrl");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlBetween(String value1, String value2) {
            this.addCriterion("pic_url between", value1, value2, "picUrl");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPicUrlNotBetween(String value1, String value2) {
            this.addCriterion("pic_url not between", value1, value2, "picUrl");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIsNull() {
            this.addCriterion("num is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumIsNotNull() {
            this.addCriterion("num is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumEqualTo(Long value) {
            this.addCriterion("num =", value, "num");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumNotEqualTo(Long value) {
            this.addCriterion("num <>", value, "num");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumGreaterThan(Long value) {
            this.addCriterion("num >", value, "num");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumGreaterThanOrEqualTo(Long value) {
            this.addCriterion("num >=", value, "num");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumLessThan(Long value) {
            this.addCriterion("num <", value, "num");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumLessThanOrEqualTo(Long value) {
            this.addCriterion("num <=", value, "num");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumLike(String value) {
            this.addCriterion("num like", value, "num");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumNotLike(String value) {
            this.addCriterion("num not like", value, "num");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andNumIn(List<Long> values) {
            this.addCriterion("num in", values, "num");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumNotIn(List<Long> values) {
            this.addCriterion("num not in", values, "num");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumBetween(Long value1, Long value2) {
            this.addCriterion("num between", value1, value2, "num");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumNotBetween(Long value1, Long value2) {
            this.addCriterion("num not between", value1, value2, "num");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }
        @Deprecated
        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeIsNull() {
            this.addCriterion("sold_out_time is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }
        @Deprecated
        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeIsNotNull() {
            this.addCriterion("sold_out_time is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }
        @Deprecated
        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeEqualTo(Date value) {
            this.addCriterion("sold_out_time =", value, "soldOutTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }
        @Deprecated
        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeNotEqualTo(Date value) {
            this.addCriterion("sold_out_time <>", value, "soldOutTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }
        @Deprecated
        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeGreaterThan(Date value) {
            this.addCriterion("sold_out_time >", value, "soldOutTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }
        @Deprecated
        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("sold_out_time >=", value, "soldOutTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }
        @Deprecated
        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeLessThan(Date value) {
            this.addCriterion("sold_out_time <", value, "soldOutTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }
        @Deprecated
        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("sold_out_time <=", value, "soldOutTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }
        @Deprecated
        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeLike(String value) {
            this.addCriterion("sold_out_time like", value, "soldOutTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }
        @Deprecated
        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeNotLike(String value) {
            this.addCriterion("sold_out_time not like", value, "soldOutTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }
        @Deprecated
        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeIn(List<Date> values) {
            this.addCriterion("sold_out_time in", values, "soldOutTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }
        @Deprecated
        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeNotIn(List<Date> values) {
            this.addCriterion("sold_out_time not in", values, "soldOutTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }
        @Deprecated
        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeBetween(Date value1, Date value2) {
            this.addCriterion("sold_out_time between", value1, value2, "soldOutTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }
        @Deprecated
        public ShiguGoodsSoldoutExample.Criteria andSoldOutTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("sold_out_time not between", value1, value2, "soldOutTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andListTimeIsNull() {
            this.addCriterion("list_time is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andListTimeIsNotNull() {
            this.addCriterion("list_time is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andListTimeEqualTo(Date value) {
            this.addCriterion("list_time =", value, "listTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andListTimeNotEqualTo(Date value) {
            this.addCriterion("list_time <>", value, "listTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andListTimeGreaterThan(Date value) {
            this.addCriterion("list_time >", value, "listTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andListTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("list_time >=", value, "listTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andListTimeLessThan(Date value) {
            this.addCriterion("list_time <", value, "listTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andListTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("list_time <=", value, "listTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andListTimeLike(String value) {
            this.addCriterion("list_time like", value, "listTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andListTimeNotLike(String value) {
            this.addCriterion("list_time not like", value, "listTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andListTimeIn(List<Date> values) {
            this.addCriterion("list_time in", values, "listTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andListTimeNotIn(List<Date> values) {
            this.addCriterion("list_time not in", values, "listTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andListTimeBetween(Date value1, Date value2) {
            this.addCriterion("list_time between", value1, value2, "listTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andListTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("list_time not between", value1, value2, "listTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDelistTimeIsNull() {
            this.addCriterion("delist_time is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDelistTimeIsNotNull() {
            this.addCriterion("delist_time is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDelistTimeEqualTo(Date value) {
            this.addCriterion("delist_time =", value, "delistTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDelistTimeNotEqualTo(Date value) {
            this.addCriterion("delist_time <>", value, "delistTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDelistTimeGreaterThan(Date value) {
            this.addCriterion("delist_time >", value, "delistTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDelistTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("delist_time >=", value, "delistTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDelistTimeLessThan(Date value) {
            this.addCriterion("delist_time <", value, "delistTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDelistTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("delist_time <=", value, "delistTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDelistTimeLike(String value) {
            this.addCriterion("delist_time like", value, "delistTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDelistTimeNotLike(String value) {
            this.addCriterion("delist_time not like", value, "delistTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andDelistTimeIn(List<Date> values) {
            this.addCriterion("delist_time in", values, "delistTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDelistTimeNotIn(List<Date> values) {
            this.addCriterion("delist_time not in", values, "delistTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDelistTimeBetween(Date value1, Date value2) {
            this.addCriterion("delist_time between", value1, value2, "delistTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andDelistTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("delist_time not between", value1, value2, "delistTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusIsNull() {
            this.addCriterion("stuff_status is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusIsNotNull() {
            this.addCriterion("stuff_status is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusEqualTo(String value) {
            this.addCriterion("stuff_status =", value, "stuffStatus");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusNotEqualTo(String value) {
            this.addCriterion("stuff_status <>", value, "stuffStatus");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusGreaterThan(String value) {
            this.addCriterion("stuff_status >", value, "stuffStatus");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusGreaterThanOrEqualTo(String value) {
            this.addCriterion("stuff_status >=", value, "stuffStatus");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusLessThan(String value) {
            this.addCriterion("stuff_status <", value, "stuffStatus");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusLessThanOrEqualTo(String value) {
            this.addCriterion("stuff_status <=", value, "stuffStatus");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusLike(String value) {
            this.addCriterion("stuff_status like", value, "stuffStatus");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusNotLike(String value) {
            this.addCriterion("stuff_status not like", value, "stuffStatus");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andStuffStatusIn(List<String> values) {
            this.addCriterion("stuff_status in", values, "stuffStatus");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusNotIn(List<String> values) {
            this.addCriterion("stuff_status not in", values, "stuffStatus");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusBetween(String value1, String value2) {
            this.addCriterion("stuff_status between", value1, value2, "stuffStatus");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStuffStatusNotBetween(String value1, String value2) {
            this.addCriterion("stuff_status not between", value1, value2, "stuffStatus");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCityIsNull() {
            this.addCriterion("city is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCityIsNotNull() {
            this.addCriterion("city is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCityEqualTo(String value) {
            this.addCriterion("city =", value, "city");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCityNotEqualTo(String value) {
            this.addCriterion("city <>", value, "city");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCityGreaterThan(String value) {
            this.addCriterion("city >", value, "city");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCityGreaterThanOrEqualTo(String value) {
            this.addCriterion("city >=", value, "city");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCityLessThan(String value) {
            this.addCriterion("city <", value, "city");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCityLessThanOrEqualTo(String value) {
            this.addCriterion("city <=", value, "city");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCityLike(String value) {
            this.addCriterion("city like", value, "city");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCityNotLike(String value) {
            this.addCriterion("city not like", value, "city");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andCityIn(List<String> values) {
            this.addCriterion("city in", values, "city");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCityNotIn(List<String> values) {
            this.addCriterion("city not in", values, "city");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCityBetween(String value1, String value2) {
            this.addCriterion("city between", value1, value2, "city");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andCityNotBetween(String value1, String value2) {
            this.addCriterion("city not between", value1, value2, "city");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andProvIsNull() {
            this.addCriterion("prov is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andProvIsNotNull() {
            this.addCriterion("prov is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andProvEqualTo(String value) {
            this.addCriterion("prov =", value, "prov");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andProvNotEqualTo(String value) {
            this.addCriterion("prov <>", value, "prov");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andProvGreaterThan(String value) {
            this.addCriterion("prov >", value, "prov");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andProvGreaterThanOrEqualTo(String value) {
            this.addCriterion("prov >=", value, "prov");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andProvLessThan(String value) {
            this.addCriterion("prov <", value, "prov");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andProvLessThanOrEqualTo(String value) {
            this.addCriterion("prov <=", value, "prov");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andProvLike(String value) {
            this.addCriterion("prov like", value, "prov");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andProvNotLike(String value) {
            this.addCriterion("prov not like", value, "prov");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andProvIn(List<String> values) {
            this.addCriterion("prov in", values, "prov");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andProvNotIn(List<String> values) {
            this.addCriterion("prov not in", values, "prov");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andProvBetween(String value1, String value2) {
            this.addCriterion("prov between", value1, value2, "prov");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andProvNotBetween(String value1, String value2) {
            this.addCriterion("prov not between", value1, value2, "prov");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringIsNull() {
            this.addCriterion("price_string is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringIsNotNull() {
            this.addCriterion("price_string is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringEqualTo(String value) {
            this.addCriterion("price_string =", value, "priceString");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringNotEqualTo(String value) {
            this.addCriterion("price_string <>", value, "priceString");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringGreaterThan(String value) {
            this.addCriterion("price_string >", value, "priceString");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringGreaterThanOrEqualTo(String value) {
            this.addCriterion("price_string >=", value, "priceString");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringLessThan(String value) {
            this.addCriterion("price_string <", value, "priceString");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringLessThanOrEqualTo(String value) {
            this.addCriterion("price_string <=", value, "priceString");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringLike(String value) {
            this.addCriterion("price_string like", value, "priceString");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringNotLike(String value) {
            this.addCriterion("price_string not like", value, "priceString");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andPriceStringIn(List<String> values) {
            this.addCriterion("price_string in", values, "priceString");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringNotIn(List<String> values) {
            this.addCriterion("price_string not in", values, "priceString");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringBetween(String value1, String value2) {
            this.addCriterion("price_string between", value1, value2, "priceString");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceStringNotBetween(String value1, String value2) {
            this.addCriterion("price_string not between", value1, value2, "priceString");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceIsNull() {
            this.addCriterion("price is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceIsNotNull() {
            this.addCriterion("price is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceEqualTo(Long value) {
            this.addCriterion("price =", value, "price");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceNotEqualTo(Long value) {
            this.addCriterion("price <>", value, "price");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceGreaterThan(Long value) {
            this.addCriterion("price >", value, "price");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceGreaterThanOrEqualTo(Long value) {
            this.addCriterion("price >=", value, "price");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceLessThan(Long value) {
            this.addCriterion("price <", value, "price");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceLessThanOrEqualTo(Long value) {
            this.addCriterion("price <=", value, "price");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceLike(String value) {
            this.addCriterion("price like", value, "price");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceNotLike(String value) {
            this.addCriterion("price not like", value, "price");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andPriceIn(List<Long> values) {
            this.addCriterion("price in", values, "price");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceNotIn(List<Long> values) {
            this.addCriterion("price not in", values, "price");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceBetween(Long value1, Long value2) {
            this.addCriterion("price between", value1, value2, "price");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceNotBetween(Long value1, Long value2) {
            this.addCriterion("price not between", value1, value2, "price");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceIsNull() {
            this.addCriterion("pi_price is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceIsNotNull() {
            this.addCriterion("pi_price is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceEqualTo(Long value) {
            this.addCriterion("pi_price =", value, "piPrice");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceNotEqualTo(Long value) {
            this.addCriterion("pi_price <>", value, "piPrice");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceGreaterThan(Long value) {
            this.addCriterion("pi_price >", value, "piPrice");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceGreaterThanOrEqualTo(Long value) {
            this.addCriterion("pi_price >=", value, "piPrice");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceLessThan(Long value) {
            this.addCriterion("pi_price <", value, "piPrice");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceLessThanOrEqualTo(Long value) {
            this.addCriterion("pi_price <=", value, "piPrice");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceLike(String value) {
            this.addCriterion("pi_price like", value, "piPrice");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceNotLike(String value) {
            this.addCriterion("pi_price not like", value, "piPrice");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andPiPriceIn(List<Long> values) {
            this.addCriterion("pi_price in", values, "piPrice");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceNotIn(List<Long> values) {
            this.addCriterion("pi_price not in", values, "piPrice");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceBetween(Long value1, Long value2) {
            this.addCriterion("pi_price between", value1, value2, "piPrice");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceNotBetween(Long value1, Long value2) {
            this.addCriterion("pi_price not between", value1, value2, "piPrice");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringIsNull() {
            this.addCriterion("pi_price_string is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringIsNotNull() {
            this.addCriterion("pi_price_string is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringEqualTo(String value) {
            this.addCriterion("pi_price_string =", value, "piPriceString");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringNotEqualTo(String value) {
            this.addCriterion("pi_price_string <>", value, "piPriceString");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringGreaterThan(String value) {
            this.addCriterion("pi_price_string >", value, "piPriceString");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringGreaterThanOrEqualTo(String value) {
            this.addCriterion("pi_price_string >=", value, "piPriceString");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringLessThan(String value) {
            this.addCriterion("pi_price_string <", value, "piPriceString");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringLessThanOrEqualTo(String value) {
            this.addCriterion("pi_price_string <=", value, "piPriceString");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringLike(String value) {
            this.addCriterion("pi_price_string like", value, "piPriceString");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringNotLike(String value) {
            this.addCriterion("pi_price_string not like", value, "piPriceString");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringIn(List<String> values) {
            this.addCriterion("pi_price_string in", values, "piPriceString");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringNotIn(List<String> values) {
            this.addCriterion("pi_price_string not in", values, "piPriceString");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringBetween(String value1, String value2) {
            this.addCriterion("pi_price_string between", value1, value2, "piPriceString");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPiPriceStringNotBetween(String value1, String value2) {
            this.addCriterion("pi_price_string not between", value1, value2, "piPriceString");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleIsNull() {
            this.addCriterion("price_role is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleIsNotNull() {
            this.addCriterion("price_role is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleEqualTo(String value) {
            this.addCriterion("price_role =", value, "priceRole");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleNotEqualTo(String value) {
            this.addCriterion("price_role <>", value, "priceRole");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleGreaterThan(String value) {
            this.addCriterion("price_role >", value, "priceRole");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleGreaterThanOrEqualTo(String value) {
            this.addCriterion("price_role >=", value, "priceRole");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleLessThan(String value) {
            this.addCriterion("price_role <", value, "priceRole");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleLessThanOrEqualTo(String value) {
            this.addCriterion("price_role <=", value, "priceRole");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleLike(String value) {
            this.addCriterion("price_role like", value, "priceRole");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleNotLike(String value) {
            this.addCriterion("price_role not like", value, "priceRole");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andPriceRoleIn(List<String> values) {
            this.addCriterion("price_role in", values, "priceRole");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleNotIn(List<String> values) {
            this.addCriterion("price_role not in", values, "priceRole");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleBetween(String value1, String value2) {
            this.addCriterion("price_role between", value1, value2, "priceRole");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPriceRoleNotBetween(String value1, String value2) {
            this.addCriterion("price_role not between", value1, value2, "priceRole");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeIsNull() {
            this.addCriterion("post_fee is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeIsNotNull() {
            this.addCriterion("post_fee is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeEqualTo(String value) {
            this.addCriterion("post_fee =", value, "postFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeNotEqualTo(String value) {
            this.addCriterion("post_fee <>", value, "postFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeGreaterThan(String value) {
            this.addCriterion("post_fee >", value, "postFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeGreaterThanOrEqualTo(String value) {
            this.addCriterion("post_fee >=", value, "postFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeLessThan(String value) {
            this.addCriterion("post_fee <", value, "postFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeLessThanOrEqualTo(String value) {
            this.addCriterion("post_fee <=", value, "postFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeLike(String value) {
            this.addCriterion("post_fee like", value, "postFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeNotLike(String value) {
            this.addCriterion("post_fee not like", value, "postFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andPostFeeIn(List<String> values) {
            this.addCriterion("post_fee in", values, "postFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeNotIn(List<String> values) {
            this.addCriterion("post_fee not in", values, "postFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeBetween(String value1, String value2) {
            this.addCriterion("post_fee between", value1, value2, "postFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andPostFeeNotBetween(String value1, String value2) {
            this.addCriterion("post_fee not between", value1, value2, "postFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeIsNull() {
            this.addCriterion("express_fee is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeIsNotNull() {
            this.addCriterion("express_fee is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeEqualTo(String value) {
            this.addCriterion("express_fee =", value, "expressFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeNotEqualTo(String value) {
            this.addCriterion("express_fee <>", value, "expressFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeGreaterThan(String value) {
            this.addCriterion("express_fee >", value, "expressFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeGreaterThanOrEqualTo(String value) {
            this.addCriterion("express_fee >=", value, "expressFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeLessThan(String value) {
            this.addCriterion("express_fee <", value, "expressFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeLessThanOrEqualTo(String value) {
            this.addCriterion("express_fee <=", value, "expressFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeLike(String value) {
            this.addCriterion("express_fee like", value, "expressFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeNotLike(String value) {
            this.addCriterion("express_fee not like", value, "expressFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andExpressFeeIn(List<String> values) {
            this.addCriterion("express_fee in", values, "expressFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeNotIn(List<String> values) {
            this.addCriterion("express_fee not in", values, "expressFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeBetween(String value1, String value2) {
            this.addCriterion("express_fee between", value1, value2, "expressFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andExpressFeeNotBetween(String value1, String value2) {
            this.addCriterion("express_fee not between", value1, value2, "expressFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeIsNull() {
            this.addCriterion("ems_fee is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeIsNotNull() {
            this.addCriterion("ems_fee is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeEqualTo(String value) {
            this.addCriterion("ems_fee =", value, "emsFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeNotEqualTo(String value) {
            this.addCriterion("ems_fee <>", value, "emsFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeGreaterThan(String value) {
            this.addCriterion("ems_fee >", value, "emsFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeGreaterThanOrEqualTo(String value) {
            this.addCriterion("ems_fee >=", value, "emsFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeLessThan(String value) {
            this.addCriterion("ems_fee <", value, "emsFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeLessThanOrEqualTo(String value) {
            this.addCriterion("ems_fee <=", value, "emsFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeLike(String value) {
            this.addCriterion("ems_fee like", value, "emsFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeNotLike(String value) {
            this.addCriterion("ems_fee not like", value, "emsFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andEmsFeeIn(List<String> values) {
            this.addCriterion("ems_fee in", values, "emsFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeNotIn(List<String> values) {
            this.addCriterion("ems_fee not in", values, "emsFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeBetween(String value1, String value2) {
            this.addCriterion("ems_fee between", value1, value2, "emsFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andEmsFeeNotBetween(String value1, String value2) {
            this.addCriterion("ems_fee not between", value1, value2, "emsFee");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountIsNull() {
            this.addCriterion("has_discount is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountIsNotNull() {
            this.addCriterion("has_discount is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountEqualTo(String value) {
            this.addCriterion("has_discount =", value, "hasDiscount");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountNotEqualTo(String value) {
            this.addCriterion("has_discount <>", value, "hasDiscount");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountGreaterThan(String value) {
            this.addCriterion("has_discount >", value, "hasDiscount");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountGreaterThanOrEqualTo(String value) {
            this.addCriterion("has_discount >=", value, "hasDiscount");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountLessThan(String value) {
            this.addCriterion("has_discount <", value, "hasDiscount");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountLessThanOrEqualTo(String value) {
            this.addCriterion("has_discount <=", value, "hasDiscount");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountLike(String value) {
            this.addCriterion("has_discount like", value, "hasDiscount");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountNotLike(String value) {
            this.addCriterion("has_discount not like", value, "hasDiscount");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andHasDiscountIn(List<String> values) {
            this.addCriterion("has_discount in", values, "hasDiscount");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountNotIn(List<String> values) {
            this.addCriterion("has_discount not in", values, "hasDiscount");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountBetween(String value1, String value2) {
            this.addCriterion("has_discount between", value1, value2, "hasDiscount");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasDiscountNotBetween(String value1, String value2) {
            this.addCriterion("has_discount not between", value1, value2, "hasDiscount");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerIsNull() {
            this.addCriterion("freight_payer is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerIsNotNull() {
            this.addCriterion("freight_payer is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerEqualTo(String value) {
            this.addCriterion("freight_payer =", value, "freightPayer");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerNotEqualTo(String value) {
            this.addCriterion("freight_payer <>", value, "freightPayer");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerGreaterThan(String value) {
            this.addCriterion("freight_payer >", value, "freightPayer");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerGreaterThanOrEqualTo(String value) {
            this.addCriterion("freight_payer >=", value, "freightPayer");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerLessThan(String value) {
            this.addCriterion("freight_payer <", value, "freightPayer");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerLessThanOrEqualTo(String value) {
            this.addCriterion("freight_payer <=", value, "freightPayer");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerLike(String value) {
            this.addCriterion("freight_payer like", value, "freightPayer");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerNotLike(String value) {
            this.addCriterion("freight_payer not like", value, "freightPayer");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andFreightPayerIn(List<String> values) {
            this.addCriterion("freight_payer in", values, "freightPayer");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerNotIn(List<String> values) {
            this.addCriterion("freight_payer not in", values, "freightPayer");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerBetween(String value1, String value2) {
            this.addCriterion("freight_payer between", value1, value2, "freightPayer");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andFreightPayerNotBetween(String value1, String value2) {
            this.addCriterion("freight_payer not between", value1, value2, "freightPayer");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseIsNull() {
            this.addCriterion("has_showcase is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseIsNotNull() {
            this.addCriterion("has_showcase is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseEqualTo(String value) {
            this.addCriterion("has_showcase =", value, "hasShowcase");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseNotEqualTo(String value) {
            this.addCriterion("has_showcase <>", value, "hasShowcase");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseGreaterThan(String value) {
            this.addCriterion("has_showcase >", value, "hasShowcase");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseGreaterThanOrEqualTo(String value) {
            this.addCriterion("has_showcase >=", value, "hasShowcase");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseLessThan(String value) {
            this.addCriterion("has_showcase <", value, "hasShowcase");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseLessThanOrEqualTo(String value) {
            this.addCriterion("has_showcase <=", value, "hasShowcase");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseLike(String value) {
            this.addCriterion("has_showcase like", value, "hasShowcase");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseNotLike(String value) {
            this.addCriterion("has_showcase not like", value, "hasShowcase");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseIn(List<String> values) {
            this.addCriterion("has_showcase in", values, "hasShowcase");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseNotIn(List<String> values) {
            this.addCriterion("has_showcase not in", values, "hasShowcase");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseBetween(String value1, String value2) {
            this.addCriterion("has_showcase between", value1, value2, "hasShowcase");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andHasShowcaseNotBetween(String value1, String value2) {
            this.addCriterion("has_showcase not between", value1, value2, "hasShowcase");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andModifiedIsNull() {
            this.addCriterion("modified is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andModifiedIsNotNull() {
            this.addCriterion("modified is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andModifiedEqualTo(Date value) {
            this.addCriterion("modified =", value, "modified");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andModifiedNotEqualTo(Date value) {
            this.addCriterion("modified <>", value, "modified");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andModifiedGreaterThan(Date value) {
            this.addCriterion("modified >", value, "modified");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andModifiedGreaterThanOrEqualTo(Date value) {
            this.addCriterion("modified >=", value, "modified");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andModifiedLessThan(Date value) {
            this.addCriterion("modified <", value, "modified");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andModifiedLessThanOrEqualTo(Date value) {
            this.addCriterion("modified <=", value, "modified");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andModifiedLike(String value) {
            this.addCriterion("modified like", value, "modified");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andModifiedNotLike(String value) {
            this.addCriterion("modified not like", value, "modified");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andModifiedIn(List<Date> values) {
            this.addCriterion("modified in", values, "modified");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andModifiedNotIn(List<Date> values) {
            this.addCriterion("modified not in", values, "modified");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andModifiedBetween(Date value1, Date value2) {
            this.addCriterion("modified between", value1, value2, "modified");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andModifiedNotBetween(Date value1, Date value2) {
            this.addCriterion("modified not between", value1, value2, "modified");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIdIsNull() {
            this.addCriterion("market_id is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIdIsNotNull() {
            this.addCriterion("market_id is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIdEqualTo(Long value) {
            this.addCriterion("market_id =", value, "marketId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIdNotEqualTo(Long value) {
            this.addCriterion("market_id <>", value, "marketId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIdGreaterThan(Long value) {
            this.addCriterion("market_id >", value, "marketId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("market_id >=", value, "marketId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIdLessThan(Long value) {
            this.addCriterion("market_id <", value, "marketId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            this.addCriterion("market_id <=", value, "marketId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIdLike(String value) {
            this.addCriterion("market_id like", value, "marketId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIdNotLike(String value) {
            this.addCriterion("market_id not like", value, "marketId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andMarketIdIn(List<Long> values) {
            this.addCriterion("market_id in", values, "marketId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIdNotIn(List<Long> values) {
            this.addCriterion("market_id not in", values, "marketId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            this.addCriterion("market_id between", value1, value2, "marketId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            this.addCriterion("market_id not between", value1, value2, "marketId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIsNull() {
            this.addCriterion("market is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketIsNotNull() {
            this.addCriterion("market is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketEqualTo(String value) {
            this.addCriterion("market =", value, "market");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketNotEqualTo(String value) {
            this.addCriterion("market <>", value, "market");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketGreaterThan(String value) {
            this.addCriterion("market >", value, "market");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketGreaterThanOrEqualTo(String value) {
            this.addCriterion("market >=", value, "market");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketLessThan(String value) {
            this.addCriterion("market <", value, "market");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketLessThanOrEqualTo(String value) {
            this.addCriterion("market <=", value, "market");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketLike(String value) {
            this.addCriterion("market like", value, "market");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketNotLike(String value) {
            this.addCriterion("market not like", value, "market");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andMarketIn(List<String> values) {
            this.addCriterion("market in", values, "market");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketNotIn(List<String> values) {
            this.addCriterion("market not in", values, "market");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketBetween(String value1, String value2) {
            this.addCriterion("market between", value1, value2, "market");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andMarketNotBetween(String value1, String value2) {
            this.addCriterion("market not between", value1, value2, "market");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdIsNull() {
            this.addCriterion("parent_market_id is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdIsNotNull() {
            this.addCriterion("parent_market_id is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdEqualTo(Long value) {
            this.addCriterion("parent_market_id =", value, "parentMarketId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdNotEqualTo(Long value) {
            this.addCriterion("parent_market_id <>", value, "parentMarketId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdGreaterThan(Long value) {
            this.addCriterion("parent_market_id >", value, "parentMarketId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("parent_market_id >=", value, "parentMarketId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdLessThan(Long value) {
            this.addCriterion("parent_market_id <", value, "parentMarketId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdLessThanOrEqualTo(Long value) {
            this.addCriterion("parent_market_id <=", value, "parentMarketId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdLike(String value) {
            this.addCriterion("parent_market_id like", value, "parentMarketId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdNotLike(String value) {
            this.addCriterion("parent_market_id not like", value, "parentMarketId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdIn(List<Long> values) {
            this.addCriterion("parent_market_id in", values, "parentMarketId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdNotIn(List<Long> values) {
            this.addCriterion("parent_market_id not in", values, "parentMarketId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdBetween(Long value1, Long value2) {
            this.addCriterion("parent_market_id between", value1, value2, "parentMarketId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketIdNotBetween(Long value1, Long value2) {
            this.addCriterion("parent_market_id not between", value1, value2, "parentMarketId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameIsNull() {
            this.addCriterion("parent_market_name is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameIsNotNull() {
            this.addCriterion("parent_market_name is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameEqualTo(String value) {
            this.addCriterion("parent_market_name =", value, "parentMarketName");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameNotEqualTo(String value) {
            this.addCriterion("parent_market_name <>", value, "parentMarketName");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameGreaterThan(String value) {
            this.addCriterion("parent_market_name >", value, "parentMarketName");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("parent_market_name >=", value, "parentMarketName");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameLessThan(String value) {
            this.addCriterion("parent_market_name <", value, "parentMarketName");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameLessThanOrEqualTo(String value) {
            this.addCriterion("parent_market_name <=", value, "parentMarketName");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameLike(String value) {
            this.addCriterion("parent_market_name like", value, "parentMarketName");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameNotLike(String value) {
            this.addCriterion("parent_market_name not like", value, "parentMarketName");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameIn(List<String> values) {
            this.addCriterion("parent_market_name in", values, "parentMarketName");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameNotIn(List<String> values) {
            this.addCriterion("parent_market_name not in", values, "parentMarketName");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameBetween(String value1, String value2) {
            this.addCriterion("parent_market_name between", value1, value2, "parentMarketName");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andParentMarketNameNotBetween(String value1, String value2) {
            this.addCriterion("parent_market_name not between", value1, value2, "parentMarketName");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumIsNull() {
            this.addCriterion("store_num is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumIsNotNull() {
            this.addCriterion("store_num is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumEqualTo(String value) {
            this.addCriterion("store_num =", value, "storeNum");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumNotEqualTo(String value) {
            this.addCriterion("store_num <>", value, "storeNum");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumGreaterThan(String value) {
            this.addCriterion("store_num >", value, "storeNum");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumGreaterThanOrEqualTo(String value) {
            this.addCriterion("store_num >=", value, "storeNum");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumLessThan(String value) {
            this.addCriterion("store_num <", value, "storeNum");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumLessThanOrEqualTo(String value) {
            this.addCriterion("store_num <=", value, "storeNum");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumLike(String value) {
            this.addCriterion("store_num like", value, "storeNum");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumNotLike(String value) {
            this.addCriterion("store_num not like", value, "storeNum");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andStoreNumIn(List<String> values) {
            this.addCriterion("store_num in", values, "storeNum");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumNotIn(List<String> values) {
            this.addCriterion("store_num not in", values, "storeNum");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumBetween(String value1, String value2) {
            this.addCriterion("store_num between", value1, value2, "storeNum");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreNumNotBetween(String value1, String value2) {
            this.addCriterion("store_num not between", value1, value2, "storeNum");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationIsNull() {
            this.addCriterion("is_taobao_synchronization is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationIsNotNull() {
            this.addCriterion("is_taobao_synchronization is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationEqualTo(Long value) {
            this.addCriterion("is_taobao_synchronization =", value, "isTaobaoSynchronization");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationNotEqualTo(Long value) {
            this.addCriterion("is_taobao_synchronization <>", value, "isTaobaoSynchronization");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationGreaterThan(Long value) {
            this.addCriterion("is_taobao_synchronization >", value, "isTaobaoSynchronization");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationGreaterThanOrEqualTo(Long value) {
            this.addCriterion("is_taobao_synchronization >=", value, "isTaobaoSynchronization");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationLessThan(Long value) {
            this.addCriterion("is_taobao_synchronization <", value, "isTaobaoSynchronization");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationLessThanOrEqualTo(Long value) {
            this.addCriterion("is_taobao_synchronization <=", value, "isTaobaoSynchronization");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationLike(String value) {
            this.addCriterion("is_taobao_synchronization like", value, "isTaobaoSynchronization");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationNotLike(String value) {
            this.addCriterion("is_taobao_synchronization not like", value, "isTaobaoSynchronization");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationIn(List<Long> values) {
            this.addCriterion("is_taobao_synchronization in", values, "isTaobaoSynchronization");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationNotIn(List<Long> values) {
            this.addCriterion("is_taobao_synchronization not in", values, "isTaobaoSynchronization");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationBetween(Long value1, Long value2) {
            this.addCriterion("is_taobao_synchronization between", value1, value2, "isTaobaoSynchronization");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTaobaoSynchronizationNotBetween(Long value1, Long value2) {
            this.addCriterion("is_taobao_synchronization not between", value1, value2, "isTaobaoSynchronization");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadIsNull() {
            this.addCriterion("is_akey_to_upload is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadIsNotNull() {
            this.addCriterion("is_akey_to_upload is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadEqualTo(Long value) {
            this.addCriterion("is_akey_to_upload =", value, "isAkeyToUpload");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadNotEqualTo(Long value) {
            this.addCriterion("is_akey_to_upload <>", value, "isAkeyToUpload");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadGreaterThan(Long value) {
            this.addCriterion("is_akey_to_upload >", value, "isAkeyToUpload");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadGreaterThanOrEqualTo(Long value) {
            this.addCriterion("is_akey_to_upload >=", value, "isAkeyToUpload");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadLessThan(Long value) {
            this.addCriterion("is_akey_to_upload <", value, "isAkeyToUpload");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadLessThanOrEqualTo(Long value) {
            this.addCriterion("is_akey_to_upload <=", value, "isAkeyToUpload");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadLike(String value) {
            this.addCriterion("is_akey_to_upload like", value, "isAkeyToUpload");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadNotLike(String value) {
            this.addCriterion("is_akey_to_upload not like", value, "isAkeyToUpload");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadIn(List<Long> values) {
            this.addCriterion("is_akey_to_upload in", values, "isAkeyToUpload");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadNotIn(List<Long> values) {
            this.addCriterion("is_akey_to_upload not in", values, "isAkeyToUpload");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadBetween(Long value1, Long value2) {
            this.addCriterion("is_akey_to_upload between", value1, value2, "isAkeyToUpload");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsAkeyToUploadNotBetween(Long value1, Long value2) {
            this.addCriterion("is_akey_to_upload not between", value1, value2, "isAkeyToUpload");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTradeIsNull() {
            this.addCriterion("is_trade is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTradeIsNotNull() {
            this.addCriterion("is_trade is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTradeEqualTo(Long value) {
            this.addCriterion("is_trade =", value, "isTrade");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTradeNotEqualTo(Long value) {
            this.addCriterion("is_trade <>", value, "isTrade");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTradeGreaterThan(Long value) {
            this.addCriterion("is_trade >", value, "isTrade");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTradeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("is_trade >=", value, "isTrade");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTradeLessThan(Long value) {
            this.addCriterion("is_trade <", value, "isTrade");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTradeLessThanOrEqualTo(Long value) {
            this.addCriterion("is_trade <=", value, "isTrade");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTradeLike(String value) {
            this.addCriterion("is_trade like", value, "isTrade");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTradeNotLike(String value) {
            this.addCriterion("is_trade not like", value, "isTrade");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andIsTradeIn(List<Long> values) {
            this.addCriterion("is_trade in", values, "isTrade");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTradeNotIn(List<Long> values) {
            this.addCriterion("is_trade not in", values, "isTrade");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTradeBetween(Long value1, Long value2) {
            this.addCriterion("is_trade between", value1, value2, "isTrade");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsTradeNotBetween(Long value1, Long value2) {
            this.addCriterion("is_trade not between", value1, value2, "isTrade");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousIsNull() {
            this.addCriterion("is_efficacious is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousIsNotNull() {
            this.addCriterion("is_efficacious is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousEqualTo(Long value) {
            this.addCriterion("is_efficacious =", value, "isEfficacious");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousNotEqualTo(Long value) {
            this.addCriterion("is_efficacious <>", value, "isEfficacious");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousGreaterThan(Long value) {
            this.addCriterion("is_efficacious >", value, "isEfficacious");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousGreaterThanOrEqualTo(Long value) {
            this.addCriterion("is_efficacious >=", value, "isEfficacious");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousLessThan(Long value) {
            this.addCriterion("is_efficacious <", value, "isEfficacious");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousLessThanOrEqualTo(Long value) {
            this.addCriterion("is_efficacious <=", value, "isEfficacious");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousLike(String value) {
            this.addCriterion("is_efficacious like", value, "isEfficacious");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousNotLike(String value) {
            this.addCriterion("is_efficacious not like", value, "isEfficacious");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousIn(List<Long> values) {
            this.addCriterion("is_efficacious in", values, "isEfficacious");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousNotIn(List<Long> values) {
            this.addCriterion("is_efficacious not in", values, "isEfficacious");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousBetween(Long value1, Long value2) {
            this.addCriterion("is_efficacious between", value1, value2, "isEfficacious");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsEfficaciousNotBetween(Long value1, Long value2) {
            this.addCriterion("is_efficacious not between", value1, value2, "isEfficacious");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreIdIsNull() {
            this.addCriterion("store_id is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreIdIsNotNull() {
            this.addCriterion("store_id is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreIdEqualTo(Long value) {
            this.addCriterion("store_id =", value, "storeId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreIdNotEqualTo(Long value) {
            this.addCriterion("store_id <>", value, "storeId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreIdGreaterThan(Long value) {
            this.addCriterion("store_id >", value, "storeId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("store_id >=", value, "storeId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreIdLessThan(Long value) {
            this.addCriterion("store_id <", value, "storeId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            this.addCriterion("store_id <=", value, "storeId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreIdLike(String value) {
            this.addCriterion("store_id like", value, "storeId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreIdNotLike(String value) {
            this.addCriterion("store_id not like", value, "storeId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andStoreIdIn(List<Long> values) {
            this.addCriterion("store_id in", values, "storeId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreIdNotIn(List<Long> values) {
            this.addCriterion("store_id not in", values, "storeId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            this.addCriterion("store_id between", value1, value2, "storeId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            this.addCriterion("store_id not between", value1, value2, "storeId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andClicksIsNull() {
            this.addCriterion("clicks is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andClicksIsNotNull() {
            this.addCriterion("clicks is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andClicksEqualTo(Long value) {
            this.addCriterion("clicks =", value, "clicks");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andClicksNotEqualTo(Long value) {
            this.addCriterion("clicks <>", value, "clicks");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andClicksGreaterThan(Long value) {
            this.addCriterion("clicks >", value, "clicks");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andClicksGreaterThanOrEqualTo(Long value) {
            this.addCriterion("clicks >=", value, "clicks");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andClicksLessThan(Long value) {
            this.addCriterion("clicks <", value, "clicks");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andClicksLessThanOrEqualTo(Long value) {
            this.addCriterion("clicks <=", value, "clicks");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andClicksLike(String value) {
            this.addCriterion("clicks like", value, "clicks");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andClicksNotLike(String value) {
            this.addCriterion("clicks not like", value, "clicks");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andClicksIn(List<Long> values) {
            this.addCriterion("clicks in", values, "clicks");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andClicksNotIn(List<Long> values) {
            this.addCriterion("clicks not in", values, "clicks");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andClicksBetween(Long value1, Long value2) {
            this.addCriterion("clicks between", value1, value2, "clicks");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andClicksNotBetween(Long value1, Long value2) {
            this.addCriterion("clicks not between", value1, value2, "clicks");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsClosedIsNull() {
            this.addCriterion("is_closed is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsClosedIsNotNull() {
            this.addCriterion("is_closed is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsClosedEqualTo(Long value) {
            this.addCriterion("is_closed =", value, "isClosed");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsClosedNotEqualTo(Long value) {
            this.addCriterion("is_closed <>", value, "isClosed");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsClosedGreaterThan(Long value) {
            this.addCriterion("is_closed >", value, "isClosed");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsClosedGreaterThanOrEqualTo(Long value) {
            this.addCriterion("is_closed >=", value, "isClosed");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsClosedLessThan(Long value) {
            this.addCriterion("is_closed <", value, "isClosed");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsClosedLessThanOrEqualTo(Long value) {
            this.addCriterion("is_closed <=", value, "isClosed");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsClosedLike(String value) {
            this.addCriterion("is_closed like", value, "isClosed");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsClosedNotLike(String value) {
            this.addCriterion("is_closed not like", value, "isClosed");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andIsClosedIn(List<Long> values) {
            this.addCriterion("is_closed in", values, "isClosed");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsClosedNotIn(List<Long> values) {
            this.addCriterion("is_closed not in", values, "isClosed");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsClosedBetween(Long value1, Long value2) {
            this.addCriterion("is_closed between", value1, value2, "isClosed");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsClosedNotBetween(Long value1, Long value2) {
            this.addCriterion("is_closed not between", value1, value2, "isClosed");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusIsNull() {
            this.addCriterion("goods_status is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusIsNotNull() {
            this.addCriterion("goods_status is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusEqualTo(Integer value) {
            this.addCriterion("goods_status =", value, "goodsStatus");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusNotEqualTo(Integer value) {
            this.addCriterion("goods_status <>", value, "goodsStatus");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusGreaterThan(Integer value) {
            this.addCriterion("goods_status >", value, "goodsStatus");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("goods_status >=", value, "goodsStatus");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusLessThan(Integer value) {
            this.addCriterion("goods_status <", value, "goodsStatus");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("goods_status <=", value, "goodsStatus");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusLike(String value) {
            this.addCriterion("goods_status like", value, "goodsStatus");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusNotLike(String value) {
            this.addCriterion("goods_status not like", value, "goodsStatus");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusIn(List<Integer> values) {
            this.addCriterion("goods_status in", values, "goodsStatus");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusNotIn(List<Integer> values) {
            this.addCriterion("goods_status not in", values, "goodsStatus");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("goods_status between", value1, value2, "goodsStatus");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("goods_status not between", value1, value2, "goodsStatus");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoIsNull() {
            this.addCriterion("goods_no is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoIsNotNull() {
            this.addCriterion("goods_no is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoEqualTo(String value) {
            this.addCriterion("goods_no =", value, "goodsNo");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoNotEqualTo(String value) {
            this.addCriterion("goods_no <>", value, "goodsNo");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoGreaterThan(String value) {
            this.addCriterion("goods_no >", value, "goodsNo");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoGreaterThanOrEqualTo(String value) {
            this.addCriterion("goods_no >=", value, "goodsNo");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoLessThan(String value) {
            this.addCriterion("goods_no <", value, "goodsNo");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoLessThanOrEqualTo(String value) {
            this.addCriterion("goods_no <=", value, "goodsNo");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoLike(String value) {
            this.addCriterion("goods_no like", value, "goodsNo");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoNotLike(String value) {
            this.addCriterion("goods_no not like", value, "goodsNo");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andGoodsNoIn(List<String> values) {
            this.addCriterion("goods_no in", values, "goodsNo");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoNotIn(List<String> values) {
            this.addCriterion("goods_no not in", values, "goodsNo");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoBetween(String value1, String value2) {
            this.addCriterion("goods_no between", value1, value2, "goodsNo");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andGoodsNoNotBetween(String value1, String value2) {
            this.addCriterion("goods_no not between", value1, value2, "goodsNo");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSortOrderIsNull() {
            this.addCriterion("sort_order is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSortOrderIsNotNull() {
            this.addCriterion("sort_order is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSortOrderEqualTo(Long value) {
            this.addCriterion("sort_order =", value, "sortOrder");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSortOrderNotEqualTo(Long value) {
            this.addCriterion("sort_order <>", value, "sortOrder");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSortOrderGreaterThan(Long value) {
            this.addCriterion("sort_order >", value, "sortOrder");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSortOrderGreaterThanOrEqualTo(Long value) {
            this.addCriterion("sort_order >=", value, "sortOrder");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSortOrderLessThan(Long value) {
            this.addCriterion("sort_order <", value, "sortOrder");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSortOrderLessThanOrEqualTo(Long value) {
            this.addCriterion("sort_order <=", value, "sortOrder");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSortOrderLike(String value) {
            this.addCriterion("sort_order like", value, "sortOrder");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSortOrderNotLike(String value) {
            this.addCriterion("sort_order not like", value, "sortOrder");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andSortOrderIn(List<Long> values) {
            this.addCriterion("sort_order in", values, "sortOrder");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSortOrderNotIn(List<Long> values) {
            this.addCriterion("sort_order not in", values, "sortOrder");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSortOrderBetween(Long value1, Long value2) {
            this.addCriterion("sort_order between", value1, value2, "sortOrder");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSortOrderNotBetween(Long value1, Long value2) {
            this.addCriterion("sort_order not between", value1, value2, "sortOrder");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsIsNull() {
            this.addCriterion("number_tradable_goods is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsIsNotNull() {
            this.addCriterion("number_tradable_goods is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsEqualTo(Long value) {
            this.addCriterion("number_tradable_goods =", value, "numberTradableGoods");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsNotEqualTo(Long value) {
            this.addCriterion("number_tradable_goods <>", value, "numberTradableGoods");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsGreaterThan(Long value) {
            this.addCriterion("number_tradable_goods >", value, "numberTradableGoods");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsGreaterThanOrEqualTo(Long value) {
            this.addCriterion("number_tradable_goods >=", value, "numberTradableGoods");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsLessThan(Long value) {
            this.addCriterion("number_tradable_goods <", value, "numberTradableGoods");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsLessThanOrEqualTo(Long value) {
            this.addCriterion("number_tradable_goods <=", value, "numberTradableGoods");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsLike(String value) {
            this.addCriterion("number_tradable_goods like", value, "numberTradableGoods");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsNotLike(String value) {
            this.addCriterion("number_tradable_goods not like", value, "numberTradableGoods");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsIn(List<Long> values) {
            this.addCriterion("number_tradable_goods in", values, "numberTradableGoods");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsNotIn(List<Long> values) {
            this.addCriterion("number_tradable_goods not in", values, "numberTradableGoods");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsBetween(Long value1, Long value2) {
            this.addCriterion("number_tradable_goods between", value1, value2, "numberTradableGoods");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNumberTradableGoodsNotBetween(Long value1, Long value2) {
            this.addCriterion("number_tradable_goods not between", value1, value2, "numberTradableGoods");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsIsNull() {
            this.addCriterion("not_number_tradable_goods is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsIsNotNull() {
            this.addCriterion("not_number_tradable_goods is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsEqualTo(Long value) {
            this.addCriterion("not_number_tradable_goods =", value, "notNumberTradableGoods");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsNotEqualTo(Long value) {
            this.addCriterion("not_number_tradable_goods <>", value, "notNumberTradableGoods");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsGreaterThan(Long value) {
            this.addCriterion("not_number_tradable_goods >", value, "notNumberTradableGoods");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsGreaterThanOrEqualTo(Long value) {
            this.addCriterion("not_number_tradable_goods >=", value, "notNumberTradableGoods");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsLessThan(Long value) {
            this.addCriterion("not_number_tradable_goods <", value, "notNumberTradableGoods");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsLessThanOrEqualTo(Long value) {
            this.addCriterion("not_number_tradable_goods <=", value, "notNumberTradableGoods");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsLike(String value) {
            this.addCriterion("not_number_tradable_goods like", value, "notNumberTradableGoods");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsNotLike(String value) {
            this.addCriterion("not_number_tradable_goods not like", value, "notNumberTradableGoods");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsIn(List<Long> values) {
            this.addCriterion("not_number_tradable_goods in", values, "notNumberTradableGoods");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsNotIn(List<Long> values) {
            this.addCriterion("not_number_tradable_goods not in", values, "notNumberTradableGoods");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsBetween(Long value1, Long value2) {
            this.addCriterion("not_number_tradable_goods between", value1, value2, "notNumberTradableGoods");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andNotNumberTradableGoodsNotBetween(Long value1, Long value2) {
            this.addCriterion("not_number_tradable_goods not between", value1, value2, "notNumberTradableGoods");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteIsNull() {
            this.addCriterion("web_site is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteIsNotNull() {
            this.addCriterion("web_site is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("web_site =", value, "webSite");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("web_site <>", value, "webSite");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("web_site >", value, "webSite");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("web_site >=", value, "webSite");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteLessThan(String value) {
            this.addCriterion("web_site <", value, "webSite");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("web_site <=", value, "webSite");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteLike(String value) {
            this.addCriterion("web_site like", value, "webSite");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteNotLike(String value) {
            this.addCriterion("web_site not like", value, "webSite");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("web_site in", values, "webSite");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("web_site not in", values, "webSite");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("web_site between", value1, value2, "webSite");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("web_site not between", value1, value2, "webSite");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonIsNull() {
            this.addCriterion("soldout_reason is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonIsNotNull() {
            this.addCriterion("soldout_reason is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonEqualTo(String value) {
            this.addCriterion("soldout_reason =", value, "soldoutReason");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonNotEqualTo(String value) {
            this.addCriterion("soldout_reason <>", value, "soldoutReason");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonGreaterThan(String value) {
            this.addCriterion("soldout_reason >", value, "soldoutReason");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonGreaterThanOrEqualTo(String value) {
            this.addCriterion("soldout_reason >=", value, "soldoutReason");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonLessThan(String value) {
            this.addCriterion("soldout_reason <", value, "soldoutReason");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonLessThanOrEqualTo(String value) {
            this.addCriterion("soldout_reason <=", value, "soldoutReason");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonLike(String value) {
            this.addCriterion("soldout_reason like", value, "soldoutReason");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonNotLike(String value) {
            this.addCriterion("soldout_reason not like", value, "soldoutReason");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonIn(List<String> values) {
            this.addCriterion("soldout_reason in", values, "soldoutReason");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonNotIn(List<String> values) {
            this.addCriterion("soldout_reason not in", values, "soldoutReason");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonBetween(String value1, String value2) {
            this.addCriterion("soldout_reason between", value1, value2, "soldoutReason");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutReasonNotBetween(String value1, String value2) {
            this.addCriterion("soldout_reason not between", value1, value2, "soldoutReason");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeIsNull() {
            this.addCriterion("soldout_time is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeIsNotNull() {
            this.addCriterion("soldout_time is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeEqualTo(Date value) {
            this.addCriterion("soldout_time =", value, "soldoutTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeNotEqualTo(Date value) {
            this.addCriterion("soldout_time <>", value, "soldoutTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeGreaterThan(Date value) {
            this.addCriterion("soldout_time >", value, "soldoutTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("soldout_time >=", value, "soldoutTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeLessThan(Date value) {
            this.addCriterion("soldout_time <", value, "soldoutTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("soldout_time <=", value, "soldoutTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeLike(String value) {
            this.addCriterion("soldout_time like", value, "soldoutTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeNotLike(String value) {
            this.addCriterion("soldout_time not like", value, "soldoutTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeIn(List<Date> values) {
            this.addCriterion("soldout_time in", values, "soldoutTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeNotIn(List<Date> values) {
            this.addCriterion("soldout_time not in", values, "soldoutTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeBetween(Date value1, Date value2) {
            this.addCriterion("soldout_time between", value1, value2, "soldoutTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldoutTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("soldout_time not between", value1, value2, "soldoutTime");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdIsNull() {
            this.addCriterion("sold_user_id is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdIsNotNull() {
            this.addCriterion("sold_user_id is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdEqualTo(Long value) {
            this.addCriterion("sold_user_id =", value, "soldUserId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdNotEqualTo(Long value) {
            this.addCriterion("sold_user_id <>", value, "soldUserId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdGreaterThan(Long value) {
            this.addCriterion("sold_user_id >", value, "soldUserId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("sold_user_id >=", value, "soldUserId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdLessThan(Long value) {
            this.addCriterion("sold_user_id <", value, "soldUserId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("sold_user_id <=", value, "soldUserId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdLike(String value) {
            this.addCriterion("sold_user_id like", value, "soldUserId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdNotLike(String value) {
            this.addCriterion("sold_user_id not like", value, "soldUserId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdIn(List<Long> values) {
            this.addCriterion("sold_user_id in", values, "soldUserId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdNotIn(List<Long> values) {
            this.addCriterion("sold_user_id not in", values, "soldUserId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdBetween(Long value1, Long value2) {
            this.addCriterion("sold_user_id between", value1, value2, "soldUserId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andSoldUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("sold_user_id not between", value1, value2, "soldUserId");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpIsNull() {
            this.addCriterion("is_excel_imp is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpIsNotNull() {
            this.addCriterion("is_excel_imp is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpEqualTo(Integer value) {
            this.addCriterion("is_excel_imp =", value, "isExcelImp");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpNotEqualTo(Integer value) {
            this.addCriterion("is_excel_imp <>", value, "isExcelImp");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpGreaterThan(Integer value) {
            this.addCriterion("is_excel_imp >", value, "isExcelImp");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_excel_imp >=", value, "isExcelImp");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpLessThan(Integer value) {
            this.addCriterion("is_excel_imp <", value, "isExcelImp");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_excel_imp <=", value, "isExcelImp");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpLike(String value) {
            this.addCriterion("is_excel_imp like", value, "isExcelImp");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpNotLike(String value) {
            this.addCriterion("is_excel_imp not like", value, "isExcelImp");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpIn(List<Integer> values) {
            this.addCriterion("is_excel_imp in", values, "isExcelImp");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpNotIn(List<Integer> values) {
            this.addCriterion("is_excel_imp not in", values, "isExcelImp");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpBetween(Integer value1, Integer value2) {
            this.addCriterion("is_excel_imp between", value1, value2, "isExcelImp");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsExcelImpNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_excel_imp not between", value1, value2, "isExcelImp");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsStandardIsNull() {
            this.addCriterion("is_standard is null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsStandardIsNotNull() {
            this.addCriterion("is_standard is not null");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsStandardEqualTo(Integer value) {
            this.addCriterion("is_standard =", value, "isStandard");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsStandardNotEqualTo(Integer value) {
            this.addCriterion("is_standard <>", value, "isStandard");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsStandardGreaterThan(Integer value) {
            this.addCriterion("is_standard >", value, "isStandard");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsStandardGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_standard >=", value, "isStandard");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsStandardLessThan(Integer value) {
            this.addCriterion("is_standard <", value, "isStandard");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsStandardLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_standard <=", value, "isStandard");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsStandardLike(String value) {
            this.addCriterion("is_standard like", value, "isStandard");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsStandardNotLike(String value) {
            this.addCriterion("is_standard not like", value, "isStandard");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }        public ShiguGoodsSoldoutExample.Criteria andIsStandardIn(List<Integer> values) {
            this.addCriterion("is_standard in", values, "isStandard");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsStandardNotIn(List<Integer> values) {
            this.addCriterion("is_standard not in", values, "isStandard");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsStandardBetween(Integer value1, Integer value2) {
            this.addCriterion("is_standard between", value1, value2, "isStandard");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }

        public ShiguGoodsSoldoutExample.Criteria andIsStandardNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_standard not between", value1, value2, "isStandard");
            return (ShiguGoodsSoldoutExample.Criteria)this;
        }
    }
}
