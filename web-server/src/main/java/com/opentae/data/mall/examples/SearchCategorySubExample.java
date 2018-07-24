package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.SearchCategorySub;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class SearchCategorySubExample extends SgExample<SearchCategorySubExample.Criteria> {
    public static final Class<SearchCategorySub> beanClass = SearchCategorySub.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn subId;
    public static EntityColumn webSite;
    public static EntityColumn sort;
    public static EntityColumn type;
    public static EntityColumn parentCateValue;
    public static EntityColumn cateValue;
    public static EntityColumn cateName;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        subId = listMap.get("subId");
        webSite = listMap.get("webSite");
        sort = listMap.get("sort");
        type = listMap.get("type");
        parentCateValue = listMap.get("parentCateValue");
        cateValue = listMap.get("cateValue");
        cateName = listMap.get("cateName");
        }

    public SearchCategorySubExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected SearchCategorySubExample.Criteria createCriteriaInternal() {
        return new SearchCategorySubExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public SearchCategorySubExample.Criteria andSubIdIsNull() {
            return isNull(subId);
        }

        public SearchCategorySubExample.Criteria andSubIdIsNotNull() {
            return isNotNull(subId);
        }

        public SearchCategorySubExample.Criteria andSubIdEqualTo(Long value) {
            return equalTo(subId, value);
        }

        public SearchCategorySubExample.Criteria andSubIdNotEqualTo(Long value) {
            return notEqualTo(subId, value);
        }

        public SearchCategorySubExample.Criteria andSubIdGreaterThan(Long value) {
            return greaterThan(subId, value);
        }

        public SearchCategorySubExample.Criteria andSubIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(subId, value);
        }

        public SearchCategorySubExample.Criteria andSubIdLessThan(Long value) {
            return lessThan(subId, value);
        }

        public SearchCategorySubExample.Criteria andSubIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(subId, value);
        }

        public SearchCategorySubExample.Criteria andSubIdIn(List<Long> values) {
            return in(subId, values);
        }

        public SearchCategorySubExample.Criteria andSubIdNotIn(List<Long> values) {
            return notIn(subId, values);
        }

        public SearchCategorySubExample.Criteria andSubIdBetween(Long value1, Long value2) {
            return between(subId, value1, value2);
        }

        public SearchCategorySubExample.Criteria andSubIdNotBetween(Long value1, Long value2) {
            return notBetween(subId, value1, value2);
        }
        public SearchCategorySubExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public SearchCategorySubExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public SearchCategorySubExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public SearchCategorySubExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public SearchCategorySubExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public SearchCategorySubExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public SearchCategorySubExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public SearchCategorySubExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public SearchCategorySubExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public SearchCategorySubExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public SearchCategorySubExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public SearchCategorySubExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public SearchCategorySubExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public SearchCategorySubExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public SearchCategorySubExample.Criteria andSortIsNull() {
            return isNull(sort);
        }

        public SearchCategorySubExample.Criteria andSortIsNotNull() {
            return isNotNull(sort);
        }

        public SearchCategorySubExample.Criteria andSortEqualTo(Integer value) {
            return equalTo(sort, value);
        }

        public SearchCategorySubExample.Criteria andSortNotEqualTo(Integer value) {
            return notEqualTo(sort, value);
        }

        public SearchCategorySubExample.Criteria andSortGreaterThan(Integer value) {
            return greaterThan(sort, value);
        }

        public SearchCategorySubExample.Criteria andSortGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sort, value);
        }

        public SearchCategorySubExample.Criteria andSortLessThan(Integer value) {
            return lessThan(sort, value);
        }

        public SearchCategorySubExample.Criteria andSortLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sort, value);
        }

        public SearchCategorySubExample.Criteria andSortIn(List<Integer> values) {
            return in(sort, values);
        }

        public SearchCategorySubExample.Criteria andSortNotIn(List<Integer> values) {
            return notIn(sort, values);
        }

        public SearchCategorySubExample.Criteria andSortBetween(Integer value1, Integer value2) {
            return between(sort, value1, value2);
        }

        public SearchCategorySubExample.Criteria andSortNotBetween(Integer value1, Integer value2) {
            return notBetween(sort, value1, value2);
        }
        public SearchCategorySubExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public SearchCategorySubExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public SearchCategorySubExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public SearchCategorySubExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public SearchCategorySubExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public SearchCategorySubExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public SearchCategorySubExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public SearchCategorySubExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public SearchCategorySubExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public SearchCategorySubExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public SearchCategorySubExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public SearchCategorySubExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
        public SearchCategorySubExample.Criteria andParentCateValueIsNull() {
            return isNull(parentCateValue);
        }

        public SearchCategorySubExample.Criteria andParentCateValueIsNotNull() {
            return isNotNull(parentCateValue);
        }

        public SearchCategorySubExample.Criteria andParentCateValueEqualTo(String value) {
            return equalTo(parentCateValue, value);
        }

        public SearchCategorySubExample.Criteria andParentCateValueNotEqualTo(String value) {
            return notEqualTo(parentCateValue, value);
        }

        public SearchCategorySubExample.Criteria andParentCateValueGreaterThan(String value) {
            return greaterThan(parentCateValue, value);
        }

        public SearchCategorySubExample.Criteria andParentCateValueGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(parentCateValue, value);
        }

        public SearchCategorySubExample.Criteria andParentCateValueLessThan(String value) {
            return lessThan(parentCateValue, value);
        }

        public SearchCategorySubExample.Criteria andParentCateValueLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(parentCateValue, value);
        }

        public SearchCategorySubExample.Criteria andParentCateValueLike(String value) {
            return like(parentCateValue, value);
        }

        public SearchCategorySubExample.Criteria andParentCateValueNotLike(String value) {
            return notLike(parentCateValue, value);
        }

        public SearchCategorySubExample.Criteria andParentCateValueIn(List<String> values) {
            return in(parentCateValue, values);
        }

        public SearchCategorySubExample.Criteria andParentCateValueNotIn(List<String> values) {
            return notIn(parentCateValue, values);
        }

        public SearchCategorySubExample.Criteria andParentCateValueBetween(String value1, String value2) {
            return between(parentCateValue, value1, value2);
        }

        public SearchCategorySubExample.Criteria andParentCateValueNotBetween(String value1, String value2) {
            return notBetween(parentCateValue, value1, value2);
        }
        public SearchCategorySubExample.Criteria andCateValueIsNull() {
            return isNull(cateValue);
        }

        public SearchCategorySubExample.Criteria andCateValueIsNotNull() {
            return isNotNull(cateValue);
        }

        public SearchCategorySubExample.Criteria andCateValueEqualTo(String value) {
            return equalTo(cateValue, value);
        }

        public SearchCategorySubExample.Criteria andCateValueNotEqualTo(String value) {
            return notEqualTo(cateValue, value);
        }

        public SearchCategorySubExample.Criteria andCateValueGreaterThan(String value) {
            return greaterThan(cateValue, value);
        }

        public SearchCategorySubExample.Criteria andCateValueGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cateValue, value);
        }

        public SearchCategorySubExample.Criteria andCateValueLessThan(String value) {
            return lessThan(cateValue, value);
        }

        public SearchCategorySubExample.Criteria andCateValueLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cateValue, value);
        }

        public SearchCategorySubExample.Criteria andCateValueLike(String value) {
            return like(cateValue, value);
        }

        public SearchCategorySubExample.Criteria andCateValueNotLike(String value) {
            return notLike(cateValue, value);
        }

        public SearchCategorySubExample.Criteria andCateValueIn(List<String> values) {
            return in(cateValue, values);
        }

        public SearchCategorySubExample.Criteria andCateValueNotIn(List<String> values) {
            return notIn(cateValue, values);
        }

        public SearchCategorySubExample.Criteria andCateValueBetween(String value1, String value2) {
            return between(cateValue, value1, value2);
        }

        public SearchCategorySubExample.Criteria andCateValueNotBetween(String value1, String value2) {
            return notBetween(cateValue, value1, value2);
        }
        public SearchCategorySubExample.Criteria andCateNameIsNull() {
            return isNull(cateName);
        }

        public SearchCategorySubExample.Criteria andCateNameIsNotNull() {
            return isNotNull(cateName);
        }

        public SearchCategorySubExample.Criteria andCateNameEqualTo(String value) {
            return equalTo(cateName, value);
        }

        public SearchCategorySubExample.Criteria andCateNameNotEqualTo(String value) {
            return notEqualTo(cateName, value);
        }

        public SearchCategorySubExample.Criteria andCateNameGreaterThan(String value) {
            return greaterThan(cateName, value);
        }

        public SearchCategorySubExample.Criteria andCateNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cateName, value);
        }

        public SearchCategorySubExample.Criteria andCateNameLessThan(String value) {
            return lessThan(cateName, value);
        }

        public SearchCategorySubExample.Criteria andCateNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cateName, value);
        }

        public SearchCategorySubExample.Criteria andCateNameLike(String value) {
            return like(cateName, value);
        }

        public SearchCategorySubExample.Criteria andCateNameNotLike(String value) {
            return notLike(cateName, value);
        }

        public SearchCategorySubExample.Criteria andCateNameIn(List<String> values) {
            return in(cateName, values);
        }

        public SearchCategorySubExample.Criteria andCateNameNotIn(List<String> values) {
            return notIn(cateName, values);
        }

        public SearchCategorySubExample.Criteria andCateNameBetween(String value1, String value2) {
            return between(cateName, value1, value2);
        }

        public SearchCategorySubExample.Criteria andCateNameNotBetween(String value1, String value2) {
            return notBetween(cateName, value1, value2);
        }
    }
}
