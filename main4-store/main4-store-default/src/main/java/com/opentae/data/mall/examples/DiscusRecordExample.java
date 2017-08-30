package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.DiscusRecord;

import java.util.*;
public class DiscusRecordExample extends SgExample<DiscusRecordExample.Criteria> {
    public static final Class<DiscusRecord> beanClass = DiscusRecord.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn recordId;
    public static EntityColumn msgContext;
    public static EntityColumn doLocation;
    public static EntityColumn createdTime;
    public static EntityColumn scoreNum;
    public static EntityColumn storeId;
    public static EntityColumn title;
    public static EntityColumn userName;
    public static EntityColumn userId;
    public static EntityColumn pics;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        recordId = listMap.get("recordId");
        msgContext = listMap.get("msgContext");
        doLocation = listMap.get("doLocation");
        createdTime = listMap.get("createdTime");
        scoreNum = listMap.get("scoreNum");
        storeId = listMap.get("storeId");
        title = listMap.get("title");
        userName = listMap.get("userName");
        userId = listMap.get("userId");
        pics = listMap.get("pics");
        }

    public DiscusRecordExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DiscusRecordExample.Criteria createCriteriaInternal() {
        return new DiscusRecordExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DiscusRecordExample.Criteria andRecordIdIsNull() {
            return isNull(recordId);
        }

        public DiscusRecordExample.Criteria andRecordIdIsNotNull() {
            return isNotNull(recordId);
        }

        public DiscusRecordExample.Criteria andRecordIdEqualTo(Long value) {
            return equalTo(recordId, value);
        }

        public DiscusRecordExample.Criteria andRecordIdNotEqualTo(Long value) {
            return notEqualTo(recordId, value);
        }

        public DiscusRecordExample.Criteria andRecordIdGreaterThan(Long value) {
            return greaterThan(recordId, value);
        }

        public DiscusRecordExample.Criteria andRecordIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(recordId, value);
        }

        public DiscusRecordExample.Criteria andRecordIdLessThan(Long value) {
            return lessThan(recordId, value);
        }

        public DiscusRecordExample.Criteria andRecordIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(recordId, value);
        }

        public DiscusRecordExample.Criteria andRecordIdIn(List<Long> values) {
            return in(recordId, values);
        }

        public DiscusRecordExample.Criteria andRecordIdNotIn(List<Long> values) {
            return notIn(recordId, values);
        }

        public DiscusRecordExample.Criteria andRecordIdBetween(Long value1, Long value2) {
            return between(recordId, value1, value2);
        }

        public DiscusRecordExample.Criteria andRecordIdNotBetween(Long value1, Long value2) {
            return notBetween(recordId, value1, value2);
        }
        public DiscusRecordExample.Criteria andMsgContextIsNull() {
            return isNull(msgContext);
        }

        public DiscusRecordExample.Criteria andMsgContextIsNotNull() {
            return isNotNull(msgContext);
        }

        public DiscusRecordExample.Criteria andMsgContextEqualTo(String value) {
            return equalTo(msgContext, value);
        }

        public DiscusRecordExample.Criteria andMsgContextNotEqualTo(String value) {
            return notEqualTo(msgContext, value);
        }

        public DiscusRecordExample.Criteria andMsgContextGreaterThan(String value) {
            return greaterThan(msgContext, value);
        }

        public DiscusRecordExample.Criteria andMsgContextGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(msgContext, value);
        }

        public DiscusRecordExample.Criteria andMsgContextLessThan(String value) {
            return lessThan(msgContext, value);
        }

        public DiscusRecordExample.Criteria andMsgContextLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(msgContext, value);
        }

        public DiscusRecordExample.Criteria andMsgContextLike(String value) {
            return like(msgContext, value);
        }

        public DiscusRecordExample.Criteria andMsgContextNotLike(String value) {
            return notLike(msgContext, value);
        }

        public DiscusRecordExample.Criteria andMsgContextIn(List<String> values) {
            return in(msgContext, values);
        }

        public DiscusRecordExample.Criteria andMsgContextNotIn(List<String> values) {
            return notIn(msgContext, values);
        }

        public DiscusRecordExample.Criteria andMsgContextBetween(String value1, String value2) {
            return between(msgContext, value1, value2);
        }

        public DiscusRecordExample.Criteria andMsgContextNotBetween(String value1, String value2) {
            return notBetween(msgContext, value1, value2);
        }
        public DiscusRecordExample.Criteria andDoLocationIsNull() {
            return isNull(doLocation);
        }

        public DiscusRecordExample.Criteria andDoLocationIsNotNull() {
            return isNotNull(doLocation);
        }

        public DiscusRecordExample.Criteria andDoLocationEqualTo(String value) {
            return equalTo(doLocation, value);
        }

        public DiscusRecordExample.Criteria andDoLocationNotEqualTo(String value) {
            return notEqualTo(doLocation, value);
        }

        public DiscusRecordExample.Criteria andDoLocationGreaterThan(String value) {
            return greaterThan(doLocation, value);
        }

        public DiscusRecordExample.Criteria andDoLocationGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(doLocation, value);
        }

        public DiscusRecordExample.Criteria andDoLocationLessThan(String value) {
            return lessThan(doLocation, value);
        }

        public DiscusRecordExample.Criteria andDoLocationLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(doLocation, value);
        }

        public DiscusRecordExample.Criteria andDoLocationLike(String value) {
            return like(doLocation, value);
        }

        public DiscusRecordExample.Criteria andDoLocationNotLike(String value) {
            return notLike(doLocation, value);
        }

        public DiscusRecordExample.Criteria andDoLocationIn(List<String> values) {
            return in(doLocation, values);
        }

        public DiscusRecordExample.Criteria andDoLocationNotIn(List<String> values) {
            return notIn(doLocation, values);
        }

        public DiscusRecordExample.Criteria andDoLocationBetween(String value1, String value2) {
            return between(doLocation, value1, value2);
        }

        public DiscusRecordExample.Criteria andDoLocationNotBetween(String value1, String value2) {
            return notBetween(doLocation, value1, value2);
        }
        public DiscusRecordExample.Criteria andCreatedTimeIsNull() {
            return isNull(createdTime);
        }

        public DiscusRecordExample.Criteria andCreatedTimeIsNotNull() {
            return isNotNull(createdTime);
        }

        public DiscusRecordExample.Criteria andCreatedTimeEqualTo(Date value) {
            return equalTo(createdTime, value);
        }

        public DiscusRecordExample.Criteria andCreatedTimeNotEqualTo(Date value) {
            return notEqualTo(createdTime, value);
        }

        public DiscusRecordExample.Criteria andCreatedTimeGreaterThan(Date value) {
            return greaterThan(createdTime, value);
        }

        public DiscusRecordExample.Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createdTime, value);
        }

        public DiscusRecordExample.Criteria andCreatedTimeLessThan(Date value) {
            return lessThan(createdTime, value);
        }

        public DiscusRecordExample.Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createdTime, value);
        }

        public DiscusRecordExample.Criteria andCreatedTimeIn(List<Date> values) {
            return in(createdTime, values);
        }

        public DiscusRecordExample.Criteria andCreatedTimeNotIn(List<Date> values) {
            return notIn(createdTime, values);
        }

        public DiscusRecordExample.Criteria andCreatedTimeBetween(Date value1, Date value2) {
            return between(createdTime, value1, value2);
        }

        public DiscusRecordExample.Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            return notBetween(createdTime, value1, value2);
        }
        public DiscusRecordExample.Criteria andScoreNumIsNull() {
            return isNull(scoreNum);
        }

        public DiscusRecordExample.Criteria andScoreNumIsNotNull() {
            return isNotNull(scoreNum);
        }

        public DiscusRecordExample.Criteria andScoreNumEqualTo(Integer value) {
            return equalTo(scoreNum, value);
        }

        public DiscusRecordExample.Criteria andScoreNumNotEqualTo(Integer value) {
            return notEqualTo(scoreNum, value);
        }

        public DiscusRecordExample.Criteria andScoreNumGreaterThan(Integer value) {
            return greaterThan(scoreNum, value);
        }

        public DiscusRecordExample.Criteria andScoreNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(scoreNum, value);
        }

        public DiscusRecordExample.Criteria andScoreNumLessThan(Integer value) {
            return lessThan(scoreNum, value);
        }

        public DiscusRecordExample.Criteria andScoreNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(scoreNum, value);
        }

        public DiscusRecordExample.Criteria andScoreNumIn(List<Integer> values) {
            return in(scoreNum, values);
        }

        public DiscusRecordExample.Criteria andScoreNumNotIn(List<Integer> values) {
            return notIn(scoreNum, values);
        }

        public DiscusRecordExample.Criteria andScoreNumBetween(Integer value1, Integer value2) {
            return between(scoreNum, value1, value2);
        }

        public DiscusRecordExample.Criteria andScoreNumNotBetween(Integer value1, Integer value2) {
            return notBetween(scoreNum, value1, value2);
        }
        public DiscusRecordExample.Criteria andStoreIdIsNull() {
            return isNull(storeId);
        }

        public DiscusRecordExample.Criteria andStoreIdIsNotNull() {
            return isNotNull(storeId);
        }

        public DiscusRecordExample.Criteria andStoreIdEqualTo(Long value) {
            return equalTo(storeId, value);
        }

        public DiscusRecordExample.Criteria andStoreIdNotEqualTo(Long value) {
            return notEqualTo(storeId, value);
        }

        public DiscusRecordExample.Criteria andStoreIdGreaterThan(Long value) {
            return greaterThan(storeId, value);
        }

        public DiscusRecordExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeId, value);
        }

        public DiscusRecordExample.Criteria andStoreIdLessThan(Long value) {
            return lessThan(storeId, value);
        }

        public DiscusRecordExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeId, value);
        }

        public DiscusRecordExample.Criteria andStoreIdIn(List<Long> values) {
            return in(storeId, values);
        }

        public DiscusRecordExample.Criteria andStoreIdNotIn(List<Long> values) {
            return notIn(storeId, values);
        }

        public DiscusRecordExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            return between(storeId, value1, value2);
        }

        public DiscusRecordExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            return notBetween(storeId, value1, value2);
        }
        public DiscusRecordExample.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public DiscusRecordExample.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public DiscusRecordExample.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public DiscusRecordExample.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public DiscusRecordExample.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public DiscusRecordExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public DiscusRecordExample.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public DiscusRecordExample.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public DiscusRecordExample.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public DiscusRecordExample.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public DiscusRecordExample.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public DiscusRecordExample.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public DiscusRecordExample.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public DiscusRecordExample.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public DiscusRecordExample.Criteria andUserNameIsNull() {
            return isNull(userName);
        }

        public DiscusRecordExample.Criteria andUserNameIsNotNull() {
            return isNotNull(userName);
        }

        public DiscusRecordExample.Criteria andUserNameEqualTo(String value) {
            return equalTo(userName, value);
        }

        public DiscusRecordExample.Criteria andUserNameNotEqualTo(String value) {
            return notEqualTo(userName, value);
        }

        public DiscusRecordExample.Criteria andUserNameGreaterThan(String value) {
            return greaterThan(userName, value);
        }

        public DiscusRecordExample.Criteria andUserNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(userName, value);
        }

        public DiscusRecordExample.Criteria andUserNameLessThan(String value) {
            return lessThan(userName, value);
        }

        public DiscusRecordExample.Criteria andUserNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(userName, value);
        }

        public DiscusRecordExample.Criteria andUserNameLike(String value) {
            return like(userName, value);
        }

        public DiscusRecordExample.Criteria andUserNameNotLike(String value) {
            return notLike(userName, value);
        }

        public DiscusRecordExample.Criteria andUserNameIn(List<String> values) {
            return in(userName, values);
        }

        public DiscusRecordExample.Criteria andUserNameNotIn(List<String> values) {
            return notIn(userName, values);
        }

        public DiscusRecordExample.Criteria andUserNameBetween(String value1, String value2) {
            return between(userName, value1, value2);
        }

        public DiscusRecordExample.Criteria andUserNameNotBetween(String value1, String value2) {
            return notBetween(userName, value1, value2);
        }
        public DiscusRecordExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public DiscusRecordExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public DiscusRecordExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public DiscusRecordExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public DiscusRecordExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public DiscusRecordExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public DiscusRecordExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public DiscusRecordExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public DiscusRecordExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public DiscusRecordExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public DiscusRecordExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public DiscusRecordExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public DiscusRecordExample.Criteria andPicsIsNull() {
            return isNull(pics);
        }

        public DiscusRecordExample.Criteria andPicsIsNotNull() {
            return isNotNull(pics);
        }

        public DiscusRecordExample.Criteria andPicsEqualTo(String value) {
            return equalTo(pics, value);
        }

        public DiscusRecordExample.Criteria andPicsNotEqualTo(String value) {
            return notEqualTo(pics, value);
        }

        public DiscusRecordExample.Criteria andPicsGreaterThan(String value) {
            return greaterThan(pics, value);
        }

        public DiscusRecordExample.Criteria andPicsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(pics, value);
        }

        public DiscusRecordExample.Criteria andPicsLessThan(String value) {
            return lessThan(pics, value);
        }

        public DiscusRecordExample.Criteria andPicsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(pics, value);
        }

        public DiscusRecordExample.Criteria andPicsLike(String value) {
            return like(pics, value);
        }

        public DiscusRecordExample.Criteria andPicsNotLike(String value) {
            return notLike(pics, value);
        }

        public DiscusRecordExample.Criteria andPicsIn(List<String> values) {
            return in(pics, values);
        }

        public DiscusRecordExample.Criteria andPicsNotIn(List<String> values) {
            return notIn(pics, values);
        }

        public DiscusRecordExample.Criteria andPicsBetween(String value1, String value2) {
            return between(pics, value1, value2);
        }

        public DiscusRecordExample.Criteria andPicsNotBetween(String value1, String value2) {
            return notBetween(pics, value1, value2);
        }
    }
}
