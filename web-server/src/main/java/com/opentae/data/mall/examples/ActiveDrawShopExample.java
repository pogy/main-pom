package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ActiveDrawShop;

import java.util.*;
public class ActiveDrawShopExample extends SgExample<ActiveDrawShopExample.Criteria> {
    public static final Class<ActiveDrawShop> beanClass = ActiveDrawShop.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn picUrl;
    public static EntityColumn modifyTime;
    public static EntityColumn createTime;
    public static EntityColumn dText;
    public static EntityColumn pemId;
    public static EntityColumn uText;
    public static EntityColumn id;
    public static EntityColumn shopId;
    public static EntityColumn sort;
    public static EntityColumn pitId;
    public static EntityColumn enabled;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        picUrl = listMap.get("picUrl");
        modifyTime = listMap.get("modifyTime");
        createTime = listMap.get("createTime");
        dText = listMap.get("dText");
        pemId = listMap.get("pemId");
        uText = listMap.get("uText");
        id = listMap.get("id");
        shopId = listMap.get("shopId");
        sort = listMap.get("sort");
        pitId = listMap.get("pitId");
        enabled = listMap.get("enabled");
        }

    public ActiveDrawShopExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ActiveDrawShopExample.Criteria createCriteriaInternal() {
        return new ActiveDrawShopExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ActiveDrawShopExample.Criteria andPicUrlIsNull() {
            return isNull(picUrl);
        }

        public ActiveDrawShopExample.Criteria andPicUrlIsNotNull() {
            return isNotNull(picUrl);
        }

        public ActiveDrawShopExample.Criteria andPicUrlEqualTo(String value) {
            return equalTo(picUrl, value);
        }

        public ActiveDrawShopExample.Criteria andPicUrlNotEqualTo(String value) {
            return notEqualTo(picUrl, value);
        }

        public ActiveDrawShopExample.Criteria andPicUrlGreaterThan(String value) {
            return greaterThan(picUrl, value);
        }

        public ActiveDrawShopExample.Criteria andPicUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(picUrl, value);
        }

        public ActiveDrawShopExample.Criteria andPicUrlLessThan(String value) {
            return lessThan(picUrl, value);
        }

        public ActiveDrawShopExample.Criteria andPicUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(picUrl, value);
        }

        public ActiveDrawShopExample.Criteria andPicUrlLike(String value) {
            return like(picUrl, value);
        }

        public ActiveDrawShopExample.Criteria andPicUrlNotLike(String value) {
            return notLike(picUrl, value);
        }

        public ActiveDrawShopExample.Criteria andPicUrlIn(List<String> values) {
            return in(picUrl, values);
        }

        public ActiveDrawShopExample.Criteria andPicUrlNotIn(List<String> values) {
            return notIn(picUrl, values);
        }

        public ActiveDrawShopExample.Criteria andPicUrlBetween(String value1, String value2) {
            return between(picUrl, value1, value2);
        }

        public ActiveDrawShopExample.Criteria andPicUrlNotBetween(String value1, String value2) {
            return notBetween(picUrl, value1, value2);
        }
        public ActiveDrawShopExample.Criteria andModifyTimeIsNull() {
            return isNull(modifyTime);
        }

        public ActiveDrawShopExample.Criteria andModifyTimeIsNotNull() {
            return isNotNull(modifyTime);
        }

        public ActiveDrawShopExample.Criteria andModifyTimeEqualTo(Date value) {
            return equalTo(modifyTime, value);
        }

        public ActiveDrawShopExample.Criteria andModifyTimeNotEqualTo(Date value) {
            return notEqualTo(modifyTime, value);
        }

        public ActiveDrawShopExample.Criteria andModifyTimeGreaterThan(Date value) {
            return greaterThan(modifyTime, value);
        }

        public ActiveDrawShopExample.Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(modifyTime, value);
        }

        public ActiveDrawShopExample.Criteria andModifyTimeLessThan(Date value) {
            return lessThan(modifyTime, value);
        }

        public ActiveDrawShopExample.Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(modifyTime, value);
        }

        public ActiveDrawShopExample.Criteria andModifyTimeIn(List<Date> values) {
            return in(modifyTime, values);
        }

        public ActiveDrawShopExample.Criteria andModifyTimeNotIn(List<Date> values) {
            return notIn(modifyTime, values);
        }

        public ActiveDrawShopExample.Criteria andModifyTimeBetween(Date value1, Date value2) {
            return between(modifyTime, value1, value2);
        }

        public ActiveDrawShopExample.Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            return notBetween(modifyTime, value1, value2);
        }
        public ActiveDrawShopExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public ActiveDrawShopExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public ActiveDrawShopExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public ActiveDrawShopExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public ActiveDrawShopExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public ActiveDrawShopExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public ActiveDrawShopExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public ActiveDrawShopExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public ActiveDrawShopExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public ActiveDrawShopExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public ActiveDrawShopExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public ActiveDrawShopExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public ActiveDrawShopExample.Criteria andDTextIsNull() {
            return isNull(dText);
        }

        public ActiveDrawShopExample.Criteria andDTextIsNotNull() {
            return isNotNull(dText);
        }

        public ActiveDrawShopExample.Criteria andDTextEqualTo(String value) {
            return equalTo(dText, value);
        }

        public ActiveDrawShopExample.Criteria andDTextNotEqualTo(String value) {
            return notEqualTo(dText, value);
        }

        public ActiveDrawShopExample.Criteria andDTextGreaterThan(String value) {
            return greaterThan(dText, value);
        }

        public ActiveDrawShopExample.Criteria andDTextGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(dText, value);
        }

        public ActiveDrawShopExample.Criteria andDTextLessThan(String value) {
            return lessThan(dText, value);
        }

        public ActiveDrawShopExample.Criteria andDTextLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(dText, value);
        }

        public ActiveDrawShopExample.Criteria andDTextLike(String value) {
            return like(dText, value);
        }

        public ActiveDrawShopExample.Criteria andDTextNotLike(String value) {
            return notLike(dText, value);
        }

        public ActiveDrawShopExample.Criteria andDTextIn(List<String> values) {
            return in(dText, values);
        }

        public ActiveDrawShopExample.Criteria andDTextNotIn(List<String> values) {
            return notIn(dText, values);
        }

        public ActiveDrawShopExample.Criteria andDTextBetween(String value1, String value2) {
            return between(dText, value1, value2);
        }

        public ActiveDrawShopExample.Criteria andDTextNotBetween(String value1, String value2) {
            return notBetween(dText, value1, value2);
        }
        public ActiveDrawShopExample.Criteria andPemIdIsNull() {
            return isNull(pemId);
        }

        public ActiveDrawShopExample.Criteria andPemIdIsNotNull() {
            return isNotNull(pemId);
        }

        public ActiveDrawShopExample.Criteria andPemIdEqualTo(Long value) {
            return equalTo(pemId, value);
        }

        public ActiveDrawShopExample.Criteria andPemIdNotEqualTo(Long value) {
            return notEqualTo(pemId, value);
        }

        public ActiveDrawShopExample.Criteria andPemIdGreaterThan(Long value) {
            return greaterThan(pemId, value);
        }

        public ActiveDrawShopExample.Criteria andPemIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(pemId, value);
        }

        public ActiveDrawShopExample.Criteria andPemIdLessThan(Long value) {
            return lessThan(pemId, value);
        }

        public ActiveDrawShopExample.Criteria andPemIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(pemId, value);
        }

        public ActiveDrawShopExample.Criteria andPemIdIn(List<Long> values) {
            return in(pemId, values);
        }

        public ActiveDrawShopExample.Criteria andPemIdNotIn(List<Long> values) {
            return notIn(pemId, values);
        }

        public ActiveDrawShopExample.Criteria andPemIdBetween(Long value1, Long value2) {
            return between(pemId, value1, value2);
        }

        public ActiveDrawShopExample.Criteria andPemIdNotBetween(Long value1, Long value2) {
            return notBetween(pemId, value1, value2);
        }
        public ActiveDrawShopExample.Criteria andUTextIsNull() {
            return isNull(uText);
        }

        public ActiveDrawShopExample.Criteria andUTextIsNotNull() {
            return isNotNull(uText);
        }

        public ActiveDrawShopExample.Criteria andUTextEqualTo(String value) {
            return equalTo(uText, value);
        }

        public ActiveDrawShopExample.Criteria andUTextNotEqualTo(String value) {
            return notEqualTo(uText, value);
        }

        public ActiveDrawShopExample.Criteria andUTextGreaterThan(String value) {
            return greaterThan(uText, value);
        }

        public ActiveDrawShopExample.Criteria andUTextGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(uText, value);
        }

        public ActiveDrawShopExample.Criteria andUTextLessThan(String value) {
            return lessThan(uText, value);
        }

        public ActiveDrawShopExample.Criteria andUTextLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(uText, value);
        }

        public ActiveDrawShopExample.Criteria andUTextLike(String value) {
            return like(uText, value);
        }

        public ActiveDrawShopExample.Criteria andUTextNotLike(String value) {
            return notLike(uText, value);
        }

        public ActiveDrawShopExample.Criteria andUTextIn(List<String> values) {
            return in(uText, values);
        }

        public ActiveDrawShopExample.Criteria andUTextNotIn(List<String> values) {
            return notIn(uText, values);
        }

        public ActiveDrawShopExample.Criteria andUTextBetween(String value1, String value2) {
            return between(uText, value1, value2);
        }

        public ActiveDrawShopExample.Criteria andUTextNotBetween(String value1, String value2) {
            return notBetween(uText, value1, value2);
        }
        public ActiveDrawShopExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ActiveDrawShopExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ActiveDrawShopExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public ActiveDrawShopExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public ActiveDrawShopExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public ActiveDrawShopExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ActiveDrawShopExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public ActiveDrawShopExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public ActiveDrawShopExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public ActiveDrawShopExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public ActiveDrawShopExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public ActiveDrawShopExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public ActiveDrawShopExample.Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public ActiveDrawShopExample.Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public ActiveDrawShopExample.Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public ActiveDrawShopExample.Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public ActiveDrawShopExample.Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public ActiveDrawShopExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public ActiveDrawShopExample.Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public ActiveDrawShopExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public ActiveDrawShopExample.Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public ActiveDrawShopExample.Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public ActiveDrawShopExample.Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public ActiveDrawShopExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
        }
        public ActiveDrawShopExample.Criteria andSortIsNull() {
            return isNull(sort);
        }

        public ActiveDrawShopExample.Criteria andSortIsNotNull() {
            return isNotNull(sort);
        }

        public ActiveDrawShopExample.Criteria andSortEqualTo(Integer value) {
            return equalTo(sort, value);
        }

        public ActiveDrawShopExample.Criteria andSortNotEqualTo(Integer value) {
            return notEqualTo(sort, value);
        }

        public ActiveDrawShopExample.Criteria andSortGreaterThan(Integer value) {
            return greaterThan(sort, value);
        }

        public ActiveDrawShopExample.Criteria andSortGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sort, value);
        }

        public ActiveDrawShopExample.Criteria andSortLessThan(Integer value) {
            return lessThan(sort, value);
        }

        public ActiveDrawShopExample.Criteria andSortLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sort, value);
        }

        public ActiveDrawShopExample.Criteria andSortIn(List<Integer> values) {
            return in(sort, values);
        }

        public ActiveDrawShopExample.Criteria andSortNotIn(List<Integer> values) {
            return notIn(sort, values);
        }

        public ActiveDrawShopExample.Criteria andSortBetween(Integer value1, Integer value2) {
            return between(sort, value1, value2);
        }

        public ActiveDrawShopExample.Criteria andSortNotBetween(Integer value1, Integer value2) {
            return notBetween(sort, value1, value2);
        }
        public ActiveDrawShopExample.Criteria andPitIdIsNull() {
            return isNull(pitId);
        }

        public ActiveDrawShopExample.Criteria andPitIdIsNotNull() {
            return isNotNull(pitId);
        }

        public ActiveDrawShopExample.Criteria andPitIdEqualTo(Long value) {
            return equalTo(pitId, value);
        }

        public ActiveDrawShopExample.Criteria andPitIdNotEqualTo(Long value) {
            return notEqualTo(pitId, value);
        }

        public ActiveDrawShopExample.Criteria andPitIdGreaterThan(Long value) {
            return greaterThan(pitId, value);
        }

        public ActiveDrawShopExample.Criteria andPitIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(pitId, value);
        }

        public ActiveDrawShopExample.Criteria andPitIdLessThan(Long value) {
            return lessThan(pitId, value);
        }

        public ActiveDrawShopExample.Criteria andPitIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(pitId, value);
        }

        public ActiveDrawShopExample.Criteria andPitIdIn(List<Long> values) {
            return in(pitId, values);
        }

        public ActiveDrawShopExample.Criteria andPitIdNotIn(List<Long> values) {
            return notIn(pitId, values);
        }

        public ActiveDrawShopExample.Criteria andPitIdBetween(Long value1, Long value2) {
            return between(pitId, value1, value2);
        }

        public ActiveDrawShopExample.Criteria andPitIdNotBetween(Long value1, Long value2) {
            return notBetween(pitId, value1, value2);
        }
        public ActiveDrawShopExample.Criteria andEnabledIsNull() {
            return isNull(enabled);
        }

        public ActiveDrawShopExample.Criteria andEnabledIsNotNull() {
            return isNotNull(enabled);
        }

        public ActiveDrawShopExample.Criteria andEnabledEqualTo(Boolean value) {
            return equalTo(enabled, value);
        }

        public ActiveDrawShopExample.Criteria andEnabledNotEqualTo(Boolean value) {
            return notEqualTo(enabled, value);
        }

        public ActiveDrawShopExample.Criteria andEnabledGreaterThan(Boolean value) {
            return greaterThan(enabled, value);
        }

        public ActiveDrawShopExample.Criteria andEnabledGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(enabled, value);
        }

        public ActiveDrawShopExample.Criteria andEnabledLessThan(Boolean value) {
            return lessThan(enabled, value);
        }

        public ActiveDrawShopExample.Criteria andEnabledLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(enabled, value);
        }

        public ActiveDrawShopExample.Criteria andEnabledIn(List<Boolean> values) {
            return in(enabled, values);
        }

        public ActiveDrawShopExample.Criteria andEnabledNotIn(List<Boolean> values) {
            return notIn(enabled, values);
        }

        public ActiveDrawShopExample.Criteria andEnabledBetween(Boolean value1, Boolean value2) {
            return between(enabled, value1, value2);
        }

        public ActiveDrawShopExample.Criteria andEnabledNotBetween(Boolean value1, Boolean value2) {
            return notBetween(enabled, value1, value2);
        }
    }
}
