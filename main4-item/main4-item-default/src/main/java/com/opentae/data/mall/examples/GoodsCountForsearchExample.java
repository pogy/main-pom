package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.GoodsCountForsearch;

import java.util.*;
public class GoodsCountForsearchExample extends SgExample<GoodsCountForsearchExample.Criteria> {
    public static final Class<GoodsCountForsearch> beanClass = GoodsCountForsearch.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn flowFixedTime;
    public static EntityColumn webSite;
    public static EntityColumn trade;
    public static EntityColumn searchId;
    public static EntityColumn clickIp;
    public static EntityColumn goodsId;
    public static EntityColumn hadGoat;
    public static EntityColumn hadBigzip;
    public static EntityColumn upMan;
    public static EntityColumn up;
    public static EntityColumn click;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        flowFixedTime = listMap.get("flowFixedTime");
        webSite = listMap.get("webSite");
        trade = listMap.get("trade");
        searchId = listMap.get("searchId");
        clickIp = listMap.get("clickIp");
        goodsId = listMap.get("goodsId");
        hadGoat = listMap.get("hadGoat");
        hadBigzip = listMap.get("hadBigzip");
        upMan = listMap.get("upMan");
        up = listMap.get("up");
        click = listMap.get("click");
        }

    public GoodsCountForsearchExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected GoodsCountForsearchExample.Criteria createCriteriaInternal() {
        return new GoodsCountForsearchExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeIsNull() {
            return isNull(flowFixedTime);
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeIsNotNull() {
            return isNotNull(flowFixedTime);
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeEqualTo(Date value) {
            return equalTo(flowFixedTime, value);
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeNotEqualTo(Date value) {
            return notEqualTo(flowFixedTime, value);
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeGreaterThan(Date value) {
            return greaterThan(flowFixedTime, value);
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(flowFixedTime, value);
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeLessThan(Date value) {
            return lessThan(flowFixedTime, value);
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(flowFixedTime, value);
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeIn(List<Date> values) {
            return in(flowFixedTime, values);
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeNotIn(List<Date> values) {
            return notIn(flowFixedTime, values);
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeBetween(Date value1, Date value2) {
            return between(flowFixedTime, value1, value2);
        }

        public GoodsCountForsearchExample.Criteria andFlowFixedTimeNotBetween(Date value1, Date value2) {
            return notBetween(flowFixedTime, value1, value2);
        }
        public GoodsCountForsearchExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public GoodsCountForsearchExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public GoodsCountForsearchExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public GoodsCountForsearchExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public GoodsCountForsearchExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public GoodsCountForsearchExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public GoodsCountForsearchExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public GoodsCountForsearchExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public GoodsCountForsearchExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public GoodsCountForsearchExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public GoodsCountForsearchExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public GoodsCountForsearchExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public GoodsCountForsearchExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public GoodsCountForsearchExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public GoodsCountForsearchExample.Criteria andTradeIsNull() {
            return isNull(trade);
        }

        public GoodsCountForsearchExample.Criteria andTradeIsNotNull() {
            return isNotNull(trade);
        }

        public GoodsCountForsearchExample.Criteria andTradeEqualTo(Long value) {
            return equalTo(trade, value);
        }

        public GoodsCountForsearchExample.Criteria andTradeNotEqualTo(Long value) {
            return notEqualTo(trade, value);
        }

        public GoodsCountForsearchExample.Criteria andTradeGreaterThan(Long value) {
            return greaterThan(trade, value);
        }

        public GoodsCountForsearchExample.Criteria andTradeGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(trade, value);
        }

        public GoodsCountForsearchExample.Criteria andTradeLessThan(Long value) {
            return lessThan(trade, value);
        }

        public GoodsCountForsearchExample.Criteria andTradeLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(trade, value);
        }

        public GoodsCountForsearchExample.Criteria andTradeIn(List<Long> values) {
            return in(trade, values);
        }

        public GoodsCountForsearchExample.Criteria andTradeNotIn(List<Long> values) {
            return notIn(trade, values);
        }

        public GoodsCountForsearchExample.Criteria andTradeBetween(Long value1, Long value2) {
            return between(trade, value1, value2);
        }

        public GoodsCountForsearchExample.Criteria andTradeNotBetween(Long value1, Long value2) {
            return notBetween(trade, value1, value2);
        }
        public GoodsCountForsearchExample.Criteria andSearchIdIsNull() {
            return isNull(searchId);
        }

        public GoodsCountForsearchExample.Criteria andSearchIdIsNotNull() {
            return isNotNull(searchId);
        }

        public GoodsCountForsearchExample.Criteria andSearchIdEqualTo(Long value) {
            return equalTo(searchId, value);
        }

        public GoodsCountForsearchExample.Criteria andSearchIdNotEqualTo(Long value) {
            return notEqualTo(searchId, value);
        }

        public GoodsCountForsearchExample.Criteria andSearchIdGreaterThan(Long value) {
            return greaterThan(searchId, value);
        }

        public GoodsCountForsearchExample.Criteria andSearchIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(searchId, value);
        }

        public GoodsCountForsearchExample.Criteria andSearchIdLessThan(Long value) {
            return lessThan(searchId, value);
        }

        public GoodsCountForsearchExample.Criteria andSearchIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(searchId, value);
        }

        public GoodsCountForsearchExample.Criteria andSearchIdIn(List<Long> values) {
            return in(searchId, values);
        }

        public GoodsCountForsearchExample.Criteria andSearchIdNotIn(List<Long> values) {
            return notIn(searchId, values);
        }

        public GoodsCountForsearchExample.Criteria andSearchIdBetween(Long value1, Long value2) {
            return between(searchId, value1, value2);
        }

        public GoodsCountForsearchExample.Criteria andSearchIdNotBetween(Long value1, Long value2) {
            return notBetween(searchId, value1, value2);
        }
        public GoodsCountForsearchExample.Criteria andClickIpIsNull() {
            return isNull(clickIp);
        }

        public GoodsCountForsearchExample.Criteria andClickIpIsNotNull() {
            return isNotNull(clickIp);
        }

        public GoodsCountForsearchExample.Criteria andClickIpEqualTo(Long value) {
            return equalTo(clickIp, value);
        }

        public GoodsCountForsearchExample.Criteria andClickIpNotEqualTo(Long value) {
            return notEqualTo(clickIp, value);
        }

        public GoodsCountForsearchExample.Criteria andClickIpGreaterThan(Long value) {
            return greaterThan(clickIp, value);
        }

        public GoodsCountForsearchExample.Criteria andClickIpGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(clickIp, value);
        }

        public GoodsCountForsearchExample.Criteria andClickIpLessThan(Long value) {
            return lessThan(clickIp, value);
        }

        public GoodsCountForsearchExample.Criteria andClickIpLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(clickIp, value);
        }

        public GoodsCountForsearchExample.Criteria andClickIpIn(List<Long> values) {
            return in(clickIp, values);
        }

        public GoodsCountForsearchExample.Criteria andClickIpNotIn(List<Long> values) {
            return notIn(clickIp, values);
        }

        public GoodsCountForsearchExample.Criteria andClickIpBetween(Long value1, Long value2) {
            return between(clickIp, value1, value2);
        }

        public GoodsCountForsearchExample.Criteria andClickIpNotBetween(Long value1, Long value2) {
            return notBetween(clickIp, value1, value2);
        }
        public GoodsCountForsearchExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public GoodsCountForsearchExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public GoodsCountForsearchExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public GoodsCountForsearchExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public GoodsCountForsearchExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public GoodsCountForsearchExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public GoodsCountForsearchExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public GoodsCountForsearchExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public GoodsCountForsearchExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public GoodsCountForsearchExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public GoodsCountForsearchExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public GoodsCountForsearchExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public GoodsCountForsearchExample.Criteria andHadGoatIsNull() {
            return isNull(hadGoat);
        }

        public GoodsCountForsearchExample.Criteria andHadGoatIsNotNull() {
            return isNotNull(hadGoat);
        }

        public GoodsCountForsearchExample.Criteria andHadGoatEqualTo(Integer value) {
            return equalTo(hadGoat, value);
        }

        public GoodsCountForsearchExample.Criteria andHadGoatNotEqualTo(Integer value) {
            return notEqualTo(hadGoat, value);
        }

        public GoodsCountForsearchExample.Criteria andHadGoatGreaterThan(Integer value) {
            return greaterThan(hadGoat, value);
        }

        public GoodsCountForsearchExample.Criteria andHadGoatGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(hadGoat, value);
        }

        public GoodsCountForsearchExample.Criteria andHadGoatLessThan(Integer value) {
            return lessThan(hadGoat, value);
        }

        public GoodsCountForsearchExample.Criteria andHadGoatLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(hadGoat, value);
        }

        public GoodsCountForsearchExample.Criteria andHadGoatIn(List<Integer> values) {
            return in(hadGoat, values);
        }

        public GoodsCountForsearchExample.Criteria andHadGoatNotIn(List<Integer> values) {
            return notIn(hadGoat, values);
        }

        public GoodsCountForsearchExample.Criteria andHadGoatBetween(Integer value1, Integer value2) {
            return between(hadGoat, value1, value2);
        }

        public GoodsCountForsearchExample.Criteria andHadGoatNotBetween(Integer value1, Integer value2) {
            return notBetween(hadGoat, value1, value2);
        }
        public GoodsCountForsearchExample.Criteria andHadBigzipIsNull() {
            return isNull(hadBigzip);
        }

        public GoodsCountForsearchExample.Criteria andHadBigzipIsNotNull() {
            return isNotNull(hadBigzip);
        }

        public GoodsCountForsearchExample.Criteria andHadBigzipEqualTo(Integer value) {
            return equalTo(hadBigzip, value);
        }

        public GoodsCountForsearchExample.Criteria andHadBigzipNotEqualTo(Integer value) {
            return notEqualTo(hadBigzip, value);
        }

        public GoodsCountForsearchExample.Criteria andHadBigzipGreaterThan(Integer value) {
            return greaterThan(hadBigzip, value);
        }

        public GoodsCountForsearchExample.Criteria andHadBigzipGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(hadBigzip, value);
        }

        public GoodsCountForsearchExample.Criteria andHadBigzipLessThan(Integer value) {
            return lessThan(hadBigzip, value);
        }

        public GoodsCountForsearchExample.Criteria andHadBigzipLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(hadBigzip, value);
        }

        public GoodsCountForsearchExample.Criteria andHadBigzipIn(List<Integer> values) {
            return in(hadBigzip, values);
        }

        public GoodsCountForsearchExample.Criteria andHadBigzipNotIn(List<Integer> values) {
            return notIn(hadBigzip, values);
        }

        public GoodsCountForsearchExample.Criteria andHadBigzipBetween(Integer value1, Integer value2) {
            return between(hadBigzip, value1, value2);
        }

        public GoodsCountForsearchExample.Criteria andHadBigzipNotBetween(Integer value1, Integer value2) {
            return notBetween(hadBigzip, value1, value2);
        }
        public GoodsCountForsearchExample.Criteria andUpManIsNull() {
            return isNull(upMan);
        }

        public GoodsCountForsearchExample.Criteria andUpManIsNotNull() {
            return isNotNull(upMan);
        }

        public GoodsCountForsearchExample.Criteria andUpManEqualTo(Long value) {
            return equalTo(upMan, value);
        }

        public GoodsCountForsearchExample.Criteria andUpManNotEqualTo(Long value) {
            return notEqualTo(upMan, value);
        }

        public GoodsCountForsearchExample.Criteria andUpManGreaterThan(Long value) {
            return greaterThan(upMan, value);
        }

        public GoodsCountForsearchExample.Criteria andUpManGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(upMan, value);
        }

        public GoodsCountForsearchExample.Criteria andUpManLessThan(Long value) {
            return lessThan(upMan, value);
        }

        public GoodsCountForsearchExample.Criteria andUpManLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(upMan, value);
        }

        public GoodsCountForsearchExample.Criteria andUpManIn(List<Long> values) {
            return in(upMan, values);
        }

        public GoodsCountForsearchExample.Criteria andUpManNotIn(List<Long> values) {
            return notIn(upMan, values);
        }

        public GoodsCountForsearchExample.Criteria andUpManBetween(Long value1, Long value2) {
            return between(upMan, value1, value2);
        }

        public GoodsCountForsearchExample.Criteria andUpManNotBetween(Long value1, Long value2) {
            return notBetween(upMan, value1, value2);
        }
        public GoodsCountForsearchExample.Criteria andUpIsNull() {
            return isNull(up);
        }

        public GoodsCountForsearchExample.Criteria andUpIsNotNull() {
            return isNotNull(up);
        }

        public GoodsCountForsearchExample.Criteria andUpEqualTo(Long value) {
            return equalTo(up, value);
        }

        public GoodsCountForsearchExample.Criteria andUpNotEqualTo(Long value) {
            return notEqualTo(up, value);
        }

        public GoodsCountForsearchExample.Criteria andUpGreaterThan(Long value) {
            return greaterThan(up, value);
        }

        public GoodsCountForsearchExample.Criteria andUpGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(up, value);
        }

        public GoodsCountForsearchExample.Criteria andUpLessThan(Long value) {
            return lessThan(up, value);
        }

        public GoodsCountForsearchExample.Criteria andUpLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(up, value);
        }

        public GoodsCountForsearchExample.Criteria andUpIn(List<Long> values) {
            return in(up, values);
        }

        public GoodsCountForsearchExample.Criteria andUpNotIn(List<Long> values) {
            return notIn(up, values);
        }

        public GoodsCountForsearchExample.Criteria andUpBetween(Long value1, Long value2) {
            return between(up, value1, value2);
        }

        public GoodsCountForsearchExample.Criteria andUpNotBetween(Long value1, Long value2) {
            return notBetween(up, value1, value2);
        }
        public GoodsCountForsearchExample.Criteria andClickIsNull() {
            return isNull(click);
        }

        public GoodsCountForsearchExample.Criteria andClickIsNotNull() {
            return isNotNull(click);
        }

        public GoodsCountForsearchExample.Criteria andClickEqualTo(Long value) {
            return equalTo(click, value);
        }

        public GoodsCountForsearchExample.Criteria andClickNotEqualTo(Long value) {
            return notEqualTo(click, value);
        }

        public GoodsCountForsearchExample.Criteria andClickGreaterThan(Long value) {
            return greaterThan(click, value);
        }

        public GoodsCountForsearchExample.Criteria andClickGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(click, value);
        }

        public GoodsCountForsearchExample.Criteria andClickLessThan(Long value) {
            return lessThan(click, value);
        }

        public GoodsCountForsearchExample.Criteria andClickLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(click, value);
        }

        public GoodsCountForsearchExample.Criteria andClickIn(List<Long> values) {
            return in(click, values);
        }

        public GoodsCountForsearchExample.Criteria andClickNotIn(List<Long> values) {
            return notIn(click, values);
        }

        public GoodsCountForsearchExample.Criteria andClickBetween(Long value1, Long value2) {
            return between(click, value1, value2);
        }

        public GoodsCountForsearchExample.Criteria andClickNotBetween(Long value1, Long value2) {
            return notBetween(click, value1, value2);
        }
    }
}