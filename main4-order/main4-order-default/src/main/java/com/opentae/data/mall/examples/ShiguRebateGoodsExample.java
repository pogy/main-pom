package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguRebateGoods;

import java.util.*;
public class ShiguRebateGoodsExample extends SgExample<ShiguRebateGoodsExample.Criteria> {
    public static final Class<ShiguRebateGoods> beanClass = ShiguRebateGoods.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn goodsStatus;
    public static EntityColumn goodsId;
    public static EntityColumn gmtUpdate;
    public static EntityColumn id;
    public static EntityColumn gmtCreate;
    public static EntityColumn goodsTabId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        goodsStatus = listMap.get("goodsStatus");
        goodsId = listMap.get("goodsId");
        gmtUpdate = listMap.get("gmtUpdate");
        id = listMap.get("id");
        gmtCreate = listMap.get("gmtCreate");
        goodsTabId = listMap.get("goodsTabId");
        }

    public ShiguRebateGoodsExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguRebateGoodsExample.Criteria createCriteriaInternal() {
        return new ShiguRebateGoodsExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsStatusIsNull() {
            return isNull(goodsStatus);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsStatusIsNotNull() {
            return isNotNull(goodsStatus);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsStatusEqualTo(Integer value) {
            return equalTo(goodsStatus, value);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsStatusNotEqualTo(Integer value) {
            return notEqualTo(goodsStatus, value);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsStatusGreaterThan(Integer value) {
            return greaterThan(goodsStatus, value);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(goodsStatus, value);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsStatusLessThan(Integer value) {
            return lessThan(goodsStatus, value);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(goodsStatus, value);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsStatusIn(List<Integer> values) {
            return in(goodsStatus, values);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsStatusNotIn(List<Integer> values) {
            return notIn(goodsStatus, values);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsStatusBetween(Integer value1, Integer value2) {
            return between(goodsStatus, value1, value2);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(goodsStatus, value1, value2);
        }
        public ShiguRebateGoodsExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public ShiguRebateGoodsExample.Criteria andGmtUpdateIsNull() {
            return isNull(gmtUpdate);
        }

        public ShiguRebateGoodsExample.Criteria andGmtUpdateIsNotNull() {
            return isNotNull(gmtUpdate);
        }

        public ShiguRebateGoodsExample.Criteria andGmtUpdateEqualTo(Date value) {
            return equalTo(gmtUpdate, value);
        }

        public ShiguRebateGoodsExample.Criteria andGmtUpdateNotEqualTo(Date value) {
            return notEqualTo(gmtUpdate, value);
        }

        public ShiguRebateGoodsExample.Criteria andGmtUpdateGreaterThan(Date value) {
            return greaterThan(gmtUpdate, value);
        }

        public ShiguRebateGoodsExample.Criteria andGmtUpdateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtUpdate, value);
        }

        public ShiguRebateGoodsExample.Criteria andGmtUpdateLessThan(Date value) {
            return lessThan(gmtUpdate, value);
        }

        public ShiguRebateGoodsExample.Criteria andGmtUpdateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtUpdate, value);
        }

        public ShiguRebateGoodsExample.Criteria andGmtUpdateIn(List<Date> values) {
            return in(gmtUpdate, values);
        }

        public ShiguRebateGoodsExample.Criteria andGmtUpdateNotIn(List<Date> values) {
            return notIn(gmtUpdate, values);
        }

        public ShiguRebateGoodsExample.Criteria andGmtUpdateBetween(Date value1, Date value2) {
            return between(gmtUpdate, value1, value2);
        }

        public ShiguRebateGoodsExample.Criteria andGmtUpdateNotBetween(Date value1, Date value2) {
            return notBetween(gmtUpdate, value1, value2);
        }
        public ShiguRebateGoodsExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ShiguRebateGoodsExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ShiguRebateGoodsExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public ShiguRebateGoodsExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public ShiguRebateGoodsExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public ShiguRebateGoodsExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ShiguRebateGoodsExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public ShiguRebateGoodsExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public ShiguRebateGoodsExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public ShiguRebateGoodsExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public ShiguRebateGoodsExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public ShiguRebateGoodsExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public ShiguRebateGoodsExample.Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public ShiguRebateGoodsExample.Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public ShiguRebateGoodsExample.Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public ShiguRebateGoodsExample.Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public ShiguRebateGoodsExample.Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public ShiguRebateGoodsExample.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public ShiguRebateGoodsExample.Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public ShiguRebateGoodsExample.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public ShiguRebateGoodsExample.Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public ShiguRebateGoodsExample.Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public ShiguRebateGoodsExample.Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public ShiguRebateGoodsExample.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
        public ShiguRebateGoodsExample.Criteria andGoodsTabIdIsNull() {
            return isNull(goodsTabId);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsTabIdIsNotNull() {
            return isNotNull(goodsTabId);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsTabIdEqualTo(Long value) {
            return equalTo(goodsTabId, value);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsTabIdNotEqualTo(Long value) {
            return notEqualTo(goodsTabId, value);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsTabIdGreaterThan(Long value) {
            return greaterThan(goodsTabId, value);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsTabIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsTabId, value);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsTabIdLessThan(Long value) {
            return lessThan(goodsTabId, value);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsTabIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsTabId, value);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsTabIdIn(List<Long> values) {
            return in(goodsTabId, values);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsTabIdNotIn(List<Long> values) {
            return notIn(goodsTabId, values);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsTabIdBetween(Long value1, Long value2) {
            return between(goodsTabId, value1, value2);
        }

        public ShiguRebateGoodsExample.Criteria andGoodsTabIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsTabId, value1, value2);
        }
    }
}