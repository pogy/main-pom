package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguPropImgs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    protected Criteria createCriteriaInternal() {
        return new Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public Criteria andItemIdIsNull() {
            return isNull(itemId);
        }

        public Criteria andItemIdIsNotNull() {
            return isNotNull(itemId);
        }

        public Criteria andItemIdEqualTo(Long value) {
            return equalTo(itemId, value);
        }

        public Criteria andItemIdNotEqualTo(Long value) {
            return notEqualTo(itemId, value);
        }

        public Criteria andItemIdGreaterThan(Long value) {
            return greaterThan(itemId, value);
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(itemId, value);
        }

        public Criteria andItemIdLessThan(Long value) {
            return lessThan(itemId, value);
        }

        public Criteria andItemIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(itemId, value);
        }

        public Criteria andItemIdIn(List<Long> values) {
            return in(itemId, values);
        }

        public Criteria andItemIdNotIn(List<Long> values) {
            return notIn(itemId, values);
        }

        public Criteria andItemIdBetween(Long value1, Long value2) {
            return between(itemId, value1, value2);
        }

        public Criteria andItemIdNotBetween(Long value1, Long value2) {
            return notBetween(itemId, value1, value2);
        }
        public Criteria andPropimgIdIsNull() {
            return isNull(propimgId);
        }

        public Criteria andPropimgIdIsNotNull() {
            return isNotNull(propimgId);
        }

        public Criteria andPropimgIdEqualTo(Long value) {
            return equalTo(propimgId, value);
        }

        public Criteria andPropimgIdNotEqualTo(Long value) {
            return notEqualTo(propimgId, value);
        }

        public Criteria andPropimgIdGreaterThan(Long value) {
            return greaterThan(propimgId, value);
        }

        public Criteria andPropimgIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(propimgId, value);
        }

        public Criteria andPropimgIdLessThan(Long value) {
            return lessThan(propimgId, value);
        }

        public Criteria andPropimgIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(propimgId, value);
        }

        public Criteria andPropimgIdIn(List<Long> values) {
            return in(propimgId, values);
        }

        public Criteria andPropimgIdNotIn(List<Long> values) {
            return notIn(propimgId, values);
        }

        public Criteria andPropimgIdBetween(Long value1, Long value2) {
            return between(propimgId, value1, value2);
        }

        public Criteria andPropimgIdNotBetween(Long value1, Long value2) {
            return notBetween(propimgId, value1, value2);
        }
        public Criteria andPropimgsIsNull() {
            return isNull(propimgs);
        }

        public Criteria andPropimgsIsNotNull() {
            return isNotNull(propimgs);
        }

        public Criteria andPropimgsEqualTo(String value) {
            return equalTo(propimgs, value);
        }

        public Criteria andPropimgsNotEqualTo(String value) {
            return notEqualTo(propimgs, value);
        }

        public Criteria andPropimgsGreaterThan(String value) {
            return greaterThan(propimgs, value);
        }

        public Criteria andPropimgsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(propimgs, value);
        }

        public Criteria andPropimgsLessThan(String value) {
            return lessThan(propimgs, value);
        }

        public Criteria andPropimgsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(propimgs, value);
        }

        public Criteria andPropimgsLike(String value) {
            return like(propimgs, value);
        }

        public Criteria andPropimgsNotLike(String value) {
            return notLike(propimgs, value);
        }

        public Criteria andPropimgsIn(List<String> values) {
            return in(propimgs, values);
        }

        public Criteria andPropimgsNotIn(List<String> values) {
            return notIn(propimgs, values);
        }

        public Criteria andPropimgsBetween(String value1, String value2) {
            return between(propimgs, value1, value2);
        }

        public Criteria andPropimgsNotBetween(String value1, String value2) {
            return notBetween(propimgs, value1, value2);
        }
    }
}
