package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguNewActivity;

import java.util.*;
public class ShiguNewActivityExample extends SgExample<ShiguNewActivityExample.Criteria> {
    public static final Class<ShiguNewActivity> beanClass = ShiguNewActivity.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn amount;
    public static EntityColumn gmtModify;
    public static EntityColumn bannerImgUrl;
    public static EntityColumn startTime;
    public static EntityColumn endTime;
    public static EntityColumn id;
    public static EntityColumn winnersNum;
    public static EntityColumn gmtCreate;
    public static EntityColumn title;
    public static EntityColumn goodsImgUrl;
    public static EntityColumn activeRules;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        amount = listMap.get("amount");
        gmtModify = listMap.get("gmtModify");
        bannerImgUrl = listMap.get("bannerImgUrl");
        startTime = listMap.get("startTime");
        endTime = listMap.get("endTime");
        id = listMap.get("id");
        winnersNum = listMap.get("winnersNum");
        gmtCreate = listMap.get("gmtCreate");
        title = listMap.get("title");
        goodsImgUrl = listMap.get("goodsImgUrl");
        activeRules = listMap.get("activeRules");
        }

    public ShiguNewActivityExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguNewActivityExample.Criteria createCriteriaInternal() {
        return new ShiguNewActivityExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguNewActivityExample.Criteria andAmountIsNull() {
            return isNull(amount);
        }

        public ShiguNewActivityExample.Criteria andAmountIsNotNull() {
            return isNotNull(amount);
        }

        public ShiguNewActivityExample.Criteria andAmountEqualTo(String value) {
            return equalTo(amount, value);
        }

        public ShiguNewActivityExample.Criteria andAmountNotEqualTo(String value) {
            return notEqualTo(amount, value);
        }

        public ShiguNewActivityExample.Criteria andAmountGreaterThan(String value) {
            return greaterThan(amount, value);
        }

        public ShiguNewActivityExample.Criteria andAmountGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(amount, value);
        }

        public ShiguNewActivityExample.Criteria andAmountLessThan(String value) {
            return lessThan(amount, value);
        }

        public ShiguNewActivityExample.Criteria andAmountLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(amount, value);
        }

        public ShiguNewActivityExample.Criteria andAmountLike(String value) {
            return like(amount, value);
        }

        public ShiguNewActivityExample.Criteria andAmountNotLike(String value) {
            return notLike(amount, value);
        }

        public ShiguNewActivityExample.Criteria andAmountIn(List<String> values) {
            return in(amount, values);
        }

        public ShiguNewActivityExample.Criteria andAmountNotIn(List<String> values) {
            return notIn(amount, values);
        }

        public ShiguNewActivityExample.Criteria andAmountBetween(String value1, String value2) {
            return between(amount, value1, value2);
        }

        public ShiguNewActivityExample.Criteria andAmountNotBetween(String value1, String value2) {
            return notBetween(amount, value1, value2);
        }
        public ShiguNewActivityExample.Criteria andGmtModifyIsNull() {
            return isNull(gmtModify);
        }

        public ShiguNewActivityExample.Criteria andGmtModifyIsNotNull() {
            return isNotNull(gmtModify);
        }

        public ShiguNewActivityExample.Criteria andGmtModifyEqualTo(Date value) {
            return equalTo(gmtModify, value);
        }

        public ShiguNewActivityExample.Criteria andGmtModifyNotEqualTo(Date value) {
            return notEqualTo(gmtModify, value);
        }

        public ShiguNewActivityExample.Criteria andGmtModifyGreaterThan(Date value) {
            return greaterThan(gmtModify, value);
        }

        public ShiguNewActivityExample.Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtModify, value);
        }

        public ShiguNewActivityExample.Criteria andGmtModifyLessThan(Date value) {
            return lessThan(gmtModify, value);
        }

        public ShiguNewActivityExample.Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtModify, value);
        }

        public ShiguNewActivityExample.Criteria andGmtModifyIn(List<Date> values) {
            return in(gmtModify, values);
        }

        public ShiguNewActivityExample.Criteria andGmtModifyNotIn(List<Date> values) {
            return notIn(gmtModify, values);
        }

        public ShiguNewActivityExample.Criteria andGmtModifyBetween(Date value1, Date value2) {
            return between(gmtModify, value1, value2);
        }

        public ShiguNewActivityExample.Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            return notBetween(gmtModify, value1, value2);
        }
        public ShiguNewActivityExample.Criteria andBannerImgUrlIsNull() {
            return isNull(bannerImgUrl);
        }

        public ShiguNewActivityExample.Criteria andBannerImgUrlIsNotNull() {
            return isNotNull(bannerImgUrl);
        }

        public ShiguNewActivityExample.Criteria andBannerImgUrlEqualTo(String value) {
            return equalTo(bannerImgUrl, value);
        }

        public ShiguNewActivityExample.Criteria andBannerImgUrlNotEqualTo(String value) {
            return notEqualTo(bannerImgUrl, value);
        }

        public ShiguNewActivityExample.Criteria andBannerImgUrlGreaterThan(String value) {
            return greaterThan(bannerImgUrl, value);
        }

        public ShiguNewActivityExample.Criteria andBannerImgUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(bannerImgUrl, value);
        }

        public ShiguNewActivityExample.Criteria andBannerImgUrlLessThan(String value) {
            return lessThan(bannerImgUrl, value);
        }

        public ShiguNewActivityExample.Criteria andBannerImgUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(bannerImgUrl, value);
        }

        public ShiguNewActivityExample.Criteria andBannerImgUrlLike(String value) {
            return like(bannerImgUrl, value);
        }

        public ShiguNewActivityExample.Criteria andBannerImgUrlNotLike(String value) {
            return notLike(bannerImgUrl, value);
        }

        public ShiguNewActivityExample.Criteria andBannerImgUrlIn(List<String> values) {
            return in(bannerImgUrl, values);
        }

        public ShiguNewActivityExample.Criteria andBannerImgUrlNotIn(List<String> values) {
            return notIn(bannerImgUrl, values);
        }

        public ShiguNewActivityExample.Criteria andBannerImgUrlBetween(String value1, String value2) {
            return between(bannerImgUrl, value1, value2);
        }

        public ShiguNewActivityExample.Criteria andBannerImgUrlNotBetween(String value1, String value2) {
            return notBetween(bannerImgUrl, value1, value2);
        }
        public ShiguNewActivityExample.Criteria andStartTimeIsNull() {
            return isNull(startTime);
        }

        public ShiguNewActivityExample.Criteria andStartTimeIsNotNull() {
            return isNotNull(startTime);
        }

        public ShiguNewActivityExample.Criteria andStartTimeEqualTo(Date value) {
            return equalTo(startTime, value);
        }

        public ShiguNewActivityExample.Criteria andStartTimeNotEqualTo(Date value) {
            return notEqualTo(startTime, value);
        }

        public ShiguNewActivityExample.Criteria andStartTimeGreaterThan(Date value) {
            return greaterThan(startTime, value);
        }

        public ShiguNewActivityExample.Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(startTime, value);
        }

        public ShiguNewActivityExample.Criteria andStartTimeLessThan(Date value) {
            return lessThan(startTime, value);
        }

        public ShiguNewActivityExample.Criteria andStartTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(startTime, value);
        }

        public ShiguNewActivityExample.Criteria andStartTimeIn(List<Date> values) {
            return in(startTime, values);
        }

        public ShiguNewActivityExample.Criteria andStartTimeNotIn(List<Date> values) {
            return notIn(startTime, values);
        }

        public ShiguNewActivityExample.Criteria andStartTimeBetween(Date value1, Date value2) {
            return between(startTime, value1, value2);
        }

        public ShiguNewActivityExample.Criteria andStartTimeNotBetween(Date value1, Date value2) {
            return notBetween(startTime, value1, value2);
        }
        public ShiguNewActivityExample.Criteria andEndTimeIsNull() {
            return isNull(endTime);
        }

        public ShiguNewActivityExample.Criteria andEndTimeIsNotNull() {
            return isNotNull(endTime);
        }

        public ShiguNewActivityExample.Criteria andEndTimeEqualTo(Date value) {
            return equalTo(endTime, value);
        }

        public ShiguNewActivityExample.Criteria andEndTimeNotEqualTo(Date value) {
            return notEqualTo(endTime, value);
        }

        public ShiguNewActivityExample.Criteria andEndTimeGreaterThan(Date value) {
            return greaterThan(endTime, value);
        }

        public ShiguNewActivityExample.Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(endTime, value);
        }

        public ShiguNewActivityExample.Criteria andEndTimeLessThan(Date value) {
            return lessThan(endTime, value);
        }

        public ShiguNewActivityExample.Criteria andEndTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(endTime, value);
        }

        public ShiguNewActivityExample.Criteria andEndTimeIn(List<Date> values) {
            return in(endTime, values);
        }

        public ShiguNewActivityExample.Criteria andEndTimeNotIn(List<Date> values) {
            return notIn(endTime, values);
        }

        public ShiguNewActivityExample.Criteria andEndTimeBetween(Date value1, Date value2) {
            return between(endTime, value1, value2);
        }

        public ShiguNewActivityExample.Criteria andEndTimeNotBetween(Date value1, Date value2) {
            return notBetween(endTime, value1, value2);
        }
        public ShiguNewActivityExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ShiguNewActivityExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ShiguNewActivityExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public ShiguNewActivityExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public ShiguNewActivityExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public ShiguNewActivityExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ShiguNewActivityExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public ShiguNewActivityExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public ShiguNewActivityExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public ShiguNewActivityExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public ShiguNewActivityExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public ShiguNewActivityExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public ShiguNewActivityExample.Criteria andWinnersNumIsNull() {
            return isNull(winnersNum);
        }

        public ShiguNewActivityExample.Criteria andWinnersNumIsNotNull() {
            return isNotNull(winnersNum);
        }

        public ShiguNewActivityExample.Criteria andWinnersNumEqualTo(Integer value) {
            return equalTo(winnersNum, value);
        }

        public ShiguNewActivityExample.Criteria andWinnersNumNotEqualTo(Integer value) {
            return notEqualTo(winnersNum, value);
        }

        public ShiguNewActivityExample.Criteria andWinnersNumGreaterThan(Integer value) {
            return greaterThan(winnersNum, value);
        }

        public ShiguNewActivityExample.Criteria andWinnersNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(winnersNum, value);
        }

        public ShiguNewActivityExample.Criteria andWinnersNumLessThan(Integer value) {
            return lessThan(winnersNum, value);
        }

        public ShiguNewActivityExample.Criteria andWinnersNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(winnersNum, value);
        }

        public ShiguNewActivityExample.Criteria andWinnersNumIn(List<Integer> values) {
            return in(winnersNum, values);
        }

        public ShiguNewActivityExample.Criteria andWinnersNumNotIn(List<Integer> values) {
            return notIn(winnersNum, values);
        }

        public ShiguNewActivityExample.Criteria andWinnersNumBetween(Integer value1, Integer value2) {
            return between(winnersNum, value1, value2);
        }

        public ShiguNewActivityExample.Criteria andWinnersNumNotBetween(Integer value1, Integer value2) {
            return notBetween(winnersNum, value1, value2);
        }
        public ShiguNewActivityExample.Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public ShiguNewActivityExample.Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public ShiguNewActivityExample.Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public ShiguNewActivityExample.Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public ShiguNewActivityExample.Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public ShiguNewActivityExample.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public ShiguNewActivityExample.Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public ShiguNewActivityExample.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public ShiguNewActivityExample.Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public ShiguNewActivityExample.Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public ShiguNewActivityExample.Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public ShiguNewActivityExample.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
        public ShiguNewActivityExample.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public ShiguNewActivityExample.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public ShiguNewActivityExample.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public ShiguNewActivityExample.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public ShiguNewActivityExample.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public ShiguNewActivityExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public ShiguNewActivityExample.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public ShiguNewActivityExample.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public ShiguNewActivityExample.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public ShiguNewActivityExample.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public ShiguNewActivityExample.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public ShiguNewActivityExample.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public ShiguNewActivityExample.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public ShiguNewActivityExample.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
        public ShiguNewActivityExample.Criteria andGoodsImgUrlIsNull() {
            return isNull(goodsImgUrl);
        }

        public ShiguNewActivityExample.Criteria andGoodsImgUrlIsNotNull() {
            return isNotNull(goodsImgUrl);
        }

        public ShiguNewActivityExample.Criteria andGoodsImgUrlEqualTo(String value) {
            return equalTo(goodsImgUrl, value);
        }

        public ShiguNewActivityExample.Criteria andGoodsImgUrlNotEqualTo(String value) {
            return notEqualTo(goodsImgUrl, value);
        }

        public ShiguNewActivityExample.Criteria andGoodsImgUrlGreaterThan(String value) {
            return greaterThan(goodsImgUrl, value);
        }

        public ShiguNewActivityExample.Criteria andGoodsImgUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsImgUrl, value);
        }

        public ShiguNewActivityExample.Criteria andGoodsImgUrlLessThan(String value) {
            return lessThan(goodsImgUrl, value);
        }

        public ShiguNewActivityExample.Criteria andGoodsImgUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsImgUrl, value);
        }

        public ShiguNewActivityExample.Criteria andGoodsImgUrlLike(String value) {
            return like(goodsImgUrl, value);
        }

        public ShiguNewActivityExample.Criteria andGoodsImgUrlNotLike(String value) {
            return notLike(goodsImgUrl, value);
        }

        public ShiguNewActivityExample.Criteria andGoodsImgUrlIn(List<String> values) {
            return in(goodsImgUrl, values);
        }

        public ShiguNewActivityExample.Criteria andGoodsImgUrlNotIn(List<String> values) {
            return notIn(goodsImgUrl, values);
        }

        public ShiguNewActivityExample.Criteria andGoodsImgUrlBetween(String value1, String value2) {
            return between(goodsImgUrl, value1, value2);
        }

        public ShiguNewActivityExample.Criteria andGoodsImgUrlNotBetween(String value1, String value2) {
            return notBetween(goodsImgUrl, value1, value2);
        }
        public ShiguNewActivityExample.Criteria andActiveRulesIsNull() {
            return isNull(activeRules);
        }

        public ShiguNewActivityExample.Criteria andActiveRulesIsNotNull() {
            return isNotNull(activeRules);
        }

        public ShiguNewActivityExample.Criteria andActiveRulesEqualTo(String value) {
            return equalTo(activeRules, value);
        }

        public ShiguNewActivityExample.Criteria andActiveRulesNotEqualTo(String value) {
            return notEqualTo(activeRules, value);
        }

        public ShiguNewActivityExample.Criteria andActiveRulesGreaterThan(String value) {
            return greaterThan(activeRules, value);
        }

        public ShiguNewActivityExample.Criteria andActiveRulesGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(activeRules, value);
        }

        public ShiguNewActivityExample.Criteria andActiveRulesLessThan(String value) {
            return lessThan(activeRules, value);
        }

        public ShiguNewActivityExample.Criteria andActiveRulesLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(activeRules, value);
        }

        public ShiguNewActivityExample.Criteria andActiveRulesLike(String value) {
            return like(activeRules, value);
        }

        public ShiguNewActivityExample.Criteria andActiveRulesNotLike(String value) {
            return notLike(activeRules, value);
        }

        public ShiguNewActivityExample.Criteria andActiveRulesIn(List<String> values) {
            return in(activeRules, values);
        }

        public ShiguNewActivityExample.Criteria andActiveRulesNotIn(List<String> values) {
            return notIn(activeRules, values);
        }

        public ShiguNewActivityExample.Criteria andActiveRulesBetween(String value1, String value2) {
            return between(activeRules, value1, value2);
        }

        public ShiguNewActivityExample.Criteria andActiveRulesNotBetween(String value1, String value2) {
            return notBetween(activeRules, value1, value2);
        }
    }
}