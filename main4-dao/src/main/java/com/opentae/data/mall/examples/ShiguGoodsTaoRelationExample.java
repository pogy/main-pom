package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShiguGoodsTaoRelationExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguGoodsTaoRelationExample.Criteria> oredCriteria = new ArrayList();

    public ShiguGoodsTaoRelationExample() {
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

    public List<ShiguGoodsTaoRelationExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguGoodsTaoRelationExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguGoodsTaoRelationExample.Criteria or() {
        ShiguGoodsTaoRelationExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguGoodsTaoRelationExample.Criteria createCriteria() {
        ShiguGoodsTaoRelationExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguGoodsTaoRelationExample.Criteria createCriteriaInternal() {
        ShiguGoodsTaoRelationExample.Criteria criteria = new ShiguGoodsTaoRelationExample.Criteria();
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

    public static class Criteria extends ShiguGoodsTaoRelationExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguGoodsTaoRelationExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguGoodsTaoRelationExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguGoodsTaoRelationExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguGoodsTaoRelationExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguGoodsTaoRelationExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguGoodsTaoRelationExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdIsNull() {
            this.addCriterion("goods_id is null");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdIsNotNull() {
            this.addCriterion("goods_id is not null");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdEqualTo(Long value) {
            this.addCriterion("goods_id =", value, "goodsId");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdNotEqualTo(Long value) {
            this.addCriterion("goods_id <>", value, "goodsId");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdGreaterThan(Long value) {
            this.addCriterion("goods_id >", value, "goodsId");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("goods_id >=", value, "goodsId");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdLessThan(Long value) {
            this.addCriterion("goods_id <", value, "goodsId");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            this.addCriterion("goods_id <=", value, "goodsId");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdLike(String value) {
            this.addCriterion("goods_id like", value, "goodsId");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdNotLike(String value) {
            this.addCriterion("goods_id not like", value, "goodsId");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdIn(List<Long> values) {
            this.addCriterion("goods_id in", values, "goodsId");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdNotIn(List<Long> values) {
            this.addCriterion("goods_id not in", values, "goodsId");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            this.addCriterion("goods_id between", value1, value2, "goodsId");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            this.addCriterion("goods_id not between", value1, value2, "goodsId");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andNumIidIsNull() {
            this.addCriterion("num_iid is null");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andNumIidIsNotNull() {
            this.addCriterion("num_iid is not null");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andNumIidEqualTo(Long value) {
            this.addCriterion("num_iid =", value, "numIid");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andNumIidNotEqualTo(Long value) {
            this.addCriterion("num_iid <>", value, "numIid");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andNumIidGreaterThan(Long value) {
            this.addCriterion("num_iid >", value, "numIid");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andNumIidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("num_iid >=", value, "numIid");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andNumIidLessThan(Long value) {
            this.addCriterion("num_iid <", value, "numIid");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andNumIidLessThanOrEqualTo(Long value) {
            this.addCriterion("num_iid <=", value, "numIid");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andNumIidLike(String value) {
            this.addCriterion("num_iid like", value, "numIid");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andNumIidNotLike(String value) {
            this.addCriterion("num_iid not like", value, "numIid");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }        public ShiguGoodsTaoRelationExample.Criteria andNumIidIn(List<Long> values) {
            this.addCriterion("num_iid in", values, "numIid");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andNumIidNotIn(List<Long> values) {
            this.addCriterion("num_iid not in", values, "numIid");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andNumIidBetween(Long value1, Long value2) {
            this.addCriterion("num_iid between", value1, value2, "numIid");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andNumIidNotBetween(Long value1, Long value2) {
            this.addCriterion("num_iid not between", value1, value2, "numIid");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteIsNull() {
            this.addCriterion("web_site is null");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteIsNotNull() {
            this.addCriterion("web_site is not null");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("web_site =", value, "webSite");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("web_site <>", value, "webSite");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("web_site >", value, "webSite");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("web_site >=", value, "webSite");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteLessThan(String value) {
            this.addCriterion("web_site <", value, "webSite");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("web_site <=", value, "webSite");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteLike(String value) {
            this.addCriterion("web_site like", value, "webSite");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteNotLike(String value) {
            this.addCriterion("web_site not like", value, "webSite");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }        public ShiguGoodsTaoRelationExample.Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("web_site in", values, "webSite");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("web_site not in", values, "webSite");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("web_site between", value1, value2, "webSite");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("web_site not between", value1, value2, "webSite");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andRelationIdIsNull() {
            this.addCriterion("relation_id is null");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andRelationIdIsNotNull() {
            this.addCriterion("relation_id is not null");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andRelationIdEqualTo(Long value) {
            this.addCriterion("relation_id =", value, "relationId");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andRelationIdNotEqualTo(Long value) {
            this.addCriterion("relation_id <>", value, "relationId");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andRelationIdGreaterThan(Long value) {
            this.addCriterion("relation_id >", value, "relationId");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andRelationIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("relation_id >=", value, "relationId");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andRelationIdLessThan(Long value) {
            this.addCriterion("relation_id <", value, "relationId");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andRelationIdLessThanOrEqualTo(Long value) {
            this.addCriterion("relation_id <=", value, "relationId");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andRelationIdLike(String value) {
            this.addCriterion("relation_id like", value, "relationId");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andRelationIdNotLike(String value) {
            this.addCriterion("relation_id not like", value, "relationId");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }        public ShiguGoodsTaoRelationExample.Criteria andRelationIdIn(List<Long> values) {
            this.addCriterion("relation_id in", values, "relationId");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andRelationIdNotIn(List<Long> values) {
            this.addCriterion("relation_id not in", values, "relationId");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andRelationIdBetween(Long value1, Long value2) {
            this.addCriterion("relation_id between", value1, value2, "relationId");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }

        public ShiguGoodsTaoRelationExample.Criteria andRelationIdNotBetween(Long value1, Long value2) {
            this.addCriterion("relation_id not between", value1, value2, "relationId");
            return (ShiguGoodsTaoRelationExample.Criteria)this;
        }
    }
}
