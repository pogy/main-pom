package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaSend;

import java.util.*;
public class DaifaSendExample extends SgExample<DaifaSendExample.Criteria> {
    public static final Class<DaifaSend> beanClass = DaifaSend.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn sendId;
    public static EntityColumn dfTradeId;
    public static EntityColumn sellerId;
    public static EntityColumn daifaSendCode;
    public static EntityColumn sendStatus;
    public static EntityColumn createDate;
    public static EntityColumn createTime;
    public static EntityColumn sendDate;
    public static EntityColumn sendTime;
    public static EntityColumn money;
    public static EntityColumn buyerId;
    public static EntityColumn expressId;
    public static EntityColumn expressName;
    public static EntityColumn expressCode;
    public static EntityColumn expressFee;
    public static EntityColumn receiverState;
    public static EntityColumn receiverAddress;
    public static EntityColumn receiverName;
    public static EntityColumn receiverZip;
    public static EntityColumn receiverPhone;
    public static EntityColumn buyerRemark;
    public static EntityColumn printStatus;
    public static EntityColumn markDestination;
    public static EntityColumn packageName;
    public static EntityColumn remark1;
    public static EntityColumn remark2;
    public static EntityColumn taobaoUserNick;
    public static EntityColumn taobaoTid;
    public static EntityColumn buyerName;
    public static EntityColumn buyerTelephone;
    public static EntityColumn buyerQq;
    public static EntityColumn buyerWw;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        sendId = listMap.get("sendId");
        dfTradeId = listMap.get("dfTradeId");
        sellerId = listMap.get("sellerId");
        daifaSendCode = listMap.get("daifaSendCode");
        sendStatus = listMap.get("sendStatus");
        createDate = listMap.get("createDate");
        createTime = listMap.get("createTime");
        sendDate = listMap.get("sendDate");
        sendTime = listMap.get("sendTime");
        money = listMap.get("money");
        buyerId = listMap.get("buyerId");
        expressId = listMap.get("expressId");
        expressName = listMap.get("expressName");
        expressCode = listMap.get("expressCode");
        expressFee = listMap.get("expressFee");
        receiverState = listMap.get("receiverState");
        receiverAddress = listMap.get("receiverAddress");
        receiverName = listMap.get("receiverName");
        receiverZip = listMap.get("receiverZip");
        receiverPhone = listMap.get("receiverPhone");
        buyerRemark = listMap.get("buyerRemark");
        printStatus = listMap.get("printStatus");
        markDestination = listMap.get("markDestination");
        packageName = listMap.get("packageName");
        remark1 = listMap.get("remark1");
        remark2 = listMap.get("remark2");
        taobaoUserNick = listMap.get("taobaoUserNick");
        taobaoTid = listMap.get("taobaoTid");
        buyerName = listMap.get("buyerName");
        buyerTelephone = listMap.get("buyerTelephone");
        buyerQq = listMap.get("buyerQq");
        buyerWw = listMap.get("buyerWw");
    }

    public DaifaSendExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaSendExample.Criteria createCriteriaInternal() {
        return new DaifaSendExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaSendExample.Criteria andSendIdIsNull() {
            return isNull(sendId);
        }

        public DaifaSendExample.Criteria andSendIdIsNotNull() {
            return isNotNull(sendId);
        }

        public DaifaSendExample.Criteria andSendIdEqualTo(Long value) {
            return equalTo(sendId, value);
        }

        public DaifaSendExample.Criteria andSendIdNotEqualTo(Long value) {
            return notEqualTo(sendId, value);
        }

        public DaifaSendExample.Criteria andSendIdGreaterThan(Long value) {
            return greaterThan(sendId, value);
        }

        public DaifaSendExample.Criteria andSendIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sendId, value);
        }

        public DaifaSendExample.Criteria andSendIdLessThan(Long value) {
            return lessThan(sendId, value);
        }

        public DaifaSendExample.Criteria andSendIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sendId, value);
        }

        public DaifaSendExample.Criteria andSendIdLike(String value) {
            return like(sendId, value);
        }

        public DaifaSendExample.Criteria andSendIdNotLike(String value) {
            return notLike(sendId, value);
        }

        public DaifaSendExample.Criteria andSendIdIn(List<Long> values) {
            return in(sendId, values);
        }

        public DaifaSendExample.Criteria andSendIdNotIn(List<Long> values) {
            return notIn(sendId, values);
        }

        public DaifaSendExample.Criteria andSendIdBetween(Long value1, Long value2) {
            return between(sendId, value1, value2);
        }

        public DaifaSendExample.Criteria andSendIdNotBetween(Long value1, Long value2) {
            return notBetween(sendId, value1, value2);
        }
        public DaifaSendExample.Criteria andDfTradeIdIsNull() {
            return isNull(dfTradeId);
        }

        public DaifaSendExample.Criteria andDfTradeIdIsNotNull() {
            return isNotNull(dfTradeId);
        }

        public DaifaSendExample.Criteria andDfTradeIdEqualTo(Long value) {
            return equalTo(dfTradeId, value);
        }

        public DaifaSendExample.Criteria andDfTradeIdNotEqualTo(Long value) {
            return notEqualTo(dfTradeId, value);
        }

        public DaifaSendExample.Criteria andDfTradeIdGreaterThan(Long value) {
            return greaterThan(dfTradeId, value);
        }

        public DaifaSendExample.Criteria andDfTradeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfTradeId, value);
        }

        public DaifaSendExample.Criteria andDfTradeIdLessThan(Long value) {
            return lessThan(dfTradeId, value);
        }

        public DaifaSendExample.Criteria andDfTradeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfTradeId, value);
        }

        public DaifaSendExample.Criteria andDfTradeIdLike(String value) {
            return like(dfTradeId, value);
        }

        public DaifaSendExample.Criteria andDfTradeIdNotLike(String value) {
            return notLike(dfTradeId, value);
        }

        public DaifaSendExample.Criteria andDfTradeIdIn(List<Long> values) {
            return in(dfTradeId, values);
        }

        public DaifaSendExample.Criteria andDfTradeIdNotIn(List<Long> values) {
            return notIn(dfTradeId, values);
        }

        public DaifaSendExample.Criteria andDfTradeIdBetween(Long value1, Long value2) {
            return between(dfTradeId, value1, value2);
        }

        public DaifaSendExample.Criteria andDfTradeIdNotBetween(Long value1, Long value2) {
            return notBetween(dfTradeId, value1, value2);
        }
        public DaifaSendExample.Criteria andSellerIdIsNull() {
            return isNull(sellerId);
        }

        public DaifaSendExample.Criteria andSellerIdIsNotNull() {
            return isNotNull(sellerId);
        }

        public DaifaSendExample.Criteria andSellerIdEqualTo(Long value) {
            return equalTo(sellerId, value);
        }

        public DaifaSendExample.Criteria andSellerIdNotEqualTo(Long value) {
            return notEqualTo(sellerId, value);
        }

        public DaifaSendExample.Criteria andSellerIdGreaterThan(Long value) {
            return greaterThan(sellerId, value);
        }

        public DaifaSendExample.Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerId, value);
        }

        public DaifaSendExample.Criteria andSellerIdLessThan(Long value) {
            return lessThan(sellerId, value);
        }

        public DaifaSendExample.Criteria andSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerId, value);
        }

        public DaifaSendExample.Criteria andSellerIdLike(String value) {
            return like(sellerId, value);
        }

        public DaifaSendExample.Criteria andSellerIdNotLike(String value) {
            return notLike(sellerId, value);
        }

        public DaifaSendExample.Criteria andSellerIdIn(List<Long> values) {
            return in(sellerId, values);
        }

        public DaifaSendExample.Criteria andSellerIdNotIn(List<Long> values) {
            return notIn(sellerId, values);
        }

        public DaifaSendExample.Criteria andSellerIdBetween(Long value1, Long value2) {
            return between(sellerId, value1, value2);
        }

        public DaifaSendExample.Criteria andSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(sellerId, value1, value2);
        }
        public DaifaSendExample.Criteria andDaifaSendCodeIsNull() {
            return isNull(daifaSendCode);
        }

        public DaifaSendExample.Criteria andDaifaSendCodeIsNotNull() {
            return isNotNull(daifaSendCode);
        }

        public DaifaSendExample.Criteria andDaifaSendCodeEqualTo(String value) {
            return equalTo(daifaSendCode, value);
        }

        public DaifaSendExample.Criteria andDaifaSendCodeNotEqualTo(String value) {
            return notEqualTo(daifaSendCode, value);
        }

        public DaifaSendExample.Criteria andDaifaSendCodeGreaterThan(String value) {
            return greaterThan(daifaSendCode, value);
        }

        public DaifaSendExample.Criteria andDaifaSendCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(daifaSendCode, value);
        }

        public DaifaSendExample.Criteria andDaifaSendCodeLessThan(String value) {
            return lessThan(daifaSendCode, value);
        }

        public DaifaSendExample.Criteria andDaifaSendCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(daifaSendCode, value);
        }

        public DaifaSendExample.Criteria andDaifaSendCodeLike(String value) {
            return like(daifaSendCode, value);
        }

        public DaifaSendExample.Criteria andDaifaSendCodeNotLike(String value) {
            return notLike(daifaSendCode, value);
        }

        public DaifaSendExample.Criteria andDaifaSendCodeIn(List<String> values) {
            return in(daifaSendCode, values);
        }

        public DaifaSendExample.Criteria andDaifaSendCodeNotIn(List<String> values) {
            return notIn(daifaSendCode, values);
        }

        public DaifaSendExample.Criteria andDaifaSendCodeBetween(String value1, String value2) {
            return between(daifaSendCode, value1, value2);
        }

        public DaifaSendExample.Criteria andDaifaSendCodeNotBetween(String value1, String value2) {
            return notBetween(daifaSendCode, value1, value2);
        }
        public DaifaSendExample.Criteria andSendStatusIsNull() {
            return isNull(sendStatus);
        }

        public DaifaSendExample.Criteria andSendStatusIsNotNull() {
            return isNotNull(sendStatus);
        }

        public DaifaSendExample.Criteria andSendStatusEqualTo(Integer value) {
            return equalTo(sendStatus, value);
        }

        public DaifaSendExample.Criteria andSendStatusNotEqualTo(Integer value) {
            return notEqualTo(sendStatus, value);
        }

        public DaifaSendExample.Criteria andSendStatusGreaterThan(Integer value) {
            return greaterThan(sendStatus, value);
        }

        public DaifaSendExample.Criteria andSendStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sendStatus, value);
        }

        public DaifaSendExample.Criteria andSendStatusLessThan(Integer value) {
            return lessThan(sendStatus, value);
        }

        public DaifaSendExample.Criteria andSendStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sendStatus, value);
        }

        public DaifaSendExample.Criteria andSendStatusIn(List<Integer> values) {
            return in(sendStatus, values);
        }

        public DaifaSendExample.Criteria andSendStatusNotIn(List<Integer> values) {
            return notIn(sendStatus, values);
        }

        public DaifaSendExample.Criteria andSendStatusBetween(Integer value1, Integer value2) {
            return between(sendStatus, value1, value2);
        }

        public DaifaSendExample.Criteria andSendStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(sendStatus, value1, value2);
        }
        public DaifaSendExample.Criteria andCreateDateIsNull() {
            return isNull(createDate);
        }

        public DaifaSendExample.Criteria andCreateDateIsNotNull() {
            return isNotNull(createDate);
        }

        public DaifaSendExample.Criteria andCreateDateEqualTo(String value) {
            return equalTo(createDate, value);
        }

        public DaifaSendExample.Criteria andCreateDateNotEqualTo(String value) {
            return notEqualTo(createDate, value);
        }

        public DaifaSendExample.Criteria andCreateDateGreaterThan(String value) {
            return greaterThan(createDate, value);
        }

        public DaifaSendExample.Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(createDate, value);
        }

        public DaifaSendExample.Criteria andCreateDateLessThan(String value) {
            return lessThan(createDate, value);
        }

        public DaifaSendExample.Criteria andCreateDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(createDate, value);
        }

        public DaifaSendExample.Criteria andCreateDateLike(String value) {
            return like(createDate, value);
        }

        public DaifaSendExample.Criteria andCreateDateNotLike(String value) {
            return notLike(createDate, value);
        }

        public DaifaSendExample.Criteria andCreateDateIn(List<String> values) {
            return in(createDate, values);
        }

        public DaifaSendExample.Criteria andCreateDateNotIn(List<String> values) {
            return notIn(createDate, values);
        }

        public DaifaSendExample.Criteria andCreateDateBetween(String value1, String value2) {
            return between(createDate, value1, value2);
        }

        public DaifaSendExample.Criteria andCreateDateNotBetween(String value1, String value2) {
            return notBetween(createDate, value1, value2);
        }
        public DaifaSendExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaSendExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaSendExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public DaifaSendExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaSendExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaSendExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaSendExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public DaifaSendExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaSendExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public DaifaSendExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public DaifaSendExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaSendExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public DaifaSendExample.Criteria andSendDateIsNull() {
            return isNull(sendDate);
        }

        public DaifaSendExample.Criteria andSendDateIsNotNull() {
            return isNotNull(sendDate);
        }

        public DaifaSendExample.Criteria andSendDateEqualTo(String value) {
            return equalTo(sendDate, value);
        }

        public DaifaSendExample.Criteria andSendDateNotEqualTo(String value) {
            return notEqualTo(sendDate, value);
        }

        public DaifaSendExample.Criteria andSendDateGreaterThan(String value) {
            return greaterThan(sendDate, value);
        }

        public DaifaSendExample.Criteria andSendDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sendDate, value);
        }

        public DaifaSendExample.Criteria andSendDateLessThan(String value) {
            return lessThan(sendDate, value);
        }

        public DaifaSendExample.Criteria andSendDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sendDate, value);
        }

        public DaifaSendExample.Criteria andSendDateLike(String value) {
            return like(sendDate, value);
        }

        public DaifaSendExample.Criteria andSendDateNotLike(String value) {
            return notLike(sendDate, value);
        }

        public DaifaSendExample.Criteria andSendDateIn(List<String> values) {
            return in(sendDate, values);
        }

        public DaifaSendExample.Criteria andSendDateNotIn(List<String> values) {
            return notIn(sendDate, values);
        }

        public DaifaSendExample.Criteria andSendDateBetween(String value1, String value2) {
            return between(sendDate, value1, value2);
        }

        public DaifaSendExample.Criteria andSendDateNotBetween(String value1, String value2) {
            return notBetween(sendDate, value1, value2);
        }
        public DaifaSendExample.Criteria andSendTimeIsNull() {
            return isNull(sendTime);
        }

        public DaifaSendExample.Criteria andSendTimeIsNotNull() {
            return isNotNull(sendTime);
        }

        public DaifaSendExample.Criteria andSendTimeEqualTo(Date value) {
            return equalTo(sendTime, value);
        }

        public DaifaSendExample.Criteria andSendTimeNotEqualTo(Date value) {
            return notEqualTo(sendTime, value);
        }

        public DaifaSendExample.Criteria andSendTimeGreaterThan(Date value) {
            return greaterThan(sendTime, value);
        }

        public DaifaSendExample.Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(sendTime, value);
        }

        public DaifaSendExample.Criteria andSendTimeLessThan(Date value) {
            return lessThan(sendTime, value);
        }

        public DaifaSendExample.Criteria andSendTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(sendTime, value);
        }

        public DaifaSendExample.Criteria andSendTimeIn(List<Date> values) {
            return in(sendTime, values);
        }

        public DaifaSendExample.Criteria andSendTimeNotIn(List<Date> values) {
            return notIn(sendTime, values);
        }

        public DaifaSendExample.Criteria andSendTimeBetween(Date value1, Date value2) {
            return between(sendTime, value1, value2);
        }

        public DaifaSendExample.Criteria andSendTimeNotBetween(Date value1, Date value2) {
            return notBetween(sendTime, value1, value2);
        }
        public DaifaSendExample.Criteria andMoneyIsNull() {
            return isNull(money);
        }

        public DaifaSendExample.Criteria andMoneyIsNotNull() {
            return isNotNull(money);
        }

        public DaifaSendExample.Criteria andMoneyEqualTo(String value) {
            return equalTo(money, value);
        }

        public DaifaSendExample.Criteria andMoneyNotEqualTo(String value) {
            return notEqualTo(money, value);
        }

        public DaifaSendExample.Criteria andMoneyGreaterThan(String value) {
            return greaterThan(money, value);
        }

        public DaifaSendExample.Criteria andMoneyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(money, value);
        }

        public DaifaSendExample.Criteria andMoneyLessThan(String value) {
            return lessThan(money, value);
        }

        public DaifaSendExample.Criteria andMoneyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(money, value);
        }

        public DaifaSendExample.Criteria andMoneyLike(String value) {
            return like(money, value);
        }

        public DaifaSendExample.Criteria andMoneyNotLike(String value) {
            return notLike(money, value);
        }

        public DaifaSendExample.Criteria andMoneyIn(List<String> values) {
            return in(money, values);
        }

        public DaifaSendExample.Criteria andMoneyNotIn(List<String> values) {
            return notIn(money, values);
        }

        public DaifaSendExample.Criteria andMoneyBetween(String value1, String value2) {
            return between(money, value1, value2);
        }

        public DaifaSendExample.Criteria andMoneyNotBetween(String value1, String value2) {
            return notBetween(money, value1, value2);
        }
        public DaifaSendExample.Criteria andBuyerIdIsNull() {
            return isNull(buyerId);
        }

        public DaifaSendExample.Criteria andBuyerIdIsNotNull() {
            return isNotNull(buyerId);
        }

        public DaifaSendExample.Criteria andBuyerIdEqualTo(Long value) {
            return equalTo(buyerId, value);
        }

        public DaifaSendExample.Criteria andBuyerIdNotEqualTo(Long value) {
            return notEqualTo(buyerId, value);
        }

        public DaifaSendExample.Criteria andBuyerIdGreaterThan(Long value) {
            return greaterThan(buyerId, value);
        }

        public DaifaSendExample.Criteria andBuyerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(buyerId, value);
        }

        public DaifaSendExample.Criteria andBuyerIdLessThan(Long value) {
            return lessThan(buyerId, value);
        }

        public DaifaSendExample.Criteria andBuyerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(buyerId, value);
        }

        public DaifaSendExample.Criteria andBuyerIdLike(String value) {
            return like(buyerId, value);
        }

        public DaifaSendExample.Criteria andBuyerIdNotLike(String value) {
            return notLike(buyerId, value);
        }

        public DaifaSendExample.Criteria andBuyerIdIn(List<Long> values) {
            return in(buyerId, values);
        }

        public DaifaSendExample.Criteria andBuyerIdNotIn(List<Long> values) {
            return notIn(buyerId, values);
        }

        public DaifaSendExample.Criteria andBuyerIdBetween(Long value1, Long value2) {
            return between(buyerId, value1, value2);
        }

        public DaifaSendExample.Criteria andBuyerIdNotBetween(Long value1, Long value2) {
            return notBetween(buyerId, value1, value2);
        }
        public DaifaSendExample.Criteria andExpressIdIsNull() {
            return isNull(expressId);
        }

        public DaifaSendExample.Criteria andExpressIdIsNotNull() {
            return isNotNull(expressId);
        }

        public DaifaSendExample.Criteria andExpressIdEqualTo(Long value) {
            return equalTo(expressId, value);
        }

        public DaifaSendExample.Criteria andExpressIdNotEqualTo(Long value) {
            return notEqualTo(expressId, value);
        }

        public DaifaSendExample.Criteria andExpressIdGreaterThan(Long value) {
            return greaterThan(expressId, value);
        }

        public DaifaSendExample.Criteria andExpressIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(expressId, value);
        }

        public DaifaSendExample.Criteria andExpressIdLessThan(Long value) {
            return lessThan(expressId, value);
        }

        public DaifaSendExample.Criteria andExpressIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(expressId, value);
        }

        public DaifaSendExample.Criteria andExpressIdLike(String value) {
            return like(expressId, value);
        }

        public DaifaSendExample.Criteria andExpressIdNotLike(String value) {
            return notLike(expressId, value);
        }

        public DaifaSendExample.Criteria andExpressIdIn(List<Long> values) {
            return in(expressId, values);
        }

        public DaifaSendExample.Criteria andExpressIdNotIn(List<Long> values) {
            return notIn(expressId, values);
        }

        public DaifaSendExample.Criteria andExpressIdBetween(Long value1, Long value2) {
            return between(expressId, value1, value2);
        }

        public DaifaSendExample.Criteria andExpressIdNotBetween(Long value1, Long value2) {
            return notBetween(expressId, value1, value2);
        }
        public DaifaSendExample.Criteria andExpressNameIsNull() {
            return isNull(expressName);
        }

        public DaifaSendExample.Criteria andExpressNameIsNotNull() {
            return isNotNull(expressName);
        }

        public DaifaSendExample.Criteria andExpressNameEqualTo(String value) {
            return equalTo(expressName, value);
        }

        public DaifaSendExample.Criteria andExpressNameNotEqualTo(String value) {
            return notEqualTo(expressName, value);
        }

        public DaifaSendExample.Criteria andExpressNameGreaterThan(String value) {
            return greaterThan(expressName, value);
        }

        public DaifaSendExample.Criteria andExpressNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressName, value);
        }

        public DaifaSendExample.Criteria andExpressNameLessThan(String value) {
            return lessThan(expressName, value);
        }

        public DaifaSendExample.Criteria andExpressNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressName, value);
        }

        public DaifaSendExample.Criteria andExpressNameLike(String value) {
            return like(expressName, value);
        }

        public DaifaSendExample.Criteria andExpressNameNotLike(String value) {
            return notLike(expressName, value);
        }

        public DaifaSendExample.Criteria andExpressNameIn(List<String> values) {
            return in(expressName, values);
        }

        public DaifaSendExample.Criteria andExpressNameNotIn(List<String> values) {
            return notIn(expressName, values);
        }

        public DaifaSendExample.Criteria andExpressNameBetween(String value1, String value2) {
            return between(expressName, value1, value2);
        }

        public DaifaSendExample.Criteria andExpressNameNotBetween(String value1, String value2) {
            return notBetween(expressName, value1, value2);
        }
        public DaifaSendExample.Criteria andExpressCodeIsNull() {
            return isNull(expressCode);
        }

        public DaifaSendExample.Criteria andExpressCodeIsNotNull() {
            return isNotNull(expressCode);
        }

        public DaifaSendExample.Criteria andExpressCodeEqualTo(String value) {
            return equalTo(expressCode, value);
        }

        public DaifaSendExample.Criteria andExpressCodeNotEqualTo(String value) {
            return notEqualTo(expressCode, value);
        }

        public DaifaSendExample.Criteria andExpressCodeGreaterThan(String value) {
            return greaterThan(expressCode, value);
        }

        public DaifaSendExample.Criteria andExpressCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressCode, value);
        }

        public DaifaSendExample.Criteria andExpressCodeLessThan(String value) {
            return lessThan(expressCode, value);
        }

        public DaifaSendExample.Criteria andExpressCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressCode, value);
        }

        public DaifaSendExample.Criteria andExpressCodeLike(String value) {
            return like(expressCode, value);
        }

        public DaifaSendExample.Criteria andExpressCodeNotLike(String value) {
            return notLike(expressCode, value);
        }

        public DaifaSendExample.Criteria andExpressCodeIn(List<String> values) {
            return in(expressCode, values);
        }

        public DaifaSendExample.Criteria andExpressCodeNotIn(List<String> values) {
            return notIn(expressCode, values);
        }

        public DaifaSendExample.Criteria andExpressCodeBetween(String value1, String value2) {
            return between(expressCode, value1, value2);
        }

        public DaifaSendExample.Criteria andExpressCodeNotBetween(String value1, String value2) {
            return notBetween(expressCode, value1, value2);
        }
        public DaifaSendExample.Criteria andExpressFeeIsNull() {
            return isNull(expressFee);
        }

        public DaifaSendExample.Criteria andExpressFeeIsNotNull() {
            return isNotNull(expressFee);
        }

        public DaifaSendExample.Criteria andExpressFeeEqualTo(String value) {
            return equalTo(expressFee, value);
        }

        public DaifaSendExample.Criteria andExpressFeeNotEqualTo(String value) {
            return notEqualTo(expressFee, value);
        }

        public DaifaSendExample.Criteria andExpressFeeGreaterThan(String value) {
            return greaterThan(expressFee, value);
        }

        public DaifaSendExample.Criteria andExpressFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressFee, value);
        }

        public DaifaSendExample.Criteria andExpressFeeLessThan(String value) {
            return lessThan(expressFee, value);
        }

        public DaifaSendExample.Criteria andExpressFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressFee, value);
        }

        public DaifaSendExample.Criteria andExpressFeeLike(String value) {
            return like(expressFee, value);
        }

        public DaifaSendExample.Criteria andExpressFeeNotLike(String value) {
            return notLike(expressFee, value);
        }

        public DaifaSendExample.Criteria andExpressFeeIn(List<String> values) {
            return in(expressFee, values);
        }

        public DaifaSendExample.Criteria andExpressFeeNotIn(List<String> values) {
            return notIn(expressFee, values);
        }

        public DaifaSendExample.Criteria andExpressFeeBetween(String value1, String value2) {
            return between(expressFee, value1, value2);
        }

        public DaifaSendExample.Criteria andExpressFeeNotBetween(String value1, String value2) {
            return notBetween(expressFee, value1, value2);
        }
        public DaifaSendExample.Criteria andReceiverStateIsNull() {
            return isNull(receiverState);
        }

        public DaifaSendExample.Criteria andReceiverStateIsNotNull() {
            return isNotNull(receiverState);
        }

        public DaifaSendExample.Criteria andReceiverStateEqualTo(String value) {
            return equalTo(receiverState, value);
        }

        public DaifaSendExample.Criteria andReceiverStateNotEqualTo(String value) {
            return notEqualTo(receiverState, value);
        }

        public DaifaSendExample.Criteria andReceiverStateGreaterThan(String value) {
            return greaterThan(receiverState, value);
        }

        public DaifaSendExample.Criteria andReceiverStateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverState, value);
        }

        public DaifaSendExample.Criteria andReceiverStateLessThan(String value) {
            return lessThan(receiverState, value);
        }

        public DaifaSendExample.Criteria andReceiverStateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverState, value);
        }

        public DaifaSendExample.Criteria andReceiverStateLike(String value) {
            return like(receiverState, value);
        }

        public DaifaSendExample.Criteria andReceiverStateNotLike(String value) {
            return notLike(receiverState, value);
        }

        public DaifaSendExample.Criteria andReceiverStateIn(List<String> values) {
            return in(receiverState, values);
        }

        public DaifaSendExample.Criteria andReceiverStateNotIn(List<String> values) {
            return notIn(receiverState, values);
        }

        public DaifaSendExample.Criteria andReceiverStateBetween(String value1, String value2) {
            return between(receiverState, value1, value2);
        }

        public DaifaSendExample.Criteria andReceiverStateNotBetween(String value1, String value2) {
            return notBetween(receiverState, value1, value2);
        }
        public DaifaSendExample.Criteria andReceiverAddressIsNull() {
            return isNull(receiverAddress);
        }

        public DaifaSendExample.Criteria andReceiverAddressIsNotNull() {
            return isNotNull(receiverAddress);
        }

        public DaifaSendExample.Criteria andReceiverAddressEqualTo(String value) {
            return equalTo(receiverAddress, value);
        }

        public DaifaSendExample.Criteria andReceiverAddressNotEqualTo(String value) {
            return notEqualTo(receiverAddress, value);
        }

        public DaifaSendExample.Criteria andReceiverAddressGreaterThan(String value) {
            return greaterThan(receiverAddress, value);
        }

        public DaifaSendExample.Criteria andReceiverAddressGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverAddress, value);
        }

        public DaifaSendExample.Criteria andReceiverAddressLessThan(String value) {
            return lessThan(receiverAddress, value);
        }

        public DaifaSendExample.Criteria andReceiverAddressLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverAddress, value);
        }

        public DaifaSendExample.Criteria andReceiverAddressLike(String value) {
            return like(receiverAddress, value);
        }

        public DaifaSendExample.Criteria andReceiverAddressNotLike(String value) {
            return notLike(receiverAddress, value);
        }

        public DaifaSendExample.Criteria andReceiverAddressIn(List<String> values) {
            return in(receiverAddress, values);
        }

        public DaifaSendExample.Criteria andReceiverAddressNotIn(List<String> values) {
            return notIn(receiverAddress, values);
        }

        public DaifaSendExample.Criteria andReceiverAddressBetween(String value1, String value2) {
            return between(receiverAddress, value1, value2);
        }

        public DaifaSendExample.Criteria andReceiverAddressNotBetween(String value1, String value2) {
            return notBetween(receiverAddress, value1, value2);
        }
        public DaifaSendExample.Criteria andReceiverNameIsNull() {
            return isNull(receiverName);
        }

        public DaifaSendExample.Criteria andReceiverNameIsNotNull() {
            return isNotNull(receiverName);
        }

        public DaifaSendExample.Criteria andReceiverNameEqualTo(String value) {
            return equalTo(receiverName, value);
        }

        public DaifaSendExample.Criteria andReceiverNameNotEqualTo(String value) {
            return notEqualTo(receiverName, value);
        }

        public DaifaSendExample.Criteria andReceiverNameGreaterThan(String value) {
            return greaterThan(receiverName, value);
        }

        public DaifaSendExample.Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverName, value);
        }

        public DaifaSendExample.Criteria andReceiverNameLessThan(String value) {
            return lessThan(receiverName, value);
        }

        public DaifaSendExample.Criteria andReceiverNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverName, value);
        }

        public DaifaSendExample.Criteria andReceiverNameLike(String value) {
            return like(receiverName, value);
        }

        public DaifaSendExample.Criteria andReceiverNameNotLike(String value) {
            return notLike(receiverName, value);
        }

        public DaifaSendExample.Criteria andReceiverNameIn(List<String> values) {
            return in(receiverName, values);
        }

        public DaifaSendExample.Criteria andReceiverNameNotIn(List<String> values) {
            return notIn(receiverName, values);
        }

        public DaifaSendExample.Criteria andReceiverNameBetween(String value1, String value2) {
            return between(receiverName, value1, value2);
        }

        public DaifaSendExample.Criteria andReceiverNameNotBetween(String value1, String value2) {
            return notBetween(receiverName, value1, value2);
        }
        public DaifaSendExample.Criteria andReceiverZipIsNull() {
            return isNull(receiverZip);
        }

        public DaifaSendExample.Criteria andReceiverZipIsNotNull() {
            return isNotNull(receiverZip);
        }

        public DaifaSendExample.Criteria andReceiverZipEqualTo(String value) {
            return equalTo(receiverZip, value);
        }

        public DaifaSendExample.Criteria andReceiverZipNotEqualTo(String value) {
            return notEqualTo(receiverZip, value);
        }

        public DaifaSendExample.Criteria andReceiverZipGreaterThan(String value) {
            return greaterThan(receiverZip, value);
        }

        public DaifaSendExample.Criteria andReceiverZipGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverZip, value);
        }

        public DaifaSendExample.Criteria andReceiverZipLessThan(String value) {
            return lessThan(receiverZip, value);
        }

        public DaifaSendExample.Criteria andReceiverZipLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverZip, value);
        }

        public DaifaSendExample.Criteria andReceiverZipLike(String value) {
            return like(receiverZip, value);
        }

        public DaifaSendExample.Criteria andReceiverZipNotLike(String value) {
            return notLike(receiverZip, value);
        }

        public DaifaSendExample.Criteria andReceiverZipIn(List<String> values) {
            return in(receiverZip, values);
        }

        public DaifaSendExample.Criteria andReceiverZipNotIn(List<String> values) {
            return notIn(receiverZip, values);
        }

        public DaifaSendExample.Criteria andReceiverZipBetween(String value1, String value2) {
            return between(receiverZip, value1, value2);
        }

        public DaifaSendExample.Criteria andReceiverZipNotBetween(String value1, String value2) {
            return notBetween(receiverZip, value1, value2);
        }
        public DaifaSendExample.Criteria andReceiverPhoneIsNull() {
            return isNull(receiverPhone);
        }

        public DaifaSendExample.Criteria andReceiverPhoneIsNotNull() {
            return isNotNull(receiverPhone);
        }

        public DaifaSendExample.Criteria andReceiverPhoneEqualTo(String value) {
            return equalTo(receiverPhone, value);
        }

        public DaifaSendExample.Criteria andReceiverPhoneNotEqualTo(String value) {
            return notEqualTo(receiverPhone, value);
        }

        public DaifaSendExample.Criteria andReceiverPhoneGreaterThan(String value) {
            return greaterThan(receiverPhone, value);
        }

        public DaifaSendExample.Criteria andReceiverPhoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverPhone, value);
        }

        public DaifaSendExample.Criteria andReceiverPhoneLessThan(String value) {
            return lessThan(receiverPhone, value);
        }

        public DaifaSendExample.Criteria andReceiverPhoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverPhone, value);
        }

        public DaifaSendExample.Criteria andReceiverPhoneLike(String value) {
            return like(receiverPhone, value);
        }

        public DaifaSendExample.Criteria andReceiverPhoneNotLike(String value) {
            return notLike(receiverPhone, value);
        }

        public DaifaSendExample.Criteria andReceiverPhoneIn(List<String> values) {
            return in(receiverPhone, values);
        }

        public DaifaSendExample.Criteria andReceiverPhoneNotIn(List<String> values) {
            return notIn(receiverPhone, values);
        }

        public DaifaSendExample.Criteria andReceiverPhoneBetween(String value1, String value2) {
            return between(receiverPhone, value1, value2);
        }

        public DaifaSendExample.Criteria andReceiverPhoneNotBetween(String value1, String value2) {
            return notBetween(receiverPhone, value1, value2);
        }
        public DaifaSendExample.Criteria andBuyerRemarkIsNull() {
            return isNull(buyerRemark);
        }

        public DaifaSendExample.Criteria andBuyerRemarkIsNotNull() {
            return isNotNull(buyerRemark);
        }

        public DaifaSendExample.Criteria andBuyerRemarkEqualTo(String value) {
            return equalTo(buyerRemark, value);
        }

        public DaifaSendExample.Criteria andBuyerRemarkNotEqualTo(String value) {
            return notEqualTo(buyerRemark, value);
        }

        public DaifaSendExample.Criteria andBuyerRemarkGreaterThan(String value) {
            return greaterThan(buyerRemark, value);
        }

        public DaifaSendExample.Criteria andBuyerRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerRemark, value);
        }

        public DaifaSendExample.Criteria andBuyerRemarkLessThan(String value) {
            return lessThan(buyerRemark, value);
        }

        public DaifaSendExample.Criteria andBuyerRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerRemark, value);
        }

        public DaifaSendExample.Criteria andBuyerRemarkLike(String value) {
            return like(buyerRemark, value);
        }

        public DaifaSendExample.Criteria andBuyerRemarkNotLike(String value) {
            return notLike(buyerRemark, value);
        }

        public DaifaSendExample.Criteria andBuyerRemarkIn(List<String> values) {
            return in(buyerRemark, values);
        }

        public DaifaSendExample.Criteria andBuyerRemarkNotIn(List<String> values) {
            return notIn(buyerRemark, values);
        }

        public DaifaSendExample.Criteria andBuyerRemarkBetween(String value1, String value2) {
            return between(buyerRemark, value1, value2);
        }

        public DaifaSendExample.Criteria andBuyerRemarkNotBetween(String value1, String value2) {
            return notBetween(buyerRemark, value1, value2);
        }
        public DaifaSendExample.Criteria andPrintStatusIsNull() {
            return isNull(printStatus);
        }

        public DaifaSendExample.Criteria andPrintStatusIsNotNull() {
            return isNotNull(printStatus);
        }

        public DaifaSendExample.Criteria andPrintStatusEqualTo(Integer value) {
            return equalTo(printStatus, value);
        }

        public DaifaSendExample.Criteria andPrintStatusNotEqualTo(Integer value) {
            return notEqualTo(printStatus, value);
        }

        public DaifaSendExample.Criteria andPrintStatusGreaterThan(Integer value) {
            return greaterThan(printStatus, value);
        }

        public DaifaSendExample.Criteria andPrintStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(printStatus, value);
        }

        public DaifaSendExample.Criteria andPrintStatusLessThan(Integer value) {
            return lessThan(printStatus, value);
        }

        public DaifaSendExample.Criteria andPrintStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(printStatus, value);
        }

        public DaifaSendExample.Criteria andPrintStatusIn(List<Integer> values) {
            return in(printStatus, values);
        }

        public DaifaSendExample.Criteria andPrintStatusNotIn(List<Integer> values) {
            return notIn(printStatus, values);
        }

        public DaifaSendExample.Criteria andPrintStatusBetween(Integer value1, Integer value2) {
            return between(printStatus, value1, value2);
        }

        public DaifaSendExample.Criteria andPrintStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(printStatus, value1, value2);
        }
        public DaifaSendExample.Criteria andMarkDestinationIsNull() {
            return isNull(markDestination);
        }

        public DaifaSendExample.Criteria andMarkDestinationIsNotNull() {
            return isNotNull(markDestination);
        }

        public DaifaSendExample.Criteria andMarkDestinationEqualTo(String value) {
            return equalTo(markDestination, value);
        }

        public DaifaSendExample.Criteria andMarkDestinationNotEqualTo(String value) {
            return notEqualTo(markDestination, value);
        }

        public DaifaSendExample.Criteria andMarkDestinationGreaterThan(String value) {
            return greaterThan(markDestination, value);
        }

        public DaifaSendExample.Criteria andMarkDestinationGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(markDestination, value);
        }

        public DaifaSendExample.Criteria andMarkDestinationLessThan(String value) {
            return lessThan(markDestination, value);
        }

        public DaifaSendExample.Criteria andMarkDestinationLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(markDestination, value);
        }

        public DaifaSendExample.Criteria andMarkDestinationLike(String value) {
            return like(markDestination, value);
        }

        public DaifaSendExample.Criteria andMarkDestinationNotLike(String value) {
            return notLike(markDestination, value);
        }

        public DaifaSendExample.Criteria andMarkDestinationIn(List<String> values) {
            return in(markDestination, values);
        }

        public DaifaSendExample.Criteria andMarkDestinationNotIn(List<String> values) {
            return notIn(markDestination, values);
        }

        public DaifaSendExample.Criteria andMarkDestinationBetween(String value1, String value2) {
            return between(markDestination, value1, value2);
        }

        public DaifaSendExample.Criteria andMarkDestinationNotBetween(String value1, String value2) {
            return notBetween(markDestination, value1, value2);
        }
        public DaifaSendExample.Criteria andPackageNameIsNull() {
            return isNull(packageName);
        }

        public DaifaSendExample.Criteria andPackageNameIsNotNull() {
            return isNotNull(packageName);
        }

        public DaifaSendExample.Criteria andPackageNameEqualTo(String value) {
            return equalTo(packageName, value);
        }

        public DaifaSendExample.Criteria andPackageNameNotEqualTo(String value) {
            return notEqualTo(packageName, value);
        }

        public DaifaSendExample.Criteria andPackageNameGreaterThan(String value) {
            return greaterThan(packageName, value);
        }

        public DaifaSendExample.Criteria andPackageNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(packageName, value);
        }

        public DaifaSendExample.Criteria andPackageNameLessThan(String value) {
            return lessThan(packageName, value);
        }

        public DaifaSendExample.Criteria andPackageNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(packageName, value);
        }

        public DaifaSendExample.Criteria andPackageNameLike(String value) {
            return like(packageName, value);
        }

        public DaifaSendExample.Criteria andPackageNameNotLike(String value) {
            return notLike(packageName, value);
        }

        public DaifaSendExample.Criteria andPackageNameIn(List<String> values) {
            return in(packageName, values);
        }

        public DaifaSendExample.Criteria andPackageNameNotIn(List<String> values) {
            return notIn(packageName, values);
        }

        public DaifaSendExample.Criteria andPackageNameBetween(String value1, String value2) {
            return between(packageName, value1, value2);
        }

        public DaifaSendExample.Criteria andPackageNameNotBetween(String value1, String value2) {
            return notBetween(packageName, value1, value2);
        }
        public DaifaSendExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public DaifaSendExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public DaifaSendExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public DaifaSendExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public DaifaSendExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public DaifaSendExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public DaifaSendExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public DaifaSendExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public DaifaSendExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public DaifaSendExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public DaifaSendExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public DaifaSendExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public DaifaSendExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public DaifaSendExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public DaifaSendExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public DaifaSendExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public DaifaSendExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public DaifaSendExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public DaifaSendExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public DaifaSendExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public DaifaSendExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public DaifaSendExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public DaifaSendExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public DaifaSendExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public DaifaSendExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public DaifaSendExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public DaifaSendExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public DaifaSendExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
        public DaifaSendExample.Criteria andTaobaoUserNickIsNull() {
            return isNull(taobaoUserNick);
        }

        public DaifaSendExample.Criteria andTaobaoUserNickIsNotNull() {
            return isNotNull(taobaoUserNick);
        }

        public DaifaSendExample.Criteria andTaobaoUserNickEqualTo(String value) {
            return equalTo(taobaoUserNick, value);
        }

        public DaifaSendExample.Criteria andTaobaoUserNickNotEqualTo(String value) {
            return notEqualTo(taobaoUserNick, value);
        }

        public DaifaSendExample.Criteria andTaobaoUserNickGreaterThan(String value) {
            return greaterThan(taobaoUserNick, value);
        }

        public DaifaSendExample.Criteria andTaobaoUserNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(taobaoUserNick, value);
        }

        public DaifaSendExample.Criteria andTaobaoUserNickLessThan(String value) {
            return lessThan(taobaoUserNick, value);
        }

        public DaifaSendExample.Criteria andTaobaoUserNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(taobaoUserNick, value);
        }

        public DaifaSendExample.Criteria andTaobaoUserNickLike(String value) {
            return like(taobaoUserNick, value);
        }

        public DaifaSendExample.Criteria andTaobaoUserNickNotLike(String value) {
            return notLike(taobaoUserNick, value);
        }

        public DaifaSendExample.Criteria andTaobaoUserNickIn(List<String> values) {
            return in(taobaoUserNick, values);
        }

        public DaifaSendExample.Criteria andTaobaoUserNickNotIn(List<String> values) {
            return notIn(taobaoUserNick, values);
        }

        public DaifaSendExample.Criteria andTaobaoUserNickBetween(String value1, String value2) {
            return between(taobaoUserNick, value1, value2);
        }

        public DaifaSendExample.Criteria andTaobaoUserNickNotBetween(String value1, String value2) {
            return notBetween(taobaoUserNick, value1, value2);
        }
        public DaifaSendExample.Criteria andTaobaoTidIsNull() {
            return isNull(taobaoTid);
        }

        public DaifaSendExample.Criteria andTaobaoTidIsNotNull() {
            return isNotNull(taobaoTid);
        }

        public DaifaSendExample.Criteria andTaobaoTidEqualTo(Long value) {
            return equalTo(taobaoTid, value);
        }

        public DaifaSendExample.Criteria andTaobaoTidNotEqualTo(Long value) {
            return notEqualTo(taobaoTid, value);
        }

        public DaifaSendExample.Criteria andTaobaoTidGreaterThan(Long value) {
            return greaterThan(taobaoTid, value);
        }

        public DaifaSendExample.Criteria andTaobaoTidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(taobaoTid, value);
        }

        public DaifaSendExample.Criteria andTaobaoTidLessThan(Long value) {
            return lessThan(taobaoTid, value);
        }

        public DaifaSendExample.Criteria andTaobaoTidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(taobaoTid, value);
        }

        public DaifaSendExample.Criteria andTaobaoTidLike(String value) {
            return like(taobaoTid, value);
        }

        public DaifaSendExample.Criteria andTaobaoTidNotLike(String value) {
            return notLike(taobaoTid, value);
        }

        public DaifaSendExample.Criteria andTaobaoTidIn(List<Long> values) {
            return in(taobaoTid, values);
        }

        public DaifaSendExample.Criteria andTaobaoTidNotIn(List<Long> values) {
            return notIn(taobaoTid, values);
        }

        public DaifaSendExample.Criteria andTaobaoTidBetween(Long value1, Long value2) {
            return between(taobaoTid, value1, value2);
        }

        public DaifaSendExample.Criteria andTaobaoTidNotBetween(Long value1, Long value2) {
            return notBetween(taobaoTid, value1, value2);
        }
        public DaifaSendExample.Criteria andBuyerNameIsNull() {
            return isNull(buyerName);
        }

        public DaifaSendExample.Criteria andBuyerNameIsNotNull() {
            return isNotNull(buyerName);
        }

        public DaifaSendExample.Criteria andBuyerNameEqualTo(String value) {
            return equalTo(buyerName, value);
        }

        public DaifaSendExample.Criteria andBuyerNameNotEqualTo(String value) {
            return notEqualTo(buyerName, value);
        }

        public DaifaSendExample.Criteria andBuyerNameGreaterThan(String value) {
            return greaterThan(buyerName, value);
        }

        public DaifaSendExample.Criteria andBuyerNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerName, value);
        }

        public DaifaSendExample.Criteria andBuyerNameLessThan(String value) {
            return lessThan(buyerName, value);
        }

        public DaifaSendExample.Criteria andBuyerNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerName, value);
        }

        public DaifaSendExample.Criteria andBuyerNameLike(String value) {
            return like(buyerName, value);
        }

        public DaifaSendExample.Criteria andBuyerNameNotLike(String value) {
            return notLike(buyerName, value);
        }

        public DaifaSendExample.Criteria andBuyerNameIn(List<String> values) {
            return in(buyerName, values);
        }

        public DaifaSendExample.Criteria andBuyerNameNotIn(List<String> values) {
            return notIn(buyerName, values);
        }

        public DaifaSendExample.Criteria andBuyerNameBetween(String value1, String value2) {
            return between(buyerName, value1, value2);
        }

        public DaifaSendExample.Criteria andBuyerNameNotBetween(String value1, String value2) {
            return notBetween(buyerName, value1, value2);
        }
        public DaifaSendExample.Criteria andBuyerTelephoneIsNull() {
            return isNull(buyerTelephone);
        }

        public DaifaSendExample.Criteria andBuyerTelephoneIsNotNull() {
            return isNotNull(buyerTelephone);
        }

        public DaifaSendExample.Criteria andBuyerTelephoneEqualTo(String value) {
            return equalTo(buyerTelephone, value);
        }

        public DaifaSendExample.Criteria andBuyerTelephoneNotEqualTo(String value) {
            return notEqualTo(buyerTelephone, value);
        }

        public DaifaSendExample.Criteria andBuyerTelephoneGreaterThan(String value) {
            return greaterThan(buyerTelephone, value);
        }

        public DaifaSendExample.Criteria andBuyerTelephoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerTelephone, value);
        }

        public DaifaSendExample.Criteria andBuyerTelephoneLessThan(String value) {
            return lessThan(buyerTelephone, value);
        }

        public DaifaSendExample.Criteria andBuyerTelephoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerTelephone, value);
        }

        public DaifaSendExample.Criteria andBuyerTelephoneLike(String value) {
            return like(buyerTelephone, value);
        }

        public DaifaSendExample.Criteria andBuyerTelephoneNotLike(String value) {
            return notLike(buyerTelephone, value);
        }

        public DaifaSendExample.Criteria andBuyerTelephoneIn(List<String> values) {
            return in(buyerTelephone, values);
        }

        public DaifaSendExample.Criteria andBuyerTelephoneNotIn(List<String> values) {
            return notIn(buyerTelephone, values);
        }

        public DaifaSendExample.Criteria andBuyerTelephoneBetween(String value1, String value2) {
            return between(buyerTelephone, value1, value2);
        }

        public DaifaSendExample.Criteria andBuyerTelephoneNotBetween(String value1, String value2) {
            return notBetween(buyerTelephone, value1, value2);
        }
        public DaifaSendExample.Criteria andBuyerQqIsNull() {
            return isNull(buyerQq);
        }

        public DaifaSendExample.Criteria andBuyerQqIsNotNull() {
            return isNotNull(buyerQq);
        }

        public DaifaSendExample.Criteria andBuyerQqEqualTo(String value) {
            return equalTo(buyerQq, value);
        }

        public DaifaSendExample.Criteria andBuyerQqNotEqualTo(String value) {
            return notEqualTo(buyerQq, value);
        }

        public DaifaSendExample.Criteria andBuyerQqGreaterThan(String value) {
            return greaterThan(buyerQq, value);
        }

        public DaifaSendExample.Criteria andBuyerQqGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerQq, value);
        }

        public DaifaSendExample.Criteria andBuyerQqLessThan(String value) {
            return lessThan(buyerQq, value);
        }

        public DaifaSendExample.Criteria andBuyerQqLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerQq, value);
        }

        public DaifaSendExample.Criteria andBuyerQqLike(String value) {
            return like(buyerQq, value);
        }

        public DaifaSendExample.Criteria andBuyerQqNotLike(String value) {
            return notLike(buyerQq, value);
        }

        public DaifaSendExample.Criteria andBuyerQqIn(List<String> values) {
            return in(buyerQq, values);
        }

        public DaifaSendExample.Criteria andBuyerQqNotIn(List<String> values) {
            return notIn(buyerQq, values);
        }

        public DaifaSendExample.Criteria andBuyerQqBetween(String value1, String value2) {
            return between(buyerQq, value1, value2);
        }

        public DaifaSendExample.Criteria andBuyerQqNotBetween(String value1, String value2) {
            return notBetween(buyerQq, value1, value2);
        }
        public DaifaSendExample.Criteria andBuyerWwIsNull() {
            return isNull(buyerWw);
        }

        public DaifaSendExample.Criteria andBuyerWwIsNotNull() {
            return isNotNull(buyerWw);
        }

        public DaifaSendExample.Criteria andBuyerWwEqualTo(String value) {
            return equalTo(buyerWw, value);
        }

        public DaifaSendExample.Criteria andBuyerWwNotEqualTo(String value) {
            return notEqualTo(buyerWw, value);
        }

        public DaifaSendExample.Criteria andBuyerWwGreaterThan(String value) {
            return greaterThan(buyerWw, value);
        }

        public DaifaSendExample.Criteria andBuyerWwGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerWw, value);
        }

        public DaifaSendExample.Criteria andBuyerWwLessThan(String value) {
            return lessThan(buyerWw, value);
        }

        public DaifaSendExample.Criteria andBuyerWwLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerWw, value);
        }

        public DaifaSendExample.Criteria andBuyerWwLike(String value) {
            return like(buyerWw, value);
        }

        public DaifaSendExample.Criteria andBuyerWwNotLike(String value) {
            return notLike(buyerWw, value);
        }

        public DaifaSendExample.Criteria andBuyerWwIn(List<String> values) {
            return in(buyerWw, values);
        }

        public DaifaSendExample.Criteria andBuyerWwNotIn(List<String> values) {
            return notIn(buyerWw, values);
        }

        public DaifaSendExample.Criteria andBuyerWwBetween(String value1, String value2) {
            return between(buyerWw, value1, value2);
        }

        public DaifaSendExample.Criteria andBuyerWwNotBetween(String value1, String value2) {
            return notBetween(buyerWw, value1, value2);
        }
    }
}