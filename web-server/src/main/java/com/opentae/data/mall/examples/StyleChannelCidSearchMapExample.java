package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.StyleChannelCidSearchMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class StyleChannelCidSearchMapExample extends SgExample<StyleChannelCidSearchMapExample.Criteria> {
    public static final Class<StyleChannelCidSearchMap> beanClass = StyleChannelCidSearchMap.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn styleChannelSearchId;
    public static EntityColumn searchName;
    public static EntityColumn showCase;
    public static EntityColumn id;
    public static EntityColumn sort;
    public static EntityColumn realParentCid;
    public static EntityColumn cateName;
    public static EntityColumn cid;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        styleChannelSearchId = listMap.get("styleChannelSearchId");
        searchName = listMap.get("searchName");
        showCase = listMap.get("showCase");
        id = listMap.get("id");
        sort = listMap.get("sort");
        realParentCid = listMap.get("realParentCid");
        cateName = listMap.get("cateName");
        cid = listMap.get("cid");
        }

    public StyleChannelCidSearchMapExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected StyleChannelCidSearchMapExample.Criteria createCriteriaInternal() {
        return new StyleChannelCidSearchMapExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public StyleChannelCidSearchMapExample.Criteria andStyleChannelSearchIdIsNull() {
            return isNull(styleChannelSearchId);
        }

        public StyleChannelCidSearchMapExample.Criteria andStyleChannelSearchIdIsNotNull() {
            return isNotNull(styleChannelSearchId);
        }

        public StyleChannelCidSearchMapExample.Criteria andStyleChannelSearchIdEqualTo(Long value) {
            return equalTo(styleChannelSearchId, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andStyleChannelSearchIdNotEqualTo(Long value) {
            return notEqualTo(styleChannelSearchId, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andStyleChannelSearchIdGreaterThan(Long value) {
            return greaterThan(styleChannelSearchId, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andStyleChannelSearchIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(styleChannelSearchId, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andStyleChannelSearchIdLessThan(Long value) {
            return lessThan(styleChannelSearchId, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andStyleChannelSearchIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(styleChannelSearchId, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andStyleChannelSearchIdIn(List<Long> values) {
            return in(styleChannelSearchId, values);
        }

        public StyleChannelCidSearchMapExample.Criteria andStyleChannelSearchIdNotIn(List<Long> values) {
            return notIn(styleChannelSearchId, values);
        }

        public StyleChannelCidSearchMapExample.Criteria andStyleChannelSearchIdBetween(Long value1, Long value2) {
            return between(styleChannelSearchId, value1, value2);
        }

        public StyleChannelCidSearchMapExample.Criteria andStyleChannelSearchIdNotBetween(Long value1, Long value2) {
            return notBetween(styleChannelSearchId, value1, value2);
        }
        public StyleChannelCidSearchMapExample.Criteria andSearchNameIsNull() {
            return isNull(searchName);
        }

        public StyleChannelCidSearchMapExample.Criteria andSearchNameIsNotNull() {
            return isNotNull(searchName);
        }

        public StyleChannelCidSearchMapExample.Criteria andSearchNameEqualTo(String value) {
            return equalTo(searchName, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andSearchNameNotEqualTo(String value) {
            return notEqualTo(searchName, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andSearchNameGreaterThan(String value) {
            return greaterThan(searchName, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andSearchNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(searchName, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andSearchNameLessThan(String value) {
            return lessThan(searchName, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andSearchNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(searchName, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andSearchNameLike(String value) {
            return like(searchName, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andSearchNameNotLike(String value) {
            return notLike(searchName, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andSearchNameIn(List<String> values) {
            return in(searchName, values);
        }

        public StyleChannelCidSearchMapExample.Criteria andSearchNameNotIn(List<String> values) {
            return notIn(searchName, values);
        }

        public StyleChannelCidSearchMapExample.Criteria andSearchNameBetween(String value1, String value2) {
            return between(searchName, value1, value2);
        }

        public StyleChannelCidSearchMapExample.Criteria andSearchNameNotBetween(String value1, String value2) {
            return notBetween(searchName, value1, value2);
        }
        public StyleChannelCidSearchMapExample.Criteria andShowCaseIsNull() {
            return isNull(showCase);
        }

        public StyleChannelCidSearchMapExample.Criteria andShowCaseIsNotNull() {
            return isNotNull(showCase);
        }

        public StyleChannelCidSearchMapExample.Criteria andShowCaseEqualTo(Integer value) {
            return equalTo(showCase, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andShowCaseNotEqualTo(Integer value) {
            return notEqualTo(showCase, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andShowCaseGreaterThan(Integer value) {
            return greaterThan(showCase, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andShowCaseGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(showCase, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andShowCaseLessThan(Integer value) {
            return lessThan(showCase, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andShowCaseLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(showCase, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andShowCaseIn(List<Integer> values) {
            return in(showCase, values);
        }

        public StyleChannelCidSearchMapExample.Criteria andShowCaseNotIn(List<Integer> values) {
            return notIn(showCase, values);
        }

        public StyleChannelCidSearchMapExample.Criteria andShowCaseBetween(Integer value1, Integer value2) {
            return between(showCase, value1, value2);
        }

        public StyleChannelCidSearchMapExample.Criteria andShowCaseNotBetween(Integer value1, Integer value2) {
            return notBetween(showCase, value1, value2);
        }
        public StyleChannelCidSearchMapExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public StyleChannelCidSearchMapExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public StyleChannelCidSearchMapExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public StyleChannelCidSearchMapExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public StyleChannelCidSearchMapExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public StyleChannelCidSearchMapExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public StyleChannelCidSearchMapExample.Criteria andSortIsNull() {
            return isNull(sort);
        }

        public StyleChannelCidSearchMapExample.Criteria andSortIsNotNull() {
            return isNotNull(sort);
        }

        public StyleChannelCidSearchMapExample.Criteria andSortEqualTo(Integer value) {
            return equalTo(sort, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andSortNotEqualTo(Integer value) {
            return notEqualTo(sort, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andSortGreaterThan(Integer value) {
            return greaterThan(sort, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andSortGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sort, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andSortLessThan(Integer value) {
            return lessThan(sort, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andSortLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sort, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andSortIn(List<Integer> values) {
            return in(sort, values);
        }

        public StyleChannelCidSearchMapExample.Criteria andSortNotIn(List<Integer> values) {
            return notIn(sort, values);
        }

        public StyleChannelCidSearchMapExample.Criteria andSortBetween(Integer value1, Integer value2) {
            return between(sort, value1, value2);
        }

        public StyleChannelCidSearchMapExample.Criteria andSortNotBetween(Integer value1, Integer value2) {
            return notBetween(sort, value1, value2);
        }
        public StyleChannelCidSearchMapExample.Criteria andRealParentCidIsNull() {
            return isNull(realParentCid);
        }

        public StyleChannelCidSearchMapExample.Criteria andRealParentCidIsNotNull() {
            return isNotNull(realParentCid);
        }

        public StyleChannelCidSearchMapExample.Criteria andRealParentCidEqualTo(Long value) {
            return equalTo(realParentCid, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andRealParentCidNotEqualTo(Long value) {
            return notEqualTo(realParentCid, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andRealParentCidGreaterThan(Long value) {
            return greaterThan(realParentCid, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andRealParentCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(realParentCid, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andRealParentCidLessThan(Long value) {
            return lessThan(realParentCid, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andRealParentCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(realParentCid, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andRealParentCidIn(List<Long> values) {
            return in(realParentCid, values);
        }

        public StyleChannelCidSearchMapExample.Criteria andRealParentCidNotIn(List<Long> values) {
            return notIn(realParentCid, values);
        }

        public StyleChannelCidSearchMapExample.Criteria andRealParentCidBetween(Long value1, Long value2) {
            return between(realParentCid, value1, value2);
        }

        public StyleChannelCidSearchMapExample.Criteria andRealParentCidNotBetween(Long value1, Long value2) {
            return notBetween(realParentCid, value1, value2);
        }
        public StyleChannelCidSearchMapExample.Criteria andCateNameIsNull() {
            return isNull(cateName);
        }

        public StyleChannelCidSearchMapExample.Criteria andCateNameIsNotNull() {
            return isNotNull(cateName);
        }

        public StyleChannelCidSearchMapExample.Criteria andCateNameEqualTo(String value) {
            return equalTo(cateName, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andCateNameNotEqualTo(String value) {
            return notEqualTo(cateName, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andCateNameGreaterThan(String value) {
            return greaterThan(cateName, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andCateNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cateName, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andCateNameLessThan(String value) {
            return lessThan(cateName, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andCateNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cateName, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andCateNameLike(String value) {
            return like(cateName, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andCateNameNotLike(String value) {
            return notLike(cateName, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andCateNameIn(List<String> values) {
            return in(cateName, values);
        }

        public StyleChannelCidSearchMapExample.Criteria andCateNameNotIn(List<String> values) {
            return notIn(cateName, values);
        }

        public StyleChannelCidSearchMapExample.Criteria andCateNameBetween(String value1, String value2) {
            return between(cateName, value1, value2);
        }

        public StyleChannelCidSearchMapExample.Criteria andCateNameNotBetween(String value1, String value2) {
            return notBetween(cateName, value1, value2);
        }
        public StyleChannelCidSearchMapExample.Criteria andCidIsNull() {
            return isNull(cid);
        }

        public StyleChannelCidSearchMapExample.Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public StyleChannelCidSearchMapExample.Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public StyleChannelCidSearchMapExample.Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public StyleChannelCidSearchMapExample.Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public StyleChannelCidSearchMapExample.Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public StyleChannelCidSearchMapExample.Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
        }
    }
}