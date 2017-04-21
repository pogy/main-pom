package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class ShiguStoreUsercatExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<ShiguStoreUsercatExample.Criteria> oredCriteria = new ArrayList();

    public ShiguStoreUsercatExample() {
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

    public List<ShiguStoreUsercatExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(ShiguStoreUsercatExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public ShiguStoreUsercatExample.Criteria or() {
        ShiguStoreUsercatExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public ShiguStoreUsercatExample.Criteria createCriteria() {
        ShiguStoreUsercatExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected ShiguStoreUsercatExample.Criteria createCriteriaInternal() {
        ShiguStoreUsercatExample.Criteria criteria = new ShiguStoreUsercatExample.Criteria();
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

    public static class Criteria extends ShiguStoreUsercatExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<ShiguStoreUsercatExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<ShiguStoreUsercatExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<ShiguStoreUsercatExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new ShiguStoreUsercatExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new ShiguStoreUsercatExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new ShiguStoreUsercatExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public ShiguStoreUsercatExample.Criteria andUseCatIdIsNull() {
            this.addCriterion("use_cat_id is null");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andUseCatIdIsNotNull() {
            this.addCriterion("use_cat_id is not null");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andUseCatIdEqualTo(Long value) {
            this.addCriterion("use_cat_id =", value, "useCatId");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andUseCatIdNotEqualTo(Long value) {
            this.addCriterion("use_cat_id <>", value, "useCatId");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andUseCatIdGreaterThan(Long value) {
            this.addCriterion("use_cat_id >", value, "useCatId");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andUseCatIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("use_cat_id >=", value, "useCatId");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andUseCatIdLessThan(Long value) {
            this.addCriterion("use_cat_id <", value, "useCatId");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andUseCatIdLessThanOrEqualTo(Long value) {
            this.addCriterion("use_cat_id <=", value, "useCatId");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andUseCatIdLike(String value) {
            this.addCriterion("use_cat_id like", value, "useCatId");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andUseCatIdNotLike(String value) {
            this.addCriterion("use_cat_id not like", value, "useCatId");
            return (ShiguStoreUsercatExample.Criteria)this;
        }        public ShiguStoreUsercatExample.Criteria andUseCatIdIn(List<Long> values) {
            this.addCriterion("use_cat_id in", values, "useCatId");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andUseCatIdNotIn(List<Long> values) {
            this.addCriterion("use_cat_id not in", values, "useCatId");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andUseCatIdBetween(Long value1, Long value2) {
            this.addCriterion("use_cat_id between", value1, value2, "useCatId");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andUseCatIdNotBetween(Long value1, Long value2) {
            this.addCriterion("use_cat_id not between", value1, value2, "useCatId");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andShowNameIsNull() {
            this.addCriterion("show_name is null");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andShowNameIsNotNull() {
            this.addCriterion("show_name is not null");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andShowNameEqualTo(String value) {
            this.addCriterion("show_name =", value, "showName");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andShowNameNotEqualTo(String value) {
            this.addCriterion("show_name <>", value, "showName");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andShowNameGreaterThan(String value) {
            this.addCriterion("show_name >", value, "showName");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andShowNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("show_name >=", value, "showName");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andShowNameLessThan(String value) {
            this.addCriterion("show_name <", value, "showName");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andShowNameLessThanOrEqualTo(String value) {
            this.addCriterion("show_name <=", value, "showName");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andShowNameLike(String value) {
            this.addCriterion("show_name like", value, "showName");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andShowNameNotLike(String value) {
            this.addCriterion("show_name not like", value, "showName");
            return (ShiguStoreUsercatExample.Criteria)this;
        }        public ShiguStoreUsercatExample.Criteria andShowNameIn(List<String> values) {
            this.addCriterion("show_name in", values, "showName");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andShowNameNotIn(List<String> values) {
            this.addCriterion("show_name not in", values, "showName");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andShowNameBetween(String value1, String value2) {
            this.addCriterion("show_name between", value1, value2, "showName");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andShowNameNotBetween(String value1, String value2) {
            this.addCriterion("show_name not between", value1, value2, "showName");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsIsNull() {
            this.addCriterion("allcids is null");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsIsNotNull() {
            this.addCriterion("allcids is not null");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsEqualTo(String value) {
            this.addCriterion("allcids =", value, "allcids");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsNotEqualTo(String value) {
            this.addCriterion("allcids <>", value, "allcids");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsGreaterThan(String value) {
            this.addCriterion("allcids >", value, "allcids");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsGreaterThanOrEqualTo(String value) {
            this.addCriterion("allcids >=", value, "allcids");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsLessThan(String value) {
            this.addCriterion("allcids <", value, "allcids");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsLessThanOrEqualTo(String value) {
            this.addCriterion("allcids <=", value, "allcids");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsLike(String value) {
            this.addCriterion("allcids like", value, "allcids");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsNotLike(String value) {
            this.addCriterion("allcids not like", value, "allcids");
            return (ShiguStoreUsercatExample.Criteria)this;
        }        public ShiguStoreUsercatExample.Criteria andAllcidsIn(List<String> values) {
            this.addCriterion("allcids in", values, "allcids");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsNotIn(List<String> values) {
            this.addCriterion("allcids not in", values, "allcids");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsBetween(String value1, String value2) {
            this.addCriterion("allcids between", value1, value2, "allcids");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andAllcidsNotBetween(String value1, String value2) {
            this.addCriterion("allcids not between", value1, value2, "allcids");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCidIsNull() {
            this.addCriterion("cid is null");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCidIsNotNull() {
            this.addCriterion("cid is not null");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCidEqualTo(Long value) {
            this.addCriterion("cid =", value, "cid");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCidNotEqualTo(Long value) {
            this.addCriterion("cid <>", value, "cid");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCidGreaterThan(Long value) {
            this.addCriterion("cid >", value, "cid");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            this.addCriterion("cid >=", value, "cid");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCidLessThan(Long value) {
            this.addCriterion("cid <", value, "cid");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCidLessThanOrEqualTo(Long value) {
            this.addCriterion("cid <=", value, "cid");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCidLike(String value) {
            this.addCriterion("cid like", value, "cid");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCidNotLike(String value) {
            this.addCriterion("cid not like", value, "cid");
            return (ShiguStoreUsercatExample.Criteria)this;
        }        public ShiguStoreUsercatExample.Criteria andCidIn(List<Long> values) {
            this.addCriterion("cid in", values, "cid");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCidNotIn(List<Long> values) {
            this.addCriterion("cid not in", values, "cid");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCidBetween(Long value1, Long value2) {
            this.addCriterion("cid between", value1, value2, "cid");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCidNotBetween(Long value1, Long value2) {
            this.addCriterion("cid not between", value1, value2, "cid");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCnameIsNull() {
            this.addCriterion("cname is null");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCnameIsNotNull() {
            this.addCriterion("cname is not null");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCnameEqualTo(String value) {
            this.addCriterion("cname =", value, "cname");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCnameNotEqualTo(String value) {
            this.addCriterion("cname <>", value, "cname");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCnameGreaterThan(String value) {
            this.addCriterion("cname >", value, "cname");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCnameGreaterThanOrEqualTo(String value) {
            this.addCriterion("cname >=", value, "cname");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCnameLessThan(String value) {
            this.addCriterion("cname <", value, "cname");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCnameLessThanOrEqualTo(String value) {
            this.addCriterion("cname <=", value, "cname");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCnameLike(String value) {
            this.addCriterion("cname like", value, "cname");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCnameNotLike(String value) {
            this.addCriterion("cname not like", value, "cname");
            return (ShiguStoreUsercatExample.Criteria)this;
        }        public ShiguStoreUsercatExample.Criteria andCnameIn(List<String> values) {
            this.addCriterion("cname in", values, "cname");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCnameNotIn(List<String> values) {
            this.addCriterion("cname not in", values, "cname");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCnameBetween(String value1, String value2) {
            this.addCriterion("cname between", value1, value2, "cname");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCnameNotBetween(String value1, String value2) {
            this.addCriterion("cname not between", value1, value2, "cname");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andStoreIdIsNull() {
            this.addCriterion("store_id is null");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andStoreIdIsNotNull() {
            this.addCriterion("store_id is not null");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andStoreIdEqualTo(Long value) {
            this.addCriterion("store_id =", value, "storeId");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andStoreIdNotEqualTo(Long value) {
            this.addCriterion("store_id <>", value, "storeId");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andStoreIdGreaterThan(Long value) {
            this.addCriterion("store_id >", value, "storeId");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("store_id >=", value, "storeId");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andStoreIdLessThan(Long value) {
            this.addCriterion("store_id <", value, "storeId");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            this.addCriterion("store_id <=", value, "storeId");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andStoreIdLike(String value) {
            this.addCriterion("store_id like", value, "storeId");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andStoreIdNotLike(String value) {
            this.addCriterion("store_id not like", value, "storeId");
            return (ShiguStoreUsercatExample.Criteria)this;
        }        public ShiguStoreUsercatExample.Criteria andStoreIdIn(List<Long> values) {
            this.addCriterion("store_id in", values, "storeId");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andStoreIdNotIn(List<Long> values) {
            this.addCriterion("store_id not in", values, "storeId");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            this.addCriterion("store_id between", value1, value2, "storeId");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            this.addCriterion("store_id not between", value1, value2, "storeId");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCreatedIsNull() {
            this.addCriterion("created is null");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCreatedIsNotNull() {
            this.addCriterion("created is not null");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCreatedEqualTo(Date value) {
            this.addCriterion("created =", value, "created");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCreatedNotEqualTo(Date value) {
            this.addCriterion("created <>", value, "created");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCreatedGreaterThan(Date value) {
            this.addCriterion("created >", value, "created");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            this.addCriterion("created >=", value, "created");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCreatedLessThan(Date value) {
            this.addCriterion("created <", value, "created");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCreatedLessThanOrEqualTo(Date value) {
            this.addCriterion("created <=", value, "created");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCreatedLike(String value) {
            this.addCriterion("created like", value, "created");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCreatedNotLike(String value) {
            this.addCriterion("created not like", value, "created");
            return (ShiguStoreUsercatExample.Criteria)this;
        }        public ShiguStoreUsercatExample.Criteria andCreatedIn(List<Date> values) {
            this.addCriterion("created in", values, "created");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCreatedNotIn(List<Date> values) {
            this.addCriterion("created not in", values, "created");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCreatedBetween(Date value1, Date value2) {
            this.addCriterion("created between", value1, value2, "created");
            return (ShiguStoreUsercatExample.Criteria)this;
        }

        public ShiguStoreUsercatExample.Criteria andCreatedNotBetween(Date value1, Date value2) {
            this.addCriterion("created not between", value1, value2, "created");
            return (ShiguStoreUsercatExample.Criteria)this;
        }
    }
}
