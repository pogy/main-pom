package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShopFitmentFtl;

import java.util.*;
public class ShopFitmentFtlExample extends SgExample<ShopFitmentFtlExample.Criteria> {
    public static final Class<ShopFitmentFtl> beanClass = ShopFitmentFtl.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn context;
    public static EntityColumn ftlId;
    public static EntityColumn shopId;
    public static EntityColumn pageId;
    public static EntityColumn type;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        context = listMap.get("context");
        ftlId = listMap.get("ftlId");
        shopId = listMap.get("shopId");
        pageId = listMap.get("pageId");
        type = listMap.get("type");
        }

    public ShopFitmentFtlExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShopFitmentFtlExample.Criteria createCriteriaInternal() {
        return new ShopFitmentFtlExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShopFitmentFtlExample.Criteria andContextIsNull() {
            return isNull(context);
        }

        public ShopFitmentFtlExample.Criteria andContextIsNotNull() {
            return isNotNull(context);
        }

        public ShopFitmentFtlExample.Criteria andContextEqualTo(String value) {
            return equalTo(context, value);
        }

        public ShopFitmentFtlExample.Criteria andContextNotEqualTo(String value) {
            return notEqualTo(context, value);
        }

        public ShopFitmentFtlExample.Criteria andContextGreaterThan(String value) {
            return greaterThan(context, value);
        }

        public ShopFitmentFtlExample.Criteria andContextGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(context, value);
        }

        public ShopFitmentFtlExample.Criteria andContextLessThan(String value) {
            return lessThan(context, value);
        }

        public ShopFitmentFtlExample.Criteria andContextLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(context, value);
        }

        public ShopFitmentFtlExample.Criteria andContextLike(String value) {
            return like(context, value);
        }

        public ShopFitmentFtlExample.Criteria andContextNotLike(String value) {
            return notLike(context, value);
        }

        public ShopFitmentFtlExample.Criteria andContextIn(List<String> values) {
            return in(context, values);
        }

        public ShopFitmentFtlExample.Criteria andContextNotIn(List<String> values) {
            return notIn(context, values);
        }

        public ShopFitmentFtlExample.Criteria andContextBetween(String value1, String value2) {
            return between(context, value1, value2);
        }

        public ShopFitmentFtlExample.Criteria andContextNotBetween(String value1, String value2) {
            return notBetween(context, value1, value2);
        }
        public ShopFitmentFtlExample.Criteria andFtlIdIsNull() {
            return isNull(ftlId);
        }

        public ShopFitmentFtlExample.Criteria andFtlIdIsNotNull() {
            return isNotNull(ftlId);
        }

        public ShopFitmentFtlExample.Criteria andFtlIdEqualTo(Long value) {
            return equalTo(ftlId, value);
        }

        public ShopFitmentFtlExample.Criteria andFtlIdNotEqualTo(Long value) {
            return notEqualTo(ftlId, value);
        }

        public ShopFitmentFtlExample.Criteria andFtlIdGreaterThan(Long value) {
            return greaterThan(ftlId, value);
        }

        public ShopFitmentFtlExample.Criteria andFtlIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(ftlId, value);
        }

        public ShopFitmentFtlExample.Criteria andFtlIdLessThan(Long value) {
            return lessThan(ftlId, value);
        }

        public ShopFitmentFtlExample.Criteria andFtlIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(ftlId, value);
        }

        public ShopFitmentFtlExample.Criteria andFtlIdIn(List<Long> values) {
            return in(ftlId, values);
        }

        public ShopFitmentFtlExample.Criteria andFtlIdNotIn(List<Long> values) {
            return notIn(ftlId, values);
        }

        public ShopFitmentFtlExample.Criteria andFtlIdBetween(Long value1, Long value2) {
            return between(ftlId, value1, value2);
        }

        public ShopFitmentFtlExample.Criteria andFtlIdNotBetween(Long value1, Long value2) {
            return notBetween(ftlId, value1, value2);
        }
        public ShopFitmentFtlExample.Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public ShopFitmentFtlExample.Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public ShopFitmentFtlExample.Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public ShopFitmentFtlExample.Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public ShopFitmentFtlExample.Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public ShopFitmentFtlExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public ShopFitmentFtlExample.Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public ShopFitmentFtlExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public ShopFitmentFtlExample.Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public ShopFitmentFtlExample.Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public ShopFitmentFtlExample.Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public ShopFitmentFtlExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
        }
        public ShopFitmentFtlExample.Criteria andPageIdIsNull() {
            return isNull(pageId);
        }

        public ShopFitmentFtlExample.Criteria andPageIdIsNotNull() {
            return isNotNull(pageId);
        }

        public ShopFitmentFtlExample.Criteria andPageIdEqualTo(Long value) {
            return equalTo(pageId, value);
        }

        public ShopFitmentFtlExample.Criteria andPageIdNotEqualTo(Long value) {
            return notEqualTo(pageId, value);
        }

        public ShopFitmentFtlExample.Criteria andPageIdGreaterThan(Long value) {
            return greaterThan(pageId, value);
        }

        public ShopFitmentFtlExample.Criteria andPageIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(pageId, value);
        }

        public ShopFitmentFtlExample.Criteria andPageIdLessThan(Long value) {
            return lessThan(pageId, value);
        }

        public ShopFitmentFtlExample.Criteria andPageIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(pageId, value);
        }

        public ShopFitmentFtlExample.Criteria andPageIdIn(List<Long> values) {
            return in(pageId, values);
        }

        public ShopFitmentFtlExample.Criteria andPageIdNotIn(List<Long> values) {
            return notIn(pageId, values);
        }

        public ShopFitmentFtlExample.Criteria andPageIdBetween(Long value1, Long value2) {
            return between(pageId, value1, value2);
        }

        public ShopFitmentFtlExample.Criteria andPageIdNotBetween(Long value1, Long value2) {
            return notBetween(pageId, value1, value2);
        }
        public ShopFitmentFtlExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public ShopFitmentFtlExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public ShopFitmentFtlExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public ShopFitmentFtlExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public ShopFitmentFtlExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public ShopFitmentFtlExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public ShopFitmentFtlExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public ShopFitmentFtlExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public ShopFitmentFtlExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public ShopFitmentFtlExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public ShopFitmentFtlExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public ShopFitmentFtlExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
    }
}
