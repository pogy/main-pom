package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguGoodsUnlicense;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class ShiguGoodsUnlicenseExample extends SgExample<ShiguGoodsUnlicenseExample.Criteria> {
    public static final Class<ShiguGoodsUnlicense> beanClass = ShiguGoodsUnlicense.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn goodsId;
    public static EntityColumn unlicenseContext;
    public static EntityColumn unlicenseId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        goodsId = listMap.get("goodsId");
        unlicenseContext = listMap.get("unlicenseContext");
        unlicenseId = listMap.get("unlicenseId");
        }

    public ShiguGoodsUnlicenseExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguGoodsUnlicenseExample.Criteria createCriteriaInternal() {
        return new ShiguGoodsUnlicenseExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public ShiguGoodsUnlicenseExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextIsNull() {
            return isNull(unlicenseContext);
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextIsNotNull() {
            return isNotNull(unlicenseContext);
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextEqualTo(String value) {
            return equalTo(unlicenseContext, value);
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextNotEqualTo(String value) {
            return notEqualTo(unlicenseContext, value);
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextGreaterThan(String value) {
            return greaterThan(unlicenseContext, value);
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(unlicenseContext, value);
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextLessThan(String value) {
            return lessThan(unlicenseContext, value);
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(unlicenseContext, value);
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextLike(String value) {
            return like(unlicenseContext, value);
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextNotLike(String value) {
            return notLike(unlicenseContext, value);
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextIn(List<String> values) {
            return in(unlicenseContext, values);
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextNotIn(List<String> values) {
            return notIn(unlicenseContext, values);
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextBetween(String value1, String value2) {
            return between(unlicenseContext, value1, value2);
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseContextNotBetween(String value1, String value2) {
            return notBetween(unlicenseContext, value1, value2);
        }
        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdIsNull() {
            return isNull(unlicenseId);
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdIsNotNull() {
            return isNotNull(unlicenseId);
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdEqualTo(Long value) {
            return equalTo(unlicenseId, value);
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdNotEqualTo(Long value) {
            return notEqualTo(unlicenseId, value);
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdGreaterThan(Long value) {
            return greaterThan(unlicenseId, value);
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(unlicenseId, value);
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdLessThan(Long value) {
            return lessThan(unlicenseId, value);
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(unlicenseId, value);
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdIn(List<Long> values) {
            return in(unlicenseId, values);
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdNotIn(List<Long> values) {
            return notIn(unlicenseId, values);
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdBetween(Long value1, Long value2) {
            return between(unlicenseId, value1, value2);
        }

        public ShiguGoodsUnlicenseExample.Criteria andUnlicenseIdNotBetween(Long value1, Long value2) {
            return notBetween(unlicenseId, value1, value2);
        }
    }
}
