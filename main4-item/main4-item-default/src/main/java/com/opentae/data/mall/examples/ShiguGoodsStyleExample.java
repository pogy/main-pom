package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguGoodsStyle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class ShiguGoodsStyleExample extends SgExample<ShiguGoodsStyleExample.Criteria> {
    public static final Class<ShiguGoodsStyle> beanClass = ShiguGoodsStyle.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn sids;
    public static EntityColumn goodsId;
    public static EntityColumn gsId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        sids = listMap.get("sids");
        goodsId = listMap.get("goodsId");
        gsId = listMap.get("gsId");
        }

    public ShiguGoodsStyleExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguGoodsStyleExample.Criteria createCriteriaInternal() {
        return new ShiguGoodsStyleExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguGoodsStyleExample.Criteria andSidsIsNull() {
            return isNull(sids);
        }

        public ShiguGoodsStyleExample.Criteria andSidsIsNotNull() {
            return isNotNull(sids);
        }

        public ShiguGoodsStyleExample.Criteria andSidsEqualTo(String value) {
            return equalTo(sids, value);
        }

        public ShiguGoodsStyleExample.Criteria andSidsNotEqualTo(String value) {
            return notEqualTo(sids, value);
        }

        public ShiguGoodsStyleExample.Criteria andSidsGreaterThan(String value) {
            return greaterThan(sids, value);
        }

        public ShiguGoodsStyleExample.Criteria andSidsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sids, value);
        }

        public ShiguGoodsStyleExample.Criteria andSidsLessThan(String value) {
            return lessThan(sids, value);
        }

        public ShiguGoodsStyleExample.Criteria andSidsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sids, value);
        }

        public ShiguGoodsStyleExample.Criteria andSidsLike(String value) {
            return like(sids, value);
        }

        public ShiguGoodsStyleExample.Criteria andSidsNotLike(String value) {
            return notLike(sids, value);
        }

        public ShiguGoodsStyleExample.Criteria andSidsIn(List<String> values) {
            return in(sids, values);
        }

        public ShiguGoodsStyleExample.Criteria andSidsNotIn(List<String> values) {
            return notIn(sids, values);
        }

        public ShiguGoodsStyleExample.Criteria andSidsBetween(String value1, String value2) {
            return between(sids, value1, value2);
        }

        public ShiguGoodsStyleExample.Criteria andSidsNotBetween(String value1, String value2) {
            return notBetween(sids, value1, value2);
        }
        public ShiguGoodsStyleExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public ShiguGoodsStyleExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public ShiguGoodsStyleExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public ShiguGoodsStyleExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public ShiguGoodsStyleExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public ShiguGoodsStyleExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public ShiguGoodsStyleExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public ShiguGoodsStyleExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public ShiguGoodsStyleExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public ShiguGoodsStyleExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public ShiguGoodsStyleExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public ShiguGoodsStyleExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public ShiguGoodsStyleExample.Criteria andGsIdIsNull() {
            return isNull(gsId);
        }

        public ShiguGoodsStyleExample.Criteria andGsIdIsNotNull() {
            return isNotNull(gsId);
        }

        public ShiguGoodsStyleExample.Criteria andGsIdEqualTo(Long value) {
            return equalTo(gsId, value);
        }

        public ShiguGoodsStyleExample.Criteria andGsIdNotEqualTo(Long value) {
            return notEqualTo(gsId, value);
        }

        public ShiguGoodsStyleExample.Criteria andGsIdGreaterThan(Long value) {
            return greaterThan(gsId, value);
        }

        public ShiguGoodsStyleExample.Criteria andGsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(gsId, value);
        }

        public ShiguGoodsStyleExample.Criteria andGsIdLessThan(Long value) {
            return lessThan(gsId, value);
        }

        public ShiguGoodsStyleExample.Criteria andGsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(gsId, value);
        }

        public ShiguGoodsStyleExample.Criteria andGsIdIn(List<Long> values) {
            return in(gsId, values);
        }

        public ShiguGoodsStyleExample.Criteria andGsIdNotIn(List<Long> values) {
            return notIn(gsId, values);
        }

        public ShiguGoodsStyleExample.Criteria andGsIdBetween(Long value1, Long value2) {
            return between(gsId, value1, value2);
        }

        public ShiguGoodsStyleExample.Criteria andGsIdNotBetween(Long value1, Long value2) {
            return notBetween(gsId, value1, value2);
        }
    }
}
