package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguPropImgs;

import java.util.*;
public class ShiguPropImgsExample extends SgExample<ShiguPropImgsExample.Criteria> {
    public static final Class<ShiguPropImgs> beanClass = ShiguPropImgs.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn itemId;
    public static EntityColumn propimgId;
    public static EntityColumn propimgs;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        itemId = listMap.get("itemId");
        propimgId = listMap.get("propimgId");
        propimgs = listMap.get("propimgs");
        }

    public ShiguPropImgsExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguPropImgsExample.Criteria createCriteriaInternal() {
        return new ShiguPropImgsExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguPropImgsExample.Criteria andItemIdIsNull() {
            return isNull(itemId);
        }

        public ShiguPropImgsExample.Criteria andItemIdIsNotNull() {
            return isNotNull(itemId);
        }

        public ShiguPropImgsExample.Criteria andItemIdEqualTo(Long value) {
            return equalTo(itemId, value);
        }

        public ShiguPropImgsExample.Criteria andItemIdNotEqualTo(Long value) {
            return notEqualTo(itemId, value);
        }

        public ShiguPropImgsExample.Criteria andItemIdGreaterThan(Long value) {
            return greaterThan(itemId, value);
        }

        public ShiguPropImgsExample.Criteria andItemIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(itemId, value);
        }

        public ShiguPropImgsExample.Criteria andItemIdLessThan(Long value) {
            return lessThan(itemId, value);
        }

        public ShiguPropImgsExample.Criteria andItemIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(itemId, value);
        }

        public ShiguPropImgsExample.Criteria andItemIdIn(List<Long> values) {
            return in(itemId, values);
        }

        public ShiguPropImgsExample.Criteria andItemIdNotIn(List<Long> values) {
            return notIn(itemId, values);
        }

        public ShiguPropImgsExample.Criteria andItemIdBetween(Long value1, Long value2) {
            return between(itemId, value1, value2);
        }

        public ShiguPropImgsExample.Criteria andItemIdNotBetween(Long value1, Long value2) {
            return notBetween(itemId, value1, value2);
        }
        public ShiguPropImgsExample.Criteria andPropimgIdIsNull() {
            return isNull(propimgId);
        }

        public ShiguPropImgsExample.Criteria andPropimgIdIsNotNull() {
            return isNotNull(propimgId);
        }

        public ShiguPropImgsExample.Criteria andPropimgIdEqualTo(Long value) {
            return equalTo(propimgId, value);
        }

        public ShiguPropImgsExample.Criteria andPropimgIdNotEqualTo(Long value) {
            return notEqualTo(propimgId, value);
        }

        public ShiguPropImgsExample.Criteria andPropimgIdGreaterThan(Long value) {
            return greaterThan(propimgId, value);
        }

        public ShiguPropImgsExample.Criteria andPropimgIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(propimgId, value);
        }

        public ShiguPropImgsExample.Criteria andPropimgIdLessThan(Long value) {
            return lessThan(propimgId, value);
        }

        public ShiguPropImgsExample.Criteria andPropimgIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(propimgId, value);
        }

        public ShiguPropImgsExample.Criteria andPropimgIdIn(List<Long> values) {
            return in(propimgId, values);
        }

        public ShiguPropImgsExample.Criteria andPropimgIdNotIn(List<Long> values) {
            return notIn(propimgId, values);
        }

        public ShiguPropImgsExample.Criteria andPropimgIdBetween(Long value1, Long value2) {
            return between(propimgId, value1, value2);
        }

        public ShiguPropImgsExample.Criteria andPropimgIdNotBetween(Long value1, Long value2) {
            return notBetween(propimgId, value1, value2);
        }
        public ShiguPropImgsExample.Criteria andPropimgsIsNull() {
            return isNull(propimgs);
        }

        public ShiguPropImgsExample.Criteria andPropimgsIsNotNull() {
            return isNotNull(propimgs);
        }

        public ShiguPropImgsExample.Criteria andPropimgsEqualTo(String value) {
            return equalTo(propimgs, value);
        }

        public ShiguPropImgsExample.Criteria andPropimgsNotEqualTo(String value) {
            return notEqualTo(propimgs, value);
        }

        public ShiguPropImgsExample.Criteria andPropimgsGreaterThan(String value) {
            return greaterThan(propimgs, value);
        }

        public ShiguPropImgsExample.Criteria andPropimgsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(propimgs, value);
        }

        public ShiguPropImgsExample.Criteria andPropimgsLessThan(String value) {
            return lessThan(propimgs, value);
        }

        public ShiguPropImgsExample.Criteria andPropimgsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(propimgs, value);
        }

        public ShiguPropImgsExample.Criteria andPropimgsLike(String value) {
            return like(propimgs, value);
        }

        public ShiguPropImgsExample.Criteria andPropimgsNotLike(String value) {
            return notLike(propimgs, value);
        }

        public ShiguPropImgsExample.Criteria andPropimgsIn(List<String> values) {
            return in(propimgs, values);
        }

        public ShiguPropImgsExample.Criteria andPropimgsNotIn(List<String> values) {
            return notIn(propimgs, values);
        }

        public ShiguPropImgsExample.Criteria andPropimgsBetween(String value1, String value2) {
            return between(propimgs, value1, value2);
        }

        public ShiguPropImgsExample.Criteria andPropimgsNotBetween(String value1, String value2) {
            return notBetween(propimgs, value1, value2);
        }
    }
}
