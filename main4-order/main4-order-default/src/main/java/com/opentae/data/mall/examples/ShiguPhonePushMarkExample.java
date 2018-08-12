package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguPhonePushMark;

import java.util.*;
public class ShiguPhonePushMarkExample extends SgExample<ShiguPhonePushMarkExample.Criteria> {
    public static final Class<ShiguPhonePushMark> beanClass = ShiguPhonePushMark.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn pushCid;
    public static EntityColumn phoneModel;
    public static EntityColumn xzUserKey;
    public static EntityColumn gmtModify;
    public static EntityColumn pushAppId;
    public static EntityColumn id;
    public static EntityColumn gmtCreate;
    public static EntityColumn deviceToken;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        pushCid = listMap.get("pushCid");
        phoneModel = listMap.get("phoneModel");
        xzUserKey = listMap.get("xzUserKey");
        gmtModify = listMap.get("gmtModify");
        pushAppId = listMap.get("pushAppId");
        id = listMap.get("id");
        gmtCreate = listMap.get("gmtCreate");
        deviceToken = listMap.get("deviceToken");
        }

    public ShiguPhonePushMarkExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguPhonePushMarkExample.Criteria createCriteriaInternal() {
        return new ShiguPhonePushMarkExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguPhonePushMarkExample.Criteria andPushCidIsNull() {
            return isNull(pushCid);
        }

        public ShiguPhonePushMarkExample.Criteria andPushCidIsNotNull() {
            return isNotNull(pushCid);
        }

        public ShiguPhonePushMarkExample.Criteria andPushCidEqualTo(String value) {
            return equalTo(pushCid, value);
        }

        public ShiguPhonePushMarkExample.Criteria andPushCidNotEqualTo(String value) {
            return notEqualTo(pushCid, value);
        }

        public ShiguPhonePushMarkExample.Criteria andPushCidGreaterThan(String value) {
            return greaterThan(pushCid, value);
        }

        public ShiguPhonePushMarkExample.Criteria andPushCidGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(pushCid, value);
        }

        public ShiguPhonePushMarkExample.Criteria andPushCidLessThan(String value) {
            return lessThan(pushCid, value);
        }

        public ShiguPhonePushMarkExample.Criteria andPushCidLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(pushCid, value);
        }

        public ShiguPhonePushMarkExample.Criteria andPushCidLike(String value) {
            return like(pushCid, value);
        }

        public ShiguPhonePushMarkExample.Criteria andPushCidNotLike(String value) {
            return notLike(pushCid, value);
        }

        public ShiguPhonePushMarkExample.Criteria andPushCidIn(List<String> values) {
            return in(pushCid, values);
        }

        public ShiguPhonePushMarkExample.Criteria andPushCidNotIn(List<String> values) {
            return notIn(pushCid, values);
        }

        public ShiguPhonePushMarkExample.Criteria andPushCidBetween(String value1, String value2) {
            return between(pushCid, value1, value2);
        }

        public ShiguPhonePushMarkExample.Criteria andPushCidNotBetween(String value1, String value2) {
            return notBetween(pushCid, value1, value2);
        }
        public ShiguPhonePushMarkExample.Criteria andPhoneModelIsNull() {
            return isNull(phoneModel);
        }

        public ShiguPhonePushMarkExample.Criteria andPhoneModelIsNotNull() {
            return isNotNull(phoneModel);
        }

        public ShiguPhonePushMarkExample.Criteria andPhoneModelEqualTo(Integer value) {
            return equalTo(phoneModel, value);
        }

        public ShiguPhonePushMarkExample.Criteria andPhoneModelNotEqualTo(Integer value) {
            return notEqualTo(phoneModel, value);
        }

        public ShiguPhonePushMarkExample.Criteria andPhoneModelGreaterThan(Integer value) {
            return greaterThan(phoneModel, value);
        }

        public ShiguPhonePushMarkExample.Criteria andPhoneModelGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(phoneModel, value);
        }

        public ShiguPhonePushMarkExample.Criteria andPhoneModelLessThan(Integer value) {
            return lessThan(phoneModel, value);
        }

        public ShiguPhonePushMarkExample.Criteria andPhoneModelLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(phoneModel, value);
        }

        public ShiguPhonePushMarkExample.Criteria andPhoneModelIn(List<Integer> values) {
            return in(phoneModel, values);
        }

        public ShiguPhonePushMarkExample.Criteria andPhoneModelNotIn(List<Integer> values) {
            return notIn(phoneModel, values);
        }

        public ShiguPhonePushMarkExample.Criteria andPhoneModelBetween(Integer value1, Integer value2) {
            return between(phoneModel, value1, value2);
        }

        public ShiguPhonePushMarkExample.Criteria andPhoneModelNotBetween(Integer value1, Integer value2) {
            return notBetween(phoneModel, value1, value2);
        }
        public ShiguPhonePushMarkExample.Criteria andXzUserKeyIsNull() {
            return isNull(xzUserKey);
        }

        public ShiguPhonePushMarkExample.Criteria andXzUserKeyIsNotNull() {
            return isNotNull(xzUserKey);
        }

        public ShiguPhonePushMarkExample.Criteria andXzUserKeyEqualTo(String value) {
            return equalTo(xzUserKey, value);
        }

        public ShiguPhonePushMarkExample.Criteria andXzUserKeyNotEqualTo(String value) {
            return notEqualTo(xzUserKey, value);
        }

        public ShiguPhonePushMarkExample.Criteria andXzUserKeyGreaterThan(String value) {
            return greaterThan(xzUserKey, value);
        }

        public ShiguPhonePushMarkExample.Criteria andXzUserKeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(xzUserKey, value);
        }

        public ShiguPhonePushMarkExample.Criteria andXzUserKeyLessThan(String value) {
            return lessThan(xzUserKey, value);
        }

        public ShiguPhonePushMarkExample.Criteria andXzUserKeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(xzUserKey, value);
        }

        public ShiguPhonePushMarkExample.Criteria andXzUserKeyLike(String value) {
            return like(xzUserKey, value);
        }

        public ShiguPhonePushMarkExample.Criteria andXzUserKeyNotLike(String value) {
            return notLike(xzUserKey, value);
        }

        public ShiguPhonePushMarkExample.Criteria andXzUserKeyIn(List<String> values) {
            return in(xzUserKey, values);
        }

        public ShiguPhonePushMarkExample.Criteria andXzUserKeyNotIn(List<String> values) {
            return notIn(xzUserKey, values);
        }

        public ShiguPhonePushMarkExample.Criteria andXzUserKeyBetween(String value1, String value2) {
            return between(xzUserKey, value1, value2);
        }

        public ShiguPhonePushMarkExample.Criteria andXzUserKeyNotBetween(String value1, String value2) {
            return notBetween(xzUserKey, value1, value2);
        }
        public ShiguPhonePushMarkExample.Criteria andGmtModifyIsNull() {
            return isNull(gmtModify);
        }

        public ShiguPhonePushMarkExample.Criteria andGmtModifyIsNotNull() {
            return isNotNull(gmtModify);
        }

        public ShiguPhonePushMarkExample.Criteria andGmtModifyEqualTo(Date value) {
            return equalTo(gmtModify, value);
        }

        public ShiguPhonePushMarkExample.Criteria andGmtModifyNotEqualTo(Date value) {
            return notEqualTo(gmtModify, value);
        }

        public ShiguPhonePushMarkExample.Criteria andGmtModifyGreaterThan(Date value) {
            return greaterThan(gmtModify, value);
        }

        public ShiguPhonePushMarkExample.Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtModify, value);
        }

        public ShiguPhonePushMarkExample.Criteria andGmtModifyLessThan(Date value) {
            return lessThan(gmtModify, value);
        }

        public ShiguPhonePushMarkExample.Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtModify, value);
        }

        public ShiguPhonePushMarkExample.Criteria andGmtModifyIn(List<Date> values) {
            return in(gmtModify, values);
        }

        public ShiguPhonePushMarkExample.Criteria andGmtModifyNotIn(List<Date> values) {
            return notIn(gmtModify, values);
        }

        public ShiguPhonePushMarkExample.Criteria andGmtModifyBetween(Date value1, Date value2) {
            return between(gmtModify, value1, value2);
        }

        public ShiguPhonePushMarkExample.Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            return notBetween(gmtModify, value1, value2);
        }
        public ShiguPhonePushMarkExample.Criteria andPushAppIdIsNull() {
            return isNull(pushAppId);
        }

        public ShiguPhonePushMarkExample.Criteria andPushAppIdIsNotNull() {
            return isNotNull(pushAppId);
        }

        public ShiguPhonePushMarkExample.Criteria andPushAppIdEqualTo(String value) {
            return equalTo(pushAppId, value);
        }

        public ShiguPhonePushMarkExample.Criteria andPushAppIdNotEqualTo(String value) {
            return notEqualTo(pushAppId, value);
        }

        public ShiguPhonePushMarkExample.Criteria andPushAppIdGreaterThan(String value) {
            return greaterThan(pushAppId, value);
        }

        public ShiguPhonePushMarkExample.Criteria andPushAppIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(pushAppId, value);
        }

        public ShiguPhonePushMarkExample.Criteria andPushAppIdLessThan(String value) {
            return lessThan(pushAppId, value);
        }

        public ShiguPhonePushMarkExample.Criteria andPushAppIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(pushAppId, value);
        }

        public ShiguPhonePushMarkExample.Criteria andPushAppIdLike(String value) {
            return like(pushAppId, value);
        }

        public ShiguPhonePushMarkExample.Criteria andPushAppIdNotLike(String value) {
            return notLike(pushAppId, value);
        }

        public ShiguPhonePushMarkExample.Criteria andPushAppIdIn(List<String> values) {
            return in(pushAppId, values);
        }

        public ShiguPhonePushMarkExample.Criteria andPushAppIdNotIn(List<String> values) {
            return notIn(pushAppId, values);
        }

        public ShiguPhonePushMarkExample.Criteria andPushAppIdBetween(String value1, String value2) {
            return between(pushAppId, value1, value2);
        }

        public ShiguPhonePushMarkExample.Criteria andPushAppIdNotBetween(String value1, String value2) {
            return notBetween(pushAppId, value1, value2);
        }
        public ShiguPhonePushMarkExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ShiguPhonePushMarkExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ShiguPhonePushMarkExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public ShiguPhonePushMarkExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public ShiguPhonePushMarkExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public ShiguPhonePushMarkExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ShiguPhonePushMarkExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public ShiguPhonePushMarkExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public ShiguPhonePushMarkExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public ShiguPhonePushMarkExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public ShiguPhonePushMarkExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public ShiguPhonePushMarkExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public ShiguPhonePushMarkExample.Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public ShiguPhonePushMarkExample.Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public ShiguPhonePushMarkExample.Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public ShiguPhonePushMarkExample.Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public ShiguPhonePushMarkExample.Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public ShiguPhonePushMarkExample.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public ShiguPhonePushMarkExample.Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public ShiguPhonePushMarkExample.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public ShiguPhonePushMarkExample.Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public ShiguPhonePushMarkExample.Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public ShiguPhonePushMarkExample.Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public ShiguPhonePushMarkExample.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
        public ShiguPhonePushMarkExample.Criteria andDeviceTokenIsNull() {
            return isNull(deviceToken);
        }

        public ShiguPhonePushMarkExample.Criteria andDeviceTokenIsNotNull() {
            return isNotNull(deviceToken);
        }

        public ShiguPhonePushMarkExample.Criteria andDeviceTokenEqualTo(String value) {
            return equalTo(deviceToken, value);
        }

        public ShiguPhonePushMarkExample.Criteria andDeviceTokenNotEqualTo(String value) {
            return notEqualTo(deviceToken, value);
        }

        public ShiguPhonePushMarkExample.Criteria andDeviceTokenGreaterThan(String value) {
            return greaterThan(deviceToken, value);
        }

        public ShiguPhonePushMarkExample.Criteria andDeviceTokenGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(deviceToken, value);
        }

        public ShiguPhonePushMarkExample.Criteria andDeviceTokenLessThan(String value) {
            return lessThan(deviceToken, value);
        }

        public ShiguPhonePushMarkExample.Criteria andDeviceTokenLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(deviceToken, value);
        }

        public ShiguPhonePushMarkExample.Criteria andDeviceTokenLike(String value) {
            return like(deviceToken, value);
        }

        public ShiguPhonePushMarkExample.Criteria andDeviceTokenNotLike(String value) {
            return notLike(deviceToken, value);
        }

        public ShiguPhonePushMarkExample.Criteria andDeviceTokenIn(List<String> values) {
            return in(deviceToken, values);
        }

        public ShiguPhonePushMarkExample.Criteria andDeviceTokenNotIn(List<String> values) {
            return notIn(deviceToken, values);
        }

        public ShiguPhonePushMarkExample.Criteria andDeviceTokenBetween(String value1, String value2) {
            return between(deviceToken, value1, value2);
        }

        public ShiguPhonePushMarkExample.Criteria andDeviceTokenNotBetween(String value1, String value2) {
            return notBetween(deviceToken, value1, value2);
        }
    }
}