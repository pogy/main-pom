package com.opentae.data.photo.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.photo.beans.ShiguPhotoGoatNav;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShiguPhotoGoatNavExample extends SgExample<ShiguPhotoGoatNavExample.Criteria> {
    public static final Class<ShiguPhotoGoatNav> beanClass = ShiguPhotoGoatNav.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn pageGuide;
    public static EntityColumn targetId;
    public static EntityColumn navId;
    public static EntityColumn parentNavName;
    public static EntityColumn navName;
    public static EntityColumn hot;
    public static EntityColumn parentNavId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        pageGuide = listMap.get("pageGuide");
        targetId = listMap.get("targetId");
        navId = listMap.get("navId");
        parentNavName = listMap.get("parentNavName");
        navName = listMap.get("navName");
        hot = listMap.get("hot");
        parentNavId = listMap.get("parentNavId");
        }

    public ShiguPhotoGoatNavExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguPhotoGoatNavExample.Criteria createCriteriaInternal() {
        return new ShiguPhotoGoatNavExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguPhotoGoatNavExample.Criteria andPageGuideIsNull() {
            return isNull(pageGuide);
        }

        public ShiguPhotoGoatNavExample.Criteria andPageGuideIsNotNull() {
            return isNotNull(pageGuide);
        }

        public ShiguPhotoGoatNavExample.Criteria andPageGuideEqualTo(Integer value) {
            return equalTo(pageGuide, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andPageGuideNotEqualTo(Integer value) {
            return notEqualTo(pageGuide, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andPageGuideGreaterThan(Integer value) {
            return greaterThan(pageGuide, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andPageGuideGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(pageGuide, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andPageGuideLessThan(Integer value) {
            return lessThan(pageGuide, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andPageGuideLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(pageGuide, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andPageGuideIn(List<Integer> values) {
            return in(pageGuide, values);
        }

        public ShiguPhotoGoatNavExample.Criteria andPageGuideNotIn(List<Integer> values) {
            return notIn(pageGuide, values);
        }

        public ShiguPhotoGoatNavExample.Criteria andPageGuideBetween(Integer value1, Integer value2) {
            return between(pageGuide, value1, value2);
        }

        public ShiguPhotoGoatNavExample.Criteria andPageGuideNotBetween(Integer value1, Integer value2) {
            return notBetween(pageGuide, value1, value2);
        }
        public ShiguPhotoGoatNavExample.Criteria andTargetIdIsNull() {
            return isNull(targetId);
        }

        public ShiguPhotoGoatNavExample.Criteria andTargetIdIsNotNull() {
            return isNotNull(targetId);
        }

        public ShiguPhotoGoatNavExample.Criteria andTargetIdEqualTo(Long value) {
            return equalTo(targetId, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andTargetIdNotEqualTo(Long value) {
            return notEqualTo(targetId, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andTargetIdGreaterThan(Long value) {
            return greaterThan(targetId, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andTargetIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(targetId, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andTargetIdLessThan(Long value) {
            return lessThan(targetId, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andTargetIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(targetId, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andTargetIdIn(List<Long> values) {
            return in(targetId, values);
        }

        public ShiguPhotoGoatNavExample.Criteria andTargetIdNotIn(List<Long> values) {
            return notIn(targetId, values);
        }

        public ShiguPhotoGoatNavExample.Criteria andTargetIdBetween(Long value1, Long value2) {
            return between(targetId, value1, value2);
        }

        public ShiguPhotoGoatNavExample.Criteria andTargetIdNotBetween(Long value1, Long value2) {
            return notBetween(targetId, value1, value2);
        }
        public ShiguPhotoGoatNavExample.Criteria andNavIdIsNull() {
            return isNull(navId);
        }

        public ShiguPhotoGoatNavExample.Criteria andNavIdIsNotNull() {
            return isNotNull(navId);
        }

        public ShiguPhotoGoatNavExample.Criteria andNavIdEqualTo(Long value) {
            return equalTo(navId, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andNavIdNotEqualTo(Long value) {
            return notEqualTo(navId, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andNavIdGreaterThan(Long value) {
            return greaterThan(navId, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andNavIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(navId, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andNavIdLessThan(Long value) {
            return lessThan(navId, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andNavIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(navId, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andNavIdIn(List<Long> values) {
            return in(navId, values);
        }

        public ShiguPhotoGoatNavExample.Criteria andNavIdNotIn(List<Long> values) {
            return notIn(navId, values);
        }

        public ShiguPhotoGoatNavExample.Criteria andNavIdBetween(Long value1, Long value2) {
            return between(navId, value1, value2);
        }

        public ShiguPhotoGoatNavExample.Criteria andNavIdNotBetween(Long value1, Long value2) {
            return notBetween(navId, value1, value2);
        }
        public ShiguPhotoGoatNavExample.Criteria andParentNavNameIsNull() {
            return isNull(parentNavName);
        }

        public ShiguPhotoGoatNavExample.Criteria andParentNavNameIsNotNull() {
            return isNotNull(parentNavName);
        }

        public ShiguPhotoGoatNavExample.Criteria andParentNavNameEqualTo(String value) {
            return equalTo(parentNavName, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andParentNavNameNotEqualTo(String value) {
            return notEqualTo(parentNavName, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andParentNavNameGreaterThan(String value) {
            return greaterThan(parentNavName, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andParentNavNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(parentNavName, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andParentNavNameLessThan(String value) {
            return lessThan(parentNavName, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andParentNavNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(parentNavName, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andParentNavNameLike(String value) {
            return like(parentNavName, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andParentNavNameNotLike(String value) {
            return notLike(parentNavName, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andParentNavNameIn(List<String> values) {
            return in(parentNavName, values);
        }

        public ShiguPhotoGoatNavExample.Criteria andParentNavNameNotIn(List<String> values) {
            return notIn(parentNavName, values);
        }

        public ShiguPhotoGoatNavExample.Criteria andParentNavNameBetween(String value1, String value2) {
            return between(parentNavName, value1, value2);
        }

        public ShiguPhotoGoatNavExample.Criteria andParentNavNameNotBetween(String value1, String value2) {
            return notBetween(parentNavName, value1, value2);
        }
        public ShiguPhotoGoatNavExample.Criteria andNavNameIsNull() {
            return isNull(navName);
        }

        public ShiguPhotoGoatNavExample.Criteria andNavNameIsNotNull() {
            return isNotNull(navName);
        }

        public ShiguPhotoGoatNavExample.Criteria andNavNameEqualTo(String value) {
            return equalTo(navName, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andNavNameNotEqualTo(String value) {
            return notEqualTo(navName, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andNavNameGreaterThan(String value) {
            return greaterThan(navName, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andNavNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(navName, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andNavNameLessThan(String value) {
            return lessThan(navName, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andNavNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(navName, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andNavNameLike(String value) {
            return like(navName, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andNavNameNotLike(String value) {
            return notLike(navName, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andNavNameIn(List<String> values) {
            return in(navName, values);
        }

        public ShiguPhotoGoatNavExample.Criteria andNavNameNotIn(List<String> values) {
            return notIn(navName, values);
        }

        public ShiguPhotoGoatNavExample.Criteria andNavNameBetween(String value1, String value2) {
            return between(navName, value1, value2);
        }

        public ShiguPhotoGoatNavExample.Criteria andNavNameNotBetween(String value1, String value2) {
            return notBetween(navName, value1, value2);
        }
        public ShiguPhotoGoatNavExample.Criteria andHotIsNull() {
            return isNull(hot);
        }

        public ShiguPhotoGoatNavExample.Criteria andHotIsNotNull() {
            return isNotNull(hot);
        }

        public ShiguPhotoGoatNavExample.Criteria andHotEqualTo(Boolean value) {
            return equalTo(hot, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andHotNotEqualTo(Boolean value) {
            return notEqualTo(hot, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andHotGreaterThan(Boolean value) {
            return greaterThan(hot, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andHotGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(hot, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andHotLessThan(Boolean value) {
            return lessThan(hot, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andHotLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(hot, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andHotIn(List<Boolean> values) {
            return in(hot, values);
        }

        public ShiguPhotoGoatNavExample.Criteria andHotNotIn(List<Boolean> values) {
            return notIn(hot, values);
        }

        public ShiguPhotoGoatNavExample.Criteria andHotBetween(Boolean value1, Boolean value2) {
            return between(hot, value1, value2);
        }

        public ShiguPhotoGoatNavExample.Criteria andHotNotBetween(Boolean value1, Boolean value2) {
            return notBetween(hot, value1, value2);
        }
        public ShiguPhotoGoatNavExample.Criteria andParentNavIdIsNull() {
            return isNull(parentNavId);
        }

        public ShiguPhotoGoatNavExample.Criteria andParentNavIdIsNotNull() {
            return isNotNull(parentNavId);
        }

        public ShiguPhotoGoatNavExample.Criteria andParentNavIdEqualTo(Long value) {
            return equalTo(parentNavId, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andParentNavIdNotEqualTo(Long value) {
            return notEqualTo(parentNavId, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andParentNavIdGreaterThan(Long value) {
            return greaterThan(parentNavId, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andParentNavIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentNavId, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andParentNavIdLessThan(Long value) {
            return lessThan(parentNavId, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andParentNavIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentNavId, value);
        }

        public ShiguPhotoGoatNavExample.Criteria andParentNavIdIn(List<Long> values) {
            return in(parentNavId, values);
        }

        public ShiguPhotoGoatNavExample.Criteria andParentNavIdNotIn(List<Long> values) {
            return notIn(parentNavId, values);
        }

        public ShiguPhotoGoatNavExample.Criteria andParentNavIdBetween(Long value1, Long value2) {
            return between(parentNavId, value1, value2);
        }

        public ShiguPhotoGoatNavExample.Criteria andParentNavIdNotBetween(Long value1, Long value2) {
            return notBetween(parentNavId, value1, value2);
        }
    }
}