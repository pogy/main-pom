package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShiguShopApplyExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguShopApplyExample.Criteria> oredCriteria = new ArrayList();

    public ShiguShopApplyExample() {
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

    public List<ShiguShopApplyExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguShopApplyExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguShopApplyExample.Criteria or() {
        ShiguShopApplyExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguShopApplyExample.Criteria createCriteria() {
        ShiguShopApplyExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguShopApplyExample.Criteria createCriteriaInternal() {
        ShiguShopApplyExample.Criteria criteria = new ShiguShopApplyExample.Criteria();
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

    public static class Criteria extends ShiguShopApplyExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguShopApplyExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguShopApplyExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguShopApplyExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguShopApplyExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguShopApplyExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguShopApplyExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguShopApplyExample.Criteria andImQqIsNull() {
            this.addCriterion("im_qq is null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImQqIsNotNull() {
            this.addCriterion("im_qq is not null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImQqEqualTo(String value) {
            this.addCriterion("im_qq =", value, "imQq");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImQqNotEqualTo(String value) {
            this.addCriterion("im_qq <>", value, "imQq");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImQqGreaterThan(String value) {
            this.addCriterion("im_qq >", value, "imQq");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImQqGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_qq >=", value, "imQq");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImQqLessThan(String value) {
            this.addCriterion("im_qq <", value, "imQq");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImQqLessThanOrEqualTo(String value) {
            this.addCriterion("im_qq <=", value, "imQq");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImQqLike(String value) {
            this.addCriterion("im_qq like", value, "imQq");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImQqNotLike(String value) {
            this.addCriterion("im_qq not like", value, "imQq");
            return (ShiguShopApplyExample.Criteria)this;
        }        public ShiguShopApplyExample.Criteria andImQqIn(List<String> values) {
            this.addCriterion("im_qq in", values, "imQq");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImQqNotIn(List<String> values) {
            this.addCriterion("im_qq not in", values, "imQq");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImQqBetween(String value1, String value2) {
            this.addCriterion("im_qq between", value1, value2, "imQq");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImQqNotBetween(String value1, String value2) {
            this.addCriterion("im_qq not between", value1, value2, "imQq");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImWxIsNull() {
            this.addCriterion("im_wx is null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImWxIsNotNull() {
            this.addCriterion("im_wx is not null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImWxEqualTo(String value) {
            this.addCriterion("im_wx =", value, "imWx");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImWxNotEqualTo(String value) {
            this.addCriterion("im_wx <>", value, "imWx");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImWxGreaterThan(String value) {
            this.addCriterion("im_wx >", value, "imWx");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImWxGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_wx >=", value, "imWx");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImWxLessThan(String value) {
            this.addCriterion("im_wx <", value, "imWx");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImWxLessThanOrEqualTo(String value) {
            this.addCriterion("im_wx <=", value, "imWx");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImWxLike(String value) {
            this.addCriterion("im_wx like", value, "imWx");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImWxNotLike(String value) {
            this.addCriterion("im_wx not like", value, "imWx");
            return (ShiguShopApplyExample.Criteria)this;
        }        public ShiguShopApplyExample.Criteria andImWxIn(List<String> values) {
            this.addCriterion("im_wx in", values, "imWx");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImWxNotIn(List<String> values) {
            this.addCriterion("im_wx not in", values, "imWx");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImWxBetween(String value1, String value2) {
            this.addCriterion("im_wx between", value1, value2, "imWx");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImWxNotBetween(String value1, String value2) {
            this.addCriterion("im_wx not between", value1, value2, "imWx");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonIsNull() {
            this.addCriterion("refuse_reason is null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonIsNotNull() {
            this.addCriterion("refuse_reason is not null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonEqualTo(String value) {
            this.addCriterion("refuse_reason =", value, "refuseReason");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonNotEqualTo(String value) {
            this.addCriterion("refuse_reason <>", value, "refuseReason");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonGreaterThan(String value) {
            this.addCriterion("refuse_reason >", value, "refuseReason");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonGreaterThanOrEqualTo(String value) {
            this.addCriterion("refuse_reason >=", value, "refuseReason");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonLessThan(String value) {
            this.addCriterion("refuse_reason <", value, "refuseReason");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonLessThanOrEqualTo(String value) {
            this.addCriterion("refuse_reason <=", value, "refuseReason");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonLike(String value) {
            this.addCriterion("refuse_reason like", value, "refuseReason");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonNotLike(String value) {
            this.addCriterion("refuse_reason not like", value, "refuseReason");
            return (ShiguShopApplyExample.Criteria)this;
        }        public ShiguShopApplyExample.Criteria andRefuseReasonIn(List<String> values) {
            this.addCriterion("refuse_reason in", values, "refuseReason");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonNotIn(List<String> values) {
            this.addCriterion("refuse_reason not in", values, "refuseReason");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonBetween(String value1, String value2) {
            this.addCriterion("refuse_reason between", value1, value2, "refuseReason");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonNotBetween(String value1, String value2) {
            this.addCriterion("refuse_reason not between", value1, value2, "refuseReason");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andIpIsNull() {
            this.addCriterion("ip is null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andIpIsNotNull() {
            this.addCriterion("ip is not null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andIpEqualTo(String value) {
            this.addCriterion("ip =", value, "ip");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andIpNotEqualTo(String value) {
            this.addCriterion("ip <>", value, "ip");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andIpGreaterThan(String value) {
            this.addCriterion("ip >", value, "ip");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andIpGreaterThanOrEqualTo(String value) {
            this.addCriterion("ip >=", value, "ip");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andIpLessThan(String value) {
            this.addCriterion("ip <", value, "ip");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andIpLessThanOrEqualTo(String value) {
            this.addCriterion("ip <=", value, "ip");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andIpLike(String value) {
            this.addCriterion("ip like", value, "ip");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andIpNotLike(String value) {
            this.addCriterion("ip not like", value, "ip");
            return (ShiguShopApplyExample.Criteria)this;
        }        public ShiguShopApplyExample.Criteria andIpIn(List<String> values) {
            this.addCriterion("ip in", values, "ip");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andIpNotIn(List<String> values) {
            this.addCriterion("ip not in", values, "ip");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andIpBetween(String value1, String value2) {
            this.addCriterion("ip between", value1, value2, "ip");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andIpNotBetween(String value1, String value2) {
            this.addCriterion("ip not between", value1, value2, "ip");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRuzhuIdIsNull() {
            this.addCriterion("ruzhu_id is null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRuzhuIdIsNotNull() {
            this.addCriterion("ruzhu_id is not null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRuzhuIdEqualTo(Long value) {
            this.addCriterion("ruzhu_id =", value, "ruzhuId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRuzhuIdNotEqualTo(Long value) {
            this.addCriterion("ruzhu_id <>", value, "ruzhuId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRuzhuIdGreaterThan(Long value) {
            this.addCriterion("ruzhu_id >", value, "ruzhuId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRuzhuIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("ruzhu_id >=", value, "ruzhuId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRuzhuIdLessThan(Long value) {
            this.addCriterion("ruzhu_id <", value, "ruzhuId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRuzhuIdLessThanOrEqualTo(Long value) {
            this.addCriterion("ruzhu_id <=", value, "ruzhuId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRuzhuIdLike(String value) {
            this.addCriterion("ruzhu_id like", value, "ruzhuId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRuzhuIdNotLike(String value) {
            this.addCriterion("ruzhu_id not like", value, "ruzhuId");
            return (ShiguShopApplyExample.Criteria)this;
        }        public ShiguShopApplyExample.Criteria andRuzhuIdIn(List<Long> values) {
            this.addCriterion("ruzhu_id in", values, "ruzhuId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRuzhuIdNotIn(List<Long> values) {
            this.addCriterion("ruzhu_id not in", values, "ruzhuId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRuzhuIdBetween(Long value1, Long value2) {
            this.addCriterion("ruzhu_id between", value1, value2, "ruzhuId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andRuzhuIdNotBetween(Long value1, Long value2) {
            this.addCriterion("ruzhu_id not between", value1, value2, "ruzhuId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbNickIsNull() {
            this.addCriterion("tb_nick is null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbNickIsNotNull() {
            this.addCriterion("tb_nick is not null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbNickEqualTo(String value) {
            this.addCriterion("tb_nick =", value, "tbNick");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbNickNotEqualTo(String value) {
            this.addCriterion("tb_nick <>", value, "tbNick");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbNickGreaterThan(String value) {
            this.addCriterion("tb_nick >", value, "tbNick");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbNickGreaterThanOrEqualTo(String value) {
            this.addCriterion("tb_nick >=", value, "tbNick");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbNickLessThan(String value) {
            this.addCriterion("tb_nick <", value, "tbNick");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbNickLessThanOrEqualTo(String value) {
            this.addCriterion("tb_nick <=", value, "tbNick");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbNickLike(String value) {
            this.addCriterion("tb_nick like", value, "tbNick");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbNickNotLike(String value) {
            this.addCriterion("tb_nick not like", value, "tbNick");
            return (ShiguShopApplyExample.Criteria)this;
        }        public ShiguShopApplyExample.Criteria andTbNickIn(List<String> values) {
            this.addCriterion("tb_nick in", values, "tbNick");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbNickNotIn(List<String> values) {
            this.addCriterion("tb_nick not in", values, "tbNick");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbNickBetween(String value1, String value2) {
            this.addCriterion("tb_nick between", value1, value2, "tbNick");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbNickNotBetween(String value1, String value2) {
            this.addCriterion("tb_nick not between", value1, value2, "tbNick");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMarketIdIsNull() {
            this.addCriterion("market_id is null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMarketIdIsNotNull() {
            this.addCriterion("market_id is not null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMarketIdEqualTo(Long value) {
            this.addCriterion("market_id =", value, "marketId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMarketIdNotEqualTo(Long value) {
            this.addCriterion("market_id <>", value, "marketId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMarketIdGreaterThan(Long value) {
            this.addCriterion("market_id >", value, "marketId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("market_id >=", value, "marketId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMarketIdLessThan(Long value) {
            this.addCriterion("market_id <", value, "marketId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            this.addCriterion("market_id <=", value, "marketId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMarketIdLike(String value) {
            this.addCriterion("market_id like", value, "marketId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMarketIdNotLike(String value) {
            this.addCriterion("market_id not like", value, "marketId");
            return (ShiguShopApplyExample.Criteria)this;
        }        public ShiguShopApplyExample.Criteria andMarketIdIn(List<Long> values) {
            this.addCriterion("market_id in", values, "marketId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMarketIdNotIn(List<Long> values) {
            this.addCriterion("market_id not in", values, "marketId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            this.addCriterion("market_id between", value1, value2, "marketId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            this.addCriterion("market_id not between", value1, value2, "marketId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyStatusIsNull() {
            this.addCriterion("apply_status is null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyStatusIsNotNull() {
            this.addCriterion("apply_status is not null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyStatusEqualTo(Integer value) {
            this.addCriterion("apply_status =", value, "applyStatus");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyStatusNotEqualTo(Integer value) {
            this.addCriterion("apply_status <>", value, "applyStatus");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyStatusGreaterThan(Integer value) {
            this.addCriterion("apply_status >", value, "applyStatus");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("apply_status >=", value, "applyStatus");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyStatusLessThan(Integer value) {
            this.addCriterion("apply_status <", value, "applyStatus");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("apply_status <=", value, "applyStatus");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyStatusLike(String value) {
            this.addCriterion("apply_status like", value, "applyStatus");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyStatusNotLike(String value) {
            this.addCriterion("apply_status not like", value, "applyStatus");
            return (ShiguShopApplyExample.Criteria)this;
        }        public ShiguShopApplyExample.Criteria andApplyStatusIn(List<Integer> values) {
            this.addCriterion("apply_status in", values, "applyStatus");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyStatusNotIn(List<Integer> values) {
            this.addCriterion("apply_status not in", values, "applyStatus");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("apply_status between", value1, value2, "applyStatus");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("apply_status not between", value1, value2, "applyStatus");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTelephoneIsNull() {
            this.addCriterion("telephone is null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTelephoneIsNotNull() {
            this.addCriterion("telephone is not null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTelephoneEqualTo(String value) {
            this.addCriterion("telephone =", value, "telephone");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTelephoneNotEqualTo(String value) {
            this.addCriterion("telephone <>", value, "telephone");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTelephoneGreaterThan(String value) {
            this.addCriterion("telephone >", value, "telephone");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            this.addCriterion("telephone >=", value, "telephone");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTelephoneLessThan(String value) {
            this.addCriterion("telephone <", value, "telephone");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTelephoneLessThanOrEqualTo(String value) {
            this.addCriterion("telephone <=", value, "telephone");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTelephoneLike(String value) {
            this.addCriterion("telephone like", value, "telephone");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTelephoneNotLike(String value) {
            this.addCriterion("telephone not like", value, "telephone");
            return (ShiguShopApplyExample.Criteria)this;
        }        public ShiguShopApplyExample.Criteria andTelephoneIn(List<String> values) {
            this.addCriterion("telephone in", values, "telephone");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTelephoneNotIn(List<String> values) {
            this.addCriterion("telephone not in", values, "telephone");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTelephoneBetween(String value1, String value2) {
            this.addCriterion("telephone between", value1, value2, "telephone");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTelephoneNotBetween(String value1, String value2) {
            this.addCriterion("telephone not between", value1, value2, "telephone");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyTimeIsNull() {
            this.addCriterion("apply_time is null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyTimeIsNotNull() {
            this.addCriterion("apply_time is not null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyTimeEqualTo(Date value) {
            this.addCriterion("apply_time =", value, "applyTime");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyTimeNotEqualTo(Date value) {
            this.addCriterion("apply_time <>", value, "applyTime");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyTimeGreaterThan(Date value) {
            this.addCriterion("apply_time >", value, "applyTime");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("apply_time >=", value, "applyTime");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyTimeLessThan(Date value) {
            this.addCriterion("apply_time <", value, "applyTime");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("apply_time <=", value, "applyTime");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyTimeLike(String value) {
            this.addCriterion("apply_time like", value, "applyTime");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyTimeNotLike(String value) {
            this.addCriterion("apply_time not like", value, "applyTime");
            return (ShiguShopApplyExample.Criteria)this;
        }        public ShiguShopApplyExample.Criteria andApplyTimeIn(List<Date> values) {
            this.addCriterion("apply_time in", values, "applyTime");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyTimeNotIn(List<Date> values) {
            this.addCriterion("apply_time not in", values, "applyTime");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyTimeBetween(Date value1, Date value2) {
            this.addCriterion("apply_time between", value1, value2, "applyTime");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andApplyTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("apply_time not between", value1, value2, "applyTime");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImAliwwIsNull() {
            this.addCriterion("im_aliww is null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImAliwwIsNotNull() {
            this.addCriterion("im_aliww is not null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImAliwwEqualTo(String value) {
            this.addCriterion("im_aliww =", value, "imAliww");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImAliwwNotEqualTo(String value) {
            this.addCriterion("im_aliww <>", value, "imAliww");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImAliwwGreaterThan(String value) {
            this.addCriterion("im_aliww >", value, "imAliww");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImAliwwGreaterThanOrEqualTo(String value) {
            this.addCriterion("im_aliww >=", value, "imAliww");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImAliwwLessThan(String value) {
            this.addCriterion("im_aliww <", value, "imAliww");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImAliwwLessThanOrEqualTo(String value) {
            this.addCriterion("im_aliww <=", value, "imAliww");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImAliwwLike(String value) {
            this.addCriterion("im_aliww like", value, "imAliww");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImAliwwNotLike(String value) {
            this.addCriterion("im_aliww not like", value, "imAliww");
            return (ShiguShopApplyExample.Criteria)this;
        }        public ShiguShopApplyExample.Criteria andImAliwwIn(List<String> values) {
            this.addCriterion("im_aliww in", values, "imAliww");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImAliwwNotIn(List<String> values) {
            this.addCriterion("im_aliww not in", values, "imAliww");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImAliwwBetween(String value1, String value2) {
            this.addCriterion("im_aliww between", value1, value2, "imAliww");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andImAliwwNotBetween(String value1, String value2) {
            this.addCriterion("im_aliww not between", value1, value2, "imAliww");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andShopNumIsNull() {
            this.addCriterion("shop_num is null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andShopNumIsNotNull() {
            this.addCriterion("shop_num is not null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andShopNumEqualTo(String value) {
            this.addCriterion("shop_num =", value, "shopNum");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andShopNumNotEqualTo(String value) {
            this.addCriterion("shop_num <>", value, "shopNum");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andShopNumGreaterThan(String value) {
            this.addCriterion("shop_num >", value, "shopNum");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andShopNumGreaterThanOrEqualTo(String value) {
            this.addCriterion("shop_num >=", value, "shopNum");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andShopNumLessThan(String value) {
            this.addCriterion("shop_num <", value, "shopNum");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andShopNumLessThanOrEqualTo(String value) {
            this.addCriterion("shop_num <=", value, "shopNum");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andShopNumLike(String value) {
            this.addCriterion("shop_num like", value, "shopNum");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andShopNumNotLike(String value) {
            this.addCriterion("shop_num not like", value, "shopNum");
            return (ShiguShopApplyExample.Criteria)this;
        }        public ShiguShopApplyExample.Criteria andShopNumIn(List<String> values) {
            this.addCriterion("shop_num in", values, "shopNum");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andShopNumNotIn(List<String> values) {
            this.addCriterion("shop_num not in", values, "shopNum");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andShopNumBetween(String value1, String value2) {
            this.addCriterion("shop_num between", value1, value2, "shopNum");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andShopNumNotBetween(String value1, String value2) {
            this.addCriterion("shop_num not between", value1, value2, "shopNum");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTagsIsNull() {
            this.addCriterion("tags is null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTagsIsNotNull() {
            this.addCriterion("tags is not null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTagsEqualTo(String value) {
            this.addCriterion("tags =", value, "tags");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTagsNotEqualTo(String value) {
            this.addCriterion("tags <>", value, "tags");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTagsGreaterThan(String value) {
            this.addCriterion("tags >", value, "tags");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTagsGreaterThanOrEqualTo(String value) {
            this.addCriterion("tags >=", value, "tags");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTagsLessThan(String value) {
            this.addCriterion("tags <", value, "tags");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTagsLessThanOrEqualTo(String value) {
            this.addCriterion("tags <=", value, "tags");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTagsLike(String value) {
            this.addCriterion("tags like", value, "tags");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTagsNotLike(String value) {
            this.addCriterion("tags not like", value, "tags");
            return (ShiguShopApplyExample.Criteria)this;
        }        public ShiguShopApplyExample.Criteria andTagsIn(List<String> values) {
            this.addCriterion("tags in", values, "tags");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTagsNotIn(List<String> values) {
            this.addCriterion("tags not in", values, "tags");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTagsBetween(String value1, String value2) {
            this.addCriterion("tags between", value1, value2, "tags");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTagsNotBetween(String value1, String value2) {
            this.addCriterion("tags not between", value1, value2, "tags");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbuserIdIsNull() {
            this.addCriterion("tbuser_id is null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbuserIdIsNotNull() {
            this.addCriterion("tbuser_id is not null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbuserIdEqualTo(String value) {
            this.addCriterion("tbuser_id =", value, "tbuserId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbuserIdNotEqualTo(String value) {
            this.addCriterion("tbuser_id <>", value, "tbuserId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbuserIdGreaterThan(String value) {
            this.addCriterion("tbuser_id >", value, "tbuserId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbuserIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("tbuser_id >=", value, "tbuserId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbuserIdLessThan(String value) {
            this.addCriterion("tbuser_id <", value, "tbuserId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbuserIdLessThanOrEqualTo(String value) {
            this.addCriterion("tbuser_id <=", value, "tbuserId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbuserIdLike(String value) {
            this.addCriterion("tbuser_id like", value, "tbuserId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbuserIdNotLike(String value) {
            this.addCriterion("tbuser_id not like", value, "tbuserId");
            return (ShiguShopApplyExample.Criteria)this;
        }        public ShiguShopApplyExample.Criteria andTbuserIdIn(List<String> values) {
            this.addCriterion("tbuser_id in", values, "tbuserId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbuserIdNotIn(List<String> values) {
            this.addCriterion("tbuser_id not in", values, "tbuserId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbuserIdBetween(String value1, String value2) {
            this.addCriterion("tbuser_id between", value1, value2, "tbuserId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbuserIdNotBetween(String value1, String value2) {
            this.addCriterion("tbuser_id not between", value1, value2, "tbuserId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andCanExamineIsNull() {
            this.addCriterion("can_examine is null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andCanExamineIsNotNull() {
            this.addCriterion("can_examine is not null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andCanExamineEqualTo(Integer value) {
            this.addCriterion("can_examine =", value, "canExamine");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andCanExamineNotEqualTo(Integer value) {
            this.addCriterion("can_examine <>", value, "canExamine");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andCanExamineGreaterThan(Integer value) {
            this.addCriterion("can_examine >", value, "canExamine");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andCanExamineGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("can_examine >=", value, "canExamine");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andCanExamineLessThan(Integer value) {
            this.addCriterion("can_examine <", value, "canExamine");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andCanExamineLessThanOrEqualTo(Integer value) {
            this.addCriterion("can_examine <=", value, "canExamine");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andCanExamineLike(String value) {
            this.addCriterion("can_examine like", value, "canExamine");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andCanExamineNotLike(String value) {
            this.addCriterion("can_examine not like", value, "canExamine");
            return (ShiguShopApplyExample.Criteria)this;
        }        public ShiguShopApplyExample.Criteria andCanExamineIn(List<Integer> values) {
            this.addCriterion("can_examine in", values, "canExamine");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andCanExamineNotIn(List<Integer> values) {
            this.addCriterion("can_examine not in", values, "canExamine");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andCanExamineBetween(Integer value1, Integer value2) {
            this.addCriterion("can_examine between", value1, value2, "canExamine");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andCanExamineNotBetween(Integer value1, Integer value2) {
            this.addCriterion("can_examine not between", value1, value2, "canExamine");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (ShiguShopApplyExample.Criteria)this;
        }        public ShiguShopApplyExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andFloorIdIsNull() {
            this.addCriterion("floor_id is null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andFloorIdIsNotNull() {
            this.addCriterion("floor_id is not null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andFloorIdEqualTo(Long value) {
            this.addCriterion("floor_id =", value, "floorId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andFloorIdNotEqualTo(Long value) {
            this.addCriterion("floor_id <>", value, "floorId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andFloorIdGreaterThan(Long value) {
            this.addCriterion("floor_id >", value, "floorId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andFloorIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("floor_id >=", value, "floorId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andFloorIdLessThan(Long value) {
            this.addCriterion("floor_id <", value, "floorId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andFloorIdLessThanOrEqualTo(Long value) {
            this.addCriterion("floor_id <=", value, "floorId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andFloorIdLike(String value) {
            this.addCriterion("floor_id like", value, "floorId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andFloorIdNotLike(String value) {
            this.addCriterion("floor_id not like", value, "floorId");
            return (ShiguShopApplyExample.Criteria)this;
        }        public ShiguShopApplyExample.Criteria andFloorIdIn(List<Long> values) {
            this.addCriterion("floor_id in", values, "floorId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andFloorIdNotIn(List<Long> values) {
            this.addCriterion("floor_id not in", values, "floorId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andFloorIdBetween(Long value1, Long value2) {
            this.addCriterion("floor_id between", value1, value2, "floorId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andFloorIdNotBetween(Long value1, Long value2) {
            this.addCriterion("floor_id not between", value1, value2, "floorId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbUrlIsNull() {
            this.addCriterion("tb_url is null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbUrlIsNotNull() {
            this.addCriterion("tb_url is not null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbUrlEqualTo(String value) {
            this.addCriterion("tb_url =", value, "tbUrl");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbUrlNotEqualTo(String value) {
            this.addCriterion("tb_url <>", value, "tbUrl");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbUrlGreaterThan(String value) {
            this.addCriterion("tb_url >", value, "tbUrl");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("tb_url >=", value, "tbUrl");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbUrlLessThan(String value) {
            this.addCriterion("tb_url <", value, "tbUrl");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbUrlLessThanOrEqualTo(String value) {
            this.addCriterion("tb_url <=", value, "tbUrl");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbUrlLike(String value) {
            this.addCriterion("tb_url like", value, "tbUrl");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbUrlNotLike(String value) {
            this.addCriterion("tb_url not like", value, "tbUrl");
            return (ShiguShopApplyExample.Criteria)this;
        }        public ShiguShopApplyExample.Criteria andTbUrlIn(List<String> values) {
            this.addCriterion("tb_url in", values, "tbUrl");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbUrlNotIn(List<String> values) {
            this.addCriterion("tb_url not in", values, "tbUrl");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbUrlBetween(String value1, String value2) {
            this.addCriterion("tb_url between", value1, value2, "tbUrl");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbUrlNotBetween(String value1, String value2) {
            this.addCriterion("tb_url not between", value1, value2, "tbUrl");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbshopIdIsNull() {
            this.addCriterion("tbshop_id is null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbshopIdIsNotNull() {
            this.addCriterion("tbshop_id is not null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbshopIdEqualTo(String value) {
            this.addCriterion("tbshop_id =", value, "tbshopId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbshopIdNotEqualTo(String value) {
            this.addCriterion("tbshop_id <>", value, "tbshopId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbshopIdGreaterThan(String value) {
            this.addCriterion("tbshop_id >", value, "tbshopId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbshopIdGreaterThanOrEqualTo(String value) {
            this.addCriterion("tbshop_id >=", value, "tbshopId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbshopIdLessThan(String value) {
            this.addCriterion("tbshop_id <", value, "tbshopId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbshopIdLessThanOrEqualTo(String value) {
            this.addCriterion("tbshop_id <=", value, "tbshopId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbshopIdLike(String value) {
            this.addCriterion("tbshop_id like", value, "tbshopId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbshopIdNotLike(String value) {
            this.addCriterion("tbshop_id not like", value, "tbshopId");
            return (ShiguShopApplyExample.Criteria)this;
        }        public ShiguShopApplyExample.Criteria andTbshopIdIn(List<String> values) {
            this.addCriterion("tbshop_id in", values, "tbshopId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbshopIdNotIn(List<String> values) {
            this.addCriterion("tbshop_id not in", values, "tbshopId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbshopIdBetween(String value1, String value2) {
            this.addCriterion("tbshop_id between", value1, value2, "tbshopId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andTbshopIdNotBetween(String value1, String value2) {
            this.addCriterion("tbshop_id not between", value1, value2, "tbshopId");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMainBusIsNull() {
            this.addCriterion("main_bus is null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMainBusIsNotNull() {
            this.addCriterion("main_bus is not null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMainBusEqualTo(String value) {
            this.addCriterion("main_bus =", value, "mainBus");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMainBusNotEqualTo(String value) {
            this.addCriterion("main_bus <>", value, "mainBus");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMainBusGreaterThan(String value) {
            this.addCriterion("main_bus >", value, "mainBus");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMainBusGreaterThanOrEqualTo(String value) {
            this.addCriterion("main_bus >=", value, "mainBus");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMainBusLessThan(String value) {
            this.addCriterion("main_bus <", value, "mainBus");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMainBusLessThanOrEqualTo(String value) {
            this.addCriterion("main_bus <=", value, "mainBus");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMainBusLike(String value) {
            this.addCriterion("main_bus like", value, "mainBus");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMainBusNotLike(String value) {
            this.addCriterion("main_bus not like", value, "mainBus");
            return (ShiguShopApplyExample.Criteria)this;
        }        public ShiguShopApplyExample.Criteria andMainBusIn(List<String> values) {
            this.addCriterion("main_bus in", values, "mainBus");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMainBusNotIn(List<String> values) {
            this.addCriterion("main_bus not in", values, "mainBus");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMainBusBetween(String value1, String value2) {
            this.addCriterion("main_bus between", value1, value2, "mainBus");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andMainBusNotBetween(String value1, String value2) {
            this.addCriterion("main_bus not between", value1, value2, "mainBus");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andEmailIsNull() {
            this.addCriterion("email is null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andEmailIsNotNull() {
            this.addCriterion("email is not null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andEmailEqualTo(String value) {
            this.addCriterion("email =", value, "email");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andEmailNotEqualTo(String value) {
            this.addCriterion("email <>", value, "email");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andEmailGreaterThan(String value) {
            this.addCriterion("email >", value, "email");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andEmailGreaterThanOrEqualTo(String value) {
            this.addCriterion("email >=", value, "email");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andEmailLessThan(String value) {
            this.addCriterion("email <", value, "email");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andEmailLessThanOrEqualTo(String value) {
            this.addCriterion("email <=", value, "email");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andEmailLike(String value) {
            this.addCriterion("email like", value, "email");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andEmailNotLike(String value) {
            this.addCriterion("email not like", value, "email");
            return (ShiguShopApplyExample.Criteria)this;
        }        public ShiguShopApplyExample.Criteria andEmailIn(List<String> values) {
            this.addCriterion("email in", values, "email");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andEmailNotIn(List<String> values) {
            this.addCriterion("email not in", values, "email");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andEmailBetween(String value1, String value2) {
            this.addCriterion("email between", value1, value2, "email");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andEmailNotBetween(String value1, String value2) {
            this.addCriterion("email not between", value1, value2, "email");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andWebSiteIsNull() {
            this.addCriterion("web_site is null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andWebSiteIsNotNull() {
            this.addCriterion("web_site is not null");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("web_site =", value, "webSite");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("web_site <>", value, "webSite");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("web_site >", value, "webSite");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("web_site >=", value, "webSite");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andWebSiteLessThan(String value) {
            this.addCriterion("web_site <", value, "webSite");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("web_site <=", value, "webSite");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andWebSiteLike(String value) {
            this.addCriterion("web_site like", value, "webSite");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andWebSiteNotLike(String value) {
            this.addCriterion("web_site not like", value, "webSite");
            return (ShiguShopApplyExample.Criteria)this;
        }        public ShiguShopApplyExample.Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("web_site in", values, "webSite");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("web_site not in", values, "webSite");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("web_site between", value1, value2, "webSite");
            return (ShiguShopApplyExample.Criteria)this;
        }

        public ShiguShopApplyExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("web_site not between", value1, value2, "webSite");
            return (ShiguShopApplyExample.Criteria)this;
        }
    }
}
