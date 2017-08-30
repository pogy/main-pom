package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ActiveDrawGoods;

import java.util.*;
public class ActiveDrawGoodsExample extends SgExample<ActiveDrawGoodsExample.Criteria> {
    public static final Class<ActiveDrawGoods> beanClass = ActiveDrawGoods.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn modifyTime;
    public static EntityColumn createTime;
    public static EntityColumn goodsId;
    public static EntityColumn pemId;
    public static EntityColumn id;
    public static EntityColumn sort;
    public static EntityColumn type;
    public static EntityColumn pitId;
    public static EntityColumn enabled;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        modifyTime = listMap.get("modifyTime");
        createTime = listMap.get("createTime");
        goodsId = listMap.get("goodsId");
        pemId = listMap.get("pemId");
        id = listMap.get("id");
        sort = listMap.get("sort");
        type = listMap.get("type");
        pitId = listMap.get("pitId");
        enabled = listMap.get("enabled");
        }

    public ActiveDrawGoodsExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ActiveDrawGoodsExample.Criteria createCriteriaInternal() {
        return new ActiveDrawGoodsExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeIsNull() {
            return isNull(modifyTime);
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeIsNotNull() {
            return isNotNull(modifyTime);
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeEqualTo(Date value) {
            return equalTo(modifyTime, value);
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeNotEqualTo(Date value) {
            return notEqualTo(modifyTime, value);
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeGreaterThan(Date value) {
            return greaterThan(modifyTime, value);
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(modifyTime, value);
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeLessThan(Date value) {
            return lessThan(modifyTime, value);
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(modifyTime, value);
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeIn(List<Date> values) {
            return in(modifyTime, values);
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeNotIn(List<Date> values) {
            return notIn(modifyTime, values);
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeBetween(Date value1, Date value2) {
            return between(modifyTime, value1, value2);
        }

        public ActiveDrawGoodsExample.Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            return notBetween(modifyTime, value1, value2);
        }
        public ActiveDrawGoodsExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public ActiveDrawGoodsExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public ActiveDrawGoodsExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public ActiveDrawGoodsExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public ActiveDrawGoodsExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public ActiveDrawGoodsExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public ActiveDrawGoodsExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public ActiveDrawGoodsExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public ActiveDrawGoodsExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public ActiveDrawGoodsExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public ActiveDrawGoodsExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public ActiveDrawGoodsExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public ActiveDrawGoodsExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public ActiveDrawGoodsExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public ActiveDrawGoodsExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public ActiveDrawGoodsExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public ActiveDrawGoodsExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public ActiveDrawGoodsExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public ActiveDrawGoodsExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public ActiveDrawGoodsExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public ActiveDrawGoodsExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public ActiveDrawGoodsExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public ActiveDrawGoodsExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public ActiveDrawGoodsExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public ActiveDrawGoodsExample.Criteria andPemIdIsNull() {
            return isNull(pemId);
        }

        public ActiveDrawGoodsExample.Criteria andPemIdIsNotNull() {
            return isNotNull(pemId);
        }

        public ActiveDrawGoodsExample.Criteria andPemIdEqualTo(Long value) {
            return equalTo(pemId, value);
        }

        public ActiveDrawGoodsExample.Criteria andPemIdNotEqualTo(Long value) {
            return notEqualTo(pemId, value);
        }

        public ActiveDrawGoodsExample.Criteria andPemIdGreaterThan(Long value) {
            return greaterThan(pemId, value);
        }

        public ActiveDrawGoodsExample.Criteria andPemIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(pemId, value);
        }

        public ActiveDrawGoodsExample.Criteria andPemIdLessThan(Long value) {
            return lessThan(pemId, value);
        }

        public ActiveDrawGoodsExample.Criteria andPemIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(pemId, value);
        }

        public ActiveDrawGoodsExample.Criteria andPemIdIn(List<Long> values) {
            return in(pemId, values);
        }

        public ActiveDrawGoodsExample.Criteria andPemIdNotIn(List<Long> values) {
            return notIn(pemId, values);
        }

        public ActiveDrawGoodsExample.Criteria andPemIdBetween(Long value1, Long value2) {
            return between(pemId, value1, value2);
        }

        public ActiveDrawGoodsExample.Criteria andPemIdNotBetween(Long value1, Long value2) {
            return notBetween(pemId, value1, value2);
        }
        public ActiveDrawGoodsExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ActiveDrawGoodsExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ActiveDrawGoodsExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public ActiveDrawGoodsExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public ActiveDrawGoodsExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public ActiveDrawGoodsExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ActiveDrawGoodsExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public ActiveDrawGoodsExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public ActiveDrawGoodsExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public ActiveDrawGoodsExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public ActiveDrawGoodsExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public ActiveDrawGoodsExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public ActiveDrawGoodsExample.Criteria andSortIsNull() {
            return isNull(sort);
        }

        public ActiveDrawGoodsExample.Criteria andSortIsNotNull() {
            return isNotNull(sort);
        }

        public ActiveDrawGoodsExample.Criteria andSortEqualTo(Integer value) {
            return equalTo(sort, value);
        }

        public ActiveDrawGoodsExample.Criteria andSortNotEqualTo(Integer value) {
            return notEqualTo(sort, value);
        }

        public ActiveDrawGoodsExample.Criteria andSortGreaterThan(Integer value) {
            return greaterThan(sort, value);
        }

        public ActiveDrawGoodsExample.Criteria andSortGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sort, value);
        }

        public ActiveDrawGoodsExample.Criteria andSortLessThan(Integer value) {
            return lessThan(sort, value);
        }

        public ActiveDrawGoodsExample.Criteria andSortLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sort, value);
        }

        public ActiveDrawGoodsExample.Criteria andSortIn(List<Integer> values) {
            return in(sort, values);
        }

        public ActiveDrawGoodsExample.Criteria andSortNotIn(List<Integer> values) {
            return notIn(sort, values);
        }

        public ActiveDrawGoodsExample.Criteria andSortBetween(Integer value1, Integer value2) {
            return between(sort, value1, value2);
        }

        public ActiveDrawGoodsExample.Criteria andSortNotBetween(Integer value1, Integer value2) {
            return notBetween(sort, value1, value2);
        }
        public ActiveDrawGoodsExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public ActiveDrawGoodsExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public ActiveDrawGoodsExample.Criteria andTypeEqualTo(String value) {
            return equalTo(type, value);
        }

        public ActiveDrawGoodsExample.Criteria andTypeNotEqualTo(String value) {
            return notEqualTo(type, value);
        }

        public ActiveDrawGoodsExample.Criteria andTypeGreaterThan(String value) {
            return greaterThan(type, value);
        }

        public ActiveDrawGoodsExample.Criteria andTypeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(type, value);
        }

        public ActiveDrawGoodsExample.Criteria andTypeLessThan(String value) {
            return lessThan(type, value);
        }

        public ActiveDrawGoodsExample.Criteria andTypeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(type, value);
        }

        public ActiveDrawGoodsExample.Criteria andTypeLike(String value) {
            return like(type, value);
        }

        public ActiveDrawGoodsExample.Criteria andTypeNotLike(String value) {
            return notLike(type, value);
        }

        public ActiveDrawGoodsExample.Criteria andTypeIn(List<String> values) {
            return in(type, values);
        }

        public ActiveDrawGoodsExample.Criteria andTypeNotIn(List<String> values) {
            return notIn(type, values);
        }

        public ActiveDrawGoodsExample.Criteria andTypeBetween(String value1, String value2) {
            return between(type, value1, value2);
        }

        public ActiveDrawGoodsExample.Criteria andTypeNotBetween(String value1, String value2) {
            return notBetween(type, value1, value2);
        }
        public ActiveDrawGoodsExample.Criteria andPitIdIsNull() {
            return isNull(pitId);
        }

        public ActiveDrawGoodsExample.Criteria andPitIdIsNotNull() {
            return isNotNull(pitId);
        }

        public ActiveDrawGoodsExample.Criteria andPitIdEqualTo(Long value) {
            return equalTo(pitId, value);
        }

        public ActiveDrawGoodsExample.Criteria andPitIdNotEqualTo(Long value) {
            return notEqualTo(pitId, value);
        }

        public ActiveDrawGoodsExample.Criteria andPitIdGreaterThan(Long value) {
            return greaterThan(pitId, value);
        }

        public ActiveDrawGoodsExample.Criteria andPitIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(pitId, value);
        }

        public ActiveDrawGoodsExample.Criteria andPitIdLessThan(Long value) {
            return lessThan(pitId, value);
        }

        public ActiveDrawGoodsExample.Criteria andPitIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(pitId, value);
        }

        public ActiveDrawGoodsExample.Criteria andPitIdIn(List<Long> values) {
            return in(pitId, values);
        }

        public ActiveDrawGoodsExample.Criteria andPitIdNotIn(List<Long> values) {
            return notIn(pitId, values);
        }

        public ActiveDrawGoodsExample.Criteria andPitIdBetween(Long value1, Long value2) {
            return between(pitId, value1, value2);
        }

        public ActiveDrawGoodsExample.Criteria andPitIdNotBetween(Long value1, Long value2) {
            return notBetween(pitId, value1, value2);
        }
        public ActiveDrawGoodsExample.Criteria andEnabledIsNull() {
            return isNull(enabled);
        }

        public ActiveDrawGoodsExample.Criteria andEnabledIsNotNull() {
            return isNotNull(enabled);
        }

        public ActiveDrawGoodsExample.Criteria andEnabledEqualTo(Boolean value) {
            return equalTo(enabled, value);
        }

        public ActiveDrawGoodsExample.Criteria andEnabledNotEqualTo(Boolean value) {
            return notEqualTo(enabled, value);
        }

        public ActiveDrawGoodsExample.Criteria andEnabledGreaterThan(Boolean value) {
            return greaterThan(enabled, value);
        }

        public ActiveDrawGoodsExample.Criteria andEnabledGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(enabled, value);
        }

        public ActiveDrawGoodsExample.Criteria andEnabledLessThan(Boolean value) {
            return lessThan(enabled, value);
        }

        public ActiveDrawGoodsExample.Criteria andEnabledLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(enabled, value);
        }

        public ActiveDrawGoodsExample.Criteria andEnabledIn(List<Boolean> values) {
            return in(enabled, values);
        }

        public ActiveDrawGoodsExample.Criteria andEnabledNotIn(List<Boolean> values) {
            return notIn(enabled, values);
        }

        public ActiveDrawGoodsExample.Criteria andEnabledBetween(Boolean value1, Boolean value2) {
            return between(enabled, value1, value2);
        }

        public ActiveDrawGoodsExample.Criteria andEnabledNotBetween(Boolean value1, Boolean value2) {
            return notBetween(enabled, value1, value2);
        }
    }
}
