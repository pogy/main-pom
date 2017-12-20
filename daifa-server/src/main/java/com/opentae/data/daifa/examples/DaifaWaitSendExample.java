package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaWaitSend;

import java.util.*;
public class DaifaWaitSendExample extends SgExample<DaifaWaitSendExample.Criteria> {
    public static final Class<DaifaWaitSend> beanClass = DaifaWaitSend.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn dwsId;
    public static EntityColumn dfTradeId;
    public static EntityColumn tradeCode;
    public static EntityColumn sellerId;
    public static EntityColumn sendStatus;
    public static EntityColumn stockStatus;
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
    public static EntityColumn receiverPhone;
    public static EntityColumn buyerRemark;
    public static EntityColumn taobaoTid;
    public static EntityColumn markDestination;
    public static EntityColumn packageName;
    public static EntityColumn remark1;
    public static EntityColumn remark2;
    public static EntityColumn taobaoUserNick;
    public static EntityColumn receiverQq;
    public static EntityColumn buyerName;
    public static EntityColumn buyerTelephone;
    public static EntityColumn buyerQq;
    public static EntityColumn buyerWw;
    public static EntityColumn receiverZip;
    public static EntityColumn orderDisplay;

    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        dwsId = listMap.get("dwsId");
        dfTradeId = listMap.get("dfTradeId");
        tradeCode = listMap.get("tradeCode");
        sellerId = listMap.get("sellerId");
        sendStatus = listMap.get("sendStatus");
        stockStatus = listMap.get("stockStatus");
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
        receiverPhone = listMap.get("receiverPhone");
        buyerRemark = listMap.get("buyerRemark");
        taobaoTid = listMap.get("taobaoTid");
        markDestination = listMap.get("markDestination");
        packageName = listMap.get("packageName");
        remark1 = listMap.get("remark1");
        remark2 = listMap.get("remark2");
        taobaoUserNick = listMap.get("taobaoUserNick");
        receiverQq = listMap.get("receiverQq");
        buyerName = listMap.get("buyerName");
        buyerTelephone = listMap.get("buyerTelephone");
        buyerQq = listMap.get("buyerQq");
        buyerWw = listMap.get("buyerWw");
        receiverZip = listMap.get("receiverZip");
        orderDisplay = listMap.get("orderDisplay");

    }

    public DaifaWaitSendExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaWaitSendExample.Criteria createCriteriaInternal() {
        return new DaifaWaitSendExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaWaitSendExample.Criteria andDwsIdIsNull() {
            return isNull(dwsId);
        }

        public DaifaWaitSendExample.Criteria andDwsIdIsNotNull() {
            return isNotNull(dwsId);
        }

        public DaifaWaitSendExample.Criteria andDwsIdEqualTo(Long value) {
            return equalTo(dwsId, value);
        }

        public DaifaWaitSendExample.Criteria andDwsIdNotEqualTo(Long value) {
            return notEqualTo(dwsId, value);
        }

        public DaifaWaitSendExample.Criteria andDwsIdGreaterThan(Long value) {
            return greaterThan(dwsId, value);
        }

        public DaifaWaitSendExample.Criteria andDwsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dwsId, value);
        }

        public DaifaWaitSendExample.Criteria andDwsIdLessThan(Long value) {
            return lessThan(dwsId, value);
        }

        public DaifaWaitSendExample.Criteria andDwsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dwsId, value);
        }

        public DaifaWaitSendExample.Criteria andDwsIdLike(String value) {
            return like(dwsId, value);
        }

        public DaifaWaitSendExample.Criteria andDwsIdNotLike(String value) {
            return notLike(dwsId, value);
        }

        public DaifaWaitSendExample.Criteria andDwsIdIn(List<Long> values) {
            return in(dwsId, values);
        }

        public DaifaWaitSendExample.Criteria andDwsIdNotIn(List<Long> values) {
            return notIn(dwsId, values);
        }

        public DaifaWaitSendExample.Criteria andDwsIdBetween(Long value1, Long value2) {
            return between(dwsId, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andDwsIdNotBetween(Long value1, Long value2) {
            return notBetween(dwsId, value1, value2);
        }

        public Criteria andOrderDisplayIsNull() {
            return isNull(orderDisplay);
        }

        public Criteria andOrderDisplayIsNotNull() {
            return isNotNull(orderDisplay);
        }

        public Criteria andOrderDisplayEqualTo(Integer value) {
            return equalTo(orderDisplay, value);
        }

        public Criteria andOrderDisplayNotEqualTo(Integer value) {
            return notEqualTo(orderDisplay, value);
        }

        public Criteria andOrderDisplayGreaterThan(Integer value) {
            return greaterThan(orderDisplay, value);
        }

        public Criteria andOrderDisplayGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(orderDisplay, value);
        }

        public Criteria andOrderDisplayLessThan(Integer value) {
            return lessThan(orderDisplay, value);
        }

        public Criteria andOrderDisplayLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(orderDisplay, value);
        }

        public Criteria andOrderDisplayLike(String value) {
            return like(orderDisplay, value);
        }

        public Criteria andOrderDisplayNotLike(String value) {
            return notLike(orderDisplay, value);
        }

        public Criteria andOrderDisplayIn(List<Integer> values) {
            return in(orderDisplay, values);
        }

        public Criteria andOrderDisplayNotIn(List<Integer> values) {
            return notIn(orderDisplay, values);
        }

        public Criteria andOrderDisplayBetween(Integer value1, Integer value2) {
            return between(orderDisplay, value1, value2);
        }

        public Criteria andOrderDisplayNotBetween(Integer value1, Integer value2) {
            return notBetween(orderDisplay, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andDfTradeIdIsNull() {
            return isNull(dfTradeId);
        }

        public DaifaWaitSendExample.Criteria andDfTradeIdIsNotNull() {
            return isNotNull(dfTradeId);
        }

        public DaifaWaitSendExample.Criteria andDfTradeIdEqualTo(Long value) {
            return equalTo(dfTradeId, value);
        }

        public DaifaWaitSendExample.Criteria andDfTradeIdNotEqualTo(Long value) {
            return notEqualTo(dfTradeId, value);
        }

        public DaifaWaitSendExample.Criteria andDfTradeIdGreaterThan(Long value) {
            return greaterThan(dfTradeId, value);
        }

        public DaifaWaitSendExample.Criteria andDfTradeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfTradeId, value);
        }

        public DaifaWaitSendExample.Criteria andDfTradeIdLessThan(Long value) {
            return lessThan(dfTradeId, value);
        }

        public DaifaWaitSendExample.Criteria andDfTradeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfTradeId, value);
        }

        public DaifaWaitSendExample.Criteria andDfTradeIdLike(String value) {
            return like(dfTradeId, value);
        }

        public DaifaWaitSendExample.Criteria andDfTradeIdNotLike(String value) {
            return notLike(dfTradeId, value);
        }

        public DaifaWaitSendExample.Criteria andDfTradeIdIn(List<Long> values) {
            return in(dfTradeId, values);
        }

        public DaifaWaitSendExample.Criteria andDfTradeIdNotIn(List<Long> values) {
            return notIn(dfTradeId, values);
        }

        public DaifaWaitSendExample.Criteria andDfTradeIdBetween(Long value1, Long value2) {
            return between(dfTradeId, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andDfTradeIdNotBetween(Long value1, Long value2) {
            return notBetween(dfTradeId, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andTradeCodeIsNull() {
            return isNull(tradeCode);
        }

        public DaifaWaitSendExample.Criteria andTradeCodeIsNotNull() {
            return isNotNull(tradeCode);
        }

        public DaifaWaitSendExample.Criteria andTradeCodeEqualTo(String value) {
            return equalTo(tradeCode, value);
        }

        public DaifaWaitSendExample.Criteria andTradeCodeNotEqualTo(String value) {
            return notEqualTo(tradeCode, value);
        }

        public DaifaWaitSendExample.Criteria andTradeCodeGreaterThan(String value) {
            return greaterThan(tradeCode, value);
        }

        public DaifaWaitSendExample.Criteria andTradeCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(tradeCode, value);
        }

        public DaifaWaitSendExample.Criteria andTradeCodeLessThan(String value) {
            return lessThan(tradeCode, value);
        }

        public DaifaWaitSendExample.Criteria andTradeCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(tradeCode, value);
        }

        public DaifaWaitSendExample.Criteria andTradeCodeLike(String value) {
            return like(tradeCode, value);
        }

        public DaifaWaitSendExample.Criteria andTradeCodeNotLike(String value) {
            return notLike(tradeCode, value);
        }

        public DaifaWaitSendExample.Criteria andTradeCodeIn(List<String> values) {
            return in(tradeCode, values);
        }

        public DaifaWaitSendExample.Criteria andTradeCodeNotIn(List<String> values) {
            return notIn(tradeCode, values);
        }

        public DaifaWaitSendExample.Criteria andTradeCodeBetween(String value1, String value2) {
            return between(tradeCode, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andTradeCodeNotBetween(String value1, String value2) {
            return notBetween(tradeCode, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andSellerIdIsNull() {
            return isNull(sellerId);
        }

        public DaifaWaitSendExample.Criteria andSellerIdIsNotNull() {
            return isNotNull(sellerId);
        }

        public DaifaWaitSendExample.Criteria andSellerIdEqualTo(Long value) {
            return equalTo(sellerId, value);
        }

        public DaifaWaitSendExample.Criteria andSellerIdNotEqualTo(Long value) {
            return notEqualTo(sellerId, value);
        }

        public DaifaWaitSendExample.Criteria andSellerIdGreaterThan(Long value) {
            return greaterThan(sellerId, value);
        }

        public DaifaWaitSendExample.Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerId, value);
        }

        public DaifaWaitSendExample.Criteria andSellerIdLessThan(Long value) {
            return lessThan(sellerId, value);
        }

        public DaifaWaitSendExample.Criteria andSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerId, value);
        }

        public DaifaWaitSendExample.Criteria andSellerIdLike(String value) {
            return like(sellerId, value);
        }

        public DaifaWaitSendExample.Criteria andSellerIdNotLike(String value) {
            return notLike(sellerId, value);
        }

        public DaifaWaitSendExample.Criteria andSellerIdIn(List<Long> values) {
            return in(sellerId, values);
        }

        public DaifaWaitSendExample.Criteria andSellerIdNotIn(List<Long> values) {
            return notIn(sellerId, values);
        }

        public DaifaWaitSendExample.Criteria andSellerIdBetween(Long value1, Long value2) {
            return between(sellerId, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(sellerId, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andSendStatusIsNull() {
            return isNull(sendStatus);
        }

        public DaifaWaitSendExample.Criteria andSendStatusIsNotNull() {
            return isNotNull(sendStatus);
        }

        public DaifaWaitSendExample.Criteria andSendStatusEqualTo(Integer value) {
            return equalTo(sendStatus, value);
        }

        public DaifaWaitSendExample.Criteria andSendStatusNotEqualTo(Integer value) {
            return notEqualTo(sendStatus, value);
        }

        public DaifaWaitSendExample.Criteria andSendStatusGreaterThan(Integer value) {
            return greaterThan(sendStatus, value);
        }

        public DaifaWaitSendExample.Criteria andSendStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sendStatus, value);
        }

        public DaifaWaitSendExample.Criteria andSendStatusLessThan(Integer value) {
            return lessThan(sendStatus, value);
        }

        public DaifaWaitSendExample.Criteria andSendStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sendStatus, value);
        }

        public DaifaWaitSendExample.Criteria andSendStatusIn(List<Integer> values) {
            return in(sendStatus, values);
        }

        public DaifaWaitSendExample.Criteria andSendStatusNotIn(List<Integer> values) {
            return notIn(sendStatus, values);
        }

        public DaifaWaitSendExample.Criteria andSendStatusBetween(Integer value1, Integer value2) {
            return between(sendStatus, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andSendStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(sendStatus, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andStockStatusIsNull() {
            return isNull(stockStatus);
        }

        public DaifaWaitSendExample.Criteria andStockStatusIsNotNull() {
            return isNotNull(stockStatus);
        }

        public DaifaWaitSendExample.Criteria andStockStatusEqualTo(Integer value) {
            return equalTo(stockStatus, value);
        }

        public DaifaWaitSendExample.Criteria andStockStatusNotEqualTo(Integer value) {
            return notEqualTo(stockStatus, value);
        }

        public DaifaWaitSendExample.Criteria andStockStatusGreaterThan(Integer value) {
            return greaterThan(stockStatus, value);
        }

        public DaifaWaitSendExample.Criteria andStockStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(stockStatus, value);
        }

        public DaifaWaitSendExample.Criteria andStockStatusLessThan(Integer value) {
            return lessThan(stockStatus, value);
        }

        public DaifaWaitSendExample.Criteria andStockStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(stockStatus, value);
        }

        public DaifaWaitSendExample.Criteria andStockStatusIn(List<Integer> values) {
            return in(stockStatus, values);
        }

        public DaifaWaitSendExample.Criteria andStockStatusNotIn(List<Integer> values) {
            return notIn(stockStatus, values);
        }

        public DaifaWaitSendExample.Criteria andStockStatusBetween(Integer value1, Integer value2) {
            return between(stockStatus, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andStockStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(stockStatus, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andCreateDateIsNull() {
            return isNull(createDate);
        }

        public DaifaWaitSendExample.Criteria andCreateDateIsNotNull() {
            return isNotNull(createDate);
        }

        public DaifaWaitSendExample.Criteria andCreateDateEqualTo(String value) {
            return equalTo(createDate, value);
        }

        public DaifaWaitSendExample.Criteria andCreateDateNotEqualTo(String value) {
            return notEqualTo(createDate, value);
        }

        public DaifaWaitSendExample.Criteria andCreateDateGreaterThan(String value) {
            return greaterThan(createDate, value);
        }

        public DaifaWaitSendExample.Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(createDate, value);
        }

        public DaifaWaitSendExample.Criteria andCreateDateLessThan(String value) {
            return lessThan(createDate, value);
        }

        public DaifaWaitSendExample.Criteria andCreateDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(createDate, value);
        }

        public DaifaWaitSendExample.Criteria andCreateDateLike(String value) {
            return like(createDate, value);
        }

        public DaifaWaitSendExample.Criteria andCreateDateNotLike(String value) {
            return notLike(createDate, value);
        }

        public DaifaWaitSendExample.Criteria andCreateDateIn(List<String> values) {
            return in(createDate, values);
        }

        public DaifaWaitSendExample.Criteria andCreateDateNotIn(List<String> values) {
            return notIn(createDate, values);
        }

        public DaifaWaitSendExample.Criteria andCreateDateBetween(String value1, String value2) {
            return between(createDate, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andCreateDateNotBetween(String value1, String value2) {
            return notBetween(createDate, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaWaitSendExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaWaitSendExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public DaifaWaitSendExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaWaitSendExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaWaitSendExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaWaitSendExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public DaifaWaitSendExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaWaitSendExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public DaifaWaitSendExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public DaifaWaitSendExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andSendDateIsNull() {
            return isNull(sendDate);
        }

        public DaifaWaitSendExample.Criteria andSendDateIsNotNull() {
            return isNotNull(sendDate);
        }

        public DaifaWaitSendExample.Criteria andSendDateEqualTo(String value) {
            return equalTo(sendDate, value);
        }

        public DaifaWaitSendExample.Criteria andSendDateNotEqualTo(String value) {
            return notEqualTo(sendDate, value);
        }

        public DaifaWaitSendExample.Criteria andSendDateGreaterThan(String value) {
            return greaterThan(sendDate, value);
        }

        public DaifaWaitSendExample.Criteria andSendDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sendDate, value);
        }

        public DaifaWaitSendExample.Criteria andSendDateLessThan(String value) {
            return lessThan(sendDate, value);
        }

        public DaifaWaitSendExample.Criteria andSendDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sendDate, value);
        }

        public DaifaWaitSendExample.Criteria andSendDateLike(String value) {
            return like(sendDate, value);
        }

        public DaifaWaitSendExample.Criteria andSendDateNotLike(String value) {
            return notLike(sendDate, value);
        }

        public DaifaWaitSendExample.Criteria andSendDateIn(List<String> values) {
            return in(sendDate, values);
        }

        public DaifaWaitSendExample.Criteria andSendDateNotIn(List<String> values) {
            return notIn(sendDate, values);
        }

        public DaifaWaitSendExample.Criteria andSendDateBetween(String value1, String value2) {
            return between(sendDate, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andSendDateNotBetween(String value1, String value2) {
            return notBetween(sendDate, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andSendTimeIsNull() {
            return isNull(sendTime);
        }

        public DaifaWaitSendExample.Criteria andSendTimeIsNotNull() {
            return isNotNull(sendTime);
        }

        public DaifaWaitSendExample.Criteria andSendTimeEqualTo(Date value) {
            return equalTo(sendTime, value);
        }

        public DaifaWaitSendExample.Criteria andSendTimeNotEqualTo(Date value) {
            return notEqualTo(sendTime, value);
        }

        public DaifaWaitSendExample.Criteria andSendTimeGreaterThan(Date value) {
            return greaterThan(sendTime, value);
        }

        public DaifaWaitSendExample.Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(sendTime, value);
        }

        public DaifaWaitSendExample.Criteria andSendTimeLessThan(Date value) {
            return lessThan(sendTime, value);
        }

        public DaifaWaitSendExample.Criteria andSendTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(sendTime, value);
        }

        public DaifaWaitSendExample.Criteria andSendTimeIn(List<Date> values) {
            return in(sendTime, values);
        }

        public DaifaWaitSendExample.Criteria andSendTimeNotIn(List<Date> values) {
            return notIn(sendTime, values);
        }

        public DaifaWaitSendExample.Criteria andSendTimeBetween(Date value1, Date value2) {
            return between(sendTime, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andSendTimeNotBetween(Date value1, Date value2) {
            return notBetween(sendTime, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andMoneyIsNull() {
            return isNull(money);
        }

        public DaifaWaitSendExample.Criteria andMoneyIsNotNull() {
            return isNotNull(money);
        }

        public DaifaWaitSendExample.Criteria andMoneyEqualTo(String value) {
            return equalTo(money, value);
        }

        public DaifaWaitSendExample.Criteria andMoneyNotEqualTo(String value) {
            return notEqualTo(money, value);
        }

        public DaifaWaitSendExample.Criteria andMoneyGreaterThan(String value) {
            return greaterThan(money, value);
        }

        public DaifaWaitSendExample.Criteria andMoneyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(money, value);
        }

        public DaifaWaitSendExample.Criteria andMoneyLessThan(String value) {
            return lessThan(money, value);
        }

        public DaifaWaitSendExample.Criteria andMoneyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(money, value);
        }

        public DaifaWaitSendExample.Criteria andMoneyLike(String value) {
            return like(money, value);
        }

        public DaifaWaitSendExample.Criteria andMoneyNotLike(String value) {
            return notLike(money, value);
        }

        public DaifaWaitSendExample.Criteria andMoneyIn(List<String> values) {
            return in(money, values);
        }

        public DaifaWaitSendExample.Criteria andMoneyNotIn(List<String> values) {
            return notIn(money, values);
        }

        public DaifaWaitSendExample.Criteria andMoneyBetween(String value1, String value2) {
            return between(money, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andMoneyNotBetween(String value1, String value2) {
            return notBetween(money, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andBuyerIdIsNull() {
            return isNull(buyerId);
        }

        public DaifaWaitSendExample.Criteria andBuyerIdIsNotNull() {
            return isNotNull(buyerId);
        }

        public DaifaWaitSendExample.Criteria andBuyerIdEqualTo(Long value) {
            return equalTo(buyerId, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerIdNotEqualTo(Long value) {
            return notEqualTo(buyerId, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerIdGreaterThan(Long value) {
            return greaterThan(buyerId, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(buyerId, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerIdLessThan(Long value) {
            return lessThan(buyerId, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(buyerId, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerIdLike(String value) {
            return like(buyerId, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerIdNotLike(String value) {
            return notLike(buyerId, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerIdIn(List<Long> values) {
            return in(buyerId, values);
        }

        public DaifaWaitSendExample.Criteria andBuyerIdNotIn(List<Long> values) {
            return notIn(buyerId, values);
        }

        public DaifaWaitSendExample.Criteria andBuyerIdBetween(Long value1, Long value2) {
            return between(buyerId, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andBuyerIdNotBetween(Long value1, Long value2) {
            return notBetween(buyerId, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andExpressIdIsNull() {
            return isNull(expressId);
        }

        public DaifaWaitSendExample.Criteria andExpressIdIsNotNull() {
            return isNotNull(expressId);
        }

        public DaifaWaitSendExample.Criteria andExpressIdEqualTo(Long value) {
            return equalTo(expressId, value);
        }

        public DaifaWaitSendExample.Criteria andExpressIdNotEqualTo(Long value) {
            return notEqualTo(expressId, value);
        }

        public DaifaWaitSendExample.Criteria andExpressIdGreaterThan(Long value) {
            return greaterThan(expressId, value);
        }

        public DaifaWaitSendExample.Criteria andExpressIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(expressId, value);
        }

        public DaifaWaitSendExample.Criteria andExpressIdLessThan(Long value) {
            return lessThan(expressId, value);
        }

        public DaifaWaitSendExample.Criteria andExpressIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(expressId, value);
        }

        public DaifaWaitSendExample.Criteria andExpressIdLike(String value) {
            return like(expressId, value);
        }

        public DaifaWaitSendExample.Criteria andExpressIdNotLike(String value) {
            return notLike(expressId, value);
        }

        public DaifaWaitSendExample.Criteria andExpressIdIn(List<Long> values) {
            return in(expressId, values);
        }

        public DaifaWaitSendExample.Criteria andExpressIdNotIn(List<Long> values) {
            return notIn(expressId, values);
        }

        public DaifaWaitSendExample.Criteria andExpressIdBetween(Long value1, Long value2) {
            return between(expressId, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andExpressIdNotBetween(Long value1, Long value2) {
            return notBetween(expressId, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andExpressNameIsNull() {
            return isNull(expressName);
        }

        public DaifaWaitSendExample.Criteria andExpressNameIsNotNull() {
            return isNotNull(expressName);
        }

        public DaifaWaitSendExample.Criteria andExpressNameEqualTo(String value) {
            return equalTo(expressName, value);
        }

        public DaifaWaitSendExample.Criteria andExpressNameNotEqualTo(String value) {
            return notEqualTo(expressName, value);
        }

        public DaifaWaitSendExample.Criteria andExpressNameGreaterThan(String value) {
            return greaterThan(expressName, value);
        }

        public DaifaWaitSendExample.Criteria andExpressNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressName, value);
        }

        public DaifaWaitSendExample.Criteria andExpressNameLessThan(String value) {
            return lessThan(expressName, value);
        }

        public DaifaWaitSendExample.Criteria andExpressNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressName, value);
        }

        public DaifaWaitSendExample.Criteria andExpressNameLike(String value) {
            return like(expressName, value);
        }

        public DaifaWaitSendExample.Criteria andExpressNameNotLike(String value) {
            return notLike(expressName, value);
        }

        public DaifaWaitSendExample.Criteria andExpressNameIn(List<String> values) {
            return in(expressName, values);
        }

        public DaifaWaitSendExample.Criteria andExpressNameNotIn(List<String> values) {
            return notIn(expressName, values);
        }

        public DaifaWaitSendExample.Criteria andExpressNameBetween(String value1, String value2) {
            return between(expressName, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andExpressNameNotBetween(String value1, String value2) {
            return notBetween(expressName, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andExpressCodeIsNull() {
            return isNull(expressCode);
        }

        public DaifaWaitSendExample.Criteria andExpressCodeIsNotNull() {
            return isNotNull(expressCode);
        }

        public DaifaWaitSendExample.Criteria andExpressCodeEqualTo(String value) {
            return equalTo(expressCode, value);
        }

        public DaifaWaitSendExample.Criteria andExpressCodeNotEqualTo(String value) {
            return notEqualTo(expressCode, value);
        }

        public DaifaWaitSendExample.Criteria andExpressCodeGreaterThan(String value) {
            return greaterThan(expressCode, value);
        }

        public DaifaWaitSendExample.Criteria andExpressCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressCode, value);
        }

        public DaifaWaitSendExample.Criteria andExpressCodeLessThan(String value) {
            return lessThan(expressCode, value);
        }

        public DaifaWaitSendExample.Criteria andExpressCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressCode, value);
        }

        public DaifaWaitSendExample.Criteria andExpressCodeLike(String value) {
            return like(expressCode, value);
        }

        public DaifaWaitSendExample.Criteria andExpressCodeNotLike(String value) {
            return notLike(expressCode, value);
        }

        public DaifaWaitSendExample.Criteria andExpressCodeIn(List<String> values) {
            return in(expressCode, values);
        }

        public DaifaWaitSendExample.Criteria andExpressCodeNotIn(List<String> values) {
            return notIn(expressCode, values);
        }

        public DaifaWaitSendExample.Criteria andExpressCodeBetween(String value1, String value2) {
            return between(expressCode, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andExpressCodeNotBetween(String value1, String value2) {
            return notBetween(expressCode, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andExpressFeeIsNull() {
            return isNull(expressFee);
        }

        public DaifaWaitSendExample.Criteria andExpressFeeIsNotNull() {
            return isNotNull(expressFee);
        }

        public DaifaWaitSendExample.Criteria andExpressFeeEqualTo(String value) {
            return equalTo(expressFee, value);
        }

        public DaifaWaitSendExample.Criteria andExpressFeeNotEqualTo(String value) {
            return notEqualTo(expressFee, value);
        }

        public DaifaWaitSendExample.Criteria andExpressFeeGreaterThan(String value) {
            return greaterThan(expressFee, value);
        }

        public DaifaWaitSendExample.Criteria andExpressFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressFee, value);
        }

        public DaifaWaitSendExample.Criteria andExpressFeeLessThan(String value) {
            return lessThan(expressFee, value);
        }

        public DaifaWaitSendExample.Criteria andExpressFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressFee, value);
        }

        public DaifaWaitSendExample.Criteria andExpressFeeLike(String value) {
            return like(expressFee, value);
        }

        public DaifaWaitSendExample.Criteria andExpressFeeNotLike(String value) {
            return notLike(expressFee, value);
        }

        public DaifaWaitSendExample.Criteria andExpressFeeIn(List<String> values) {
            return in(expressFee, values);
        }

        public DaifaWaitSendExample.Criteria andExpressFeeNotIn(List<String> values) {
            return notIn(expressFee, values);
        }

        public DaifaWaitSendExample.Criteria andExpressFeeBetween(String value1, String value2) {
            return between(expressFee, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andExpressFeeNotBetween(String value1, String value2) {
            return notBetween(expressFee, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andReceiverStateIsNull() {
            return isNull(receiverState);
        }

        public DaifaWaitSendExample.Criteria andReceiverStateIsNotNull() {
            return isNotNull(receiverState);
        }

        public DaifaWaitSendExample.Criteria andReceiverStateEqualTo(String value) {
            return equalTo(receiverState, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverStateNotEqualTo(String value) {
            return notEqualTo(receiverState, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverStateGreaterThan(String value) {
            return greaterThan(receiverState, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverStateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverState, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverStateLessThan(String value) {
            return lessThan(receiverState, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverStateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverState, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverStateLike(String value) {
            return like(receiverState, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverStateNotLike(String value) {
            return notLike(receiverState, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverStateIn(List<String> values) {
            return in(receiverState, values);
        }

        public DaifaWaitSendExample.Criteria andReceiverStateNotIn(List<String> values) {
            return notIn(receiverState, values);
        }

        public DaifaWaitSendExample.Criteria andReceiverStateBetween(String value1, String value2) {
            return between(receiverState, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andReceiverStateNotBetween(String value1, String value2) {
            return notBetween(receiverState, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andReceiverAddressIsNull() {
            return isNull(receiverAddress);
        }

        public DaifaWaitSendExample.Criteria andReceiverAddressIsNotNull() {
            return isNotNull(receiverAddress);
        }

        public DaifaWaitSendExample.Criteria andReceiverAddressEqualTo(String value) {
            return equalTo(receiverAddress, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverAddressNotEqualTo(String value) {
            return notEqualTo(receiverAddress, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverAddressGreaterThan(String value) {
            return greaterThan(receiverAddress, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverAddressGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverAddress, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverAddressLessThan(String value) {
            return lessThan(receiverAddress, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverAddressLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverAddress, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverAddressLike(String value) {
            return like(receiverAddress, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverAddressNotLike(String value) {
            return notLike(receiverAddress, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverAddressIn(List<String> values) {
            return in(receiverAddress, values);
        }

        public DaifaWaitSendExample.Criteria andReceiverAddressNotIn(List<String> values) {
            return notIn(receiverAddress, values);
        }

        public DaifaWaitSendExample.Criteria andReceiverAddressBetween(String value1, String value2) {
            return between(receiverAddress, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andReceiverAddressNotBetween(String value1, String value2) {
            return notBetween(receiverAddress, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andReceiverNameIsNull() {
            return isNull(receiverName);
        }

        public DaifaWaitSendExample.Criteria andReceiverNameIsNotNull() {
            return isNotNull(receiverName);
        }

        public DaifaWaitSendExample.Criteria andReceiverNameEqualTo(String value) {
            return equalTo(receiverName, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverNameNotEqualTo(String value) {
            return notEqualTo(receiverName, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverNameGreaterThan(String value) {
            return greaterThan(receiverName, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverName, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverNameLessThan(String value) {
            return lessThan(receiverName, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverName, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverNameLike(String value) {
            return like(receiverName, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverNameNotLike(String value) {
            return notLike(receiverName, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverNameIn(List<String> values) {
            return in(receiverName, values);
        }

        public DaifaWaitSendExample.Criteria andReceiverNameNotIn(List<String> values) {
            return notIn(receiverName, values);
        }

        public DaifaWaitSendExample.Criteria andReceiverNameBetween(String value1, String value2) {
            return between(receiverName, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andReceiverNameNotBetween(String value1, String value2) {
            return notBetween(receiverName, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andReceiverPhoneIsNull() {
            return isNull(receiverPhone);
        }

        public DaifaWaitSendExample.Criteria andReceiverPhoneIsNotNull() {
            return isNotNull(receiverPhone);
        }

        public DaifaWaitSendExample.Criteria andReceiverPhoneEqualTo(String value) {
            return equalTo(receiverPhone, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverPhoneNotEqualTo(String value) {
            return notEqualTo(receiverPhone, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverPhoneGreaterThan(String value) {
            return greaterThan(receiverPhone, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverPhoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverPhone, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverPhoneLessThan(String value) {
            return lessThan(receiverPhone, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverPhoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverPhone, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverPhoneLike(String value) {
            return like(receiverPhone, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverPhoneNotLike(String value) {
            return notLike(receiverPhone, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverPhoneIn(List<String> values) {
            return in(receiverPhone, values);
        }

        public DaifaWaitSendExample.Criteria andReceiverPhoneNotIn(List<String> values) {
            return notIn(receiverPhone, values);
        }

        public DaifaWaitSendExample.Criteria andReceiverPhoneBetween(String value1, String value2) {
            return between(receiverPhone, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andReceiverPhoneNotBetween(String value1, String value2) {
            return notBetween(receiverPhone, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andBuyerRemarkIsNull() {
            return isNull(buyerRemark);
        }

        public DaifaWaitSendExample.Criteria andBuyerRemarkIsNotNull() {
            return isNotNull(buyerRemark);
        }

        public DaifaWaitSendExample.Criteria andBuyerRemarkEqualTo(String value) {
            return equalTo(buyerRemark, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerRemarkNotEqualTo(String value) {
            return notEqualTo(buyerRemark, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerRemarkGreaterThan(String value) {
            return greaterThan(buyerRemark, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerRemark, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerRemarkLessThan(String value) {
            return lessThan(buyerRemark, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerRemark, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerRemarkLike(String value) {
            return like(buyerRemark, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerRemarkNotLike(String value) {
            return notLike(buyerRemark, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerRemarkIn(List<String> values) {
            return in(buyerRemark, values);
        }

        public DaifaWaitSendExample.Criteria andBuyerRemarkNotIn(List<String> values) {
            return notIn(buyerRemark, values);
        }

        public DaifaWaitSendExample.Criteria andBuyerRemarkBetween(String value1, String value2) {
            return between(buyerRemark, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andBuyerRemarkNotBetween(String value1, String value2) {
            return notBetween(buyerRemark, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andTaobaoTidIsNull() {
            return isNull(taobaoTid);
        }

        public DaifaWaitSendExample.Criteria andTaobaoTidIsNotNull() {
            return isNotNull(taobaoTid);
        }

        public DaifaWaitSendExample.Criteria andTaobaoTidEqualTo(Long value) {
            return equalTo(taobaoTid, value);
        }

        public DaifaWaitSendExample.Criteria andTaobaoTidNotEqualTo(Long value) {
            return notEqualTo(taobaoTid, value);
        }

        public DaifaWaitSendExample.Criteria andTaobaoTidGreaterThan(Long value) {
            return greaterThan(taobaoTid, value);
        }

        public DaifaWaitSendExample.Criteria andTaobaoTidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(taobaoTid, value);
        }

        public DaifaWaitSendExample.Criteria andTaobaoTidLessThan(Long value) {
            return lessThan(taobaoTid, value);
        }

        public DaifaWaitSendExample.Criteria andTaobaoTidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(taobaoTid, value);
        }

        public DaifaWaitSendExample.Criteria andTaobaoTidLike(String value) {
            return like(taobaoTid, value);
        }

        public DaifaWaitSendExample.Criteria andTaobaoTidNotLike(String value) {
            return notLike(taobaoTid, value);
        }

        public DaifaWaitSendExample.Criteria andTaobaoTidIn(List<Long> values) {
            return in(taobaoTid, values);
        }

        public DaifaWaitSendExample.Criteria andTaobaoTidNotIn(List<Long> values) {
            return notIn(taobaoTid, values);
        }

        public DaifaWaitSendExample.Criteria andTaobaoTidBetween(Long value1, Long value2) {
            return between(taobaoTid, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andTaobaoTidNotBetween(Long value1, Long value2) {
            return notBetween(taobaoTid, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andMarkDestinationIsNull() {
            return isNull(markDestination);
        }

        public DaifaWaitSendExample.Criteria andMarkDestinationIsNotNull() {
            return isNotNull(markDestination);
        }

        public DaifaWaitSendExample.Criteria andMarkDestinationEqualTo(String value) {
            return equalTo(markDestination, value);
        }

        public DaifaWaitSendExample.Criteria andMarkDestinationNotEqualTo(String value) {
            return notEqualTo(markDestination, value);
        }

        public DaifaWaitSendExample.Criteria andMarkDestinationGreaterThan(String value) {
            return greaterThan(markDestination, value);
        }

        public DaifaWaitSendExample.Criteria andMarkDestinationGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(markDestination, value);
        }

        public DaifaWaitSendExample.Criteria andMarkDestinationLessThan(String value) {
            return lessThan(markDestination, value);
        }

        public DaifaWaitSendExample.Criteria andMarkDestinationLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(markDestination, value);
        }

        public DaifaWaitSendExample.Criteria andMarkDestinationLike(String value) {
            return like(markDestination, value);
        }

        public DaifaWaitSendExample.Criteria andMarkDestinationNotLike(String value) {
            return notLike(markDestination, value);
        }

        public DaifaWaitSendExample.Criteria andMarkDestinationIn(List<String> values) {
            return in(markDestination, values);
        }

        public DaifaWaitSendExample.Criteria andMarkDestinationNotIn(List<String> values) {
            return notIn(markDestination, values);
        }

        public DaifaWaitSendExample.Criteria andMarkDestinationBetween(String value1, String value2) {
            return between(markDestination, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andMarkDestinationNotBetween(String value1, String value2) {
            return notBetween(markDestination, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andPackageNameIsNull() {
            return isNull(packageName);
        }

        public DaifaWaitSendExample.Criteria andPackageNameIsNotNull() {
            return isNotNull(packageName);
        }

        public DaifaWaitSendExample.Criteria andPackageNameEqualTo(String value) {
            return equalTo(packageName, value);
        }

        public DaifaWaitSendExample.Criteria andPackageNameNotEqualTo(String value) {
            return notEqualTo(packageName, value);
        }

        public DaifaWaitSendExample.Criteria andPackageNameGreaterThan(String value) {
            return greaterThan(packageName, value);
        }

        public DaifaWaitSendExample.Criteria andPackageNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(packageName, value);
        }

        public DaifaWaitSendExample.Criteria andPackageNameLessThan(String value) {
            return lessThan(packageName, value);
        }

        public DaifaWaitSendExample.Criteria andPackageNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(packageName, value);
        }

        public DaifaWaitSendExample.Criteria andPackageNameLike(String value) {
            return like(packageName, value);
        }

        public DaifaWaitSendExample.Criteria andPackageNameNotLike(String value) {
            return notLike(packageName, value);
        }

        public DaifaWaitSendExample.Criteria andPackageNameIn(List<String> values) {
            return in(packageName, values);
        }

        public DaifaWaitSendExample.Criteria andPackageNameNotIn(List<String> values) {
            return notIn(packageName, values);
        }

        public DaifaWaitSendExample.Criteria andPackageNameBetween(String value1, String value2) {
            return between(packageName, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andPackageNameNotBetween(String value1, String value2) {
            return notBetween(packageName, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public DaifaWaitSendExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public DaifaWaitSendExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public DaifaWaitSendExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public DaifaWaitSendExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public DaifaWaitSendExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public DaifaWaitSendExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public DaifaWaitSendExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public DaifaWaitSendExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public DaifaWaitSendExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public DaifaWaitSendExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public DaifaWaitSendExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public DaifaWaitSendExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public DaifaWaitSendExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public DaifaWaitSendExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public DaifaWaitSendExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public DaifaWaitSendExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public DaifaWaitSendExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public DaifaWaitSendExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public DaifaWaitSendExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public DaifaWaitSendExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public DaifaWaitSendExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public DaifaWaitSendExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public DaifaWaitSendExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public DaifaWaitSendExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andTaobaoUserNickIsNull() {
            return isNull(taobaoUserNick);
        }

        public DaifaWaitSendExample.Criteria andTaobaoUserNickIsNotNull() {
            return isNotNull(taobaoUserNick);
        }

        public DaifaWaitSendExample.Criteria andTaobaoUserNickEqualTo(String value) {
            return equalTo(taobaoUserNick, value);
        }

        public DaifaWaitSendExample.Criteria andTaobaoUserNickNotEqualTo(String value) {
            return notEqualTo(taobaoUserNick, value);
        }

        public DaifaWaitSendExample.Criteria andTaobaoUserNickGreaterThan(String value) {
            return greaterThan(taobaoUserNick, value);
        }

        public DaifaWaitSendExample.Criteria andTaobaoUserNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(taobaoUserNick, value);
        }

        public DaifaWaitSendExample.Criteria andTaobaoUserNickLessThan(String value) {
            return lessThan(taobaoUserNick, value);
        }

        public DaifaWaitSendExample.Criteria andTaobaoUserNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(taobaoUserNick, value);
        }

        public DaifaWaitSendExample.Criteria andTaobaoUserNickLike(String value) {
            return like(taobaoUserNick, value);
        }

        public DaifaWaitSendExample.Criteria andTaobaoUserNickNotLike(String value) {
            return notLike(taobaoUserNick, value);
        }

        public DaifaWaitSendExample.Criteria andTaobaoUserNickIn(List<String> values) {
            return in(taobaoUserNick, values);
        }

        public DaifaWaitSendExample.Criteria andTaobaoUserNickNotIn(List<String> values) {
            return notIn(taobaoUserNick, values);
        }

        public DaifaWaitSendExample.Criteria andTaobaoUserNickBetween(String value1, String value2) {
            return between(taobaoUserNick, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andTaobaoUserNickNotBetween(String value1, String value2) {
            return notBetween(taobaoUserNick, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andReceiverQqIsNull() {
            return isNull(receiverQq);
        }

        public DaifaWaitSendExample.Criteria andReceiverQqIsNotNull() {
            return isNotNull(receiverQq);
        }

        public DaifaWaitSendExample.Criteria andReceiverQqEqualTo(String value) {
            return equalTo(receiverQq, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverQqNotEqualTo(String value) {
            return notEqualTo(receiverQq, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverQqGreaterThan(String value) {
            return greaterThan(receiverQq, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverQqGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverQq, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverQqLessThan(String value) {
            return lessThan(receiverQq, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverQqLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverQq, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverQqLike(String value) {
            return like(receiverQq, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverQqNotLike(String value) {
            return notLike(receiverQq, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverQqIn(List<String> values) {
            return in(receiverQq, values);
        }

        public DaifaWaitSendExample.Criteria andReceiverQqNotIn(List<String> values) {
            return notIn(receiverQq, values);
        }

        public DaifaWaitSendExample.Criteria andReceiverQqBetween(String value1, String value2) {
            return between(receiverQq, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andReceiverQqNotBetween(String value1, String value2) {
            return notBetween(receiverQq, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andBuyerNameIsNull() {
            return isNull(buyerName);
        }

        public DaifaWaitSendExample.Criteria andBuyerNameIsNotNull() {
            return isNotNull(buyerName);
        }

        public DaifaWaitSendExample.Criteria andBuyerNameEqualTo(String value) {
            return equalTo(buyerName, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerNameNotEqualTo(String value) {
            return notEqualTo(buyerName, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerNameGreaterThan(String value) {
            return greaterThan(buyerName, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerName, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerNameLessThan(String value) {
            return lessThan(buyerName, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerName, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerNameLike(String value) {
            return like(buyerName, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerNameNotLike(String value) {
            return notLike(buyerName, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerNameIn(List<String> values) {
            return in(buyerName, values);
        }

        public DaifaWaitSendExample.Criteria andBuyerNameNotIn(List<String> values) {
            return notIn(buyerName, values);
        }

        public DaifaWaitSendExample.Criteria andBuyerNameBetween(String value1, String value2) {
            return between(buyerName, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andBuyerNameNotBetween(String value1, String value2) {
            return notBetween(buyerName, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andBuyerTelephoneIsNull() {
            return isNull(buyerTelephone);
        }

        public DaifaWaitSendExample.Criteria andBuyerTelephoneIsNotNull() {
            return isNotNull(buyerTelephone);
        }

        public DaifaWaitSendExample.Criteria andBuyerTelephoneEqualTo(String value) {
            return equalTo(buyerTelephone, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerTelephoneNotEqualTo(String value) {
            return notEqualTo(buyerTelephone, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerTelephoneGreaterThan(String value) {
            return greaterThan(buyerTelephone, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerTelephoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerTelephone, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerTelephoneLessThan(String value) {
            return lessThan(buyerTelephone, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerTelephoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerTelephone, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerTelephoneLike(String value) {
            return like(buyerTelephone, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerTelephoneNotLike(String value) {
            return notLike(buyerTelephone, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerTelephoneIn(List<String> values) {
            return in(buyerTelephone, values);
        }

        public DaifaWaitSendExample.Criteria andBuyerTelephoneNotIn(List<String> values) {
            return notIn(buyerTelephone, values);
        }

        public DaifaWaitSendExample.Criteria andBuyerTelephoneBetween(String value1, String value2) {
            return between(buyerTelephone, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andBuyerTelephoneNotBetween(String value1, String value2) {
            return notBetween(buyerTelephone, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andBuyerQqIsNull() {
            return isNull(buyerQq);
        }

        public DaifaWaitSendExample.Criteria andBuyerQqIsNotNull() {
            return isNotNull(buyerQq);
        }

        public DaifaWaitSendExample.Criteria andBuyerQqEqualTo(String value) {
            return equalTo(buyerQq, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerQqNotEqualTo(String value) {
            return notEqualTo(buyerQq, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerQqGreaterThan(String value) {
            return greaterThan(buyerQq, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerQqGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerQq, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerQqLessThan(String value) {
            return lessThan(buyerQq, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerQqLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerQq, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerQqLike(String value) {
            return like(buyerQq, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerQqNotLike(String value) {
            return notLike(buyerQq, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerQqIn(List<String> values) {
            return in(buyerQq, values);
        }

        public DaifaWaitSendExample.Criteria andBuyerQqNotIn(List<String> values) {
            return notIn(buyerQq, values);
        }

        public DaifaWaitSendExample.Criteria andBuyerQqBetween(String value1, String value2) {
            return between(buyerQq, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andBuyerQqNotBetween(String value1, String value2) {
            return notBetween(buyerQq, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andBuyerWwIsNull() {
            return isNull(buyerWw);
        }

        public DaifaWaitSendExample.Criteria andBuyerWwIsNotNull() {
            return isNotNull(buyerWw);
        }

        public DaifaWaitSendExample.Criteria andBuyerWwEqualTo(String value) {
            return equalTo(buyerWw, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerWwNotEqualTo(String value) {
            return notEqualTo(buyerWw, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerWwGreaterThan(String value) {
            return greaterThan(buyerWw, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerWwGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerWw, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerWwLessThan(String value) {
            return lessThan(buyerWw, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerWwLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerWw, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerWwLike(String value) {
            return like(buyerWw, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerWwNotLike(String value) {
            return notLike(buyerWw, value);
        }

        public DaifaWaitSendExample.Criteria andBuyerWwIn(List<String> values) {
            return in(buyerWw, values);
        }

        public DaifaWaitSendExample.Criteria andBuyerWwNotIn(List<String> values) {
            return notIn(buyerWw, values);
        }

        public DaifaWaitSendExample.Criteria andBuyerWwBetween(String value1, String value2) {
            return between(buyerWw, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andBuyerWwNotBetween(String value1, String value2) {
            return notBetween(buyerWw, value1, value2);
        }
        public DaifaWaitSendExample.Criteria andReceiverZipIsNull() {
            return isNull(receiverZip);
        }

        public DaifaWaitSendExample.Criteria andReceiverZipIsNotNull() {
            return isNotNull(receiverZip);
        }

        public DaifaWaitSendExample.Criteria andReceiverZipEqualTo(String value) {
            return equalTo(receiverZip, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverZipNotEqualTo(String value) {
            return notEqualTo(receiverZip, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverZipGreaterThan(String value) {
            return greaterThan(receiverZip, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverZipGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverZip, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverZipLessThan(String value) {
            return lessThan(receiverZip, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverZipLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverZip, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverZipLike(String value) {
            return like(receiverZip, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverZipNotLike(String value) {
            return notLike(receiverZip, value);
        }

        public DaifaWaitSendExample.Criteria andReceiverZipIn(List<String> values) {
            return in(receiverZip, values);
        }

        public DaifaWaitSendExample.Criteria andReceiverZipNotIn(List<String> values) {
            return notIn(receiverZip, values);
        }

        public DaifaWaitSendExample.Criteria andReceiverZipBetween(String value1, String value2) {
            return between(receiverZip, value1, value2);
        }

        public DaifaWaitSendExample.Criteria andReceiverZipNotBetween(String value1, String value2) {
            return notBetween(receiverZip, value1, value2);
        }
    }
}