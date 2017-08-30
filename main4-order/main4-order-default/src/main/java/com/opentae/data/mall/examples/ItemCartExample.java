package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ItemCart;

import java.util.*;
public class ItemCartExample extends SgExample<ItemCartExample.Criteria> {
    public static final Class<ItemCart> beanClass = ItemCart.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn webSite;
    public static EntityColumn lastModify;
    public static EntityColumn cartId;
    public static EntityColumn num;
    public static EntityColumn pid;
    public static EntityColumn shopId;
    public static EntityColumn userId;
    public static EntityColumn skuId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        webSite = listMap.get("webSite");
        lastModify = listMap.get("lastModify");
        cartId = listMap.get("cartId");
        num = listMap.get("num");
        pid = listMap.get("pid");
        shopId = listMap.get("shopId");
        userId = listMap.get("userId");
        skuId = listMap.get("skuId");
        }

    public ItemCartExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ItemCartExample.Criteria createCriteriaInternal() {
        return new ItemCartExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ItemCartExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public ItemCartExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public ItemCartExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public ItemCartExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public ItemCartExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public ItemCartExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public ItemCartExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public ItemCartExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public ItemCartExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public ItemCartExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public ItemCartExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public ItemCartExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public ItemCartExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public ItemCartExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public ItemCartExample.Criteria andLastModifyIsNull() {
            return isNull(lastModify);
        }

        public ItemCartExample.Criteria andLastModifyIsNotNull() {
            return isNotNull(lastModify);
        }

        public ItemCartExample.Criteria andLastModifyEqualTo(Date value) {
            return equalTo(lastModify, value);
        }

        public ItemCartExample.Criteria andLastModifyNotEqualTo(Date value) {
            return notEqualTo(lastModify, value);
        }

        public ItemCartExample.Criteria andLastModifyGreaterThan(Date value) {
            return greaterThan(lastModify, value);
        }

        public ItemCartExample.Criteria andLastModifyGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastModify, value);
        }

        public ItemCartExample.Criteria andLastModifyLessThan(Date value) {
            return lessThan(lastModify, value);
        }

        public ItemCartExample.Criteria andLastModifyLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastModify, value);
        }

        public ItemCartExample.Criteria andLastModifyIn(List<Date> values) {
            return in(lastModify, values);
        }

        public ItemCartExample.Criteria andLastModifyNotIn(List<Date> values) {
            return notIn(lastModify, values);
        }

        public ItemCartExample.Criteria andLastModifyBetween(Date value1, Date value2) {
            return between(lastModify, value1, value2);
        }

        public ItemCartExample.Criteria andLastModifyNotBetween(Date value1, Date value2) {
            return notBetween(lastModify, value1, value2);
        }
        public ItemCartExample.Criteria andCartIdIsNull() {
            return isNull(cartId);
        }

        public ItemCartExample.Criteria andCartIdIsNotNull() {
            return isNotNull(cartId);
        }

        public ItemCartExample.Criteria andCartIdEqualTo(Long value) {
            return equalTo(cartId, value);
        }

        public ItemCartExample.Criteria andCartIdNotEqualTo(Long value) {
            return notEqualTo(cartId, value);
        }

        public ItemCartExample.Criteria andCartIdGreaterThan(Long value) {
            return greaterThan(cartId, value);
        }

        public ItemCartExample.Criteria andCartIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cartId, value);
        }

        public ItemCartExample.Criteria andCartIdLessThan(Long value) {
            return lessThan(cartId, value);
        }

        public ItemCartExample.Criteria andCartIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cartId, value);
        }

        public ItemCartExample.Criteria andCartIdIn(List<Long> values) {
            return in(cartId, values);
        }

        public ItemCartExample.Criteria andCartIdNotIn(List<Long> values) {
            return notIn(cartId, values);
        }

        public ItemCartExample.Criteria andCartIdBetween(Long value1, Long value2) {
            return between(cartId, value1, value2);
        }

        public ItemCartExample.Criteria andCartIdNotBetween(Long value1, Long value2) {
            return notBetween(cartId, value1, value2);
        }
        public ItemCartExample.Criteria andNumIsNull() {
            return isNull(num);
        }

        public ItemCartExample.Criteria andNumIsNotNull() {
            return isNotNull(num);
        }

        public ItemCartExample.Criteria andNumEqualTo(Integer value) {
            return equalTo(num, value);
        }

        public ItemCartExample.Criteria andNumNotEqualTo(Integer value) {
            return notEqualTo(num, value);
        }

        public ItemCartExample.Criteria andNumGreaterThan(Integer value) {
            return greaterThan(num, value);
        }

        public ItemCartExample.Criteria andNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(num, value);
        }

        public ItemCartExample.Criteria andNumLessThan(Integer value) {
            return lessThan(num, value);
        }

        public ItemCartExample.Criteria andNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(num, value);
        }

        public ItemCartExample.Criteria andNumIn(List<Integer> values) {
            return in(num, values);
        }

        public ItemCartExample.Criteria andNumNotIn(List<Integer> values) {
            return notIn(num, values);
        }

        public ItemCartExample.Criteria andNumBetween(Integer value1, Integer value2) {
            return between(num, value1, value2);
        }

        public ItemCartExample.Criteria andNumNotBetween(Integer value1, Integer value2) {
            return notBetween(num, value1, value2);
        }
        public ItemCartExample.Criteria andPidIsNull() {
            return isNull(pid);
        }

        public ItemCartExample.Criteria andPidIsNotNull() {
            return isNotNull(pid);
        }

        public ItemCartExample.Criteria andPidEqualTo(Long value) {
            return equalTo(pid, value);
        }

        public ItemCartExample.Criteria andPidNotEqualTo(Long value) {
            return notEqualTo(pid, value);
        }

        public ItemCartExample.Criteria andPidGreaterThan(Long value) {
            return greaterThan(pid, value);
        }

        public ItemCartExample.Criteria andPidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(pid, value);
        }

        public ItemCartExample.Criteria andPidLessThan(Long value) {
            return lessThan(pid, value);
        }

        public ItemCartExample.Criteria andPidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(pid, value);
        }

        public ItemCartExample.Criteria andPidIn(List<Long> values) {
            return in(pid, values);
        }

        public ItemCartExample.Criteria andPidNotIn(List<Long> values) {
            return notIn(pid, values);
        }

        public ItemCartExample.Criteria andPidBetween(Long value1, Long value2) {
            return between(pid, value1, value2);
        }

        public ItemCartExample.Criteria andPidNotBetween(Long value1, Long value2) {
            return notBetween(pid, value1, value2);
        }
        public ItemCartExample.Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public ItemCartExample.Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public ItemCartExample.Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public ItemCartExample.Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public ItemCartExample.Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public ItemCartExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public ItemCartExample.Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public ItemCartExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public ItemCartExample.Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public ItemCartExample.Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public ItemCartExample.Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public ItemCartExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
        }
        public ItemCartExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public ItemCartExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public ItemCartExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public ItemCartExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public ItemCartExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public ItemCartExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public ItemCartExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public ItemCartExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public ItemCartExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public ItemCartExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public ItemCartExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public ItemCartExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public ItemCartExample.Criteria andSkuIdIsNull() {
            return isNull(skuId);
        }

        public ItemCartExample.Criteria andSkuIdIsNotNull() {
            return isNotNull(skuId);
        }

        public ItemCartExample.Criteria andSkuIdEqualTo(Long value) {
            return equalTo(skuId, value);
        }

        public ItemCartExample.Criteria andSkuIdNotEqualTo(Long value) {
            return notEqualTo(skuId, value);
        }

        public ItemCartExample.Criteria andSkuIdGreaterThan(Long value) {
            return greaterThan(skuId, value);
        }

        public ItemCartExample.Criteria andSkuIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(skuId, value);
        }

        public ItemCartExample.Criteria andSkuIdLessThan(Long value) {
            return lessThan(skuId, value);
        }

        public ItemCartExample.Criteria andSkuIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(skuId, value);
        }

        public ItemCartExample.Criteria andSkuIdIn(List<Long> values) {
            return in(skuId, values);
        }

        public ItemCartExample.Criteria andSkuIdNotIn(List<Long> values) {
            return notIn(skuId, values);
        }

        public ItemCartExample.Criteria andSkuIdBetween(Long value1, Long value2) {
            return between(skuId, value1, value2);
        }

        public ItemCartExample.Criteria andSkuIdNotBetween(Long value1, Long value2) {
            return notBetween(skuId, value1, value2);
        }
    }
}