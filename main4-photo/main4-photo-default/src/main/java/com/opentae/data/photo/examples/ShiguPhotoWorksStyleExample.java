package com.opentae.data.photo.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.photo.beans.ShiguPhotoWorksStyle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShiguPhotoWorksStyleExample extends SgExample<ShiguPhotoWorksStyleExample.Criteria> {
    public static final Class<ShiguPhotoWorksStyle> beanClass = ShiguPhotoWorksStyle.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn linkId;
    public static EntityColumn worksId;
    public static EntityColumn styleId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        linkId = listMap.get("linkId");
        worksId = listMap.get("worksId");
        styleId = listMap.get("styleId");
        }

    public ShiguPhotoWorksStyleExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguPhotoWorksStyleExample.Criteria createCriteriaInternal() {
        return new ShiguPhotoWorksStyleExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguPhotoWorksStyleExample.Criteria andLinkIdIsNull() {
            return isNull(linkId);
        }

        public ShiguPhotoWorksStyleExample.Criteria andLinkIdIsNotNull() {
            return isNotNull(linkId);
        }

        public ShiguPhotoWorksStyleExample.Criteria andLinkIdEqualTo(Long value) {
            return equalTo(linkId, value);
        }

        public ShiguPhotoWorksStyleExample.Criteria andLinkIdNotEqualTo(Long value) {
            return notEqualTo(linkId, value);
        }

        public ShiguPhotoWorksStyleExample.Criteria andLinkIdGreaterThan(Long value) {
            return greaterThan(linkId, value);
        }

        public ShiguPhotoWorksStyleExample.Criteria andLinkIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(linkId, value);
        }

        public ShiguPhotoWorksStyleExample.Criteria andLinkIdLessThan(Long value) {
            return lessThan(linkId, value);
        }

        public ShiguPhotoWorksStyleExample.Criteria andLinkIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(linkId, value);
        }

        public ShiguPhotoWorksStyleExample.Criteria andLinkIdIn(List<Long> values) {
            return in(linkId, values);
        }

        public ShiguPhotoWorksStyleExample.Criteria andLinkIdNotIn(List<Long> values) {
            return notIn(linkId, values);
        }

        public ShiguPhotoWorksStyleExample.Criteria andLinkIdBetween(Long value1, Long value2) {
            return between(linkId, value1, value2);
        }

        public ShiguPhotoWorksStyleExample.Criteria andLinkIdNotBetween(Long value1, Long value2) {
            return notBetween(linkId, value1, value2);
        }
        public ShiguPhotoWorksStyleExample.Criteria andWorksIdIsNull() {
            return isNull(worksId);
        }

        public ShiguPhotoWorksStyleExample.Criteria andWorksIdIsNotNull() {
            return isNotNull(worksId);
        }

        public ShiguPhotoWorksStyleExample.Criteria andWorksIdEqualTo(Long value) {
            return equalTo(worksId, value);
        }

        public ShiguPhotoWorksStyleExample.Criteria andWorksIdNotEqualTo(Long value) {
            return notEqualTo(worksId, value);
        }

        public ShiguPhotoWorksStyleExample.Criteria andWorksIdGreaterThan(Long value) {
            return greaterThan(worksId, value);
        }

        public ShiguPhotoWorksStyleExample.Criteria andWorksIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(worksId, value);
        }

        public ShiguPhotoWorksStyleExample.Criteria andWorksIdLessThan(Long value) {
            return lessThan(worksId, value);
        }

        public ShiguPhotoWorksStyleExample.Criteria andWorksIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(worksId, value);
        }

        public ShiguPhotoWorksStyleExample.Criteria andWorksIdIn(List<Long> values) {
            return in(worksId, values);
        }

        public ShiguPhotoWorksStyleExample.Criteria andWorksIdNotIn(List<Long> values) {
            return notIn(worksId, values);
        }

        public ShiguPhotoWorksStyleExample.Criteria andWorksIdBetween(Long value1, Long value2) {
            return between(worksId, value1, value2);
        }

        public ShiguPhotoWorksStyleExample.Criteria andWorksIdNotBetween(Long value1, Long value2) {
            return notBetween(worksId, value1, value2);
        }
        public ShiguPhotoWorksStyleExample.Criteria andStyleIdIsNull() {
            return isNull(styleId);
        }

        public ShiguPhotoWorksStyleExample.Criteria andStyleIdIsNotNull() {
            return isNotNull(styleId);
        }

        public ShiguPhotoWorksStyleExample.Criteria andStyleIdEqualTo(Long value) {
            return equalTo(styleId, value);
        }

        public ShiguPhotoWorksStyleExample.Criteria andStyleIdNotEqualTo(Long value) {
            return notEqualTo(styleId, value);
        }

        public ShiguPhotoWorksStyleExample.Criteria andStyleIdGreaterThan(Long value) {
            return greaterThan(styleId, value);
        }

        public ShiguPhotoWorksStyleExample.Criteria andStyleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(styleId, value);
        }

        public ShiguPhotoWorksStyleExample.Criteria andStyleIdLessThan(Long value) {
            return lessThan(styleId, value);
        }

        public ShiguPhotoWorksStyleExample.Criteria andStyleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(styleId, value);
        }

        public ShiguPhotoWorksStyleExample.Criteria andStyleIdIn(List<Long> values) {
            return in(styleId, values);
        }

        public ShiguPhotoWorksStyleExample.Criteria andStyleIdNotIn(List<Long> values) {
            return notIn(styleId, values);
        }

        public ShiguPhotoWorksStyleExample.Criteria andStyleIdBetween(Long value1, Long value2) {
            return between(styleId, value1, value2);
        }

        public ShiguPhotoWorksStyleExample.Criteria andStyleIdNotBetween(Long value1, Long value2) {
            return notBetween(styleId, value1, value2);
        }
    }
}