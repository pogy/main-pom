package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguGoodsTinyCreatedQz;

import java.util.*;
public class ShiguGoodsTinyCreatedQzExample extends SgExample<ShiguGoodsTinyCreatedQzExample.Criteria> {
    public static final Class<ShiguGoodsTinyCreatedQz> beanClass = ShiguGoodsTinyCreatedQz.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn oldCreated;
    public static EntityColumn goodsId;
    public static EntityColumn gmtCreate;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        oldCreated = listMap.get("oldCreated");
        goodsId = listMap.get("goodsId");
        gmtCreate = listMap.get("gmtCreate");
        }

    public ShiguGoodsTinyCreatedQzExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguGoodsTinyCreatedQzExample.Criteria createCriteriaInternal() {
        return new ShiguGoodsTinyCreatedQzExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andOldCreatedIsNull() {
            return isNull(oldCreated);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andOldCreatedIsNotNull() {
            return isNotNull(oldCreated);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andOldCreatedEqualTo(Date value) {
            return equalTo(oldCreated, value);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andOldCreatedNotEqualTo(Date value) {
            return notEqualTo(oldCreated, value);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andOldCreatedGreaterThan(Date value) {
            return greaterThan(oldCreated, value);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andOldCreatedGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(oldCreated, value);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andOldCreatedLessThan(Date value) {
            return lessThan(oldCreated, value);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andOldCreatedLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(oldCreated, value);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andOldCreatedIn(List<Date> values) {
            return in(oldCreated, values);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andOldCreatedNotIn(List<Date> values) {
            return notIn(oldCreated, values);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andOldCreatedBetween(Date value1, Date value2) {
            return between(oldCreated, value1, value2);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andOldCreatedNotBetween(Date value1, Date value2) {
            return notBetween(oldCreated, value1, value2);
        }
        public ShiguGoodsTinyCreatedQzExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public ShiguGoodsTinyCreatedQzExample.Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public ShiguGoodsTinyCreatedQzExample.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
    }
}