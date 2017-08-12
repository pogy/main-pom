package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShiguOuterMarketExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguOuterMarketExample.Criteria> oredCriteria = new ArrayList();

    public ShiguOuterMarketExample() {
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

    public List<ShiguOuterMarketExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguOuterMarketExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguOuterMarketExample.Criteria or() {
        ShiguOuterMarketExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguOuterMarketExample.Criteria createCriteria() {
        ShiguOuterMarketExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguOuterMarketExample.Criteria createCriteriaInternal() {
        ShiguOuterMarketExample.Criteria criteria = new ShiguOuterMarketExample.Criteria();
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

    public static class Criteria extends ShiguOuterMarketExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguOuterMarketExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguOuterMarketExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguOuterMarketExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguOuterMarketExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguOuterMarketExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguOuterMarketExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguOuterMarketExample.Criteria andRuleIdIsNull() {
            this.addCriterion("rule_id is null");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andRuleIdIsNotNull() {
            this.addCriterion("rule_id is not null");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andRuleIdEqualTo(Long value) {
            this.addCriterion("rule_id =", value, "ruleId");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andRuleIdNotEqualTo(Long value) {
            this.addCriterion("rule_id <>", value, "ruleId");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andRuleIdGreaterThan(Long value) {
            this.addCriterion("rule_id >", value, "ruleId");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andRuleIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("rule_id >=", value, "ruleId");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andRuleIdLessThan(Long value) {
            this.addCriterion("rule_id <", value, "ruleId");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andRuleIdLessThanOrEqualTo(Long value) {
            this.addCriterion("rule_id <=", value, "ruleId");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andRuleIdLike(String value) {
            this.addCriterion("rule_id like", value, "ruleId");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andRuleIdNotLike(String value) {
            this.addCriterion("rule_id not like", value, "ruleId");
            return (ShiguOuterMarketExample.Criteria)this;
        }        public ShiguOuterMarketExample.Criteria andRuleIdIn(List<Long> values) {
            this.addCriterion("rule_id in", values, "ruleId");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andRuleIdNotIn(List<Long> values) {
            this.addCriterion("rule_id not in", values, "ruleId");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andRuleIdBetween(Long value1, Long value2) {
            this.addCriterion("rule_id between", value1, value2, "ruleId");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andRuleIdNotBetween(Long value1, Long value2) {
            this.addCriterion("rule_id not between", value1, value2, "ruleId");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andWebSiteIsNull() {
            this.addCriterion("web_site is null");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andWebSiteIsNotNull() {
            this.addCriterion("web_site is not null");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("web_site =", value, "webSite");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("web_site <>", value, "webSite");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("web_site >", value, "webSite");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("web_site >=", value, "webSite");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andWebSiteLessThan(String value) {
            this.addCriterion("web_site <", value, "webSite");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("web_site <=", value, "webSite");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andWebSiteLike(String value) {
            this.addCriterion("web_site like", value, "webSite");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andWebSiteNotLike(String value) {
            this.addCriterion("web_site not like", value, "webSite");
            return (ShiguOuterMarketExample.Criteria)this;
        }        public ShiguOuterMarketExample.Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("web_site in", values, "webSite");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("web_site not in", values, "webSite");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("web_site between", value1, value2, "webSite");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("web_site not between", value1, value2, "webSite");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketIdIsNull() {
            this.addCriterion("market_id is null");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketIdIsNotNull() {
            this.addCriterion("market_id is not null");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketIdEqualTo(Long value) {
            this.addCriterion("market_id =", value, "marketId");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketIdNotEqualTo(Long value) {
            this.addCriterion("market_id <>", value, "marketId");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketIdGreaterThan(Long value) {
            this.addCriterion("market_id >", value, "marketId");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("market_id >=", value, "marketId");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketIdLessThan(Long value) {
            this.addCriterion("market_id <", value, "marketId");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            this.addCriterion("market_id <=", value, "marketId");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketIdLike(String value) {
            this.addCriterion("market_id like", value, "marketId");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketIdNotLike(String value) {
            this.addCriterion("market_id not like", value, "marketId");
            return (ShiguOuterMarketExample.Criteria)this;
        }        public ShiguOuterMarketExample.Criteria andMarketIdIn(List<Long> values) {
            this.addCriterion("market_id in", values, "marketId");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketIdNotIn(List<Long> values) {
            this.addCriterion("market_id not in", values, "marketId");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            this.addCriterion("market_id between", value1, value2, "marketId");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            this.addCriterion("market_id not between", value1, value2, "marketId");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andSortOrderIsNull() {
            this.addCriterion("sort_order is null");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andSortOrderIsNotNull() {
            this.addCriterion("sort_order is not null");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andSortOrderEqualTo(int value) {
            this.addCriterion("sort_order =", value, "sortOrder");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andSortOrderNotEqualTo(int value) {
            this.addCriterion("sort_order <>", value, "sortOrder");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andSortOrderGreaterThan(int value) {
            this.addCriterion("sort_order >", value, "sortOrder");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andSortOrderGreaterThanOrEqualTo(int value) {
            this.addCriterion("sort_order >=", value, "sortOrder");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andSortOrderLessThan(int value) {
            this.addCriterion("sort_order <", value, "sortOrder");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andSortOrderLessThanOrEqualTo(int value) {
            this.addCriterion("sort_order <=", value, "sortOrder");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andSortOrderLike(String value) {
            this.addCriterion("sort_order like", value, "sortOrder");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andSortOrderNotLike(String value) {
            this.addCriterion("sort_order not like", value, "sortOrder");
            return (ShiguOuterMarketExample.Criteria)this;
        }        public ShiguOuterMarketExample.Criteria andSortOrderIn(List<Integer> values) {
            this.addCriterion("sort_order in", values, "sortOrder");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andSortOrderNotIn(List<Integer> values) {
            this.addCriterion("sort_order not in", values, "sortOrder");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andSortOrderBetween(int value1, int value2) {
            this.addCriterion("sort_order between", value1, value2, "sortOrder");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andSortOrderNotBetween(int value1, int value2) {
            this.addCriterion("sort_order not between", value1, value2, "sortOrder");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketNameIsNull() {
            this.addCriterion("market_name is null");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketNameIsNotNull() {
            this.addCriterion("market_name is not null");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketNameEqualTo(String value) {
            this.addCriterion("market_name =", value, "marketName");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketNameNotEqualTo(String value) {
            this.addCriterion("market_name <>", value, "marketName");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketNameGreaterThan(String value) {
            this.addCriterion("market_name >", value, "marketName");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("market_name >=", value, "marketName");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketNameLessThan(String value) {
            this.addCriterion("market_name <", value, "marketName");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketNameLessThanOrEqualTo(String value) {
            this.addCriterion("market_name <=", value, "marketName");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketNameLike(String value) {
            this.addCriterion("market_name like", value, "marketName");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketNameNotLike(String value) {
            this.addCriterion("market_name not like", value, "marketName");
            return (ShiguOuterMarketExample.Criteria)this;
        }        public ShiguOuterMarketExample.Criteria andMarketNameIn(List<String> values) {
            this.addCriterion("market_name in", values, "marketName");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketNameNotIn(List<String> values) {
            this.addCriterion("market_name not in", values, "marketName");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketNameBetween(String value1, String value2) {
            this.addCriterion("market_name between", value1, value2, "marketName");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andMarketNameNotBetween(String value1, String value2) {
            this.addCriterion("market_name not between", value1, value2, "marketName");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsIsNull() {
            this.addCriterion("outer_floor_ids is null");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsIsNotNull() {
            this.addCriterion("outer_floor_ids is not null");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsEqualTo(String value) {
            this.addCriterion("outer_floor_ids =", value, "outerFloorIds");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsNotEqualTo(String value) {
            this.addCriterion("outer_floor_ids <>", value, "outerFloorIds");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsGreaterThan(String value) {
            this.addCriterion("outer_floor_ids >", value, "outerFloorIds");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsGreaterThanOrEqualTo(String value) {
            this.addCriterion("outer_floor_ids >=", value, "outerFloorIds");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsLessThan(String value) {
            this.addCriterion("outer_floor_ids <", value, "outerFloorIds");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsLessThanOrEqualTo(String value) {
            this.addCriterion("outer_floor_ids <=", value, "outerFloorIds");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsLike(String value) {
            this.addCriterion("outer_floor_ids like", value, "outerFloorIds");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsNotLike(String value) {
            this.addCriterion("outer_floor_ids not like", value, "outerFloorIds");
            return (ShiguOuterMarketExample.Criteria)this;
        }        public ShiguOuterMarketExample.Criteria andOuterFloorIdsIn(List<String> values) {
            this.addCriterion("outer_floor_ids in", values, "outerFloorIds");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsNotIn(List<String> values) {
            this.addCriterion("outer_floor_ids not in", values, "outerFloorIds");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsBetween(String value1, String value2) {
            this.addCriterion("outer_floor_ids between", value1, value2, "outerFloorIds");
            return (ShiguOuterMarketExample.Criteria)this;
        }

        public ShiguOuterMarketExample.Criteria andOuterFloorIdsNotBetween(String value1, String value2) {
            this.addCriterion("outer_floor_ids not between", value1, value2, "outerFloorIds");
            return (ShiguOuterMarketExample.Criteria)this;
        }
    }
}
