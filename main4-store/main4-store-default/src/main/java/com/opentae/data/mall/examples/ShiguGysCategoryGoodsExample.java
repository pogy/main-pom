package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguGysCategoryGoods;

import java.util.*;
public class ShiguGysCategoryGoodsExample extends SgExample<ShiguGysCategoryGoodsExample.Criteria> {
    public static final Class<ShiguGysCategoryGoods> beanClass = ShiguGysCategoryGoods.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn goodsId;
    public static EntityColumn gcId;
    public static EntityColumn gcgId;
    public static EntityColumn gcgStatus;
    public static EntityColumn sId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        goodsId = listMap.get("goodsId");
        gcId = listMap.get("gcId");
        gcgId = listMap.get("gcgId");
        gcgStatus = listMap.get("gcgStatus");
        sId = listMap.get("sId");
        }

    public ShiguGysCategoryGoodsExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguGysCategoryGoodsExample.Criteria createCriteriaInternal() {
        return new ShiguGysCategoryGoodsExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public ShiguGysCategoryGoodsExample.Criteria andGcIdIsNull() {
            return isNull(gcId);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcIdIsNotNull() {
            return isNotNull(gcId);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcIdEqualTo(Long value) {
            return equalTo(gcId, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcIdNotEqualTo(Long value) {
            return notEqualTo(gcId, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcIdGreaterThan(Long value) {
            return greaterThan(gcId, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(gcId, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcIdLessThan(Long value) {
            return lessThan(gcId, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(gcId, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcIdIn(List<Long> values) {
            return in(gcId, values);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcIdNotIn(List<Long> values) {
            return notIn(gcId, values);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcIdBetween(Long value1, Long value2) {
            return between(gcId, value1, value2);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcIdNotBetween(Long value1, Long value2) {
            return notBetween(gcId, value1, value2);
        }
        public ShiguGysCategoryGoodsExample.Criteria andGcgIdIsNull() {
            return isNull(gcgId);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcgIdIsNotNull() {
            return isNotNull(gcgId);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcgIdEqualTo(Long value) {
            return equalTo(gcgId, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcgIdNotEqualTo(Long value) {
            return notEqualTo(gcgId, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcgIdGreaterThan(Long value) {
            return greaterThan(gcgId, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcgIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(gcgId, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcgIdLessThan(Long value) {
            return lessThan(gcgId, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcgIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(gcgId, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcgIdIn(List<Long> values) {
            return in(gcgId, values);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcgIdNotIn(List<Long> values) {
            return notIn(gcgId, values);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcgIdBetween(Long value1, Long value2) {
            return between(gcgId, value1, value2);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcgIdNotBetween(Long value1, Long value2) {
            return notBetween(gcgId, value1, value2);
        }
        public ShiguGysCategoryGoodsExample.Criteria andGcgStatusIsNull() {
            return isNull(gcgStatus);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcgStatusIsNotNull() {
            return isNotNull(gcgStatus);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcgStatusEqualTo(Integer value) {
            return equalTo(gcgStatus, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcgStatusNotEqualTo(Integer value) {
            return notEqualTo(gcgStatus, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcgStatusGreaterThan(Integer value) {
            return greaterThan(gcgStatus, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcgStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(gcgStatus, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcgStatusLessThan(Integer value) {
            return lessThan(gcgStatus, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcgStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(gcgStatus, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcgStatusIn(List<Integer> values) {
            return in(gcgStatus, values);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcgStatusNotIn(List<Integer> values) {
            return notIn(gcgStatus, values);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcgStatusBetween(Integer value1, Integer value2) {
            return between(gcgStatus, value1, value2);
        }

        public ShiguGysCategoryGoodsExample.Criteria andGcgStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(gcgStatus, value1, value2);
        }
        public ShiguGysCategoryGoodsExample.Criteria andSIdIsNull() {
            return isNull(sId);
        }

        public ShiguGysCategoryGoodsExample.Criteria andSIdIsNotNull() {
            return isNotNull(sId);
        }

        public ShiguGysCategoryGoodsExample.Criteria andSIdEqualTo(Long value) {
            return equalTo(sId, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andSIdNotEqualTo(Long value) {
            return notEqualTo(sId, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andSIdGreaterThan(Long value) {
            return greaterThan(sId, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andSIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sId, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andSIdLessThan(Long value) {
            return lessThan(sId, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andSIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sId, value);
        }

        public ShiguGysCategoryGoodsExample.Criteria andSIdIn(List<Long> values) {
            return in(sId, values);
        }

        public ShiguGysCategoryGoodsExample.Criteria andSIdNotIn(List<Long> values) {
            return notIn(sId, values);
        }

        public ShiguGysCategoryGoodsExample.Criteria andSIdBetween(Long value1, Long value2) {
            return between(sId, value1, value2);
        }

        public ShiguGysCategoryGoodsExample.Criteria andSIdNotBetween(Long value1, Long value2) {
            return notBetween(sId, value1, value2);
        }
    }
}