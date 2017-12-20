package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ItemTradeForbid;

import java.util.*;
public class ItemTradeForbidExample extends SgExample<ItemTradeForbidExample.Criteria> {
    public static final Class<ItemTradeForbid> beanClass = ItemTradeForbid.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn senderId;
    public static EntityColumn canSale;
    public static EntityColumn targetId;
    public static EntityColumn forbidId;
    public static EntityColumn type;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        senderId = listMap.get("senderId");
        canSale = listMap.get("canSale");
        targetId = listMap.get("targetId");
        forbidId = listMap.get("forbidId");
        type = listMap.get("type");
        }

    public ItemTradeForbidExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ItemTradeForbidExample.Criteria createCriteriaInternal() {
        return new ItemTradeForbidExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ItemTradeForbidExample.Criteria andSenderIdIsNull() {
            return isNull(senderId);
        }

        public ItemTradeForbidExample.Criteria andSenderIdIsNotNull() {
            return isNotNull(senderId);
        }

        public ItemTradeForbidExample.Criteria andSenderIdEqualTo(Long value) {
            return equalTo(senderId, value);
        }

        public ItemTradeForbidExample.Criteria andSenderIdNotEqualTo(Long value) {
            return notEqualTo(senderId, value);
        }

        public ItemTradeForbidExample.Criteria andSenderIdGreaterThan(Long value) {
            return greaterThan(senderId, value);
        }

        public ItemTradeForbidExample.Criteria andSenderIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(senderId, value);
        }

        public ItemTradeForbidExample.Criteria andSenderIdLessThan(Long value) {
            return lessThan(senderId, value);
        }

        public ItemTradeForbidExample.Criteria andSenderIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(senderId, value);
        }

        public ItemTradeForbidExample.Criteria andSenderIdIn(List<Long> values) {
            return in(senderId, values);
        }

        public ItemTradeForbidExample.Criteria andSenderIdNotIn(List<Long> values) {
            return notIn(senderId, values);
        }

        public ItemTradeForbidExample.Criteria andSenderIdBetween(Long value1, Long value2) {
            return between(senderId, value1, value2);
        }

        public ItemTradeForbidExample.Criteria andSenderIdNotBetween(Long value1, Long value2) {
            return notBetween(senderId, value1, value2);
        }
        public ItemTradeForbidExample.Criteria andCanSaleIsNull() {
            return isNull(canSale);
        }

        public ItemTradeForbidExample.Criteria andCanSaleIsNotNull() {
            return isNotNull(canSale);
        }

        public ItemTradeForbidExample.Criteria andCanSaleEqualTo(Integer value) {
            return equalTo(canSale, value);
        }

        public ItemTradeForbidExample.Criteria andCanSaleNotEqualTo(Integer value) {
            return notEqualTo(canSale, value);
        }

        public ItemTradeForbidExample.Criteria andCanSaleGreaterThan(Integer value) {
            return greaterThan(canSale, value);
        }

        public ItemTradeForbidExample.Criteria andCanSaleGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(canSale, value);
        }

        public ItemTradeForbidExample.Criteria andCanSaleLessThan(Integer value) {
            return lessThan(canSale, value);
        }

        public ItemTradeForbidExample.Criteria andCanSaleLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(canSale, value);
        }

        public ItemTradeForbidExample.Criteria andCanSaleIn(List<Integer> values) {
            return in(canSale, values);
        }

        public ItemTradeForbidExample.Criteria andCanSaleNotIn(List<Integer> values) {
            return notIn(canSale, values);
        }

        public ItemTradeForbidExample.Criteria andCanSaleBetween(Integer value1, Integer value2) {
            return between(canSale, value1, value2);
        }

        public ItemTradeForbidExample.Criteria andCanSaleNotBetween(Integer value1, Integer value2) {
            return notBetween(canSale, value1, value2);
        }
        public ItemTradeForbidExample.Criteria andTargetIdIsNull() {
            return isNull(targetId);
        }

        public ItemTradeForbidExample.Criteria andTargetIdIsNotNull() {
            return isNotNull(targetId);
        }

        public ItemTradeForbidExample.Criteria andTargetIdEqualTo(Long value) {
            return equalTo(targetId, value);
        }

        public ItemTradeForbidExample.Criteria andTargetIdNotEqualTo(Long value) {
            return notEqualTo(targetId, value);
        }

        public ItemTradeForbidExample.Criteria andTargetIdGreaterThan(Long value) {
            return greaterThan(targetId, value);
        }

        public ItemTradeForbidExample.Criteria andTargetIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(targetId, value);
        }

        public ItemTradeForbidExample.Criteria andTargetIdLessThan(Long value) {
            return lessThan(targetId, value);
        }

        public ItemTradeForbidExample.Criteria andTargetIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(targetId, value);
        }

        public ItemTradeForbidExample.Criteria andTargetIdIn(List<Long> values) {
            return in(targetId, values);
        }

        public ItemTradeForbidExample.Criteria andTargetIdNotIn(List<Long> values) {
            return notIn(targetId, values);
        }

        public ItemTradeForbidExample.Criteria andTargetIdBetween(Long value1, Long value2) {
            return between(targetId, value1, value2);
        }

        public ItemTradeForbidExample.Criteria andTargetIdNotBetween(Long value1, Long value2) {
            return notBetween(targetId, value1, value2);
        }
        public ItemTradeForbidExample.Criteria andForbidIdIsNull() {
            return isNull(forbidId);
        }

        public ItemTradeForbidExample.Criteria andForbidIdIsNotNull() {
            return isNotNull(forbidId);
        }

        public ItemTradeForbidExample.Criteria andForbidIdEqualTo(Long value) {
            return equalTo(forbidId, value);
        }

        public ItemTradeForbidExample.Criteria andForbidIdNotEqualTo(Long value) {
            return notEqualTo(forbidId, value);
        }

        public ItemTradeForbidExample.Criteria andForbidIdGreaterThan(Long value) {
            return greaterThan(forbidId, value);
        }

        public ItemTradeForbidExample.Criteria andForbidIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(forbidId, value);
        }

        public ItemTradeForbidExample.Criteria andForbidIdLessThan(Long value) {
            return lessThan(forbidId, value);
        }

        public ItemTradeForbidExample.Criteria andForbidIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(forbidId, value);
        }

        public ItemTradeForbidExample.Criteria andForbidIdIn(List<Long> values) {
            return in(forbidId, values);
        }

        public ItemTradeForbidExample.Criteria andForbidIdNotIn(List<Long> values) {
            return notIn(forbidId, values);
        }

        public ItemTradeForbidExample.Criteria andForbidIdBetween(Long value1, Long value2) {
            return between(forbidId, value1, value2);
        }

        public ItemTradeForbidExample.Criteria andForbidIdNotBetween(Long value1, Long value2) {
            return notBetween(forbidId, value1, value2);
        }
        public ItemTradeForbidExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public ItemTradeForbidExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public ItemTradeForbidExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public ItemTradeForbidExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public ItemTradeForbidExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public ItemTradeForbidExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public ItemTradeForbidExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public ItemTradeForbidExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public ItemTradeForbidExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public ItemTradeForbidExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public ItemTradeForbidExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public ItemTradeForbidExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
    }
}