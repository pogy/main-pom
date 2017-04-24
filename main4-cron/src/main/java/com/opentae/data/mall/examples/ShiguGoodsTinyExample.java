package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShiguGoodsTinyExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguGoodsTinyExample.Criteria> oredCriteria = new ArrayList();

    public ShiguGoodsTinyExample() {
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

    public List<ShiguGoodsTinyExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguGoodsTinyExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguGoodsTinyExample.Criteria or() {
        ShiguGoodsTinyExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguGoodsTinyExample.Criteria createCriteria() {
        ShiguGoodsTinyExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguGoodsTinyExample.Criteria createCriteriaInternal() {
        ShiguGoodsTinyExample.Criteria criteria = new ShiguGoodsTinyExample.Criteria();
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

    public static class Criteria extends ShiguGoodsTinyExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguGoodsTinyExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguGoodsTinyExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguGoodsTinyExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguGoodsTinyExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguGoodsTinyExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguGoodsTinyExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguGoodsTinyExample.Criteria andGoodsIdIsNull() {
            this.addCriterion("goods_id is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsIdIsNotNull() {
            this.addCriterion("goods_id is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsIdEqualTo(Long value) {
            this.addCriterion("goods_id =", value, "goodsId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsIdNotEqualTo(Long value) {
            this.addCriterion("goods_id <>", value, "goodsId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsIdGreaterThan(Long value) {
            this.addCriterion("goods_id >", value, "goodsId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("goods_id >=", value, "goodsId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsIdLessThan(Long value) {
            this.addCriterion("goods_id <", value, "goodsId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            this.addCriterion("goods_id <=", value, "goodsId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsIdLike(String value) {
            this.addCriterion("goods_id like", value, "goodsId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsIdNotLike(String value) {
            this.addCriterion("goods_id not like", value, "goodsId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andGoodsIdIn(List<Long> values) {
            this.addCriterion("goods_id in", values, "goodsId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsIdNotIn(List<Long> values) {
            this.addCriterion("goods_id not in", values, "goodsId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            this.addCriterion("goods_id between", value1, value2, "goodsId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            this.addCriterion("goods_id not between", value1, value2, "goodsId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumIidIsNull() {
            this.addCriterion("num_iid is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumIidIsNotNull() {
            this.addCriterion("num_iid is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumIidEqualTo(Long value) {
            this.addCriterion("num_iid =", value, "numIid");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumIidNotEqualTo(Long value) {
            this.addCriterion("num_iid <>", value, "numIid");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumIidGreaterThan(Long value) {
            this.addCriterion("num_iid >", value, "numIid");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumIidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("num_iid >=", value, "numIid");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumIidLessThan(Long value) {
            this.addCriterion("num_iid <", value, "numIid");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumIidLessThanOrEqualTo(Long value) {
            this.addCriterion("num_iid <=", value, "numIid");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumIidLike(String value) {
            this.addCriterion("num_iid like", value, "numIid");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumIidNotLike(String value) {
            this.addCriterion("num_iid not like", value, "numIid");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andNumIidIn(List<Long> values) {
            this.addCriterion("num_iid in", values, "numIid");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumIidNotIn(List<Long> values) {
            this.addCriterion("num_iid not in", values, "numIid");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumIidBetween(Long value1, Long value2) {
            this.addCriterion("num_iid between", value1, value2, "numIid");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumIidNotBetween(Long value1, Long value2) {
            this.addCriterion("num_iid not between", value1, value2, "numIid");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlIsNull() {
            this.addCriterion("detail_url is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlIsNotNull() {
            this.addCriterion("detail_url is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlEqualTo(String value) {
            this.addCriterion("detail_url =", value, "detailUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlNotEqualTo(String value) {
            this.addCriterion("detail_url <>", value, "detailUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlGreaterThan(String value) {
            this.addCriterion("detail_url >", value, "detailUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("detail_url >=", value, "detailUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlLessThan(String value) {
            this.addCriterion("detail_url <", value, "detailUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlLessThanOrEqualTo(String value) {
            this.addCriterion("detail_url <=", value, "detailUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlLike(String value) {
            this.addCriterion("detail_url like", value, "detailUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlNotLike(String value) {
            this.addCriterion("detail_url not like", value, "detailUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andDetailUrlIn(List<String> values) {
            this.addCriterion("detail_url in", values, "detailUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlNotIn(List<String> values) {
            this.addCriterion("detail_url not in", values, "detailUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlBetween(String value1, String value2) {
            this.addCriterion("detail_url between", value1, value2, "detailUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDetailUrlNotBetween(String value1, String value2) {
            this.addCriterion("detail_url not between", value1, value2, "detailUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleIsNull() {
            this.addCriterion("title is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleIsNotNull() {
            this.addCriterion("title is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleEqualTo(String value) {
            this.addCriterion("title =", value, "title");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleNotEqualTo(String value) {
            this.addCriterion("title <>", value, "title");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleGreaterThan(String value) {
            this.addCriterion("title >", value, "title");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            this.addCriterion("title >=", value, "title");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleLessThan(String value) {
            this.addCriterion("title <", value, "title");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleLessThanOrEqualTo(String value) {
            this.addCriterion("title <=", value, "title");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleLike(String value) {
            this.addCriterion("title like", value, "title");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleNotLike(String value) {
            this.addCriterion("title not like", value, "title");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andTitleIn(List<String> values) {
            this.addCriterion("title in", values, "title");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleNotIn(List<String> values) {
            this.addCriterion("title not in", values, "title");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleBetween(String value1, String value2) {
            this.addCriterion("title between", value1, value2, "title");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleNotBetween(String value1, String value2) {
            this.addCriterion("title not between", value1, value2, "title");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNickIsNull() {
            this.addCriterion("nick is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNickIsNotNull() {
            this.addCriterion("nick is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNickEqualTo(String value) {
            this.addCriterion("nick =", value, "nick");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNickNotEqualTo(String value) {
            this.addCriterion("nick <>", value, "nick");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNickGreaterThan(String value) {
            this.addCriterion("nick >", value, "nick");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNickGreaterThanOrEqualTo(String value) {
            this.addCriterion("nick >=", value, "nick");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNickLessThan(String value) {
            this.addCriterion("nick <", value, "nick");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNickLessThanOrEqualTo(String value) {
            this.addCriterion("nick <=", value, "nick");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNickLike(String value) {
            this.addCriterion("nick like", value, "nick");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNickNotLike(String value) {
            this.addCriterion("nick not like", value, "nick");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andNickIn(List<String> values) {
            this.addCriterion("nick in", values, "nick");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNickNotIn(List<String> values) {
            this.addCriterion("nick not in", values, "nick");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNickBetween(String value1, String value2) {
            this.addCriterion("nick between", value1, value2, "nick");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNickNotBetween(String value1, String value2) {
            this.addCriterion("nick not between", value1, value2, "nick");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTypeIsNull() {
            this.addCriterion("type is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTypeIsNotNull() {
            this.addCriterion("type is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTypeEqualTo(String value) {
            this.addCriterion("type =", value, "type");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTypeNotEqualTo(String value) {
            this.addCriterion("type <>", value, "type");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTypeGreaterThan(String value) {
            this.addCriterion("type >", value, "type");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTypeGreaterThanOrEqualTo(String value) {
            this.addCriterion("type >=", value, "type");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTypeLessThan(String value) {
            this.addCriterion("type <", value, "type");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTypeLessThanOrEqualTo(String value) {
            this.addCriterion("type <=", value, "type");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTypeLike(String value) {
            this.addCriterion("type like", value, "type");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTypeNotLike(String value) {
            this.addCriterion("type not like", value, "type");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andTypeIn(List<String> values) {
            this.addCriterion("type in", values, "type");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTypeNotIn(List<String> values) {
            this.addCriterion("type not in", values, "type");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTypeBetween(String value1, String value2) {
            this.addCriterion("type between", value1, value2, "type");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTypeNotBetween(String value1, String value2) {
            this.addCriterion("type not between", value1, value2, "type");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCreatedIsNull() {
            this.addCriterion("created is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCreatedIsNotNull() {
            this.addCriterion("created is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCreatedEqualTo(Date value) {
            this.addCriterion("created =", value, "created");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCreatedNotEqualTo(Date value) {
            this.addCriterion("created <>", value, "created");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCreatedGreaterThan(Date value) {
            this.addCriterion("created >", value, "created");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            this.addCriterion("created >=", value, "created");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCreatedLessThan(Date value) {
            this.addCriterion("created <", value, "created");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCreatedLessThanOrEqualTo(Date value) {
            this.addCriterion("created <=", value, "created");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCreatedLike(String value) {
            this.addCriterion("created like", value, "created");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCreatedNotLike(String value) {
            this.addCriterion("created not like", value, "created");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andCreatedIn(List<Date> values) {
            this.addCriterion("created in", values, "created");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCreatedNotIn(List<Date> values) {
            this.addCriterion("created not in", values, "created");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCreatedBetween(Date value1, Date value2) {
            this.addCriterion("created between", value1, value2, "created");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCreatedNotBetween(Date value1, Date value2) {
            this.addCriterion("created not between", value1, value2, "created");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentIsNull() {
            this.addCriterion("is_lightning_consignment is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentIsNotNull() {
            this.addCriterion("is_lightning_consignment is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentEqualTo(String value) {
            this.addCriterion("is_lightning_consignment =", value, "isLightningConsignment");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentNotEqualTo(String value) {
            this.addCriterion("is_lightning_consignment <>", value, "isLightningConsignment");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentGreaterThan(String value) {
            this.addCriterion("is_lightning_consignment >", value, "isLightningConsignment");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentGreaterThanOrEqualTo(String value) {
            this.addCriterion("is_lightning_consignment >=", value, "isLightningConsignment");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentLessThan(String value) {
            this.addCriterion("is_lightning_consignment <", value, "isLightningConsignment");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentLessThanOrEqualTo(String value) {
            this.addCriterion("is_lightning_consignment <=", value, "isLightningConsignment");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentLike(String value) {
            this.addCriterion("is_lightning_consignment like", value, "isLightningConsignment");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentNotLike(String value) {
            this.addCriterion("is_lightning_consignment not like", value, "isLightningConsignment");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentIn(List<String> values) {
            this.addCriterion("is_lightning_consignment in", values, "isLightningConsignment");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentNotIn(List<String> values) {
            this.addCriterion("is_lightning_consignment not in", values, "isLightningConsignment");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentBetween(String value1, String value2) {
            this.addCriterion("is_lightning_consignment between", value1, value2, "isLightningConsignment");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsLightningConsignmentNotBetween(String value1, String value2) {
            this.addCriterion("is_lightning_consignment not between", value1, value2, "isLightningConsignment");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsFenxiaoIsNull() {
            this.addCriterion("is_fenxiao is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsFenxiaoIsNotNull() {
            this.addCriterion("is_fenxiao is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsFenxiaoEqualTo(Long value) {
            this.addCriterion("is_fenxiao =", value, "isFenxiao");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsFenxiaoNotEqualTo(Long value) {
            this.addCriterion("is_fenxiao <>", value, "isFenxiao");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsFenxiaoGreaterThan(Long value) {
            this.addCriterion("is_fenxiao >", value, "isFenxiao");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsFenxiaoGreaterThanOrEqualTo(Long value) {
            this.addCriterion("is_fenxiao >=", value, "isFenxiao");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsFenxiaoLessThan(Long value) {
            this.addCriterion("is_fenxiao <", value, "isFenxiao");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsFenxiaoLessThanOrEqualTo(Long value) {
            this.addCriterion("is_fenxiao <=", value, "isFenxiao");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsFenxiaoLike(String value) {
            this.addCriterion("is_fenxiao like", value, "isFenxiao");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsFenxiaoNotLike(String value) {
            this.addCriterion("is_fenxiao not like", value, "isFenxiao");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andIsFenxiaoIn(List<Long> values) {
            this.addCriterion("is_fenxiao in", values, "isFenxiao");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsFenxiaoNotIn(List<Long> values) {
            this.addCriterion("is_fenxiao not in", values, "isFenxiao");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsFenxiaoBetween(Long value1, Long value2) {
            this.addCriterion("is_fenxiao between", value1, value2, "isFenxiao");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsFenxiaoNotBetween(Long value1, Long value2) {
            this.addCriterion("is_fenxiao not between", value1, value2, "isFenxiao");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSaleIsNull() {
            this.addCriterion("is_sale is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSaleIsNotNull() {
            this.addCriterion("is_sale is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSaleEqualTo(Long value) {
            this.addCriterion("is_sale =", value, "isSale");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSaleNotEqualTo(Long value) {
            this.addCriterion("is_sale <>", value, "isSale");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSaleGreaterThan(Long value) {
            this.addCriterion("is_sale >", value, "isSale");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSaleGreaterThanOrEqualTo(Long value) {
            this.addCriterion("is_sale >=", value, "isSale");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSaleLessThan(Long value) {
            this.addCriterion("is_sale <", value, "isSale");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSaleLessThanOrEqualTo(Long value) {
            this.addCriterion("is_sale <=", value, "isSale");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSaleLike(String value) {
            this.addCriterion("is_sale like", value, "isSale");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSaleNotLike(String value) {
            this.addCriterion("is_sale not like", value, "isSale");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andIsSaleIn(List<Long> values) {
            this.addCriterion("is_sale in", values, "isSale");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSaleNotIn(List<Long> values) {
            this.addCriterion("is_sale not in", values, "isSale");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSaleBetween(Long value1, Long value2) {
            this.addCriterion("is_sale between", value1, value2, "isSale");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSaleNotBetween(Long value1, Long value2) {
            this.addCriterion("is_sale not between", value1, value2, "isSale");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinIsNull() {
            this.addCriterion("is_xinpin is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinIsNotNull() {
            this.addCriterion("is_xinpin is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinEqualTo(String value) {
            this.addCriterion("is_xinpin =", value, "isXinpin");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinNotEqualTo(String value) {
            this.addCriterion("is_xinpin <>", value, "isXinpin");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinGreaterThan(String value) {
            this.addCriterion("is_xinpin >", value, "isXinpin");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinGreaterThanOrEqualTo(String value) {
            this.addCriterion("is_xinpin >=", value, "isXinpin");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinLessThan(String value) {
            this.addCriterion("is_xinpin <", value, "isXinpin");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinLessThanOrEqualTo(String value) {
            this.addCriterion("is_xinpin <=", value, "isXinpin");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinLike(String value) {
            this.addCriterion("is_xinpin like", value, "isXinpin");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinNotLike(String value) {
            this.addCriterion("is_xinpin not like", value, "isXinpin");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andIsXinpinIn(List<String> values) {
            this.addCriterion("is_xinpin in", values, "isXinpin");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinNotIn(List<String> values) {
            this.addCriterion("is_xinpin not in", values, "isXinpin");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinBetween(String value1, String value2) {
            this.addCriterion("is_xinpin between", value1, value2, "isXinpin");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsXinpinNotBetween(String value1, String value2) {
            this.addCriterion("is_xinpin not between", value1, value2, "isXinpin");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andValidThruIsNull() {
            this.addCriterion("valid_thru is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andValidThruIsNotNull() {
            this.addCriterion("valid_thru is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andValidThruEqualTo(Long value) {
            this.addCriterion("valid_thru =", value, "validThru");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andValidThruNotEqualTo(Long value) {
            this.addCriterion("valid_thru <>", value, "validThru");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andValidThruGreaterThan(Long value) {
            this.addCriterion("valid_thru >", value, "validThru");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andValidThruGreaterThanOrEqualTo(Long value) {
            this.addCriterion("valid_thru >=", value, "validThru");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andValidThruLessThan(Long value) {
            this.addCriterion("valid_thru <", value, "validThru");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andValidThruLessThanOrEqualTo(Long value) {
            this.addCriterion("valid_thru <=", value, "validThru");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andValidThruLike(String value) {
            this.addCriterion("valid_thru like", value, "validThru");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andValidThruNotLike(String value) {
            this.addCriterion("valid_thru not like", value, "validThru");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andValidThruIn(List<Long> values) {
            this.addCriterion("valid_thru in", values, "validThru");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andValidThruNotIn(List<Long> values) {
            this.addCriterion("valid_thru not in", values, "validThru");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andValidThruBetween(Long value1, Long value2) {
            this.addCriterion("valid_thru between", value1, value2, "validThru");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andValidThruNotBetween(Long value1, Long value2) {
            this.addCriterion("valid_thru not between", value1, value2, "validThru");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdIsNull() {
            this.addCriterion("outer_id is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdIsNotNull() {
            this.addCriterion("outer_id is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdEqualTo(String value) {
            this.addCriterion("outer_id =", value, "outerId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdNotEqualTo(String value) {
            this.addCriterion("outer_id <>", value, "outerId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdGreaterThan(String value) {
            this.addCriterion("outer_id >", value, "outerId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("outer_id >=", value, "outerId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdLessThan(String value) {
            this.addCriterion("outer_id <", value, "outerId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdLessThanOrEqualTo(String value) {
            this.addCriterion("outer_id <=", value, "outerId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdLike(String value) {
            this.addCriterion("outer_id like", value, "outerId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdNotLike(String value) {
            this.addCriterion("outer_id not like", value, "outerId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andOuterIdIn(List<String> values) {
            this.addCriterion("outer_id in", values, "outerId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdNotIn(List<String> values) {
            this.addCriterion("outer_id not in", values, "outerId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdBetween(String value1, String value2) {
            this.addCriterion("outer_id between", value1, value2, "outerId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andOuterIdNotBetween(String value1, String value2) {
            this.addCriterion("outer_id not between", value1, value2, "outerId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidIsNull() {
            this.addCriterion("cid is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidIsNotNull() {
            this.addCriterion("cid is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidEqualTo(Long value) {
            this.addCriterion("cid =", value, "cid");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidNotEqualTo(Long value) {
            this.addCriterion("cid <>", value, "cid");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidGreaterThan(Long value) {
            this.addCriterion("cid >", value, "cid");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("cid >=", value, "cid");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidLessThan(Long value) {
            this.addCriterion("cid <", value, "cid");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidLessThanOrEqualTo(Long value) {
            this.addCriterion("cid <=", value, "cid");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidLike(String value) {
            this.addCriterion("cid like", value, "cid");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidNotLike(String value) {
            this.addCriterion("cid not like", value, "cid");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andCidIn(List<Long> values) {
            this.addCriterion("cid in", values, "cid");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidNotIn(List<Long> values) {
            this.addCriterion("cid not in", values, "cid");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidBetween(Long value1, Long value2) {
            this.addCriterion("cid between", value1, value2, "cid");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidNotBetween(Long value1, Long value2) {
            this.addCriterion("cid not between", value1, value2, "cid");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidAllIsNull() {
            this.addCriterion("cid_all is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidAllIsNotNull() {
            this.addCriterion("cid_all is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidAllEqualTo(String value) {
            this.addCriterion("cid_all =", value, "cidAll");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidAllNotEqualTo(String value) {
            this.addCriterion("cid_all <>", value, "cidAll");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidAllGreaterThan(String value) {
            this.addCriterion("cid_all >", value, "cidAll");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidAllGreaterThanOrEqualTo(String value) {
            this.addCriterion("cid_all >=", value, "cidAll");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidAllLessThan(String value) {
            this.addCriterion("cid_all <", value, "cidAll");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidAllLessThanOrEqualTo(String value) {
            this.addCriterion("cid_all <=", value, "cidAll");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidAllLike(String value) {
            this.addCriterion("cid_all like", value, "cidAll");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidAllNotLike(String value) {
            this.addCriterion("cid_all not like", value, "cidAll");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andCidAllIn(List<String> values) {
            this.addCriterion("cid_all in", values, "cidAll");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidAllNotIn(List<String> values) {
            this.addCriterion("cid_all not in", values, "cidAll");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidAllBetween(String value1, String value2) {
            this.addCriterion("cid_all between", value1, value2, "cidAll");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCidAllNotBetween(String value1, String value2) {
            this.addCriterion("cid_all not between", value1, value2, "cidAll");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlIsNull() {
            this.addCriterion("pic_url is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlIsNotNull() {
            this.addCriterion("pic_url is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlEqualTo(String value) {
            this.addCriterion("pic_url =", value, "picUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlNotEqualTo(String value) {
            this.addCriterion("pic_url <>", value, "picUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlGreaterThan(String value) {
            this.addCriterion("pic_url >", value, "picUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("pic_url >=", value, "picUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlLessThan(String value) {
            this.addCriterion("pic_url <", value, "picUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlLessThanOrEqualTo(String value) {
            this.addCriterion("pic_url <=", value, "picUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlLike(String value) {
            this.addCriterion("pic_url like", value, "picUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlNotLike(String value) {
            this.addCriterion("pic_url not like", value, "picUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andPicUrlIn(List<String> values) {
            this.addCriterion("pic_url in", values, "picUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlNotIn(List<String> values) {
            this.addCriterion("pic_url not in", values, "picUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlBetween(String value1, String value2) {
            this.addCriterion("pic_url between", value1, value2, "picUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPicUrlNotBetween(String value1, String value2) {
            this.addCriterion("pic_url not between", value1, value2, "picUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumIsNull() {
            this.addCriterion("num is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumIsNotNull() {
            this.addCriterion("num is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumEqualTo(Long value) {
            this.addCriterion("num =", value, "num");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumNotEqualTo(Long value) {
            this.addCriterion("num <>", value, "num");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumGreaterThan(Long value) {
            this.addCriterion("num >", value, "num");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumGreaterThanOrEqualTo(Long value) {
            this.addCriterion("num >=", value, "num");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumLessThan(Long value) {
            this.addCriterion("num <", value, "num");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumLessThanOrEqualTo(Long value) {
            this.addCriterion("num <=", value, "num");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumLike(String value) {
            this.addCriterion("num like", value, "num");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumNotLike(String value) {
            this.addCriterion("num not like", value, "num");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andNumIn(List<Long> values) {
            this.addCriterion("num in", values, "num");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumNotIn(List<Long> values) {
            this.addCriterion("num not in", values, "num");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumBetween(Long value1, Long value2) {
            this.addCriterion("num between", value1, value2, "num");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumNotBetween(Long value1, Long value2) {
            this.addCriterion("num not between", value1, value2, "num");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSoldOutTimeIsNull() {
            this.addCriterion("sold_out_time is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSoldOutTimeIsNotNull() {
            this.addCriterion("sold_out_time is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSoldOutTimeEqualTo(Date value) {
            this.addCriterion("sold_out_time =", value, "soldOutTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSoldOutTimeNotEqualTo(Date value) {
            this.addCriterion("sold_out_time <>", value, "soldOutTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSoldOutTimeGreaterThan(Date value) {
            this.addCriterion("sold_out_time >", value, "soldOutTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSoldOutTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("sold_out_time >=", value, "soldOutTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSoldOutTimeLessThan(Date value) {
            this.addCriterion("sold_out_time <", value, "soldOutTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSoldOutTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("sold_out_time <=", value, "soldOutTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSoldOutTimeLike(String value) {
            this.addCriterion("sold_out_time like", value, "soldOutTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSoldOutTimeNotLike(String value) {
            this.addCriterion("sold_out_time not like", value, "soldOutTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andSoldOutTimeIn(List<Date> values) {
            this.addCriterion("sold_out_time in", values, "soldOutTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSoldOutTimeNotIn(List<Date> values) {
            this.addCriterion("sold_out_time not in", values, "soldOutTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSoldOutTimeBetween(Date value1, Date value2) {
            this.addCriterion("sold_out_time between", value1, value2, "soldOutTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSoldOutTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("sold_out_time not between", value1, value2, "soldOutTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andListTimeIsNull() {
            this.addCriterion("list_time is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andListTimeIsNotNull() {
            this.addCriterion("list_time is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andListTimeEqualTo(Date value) {
            this.addCriterion("list_time =", value, "listTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andListTimeNotEqualTo(Date value) {
            this.addCriterion("list_time <>", value, "listTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andListTimeGreaterThan(Date value) {
            this.addCriterion("list_time >", value, "listTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andListTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("list_time >=", value, "listTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andListTimeLessThan(Date value) {
            this.addCriterion("list_time <", value, "listTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andListTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("list_time <=", value, "listTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andListTimeLike(String value) {
            this.addCriterion("list_time like", value, "listTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andListTimeNotLike(String value) {
            this.addCriterion("list_time not like", value, "listTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andListTimeIn(List<Date> values) {
            this.addCriterion("list_time in", values, "listTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andListTimeNotIn(List<Date> values) {
            this.addCriterion("list_time not in", values, "listTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andListTimeBetween(Date value1, Date value2) {
            this.addCriterion("list_time between", value1, value2, "listTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andListTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("list_time not between", value1, value2, "listTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDelistTimeIsNull() {
            this.addCriterion("delist_time is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDelistTimeIsNotNull() {
            this.addCriterion("delist_time is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDelistTimeEqualTo(Date value) {
            this.addCriterion("delist_time =", value, "delistTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDelistTimeNotEqualTo(Date value) {
            this.addCriterion("delist_time <>", value, "delistTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDelistTimeGreaterThan(Date value) {
            this.addCriterion("delist_time >", value, "delistTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDelistTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("delist_time >=", value, "delistTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDelistTimeLessThan(Date value) {
            this.addCriterion("delist_time <", value, "delistTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDelistTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("delist_time <=", value, "delistTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDelistTimeLike(String value) {
            this.addCriterion("delist_time like", value, "delistTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDelistTimeNotLike(String value) {
            this.addCriterion("delist_time not like", value, "delistTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andDelistTimeIn(List<Date> values) {
            this.addCriterion("delist_time in", values, "delistTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDelistTimeNotIn(List<Date> values) {
            this.addCriterion("delist_time not in", values, "delistTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDelistTimeBetween(Date value1, Date value2) {
            this.addCriterion("delist_time between", value1, value2, "delistTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andDelistTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("delist_time not between", value1, value2, "delistTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusIsNull() {
            this.addCriterion("stuff_status is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusIsNotNull() {
            this.addCriterion("stuff_status is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusEqualTo(String value) {
            this.addCriterion("stuff_status =", value, "stuffStatus");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusNotEqualTo(String value) {
            this.addCriterion("stuff_status <>", value, "stuffStatus");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusGreaterThan(String value) {
            this.addCriterion("stuff_status >", value, "stuffStatus");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusGreaterThanOrEqualTo(String value) {
            this.addCriterion("stuff_status >=", value, "stuffStatus");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusLessThan(String value) {
            this.addCriterion("stuff_status <", value, "stuffStatus");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusLessThanOrEqualTo(String value) {
            this.addCriterion("stuff_status <=", value, "stuffStatus");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusLike(String value) {
            this.addCriterion("stuff_status like", value, "stuffStatus");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusNotLike(String value) {
            this.addCriterion("stuff_status not like", value, "stuffStatus");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andStuffStatusIn(List<String> values) {
            this.addCriterion("stuff_status in", values, "stuffStatus");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusNotIn(List<String> values) {
            this.addCriterion("stuff_status not in", values, "stuffStatus");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusBetween(String value1, String value2) {
            this.addCriterion("stuff_status between", value1, value2, "stuffStatus");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStuffStatusNotBetween(String value1, String value2) {
            this.addCriterion("stuff_status not between", value1, value2, "stuffStatus");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCityIsNull() {
            this.addCriterion("city is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCityIsNotNull() {
            this.addCriterion("city is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCityEqualTo(String value) {
            this.addCriterion("city =", value, "city");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCityNotEqualTo(String value) {
            this.addCriterion("city <>", value, "city");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCityGreaterThan(String value) {
            this.addCriterion("city >", value, "city");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCityGreaterThanOrEqualTo(String value) {
            this.addCriterion("city >=", value, "city");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCityLessThan(String value) {
            this.addCriterion("city <", value, "city");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCityLessThanOrEqualTo(String value) {
            this.addCriterion("city <=", value, "city");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCityLike(String value) {
            this.addCriterion("city like", value, "city");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCityNotLike(String value) {
            this.addCriterion("city not like", value, "city");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andCityIn(List<String> values) {
            this.addCriterion("city in", values, "city");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCityNotIn(List<String> values) {
            this.addCriterion("city not in", values, "city");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCityBetween(String value1, String value2) {
            this.addCriterion("city between", value1, value2, "city");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andCityNotBetween(String value1, String value2) {
            this.addCriterion("city not between", value1, value2, "city");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andProvIsNull() {
            this.addCriterion("prov is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andProvIsNotNull() {
            this.addCriterion("prov is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andProvEqualTo(String value) {
            this.addCriterion("prov =", value, "prov");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andProvNotEqualTo(String value) {
            this.addCriterion("prov <>", value, "prov");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andProvGreaterThan(String value) {
            this.addCriterion("prov >", value, "prov");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andProvGreaterThanOrEqualTo(String value) {
            this.addCriterion("prov >=", value, "prov");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andProvLessThan(String value) {
            this.addCriterion("prov <", value, "prov");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andProvLessThanOrEqualTo(String value) {
            this.addCriterion("prov <=", value, "prov");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andProvLike(String value) {
            this.addCriterion("prov like", value, "prov");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andProvNotLike(String value) {
            this.addCriterion("prov not like", value, "prov");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andProvIn(List<String> values) {
            this.addCriterion("prov in", values, "prov");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andProvNotIn(List<String> values) {
            this.addCriterion("prov not in", values, "prov");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andProvBetween(String value1, String value2) {
            this.addCriterion("prov between", value1, value2, "prov");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andProvNotBetween(String value1, String value2) {
            this.addCriterion("prov not between", value1, value2, "prov");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringIsNull() {
            this.addCriterion("price_string is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringIsNotNull() {
            this.addCriterion("price_string is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringEqualTo(String value) {
            this.addCriterion("price_string =", value, "priceString");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringNotEqualTo(String value) {
            this.addCriterion("price_string <>", value, "priceString");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringGreaterThan(String value) {
            this.addCriterion("price_string >", value, "priceString");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringGreaterThanOrEqualTo(String value) {
            this.addCriterion("price_string >=", value, "priceString");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringLessThan(String value) {
            this.addCriterion("price_string <", value, "priceString");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringLessThanOrEqualTo(String value) {
            this.addCriterion("price_string <=", value, "priceString");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringLike(String value) {
            this.addCriterion("price_string like", value, "priceString");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringNotLike(String value) {
            this.addCriterion("price_string not like", value, "priceString");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andPriceStringIn(List<String> values) {
            this.addCriterion("price_string in", values, "priceString");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringNotIn(List<String> values) {
            this.addCriterion("price_string not in", values, "priceString");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringBetween(String value1, String value2) {
            this.addCriterion("price_string between", value1, value2, "priceString");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceStringNotBetween(String value1, String value2) {
            this.addCriterion("price_string not between", value1, value2, "priceString");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceIsNull() {
            this.addCriterion("price is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceIsNotNull() {
            this.addCriterion("price is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceEqualTo(Long value) {
            this.addCriterion("price =", value, "price");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceNotEqualTo(Long value) {
            this.addCriterion("price <>", value, "price");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceGreaterThan(Long value) {
            this.addCriterion("price >", value, "price");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceGreaterThanOrEqualTo(Long value) {
            this.addCriterion("price >=", value, "price");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceLessThan(Long value) {
            this.addCriterion("price <", value, "price");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceLessThanOrEqualTo(Long value) {
            this.addCriterion("price <=", value, "price");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceLike(String value) {
            this.addCriterion("price like", value, "price");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceNotLike(String value) {
            this.addCriterion("price not like", value, "price");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andPriceIn(List<Long> values) {
            this.addCriterion("price in", values, "price");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceNotIn(List<Long> values) {
            this.addCriterion("price not in", values, "price");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceBetween(Long value1, Long value2) {
            this.addCriterion("price between", value1, value2, "price");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceNotBetween(Long value1, Long value2) {
            this.addCriterion("price not between", value1, value2, "price");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceIsNull() {
            this.addCriterion("pi_price is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceIsNotNull() {
            this.addCriterion("pi_price is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceEqualTo(Long value) {
            this.addCriterion("pi_price =", value, "piPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceNotEqualTo(Long value) {
            this.addCriterion("pi_price <>", value, "piPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceGreaterThan(Long value) {
            this.addCriterion("pi_price >", value, "piPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceGreaterThanOrEqualTo(Long value) {
            this.addCriterion("pi_price >=", value, "piPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceLessThan(Long value) {
            this.addCriterion("pi_price <", value, "piPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceLessThanOrEqualTo(Long value) {
            this.addCriterion("pi_price <=", value, "piPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceLike(String value) {
            this.addCriterion("pi_price like", value, "piPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceNotLike(String value) {
            this.addCriterion("pi_price not like", value, "piPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andPiPriceIn(List<Long> values) {
            this.addCriterion("pi_price in", values, "piPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceNotIn(List<Long> values) {
            this.addCriterion("pi_price not in", values, "piPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceBetween(Long value1, Long value2) {
            this.addCriterion("pi_price between", value1, value2, "piPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceNotBetween(Long value1, Long value2) {
            this.addCriterion("pi_price not between", value1, value2, "piPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringIsNull() {
            this.addCriterion("pi_price_string is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringIsNotNull() {
            this.addCriterion("pi_price_string is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringEqualTo(String value) {
            this.addCriterion("pi_price_string =", value, "piPriceString");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringNotEqualTo(String value) {
            this.addCriterion("pi_price_string <>", value, "piPriceString");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringGreaterThan(String value) {
            this.addCriterion("pi_price_string >", value, "piPriceString");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringGreaterThanOrEqualTo(String value) {
            this.addCriterion("pi_price_string >=", value, "piPriceString");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringLessThan(String value) {
            this.addCriterion("pi_price_string <", value, "piPriceString");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringLessThanOrEqualTo(String value) {
            this.addCriterion("pi_price_string <=", value, "piPriceString");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringLike(String value) {
            this.addCriterion("pi_price_string like", value, "piPriceString");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringNotLike(String value) {
            this.addCriterion("pi_price_string not like", value, "piPriceString");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andPiPriceStringIn(List<String> values) {
            this.addCriterion("pi_price_string in", values, "piPriceString");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringNotIn(List<String> values) {
            this.addCriterion("pi_price_string not in", values, "piPriceString");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringBetween(String value1, String value2) {
            this.addCriterion("pi_price_string between", value1, value2, "piPriceString");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPiPriceStringNotBetween(String value1, String value2) {
            this.addCriterion("pi_price_string not between", value1, value2, "piPriceString");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleIsNull() {
            this.addCriterion("price_role is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleIsNotNull() {
            this.addCriterion("price_role is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleEqualTo(String value) {
            this.addCriterion("price_role =", value, "priceRole");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleNotEqualTo(String value) {
            this.addCriterion("price_role <>", value, "priceRole");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleGreaterThan(String value) {
            this.addCriterion("price_role >", value, "priceRole");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleGreaterThanOrEqualTo(String value) {
            this.addCriterion("price_role >=", value, "priceRole");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleLessThan(String value) {
            this.addCriterion("price_role <", value, "priceRole");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleLessThanOrEqualTo(String value) {
            this.addCriterion("price_role <=", value, "priceRole");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleLike(String value) {
            this.addCriterion("price_role like", value, "priceRole");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleNotLike(String value) {
            this.addCriterion("price_role not like", value, "priceRole");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andPriceRoleIn(List<String> values) {
            this.addCriterion("price_role in", values, "priceRole");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleNotIn(List<String> values) {
            this.addCriterion("price_role not in", values, "priceRole");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleBetween(String value1, String value2) {
            this.addCriterion("price_role between", value1, value2, "priceRole");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPriceRoleNotBetween(String value1, String value2) {
            this.addCriterion("price_role not between", value1, value2, "priceRole");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeIsNull() {
            this.addCriterion("post_fee is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeIsNotNull() {
            this.addCriterion("post_fee is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeEqualTo(String value) {
            this.addCriterion("post_fee =", value, "postFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeNotEqualTo(String value) {
            this.addCriterion("post_fee <>", value, "postFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeGreaterThan(String value) {
            this.addCriterion("post_fee >", value, "postFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeGreaterThanOrEqualTo(String value) {
            this.addCriterion("post_fee >=", value, "postFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeLessThan(String value) {
            this.addCriterion("post_fee <", value, "postFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeLessThanOrEqualTo(String value) {
            this.addCriterion("post_fee <=", value, "postFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeLike(String value) {
            this.addCriterion("post_fee like", value, "postFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeNotLike(String value) {
            this.addCriterion("post_fee not like", value, "postFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andPostFeeIn(List<String> values) {
            this.addCriterion("post_fee in", values, "postFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeNotIn(List<String> values) {
            this.addCriterion("post_fee not in", values, "postFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeBetween(String value1, String value2) {
            this.addCriterion("post_fee between", value1, value2, "postFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andPostFeeNotBetween(String value1, String value2) {
            this.addCriterion("post_fee not between", value1, value2, "postFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeIsNull() {
            this.addCriterion("express_fee is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeIsNotNull() {
            this.addCriterion("express_fee is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeEqualTo(String value) {
            this.addCriterion("express_fee =", value, "expressFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeNotEqualTo(String value) {
            this.addCriterion("express_fee <>", value, "expressFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeGreaterThan(String value) {
            this.addCriterion("express_fee >", value, "expressFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeGreaterThanOrEqualTo(String value) {
            this.addCriterion("express_fee >=", value, "expressFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeLessThan(String value) {
            this.addCriterion("express_fee <", value, "expressFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeLessThanOrEqualTo(String value) {
            this.addCriterion("express_fee <=", value, "expressFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeLike(String value) {
            this.addCriterion("express_fee like", value, "expressFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeNotLike(String value) {
            this.addCriterion("express_fee not like", value, "expressFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andExpressFeeIn(List<String> values) {
            this.addCriterion("express_fee in", values, "expressFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeNotIn(List<String> values) {
            this.addCriterion("express_fee not in", values, "expressFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeBetween(String value1, String value2) {
            this.addCriterion("express_fee between", value1, value2, "expressFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andExpressFeeNotBetween(String value1, String value2) {
            this.addCriterion("express_fee not between", value1, value2, "expressFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeIsNull() {
            this.addCriterion("ems_fee is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeIsNotNull() {
            this.addCriterion("ems_fee is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeEqualTo(String value) {
            this.addCriterion("ems_fee =", value, "emsFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeNotEqualTo(String value) {
            this.addCriterion("ems_fee <>", value, "emsFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeGreaterThan(String value) {
            this.addCriterion("ems_fee >", value, "emsFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeGreaterThanOrEqualTo(String value) {
            this.addCriterion("ems_fee >=", value, "emsFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeLessThan(String value) {
            this.addCriterion("ems_fee <", value, "emsFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeLessThanOrEqualTo(String value) {
            this.addCriterion("ems_fee <=", value, "emsFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeLike(String value) {
            this.addCriterion("ems_fee like", value, "emsFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeNotLike(String value) {
            this.addCriterion("ems_fee not like", value, "emsFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andEmsFeeIn(List<String> values) {
            this.addCriterion("ems_fee in", values, "emsFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeNotIn(List<String> values) {
            this.addCriterion("ems_fee not in", values, "emsFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeBetween(String value1, String value2) {
            this.addCriterion("ems_fee between", value1, value2, "emsFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andEmsFeeNotBetween(String value1, String value2) {
            this.addCriterion("ems_fee not between", value1, value2, "emsFee");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountIsNull() {
            this.addCriterion("has_discount is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountIsNotNull() {
            this.addCriterion("has_discount is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountEqualTo(String value) {
            this.addCriterion("has_discount =", value, "hasDiscount");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountNotEqualTo(String value) {
            this.addCriterion("has_discount <>", value, "hasDiscount");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountGreaterThan(String value) {
            this.addCriterion("has_discount >", value, "hasDiscount");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountGreaterThanOrEqualTo(String value) {
            this.addCriterion("has_discount >=", value, "hasDiscount");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountLessThan(String value) {
            this.addCriterion("has_discount <", value, "hasDiscount");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountLessThanOrEqualTo(String value) {
            this.addCriterion("has_discount <=", value, "hasDiscount");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountLike(String value) {
            this.addCriterion("has_discount like", value, "hasDiscount");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountNotLike(String value) {
            this.addCriterion("has_discount not like", value, "hasDiscount");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andHasDiscountIn(List<String> values) {
            this.addCriterion("has_discount in", values, "hasDiscount");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountNotIn(List<String> values) {
            this.addCriterion("has_discount not in", values, "hasDiscount");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountBetween(String value1, String value2) {
            this.addCriterion("has_discount between", value1, value2, "hasDiscount");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasDiscountNotBetween(String value1, String value2) {
            this.addCriterion("has_discount not between", value1, value2, "hasDiscount");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerIsNull() {
            this.addCriterion("freight_payer is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerIsNotNull() {
            this.addCriterion("freight_payer is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerEqualTo(String value) {
            this.addCriterion("freight_payer =", value, "freightPayer");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerNotEqualTo(String value) {
            this.addCriterion("freight_payer <>", value, "freightPayer");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerGreaterThan(String value) {
            this.addCriterion("freight_payer >", value, "freightPayer");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerGreaterThanOrEqualTo(String value) {
            this.addCriterion("freight_payer >=", value, "freightPayer");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerLessThan(String value) {
            this.addCriterion("freight_payer <", value, "freightPayer");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerLessThanOrEqualTo(String value) {
            this.addCriterion("freight_payer <=", value, "freightPayer");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerLike(String value) {
            this.addCriterion("freight_payer like", value, "freightPayer");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerNotLike(String value) {
            this.addCriterion("freight_payer not like", value, "freightPayer");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andFreightPayerIn(List<String> values) {
            this.addCriterion("freight_payer in", values, "freightPayer");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerNotIn(List<String> values) {
            this.addCriterion("freight_payer not in", values, "freightPayer");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerBetween(String value1, String value2) {
            this.addCriterion("freight_payer between", value1, value2, "freightPayer");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andFreightPayerNotBetween(String value1, String value2) {
            this.addCriterion("freight_payer not between", value1, value2, "freightPayer");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseIsNull() {
            this.addCriterion("has_showcase is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseIsNotNull() {
            this.addCriterion("has_showcase is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseEqualTo(String value) {
            this.addCriterion("has_showcase =", value, "hasShowcase");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseNotEqualTo(String value) {
            this.addCriterion("has_showcase <>", value, "hasShowcase");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseGreaterThan(String value) {
            this.addCriterion("has_showcase >", value, "hasShowcase");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseGreaterThanOrEqualTo(String value) {
            this.addCriterion("has_showcase >=", value, "hasShowcase");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseLessThan(String value) {
            this.addCriterion("has_showcase <", value, "hasShowcase");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseLessThanOrEqualTo(String value) {
            this.addCriterion("has_showcase <=", value, "hasShowcase");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseLike(String value) {
            this.addCriterion("has_showcase like", value, "hasShowcase");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseNotLike(String value) {
            this.addCriterion("has_showcase not like", value, "hasShowcase");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andHasShowcaseIn(List<String> values) {
            this.addCriterion("has_showcase in", values, "hasShowcase");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseNotIn(List<String> values) {
            this.addCriterion("has_showcase not in", values, "hasShowcase");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseBetween(String value1, String value2) {
            this.addCriterion("has_showcase between", value1, value2, "hasShowcase");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andHasShowcaseNotBetween(String value1, String value2) {
            this.addCriterion("has_showcase not between", value1, value2, "hasShowcase");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModifiedIsNull() {
            this.addCriterion("modified is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModifiedIsNotNull() {
            this.addCriterion("modified is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModifiedEqualTo(Date value) {
            this.addCriterion("modified =", value, "modified");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModifiedNotEqualTo(Date value) {
            this.addCriterion("modified <>", value, "modified");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModifiedGreaterThan(Date value) {
            this.addCriterion("modified >", value, "modified");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModifiedGreaterThanOrEqualTo(Date value) {
            this.addCriterion("modified >=", value, "modified");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModifiedLessThan(Date value) {
            this.addCriterion("modified <", value, "modified");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModifiedLessThanOrEqualTo(Date value) {
            this.addCriterion("modified <=", value, "modified");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModifiedLike(String value) {
            this.addCriterion("modified like", value, "modified");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModifiedNotLike(String value) {
            this.addCriterion("modified not like", value, "modified");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andModifiedIn(List<Date> values) {
            this.addCriterion("modified in", values, "modified");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModifiedNotIn(List<Date> values) {
            this.addCriterion("modified not in", values, "modified");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModifiedBetween(Date value1, Date value2) {
            this.addCriterion("modified between", value1, value2, "modified");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModifiedNotBetween(Date value1, Date value2) {
            this.addCriterion("modified not between", value1, value2, "modified");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketIdIsNull() {
            this.addCriterion("market_id is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketIdIsNotNull() {
            this.addCriterion("market_id is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketIdEqualTo(Long value) {
            this.addCriterion("market_id =", value, "marketId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketIdNotEqualTo(Long value) {
            this.addCriterion("market_id <>", value, "marketId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketIdGreaterThan(Long value) {
            this.addCriterion("market_id >", value, "marketId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("market_id >=", value, "marketId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketIdLessThan(Long value) {
            this.addCriterion("market_id <", value, "marketId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            this.addCriterion("market_id <=", value, "marketId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketIdLike(String value) {
            this.addCriterion("market_id like", value, "marketId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketIdNotLike(String value) {
            this.addCriterion("market_id not like", value, "marketId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andMarketIdIn(List<Long> values) {
            this.addCriterion("market_id in", values, "marketId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketIdNotIn(List<Long> values) {
            this.addCriterion("market_id not in", values, "marketId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            this.addCriterion("market_id between", value1, value2, "marketId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            this.addCriterion("market_id not between", value1, value2, "marketId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketIsNull() {
            this.addCriterion("market is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketIsNotNull() {
            this.addCriterion("market is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketEqualTo(String value) {
            this.addCriterion("market =", value, "market");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketNotEqualTo(String value) {
            this.addCriterion("market <>", value, "market");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketGreaterThan(String value) {
            this.addCriterion("market >", value, "market");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketGreaterThanOrEqualTo(String value) {
            this.addCriterion("market >=", value, "market");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketLessThan(String value) {
            this.addCriterion("market <", value, "market");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketLessThanOrEqualTo(String value) {
            this.addCriterion("market <=", value, "market");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketLike(String value) {
            this.addCriterion("market like", value, "market");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketNotLike(String value) {
            this.addCriterion("market not like", value, "market");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andMarketIn(List<String> values) {
            this.addCriterion("market in", values, "market");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketNotIn(List<String> values) {
            this.addCriterion("market not in", values, "market");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketBetween(String value1, String value2) {
            this.addCriterion("market between", value1, value2, "market");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andMarketNotBetween(String value1, String value2) {
            this.addCriterion("market not between", value1, value2, "market");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketIdIsNull() {
            this.addCriterion("parent_market_id is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketIdIsNotNull() {
            this.addCriterion("parent_market_id is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketIdEqualTo(Long value) {
            this.addCriterion("parent_market_id =", value, "parentMarketId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketIdNotEqualTo(Long value) {
            this.addCriterion("parent_market_id <>", value, "parentMarketId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketIdGreaterThan(Long value) {
            this.addCriterion("parent_market_id >", value, "parentMarketId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("parent_market_id >=", value, "parentMarketId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketIdLessThan(Long value) {
            this.addCriterion("parent_market_id <", value, "parentMarketId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketIdLessThanOrEqualTo(Long value) {
            this.addCriterion("parent_market_id <=", value, "parentMarketId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketIdLike(String value) {
            this.addCriterion("parent_market_id like", value, "parentMarketId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketIdNotLike(String value) {
            this.addCriterion("parent_market_id not like", value, "parentMarketId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andParentMarketIdIn(List<Long> values) {
            this.addCriterion("parent_market_id in", values, "parentMarketId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketIdNotIn(List<Long> values) {
            this.addCriterion("parent_market_id not in", values, "parentMarketId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketIdBetween(Long value1, Long value2) {
            this.addCriterion("parent_market_id between", value1, value2, "parentMarketId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketIdNotBetween(Long value1, Long value2) {
            this.addCriterion("parent_market_id not between", value1, value2, "parentMarketId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameIsNull() {
            this.addCriterion("parent_market_name is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameIsNotNull() {
            this.addCriterion("parent_market_name is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameEqualTo(String value) {
            this.addCriterion("parent_market_name =", value, "parentMarketName");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameNotEqualTo(String value) {
            this.addCriterion("parent_market_name <>", value, "parentMarketName");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameGreaterThan(String value) {
            this.addCriterion("parent_market_name >", value, "parentMarketName");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("parent_market_name >=", value, "parentMarketName");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameLessThan(String value) {
            this.addCriterion("parent_market_name <", value, "parentMarketName");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameLessThanOrEqualTo(String value) {
            this.addCriterion("parent_market_name <=", value, "parentMarketName");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameLike(String value) {
            this.addCriterion("parent_market_name like", value, "parentMarketName");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameNotLike(String value) {
            this.addCriterion("parent_market_name not like", value, "parentMarketName");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andParentMarketNameIn(List<String> values) {
            this.addCriterion("parent_market_name in", values, "parentMarketName");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameNotIn(List<String> values) {
            this.addCriterion("parent_market_name not in", values, "parentMarketName");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameBetween(String value1, String value2) {
            this.addCriterion("parent_market_name between", value1, value2, "parentMarketName");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andParentMarketNameNotBetween(String value1, String value2) {
            this.addCriterion("parent_market_name not between", value1, value2, "parentMarketName");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumIsNull() {
            this.addCriterion("store_num is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumIsNotNull() {
            this.addCriterion("store_num is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumEqualTo(String value) {
            this.addCriterion("store_num =", value, "storeNum");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumNotEqualTo(String value) {
            this.addCriterion("store_num <>", value, "storeNum");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumGreaterThan(String value) {
            this.addCriterion("store_num >", value, "storeNum");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumGreaterThanOrEqualTo(String value) {
            this.addCriterion("store_num >=", value, "storeNum");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumLessThan(String value) {
            this.addCriterion("store_num <", value, "storeNum");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumLessThanOrEqualTo(String value) {
            this.addCriterion("store_num <=", value, "storeNum");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumLike(String value) {
            this.addCriterion("store_num like", value, "storeNum");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumNotLike(String value) {
            this.addCriterion("store_num not like", value, "storeNum");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andStoreNumIn(List<String> values) {
            this.addCriterion("store_num in", values, "storeNum");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumNotIn(List<String> values) {
            this.addCriterion("store_num not in", values, "storeNum");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumBetween(String value1, String value2) {
            this.addCriterion("store_num between", value1, value2, "storeNum");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreNumNotBetween(String value1, String value2) {
            this.addCriterion("store_num not between", value1, value2, "storeNum");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationIsNull() {
            this.addCriterion("is_taobao_synchronization is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationIsNotNull() {
            this.addCriterion("is_taobao_synchronization is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationEqualTo(Long value) {
            this.addCriterion("is_taobao_synchronization =", value, "isTaobaoSynchronization");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationNotEqualTo(Long value) {
            this.addCriterion("is_taobao_synchronization <>", value, "isTaobaoSynchronization");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationGreaterThan(Long value) {
            this.addCriterion("is_taobao_synchronization >", value, "isTaobaoSynchronization");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationGreaterThanOrEqualTo(Long value) {
            this.addCriterion("is_taobao_synchronization >=", value, "isTaobaoSynchronization");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationLessThan(Long value) {
            this.addCriterion("is_taobao_synchronization <", value, "isTaobaoSynchronization");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationLessThanOrEqualTo(Long value) {
            this.addCriterion("is_taobao_synchronization <=", value, "isTaobaoSynchronization");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationLike(String value) {
            this.addCriterion("is_taobao_synchronization like", value, "isTaobaoSynchronization");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationNotLike(String value) {
            this.addCriterion("is_taobao_synchronization not like", value, "isTaobaoSynchronization");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationIn(List<Long> values) {
            this.addCriterion("is_taobao_synchronization in", values, "isTaobaoSynchronization");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationNotIn(List<Long> values) {
            this.addCriterion("is_taobao_synchronization not in", values, "isTaobaoSynchronization");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationBetween(Long value1, Long value2) {
            this.addCriterion("is_taobao_synchronization between", value1, value2, "isTaobaoSynchronization");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTaobaoSynchronizationNotBetween(Long value1, Long value2) {
            this.addCriterion("is_taobao_synchronization not between", value1, value2, "isTaobaoSynchronization");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadIsNull() {
            this.addCriterion("is_akey_to_upload is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadIsNotNull() {
            this.addCriterion("is_akey_to_upload is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadEqualTo(Long value) {
            this.addCriterion("is_akey_to_upload =", value, "isAkeyToUpload");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadNotEqualTo(Long value) {
            this.addCriterion("is_akey_to_upload <>", value, "isAkeyToUpload");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadGreaterThan(Long value) {
            this.addCriterion("is_akey_to_upload >", value, "isAkeyToUpload");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadGreaterThanOrEqualTo(Long value) {
            this.addCriterion("is_akey_to_upload >=", value, "isAkeyToUpload");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadLessThan(Long value) {
            this.addCriterion("is_akey_to_upload <", value, "isAkeyToUpload");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadLessThanOrEqualTo(Long value) {
            this.addCriterion("is_akey_to_upload <=", value, "isAkeyToUpload");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadLike(String value) {
            this.addCriterion("is_akey_to_upload like", value, "isAkeyToUpload");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadNotLike(String value) {
            this.addCriterion("is_akey_to_upload not like", value, "isAkeyToUpload");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadIn(List<Long> values) {
            this.addCriterion("is_akey_to_upload in", values, "isAkeyToUpload");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadNotIn(List<Long> values) {
            this.addCriterion("is_akey_to_upload not in", values, "isAkeyToUpload");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadBetween(Long value1, Long value2) {
            this.addCriterion("is_akey_to_upload between", value1, value2, "isAkeyToUpload");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAkeyToUploadNotBetween(Long value1, Long value2) {
            this.addCriterion("is_akey_to_upload not between", value1, value2, "isAkeyToUpload");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTradeIsNull() {
            this.addCriterion("is_trade is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTradeIsNotNull() {
            this.addCriterion("is_trade is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTradeEqualTo(Long value) {
            this.addCriterion("is_trade =", value, "isTrade");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTradeNotEqualTo(Long value) {
            this.addCriterion("is_trade <>", value, "isTrade");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTradeGreaterThan(Long value) {
            this.addCriterion("is_trade >", value, "isTrade");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTradeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("is_trade >=", value, "isTrade");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTradeLessThan(Long value) {
            this.addCriterion("is_trade <", value, "isTrade");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTradeLessThanOrEqualTo(Long value) {
            this.addCriterion("is_trade <=", value, "isTrade");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTradeLike(String value) {
            this.addCriterion("is_trade like", value, "isTrade");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTradeNotLike(String value) {
            this.addCriterion("is_trade not like", value, "isTrade");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andIsTradeIn(List<Long> values) {
            this.addCriterion("is_trade in", values, "isTrade");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTradeNotIn(List<Long> values) {
            this.addCriterion("is_trade not in", values, "isTrade");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTradeBetween(Long value1, Long value2) {
            this.addCriterion("is_trade between", value1, value2, "isTrade");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsTradeNotBetween(Long value1, Long value2) {
            this.addCriterion("is_trade not between", value1, value2, "isTrade");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsEfficaciousIsNull() {
            this.addCriterion("is_efficacious is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsEfficaciousIsNotNull() {
            this.addCriterion("is_efficacious is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsEfficaciousEqualTo(Long value) {
            this.addCriterion("is_efficacious =", value, "isEfficacious");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsEfficaciousNotEqualTo(Long value) {
            this.addCriterion("is_efficacious <>", value, "isEfficacious");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsEfficaciousGreaterThan(Long value) {
            this.addCriterion("is_efficacious >", value, "isEfficacious");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsEfficaciousGreaterThanOrEqualTo(Long value) {
            this.addCriterion("is_efficacious >=", value, "isEfficacious");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsEfficaciousLessThan(Long value) {
            this.addCriterion("is_efficacious <", value, "isEfficacious");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsEfficaciousLessThanOrEqualTo(Long value) {
            this.addCriterion("is_efficacious <=", value, "isEfficacious");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsEfficaciousLike(String value) {
            this.addCriterion("is_efficacious like", value, "isEfficacious");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsEfficaciousNotLike(String value) {
            this.addCriterion("is_efficacious not like", value, "isEfficacious");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andIsEfficaciousIn(List<Long> values) {
            this.addCriterion("is_efficacious in", values, "isEfficacious");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsEfficaciousNotIn(List<Long> values) {
            this.addCriterion("is_efficacious not in", values, "isEfficacious");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsEfficaciousBetween(Long value1, Long value2) {
            this.addCriterion("is_efficacious between", value1, value2, "isEfficacious");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsEfficaciousNotBetween(Long value1, Long value2) {
            this.addCriterion("is_efficacious not between", value1, value2, "isEfficacious");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDownIsNull() {
            this.addCriterion("is_down is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDownIsNotNull() {
            this.addCriterion("is_down is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDownEqualTo(Long value) {
            this.addCriterion("is_down =", value, "isDown");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDownNotEqualTo(Long value) {
            this.addCriterion("is_down <>", value, "isDown");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDownGreaterThan(Long value) {
            this.addCriterion("is_down >", value, "isDown");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDownGreaterThanOrEqualTo(Long value) {
            this.addCriterion("is_down >=", value, "isDown");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDownLessThan(Long value) {
            this.addCriterion("is_down <", value, "isDown");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDownLessThanOrEqualTo(Long value) {
            this.addCriterion("is_down <=", value, "isDown");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDownLike(String value) {
            this.addCriterion("is_down like", value, "isDown");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDownNotLike(String value) {
            this.addCriterion("is_down not like", value, "isDown");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andIsDownIn(List<Long> values) {
            this.addCriterion("is_down in", values, "isDown");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDownNotIn(List<Long> values) {
            this.addCriterion("is_down not in", values, "isDown");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDownBetween(Long value1, Long value2) {
            this.addCriterion("is_down between", value1, value2, "isDown");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDownNotBetween(Long value1, Long value2) {
            this.addCriterion("is_down not between", value1, value2, "isDown");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreIdIsNull() {
            this.addCriterion("store_id is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreIdIsNotNull() {
            this.addCriterion("store_id is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreIdEqualTo(Long value) {
            this.addCriterion("store_id =", value, "storeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreIdNotEqualTo(Long value) {
            this.addCriterion("store_id <>", value, "storeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreIdGreaterThan(Long value) {
            this.addCriterion("store_id >", value, "storeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("store_id >=", value, "storeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreIdLessThan(Long value) {
            this.addCriterion("store_id <", value, "storeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            this.addCriterion("store_id <=", value, "storeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreIdLike(String value) {
            this.addCriterion("store_id like", value, "storeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreIdNotLike(String value) {
            this.addCriterion("store_id not like", value, "storeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andStoreIdIn(List<Long> values) {
            this.addCriterion("store_id in", values, "storeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreIdNotIn(List<Long> values) {
            this.addCriterion("store_id not in", values, "storeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            this.addCriterion("store_id between", value1, value2, "storeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            this.addCriterion("store_id not between", value1, value2, "storeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andClicksIsNull() {
            this.addCriterion("clicks is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andClicksIsNotNull() {
            this.addCriterion("clicks is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andClicksEqualTo(Long value) {
            this.addCriterion("clicks =", value, "clicks");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andClicksNotEqualTo(Long value) {
            this.addCriterion("clicks <>", value, "clicks");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andClicksGreaterThan(Long value) {
            this.addCriterion("clicks >", value, "clicks");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andClicksGreaterThanOrEqualTo(Long value) {
            this.addCriterion("clicks >=", value, "clicks");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andClicksLessThan(Long value) {
            this.addCriterion("clicks <", value, "clicks");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andClicksLessThanOrEqualTo(Long value) {
            this.addCriterion("clicks <=", value, "clicks");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andClicksLike(String value) {
            this.addCriterion("clicks like", value, "clicks");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andClicksNotLike(String value) {
            this.addCriterion("clicks not like", value, "clicks");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andClicksIn(List<Long> values) {
            this.addCriterion("clicks in", values, "clicks");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andClicksNotIn(List<Long> values) {
            this.addCriterion("clicks not in", values, "clicks");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andClicksBetween(Long value1, Long value2) {
            this.addCriterion("clicks between", value1, value2, "clicks");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andClicksNotBetween(Long value1, Long value2) {
            this.addCriterion("clicks not between", value1, value2, "clicks");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsClosedIsNull() {
            this.addCriterion("is_closed is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsClosedIsNotNull() {
            this.addCriterion("is_closed is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsClosedEqualTo(Long value) {
            this.addCriterion("is_closed =", value, "isClosed");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsClosedNotEqualTo(Long value) {
            this.addCriterion("is_closed <>", value, "isClosed");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsClosedGreaterThan(Long value) {
            this.addCriterion("is_closed >", value, "isClosed");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsClosedGreaterThanOrEqualTo(Long value) {
            this.addCriterion("is_closed >=", value, "isClosed");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsClosedLessThan(Long value) {
            this.addCriterion("is_closed <", value, "isClosed");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsClosedLessThanOrEqualTo(Long value) {
            this.addCriterion("is_closed <=", value, "isClosed");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsClosedLike(String value) {
            this.addCriterion("is_closed like", value, "isClosed");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsClosedNotLike(String value) {
            this.addCriterion("is_closed not like", value, "isClosed");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andIsClosedIn(List<Long> values) {
            this.addCriterion("is_closed in", values, "isClosed");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsClosedNotIn(List<Long> values) {
            this.addCriterion("is_closed not in", values, "isClosed");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsClosedBetween(Long value1, Long value2) {
            this.addCriterion("is_closed between", value1, value2, "isClosed");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsClosedNotBetween(Long value1, Long value2) {
            this.addCriterion("is_closed not between", value1, value2, "isClosed");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsStatusIsNull() {
            this.addCriterion("goods_status is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsStatusIsNotNull() {
            this.addCriterion("goods_status is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsStatusEqualTo(Integer value) {
            this.addCriterion("goods_status =", value, "goodsStatus");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsStatusNotEqualTo(Integer value) {
            this.addCriterion("goods_status <>", value, "goodsStatus");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsStatusGreaterThan(Integer value) {
            this.addCriterion("goods_status >", value, "goodsStatus");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("goods_status >=", value, "goodsStatus");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsStatusLessThan(Integer value) {
            this.addCriterion("goods_status <", value, "goodsStatus");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("goods_status <=", value, "goodsStatus");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsStatusLike(String value) {
            this.addCriterion("goods_status like", value, "goodsStatus");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsStatusNotLike(String value) {
            this.addCriterion("goods_status not like", value, "goodsStatus");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andGoodsStatusIn(List<Integer> values) {
            this.addCriterion("goods_status in", values, "goodsStatus");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsStatusNotIn(List<Integer> values) {
            this.addCriterion("goods_status not in", values, "goodsStatus");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("goods_status between", value1, value2, "goodsStatus");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("goods_status not between", value1, value2, "goodsStatus");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoIsNull() {
            this.addCriterion("goods_no is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoIsNotNull() {
            this.addCriterion("goods_no is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoEqualTo(String value) {
            this.addCriterion("goods_no =", value, "goodsNo");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoNotEqualTo(String value) {
            this.addCriterion("goods_no <>", value, "goodsNo");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoGreaterThan(String value) {
            this.addCriterion("goods_no >", value, "goodsNo");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoGreaterThanOrEqualTo(String value) {
            this.addCriterion("goods_no >=", value, "goodsNo");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoLessThan(String value) {
            this.addCriterion("goods_no <", value, "goodsNo");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoLessThanOrEqualTo(String value) {
            this.addCriterion("goods_no <=", value, "goodsNo");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoLike(String value) {
            this.addCriterion("goods_no like", value, "goodsNo");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoNotLike(String value) {
            this.addCriterion("goods_no not like", value, "goodsNo");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andGoodsNoIn(List<String> values) {
            this.addCriterion("goods_no in", values, "goodsNo");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoNotIn(List<String> values) {
            this.addCriterion("goods_no not in", values, "goodsNo");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoBetween(String value1, String value2) {
            this.addCriterion("goods_no between", value1, value2, "goodsNo");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsNoNotBetween(String value1, String value2) {
            this.addCriterion("goods_no not between", value1, value2, "goodsNo");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSortOrderIsNull() {
            this.addCriterion("sort_order is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSortOrderIsNotNull() {
            this.addCriterion("sort_order is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSortOrderEqualTo(Long value) {
            this.addCriterion("sort_order =", value, "sortOrder");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSortOrderNotEqualTo(Long value) {
            this.addCriterion("sort_order <>", value, "sortOrder");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSortOrderGreaterThan(Long value) {
            this.addCriterion("sort_order >", value, "sortOrder");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSortOrderGreaterThanOrEqualTo(Long value) {
            this.addCriterion("sort_order >=", value, "sortOrder");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSortOrderLessThan(Long value) {
            this.addCriterion("sort_order <", value, "sortOrder");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSortOrderLessThanOrEqualTo(Long value) {
            this.addCriterion("sort_order <=", value, "sortOrder");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSortOrderLike(String value) {
            this.addCriterion("sort_order like", value, "sortOrder");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSortOrderNotLike(String value) {
            this.addCriterion("sort_order not like", value, "sortOrder");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andSortOrderIn(List<Long> values) {
            this.addCriterion("sort_order in", values, "sortOrder");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSortOrderNotIn(List<Long> values) {
            this.addCriterion("sort_order not in", values, "sortOrder");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSortOrderBetween(Long value1, Long value2) {
            this.addCriterion("sort_order between", value1, value2, "sortOrder");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andSortOrderNotBetween(Long value1, Long value2) {
            this.addCriterion("sort_order not between", value1, value2, "sortOrder");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderIsNull() {
            this.addCriterion("in_store_sort_order is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderIsNotNull() {
            this.addCriterion("in_store_sort_order is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderEqualTo(Long value) {
            this.addCriterion("in_store_sort_order =", value, "inStoreSortOrder");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderNotEqualTo(Long value) {
            this.addCriterion("in_store_sort_order <>", value, "inStoreSortOrder");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderGreaterThan(Long value) {
            this.addCriterion("in_store_sort_order >", value, "inStoreSortOrder");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderGreaterThanOrEqualTo(Long value) {
            this.addCriterion("in_store_sort_order >=", value, "inStoreSortOrder");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderLessThan(Long value) {
            this.addCriterion("in_store_sort_order <", value, "inStoreSortOrder");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderLessThanOrEqualTo(Long value) {
            this.addCriterion("in_store_sort_order <=", value, "inStoreSortOrder");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderLike(String value) {
            this.addCriterion("in_store_sort_order like", value, "inStoreSortOrder");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderNotLike(String value) {
            this.addCriterion("in_store_sort_order not like", value, "inStoreSortOrder");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderIn(List<Long> values) {
            this.addCriterion("in_store_sort_order in", values, "inStoreSortOrder");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderNotIn(List<Long> values) {
            this.addCriterion("in_store_sort_order not in", values, "inStoreSortOrder");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderBetween(Long value1, Long value2) {
            this.addCriterion("in_store_sort_order between", value1, value2, "inStoreSortOrder");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andInStoreSortOrderNotBetween(Long value1, Long value2) {
            this.addCriterion("in_store_sort_order not between", value1, value2, "inStoreSortOrder");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsIsNull() {
            this.addCriterion("number_tradable_goods is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsIsNotNull() {
            this.addCriterion("number_tradable_goods is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsEqualTo(Long value) {
            this.addCriterion("number_tradable_goods =", value, "numberTradableGoods");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsNotEqualTo(Long value) {
            this.addCriterion("number_tradable_goods <>", value, "numberTradableGoods");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsGreaterThan(Long value) {
            this.addCriterion("number_tradable_goods >", value, "numberTradableGoods");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsGreaterThanOrEqualTo(Long value) {
            this.addCriterion("number_tradable_goods >=", value, "numberTradableGoods");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsLessThan(Long value) {
            this.addCriterion("number_tradable_goods <", value, "numberTradableGoods");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsLessThanOrEqualTo(Long value) {
            this.addCriterion("number_tradable_goods <=", value, "numberTradableGoods");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsLike(String value) {
            this.addCriterion("number_tradable_goods like", value, "numberTradableGoods");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsNotLike(String value) {
            this.addCriterion("number_tradable_goods not like", value, "numberTradableGoods");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsIn(List<Long> values) {
            this.addCriterion("number_tradable_goods in", values, "numberTradableGoods");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsNotIn(List<Long> values) {
            this.addCriterion("number_tradable_goods not in", values, "numberTradableGoods");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsBetween(Long value1, Long value2) {
            this.addCriterion("number_tradable_goods between", value1, value2, "numberTradableGoods");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNumberTradableGoodsNotBetween(Long value1, Long value2) {
            this.addCriterion("number_tradable_goods not between", value1, value2, "numberTradableGoods");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsIsNull() {
            this.addCriterion("not_number_tradable_goods is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsIsNotNull() {
            this.addCriterion("not_number_tradable_goods is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsEqualTo(Long value) {
            this.addCriterion("not_number_tradable_goods =", value, "notNumberTradableGoods");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsNotEqualTo(Long value) {
            this.addCriterion("not_number_tradable_goods <>", value, "notNumberTradableGoods");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsGreaterThan(Long value) {
            this.addCriterion("not_number_tradable_goods >", value, "notNumberTradableGoods");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsGreaterThanOrEqualTo(Long value) {
            this.addCriterion("not_number_tradable_goods >=", value, "notNumberTradableGoods");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsLessThan(Long value) {
            this.addCriterion("not_number_tradable_goods <", value, "notNumberTradableGoods");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsLessThanOrEqualTo(Long value) {
            this.addCriterion("not_number_tradable_goods <=", value, "notNumberTradableGoods");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsLike(String value) {
            this.addCriterion("not_number_tradable_goods like", value, "notNumberTradableGoods");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsNotLike(String value) {
            this.addCriterion("not_number_tradable_goods not like", value, "notNumberTradableGoods");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsIn(List<Long> values) {
            this.addCriterion("not_number_tradable_goods in", values, "notNumberTradableGoods");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsNotIn(List<Long> values) {
            this.addCriterion("not_number_tradable_goods not in", values, "notNumberTradableGoods");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsBetween(Long value1, Long value2) {
            this.addCriterion("not_number_tradable_goods between", value1, value2, "notNumberTradableGoods");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andNotNumberTradableGoodsNotBetween(Long value1, Long value2) {
            this.addCriterion("not_number_tradable_goods not between", value1, value2, "notNumberTradableGoods");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteIsNull() {
            this.addCriterion("web_site is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteIsNotNull() {
            this.addCriterion("web_site is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("web_site =", value, "webSite");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("web_site <>", value, "webSite");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("web_site >", value, "webSite");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("web_site >=", value, "webSite");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteLessThan(String value) {
            this.addCriterion("web_site <", value, "webSite");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("web_site <=", value, "webSite");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteLike(String value) {
            this.addCriterion("web_site like", value, "webSite");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteNotLike(String value) {
            this.addCriterion("web_site not like", value, "webSite");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("web_site in", values, "webSite");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("web_site not in", values, "webSite");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("web_site between", value1, value2, "webSite");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("web_site not between", value1, value2, "webSite");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLoadDateIsNull() {
            this.addCriterion("load_date is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLoadDateIsNotNull() {
            this.addCriterion("load_date is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLoadDateEqualTo(Date value) {
            this.addCriterion("load_date =", value, "loadDate");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLoadDateNotEqualTo(Date value) {
            this.addCriterion("load_date <>", value, "loadDate");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLoadDateGreaterThan(Date value) {
            this.addCriterion("load_date >", value, "loadDate");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLoadDateGreaterThanOrEqualTo(Date value) {
            this.addCriterion("load_date >=", value, "loadDate");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLoadDateLessThan(Date value) {
            this.addCriterion("load_date <", value, "loadDate");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLoadDateLessThanOrEqualTo(Date value) {
            this.addCriterion("load_date <=", value, "loadDate");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLoadDateLike(String value) {
            this.addCriterion("load_date like", value, "loadDate");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLoadDateNotLike(String value) {
            this.addCriterion("load_date not like", value, "loadDate");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andLoadDateIn(List<Date> values) {
            this.addCriterion("load_date in", values, "loadDate");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLoadDateNotIn(List<Date> values) {
            this.addCriterion("load_date not in", values, "loadDate");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLoadDateBetween(Date value1, Date value2) {
            this.addCriterion("load_date between", value1, value2, "loadDate");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLoadDateNotBetween(Date value1, Date value2) {
            this.addCriterion("load_date not between", value1, value2, "loadDate");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwIsNull() {
            this.addCriterion("im_aliww is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwIsNotNull() {
            this.addCriterion("im_aliww is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwEqualTo(String value) {
            this.addCriterion("im_aliww =", value, "imAliww");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwNotEqualTo(String value) {
            this.addCriterion("im_aliww <>", value, "imAliww");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwGreaterThan(String value) {
            this.addCriterion("im_aliww >", value, "imAliww");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_aliww >=", value, "imAliww");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwLessThan(String value) {
            this.addCriterion("im_aliww <", value, "imAliww");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwLessThanOrEqualTo(String value) {
            this.addCriterion("im_aliww <=", value, "imAliww");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwLike(String value) {
            this.addCriterion("im_aliww like", value, "imAliww");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwNotLike(String value) {
            this.addCriterion("im_aliww not like", value, "imAliww");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andImAliwwIn(List<String> values) {
            this.addCriterion("im_aliww in", values, "imAliww");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwNotIn(List<String> values) {
            this.addCriterion("im_aliww not in", values, "imAliww");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwBetween(String value1, String value2) {
            this.addCriterion("im_aliww between", value1, value2, "imAliww");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andImAliwwNotBetween(String value1, String value2) {
            this.addCriterion("im_aliww not between", value1, value2, "imAliww");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesIsNull() {
            this.addCriterion("goods_services is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesIsNotNull() {
            this.addCriterion("goods_services is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesEqualTo(String value) {
            this.addCriterion("goods_services =", value, "goodsServices");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesNotEqualTo(String value) {
            this.addCriterion("goods_services <>", value, "goodsServices");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesGreaterThan(String value) {
            this.addCriterion("goods_services >", value, "goodsServices");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesGreaterThanOrEqualTo(String value) {
            this.addCriterion("goods_services >=", value, "goodsServices");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesLessThan(String value) {
            this.addCriterion("goods_services <", value, "goodsServices");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesLessThanOrEqualTo(String value) {
            this.addCriterion("goods_services <=", value, "goodsServices");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesLike(String value) {
            this.addCriterion("goods_services like", value, "goodsServices");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesNotLike(String value) {
            this.addCriterion("goods_services not like", value, "goodsServices");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andGoodsServicesIn(List<String> values) {
            this.addCriterion("goods_services in", values, "goodsServices");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesNotIn(List<String> values) {
            this.addCriterion("goods_services not in", values, "goodsServices");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesBetween(String value1, String value2) {
            this.addCriterion("goods_services between", value1, value2, "goodsServices");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsServicesNotBetween(String value1, String value2) {
            this.addCriterion("goods_services not between", value1, value2, "goodsServices");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsShowcaseIsNull() {
            this.addCriterion("is_showcase is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsShowcaseIsNotNull() {
            this.addCriterion("is_showcase is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsShowcaseEqualTo(Integer value) {
            this.addCriterion("is_showcase =", value, "isShowcase");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsShowcaseNotEqualTo(Integer value) {
            this.addCriterion("is_showcase <>", value, "isShowcase");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsShowcaseGreaterThan(Integer value) {
            this.addCriterion("is_showcase >", value, "isShowcase");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsShowcaseGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_showcase >=", value, "isShowcase");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsShowcaseLessThan(Integer value) {
            this.addCriterion("is_showcase <", value, "isShowcase");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsShowcaseLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_showcase <=", value, "isShowcase");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsShowcaseLike(String value) {
            this.addCriterion("is_showcase like", value, "isShowcase");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsShowcaseNotLike(String value) {
            this.addCriterion("is_showcase not like", value, "isShowcase");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andIsShowcaseIn(List<Integer> values) {
            this.addCriterion("is_showcase in", values, "isShowcase");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsShowcaseNotIn(List<Integer> values) {
            this.addCriterion("is_showcase not in", values, "isShowcase");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsShowcaseBetween(Integer value1, Integer value2) {
            this.addCriterion("is_showcase between", value1, value2, "isShowcase");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsShowcaseNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_showcase not between", value1, value2, "isShowcase");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsStandardIsNull() {
            this.addCriterion("is_standard is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsStandardIsNotNull() {
            this.addCriterion("is_standard is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsStandardEqualTo(Integer value) {
            this.addCriterion("is_standard =", value, "isStandard");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsStandardNotEqualTo(Integer value) {
            this.addCriterion("is_standard <>", value, "isStandard");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsStandardGreaterThan(Integer value) {
            this.addCriterion("is_standard >", value, "isStandard");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsStandardGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_standard >=", value, "isStandard");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsStandardLessThan(Integer value) {
            this.addCriterion("is_standard <", value, "isStandard");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsStandardLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_standard <=", value, "isStandard");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsStandardLike(String value) {
            this.addCriterion("is_standard like", value, "isStandard");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsStandardNotLike(String value) {
            this.addCriterion("is_standard not like", value, "isStandard");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andIsStandardIn(List<Integer> values) {
            this.addCriterion("is_standard in", values, "isStandard");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsStandardNotIn(List<Integer> values) {
            this.addCriterion("is_standard not in", values, "isStandard");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsStandardBetween(Integer value1, Integer value2) {
            this.addCriterion("is_standard between", value1, value2, "isStandard");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsStandardNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_standard not between", value1, value2, "isStandard");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexIsNull() {
            this.addCriterion("title_index is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexIsNotNull() {
            this.addCriterion("title_index is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexEqualTo(String value) {
            this.addCriterion("title_index =", value, "titleIndex");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexNotEqualTo(String value) {
            this.addCriterion("title_index <>", value, "titleIndex");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexGreaterThan(String value) {
            this.addCriterion("title_index >", value, "titleIndex");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexGreaterThanOrEqualTo(String value) {
            this.addCriterion("title_index >=", value, "titleIndex");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexLessThan(String value) {
            this.addCriterion("title_index <", value, "titleIndex");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexLessThanOrEqualTo(String value) {
            this.addCriterion("title_index <=", value, "titleIndex");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexLike(String value) {
            this.addCriterion("title_index like", value, "titleIndex");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexNotLike(String value) {
            this.addCriterion("title_index not like", value, "titleIndex");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andTitleIndexIn(List<String> values) {
            this.addCriterion("title_index in", values, "titleIndex");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexNotIn(List<String> values) {
            this.addCriterion("title_index not in", values, "titleIndex");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexBetween(String value1, String value2) {
            this.addCriterion("title_index between", value1, value2, "titleIndex");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andTitleIndexNotBetween(String value1, String value2) {
            this.addCriterion("title_index not between", value1, value2, "titleIndex");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceIsNull() {
            this.addCriterion("is_admin_set_pi_price is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceIsNotNull() {
            this.addCriterion("is_admin_set_pi_price is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceEqualTo(Integer value) {
            this.addCriterion("is_admin_set_pi_price =", value, "isAdminSetPiPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceNotEqualTo(Integer value) {
            this.addCriterion("is_admin_set_pi_price <>", value, "isAdminSetPiPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceGreaterThan(Integer value) {
            this.addCriterion("is_admin_set_pi_price >", value, "isAdminSetPiPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_admin_set_pi_price >=", value, "isAdminSetPiPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceLessThan(Integer value) {
            this.addCriterion("is_admin_set_pi_price <", value, "isAdminSetPiPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_admin_set_pi_price <=", value, "isAdminSetPiPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceLike(String value) {
            this.addCriterion("is_admin_set_pi_price like", value, "isAdminSetPiPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceNotLike(String value) {
            this.addCriterion("is_admin_set_pi_price not like", value, "isAdminSetPiPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceIn(List<Integer> values) {
            this.addCriterion("is_admin_set_pi_price in", values, "isAdminSetPiPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceNotIn(List<Integer> values) {
            this.addCriterion("is_admin_set_pi_price not in", values, "isAdminSetPiPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceBetween(Integer value1, Integer value2) {
            this.addCriterion("is_admin_set_pi_price between", value1, value2, "isAdminSetPiPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsAdminSetPiPriceNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_admin_set_pi_price not between", value1, value2, "isAdminSetPiPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceIsNull() {
            this.addCriterion("is_user_set_pi_price is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceIsNotNull() {
            this.addCriterion("is_user_set_pi_price is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceEqualTo(Integer value) {
            this.addCriterion("is_user_set_pi_price =", value, "isUserSetPiPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceNotEqualTo(Integer value) {
            this.addCriterion("is_user_set_pi_price <>", value, "isUserSetPiPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceGreaterThan(Integer value) {
            this.addCriterion("is_user_set_pi_price >", value, "isUserSetPiPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_user_set_pi_price >=", value, "isUserSetPiPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceLessThan(Integer value) {
            this.addCriterion("is_user_set_pi_price <", value, "isUserSetPiPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_user_set_pi_price <=", value, "isUserSetPiPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceLike(String value) {
            this.addCriterion("is_user_set_pi_price like", value, "isUserSetPiPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceNotLike(String value) {
            this.addCriterion("is_user_set_pi_price not like", value, "isUserSetPiPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceIn(List<Integer> values) {
            this.addCriterion("is_user_set_pi_price in", values, "isUserSetPiPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceNotIn(List<Integer> values) {
            this.addCriterion("is_user_set_pi_price not in", values, "isUserSetPiPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceBetween(Integer value1, Integer value2) {
            this.addCriterion("is_user_set_pi_price between", value1, value2, "isUserSetPiPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsUserSetPiPriceNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_user_set_pi_price not between", value1, value2, "isUserSetPiPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsExcelImpIsNull() {
            this.addCriterion("is_excel_imp is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsExcelImpIsNotNull() {
            this.addCriterion("is_excel_imp is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsExcelImpEqualTo(Integer value) {
            this.addCriterion("is_excel_imp =", value, "isExcelImp");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsExcelImpNotEqualTo(Integer value) {
            this.addCriterion("is_excel_imp <>", value, "isExcelImp");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsExcelImpGreaterThan(Integer value) {
            this.addCriterion("is_excel_imp >", value, "isExcelImp");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsExcelImpGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_excel_imp >=", value, "isExcelImp");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsExcelImpLessThan(Integer value) {
            this.addCriterion("is_excel_imp <", value, "isExcelImp");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsExcelImpLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_excel_imp <=", value, "isExcelImp");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsExcelImpLike(String value) {
            this.addCriterion("is_excel_imp like", value, "isExcelImp");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsExcelImpNotLike(String value) {
            this.addCriterion("is_excel_imp not like", value, "isExcelImp");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andIsExcelImpIn(List<Integer> values) {
            this.addCriterion("is_excel_imp in", values, "isExcelImp");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsExcelImpNotIn(List<Integer> values) {
            this.addCriterion("is_excel_imp not in", values, "isExcelImp");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsExcelImpBetween(Integer value1, Integer value2) {
            this.addCriterion("is_excel_imp between", value1, value2, "isExcelImp");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsExcelImpNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_excel_imp not between", value1, value2, "isExcelImp");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameIsNull() {
            this.addCriterion("up_data_package_name is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameIsNotNull() {
            this.addCriterion("up_data_package_name is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameEqualTo(String value) {
            this.addCriterion("up_data_package_name =", value, "upDataPackageName");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameNotEqualTo(String value) {
            this.addCriterion("up_data_package_name <>", value, "upDataPackageName");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameGreaterThan(String value) {
            this.addCriterion("up_data_package_name >", value, "upDataPackageName");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("up_data_package_name >=", value, "upDataPackageName");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameLessThan(String value) {
            this.addCriterion("up_data_package_name <", value, "upDataPackageName");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameLessThanOrEqualTo(String value) {
            this.addCriterion("up_data_package_name <=", value, "upDataPackageName");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameLike(String value) {
            this.addCriterion("up_data_package_name like", value, "upDataPackageName");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameNotLike(String value) {
            this.addCriterion("up_data_package_name not like", value, "upDataPackageName");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameIn(List<String> values) {
            this.addCriterion("up_data_package_name in", values, "upDataPackageName");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameNotIn(List<String> values) {
            this.addCriterion("up_data_package_name not in", values, "upDataPackageName");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameBetween(String value1, String value2) {
            this.addCriterion("up_data_package_name between", value1, value2, "upDataPackageName");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageNameNotBetween(String value1, String value2) {
            this.addCriterion("up_data_package_name not between", value1, value2, "upDataPackageName");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlIsNull() {
            this.addCriterion("up_data_package_url is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlIsNotNull() {
            this.addCriterion("up_data_package_url is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlEqualTo(String value) {
            this.addCriterion("up_data_package_url =", value, "upDataPackageUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlNotEqualTo(String value) {
            this.addCriterion("up_data_package_url <>", value, "upDataPackageUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlGreaterThan(String value) {
            this.addCriterion("up_data_package_url >", value, "upDataPackageUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("up_data_package_url >=", value, "upDataPackageUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlLessThan(String value) {
            this.addCriterion("up_data_package_url <", value, "upDataPackageUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlLessThanOrEqualTo(String value) {
            this.addCriterion("up_data_package_url <=", value, "upDataPackageUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlLike(String value) {
            this.addCriterion("up_data_package_url like", value, "upDataPackageUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlNotLike(String value) {
            this.addCriterion("up_data_package_url not like", value, "upDataPackageUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlIn(List<String> values) {
            this.addCriterion("up_data_package_url in", values, "upDataPackageUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlNotIn(List<String> values) {
            this.addCriterion("up_data_package_url not in", values, "upDataPackageUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlBetween(String value1, String value2) {
            this.addCriterion("up_data_package_url between", value1, value2, "upDataPackageUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andUpDataPackageUrlNotBetween(String value1, String value2) {
            this.addCriterion("up_data_package_url not between", value1, value2, "upDataPackageUrl");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDataPackageIsNull() {
            this.addCriterion("is_data_package is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDataPackageIsNotNull() {
            this.addCriterion("is_data_package is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDataPackageEqualTo(Integer value) {
            this.addCriterion("is_data_package =", value, "isDataPackage");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDataPackageNotEqualTo(Integer value) {
            this.addCriterion("is_data_package <>", value, "isDataPackage");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDataPackageGreaterThan(Integer value) {
            this.addCriterion("is_data_package >", value, "isDataPackage");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDataPackageGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_data_package >=", value, "isDataPackage");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDataPackageLessThan(Integer value) {
            this.addCriterion("is_data_package <", value, "isDataPackage");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDataPackageLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_data_package <=", value, "isDataPackage");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDataPackageLike(String value) {
            this.addCriterion("is_data_package like", value, "isDataPackage");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDataPackageNotLike(String value) {
            this.addCriterion("is_data_package not like", value, "isDataPackage");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andIsDataPackageIn(List<Integer> values) {
            this.addCriterion("is_data_package in", values, "isDataPackage");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDataPackageNotIn(List<Integer> values) {
            this.addCriterion("is_data_package not in", values, "isDataPackage");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDataPackageBetween(Integer value1, Integer value2) {
            this.addCriterion("is_data_package between", value1, value2, "isDataPackage");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsDataPackageNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_data_package not between", value1, value2, "isDataPackage");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSetModeIsNull() {
            this.addCriterion("is_set_mode is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSetModeIsNotNull() {
            this.addCriterion("is_set_mode is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSetModeEqualTo(Integer value) {
            this.addCriterion("is_set_mode =", value, "isSetMode");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSetModeNotEqualTo(Integer value) {
            this.addCriterion("is_set_mode <>", value, "isSetMode");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSetModeGreaterThan(Integer value) {
            this.addCriterion("is_set_mode >", value, "isSetMode");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSetModeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_set_mode >=", value, "isSetMode");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSetModeLessThan(Integer value) {
            this.addCriterion("is_set_mode <", value, "isSetMode");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSetModeLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_set_mode <=", value, "isSetMode");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSetModeLike(String value) {
            this.addCriterion("is_set_mode like", value, "isSetMode");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSetModeNotLike(String value) {
            this.addCriterion("is_set_mode not like", value, "isSetMode");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andIsSetModeIn(List<Integer> values) {
            this.addCriterion("is_set_mode in", values, "isSetMode");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSetModeNotIn(List<Integer> values) {
            this.addCriterion("is_set_mode not in", values, "isSetMode");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSetModeBetween(Integer value1, Integer value2) {
            this.addCriterion("is_set_mode between", value1, value2, "isSetMode");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsSetModeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_set_mode not between", value1, value2, "isSetMode");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdIsNull() {
            this.addCriterion("mode_top_type_id is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdIsNotNull() {
            this.addCriterion("mode_top_type_id is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdEqualTo(Long value) {
            this.addCriterion("mode_top_type_id =", value, "modeTopTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdNotEqualTo(Long value) {
            this.addCriterion("mode_top_type_id <>", value, "modeTopTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdGreaterThan(Long value) {
            this.addCriterion("mode_top_type_id >", value, "modeTopTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("mode_top_type_id >=", value, "modeTopTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdLessThan(Long value) {
            this.addCriterion("mode_top_type_id <", value, "modeTopTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdLessThanOrEqualTo(Long value) {
            this.addCriterion("mode_top_type_id <=", value, "modeTopTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdLike(String value) {
            this.addCriterion("mode_top_type_id like", value, "modeTopTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdNotLike(String value) {
            this.addCriterion("mode_top_type_id not like", value, "modeTopTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdIn(List<Long> values) {
            this.addCriterion("mode_top_type_id in", values, "modeTopTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdNotIn(List<Long> values) {
            this.addCriterion("mode_top_type_id not in", values, "modeTopTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdBetween(Long value1, Long value2) {
            this.addCriterion("mode_top_type_id between", value1, value2, "modeTopTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIdNotBetween(Long value1, Long value2) {
            this.addCriterion("mode_top_type_id not between", value1, value2, "modeTopTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIsNull() {
            this.addCriterion("mode_top_type is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeIsNotNull() {
            this.addCriterion("mode_top_type is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeEqualTo(String value) {
            this.addCriterion("mode_top_type =", value, "modeTopType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeNotEqualTo(String value) {
            this.addCriterion("mode_top_type <>", value, "modeTopType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeGreaterThan(String value) {
            this.addCriterion("mode_top_type >", value, "modeTopType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeGreaterThanOrEqualTo(String value) {
            this.addCriterion("mode_top_type >=", value, "modeTopType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeLessThan(String value) {
            this.addCriterion("mode_top_type <", value, "modeTopType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeLessThanOrEqualTo(String value) {
            this.addCriterion("mode_top_type <=", value, "modeTopType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeLike(String value) {
            this.addCriterion("mode_top_type like", value, "modeTopType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeNotLike(String value) {
            this.addCriterion("mode_top_type not like", value, "modeTopType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andModeTopTypeIn(List<String> values) {
            this.addCriterion("mode_top_type in", values, "modeTopType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeNotIn(List<String> values) {
            this.addCriterion("mode_top_type not in", values, "modeTopType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeBetween(String value1, String value2) {
            this.addCriterion("mode_top_type between", value1, value2, "modeTopType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeTopTypeNotBetween(String value1, String value2) {
            this.addCriterion("mode_top_type not between", value1, value2, "modeTopType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdIsNull() {
            this.addCriterion("mode_first_type_id is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdIsNotNull() {
            this.addCriterion("mode_first_type_id is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdEqualTo(Long value) {
            this.addCriterion("mode_first_type_id =", value, "modeFirstTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdNotEqualTo(Long value) {
            this.addCriterion("mode_first_type_id <>", value, "modeFirstTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdGreaterThan(Long value) {
            this.addCriterion("mode_first_type_id >", value, "modeFirstTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("mode_first_type_id >=", value, "modeFirstTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdLessThan(Long value) {
            this.addCriterion("mode_first_type_id <", value, "modeFirstTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdLessThanOrEqualTo(Long value) {
            this.addCriterion("mode_first_type_id <=", value, "modeFirstTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdLike(String value) {
            this.addCriterion("mode_first_type_id like", value, "modeFirstTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdNotLike(String value) {
            this.addCriterion("mode_first_type_id not like", value, "modeFirstTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdIn(List<Long> values) {
            this.addCriterion("mode_first_type_id in", values, "modeFirstTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdNotIn(List<Long> values) {
            this.addCriterion("mode_first_type_id not in", values, "modeFirstTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdBetween(Long value1, Long value2) {
            this.addCriterion("mode_first_type_id between", value1, value2, "modeFirstTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIdNotBetween(Long value1, Long value2) {
            this.addCriterion("mode_first_type_id not between", value1, value2, "modeFirstTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIsNull() {
            this.addCriterion("mode_first_type is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIsNotNull() {
            this.addCriterion("mode_first_type is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeEqualTo(String value) {
            this.addCriterion("mode_first_type =", value, "modeFirstType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeNotEqualTo(String value) {
            this.addCriterion("mode_first_type <>", value, "modeFirstType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeGreaterThan(String value) {
            this.addCriterion("mode_first_type >", value, "modeFirstType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeGreaterThanOrEqualTo(String value) {
            this.addCriterion("mode_first_type >=", value, "modeFirstType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeLessThan(String value) {
            this.addCriterion("mode_first_type <", value, "modeFirstType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeLessThanOrEqualTo(String value) {
            this.addCriterion("mode_first_type <=", value, "modeFirstType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeLike(String value) {
            this.addCriterion("mode_first_type like", value, "modeFirstType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeNotLike(String value) {
            this.addCriterion("mode_first_type not like", value, "modeFirstType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andModeFirstTypeIn(List<String> values) {
            this.addCriterion("mode_first_type in", values, "modeFirstType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeNotIn(List<String> values) {
            this.addCriterion("mode_first_type not in", values, "modeFirstType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeBetween(String value1, String value2) {
            this.addCriterion("mode_first_type between", value1, value2, "modeFirstType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeFirstTypeNotBetween(String value1, String value2) {
            this.addCriterion("mode_first_type not between", value1, value2, "modeFirstType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdIsNull() {
            this.addCriterion("mode_second_type_id is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdIsNotNull() {
            this.addCriterion("mode_second_type_id is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdEqualTo(Long value) {
            this.addCriterion("mode_second_type_id =", value, "modeSecondTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdNotEqualTo(Long value) {
            this.addCriterion("mode_second_type_id <>", value, "modeSecondTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdGreaterThan(Long value) {
            this.addCriterion("mode_second_type_id >", value, "modeSecondTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("mode_second_type_id >=", value, "modeSecondTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdLessThan(Long value) {
            this.addCriterion("mode_second_type_id <", value, "modeSecondTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdLessThanOrEqualTo(Long value) {
            this.addCriterion("mode_second_type_id <=", value, "modeSecondTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdLike(String value) {
            this.addCriterion("mode_second_type_id like", value, "modeSecondTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdNotLike(String value) {
            this.addCriterion("mode_second_type_id not like", value, "modeSecondTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdIn(List<Long> values) {
            this.addCriterion("mode_second_type_id in", values, "modeSecondTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdNotIn(List<Long> values) {
            this.addCriterion("mode_second_type_id not in", values, "modeSecondTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdBetween(Long value1, Long value2) {
            this.addCriterion("mode_second_type_id between", value1, value2, "modeSecondTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIdNotBetween(Long value1, Long value2) {
            this.addCriterion("mode_second_type_id not between", value1, value2, "modeSecondTypeId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIsNull() {
            this.addCriterion("mode_second_type is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIsNotNull() {
            this.addCriterion("mode_second_type is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeEqualTo(String value) {
            this.addCriterion("mode_second_type =", value, "modeSecondType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeNotEqualTo(String value) {
            this.addCriterion("mode_second_type <>", value, "modeSecondType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeGreaterThan(String value) {
            this.addCriterion("mode_second_type >", value, "modeSecondType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeGreaterThanOrEqualTo(String value) {
            this.addCriterion("mode_second_type >=", value, "modeSecondType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeLessThan(String value) {
            this.addCriterion("mode_second_type <", value, "modeSecondType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeLessThanOrEqualTo(String value) {
            this.addCriterion("mode_second_type <=", value, "modeSecondType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeLike(String value) {
            this.addCriterion("mode_second_type like", value, "modeSecondType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeNotLike(String value) {
            this.addCriterion("mode_second_type not like", value, "modeSecondType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andModeSecondTypeIn(List<String> values) {
            this.addCriterion("mode_second_type in", values, "modeSecondType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeNotIn(List<String> values) {
            this.addCriterion("mode_second_type not in", values, "modeSecondType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeBetween(String value1, String value2) {
            this.addCriterion("mode_second_type between", value1, value2, "modeSecondType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andModeSecondTypeNotBetween(String value1, String value2) {
            this.addCriterion("mode_second_type not between", value1, value2, "modeSecondType");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLastModifyTimeIsNull() {
            this.addCriterion("last_modify_time is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLastModifyTimeIsNotNull() {
            this.addCriterion("last_modify_time is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLastModifyTimeEqualTo(Date value) {
            this.addCriterion("last_modify_time =", value, "lastModifyTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLastModifyTimeNotEqualTo(Date value) {
            this.addCriterion("last_modify_time <>", value, "lastModifyTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLastModifyTimeGreaterThan(Date value) {
            this.addCriterion("last_modify_time >", value, "lastModifyTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("last_modify_time >=", value, "lastModifyTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLastModifyTimeLessThan(Date value) {
            this.addCriterion("last_modify_time <", value, "lastModifyTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("last_modify_time <=", value, "lastModifyTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLastModifyTimeLike(String value) {
            this.addCriterion("last_modify_time like", value, "lastModifyTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLastModifyTimeNotLike(String value) {
            this.addCriterion("last_modify_time not like", value, "lastModifyTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andLastModifyTimeIn(List<Date> values) {
            this.addCriterion("last_modify_time in", values, "lastModifyTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLastModifyTimeNotIn(List<Date> values) {
            this.addCriterion("last_modify_time not in", values, "lastModifyTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            this.addCriterion("last_modify_time between", value1, value2, "lastModifyTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("last_modify_time not between", value1, value2, "lastModifyTime");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModTitleIsNull() {
            this.addCriterion("is_mod_title is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModTitleIsNotNull() {
            this.addCriterion("is_mod_title is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModTitleEqualTo(Integer value) {
            this.addCriterion("is_mod_title =", value, "isModTitle");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModTitleNotEqualTo(Integer value) {
            this.addCriterion("is_mod_title <>", value, "isModTitle");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModTitleGreaterThan(Integer value) {
            this.addCriterion("is_mod_title >", value, "isModTitle");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModTitleGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_mod_title >=", value, "isModTitle");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModTitleLessThan(Integer value) {
            this.addCriterion("is_mod_title <", value, "isModTitle");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModTitleLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_mod_title <=", value, "isModTitle");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModTitleLike(String value) {
            this.addCriterion("is_mod_title like", value, "isModTitle");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModTitleNotLike(String value) {
            this.addCriterion("is_mod_title not like", value, "isModTitle");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andIsModTitleIn(List<Integer> values) {
            this.addCriterion("is_mod_title in", values, "isModTitle");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModTitleNotIn(List<Integer> values) {
            this.addCriterion("is_mod_title not in", values, "isModTitle");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModTitleBetween(Integer value1, Integer value2) {
            this.addCriterion("is_mod_title between", value1, value2, "isModTitle");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModTitleNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_mod_title not between", value1, value2, "isModTitle");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModPriceIsNull() {
            this.addCriterion("is_mod_price is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModPriceIsNotNull() {
            this.addCriterion("is_mod_price is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModPriceEqualTo(Integer value) {
            this.addCriterion("is_mod_price =", value, "isModPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModPriceNotEqualTo(Integer value) {
            this.addCriterion("is_mod_price <>", value, "isModPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModPriceGreaterThan(Integer value) {
            this.addCriterion("is_mod_price >", value, "isModPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModPriceGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_mod_price >=", value, "isModPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModPriceLessThan(Integer value) {
            this.addCriterion("is_mod_price <", value, "isModPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModPriceLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_mod_price <=", value, "isModPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModPriceLike(String value) {
            this.addCriterion("is_mod_price like", value, "isModPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModPriceNotLike(String value) {
            this.addCriterion("is_mod_price not like", value, "isModPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andIsModPriceIn(List<Integer> values) {
            this.addCriterion("is_mod_price in", values, "isModPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModPriceNotIn(List<Integer> values) {
            this.addCriterion("is_mod_price not in", values, "isModPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModPriceBetween(Integer value1, Integer value2) {
            this.addCriterion("is_mod_price between", value1, value2, "isModPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModPriceNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_mod_price not between", value1, value2, "isModPrice");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoIsNull() {
            this.addCriterion("is_mod_goodsno is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoIsNotNull() {
            this.addCriterion("is_mod_goodsno is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoEqualTo(Integer value) {
            this.addCriterion("is_mod_goodsno =", value, "isModGoodsno");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoNotEqualTo(Integer value) {
            this.addCriterion("is_mod_goodsno <>", value, "isModGoodsno");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoGreaterThan(Integer value) {
            this.addCriterion("is_mod_goodsno >", value, "isModGoodsno");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_mod_goodsno >=", value, "isModGoodsno");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoLessThan(Integer value) {
            this.addCriterion("is_mod_goodsno <", value, "isModGoodsno");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_mod_goodsno <=", value, "isModGoodsno");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoLike(String value) {
            this.addCriterion("is_mod_goodsno like", value, "isModGoodsno");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoNotLike(String value) {
            this.addCriterion("is_mod_goodsno not like", value, "isModGoodsno");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoIn(List<Integer> values) {
            this.addCriterion("is_mod_goodsno in", values, "isModGoodsno");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoNotIn(List<Integer> values) {
            this.addCriterion("is_mod_goodsno not in", values, "isModGoodsno");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoBetween(Integer value1, Integer value2) {
            this.addCriterion("is_mod_goodsno between", value1, value2, "isModGoodsno");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andIsModGoodsnoNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_mod_goodsno not between", value1, value2, "isModGoodsno");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelIsNull() {
            this.addCriterion("goods_level is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelIsNotNull() {
            this.addCriterion("goods_level is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelEqualTo(String value) {
            this.addCriterion("goods_level =", value, "goodsLevel");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelNotEqualTo(String value) {
            this.addCriterion("goods_level <>", value, "goodsLevel");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelGreaterThan(String value) {
            this.addCriterion("goods_level >", value, "goodsLevel");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelGreaterThanOrEqualTo(String value) {
            this.addCriterion("goods_level >=", value, "goodsLevel");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelLessThan(String value) {
            this.addCriterion("goods_level <", value, "goodsLevel");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelLessThanOrEqualTo(String value) {
            this.addCriterion("goods_level <=", value, "goodsLevel");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelLike(String value) {
            this.addCriterion("goods_level like", value, "goodsLevel");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelNotLike(String value) {
            this.addCriterion("goods_level not like", value, "goodsLevel");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andGoodsLevelIn(List<String> values) {
            this.addCriterion("goods_level in", values, "goodsLevel");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelNotIn(List<String> values) {
            this.addCriterion("goods_level not in", values, "goodsLevel");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelBetween(String value1, String value2) {
            this.addCriterion("goods_level between", value1, value2, "goodsLevel");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andGoodsLevelNotBetween(String value1, String value2) {
            this.addCriterion("goods_level not between", value1, value2, "goodsLevel");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRelationLevelIdIsNull() {
            this.addCriterion("relation_level_id is null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRelationLevelIdIsNotNull() {
            this.addCriterion("relation_level_id is not null");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRelationLevelIdEqualTo(Long value) {
            this.addCriterion("relation_level_id =", value, "relationLevelId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRelationLevelIdNotEqualTo(Long value) {
            this.addCriterion("relation_level_id <>", value, "relationLevelId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRelationLevelIdGreaterThan(Long value) {
            this.addCriterion("relation_level_id >", value, "relationLevelId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRelationLevelIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("relation_level_id >=", value, "relationLevelId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRelationLevelIdLessThan(Long value) {
            this.addCriterion("relation_level_id <", value, "relationLevelId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRelationLevelIdLessThanOrEqualTo(Long value) {
            this.addCriterion("relation_level_id <=", value, "relationLevelId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRelationLevelIdLike(String value) {
            this.addCriterion("relation_level_id like", value, "relationLevelId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRelationLevelIdNotLike(String value) {
            this.addCriterion("relation_level_id not like", value, "relationLevelId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }        public ShiguGoodsTinyExample.Criteria andRelationLevelIdIn(List<Long> values) {
            this.addCriterion("relation_level_id in", values, "relationLevelId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRelationLevelIdNotIn(List<Long> values) {
            this.addCriterion("relation_level_id not in", values, "relationLevelId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRelationLevelIdBetween(Long value1, Long value2) {
            this.addCriterion("relation_level_id between", value1, value2, "relationLevelId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }

        public ShiguGoodsTinyExample.Criteria andRelationLevelIdNotBetween(Long value1, Long value2) {
            this.addCriterion("relation_level_id not between", value1, value2, "relationLevelId");
            return (ShiguGoodsTinyExample.Criteria)this;
        }
    }
}
