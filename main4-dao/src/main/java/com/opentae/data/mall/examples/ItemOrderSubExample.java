package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ItemOrderSubExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ItemOrderSubExample.Criteria> oredCriteria = new ArrayList();

    public ItemOrderSubExample() {
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

    public List<ItemOrderSubExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ItemOrderSubExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ItemOrderSubExample.Criteria or() {
        ItemOrderSubExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ItemOrderSubExample.Criteria createCriteria() {
        ItemOrderSubExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ItemOrderSubExample.Criteria createCriteriaInternal() {
        ItemOrderSubExample.Criteria criteria = new ItemOrderSubExample.Criteria();
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

    public static class Criteria extends ItemOrderSubExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ItemOrderSubExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ItemOrderSubExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ItemOrderSubExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ItemOrderSubExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ItemOrderSubExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ItemOrderSubExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ItemOrderSubExample.Criteria andSingleWeightIsNull() {
            this.addCriterion("singleWeight is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSingleWeightIsNotNull() {
            this.addCriterion("singleWeight is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSingleWeightEqualTo(Long value) {
            this.addCriterion("singleWeight =", value, "single_weight");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSingleWeightNotEqualTo(Long value) {
            this.addCriterion("singleWeight <>", value, "single_weight");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSingleWeightGreaterThan(Long value) {
            this.addCriterion("singleWeight >", value, "single_weight");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSingleWeightGreaterThanOrEqualTo(Long value) {
            this.addCriterion("singleWeight >=", value, "single_weight");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSingleWeightLessThan(Long value) {
            this.addCriterion("singleWeight <", value, "single_weight");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSingleWeightLessThanOrEqualTo(Long value) {
            this.addCriterion("singleWeight <=", value, "single_weight");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSingleWeightLike(String value) {
            this.addCriterion("singleWeight like", value, "single_weight");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSingleWeightNotLike(String value) {
            this.addCriterion("singleWeight not like", value, "single_weight");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andSingleWeightIn(List<Long> values) {
            this.addCriterion("singleWeight in", values, "single_weight");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSingleWeightNotIn(List<Long> values) {
            this.addCriterion("singleWeight not in", values, "single_weight");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSingleWeightBetween(Long value1, Long value2) {
            this.addCriterion("singleWeight between", value1, value2, "single_weight");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSingleWeightNotBetween(Long value1, Long value2) {
            this.addCriterion("singleWeight not between", value1, value2, "single_weight");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendIsNull() {
            this.addCriterion("send is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendIsNotNull() {
            this.addCriterion("send is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendEqualTo(Boolean value) {
            this.addCriterion("send =", value, "send");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendNotEqualTo(Boolean value) {
            this.addCriterion("send <>", value, "send");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendGreaterThan(Boolean value) {
            this.addCriterion("send >", value, "send");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("send >=", value, "send");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendLessThan(Boolean value) {
            this.addCriterion("send <", value, "send");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendLessThanOrEqualTo(Boolean value) {
            this.addCriterion("send <=", value, "send");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendLike(String value) {
            this.addCriterion("send like", value, "send");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendNotLike(String value) {
            this.addCriterion("send not like", value, "send");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andSendIn(List<Boolean> values) {
            this.addCriterion("send in", values, "send");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendNotIn(List<Boolean> values) {
            this.addCriterion("send not in", values, "send");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendBetween(Boolean value1, Boolean value2) {
            this.addCriterion("send between", value1, value2, "send");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSendNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("send not between", value1, value2, "send");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdIsNull() {
            this.addCriterion("logisticsId is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdIsNotNull() {
            this.addCriterion("logisticsId is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdEqualTo(Long value) {
            this.addCriterion("logisticsId =", value, "logistics_id");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdNotEqualTo(Long value) {
            this.addCriterion("logisticsId <>", value, "logistics_id");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdGreaterThan(Long value) {
            this.addCriterion("logisticsId >", value, "logistics_id");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("logisticsId >=", value, "logistics_id");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdLessThan(Long value) {
            this.addCriterion("logisticsId <", value, "logistics_id");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdLessThanOrEqualTo(Long value) {
            this.addCriterion("logisticsId <=", value, "logistics_id");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdLike(String value) {
            this.addCriterion("logisticsId like", value, "logistics_id");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdNotLike(String value) {
            this.addCriterion("logisticsId not like", value, "logistics_id");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andLogisticsIdIn(List<Long> values) {
            this.addCriterion("logisticsId in", values, "logistics_id");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdNotIn(List<Long> values) {
            this.addCriterion("logisticsId not in", values, "logistics_id");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdBetween(Long value1, Long value2) {
            this.addCriterion("logisticsId between", value1, value2, "logistics_id");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andLogisticsIdNotBetween(Long value1, Long value2) {
            this.addCriterion("logisticsId not between", value1, value2, "logistics_id");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSinglePriceIsNull() {
            this.addCriterion("singlePrice is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSinglePriceIsNotNull() {
            this.addCriterion("singlePrice is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSinglePriceEqualTo(Long value) {
            this.addCriterion("singlePrice =", value, "single_price");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSinglePriceNotEqualTo(Long value) {
            this.addCriterion("singlePrice <>", value, "single_price");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSinglePriceGreaterThan(Long value) {
            this.addCriterion("singlePrice >", value, "single_price");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSinglePriceGreaterThanOrEqualTo(Long value) {
            this.addCriterion("singlePrice >=", value, "single_price");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSinglePriceLessThan(Long value) {
            this.addCriterion("singlePrice <", value, "single_price");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSinglePriceLessThanOrEqualTo(Long value) {
            this.addCriterion("singlePrice <=", value, "single_price");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSinglePriceLike(String value) {
            this.addCriterion("singlePrice like", value, "single_price");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSinglePriceNotLike(String value) {
            this.addCriterion("singlePrice not like", value, "single_price");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andSinglePriceIn(List<Long> values) {
            this.addCriterion("singlePrice in", values, "single_price");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSinglePriceNotIn(List<Long> values) {
            this.addCriterion("singlePrice not in", values, "single_price");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSinglePriceBetween(Long value1, Long value2) {
            this.addCriterion("singlePrice between", value1, value2, "single_price");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSinglePriceNotBetween(Long value1, Long value2) {
            this.addCriterion("singlePrice not between", value1, value2, "single_price");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyIsNull() {
            this.addCriterion("shouldPayMoney is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyIsNotNull() {
            this.addCriterion("shouldPayMoney is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyEqualTo(Long value) {
            this.addCriterion("shouldPayMoney =", value, "should_pay_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyNotEqualTo(Long value) {
            this.addCriterion("shouldPayMoney <>", value, "should_pay_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyGreaterThan(Long value) {
            this.addCriterion("shouldPayMoney >", value, "should_pay_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyGreaterThanOrEqualTo(Long value) {
            this.addCriterion("shouldPayMoney >=", value, "should_pay_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyLessThan(Long value) {
            this.addCriterion("shouldPayMoney <", value, "should_pay_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyLessThanOrEqualTo(Long value) {
            this.addCriterion("shouldPayMoney <=", value, "should_pay_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyLike(String value) {
            this.addCriterion("shouldPayMoney like", value, "should_pay_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyNotLike(String value) {
            this.addCriterion("shouldPayMoney not like", value, "should_pay_money");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andShouldPayMoneyIn(List<Long> values) {
            this.addCriterion("shouldPayMoney in", values, "should_pay_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyNotIn(List<Long> values) {
            this.addCriterion("shouldPayMoney not in", values, "should_pay_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyBetween(Long value1, Long value2) {
            this.addCriterion("shouldPayMoney between", value1, value2, "should_pay_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andShouldPayMoneyNotBetween(Long value1, Long value2) {
            this.addCriterion("shouldPayMoney not between", value1, value2, "should_pay_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkIsNull() {
            this.addCriterion("mark is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkIsNotNull() {
            this.addCriterion("mark is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkEqualTo(String value) {
            this.addCriterion("mark =", value, "mark");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkNotEqualTo(String value) {
            this.addCriterion("mark <>", value, "mark");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkGreaterThan(String value) {
            this.addCriterion("mark >", value, "mark");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkGreaterThanOrEqualTo(String value) {
            this.addCriterion("mark >=", value, "mark");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkLessThan(String value) {
            this.addCriterion("mark <", value, "mark");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkLessThanOrEqualTo(String value) {
            this.addCriterion("mark <=", value, "mark");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkLike(String value) {
            this.addCriterion("mark like", value, "mark");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkNotLike(String value) {
            this.addCriterion("mark not like", value, "mark");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andMarkIn(List<String> values) {
            this.addCriterion("mark in", values, "mark");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkNotIn(List<String> values) {
            this.addCriterion("mark not in", values, "mark");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkBetween(String value1, String value2) {
            this.addCriterion("mark between", value1, value2, "mark");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andMarkNotBetween(String value1, String value2) {
            this.addCriterion("mark not between", value1, value2, "mark");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPicUrlIsNull() {
            this.addCriterion("picUrl is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPicUrlIsNotNull() {
            this.addCriterion("picUrl is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPicUrlEqualTo(String value) {
            this.addCriterion("picUrl =", value, "pic_url");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPicUrlNotEqualTo(String value) {
            this.addCriterion("picUrl <>", value, "pic_url");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPicUrlGreaterThan(String value) {
            this.addCriterion("picUrl >", value, "pic_url");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("picUrl >=", value, "pic_url");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPicUrlLessThan(String value) {
            this.addCriterion("picUrl <", value, "pic_url");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPicUrlLessThanOrEqualTo(String value) {
            this.addCriterion("picUrl <=", value, "pic_url");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPicUrlLike(String value) {
            this.addCriterion("picUrl like", value, "pic_url");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPicUrlNotLike(String value) {
            this.addCriterion("picUrl not like", value, "pic_url");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andPicUrlIn(List<String> values) {
            this.addCriterion("picUrl in", values, "pic_url");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPicUrlNotIn(List<String> values) {
            this.addCriterion("picUrl not in", values, "pic_url");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPicUrlBetween(String value1, String value2) {
            this.addCriterion("picUrl between", value1, value2, "pic_url");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPicUrlNotBetween(String value1, String value2) {
            this.addCriterion("picUrl not between", value1, value2, "pic_url");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSizeIsNull() {
            this.addCriterion("size is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSizeIsNotNull() {
            this.addCriterion("size is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSizeEqualTo(String value) {
            this.addCriterion("size =", value, "size");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSizeNotEqualTo(String value) {
            this.addCriterion("size <>", value, "size");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSizeGreaterThan(String value) {
            this.addCriterion("size >", value, "size");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSizeGreaterThanOrEqualTo(String value) {
            this.addCriterion("size >=", value, "size");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSizeLessThan(String value) {
            this.addCriterion("size <", value, "size");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSizeLessThanOrEqualTo(String value) {
            this.addCriterion("size <=", value, "size");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSizeLike(String value) {
            this.addCriterion("size like", value, "size");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSizeNotLike(String value) {
            this.addCriterion("size not like", value, "size");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andSizeIn(List<String> values) {
            this.addCriterion("size in", values, "size");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSizeNotIn(List<String> values) {
            this.addCriterion("size not in", values, "size");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSizeBetween(String value1, String value2) {
            this.addCriterion("size between", value1, value2, "size");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSizeNotBetween(String value1, String value2) {
            this.addCriterion("size not between", value1, value2, "size");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andTitleIsNull() {
            this.addCriterion("title is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andTitleIsNotNull() {
            this.addCriterion("title is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andTitleEqualTo(String value) {
            this.addCriterion("title =", value, "title");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andTitleNotEqualTo(String value) {
            this.addCriterion("title <>", value, "title");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andTitleGreaterThan(String value) {
            this.addCriterion("title >", value, "title");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            this.addCriterion("title >=", value, "title");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andTitleLessThan(String value) {
            this.addCriterion("title <", value, "title");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andTitleLessThanOrEqualTo(String value) {
            this.addCriterion("title <=", value, "title");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andTitleLike(String value) {
            this.addCriterion("title like", value, "title");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andTitleNotLike(String value) {
            this.addCriterion("title not like", value, "title");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andTitleIn(List<String> values) {
            this.addCriterion("title in", values, "title");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andTitleNotIn(List<String> values) {
            this.addCriterion("title not in", values, "title");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andTitleBetween(String value1, String value2) {
            this.addCriterion("title between", value1, value2, "title");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andTitleNotBetween(String value1, String value2) {
            this.addCriterion("title not between", value1, value2, "title");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumIsNull() {
            this.addCriterion("num is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumIsNotNull() {
            this.addCriterion("num is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumEqualTo(Integer value) {
            this.addCriterion("num =", value, "num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumNotEqualTo(Integer value) {
            this.addCriterion("num <>", value, "num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumGreaterThan(Integer value) {
            this.addCriterion("num >", value, "num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("num >=", value, "num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumLessThan(Integer value) {
            this.addCriterion("num <", value, "num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumLessThanOrEqualTo(Integer value) {
            this.addCriterion("num <=", value, "num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumLike(String value) {
            this.addCriterion("num like", value, "num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumNotLike(String value) {
            this.addCriterion("num not like", value, "num");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andNumIn(List<Integer> values) {
            this.addCriterion("num in", values, "num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumNotIn(List<Integer> values) {
            this.addCriterion("num not in", values, "num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumBetween(Integer value1, Integer value2) {
            this.addCriterion("num between", value1, value2, "num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andNumNotBetween(Integer value1, Integer value2) {
            this.addCriterion("num not between", value1, value2, "num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyIsNull() {
            this.addCriterion("payMoney is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyIsNotNull() {
            this.addCriterion("payMoney is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyEqualTo(Long value) {
            this.addCriterion("payMoney =", value, "pay_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyNotEqualTo(Long value) {
            this.addCriterion("payMoney <>", value, "pay_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyGreaterThan(Long value) {
            this.addCriterion("payMoney >", value, "pay_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyGreaterThanOrEqualTo(Long value) {
            this.addCriterion("payMoney >=", value, "pay_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyLessThan(Long value) {
            this.addCriterion("payMoney <", value, "pay_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyLessThanOrEqualTo(Long value) {
            this.addCriterion("payMoney <=", value, "pay_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyLike(String value) {
            this.addCriterion("payMoney like", value, "pay_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyNotLike(String value) {
            this.addCriterion("payMoney not like", value, "pay_money");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andPayMoneyIn(List<Long> values) {
            this.addCriterion("payMoney in", values, "pay_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyNotIn(List<Long> values) {
            this.addCriterion("payMoney not in", values, "pay_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyBetween(Long value1, Long value2) {
            this.addCriterion("payMoney between", value1, value2, "pay_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andPayMoneyNotBetween(Long value1, Long value2) {
            this.addCriterion("payMoney not between", value1, value2, "pay_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andColorIsNull() {
            this.addCriterion("color is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andColorIsNotNull() {
            this.addCriterion("color is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andColorEqualTo(String value) {
            this.addCriterion("color =", value, "color");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andColorNotEqualTo(String value) {
            this.addCriterion("color <>", value, "color");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andColorGreaterThan(String value) {
            this.addCriterion("color >", value, "color");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andColorGreaterThanOrEqualTo(String value) {
            this.addCriterion("color >=", value, "color");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andColorLessThan(String value) {
            this.addCriterion("color <", value, "color");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andColorLessThanOrEqualTo(String value) {
            this.addCriterion("color <=", value, "color");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andColorLike(String value) {
            this.addCriterion("color like", value, "color");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andColorNotLike(String value) {
            this.addCriterion("color not like", value, "color");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andColorIn(List<String> values) {
            this.addCriterion("color in", values, "color");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andColorNotIn(List<String> values) {
            this.addCriterion("color not in", values, "color");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andColorBetween(String value1, String value2) {
            this.addCriterion("color between", value1, value2, "color");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andColorNotBetween(String value1, String value2) {
            this.addCriterion("color not between", value1, value2, "color");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidIsNull() {
            this.addCriterion("oid is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidIsNotNull() {
            this.addCriterion("oid is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidEqualTo(Long value) {
            this.addCriterion("oid =", value, "oid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidNotEqualTo(Long value) {
            this.addCriterion("oid <>", value, "oid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidGreaterThan(Long value) {
            this.addCriterion("oid >", value, "oid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("oid >=", value, "oid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidLessThan(Long value) {
            this.addCriterion("oid <", value, "oid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidLessThanOrEqualTo(Long value) {
            this.addCriterion("oid <=", value, "oid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidLike(String value) {
            this.addCriterion("oid like", value, "oid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidNotLike(String value) {
            this.addCriterion("oid not like", value, "oid");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andOidIn(List<Long> values) {
            this.addCriterion("oid in", values, "oid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidNotIn(List<Long> values) {
            this.addCriterion("oid not in", values, "oid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidBetween(Long value1, Long value2) {
            this.addCriterion("oid between", value1, value2, "oid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andOidNotBetween(Long value1, Long value2) {
            this.addCriterion("oid not between", value1, value2, "oid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundIsNull() {
            this.addCriterion("refund is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundIsNotNull() {
            this.addCriterion("refund is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundEqualTo(Boolean value) {
            this.addCriterion("refund =", value, "refund");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundNotEqualTo(Boolean value) {
            this.addCriterion("refund <>", value, "refund");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundGreaterThan(Boolean value) {
            this.addCriterion("refund >", value, "refund");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("refund >=", value, "refund");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundLessThan(Boolean value) {
            this.addCriterion("refund <", value, "refund");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundLessThanOrEqualTo(Boolean value) {
            this.addCriterion("refund <=", value, "refund");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundLike(String value) {
            this.addCriterion("refund like", value, "refund");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundNotLike(String value) {
            this.addCriterion("refund not like", value, "refund");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andRefundIn(List<Boolean> values) {
            this.addCriterion("refund in", values, "refund");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundNotIn(List<Boolean> values) {
            this.addCriterion("refund not in", values, "refund");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundBetween(Boolean value1, Boolean value2) {
            this.addCriterion("refund between", value1, value2, "refund");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("refund not between", value1, value2, "refund");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidIsNull() {
            this.addCriterion("soid is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidIsNotNull() {
            this.addCriterion("soid is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidEqualTo(Long value) {
            this.addCriterion("soid =", value, "soid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidNotEqualTo(Long value) {
            this.addCriterion("soid <>", value, "soid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidGreaterThan(Long value) {
            this.addCriterion("soid >", value, "soid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("soid >=", value, "soid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidLessThan(Long value) {
            this.addCriterion("soid <", value, "soid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidLessThanOrEqualTo(Long value) {
            this.addCriterion("soid <=", value, "soid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidLike(String value) {
            this.addCriterion("soid like", value, "soid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidNotLike(String value) {
            this.addCriterion("soid not like", value, "soid");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andSoidIn(List<Long> values) {
            this.addCriterion("soid in", values, "soid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidNotIn(List<Long> values) {
            this.addCriterion("soid not in", values, "soid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidBetween(Long value1, Long value2) {
            this.addCriterion("soid between", value1, value2, "soid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andSoidNotBetween(Long value1, Long value2) {
            this.addCriterion("soid not between", value1, value2, "soid");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumIsNull() {
            this.addCriterion("distributionNum is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumIsNotNull() {
            this.addCriterion("distributionNum is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumEqualTo(Integer value) {
            this.addCriterion("distributionNum =", value, "distribution_num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumNotEqualTo(Integer value) {
            this.addCriterion("distributionNum <>", value, "distribution_num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumGreaterThan(Integer value) {
            this.addCriterion("distributionNum >", value, "distribution_num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("distributionNum >=", value, "distribution_num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumLessThan(Integer value) {
            this.addCriterion("distributionNum <", value, "distribution_num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumLessThanOrEqualTo(Integer value) {
            this.addCriterion("distributionNum <=", value, "distribution_num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumLike(String value) {
            this.addCriterion("distributionNum like", value, "distribution_num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumNotLike(String value) {
            this.addCriterion("distributionNum not like", value, "distribution_num");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andDistributionNumIn(List<Integer> values) {
            this.addCriterion("distributionNum in", values, "distribution_num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumNotIn(List<Integer> values) {
            this.addCriterion("distributionNum not in", values, "distribution_num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumBetween(Integer value1, Integer value2) {
            this.addCriterion("distributionNum between", value1, value2, "distribution_num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andDistributionNumNotBetween(Integer value1, Integer value2) {
            this.addCriterion("distributionNum not between", value1, value2, "distribution_num");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andGoodsIdIsNull() {
            this.addCriterion("goodsId is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andGoodsIdIsNotNull() {
            this.addCriterion("goodsId is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andGoodsIdEqualTo(Long value) {
            this.addCriterion("goodsId =", value, "goods_id");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andGoodsIdNotEqualTo(Long value) {
            this.addCriterion("goodsId <>", value, "goods_id");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andGoodsIdGreaterThan(Long value) {
            this.addCriterion("goodsId >", value, "goods_id");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("goodsId >=", value, "goods_id");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andGoodsIdLessThan(Long value) {
            this.addCriterion("goodsId <", value, "goods_id");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            this.addCriterion("goodsId <=", value, "goods_id");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andGoodsIdLike(String value) {
            this.addCriterion("goodsId like", value, "goods_id");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andGoodsIdNotLike(String value) {
            this.addCriterion("goodsId not like", value, "goods_id");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andGoodsIdIn(List<Long> values) {
            this.addCriterion("goodsId in", values, "goods_id");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andGoodsIdNotIn(List<Long> values) {
            this.addCriterion("goodsId not in", values, "goods_id");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            this.addCriterion("goodsId between", value1, value2, "goods_id");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            this.addCriterion("goodsId not between", value1, value2, "goods_id");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyIsNull() {
            this.addCriterion("refundMoney is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyIsNotNull() {
            this.addCriterion("refundMoney is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyEqualTo(Long value) {
            this.addCriterion("refundMoney =", value, "refund_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyNotEqualTo(Long value) {
            this.addCriterion("refundMoney <>", value, "refund_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyGreaterThan(Long value) {
            this.addCriterion("refundMoney >", value, "refund_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyGreaterThanOrEqualTo(Long value) {
            this.addCriterion("refundMoney >=", value, "refund_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyLessThan(Long value) {
            this.addCriterion("refundMoney <", value, "refund_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyLessThanOrEqualTo(Long value) {
            this.addCriterion("refundMoney <=", value, "refund_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyLike(String value) {
            this.addCriterion("refundMoney like", value, "refund_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyNotLike(String value) {
            this.addCriterion("refundMoney not like", value, "refund_money");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andRefundMoneyIn(List<Long> values) {
            this.addCriterion("refundMoney in", values, "refund_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyNotIn(List<Long> values) {
            this.addCriterion("refundMoney not in", values, "refund_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyBetween(Long value1, Long value2) {
            this.addCriterion("refundMoney between", value1, value2, "refund_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andRefundMoneyNotBetween(Long value1, Long value2) {
            this.addCriterion("refundMoney not between", value1, value2, "refund_money");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andWebSiteIsNull() {
            this.addCriterion("webSite is null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andWebSiteIsNotNull() {
            this.addCriterion("webSite is not null");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("webSite =", value, "web_site");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("webSite <>", value, "web_site");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("webSite >", value, "web_site");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("webSite >=", value, "web_site");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andWebSiteLessThan(String value) {
            this.addCriterion("webSite <", value, "web_site");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("webSite <=", value, "web_site");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andWebSiteLike(String value) {
            this.addCriterion("webSite like", value, "web_site");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andWebSiteNotLike(String value) {
            this.addCriterion("webSite not like", value, "web_site");
            return (ItemOrderSubExample.Criteria)this;
        }        public ItemOrderSubExample.Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("webSite in", values, "web_site");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("webSite not in", values, "web_site");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("webSite between", value1, value2, "web_site");
            return (ItemOrderSubExample.Criteria)this;
        }

        public ItemOrderSubExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("webSite not between", value1, value2, "web_site");
            return (ItemOrderSubExample.Criteria)this;
        }
    }
}
