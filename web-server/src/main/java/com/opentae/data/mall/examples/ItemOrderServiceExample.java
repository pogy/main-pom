package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ItemOrderService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class ItemOrderServiceExample extends SgExample<ItemOrderServiceExample.Criteria> {
    public static final Class<ItemOrderService> beanClass = ItemOrderService.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn money;
    public static EntityColumn name;
    public static EntityColumn refundMoney;
    public static EntityColumn id;
    public static EntityColumn oid;
    public static EntityColumn serviceId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        money = listMap.get("money");
        name = listMap.get("name");
        refundMoney = listMap.get("refundMoney");
        id = listMap.get("id");
        oid = listMap.get("oid");
        serviceId = listMap.get("serviceId");
        }

    public ItemOrderServiceExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ItemOrderServiceExample.Criteria createCriteriaInternal() {
        return new ItemOrderServiceExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ItemOrderServiceExample.Criteria andMoneyIsNull() {
            return isNull(money);
        }

        public ItemOrderServiceExample.Criteria andMoneyIsNotNull() {
            return isNotNull(money);
        }

        public ItemOrderServiceExample.Criteria andMoneyEqualTo(Long value) {
            return equalTo(money, value);
        }

        public ItemOrderServiceExample.Criteria andMoneyNotEqualTo(Long value) {
            return notEqualTo(money, value);
        }

        public ItemOrderServiceExample.Criteria andMoneyGreaterThan(Long value) {
            return greaterThan(money, value);
        }

        public ItemOrderServiceExample.Criteria andMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(money, value);
        }

        public ItemOrderServiceExample.Criteria andMoneyLessThan(Long value) {
            return lessThan(money, value);
        }

        public ItemOrderServiceExample.Criteria andMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(money, value);
        }

        public ItemOrderServiceExample.Criteria andMoneyIn(List<Long> values) {
            return in(money, values);
        }

        public ItemOrderServiceExample.Criteria andMoneyNotIn(List<Long> values) {
            return notIn(money, values);
        }

        public ItemOrderServiceExample.Criteria andMoneyBetween(Long value1, Long value2) {
            return between(money, value1, value2);
        }

        public ItemOrderServiceExample.Criteria andMoneyNotBetween(Long value1, Long value2) {
            return notBetween(money, value1, value2);
        }
        public ItemOrderServiceExample.Criteria andNameIsNull() {
            return isNull(name);
        }

        public ItemOrderServiceExample.Criteria andNameIsNotNull() {
            return isNotNull(name);
        }

        public ItemOrderServiceExample.Criteria andNameEqualTo(String value) {
            return equalTo(name, value);
        }

        public ItemOrderServiceExample.Criteria andNameNotEqualTo(String value) {
            return notEqualTo(name, value);
        }

        public ItemOrderServiceExample.Criteria andNameGreaterThan(String value) {
            return greaterThan(name, value);
        }

        public ItemOrderServiceExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(name, value);
        }

        public ItemOrderServiceExample.Criteria andNameLessThan(String value) {
            return lessThan(name, value);
        }

        public ItemOrderServiceExample.Criteria andNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(name, value);
        }

        public ItemOrderServiceExample.Criteria andNameLike(String value) {
            return like(name, value);
        }

        public ItemOrderServiceExample.Criteria andNameNotLike(String value) {
            return notLike(name, value);
        }

        public ItemOrderServiceExample.Criteria andNameIn(List<String> values) {
            return in(name, values);
        }

        public ItemOrderServiceExample.Criteria andNameNotIn(List<String> values) {
            return notIn(name, values);
        }

        public ItemOrderServiceExample.Criteria andNameBetween(String value1, String value2) {
            return between(name, value1, value2);
        }

        public ItemOrderServiceExample.Criteria andNameNotBetween(String value1, String value2) {
            return notBetween(name, value1, value2);
        }
        public ItemOrderServiceExample.Criteria andRefundMoneyIsNull() {
            return isNull(refundMoney);
        }

        public ItemOrderServiceExample.Criteria andRefundMoneyIsNotNull() {
            return isNotNull(refundMoney);
        }

        public ItemOrderServiceExample.Criteria andRefundMoneyEqualTo(Long value) {
            return equalTo(refundMoney, value);
        }

        public ItemOrderServiceExample.Criteria andRefundMoneyNotEqualTo(Long value) {
            return notEqualTo(refundMoney, value);
        }

        public ItemOrderServiceExample.Criteria andRefundMoneyGreaterThan(Long value) {
            return greaterThan(refundMoney, value);
        }

        public ItemOrderServiceExample.Criteria andRefundMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(refundMoney, value);
        }

        public ItemOrderServiceExample.Criteria andRefundMoneyLessThan(Long value) {
            return lessThan(refundMoney, value);
        }

        public ItemOrderServiceExample.Criteria andRefundMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(refundMoney, value);
        }

        public ItemOrderServiceExample.Criteria andRefundMoneyIn(List<Long> values) {
            return in(refundMoney, values);
        }

        public ItemOrderServiceExample.Criteria andRefundMoneyNotIn(List<Long> values) {
            return notIn(refundMoney, values);
        }

        public ItemOrderServiceExample.Criteria andRefundMoneyBetween(Long value1, Long value2) {
            return between(refundMoney, value1, value2);
        }

        public ItemOrderServiceExample.Criteria andRefundMoneyNotBetween(Long value1, Long value2) {
            return notBetween(refundMoney, value1, value2);
        }
        public ItemOrderServiceExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ItemOrderServiceExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ItemOrderServiceExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public ItemOrderServiceExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public ItemOrderServiceExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public ItemOrderServiceExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ItemOrderServiceExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public ItemOrderServiceExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public ItemOrderServiceExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public ItemOrderServiceExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public ItemOrderServiceExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public ItemOrderServiceExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public ItemOrderServiceExample.Criteria andOidIsNull() {
            return isNull(oid);
        }

        public ItemOrderServiceExample.Criteria andOidIsNotNull() {
            return isNotNull(oid);
        }

        public ItemOrderServiceExample.Criteria andOidEqualTo(Long value) {
            return equalTo(oid, value);
        }

        public ItemOrderServiceExample.Criteria andOidNotEqualTo(Long value) {
            return notEqualTo(oid, value);
        }

        public ItemOrderServiceExample.Criteria andOidGreaterThan(Long value) {
            return greaterThan(oid, value);
        }

        public ItemOrderServiceExample.Criteria andOidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(oid, value);
        }

        public ItemOrderServiceExample.Criteria andOidLessThan(Long value) {
            return lessThan(oid, value);
        }

        public ItemOrderServiceExample.Criteria andOidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(oid, value);
        }

        public ItemOrderServiceExample.Criteria andOidIn(List<Long> values) {
            return in(oid, values);
        }

        public ItemOrderServiceExample.Criteria andOidNotIn(List<Long> values) {
            return notIn(oid, values);
        }

        public ItemOrderServiceExample.Criteria andOidBetween(Long value1, Long value2) {
            return between(oid, value1, value2);
        }

        public ItemOrderServiceExample.Criteria andOidNotBetween(Long value1, Long value2) {
            return notBetween(oid, value1, value2);
        }
        public ItemOrderServiceExample.Criteria andServiceIdIsNull() {
            return isNull(serviceId);
        }

        public ItemOrderServiceExample.Criteria andServiceIdIsNotNull() {
            return isNotNull(serviceId);
        }

        public ItemOrderServiceExample.Criteria andServiceIdEqualTo(Long value) {
            return equalTo(serviceId, value);
        }

        public ItemOrderServiceExample.Criteria andServiceIdNotEqualTo(Long value) {
            return notEqualTo(serviceId, value);
        }

        public ItemOrderServiceExample.Criteria andServiceIdGreaterThan(Long value) {
            return greaterThan(serviceId, value);
        }

        public ItemOrderServiceExample.Criteria andServiceIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(serviceId, value);
        }

        public ItemOrderServiceExample.Criteria andServiceIdLessThan(Long value) {
            return lessThan(serviceId, value);
        }

        public ItemOrderServiceExample.Criteria andServiceIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(serviceId, value);
        }

        public ItemOrderServiceExample.Criteria andServiceIdIn(List<Long> values) {
            return in(serviceId, values);
        }

        public ItemOrderServiceExample.Criteria andServiceIdNotIn(List<Long> values) {
            return notIn(serviceId, values);
        }

        public ItemOrderServiceExample.Criteria andServiceIdBetween(Long value1, Long value2) {
            return between(serviceId, value1, value2);
        }

        public ItemOrderServiceExample.Criteria andServiceIdNotBetween(Long value1, Long value2) {
            return notBetween(serviceId, value1, value2);
        }
    }
}
