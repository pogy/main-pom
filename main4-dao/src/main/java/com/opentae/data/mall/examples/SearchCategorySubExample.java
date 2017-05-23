package com.opentae.data.mall.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.opentae.core.mybatis.SgExample;

public class SearchCategorySubExample implements SgExample{
    protected String orderByClause;
    protected boolean distinct;
    protected List<SearchCategorySubExample.Criteria> oredCriteria = new ArrayList();

    public SearchCategorySubExample() {
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

    public List<SearchCategorySubExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(SearchCategorySubExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public SearchCategorySubExample.Criteria or() {
        SearchCategorySubExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public SearchCategorySubExample.Criteria createCriteria() {
        SearchCategorySubExample.Criteria criteria = this.createCriteriaInternal();
        if(this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected SearchCategorySubExample.Criteria createCriteriaInternal() {
        SearchCategorySubExample.Criteria criteria = new SearchCategorySubExample.Criteria();
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

    public static class Criteria extends SearchCategorySubExample.GeneratedCriteria {
        protected Criteria() {
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<SearchCategorySubExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<SearchCategorySubExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<SearchCategorySubExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if(condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new SearchCategorySubExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if(value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new SearchCategorySubExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if(value1 != null && value2 != null) {
                this.criteria.add(new SearchCategorySubExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public SearchCategorySubExample.Criteria andSubIdIsNull() {
            this.addCriterion("sub_id is null");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSubIdIsNotNull() {
            this.addCriterion("sub_id is not null");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSubIdEqualTo(Long value) {
            this.addCriterion("sub_id =", value, "subId");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSubIdNotEqualTo(Long value) {
            this.addCriterion("sub_id <>", value, "subId");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSubIdGreaterThan(Long value) {
            this.addCriterion("sub_id >", value, "subId");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSubIdGreaterThanOrEqualTo(Long value) {
            this.addCriterion("sub_id >=", value, "subId");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSubIdLessThan(Long value) {
            this.addCriterion("sub_id <", value, "subId");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSubIdLessThanOrEqualTo(Long value) {
            this.addCriterion("sub_id <=", value, "subId");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSubIdLike(String value) {
            this.addCriterion("sub_id like", value, "subId");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSubIdNotLike(String value) {
            this.addCriterion("sub_id not like", value, "subId");
            return (SearchCategorySubExample.Criteria)this;
        }        public SearchCategorySubExample.Criteria andSubIdIn(List<Long> values) {
            this.addCriterion("sub_id in", values, "subId");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSubIdNotIn(List<Long> values) {
            this.addCriterion("sub_id not in", values, "subId");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSubIdBetween(Long value1, Long value2) {
            this.addCriterion("sub_id between", value1, value2, "subId");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSubIdNotBetween(Long value1, Long value2) {
            this.addCriterion("sub_id not between", value1, value2, "subId");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andParentCateValueIsNull() {
            this.addCriterion("parent_cate_value is null");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andParentCateValueIsNotNull() {
            this.addCriterion("parent_cate_value is not null");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andParentCateValueEqualTo(String value) {
            this.addCriterion("parent_cate_value =", value, "parentCateValue");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andParentCateValueNotEqualTo(String value) {
            this.addCriterion("parent_cate_value <>", value, "parentCateValue");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andParentCateValueGreaterThan(String value) {
            this.addCriterion("parent_cate_value >", value, "parentCateValue");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andParentCateValueGreaterThanOrEqualTo(String value) {
            this.addCriterion("parent_cate_value >=", value, "parentCateValue");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andParentCateValueLessThan(String value) {
            this.addCriterion("parent_cate_value <", value, "parentCateValue");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andParentCateValueLessThanOrEqualTo(String value) {
            this.addCriterion("parent_cate_value <=", value, "parentCateValue");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andParentCateValueLike(String value) {
            this.addCriterion("parent_cate_value like", value, "parentCateValue");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andParentCateValueNotLike(String value) {
            this.addCriterion("parent_cate_value not like", value, "parentCateValue");
            return (SearchCategorySubExample.Criteria)this;
        }        public SearchCategorySubExample.Criteria andParentCateValueIn(List<String> values) {
            this.addCriterion("parent_cate_value in", values, "parentCateValue");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andParentCateValueNotIn(List<String> values) {
            this.addCriterion("parent_cate_value not in", values, "parentCateValue");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andParentCateValueBetween(String value1, String value2) {
            this.addCriterion("parent_cate_value between", value1, value2, "parentCateValue");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andParentCateValueNotBetween(String value1, String value2) {
            this.addCriterion("parent_cate_value not between", value1, value2, "parentCateValue");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andTypeIsNull() {
            this.addCriterion("type is null");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andTypeIsNotNull() {
            this.addCriterion("type is not null");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andTypeEqualTo(Integer value) {
            this.addCriterion("type =", value, "type");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andTypeNotEqualTo(Integer value) {
            this.addCriterion("type <>", value, "type");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andTypeGreaterThan(Integer value) {
            this.addCriterion("type >", value, "type");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("type >=", value, "type");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andTypeLessThan(Integer value) {
            this.addCriterion("type <", value, "type");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            this.addCriterion("type <=", value, "type");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andTypeLike(String value) {
            this.addCriterion("type like", value, "type");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andTypeNotLike(String value) {
            this.addCriterion("type not like", value, "type");
            return (SearchCategorySubExample.Criteria)this;
        }        public SearchCategorySubExample.Criteria andTypeIn(List<Integer> values) {
            this.addCriterion("type in", values, "type");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andTypeNotIn(List<Integer> values) {
            this.addCriterion("type not in", values, "type");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            this.addCriterion("type between", value1, value2, "type");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            this.addCriterion("type not between", value1, value2, "type");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateNameIsNull() {
            this.addCriterion("cate_name is null");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateNameIsNotNull() {
            this.addCriterion("cate_name is not null");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateNameEqualTo(String value) {
            this.addCriterion("cate_name =", value, "cateName");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateNameNotEqualTo(String value) {
            this.addCriterion("cate_name <>", value, "cateName");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateNameGreaterThan(String value) {
            this.addCriterion("cate_name >", value, "cateName");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("cate_name >=", value, "cateName");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateNameLessThan(String value) {
            this.addCriterion("cate_name <", value, "cateName");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateNameLessThanOrEqualTo(String value) {
            this.addCriterion("cate_name <=", value, "cateName");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateNameLike(String value) {
            this.addCriterion("cate_name like", value, "cateName");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateNameNotLike(String value) {
            this.addCriterion("cate_name not like", value, "cateName");
            return (SearchCategorySubExample.Criteria)this;
        }        public SearchCategorySubExample.Criteria andCateNameIn(List<String> values) {
            this.addCriterion("cate_name in", values, "cateName");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateNameNotIn(List<String> values) {
            this.addCriterion("cate_name not in", values, "cateName");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateNameBetween(String value1, String value2) {
            this.addCriterion("cate_name between", value1, value2, "cateName");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateNameNotBetween(String value1, String value2) {
            this.addCriterion("cate_name not between", value1, value2, "cateName");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateValueIsNull() {
            this.addCriterion("cate_value is null");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateValueIsNotNull() {
            this.addCriterion("cate_value is not null");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateValueEqualTo(String value) {
            this.addCriterion("cate_value =", value, "cateValue");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateValueNotEqualTo(String value) {
            this.addCriterion("cate_value <>", value, "cateValue");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateValueGreaterThan(String value) {
            this.addCriterion("cate_value >", value, "cateValue");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateValueGreaterThanOrEqualTo(String value) {
            this.addCriterion("cate_value >=", value, "cateValue");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateValueLessThan(String value) {
            this.addCriterion("cate_value <", value, "cateValue");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateValueLessThanOrEqualTo(String value) {
            this.addCriterion("cate_value <=", value, "cateValue");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateValueLike(String value) {
            this.addCriterion("cate_value like", value, "cateValue");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateValueNotLike(String value) {
            this.addCriterion("cate_value not like", value, "cateValue");
            return (SearchCategorySubExample.Criteria)this;
        }        public SearchCategorySubExample.Criteria andCateValueIn(List<String> values) {
            this.addCriterion("cate_value in", values, "cateValue");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateValueNotIn(List<String> values) {
            this.addCriterion("cate_value not in", values, "cateValue");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateValueBetween(String value1, String value2) {
            this.addCriterion("cate_value between", value1, value2, "cateValue");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andCateValueNotBetween(String value1, String value2) {
            this.addCriterion("cate_value not between", value1, value2, "cateValue");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSortIsNull() {
            this.addCriterion("sort is null");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSortIsNotNull() {
            this.addCriterion("sort is not null");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSortEqualTo(Integer value) {
            this.addCriterion("sort =", value, "sort");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSortNotEqualTo(Integer value) {
            this.addCriterion("sort <>", value, "sort");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSortGreaterThan(Integer value) {
            this.addCriterion("sort >", value, "sort");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSortGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("sort >=", value, "sort");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSortLessThan(Integer value) {
            this.addCriterion("sort <", value, "sort");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSortLessThanOrEqualTo(Integer value) {
            this.addCriterion("sort <=", value, "sort");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSortLike(String value) {
            this.addCriterion("sort like", value, "sort");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSortNotLike(String value) {
            this.addCriterion("sort not like", value, "sort");
            return (SearchCategorySubExample.Criteria)this;
        }        public SearchCategorySubExample.Criteria andSortIn(List<Integer> values) {
            this.addCriterion("sort in", values, "sort");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSortNotIn(List<Integer> values) {
            this.addCriterion("sort not in", values, "sort");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSortBetween(Integer value1, Integer value2) {
            this.addCriterion("sort between", value1, value2, "sort");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andSortNotBetween(Integer value1, Integer value2) {
            this.addCriterion("sort not between", value1, value2, "sort");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andWebSiteIsNull() {
            this.addCriterion("web_site is null");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andWebSiteIsNotNull() {
            this.addCriterion("web_site is not null");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andWebSiteEqualTo(String value) {
            this.addCriterion("web_site =", value, "webSite");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andWebSiteNotEqualTo(String value) {
            this.addCriterion("web_site <>", value, "webSite");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andWebSiteGreaterThan(String value) {
            this.addCriterion("web_site >", value, "webSite");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            this.addCriterion("web_site >=", value, "webSite");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andWebSiteLessThan(String value) {
            this.addCriterion("web_site <", value, "webSite");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            this.addCriterion("web_site <=", value, "webSite");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andWebSiteLike(String value) {
            this.addCriterion("web_site like", value, "webSite");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andWebSiteNotLike(String value) {
            this.addCriterion("web_site not like", value, "webSite");
            return (SearchCategorySubExample.Criteria)this;
        }        public SearchCategorySubExample.Criteria andWebSiteIn(List<String> values) {
            this.addCriterion("web_site in", values, "webSite");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andWebSiteNotIn(List<String> values) {
            this.addCriterion("web_site not in", values, "webSite");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andWebSiteBetween(String value1, String value2) {
            this.addCriterion("web_site between", value1, value2, "webSite");
            return (SearchCategorySubExample.Criteria)this;
        }

        public SearchCategorySubExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            this.addCriterion("web_site not between", value1, value2, "webSite");
            return (SearchCategorySubExample.Criteria)this;
        }
    }
}
