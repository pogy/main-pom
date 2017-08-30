package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ActiveDrawRecord;

import java.util.*;
public class ActiveDrawRecordExample extends SgExample<ActiveDrawRecordExample.Criteria> {
    public static final Class<ActiveDrawRecord> beanClass = ActiveDrawRecord.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn drawStatus;
    public static EntityColumn pemId;
    public static EntityColumn ward;
    public static EntityColumn userId;
    public static EntityColumn enabled;
    public static EntityColumn modifyTime;
    public static EntityColumn createTime;
    public static EntityColumn userNick;
    public static EntityColumn loginPhone;
    public static EntityColumn receivesYes;
    public static EntityColumn id;
    public static EntityColumn drawCode;
    public static EntityColumn refeTime;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        drawStatus = listMap.get("drawStatus");
        pemId = listMap.get("pemId");
        ward = listMap.get("ward");
        userId = listMap.get("userId");
        enabled = listMap.get("enabled");
        modifyTime = listMap.get("modifyTime");
        createTime = listMap.get("createTime");
        userNick = listMap.get("userNick");
        loginPhone = listMap.get("loginPhone");
        receivesYes = listMap.get("receivesYes");
        id = listMap.get("id");
        drawCode = listMap.get("drawCode");
        refeTime = listMap.get("refeTime");
        }

    public ActiveDrawRecordExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ActiveDrawRecordExample.Criteria createCriteriaInternal() {
        return new ActiveDrawRecordExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusIsNull() {
            return isNull(drawStatus);
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusIsNotNull() {
            return isNotNull(drawStatus);
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusEqualTo(Integer value) {
            return equalTo(drawStatus, value);
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusNotEqualTo(Integer value) {
            return notEqualTo(drawStatus, value);
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusGreaterThan(Integer value) {
            return greaterThan(drawStatus, value);
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(drawStatus, value);
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusLessThan(Integer value) {
            return lessThan(drawStatus, value);
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(drawStatus, value);
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusIn(List<Integer> values) {
            return in(drawStatus, values);
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusNotIn(List<Integer> values) {
            return notIn(drawStatus, values);
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusBetween(Integer value1, Integer value2) {
            return between(drawStatus, value1, value2);
        }

        public ActiveDrawRecordExample.Criteria andDrawStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(drawStatus, value1, value2);
        }
        public ActiveDrawRecordExample.Criteria andPemIdIsNull() {
            return isNull(pemId);
        }

        public ActiveDrawRecordExample.Criteria andPemIdIsNotNull() {
            return isNotNull(pemId);
        }

        public ActiveDrawRecordExample.Criteria andPemIdEqualTo(Long value) {
            return equalTo(pemId, value);
        }

        public ActiveDrawRecordExample.Criteria andPemIdNotEqualTo(Long value) {
            return notEqualTo(pemId, value);
        }

        public ActiveDrawRecordExample.Criteria andPemIdGreaterThan(Long value) {
            return greaterThan(pemId, value);
        }

        public ActiveDrawRecordExample.Criteria andPemIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(pemId, value);
        }

        public ActiveDrawRecordExample.Criteria andPemIdLessThan(Long value) {
            return lessThan(pemId, value);
        }

        public ActiveDrawRecordExample.Criteria andPemIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(pemId, value);
        }

        public ActiveDrawRecordExample.Criteria andPemIdIn(List<Long> values) {
            return in(pemId, values);
        }

        public ActiveDrawRecordExample.Criteria andPemIdNotIn(List<Long> values) {
            return notIn(pemId, values);
        }

        public ActiveDrawRecordExample.Criteria andPemIdBetween(Long value1, Long value2) {
            return between(pemId, value1, value2);
        }

        public ActiveDrawRecordExample.Criteria andPemIdNotBetween(Long value1, Long value2) {
            return notBetween(pemId, value1, value2);
        }
        public ActiveDrawRecordExample.Criteria andWardIsNull() {
            return isNull(ward);
        }

        public ActiveDrawRecordExample.Criteria andWardIsNotNull() {
            return isNotNull(ward);
        }

        public ActiveDrawRecordExample.Criteria andWardEqualTo(String value) {
            return equalTo(ward, value);
        }

        public ActiveDrawRecordExample.Criteria andWardNotEqualTo(String value) {
            return notEqualTo(ward, value);
        }

        public ActiveDrawRecordExample.Criteria andWardGreaterThan(String value) {
            return greaterThan(ward, value);
        }

        public ActiveDrawRecordExample.Criteria andWardGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(ward, value);
        }

        public ActiveDrawRecordExample.Criteria andWardLessThan(String value) {
            return lessThan(ward, value);
        }

        public ActiveDrawRecordExample.Criteria andWardLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(ward, value);
        }

        public ActiveDrawRecordExample.Criteria andWardLike(String value) {
            return like(ward, value);
        }

        public ActiveDrawRecordExample.Criteria andWardNotLike(String value) {
            return notLike(ward, value);
        }

        public ActiveDrawRecordExample.Criteria andWardIn(List<String> values) {
            return in(ward, values);
        }

        public ActiveDrawRecordExample.Criteria andWardNotIn(List<String> values) {
            return notIn(ward, values);
        }

        public ActiveDrawRecordExample.Criteria andWardBetween(String value1, String value2) {
            return between(ward, value1, value2);
        }

        public ActiveDrawRecordExample.Criteria andWardNotBetween(String value1, String value2) {
            return notBetween(ward, value1, value2);
        }
        public ActiveDrawRecordExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public ActiveDrawRecordExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public ActiveDrawRecordExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public ActiveDrawRecordExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public ActiveDrawRecordExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public ActiveDrawRecordExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public ActiveDrawRecordExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public ActiveDrawRecordExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public ActiveDrawRecordExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public ActiveDrawRecordExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public ActiveDrawRecordExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public ActiveDrawRecordExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public ActiveDrawRecordExample.Criteria andEnabledIsNull() {
            return isNull(enabled);
        }

        public ActiveDrawRecordExample.Criteria andEnabledIsNotNull() {
            return isNotNull(enabled);
        }

        public ActiveDrawRecordExample.Criteria andEnabledEqualTo(Boolean value) {
            return equalTo(enabled, value);
        }

        public ActiveDrawRecordExample.Criteria andEnabledNotEqualTo(Boolean value) {
            return notEqualTo(enabled, value);
        }

        public ActiveDrawRecordExample.Criteria andEnabledGreaterThan(Boolean value) {
            return greaterThan(enabled, value);
        }

        public ActiveDrawRecordExample.Criteria andEnabledGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(enabled, value);
        }

        public ActiveDrawRecordExample.Criteria andEnabledLessThan(Boolean value) {
            return lessThan(enabled, value);
        }

        public ActiveDrawRecordExample.Criteria andEnabledLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(enabled, value);
        }

        public ActiveDrawRecordExample.Criteria andEnabledIn(List<Boolean> values) {
            return in(enabled, values);
        }

        public ActiveDrawRecordExample.Criteria andEnabledNotIn(List<Boolean> values) {
            return notIn(enabled, values);
        }

        public ActiveDrawRecordExample.Criteria andEnabledBetween(Boolean value1, Boolean value2) {
            return between(enabled, value1, value2);
        }

        public ActiveDrawRecordExample.Criteria andEnabledNotBetween(Boolean value1, Boolean value2) {
            return notBetween(enabled, value1, value2);
        }
        public ActiveDrawRecordExample.Criteria andModifyTimeIsNull() {
            return isNull(modifyTime);
        }

        public ActiveDrawRecordExample.Criteria andModifyTimeIsNotNull() {
            return isNotNull(modifyTime);
        }

        public ActiveDrawRecordExample.Criteria andModifyTimeEqualTo(Date value) {
            return equalTo(modifyTime, value);
        }

        public ActiveDrawRecordExample.Criteria andModifyTimeNotEqualTo(Date value) {
            return notEqualTo(modifyTime, value);
        }

        public ActiveDrawRecordExample.Criteria andModifyTimeGreaterThan(Date value) {
            return greaterThan(modifyTime, value);
        }

        public ActiveDrawRecordExample.Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(modifyTime, value);
        }

        public ActiveDrawRecordExample.Criteria andModifyTimeLessThan(Date value) {
            return lessThan(modifyTime, value);
        }

        public ActiveDrawRecordExample.Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(modifyTime, value);
        }

        public ActiveDrawRecordExample.Criteria andModifyTimeIn(List<Date> values) {
            return in(modifyTime, values);
        }

        public ActiveDrawRecordExample.Criteria andModifyTimeNotIn(List<Date> values) {
            return notIn(modifyTime, values);
        }

        public ActiveDrawRecordExample.Criteria andModifyTimeBetween(Date value1, Date value2) {
            return between(modifyTime, value1, value2);
        }

        public ActiveDrawRecordExample.Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            return notBetween(modifyTime, value1, value2);
        }
        public ActiveDrawRecordExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public ActiveDrawRecordExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public ActiveDrawRecordExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public ActiveDrawRecordExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public ActiveDrawRecordExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public ActiveDrawRecordExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public ActiveDrawRecordExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public ActiveDrawRecordExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public ActiveDrawRecordExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public ActiveDrawRecordExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public ActiveDrawRecordExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public ActiveDrawRecordExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public ActiveDrawRecordExample.Criteria andUserNickIsNull() {
            return isNull(userNick);
        }

        public ActiveDrawRecordExample.Criteria andUserNickIsNotNull() {
            return isNotNull(userNick);
        }

        public ActiveDrawRecordExample.Criteria andUserNickEqualTo(String value) {
            return equalTo(userNick, value);
        }

        public ActiveDrawRecordExample.Criteria andUserNickNotEqualTo(String value) {
            return notEqualTo(userNick, value);
        }

        public ActiveDrawRecordExample.Criteria andUserNickGreaterThan(String value) {
            return greaterThan(userNick, value);
        }

        public ActiveDrawRecordExample.Criteria andUserNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(userNick, value);
        }

        public ActiveDrawRecordExample.Criteria andUserNickLessThan(String value) {
            return lessThan(userNick, value);
        }

        public ActiveDrawRecordExample.Criteria andUserNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(userNick, value);
        }

        public ActiveDrawRecordExample.Criteria andUserNickLike(String value) {
            return like(userNick, value);
        }

        public ActiveDrawRecordExample.Criteria andUserNickNotLike(String value) {
            return notLike(userNick, value);
        }

        public ActiveDrawRecordExample.Criteria andUserNickIn(List<String> values) {
            return in(userNick, values);
        }

        public ActiveDrawRecordExample.Criteria andUserNickNotIn(List<String> values) {
            return notIn(userNick, values);
        }

        public ActiveDrawRecordExample.Criteria andUserNickBetween(String value1, String value2) {
            return between(userNick, value1, value2);
        }

        public ActiveDrawRecordExample.Criteria andUserNickNotBetween(String value1, String value2) {
            return notBetween(userNick, value1, value2);
        }
        public ActiveDrawRecordExample.Criteria andLoginPhoneIsNull() {
            return isNull(loginPhone);
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneIsNotNull() {
            return isNotNull(loginPhone);
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneEqualTo(String value) {
            return equalTo(loginPhone, value);
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneNotEqualTo(String value) {
            return notEqualTo(loginPhone, value);
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneGreaterThan(String value) {
            return greaterThan(loginPhone, value);
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(loginPhone, value);
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneLessThan(String value) {
            return lessThan(loginPhone, value);
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(loginPhone, value);
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneLike(String value) {
            return like(loginPhone, value);
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneNotLike(String value) {
            return notLike(loginPhone, value);
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneIn(List<String> values) {
            return in(loginPhone, values);
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneNotIn(List<String> values) {
            return notIn(loginPhone, values);
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneBetween(String value1, String value2) {
            return between(loginPhone, value1, value2);
        }

        public ActiveDrawRecordExample.Criteria andLoginPhoneNotBetween(String value1, String value2) {
            return notBetween(loginPhone, value1, value2);
        }
        public ActiveDrawRecordExample.Criteria andReceivesYesIsNull() {
            return isNull(receivesYes);
        }

        public ActiveDrawRecordExample.Criteria andReceivesYesIsNotNull() {
            return isNotNull(receivesYes);
        }

        public ActiveDrawRecordExample.Criteria andReceivesYesEqualTo(Boolean value) {
            return equalTo(receivesYes, value);
        }

        public ActiveDrawRecordExample.Criteria andReceivesYesNotEqualTo(Boolean value) {
            return notEqualTo(receivesYes, value);
        }

        public ActiveDrawRecordExample.Criteria andReceivesYesGreaterThan(Boolean value) {
            return greaterThan(receivesYes, value);
        }

        public ActiveDrawRecordExample.Criteria andReceivesYesGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(receivesYes, value);
        }

        public ActiveDrawRecordExample.Criteria andReceivesYesLessThan(Boolean value) {
            return lessThan(receivesYes, value);
        }

        public ActiveDrawRecordExample.Criteria andReceivesYesLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(receivesYes, value);
        }

        public ActiveDrawRecordExample.Criteria andReceivesYesIn(List<Boolean> values) {
            return in(receivesYes, values);
        }

        public ActiveDrawRecordExample.Criteria andReceivesYesNotIn(List<Boolean> values) {
            return notIn(receivesYes, values);
        }

        public ActiveDrawRecordExample.Criteria andReceivesYesBetween(Boolean value1, Boolean value2) {
            return between(receivesYes, value1, value2);
        }

        public ActiveDrawRecordExample.Criteria andReceivesYesNotBetween(Boolean value1, Boolean value2) {
            return notBetween(receivesYes, value1, value2);
        }
        public ActiveDrawRecordExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ActiveDrawRecordExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ActiveDrawRecordExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public ActiveDrawRecordExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public ActiveDrawRecordExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public ActiveDrawRecordExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ActiveDrawRecordExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public ActiveDrawRecordExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public ActiveDrawRecordExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public ActiveDrawRecordExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public ActiveDrawRecordExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public ActiveDrawRecordExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public ActiveDrawRecordExample.Criteria andDrawCodeIsNull() {
            return isNull(drawCode);
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeIsNotNull() {
            return isNotNull(drawCode);
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeEqualTo(String value) {
            return equalTo(drawCode, value);
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeNotEqualTo(String value) {
            return notEqualTo(drawCode, value);
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeGreaterThan(String value) {
            return greaterThan(drawCode, value);
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(drawCode, value);
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeLessThan(String value) {
            return lessThan(drawCode, value);
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(drawCode, value);
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeLike(String value) {
            return like(drawCode, value);
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeNotLike(String value) {
            return notLike(drawCode, value);
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeIn(List<String> values) {
            return in(drawCode, values);
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeNotIn(List<String> values) {
            return notIn(drawCode, values);
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeBetween(String value1, String value2) {
            return between(drawCode, value1, value2);
        }

        public ActiveDrawRecordExample.Criteria andDrawCodeNotBetween(String value1, String value2) {
            return notBetween(drawCode, value1, value2);
        }
        public ActiveDrawRecordExample.Criteria andRefeTimeIsNull() {
            return isNull(refeTime);
        }

        public ActiveDrawRecordExample.Criteria andRefeTimeIsNotNull() {
            return isNotNull(refeTime);
        }

        public ActiveDrawRecordExample.Criteria andRefeTimeEqualTo(Date value) {
            return equalTo(refeTime, value);
        }

        public ActiveDrawRecordExample.Criteria andRefeTimeNotEqualTo(Date value) {
            return notEqualTo(refeTime, value);
        }

        public ActiveDrawRecordExample.Criteria andRefeTimeGreaterThan(Date value) {
            return greaterThan(refeTime, value);
        }

        public ActiveDrawRecordExample.Criteria andRefeTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(refeTime, value);
        }

        public ActiveDrawRecordExample.Criteria andRefeTimeLessThan(Date value) {
            return lessThan(refeTime, value);
        }

        public ActiveDrawRecordExample.Criteria andRefeTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(refeTime, value);
        }

        public ActiveDrawRecordExample.Criteria andRefeTimeIn(List<Date> values) {
            return in(refeTime, values);
        }

        public ActiveDrawRecordExample.Criteria andRefeTimeNotIn(List<Date> values) {
            return notIn(refeTime, values);
        }

        public ActiveDrawRecordExample.Criteria andRefeTimeBetween(Date value1, Date value2) {
            return between(refeTime, value1, value2);
        }

        public ActiveDrawRecordExample.Criteria andRefeTimeNotBetween(Date value1, Date value2) {
            return notBetween(refeTime, value1, value2);
        }
    }
}
