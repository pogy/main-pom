package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguBonusRecord;

import java.util.*;
public class ShiguBonusRecordExample extends SgExample<ShiguBonusRecordExample.Criteria> {
    public static final Class<ShiguBonusRecord> beanClass = ShiguBonusRecord.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn amount;
    public static EntityColumn serialNumber;
    public static EntityColumn tab;
    public static EntityColumn thirdId;
    public static EntityColumn createTime;
    public static EntityColumn fromUserId;
    public static EntityColumn updateTime;
    public static EntityColumn id;
    public static EntityColumn type;
    public static EntityColumn toUserId;
    public static EntityColumn status;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        amount = listMap.get("amount");
        serialNumber = listMap.get("serialNumber");
        tab = listMap.get("tab");
        thirdId = listMap.get("thirdId");
        createTime = listMap.get("createTime");
        fromUserId = listMap.get("fromUserId");
        updateTime = listMap.get("updateTime");
        id = listMap.get("id");
        type = listMap.get("type");
        toUserId = listMap.get("toUserId");
        status = listMap.get("status");
        }

    public ShiguBonusRecordExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguBonusRecordExample.Criteria createCriteriaInternal() {
        return new ShiguBonusRecordExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguBonusRecordExample.Criteria andAmountIsNull() {
            return isNull(amount);
        }

        public ShiguBonusRecordExample.Criteria andAmountIsNotNull() {
            return isNotNull(amount);
        }

        public ShiguBonusRecordExample.Criteria andAmountEqualTo(Long value) {
            return equalTo(amount, value);
        }

        public ShiguBonusRecordExample.Criteria andAmountNotEqualTo(Long value) {
            return notEqualTo(amount, value);
        }

        public ShiguBonusRecordExample.Criteria andAmountGreaterThan(Long value) {
            return greaterThan(amount, value);
        }

        public ShiguBonusRecordExample.Criteria andAmountGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(amount, value);
        }

        public ShiguBonusRecordExample.Criteria andAmountLessThan(Long value) {
            return lessThan(amount, value);
        }

        public ShiguBonusRecordExample.Criteria andAmountLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(amount, value);
        }

        public ShiguBonusRecordExample.Criteria andAmountIn(List<Long> values) {
            return in(amount, values);
        }

        public ShiguBonusRecordExample.Criteria andAmountNotIn(List<Long> values) {
            return notIn(amount, values);
        }

        public ShiguBonusRecordExample.Criteria andAmountBetween(Long value1, Long value2) {
            return between(amount, value1, value2);
        }

        public ShiguBonusRecordExample.Criteria andAmountNotBetween(Long value1, Long value2) {
            return notBetween(amount, value1, value2);
        }
        public ShiguBonusRecordExample.Criteria andSerialNumberIsNull() {
            return isNull(serialNumber);
        }

        public ShiguBonusRecordExample.Criteria andSerialNumberIsNotNull() {
            return isNotNull(serialNumber);
        }

        public ShiguBonusRecordExample.Criteria andSerialNumberEqualTo(String value) {
            return equalTo(serialNumber, value);
        }

        public ShiguBonusRecordExample.Criteria andSerialNumberNotEqualTo(String value) {
            return notEqualTo(serialNumber, value);
        }

        public ShiguBonusRecordExample.Criteria andSerialNumberGreaterThan(String value) {
            return greaterThan(serialNumber, value);
        }

        public ShiguBonusRecordExample.Criteria andSerialNumberGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(serialNumber, value);
        }

        public ShiguBonusRecordExample.Criteria andSerialNumberLessThan(String value) {
            return lessThan(serialNumber, value);
        }

        public ShiguBonusRecordExample.Criteria andSerialNumberLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(serialNumber, value);
        }

        public ShiguBonusRecordExample.Criteria andSerialNumberLike(String value) {
            return like(serialNumber, value);
        }

        public ShiguBonusRecordExample.Criteria andSerialNumberNotLike(String value) {
            return notLike(serialNumber, value);
        }

        public ShiguBonusRecordExample.Criteria andSerialNumberIn(List<String> values) {
            return in(serialNumber, values);
        }

        public ShiguBonusRecordExample.Criteria andSerialNumberNotIn(List<String> values) {
            return notIn(serialNumber, values);
        }

        public ShiguBonusRecordExample.Criteria andSerialNumberBetween(String value1, String value2) {
            return between(serialNumber, value1, value2);
        }

        public ShiguBonusRecordExample.Criteria andSerialNumberNotBetween(String value1, String value2) {
            return notBetween(serialNumber, value1, value2);
        }
        public ShiguBonusRecordExample.Criteria andTabIsNull() {
            return isNull(tab);
        }

        public ShiguBonusRecordExample.Criteria andTabIsNotNull() {
            return isNotNull(tab);
        }

        public ShiguBonusRecordExample.Criteria andTabEqualTo(Integer value) {
            return equalTo(tab, value);
        }

        public ShiguBonusRecordExample.Criteria andTabNotEqualTo(Integer value) {
            return notEqualTo(tab, value);
        }

        public ShiguBonusRecordExample.Criteria andTabGreaterThan(Integer value) {
            return greaterThan(tab, value);
        }

        public ShiguBonusRecordExample.Criteria andTabGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(tab, value);
        }

        public ShiguBonusRecordExample.Criteria andTabLessThan(Integer value) {
            return lessThan(tab, value);
        }

        public ShiguBonusRecordExample.Criteria andTabLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(tab, value);
        }

        public ShiguBonusRecordExample.Criteria andTabIn(List<Integer> values) {
            return in(tab, values);
        }

        public ShiguBonusRecordExample.Criteria andTabNotIn(List<Integer> values) {
            return notIn(tab, values);
        }

        public ShiguBonusRecordExample.Criteria andTabBetween(Integer value1, Integer value2) {
            return between(tab, value1, value2);
        }

        public ShiguBonusRecordExample.Criteria andTabNotBetween(Integer value1, Integer value2) {
            return notBetween(tab, value1, value2);
        }
        public ShiguBonusRecordExample.Criteria andThirdIdIsNull() {
            return isNull(thirdId);
        }

        public ShiguBonusRecordExample.Criteria andThirdIdIsNotNull() {
            return isNotNull(thirdId);
        }

        public ShiguBonusRecordExample.Criteria andThirdIdEqualTo(String value) {
            return equalTo(thirdId, value);
        }

        public ShiguBonusRecordExample.Criteria andThirdIdNotEqualTo(String value) {
            return notEqualTo(thirdId, value);
        }

        public ShiguBonusRecordExample.Criteria andThirdIdGreaterThan(String value) {
            return greaterThan(thirdId, value);
        }

        public ShiguBonusRecordExample.Criteria andThirdIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(thirdId, value);
        }

        public ShiguBonusRecordExample.Criteria andThirdIdLessThan(String value) {
            return lessThan(thirdId, value);
        }

        public ShiguBonusRecordExample.Criteria andThirdIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(thirdId, value);
        }

        public ShiguBonusRecordExample.Criteria andThirdIdLike(String value) {
            return like(thirdId, value);
        }

        public ShiguBonusRecordExample.Criteria andThirdIdNotLike(String value) {
            return notLike(thirdId, value);
        }

        public ShiguBonusRecordExample.Criteria andThirdIdIn(List<String> values) {
            return in(thirdId, values);
        }

        public ShiguBonusRecordExample.Criteria andThirdIdNotIn(List<String> values) {
            return notIn(thirdId, values);
        }

        public ShiguBonusRecordExample.Criteria andThirdIdBetween(String value1, String value2) {
            return between(thirdId, value1, value2);
        }

        public ShiguBonusRecordExample.Criteria andThirdIdNotBetween(String value1, String value2) {
            return notBetween(thirdId, value1, value2);
        }
        public ShiguBonusRecordExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public ShiguBonusRecordExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public ShiguBonusRecordExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public ShiguBonusRecordExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public ShiguBonusRecordExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public ShiguBonusRecordExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public ShiguBonusRecordExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public ShiguBonusRecordExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public ShiguBonusRecordExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public ShiguBonusRecordExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public ShiguBonusRecordExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public ShiguBonusRecordExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public ShiguBonusRecordExample.Criteria andFromUserIdIsNull() {
            return isNull(fromUserId);
        }

        public ShiguBonusRecordExample.Criteria andFromUserIdIsNotNull() {
            return isNotNull(fromUserId);
        }

        public ShiguBonusRecordExample.Criteria andFromUserIdEqualTo(Long value) {
            return equalTo(fromUserId, value);
        }

        public ShiguBonusRecordExample.Criteria andFromUserIdNotEqualTo(Long value) {
            return notEqualTo(fromUserId, value);
        }

        public ShiguBonusRecordExample.Criteria andFromUserIdGreaterThan(Long value) {
            return greaterThan(fromUserId, value);
        }

        public ShiguBonusRecordExample.Criteria andFromUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(fromUserId, value);
        }

        public ShiguBonusRecordExample.Criteria andFromUserIdLessThan(Long value) {
            return lessThan(fromUserId, value);
        }

        public ShiguBonusRecordExample.Criteria andFromUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(fromUserId, value);
        }

        public ShiguBonusRecordExample.Criteria andFromUserIdIn(List<Long> values) {
            return in(fromUserId, values);
        }

        public ShiguBonusRecordExample.Criteria andFromUserIdNotIn(List<Long> values) {
            return notIn(fromUserId, values);
        }

        public ShiguBonusRecordExample.Criteria andFromUserIdBetween(Long value1, Long value2) {
            return between(fromUserId, value1, value2);
        }

        public ShiguBonusRecordExample.Criteria andFromUserIdNotBetween(Long value1, Long value2) {
            return notBetween(fromUserId, value1, value2);
        }
        public ShiguBonusRecordExample.Criteria andUpdateTimeIsNull() {
            return isNull(updateTime);
        }

        public ShiguBonusRecordExample.Criteria andUpdateTimeIsNotNull() {
            return isNotNull(updateTime);
        }

        public ShiguBonusRecordExample.Criteria andUpdateTimeEqualTo(Date value) {
            return equalTo(updateTime, value);
        }

        public ShiguBonusRecordExample.Criteria andUpdateTimeNotEqualTo(Date value) {
            return notEqualTo(updateTime, value);
        }

        public ShiguBonusRecordExample.Criteria andUpdateTimeGreaterThan(Date value) {
            return greaterThan(updateTime, value);
        }

        public ShiguBonusRecordExample.Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(updateTime, value);
        }

        public ShiguBonusRecordExample.Criteria andUpdateTimeLessThan(Date value) {
            return lessThan(updateTime, value);
        }

        public ShiguBonusRecordExample.Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(updateTime, value);
        }

        public ShiguBonusRecordExample.Criteria andUpdateTimeIn(List<Date> values) {
            return in(updateTime, values);
        }

        public ShiguBonusRecordExample.Criteria andUpdateTimeNotIn(List<Date> values) {
            return notIn(updateTime, values);
        }

        public ShiguBonusRecordExample.Criteria andUpdateTimeBetween(Date value1, Date value2) {
            return between(updateTime, value1, value2);
        }

        public ShiguBonusRecordExample.Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            return notBetween(updateTime, value1, value2);
        }
        public ShiguBonusRecordExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ShiguBonusRecordExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ShiguBonusRecordExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public ShiguBonusRecordExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public ShiguBonusRecordExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public ShiguBonusRecordExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ShiguBonusRecordExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public ShiguBonusRecordExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public ShiguBonusRecordExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public ShiguBonusRecordExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public ShiguBonusRecordExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public ShiguBonusRecordExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public ShiguBonusRecordExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public ShiguBonusRecordExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public ShiguBonusRecordExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public ShiguBonusRecordExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public ShiguBonusRecordExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public ShiguBonusRecordExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public ShiguBonusRecordExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public ShiguBonusRecordExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public ShiguBonusRecordExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public ShiguBonusRecordExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public ShiguBonusRecordExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public ShiguBonusRecordExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
        public ShiguBonusRecordExample.Criteria andToUserIdIsNull() {
            return isNull(toUserId);
        }

        public ShiguBonusRecordExample.Criteria andToUserIdIsNotNull() {
            return isNotNull(toUserId);
        }

        public ShiguBonusRecordExample.Criteria andToUserIdEqualTo(Long value) {
            return equalTo(toUserId, value);
        }

        public ShiguBonusRecordExample.Criteria andToUserIdNotEqualTo(Long value) {
            return notEqualTo(toUserId, value);
        }

        public ShiguBonusRecordExample.Criteria andToUserIdGreaterThan(Long value) {
            return greaterThan(toUserId, value);
        }

        public ShiguBonusRecordExample.Criteria andToUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(toUserId, value);
        }

        public ShiguBonusRecordExample.Criteria andToUserIdLessThan(Long value) {
            return lessThan(toUserId, value);
        }

        public ShiguBonusRecordExample.Criteria andToUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(toUserId, value);
        }

        public ShiguBonusRecordExample.Criteria andToUserIdIn(List<Long> values) {
            return in(toUserId, values);
        }

        public ShiguBonusRecordExample.Criteria andToUserIdNotIn(List<Long> values) {
            return notIn(toUserId, values);
        }

        public ShiguBonusRecordExample.Criteria andToUserIdBetween(Long value1, Long value2) {
            return between(toUserId, value1, value2);
        }

        public ShiguBonusRecordExample.Criteria andToUserIdNotBetween(Long value1, Long value2) {
            return notBetween(toUserId, value1, value2);
        }
        public ShiguBonusRecordExample.Criteria andStatusIsNull() {
            return isNull(status);
        }

        public ShiguBonusRecordExample.Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public ShiguBonusRecordExample.Criteria andStatusEqualTo(Integer value) {
            return equalTo(status, value);
        }

        public ShiguBonusRecordExample.Criteria andStatusNotEqualTo(Integer value) {
            return notEqualTo(status, value);
        }

        public ShiguBonusRecordExample.Criteria andStatusGreaterThan(Integer value) {
            return greaterThan(status, value);
        }

        public ShiguBonusRecordExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(status, value);
        }

        public ShiguBonusRecordExample.Criteria andStatusLessThan(Integer value) {
            return lessThan(status, value);
        }

        public ShiguBonusRecordExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(status, value);
        }

        public ShiguBonusRecordExample.Criteria andStatusIn(List<Integer> values) {
            return in(status, values);
        }

        public ShiguBonusRecordExample.Criteria andStatusNotIn(List<Integer> values) {
            return notIn(status, values);
        }

        public ShiguBonusRecordExample.Criteria andStatusBetween(Integer value1, Integer value2) {
            return between(status, value1, value2);
        }

        public ShiguBonusRecordExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(status, value1, value2);
        }
    }
}