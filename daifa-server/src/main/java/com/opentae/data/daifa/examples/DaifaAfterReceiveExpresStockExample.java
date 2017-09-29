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
    protected DaifaAfterReceiveExpresStockExample.Criteria createCriteriaInternal() {
        return new DaifaAfterReceiveExpresStockExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andStockLocationIsNull() {
            return isNull(stockLocation);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andStockLocationIsNotNull() {
            return isNotNull(stockLocation);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andStockLocationEqualTo(String value) {
            return equalTo(stockLocation, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andStockLocationNotEqualTo(String value) {
            return notEqualTo(stockLocation, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andStockLocationGreaterThan(String value) {
            return greaterThan(stockLocation, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andStockLocationGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(stockLocation, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andStockLocationLessThan(String value) {
            return lessThan(stockLocation, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andStockLocationLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(stockLocation, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andStockLocationLike(String value) {
            return like(stockLocation, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andStockLocationNotLike(String value) {
            return notLike(stockLocation, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andStockLocationIn(List<String> values) {
            return in(stockLocation, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andStockLocationNotIn(List<String> values) {
            return notIn(stockLocation, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andStockLocationBetween(String value1, String value2) {
            return between(stockLocation, value1, value2);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andStockLocationNotBetween(String value1, String value2) {
            return notBetween(stockLocation, value1, value2);
        }
        public DaifaAfterReceiveExpresStockExample.Criteria andTradeCodeIsNull() {
            return isNull(tradeCode);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andTradeCodeIsNotNull() {
            return isNotNull(tradeCode);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andTradeCodeEqualTo(String value) {
            return equalTo(tradeCode, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andTradeCodeNotEqualTo(String value) {
            return notEqualTo(tradeCode, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andTradeCodeGreaterThan(String value) {
            return greaterThan(tradeCode, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andTradeCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(tradeCode, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andTradeCodeLessThan(String value) {
            return lessThan(tradeCode, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andTradeCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(tradeCode, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andTradeCodeLike(String value) {
            return like(tradeCode, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andTradeCodeNotLike(String value) {
            return notLike(tradeCode, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andTradeCodeIn(List<String> values) {
            return in(tradeCode, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andTradeCodeNotIn(List<String> values) {
            return notIn(tradeCode, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andTradeCodeBetween(String value1, String value2) {
            return between(tradeCode, value1, value2);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andTradeCodeNotBetween(String value1, String value2) {
            return notBetween(tradeCode, value1, value2);
        }
        public DaifaAfterReceiveExpresStockExample.Criteria andDfTradeIdIsNull() {
            return isNull(dfTradeId);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andDfTradeIdIsNotNull() {
            return isNotNull(dfTradeId);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andDfTradeIdEqualTo(Long value) {
            return equalTo(dfTradeId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andDfTradeIdNotEqualTo(Long value) {
            return notEqualTo(dfTradeId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andDfTradeIdGreaterThan(Long value) {
            return greaterThan(dfTradeId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andDfTradeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfTradeId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andDfTradeIdLessThan(Long value) {
            return lessThan(dfTradeId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andDfTradeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfTradeId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andDfTradeIdIn(List<Long> values) {
            return in(dfTradeId, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andDfTradeIdNotIn(List<Long> values) {
            return notIn(dfTradeId, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andDfTradeIdBetween(Long value1, Long value2) {
            return between(dfTradeId, value1, value2);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andDfTradeIdNotBetween(Long value1, Long value2) {
            return notBetween(dfTradeId, value1, value2);
        }
        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressNameIsNull() {
            return isNull(receivedExpressName);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressNameIsNotNull() {
            return isNotNull(receivedExpressName);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressNameEqualTo(String value) {
            return equalTo(receivedExpressName, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressNameNotEqualTo(String value) {
            return notEqualTo(receivedExpressName, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressNameGreaterThan(String value) {
            return greaterThan(receivedExpressName, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receivedExpressName, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressNameLessThan(String value) {
            return lessThan(receivedExpressName, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receivedExpressName, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressNameLike(String value) {
            return like(receivedExpressName, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressNameNotLike(String value) {
            return notLike(receivedExpressName, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressNameIn(List<String> values) {
            return in(receivedExpressName, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressNameNotIn(List<String> values) {
            return notIn(receivedExpressName, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressNameBetween(String value1, String value2) {
            return between(receivedExpressName, value1, value2);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressNameNotBetween(String value1, String value2) {
            return notBetween(receivedExpressName, value1, value2);
        }
        public DaifaAfterReceiveExpresStockExample.Criteria andPackageRemarkIsNull() {
            return isNull(packageRemark);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andPackageRemarkIsNotNull() {
            return isNotNull(packageRemark);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andPackageRemarkEqualTo(String value) {
            return equalTo(packageRemark, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andPackageRemarkNotEqualTo(String value) {
            return notEqualTo(packageRemark, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andPackageRemarkGreaterThan(String value) {
            return greaterThan(packageRemark, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andPackageRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(packageRemark, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andPackageRemarkLessThan(String value) {
            return lessThan(packageRemark, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andPackageRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(packageRemark, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andPackageRemarkLike(String value) {
            return like(packageRemark, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andPackageRemarkNotLike(String value) {
            return notLike(packageRemark, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andPackageRemarkIn(List<String> values) {
            return in(packageRemark, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andPackageRemarkNotIn(List<String> values) {
            return notIn(packageRemark, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andPackageRemarkBetween(String value1, String value2) {
            return between(packageRemark, value1, value2);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andPackageRemarkNotBetween(String value1, String value2) {
            return notBetween(packageRemark, value1, value2);
        }
        public DaifaAfterReceiveExpresStockExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressCodeIsNull() {
            return isNull(receivedExpressCode);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressCodeIsNotNull() {
            return isNotNull(receivedExpressCode);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressCodeEqualTo(String value) {
            return equalTo(receivedExpressCode, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressCodeNotEqualTo(String value) {
            return notEqualTo(receivedExpressCode, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressCodeGreaterThan(String value) {
            return greaterThan(receivedExpressCode, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receivedExpressCode, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressCodeLessThan(String value) {
            return lessThan(receivedExpressCode, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receivedExpressCode, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressCodeLike(String value) {
            return like(receivedExpressCode, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressCodeNotLike(String value) {
            return notLike(receivedExpressCode, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressCodeIn(List<String> values) {
            return in(receivedExpressCode, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressCodeNotIn(List<String> values) {
            return notIn(receivedExpressCode, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressCodeBetween(String value1, String value2) {
            return between(receivedExpressCode, value1, value2);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressCodeNotBetween(String value1, String value2) {
            return notBetween(receivedExpressCode, value1, value2);
        }
        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressIdIsNull() {
            return isNull(receivedExpressId);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressIdIsNotNull() {
            return isNotNull(receivedExpressId);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressIdEqualTo(Integer value) {
            return equalTo(receivedExpressId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressIdNotEqualTo(Integer value) {
            return notEqualTo(receivedExpressId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressIdGreaterThan(Integer value) {
            return greaterThan(receivedExpressId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressIdGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(receivedExpressId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressIdLessThan(Integer value) {
            return lessThan(receivedExpressId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressIdLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(receivedExpressId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressIdIn(List<Integer> values) {
            return in(receivedExpressId, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressIdNotIn(List<Integer> values) {
            return notIn(receivedExpressId, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressIdBetween(Integer value1, Integer value2) {
            return between(receivedExpressId, value1, value2);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andReceivedExpressIdNotBetween(Integer value1, Integer value2) {
            return notBetween(receivedExpressId, value1, value2);
        }
        public DaifaAfterReceiveExpresStockExample.Criteria andSendPhoneIsNull() {
            return isNull(sendPhone);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andSendPhoneIsNotNull() {
            return isNotNull(sendPhone);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andSendPhoneEqualTo(String value) {
            return equalTo(sendPhone, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andSendPhoneNotEqualTo(String value) {
            return notEqualTo(sendPhone, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andSendPhoneGreaterThan(String value) {
            return greaterThan(sendPhone, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andSendPhoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sendPhone, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andSendPhoneLessThan(String value) {
            return lessThan(sendPhone, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andSendPhoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sendPhone, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andSendPhoneLike(String value) {
            return like(sendPhone, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andSendPhoneNotLike(String value) {
            return notLike(sendPhone, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andSendPhoneIn(List<String> values) {
            return in(sendPhone, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andSendPhoneNotIn(List<String> values) {
            return notIn(sendPhone, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andSendPhoneBetween(String value1, String value2) {
            return between(sendPhone, value1, value2);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andSendPhoneNotBetween(String value1, String value2) {
            return notBetween(sendPhone, value1, value2);
        }
        public DaifaAfterReceiveExpresStockExample.Criteria andOrderPartitionIdIsNull() {
            return isNull(orderPartitionId);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderPartitionIdIsNotNull() {
            return isNotNull(orderPartitionId);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderPartitionIdEqualTo(String value) {
            return equalTo(orderPartitionId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderPartitionIdNotEqualTo(String value) {
            return notEqualTo(orderPartitionId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderPartitionIdGreaterThan(String value) {
            return greaterThan(orderPartitionId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderPartitionIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(orderPartitionId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderPartitionIdLessThan(String value) {
            return lessThan(orderPartitionId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderPartitionIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(orderPartitionId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderPartitionIdLike(String value) {
            return like(orderPartitionId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderPartitionIdNotLike(String value) {
            return notLike(orderPartitionId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderPartitionIdIn(List<String> values) {
            return in(orderPartitionId, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderPartitionIdNotIn(List<String> values) {
            return notIn(orderPartitionId, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderPartitionIdBetween(String value1, String value2) {
            return between(orderPartitionId, value1, value2);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderPartitionIdNotBetween(String value1, String value2) {
            return notBetween(orderPartitionId, value1, value2);
        }
        public DaifaAfterReceiveExpresStockExample.Criteria andOrderCodeIsNull() {
            return isNull(orderCode);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderCodeIsNotNull() {
            return isNotNull(orderCode);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderCodeEqualTo(String value) {
            return equalTo(orderCode, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderCodeNotEqualTo(String value) {
            return notEqualTo(orderCode, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderCodeGreaterThan(String value) {
            return greaterThan(orderCode, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(orderCode, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderCodeLessThan(String value) {
            return lessThan(orderCode, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(orderCode, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderCodeLike(String value) {
            return like(orderCode, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderCodeNotLike(String value) {
            return notLike(orderCode, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderCodeIn(List<String> values) {
            return in(orderCode, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderCodeNotIn(List<String> values) {
            return notIn(orderCode, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderCodeBetween(String value1, String value2) {
            return between(orderCode, value1, value2);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andOrderCodeNotBetween(String value1, String value2) {
            return notBetween(orderCode, value1, value2);
        }
        public DaifaAfterReceiveExpresStockExample.Criteria andRefundIdIsNull() {
            return isNull(refundId);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andRefundIdIsNotNull() {
            return isNotNull(refundId);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andRefundIdEqualTo(Long value) {
            return equalTo(refundId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andRefundIdNotEqualTo(Long value) {
            return notEqualTo(refundId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andRefundIdGreaterThan(Long value) {
            return greaterThan(refundId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andRefundIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(refundId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andRefundIdLessThan(Long value) {
            return lessThan(refundId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andRefundIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(refundId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andRefundIdIn(List<Long> values) {
            return in(refundId, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andRefundIdNotIn(List<Long> values) {
            return notIn(refundId, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andRefundIdBetween(Long value1, Long value2) {
            return between(refundId, value1, value2);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andRefundIdNotBetween(Long value1, Long value2) {
            return notBetween(refundId, value1, value2);
        }
        public DaifaAfterReceiveExpresStockExample.Criteria andRelevanceStatusIsNull() {
            return isNull(relevanceStatus);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andRelevanceStatusIsNotNull() {
            return isNotNull(relevanceStatus);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andRelevanceStatusEqualTo(Integer value) {
            return equalTo(relevanceStatus, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andRelevanceStatusNotEqualTo(Integer value) {
            return notEqualTo(relevanceStatus, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andRelevanceStatusGreaterThan(Integer value) {
            return greaterThan(relevanceStatus, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andRelevanceStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(relevanceStatus, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andRelevanceStatusLessThan(Integer value) {
            return lessThan(relevanceStatus, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andRelevanceStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(relevanceStatus, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andRelevanceStatusIn(List<Integer> values) {
            return in(relevanceStatus, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andRelevanceStatusNotIn(List<Integer> values) {
            return notIn(relevanceStatus, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andRelevanceStatusBetween(Integer value1, Integer value2) {
            return between(relevanceStatus, value1, value2);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andRelevanceStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(relevanceStatus, value1, value2);
        }
        public DaifaAfterReceiveExpresStockExample.Criteria andDfOrderIdIsNull() {
            return isNull(dfOrderId);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andDfOrderIdIsNotNull() {
            return isNotNull(dfOrderId);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andDfOrderIdEqualTo(Long value) {
            return equalTo(dfOrderId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andDfOrderIdNotEqualTo(Long value) {
            return notEqualTo(dfOrderId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andDfOrderIdGreaterThan(Long value) {
            return greaterThan(dfOrderId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andDfOrderIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfOrderId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andDfOrderIdLessThan(Long value) {
            return lessThan(dfOrderId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andDfOrderIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfOrderId, value);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andDfOrderIdIn(List<Long> values) {
            return in(dfOrderId, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andDfOrderIdNotIn(List<Long> values) {
            return notIn(dfOrderId, values);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andDfOrderIdBetween(Long value1, Long value2) {
            return between(dfOrderId, value1, value2);
        }

        public DaifaAfterReceiveExpresStockExample.Criteria andDfOrderIdNotBetween(Long value1, Long value2) {
            return notBetween(dfOrderId, value1, value2);
        }
    }
}