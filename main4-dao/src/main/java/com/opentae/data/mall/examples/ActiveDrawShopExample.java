package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ActiveDrawShopExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ActiveDrawShopExample.Criteria> oredCriteria = new ArrayList();

    public ActiveDrawShopExample() {
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

    public List<ActiveDrawShopExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ActiveDrawShopExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ActiveDrawShopExample.Criteria or() {
        ActiveDrawShopExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ActiveDrawShopExample.Criteria createCriteria() {
        ActiveDrawShopExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ActiveDrawShopExample.Criteria createCriteriaInternal() {
        ActiveDrawShopExample.Criteria criteria = new ActiveDrawShopExample.Criteria();
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

    public static class Criteria extends ActiveDrawShopExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ActiveDrawShopExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ActiveDrawShopExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ActiveDrawShopExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ActiveDrawShopExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ActiveDrawShopExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ActiveDrawShopExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ActiveDrawShopExample.Criteria andIdIsNull() {
            this.addCriterion("id is null");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andIdIsNotNull() {
            this.addCriterion("id is not null");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andIdEqualTo(Long value) {
            this.addCriterion("id =", value, "id");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andIdNotEqualTo(Long value) {
            this.addCriterion("id <>", value, "id");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andIdGreaterThan(Long value) {
            this.addCriterion("id >", value, "id");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("id >=", value, "id");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andIdLessThan(Long value) {
            this.addCriterion("id <", value, "id");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andIdLessThanOrEqualTo(Long value) {
            this.addCriterion("id <=", value, "id");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andIdLike(String value) {
            this.addCriterion("id like", value, "id");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andIdNotLike(String value) {
            this.addCriterion("id not like", value, "id");
            return (ActiveDrawShopExample.Criteria)this;
        }        public ActiveDrawShopExample.Criteria andIdIn(List<Long> values) {
            this.addCriterion("id in", values, "id");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andIdNotIn(List<Long> values) {
            this.addCriterion("id not in", values, "id");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andIdBetween(Long value1, Long value2) {
            this.addCriterion("id between", value1, value2, "id");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andIdNotBetween(Long value1, Long value2) {
            this.addCriterion("id not between", value1, value2, "id");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPemIdIsNull() {
            this.addCriterion("pem_id is null");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPemIdIsNotNull() {
            this.addCriterion("pem_id is not null");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPemIdEqualTo(Long value) {
            this.addCriterion("pem_id =", value, "pemId");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPemIdNotEqualTo(Long value) {
            this.addCriterion("pem_id <>", value, "pemId");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPemIdGreaterThan(Long value) {
            this.addCriterion("pem_id >", value, "pemId");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPemIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("pem_id >=", value, "pemId");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPemIdLessThan(Long value) {
            this.addCriterion("pem_id <", value, "pemId");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPemIdLessThanOrEqualTo(Long value) {
            this.addCriterion("pem_id <=", value, "pemId");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPemIdLike(String value) {
            this.addCriterion("pem_id like", value, "pemId");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPemIdNotLike(String value) {
            this.addCriterion("pem_id not like", value, "pemId");
            return (ActiveDrawShopExample.Criteria)this;
        }        public ActiveDrawShopExample.Criteria andPemIdIn(List<Long> values) {
            this.addCriterion("pem_id in", values, "pemId");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPemIdNotIn(List<Long> values) {
            this.addCriterion("pem_id not in", values, "pemId");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPemIdBetween(Long value1, Long value2) {
            this.addCriterion("pem_id between", value1, value2, "pemId");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPemIdNotBetween(Long value1, Long value2) {
            this.addCriterion("pem_id not between", value1, value2, "pemId");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andShopIdIsNull() {
            this.addCriterion("shop_id is null");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andShopIdIsNotNull() {
            this.addCriterion("shop_id is not null");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andShopIdEqualTo(Long value) {
            this.addCriterion("shop_id =", value, "shopId");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andShopIdNotEqualTo(Long value) {
            this.addCriterion("shop_id <>", value, "shopId");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andShopIdGreaterThan(Long value) {
            this.addCriterion("shop_id >", value, "shopId");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("shop_id >=", value, "shopId");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andShopIdLessThan(Long value) {
            this.addCriterion("shop_id <", value, "shopId");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            this.addCriterion("shop_id <=", value, "shopId");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andShopIdLike(String value) {
            this.addCriterion("shop_id like", value, "shopId");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andShopIdNotLike(String value) {
            this.addCriterion("shop_id not like", value, "shopId");
            return (ActiveDrawShopExample.Criteria)this;
        }        public ActiveDrawShopExample.Criteria andShopIdIn(List<Long> values) {
            this.addCriterion("shop_id in", values, "shopId");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andShopIdNotIn(List<Long> values) {
            this.addCriterion("shop_id not in", values, "shopId");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andShopIdBetween(Long value1, Long value2) {
            this.addCriterion("shop_id between", value1, value2, "shopId");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            this.addCriterion("shop_id not between", value1, value2, "shopId");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPicUrlIsNull() {
            this.addCriterion("pic_url is null");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPicUrlIsNotNull() {
            this.addCriterion("pic_url is not null");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPicUrlEqualTo(String value) {
            this.addCriterion("pic_url =", value, "picUrl");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPicUrlNotEqualTo(String value) {
            this.addCriterion("pic_url <>", value, "picUrl");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPicUrlGreaterThan(String value) {
            this.addCriterion("pic_url >", value, "picUrl");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("pic_url >=", value, "picUrl");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPicUrlLessThan(String value) {
            this.addCriterion("pic_url <", value, "picUrl");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPicUrlLessThanOrEqualTo(String value) {
            this.addCriterion("pic_url <=", value, "picUrl");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPicUrlLike(String value) {
            this.addCriterion("pic_url like", value, "picUrl");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPicUrlNotLike(String value) {
            this.addCriterion("pic_url not like", value, "picUrl");
            return (ActiveDrawShopExample.Criteria)this;
        }        public ActiveDrawShopExample.Criteria andPicUrlIn(List<String> values) {
            this.addCriterion("pic_url in", values, "picUrl");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPicUrlNotIn(List<String> values) {
            this.addCriterion("pic_url not in", values, "picUrl");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPicUrlBetween(String value1, String value2) {
            this.addCriterion("pic_url between", value1, value2, "picUrl");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andPicUrlNotBetween(String value1, String value2) {
            this.addCriterion("pic_url not between", value1, value2, "picUrl");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andSortIsNull() {
            this.addCriterion("sort is null");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andSortIsNotNull() {
            this.addCriterion("sort is not null");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andSortEqualTo(Integer value) {
            this.addCriterion("sort =", value, "sort");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andSortNotEqualTo(Integer value) {
            this.addCriterion("sort <>", value, "sort");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andSortGreaterThan(Integer value) {
            this.addCriterion("sort >", value, "sort");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andSortGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("sort >=", value, "sort");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andSortLessThan(Integer value) {
            this.addCriterion("sort <", value, "sort");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andSortLessThanOrEqualTo(Integer value) {
            this.addCriterion("sort <=", value, "sort");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andSortLike(String value) {
            this.addCriterion("sort like", value, "sort");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andSortNotLike(String value) {
            this.addCriterion("sort not like", value, "sort");
            return (ActiveDrawShopExample.Criteria)this;
        }        public ActiveDrawShopExample.Criteria andSortIn(List<Integer> values) {
            this.addCriterion("sort in", values, "sort");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andSortNotIn(List<Integer> values) {
            this.addCriterion("sort not in", values, "sort");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andSortBetween(Integer value1, Integer value2) {
            this.addCriterion("sort between", value1, value2, "sort");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andSortNotBetween(Integer value1, Integer value2) {
            this.addCriterion("sort not between", value1, value2, "sort");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andCreateTimeIsNull() {
            this.addCriterion("create_time is null");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andCreateTimeIsNotNull() {
            this.addCriterion("create_time is not null");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andCreateTimeEqualTo(Date value) {
            this.addCriterion("create_time =", value, "createTime");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andCreateTimeNotEqualTo(Date value) {
            this.addCriterion("create_time <>", value, "createTime");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andCreateTimeGreaterThan(Date value) {
            this.addCriterion("create_time >", value, "createTime");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("create_time >=", value, "createTime");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andCreateTimeLessThan(Date value) {
            this.addCriterion("create_time <", value, "createTime");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("create_time <=", value, "createTime");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andCreateTimeLike(String value) {
            this.addCriterion("create_time like", value, "createTime");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andCreateTimeNotLike(String value) {
            this.addCriterion("create_time not like", value, "createTime");
            return (ActiveDrawShopExample.Criteria)this;
        }        public ActiveDrawShopExample.Criteria andCreateTimeIn(List<Date> values) {
            this.addCriterion("create_time in", values, "createTime");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andCreateTimeNotIn(List<Date> values) {
            this.addCriterion("create_time not in", values, "createTime");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            this.addCriterion("create_time between", value1, value2, "createTime");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("create_time not between", value1, value2, "createTime");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andModifyTimeIsNull() {
            this.addCriterion("modify_time is null");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andModifyTimeIsNotNull() {
            this.addCriterion("modify_time is not null");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andModifyTimeEqualTo(Date value) {
            this.addCriterion("modify_time =", value, "modifyTime");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andModifyTimeNotEqualTo(Date value) {
            this.addCriterion("modify_time <>", value, "modifyTime");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andModifyTimeGreaterThan(Date value) {
            this.addCriterion("modify_time >", value, "modifyTime");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            this.addCriterion("modify_time >=", value, "modifyTime");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andModifyTimeLessThan(Date value) {
            this.addCriterion("modify_time <", value, "modifyTime");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            this.addCriterion("modify_time <=", value, "modifyTime");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andModifyTimeLike(String value) {
            this.addCriterion("modify_time like", value, "modifyTime");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andModifyTimeNotLike(String value) {
            this.addCriterion("modify_time not like", value, "modifyTime");
            return (ActiveDrawShopExample.Criteria)this;
        }        public ActiveDrawShopExample.Criteria andModifyTimeIn(List<Date> values) {
            this.addCriterion("modify_time in", values, "modifyTime");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andModifyTimeNotIn(List<Date> values) {
            this.addCriterion("modify_time not in", values, "modifyTime");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andModifyTimeBetween(Date value1, Date value2) {
            this.addCriterion("modify_time between", value1, value2, "modifyTime");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            this.addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andEnabledIsNull() {
            this.addCriterion("enabled is null");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andEnabledIsNotNull() {
            this.addCriterion("enabled is not null");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andEnabledEqualTo(Boolean value) {
            this.addCriterion("enabled =", value, "enabled");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andEnabledNotEqualTo(Boolean value) {
            this.addCriterion("enabled <>", value, "enabled");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andEnabledGreaterThan(Boolean value) {
            this.addCriterion("enabled >", value, "enabled");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andEnabledGreaterThanOrEqualTo(Boolean value) {
            this.addCriterion("enabled >=", value, "enabled");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andEnabledLessThan(Boolean value) {
            this.addCriterion("enabled <", value, "enabled");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andEnabledLessThanOrEqualTo(Boolean value) {
            this.addCriterion("enabled <=", value, "enabled");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andEnabledLike(String value) {
            this.addCriterion("enabled like", value, "enabled");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andEnabledNotLike(String value) {
            this.addCriterion("enabled not like", value, "enabled");
            return (ActiveDrawShopExample.Criteria)this;
        }        public ActiveDrawShopExample.Criteria andEnabledIn(List<Boolean> values) {
            this.addCriterion("enabled in", values, "enabled");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andEnabledNotIn(List<Boolean> values) {
            this.addCriterion("enabled not in", values, "enabled");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andEnabledBetween(Boolean value1, Boolean value2) {
            this.addCriterion("enabled between", value1, value2, "enabled");
            return (ActiveDrawShopExample.Criteria)this;
        }

        public ActiveDrawShopExample.Criteria andEnabledNotBetween(Boolean value1, Boolean value2) {
            this.addCriterion("enabled not between", value1, value2, "enabled");
            return (ActiveDrawShopExample.Criteria)this;
        }
    }
}
