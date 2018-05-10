package com.opentae.data.photo.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.photo.beans.ShiguPhotoUserSelectedStyleRelation;

import java.util.*;
public class ShiguPhotoUserSelectedStyleRelationExample extends SgExample<ShiguPhotoUserSelectedStyleRelationExample.Criteria> {
    public static final Class<ShiguPhotoUserSelectedStyleRelation> beanClass = ShiguPhotoUserSelectedStyleRelation.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn styleId;
    public static EntityColumn authId;
    public static EntityColumn effected;
    public static EntityColumn authStyleRelaId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        styleId = listMap.get("styleId");
        authId = listMap.get("authId");
        effected = listMap.get("effected");
        authStyleRelaId = listMap.get("authStyleRelaId");
        }

    public ShiguPhotoUserSelectedStyleRelationExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguPhotoUserSelectedStyleRelationExample.Criteria createCriteriaInternal() {
        return new ShiguPhotoUserSelectedStyleRelationExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andStyleIdIsNull() {
            return isNull(styleId);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andStyleIdIsNotNull() {
            return isNotNull(styleId);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andStyleIdEqualTo(Long value) {
            return equalTo(styleId, value);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andStyleIdNotEqualTo(Long value) {
            return notEqualTo(styleId, value);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andStyleIdGreaterThan(Long value) {
            return greaterThan(styleId, value);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andStyleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(styleId, value);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andStyleIdLessThan(Long value) {
            return lessThan(styleId, value);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andStyleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(styleId, value);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andStyleIdIn(List<Long> values) {
            return in(styleId, values);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andStyleIdNotIn(List<Long> values) {
            return notIn(styleId, values);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andStyleIdBetween(Long value1, Long value2) {
            return between(styleId, value1, value2);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andStyleIdNotBetween(Long value1, Long value2) {
            return notBetween(styleId, value1, value2);
        }
        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andAuthIdIsNull() {
            return isNull(authId);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andAuthIdIsNotNull() {
            return isNotNull(authId);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andAuthIdEqualTo(Long value) {
            return equalTo(authId, value);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andAuthIdNotEqualTo(Long value) {
            return notEqualTo(authId, value);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andAuthIdGreaterThan(Long value) {
            return greaterThan(authId, value);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andAuthIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(authId, value);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andAuthIdLessThan(Long value) {
            return lessThan(authId, value);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andAuthIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(authId, value);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andAuthIdIn(List<Long> values) {
            return in(authId, values);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andAuthIdNotIn(List<Long> values) {
            return notIn(authId, values);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andAuthIdBetween(Long value1, Long value2) {
            return between(authId, value1, value2);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andAuthIdNotBetween(Long value1, Long value2) {
            return notBetween(authId, value1, value2);
        }
        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andEffectedIsNull() {
            return isNull(effected);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andEffectedIsNotNull() {
            return isNotNull(effected);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andEffectedEqualTo(Integer value) {
            return equalTo(effected, value);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andEffectedNotEqualTo(Integer value) {
            return notEqualTo(effected, value);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andEffectedGreaterThan(Integer value) {
            return greaterThan(effected, value);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andEffectedGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(effected, value);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andEffectedLessThan(Integer value) {
            return lessThan(effected, value);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andEffectedLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(effected, value);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andEffectedIn(List<Integer> values) {
            return in(effected, values);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andEffectedNotIn(List<Integer> values) {
            return notIn(effected, values);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andEffectedBetween(Integer value1, Integer value2) {
            return between(effected, value1, value2);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andEffectedNotBetween(Integer value1, Integer value2) {
            return notBetween(effected, value1, value2);
        }
        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andAuthStyleRelaIdIsNull() {
            return isNull(authStyleRelaId);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andAuthStyleRelaIdIsNotNull() {
            return isNotNull(authStyleRelaId);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andAuthStyleRelaIdEqualTo(Long value) {
            return equalTo(authStyleRelaId, value);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andAuthStyleRelaIdNotEqualTo(Long value) {
            return notEqualTo(authStyleRelaId, value);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andAuthStyleRelaIdGreaterThan(Long value) {
            return greaterThan(authStyleRelaId, value);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andAuthStyleRelaIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(authStyleRelaId, value);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andAuthStyleRelaIdLessThan(Long value) {
            return lessThan(authStyleRelaId, value);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andAuthStyleRelaIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(authStyleRelaId, value);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andAuthStyleRelaIdIn(List<Long> values) {
            return in(authStyleRelaId, values);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andAuthStyleRelaIdNotIn(List<Long> values) {
            return notIn(authStyleRelaId, values);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andAuthStyleRelaIdBetween(Long value1, Long value2) {
            return between(authStyleRelaId, value1, value2);
        }

        public ShiguPhotoUserSelectedStyleRelationExample.Criteria andAuthStyleRelaIdNotBetween(Long value1, Long value2) {
            return notBetween(authStyleRelaId, value1, value2);
        }
    }
}