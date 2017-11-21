package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ActivityDrawPrizePool;

import java.util.*;
public class ActivityDrawPrizePoolExample extends SgExample<ActivityDrawPrizePoolExample.Criteria> {
    public static final Class<ActivityDrawPrizePool> beanClass = ActivityDrawPrizePool.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn prizeImgUrl;
    public static EntityColumn totalNum;
    public static EntityColumn prizeName;
    public static EntityColumn rankStr;
    public static EntityColumn rank;
    public static EntityColumn pemId;
    public static EntityColumn drawAbleNum;
    public static EntityColumn prizeId;
    public static EntityColumn drawedNum;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        prizeImgUrl = listMap.get("prizeImgUrl");
        totalNum = listMap.get("totalNum");
        prizeName = listMap.get("prizeName");
        rankStr = listMap.get("rankStr");
        rank = listMap.get("rank");
        pemId = listMap.get("pemId");
        drawAbleNum = listMap.get("drawAbleNum");
        prizeId = listMap.get("prizeId");
        drawedNum = listMap.get("drawedNum");
        }

    public ActivityDrawPrizePoolExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ActivityDrawPrizePoolExample.Criteria createCriteriaInternal() {
        return new ActivityDrawPrizePoolExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeImgUrlIsNull() {
            return isNull(prizeImgUrl);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeImgUrlIsNotNull() {
            return isNotNull(prizeImgUrl);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeImgUrlEqualTo(String value) {
            return equalTo(prizeImgUrl, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeImgUrlNotEqualTo(String value) {
            return notEqualTo(prizeImgUrl, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeImgUrlGreaterThan(String value) {
            return greaterThan(prizeImgUrl, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeImgUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(prizeImgUrl, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeImgUrlLessThan(String value) {
            return lessThan(prizeImgUrl, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeImgUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(prizeImgUrl, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeImgUrlLike(String value) {
            return like(prizeImgUrl, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeImgUrlNotLike(String value) {
            return notLike(prizeImgUrl, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeImgUrlIn(List<String> values) {
            return in(prizeImgUrl, values);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeImgUrlNotIn(List<String> values) {
            return notIn(prizeImgUrl, values);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeImgUrlBetween(String value1, String value2) {
            return between(prizeImgUrl, value1, value2);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeImgUrlNotBetween(String value1, String value2) {
            return notBetween(prizeImgUrl, value1, value2);
        }
        public ActivityDrawPrizePoolExample.Criteria andTotalNumIsNull() {
            return isNull(totalNum);
        }

        public ActivityDrawPrizePoolExample.Criteria andTotalNumIsNotNull() {
            return isNotNull(totalNum);
        }

        public ActivityDrawPrizePoolExample.Criteria andTotalNumEqualTo(Integer value) {
            return equalTo(totalNum, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andTotalNumNotEqualTo(Integer value) {
            return notEqualTo(totalNum, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andTotalNumGreaterThan(Integer value) {
            return greaterThan(totalNum, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andTotalNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(totalNum, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andTotalNumLessThan(Integer value) {
            return lessThan(totalNum, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andTotalNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(totalNum, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andTotalNumIn(List<Integer> values) {
            return in(totalNum, values);
        }

        public ActivityDrawPrizePoolExample.Criteria andTotalNumNotIn(List<Integer> values) {
            return notIn(totalNum, values);
        }

        public ActivityDrawPrizePoolExample.Criteria andTotalNumBetween(Integer value1, Integer value2) {
            return between(totalNum, value1, value2);
        }

        public ActivityDrawPrizePoolExample.Criteria andTotalNumNotBetween(Integer value1, Integer value2) {
            return notBetween(totalNum, value1, value2);
        }
        public ActivityDrawPrizePoolExample.Criteria andPrizeNameIsNull() {
            return isNull(prizeName);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeNameIsNotNull() {
            return isNotNull(prizeName);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeNameEqualTo(String value) {
            return equalTo(prizeName, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeNameNotEqualTo(String value) {
            return notEqualTo(prizeName, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeNameGreaterThan(String value) {
            return greaterThan(prizeName, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(prizeName, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeNameLessThan(String value) {
            return lessThan(prizeName, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(prizeName, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeNameLike(String value) {
            return like(prizeName, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeNameNotLike(String value) {
            return notLike(prizeName, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeNameIn(List<String> values) {
            return in(prizeName, values);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeNameNotIn(List<String> values) {
            return notIn(prizeName, values);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeNameBetween(String value1, String value2) {
            return between(prizeName, value1, value2);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeNameNotBetween(String value1, String value2) {
            return notBetween(prizeName, value1, value2);
        }
        public ActivityDrawPrizePoolExample.Criteria andRankStrIsNull() {
            return isNull(rankStr);
        }

        public ActivityDrawPrizePoolExample.Criteria andRankStrIsNotNull() {
            return isNotNull(rankStr);
        }

        public ActivityDrawPrizePoolExample.Criteria andRankStrEqualTo(String value) {
            return equalTo(rankStr, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andRankStrNotEqualTo(String value) {
            return notEqualTo(rankStr, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andRankStrGreaterThan(String value) {
            return greaterThan(rankStr, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andRankStrGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(rankStr, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andRankStrLessThan(String value) {
            return lessThan(rankStr, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andRankStrLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(rankStr, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andRankStrLike(String value) {
            return like(rankStr, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andRankStrNotLike(String value) {
            return notLike(rankStr, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andRankStrIn(List<String> values) {
            return in(rankStr, values);
        }

        public ActivityDrawPrizePoolExample.Criteria andRankStrNotIn(List<String> values) {
            return notIn(rankStr, values);
        }

        public ActivityDrawPrizePoolExample.Criteria andRankStrBetween(String value1, String value2) {
            return between(rankStr, value1, value2);
        }

        public ActivityDrawPrizePoolExample.Criteria andRankStrNotBetween(String value1, String value2) {
            return notBetween(rankStr, value1, value2);
        }
        public ActivityDrawPrizePoolExample.Criteria andRankIsNull() {
            return isNull(rank);
        }

        public ActivityDrawPrizePoolExample.Criteria andRankIsNotNull() {
            return isNotNull(rank);
        }

        public ActivityDrawPrizePoolExample.Criteria andRankEqualTo(Integer value) {
            return equalTo(rank, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andRankNotEqualTo(Integer value) {
            return notEqualTo(rank, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andRankGreaterThan(Integer value) {
            return greaterThan(rank, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andRankGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(rank, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andRankLessThan(Integer value) {
            return lessThan(rank, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andRankLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(rank, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andRankIn(List<Integer> values) {
            return in(rank, values);
        }

        public ActivityDrawPrizePoolExample.Criteria andRankNotIn(List<Integer> values) {
            return notIn(rank, values);
        }

        public ActivityDrawPrizePoolExample.Criteria andRankBetween(Integer value1, Integer value2) {
            return between(rank, value1, value2);
        }

        public ActivityDrawPrizePoolExample.Criteria andRankNotBetween(Integer value1, Integer value2) {
            return notBetween(rank, value1, value2);
        }
        public ActivityDrawPrizePoolExample.Criteria andPemIdIsNull() {
            return isNull(pemId);
        }

        public ActivityDrawPrizePoolExample.Criteria andPemIdIsNotNull() {
            return isNotNull(pemId);
        }

        public ActivityDrawPrizePoolExample.Criteria andPemIdEqualTo(Long value) {
            return equalTo(pemId, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPemIdNotEqualTo(Long value) {
            return notEqualTo(pemId, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPemIdGreaterThan(Long value) {
            return greaterThan(pemId, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPemIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(pemId, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPemIdLessThan(Long value) {
            return lessThan(pemId, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPemIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(pemId, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPemIdIn(List<Long> values) {
            return in(pemId, values);
        }

        public ActivityDrawPrizePoolExample.Criteria andPemIdNotIn(List<Long> values) {
            return notIn(pemId, values);
        }

        public ActivityDrawPrizePoolExample.Criteria andPemIdBetween(Long value1, Long value2) {
            return between(pemId, value1, value2);
        }

        public ActivityDrawPrizePoolExample.Criteria andPemIdNotBetween(Long value1, Long value2) {
            return notBetween(pemId, value1, value2);
        }
        public ActivityDrawPrizePoolExample.Criteria andDrawAbleNumIsNull() {
            return isNull(drawAbleNum);
        }

        public ActivityDrawPrizePoolExample.Criteria andDrawAbleNumIsNotNull() {
            return isNotNull(drawAbleNum);
        }

        public ActivityDrawPrizePoolExample.Criteria andDrawAbleNumEqualTo(Integer value) {
            return equalTo(drawAbleNum, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andDrawAbleNumNotEqualTo(Integer value) {
            return notEqualTo(drawAbleNum, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andDrawAbleNumGreaterThan(Integer value) {
            return greaterThan(drawAbleNum, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andDrawAbleNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(drawAbleNum, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andDrawAbleNumLessThan(Integer value) {
            return lessThan(drawAbleNum, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andDrawAbleNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(drawAbleNum, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andDrawAbleNumIn(List<Integer> values) {
            return in(drawAbleNum, values);
        }

        public ActivityDrawPrizePoolExample.Criteria andDrawAbleNumNotIn(List<Integer> values) {
            return notIn(drawAbleNum, values);
        }

        public ActivityDrawPrizePoolExample.Criteria andDrawAbleNumBetween(Integer value1, Integer value2) {
            return between(drawAbleNum, value1, value2);
        }

        public ActivityDrawPrizePoolExample.Criteria andDrawAbleNumNotBetween(Integer value1, Integer value2) {
            return notBetween(drawAbleNum, value1, value2);
        }
        public ActivityDrawPrizePoolExample.Criteria andPrizeIdIsNull() {
            return isNull(prizeId);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeIdIsNotNull() {
            return isNotNull(prizeId);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeIdEqualTo(Long value) {
            return equalTo(prizeId, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeIdNotEqualTo(Long value) {
            return notEqualTo(prizeId, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeIdGreaterThan(Long value) {
            return greaterThan(prizeId, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(prizeId, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeIdLessThan(Long value) {
            return lessThan(prizeId, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(prizeId, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeIdIn(List<Long> values) {
            return in(prizeId, values);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeIdNotIn(List<Long> values) {
            return notIn(prizeId, values);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeIdBetween(Long value1, Long value2) {
            return between(prizeId, value1, value2);
        }

        public ActivityDrawPrizePoolExample.Criteria andPrizeIdNotBetween(Long value1, Long value2) {
            return notBetween(prizeId, value1, value2);
        }
        public ActivityDrawPrizePoolExample.Criteria andDrawedNumIsNull() {
            return isNull(drawedNum);
        }

        public ActivityDrawPrizePoolExample.Criteria andDrawedNumIsNotNull() {
            return isNotNull(drawedNum);
        }

        public ActivityDrawPrizePoolExample.Criteria andDrawedNumEqualTo(Integer value) {
            return equalTo(drawedNum, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andDrawedNumNotEqualTo(Integer value) {
            return notEqualTo(drawedNum, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andDrawedNumGreaterThan(Integer value) {
            return greaterThan(drawedNum, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andDrawedNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(drawedNum, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andDrawedNumLessThan(Integer value) {
            return lessThan(drawedNum, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andDrawedNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(drawedNum, value);
        }

        public ActivityDrawPrizePoolExample.Criteria andDrawedNumIn(List<Integer> values) {
            return in(drawedNum, values);
        }

        public ActivityDrawPrizePoolExample.Criteria andDrawedNumNotIn(List<Integer> values) {
            return notIn(drawedNum, values);
        }

        public ActivityDrawPrizePoolExample.Criteria andDrawedNumBetween(Integer value1, Integer value2) {
            return between(drawedNum, value1, value2);
        }

        public ActivityDrawPrizePoolExample.Criteria andDrawedNumNotBetween(Integer value1, Integer value2) {
            return notBetween(drawedNum, value1, value2);
        }
    }
}