package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ItemOrderPackage;

import java.util.*;
public class ItemOrderPackageExample extends SgExample<ItemOrderPackageExample.Criteria> {
    public static final Class<ItemOrderPackage> beanClass = ItemOrderPackage.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn money;
    public static EntityColumn metarialId;
    public static EntityColumn num;
    public static EntityColumn name;
    public static EntityColumn refundMoney;
    public static EntityColumn id;
    public static EntityColumn oid;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        money = listMap.get("money");
        metarialId = listMap.get("metarialId");
        num = listMap.get("num");
        name = listMap.get("name");
        refundMoney = listMap.get("refundMoney");
        id = listMap.get("id");
        oid = listMap.get("oid");
        }

    public ItemOrderPackageExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ItemOrderPackageExample.Criteria createCriteriaInternal() {
        return new ItemOrderPackageExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ItemOrderPackageExample.Criteria andMoneyIsNull() {
            return isNull(money);
        }

        public ItemOrderPackageExample.Criteria andMoneyIsNotNull() {
            return isNotNull(money);
        }

        public ItemOrderPackageExample.Criteria andMoneyEqualTo(Long value) {
            return equalTo(money, value);
        }

        public ItemOrderPackageExample.Criteria andMoneyNotEqualTo(Long value) {
            return notEqualTo(money, value);
        }

        public ItemOrderPackageExample.Criteria andMoneyGreaterThan(Long value) {
            return greaterThan(money, value);
        }

        public ItemOrderPackageExample.Criteria andMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(money, value);
        }

        public ItemOrderPackageExample.Criteria andMoneyLessThan(Long value) {
            return lessThan(money, value);
        }

        public ItemOrderPackageExample.Criteria andMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(money, value);
        }

        public ItemOrderPackageExample.Criteria andMoneyIn(List<Long> values) {
            return in(money, values);
        }

        public ItemOrderPackageExample.Criteria andMoneyNotIn(List<Long> values) {
            return notIn(money, values);
        }

        public ItemOrderPackageExample.Criteria andMoneyBetween(Long value1, Long value2) {
            return between(money, value1, value2);
        }

        public ItemOrderPackageExample.Criteria andMoneyNotBetween(Long value1, Long value2) {
            return notBetween(money, value1, value2);
        }
        public ItemOrderPackageExample.Criteria andMetarialIdIsNull() {
            return isNull(metarialId);
        }

        public ItemOrderPackageExample.Criteria andMetarialIdIsNotNull() {
            return isNotNull(metarialId);
        }

        public ItemOrderPackageExample.Criteria andMetarialIdEqualTo(Long value) {
            return equalTo(metarialId, value);
        }

        public ItemOrderPackageExample.Criteria andMetarialIdNotEqualTo(Long value) {
            return notEqualTo(metarialId, value);
        }

        public ItemOrderPackageExample.Criteria andMetarialIdGreaterThan(Long value) {
            return greaterThan(metarialId, value);
        }

        public ItemOrderPackageExample.Criteria andMetarialIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(metarialId, value);
        }

        public ItemOrderPackageExample.Criteria andMetarialIdLessThan(Long value) {
            return lessThan(metarialId, value);
        }

        public ItemOrderPackageExample.Criteria andMetarialIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(metarialId, value);
        }

        public ItemOrderPackageExample.Criteria andMetarialIdIn(List<Long> values) {
            return in(metarialId, values);
        }

        public ItemOrderPackageExample.Criteria andMetarialIdNotIn(List<Long> values) {
            return notIn(metarialId, values);
        }

        public ItemOrderPackageExample.Criteria andMetarialIdBetween(Long value1, Long value2) {
            return between(metarialId, value1, value2);
        }

        public ItemOrderPackageExample.Criteria andMetarialIdNotBetween(Long value1, Long value2) {
            return notBetween(metarialId, value1, value2);
        }
        public ItemOrderPackageExample.Criteria andNumIsNull() {
            return isNull(num);
        }

        public ItemOrderPackageExample.Criteria andNumIsNotNull() {
            return isNotNull(num);
        }

        public ItemOrderPackageExample.Criteria andNumEqualTo(Integer value) {
            return equalTo(num, value);
        }

        public ItemOrderPackageExample.Criteria andNumNotEqualTo(Integer value) {
            return notEqualTo(num, value);
        }

        public ItemOrderPackageExample.Criteria andNumGreaterThan(Integer value) {
            return greaterThan(num, value);
        }

        public ItemOrderPackageExample.Criteria andNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(num, value);
        }

        public ItemOrderPackageExample.Criteria andNumLessThan(Integer value) {
            return lessThan(num, value);
        }

        public ItemOrderPackageExample.Criteria andNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(num, value);
        }

        public ItemOrderPackageExample.Criteria andNumIn(List<Integer> values) {
            return in(num, values);
        }

        public ItemOrderPackageExample.Criteria andNumNotIn(List<Integer> values) {
            return notIn(num, values);
        }

        public ItemOrderPackageExample.Criteria andNumBetween(Integer value1, Integer value2) {
            return between(num, value1, value2);
        }

        public ItemOrderPackageExample.Criteria andNumNotBetween(Integer value1, Integer value2) {
            return notBetween(num, value1, value2);
        }
        public ItemOrderPackageExample.Criteria andNameIsNull() {
            return isNull(name);
        }

        public ItemOrderPackageExample.Criteria andNameIsNotNull() {
            return isNotNull(name);
        }

        public ItemOrderPackageExample.Criteria andNameEqualTo(String value) {
            return equalTo(name, value);
        }

        public ItemOrderPackageExample.Criteria andNameNotEqualTo(String value) {
            return notEqualTo(name, value);
        }

        public ItemOrderPackageExample.Criteria andNameGreaterThan(String value) {
            return greaterThan(name, value);
        }

        public ItemOrderPackageExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(name, value);
        }

        public ItemOrderPackageExample.Criteria andNameLessThan(String value) {
            return lessThan(name, value);
        }

        public ItemOrderPackageExample.Criteria andNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(name, value);
        }

        public ItemOrderPackageExample.Criteria andNameLike(String value) {
            return like(name, value);
        }

        public ItemOrderPackageExample.Criteria andNameNotLike(String value) {
            return notLike(name, value);
        }

        public ItemOrderPackageExample.Criteria andNameIn(List<String> values) {
            return in(name, values);
        }

        public ItemOrderPackageExample.Criteria andNameNotIn(List<String> values) {
            return notIn(name, values);
        }

        public ItemOrderPackageExample.Criteria andNameBetween(String value1, String value2) {
            return between(name, value1, value2);
        }

        public ItemOrderPackageExample.Criteria andNameNotBetween(String value1, String value2) {
            return notBetween(name, value1, value2);
        }
        public ItemOrderPackageExample.Criteria andRefundMoneyIsNull() {
            return isNull(refundMoney);
        }

        public ItemOrderPackageExample.Criteria andRefundMoneyIsNotNull() {
            return isNotNull(refundMoney);
        }

        public ItemOrderPackageExample.Criteria andRefundMoneyEqualTo(Long value) {
            return equalTo(refundMoney, value);
        }

        public ItemOrderPackageExample.Criteria andRefundMoneyNotEqualTo(Long value) {
            return notEqualTo(refundMoney, value);
        }

        public ItemOrderPackageExample.Criteria andRefundMoneyGreaterThan(Long value) {
            return greaterThan(refundMoney, value);
        }

        public ItemOrderPackageExample.Criteria andRefundMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(refundMoney, value);
        }

        public ItemOrderPackageExample.Criteria andRefundMoneyLessThan(Long value) {
            return lessThan(refundMoney, value);
        }

        public ItemOrderPackageExample.Criteria andRefundMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(refundMoney, value);
        }

        public ItemOrderPackageExample.Criteria andRefundMoneyIn(List<Long> values) {
            return in(refundMoney, values);
        }

        public ItemOrderPackageExample.Criteria andRefundMoneyNotIn(List<Long> values) {
            return notIn(refundMoney, values);
        }

        public ItemOrderPackageExample.Criteria andRefundMoneyBetween(Long value1, Long value2) {
            return between(refundMoney, value1, value2);
        }

        public ItemOrderPackageExample.Criteria andRefundMoneyNotBetween(Long value1, Long value2) {
            return notBetween(refundMoney, value1, value2);
        }
        public ItemOrderPackageExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ItemOrderPackageExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ItemOrderPackageExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public ItemOrderPackageExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public ItemOrderPackageExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public ItemOrderPackageExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ItemOrderPackageExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public ItemOrderPackageExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public ItemOrderPackageExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public ItemOrderPackageExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public ItemOrderPackageExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public ItemOrderPackageExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public ItemOrderPackageExample.Criteria andOidIsNull() {
            return isNull(oid);
        }

        public ItemOrderPackageExample.Criteria andOidIsNotNull() {
            return isNotNull(oid);
        }

        public ItemOrderPackageExample.Criteria andOidEqualTo(Long value) {
            return equalTo(oid, value);
        }

        public ItemOrderPackageExample.Criteria andOidNotEqualTo(Long value) {
            return notEqualTo(oid, value);
        }

        public ItemOrderPackageExample.Criteria andOidGreaterThan(Long value) {
            return greaterThan(oid, value);
        }

        public ItemOrderPackageExample.Criteria andOidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(oid, value);
        }

        public ItemOrderPackageExample.Criteria andOidLessThan(Long value) {
            return lessThan(oid, value);
        }

        public ItemOrderPackageExample.Criteria andOidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(oid, value);
        }

        public ItemOrderPackageExample.Criteria andOidIn(List<Long> values) {
            return in(oid, values);
        }

        public ItemOrderPackageExample.Criteria andOidNotIn(List<Long> values) {
            return notIn(oid, values);
        }

        public ItemOrderPackageExample.Criteria andOidBetween(Long value1, Long value2) {
            return between(oid, value1, value2);
        }

        public ItemOrderPackageExample.Criteria andOidNotBetween(Long value1, Long value2) {
            return notBetween(oid, value1, value2);
        }
    }
}
