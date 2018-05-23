package com.opentae.data.photo.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.photo.beans.ShiguPhotoWorksAuth;

import java.util.*;
public class ShiguPhotoWorksAuthExample extends SgExample<ShiguPhotoWorksAuthExample.Criteria> {
    public static final Class<ShiguPhotoWorksAuth> beanClass = ShiguPhotoWorksAuth.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn msg;
    public static EntityColumn picUrl;
    public static EntityColumn images;
    public static EntityColumn worksId;
    public static EntityColumn authStatus;
    public static EntityColumn worksAuthId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        msg = listMap.get("msg");
        picUrl = listMap.get("picUrl");
        images = listMap.get("images");
        worksId = listMap.get("worksId");
        authStatus = listMap.get("authStatus");
        worksAuthId = listMap.get("worksAuthId");
        }

    public ShiguPhotoWorksAuthExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguPhotoWorksAuthExample.Criteria createCriteriaInternal() {
        return new ShiguPhotoWorksAuthExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguPhotoWorksAuthExample.Criteria andMsgIsNull() {
            return isNull(msg);
        }

        public ShiguPhotoWorksAuthExample.Criteria andMsgIsNotNull() {
            return isNotNull(msg);
        }

        public ShiguPhotoWorksAuthExample.Criteria andMsgEqualTo(String value) {
            return equalTo(msg, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andMsgNotEqualTo(String value) {
            return notEqualTo(msg, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andMsgGreaterThan(String value) {
            return greaterThan(msg, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andMsgGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(msg, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andMsgLessThan(String value) {
            return lessThan(msg, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andMsgLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(msg, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andMsgLike(String value) {
            return like(msg, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andMsgNotLike(String value) {
            return notLike(msg, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andMsgIn(List<String> values) {
            return in(msg, values);
        }

        public ShiguPhotoWorksAuthExample.Criteria andMsgNotIn(List<String> values) {
            return notIn(msg, values);
        }

        public ShiguPhotoWorksAuthExample.Criteria andMsgBetween(String value1, String value2) {
            return between(msg, value1, value2);
        }

        public ShiguPhotoWorksAuthExample.Criteria andMsgNotBetween(String value1, String value2) {
            return notBetween(msg, value1, value2);
        }
        public ShiguPhotoWorksAuthExample.Criteria andPicUrlIsNull() {
            return isNull(picUrl);
        }

        public ShiguPhotoWorksAuthExample.Criteria andPicUrlIsNotNull() {
            return isNotNull(picUrl);
        }

        public ShiguPhotoWorksAuthExample.Criteria andPicUrlEqualTo(String value) {
            return equalTo(picUrl, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andPicUrlNotEqualTo(String value) {
            return notEqualTo(picUrl, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andPicUrlGreaterThan(String value) {
            return greaterThan(picUrl, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(picUrl, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andPicUrlLessThan(String value) {
            return lessThan(picUrl, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andPicUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(picUrl, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andPicUrlLike(String value) {
            return like(picUrl, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andPicUrlNotLike(String value) {
            return notLike(picUrl, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andPicUrlIn(List<String> values) {
            return in(picUrl, values);
        }

        public ShiguPhotoWorksAuthExample.Criteria andPicUrlNotIn(List<String> values) {
            return notIn(picUrl, values);
        }

        public ShiguPhotoWorksAuthExample.Criteria andPicUrlBetween(String value1, String value2) {
            return between(picUrl, value1, value2);
        }

        public ShiguPhotoWorksAuthExample.Criteria andPicUrlNotBetween(String value1, String value2) {
            return notBetween(picUrl, value1, value2);
        }
        public ShiguPhotoWorksAuthExample.Criteria andImagesIsNull() {
            return isNull(images);
        }

        public ShiguPhotoWorksAuthExample.Criteria andImagesIsNotNull() {
            return isNotNull(images);
        }

        public ShiguPhotoWorksAuthExample.Criteria andImagesEqualTo(String value) {
            return equalTo(images, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andImagesNotEqualTo(String value) {
            return notEqualTo(images, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andImagesGreaterThan(String value) {
            return greaterThan(images, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andImagesGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(images, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andImagesLessThan(String value) {
            return lessThan(images, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andImagesLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(images, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andImagesLike(String value) {
            return like(images, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andImagesNotLike(String value) {
            return notLike(images, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andImagesIn(List<String> values) {
            return in(images, values);
        }

        public ShiguPhotoWorksAuthExample.Criteria andImagesNotIn(List<String> values) {
            return notIn(images, values);
        }

        public ShiguPhotoWorksAuthExample.Criteria andImagesBetween(String value1, String value2) {
            return between(images, value1, value2);
        }

        public ShiguPhotoWorksAuthExample.Criteria andImagesNotBetween(String value1, String value2) {
            return notBetween(images, value1, value2);
        }
        public ShiguPhotoWorksAuthExample.Criteria andWorksIdIsNull() {
            return isNull(worksId);
        }

        public ShiguPhotoWorksAuthExample.Criteria andWorksIdIsNotNull() {
            return isNotNull(worksId);
        }

        public ShiguPhotoWorksAuthExample.Criteria andWorksIdEqualTo(Long value) {
            return equalTo(worksId, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andWorksIdNotEqualTo(Long value) {
            return notEqualTo(worksId, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andWorksIdGreaterThan(Long value) {
            return greaterThan(worksId, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andWorksIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(worksId, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andWorksIdLessThan(Long value) {
            return lessThan(worksId, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andWorksIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(worksId, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andWorksIdIn(List<Long> values) {
            return in(worksId, values);
        }

        public ShiguPhotoWorksAuthExample.Criteria andWorksIdNotIn(List<Long> values) {
            return notIn(worksId, values);
        }

        public ShiguPhotoWorksAuthExample.Criteria andWorksIdBetween(Long value1, Long value2) {
            return between(worksId, value1, value2);
        }

        public ShiguPhotoWorksAuthExample.Criteria andWorksIdNotBetween(Long value1, Long value2) {
            return notBetween(worksId, value1, value2);
        }
        public ShiguPhotoWorksAuthExample.Criteria andAuthStatusIsNull() {
            return isNull(authStatus);
        }

        public ShiguPhotoWorksAuthExample.Criteria andAuthStatusIsNotNull() {
            return isNotNull(authStatus);
        }

        public ShiguPhotoWorksAuthExample.Criteria andAuthStatusEqualTo(Integer value) {
            return equalTo(authStatus, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andAuthStatusNotEqualTo(Integer value) {
            return notEqualTo(authStatus, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andAuthStatusGreaterThan(Integer value) {
            return greaterThan(authStatus, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andAuthStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(authStatus, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andAuthStatusLessThan(Integer value) {
            return lessThan(authStatus, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andAuthStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(authStatus, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andAuthStatusIn(List<Integer> values) {
            return in(authStatus, values);
        }

        public ShiguPhotoWorksAuthExample.Criteria andAuthStatusNotIn(List<Integer> values) {
            return notIn(authStatus, values);
        }

        public ShiguPhotoWorksAuthExample.Criteria andAuthStatusBetween(Integer value1, Integer value2) {
            return between(authStatus, value1, value2);
        }

        public ShiguPhotoWorksAuthExample.Criteria andAuthStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(authStatus, value1, value2);
        }
        public ShiguPhotoWorksAuthExample.Criteria andWorksAuthIdIsNull() {
            return isNull(worksAuthId);
        }

        public ShiguPhotoWorksAuthExample.Criteria andWorksAuthIdIsNotNull() {
            return isNotNull(worksAuthId);
        }

        public ShiguPhotoWorksAuthExample.Criteria andWorksAuthIdEqualTo(Long value) {
            return equalTo(worksAuthId, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andWorksAuthIdNotEqualTo(Long value) {
            return notEqualTo(worksAuthId, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andWorksAuthIdGreaterThan(Long value) {
            return greaterThan(worksAuthId, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andWorksAuthIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(worksAuthId, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andWorksAuthIdLessThan(Long value) {
            return lessThan(worksAuthId, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andWorksAuthIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(worksAuthId, value);
        }

        public ShiguPhotoWorksAuthExample.Criteria andWorksAuthIdIn(List<Long> values) {
            return in(worksAuthId, values);
        }

        public ShiguPhotoWorksAuthExample.Criteria andWorksAuthIdNotIn(List<Long> values) {
            return notIn(worksAuthId, values);
        }

        public ShiguPhotoWorksAuthExample.Criteria andWorksAuthIdBetween(Long value1, Long value2) {
            return between(worksAuthId, value1, value2);
        }

        public ShiguPhotoWorksAuthExample.Criteria andWorksAuthIdNotBetween(Long value1, Long value2) {
            return notBetween(worksAuthId, value1, value2);
        }
    }
}