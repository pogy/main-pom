package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguActivityCategory;

import java.util.*;
public class ShiguActivityCategoryExample extends SgExample<ShiguActivityCategoryExample.Criteria> {
    public static final Class<ShiguActivityCategory> beanClass = ShiguActivityCategory.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn titleImg;
    public static EntityColumn cateId;
    public static EntityColumn activeId;
    public static EntityColumn title;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        titleImg = listMap.get("titleImg");
        cateId = listMap.get("cateId");
        activeId = listMap.get("activeId");
        title = listMap.get("title");
        }

    public ShiguActivityCategoryExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguActivityCategoryExample.Criteria createCriteriaInternal() {
        return new ShiguActivityCategoryExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgIsNull() {
            return isNull(titleImg);
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgIsNotNull() {
            return isNotNull(titleImg);
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgEqualTo(String value) {
            return equalTo(titleImg, value);
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgNotEqualTo(String value) {
            return notEqualTo(titleImg, value);
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgGreaterThan(String value) {
            return greaterThan(titleImg, value);
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(titleImg, value);
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgLessThan(String value) {
            return lessThan(titleImg, value);
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(titleImg, value);
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgLike(String value) {
            return like(titleImg, value);
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgNotLike(String value) {
            return notLike(titleImg, value);
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgIn(List<String> values) {
            return in(titleImg, values);
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgNotIn(List<String> values) {
            return notIn(titleImg, values);
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgBetween(String value1, String value2) {
            return between(titleImg, value1, value2);
        }

        public ShiguActivityCategoryExample.Criteria andTitleImgNotBetween(String value1, String value2) {
            return notBetween(titleImg, value1, value2);
        }
        public ShiguActivityCategoryExample.Criteria andCateIdIsNull() {
            return isNull(cateId);
        }

        public ShiguActivityCategoryExample.Criteria andCateIdIsNotNull() {
            return isNotNull(cateId);
        }

        public ShiguActivityCategoryExample.Criteria andCateIdEqualTo(Long value) {
            return equalTo(cateId, value);
        }

        public ShiguActivityCategoryExample.Criteria andCateIdNotEqualTo(Long value) {
            return notEqualTo(cateId, value);
        }

        public ShiguActivityCategoryExample.Criteria andCateIdGreaterThan(Long value) {
            return greaterThan(cateId, value);
        }

        public ShiguActivityCategoryExample.Criteria andCateIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cateId, value);
        }

        public ShiguActivityCategoryExample.Criteria andCateIdLessThan(Long value) {
            return lessThan(cateId, value);
        }

        public ShiguActivityCategoryExample.Criteria andCateIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cateId, value);
        }

        public ShiguActivityCategoryExample.Criteria andCateIdIn(List<Long> values) {
            return in(cateId, values);
        }

        public ShiguActivityCategoryExample.Criteria andCateIdNotIn(List<Long> values) {
            return notIn(cateId, values);
        }

        public ShiguActivityCategoryExample.Criteria andCateIdBetween(Long value1, Long value2) {
            return between(cateId, value1, value2);
        }

        public ShiguActivityCategoryExample.Criteria andCateIdNotBetween(Long value1, Long value2) {
            return notBetween(cateId, value1, value2);
        }
        public ShiguActivityCategoryExample.Criteria andActiveIdIsNull() {
            return isNull(activeId);
        }

        public ShiguActivityCategoryExample.Criteria andActiveIdIsNotNull() {
            return isNotNull(activeId);
        }

        public ShiguActivityCategoryExample.Criteria andActiveIdEqualTo(Long value) {
            return equalTo(activeId, value);
        }

        public ShiguActivityCategoryExample.Criteria andActiveIdNotEqualTo(Long value) {
            return notEqualTo(activeId, value);
        }

        public ShiguActivityCategoryExample.Criteria andActiveIdGreaterThan(Long value) {
            return greaterThan(activeId, value);
        }

        public ShiguActivityCategoryExample.Criteria andActiveIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(activeId, value);
        }

        public ShiguActivityCategoryExample.Criteria andActiveIdLessThan(Long value) {
            return lessThan(activeId, value);
        }

        public ShiguActivityCategoryExample.Criteria andActiveIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(activeId, value);
        }

        public ShiguActivityCategoryExample.Criteria andActiveIdIn(List<Long> values) {
            return in(activeId, values);
        }

        public ShiguActivityCategoryExample.Criteria andActiveIdNotIn(List<Long> values) {
            return notIn(activeId, values);
        }

        public ShiguActivityCategoryExample.Criteria andActiveIdBetween(Long value1, Long value2) {
            return between(activeId, value1, value2);
        }

        public ShiguActivityCategoryExample.Criteria andActiveIdNotBetween(Long value1, Long value2) {
            return notBetween(activeId, value1, value2);
        }
        public ShiguActivityCategoryExample.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public ShiguActivityCategoryExample.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public ShiguActivityCategoryExample.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public ShiguActivityCategoryExample.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public ShiguActivityCategoryExample.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public ShiguActivityCategoryExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public ShiguActivityCategoryExample.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public ShiguActivityCategoryExample.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public ShiguActivityCategoryExample.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public ShiguActivityCategoryExample.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public ShiguActivityCategoryExample.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public ShiguActivityCategoryExample.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public ShiguActivityCategoryExample.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public ShiguActivityCategoryExample.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
    }
}
