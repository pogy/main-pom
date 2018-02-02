package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguNewActivityUpRecord;

import java.util.*;
public class ShiguNewActivityUpRecordExample extends SgExample<ShiguNewActivityUpRecordExample.Criteria> {
    public static final Class<ShiguNewActivityUpRecord> beanClass = ShiguNewActivityUpRecord.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn gmtModify;
    public static EntityColumn newActiveId;
    public static EntityColumn goodsId;
    public static EntityColumn id;
    public static EntityColumn gmtCreate;
    public static EntityColumn type;
    public static EntityColumn memberId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        gmtModify = listMap.get("gmtModify");
        newActiveId = listMap.get("newActiveId");
        goodsId = listMap.get("goodsId");
        id = listMap.get("id");
        gmtCreate = listMap.get("gmtCreate");
        type = listMap.get("type");
        memberId = listMap.get("memberId");
        }

    public ShiguNewActivityUpRecordExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguNewActivityUpRecordExample.Criteria createCriteriaInternal() {
        return new ShiguNewActivityUpRecordExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGmtModifyIsNull() {
            return isNull(gmtModify);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGmtModifyIsNotNull() {
            return isNotNull(gmtModify);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGmtModifyEqualTo(Date value) {
            return equalTo(gmtModify, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGmtModifyNotEqualTo(Date value) {
            return notEqualTo(gmtModify, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGmtModifyGreaterThan(Date value) {
            return greaterThan(gmtModify, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtModify, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGmtModifyLessThan(Date value) {
            return lessThan(gmtModify, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtModify, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGmtModifyIn(List<Date> values) {
            return in(gmtModify, values);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGmtModifyNotIn(List<Date> values) {
            return notIn(gmtModify, values);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGmtModifyBetween(Date value1, Date value2) {
            return between(gmtModify, value1, value2);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            return notBetween(gmtModify, value1, value2);
        }
        public ShiguNewActivityUpRecordExample.Criteria andNewActiveIdIsNull() {
            return isNull(newActiveId);
        }

        public ShiguNewActivityUpRecordExample.Criteria andNewActiveIdIsNotNull() {
            return isNotNull(newActiveId);
        }

        public ShiguNewActivityUpRecordExample.Criteria andNewActiveIdEqualTo(Long value) {
            return equalTo(newActiveId, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andNewActiveIdNotEqualTo(Long value) {
            return notEqualTo(newActiveId, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andNewActiveIdGreaterThan(Long value) {
            return greaterThan(newActiveId, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andNewActiveIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(newActiveId, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andNewActiveIdLessThan(Long value) {
            return lessThan(newActiveId, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andNewActiveIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(newActiveId, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andNewActiveIdIn(List<Long> values) {
            return in(newActiveId, values);
        }

        public ShiguNewActivityUpRecordExample.Criteria andNewActiveIdNotIn(List<Long> values) {
            return notIn(newActiveId, values);
        }

        public ShiguNewActivityUpRecordExample.Criteria andNewActiveIdBetween(Long value1, Long value2) {
            return between(newActiveId, value1, value2);
        }

        public ShiguNewActivityUpRecordExample.Criteria andNewActiveIdNotBetween(Long value1, Long value2) {
            return notBetween(newActiveId, value1, value2);
        }
        public ShiguNewActivityUpRecordExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public ShiguNewActivityUpRecordExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ShiguNewActivityUpRecordExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ShiguNewActivityUpRecordExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public ShiguNewActivityUpRecordExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public ShiguNewActivityUpRecordExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public ShiguNewActivityUpRecordExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public ShiguNewActivityUpRecordExample.Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public ShiguNewActivityUpRecordExample.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
        public ShiguNewActivityUpRecordExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public ShiguNewActivityUpRecordExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public ShiguNewActivityUpRecordExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public ShiguNewActivityUpRecordExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public ShiguNewActivityUpRecordExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public ShiguNewActivityUpRecordExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
        public ShiguNewActivityUpRecordExample.Criteria andMemberIdIsNull() {
            return isNull(memberId);
        }

        public ShiguNewActivityUpRecordExample.Criteria andMemberIdIsNotNull() {
            return isNotNull(memberId);
        }

        public ShiguNewActivityUpRecordExample.Criteria andMemberIdEqualTo(Long value) {
            return equalTo(memberId, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andMemberIdNotEqualTo(Long value) {
            return notEqualTo(memberId, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andMemberIdGreaterThan(Long value) {
            return greaterThan(memberId, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andMemberIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(memberId, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andMemberIdLessThan(Long value) {
            return lessThan(memberId, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andMemberIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(memberId, value);
        }

        public ShiguNewActivityUpRecordExample.Criteria andMemberIdIn(List<Long> values) {
            return in(memberId, values);
        }

        public ShiguNewActivityUpRecordExample.Criteria andMemberIdNotIn(List<Long> values) {
            return notIn(memberId, values);
        }

        public ShiguNewActivityUpRecordExample.Criteria andMemberIdBetween(Long value1, Long value2) {
            return between(memberId, value1, value2);
        }

        public ShiguNewActivityUpRecordExample.Criteria andMemberIdNotBetween(Long value1, Long value2) {
            return notBetween(memberId, value1, value2);
        }
    }
}