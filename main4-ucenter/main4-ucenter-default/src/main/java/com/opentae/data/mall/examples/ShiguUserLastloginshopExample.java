package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguUserLastloginshop;

import java.util.*;
public class ShiguUserLastloginshopExample extends SgExample<ShiguUserLastloginshopExample.Criteria> {
    public static final Class<ShiguUserLastloginshop> beanClass = ShiguUserLastloginshop.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn shopId;
    public static EntityColumn userId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        shopId = listMap.get("shopId");
        userId = listMap.get("userId");
        }

    public ShiguUserLastloginshopExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguUserLastloginshopExample.Criteria createCriteriaInternal() {
        return new ShiguUserLastloginshopExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public ShiguUserLastloginshopExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
        }
        public ShiguUserLastloginshopExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public ShiguUserLastloginshopExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public ShiguUserLastloginshopExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public ShiguUserLastloginshopExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public ShiguUserLastloginshopExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public ShiguUserLastloginshopExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public ShiguUserLastloginshopExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public ShiguUserLastloginshopExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public ShiguUserLastloginshopExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public ShiguUserLastloginshopExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public ShiguUserLastloginshopExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public ShiguUserLastloginshopExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
    }
}
