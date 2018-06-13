package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguGysCustomCategory;

import java.util.*;
public class ShiguGysCustomCategoryExample extends SgExample<ShiguGysCustomCategoryExample.Criteria> {
    public static final Class<ShiguGysCustomCategory> beanClass = ShiguGysCustomCategory.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn gcId;
    public static EntityColumn gcStatus;
    public static EntityColumn gcName;
    public static EntityColumn sId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        gcId = listMap.get("gcId");
        gcStatus = listMap.get("gcStatus");
        gcName = listMap.get("gcName");
        sId = listMap.get("sId");
        }

    public ShiguGysCustomCategoryExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguGysCustomCategoryExample.Criteria createCriteriaInternal() {
        return new ShiguGysCustomCategoryExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcIdIsNull() {
            return isNull(gcId);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcIdIsNotNull() {
            return isNotNull(gcId);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcIdEqualTo(Long value) {
            return equalTo(gcId, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcIdNotEqualTo(Long value) {
            return notEqualTo(gcId, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcIdGreaterThan(Long value) {
            return greaterThan(gcId, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(gcId, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcIdLessThan(Long value) {
            return lessThan(gcId, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(gcId, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcIdIn(List<Long> values) {
            return in(gcId, values);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcIdNotIn(List<Long> values) {
            return notIn(gcId, values);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcIdBetween(Long value1, Long value2) {
            return between(gcId, value1, value2);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcIdNotBetween(Long value1, Long value2) {
            return notBetween(gcId, value1, value2);
        }
        public ShiguGysCustomCategoryExample.Criteria andGcStatusIsNull() {
            return isNull(gcStatus);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcStatusIsNotNull() {
            return isNotNull(gcStatus);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcStatusEqualTo(Integer value) {
            return equalTo(gcStatus, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcStatusNotEqualTo(Integer value) {
            return notEqualTo(gcStatus, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcStatusGreaterThan(Integer value) {
            return greaterThan(gcStatus, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(gcStatus, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcStatusLessThan(Integer value) {
            return lessThan(gcStatus, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(gcStatus, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcStatusIn(List<Integer> values) {
            return in(gcStatus, values);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcStatusNotIn(List<Integer> values) {
            return notIn(gcStatus, values);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcStatusBetween(Integer value1, Integer value2) {
            return between(gcStatus, value1, value2);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(gcStatus, value1, value2);
        }
        public ShiguGysCustomCategoryExample.Criteria andGcNameIsNull() {
            return isNull(gcName);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcNameIsNotNull() {
            return isNotNull(gcName);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcNameEqualTo(String value) {
            return equalTo(gcName, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcNameNotEqualTo(String value) {
            return notEqualTo(gcName, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcNameGreaterThan(String value) {
            return greaterThan(gcName, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(gcName, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcNameLessThan(String value) {
            return lessThan(gcName, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(gcName, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcNameLike(String value) {
            return like(gcName, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcNameNotLike(String value) {
            return notLike(gcName, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcNameIn(List<String> values) {
            return in(gcName, values);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcNameNotIn(List<String> values) {
            return notIn(gcName, values);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcNameBetween(String value1, String value2) {
            return between(gcName, value1, value2);
        }

        public ShiguGysCustomCategoryExample.Criteria andGcNameNotBetween(String value1, String value2) {
            return notBetween(gcName, value1, value2);
        }
        public ShiguGysCustomCategoryExample.Criteria andSIdIsNull() {
            return isNull(sId);
        }

        public ShiguGysCustomCategoryExample.Criteria andSIdIsNotNull() {
            return isNotNull(sId);
        }

        public ShiguGysCustomCategoryExample.Criteria andSIdEqualTo(Long value) {
            return equalTo(sId, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andSIdNotEqualTo(Long value) {
            return notEqualTo(sId, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andSIdGreaterThan(Long value) {
            return greaterThan(sId, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andSIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sId, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andSIdLessThan(Long value) {
            return lessThan(sId, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andSIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sId, value);
        }

        public ShiguGysCustomCategoryExample.Criteria andSIdIn(List<Long> values) {
            return in(sId, values);
        }

        public ShiguGysCustomCategoryExample.Criteria andSIdNotIn(List<Long> values) {
            return notIn(sId, values);
        }

        public ShiguGysCustomCategoryExample.Criteria andSIdBetween(Long value1, Long value2) {
            return between(sId, value1, value2);
        }

        public ShiguGysCustomCategoryExample.Criteria andSIdNotBetween(Long value1, Long value2) {
            return notBetween(sId, value1, value2);
        }
    }
}