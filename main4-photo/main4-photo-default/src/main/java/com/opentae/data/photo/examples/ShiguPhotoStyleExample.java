package com.opentae.data.photo.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.photo.beans.ShiguPhotoStyle;

import java.util.*;
public class ShiguPhotoStyleExample extends SgExample<ShiguPhotoStyleExample.Criteria> {
    public static final Class<ShiguPhotoStyle> beanClass = ShiguPhotoStyle.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn styleId;
    public static EntityColumn styleName;
    public static EntityColumn authorId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        styleId = listMap.get("styleId");
        styleName = listMap.get("styleName");
        authorId = listMap.get("authorId");
        }

    public ShiguPhotoStyleExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguPhotoStyleExample.Criteria createCriteriaInternal() {
        return new ShiguPhotoStyleExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguPhotoStyleExample.Criteria andStyleIdIsNull() {
            return isNull(styleId);
        }

        public ShiguPhotoStyleExample.Criteria andStyleIdIsNotNull() {
            return isNotNull(styleId);
        }

        public ShiguPhotoStyleExample.Criteria andStyleIdEqualTo(Long value) {
            return equalTo(styleId, value);
        }

        public ShiguPhotoStyleExample.Criteria andStyleIdNotEqualTo(Long value) {
            return notEqualTo(styleId, value);
        }

        public ShiguPhotoStyleExample.Criteria andStyleIdGreaterThan(Long value) {
            return greaterThan(styleId, value);
        }

        public ShiguPhotoStyleExample.Criteria andStyleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(styleId, value);
        }

        public ShiguPhotoStyleExample.Criteria andStyleIdLessThan(Long value) {
            return lessThan(styleId, value);
        }

        public ShiguPhotoStyleExample.Criteria andStyleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(styleId, value);
        }

        public ShiguPhotoStyleExample.Criteria andStyleIdIn(List<Long> values) {
            return in(styleId, values);
        }

        public ShiguPhotoStyleExample.Criteria andStyleIdNotIn(List<Long> values) {
            return notIn(styleId, values);
        }

        public ShiguPhotoStyleExample.Criteria andStyleIdBetween(Long value1, Long value2) {
            return between(styleId, value1, value2);
        }

        public ShiguPhotoStyleExample.Criteria andStyleIdNotBetween(Long value1, Long value2) {
            return notBetween(styleId, value1, value2);
        }
        public ShiguPhotoStyleExample.Criteria andStyleNameIsNull() {
            return isNull(styleName);
        }

        public ShiguPhotoStyleExample.Criteria andStyleNameIsNotNull() {
            return isNotNull(styleName);
        }

        public ShiguPhotoStyleExample.Criteria andStyleNameEqualTo(String value) {
            return equalTo(styleName, value);
        }

        public ShiguPhotoStyleExample.Criteria andStyleNameNotEqualTo(String value) {
            return notEqualTo(styleName, value);
        }

        public ShiguPhotoStyleExample.Criteria andStyleNameGreaterThan(String value) {
            return greaterThan(styleName, value);
        }

        public ShiguPhotoStyleExample.Criteria andStyleNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(styleName, value);
        }

        public ShiguPhotoStyleExample.Criteria andStyleNameLessThan(String value) {
            return lessThan(styleName, value);
        }

        public ShiguPhotoStyleExample.Criteria andStyleNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(styleName, value);
        }

        public ShiguPhotoStyleExample.Criteria andStyleNameLike(String value) {
            return like(styleName, value);
        }

        public ShiguPhotoStyleExample.Criteria andStyleNameNotLike(String value) {
            return notLike(styleName, value);
        }

        public ShiguPhotoStyleExample.Criteria andStyleNameIn(List<String> values) {
            return in(styleName, values);
        }

        public ShiguPhotoStyleExample.Criteria andStyleNameNotIn(List<String> values) {
            return notIn(styleName, values);
        }

        public ShiguPhotoStyleExample.Criteria andStyleNameBetween(String value1, String value2) {
            return between(styleName, value1, value2);
        }

        public ShiguPhotoStyleExample.Criteria andStyleNameNotBetween(String value1, String value2) {
            return notBetween(styleName, value1, value2);
        }
        public ShiguPhotoStyleExample.Criteria andAuthorIdIsNull() {
            return isNull(authorId);
        }

        public ShiguPhotoStyleExample.Criteria andAuthorIdIsNotNull() {
            return isNotNull(authorId);
        }

        public ShiguPhotoStyleExample.Criteria andAuthorIdEqualTo(Long value) {
            return equalTo(authorId, value);
        }

        public ShiguPhotoStyleExample.Criteria andAuthorIdNotEqualTo(Long value) {
            return notEqualTo(authorId, value);
        }

        public ShiguPhotoStyleExample.Criteria andAuthorIdGreaterThan(Long value) {
            return greaterThan(authorId, value);
        }

        public ShiguPhotoStyleExample.Criteria andAuthorIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(authorId, value);
        }

        public ShiguPhotoStyleExample.Criteria andAuthorIdLessThan(Long value) {
            return lessThan(authorId, value);
        }

        public ShiguPhotoStyleExample.Criteria andAuthorIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(authorId, value);
        }

        public ShiguPhotoStyleExample.Criteria andAuthorIdIn(List<Long> values) {
            return in(authorId, values);
        }

        public ShiguPhotoStyleExample.Criteria andAuthorIdNotIn(List<Long> values) {
            return notIn(authorId, values);
        }

        public ShiguPhotoStyleExample.Criteria andAuthorIdBetween(Long value1, Long value2) {
            return between(authorId, value1, value2);
        }

        public ShiguPhotoStyleExample.Criteria andAuthorIdNotBetween(Long value1, Long value2) {
            return notBetween(authorId, value1, value2);
        }
    }
}