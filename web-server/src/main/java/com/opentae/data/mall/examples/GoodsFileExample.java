package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.GoodsFile;

import java.util.*;
public class GoodsFileExample extends SgExample<GoodsFileExample.Criteria> {
    public static final Class<GoodsFile> beanClass = GoodsFile.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn goodsId;
    public static EntityColumn fileKey;
    public static EntityColumn id;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        goodsId = listMap.get("goodsId");
        fileKey = listMap.get("fileKey");
        id = listMap.get("id");
        }

    public GoodsFileExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected GoodsFileExample.Criteria createCriteriaInternal() {
        return new GoodsFileExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public GoodsFileExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public GoodsFileExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public GoodsFileExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public GoodsFileExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public GoodsFileExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public GoodsFileExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public GoodsFileExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public GoodsFileExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public GoodsFileExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public GoodsFileExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public GoodsFileExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public GoodsFileExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public GoodsFileExample.Criteria andFileKeyIsNull() {
            return isNull(fileKey);
        }

        public GoodsFileExample.Criteria andFileKeyIsNotNull() {
            return isNotNull(fileKey);
        }

        public GoodsFileExample.Criteria andFileKeyEqualTo(String value) {
            return equalTo(fileKey, value);
        }

        public GoodsFileExample.Criteria andFileKeyNotEqualTo(String value) {
            return notEqualTo(fileKey, value);
        }

        public GoodsFileExample.Criteria andFileKeyGreaterThan(String value) {
            return greaterThan(fileKey, value);
        }

        public GoodsFileExample.Criteria andFileKeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(fileKey, value);
        }

        public GoodsFileExample.Criteria andFileKeyLessThan(String value) {
            return lessThan(fileKey, value);
        }

        public GoodsFileExample.Criteria andFileKeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(fileKey, value);
        }

        public GoodsFileExample.Criteria andFileKeyLike(String value) {
            return like(fileKey, value);
        }

        public GoodsFileExample.Criteria andFileKeyNotLike(String value) {
            return notLike(fileKey, value);
        }

        public GoodsFileExample.Criteria andFileKeyIn(List<String> values) {
            return in(fileKey, values);
        }

        public GoodsFileExample.Criteria andFileKeyNotIn(List<String> values) {
            return notIn(fileKey, values);
        }

        public GoodsFileExample.Criteria andFileKeyBetween(String value1, String value2) {
            return between(fileKey, value1, value2);
        }

        public GoodsFileExample.Criteria andFileKeyNotBetween(String value1, String value2) {
            return notBetween(fileKey, value1, value2);
        }
        public GoodsFileExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public GoodsFileExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public GoodsFileExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public GoodsFileExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public GoodsFileExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public GoodsFileExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public GoodsFileExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public GoodsFileExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public GoodsFileExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public GoodsFileExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public GoodsFileExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public GoodsFileExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
    }
}
