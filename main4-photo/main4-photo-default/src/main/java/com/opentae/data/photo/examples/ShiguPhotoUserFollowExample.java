package com.opentae.data.photo.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.photo.beans.ShiguPhotoUserFollow;

import java.util.*;
public class ShiguPhotoUserFollowExample extends SgExample<ShiguPhotoUserFollowExample.Criteria> {
    public static final Class<ShiguPhotoUserFollow> beanClass = ShiguPhotoUserFollow.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn followId;
    public static EntityColumn authorId;
    public static EntityColumn followAuthorId;
    public static EntityColumn status;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        followId = listMap.get("followId");
        authorId = listMap.get("authorId");
        followAuthorId = listMap.get("followAuthorId");
        status = listMap.get("status");
        }

    public ShiguPhotoUserFollowExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguPhotoUserFollowExample.Criteria createCriteriaInternal() {
        return new ShiguPhotoUserFollowExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowIdIsNull() {
            return isNull(followId);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowIdIsNotNull() {
            return isNotNull(followId);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowIdEqualTo(Long value) {
            return equalTo(followId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowIdNotEqualTo(Long value) {
            return notEqualTo(followId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowIdGreaterThan(Long value) {
            return greaterThan(followId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(followId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowIdLessThan(Long value) {
            return lessThan(followId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(followId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowIdIn(List<Long> values) {
            return in(followId, values);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowIdNotIn(List<Long> values) {
            return notIn(followId, values);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowIdBetween(Long value1, Long value2) {
            return between(followId, value1, value2);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowIdNotBetween(Long value1, Long value2) {
            return notBetween(followId, value1, value2);
        }
        public ShiguPhotoUserFollowExample.Criteria andAuthorIdIsNull() {
            return isNull(authorId);
        }

        public ShiguPhotoUserFollowExample.Criteria andAuthorIdIsNotNull() {
            return isNotNull(authorId);
        }

        public ShiguPhotoUserFollowExample.Criteria andAuthorIdEqualTo(Long value) {
            return equalTo(authorId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andAuthorIdNotEqualTo(Long value) {
            return notEqualTo(authorId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andAuthorIdGreaterThan(Long value) {
            return greaterThan(authorId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andAuthorIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(authorId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andAuthorIdLessThan(Long value) {
            return lessThan(authorId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andAuthorIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(authorId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andAuthorIdIn(List<Long> values) {
            return in(authorId, values);
        }

        public ShiguPhotoUserFollowExample.Criteria andAuthorIdNotIn(List<Long> values) {
            return notIn(authorId, values);
        }

        public ShiguPhotoUserFollowExample.Criteria andAuthorIdBetween(Long value1, Long value2) {
            return between(authorId, value1, value2);
        }

        public ShiguPhotoUserFollowExample.Criteria andAuthorIdNotBetween(Long value1, Long value2) {
            return notBetween(authorId, value1, value2);
        }
        public ShiguPhotoUserFollowExample.Criteria andFollowAuthorIdIsNull() {
            return isNull(followAuthorId);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowAuthorIdIsNotNull() {
            return isNotNull(followAuthorId);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowAuthorIdEqualTo(Long value) {
            return equalTo(followAuthorId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowAuthorIdNotEqualTo(Long value) {
            return notEqualTo(followAuthorId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowAuthorIdGreaterThan(Long value) {
            return greaterThan(followAuthorId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowAuthorIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(followAuthorId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowAuthorIdLessThan(Long value) {
            return lessThan(followAuthorId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowAuthorIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(followAuthorId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowAuthorIdIn(List<Long> values) {
            return in(followAuthorId, values);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowAuthorIdNotIn(List<Long> values) {
            return notIn(followAuthorId, values);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowAuthorIdBetween(Long value1, Long value2) {
            return between(followAuthorId, value1, value2);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowAuthorIdNotBetween(Long value1, Long value2) {
            return notBetween(followAuthorId, value1, value2);
        }
        public ShiguPhotoUserFollowExample.Criteria andStatusIsNull() {
            return isNull(status);
        }

        public ShiguPhotoUserFollowExample.Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public ShiguPhotoUserFollowExample.Criteria andStatusEqualTo(Integer value) {
            return equalTo(status, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andStatusNotEqualTo(Integer value) {
            return notEqualTo(status, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andStatusGreaterThan(Integer value) {
            return greaterThan(status, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(status, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andStatusLessThan(Integer value) {
            return lessThan(status, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(status, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andStatusIn(List<Integer> values) {
            return in(status, values);
        }

        public ShiguPhotoUserFollowExample.Criteria andStatusNotIn(List<Integer> values) {
            return notIn(status, values);
        }

        public ShiguPhotoUserFollowExample.Criteria andStatusBetween(Integer value1, Integer value2) {
            return between(status, value1, value2);
        }

        public ShiguPhotoUserFollowExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(status, value1, value2);
        }
    }
}