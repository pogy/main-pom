package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShiguStoreCollectExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguStoreCollectExample.Criteria> oredCriteria = new ArrayList();

    public ShiguStoreCollectExample() {
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

    public List<ShiguStoreCollectExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguStoreCollectExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguStoreCollectExample.Criteria or() {
        ShiguStoreCollectExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguStoreCollectExample.Criteria createCriteria() {
        ShiguStoreCollectExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguStoreCollectExample.Criteria createCriteriaInternal() {
        ShiguStoreCollectExample.Criteria criteria = new ShiguStoreCollectExample.Criteria();
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

    public static class Criteria extends ShiguStoreCollectExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguStoreCollectExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguStoreCollectExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguStoreCollectExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguStoreCollectExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguStoreCollectExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguStoreCollectExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguStoreCollectExample.Criteria andStoreCollectIdIsNull() {
            this.addCriterion("store_collect_id is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreCollectIdIsNotNull() {
            this.addCriterion("store_collect_id is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreCollectIdEqualTo(Long value) {
            this.addCriterion("store_collect_id =", value, "storeCollectId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreCollectIdNotEqualTo(Long value) {
            this.addCriterion("store_collect_id <>", value, "storeCollectId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreCollectIdGreaterThan(Long value) {
            this.addCriterion("store_collect_id >", value, "storeCollectId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreCollectIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("store_collect_id >=", value, "storeCollectId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreCollectIdLessThan(Long value) {
            this.addCriterion("store_collect_id <", value, "storeCollectId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreCollectIdLessThanOrEqualTo(Long value) {
            this.addCriterion("store_collect_id <=", value, "storeCollectId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreCollectIdLike(String value) {
            this.addCriterion("store_collect_id like", value, "storeCollectId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreCollectIdNotLike(String value) {
            this.addCriterion("store_collect_id not like", value, "storeCollectId");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andStoreCollectIdIn(List<Long> values) {
            this.addCriterion("store_collect_id in", values, "storeCollectId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreCollectIdNotIn(List<Long> values) {
            this.addCriterion("store_collect_id not in", values, "storeCollectId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreCollectIdBetween(Long value1, Long value2) {
            this.addCriterion("store_collect_id between", value1, value2, "storeCollectId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreCollectIdNotBetween(Long value1, Long value2) {
            this.addCriterion("store_collect_id not between", value1, value2, "storeCollectId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreIdIsNull() {
            this.addCriterion("store_id is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreIdIsNotNull() {
            this.addCriterion("store_id is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreIdEqualTo(Long value) {
            this.addCriterion("store_id =", value, "storeId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreIdNotEqualTo(Long value) {
            this.addCriterion("store_id <>", value, "storeId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreIdGreaterThan(Long value) {
            this.addCriterion("store_id >", value, "storeId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("store_id >=", value, "storeId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreIdLessThan(Long value) {
            this.addCriterion("store_id <", value, "storeId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            this.addCriterion("store_id <=", value, "storeId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreIdLike(String value) {
            this.addCriterion("store_id like", value, "storeId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreIdNotLike(String value) {
            this.addCriterion("store_id not like", value, "storeId");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andStoreIdIn(List<Long> values) {
            this.addCriterion("store_id in", values, "storeId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreIdNotIn(List<Long> values) {
            this.addCriterion("store_id not in", values, "storeId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            this.addCriterion("store_id between", value1, value2, "storeId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            this.addCriterion("store_id not between", value1, value2, "storeId");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUseStatusIsNull() {
            this.addCriterion("use_status is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUseStatusIsNotNull() {
            this.addCriterion("use_status is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUseStatusEqualTo(Integer value) {
            this.addCriterion("use_status =", value, "useStatus");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUseStatusNotEqualTo(Integer value) {
            this.addCriterion("use_status <>", value, "useStatus");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUseStatusGreaterThan(Integer value) {
            this.addCriterion("use_status >", value, "useStatus");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("use_status >=", value, "useStatus");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUseStatusLessThan(Integer value) {
            this.addCriterion("use_status <", value, "useStatus");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("use_status <=", value, "useStatus");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUseStatusLike(String value) {
            this.addCriterion("use_status like", value, "useStatus");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUseStatusNotLike(String value) {
            this.addCriterion("use_status not like", value, "useStatus");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andUseStatusIn(List<Integer> values) {
            this.addCriterion("use_status in", values, "useStatus");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUseStatusNotIn(List<Integer> values) {
            this.addCriterion("use_status not in", values, "useStatus");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUseStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("use_status between", value1, value2, "useStatus");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("use_status not between", value1, value2, "useStatus");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andSortOrderIsNull() {
            this.addCriterion("sort_order is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andSortOrderIsNotNull() {
            this.addCriterion("sort_order is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andSortOrderEqualTo(Long value) {
            this.addCriterion("sort_order =", value, "sortOrder");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andSortOrderNotEqualTo(Long value) {
            this.addCriterion("sort_order <>", value, "sortOrder");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andSortOrderGreaterThan(Long value) {
            this.addCriterion("sort_order >", value, "sortOrder");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andSortOrderGreaterThanOrEqualTo(Long value) {
            this.addCriterion("sort_order >=", value, "sortOrder");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andSortOrderLessThan(Long value) {
            this.addCriterion("sort_order <", value, "sortOrder");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andSortOrderLessThanOrEqualTo(Long value) {
            this.addCriterion("sort_order <=", value, "sortOrder");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andSortOrderLike(String value) {
            this.addCriterion("sort_order like", value, "sortOrder");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andSortOrderNotLike(String value) {
            this.addCriterion("sort_order not like", value, "sortOrder");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andSortOrderIn(List<Long> values) {
            this.addCriterion("sort_order in", values, "sortOrder");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andSortOrderNotIn(List<Long> values) {
            this.addCriterion("sort_order not in", values, "sortOrder");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andSortOrderBetween(Long value1, Long value2) {
            this.addCriterion("sort_order between", value1, value2, "sortOrder");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andSortOrderNotBetween(Long value1, Long value2) {
            this.addCriterion("sort_order not between", value1, value2, "sortOrder");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andWebSiteIsNull() {
            this.addCriterion("web_site is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andWebSiteIsNotNull() {
            this.addCriterion("web_site is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("web_site =", value, "webSite");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("web_site <>", value, "webSite");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("web_site >", value, "webSite");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("web_site >=", value, "webSite");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andWebSiteLessThan(String value) {
            this.addCriterion("web_site <", value, "webSite");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("web_site <=", value, "webSite");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andWebSiteLike(String value) {
            this.addCriterion("web_site like", value, "webSite");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andWebSiteNotLike(String value) {
            this.addCriterion("web_site not like", value, "webSite");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("web_site in", values, "webSite");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("web_site not in", values, "webSite");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("web_site between", value1, value2, "webSite");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("web_site not between", value1, value2, "webSite");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark11IsNull() {
            this.addCriterion("remark11 is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark11IsNotNull() {
            this.addCriterion("remark11 is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark11EqualTo(String value) {
            this.addCriterion("remark11 =", value, "remark11");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark11NotEqualTo(String value) {
            this.addCriterion("remark11 <>", value, "remark11");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark11GreaterThan(String value) {
            this.addCriterion("remark11 >", value, "remark11");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark11GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark11 >=", value, "remark11");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark11LessThan(String value) {
            this.addCriterion("remark11 <", value, "remark11");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark11LessThanOrEqualTo(String value) {
            this.addCriterion("remark11 <=", value, "remark11");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark11Like(String value) {
            this.addCriterion("remark11 like", value, "remark11");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark11NotLike(String value) {
            this.addCriterion("remark11 not like", value, "remark11");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andRemark11In(List<String> values) {
            this.addCriterion("remark11 in", values, "remark11");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark11NotIn(List<String> values) {
            this.addCriterion("remark11 not in", values, "remark11");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark11Between(String value1, String value2) {
            this.addCriterion("remark11 between", value1, value2, "remark11");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark11NotBetween(String value1, String value2) {
            this.addCriterion("remark11 not between", value1, value2, "remark11");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark12IsNull() {
            this.addCriterion("remark12 is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark12IsNotNull() {
            this.addCriterion("remark12 is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark12EqualTo(String value) {
            this.addCriterion("remark12 =", value, "remark12");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark12NotEqualTo(String value) {
            this.addCriterion("remark12 <>", value, "remark12");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark12GreaterThan(String value) {
            this.addCriterion("remark12 >", value, "remark12");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark12GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark12 >=", value, "remark12");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark12LessThan(String value) {
            this.addCriterion("remark12 <", value, "remark12");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark12LessThanOrEqualTo(String value) {
            this.addCriterion("remark12 <=", value, "remark12");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark12Like(String value) {
            this.addCriterion("remark12 like", value, "remark12");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark12NotLike(String value) {
            this.addCriterion("remark12 not like", value, "remark12");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andRemark12In(List<String> values) {
            this.addCriterion("remark12 in", values, "remark12");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark12NotIn(List<String> values) {
            this.addCriterion("remark12 not in", values, "remark12");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark12Between(String value1, String value2) {
            this.addCriterion("remark12 between", value1, value2, "remark12");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark12NotBetween(String value1, String value2) {
            this.addCriterion("remark12 not between", value1, value2, "remark12");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark13IsNull() {
            this.addCriterion("remark13 is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark13IsNotNull() {
            this.addCriterion("remark13 is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark13EqualTo(String value) {
            this.addCriterion("remark13 =", value, "remark13");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark13NotEqualTo(String value) {
            this.addCriterion("remark13 <>", value, "remark13");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark13GreaterThan(String value) {
            this.addCriterion("remark13 >", value, "remark13");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark13GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark13 >=", value, "remark13");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark13LessThan(String value) {
            this.addCriterion("remark13 <", value, "remark13");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark13LessThanOrEqualTo(String value) {
            this.addCriterion("remark13 <=", value, "remark13");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark13Like(String value) {
            this.addCriterion("remark13 like", value, "remark13");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark13NotLike(String value) {
            this.addCriterion("remark13 not like", value, "remark13");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andRemark13In(List<String> values) {
            this.addCriterion("remark13 in", values, "remark13");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark13NotIn(List<String> values) {
            this.addCriterion("remark13 not in", values, "remark13");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark13Between(String value1, String value2) {
            this.addCriterion("remark13 between", value1, value2, "remark13");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark13NotBetween(String value1, String value2) {
            this.addCriterion("remark13 not between", value1, value2, "remark13");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark14IsNull() {
            this.addCriterion("remark14 is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark14IsNotNull() {
            this.addCriterion("remark14 is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark14EqualTo(String value) {
            this.addCriterion("remark14 =", value, "remark14");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark14NotEqualTo(String value) {
            this.addCriterion("remark14 <>", value, "remark14");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark14GreaterThan(String value) {
            this.addCriterion("remark14 >", value, "remark14");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark14GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark14 >=", value, "remark14");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark14LessThan(String value) {
            this.addCriterion("remark14 <", value, "remark14");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark14LessThanOrEqualTo(String value) {
            this.addCriterion("remark14 <=", value, "remark14");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark14Like(String value) {
            this.addCriterion("remark14 like", value, "remark14");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark14NotLike(String value) {
            this.addCriterion("remark14 not like", value, "remark14");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andRemark14In(List<String> values) {
            this.addCriterion("remark14 in", values, "remark14");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark14NotIn(List<String> values) {
            this.addCriterion("remark14 not in", values, "remark14");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark14Between(String value1, String value2) {
            this.addCriterion("remark14 between", value1, value2, "remark14");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark14NotBetween(String value1, String value2) {
            this.addCriterion("remark14 not between", value1, value2, "remark14");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark15IsNull() {
            this.addCriterion("remark15 is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark15IsNotNull() {
            this.addCriterion("remark15 is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark15EqualTo(String value) {
            this.addCriterion("remark15 =", value, "remark15");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark15NotEqualTo(String value) {
            this.addCriterion("remark15 <>", value, "remark15");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark15GreaterThan(String value) {
            this.addCriterion("remark15 >", value, "remark15");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark15GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark15 >=", value, "remark15");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark15LessThan(String value) {
            this.addCriterion("remark15 <", value, "remark15");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark15LessThanOrEqualTo(String value) {
            this.addCriterion("remark15 <=", value, "remark15");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark15Like(String value) {
            this.addCriterion("remark15 like", value, "remark15");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark15NotLike(String value) {
            this.addCriterion("remark15 not like", value, "remark15");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andRemark15In(List<String> values) {
            this.addCriterion("remark15 in", values, "remark15");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark15NotIn(List<String> values) {
            this.addCriterion("remark15 not in", values, "remark15");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark15Between(String value1, String value2) {
            this.addCriterion("remark15 between", value1, value2, "remark15");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark15NotBetween(String value1, String value2) {
            this.addCriterion("remark15 not between", value1, value2, "remark15");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark16IsNull() {
            this.addCriterion("remark16 is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark16IsNotNull() {
            this.addCriterion("remark16 is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark16EqualTo(String value) {
            this.addCriterion("remark16 =", value, "remark16");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark16NotEqualTo(String value) {
            this.addCriterion("remark16 <>", value, "remark16");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark16GreaterThan(String value) {
            this.addCriterion("remark16 >", value, "remark16");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark16GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark16 >=", value, "remark16");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark16LessThan(String value) {
            this.addCriterion("remark16 <", value, "remark16");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark16LessThanOrEqualTo(String value) {
            this.addCriterion("remark16 <=", value, "remark16");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark16Like(String value) {
            this.addCriterion("remark16 like", value, "remark16");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark16NotLike(String value) {
            this.addCriterion("remark16 not like", value, "remark16");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andRemark16In(List<String> values) {
            this.addCriterion("remark16 in", values, "remark16");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark16NotIn(List<String> values) {
            this.addCriterion("remark16 not in", values, "remark16");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark16Between(String value1, String value2) {
            this.addCriterion("remark16 between", value1, value2, "remark16");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark16NotBetween(String value1, String value2) {
            this.addCriterion("remark16 not between", value1, value2, "remark16");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark17IsNull() {
            this.addCriterion("remark17 is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark17IsNotNull() {
            this.addCriterion("remark17 is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark17EqualTo(String value) {
            this.addCriterion("remark17 =", value, "remark17");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark17NotEqualTo(String value) {
            this.addCriterion("remark17 <>", value, "remark17");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark17GreaterThan(String value) {
            this.addCriterion("remark17 >", value, "remark17");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark17GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark17 >=", value, "remark17");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark17LessThan(String value) {
            this.addCriterion("remark17 <", value, "remark17");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark17LessThanOrEqualTo(String value) {
            this.addCriterion("remark17 <=", value, "remark17");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark17Like(String value) {
            this.addCriterion("remark17 like", value, "remark17");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark17NotLike(String value) {
            this.addCriterion("remark17 not like", value, "remark17");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andRemark17In(List<String> values) {
            this.addCriterion("remark17 in", values, "remark17");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark17NotIn(List<String> values) {
            this.addCriterion("remark17 not in", values, "remark17");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark17Between(String value1, String value2) {
            this.addCriterion("remark17 between", value1, value2, "remark17");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark17NotBetween(String value1, String value2) {
            this.addCriterion("remark17 not between", value1, value2, "remark17");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark18IsNull() {
            this.addCriterion("remark18 is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark18IsNotNull() {
            this.addCriterion("remark18 is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark18EqualTo(String value) {
            this.addCriterion("remark18 =", value, "remark18");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark18NotEqualTo(String value) {
            this.addCriterion("remark18 <>", value, "remark18");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark18GreaterThan(String value) {
            this.addCriterion("remark18 >", value, "remark18");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark18GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark18 >=", value, "remark18");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark18LessThan(String value) {
            this.addCriterion("remark18 <", value, "remark18");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark18LessThanOrEqualTo(String value) {
            this.addCriterion("remark18 <=", value, "remark18");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark18Like(String value) {
            this.addCriterion("remark18 like", value, "remark18");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark18NotLike(String value) {
            this.addCriterion("remark18 not like", value, "remark18");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andRemark18In(List<String> values) {
            this.addCriterion("remark18 in", values, "remark18");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark18NotIn(List<String> values) {
            this.addCriterion("remark18 not in", values, "remark18");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark18Between(String value1, String value2) {
            this.addCriterion("remark18 between", value1, value2, "remark18");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark18NotBetween(String value1, String value2) {
            this.addCriterion("remark18 not between", value1, value2, "remark18");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark19IsNull() {
            this.addCriterion("remark19 is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark19IsNotNull() {
            this.addCriterion("remark19 is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark19EqualTo(String value) {
            this.addCriterion("remark19 =", value, "remark19");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark19NotEqualTo(String value) {
            this.addCriterion("remark19 <>", value, "remark19");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark19GreaterThan(String value) {
            this.addCriterion("remark19 >", value, "remark19");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark19GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark19 >=", value, "remark19");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark19LessThan(String value) {
            this.addCriterion("remark19 <", value, "remark19");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark19LessThanOrEqualTo(String value) {
            this.addCriterion("remark19 <=", value, "remark19");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark19Like(String value) {
            this.addCriterion("remark19 like", value, "remark19");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark19NotLike(String value) {
            this.addCriterion("remark19 not like", value, "remark19");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andRemark19In(List<String> values) {
            this.addCriterion("remark19 in", values, "remark19");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark19NotIn(List<String> values) {
            this.addCriterion("remark19 not in", values, "remark19");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark19Between(String value1, String value2) {
            this.addCriterion("remark19 between", value1, value2, "remark19");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark19NotBetween(String value1, String value2) {
            this.addCriterion("remark19 not between", value1, value2, "remark19");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark20IsNull() {
            this.addCriterion("remark20 is null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark20IsNotNull() {
            this.addCriterion("remark20 is not null");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark20EqualTo(String value) {
            this.addCriterion("remark20 =", value, "remark20");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark20NotEqualTo(String value) {
            this.addCriterion("remark20 <>", value, "remark20");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark20GreaterThan(String value) {
            this.addCriterion("remark20 >", value, "remark20");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark20GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark20 >=", value, "remark20");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark20LessThan(String value) {
            this.addCriterion("remark20 <", value, "remark20");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark20LessThanOrEqualTo(String value) {
            this.addCriterion("remark20 <=", value, "remark20");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark20Like(String value) {
            this.addCriterion("remark20 like", value, "remark20");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark20NotLike(String value) {
            this.addCriterion("remark20 not like", value, "remark20");
            return (ShiguStoreCollectExample.Criteria)this;
        }        public ShiguStoreCollectExample.Criteria andRemark20In(List<String> values) {
            this.addCriterion("remark20 in", values, "remark20");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark20NotIn(List<String> values) {
            this.addCriterion("remark20 not in", values, "remark20");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark20Between(String value1, String value2) {
            this.addCriterion("remark20 between", value1, value2, "remark20");
            return (ShiguStoreCollectExample.Criteria)this;
        }

        public ShiguStoreCollectExample.Criteria andRemark20NotBetween(String value1, String value2) {
            this.addCriterion("remark20 not between", value1, value2, "remark20");
            return (ShiguStoreCollectExample.Criteria)this;
        }
    }
}
