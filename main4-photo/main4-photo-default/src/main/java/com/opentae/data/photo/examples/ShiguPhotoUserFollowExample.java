package com.opentae.data.photo.examples;

import com.opentae.data.photo.beans.ShiguPhotoUserFollow;
import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;

import java.util.*;
public class ShiguPhotoUserFollowExample extends SgExample<ShiguPhotoUserFollowExample.Criteria> {
    public static final Class<ShiguPhotoUserFollow> beanClass = ShiguPhotoUserFollow.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn followId;
    public static EntityColumn followUserId;
    public static EntityColumn userId;
    public static EntityColumn status;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        followId = listMap.get("followId");
        followUserId = listMap.get("followUserId");
        userId = listMap.get("userId");
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
        public ShiguPhotoUserFollowExample.Criteria andFollowUserIdIsNull() {
            return isNull(followUserId);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowUserIdIsNotNull() {
            return isNotNull(followUserId);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowUserIdEqualTo(Long value) {
            return equalTo(followUserId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowUserIdNotEqualTo(Long value) {
            return notEqualTo(followUserId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowUserIdGreaterThan(Long value) {
            return greaterThan(followUserId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(followUserId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowUserIdLessThan(Long value) {
            return lessThan(followUserId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(followUserId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowUserIdIn(List<Long> values) {
            return in(followUserId, values);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowUserIdNotIn(List<Long> values) {
            return notIn(followUserId, values);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowUserIdBetween(Long value1, Long value2) {
            return between(followUserId, value1, value2);
        }

        public ShiguPhotoUserFollowExample.Criteria andFollowUserIdNotBetween(Long value1, Long value2) {
            return notBetween(followUserId, value1, value2);
        }
        public ShiguPhotoUserFollowExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public ShiguPhotoUserFollowExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public ShiguPhotoUserFollowExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public ShiguPhotoUserFollowExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public ShiguPhotoUserFollowExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public ShiguPhotoUserFollowExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public ShiguPhotoUserFollowExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
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