package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.GoatItemData;

import java.util.*;
public class GoatItemDataExample extends SgExample<GoatItemDataExample.Criteria> {
    public static final Class<GoatItemData> beanClass = GoatItemData.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn dataId;
    public static EntityColumn fromTime;
    public static EntityColumn context;
    public static EntityColumn lastPublishTime;
    public static EntityColumn goatId;
    public static EntityColumn userId;
    public static EntityColumn toTime;
    public static EntityColumn status;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        dataId = listMap.get("dataId");
        fromTime = listMap.get("fromTime");
        context = listMap.get("context");
        lastPublishTime = listMap.get("lastPublishTime");
        goatId = listMap.get("goatId");
        userId = listMap.get("userId");
        toTime = listMap.get("toTime");
        status = listMap.get("status");
        }

    public GoatItemDataExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected GoatItemDataExample.Criteria createCriteriaInternal() {
        return new GoatItemDataExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public GoatItemDataExample.Criteria andDataIdIsNull() {
            return isNull(dataId);
        }

        public GoatItemDataExample.Criteria andDataIdIsNotNull() {
            return isNotNull(dataId);
        }

        public GoatItemDataExample.Criteria andDataIdEqualTo(Long value) {
            return equalTo(dataId, value);
        }

        public GoatItemDataExample.Criteria andDataIdNotEqualTo(Long value) {
            return notEqualTo(dataId, value);
        }

        public GoatItemDataExample.Criteria andDataIdGreaterThan(Long value) {
            return greaterThan(dataId, value);
        }

        public GoatItemDataExample.Criteria andDataIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dataId, value);
        }

        public GoatItemDataExample.Criteria andDataIdLessThan(Long value) {
            return lessThan(dataId, value);
        }

        public GoatItemDataExample.Criteria andDataIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dataId, value);
        }

        public GoatItemDataExample.Criteria andDataIdIn(List<Long> values) {
            return in(dataId, values);
        }

        public GoatItemDataExample.Criteria andDataIdNotIn(List<Long> values) {
            return notIn(dataId, values);
        }

        public GoatItemDataExample.Criteria andDataIdBetween(Long value1, Long value2) {
            return between(dataId, value1, value2);
        }

        public GoatItemDataExample.Criteria andDataIdNotBetween(Long value1, Long value2) {
            return notBetween(dataId, value1, value2);
        }
        public GoatItemDataExample.Criteria andFromTimeIsNull() {
            return isNull(fromTime);
        }

        public GoatItemDataExample.Criteria andFromTimeIsNotNull() {
            return isNotNull(fromTime);
        }

        public GoatItemDataExample.Criteria andFromTimeEqualTo(Date value) {
            return equalTo(fromTime, value);
        }

        public GoatItemDataExample.Criteria andFromTimeNotEqualTo(Date value) {
            return notEqualTo(fromTime, value);
        }

        public GoatItemDataExample.Criteria andFromTimeGreaterThan(Date value) {
            return greaterThan(fromTime, value);
        }

        public GoatItemDataExample.Criteria andFromTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(fromTime, value);
        }

        public GoatItemDataExample.Criteria andFromTimeLessThan(Date value) {
            return lessThan(fromTime, value);
        }

        public GoatItemDataExample.Criteria andFromTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(fromTime, value);
        }

        public GoatItemDataExample.Criteria andFromTimeIn(List<Date> values) {
            return in(fromTime, values);
        }

        public GoatItemDataExample.Criteria andFromTimeNotIn(List<Date> values) {
            return notIn(fromTime, values);
        }

        public GoatItemDataExample.Criteria andFromTimeBetween(Date value1, Date value2) {
            return between(fromTime, value1, value2);
        }

        public GoatItemDataExample.Criteria andFromTimeNotBetween(Date value1, Date value2) {
            return notBetween(fromTime, value1, value2);
        }
        public GoatItemDataExample.Criteria andContextIsNull() {
            return isNull(context);
        }

        public GoatItemDataExample.Criteria andContextIsNotNull() {
            return isNotNull(context);
        }

        public GoatItemDataExample.Criteria andContextEqualTo(String value) {
            return equalTo(context, value);
        }

        public GoatItemDataExample.Criteria andContextNotEqualTo(String value) {
            return notEqualTo(context, value);
        }

        public GoatItemDataExample.Criteria andContextGreaterThan(String value) {
            return greaterThan(context, value);
        }

        public GoatItemDataExample.Criteria andContextGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(context, value);
        }

        public GoatItemDataExample.Criteria andContextLessThan(String value) {
            return lessThan(context, value);
        }

        public GoatItemDataExample.Criteria andContextLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(context, value);
        }

        public GoatItemDataExample.Criteria andContextLike(String value) {
            return like(context, value);
        }

        public GoatItemDataExample.Criteria andContextNotLike(String value) {
            return notLike(context, value);
        }

        public GoatItemDataExample.Criteria andContextIn(List<String> values) {
            return in(context, values);
        }

        public GoatItemDataExample.Criteria andContextNotIn(List<String> values) {
            return notIn(context, values);
        }

        public GoatItemDataExample.Criteria andContextBetween(String value1, String value2) {
            return between(context, value1, value2);
        }

        public GoatItemDataExample.Criteria andContextNotBetween(String value1, String value2) {
            return notBetween(context, value1, value2);
        }
        public GoatItemDataExample.Criteria andLastPublishTimeIsNull() {
            return isNull(lastPublishTime);
        }

        public GoatItemDataExample.Criteria andLastPublishTimeIsNotNull() {
            return isNotNull(lastPublishTime);
        }

        public GoatItemDataExample.Criteria andLastPublishTimeEqualTo(Date value) {
            return equalTo(lastPublishTime, value);
        }

        public GoatItemDataExample.Criteria andLastPublishTimeNotEqualTo(Date value) {
            return notEqualTo(lastPublishTime, value);
        }

        public GoatItemDataExample.Criteria andLastPublishTimeGreaterThan(Date value) {
            return greaterThan(lastPublishTime, value);
        }

        public GoatItemDataExample.Criteria andLastPublishTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastPublishTime, value);
        }

        public GoatItemDataExample.Criteria andLastPublishTimeLessThan(Date value) {
            return lessThan(lastPublishTime, value);
        }

        public GoatItemDataExample.Criteria andLastPublishTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastPublishTime, value);
        }

        public GoatItemDataExample.Criteria andLastPublishTimeIn(List<Date> values) {
            return in(lastPublishTime, values);
        }

        public GoatItemDataExample.Criteria andLastPublishTimeNotIn(List<Date> values) {
            return notIn(lastPublishTime, values);
        }

        public GoatItemDataExample.Criteria andLastPublishTimeBetween(Date value1, Date value2) {
            return between(lastPublishTime, value1, value2);
        }

        public GoatItemDataExample.Criteria andLastPublishTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastPublishTime, value1, value2);
        }
        public GoatItemDataExample.Criteria andGoatIdIsNull() {
            return isNull(goatId);
        }

        public GoatItemDataExample.Criteria andGoatIdIsNotNull() {
            return isNotNull(goatId);
        }

        public GoatItemDataExample.Criteria andGoatIdEqualTo(Long value) {
            return equalTo(goatId, value);
        }

        public GoatItemDataExample.Criteria andGoatIdNotEqualTo(Long value) {
            return notEqualTo(goatId, value);
        }

        public GoatItemDataExample.Criteria andGoatIdGreaterThan(Long value) {
            return greaterThan(goatId, value);
        }

        public GoatItemDataExample.Criteria andGoatIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goatId, value);
        }

        public GoatItemDataExample.Criteria andGoatIdLessThan(Long value) {
            return lessThan(goatId, value);
        }

        public GoatItemDataExample.Criteria andGoatIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goatId, value);
        }

        public GoatItemDataExample.Criteria andGoatIdIn(List<Long> values) {
            return in(goatId, values);
        }

        public GoatItemDataExample.Criteria andGoatIdNotIn(List<Long> values) {
            return notIn(goatId, values);
        }

        public GoatItemDataExample.Criteria andGoatIdBetween(Long value1, Long value2) {
            return between(goatId, value1, value2);
        }

        public GoatItemDataExample.Criteria andGoatIdNotBetween(Long value1, Long value2) {
            return notBetween(goatId, value1, value2);
        }
        public GoatItemDataExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public GoatItemDataExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public GoatItemDataExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public GoatItemDataExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public GoatItemDataExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public GoatItemDataExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public GoatItemDataExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public GoatItemDataExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public GoatItemDataExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public GoatItemDataExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public GoatItemDataExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public GoatItemDataExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public GoatItemDataExample.Criteria andToTimeIsNull() {
            return isNull(toTime);
        }

        public GoatItemDataExample.Criteria andToTimeIsNotNull() {
            return isNotNull(toTime);
        }

        public GoatItemDataExample.Criteria andToTimeEqualTo(Date value) {
            return equalTo(toTime, value);
        }

        public GoatItemDataExample.Criteria andToTimeNotEqualTo(Date value) {
            return notEqualTo(toTime, value);
        }

        public GoatItemDataExample.Criteria andToTimeGreaterThan(Date value) {
            return greaterThan(toTime, value);
        }

        public GoatItemDataExample.Criteria andToTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(toTime, value);
        }

        public GoatItemDataExample.Criteria andToTimeLessThan(Date value) {
            return lessThan(toTime, value);
        }

        public GoatItemDataExample.Criteria andToTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(toTime, value);
        }

        public GoatItemDataExample.Criteria andToTimeIn(List<Date> values) {
            return in(toTime, values);
        }

        public GoatItemDataExample.Criteria andToTimeNotIn(List<Date> values) {
            return notIn(toTime, values);
        }

        public GoatItemDataExample.Criteria andToTimeBetween(Date value1, Date value2) {
            return between(toTime, value1, value2);
        }

        public GoatItemDataExample.Criteria andToTimeNotBetween(Date value1, Date value2) {
            return notBetween(toTime, value1, value2);
        }
        public GoatItemDataExample.Criteria andStatusIsNull() {
            return isNull(status);
        }

        public GoatItemDataExample.Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public GoatItemDataExample.Criteria andStatusEqualTo(Integer value) {
            return equalTo(status, value);
        }

        public GoatItemDataExample.Criteria andStatusNotEqualTo(Integer value) {
            return notEqualTo(status, value);
        }

        public GoatItemDataExample.Criteria andStatusGreaterThan(Integer value) {
            return greaterThan(status, value);
        }

        public GoatItemDataExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(status, value);
        }

        public GoatItemDataExample.Criteria andStatusLessThan(Integer value) {
            return lessThan(status, value);
        }

        public GoatItemDataExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(status, value);
        }

        public GoatItemDataExample.Criteria andStatusIn(List<Integer> values) {
            return in(status, values);
        }

        public GoatItemDataExample.Criteria andStatusNotIn(List<Integer> values) {
            return notIn(status, values);
        }

        public GoatItemDataExample.Criteria andStatusBetween(Integer value1, Integer value2) {
            return between(status, value1, value2);
        }

        public GoatItemDataExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(status, value1, value2);
        }
    }
}
