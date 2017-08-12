package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShiguGoodsTinyExample implements SgExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<Criteria> oredCriteria = new ArrayList();

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

    public List<Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
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

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public Criteria andGoodsIdIsNull() {
            this.addCriterion("goods_id is null");
            return (Criteria)this;
        }

        public Criteria andGoodsIdIsNotNull() {
            this.addCriterion("goods_id is not null");
            return (Criteria)this;
        }

        public Criteria andGoodsIdEqualTo(Long value) {
            this.addCriterion("goods_id =", value, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            this.addCriterion("goods_id <>", value, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            this.addCriterion("goods_id >", value, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("goods_id >=", value, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdLessThan(Long value) {
            this.addCriterion("goods_id <", value, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            this.addCriterion("goods_id <=", value, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdLike(String value) {
            this.addCriterion("goods_id like", value, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdNotLike(String value) {
            this.addCriterion("goods_id not like", value, "goodsId");
            return (Criteria)this;
        }        public Criteria andGoodsIdIn(List<Long> values) {
            this.addCriterion("goods_id in", values, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            this.addCriterion("goods_id not in", values, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            this.addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria)this;
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            this.addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria)this;
        }

        public Criteria andNumIidIsNull() {
            this.addCriterion("num_iid is null");
            return (Criteria)this;
        }

        public Criteria andNumIidIsNotNull() {
            this.addCriterion("num_iid is not null");
            return (Criteria)this;
        }

        public Criteria andNumIidEqualTo(Long value) {
            this.addCriterion("num_iid =", value, "numIid");
            return (Criteria)this;
        }

        public Criteria andNumIidNotEqualTo(Long value) {
            this.addCriterion("num_iid <>", value, "numIid");
            return (Criteria)this;
        }

        public Criteria andNumIidGreaterThan(Long value) {
            this.addCriterion("num_iid >", value, "numIid");
            return (Criteria)this;
        }

        public Criteria andNumIidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("num_iid >=", value, "numIid");
            return (Criteria)this;
        }

        public Criteria andNumIidLessThan(Long value) {
            this.addCriterion("num_iid <", value, "numIid");
            return (Criteria)this;
        }

        public Criteria andNumIidLessThanOrEqualTo(Long value) {
            this.addCriterion("num_iid <=", value, "numIid");
            return (Criteria)this;
        }

        public Criteria andNumIidLike(String value) {
            this.addCriterion("num_iid like", value, "numIid");
            return (Criteria)this;
        }

        public Criteria andNumIidNotLike(String value) {
            this.addCriterion("num_iid not like", value, "numIid");
            return (Criteria)this;
        }        public Criteria andNumIidIn(List<Long> values) {
            this.addCriterion("num_iid in", values, "numIid");
            return (Criteria)this;
        }

        public Criteria andNumIidNotIn(List<Long> values) {
            this.addCriterion("num_iid not in", values, "numIid");
            return (Criteria)this;
        }

        public Criteria andNumIidBetween(Long value1, Long value2) {
            this.addCriterion("num_iid between", value1, value2, "numIid");
            return (Criteria)this;
        }

        public Criteria andNumIidNotBetween(Long value1, Long value2) {
            this.addCriterion("num_iid not between", value1, value2, "numIid");
            return (Criteria)this;
        }

        public Criteria andDetailUrlIsNull() {
            this.addCriterion("detail_url is null");
            return (Criteria)this;
        }

        public Criteria andDetailUrlIsNotNull() {
            this.addCriterion("detail_url is not null");
            return (Criteria)this;
        }

        public Criteria andDetailUrlEqualTo(String value) {
            this.addCriterion("detail_url =", value, "detailUrl");
            return (Criteria)this;
        }

        public Criteria andDetailUrlNotEqualTo(String value) {
            this.addCriterion("detail_url <>", value, "detailUrl");
            return (Criteria)this;
        }

        public Criteria andDetailUrlGreaterThan(String value) {
            this.addCriterion("detail_url >", value, "detailUrl");
            return (Criteria)this;
        }

        public Criteria andDetailUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("detail_url >=", value, "detailUrl");
            return (Criteria)this;
        }

        public Criteria andDetailUrlLessThan(String value) {
            this.addCriterion("detail_url <", value, "detailUrl");
            return (Criteria)this;
        }

        public Criteria andDetailUrlLessThanOrEqualTo(String value) {
            this.addCriterion("detail_url <=", value, "detailUrl");
            return (Criteria)this;
        }

        public Criteria andDetailUrlLike(String value) {
            this.addCriterion("detail_url like", value, "detailUrl");
            return (Criteria)this;
        }

        public Criteria andDetailUrlNotLike(String value) {
            this.addCriterion("detail_url not like", value, "detailUrl");
            return (Criteria)this;
        }        public Criteria andDetailUrlIn(List<String> values) {
            this.addCriterion("detail_url in", values, "detailUrl");
            return (Criteria)this;
        }

        public Criteria andDetailUrlNotIn(List<String> values) {
            this.addCriterion("detail_url not in", values, "detailUrl");
            return (Criteria)this;
        }

        public Criteria andDetailUrlBetween(String value1, String value2) {
            this.addCriterion("detail_url between", value1, value2, "detailUrl");
            return (Criteria)this;
        }

        public Criteria andDetailUrlNotBetween(String value1, String value2) {
            this.addCriterion("detail_url not between", value1, value2, "detailUrl");
            return (Criteria)this;
        }

        public Criteria andTitleIsNull() {
            this.addCriterion("title is null");
            return (Criteria)this;
        }

        public Criteria andTitleIsNotNull() {
            this.addCriterion("title is not null");
            return (Criteria)this;
        }

        public Criteria andTitleEqualTo(String value) {
            this.addCriterion("title =", value, "title");
            return (Criteria)this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            this.addCriterion("title <>", value, "title");
            return (Criteria)this;
        }

        public Criteria andTitleGreaterThan(String value) {
            this.addCriterion("title >", value, "title");
            return (Criteria)this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            this.addCriterion("title >=", value, "title");
            return (Criteria)this;
        }

        public Criteria andTitleLessThan(String value) {
            this.addCriterion("title <", value, "title");
            return (Criteria)this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            this.addCriterion("title <=", value, "title");
            return (Criteria)this;
        }

        public Criteria andTitleLike(String value) {
            this.addCriterion("title like", value, "title");
            return (Criteria)this;
        }

        public Criteria andTitleNotLike(String value) {
            this.addCriterion("title not like", value, "title");
            return (Criteria)this;
        }        public Criteria andTitleIn(List<String> values) {
            this.addCriterion("title in", values, "title");
            return (Criteria)this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            this.addCriterion("title not in", values, "title");
            return (Criteria)this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            this.addCriterion("title between", value1, value2, "title");
            return (Criteria)this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            this.addCriterion("title not between", value1, value2, "title");
            return (Criteria)this;
        }

        public Criteria andNickIsNull() {
            this.addCriterion("nick is null");
            return (Criteria)this;
        }

        public Criteria andNickIsNotNull() {
            this.addCriterion("nick is not null");
            return (Criteria)this;
        }

        public Criteria andNickEqualTo(String value) {
            this.addCriterion("nick =", value, "nick");
            return (Criteria)this;
        }

        public Criteria andNickNotEqualTo(String value) {
            this.addCriterion("nick <>", value, "nick");
            return (Criteria)this;
        }

        public Criteria andNickGreaterThan(String value) {
            this.addCriterion("nick >", value, "nick");
            return (Criteria)this;
        }

        public Criteria andNickGreaterThanOrEqualTo(String value) {
            this.addCriterion("nick >=", value, "nick");
            return (Criteria)this;
        }

        public Criteria andNickLessThan(String value) {
            this.addCriterion("nick <", value, "nick");
            return (Criteria)this;
        }

        public Criteria andNickLessThanOrEqualTo(String value) {
            this.addCriterion("nick <=", value, "nick");
            return (Criteria)this;
        }

        public Criteria andNickLike(String value) {
            this.addCriterion("nick like", value, "nick");
            return (Criteria)this;
        }

        public Criteria andNickNotLike(String value) {
            this.addCriterion("nick not like", value, "nick");
            return (Criteria)this;
        }        public Criteria andNickIn(List<String> values) {
            this.addCriterion("nick in", values, "nick");
            return (Criteria)this;
        }

        public Criteria andNickNotIn(List<String> values) {
            this.addCriterion("nick not in", values, "nick");
            return (Criteria)this;
        }

        public Criteria andNickBetween(String value1, String value2) {
            this.addCriterion("nick between", value1, value2, "nick");
            return (Criteria)this;
        }

        public Criteria andNickNotBetween(String value1, String value2) {
            this.addCriterion("nick not between", value1, value2, "nick");
            return (Criteria)this;
        }

        public Criteria andTypeIsNull() {
            this.addCriterion("type is null");
            return (Criteria)this;
        }

        public Criteria andTypeIsNotNull() {
            this.addCriterion("type is not null");
            return (Criteria)this;
        }

        public Criteria andTypeEqualTo(String value) {
            this.addCriterion("type =", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            this.addCriterion("type <>", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeGreaterThan(String value) {
            this.addCriterion("type >", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            this.addCriterion("type >=", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeLessThan(String value) {
            this.addCriterion("type <", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            this.addCriterion("type <=", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeLike(String value) {
            this.addCriterion("type like", value, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotLike(String value) {
            this.addCriterion("type not like", value, "type");
            return (Criteria)this;
        }        public Criteria andTypeIn(List<String> values) {
            this.addCriterion("type in", values, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            this.addCriterion("type not in", values, "type");
            return (Criteria)this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            this.addCriterion("type between", value1, value2, "type");
            return (Criteria)this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            this.addCriterion("type not between", value1, value2, "type");
            return (Criteria)this;
        }

        public Criteria andCreatedIsNull() {
            this.addCriterion("created is null");
            return (Criteria)this;
        }

        public Criteria andCreatedIsNotNull() {
            this.addCriterion("created is not null");
            return (Criteria)this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            this.addCriterion("created =", value, "created");
            return (Criteria)this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            this.addCriterion("created <>", value, "created");
            return (Criteria)this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            this.addCriterion("created >", value, "created");
            return (Criteria)this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            this.addCriterion("created >=", value, "created");
            return (Criteria)this;
        }

        public Criteria andCreatedLessThan(Date value) {
            this.addCriterion("created <", value, "created");
            return (Criteria)this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            this.addCriterion("created <=", value, "created");
            return (Criteria)this;
        }

        public Criteria andCreatedLike(String value) {
            this.addCriterion("created like", value, "created");
            return (Criteria)this;
        }

        public Criteria andCreatedNotLike(String value) {
            this.addCriterion("created not like", value, "created");
            return (Criteria)this;
        }        public Criteria andCreatedIn(List<Date> values) {
            this.addCriterion("created in", values, "created");
            return (Criteria)this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            this.addCriterion("created not in", values, "created");
            return (Criteria)this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            this.addCriterion("created between", value1, value2, "created");
            return (Criteria)this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            this.addCriterion("created not between", value1, value2, "created");
            return (Criteria)this;
        }

        public Criteria andIsLightningConsignmentIsNull() {
            this.addCriterion("is_lightning_consignment is null");
            return (Criteria)this;
        }

        public Criteria andIsLightningConsignmentIsNotNull() {
            this.addCriterion("is_lightning_consignment is not null");
            return (Criteria)this;
        }

        public Criteria andIsLightningConsignmentEqualTo(String value) {
            this.addCriterion("is_lightning_consignment =", value, "isLightningConsignment");
            return (Criteria)this;
        }

        public Criteria andIsLightningConsignmentNotEqualTo(String value) {
            this.addCriterion("is_lightning_consignment <>", value, "isLightningConsignment");
            return (Criteria)this;
        }

        public Criteria andIsLightningConsignmentGreaterThan(String value) {
            this.addCriterion("is_lightning_consignment >", value, "isLightningConsignment");
            return (Criteria)this;
        }

        public Criteria andIsLightningConsignmentGreaterThanOrEqualTo(String value) {
            this.addCriterion("is_lightning_consignment >=", value, "isLightningConsignment");
            return (Criteria)this;
        }

        public Criteria andIsLightningConsignmentLessThan(String value) {
            this.addCriterion("is_lightning_consignment <", value, "isLightningConsignment");
            return (Criteria)this;
        }

        public Criteria andIsLightningConsignmentLessThanOrEqualTo(String value) {
            this.addCriterion("is_lightning_consignment <=", value, "isLightningConsignment");
            return (Criteria)this;
        }

        public Criteria andIsLightningConsignmentLike(String value) {
            this.addCriterion("is_lightning_consignment like", value, "isLightningConsignment");
            return (Criteria)this;
        }

        public Criteria andIsLightningConsignmentNotLike(String value) {
            this.addCriterion("is_lightning_consignment not like", value, "isLightningConsignment");
            return (Criteria)this;
        }        public Criteria andIsLightningConsignmentIn(List<String> values) {
            this.addCriterion("is_lightning_consignment in", values, "isLightningConsignment");
            return (Criteria)this;
        }

        public Criteria andIsLightningConsignmentNotIn(List<String> values) {
            this.addCriterion("is_lightning_consignment not in", values, "isLightningConsignment");
            return (Criteria)this;
        }

        public Criteria andIsLightningConsignmentBetween(String value1, String value2) {
            this.addCriterion("is_lightning_consignment between", value1, value2, "isLightningConsignment");
            return (Criteria)this;
        }

        public Criteria andIsLightningConsignmentNotBetween(String value1, String value2) {
            this.addCriterion("is_lightning_consignment not between", value1, value2, "isLightningConsignment");
            return (Criteria)this;
        }

        public Criteria andIsFenxiaoIsNull() {
            this.addCriterion("is_fenxiao is null");
            return (Criteria)this;
        }

        public Criteria andIsFenxiaoIsNotNull() {
            this.addCriterion("is_fenxiao is not null");
            return (Criteria)this;
        }

        public Criteria andIsFenxiaoEqualTo(Long value) {
            this.addCriterion("is_fenxiao =", value, "isFenxiao");
            return (Criteria)this;
        }

        public Criteria andIsFenxiaoNotEqualTo(Long value) {
            this.addCriterion("is_fenxiao <>", value, "isFenxiao");
            return (Criteria)this;
        }

        public Criteria andIsFenxiaoGreaterThan(Long value) {
            this.addCriterion("is_fenxiao >", value, "isFenxiao");
            return (Criteria)this;
        }

        public Criteria andIsFenxiaoGreaterThanOrEqualTo(Long value) {
            this.addCriterion("is_fenxiao >=", value, "isFenxiao");
            return (Criteria)this;
        }

        public Criteria andIsFenxiaoLessThan(Long value) {
            this.addCriterion("is_fenxiao <", value, "isFenxiao");
            return (Criteria)this;
        }

        public Criteria andIsFenxiaoLessThanOrEqualTo(Long value) {
            this.addCriterion("is_fenxiao <=", value, "isFenxiao");
            return (Criteria)this;
        }

        public Criteria andIsFenxiaoLike(String value) {
            this.addCriterion("is_fenxiao like", value, "isFenxiao");
            return (Criteria)this;
        }

        public Criteria andIsFenxiaoNotLike(String value) {
            this.addCriterion("is_fenxiao not like", value, "isFenxiao");
            return (Criteria)this;
        }        public Criteria andIsFenxiaoIn(List<Long> values) {
            this.addCriterion("is_fenxiao in", values, "isFenxiao");
            return (Criteria)this;
        }

        public Criteria andIsFenxiaoNotIn(List<Long> values) {
            this.addCriterion("is_fenxiao not in", values, "isFenxiao");
            return (Criteria)this;
        }

        public Criteria andIsFenxiaoBetween(Long value1, Long value2) {
            this.addCriterion("is_fenxiao between", value1, value2, "isFenxiao");
            return (Criteria)this;
        }

        public Criteria andIsFenxiaoNotBetween(Long value1, Long value2) {
            this.addCriterion("is_fenxiao not between", value1, value2, "isFenxiao");
            return (Criteria)this;
        }

        public Criteria andIsSaleIsNull() {
            this.addCriterion("is_sale is null");
            return (Criteria)this;
        }

        public Criteria andIsSaleIsNotNull() {
            this.addCriterion("is_sale is not null");
            return (Criteria)this;
        }

        public Criteria andIsSaleEqualTo(Long value) {
            this.addCriterion("is_sale =", value, "isSale");
            return (Criteria)this;
        }

        public Criteria andIsSaleNotEqualTo(Long value) {
            this.addCriterion("is_sale <>", value, "isSale");
            return (Criteria)this;
        }

        public Criteria andIsSaleGreaterThan(Long value) {
            this.addCriterion("is_sale >", value, "isSale");
            return (Criteria)this;
        }

        public Criteria andIsSaleGreaterThanOrEqualTo(Long value) {
            this.addCriterion("is_sale >=", value, "isSale");
            return (Criteria)this;
        }

        public Criteria andIsSaleLessThan(Long value) {
            this.addCriterion("is_sale <", value, "isSale");
            return (Criteria)this;
        }

        public Criteria andIsSaleLessThanOrEqualTo(Long value) {
            this.addCriterion("is_sale <=", value, "isSale");
            return (Criteria)this;
        }

        public Criteria andIsSaleLike(String value) {
            this.addCriterion("is_sale like", value, "isSale");
            return (Criteria)this;
        }

        public Criteria andIsSaleNotLike(String value) {
            this.addCriterion("is_sale not like", value, "isSale");
            return (Criteria)this;
        }        public Criteria andIsSaleIn(List<Long> values) {
            this.addCriterion("is_sale in", values, "isSale");
            return (Criteria)this;
        }

        public Criteria andIsSaleNotIn(List<Long> values) {
            this.addCriterion("is_sale not in", values, "isSale");
            return (Criteria)this;
        }

        public Criteria andIsSaleBetween(Long value1, Long value2) {
            this.addCriterion("is_sale between", value1, value2, "isSale");
            return (Criteria)this;
        }

        public Criteria andIsSaleNotBetween(Long value1, Long value2) {
            this.addCriterion("is_sale not between", value1, value2, "isSale");
            return (Criteria)this;
        }

        public Criteria andIsXinpinIsNull() {
            this.addCriterion("is_xinpin is null");
            return (Criteria)this;
        }

        public Criteria andIsXinpinIsNotNull() {
            this.addCriterion("is_xinpin is not null");
            return (Criteria)this;
        }

        public Criteria andIsXinpinEqualTo(String value) {
            this.addCriterion("is_xinpin =", value, "isXinpin");
            return (Criteria)this;
        }

        public Criteria andIsXinpinNotEqualTo(String value) {
            this.addCriterion("is_xinpin <>", value, "isXinpin");
            return (Criteria)this;
        }

        public Criteria andIsXinpinGreaterThan(String value) {
            this.addCriterion("is_xinpin >", value, "isXinpin");
            return (Criteria)this;
        }

        public Criteria andIsXinpinGreaterThanOrEqualTo(String value) {
            this.addCriterion("is_xinpin >=", value, "isXinpin");
            return (Criteria)this;
        }

        public Criteria andIsXinpinLessThan(String value) {
            this.addCriterion("is_xinpin <", value, "isXinpin");
            return (Criteria)this;
        }

        public Criteria andIsXinpinLessThanOrEqualTo(String value) {
            this.addCriterion("is_xinpin <=", value, "isXinpin");
            return (Criteria)this;
        }

        public Criteria andIsXinpinLike(String value) {
            this.addCriterion("is_xinpin like", value, "isXinpin");
            return (Criteria)this;
        }

        public Criteria andIsXinpinNotLike(String value) {
            this.addCriterion("is_xinpin not like", value, "isXinpin");
            return (Criteria)this;
        }        public Criteria andIsXinpinIn(List<String> values) {
            this.addCriterion("is_xinpin in", values, "isXinpin");
            return (Criteria)this;
        }

        public Criteria andIsXinpinNotIn(List<String> values) {
            this.addCriterion("is_xinpin not in", values, "isXinpin");
            return (Criteria)this;
        }

        public Criteria andIsXinpinBetween(String value1, String value2) {
            this.addCriterion("is_xinpin between", value1, value2, "isXinpin");
            return (Criteria)this;
        }

        public Criteria andIsXinpinNotBetween(String value1, String value2) {
            this.addCriterion("is_xinpin not between", value1, value2, "isXinpin");
            return (Criteria)this;
        }

        public Criteria andValidThruIsNull() {
            this.addCriterion("valid_thru is null");
            return (Criteria)this;
        }

        public Criteria andValidThruIsNotNull() {
            this.addCriterion("valid_thru is not null");
            return (Criteria)this;
        }

        public Criteria andValidThruEqualTo(Long value) {
            this.addCriterion("valid_thru =", value, "validThru");
            return (Criteria)this;
        }

        public Criteria andValidThruNotEqualTo(Long value) {
            this.addCriterion("valid_thru <>", value, "validThru");
            return (Criteria)this;
        }

        public Criteria andValidThruGreaterThan(Long value) {
            this.addCriterion("valid_thru >", value, "validThru");
            return (Criteria)this;
        }

        public Criteria andValidThruGreaterThanOrEqualTo(Long value) {
            this.addCriterion("valid_thru >=", value, "validThru");
            return (Criteria)this;
        }

        public Criteria andValidThruLessThan(Long value) {
            this.addCriterion("valid_thru <", value, "validThru");
            return (Criteria)this;
        }

        public Criteria andValidThruLessThanOrEqualTo(Long value) {
            this.addCriterion("valid_thru <=", value, "validThru");
            return (Criteria)this;
        }

        public Criteria andValidThruLike(String value) {
            this.addCriterion("valid_thru like", value, "validThru");
            return (Criteria)this;
        }

        public Criteria andValidThruNotLike(String value) {
            this.addCriterion("valid_thru not like", value, "validThru");
            return (Criteria)this;
        }        public Criteria andValidThruIn(List<Long> values) {
            this.addCriterion("valid_thru in", values, "validThru");
            return (Criteria)this;
        }

        public Criteria andValidThruNotIn(List<Long> values) {
            this.addCriterion("valid_thru not in", values, "validThru");
            return (Criteria)this;
        }

        public Criteria andValidThruBetween(Long value1, Long value2) {
            this.addCriterion("valid_thru between", value1, value2, "validThru");
            return (Criteria)this;
        }

        public Criteria andValidThruNotBetween(Long value1, Long value2) {
            this.addCriterion("valid_thru not between", value1, value2, "validThru");
            return (Criteria)this;
        }

        public Criteria andOuterIdIsNull() {
            this.addCriterion("outer_id is null");
            return (Criteria)this;
        }

        public Criteria andOuterIdIsNotNull() {
            this.addCriterion("outer_id is not null");
            return (Criteria)this;
        }

        public Criteria andOuterIdEqualTo(String value) {
            this.addCriterion("outer_id =", value, "outerId");
            return (Criteria)this;
        }

        public Criteria andOuterIdNotEqualTo(String value) {
            this.addCriterion("outer_id <>", value, "outerId");
            return (Criteria)this;
        }

        public Criteria andOuterIdGreaterThan(String value) {
            this.addCriterion("outer_id >", value, "outerId");
            return (Criteria)this;
        }

        public Criteria andOuterIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("outer_id >=", value, "outerId");
            return (Criteria)this;
        }

        public Criteria andOuterIdLessThan(String value) {
            this.addCriterion("outer_id <", value, "outerId");
            return (Criteria)this;
        }

        public Criteria andOuterIdLessThanOrEqualTo(String value) {
            this.addCriterion("outer_id <=", value, "outerId");
            return (Criteria)this;
        }

        public Criteria andOuterIdLike(String value) {
            this.addCriterion("outer_id like", value, "outerId");
            return (Criteria)this;
        }

        public Criteria andOuterIdNotLike(String value) {
            this.addCriterion("outer_id not like", value, "outerId");
            return (Criteria)this;
        }        public Criteria andOuterIdIn(List<String> values) {
            this.addCriterion("outer_id in", values, "outerId");
            return (Criteria)this;
        }

        public Criteria andOuterIdNotIn(List<String> values) {
            this.addCriterion("outer_id not in", values, "outerId");
            return (Criteria)this;
        }

        public Criteria andOuterIdBetween(String value1, String value2) {
            this.addCriterion("outer_id between", value1, value2, "outerId");
            return (Criteria)this;
        }

        public Criteria andOuterIdNotBetween(String value1, String value2) {
            this.addCriterion("outer_id not between", value1, value2, "outerId");
            return (Criteria)this;
        }

        public Criteria andCidIsNull() {
            this.addCriterion("cid is null");
            return (Criteria)this;
        }

        public Criteria andCidIsNotNull() {
            this.addCriterion("cid is not null");
            return (Criteria)this;
        }

        public Criteria andCidEqualTo(Long value) {
            this.addCriterion("cid =", value, "cid");
            return (Criteria)this;
        }

        public Criteria andCidNotEqualTo(Long value) {
            this.addCriterion("cid <>", value, "cid");
            return (Criteria)this;
        }

        public Criteria andCidGreaterThan(Long value) {
            this.addCriterion("cid >", value, "cid");
            return (Criteria)this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("cid >=", value, "cid");
            return (Criteria)this;
        }

        public Criteria andCidLessThan(Long value) {
            this.addCriterion("cid <", value, "cid");
            return (Criteria)this;
        }

        public Criteria andCidLessThanOrEqualTo(Long value) {
            this.addCriterion("cid <=", value, "cid");
            return (Criteria)this;
        }

        public Criteria andCidLike(String value) {
            this.addCriterion("cid like", value, "cid");
            return (Criteria)this;
        }

        public Criteria andCidNotLike(String value) {
            this.addCriterion("cid not like", value, "cid");
            return (Criteria)this;
        }        public Criteria andCidIn(List<Long> values) {
            this.addCriterion("cid in", values, "cid");
            return (Criteria)this;
        }

        public Criteria andCidNotIn(List<Long> values) {
            this.addCriterion("cid not in", values, "cid");
            return (Criteria)this;
        }

        public Criteria andCidBetween(Long value1, Long value2) {
            this.addCriterion("cid between", value1, value2, "cid");
            return (Criteria)this;
        }

        public Criteria andCidNotBetween(Long value1, Long value2) {
            this.addCriterion("cid not between", value1, value2, "cid");
            return (Criteria)this;
        }

        public Criteria andCidAllIsNull() {
            this.addCriterion("cid_all is null");
            return (Criteria)this;
        }

        public Criteria andCidAllIsNotNull() {
            this.addCriterion("cid_all is not null");
            return (Criteria)this;
        }

        public Criteria andCidAllEqualTo(String value) {
            this.addCriterion("cid_all =", value, "cidAll");
            return (Criteria)this;
        }

        public Criteria andCidAllNotEqualTo(String value) {
            this.addCriterion("cid_all <>", value, "cidAll");
            return (Criteria)this;
        }

        public Criteria andCidAllGreaterThan(String value) {
            this.addCriterion("cid_all >", value, "cidAll");
            return (Criteria)this;
        }

        public Criteria andCidAllGreaterThanOrEqualTo(String value) {
            this.addCriterion("cid_all >=", value, "cidAll");
            return (Criteria)this;
        }

        public Criteria andCidAllLessThan(String value) {
            this.addCriterion("cid_all <", value, "cidAll");
            return (Criteria)this;
        }

        public Criteria andCidAllLessThanOrEqualTo(String value) {
            this.addCriterion("cid_all <=", value, "cidAll");
            return (Criteria)this;
        }

        public Criteria andCidAllLike(String value) {
            this.addCriterion("cid_all like", value, "cidAll");
            return (Criteria)this;
        }

        public Criteria andCidAllNotLike(String value) {
            this.addCriterion("cid_all not like", value, "cidAll");
            return (Criteria)this;
        }        public Criteria andCidAllIn(List<String> values) {
            this.addCriterion("cid_all in", values, "cidAll");
            return (Criteria)this;
        }

        public Criteria andCidAllNotIn(List<String> values) {
            this.addCriterion("cid_all not in", values, "cidAll");
            return (Criteria)this;
        }

        public Criteria andCidAllBetween(String value1, String value2) {
            this.addCriterion("cid_all between", value1, value2, "cidAll");
            return (Criteria)this;
        }

        public Criteria andCidAllNotBetween(String value1, String value2) {
            this.addCriterion("cid_all not between", value1, value2, "cidAll");
            return (Criteria)this;
        }

        public Criteria andPicUrlIsNull() {
            this.addCriterion("pic_url is null");
            return (Criteria)this;
        }

        public Criteria andPicUrlIsNotNull() {
            this.addCriterion("pic_url is not null");
            return (Criteria)this;
        }

        public Criteria andPicUrlEqualTo(String value) {
            this.addCriterion("pic_url =", value, "picUrl");
            return (Criteria)this;
        }

        public Criteria andPicUrlNotEqualTo(String value) {
            this.addCriterion("pic_url <>", value, "picUrl");
            return (Criteria)this;
        }

        public Criteria andPicUrlGreaterThan(String value) {
            this.addCriterion("pic_url >", value, "picUrl");
            return (Criteria)this;
        }

        public Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("pic_url >=", value, "picUrl");
            return (Criteria)this;
        }

        public Criteria andPicUrlLessThan(String value) {
            this.addCriterion("pic_url <", value, "picUrl");
            return (Criteria)this;
        }

        public Criteria andPicUrlLessThanOrEqualTo(String value) {
            this.addCriterion("pic_url <=", value, "picUrl");
            return (Criteria)this;
        }

        public Criteria andPicUrlLike(String value) {
            this.addCriterion("pic_url like", value, "picUrl");
            return (Criteria)this;
        }

        public Criteria andPicUrlNotLike(String value) {
            this.addCriterion("pic_url not like", value, "picUrl");
            return (Criteria)this;
        }        public Criteria andPicUrlIn(List<String> values) {
            this.addCriterion("pic_url in", values, "picUrl");
            return (Criteria)this;
        }

        public Criteria andPicUrlNotIn(List<String> values) {
            this.addCriterion("pic_url not in", values, "picUrl");
            return (Criteria)this;
        }

        public Criteria andPicUrlBetween(String value1, String value2) {
            this.addCriterion("pic_url between", value1, value2, "picUrl");
            return (Criteria)this;
        }

        public Criteria andPicUrlNotBetween(String value1, String value2) {
            this.addCriterion("pic_url not between", value1, value2, "picUrl");
            return (Criteria)this;
        }

        public Criteria andNumIsNull() {
            this.addCriterion("num is null");
            return (Criteria)this;
        }

        public Criteria andNumIsNotNull() {
            this.addCriterion("num is not null");
            return (Criteria)this;
        }

        public Criteria andNumEqualTo(Long value) {
            this.addCriterion("num =", value, "num");
            return (Criteria)this;
        }

        public Criteria andNumNotEqualTo(Long value) {
            this.addCriterion("num <>", value, "num");
            return (Criteria)this;
        }

        public Criteria andNumGreaterThan(Long value) {
            this.addCriterion("num >", value, "num");
            return (Criteria)this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Long value) {
            this.addCriterion("num >=", value, "num");
            return (Criteria)this;
        }

        public Criteria andNumLessThan(Long value) {
            this.addCriterion("num <", value, "num");
            return (Criteria)this;
        }

        public Criteria andNumLessThanOrEqualTo(Long value) {
            this.addCriterion("num <=", value, "num");
            return (Criteria)this;
        }

        public Criteria andNumLike(String value) {
            this.addCriterion("num like", value, "num");
            return (Criteria)this;
        }

        public Criteria andNumNotLike(String value) {
            this.addCriterion("num not like", value, "num");
            return (Criteria)this;
        }        public Criteria andNumIn(List<Long> values) {
            this.addCriterion("num in", values, "num");
            return (Criteria)this;
        }

        public Criteria andNumNotIn(List<Long> values) {
            this.addCriterion("num not in", values, "num");
            return (Criteria)this;
        }

        public Criteria andNumBetween(Long value1, Long value2) {
            this.addCriterion("num between", value1, value2, "num");
            return (Criteria)this;
        }

        public Criteria andNumNotBetween(Long value1, Long value2) {
            this.addCriterion("num not between", value1, value2, "num");
            return (Criteria)this;
        }

        public Criteria andSoldOutTimeIsNull() {
            this.addCriterion("sold_out_time is null");
            return (Criteria)this;
        }

        public Criteria andSoldOutTimeIsNotNull() {
            this.addCriterion("sold_out_time is not null");
            return (Criteria)this;
        }

        public Criteria andSoldOutTimeEqualTo(Date value) {
            this.addCriterion("sold_out_time =", value, "soldOutTime");
            return (Criteria)this;
        }

        public Criteria andSoldOutTimeNotEqualTo(Date value) {
            this.addCriterion("sold_out_time <>", value, "soldOutTime");
            return (Criteria)this;
        }

        public Criteria andSoldOutTimeGreaterThan(Date value) {
            this.addCriterion("sold_out_time >", value, "soldOutTime");
            return (Criteria)this;
        }

        public Criteria andSoldOutTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("sold_out_time >=", value, "soldOutTime");
            return (Criteria)this;
        }

        public Criteria andSoldOutTimeLessThan(Date value) {
            this.addCriterion("sold_out_time <", value, "soldOutTime");
            return (Criteria)this;
        }

        public Criteria andSoldOutTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("sold_out_time <=", value, "soldOutTime");
            return (Criteria)this;
        }

        public Criteria andSoldOutTimeLike(String value) {
            this.addCriterion("sold_out_time like", value, "soldOutTime");
            return (Criteria)this;
        }

        public Criteria andSoldOutTimeNotLike(String value) {
            this.addCriterion("sold_out_time not like", value, "soldOutTime");
            return (Criteria)this;
        }        public Criteria andSoldOutTimeIn(List<Date> values) {
            this.addCriterion("sold_out_time in", values, "soldOutTime");
            return (Criteria)this;
        }

        public Criteria andSoldOutTimeNotIn(List<Date> values) {
            this.addCriterion("sold_out_time not in", values, "soldOutTime");
            return (Criteria)this;
        }

        public Criteria andSoldOutTimeBetween(Date value1, Date value2) {
            this.addCriterion("sold_out_time between", value1, value2, "soldOutTime");
            return (Criteria)this;
        }

        public Criteria andSoldOutTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("sold_out_time not between", value1, value2, "soldOutTime");
            return (Criteria)this;
        }

        public Criteria andListTimeIsNull() {
            this.addCriterion("list_time is null");
            return (Criteria)this;
        }

        public Criteria andListTimeIsNotNull() {
            this.addCriterion("list_time is not null");
            return (Criteria)this;
        }

        public Criteria andListTimeEqualTo(Date value) {
            this.addCriterion("list_time =", value, "listTime");
            return (Criteria)this;
        }

        public Criteria andListTimeNotEqualTo(Date value) {
            this.addCriterion("list_time <>", value, "listTime");
            return (Criteria)this;
        }

        public Criteria andListTimeGreaterThan(Date value) {
            this.addCriterion("list_time >", value, "listTime");
            return (Criteria)this;
        }

        public Criteria andListTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("list_time >=", value, "listTime");
            return (Criteria)this;
        }

        public Criteria andListTimeLessThan(Date value) {
            this.addCriterion("list_time <", value, "listTime");
            return (Criteria)this;
        }

        public Criteria andListTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("list_time <=", value, "listTime");
            return (Criteria)this;
        }

        public Criteria andListTimeLike(String value) {
            this.addCriterion("list_time like", value, "listTime");
            return (Criteria)this;
        }

        public Criteria andListTimeNotLike(String value) {
            this.addCriterion("list_time not like", value, "listTime");
            return (Criteria)this;
        }        public Criteria andListTimeIn(List<Date> values) {
            this.addCriterion("list_time in", values, "listTime");
            return (Criteria)this;
        }

        public Criteria andListTimeNotIn(List<Date> values) {
            this.addCriterion("list_time not in", values, "listTime");
            return (Criteria)this;
        }

        public Criteria andListTimeBetween(Date value1, Date value2) {
            this.addCriterion("list_time between", value1, value2, "listTime");
            return (Criteria)this;
        }

        public Criteria andListTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("list_time not between", value1, value2, "listTime");
            return (Criteria)this;
        }

        public Criteria andDelistTimeIsNull() {
            this.addCriterion("delist_time is null");
            return (Criteria)this;
        }

        public Criteria andDelistTimeIsNotNull() {
            this.addCriterion("delist_time is not null");
            return (Criteria)this;
        }

        public Criteria andDelistTimeEqualTo(Date value) {
            this.addCriterion("delist_time =", value, "delistTime");
            return (Criteria)this;
        }

        public Criteria andDelistTimeNotEqualTo(Date value) {
            this.addCriterion("delist_time <>", value, "delistTime");
            return (Criteria)this;
        }

        public Criteria andDelistTimeGreaterThan(Date value) {
            this.addCriterion("delist_time >", value, "delistTime");
            return (Criteria)this;
        }

        public Criteria andDelistTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("delist_time >=", value, "delistTime");
            return (Criteria)this;
        }

        public Criteria andDelistTimeLessThan(Date value) {
            this.addCriterion("delist_time <", value, "delistTime");
            return (Criteria)this;
        }

        public Criteria andDelistTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("delist_time <=", value, "delistTime");
            return (Criteria)this;
        }

        public Criteria andDelistTimeLike(String value) {
            this.addCriterion("delist_time like", value, "delistTime");
            return (Criteria)this;
        }

        public Criteria andDelistTimeNotLike(String value) {
            this.addCriterion("delist_time not like", value, "delistTime");
            return (Criteria)this;
        }        public Criteria andDelistTimeIn(List<Date> values) {
            this.addCriterion("delist_time in", values, "delistTime");
            return (Criteria)this;
        }

        public Criteria andDelistTimeNotIn(List<Date> values) {
            this.addCriterion("delist_time not in", values, "delistTime");
            return (Criteria)this;
        }

        public Criteria andDelistTimeBetween(Date value1, Date value2) {
            this.addCriterion("delist_time between", value1, value2, "delistTime");
            return (Criteria)this;
        }

        public Criteria andDelistTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("delist_time not between", value1, value2, "delistTime");
            return (Criteria)this;
        }

        public Criteria andStuffStatusIsNull() {
            this.addCriterion("stuff_status is null");
            return (Criteria)this;
        }

        public Criteria andStuffStatusIsNotNull() {
            this.addCriterion("stuff_status is not null");
            return (Criteria)this;
        }

        public Criteria andStuffStatusEqualTo(String value) {
            this.addCriterion("stuff_status =", value, "stuffStatus");
            return (Criteria)this;
        }

        public Criteria andStuffStatusNotEqualTo(String value) {
            this.addCriterion("stuff_status <>", value, "stuffStatus");
            return (Criteria)this;
        }

        public Criteria andStuffStatusGreaterThan(String value) {
            this.addCriterion("stuff_status >", value, "stuffStatus");
            return (Criteria)this;
        }

        public Criteria andStuffStatusGreaterThanOrEqualTo(String value) {
            this.addCriterion("stuff_status >=", value, "stuffStatus");
            return (Criteria)this;
        }

        public Criteria andStuffStatusLessThan(String value) {
            this.addCriterion("stuff_status <", value, "stuffStatus");
            return (Criteria)this;
        }

        public Criteria andStuffStatusLessThanOrEqualTo(String value) {
            this.addCriterion("stuff_status <=", value, "stuffStatus");
            return (Criteria)this;
        }

        public Criteria andStuffStatusLike(String value) {
            this.addCriterion("stuff_status like", value, "stuffStatus");
            return (Criteria)this;
        }

        public Criteria andStuffStatusNotLike(String value) {
            this.addCriterion("stuff_status not like", value, "stuffStatus");
            return (Criteria)this;
        }        public Criteria andStuffStatusIn(List<String> values) {
            this.addCriterion("stuff_status in", values, "stuffStatus");
            return (Criteria)this;
        }

        public Criteria andStuffStatusNotIn(List<String> values) {
            this.addCriterion("stuff_status not in", values, "stuffStatus");
            return (Criteria)this;
        }

        public Criteria andStuffStatusBetween(String value1, String value2) {
            this.addCriterion("stuff_status between", value1, value2, "stuffStatus");
            return (Criteria)this;
        }

        public Criteria andStuffStatusNotBetween(String value1, String value2) {
            this.addCriterion("stuff_status not between", value1, value2, "stuffStatus");
            return (Criteria)this;
        }

        public Criteria andCityIsNull() {
            this.addCriterion("city is null");
            return (Criteria)this;
        }

        public Criteria andCityIsNotNull() {
            this.addCriterion("city is not null");
            return (Criteria)this;
        }

        public Criteria andCityEqualTo(String value) {
            this.addCriterion("city =", value, "city");
            return (Criteria)this;
        }

        public Criteria andCityNotEqualTo(String value) {
            this.addCriterion("city <>", value, "city");
            return (Criteria)this;
        }

        public Criteria andCityGreaterThan(String value) {
            this.addCriterion("city >", value, "city");
            return (Criteria)this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            this.addCriterion("city >=", value, "city");
            return (Criteria)this;
        }

        public Criteria andCityLessThan(String value) {
            this.addCriterion("city <", value, "city");
            return (Criteria)this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            this.addCriterion("city <=", value, "city");
            return (Criteria)this;
        }

        public Criteria andCityLike(String value) {
            this.addCriterion("city like", value, "city");
            return (Criteria)this;
        }

        public Criteria andCityNotLike(String value) {
            this.addCriterion("city not like", value, "city");
            return (Criteria)this;
        }        public Criteria andCityIn(List<String> values) {
            this.addCriterion("city in", values, "city");
            return (Criteria)this;
        }

        public Criteria andCityNotIn(List<String> values) {
            this.addCriterion("city not in", values, "city");
            return (Criteria)this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            this.addCriterion("city between", value1, value2, "city");
            return (Criteria)this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            this.addCriterion("city not between", value1, value2, "city");
            return (Criteria)this;
        }

        public Criteria andProvIsNull() {
            this.addCriterion("prov is null");
            return (Criteria)this;
        }

        public Criteria andProvIsNotNull() {
            this.addCriterion("prov is not null");
            return (Criteria)this;
        }

        public Criteria andProvEqualTo(String value) {
            this.addCriterion("prov =", value, "prov");
            return (Criteria)this;
        }

        public Criteria andProvNotEqualTo(String value) {
            this.addCriterion("prov <>", value, "prov");
            return (Criteria)this;
        }

        public Criteria andProvGreaterThan(String value) {
            this.addCriterion("prov >", value, "prov");
            return (Criteria)this;
        }

        public Criteria andProvGreaterThanOrEqualTo(String value) {
            this.addCriterion("prov >=", value, "prov");
            return (Criteria)this;
        }

        public Criteria andProvLessThan(String value) {
            this.addCriterion("prov <", value, "prov");
            return (Criteria)this;
        }

        public Criteria andProvLessThanOrEqualTo(String value) {
            this.addCriterion("prov <=", value, "prov");
            return (Criteria)this;
        }

        public Criteria andProvLike(String value) {
            this.addCriterion("prov like", value, "prov");
            return (Criteria)this;
        }

        public Criteria andProvNotLike(String value) {
            this.addCriterion("prov not like", value, "prov");
            return (Criteria)this;
        }        public Criteria andProvIn(List<String> values) {
            this.addCriterion("prov in", values, "prov");
            return (Criteria)this;
        }

        public Criteria andProvNotIn(List<String> values) {
            this.addCriterion("prov not in", values, "prov");
            return (Criteria)this;
        }

        public Criteria andProvBetween(String value1, String value2) {
            this.addCriterion("prov between", value1, value2, "prov");
            return (Criteria)this;
        }

        public Criteria andProvNotBetween(String value1, String value2) {
            this.addCriterion("prov not between", value1, value2, "prov");
            return (Criteria)this;
        }

        public Criteria andPriceStringIsNull() {
            this.addCriterion("price_string is null");
            return (Criteria)this;
        }

        public Criteria andPriceStringIsNotNull() {
            this.addCriterion("price_string is not null");
            return (Criteria)this;
        }

        public Criteria andPriceStringEqualTo(String value) {
            this.addCriterion("price_string =", value, "priceString");
            return (Criteria)this;
        }

        public Criteria andPriceStringNotEqualTo(String value) {
            this.addCriterion("price_string <>", value, "priceString");
            return (Criteria)this;
        }

        public Criteria andPriceStringGreaterThan(String value) {
            this.addCriterion("price_string >", value, "priceString");
            return (Criteria)this;
        }

        public Criteria andPriceStringGreaterThanOrEqualTo(String value) {
            this.addCriterion("price_string >=", value, "priceString");
            return (Criteria)this;
        }

        public Criteria andPriceStringLessThan(String value) {
            this.addCriterion("price_string <", value, "priceString");
            return (Criteria)this;
        }

        public Criteria andPriceStringLessThanOrEqualTo(String value) {
            this.addCriterion("price_string <=", value, "priceString");
            return (Criteria)this;
        }

        public Criteria andPriceStringLike(String value) {
            this.addCriterion("price_string like", value, "priceString");
            return (Criteria)this;
        }

        public Criteria andPriceStringNotLike(String value) {
            this.addCriterion("price_string not like", value, "priceString");
            return (Criteria)this;
        }        public Criteria andPriceStringIn(List<String> values) {
            this.addCriterion("price_string in", values, "priceString");
            return (Criteria)this;
        }

        public Criteria andPriceStringNotIn(List<String> values) {
            this.addCriterion("price_string not in", values, "priceString");
            return (Criteria)this;
        }

        public Criteria andPriceStringBetween(String value1, String value2) {
            this.addCriterion("price_string between", value1, value2, "priceString");
            return (Criteria)this;
        }

        public Criteria andPriceStringNotBetween(String value1, String value2) {
            this.addCriterion("price_string not between", value1, value2, "priceString");
            return (Criteria)this;
        }

        public Criteria andPriceIsNull() {
            this.addCriterion("price is null");
            return (Criteria)this;
        }

        public Criteria andPriceIsNotNull() {
            this.addCriterion("price is not null");
            return (Criteria)this;
        }

        public Criteria andPriceEqualTo(Long value) {
            this.addCriterion("price =", value, "price");
            return (Criteria)this;
        }

        public Criteria andPriceNotEqualTo(Long value) {
            this.addCriterion("price <>", value, "price");
            return (Criteria)this;
        }

        public Criteria andPriceGreaterThan(Long value) {
            this.addCriterion("price >", value, "price");
            return (Criteria)this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Long value) {
            this.addCriterion("price >=", value, "price");
            return (Criteria)this;
        }

        public Criteria andPriceLessThan(Long value) {
            this.addCriterion("price <", value, "price");
            return (Criteria)this;
        }

        public Criteria andPriceLessThanOrEqualTo(Long value) {
            this.addCriterion("price <=", value, "price");
            return (Criteria)this;
        }

        public Criteria andPriceLike(String value) {
            this.addCriterion("price like", value, "price");
            return (Criteria)this;
        }

        public Criteria andPriceNotLike(String value) {
            this.addCriterion("price not like", value, "price");
            return (Criteria)this;
        }        public Criteria andPriceIn(List<Long> values) {
            this.addCriterion("price in", values, "price");
            return (Criteria)this;
        }

        public Criteria andPriceNotIn(List<Long> values) {
            this.addCriterion("price not in", values, "price");
            return (Criteria)this;
        }

        public Criteria andPriceBetween(Long value1, Long value2) {
            this.addCriterion("price between", value1, value2, "price");
            return (Criteria)this;
        }

        public Criteria andPriceNotBetween(Long value1, Long value2) {
            this.addCriterion("price not between", value1, value2, "price");
            return (Criteria)this;
        }

        public Criteria andPiPriceIsNull() {
            this.addCriterion("pi_price is null");
            return (Criteria)this;
        }

        public Criteria andPiPriceIsNotNull() {
            this.addCriterion("pi_price is not null");
            return (Criteria)this;
        }

        public Criteria andPiPriceEqualTo(Long value) {
            this.addCriterion("pi_price =", value, "piPrice");
            return (Criteria)this;
        }

        public Criteria andPiPriceNotEqualTo(Long value) {
            this.addCriterion("pi_price <>", value, "piPrice");
            return (Criteria)this;
        }

        public Criteria andPiPriceGreaterThan(Long value) {
            this.addCriterion("pi_price >", value, "piPrice");
            return (Criteria)this;
        }

        public Criteria andPiPriceGreaterThanOrEqualTo(Long value) {
            this.addCriterion("pi_price >=", value, "piPrice");
            return (Criteria)this;
        }

        public Criteria andPiPriceLessThan(Long value) {
            this.addCriterion("pi_price <", value, "piPrice");
            return (Criteria)this;
        }

        public Criteria andPiPriceLessThanOrEqualTo(Long value) {
            this.addCriterion("pi_price <=", value, "piPrice");
            return (Criteria)this;
        }

        public Criteria andPiPriceLike(String value) {
            this.addCriterion("pi_price like", value, "piPrice");
            return (Criteria)this;
        }

        public Criteria andPiPriceNotLike(String value) {
            this.addCriterion("pi_price not like", value, "piPrice");
            return (Criteria)this;
        }        public Criteria andPiPriceIn(List<Long> values) {
            this.addCriterion("pi_price in", values, "piPrice");
            return (Criteria)this;
        }

        public Criteria andPiPriceNotIn(List<Long> values) {
            this.addCriterion("pi_price not in", values, "piPrice");
            return (Criteria)this;
        }

        public Criteria andPiPriceBetween(Long value1, Long value2) {
            this.addCriterion("pi_price between", value1, value2, "piPrice");
            return (Criteria)this;
        }

        public Criteria andPiPriceNotBetween(Long value1, Long value2) {
            this.addCriterion("pi_price not between", value1, value2, "piPrice");
            return (Criteria)this;
        }

        public Criteria andPiPriceStringIsNull() {
            this.addCriterion("pi_price_string is null");
            return (Criteria)this;
        }

        public Criteria andPiPriceStringIsNotNull() {
            this.addCriterion("pi_price_string is not null");
            return (Criteria)this;
        }

        public Criteria andPiPriceStringEqualTo(String value) {
            this.addCriterion("pi_price_string =", value, "piPriceString");
            return (Criteria)this;
        }

        public Criteria andPiPriceStringNotEqualTo(String value) {
            this.addCriterion("pi_price_string <>", value, "piPriceString");
            return (Criteria)this;
        }

        public Criteria andPiPriceStringGreaterThan(String value) {
            this.addCriterion("pi_price_string >", value, "piPriceString");
            return (Criteria)this;
        }

        public Criteria andPiPriceStringGreaterThanOrEqualTo(String value) {
            this.addCriterion("pi_price_string >=", value, "piPriceString");
            return (Criteria)this;
        }

        public Criteria andPiPriceStringLessThan(String value) {
            this.addCriterion("pi_price_string <", value, "piPriceString");
            return (Criteria)this;
        }

        public Criteria andPiPriceStringLessThanOrEqualTo(String value) {
            this.addCriterion("pi_price_string <=", value, "piPriceString");
            return (Criteria)this;
        }

        public Criteria andPiPriceStringLike(String value) {
            this.addCriterion("pi_price_string like", value, "piPriceString");
            return (Criteria)this;
        }

        public Criteria andPiPriceStringNotLike(String value) {
            this.addCriterion("pi_price_string not like", value, "piPriceString");
            return (Criteria)this;
        }        public Criteria andPiPriceStringIn(List<String> values) {
            this.addCriterion("pi_price_string in", values, "piPriceString");
            return (Criteria)this;
        }

        public Criteria andPiPriceStringNotIn(List<String> values) {
            this.addCriterion("pi_price_string not in", values, "piPriceString");
            return (Criteria)this;
        }

        public Criteria andPiPriceStringBetween(String value1, String value2) {
            this.addCriterion("pi_price_string between", value1, value2, "piPriceString");
            return (Criteria)this;
        }

        public Criteria andPiPriceStringNotBetween(String value1, String value2) {
            this.addCriterion("pi_price_string not between", value1, value2, "piPriceString");
            return (Criteria)this;
        }

        public Criteria andPriceRoleIsNull() {
            this.addCriterion("price_role is null");
            return (Criteria)this;
        }

        public Criteria andPriceRoleIsNotNull() {
            this.addCriterion("price_role is not null");
            return (Criteria)this;
        }

        public Criteria andPriceRoleEqualTo(String value) {
            this.addCriterion("price_role =", value, "priceRole");
            return (Criteria)this;
        }

        public Criteria andPriceRoleNotEqualTo(String value) {
            this.addCriterion("price_role <>", value, "priceRole");
            return (Criteria)this;
        }

        public Criteria andPriceRoleGreaterThan(String value) {
            this.addCriterion("price_role >", value, "priceRole");
            return (Criteria)this;
        }

        public Criteria andPriceRoleGreaterThanOrEqualTo(String value) {
            this.addCriterion("price_role >=", value, "priceRole");
            return (Criteria)this;
        }

        public Criteria andPriceRoleLessThan(String value) {
            this.addCriterion("price_role <", value, "priceRole");
            return (Criteria)this;
        }

        public Criteria andPriceRoleLessThanOrEqualTo(String value) {
            this.addCriterion("price_role <=", value, "priceRole");
            return (Criteria)this;
        }

        public Criteria andPriceRoleLike(String value) {
            this.addCriterion("price_role like", value, "priceRole");
            return (Criteria)this;
        }

        public Criteria andPriceRoleNotLike(String value) {
            this.addCriterion("price_role not like", value, "priceRole");
            return (Criteria)this;
        }        public Criteria andPriceRoleIn(List<String> values) {
            this.addCriterion("price_role in", values, "priceRole");
            return (Criteria)this;
        }

        public Criteria andPriceRoleNotIn(List<String> values) {
            this.addCriterion("price_role not in", values, "priceRole");
            return (Criteria)this;
        }

        public Criteria andPriceRoleBetween(String value1, String value2) {
            this.addCriterion("price_role between", value1, value2, "priceRole");
            return (Criteria)this;
        }

        public Criteria andPriceRoleNotBetween(String value1, String value2) {
            this.addCriterion("price_role not between", value1, value2, "priceRole");
            return (Criteria)this;
        }

        public Criteria andPostFeeIsNull() {
            this.addCriterion("post_fee is null");
            return (Criteria)this;
        }

        public Criteria andPostFeeIsNotNull() {
            this.addCriterion("post_fee is not null");
            return (Criteria)this;
        }

        public Criteria andPostFeeEqualTo(String value) {
            this.addCriterion("post_fee =", value, "postFee");
            return (Criteria)this;
        }

        public Criteria andPostFeeNotEqualTo(String value) {
            this.addCriterion("post_fee <>", value, "postFee");
            return (Criteria)this;
        }

        public Criteria andPostFeeGreaterThan(String value) {
            this.addCriterion("post_fee >", value, "postFee");
            return (Criteria)this;
        }

        public Criteria andPostFeeGreaterThanOrEqualTo(String value) {
            this.addCriterion("post_fee >=", value, "postFee");
            return (Criteria)this;
        }

        public Criteria andPostFeeLessThan(String value) {
            this.addCriterion("post_fee <", value, "postFee");
            return (Criteria)this;
        }

        public Criteria andPostFeeLessThanOrEqualTo(String value) {
            this.addCriterion("post_fee <=", value, "postFee");
            return (Criteria)this;
        }

        public Criteria andPostFeeLike(String value) {
            this.addCriterion("post_fee like", value, "postFee");
            return (Criteria)this;
        }

        public Criteria andPostFeeNotLike(String value) {
            this.addCriterion("post_fee not like", value, "postFee");
            return (Criteria)this;
        }        public Criteria andPostFeeIn(List<String> values) {
            this.addCriterion("post_fee in", values, "postFee");
            return (Criteria)this;
        }

        public Criteria andPostFeeNotIn(List<String> values) {
            this.addCriterion("post_fee not in", values, "postFee");
            return (Criteria)this;
        }

        public Criteria andPostFeeBetween(String value1, String value2) {
            this.addCriterion("post_fee between", value1, value2, "postFee");
            return (Criteria)this;
        }

        public Criteria andPostFeeNotBetween(String value1, String value2) {
            this.addCriterion("post_fee not between", value1, value2, "postFee");
            return (Criteria)this;
        }

        public Criteria andExpressFeeIsNull() {
            this.addCriterion("express_fee is null");
            return (Criteria)this;
        }

        public Criteria andExpressFeeIsNotNull() {
            this.addCriterion("express_fee is not null");
            return (Criteria)this;
        }

        public Criteria andExpressFeeEqualTo(String value) {
            this.addCriterion("express_fee =", value, "expressFee");
            return (Criteria)this;
        }

        public Criteria andExpressFeeNotEqualTo(String value) {
            this.addCriterion("express_fee <>", value, "expressFee");
            return (Criteria)this;
        }

        public Criteria andExpressFeeGreaterThan(String value) {
            this.addCriterion("express_fee >", value, "expressFee");
            return (Criteria)this;
        }

        public Criteria andExpressFeeGreaterThanOrEqualTo(String value) {
            this.addCriterion("express_fee >=", value, "expressFee");
            return (Criteria)this;
        }

        public Criteria andExpressFeeLessThan(String value) {
            this.addCriterion("express_fee <", value, "expressFee");
            return (Criteria)this;
        }

        public Criteria andExpressFeeLessThanOrEqualTo(String value) {
            this.addCriterion("express_fee <=", value, "expressFee");
            return (Criteria)this;
        }

        public Criteria andExpressFeeLike(String value) {
            this.addCriterion("express_fee like", value, "expressFee");
            return (Criteria)this;
        }

        public Criteria andExpressFeeNotLike(String value) {
            this.addCriterion("express_fee not like", value, "expressFee");
            return (Criteria)this;
        }        public Criteria andExpressFeeIn(List<String> values) {
            this.addCriterion("express_fee in", values, "expressFee");
            return (Criteria)this;
        }

        public Criteria andExpressFeeNotIn(List<String> values) {
            this.addCriterion("express_fee not in", values, "expressFee");
            return (Criteria)this;
        }

        public Criteria andExpressFeeBetween(String value1, String value2) {
            this.addCriterion("express_fee between", value1, value2, "expressFee");
            return (Criteria)this;
        }

        public Criteria andExpressFeeNotBetween(String value1, String value2) {
            this.addCriterion("express_fee not between", value1, value2, "expressFee");
            return (Criteria)this;
        }

        public Criteria andEmsFeeIsNull() {
            this.addCriterion("ems_fee is null");
            return (Criteria)this;
        }

        public Criteria andEmsFeeIsNotNull() {
            this.addCriterion("ems_fee is not null");
            return (Criteria)this;
        }

        public Criteria andEmsFeeEqualTo(String value) {
            this.addCriterion("ems_fee =", value, "emsFee");
            return (Criteria)this;
        }

        public Criteria andEmsFeeNotEqualTo(String value) {
            this.addCriterion("ems_fee <>", value, "emsFee");
            return (Criteria)this;
        }

        public Criteria andEmsFeeGreaterThan(String value) {
            this.addCriterion("ems_fee >", value, "emsFee");
            return (Criteria)this;
        }

        public Criteria andEmsFeeGreaterThanOrEqualTo(String value) {
            this.addCriterion("ems_fee >=", value, "emsFee");
            return (Criteria)this;
        }

        public Criteria andEmsFeeLessThan(String value) {
            this.addCriterion("ems_fee <", value, "emsFee");
            return (Criteria)this;
        }

        public Criteria andEmsFeeLessThanOrEqualTo(String value) {
            this.addCriterion("ems_fee <=", value, "emsFee");
            return (Criteria)this;
        }

        public Criteria andEmsFeeLike(String value) {
            this.addCriterion("ems_fee like", value, "emsFee");
            return (Criteria)this;
        }

        public Criteria andEmsFeeNotLike(String value) {
            this.addCriterion("ems_fee not like", value, "emsFee");
            return (Criteria)this;
        }        public Criteria andEmsFeeIn(List<String> values) {
            this.addCriterion("ems_fee in", values, "emsFee");
            return (Criteria)this;
        }

        public Criteria andEmsFeeNotIn(List<String> values) {
            this.addCriterion("ems_fee not in", values, "emsFee");
            return (Criteria)this;
        }

        public Criteria andEmsFeeBetween(String value1, String value2) {
            this.addCriterion("ems_fee between", value1, value2, "emsFee");
            return (Criteria)this;
        }

        public Criteria andEmsFeeNotBetween(String value1, String value2) {
            this.addCriterion("ems_fee not between", value1, value2, "emsFee");
            return (Criteria)this;
        }

        public Criteria andHasDiscountIsNull() {
            this.addCriterion("has_discount is null");
            return (Criteria)this;
        }

        public Criteria andHasDiscountIsNotNull() {
            this.addCriterion("has_discount is not null");
            return (Criteria)this;
        }

        public Criteria andHasDiscountEqualTo(String value) {
            this.addCriterion("has_discount =", value, "hasDiscount");
            return (Criteria)this;
        }

        public Criteria andHasDiscountNotEqualTo(String value) {
            this.addCriterion("has_discount <>", value, "hasDiscount");
            return (Criteria)this;
        }

        public Criteria andHasDiscountGreaterThan(String value) {
            this.addCriterion("has_discount >", value, "hasDiscount");
            return (Criteria)this;
        }

        public Criteria andHasDiscountGreaterThanOrEqualTo(String value) {
            this.addCriterion("has_discount >=", value, "hasDiscount");
            return (Criteria)this;
        }

        public Criteria andHasDiscountLessThan(String value) {
            this.addCriterion("has_discount <", value, "hasDiscount");
            return (Criteria)this;
        }

        public Criteria andHasDiscountLessThanOrEqualTo(String value) {
            this.addCriterion("has_discount <=", value, "hasDiscount");
            return (Criteria)this;
        }

        public Criteria andHasDiscountLike(String value) {
            this.addCriterion("has_discount like", value, "hasDiscount");
            return (Criteria)this;
        }

        public Criteria andHasDiscountNotLike(String value) {
            this.addCriterion("has_discount not like", value, "hasDiscount");
            return (Criteria)this;
        }        public Criteria andHasDiscountIn(List<String> values) {
            this.addCriterion("has_discount in", values, "hasDiscount");
            return (Criteria)this;
        }

        public Criteria andHasDiscountNotIn(List<String> values) {
            this.addCriterion("has_discount not in", values, "hasDiscount");
            return (Criteria)this;
        }

        public Criteria andHasDiscountBetween(String value1, String value2) {
            this.addCriterion("has_discount between", value1, value2, "hasDiscount");
            return (Criteria)this;
        }

        public Criteria andHasDiscountNotBetween(String value1, String value2) {
            this.addCriterion("has_discount not between", value1, value2, "hasDiscount");
            return (Criteria)this;
        }

        public Criteria andFreightPayerIsNull() {
            this.addCriterion("freight_payer is null");
            return (Criteria)this;
        }

        public Criteria andFreightPayerIsNotNull() {
            this.addCriterion("freight_payer is not null");
            return (Criteria)this;
        }

        public Criteria andFreightPayerEqualTo(String value) {
            this.addCriterion("freight_payer =", value, "freightPayer");
            return (Criteria)this;
        }

        public Criteria andFreightPayerNotEqualTo(String value) {
            this.addCriterion("freight_payer <>", value, "freightPayer");
            return (Criteria)this;
        }

        public Criteria andFreightPayerGreaterThan(String value) {
            this.addCriterion("freight_payer >", value, "freightPayer");
            return (Criteria)this;
        }

        public Criteria andFreightPayerGreaterThanOrEqualTo(String value) {
            this.addCriterion("freight_payer >=", value, "freightPayer");
            return (Criteria)this;
        }

        public Criteria andFreightPayerLessThan(String value) {
            this.addCriterion("freight_payer <", value, "freightPayer");
            return (Criteria)this;
        }

        public Criteria andFreightPayerLessThanOrEqualTo(String value) {
            this.addCriterion("freight_payer <=", value, "freightPayer");
            return (Criteria)this;
        }

        public Criteria andFreightPayerLike(String value) {
            this.addCriterion("freight_payer like", value, "freightPayer");
            return (Criteria)this;
        }

        public Criteria andFreightPayerNotLike(String value) {
            this.addCriterion("freight_payer not like", value, "freightPayer");
            return (Criteria)this;
        }        public Criteria andFreightPayerIn(List<String> values) {
            this.addCriterion("freight_payer in", values, "freightPayer");
            return (Criteria)this;
        }

        public Criteria andFreightPayerNotIn(List<String> values) {
            this.addCriterion("freight_payer not in", values, "freightPayer");
            return (Criteria)this;
        }

        public Criteria andFreightPayerBetween(String value1, String value2) {
            this.addCriterion("freight_payer between", value1, value2, "freightPayer");
            return (Criteria)this;
        }

        public Criteria andFreightPayerNotBetween(String value1, String value2) {
            this.addCriterion("freight_payer not between", value1, value2, "freightPayer");
            return (Criteria)this;
        }

        public Criteria andHasShowcaseIsNull() {
            this.addCriterion("has_showcase is null");
            return (Criteria)this;
        }

        public Criteria andHasShowcaseIsNotNull() {
            this.addCriterion("has_showcase is not null");
            return (Criteria)this;
        }

        public Criteria andHasShowcaseEqualTo(String value) {
            this.addCriterion("has_showcase =", value, "hasShowcase");
            return (Criteria)this;
        }

        public Criteria andHasShowcaseNotEqualTo(String value) {
            this.addCriterion("has_showcase <>", value, "hasShowcase");
            return (Criteria)this;
        }

        public Criteria andHasShowcaseGreaterThan(String value) {
            this.addCriterion("has_showcase >", value, "hasShowcase");
            return (Criteria)this;
        }

        public Criteria andHasShowcaseGreaterThanOrEqualTo(String value) {
            this.addCriterion("has_showcase >=", value, "hasShowcase");
            return (Criteria)this;
        }

        public Criteria andHasShowcaseLessThan(String value) {
            this.addCriterion("has_showcase <", value, "hasShowcase");
            return (Criteria)this;
        }

        public Criteria andHasShowcaseLessThanOrEqualTo(String value) {
            this.addCriterion("has_showcase <=", value, "hasShowcase");
            return (Criteria)this;
        }

        public Criteria andHasShowcaseLike(String value) {
            this.addCriterion("has_showcase like", value, "hasShowcase");
            return (Criteria)this;
        }

        public Criteria andHasShowcaseNotLike(String value) {
            this.addCriterion("has_showcase not like", value, "hasShowcase");
            return (Criteria)this;
        }        public Criteria andHasShowcaseIn(List<String> values) {
            this.addCriterion("has_showcase in", values, "hasShowcase");
            return (Criteria)this;
        }

        public Criteria andHasShowcaseNotIn(List<String> values) {
            this.addCriterion("has_showcase not in", values, "hasShowcase");
            return (Criteria)this;
        }

        public Criteria andHasShowcaseBetween(String value1, String value2) {
            this.addCriterion("has_showcase between", value1, value2, "hasShowcase");
            return (Criteria)this;
        }

        public Criteria andHasShowcaseNotBetween(String value1, String value2) {
            this.addCriterion("has_showcase not between", value1, value2, "hasShowcase");
            return (Criteria)this;
        }

        public Criteria andModifiedIsNull() {
            this.addCriterion("modified is null");
            return (Criteria)this;
        }

        public Criteria andModifiedIsNotNull() {
            this.addCriterion("modified is not null");
            return (Criteria)this;
        }

        public Criteria andModifiedEqualTo(Date value) {
            this.addCriterion("modified =", value, "modified");
            return (Criteria)this;
        }

        public Criteria andModifiedNotEqualTo(Date value) {
            this.addCriterion("modified <>", value, "modified");
            return (Criteria)this;
        }

        public Criteria andModifiedGreaterThan(Date value) {
            this.addCriterion("modified >", value, "modified");
            return (Criteria)this;
        }

        public Criteria andModifiedGreaterThanOrEqualTo(Date value) {
            this.addCriterion("modified >=", value, "modified");
            return (Criteria)this;
        }

        public Criteria andModifiedLessThan(Date value) {
            this.addCriterion("modified <", value, "modified");
            return (Criteria)this;
        }

        public Criteria andModifiedLessThanOrEqualTo(Date value) {
            this.addCriterion("modified <=", value, "modified");
            return (Criteria)this;
        }

        public Criteria andModifiedLike(String value) {
            this.addCriterion("modified like", value, "modified");
            return (Criteria)this;
        }

        public Criteria andModifiedNotLike(String value) {
            this.addCriterion("modified not like", value, "modified");
            return (Criteria)this;
        }        public Criteria andModifiedIn(List<Date> values) {
            this.addCriterion("modified in", values, "modified");
            return (Criteria)this;
        }

        public Criteria andModifiedNotIn(List<Date> values) {
            this.addCriterion("modified not in", values, "modified");
            return (Criteria)this;
        }

        public Criteria andModifiedBetween(Date value1, Date value2) {
            this.addCriterion("modified between", value1, value2, "modified");
            return (Criteria)this;
        }

        public Criteria andModifiedNotBetween(Date value1, Date value2) {
            this.addCriterion("modified not between", value1, value2, "modified");
            return (Criteria)this;
        }

        public Criteria andMarketIdIsNull() {
            this.addCriterion("market_id is null");
            return (Criteria)this;
        }

        public Criteria andMarketIdIsNotNull() {
            this.addCriterion("market_id is not null");
            return (Criteria)this;
        }

        public Criteria andMarketIdEqualTo(Long value) {
            this.addCriterion("market_id =", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdNotEqualTo(Long value) {
            this.addCriterion("market_id <>", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdGreaterThan(Long value) {
            this.addCriterion("market_id >", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("market_id >=", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdLessThan(Long value) {
            this.addCriterion("market_id <", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdLessThanOrEqualTo(Long value) {
            this.addCriterion("market_id <=", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdLike(String value) {
            this.addCriterion("market_id like", value, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdNotLike(String value) {
            this.addCriterion("market_id not like", value, "marketId");
            return (Criteria)this;
        }        public Criteria andMarketIdIn(List<Long> values) {
            this.addCriterion("market_id in", values, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdNotIn(List<Long> values) {
            this.addCriterion("market_id not in", values, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdBetween(Long value1, Long value2) {
            this.addCriterion("market_id between", value1, value2, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIdNotBetween(Long value1, Long value2) {
            this.addCriterion("market_id not between", value1, value2, "marketId");
            return (Criteria)this;
        }

        public Criteria andMarketIsNull() {
            this.addCriterion("market is null");
            return (Criteria)this;
        }

        public Criteria andMarketIsNotNull() {
            this.addCriterion("market is not null");
            return (Criteria)this;
        }

        public Criteria andMarketEqualTo(String value) {
            this.addCriterion("market =", value, "market");
            return (Criteria)this;
        }

        public Criteria andMarketNotEqualTo(String value) {
            this.addCriterion("market <>", value, "market");
            return (Criteria)this;
        }

        public Criteria andMarketGreaterThan(String value) {
            this.addCriterion("market >", value, "market");
            return (Criteria)this;
        }

        public Criteria andMarketGreaterThanOrEqualTo(String value) {
            this.addCriterion("market >=", value, "market");
            return (Criteria)this;
        }

        public Criteria andMarketLessThan(String value) {
            this.addCriterion("market <", value, "market");
            return (Criteria)this;
        }

        public Criteria andMarketLessThanOrEqualTo(String value) {
            this.addCriterion("market <=", value, "market");
            return (Criteria)this;
        }

        public Criteria andMarketLike(String value) {
            this.addCriterion("market like", value, "market");
            return (Criteria)this;
        }

        public Criteria andMarketNotLike(String value) {
            this.addCriterion("market not like", value, "market");
            return (Criteria)this;
        }        public Criteria andMarketIn(List<String> values) {
            this.addCriterion("market in", values, "market");
            return (Criteria)this;
        }

        public Criteria andMarketNotIn(List<String> values) {
            this.addCriterion("market not in", values, "market");
            return (Criteria)this;
        }

        public Criteria andMarketBetween(String value1, String value2) {
            this.addCriterion("market between", value1, value2, "market");
            return (Criteria)this;
        }

        public Criteria andMarketNotBetween(String value1, String value2) {
            this.addCriterion("market not between", value1, value2, "market");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdIsNull() {
            this.addCriterion("parent_market_id is null");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdIsNotNull() {
            this.addCriterion("parent_market_id is not null");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdEqualTo(Long value) {
            this.addCriterion("parent_market_id =", value, "parentMarketId");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdNotEqualTo(Long value) {
            this.addCriterion("parent_market_id <>", value, "parentMarketId");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdGreaterThan(Long value) {
            this.addCriterion("parent_market_id >", value, "parentMarketId");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("parent_market_id >=", value, "parentMarketId");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdLessThan(Long value) {
            this.addCriterion("parent_market_id <", value, "parentMarketId");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdLessThanOrEqualTo(Long value) {
            this.addCriterion("parent_market_id <=", value, "parentMarketId");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdLike(String value) {
            this.addCriterion("parent_market_id like", value, "parentMarketId");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdNotLike(String value) {
            this.addCriterion("parent_market_id not like", value, "parentMarketId");
            return (Criteria)this;
        }        public Criteria andParentMarketIdIn(List<Long> values) {
            this.addCriterion("parent_market_id in", values, "parentMarketId");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdNotIn(List<Long> values) {
            this.addCriterion("parent_market_id not in", values, "parentMarketId");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdBetween(Long value1, Long value2) {
            this.addCriterion("parent_market_id between", value1, value2, "parentMarketId");
            return (Criteria)this;
        }

        public Criteria andParentMarketIdNotBetween(Long value1, Long value2) {
            this.addCriterion("parent_market_id not between", value1, value2, "parentMarketId");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameIsNull() {
            this.addCriterion("parent_market_name is null");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameIsNotNull() {
            this.addCriterion("parent_market_name is not null");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameEqualTo(String value) {
            this.addCriterion("parent_market_name =", value, "parentMarketName");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameNotEqualTo(String value) {
            this.addCriterion("parent_market_name <>", value, "parentMarketName");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameGreaterThan(String value) {
            this.addCriterion("parent_market_name >", value, "parentMarketName");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("parent_market_name >=", value, "parentMarketName");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameLessThan(String value) {
            this.addCriterion("parent_market_name <", value, "parentMarketName");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameLessThanOrEqualTo(String value) {
            this.addCriterion("parent_market_name <=", value, "parentMarketName");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameLike(String value) {
            this.addCriterion("parent_market_name like", value, "parentMarketName");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameNotLike(String value) {
            this.addCriterion("parent_market_name not like", value, "parentMarketName");
            return (Criteria)this;
        }        public Criteria andParentMarketNameIn(List<String> values) {
            this.addCriterion("parent_market_name in", values, "parentMarketName");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameNotIn(List<String> values) {
            this.addCriterion("parent_market_name not in", values, "parentMarketName");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameBetween(String value1, String value2) {
            this.addCriterion("parent_market_name between", value1, value2, "parentMarketName");
            return (Criteria)this;
        }

        public Criteria andParentMarketNameNotBetween(String value1, String value2) {
            this.addCriterion("parent_market_name not between", value1, value2, "parentMarketName");
            return (Criteria)this;
        }

        public Criteria andStoreNumIsNull() {
            this.addCriterion("store_num is null");
            return (Criteria)this;
        }

        public Criteria andStoreNumIsNotNull() {
            this.addCriterion("store_num is not null");
            return (Criteria)this;
        }

        public Criteria andStoreNumEqualTo(String value) {
            this.addCriterion("store_num =", value, "storeNum");
            return (Criteria)this;
        }

        public Criteria andStoreNumNotEqualTo(String value) {
            this.addCriterion("store_num <>", value, "storeNum");
            return (Criteria)this;
        }

        public Criteria andStoreNumGreaterThan(String value) {
            this.addCriterion("store_num >", value, "storeNum");
            return (Criteria)this;
        }

        public Criteria andStoreNumGreaterThanOrEqualTo(String value) {
            this.addCriterion("store_num >=", value, "storeNum");
            return (Criteria)this;
        }

        public Criteria andStoreNumLessThan(String value) {
            this.addCriterion("store_num <", value, "storeNum");
            return (Criteria)this;
        }

        public Criteria andStoreNumLessThanOrEqualTo(String value) {
            this.addCriterion("store_num <=", value, "storeNum");
            return (Criteria)this;
        }

        public Criteria andStoreNumLike(String value) {
            this.addCriterion("store_num like", value, "storeNum");
            return (Criteria)this;
        }

        public Criteria andStoreNumNotLike(String value) {
            this.addCriterion("store_num not like", value, "storeNum");
            return (Criteria)this;
        }        public Criteria andStoreNumIn(List<String> values) {
            this.addCriterion("store_num in", values, "storeNum");
            return (Criteria)this;
        }

        public Criteria andStoreNumNotIn(List<String> values) {
            this.addCriterion("store_num not in", values, "storeNum");
            return (Criteria)this;
        }

        public Criteria andStoreNumBetween(String value1, String value2) {
            this.addCriterion("store_num between", value1, value2, "storeNum");
            return (Criteria)this;
        }

        public Criteria andStoreNumNotBetween(String value1, String value2) {
            this.addCriterion("store_num not between", value1, value2, "storeNum");
            return (Criteria)this;
        }

        public Criteria andIsTaobaoSynchronizationIsNull() {
            this.addCriterion("is_taobao_synchronization is null");
            return (Criteria)this;
        }

        public Criteria andIsTaobaoSynchronizationIsNotNull() {
            this.addCriterion("is_taobao_synchronization is not null");
            return (Criteria)this;
        }

        public Criteria andIsTaobaoSynchronizationEqualTo(Long value) {
            this.addCriterion("is_taobao_synchronization =", value, "isTaobaoSynchronization");
            return (Criteria)this;
        }

        public Criteria andIsTaobaoSynchronizationNotEqualTo(Long value) {
            this.addCriterion("is_taobao_synchronization <>", value, "isTaobaoSynchronization");
            return (Criteria)this;
        }

        public Criteria andIsTaobaoSynchronizationGreaterThan(Long value) {
            this.addCriterion("is_taobao_synchronization >", value, "isTaobaoSynchronization");
            return (Criteria)this;
        }

        public Criteria andIsTaobaoSynchronizationGreaterThanOrEqualTo(Long value) {
            this.addCriterion("is_taobao_synchronization >=", value, "isTaobaoSynchronization");
            return (Criteria)this;
        }

        public Criteria andIsTaobaoSynchronizationLessThan(Long value) {
            this.addCriterion("is_taobao_synchronization <", value, "isTaobaoSynchronization");
            return (Criteria)this;
        }

        public Criteria andIsTaobaoSynchronizationLessThanOrEqualTo(Long value) {
            this.addCriterion("is_taobao_synchronization <=", value, "isTaobaoSynchronization");
            return (Criteria)this;
        }

        public Criteria andIsTaobaoSynchronizationLike(String value) {
            this.addCriterion("is_taobao_synchronization like", value, "isTaobaoSynchronization");
            return (Criteria)this;
        }

        public Criteria andIsTaobaoSynchronizationNotLike(String value) {
            this.addCriterion("is_taobao_synchronization not like", value, "isTaobaoSynchronization");
            return (Criteria)this;
        }        public Criteria andIsTaobaoSynchronizationIn(List<Long> values) {
            this.addCriterion("is_taobao_synchronization in", values, "isTaobaoSynchronization");
            return (Criteria)this;
        }

        public Criteria andIsTaobaoSynchronizationNotIn(List<Long> values) {
            this.addCriterion("is_taobao_synchronization not in", values, "isTaobaoSynchronization");
            return (Criteria)this;
        }

        public Criteria andIsTaobaoSynchronizationBetween(Long value1, Long value2) {
            this.addCriterion("is_taobao_synchronization between", value1, value2, "isTaobaoSynchronization");
            return (Criteria)this;
        }

        public Criteria andIsTaobaoSynchronizationNotBetween(Long value1, Long value2) {
            this.addCriterion("is_taobao_synchronization not between", value1, value2, "isTaobaoSynchronization");
            return (Criteria)this;
        }

        public Criteria andIsAkeyToUploadIsNull() {
            this.addCriterion("is_akey_to_upload is null");
            return (Criteria)this;
        }

        public Criteria andIsAkeyToUploadIsNotNull() {
            this.addCriterion("is_akey_to_upload is not null");
            return (Criteria)this;
        }

        public Criteria andIsAkeyToUploadEqualTo(Long value) {
            this.addCriterion("is_akey_to_upload =", value, "isAkeyToUpload");
            return (Criteria)this;
        }

        public Criteria andIsAkeyToUploadNotEqualTo(Long value) {
            this.addCriterion("is_akey_to_upload <>", value, "isAkeyToUpload");
            return (Criteria)this;
        }

        public Criteria andIsAkeyToUploadGreaterThan(Long value) {
            this.addCriterion("is_akey_to_upload >", value, "isAkeyToUpload");
            return (Criteria)this;
        }

        public Criteria andIsAkeyToUploadGreaterThanOrEqualTo(Long value) {
            this.addCriterion("is_akey_to_upload >=", value, "isAkeyToUpload");
            return (Criteria)this;
        }

        public Criteria andIsAkeyToUploadLessThan(Long value) {
            this.addCriterion("is_akey_to_upload <", value, "isAkeyToUpload");
            return (Criteria)this;
        }

        public Criteria andIsAkeyToUploadLessThanOrEqualTo(Long value) {
            this.addCriterion("is_akey_to_upload <=", value, "isAkeyToUpload");
            return (Criteria)this;
        }

        public Criteria andIsAkeyToUploadLike(String value) {
            this.addCriterion("is_akey_to_upload like", value, "isAkeyToUpload");
            return (Criteria)this;
        }

        public Criteria andIsAkeyToUploadNotLike(String value) {
            this.addCriterion("is_akey_to_upload not like", value, "isAkeyToUpload");
            return (Criteria)this;
        }        public Criteria andIsAkeyToUploadIn(List<Long> values) {
            this.addCriterion("is_akey_to_upload in", values, "isAkeyToUpload");
            return (Criteria)this;
        }

        public Criteria andIsAkeyToUploadNotIn(List<Long> values) {
            this.addCriterion("is_akey_to_upload not in", values, "isAkeyToUpload");
            return (Criteria)this;
        }

        public Criteria andIsAkeyToUploadBetween(Long value1, Long value2) {
            this.addCriterion("is_akey_to_upload between", value1, value2, "isAkeyToUpload");
            return (Criteria)this;
        }

        public Criteria andIsAkeyToUploadNotBetween(Long value1, Long value2) {
            this.addCriterion("is_akey_to_upload not between", value1, value2, "isAkeyToUpload");
            return (Criteria)this;
        }

        public Criteria andIsTradeIsNull() {
            this.addCriterion("is_trade is null");
            return (Criteria)this;
        }

        public Criteria andIsTradeIsNotNull() {
            this.addCriterion("is_trade is not null");
            return (Criteria)this;
        }

        public Criteria andIsTradeEqualTo(Long value) {
            this.addCriterion("is_trade =", value, "isTrade");
            return (Criteria)this;
        }

        public Criteria andIsTradeNotEqualTo(Long value) {
            this.addCriterion("is_trade <>", value, "isTrade");
            return (Criteria)this;
        }

        public Criteria andIsTradeGreaterThan(Long value) {
            this.addCriterion("is_trade >", value, "isTrade");
            return (Criteria)this;
        }

        public Criteria andIsTradeGreaterThanOrEqualTo(Long value) {
            this.addCriterion("is_trade >=", value, "isTrade");
            return (Criteria)this;
        }

        public Criteria andIsTradeLessThan(Long value) {
            this.addCriterion("is_trade <", value, "isTrade");
            return (Criteria)this;
        }

        public Criteria andIsTradeLessThanOrEqualTo(Long value) {
            this.addCriterion("is_trade <=", value, "isTrade");
            return (Criteria)this;
        }

        public Criteria andIsTradeLike(String value) {
            this.addCriterion("is_trade like", value, "isTrade");
            return (Criteria)this;
        }

        public Criteria andIsTradeNotLike(String value) {
            this.addCriterion("is_trade not like", value, "isTrade");
            return (Criteria)this;
        }        public Criteria andIsTradeIn(List<Long> values) {
            this.addCriterion("is_trade in", values, "isTrade");
            return (Criteria)this;
        }

        public Criteria andIsTradeNotIn(List<Long> values) {
            this.addCriterion("is_trade not in", values, "isTrade");
            return (Criteria)this;
        }

        public Criteria andIsTradeBetween(Long value1, Long value2) {
            this.addCriterion("is_trade between", value1, value2, "isTrade");
            return (Criteria)this;
        }

        public Criteria andIsTradeNotBetween(Long value1, Long value2) {
            this.addCriterion("is_trade not between", value1, value2, "isTrade");
            return (Criteria)this;
        }

        public Criteria andIsEfficaciousIsNull() {
            this.addCriterion("is_efficacious is null");
            return (Criteria)this;
        }

        public Criteria andIsEfficaciousIsNotNull() {
            this.addCriterion("is_efficacious is not null");
            return (Criteria)this;
        }

        public Criteria andIsEfficaciousEqualTo(Long value) {
            this.addCriterion("is_efficacious =", value, "isEfficacious");
            return (Criteria)this;
        }

        public Criteria andIsEfficaciousNotEqualTo(Long value) {
            this.addCriterion("is_efficacious <>", value, "isEfficacious");
            return (Criteria)this;
        }

        public Criteria andIsEfficaciousGreaterThan(Long value) {
            this.addCriterion("is_efficacious >", value, "isEfficacious");
            return (Criteria)this;
        }

        public Criteria andIsEfficaciousGreaterThanOrEqualTo(Long value) {
            this.addCriterion("is_efficacious >=", value, "isEfficacious");
            return (Criteria)this;
        }

        public Criteria andIsEfficaciousLessThan(Long value) {
            this.addCriterion("is_efficacious <", value, "isEfficacious");
            return (Criteria)this;
        }

        public Criteria andIsEfficaciousLessThanOrEqualTo(Long value) {
            this.addCriterion("is_efficacious <=", value, "isEfficacious");
            return (Criteria)this;
        }

        public Criteria andIsEfficaciousLike(String value) {
            this.addCriterion("is_efficacious like", value, "isEfficacious");
            return (Criteria)this;
        }

        public Criteria andIsEfficaciousNotLike(String value) {
            this.addCriterion("is_efficacious not like", value, "isEfficacious");
            return (Criteria)this;
        }        public Criteria andIsEfficaciousIn(List<Long> values) {
            this.addCriterion("is_efficacious in", values, "isEfficacious");
            return (Criteria)this;
        }

        public Criteria andIsEfficaciousNotIn(List<Long> values) {
            this.addCriterion("is_efficacious not in", values, "isEfficacious");
            return (Criteria)this;
        }

        public Criteria andIsEfficaciousBetween(Long value1, Long value2) {
            this.addCriterion("is_efficacious between", value1, value2, "isEfficacious");
            return (Criteria)this;
        }

        public Criteria andIsEfficaciousNotBetween(Long value1, Long value2) {
            this.addCriterion("is_efficacious not between", value1, value2, "isEfficacious");
            return (Criteria)this;
        }

        public Criteria andIsDownIsNull() {
            this.addCriterion("is_down is null");
            return (Criteria)this;
        }

        public Criteria andIsDownIsNotNull() {
            this.addCriterion("is_down is not null");
            return (Criteria)this;
        }

        public Criteria andIsDownEqualTo(Long value) {
            this.addCriterion("is_down =", value, "isDown");
            return (Criteria)this;
        }

        public Criteria andIsDownNotEqualTo(Long value) {
            this.addCriterion("is_down <>", value, "isDown");
            return (Criteria)this;
        }

        public Criteria andIsDownGreaterThan(Long value) {
            this.addCriterion("is_down >", value, "isDown");
            return (Criteria)this;
        }

        public Criteria andIsDownGreaterThanOrEqualTo(Long value) {
            this.addCriterion("is_down >=", value, "isDown");
            return (Criteria)this;
        }

        public Criteria andIsDownLessThan(Long value) {
            this.addCriterion("is_down <", value, "isDown");
            return (Criteria)this;
        }

        public Criteria andIsDownLessThanOrEqualTo(Long value) {
            this.addCriterion("is_down <=", value, "isDown");
            return (Criteria)this;
        }

        public Criteria andIsDownLike(String value) {
            this.addCriterion("is_down like", value, "isDown");
            return (Criteria)this;
        }

        public Criteria andIsDownNotLike(String value) {
            this.addCriterion("is_down not like", value, "isDown");
            return (Criteria)this;
        }        public Criteria andIsDownIn(List<Long> values) {
            this.addCriterion("is_down in", values, "isDown");
            return (Criteria)this;
        }

        public Criteria andIsDownNotIn(List<Long> values) {
            this.addCriterion("is_down not in", values, "isDown");
            return (Criteria)this;
        }

        public Criteria andIsDownBetween(Long value1, Long value2) {
            this.addCriterion("is_down between", value1, value2, "isDown");
            return (Criteria)this;
        }

        public Criteria andIsDownNotBetween(Long value1, Long value2) {
            this.addCriterion("is_down not between", value1, value2, "isDown");
            return (Criteria)this;
        }

        public Criteria andStoreIdIsNull() {
            this.addCriterion("store_id is null");
            return (Criteria)this;
        }

        public Criteria andStoreIdIsNotNull() {
            this.addCriterion("store_id is not null");
            return (Criteria)this;
        }

        public Criteria andStoreIdEqualTo(Long value) {
            this.addCriterion("store_id =", value, "storeId");
            return (Criteria)this;
        }

        public Criteria andStoreIdNotEqualTo(Long value) {
            this.addCriterion("store_id <>", value, "storeId");
            return (Criteria)this;
        }

        public Criteria andStoreIdGreaterThan(Long value) {
            this.addCriterion("store_id >", value, "storeId");
            return (Criteria)this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("store_id >=", value, "storeId");
            return (Criteria)this;
        }

        public Criteria andStoreIdLessThan(Long value) {
            this.addCriterion("store_id <", value, "storeId");
            return (Criteria)this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(Long value) {
            this.addCriterion("store_id <=", value, "storeId");
            return (Criteria)this;
        }

        public Criteria andStoreIdLike(String value) {
            this.addCriterion("store_id like", value, "storeId");
            return (Criteria)this;
        }

        public Criteria andStoreIdNotLike(String value) {
            this.addCriterion("store_id not like", value, "storeId");
            return (Criteria)this;
        }        public Criteria andStoreIdIn(List<Long> values) {
            this.addCriterion("store_id in", values, "storeId");
            return (Criteria)this;
        }

        public Criteria andStoreIdNotIn(List<Long> values) {
            this.addCriterion("store_id not in", values, "storeId");
            return (Criteria)this;
        }

        public Criteria andStoreIdBetween(Long value1, Long value2) {
            this.addCriterion("store_id between", value1, value2, "storeId");
            return (Criteria)this;
        }

        public Criteria andStoreIdNotBetween(Long value1, Long value2) {
            this.addCriterion("store_id not between", value1, value2, "storeId");
            return (Criteria)this;
        }

        public Criteria andClicksIsNull() {
            this.addCriterion("clicks is null");
            return (Criteria)this;
        }

        public Criteria andClicksIsNotNull() {
            this.addCriterion("clicks is not null");
            return (Criteria)this;
        }

        public Criteria andClicksEqualTo(Long value) {
            this.addCriterion("clicks =", value, "clicks");
            return (Criteria)this;
        }

        public Criteria andClicksNotEqualTo(Long value) {
            this.addCriterion("clicks <>", value, "clicks");
            return (Criteria)this;
        }

        public Criteria andClicksGreaterThan(Long value) {
            this.addCriterion("clicks >", value, "clicks");
            return (Criteria)this;
        }

        public Criteria andClicksGreaterThanOrEqualTo(Long value) {
            this.addCriterion("clicks >=", value, "clicks");
            return (Criteria)this;
        }

        public Criteria andClicksLessThan(Long value) {
            this.addCriterion("clicks <", value, "clicks");
            return (Criteria)this;
        }

        public Criteria andClicksLessThanOrEqualTo(Long value) {
            this.addCriterion("clicks <=", value, "clicks");
            return (Criteria)this;
        }

        public Criteria andClicksLike(String value) {
            this.addCriterion("clicks like", value, "clicks");
            return (Criteria)this;
        }

        public Criteria andClicksNotLike(String value) {
            this.addCriterion("clicks not like", value, "clicks");
            return (Criteria)this;
        }        public Criteria andClicksIn(List<Long> values) {
            this.addCriterion("clicks in", values, "clicks");
            return (Criteria)this;
        }

        public Criteria andClicksNotIn(List<Long> values) {
            this.addCriterion("clicks not in", values, "clicks");
            return (Criteria)this;
        }

        public Criteria andClicksBetween(Long value1, Long value2) {
            this.addCriterion("clicks between", value1, value2, "clicks");
            return (Criteria)this;
        }

        public Criteria andClicksNotBetween(Long value1, Long value2) {
            this.addCriterion("clicks not between", value1, value2, "clicks");
            return (Criteria)this;
        }

        public Criteria andIsClosedIsNull() {
            this.addCriterion("is_closed is null");
            return (Criteria)this;
        }

        public Criteria andIsClosedIsNotNull() {
            this.addCriterion("is_closed is not null");
            return (Criteria)this;
        }

        public Criteria andIsClosedEqualTo(Long value) {
            this.addCriterion("is_closed =", value, "isClosed");
            return (Criteria)this;
        }

        public Criteria andIsClosedNotEqualTo(Long value) {
            this.addCriterion("is_closed <>", value, "isClosed");
            return (Criteria)this;
        }

        public Criteria andIsClosedGreaterThan(Long value) {
            this.addCriterion("is_closed >", value, "isClosed");
            return (Criteria)this;
        }

        public Criteria andIsClosedGreaterThanOrEqualTo(Long value) {
            this.addCriterion("is_closed >=", value, "isClosed");
            return (Criteria)this;
        }

        public Criteria andIsClosedLessThan(Long value) {
            this.addCriterion("is_closed <", value, "isClosed");
            return (Criteria)this;
        }

        public Criteria andIsClosedLessThanOrEqualTo(Long value) {
            this.addCriterion("is_closed <=", value, "isClosed");
            return (Criteria)this;
        }

        public Criteria andIsClosedLike(String value) {
            this.addCriterion("is_closed like", value, "isClosed");
            return (Criteria)this;
        }

        public Criteria andIsClosedNotLike(String value) {
            this.addCriterion("is_closed not like", value, "isClosed");
            return (Criteria)this;
        }        public Criteria andIsClosedIn(List<Long> values) {
            this.addCriterion("is_closed in", values, "isClosed");
            return (Criteria)this;
        }

        public Criteria andIsClosedNotIn(List<Long> values) {
            this.addCriterion("is_closed not in", values, "isClosed");
            return (Criteria)this;
        }

        public Criteria andIsClosedBetween(Long value1, Long value2) {
            this.addCriterion("is_closed between", value1, value2, "isClosed");
            return (Criteria)this;
        }

        public Criteria andIsClosedNotBetween(Long value1, Long value2) {
            this.addCriterion("is_closed not between", value1, value2, "isClosed");
            return (Criteria)this;
        }

        public Criteria andGoodsStatusIsNull() {
            this.addCriterion("goods_status is null");
            return (Criteria)this;
        }

        public Criteria andGoodsStatusIsNotNull() {
            this.addCriterion("goods_status is not null");
            return (Criteria)this;
        }

        public Criteria andGoodsStatusEqualTo(Integer value) {
            this.addCriterion("goods_status =", value, "goodsStatus");
            return (Criteria)this;
        }

        public Criteria andGoodsStatusNotEqualTo(Integer value) {
            this.addCriterion("goods_status <>", value, "goodsStatus");
            return (Criteria)this;
        }

        public Criteria andGoodsStatusGreaterThan(Integer value) {
            this.addCriterion("goods_status >", value, "goodsStatus");
            return (Criteria)this;
        }

        public Criteria andGoodsStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("goods_status >=", value, "goodsStatus");
            return (Criteria)this;
        }

        public Criteria andGoodsStatusLessThan(Integer value) {
            this.addCriterion("goods_status <", value, "goodsStatus");
            return (Criteria)this;
        }

        public Criteria andGoodsStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("goods_status <=", value, "goodsStatus");
            return (Criteria)this;
        }

        public Criteria andGoodsStatusLike(String value) {
            this.addCriterion("goods_status like", value, "goodsStatus");
            return (Criteria)this;
        }

        public Criteria andGoodsStatusNotLike(String value) {
            this.addCriterion("goods_status not like", value, "goodsStatus");
            return (Criteria)this;
        }        public Criteria andGoodsStatusIn(List<Integer> values) {
            this.addCriterion("goods_status in", values, "goodsStatus");
            return (Criteria)this;
        }

        public Criteria andGoodsStatusNotIn(List<Integer> values) {
            this.addCriterion("goods_status not in", values, "goodsStatus");
            return (Criteria)this;
        }

        public Criteria andGoodsStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("goods_status between", value1, value2, "goodsStatus");
            return (Criteria)this;
        }

        public Criteria andGoodsStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("goods_status not between", value1, value2, "goodsStatus");
            return (Criteria)this;
        }

        public Criteria andGoodsNoIsNull() {
            this.addCriterion("goods_no is null");
            return (Criteria)this;
        }

        public Criteria andGoodsNoIsNotNull() {
            this.addCriterion("goods_no is not null");
            return (Criteria)this;
        }

        public Criteria andGoodsNoEqualTo(String value) {
            this.addCriterion("goods_no =", value, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoNotEqualTo(String value) {
            this.addCriterion("goods_no <>", value, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoGreaterThan(String value) {
            this.addCriterion("goods_no >", value, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoGreaterThanOrEqualTo(String value) {
            this.addCriterion("goods_no >=", value, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoLessThan(String value) {
            this.addCriterion("goods_no <", value, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoLessThanOrEqualTo(String value) {
            this.addCriterion("goods_no <=", value, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoLike(String value) {
            this.addCriterion("goods_no like", value, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoNotLike(String value) {
            this.addCriterion("goods_no not like", value, "goodsNo");
            return (Criteria)this;
        }        public Criteria andGoodsNoIn(List<String> values) {
            this.addCriterion("goods_no in", values, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoNotIn(List<String> values) {
            this.addCriterion("goods_no not in", values, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoBetween(String value1, String value2) {
            this.addCriterion("goods_no between", value1, value2, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andGoodsNoNotBetween(String value1, String value2) {
            this.addCriterion("goods_no not between", value1, value2, "goodsNo");
            return (Criteria)this;
        }

        public Criteria andSortOrderIsNull() {
            this.addCriterion("sort_order is null");
            return (Criteria)this;
        }

        public Criteria andSortOrderIsNotNull() {
            this.addCriterion("sort_order is not null");
            return (Criteria)this;
        }

        public Criteria andSortOrderEqualTo(Long value) {
            this.addCriterion("sort_order =", value, "sortOrder");
            return (Criteria)this;
        }

        public Criteria andSortOrderNotEqualTo(Long value) {
            this.addCriterion("sort_order <>", value, "sortOrder");
            return (Criteria)this;
        }

        public Criteria andSortOrderGreaterThan(Long value) {
            this.addCriterion("sort_order >", value, "sortOrder");
            return (Criteria)this;
        }

        public Criteria andSortOrderGreaterThanOrEqualTo(Long value) {
            this.addCriterion("sort_order >=", value, "sortOrder");
            return (Criteria)this;
        }

        public Criteria andSortOrderLessThan(Long value) {
            this.addCriterion("sort_order <", value, "sortOrder");
            return (Criteria)this;
        }

        public Criteria andSortOrderLessThanOrEqualTo(Long value) {
            this.addCriterion("sort_order <=", value, "sortOrder");
            return (Criteria)this;
        }

        public Criteria andSortOrderLike(String value) {
            this.addCriterion("sort_order like", value, "sortOrder");
            return (Criteria)this;
        }

        public Criteria andSortOrderNotLike(String value) {
            this.addCriterion("sort_order not like", value, "sortOrder");
            return (Criteria)this;
        }        public Criteria andSortOrderIn(List<Long> values) {
            this.addCriterion("sort_order in", values, "sortOrder");
            return (Criteria)this;
        }

        public Criteria andSortOrderNotIn(List<Long> values) {
            this.addCriterion("sort_order not in", values, "sortOrder");
            return (Criteria)this;
        }

        public Criteria andSortOrderBetween(Long value1, Long value2) {
            this.addCriterion("sort_order between", value1, value2, "sortOrder");
            return (Criteria)this;
        }

        public Criteria andSortOrderNotBetween(Long value1, Long value2) {
            this.addCriterion("sort_order not between", value1, value2, "sortOrder");
            return (Criteria)this;
        }

        public Criteria andInStoreSortOrderIsNull() {
            this.addCriterion("in_store_sort_order is null");
            return (Criteria)this;
        }

        public Criteria andInStoreSortOrderIsNotNull() {
            this.addCriterion("in_store_sort_order is not null");
            return (Criteria)this;
        }

        public Criteria andInStoreSortOrderEqualTo(Long value) {
            this.addCriterion("in_store_sort_order =", value, "inStoreSortOrder");
            return (Criteria)this;
        }

        public Criteria andInStoreSortOrderNotEqualTo(Long value) {
            this.addCriterion("in_store_sort_order <>", value, "inStoreSortOrder");
            return (Criteria)this;
        }

        public Criteria andInStoreSortOrderGreaterThan(Long value) {
            this.addCriterion("in_store_sort_order >", value, "inStoreSortOrder");
            return (Criteria)this;
        }

        public Criteria andInStoreSortOrderGreaterThanOrEqualTo(Long value) {
            this.addCriterion("in_store_sort_order >=", value, "inStoreSortOrder");
            return (Criteria)this;
        }

        public Criteria andInStoreSortOrderLessThan(Long value) {
            this.addCriterion("in_store_sort_order <", value, "inStoreSortOrder");
            return (Criteria)this;
        }

        public Criteria andInStoreSortOrderLessThanOrEqualTo(Long value) {
            this.addCriterion("in_store_sort_order <=", value, "inStoreSortOrder");
            return (Criteria)this;
        }

        public Criteria andInStoreSortOrderLike(String value) {
            this.addCriterion("in_store_sort_order like", value, "inStoreSortOrder");
            return (Criteria)this;
        }

        public Criteria andInStoreSortOrderNotLike(String value) {
            this.addCriterion("in_store_sort_order not like", value, "inStoreSortOrder");
            return (Criteria)this;
        }        public Criteria andInStoreSortOrderIn(List<Long> values) {
            this.addCriterion("in_store_sort_order in", values, "inStoreSortOrder");
            return (Criteria)this;
        }

        public Criteria andInStoreSortOrderNotIn(List<Long> values) {
            this.addCriterion("in_store_sort_order not in", values, "inStoreSortOrder");
            return (Criteria)this;
        }

        public Criteria andInStoreSortOrderBetween(Long value1, Long value2) {
            this.addCriterion("in_store_sort_order between", value1, value2, "inStoreSortOrder");
            return (Criteria)this;
        }

        public Criteria andInStoreSortOrderNotBetween(Long value1, Long value2) {
            this.addCriterion("in_store_sort_order not between", value1, value2, "inStoreSortOrder");
            return (Criteria)this;
        }

        public Criteria andNumberTradableGoodsIsNull() {
            this.addCriterion("number_tradable_goods is null");
            return (Criteria)this;
        }

        public Criteria andNumberTradableGoodsIsNotNull() {
            this.addCriterion("number_tradable_goods is not null");
            return (Criteria)this;
        }

        public Criteria andNumberTradableGoodsEqualTo(Long value) {
            this.addCriterion("number_tradable_goods =", value, "numberTradableGoods");
            return (Criteria)this;
        }

        public Criteria andNumberTradableGoodsNotEqualTo(Long value) {
            this.addCriterion("number_tradable_goods <>", value, "numberTradableGoods");
            return (Criteria)this;
        }

        public Criteria andNumberTradableGoodsGreaterThan(Long value) {
            this.addCriterion("number_tradable_goods >", value, "numberTradableGoods");
            return (Criteria)this;
        }

        public Criteria andNumberTradableGoodsGreaterThanOrEqualTo(Long value) {
            this.addCriterion("number_tradable_goods >=", value, "numberTradableGoods");
            return (Criteria)this;
        }

        public Criteria andNumberTradableGoodsLessThan(Long value) {
            this.addCriterion("number_tradable_goods <", value, "numberTradableGoods");
            return (Criteria)this;
        }

        public Criteria andNumberTradableGoodsLessThanOrEqualTo(Long value) {
            this.addCriterion("number_tradable_goods <=", value, "numberTradableGoods");
            return (Criteria)this;
        }

        public Criteria andNumberTradableGoodsLike(String value) {
            this.addCriterion("number_tradable_goods like", value, "numberTradableGoods");
            return (Criteria)this;
        }

        public Criteria andNumberTradableGoodsNotLike(String value) {
            this.addCriterion("number_tradable_goods not like", value, "numberTradableGoods");
            return (Criteria)this;
        }        public Criteria andNumberTradableGoodsIn(List<Long> values) {
            this.addCriterion("number_tradable_goods in", values, "numberTradableGoods");
            return (Criteria)this;
        }

        public Criteria andNumberTradableGoodsNotIn(List<Long> values) {
            this.addCriterion("number_tradable_goods not in", values, "numberTradableGoods");
            return (Criteria)this;
        }

        public Criteria andNumberTradableGoodsBetween(Long value1, Long value2) {
            this.addCriterion("number_tradable_goods between", value1, value2, "numberTradableGoods");
            return (Criteria)this;
        }

        public Criteria andNumberTradableGoodsNotBetween(Long value1, Long value2) {
            this.addCriterion("number_tradable_goods not between", value1, value2, "numberTradableGoods");
            return (Criteria)this;
        }

        public Criteria andNotNumberTradableGoodsIsNull() {
            this.addCriterion("not_number_tradable_goods is null");
            return (Criteria)this;
        }

        public Criteria andNotNumberTradableGoodsIsNotNull() {
            this.addCriterion("not_number_tradable_goods is not null");
            return (Criteria)this;
        }

        public Criteria andNotNumberTradableGoodsEqualTo(Long value) {
            this.addCriterion("not_number_tradable_goods =", value, "notNumberTradableGoods");
            return (Criteria)this;
        }

        public Criteria andNotNumberTradableGoodsNotEqualTo(Long value) {
            this.addCriterion("not_number_tradable_goods <>", value, "notNumberTradableGoods");
            return (Criteria)this;
        }

        public Criteria andNotNumberTradableGoodsGreaterThan(Long value) {
            this.addCriterion("not_number_tradable_goods >", value, "notNumberTradableGoods");
            return (Criteria)this;
        }

        public Criteria andNotNumberTradableGoodsGreaterThanOrEqualTo(Long value) {
            this.addCriterion("not_number_tradable_goods >=", value, "notNumberTradableGoods");
            return (Criteria)this;
        }

        public Criteria andNotNumberTradableGoodsLessThan(Long value) {
            this.addCriterion("not_number_tradable_goods <", value, "notNumberTradableGoods");
            return (Criteria)this;
        }

        public Criteria andNotNumberTradableGoodsLessThanOrEqualTo(Long value) {
            this.addCriterion("not_number_tradable_goods <=", value, "notNumberTradableGoods");
            return (Criteria)this;
        }

        public Criteria andNotNumberTradableGoodsLike(String value) {
            this.addCriterion("not_number_tradable_goods like", value, "notNumberTradableGoods");
            return (Criteria)this;
        }

        public Criteria andNotNumberTradableGoodsNotLike(String value) {
            this.addCriterion("not_number_tradable_goods not like", value, "notNumberTradableGoods");
            return (Criteria)this;
        }        public Criteria andNotNumberTradableGoodsIn(List<Long> values) {
            this.addCriterion("not_number_tradable_goods in", values, "notNumberTradableGoods");
            return (Criteria)this;
        }

        public Criteria andNotNumberTradableGoodsNotIn(List<Long> values) {
            this.addCriterion("not_number_tradable_goods not in", values, "notNumberTradableGoods");
            return (Criteria)this;
        }

        public Criteria andNotNumberTradableGoodsBetween(Long value1, Long value2) {
            this.addCriterion("not_number_tradable_goods between", value1, value2, "notNumberTradableGoods");
            return (Criteria)this;
        }

        public Criteria andNotNumberTradableGoodsNotBetween(Long value1, Long value2) {
            this.addCriterion("not_number_tradable_goods not between", value1, value2, "notNumberTradableGoods");
            return (Criteria)this;
        }

        public Criteria andWebSiteIsNull() {
            this.addCriterion("web_site is null");
            return (Criteria)this;
        }

        public Criteria andWebSiteIsNotNull() {
            this.addCriterion("web_site is not null");
            return (Criteria)this;
        }

        public Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("web_site =", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("web_site <>", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("web_site >", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("web_site >=", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteLessThan(String value) {
            this.addCriterion("web_site <", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("web_site <=", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteLike(String value) {
            this.addCriterion("web_site like", value, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteNotLike(String value) {
            this.addCriterion("web_site not like", value, "webSite");
            return (Criteria)this;
        }        public Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("web_site in", values, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("web_site not in", values, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("web_site between", value1, value2, "webSite");
            return (Criteria)this;
        }

        public Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("web_site not between", value1, value2, "webSite");
            return (Criteria)this;
        }

        public Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (Criteria)this;
        }

        public Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (Criteria)this;
        }        public Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (Criteria)this;
        }

        public Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (Criteria)this;
        }

        public Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (Criteria)this;
        }        public Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (Criteria)this;
        }

        public Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (Criteria)this;
        }

        public Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (Criteria)this;
        }        public Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (Criteria)this;
        }

        public Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (Criteria)this;
        }

        public Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (Criteria)this;
        }        public Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (Criteria)this;
        }

        public Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (Criteria)this;
        }

        public Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (Criteria)this;
        }        public Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (Criteria)this;
        }

        public Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (Criteria)this;
        }

        public Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (Criteria)this;
        }        public Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (Criteria)this;
        }

        public Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (Criteria)this;
        }

        public Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (Criteria)this;
        }        public Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (Criteria)this;
        }

        public Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (Criteria)this;
        }

        public Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (Criteria)this;
        }        public Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (Criteria)this;
        }

        public Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (Criteria)this;
        }

        public Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (Criteria)this;
        }        public Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (Criteria)this;
        }

        public Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (Criteria)this;
        }

        public Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (Criteria)this;
        }

        public Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (Criteria)this;
        }        public Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (Criteria)this;
        }

        public Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (Criteria)this;
        }

        public Criteria andLoadDateIsNull() {
            this.addCriterion("load_date is null");
            return (Criteria)this;
        }

        public Criteria andLoadDateIsNotNull() {
            this.addCriterion("load_date is not null");
            return (Criteria)this;
        }

        public Criteria andLoadDateEqualTo(Date value) {
            this.addCriterion("load_date =", value, "loadDate");
            return (Criteria)this;
        }

        public Criteria andLoadDateNotEqualTo(Date value) {
            this.addCriterion("load_date <>", value, "loadDate");
            return (Criteria)this;
        }

        public Criteria andLoadDateGreaterThan(Date value) {
            this.addCriterion("load_date >", value, "loadDate");
            return (Criteria)this;
        }

        public Criteria andLoadDateGreaterThanOrEqualTo(Date value) {
            this.addCriterion("load_date >=", value, "loadDate");
            return (Criteria)this;
        }

        public Criteria andLoadDateLessThan(Date value) {
            this.addCriterion("load_date <", value, "loadDate");
            return (Criteria)this;
        }

        public Criteria andLoadDateLessThanOrEqualTo(Date value) {
            this.addCriterion("load_date <=", value, "loadDate");
            return (Criteria)this;
        }

        public Criteria andLoadDateLike(String value) {
            this.addCriterion("load_date like", value, "loadDate");
            return (Criteria)this;
        }

        public Criteria andLoadDateNotLike(String value) {
            this.addCriterion("load_date not like", value, "loadDate");
            return (Criteria)this;
        }        public Criteria andLoadDateIn(List<Date> values) {
            this.addCriterion("load_date in", values, "loadDate");
            return (Criteria)this;
        }

        public Criteria andLoadDateNotIn(List<Date> values) {
            this.addCriterion("load_date not in", values, "loadDate");
            return (Criteria)this;
        }

        public Criteria andLoadDateBetween(Date value1, Date value2) {
            this.addCriterion("load_date between", value1, value2, "loadDate");
            return (Criteria)this;
        }

        public Criteria andLoadDateNotBetween(Date value1, Date value2) {
            this.addCriterion("load_date not between", value1, value2, "loadDate");
            return (Criteria)this;
        }

        public Criteria andImAliwwIsNull() {
            this.addCriterion("im_aliww is null");
            return (Criteria)this;
        }

        public Criteria andImAliwwIsNotNull() {
            this.addCriterion("im_aliww is not null");
            return (Criteria)this;
        }

        public Criteria andImAliwwEqualTo(String value) {
            this.addCriterion("im_aliww =", value, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwNotEqualTo(String value) {
            this.addCriterion("im_aliww <>", value, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwGreaterThan(String value) {
            this.addCriterion("im_aliww >", value, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_aliww >=", value, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwLessThan(String value) {
            this.addCriterion("im_aliww <", value, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwLessThanOrEqualTo(String value) {
            this.addCriterion("im_aliww <=", value, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwLike(String value) {
            this.addCriterion("im_aliww like", value, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwNotLike(String value) {
            this.addCriterion("im_aliww not like", value, "imAliww");
            return (Criteria)this;
        }        public Criteria andImAliwwIn(List<String> values) {
            this.addCriterion("im_aliww in", values, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwNotIn(List<String> values) {
            this.addCriterion("im_aliww not in", values, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwBetween(String value1, String value2) {
            this.addCriterion("im_aliww between", value1, value2, "imAliww");
            return (Criteria)this;
        }

        public Criteria andImAliwwNotBetween(String value1, String value2) {
            this.addCriterion("im_aliww not between", value1, value2, "imAliww");
            return (Criteria)this;
        }

        public Criteria andGoodsServicesIsNull() {
            this.addCriterion("goods_services is null");
            return (Criteria)this;
        }

        public Criteria andGoodsServicesIsNotNull() {
            this.addCriterion("goods_services is not null");
            return (Criteria)this;
        }

        public Criteria andGoodsServicesEqualTo(String value) {
            this.addCriterion("goods_services =", value, "goodsServices");
            return (Criteria)this;
        }

        public Criteria andGoodsServicesNotEqualTo(String value) {
            this.addCriterion("goods_services <>", value, "goodsServices");
            return (Criteria)this;
        }

        public Criteria andGoodsServicesGreaterThan(String value) {
            this.addCriterion("goods_services >", value, "goodsServices");
            return (Criteria)this;
        }

        public Criteria andGoodsServicesGreaterThanOrEqualTo(String value) {
            this.addCriterion("goods_services >=", value, "goodsServices");
            return (Criteria)this;
        }

        public Criteria andGoodsServicesLessThan(String value) {
            this.addCriterion("goods_services <", value, "goodsServices");
            return (Criteria)this;
        }

        public Criteria andGoodsServicesLessThanOrEqualTo(String value) {
            this.addCriterion("goods_services <=", value, "goodsServices");
            return (Criteria)this;
        }

        public Criteria andGoodsServicesLike(String value) {
            this.addCriterion("goods_services like", value, "goodsServices");
            return (Criteria)this;
        }

        public Criteria andGoodsServicesNotLike(String value) {
            this.addCriterion("goods_services not like", value, "goodsServices");
            return (Criteria)this;
        }        public Criteria andGoodsServicesIn(List<String> values) {
            this.addCriterion("goods_services in", values, "goodsServices");
            return (Criteria)this;
        }

        public Criteria andGoodsServicesNotIn(List<String> values) {
            this.addCriterion("goods_services not in", values, "goodsServices");
            return (Criteria)this;
        }

        public Criteria andGoodsServicesBetween(String value1, String value2) {
            this.addCriterion("goods_services between", value1, value2, "goodsServices");
            return (Criteria)this;
        }

        public Criteria andGoodsServicesNotBetween(String value1, String value2) {
            this.addCriterion("goods_services not between", value1, value2, "goodsServices");
            return (Criteria)this;
        }

        public Criteria andIsShowcaseIsNull() {
            this.addCriterion("is_showcase is null");
            return (Criteria)this;
        }

        public Criteria andIsShowcaseIsNotNull() {
            this.addCriterion("is_showcase is not null");
            return (Criteria)this;
        }

        public Criteria andIsShowcaseEqualTo(Integer value) {
            this.addCriterion("is_showcase =", value, "isShowcase");
            return (Criteria)this;
        }

        public Criteria andIsShowcaseNotEqualTo(Integer value) {
            this.addCriterion("is_showcase <>", value, "isShowcase");
            return (Criteria)this;
        }

        public Criteria andIsShowcaseGreaterThan(Integer value) {
            this.addCriterion("is_showcase >", value, "isShowcase");
            return (Criteria)this;
        }

        public Criteria andIsShowcaseGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_showcase >=", value, "isShowcase");
            return (Criteria)this;
        }

        public Criteria andIsShowcaseLessThan(Integer value) {
            this.addCriterion("is_showcase <", value, "isShowcase");
            return (Criteria)this;
        }

        public Criteria andIsShowcaseLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_showcase <=", value, "isShowcase");
            return (Criteria)this;
        }

        public Criteria andIsShowcaseLike(String value) {
            this.addCriterion("is_showcase like", value, "isShowcase");
            return (Criteria)this;
        }

        public Criteria andIsShowcaseNotLike(String value) {
            this.addCriterion("is_showcase not like", value, "isShowcase");
            return (Criteria)this;
        }        public Criteria andIsShowcaseIn(List<Integer> values) {
            this.addCriterion("is_showcase in", values, "isShowcase");
            return (Criteria)this;
        }

        public Criteria andIsShowcaseNotIn(List<Integer> values) {
            this.addCriterion("is_showcase not in", values, "isShowcase");
            return (Criteria)this;
        }

        public Criteria andIsShowcaseBetween(Integer value1, Integer value2) {
            this.addCriterion("is_showcase between", value1, value2, "isShowcase");
            return (Criteria)this;
        }

        public Criteria andIsShowcaseNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_showcase not between", value1, value2, "isShowcase");
            return (Criteria)this;
        }

        public Criteria andIsStandardIsNull() {
            this.addCriterion("is_standard is null");
            return (Criteria)this;
        }

        public Criteria andIsStandardIsNotNull() {
            this.addCriterion("is_standard is not null");
            return (Criteria)this;
        }

        public Criteria andIsStandardEqualTo(Integer value) {
            this.addCriterion("is_standard =", value, "isStandard");
            return (Criteria)this;
        }

        public Criteria andIsStandardNotEqualTo(Integer value) {
            this.addCriterion("is_standard <>", value, "isStandard");
            return (Criteria)this;
        }

        public Criteria andIsStandardGreaterThan(Integer value) {
            this.addCriterion("is_standard >", value, "isStandard");
            return (Criteria)this;
        }

        public Criteria andIsStandardGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_standard >=", value, "isStandard");
            return (Criteria)this;
        }

        public Criteria andIsStandardLessThan(Integer value) {
            this.addCriterion("is_standard <", value, "isStandard");
            return (Criteria)this;
        }

        public Criteria andIsStandardLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_standard <=", value, "isStandard");
            return (Criteria)this;
        }

        public Criteria andIsStandardLike(String value) {
            this.addCriterion("is_standard like", value, "isStandard");
            return (Criteria)this;
        }

        public Criteria andIsStandardNotLike(String value) {
            this.addCriterion("is_standard not like", value, "isStandard");
            return (Criteria)this;
        }        public Criteria andIsStandardIn(List<Integer> values) {
            this.addCriterion("is_standard in", values, "isStandard");
            return (Criteria)this;
        }

        public Criteria andIsStandardNotIn(List<Integer> values) {
            this.addCriterion("is_standard not in", values, "isStandard");
            return (Criteria)this;
        }

        public Criteria andIsStandardBetween(Integer value1, Integer value2) {
            this.addCriterion("is_standard between", value1, value2, "isStandard");
            return (Criteria)this;
        }

        public Criteria andIsStandardNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_standard not between", value1, value2, "isStandard");
            return (Criteria)this;
        }

        public Criteria andTitleIndexIsNull() {
            this.addCriterion("title_index is null");
            return (Criteria)this;
        }

        public Criteria andTitleIndexIsNotNull() {
            this.addCriterion("title_index is not null");
            return (Criteria)this;
        }

        public Criteria andTitleIndexEqualTo(String value) {
            this.addCriterion("title_index =", value, "titleIndex");
            return (Criteria)this;
        }

        public Criteria andTitleIndexNotEqualTo(String value) {
            this.addCriterion("title_index <>", value, "titleIndex");
            return (Criteria)this;
        }

        public Criteria andTitleIndexGreaterThan(String value) {
            this.addCriterion("title_index >", value, "titleIndex");
            return (Criteria)this;
        }

        public Criteria andTitleIndexGreaterThanOrEqualTo(String value) {
            this.addCriterion("title_index >=", value, "titleIndex");
            return (Criteria)this;
        }

        public Criteria andTitleIndexLessThan(String value) {
            this.addCriterion("title_index <", value, "titleIndex");
            return (Criteria)this;
        }

        public Criteria andTitleIndexLessThanOrEqualTo(String value) {
            this.addCriterion("title_index <=", value, "titleIndex");
            return (Criteria)this;
        }

        public Criteria andTitleIndexLike(String value) {
            this.addCriterion("title_index like", value, "titleIndex");
            return (Criteria)this;
        }

        public Criteria andTitleIndexNotLike(String value) {
            this.addCriterion("title_index not like", value, "titleIndex");
            return (Criteria)this;
        }        public Criteria andTitleIndexIn(List<String> values) {
            this.addCriterion("title_index in", values, "titleIndex");
            return (Criteria)this;
        }

        public Criteria andTitleIndexNotIn(List<String> values) {
            this.addCriterion("title_index not in", values, "titleIndex");
            return (Criteria)this;
        }

        public Criteria andTitleIndexBetween(String value1, String value2) {
            this.addCriterion("title_index between", value1, value2, "titleIndex");
            return (Criteria)this;
        }

        public Criteria andTitleIndexNotBetween(String value1, String value2) {
            this.addCriterion("title_index not between", value1, value2, "titleIndex");
            return (Criteria)this;
        }

        public Criteria andIsAdminSetPiPriceIsNull() {
            this.addCriterion("is_admin_set_pi_price is null");
            return (Criteria)this;
        }

        public Criteria andIsAdminSetPiPriceIsNotNull() {
            this.addCriterion("is_admin_set_pi_price is not null");
            return (Criteria)this;
        }

        public Criteria andIsAdminSetPiPriceEqualTo(Integer value) {
            this.addCriterion("is_admin_set_pi_price =", value, "isAdminSetPiPrice");
            return (Criteria)this;
        }

        public Criteria andIsAdminSetPiPriceNotEqualTo(Integer value) {
            this.addCriterion("is_admin_set_pi_price <>", value, "isAdminSetPiPrice");
            return (Criteria)this;
        }

        public Criteria andIsAdminSetPiPriceGreaterThan(Integer value) {
            this.addCriterion("is_admin_set_pi_price >", value, "isAdminSetPiPrice");
            return (Criteria)this;
        }

        public Criteria andIsAdminSetPiPriceGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_admin_set_pi_price >=", value, "isAdminSetPiPrice");
            return (Criteria)this;
        }

        public Criteria andIsAdminSetPiPriceLessThan(Integer value) {
            this.addCriterion("is_admin_set_pi_price <", value, "isAdminSetPiPrice");
            return (Criteria)this;
        }

        public Criteria andIsAdminSetPiPriceLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_admin_set_pi_price <=", value, "isAdminSetPiPrice");
            return (Criteria)this;
        }

        public Criteria andIsAdminSetPiPriceLike(String value) {
            this.addCriterion("is_admin_set_pi_price like", value, "isAdminSetPiPrice");
            return (Criteria)this;
        }

        public Criteria andIsAdminSetPiPriceNotLike(String value) {
            this.addCriterion("is_admin_set_pi_price not like", value, "isAdminSetPiPrice");
            return (Criteria)this;
        }        public Criteria andIsAdminSetPiPriceIn(List<Integer> values) {
            this.addCriterion("is_admin_set_pi_price in", values, "isAdminSetPiPrice");
            return (Criteria)this;
        }

        public Criteria andIsAdminSetPiPriceNotIn(List<Integer> values) {
            this.addCriterion("is_admin_set_pi_price not in", values, "isAdminSetPiPrice");
            return (Criteria)this;
        }

        public Criteria andIsAdminSetPiPriceBetween(Integer value1, Integer value2) {
            this.addCriterion("is_admin_set_pi_price between", value1, value2, "isAdminSetPiPrice");
            return (Criteria)this;
        }

        public Criteria andIsAdminSetPiPriceNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_admin_set_pi_price not between", value1, value2, "isAdminSetPiPrice");
            return (Criteria)this;
        }

        public Criteria andIsUserSetPiPriceIsNull() {
            this.addCriterion("is_user_set_pi_price is null");
            return (Criteria)this;
        }

        public Criteria andIsUserSetPiPriceIsNotNull() {
            this.addCriterion("is_user_set_pi_price is not null");
            return (Criteria)this;
        }

        public Criteria andIsUserSetPiPriceEqualTo(Integer value) {
            this.addCriterion("is_user_set_pi_price =", value, "isUserSetPiPrice");
            return (Criteria)this;
        }

        public Criteria andIsUserSetPiPriceNotEqualTo(Integer value) {
            this.addCriterion("is_user_set_pi_price <>", value, "isUserSetPiPrice");
            return (Criteria)this;
        }

        public Criteria andIsUserSetPiPriceGreaterThan(Integer value) {
            this.addCriterion("is_user_set_pi_price >", value, "isUserSetPiPrice");
            return (Criteria)this;
        }

        public Criteria andIsUserSetPiPriceGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_user_set_pi_price >=", value, "isUserSetPiPrice");
            return (Criteria)this;
        }

        public Criteria andIsUserSetPiPriceLessThan(Integer value) {
            this.addCriterion("is_user_set_pi_price <", value, "isUserSetPiPrice");
            return (Criteria)this;
        }

        public Criteria andIsUserSetPiPriceLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_user_set_pi_price <=", value, "isUserSetPiPrice");
            return (Criteria)this;
        }

        public Criteria andIsUserSetPiPriceLike(String value) {
            this.addCriterion("is_user_set_pi_price like", value, "isUserSetPiPrice");
            return (Criteria)this;
        }

        public Criteria andIsUserSetPiPriceNotLike(String value) {
            this.addCriterion("is_user_set_pi_price not like", value, "isUserSetPiPrice");
            return (Criteria)this;
        }        public Criteria andIsUserSetPiPriceIn(List<Integer> values) {
            this.addCriterion("is_user_set_pi_price in", values, "isUserSetPiPrice");
            return (Criteria)this;
        }

        public Criteria andIsUserSetPiPriceNotIn(List<Integer> values) {
            this.addCriterion("is_user_set_pi_price not in", values, "isUserSetPiPrice");
            return (Criteria)this;
        }

        public Criteria andIsUserSetPiPriceBetween(Integer value1, Integer value2) {
            this.addCriterion("is_user_set_pi_price between", value1, value2, "isUserSetPiPrice");
            return (Criteria)this;
        }

        public Criteria andIsUserSetPiPriceNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_user_set_pi_price not between", value1, value2, "isUserSetPiPrice");
            return (Criteria)this;
        }

        public Criteria andIsExcelImpIsNull() {
            this.addCriterion("is_excel_imp is null");
            return (Criteria)this;
        }

        public Criteria andIsExcelImpIsNotNull() {
            this.addCriterion("is_excel_imp is not null");
            return (Criteria)this;
        }

        public Criteria andIsExcelImpEqualTo(Integer value) {
            this.addCriterion("is_excel_imp =", value, "isExcelImp");
            return (Criteria)this;
        }

        public Criteria andIsExcelImpNotEqualTo(Integer value) {
            this.addCriterion("is_excel_imp <>", value, "isExcelImp");
            return (Criteria)this;
        }

        public Criteria andIsExcelImpGreaterThan(Integer value) {
            this.addCriterion("is_excel_imp >", value, "isExcelImp");
            return (Criteria)this;
        }

        public Criteria andIsExcelImpGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_excel_imp >=", value, "isExcelImp");
            return (Criteria)this;
        }

        public Criteria andIsExcelImpLessThan(Integer value) {
            this.addCriterion("is_excel_imp <", value, "isExcelImp");
            return (Criteria)this;
        }

        public Criteria andIsExcelImpLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_excel_imp <=", value, "isExcelImp");
            return (Criteria)this;
        }

        public Criteria andIsExcelImpLike(String value) {
            this.addCriterion("is_excel_imp like", value, "isExcelImp");
            return (Criteria)this;
        }

        public Criteria andIsExcelImpNotLike(String value) {
            this.addCriterion("is_excel_imp not like", value, "isExcelImp");
            return (Criteria)this;
        }        public Criteria andIsExcelImpIn(List<Integer> values) {
            this.addCriterion("is_excel_imp in", values, "isExcelImp");
            return (Criteria)this;
        }

        public Criteria andIsExcelImpNotIn(List<Integer> values) {
            this.addCriterion("is_excel_imp not in", values, "isExcelImp");
            return (Criteria)this;
        }

        public Criteria andIsExcelImpBetween(Integer value1, Integer value2) {
            this.addCriterion("is_excel_imp between", value1, value2, "isExcelImp");
            return (Criteria)this;
        }

        public Criteria andIsExcelImpNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_excel_imp not between", value1, value2, "isExcelImp");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageNameIsNull() {
            this.addCriterion("up_data_package_name is null");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageNameIsNotNull() {
            this.addCriterion("up_data_package_name is not null");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageNameEqualTo(String value) {
            this.addCriterion("up_data_package_name =", value, "upDataPackageName");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageNameNotEqualTo(String value) {
            this.addCriterion("up_data_package_name <>", value, "upDataPackageName");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageNameGreaterThan(String value) {
            this.addCriterion("up_data_package_name >", value, "upDataPackageName");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("up_data_package_name >=", value, "upDataPackageName");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageNameLessThan(String value) {
            this.addCriterion("up_data_package_name <", value, "upDataPackageName");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageNameLessThanOrEqualTo(String value) {
            this.addCriterion("up_data_package_name <=", value, "upDataPackageName");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageNameLike(String value) {
            this.addCriterion("up_data_package_name like", value, "upDataPackageName");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageNameNotLike(String value) {
            this.addCriterion("up_data_package_name not like", value, "upDataPackageName");
            return (Criteria)this;
        }        public Criteria andUpDataPackageNameIn(List<String> values) {
            this.addCriterion("up_data_package_name in", values, "upDataPackageName");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageNameNotIn(List<String> values) {
            this.addCriterion("up_data_package_name not in", values, "upDataPackageName");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageNameBetween(String value1, String value2) {
            this.addCriterion("up_data_package_name between", value1, value2, "upDataPackageName");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageNameNotBetween(String value1, String value2) {
            this.addCriterion("up_data_package_name not between", value1, value2, "upDataPackageName");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageUrlIsNull() {
            this.addCriterion("up_data_package_url is null");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageUrlIsNotNull() {
            this.addCriterion("up_data_package_url is not null");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageUrlEqualTo(String value) {
            this.addCriterion("up_data_package_url =", value, "upDataPackageUrl");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageUrlNotEqualTo(String value) {
            this.addCriterion("up_data_package_url <>", value, "upDataPackageUrl");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageUrlGreaterThan(String value) {
            this.addCriterion("up_data_package_url >", value, "upDataPackageUrl");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("up_data_package_url >=", value, "upDataPackageUrl");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageUrlLessThan(String value) {
            this.addCriterion("up_data_package_url <", value, "upDataPackageUrl");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageUrlLessThanOrEqualTo(String value) {
            this.addCriterion("up_data_package_url <=", value, "upDataPackageUrl");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageUrlLike(String value) {
            this.addCriterion("up_data_package_url like", value, "upDataPackageUrl");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageUrlNotLike(String value) {
            this.addCriterion("up_data_package_url not like", value, "upDataPackageUrl");
            return (Criteria)this;
        }        public Criteria andUpDataPackageUrlIn(List<String> values) {
            this.addCriterion("up_data_package_url in", values, "upDataPackageUrl");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageUrlNotIn(List<String> values) {
            this.addCriterion("up_data_package_url not in", values, "upDataPackageUrl");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageUrlBetween(String value1, String value2) {
            this.addCriterion("up_data_package_url between", value1, value2, "upDataPackageUrl");
            return (Criteria)this;
        }

        public Criteria andUpDataPackageUrlNotBetween(String value1, String value2) {
            this.addCriterion("up_data_package_url not between", value1, value2, "upDataPackageUrl");
            return (Criteria)this;
        }

        public Criteria andIsDataPackageIsNull() {
            this.addCriterion("is_data_package is null");
            return (Criteria)this;
        }

        public Criteria andIsDataPackageIsNotNull() {
            this.addCriterion("is_data_package is not null");
            return (Criteria)this;
        }

        public Criteria andIsDataPackageEqualTo(Integer value) {
            this.addCriterion("is_data_package =", value, "isDataPackage");
            return (Criteria)this;
        }

        public Criteria andIsDataPackageNotEqualTo(Integer value) {
            this.addCriterion("is_data_package <>", value, "isDataPackage");
            return (Criteria)this;
        }

        public Criteria andIsDataPackageGreaterThan(Integer value) {
            this.addCriterion("is_data_package >", value, "isDataPackage");
            return (Criteria)this;
        }

        public Criteria andIsDataPackageGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_data_package >=", value, "isDataPackage");
            return (Criteria)this;
        }

        public Criteria andIsDataPackageLessThan(Integer value) {
            this.addCriterion("is_data_package <", value, "isDataPackage");
            return (Criteria)this;
        }

        public Criteria andIsDataPackageLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_data_package <=", value, "isDataPackage");
            return (Criteria)this;
        }

        public Criteria andIsDataPackageLike(String value) {
            this.addCriterion("is_data_package like", value, "isDataPackage");
            return (Criteria)this;
        }

        public Criteria andIsDataPackageNotLike(String value) {
            this.addCriterion("is_data_package not like", value, "isDataPackage");
            return (Criteria)this;
        }        public Criteria andIsDataPackageIn(List<Integer> values) {
            this.addCriterion("is_data_package in", values, "isDataPackage");
            return (Criteria)this;
        }

        public Criteria andIsDataPackageNotIn(List<Integer> values) {
            this.addCriterion("is_data_package not in", values, "isDataPackage");
            return (Criteria)this;
        }

        public Criteria andIsDataPackageBetween(Integer value1, Integer value2) {
            this.addCriterion("is_data_package between", value1, value2, "isDataPackage");
            return (Criteria)this;
        }

        public Criteria andIsDataPackageNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_data_package not between", value1, value2, "isDataPackage");
            return (Criteria)this;
        }

        public Criteria andIsSetModeIsNull() {
            this.addCriterion("is_set_mode is null");
            return (Criteria)this;
        }

        public Criteria andIsSetModeIsNotNull() {
            this.addCriterion("is_set_mode is not null");
            return (Criteria)this;
        }

        public Criteria andIsSetModeEqualTo(Integer value) {
            this.addCriterion("is_set_mode =", value, "isSetMode");
            return (Criteria)this;
        }

        public Criteria andIsSetModeNotEqualTo(Integer value) {
            this.addCriterion("is_set_mode <>", value, "isSetMode");
            return (Criteria)this;
        }

        public Criteria andIsSetModeGreaterThan(Integer value) {
            this.addCriterion("is_set_mode >", value, "isSetMode");
            return (Criteria)this;
        }

        public Criteria andIsSetModeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_set_mode >=", value, "isSetMode");
            return (Criteria)this;
        }

        public Criteria andIsSetModeLessThan(Integer value) {
            this.addCriterion("is_set_mode <", value, "isSetMode");
            return (Criteria)this;
        }

        public Criteria andIsSetModeLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_set_mode <=", value, "isSetMode");
            return (Criteria)this;
        }

        public Criteria andIsSetModeLike(String value) {
            this.addCriterion("is_set_mode like", value, "isSetMode");
            return (Criteria)this;
        }

        public Criteria andIsSetModeNotLike(String value) {
            this.addCriterion("is_set_mode not like", value, "isSetMode");
            return (Criteria)this;
        }        public Criteria andIsSetModeIn(List<Integer> values) {
            this.addCriterion("is_set_mode in", values, "isSetMode");
            return (Criteria)this;
        }

        public Criteria andIsSetModeNotIn(List<Integer> values) {
            this.addCriterion("is_set_mode not in", values, "isSetMode");
            return (Criteria)this;
        }

        public Criteria andIsSetModeBetween(Integer value1, Integer value2) {
            this.addCriterion("is_set_mode between", value1, value2, "isSetMode");
            return (Criteria)this;
        }

        public Criteria andIsSetModeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_set_mode not between", value1, value2, "isSetMode");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeIdIsNull() {
            this.addCriterion("mode_top_type_id is null");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeIdIsNotNull() {
            this.addCriterion("mode_top_type_id is not null");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeIdEqualTo(Long value) {
            this.addCriterion("mode_top_type_id =", value, "modeTopTypeId");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeIdNotEqualTo(Long value) {
            this.addCriterion("mode_top_type_id <>", value, "modeTopTypeId");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeIdGreaterThan(Long value) {
            this.addCriterion("mode_top_type_id >", value, "modeTopTypeId");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("mode_top_type_id >=", value, "modeTopTypeId");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeIdLessThan(Long value) {
            this.addCriterion("mode_top_type_id <", value, "modeTopTypeId");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeIdLessThanOrEqualTo(Long value) {
            this.addCriterion("mode_top_type_id <=", value, "modeTopTypeId");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeIdLike(String value) {
            this.addCriterion("mode_top_type_id like", value, "modeTopTypeId");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeIdNotLike(String value) {
            this.addCriterion("mode_top_type_id not like", value, "modeTopTypeId");
            return (Criteria)this;
        }        public Criteria andModeTopTypeIdIn(List<Long> values) {
            this.addCriterion("mode_top_type_id in", values, "modeTopTypeId");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeIdNotIn(List<Long> values) {
            this.addCriterion("mode_top_type_id not in", values, "modeTopTypeId");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeIdBetween(Long value1, Long value2) {
            this.addCriterion("mode_top_type_id between", value1, value2, "modeTopTypeId");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeIdNotBetween(Long value1, Long value2) {
            this.addCriterion("mode_top_type_id not between", value1, value2, "modeTopTypeId");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeIsNull() {
            this.addCriterion("mode_top_type is null");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeIsNotNull() {
            this.addCriterion("mode_top_type is not null");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeEqualTo(String value) {
            this.addCriterion("mode_top_type =", value, "modeTopType");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeNotEqualTo(String value) {
            this.addCriterion("mode_top_type <>", value, "modeTopType");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeGreaterThan(String value) {
            this.addCriterion("mode_top_type >", value, "modeTopType");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeGreaterThanOrEqualTo(String value) {
            this.addCriterion("mode_top_type >=", value, "modeTopType");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeLessThan(String value) {
            this.addCriterion("mode_top_type <", value, "modeTopType");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeLessThanOrEqualTo(String value) {
            this.addCriterion("mode_top_type <=", value, "modeTopType");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeLike(String value) {
            this.addCriterion("mode_top_type like", value, "modeTopType");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeNotLike(String value) {
            this.addCriterion("mode_top_type not like", value, "modeTopType");
            return (Criteria)this;
        }        public Criteria andModeTopTypeIn(List<String> values) {
            this.addCriterion("mode_top_type in", values, "modeTopType");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeNotIn(List<String> values) {
            this.addCriterion("mode_top_type not in", values, "modeTopType");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeBetween(String value1, String value2) {
            this.addCriterion("mode_top_type between", value1, value2, "modeTopType");
            return (Criteria)this;
        }

        public Criteria andModeTopTypeNotBetween(String value1, String value2) {
            this.addCriterion("mode_top_type not between", value1, value2, "modeTopType");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeIdIsNull() {
            this.addCriterion("mode_first_type_id is null");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeIdIsNotNull() {
            this.addCriterion("mode_first_type_id is not null");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeIdEqualTo(Long value) {
            this.addCriterion("mode_first_type_id =", value, "modeFirstTypeId");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeIdNotEqualTo(Long value) {
            this.addCriterion("mode_first_type_id <>", value, "modeFirstTypeId");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeIdGreaterThan(Long value) {
            this.addCriterion("mode_first_type_id >", value, "modeFirstTypeId");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("mode_first_type_id >=", value, "modeFirstTypeId");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeIdLessThan(Long value) {
            this.addCriterion("mode_first_type_id <", value, "modeFirstTypeId");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeIdLessThanOrEqualTo(Long value) {
            this.addCriterion("mode_first_type_id <=", value, "modeFirstTypeId");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeIdLike(String value) {
            this.addCriterion("mode_first_type_id like", value, "modeFirstTypeId");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeIdNotLike(String value) {
            this.addCriterion("mode_first_type_id not like", value, "modeFirstTypeId");
            return (Criteria)this;
        }        public Criteria andModeFirstTypeIdIn(List<Long> values) {
            this.addCriterion("mode_first_type_id in", values, "modeFirstTypeId");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeIdNotIn(List<Long> values) {
            this.addCriterion("mode_first_type_id not in", values, "modeFirstTypeId");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeIdBetween(Long value1, Long value2) {
            this.addCriterion("mode_first_type_id between", value1, value2, "modeFirstTypeId");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeIdNotBetween(Long value1, Long value2) {
            this.addCriterion("mode_first_type_id not between", value1, value2, "modeFirstTypeId");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeIsNull() {
            this.addCriterion("mode_first_type is null");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeIsNotNull() {
            this.addCriterion("mode_first_type is not null");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeEqualTo(String value) {
            this.addCriterion("mode_first_type =", value, "modeFirstType");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeNotEqualTo(String value) {
            this.addCriterion("mode_first_type <>", value, "modeFirstType");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeGreaterThan(String value) {
            this.addCriterion("mode_first_type >", value, "modeFirstType");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeGreaterThanOrEqualTo(String value) {
            this.addCriterion("mode_first_type >=", value, "modeFirstType");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeLessThan(String value) {
            this.addCriterion("mode_first_type <", value, "modeFirstType");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeLessThanOrEqualTo(String value) {
            this.addCriterion("mode_first_type <=", value, "modeFirstType");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeLike(String value) {
            this.addCriterion("mode_first_type like", value, "modeFirstType");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeNotLike(String value) {
            this.addCriterion("mode_first_type not like", value, "modeFirstType");
            return (Criteria)this;
        }        public Criteria andModeFirstTypeIn(List<String> values) {
            this.addCriterion("mode_first_type in", values, "modeFirstType");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeNotIn(List<String> values) {
            this.addCriterion("mode_first_type not in", values, "modeFirstType");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeBetween(String value1, String value2) {
            this.addCriterion("mode_first_type between", value1, value2, "modeFirstType");
            return (Criteria)this;
        }

        public Criteria andModeFirstTypeNotBetween(String value1, String value2) {
            this.addCriterion("mode_first_type not between", value1, value2, "modeFirstType");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeIdIsNull() {
            this.addCriterion("mode_second_type_id is null");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeIdIsNotNull() {
            this.addCriterion("mode_second_type_id is not null");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeIdEqualTo(Long value) {
            this.addCriterion("mode_second_type_id =", value, "modeSecondTypeId");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeIdNotEqualTo(Long value) {
            this.addCriterion("mode_second_type_id <>", value, "modeSecondTypeId");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeIdGreaterThan(Long value) {
            this.addCriterion("mode_second_type_id >", value, "modeSecondTypeId");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("mode_second_type_id >=", value, "modeSecondTypeId");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeIdLessThan(Long value) {
            this.addCriterion("mode_second_type_id <", value, "modeSecondTypeId");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeIdLessThanOrEqualTo(Long value) {
            this.addCriterion("mode_second_type_id <=", value, "modeSecondTypeId");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeIdLike(String value) {
            this.addCriterion("mode_second_type_id like", value, "modeSecondTypeId");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeIdNotLike(String value) {
            this.addCriterion("mode_second_type_id not like", value, "modeSecondTypeId");
            return (Criteria)this;
        }        public Criteria andModeSecondTypeIdIn(List<Long> values) {
            this.addCriterion("mode_second_type_id in", values, "modeSecondTypeId");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeIdNotIn(List<Long> values) {
            this.addCriterion("mode_second_type_id not in", values, "modeSecondTypeId");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeIdBetween(Long value1, Long value2) {
            this.addCriterion("mode_second_type_id between", value1, value2, "modeSecondTypeId");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeIdNotBetween(Long value1, Long value2) {
            this.addCriterion("mode_second_type_id not between", value1, value2, "modeSecondTypeId");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeIsNull() {
            this.addCriterion("mode_second_type is null");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeIsNotNull() {
            this.addCriterion("mode_second_type is not null");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeEqualTo(String value) {
            this.addCriterion("mode_second_type =", value, "modeSecondType");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeNotEqualTo(String value) {
            this.addCriterion("mode_second_type <>", value, "modeSecondType");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeGreaterThan(String value) {
            this.addCriterion("mode_second_type >", value, "modeSecondType");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeGreaterThanOrEqualTo(String value) {
            this.addCriterion("mode_second_type >=", value, "modeSecondType");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeLessThan(String value) {
            this.addCriterion("mode_second_type <", value, "modeSecondType");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeLessThanOrEqualTo(String value) {
            this.addCriterion("mode_second_type <=", value, "modeSecondType");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeLike(String value) {
            this.addCriterion("mode_second_type like", value, "modeSecondType");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeNotLike(String value) {
            this.addCriterion("mode_second_type not like", value, "modeSecondType");
            return (Criteria)this;
        }        public Criteria andModeSecondTypeIn(List<String> values) {
            this.addCriterion("mode_second_type in", values, "modeSecondType");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeNotIn(List<String> values) {
            this.addCriterion("mode_second_type not in", values, "modeSecondType");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeBetween(String value1, String value2) {
            this.addCriterion("mode_second_type between", value1, value2, "modeSecondType");
            return (Criteria)this;
        }

        public Criteria andModeSecondTypeNotBetween(String value1, String value2) {
            this.addCriterion("mode_second_type not between", value1, value2, "modeSecondType");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeIsNull() {
            this.addCriterion("last_modify_time is null");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeIsNotNull() {
            this.addCriterion("last_modify_time is not null");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeEqualTo(Date value) {
            this.addCriterion("last_modify_time =", value, "lastModifyTime");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeNotEqualTo(Date value) {
            this.addCriterion("last_modify_time <>", value, "lastModifyTime");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeGreaterThan(Date value) {
            this.addCriterion("last_modify_time >", value, "lastModifyTime");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("last_modify_time >=", value, "lastModifyTime");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeLessThan(Date value) {
            this.addCriterion("last_modify_time <", value, "lastModifyTime");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("last_modify_time <=", value, "lastModifyTime");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeLike(String value) {
            this.addCriterion("last_modify_time like", value, "lastModifyTime");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeNotLike(String value) {
            this.addCriterion("last_modify_time not like", value, "lastModifyTime");
            return (Criteria)this;
        }        public Criteria andLastModifyTimeIn(List<Date> values) {
            this.addCriterion("last_modify_time in", values, "lastModifyTime");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeNotIn(List<Date> values) {
            this.addCriterion("last_modify_time not in", values, "lastModifyTime");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            this.addCriterion("last_modify_time between", value1, value2, "lastModifyTime");
            return (Criteria)this;
        }

        public Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("last_modify_time not between", value1, value2, "lastModifyTime");
            return (Criteria)this;
        }

        public Criteria andIsModTitleIsNull() {
            this.addCriterion("is_mod_title is null");
            return (Criteria)this;
        }

        public Criteria andIsModTitleIsNotNull() {
            this.addCriterion("is_mod_title is not null");
            return (Criteria)this;
        }

        public Criteria andIsModTitleEqualTo(Integer value) {
            this.addCriterion("is_mod_title =", value, "isModTitle");
            return (Criteria)this;
        }

        public Criteria andIsModTitleNotEqualTo(Integer value) {
            this.addCriterion("is_mod_title <>", value, "isModTitle");
            return (Criteria)this;
        }

        public Criteria andIsModTitleGreaterThan(Integer value) {
            this.addCriterion("is_mod_title >", value, "isModTitle");
            return (Criteria)this;
        }

        public Criteria andIsModTitleGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_mod_title >=", value, "isModTitle");
            return (Criteria)this;
        }

        public Criteria andIsModTitleLessThan(Integer value) {
            this.addCriterion("is_mod_title <", value, "isModTitle");
            return (Criteria)this;
        }

        public Criteria andIsModTitleLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_mod_title <=", value, "isModTitle");
            return (Criteria)this;
        }

        public Criteria andIsModTitleLike(String value) {
            this.addCriterion("is_mod_title like", value, "isModTitle");
            return (Criteria)this;
        }

        public Criteria andIsModTitleNotLike(String value) {
            this.addCriterion("is_mod_title not like", value, "isModTitle");
            return (Criteria)this;
        }        public Criteria andIsModTitleIn(List<Integer> values) {
            this.addCriterion("is_mod_title in", values, "isModTitle");
            return (Criteria)this;
        }

        public Criteria andIsModTitleNotIn(List<Integer> values) {
            this.addCriterion("is_mod_title not in", values, "isModTitle");
            return (Criteria)this;
        }

        public Criteria andIsModTitleBetween(Integer value1, Integer value2) {
            this.addCriterion("is_mod_title between", value1, value2, "isModTitle");
            return (Criteria)this;
        }

        public Criteria andIsModTitleNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_mod_title not between", value1, value2, "isModTitle");
            return (Criteria)this;
        }

        public Criteria andIsModPriceIsNull() {
            this.addCriterion("is_mod_price is null");
            return (Criteria)this;
        }

        public Criteria andIsModPriceIsNotNull() {
            this.addCriterion("is_mod_price is not null");
            return (Criteria)this;
        }

        public Criteria andIsModPriceEqualTo(Integer value) {
            this.addCriterion("is_mod_price =", value, "isModPrice");
            return (Criteria)this;
        }

        public Criteria andIsModPriceNotEqualTo(Integer value) {
            this.addCriterion("is_mod_price <>", value, "isModPrice");
            return (Criteria)this;
        }

        public Criteria andIsModPriceGreaterThan(Integer value) {
            this.addCriterion("is_mod_price >", value, "isModPrice");
            return (Criteria)this;
        }

        public Criteria andIsModPriceGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_mod_price >=", value, "isModPrice");
            return (Criteria)this;
        }

        public Criteria andIsModPriceLessThan(Integer value) {
            this.addCriterion("is_mod_price <", value, "isModPrice");
            return (Criteria)this;
        }

        public Criteria andIsModPriceLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_mod_price <=", value, "isModPrice");
            return (Criteria)this;
        }

        public Criteria andIsModPriceLike(String value) {
            this.addCriterion("is_mod_price like", value, "isModPrice");
            return (Criteria)this;
        }

        public Criteria andIsModPriceNotLike(String value) {
            this.addCriterion("is_mod_price not like", value, "isModPrice");
            return (Criteria)this;
        }        public Criteria andIsModPriceIn(List<Integer> values) {
            this.addCriterion("is_mod_price in", values, "isModPrice");
            return (Criteria)this;
        }

        public Criteria andIsModPriceNotIn(List<Integer> values) {
            this.addCriterion("is_mod_price not in", values, "isModPrice");
            return (Criteria)this;
        }

        public Criteria andIsModPriceBetween(Integer value1, Integer value2) {
            this.addCriterion("is_mod_price between", value1, value2, "isModPrice");
            return (Criteria)this;
        }

        public Criteria andIsModPriceNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_mod_price not between", value1, value2, "isModPrice");
            return (Criteria)this;
        }

        public Criteria andIsModGoodsnoIsNull() {
            this.addCriterion("is_mod_goodsno is null");
            return (Criteria)this;
        }

        public Criteria andIsModGoodsnoIsNotNull() {
            this.addCriterion("is_mod_goodsno is not null");
            return (Criteria)this;
        }

        public Criteria andIsModGoodsnoEqualTo(Integer value) {
            this.addCriterion("is_mod_goodsno =", value, "isModGoodsno");
            return (Criteria)this;
        }

        public Criteria andIsModGoodsnoNotEqualTo(Integer value) {
            this.addCriterion("is_mod_goodsno <>", value, "isModGoodsno");
            return (Criteria)this;
        }

        public Criteria andIsModGoodsnoGreaterThan(Integer value) {
            this.addCriterion("is_mod_goodsno >", value, "isModGoodsno");
            return (Criteria)this;
        }

        public Criteria andIsModGoodsnoGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("is_mod_goodsno >=", value, "isModGoodsno");
            return (Criteria)this;
        }

        public Criteria andIsModGoodsnoLessThan(Integer value) {
            this.addCriterion("is_mod_goodsno <", value, "isModGoodsno");
            return (Criteria)this;
        }

        public Criteria andIsModGoodsnoLessThanOrEqualTo(Integer value) {
            this.addCriterion("is_mod_goodsno <=", value, "isModGoodsno");
            return (Criteria)this;
        }

        public Criteria andIsModGoodsnoLike(String value) {
            this.addCriterion("is_mod_goodsno like", value, "isModGoodsno");
            return (Criteria)this;
        }

        public Criteria andIsModGoodsnoNotLike(String value) {
            this.addCriterion("is_mod_goodsno not like", value, "isModGoodsno");
            return (Criteria)this;
        }        public Criteria andIsModGoodsnoIn(List<Integer> values) {
            this.addCriterion("is_mod_goodsno in", values, "isModGoodsno");
            return (Criteria)this;
        }

        public Criteria andIsModGoodsnoNotIn(List<Integer> values) {
            this.addCriterion("is_mod_goodsno not in", values, "isModGoodsno");
            return (Criteria)this;
        }

        public Criteria andIsModGoodsnoBetween(Integer value1, Integer value2) {
            this.addCriterion("is_mod_goodsno between", value1, value2, "isModGoodsno");
            return (Criteria)this;
        }

        public Criteria andIsModGoodsnoNotBetween(Integer value1, Integer value2) {
            this.addCriterion("is_mod_goodsno not between", value1, value2, "isModGoodsno");
            return (Criteria)this;
        }

        public Criteria andGoodsLevelIsNull() {
            this.addCriterion("goods_level is null");
            return (Criteria)this;
        }

        public Criteria andGoodsLevelIsNotNull() {
            this.addCriterion("goods_level is not null");
            return (Criteria)this;
        }

        public Criteria andGoodsLevelEqualTo(String value) {
            this.addCriterion("goods_level =", value, "goodsLevel");
            return (Criteria)this;
        }

        public Criteria andGoodsLevelNotEqualTo(String value) {
            this.addCriterion("goods_level <>", value, "goodsLevel");
            return (Criteria)this;
        }

        public Criteria andGoodsLevelGreaterThan(String value) {
            this.addCriterion("goods_level >", value, "goodsLevel");
            return (Criteria)this;
        }

        public Criteria andGoodsLevelGreaterThanOrEqualTo(String value) {
            this.addCriterion("goods_level >=", value, "goodsLevel");
            return (Criteria)this;
        }

        public Criteria andGoodsLevelLessThan(String value) {
            this.addCriterion("goods_level <", value, "goodsLevel");
            return (Criteria)this;
        }

        public Criteria andGoodsLevelLessThanOrEqualTo(String value) {
            this.addCriterion("goods_level <=", value, "goodsLevel");
            return (Criteria)this;
        }

        public Criteria andGoodsLevelLike(String value) {
            this.addCriterion("goods_level like", value, "goodsLevel");
            return (Criteria)this;
        }

        public Criteria andGoodsLevelNotLike(String value) {
            this.addCriterion("goods_level not like", value, "goodsLevel");
            return (Criteria)this;
        }        public Criteria andGoodsLevelIn(List<String> values) {
            this.addCriterion("goods_level in", values, "goodsLevel");
            return (Criteria)this;
        }

        public Criteria andGoodsLevelNotIn(List<String> values) {
            this.addCriterion("goods_level not in", values, "goodsLevel");
            return (Criteria)this;
        }

        public Criteria andGoodsLevelBetween(String value1, String value2) {
            this.addCriterion("goods_level between", value1, value2, "goodsLevel");
            return (Criteria)this;
        }

        public Criteria andGoodsLevelNotBetween(String value1, String value2) {
            this.addCriterion("goods_level not between", value1, value2, "goodsLevel");
            return (Criteria)this;
        }

        public Criteria andRelationLevelIdIsNull() {
            this.addCriterion("relation_level_id is null");
            return (Criteria)this;
        }

        public Criteria andRelationLevelIdIsNotNull() {
            this.addCriterion("relation_level_id is not null");
            return (Criteria)this;
        }

        public Criteria andRelationLevelIdEqualTo(Long value) {
            this.addCriterion("relation_level_id =", value, "relationLevelId");
            return (Criteria)this;
        }

        public Criteria andRelationLevelIdNotEqualTo(Long value) {
            this.addCriterion("relation_level_id <>", value, "relationLevelId");
            return (Criteria)this;
        }

        public Criteria andRelationLevelIdGreaterThan(Long value) {
            this.addCriterion("relation_level_id >", value, "relationLevelId");
            return (Criteria)this;
        }

        public Criteria andRelationLevelIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("relation_level_id >=", value, "relationLevelId");
            return (Criteria)this;
        }

        public Criteria andRelationLevelIdLessThan(Long value) {
            this.addCriterion("relation_level_id <", value, "relationLevelId");
            return (Criteria)this;
        }

        public Criteria andRelationLevelIdLessThanOrEqualTo(Long value) {
            this.addCriterion("relation_level_id <=", value, "relationLevelId");
            return (Criteria)this;
        }

        public Criteria andRelationLevelIdLike(String value) {
            this.addCriterion("relation_level_id like", value, "relationLevelId");
            return (Criteria)this;
        }

        public Criteria andRelationLevelIdNotLike(String value) {
            this.addCriterion("relation_level_id not like", value, "relationLevelId");
            return (Criteria)this;
        }        public Criteria andRelationLevelIdIn(List<Long> values) {
            this.addCriterion("relation_level_id in", values, "relationLevelId");
            return (Criteria)this;
        }

        public Criteria andRelationLevelIdNotIn(List<Long> values) {
            this.addCriterion("relation_level_id not in", values, "relationLevelId");
            return (Criteria)this;
        }

        public Criteria andRelationLevelIdBetween(Long value1, Long value2) {
            this.addCriterion("relation_level_id between", value1, value2, "relationLevelId");
            return (Criteria)this;
        }

        public Criteria andRelationLevelIdNotBetween(Long value1, Long value2) {
            this.addCriterion("relation_level_id not between", value1, value2, "relationLevelId");
            return (Criteria)this;
        }
    }
}
