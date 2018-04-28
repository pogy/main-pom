package com.opentae.data.photo.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.photo.beans.ShiguPhotoUserPraise;

import java.util.*;
public class ShiguPhotoUserPraiseExample extends SgExample<ShiguPhotoUserPraiseExample.Criteria> {
    public static final Class<ShiguPhotoUserPraise> beanClass = ShiguPhotoUserPraise.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn worksId;
    public static EntityColumn praiseId;
    public static EntityColumn authorId;
    public static EntityColumn status;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        worksId = listMap.get("worksId");
        praiseId = listMap.get("praiseId");
        authorId = listMap.get("authorId");
        status = listMap.get("status");
        }

    public ShiguPhotoUserPraiseExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguPhotoUserPraiseExample.Criteria createCriteriaInternal() {
        return new ShiguPhotoUserPraiseExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguPhotoUserPraiseExample.Criteria andWorksIdIsNull() {
            return isNull(worksId);
        }

        public ShiguPhotoUserPraiseExample.Criteria andWorksIdIsNotNull() {
            return isNotNull(worksId);
        }

        public ShiguPhotoUserPraiseExample.Criteria andWorksIdEqualTo(Long value) {
            return equalTo(worksId, value);
        }

        public ShiguPhotoUserPraiseExample.Criteria andWorksIdNotEqualTo(Long value) {
            return notEqualTo(worksId, value);
        }

        public ShiguPhotoUserPraiseExample.Criteria andWorksIdGreaterThan(Long value) {
            return greaterThan(worksId, value);
        }

        public ShiguPhotoUserPraiseExample.Criteria andWorksIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(worksId, value);
        }

        public ShiguPhotoUserPraiseExample.Criteria andWorksIdLessThan(Long value) {
            return lessThan(worksId, value);
        }

        public ShiguPhotoUserPraiseExample.Criteria andWorksIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(worksId, value);
        }

        public ShiguPhotoUserPraiseExample.Criteria andWorksIdIn(List<Long> values) {
            return in(worksId, values);
        }

        public ShiguPhotoUserPraiseExample.Criteria andWorksIdNotIn(List<Long> values) {
            return notIn(worksId, values);
        }

        public ShiguPhotoUserPraiseExample.Criteria andWorksIdBetween(Long value1, Long value2) {
            return between(worksId, value1, value2);
        }

        public ShiguPhotoUserPraiseExample.Criteria andWorksIdNotBetween(Long value1, Long value2) {
            return notBetween(worksId, value1, value2);
        }
        public ShiguPhotoUserPraiseExample.Criteria andPraiseIdIsNull() {
            return isNull(praiseId);
        }

        public ShiguPhotoUserPraiseExample.Criteria andPraiseIdIsNotNull() {
            return isNotNull(praiseId);
        }

        public ShiguPhotoUserPraiseExample.Criteria andPraiseIdEqualTo(Long value) {
            return equalTo(praiseId, value);
        }

        public ShiguPhotoUserPraiseExample.Criteria andPraiseIdNotEqualTo(Long value) {
            return notEqualTo(praiseId, value);
        }

        public ShiguPhotoUserPraiseExample.Criteria andPraiseIdGreaterThan(Long value) {
            return greaterThan(praiseId, value);
        }

        public ShiguPhotoUserPraiseExample.Criteria andPraiseIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(praiseId, value);
        }

        public ShiguPhotoUserPraiseExample.Criteria andPraiseIdLessThan(Long value) {
            return lessThan(praiseId, value);
        }

        public ShiguPhotoUserPraiseExample.Criteria andPraiseIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(praiseId, value);
        }

        public ShiguPhotoUserPraiseExample.Criteria andPraiseIdIn(List<Long> values) {
            return in(praiseId, values);
        }

        public ShiguPhotoUserPraiseExample.Criteria andPraiseIdNotIn(List<Long> values) {
            return notIn(praiseId, values);
        }

        public ShiguPhotoUserPraiseExample.Criteria andPraiseIdBetween(Long value1, Long value2) {
            return between(praiseId, value1, value2);
        }

        public ShiguPhotoUserPraiseExample.Criteria andPraiseIdNotBetween(Long value1, Long value2) {
            return notBetween(praiseId, value1, value2);
        }
        public ShiguPhotoUserPraiseExample.Criteria andAuthorIdIsNull() {
            return isNull(authorId);
        }

        public ShiguPhotoUserPraiseExample.Criteria andAuthorIdIsNotNull() {
            return isNotNull(authorId);
        }

        public ShiguPhotoUserPraiseExample.Criteria andAuthorIdEqualTo(Long value) {
            return equalTo(authorId, value);
        }

        public ShiguPhotoUserPraiseExample.Criteria andAuthorIdNotEqualTo(Long value) {
            return notEqualTo(authorId, value);
        }

        public ShiguPhotoUserPraiseExample.Criteria andAuthorIdGreaterThan(Long value) {
            return greaterThan(authorId, value);
        }

        public ShiguPhotoUserPraiseExample.Criteria andAuthorIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(authorId, value);
        }

        public ShiguPhotoUserPraiseExample.Criteria andAuthorIdLessThan(Long value) {
            return lessThan(authorId, value);
        }

        public ShiguPhotoUserPraiseExample.Criteria andAuthorIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(authorId, value);
        }

        public ShiguPhotoUserPraiseExample.Criteria andAuthorIdIn(List<Long> values) {
            return in(authorId, values);
        }

        public ShiguPhotoUserPraiseExample.Criteria andAuthorIdNotIn(List<Long> values) {
            return notIn(authorId, values);
        }

        public ShiguPhotoUserPraiseExample.Criteria andAuthorIdBetween(Long value1, Long value2) {
            return between(authorId, value1, value2);
        }

        public ShiguPhotoUserPraiseExample.Criteria andAuthorIdNotBetween(Long value1, Long value2) {
            return notBetween(authorId, value1, value2);
        }
        public ShiguPhotoUserPraiseExample.Criteria andStatusIsNull() {
            return isNull(status);
        }

        public ShiguPhotoUserPraiseExample.Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public ShiguPhotoUserPraiseExample.Criteria andStatusEqualTo(Integer value) {
            return equalTo(status, value);
        }

        public ShiguPhotoUserPraiseExample.Criteria andStatusNotEqualTo(Integer value) {
            return notEqualTo(status, value);
        }

        public ShiguPhotoUserPraiseExample.Criteria andStatusGreaterThan(Integer value) {
            return greaterThan(status, value);
        }

        public ShiguPhotoUserPraiseExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(status, value);
        }

        public ShiguPhotoUserPraiseExample.Criteria andStatusLessThan(Integer value) {
            return lessThan(status, value);
        }

        public ShiguPhotoUserPraiseExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(status, value);
        }

        public ShiguPhotoUserPraiseExample.Criteria andStatusIn(List<Integer> values) {
            return in(status, values);
        }

        public ShiguPhotoUserPraiseExample.Criteria andStatusNotIn(List<Integer> values) {
            return notIn(status, values);
        }

        public ShiguPhotoUserPraiseExample.Criteria andStatusBetween(Integer value1, Integer value2) {
            return between(status, value1, value2);
        }

        public ShiguPhotoUserPraiseExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(status, value1, value2);
        }
    }
}