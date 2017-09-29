package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaAfterReceiveExpresStock;

import java.util.*;

public class DaifaAfterReceiveExpresStockExample extends SgExample<DaifaAfterReceiveExpresStockExample.Criteria> {
    public static final Class<DaifaAfterReceiveExpresStock> beanClass = DaifaAfterReceiveExpresStock.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn stockLocation;
    public static EntityColumn tradeCode;
    public static EntityColumn dfTradeId;
    public static EntityColumn receivedExpressName;
    public static EntityColumn packageRemark;
    public static EntityColumn createTime;
    public static EntityColumn receivedExpressCode;
    public static EntityColumn receivedExpressId;
    public static EntityColumn sendPhone;
    public static EntityColumn orderPartitionId;
    public static EntityColumn orderCode;
    public static EntityColumn refundId;
    public static EntityColumn relevanceStatus;
    public static EntityColumn dfOrderId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        stockLocation = listMap.get("stockLocation");
        tradeCode = listMap.get("tradeCode");
        dfTradeId = listMap.get("dfTradeId");
        receivedExpressName = listMap.get("receivedExpressName");
        packageRemark = listMap.get("packageRemark");
        createTime = listMap.get("createTime");
        receivedExpressCode = listMap.get("receivedExpressCode");
        receivedExpressId = listMap.get("receivedExpressId");
        sendPhone = listMap.get("sendPhone");
        orderPartitionId = listMap.get("orderPartitionId");
        orderCode = listMap.get("orderCode");
        refundId = listMap.get("refundId");
        relevanceStatus = listMap.get("relevanceStatus");
        dfOrderId = listMap.get("dfOrderId");
        }

    public DaifaAfterReceiveExpresStockExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected Criteria createCriteriaInternal() {
        return new Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public Criteria andStockLocationIsNull() {
            return isNull(stockLocation);
        }

        public Criteria andStockLocationIsNotNull() {
            return isNotNull(stockLocation);
        }

        public Criteria andStockLocationEqualTo(String value) {
            return equalTo(stockLocation, value);
        }

        public Criteria andStockLocationNotEqualTo(String value) {
            return notEqualTo(stockLocation, value);
        }

        public Criteria andStockLocationGreaterThan(String value) {
            return greaterThan(stockLocation, value);
        }

        public Criteria andStockLocationGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(stockLocation, value);
        }

        public Criteria andStockLocationLessThan(String value) {
            return lessThan(stockLocation, value);
        }

        public Criteria andStockLocationLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(stockLocation, value);
        }

        public Criteria andStockLocationLike(String value) {
            return like(stockLocation, value);
        }

        public Criteria andStockLocationNotLike(String value) {
            return notLike(stockLocation, value);
        }

        public Criteria andStockLocationIn(List<String> values) {
            return in(stockLocation, values);
        }

        public Criteria andStockLocationNotIn(List<String> values) {
            return notIn(stockLocation, values);
        }

        public Criteria andStockLocationBetween(String value1, String value2) {
            return between(stockLocation, value1, value2);
        }

        public Criteria andStockLocationNotBetween(String value1, String value2) {
            return notBetween(stockLocation, value1, value2);
        }
        public Criteria andTradeCodeIsNull() {
            return isNull(tradeCode);
        }

        public Criteria andTradeCodeIsNotNull() {
            return isNotNull(tradeCode);
        }

        public Criteria andTradeCodeEqualTo(String value) {
            return equalTo(tradeCode, value);
        }

        public Criteria andTradeCodeNotEqualTo(String value) {
            return notEqualTo(tradeCode, value);
        }

        public Criteria andTradeCodeGreaterThan(String value) {
            return greaterThan(tradeCode, value);
        }

        public Criteria andTradeCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(tradeCode, value);
        }

        public Criteria andTradeCodeLessThan(String value) {
            return lessThan(tradeCode, value);
        }

        public Criteria andTradeCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(tradeCode, value);
        }

        public Criteria andTradeCodeLike(String value) {
            return like(tradeCode, value);
        }

        public Criteria andTradeCodeNotLike(String value) {
            return notLike(tradeCode, value);
        }

        public Criteria andTradeCodeIn(List<String> values) {
            return in(tradeCode, values);
        }

        public Criteria andTradeCodeNotIn(List<String> values) {
            return notIn(tradeCode, values);
        }

        public Criteria andTradeCodeBetween(String value1, String value2) {
            return between(tradeCode, value1, value2);
        }

        public Criteria andTradeCodeNotBetween(String value1, String value2) {
            return notBetween(tradeCode, value1, value2);
        }
        public Criteria andDfTradeIdIsNull() {
            return isNull(dfTradeId);
        }

        public Criteria andDfTradeIdIsNotNull() {
            return isNotNull(dfTradeId);
        }

        public Criteria andDfTradeIdEqualTo(Long value) {
            return equalTo(dfTradeId, value);
        }

        public Criteria andDfTradeIdNotEqualTo(Long value) {
            return notEqualTo(dfTradeId, value);
        }

        public Criteria andDfTradeIdGreaterThan(Long value) {
            return greaterThan(dfTradeId, value);
        }

        public Criteria andDfTradeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfTradeId, value);
        }

        public Criteria andDfTradeIdLessThan(Long value) {
            return lessThan(dfTradeId, value);
        }

        public Criteria andDfTradeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfTradeId, value);
        }

        public Criteria andDfTradeIdIn(List<Long> values) {
            return in(dfTradeId, values);
        }

        public Criteria andDfTradeIdNotIn(List<Long> values) {
            return notIn(dfTradeId, values);
        }

        public Criteria andDfTradeIdBetween(Long value1, Long value2) {
            return between(dfTradeId, value1, value2);
        }

        public Criteria andDfTradeIdNotBetween(Long value1, Long value2) {
            return notBetween(dfTradeId, value1, value2);
        }
        public Criteria andReceivedExpressNameIsNull() {
            return isNull(receivedExpressName);
        }

        public Criteria andReceivedExpressNameIsNotNull() {
            return isNotNull(receivedExpressName);
        }

        public Criteria andReceivedExpressNameEqualTo(String value) {
            return equalTo(receivedExpressName, value);
        }

        public Criteria andReceivedExpressNameNotEqualTo(String value) {
            return notEqualTo(receivedExpressName, value);
        }

        public Criteria andReceivedExpressNameGreaterThan(String value) {
            return greaterThan(receivedExpressName, value);
        }

        public Criteria andReceivedExpressNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receivedExpressName, value);
        }

        public Criteria andReceivedExpressNameLessThan(String value) {
            return lessThan(receivedExpressName, value);
        }

        public Criteria andReceivedExpressNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receivedExpressName, value);
        }

        public Criteria andReceivedExpressNameLike(String value) {
            return like(receivedExpressName, value);
        }

        public Criteria andReceivedExpressNameNotLike(String value) {
            return notLike(receivedExpressName, value);
        }

        public Criteria andReceivedExpressNameIn(List<String> values) {
            return in(receivedExpressName, values);
        }

        public Criteria andReceivedExpressNameNotIn(List<String> values) {
            return notIn(receivedExpressName, values);
        }

        public Criteria andReceivedExpressNameBetween(String value1, String value2) {
            return between(receivedExpressName, value1, value2);
        }

        public Criteria andReceivedExpressNameNotBetween(String value1, String value2) {
            return notBetween(receivedExpressName, value1, value2);
        }
        public Criteria andPackageRemarkIsNull() {
            return isNull(packageRemark);
        }

        public Criteria andPackageRemarkIsNotNull() {
            return isNotNull(packageRemark);
        }

        public Criteria andPackageRemarkEqualTo(String value) {
            return equalTo(packageRemark, value);
        }

        public Criteria andPackageRemarkNotEqualTo(String value) {
            return notEqualTo(packageRemark, value);
        }

        public Criteria andPackageRemarkGreaterThan(String value) {
            return greaterThan(packageRemark, value);
        }

        public Criteria andPackageRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(packageRemark, value);
        }

        public Criteria andPackageRemarkLessThan(String value) {
            return lessThan(packageRemark, value);
        }

        public Criteria andPackageRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(packageRemark, value);
        }

        public Criteria andPackageRemarkLike(String value) {
            return like(packageRemark, value);
        }

        public Criteria andPackageRemarkNotLike(String value) {
            return notLike(packageRemark, value);
        }

        public Criteria andPackageRemarkIn(List<String> values) {
            return in(packageRemark, values);
        }

        public Criteria andPackageRemarkNotIn(List<String> values) {
            return notIn(packageRemark, values);
        }

        public Criteria andPackageRemarkBetween(String value1, String value2) {
            return between(packageRemark, value1, value2);
        }

        public Criteria andPackageRemarkNotBetween(String value1, String value2) {
            return notBetween(packageRemark, value1, value2);
        }
        public Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public Criteria andReceivedExpressCodeIsNull() {
            return isNull(receivedExpressCode);
        }

        public Criteria andReceivedExpressCodeIsNotNull() {
            return isNotNull(receivedExpressCode);
        }

        public Criteria andReceivedExpressCodeEqualTo(String value) {
            return equalTo(receivedExpressCode, value);
        }

        public Criteria andReceivedExpressCodeNotEqualTo(String value) {
            return notEqualTo(receivedExpressCode, value);
        }

        public Criteria andReceivedExpressCodeGreaterThan(String value) {
            return greaterThan(receivedExpressCode, value);
        }

        public Criteria andReceivedExpressCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receivedExpressCode, value);
        }

        public Criteria andReceivedExpressCodeLessThan(String value) {
            return lessThan(receivedExpressCode, value);
        }

        public Criteria andReceivedExpressCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receivedExpressCode, value);
        }

        public Criteria andReceivedExpressCodeLike(String value) {
            return like(receivedExpressCode, value);
        }

        public Criteria andReceivedExpressCodeNotLike(String value) {
            return notLike(receivedExpressCode, value);
        }

        public Criteria andReceivedExpressCodeIn(List<String> values) {
            return in(receivedExpressCode, values);
        }

        public Criteria andReceivedExpressCodeNotIn(List<String> values) {
            return notIn(receivedExpressCode, values);
        }

        public Criteria andReceivedExpressCodeBetween(String value1, String value2) {
            return between(receivedExpressCode, value1, value2);
        }

        public Criteria andReceivedExpressCodeNotBetween(String value1, String value2) {
            return notBetween(receivedExpressCode, value1, value2);
        }
        public Criteria andReceivedExpressIdIsNull() {
            return isNull(receivedExpressId);
        }

        public Criteria andReceivedExpressIdIsNotNull() {
            return isNotNull(receivedExpressId);
        }

        public Criteria andReceivedExpressIdEqualTo(Integer value) {
            return equalTo(receivedExpressId, value);
        }

        public Criteria andReceivedExpressIdNotEqualTo(Integer value) {
            return notEqualTo(receivedExpressId, value);
        }

        public Criteria andReceivedExpressIdGreaterThan(Integer value) {
            return greaterThan(receivedExpressId, value);
        }

        public Criteria andReceivedExpressIdGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(receivedExpressId, value);
        }

        public Criteria andReceivedExpressIdLessThan(Integer value) {
            return lessThan(receivedExpressId, value);
        }

        public Criteria andReceivedExpressIdLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(receivedExpressId, value);
        }

        public Criteria andReceivedExpressIdIn(List<Integer> values) {
            return in(receivedExpressId, values);
        }

        public Criteria andReceivedExpressIdNotIn(List<Integer> values) {
            return notIn(receivedExpressId, values);
        }

        public Criteria andReceivedExpressIdBetween(Integer value1, Integer value2) {
            return between(receivedExpressId, value1, value2);
        }

        public Criteria andReceivedExpressIdNotBetween(Integer value1, Integer value2) {
            return notBetween(receivedExpressId, value1, value2);
        }
        public Criteria andSendPhoneIsNull() {
            return isNull(sendPhone);
        }

        public Criteria andSendPhoneIsNotNull() {
            return isNotNull(sendPhone);
        }

        public Criteria andSendPhoneEqualTo(String value) {
            return equalTo(sendPhone, value);
        }

        public Criteria andSendPhoneNotEqualTo(String value) {
            return notEqualTo(sendPhone, value);
        }

        public Criteria andSendPhoneGreaterThan(String value) {
            return greaterThan(sendPhone, value);
        }

        public Criteria andSendPhoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sendPhone, value);
        }

        public Criteria andSendPhoneLessThan(String value) {
            return lessThan(sendPhone, value);
        }

        public Criteria andSendPhoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sendPhone, value);
        }

        public Criteria andSendPhoneLike(String value) {
            return like(sendPhone, value);
        }

        public Criteria andSendPhoneNotLike(String value) {
            return notLike(sendPhone, value);
        }

        public Criteria andSendPhoneIn(List<String> values) {
            return in(sendPhone, values);
        }

        public Criteria andSendPhoneNotIn(List<String> values) {
            return notIn(sendPhone, values);
        }

        public Criteria andSendPhoneBetween(String value1, String value2) {
            return between(sendPhone, value1, value2);
        }

        public Criteria andSendPhoneNotBetween(String value1, String value2) {
            return notBetween(sendPhone, value1, value2);
        }
        public Criteria andOrderPartitionIdIsNull() {
            return isNull(orderPartitionId);
        }

        public Criteria andOrderPartitionIdIsNotNull() {
            return isNotNull(orderPartitionId);
        }

        public Criteria andOrderPartitionIdEqualTo(String value) {
            return equalTo(orderPartitionId, value);
        }

        public Criteria andOrderPartitionIdNotEqualTo(String value) {
            return notEqualTo(orderPartitionId, value);
        }

        public Criteria andOrderPartitionIdGreaterThan(String value) {
            return greaterThan(orderPartitionId, value);
        }

        public Criteria andOrderPartitionIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(orderPartitionId, value);
        }

        public Criteria andOrderPartitionIdLessThan(String value) {
            return lessThan(orderPartitionId, value);
        }

        public Criteria andOrderPartitionIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(orderPartitionId, value);
        }

        public Criteria andOrderPartitionIdLike(String value) {
            return like(orderPartitionId, value);
        }

        public Criteria andOrderPartitionIdNotLike(String value) {
            return notLike(orderPartitionId, value);
        }

        public Criteria andOrderPartitionIdIn(List<String> values) {
            return in(orderPartitionId, values);
        }

        public Criteria andOrderPartitionIdNotIn(List<String> values) {
            return notIn(orderPartitionId, values);
        }

        public Criteria andOrderPartitionIdBetween(String value1, String value2) {
            return between(orderPartitionId, value1, value2);
        }

        public Criteria andOrderPartitionIdNotBetween(String value1, String value2) {
            return notBetween(orderPartitionId, value1, value2);
        }
        public Criteria andOrderCodeIsNull() {
            return isNull(orderCode);
        }

        public Criteria andOrderCodeIsNotNull() {
            return isNotNull(orderCode);
        }

        public Criteria andOrderCodeEqualTo(String value) {
            return equalTo(orderCode, value);
        }

        public Criteria andOrderCodeNotEqualTo(String value) {
            return notEqualTo(orderCode, value);
        }

        public Criteria andOrderCodeGreaterThan(String value) {
            return greaterThan(orderCode, value);
        }

        public Criteria andOrderCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(orderCode, value);
        }

        public Criteria andOrderCodeLessThan(String value) {
            return lessThan(orderCode, value);
        }

        public Criteria andOrderCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(orderCode, value);
        }

        public Criteria andOrderCodeLike(String value) {
            return like(orderCode, value);
        }

        public Criteria andOrderCodeNotLike(String value) {
            return notLike(orderCode, value);
        }

        public Criteria andOrderCodeIn(List<String> values) {
            return in(orderCode, values);
        }

        public Criteria andOrderCodeNotIn(List<String> values) {
            return notIn(orderCode, values);
        }

        public Criteria andOrderCodeBetween(String value1, String value2) {
            return between(orderCode, value1, value2);
        }

        public Criteria andOrderCodeNotBetween(String value1, String value2) {
            return notBetween(orderCode, value1, value2);
        }
        public Criteria andRefundIdIsNull() {
            return isNull(refundId);
        }

        public Criteria andRefundIdIsNotNull() {
            return isNotNull(refundId);
        }

        public Criteria andRefundIdEqualTo(Long value) {
            return equalTo(refundId, value);
        }

        public Criteria andRefundIdNotEqualTo(Long value) {
            return notEqualTo(refundId, value);
        }

        public Criteria andRefundIdGreaterThan(Long value) {
            return greaterThan(refundId, value);
        }

        public Criteria andRefundIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(refundId, value);
        }

        public Criteria andRefundIdLessThan(Long value) {
            return lessThan(refundId, value);
        }

        public Criteria andRefundIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(refundId, value);
        }

        public Criteria andRefundIdIn(List<Long> values) {
            return in(refundId, values);
        }

        public Criteria andRefundIdNotIn(List<Long> values) {
            return notIn(refundId, values);
        }

        public Criteria andRefundIdBetween(Long value1, Long value2) {
            return between(refundId, value1, value2);
        }

        public Criteria andRefundIdNotBetween(Long value1, Long value2) {
            return notBetween(refundId, value1, value2);
        }
        public Criteria andRelevanceStatusIsNull() {
            return isNull(relevanceStatus);
        }

        public Criteria andRelevanceStatusIsNotNull() {
            return isNotNull(relevanceStatus);
        }

        public Criteria andRelevanceStatusEqualTo(Integer value) {
            return equalTo(relevanceStatus, value);
        }

        public Criteria andRelevanceStatusNotEqualTo(Integer value) {
            return notEqualTo(relevanceStatus, value);
        }

        public Criteria andRelevanceStatusGreaterThan(Integer value) {
            return greaterThan(relevanceStatus, value);
        }

        public Criteria andRelevanceStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(relevanceStatus, value);
        }

        public Criteria andRelevanceStatusLessThan(Integer value) {
            return lessThan(relevanceStatus, value);
        }

        public Criteria andRelevanceStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(relevanceStatus, value);
        }

        public Criteria andRelevanceStatusIn(List<Integer> values) {
            return in(relevanceStatus, values);
        }

        public Criteria andRelevanceStatusNotIn(List<Integer> values) {
            return notIn(relevanceStatus, values);
        }

        public Criteria andRelevanceStatusBetween(Integer value1, Integer value2) {
            return between(relevanceStatus, value1, value2);
        }

        public Criteria andRelevanceStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(relevanceStatus, value1, value2);
        }
        public Criteria andDfOrderIdIsNull() {
            return isNull(dfOrderId);
        }

        public Criteria andDfOrderIdIsNotNull() {
            return isNotNull(dfOrderId);
        }

        public Criteria andDfOrderIdEqualTo(Long value) {
            return equalTo(dfOrderId, value);
        }

        public Criteria andDfOrderIdNotEqualTo(Long value) {
            return notEqualTo(dfOrderId, value);
        }

        public Criteria andDfOrderIdGreaterThan(Long value) {
            return greaterThan(dfOrderId, value);
        }

        public Criteria andDfOrderIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfOrderId, value);
        }

        public Criteria andDfOrderIdLessThan(Long value) {
            return lessThan(dfOrderId, value);
        }

        public Criteria andDfOrderIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfOrderId, value);
        }

        public Criteria andDfOrderIdIn(List<Long> values) {
            return in(dfOrderId, values);
        }

        public Criteria andDfOrderIdNotIn(List<Long> values) {
            return notIn(dfOrderId, values);
        }

        public Criteria andDfOrderIdBetween(Long value1, Long value2) {
            return between(dfOrderId, value1, value2);
        }

        public Criteria andDfOrderIdNotBetween(Long value1, Long value2) {
            return notBetween(dfOrderId, value1, value2);
        }
    }
}