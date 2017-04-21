package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShiguGoodsDataPackageExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguGoodsDataPackageExample.Criteria> oredCriteria = new ArrayList();

    public ShiguGoodsDataPackageExample() {
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

    public List<ShiguGoodsDataPackageExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguGoodsDataPackageExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguGoodsDataPackageExample.Criteria or() {
        ShiguGoodsDataPackageExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguGoodsDataPackageExample.Criteria createCriteria() {
        ShiguGoodsDataPackageExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguGoodsDataPackageExample.Criteria createCriteriaInternal() {
        ShiguGoodsDataPackageExample.Criteria criteria = new ShiguGoodsDataPackageExample.Criteria();
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

    public static class Criteria extends ShiguGoodsDataPackageExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguGoodsDataPackageExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguGoodsDataPackageExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguGoodsDataPackageExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguGoodsDataPackageExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguGoodsDataPackageExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguGoodsDataPackageExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdIsNull() {
            this.addCriterion("data_package_id is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdIsNotNull() {
            this.addCriterion("data_package_id is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdEqualTo(Long value) {
            this.addCriterion("data_package_id =", value, "dataPackageId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdNotEqualTo(Long value) {
            this.addCriterion("data_package_id <>", value, "dataPackageId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdGreaterThan(Long value) {
            this.addCriterion("data_package_id >", value, "dataPackageId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("data_package_id >=", value, "dataPackageId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdLessThan(Long value) {
            this.addCriterion("data_package_id <", value, "dataPackageId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdLessThanOrEqualTo(Long value) {
            this.addCriterion("data_package_id <=", value, "dataPackageId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdLike(String value) {
            this.addCriterion("data_package_id like", value, "dataPackageId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdNotLike(String value) {
            this.addCriterion("data_package_id not like", value, "dataPackageId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdIn(List<Long> values) {
            this.addCriterion("data_package_id in", values, "dataPackageId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdNotIn(List<Long> values) {
            this.addCriterion("data_package_id not in", values, "dataPackageId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdBetween(Long value1, Long value2) {
            this.addCriterion("data_package_id between", value1, value2, "dataPackageId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageIdNotBetween(Long value1, Long value2) {
            this.addCriterion("data_package_id not between", value1, value2, "dataPackageId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUserIdIsNull() {
            this.addCriterion("user_id is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUserIdIsNotNull() {
            this.addCriterion("user_id is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUserIdEqualTo(Long value) {
            this.addCriterion("user_id =", value, "userId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUserIdNotEqualTo(Long value) {
            this.addCriterion("user_id <>", value, "userId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUserIdGreaterThan(Long value) {
            this.addCriterion("user_id >", value, "userId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("user_id >=", value, "userId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUserIdLessThan(Long value) {
            this.addCriterion("user_id <", value, "userId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            this.addCriterion("user_id <=", value, "userId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUserIdLike(String value) {
            this.addCriterion("user_id like", value, "userId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUserIdNotLike(String value) {
            this.addCriterion("user_id not like", value, "userId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andUserIdIn(List<Long> values) {
            this.addCriterion("user_id in", values, "userId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUserIdNotIn(List<Long> values) {
            this.addCriterion("user_id not in", values, "userId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUserIdBetween(Long value1, Long value2) {
            this.addCriterion("user_id between", value1, value2, "userId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            this.addCriterion("user_id not between", value1, value2, "userId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andGoodsIdIsNull() {
            this.addCriterion("goods_id is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andGoodsIdIsNotNull() {
            this.addCriterion("goods_id is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andGoodsIdEqualTo(Long value) {
            this.addCriterion("goods_id =", value, "goodsId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andGoodsIdNotEqualTo(Long value) {
            this.addCriterion("goods_id <>", value, "goodsId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andGoodsIdGreaterThan(Long value) {
            this.addCriterion("goods_id >", value, "goodsId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("goods_id >=", value, "goodsId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andGoodsIdLessThan(Long value) {
            this.addCriterion("goods_id <", value, "goodsId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            this.addCriterion("goods_id <=", value, "goodsId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andGoodsIdLike(String value) {
            this.addCriterion("goods_id like", value, "goodsId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andGoodsIdNotLike(String value) {
            this.addCriterion("goods_id not like", value, "goodsId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andGoodsIdIn(List<Long> values) {
            this.addCriterion("goods_id in", values, "goodsId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andGoodsIdNotIn(List<Long> values) {
            this.addCriterion("goods_id not in", values, "goodsId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            this.addCriterion("goods_id between", value1, value2, "goodsId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            this.addCriterion("goods_id not between", value1, value2, "goodsId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathIsNull() {
            this.addCriterion("data_package_save_path is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathIsNotNull() {
            this.addCriterion("data_package_save_path is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathEqualTo(String value) {
            this.addCriterion("data_package_save_path =", value, "dataPackageSavePath");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathNotEqualTo(String value) {
            this.addCriterion("data_package_save_path <>", value, "dataPackageSavePath");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathGreaterThan(String value) {
            this.addCriterion("data_package_save_path >", value, "dataPackageSavePath");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathGreaterThanOrEqualTo(String value) {
            this.addCriterion("data_package_save_path >=", value, "dataPackageSavePath");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathLessThan(String value) {
            this.addCriterion("data_package_save_path <", value, "dataPackageSavePath");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathLessThanOrEqualTo(String value) {
            this.addCriterion("data_package_save_path <=", value, "dataPackageSavePath");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathLike(String value) {
            this.addCriterion("data_package_save_path like", value, "dataPackageSavePath");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathNotLike(String value) {
            this.addCriterion("data_package_save_path not like", value, "dataPackageSavePath");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathIn(List<String> values) {
            this.addCriterion("data_package_save_path in", values, "dataPackageSavePath");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathNotIn(List<String> values) {
            this.addCriterion("data_package_save_path not in", values, "dataPackageSavePath");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathBetween(String value1, String value2) {
            this.addCriterion("data_package_save_path between", value1, value2, "dataPackageSavePath");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageSavePathNotBetween(String value1, String value2) {
            this.addCriterion("data_package_save_path not between", value1, value2, "dataPackageSavePath");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlIsNull() {
            this.addCriterion("data_package_url is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlIsNotNull() {
            this.addCriterion("data_package_url is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlEqualTo(String value) {
            this.addCriterion("data_package_url =", value, "dataPackageUrl");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlNotEqualTo(String value) {
            this.addCriterion("data_package_url <>", value, "dataPackageUrl");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlGreaterThan(String value) {
            this.addCriterion("data_package_url >", value, "dataPackageUrl");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlGreaterThanOrEqualTo(String value) {
            this.addCriterion("data_package_url >=", value, "dataPackageUrl");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlLessThan(String value) {
            this.addCriterion("data_package_url <", value, "dataPackageUrl");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlLessThanOrEqualTo(String value) {
            this.addCriterion("data_package_url <=", value, "dataPackageUrl");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlLike(String value) {
            this.addCriterion("data_package_url like", value, "dataPackageUrl");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlNotLike(String value) {
            this.addCriterion("data_package_url not like", value, "dataPackageUrl");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlIn(List<String> values) {
            this.addCriterion("data_package_url in", values, "dataPackageUrl");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlNotIn(List<String> values) {
            this.addCriterion("data_package_url not in", values, "dataPackageUrl");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlBetween(String value1, String value2) {
            this.addCriterion("data_package_url between", value1, value2, "dataPackageUrl");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andDataPackageUrlNotBetween(String value1, String value2) {
            this.addCriterion("data_package_url not between", value1, value2, "dataPackageUrl");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUseStatusIsNull() {
            this.addCriterion("use_status is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUseStatusIsNotNull() {
            this.addCriterion("use_status is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUseStatusEqualTo(Integer value) {
            this.addCriterion("use_status =", value, "useStatus");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUseStatusNotEqualTo(Integer value) {
            this.addCriterion("use_status <>", value, "useStatus");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUseStatusGreaterThan(Integer value) {
            this.addCriterion("use_status >", value, "useStatus");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("use_status >=", value, "useStatus");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUseStatusLessThan(Integer value) {
            this.addCriterion("use_status <", value, "useStatus");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            this.addCriterion("use_status <=", value, "useStatus");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUseStatusLike(String value) {
            this.addCriterion("use_status like", value, "useStatus");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUseStatusNotLike(String value) {
            this.addCriterion("use_status not like", value, "useStatus");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andUseStatusIn(List<Integer> values) {
            this.addCriterion("use_status in", values, "useStatus");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUseStatusNotIn(List<Integer> values) {
            this.addCriterion("use_status not in", values, "useStatus");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUseStatusBetween(Integer value1, Integer value2) {
            this.addCriterion("use_status between", value1, value2, "useStatus");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            this.addCriterion("use_status not between", value1, value2, "useStatus");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andSortOrderIsNull() {
            this.addCriterion("sort_order is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andSortOrderIsNotNull() {
            this.addCriterion("sort_order is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andSortOrderEqualTo(Long value) {
            this.addCriterion("sort_order =", value, "sortOrder");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andSortOrderNotEqualTo(Long value) {
            this.addCriterion("sort_order <>", value, "sortOrder");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andSortOrderGreaterThan(Long value) {
            this.addCriterion("sort_order >", value, "sortOrder");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andSortOrderGreaterThanOrEqualTo(Long value) {
            this.addCriterion("sort_order >=", value, "sortOrder");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andSortOrderLessThan(Long value) {
            this.addCriterion("sort_order <", value, "sortOrder");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andSortOrderLessThanOrEqualTo(Long value) {
            this.addCriterion("sort_order <=", value, "sortOrder");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andSortOrderLike(String value) {
            this.addCriterion("sort_order like", value, "sortOrder");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andSortOrderNotLike(String value) {
            this.addCriterion("sort_order not like", value, "sortOrder");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andSortOrderIn(List<Long> values) {
            this.addCriterion("sort_order in", values, "sortOrder");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andSortOrderNotIn(List<Long> values) {
            this.addCriterion("sort_order not in", values, "sortOrder");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andSortOrderBetween(Long value1, Long value2) {
            this.addCriterion("sort_order between", value1, value2, "sortOrder");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andSortOrderNotBetween(Long value1, Long value2) {
            this.addCriterion("sort_order not between", value1, value2, "sortOrder");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1IsNull() {
            this.addCriterion("remark1 is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1IsNotNull() {
            this.addCriterion("remark1 is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1EqualTo(String value) {
            this.addCriterion("remark1 =", value, "remark1");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1NotEqualTo(String value) {
            this.addCriterion("remark1 <>", value, "remark1");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1GreaterThan(String value) {
            this.addCriterion("remark1 >", value, "remark1");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark1 >=", value, "remark1");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1LessThan(String value) {
            this.addCriterion("remark1 <", value, "remark1");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            this.addCriterion("remark1 <=", value, "remark1");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1Like(String value) {
            this.addCriterion("remark1 like", value, "remark1");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1NotLike(String value) {
            this.addCriterion("remark1 not like", value, "remark1");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andRemark1In(List<String> values) {
            this.addCriterion("remark1 in", values, "remark1");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1NotIn(List<String> values) {
            this.addCriterion("remark1 not in", values, "remark1");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1Between(String value1, String value2) {
            this.addCriterion("remark1 between", value1, value2, "remark1");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark1NotBetween(String value1, String value2) {
            this.addCriterion("remark1 not between", value1, value2, "remark1");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2IsNull() {
            this.addCriterion("remark2 is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2IsNotNull() {
            this.addCriterion("remark2 is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2EqualTo(String value) {
            this.addCriterion("remark2 =", value, "remark2");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2NotEqualTo(String value) {
            this.addCriterion("remark2 <>", value, "remark2");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2GreaterThan(String value) {
            this.addCriterion("remark2 >", value, "remark2");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark2 >=", value, "remark2");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2LessThan(String value) {
            this.addCriterion("remark2 <", value, "remark2");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            this.addCriterion("remark2 <=", value, "remark2");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2Like(String value) {
            this.addCriterion("remark2 like", value, "remark2");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2NotLike(String value) {
            this.addCriterion("remark2 not like", value, "remark2");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andRemark2In(List<String> values) {
            this.addCriterion("remark2 in", values, "remark2");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2NotIn(List<String> values) {
            this.addCriterion("remark2 not in", values, "remark2");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2Between(String value1, String value2) {
            this.addCriterion("remark2 between", value1, value2, "remark2");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark2NotBetween(String value1, String value2) {
            this.addCriterion("remark2 not between", value1, value2, "remark2");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3IsNull() {
            this.addCriterion("remark3 is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3IsNotNull() {
            this.addCriterion("remark3 is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3EqualTo(String value) {
            this.addCriterion("remark3 =", value, "remark3");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3NotEqualTo(String value) {
            this.addCriterion("remark3 <>", value, "remark3");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3GreaterThan(String value) {
            this.addCriterion("remark3 >", value, "remark3");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark3 >=", value, "remark3");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3LessThan(String value) {
            this.addCriterion("remark3 <", value, "remark3");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            this.addCriterion("remark3 <=", value, "remark3");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3Like(String value) {
            this.addCriterion("remark3 like", value, "remark3");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3NotLike(String value) {
            this.addCriterion("remark3 not like", value, "remark3");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andRemark3In(List<String> values) {
            this.addCriterion("remark3 in", values, "remark3");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3NotIn(List<String> values) {
            this.addCriterion("remark3 not in", values, "remark3");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3Between(String value1, String value2) {
            this.addCriterion("remark3 between", value1, value2, "remark3");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark3NotBetween(String value1, String value2) {
            this.addCriterion("remark3 not between", value1, value2, "remark3");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4IsNull() {
            this.addCriterion("remark4 is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4IsNotNull() {
            this.addCriterion("remark4 is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4EqualTo(String value) {
            this.addCriterion("remark4 =", value, "remark4");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4NotEqualTo(String value) {
            this.addCriterion("remark4 <>", value, "remark4");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4GreaterThan(String value) {
            this.addCriterion("remark4 >", value, "remark4");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark4 >=", value, "remark4");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4LessThan(String value) {
            this.addCriterion("remark4 <", value, "remark4");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            this.addCriterion("remark4 <=", value, "remark4");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4Like(String value) {
            this.addCriterion("remark4 like", value, "remark4");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4NotLike(String value) {
            this.addCriterion("remark4 not like", value, "remark4");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andRemark4In(List<String> values) {
            this.addCriterion("remark4 in", values, "remark4");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4NotIn(List<String> values) {
            this.addCriterion("remark4 not in", values, "remark4");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4Between(String value1, String value2) {
            this.addCriterion("remark4 between", value1, value2, "remark4");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark4NotBetween(String value1, String value2) {
            this.addCriterion("remark4 not between", value1, value2, "remark4");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5IsNull() {
            this.addCriterion("remark5 is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5IsNotNull() {
            this.addCriterion("remark5 is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5EqualTo(String value) {
            this.addCriterion("remark5 =", value, "remark5");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5NotEqualTo(String value) {
            this.addCriterion("remark5 <>", value, "remark5");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5GreaterThan(String value) {
            this.addCriterion("remark5 >", value, "remark5");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark5 >=", value, "remark5");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5LessThan(String value) {
            this.addCriterion("remark5 <", value, "remark5");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            this.addCriterion("remark5 <=", value, "remark5");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5Like(String value) {
            this.addCriterion("remark5 like", value, "remark5");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5NotLike(String value) {
            this.addCriterion("remark5 not like", value, "remark5");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andRemark5In(List<String> values) {
            this.addCriterion("remark5 in", values, "remark5");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5NotIn(List<String> values) {
            this.addCriterion("remark5 not in", values, "remark5");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5Between(String value1, String value2) {
            this.addCriterion("remark5 between", value1, value2, "remark5");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark5NotBetween(String value1, String value2) {
            this.addCriterion("remark5 not between", value1, value2, "remark5");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6IsNull() {
            this.addCriterion("remark6 is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6IsNotNull() {
            this.addCriterion("remark6 is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6EqualTo(String value) {
            this.addCriterion("remark6 =", value, "remark6");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6NotEqualTo(String value) {
            this.addCriterion("remark6 <>", value, "remark6");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6GreaterThan(String value) {
            this.addCriterion("remark6 >", value, "remark6");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark6 >=", value, "remark6");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6LessThan(String value) {
            this.addCriterion("remark6 <", value, "remark6");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6LessThanOrEqualTo(String value) {
            this.addCriterion("remark6 <=", value, "remark6");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6Like(String value) {
            this.addCriterion("remark6 like", value, "remark6");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6NotLike(String value) {
            this.addCriterion("remark6 not like", value, "remark6");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andRemark6In(List<String> values) {
            this.addCriterion("remark6 in", values, "remark6");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6NotIn(List<String> values) {
            this.addCriterion("remark6 not in", values, "remark6");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6Between(String value1, String value2) {
            this.addCriterion("remark6 between", value1, value2, "remark6");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark6NotBetween(String value1, String value2) {
            this.addCriterion("remark6 not between", value1, value2, "remark6");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7IsNull() {
            this.addCriterion("remark7 is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7IsNotNull() {
            this.addCriterion("remark7 is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7EqualTo(String value) {
            this.addCriterion("remark7 =", value, "remark7");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7NotEqualTo(String value) {
            this.addCriterion("remark7 <>", value, "remark7");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7GreaterThan(String value) {
            this.addCriterion("remark7 >", value, "remark7");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark7 >=", value, "remark7");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7LessThan(String value) {
            this.addCriterion("remark7 <", value, "remark7");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7LessThanOrEqualTo(String value) {
            this.addCriterion("remark7 <=", value, "remark7");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7Like(String value) {
            this.addCriterion("remark7 like", value, "remark7");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7NotLike(String value) {
            this.addCriterion("remark7 not like", value, "remark7");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andRemark7In(List<String> values) {
            this.addCriterion("remark7 in", values, "remark7");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7NotIn(List<String> values) {
            this.addCriterion("remark7 not in", values, "remark7");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7Between(String value1, String value2) {
            this.addCriterion("remark7 between", value1, value2, "remark7");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark7NotBetween(String value1, String value2) {
            this.addCriterion("remark7 not between", value1, value2, "remark7");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8IsNull() {
            this.addCriterion("remark8 is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8IsNotNull() {
            this.addCriterion("remark8 is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8EqualTo(String value) {
            this.addCriterion("remark8 =", value, "remark8");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8NotEqualTo(String value) {
            this.addCriterion("remark8 <>", value, "remark8");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8GreaterThan(String value) {
            this.addCriterion("remark8 >", value, "remark8");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark8 >=", value, "remark8");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8LessThan(String value) {
            this.addCriterion("remark8 <", value, "remark8");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8LessThanOrEqualTo(String value) {
            this.addCriterion("remark8 <=", value, "remark8");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8Like(String value) {
            this.addCriterion("remark8 like", value, "remark8");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8NotLike(String value) {
            this.addCriterion("remark8 not like", value, "remark8");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andRemark8In(List<String> values) {
            this.addCriterion("remark8 in", values, "remark8");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8NotIn(List<String> values) {
            this.addCriterion("remark8 not in", values, "remark8");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8Between(String value1, String value2) {
            this.addCriterion("remark8 between", value1, value2, "remark8");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark8NotBetween(String value1, String value2) {
            this.addCriterion("remark8 not between", value1, value2, "remark8");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9IsNull() {
            this.addCriterion("remark9 is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9IsNotNull() {
            this.addCriterion("remark9 is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9EqualTo(String value) {
            this.addCriterion("remark9 =", value, "remark9");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9NotEqualTo(String value) {
            this.addCriterion("remark9 <>", value, "remark9");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9GreaterThan(String value) {
            this.addCriterion("remark9 >", value, "remark9");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark9 >=", value, "remark9");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9LessThan(String value) {
            this.addCriterion("remark9 <", value, "remark9");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9LessThanOrEqualTo(String value) {
            this.addCriterion("remark9 <=", value, "remark9");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9Like(String value) {
            this.addCriterion("remark9 like", value, "remark9");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9NotLike(String value) {
            this.addCriterion("remark9 not like", value, "remark9");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andRemark9In(List<String> values) {
            this.addCriterion("remark9 in", values, "remark9");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9NotIn(List<String> values) {
            this.addCriterion("remark9 not in", values, "remark9");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9Between(String value1, String value2) {
            this.addCriterion("remark9 between", value1, value2, "remark9");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark9NotBetween(String value1, String value2) {
            this.addCriterion("remark9 not between", value1, value2, "remark9");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10IsNull() {
            this.addCriterion("remark10 is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10IsNotNull() {
            this.addCriterion("remark10 is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10EqualTo(String value) {
            this.addCriterion("remark10 =", value, "remark10");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10NotEqualTo(String value) {
            this.addCriterion("remark10 <>", value, "remark10");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10GreaterThan(String value) {
            this.addCriterion("remark10 >", value, "remark10");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark10 >=", value, "remark10");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10LessThan(String value) {
            this.addCriterion("remark10 <", value, "remark10");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10LessThanOrEqualTo(String value) {
            this.addCriterion("remark10 <=", value, "remark10");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10Like(String value) {
            this.addCriterion("remark10 like", value, "remark10");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10NotLike(String value) {
            this.addCriterion("remark10 not like", value, "remark10");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andRemark10In(List<String> values) {
            this.addCriterion("remark10 in", values, "remark10");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10NotIn(List<String> values) {
            this.addCriterion("remark10 not in", values, "remark10");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10Between(String value1, String value2) {
            this.addCriterion("remark10 between", value1, value2, "remark10");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark10NotBetween(String value1, String value2) {
            this.addCriterion("remark10 not between", value1, value2, "remark10");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11IsNull() {
            this.addCriterion("remark11 is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11IsNotNull() {
            this.addCriterion("remark11 is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11EqualTo(String value) {
            this.addCriterion("remark11 =", value, "remark11");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11NotEqualTo(String value) {
            this.addCriterion("remark11 <>", value, "remark11");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11GreaterThan(String value) {
            this.addCriterion("remark11 >", value, "remark11");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark11 >=", value, "remark11");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11LessThan(String value) {
            this.addCriterion("remark11 <", value, "remark11");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11LessThanOrEqualTo(String value) {
            this.addCriterion("remark11 <=", value, "remark11");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11Like(String value) {
            this.addCriterion("remark11 like", value, "remark11");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11NotLike(String value) {
            this.addCriterion("remark11 not like", value, "remark11");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andRemark11In(List<String> values) {
            this.addCriterion("remark11 in", values, "remark11");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11NotIn(List<String> values) {
            this.addCriterion("remark11 not in", values, "remark11");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11Between(String value1, String value2) {
            this.addCriterion("remark11 between", value1, value2, "remark11");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark11NotBetween(String value1, String value2) {
            this.addCriterion("remark11 not between", value1, value2, "remark11");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12IsNull() {
            this.addCriterion("remark12 is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12IsNotNull() {
            this.addCriterion("remark12 is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12EqualTo(String value) {
            this.addCriterion("remark12 =", value, "remark12");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12NotEqualTo(String value) {
            this.addCriterion("remark12 <>", value, "remark12");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12GreaterThan(String value) {
            this.addCriterion("remark12 >", value, "remark12");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark12 >=", value, "remark12");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12LessThan(String value) {
            this.addCriterion("remark12 <", value, "remark12");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12LessThanOrEqualTo(String value) {
            this.addCriterion("remark12 <=", value, "remark12");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12Like(String value) {
            this.addCriterion("remark12 like", value, "remark12");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12NotLike(String value) {
            this.addCriterion("remark12 not like", value, "remark12");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andRemark12In(List<String> values) {
            this.addCriterion("remark12 in", values, "remark12");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12NotIn(List<String> values) {
            this.addCriterion("remark12 not in", values, "remark12");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12Between(String value1, String value2) {
            this.addCriterion("remark12 between", value1, value2, "remark12");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark12NotBetween(String value1, String value2) {
            this.addCriterion("remark12 not between", value1, value2, "remark12");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13IsNull() {
            this.addCriterion("remark13 is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13IsNotNull() {
            this.addCriterion("remark13 is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13EqualTo(String value) {
            this.addCriterion("remark13 =", value, "remark13");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13NotEqualTo(String value) {
            this.addCriterion("remark13 <>", value, "remark13");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13GreaterThan(String value) {
            this.addCriterion("remark13 >", value, "remark13");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark13 >=", value, "remark13");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13LessThan(String value) {
            this.addCriterion("remark13 <", value, "remark13");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13LessThanOrEqualTo(String value) {
            this.addCriterion("remark13 <=", value, "remark13");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13Like(String value) {
            this.addCriterion("remark13 like", value, "remark13");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13NotLike(String value) {
            this.addCriterion("remark13 not like", value, "remark13");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andRemark13In(List<String> values) {
            this.addCriterion("remark13 in", values, "remark13");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13NotIn(List<String> values) {
            this.addCriterion("remark13 not in", values, "remark13");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13Between(String value1, String value2) {
            this.addCriterion("remark13 between", value1, value2, "remark13");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark13NotBetween(String value1, String value2) {
            this.addCriterion("remark13 not between", value1, value2, "remark13");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14IsNull() {
            this.addCriterion("remark14 is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14IsNotNull() {
            this.addCriterion("remark14 is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14EqualTo(String value) {
            this.addCriterion("remark14 =", value, "remark14");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14NotEqualTo(String value) {
            this.addCriterion("remark14 <>", value, "remark14");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14GreaterThan(String value) {
            this.addCriterion("remark14 >", value, "remark14");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark14 >=", value, "remark14");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14LessThan(String value) {
            this.addCriterion("remark14 <", value, "remark14");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14LessThanOrEqualTo(String value) {
            this.addCriterion("remark14 <=", value, "remark14");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14Like(String value) {
            this.addCriterion("remark14 like", value, "remark14");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14NotLike(String value) {
            this.addCriterion("remark14 not like", value, "remark14");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andRemark14In(List<String> values) {
            this.addCriterion("remark14 in", values, "remark14");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14NotIn(List<String> values) {
            this.addCriterion("remark14 not in", values, "remark14");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14Between(String value1, String value2) {
            this.addCriterion("remark14 between", value1, value2, "remark14");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark14NotBetween(String value1, String value2) {
            this.addCriterion("remark14 not between", value1, value2, "remark14");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15IsNull() {
            this.addCriterion("remark15 is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15IsNotNull() {
            this.addCriterion("remark15 is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15EqualTo(String value) {
            this.addCriterion("remark15 =", value, "remark15");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15NotEqualTo(String value) {
            this.addCriterion("remark15 <>", value, "remark15");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15GreaterThan(String value) {
            this.addCriterion("remark15 >", value, "remark15");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark15 >=", value, "remark15");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15LessThan(String value) {
            this.addCriterion("remark15 <", value, "remark15");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15LessThanOrEqualTo(String value) {
            this.addCriterion("remark15 <=", value, "remark15");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15Like(String value) {
            this.addCriterion("remark15 like", value, "remark15");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15NotLike(String value) {
            this.addCriterion("remark15 not like", value, "remark15");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andRemark15In(List<String> values) {
            this.addCriterion("remark15 in", values, "remark15");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15NotIn(List<String> values) {
            this.addCriterion("remark15 not in", values, "remark15");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15Between(String value1, String value2) {
            this.addCriterion("remark15 between", value1, value2, "remark15");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark15NotBetween(String value1, String value2) {
            this.addCriterion("remark15 not between", value1, value2, "remark15");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16IsNull() {
            this.addCriterion("remark16 is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16IsNotNull() {
            this.addCriterion("remark16 is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16EqualTo(String value) {
            this.addCriterion("remark16 =", value, "remark16");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16NotEqualTo(String value) {
            this.addCriterion("remark16 <>", value, "remark16");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16GreaterThan(String value) {
            this.addCriterion("remark16 >", value, "remark16");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark16 >=", value, "remark16");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16LessThan(String value) {
            this.addCriterion("remark16 <", value, "remark16");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16LessThanOrEqualTo(String value) {
            this.addCriterion("remark16 <=", value, "remark16");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16Like(String value) {
            this.addCriterion("remark16 like", value, "remark16");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16NotLike(String value) {
            this.addCriterion("remark16 not like", value, "remark16");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andRemark16In(List<String> values) {
            this.addCriterion("remark16 in", values, "remark16");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16NotIn(List<String> values) {
            this.addCriterion("remark16 not in", values, "remark16");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16Between(String value1, String value2) {
            this.addCriterion("remark16 between", value1, value2, "remark16");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark16NotBetween(String value1, String value2) {
            this.addCriterion("remark16 not between", value1, value2, "remark16");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17IsNull() {
            this.addCriterion("remark17 is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17IsNotNull() {
            this.addCriterion("remark17 is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17EqualTo(String value) {
            this.addCriterion("remark17 =", value, "remark17");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17NotEqualTo(String value) {
            this.addCriterion("remark17 <>", value, "remark17");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17GreaterThan(String value) {
            this.addCriterion("remark17 >", value, "remark17");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark17 >=", value, "remark17");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17LessThan(String value) {
            this.addCriterion("remark17 <", value, "remark17");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17LessThanOrEqualTo(String value) {
            this.addCriterion("remark17 <=", value, "remark17");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17Like(String value) {
            this.addCriterion("remark17 like", value, "remark17");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17NotLike(String value) {
            this.addCriterion("remark17 not like", value, "remark17");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andRemark17In(List<String> values) {
            this.addCriterion("remark17 in", values, "remark17");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17NotIn(List<String> values) {
            this.addCriterion("remark17 not in", values, "remark17");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17Between(String value1, String value2) {
            this.addCriterion("remark17 between", value1, value2, "remark17");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark17NotBetween(String value1, String value2) {
            this.addCriterion("remark17 not between", value1, value2, "remark17");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18IsNull() {
            this.addCriterion("remark18 is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18IsNotNull() {
            this.addCriterion("remark18 is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18EqualTo(String value) {
            this.addCriterion("remark18 =", value, "remark18");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18NotEqualTo(String value) {
            this.addCriterion("remark18 <>", value, "remark18");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18GreaterThan(String value) {
            this.addCriterion("remark18 >", value, "remark18");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark18 >=", value, "remark18");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18LessThan(String value) {
            this.addCriterion("remark18 <", value, "remark18");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18LessThanOrEqualTo(String value) {
            this.addCriterion("remark18 <=", value, "remark18");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18Like(String value) {
            this.addCriterion("remark18 like", value, "remark18");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18NotLike(String value) {
            this.addCriterion("remark18 not like", value, "remark18");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andRemark18In(List<String> values) {
            this.addCriterion("remark18 in", values, "remark18");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18NotIn(List<String> values) {
            this.addCriterion("remark18 not in", values, "remark18");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18Between(String value1, String value2) {
            this.addCriterion("remark18 between", value1, value2, "remark18");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark18NotBetween(String value1, String value2) {
            this.addCriterion("remark18 not between", value1, value2, "remark18");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19IsNull() {
            this.addCriterion("remark19 is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19IsNotNull() {
            this.addCriterion("remark19 is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19EqualTo(String value) {
            this.addCriterion("remark19 =", value, "remark19");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19NotEqualTo(String value) {
            this.addCriterion("remark19 <>", value, "remark19");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19GreaterThan(String value) {
            this.addCriterion("remark19 >", value, "remark19");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark19 >=", value, "remark19");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19LessThan(String value) {
            this.addCriterion("remark19 <", value, "remark19");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19LessThanOrEqualTo(String value) {
            this.addCriterion("remark19 <=", value, "remark19");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19Like(String value) {
            this.addCriterion("remark19 like", value, "remark19");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19NotLike(String value) {
            this.addCriterion("remark19 not like", value, "remark19");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andRemark19In(List<String> values) {
            this.addCriterion("remark19 in", values, "remark19");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19NotIn(List<String> values) {
            this.addCriterion("remark19 not in", values, "remark19");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19Between(String value1, String value2) {
            this.addCriterion("remark19 between", value1, value2, "remark19");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark19NotBetween(String value1, String value2) {
            this.addCriterion("remark19 not between", value1, value2, "remark19");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20IsNull() {
            this.addCriterion("remark20 is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20IsNotNull() {
            this.addCriterion("remark20 is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20EqualTo(String value) {
            this.addCriterion("remark20 =", value, "remark20");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20NotEqualTo(String value) {
            this.addCriterion("remark20 <>", value, "remark20");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20GreaterThan(String value) {
            this.addCriterion("remark20 >", value, "remark20");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20GreaterThanOrEqualTo(String value) {
            this.addCriterion("remark20 >=", value, "remark20");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20LessThan(String value) {
            this.addCriterion("remark20 <", value, "remark20");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20LessThanOrEqualTo(String value) {
            this.addCriterion("remark20 <=", value, "remark20");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20Like(String value) {
            this.addCriterion("remark20 like", value, "remark20");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20NotLike(String value) {
            this.addCriterion("remark20 not like", value, "remark20");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andRemark20In(List<String> values) {
            this.addCriterion("remark20 in", values, "remark20");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20NotIn(List<String> values) {
            this.addCriterion("remark20 not in", values, "remark20");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20Between(String value1, String value2) {
            this.addCriterion("remark20 between", value1, value2, "remark20");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andRemark20NotBetween(String value1, String value2) {
            this.addCriterion("remark20 not between", value1, value2, "remark20");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andStoreIdIsNull() {
            this.addCriterion("store_id is null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andStoreIdIsNotNull() {
            this.addCriterion("store_id is not null");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andStoreIdEqualTo(Long value) {
            this.addCriterion("store_id =", value, "storeId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andStoreIdNotEqualTo(Long value) {
            this.addCriterion("store_id <>", value, "storeId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andStoreIdGreaterThan(Long value) {
            this.addCriterion("store_id >", value, "storeId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("store_id >=", value, "storeId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andStoreIdLessThan(Long value) {
            this.addCriterion("store_id <", value, "storeId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            this.addCriterion("store_id <=", value, "storeId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andStoreIdLike(String value) {
            this.addCriterion("store_id like", value, "storeId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andStoreIdNotLike(String value) {
            this.addCriterion("store_id not like", value, "storeId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }        public ShiguGoodsDataPackageExample.Criteria andStoreIdIn(List<Long> values) {
            this.addCriterion("store_id in", values, "storeId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andStoreIdNotIn(List<Long> values) {
            this.addCriterion("store_id not in", values, "storeId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            this.addCriterion("store_id between", value1, value2, "storeId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }

        public ShiguGoodsDataPackageExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            this.addCriterion("store_id not between", value1, value2, "storeId");
            return (ShiguGoodsDataPackageExample.Criteria)this;
        }
    }
}
