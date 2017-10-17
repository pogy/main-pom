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
    protected Criteria createCriteriaInternal() {
        return new Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public Criteria andDwsIdIsNull() {
            return isNull(dwsId);
        }

        public Criteria andDwsIdIsNotNull() {
            return isNotNull(dwsId);
        }

        public Criteria andDwsIdEqualTo(Long value) {
            return equalTo(dwsId, value);
        }

        public Criteria andDwsIdNotEqualTo(Long value) {
            return notEqualTo(dwsId, value);
        }

        public Criteria andDwsIdGreaterThan(Long value) {
            return greaterThan(dwsId, value);
        }

        public Criteria andDwsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dwsId, value);
        }

        public Criteria andDwsIdLessThan(Long value) {
            return lessThan(dwsId, value);
        }

        public Criteria andDwsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dwsId, value);
        }

        public Criteria andDwsIdLike(String value) {
            return like(dwsId, value);
        }

        public Criteria andDwsIdNotLike(String value) {
            return notLike(dwsId, value);
        }

        public Criteria andDwsIdIn(List<Long> values) {
            return in(dwsId, values);
        }

        public Criteria andDwsIdNotIn(List<Long> values) {
            return notIn(dwsId, values);
        }

        public Criteria andDwsIdBetween(Long value1, Long value2) {
            return between(dwsId, value1, value2);
        }

        public Criteria andDwsIdNotBetween(Long value1, Long value2) {
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

        public Criteria andDfTradeIdLike(String value) {
            return like(dfTradeId, value);
        }

        public Criteria andDfTradeIdNotLike(String value) {
            return notLike(dfTradeId, value);
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
        public Criteria andSellerIdIsNull() {
            return isNull(sellerId);
        }

        public Criteria andSellerIdIsNotNull() {
            return isNotNull(sellerId);
        }

        public Criteria andSellerIdEqualTo(Long value) {
            return equalTo(sellerId, value);
        }

        public Criteria andSellerIdNotEqualTo(Long value) {
            return notEqualTo(sellerId, value);
        }

        public Criteria andSellerIdGreaterThan(Long value) {
            return greaterThan(sellerId, value);
        }

        public Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerId, value);
        }

        public Criteria andSellerIdLessThan(Long value) {
            return lessThan(sellerId, value);
        }

        public Criteria andSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerId, value);
        }

        public Criteria andSellerIdLike(String value) {
            return like(sellerId, value);
        }

        public Criteria andSellerIdNotLike(String value) {
            return notLike(sellerId, value);
        }

        public Criteria andSellerIdIn(List<Long> values) {
            return in(sellerId, values);
        }

        public Criteria andSellerIdNotIn(List<Long> values) {
            return notIn(sellerId, values);
        }

        public Criteria andSellerIdBetween(Long value1, Long value2) {
            return between(sellerId, value1, value2);
        }

        public Criteria andSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(sellerId, value1, value2);
        }
        public Criteria andSendStatusIsNull() {
            return isNull(sendStatus);
        }

        public Criteria andSendStatusIsNotNull() {
            return isNotNull(sendStatus);
        }

        public Criteria andSendStatusEqualTo(Integer value) {
            return equalTo(sendStatus, value);
        }

        public Criteria andSendStatusNotEqualTo(Integer value) {
            return notEqualTo(sendStatus, value);
        }

        public Criteria andSendStatusGreaterThan(Integer value) {
            return greaterThan(sendStatus, value);
        }

        public Criteria andSendStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sendStatus, value);
        }

        public Criteria andSendStatusLessThan(Integer value) {
            return lessThan(sendStatus, value);
        }

        public Criteria andSendStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sendStatus, value);
        }

        public Criteria andSendStatusIn(List<Integer> values) {
            return in(sendStatus, values);
        }

        public Criteria andSendStatusNotIn(List<Integer> values) {
            return notIn(sendStatus, values);
        }

        public Criteria andSendStatusBetween(Integer value1, Integer value2) {
            return between(sendStatus, value1, value2);
        }

        public Criteria andSendStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(sendStatus, value1, value2);
        }
        public Criteria andStockStatusIsNull() {
            return isNull(stockStatus);
        }

        public Criteria andStockStatusIsNotNull() {
            return isNotNull(stockStatus);
        }

        public Criteria andStockStatusEqualTo(Integer value) {
            return equalTo(stockStatus, value);
        }

        public Criteria andStockStatusNotEqualTo(Integer value) {
            return notEqualTo(stockStatus, value);
        }

        public Criteria andStockStatusGreaterThan(Integer value) {
            return greaterThan(stockStatus, value);
        }

        public Criteria andStockStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(stockStatus, value);
        }

        public Criteria andStockStatusLessThan(Integer value) {
            return lessThan(stockStatus, value);
        }

        public Criteria andStockStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(stockStatus, value);
        }

        public Criteria andStockStatusIn(List<Integer> values) {
            return in(stockStatus, values);
        }

        public Criteria andStockStatusNotIn(List<Integer> values) {
            return notIn(stockStatus, values);
        }

        public Criteria andStockStatusBetween(Integer value1, Integer value2) {
            return between(stockStatus, value1, value2);
        }

        public Criteria andStockStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(stockStatus, value1, value2);
        }
        public Criteria andCreateDateIsNull() {
            return isNull(createDate);
        }

        public Criteria andCreateDateIsNotNull() {
            return isNotNull(createDate);
        }

        public Criteria andCreateDateEqualTo(String value) {
            return equalTo(createDate, value);
        }

        public Criteria andCreateDateNotEqualTo(String value) {
            return notEqualTo(createDate, value);
        }

        public Criteria andCreateDateGreaterThan(String value) {
            return greaterThan(createDate, value);
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(createDate, value);
        }

        public Criteria andCreateDateLessThan(String value) {
            return lessThan(createDate, value);
        }

        public Criteria andCreateDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(createDate, value);
        }

        public Criteria andCreateDateLike(String value) {
            return like(createDate, value);
        }

        public Criteria andCreateDateNotLike(String value) {
            return notLike(createDate, value);
        }

        public Criteria andCreateDateIn(List<String> values) {
            return in(createDate, values);
        }

        public Criteria andCreateDateNotIn(List<String> values) {
            return notIn(createDate, values);
        }

        public Criteria andCreateDateBetween(String value1, String value2) {
            return between(createDate, value1, value2);
        }

        public Criteria andCreateDateNotBetween(String value1, String value2) {
            return notBetween(createDate, value1, value2);
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
        public Criteria andSendDateIsNull() {
            return isNull(sendDate);
        }

        public Criteria andSendDateIsNotNull() {
            return isNotNull(sendDate);
        }

        public Criteria andSendDateEqualTo(String value) {
            return equalTo(sendDate, value);
        }

        public Criteria andSendDateNotEqualTo(String value) {
            return notEqualTo(sendDate, value);
        }

        public Criteria andSendDateGreaterThan(String value) {
            return greaterThan(sendDate, value);
        }

        public Criteria andSendDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sendDate, value);
        }

        public Criteria andSendDateLessThan(String value) {
            return lessThan(sendDate, value);
        }

        public Criteria andSendDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sendDate, value);
        }

        public Criteria andSendDateLike(String value) {
            return like(sendDate, value);
        }

        public Criteria andSendDateNotLike(String value) {
            return notLike(sendDate, value);
        }

        public Criteria andSendDateIn(List<String> values) {
            return in(sendDate, values);
        }

        public Criteria andSendDateNotIn(List<String> values) {
            return notIn(sendDate, values);
        }

        public Criteria andSendDateBetween(String value1, String value2) {
            return between(sendDate, value1, value2);
        }

        public Criteria andSendDateNotBetween(String value1, String value2) {
            return notBetween(sendDate, value1, value2);
        }
        public Criteria andSendTimeIsNull() {
            return isNull(sendTime);
        }

        public Criteria andSendTimeIsNotNull() {
            return isNotNull(sendTime);
        }

        public Criteria andSendTimeEqualTo(Date value) {
            return equalTo(sendTime, value);
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            return notEqualTo(sendTime, value);
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            return greaterThan(sendTime, value);
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(sendTime, value);
        }

        public Criteria andSendTimeLessThan(Date value) {
            return lessThan(sendTime, value);
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(sendTime, value);
        }

        public Criteria andSendTimeIn(List<Date> values) {
            return in(sendTime, values);
        }

        public Criteria andSendTimeNotIn(List<Date> values) {
            return notIn(sendTime, values);
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            return between(sendTime, value1, value2);
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            return notBetween(sendTime, value1, value2);
        }
        public Criteria andMoneyIsNull() {
            return isNull(money);
        }

        public Criteria andMoneyIsNotNull() {
            return isNotNull(money);
        }

        public Criteria andMoneyEqualTo(String value) {
            return equalTo(money, value);
        }

        public Criteria andMoneyNotEqualTo(String value) {
            return notEqualTo(money, value);
        }

        public Criteria andMoneyGreaterThan(String value) {
            return greaterThan(money, value);
        }

        public Criteria andMoneyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(money, value);
        }

        public Criteria andMoneyLessThan(String value) {
            return lessThan(money, value);
        }

        public Criteria andMoneyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(money, value);
        }

        public Criteria andMoneyLike(String value) {
            return like(money, value);
        }

        public Criteria andMoneyNotLike(String value) {
            return notLike(money, value);
        }

        public Criteria andMoneyIn(List<String> values) {
            return in(money, values);
        }

        public Criteria andMoneyNotIn(List<String> values) {
            return notIn(money, values);
        }

        public Criteria andMoneyBetween(String value1, String value2) {
            return between(money, value1, value2);
        }

        public Criteria andMoneyNotBetween(String value1, String value2) {
            return notBetween(money, value1, value2);
        }
        public Criteria andBuyerIdIsNull() {
            return isNull(buyerId);
        }

        public Criteria andBuyerIdIsNotNull() {
            return isNotNull(buyerId);
        }

        public Criteria andBuyerIdEqualTo(Long value) {
            return equalTo(buyerId, value);
        }

        public Criteria andBuyerIdNotEqualTo(Long value) {
            return notEqualTo(buyerId, value);
        }

        public Criteria andBuyerIdGreaterThan(Long value) {
            return greaterThan(buyerId, value);
        }

        public Criteria andBuyerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(buyerId, value);
        }

        public Criteria andBuyerIdLessThan(Long value) {
            return lessThan(buyerId, value);
        }

        public Criteria andBuyerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(buyerId, value);
        }

        public Criteria andBuyerIdLike(String value) {
            return like(buyerId, value);
        }

        public Criteria andBuyerIdNotLike(String value) {
            return notLike(buyerId, value);
        }

        public Criteria andBuyerIdIn(List<Long> values) {
            return in(buyerId, values);
        }

        public Criteria andBuyerIdNotIn(List<Long> values) {
            return notIn(buyerId, values);
        }

        public Criteria andBuyerIdBetween(Long value1, Long value2) {
            return between(buyerId, value1, value2);
        }

        public Criteria andBuyerIdNotBetween(Long value1, Long value2) {
            return notBetween(buyerId, value1, value2);
        }
        public Criteria andExpressIdIsNull() {
            return isNull(expressId);
        }

        public Criteria andExpressIdIsNotNull() {
            return isNotNull(expressId);
        }

        public Criteria andExpressIdEqualTo(Long value) {
            return equalTo(expressId, value);
        }

        public Criteria andExpressIdNotEqualTo(Long value) {
            return notEqualTo(expressId, value);
        }

        public Criteria andExpressIdGreaterThan(Long value) {
            return greaterThan(expressId, value);
        }

        public Criteria andExpressIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(expressId, value);
        }

        public Criteria andExpressIdLessThan(Long value) {
            return lessThan(expressId, value);
        }

        public Criteria andExpressIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(expressId, value);
        }

        public Criteria andExpressIdLike(String value) {
            return like(expressId, value);
        }

        public Criteria andExpressIdNotLike(String value) {
            return notLike(expressId, value);
        }

        public Criteria andExpressIdIn(List<Long> values) {
            return in(expressId, values);
        }

        public Criteria andExpressIdNotIn(List<Long> values) {
            return notIn(expressId, values);
        }

        public Criteria andExpressIdBetween(Long value1, Long value2) {
            return between(expressId, value1, value2);
        }

        public Criteria andExpressIdNotBetween(Long value1, Long value2) {
            return notBetween(expressId, value1, value2);
        }
        public Criteria andExpressNameIsNull() {
            return isNull(expressName);
        }

        public Criteria andExpressNameIsNotNull() {
            return isNotNull(expressName);
        }

        public Criteria andExpressNameEqualTo(String value) {
            return equalTo(expressName, value);
        }

        public Criteria andExpressNameNotEqualTo(String value) {
            return notEqualTo(expressName, value);
        }

        public Criteria andExpressNameGreaterThan(String value) {
            return greaterThan(expressName, value);
        }

        public Criteria andExpressNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressName, value);
        }

        public Criteria andExpressNameLessThan(String value) {
            return lessThan(expressName, value);
        }

        public Criteria andExpressNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressName, value);
        }

        public Criteria andExpressNameLike(String value) {
            return like(expressName, value);
        }

        public Criteria andExpressNameNotLike(String value) {
            return notLike(expressName, value);
        }

        public Criteria andExpressNameIn(List<String> values) {
            return in(expressName, values);
        }

        public Criteria andExpressNameNotIn(List<String> values) {
            return notIn(expressName, values);
        }

        public Criteria andExpressNameBetween(String value1, String value2) {
            return between(expressName, value1, value2);
        }

        public Criteria andExpressNameNotBetween(String value1, String value2) {
            return notBetween(expressName, value1, value2);
        }
        public Criteria andExpressCodeIsNull() {
            return isNull(expressCode);
        }

        public Criteria andExpressCodeIsNotNull() {
            return isNotNull(expressCode);
        }

        public Criteria andExpressCodeEqualTo(String value) {
            return equalTo(expressCode, value);
        }

        public Criteria andExpressCodeNotEqualTo(String value) {
            return notEqualTo(expressCode, value);
        }

        public Criteria andExpressCodeGreaterThan(String value) {
            return greaterThan(expressCode, value);
        }

        public Criteria andExpressCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressCode, value);
        }

        public Criteria andExpressCodeLessThan(String value) {
            return lessThan(expressCode, value);
        }

        public Criteria andExpressCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressCode, value);
        }

        public Criteria andExpressCodeLike(String value) {
            return like(expressCode, value);
        }

        public Criteria andExpressCodeNotLike(String value) {
            return notLike(expressCode, value);
        }

        public Criteria andExpressCodeIn(List<String> values) {
            return in(expressCode, values);
        }

        public Criteria andExpressCodeNotIn(List<String> values) {
            return notIn(expressCode, values);
        }

        public Criteria andExpressCodeBetween(String value1, String value2) {
            return between(expressCode, value1, value2);
        }

        public Criteria andExpressCodeNotBetween(String value1, String value2) {
            return notBetween(expressCode, value1, value2);
        }
        public Criteria andExpressFeeIsNull() {
            return isNull(expressFee);
        }

        public Criteria andExpressFeeIsNotNull() {
            return isNotNull(expressFee);
        }

        public Criteria andExpressFeeEqualTo(String value) {
            return equalTo(expressFee, value);
        }

        public Criteria andExpressFeeNotEqualTo(String value) {
            return notEqualTo(expressFee, value);
        }

        public Criteria andExpressFeeGreaterThan(String value) {
            return greaterThan(expressFee, value);
        }

        public Criteria andExpressFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressFee, value);
        }

        public Criteria andExpressFeeLessThan(String value) {
            return lessThan(expressFee, value);
        }

        public Criteria andExpressFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressFee, value);
        }

        public Criteria andExpressFeeLike(String value) {
            return like(expressFee, value);
        }

        public Criteria andExpressFeeNotLike(String value) {
            return notLike(expressFee, value);
        }

        public Criteria andExpressFeeIn(List<String> values) {
            return in(expressFee, values);
        }

        public Criteria andExpressFeeNotIn(List<String> values) {
            return notIn(expressFee, values);
        }

        public Criteria andExpressFeeBetween(String value1, String value2) {
            return between(expressFee, value1, value2);
        }

        public Criteria andExpressFeeNotBetween(String value1, String value2) {
            return notBetween(expressFee, value1, value2);
        }
        public Criteria andReceiverStateIsNull() {
            return isNull(receiverState);
        }

        public Criteria andReceiverStateIsNotNull() {
            return isNotNull(receiverState);
        }

        public Criteria andReceiverStateEqualTo(String value) {
            return equalTo(receiverState, value);
        }

        public Criteria andReceiverStateNotEqualTo(String value) {
            return notEqualTo(receiverState, value);
        }

        public Criteria andReceiverStateGreaterThan(String value) {
            return greaterThan(receiverState, value);
        }

        public Criteria andReceiverStateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverState, value);
        }

        public Criteria andReceiverStateLessThan(String value) {
            return lessThan(receiverState, value);
        }

        public Criteria andReceiverStateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverState, value);
        }

        public Criteria andReceiverStateLike(String value) {
            return like(receiverState, value);
        }

        public Criteria andReceiverStateNotLike(String value) {
            return notLike(receiverState, value);
        }

        public Criteria andReceiverStateIn(List<String> values) {
            return in(receiverState, values);
        }

        public Criteria andReceiverStateNotIn(List<String> values) {
            return notIn(receiverState, values);
        }

        public Criteria andReceiverStateBetween(String value1, String value2) {
            return between(receiverState, value1, value2);
        }

        public Criteria andReceiverStateNotBetween(String value1, String value2) {
            return notBetween(receiverState, value1, value2);
        }
        public Criteria andReceiverAddressIsNull() {
            return isNull(receiverAddress);
        }

        public Criteria andReceiverAddressIsNotNull() {
            return isNotNull(receiverAddress);
        }

        public Criteria andReceiverAddressEqualTo(String value) {
            return equalTo(receiverAddress, value);
        }

        public Criteria andReceiverAddressNotEqualTo(String value) {
            return notEqualTo(receiverAddress, value);
        }

        public Criteria andReceiverAddressGreaterThan(String value) {
            return greaterThan(receiverAddress, value);
        }

        public Criteria andReceiverAddressGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverAddress, value);
        }

        public Criteria andReceiverAddressLessThan(String value) {
            return lessThan(receiverAddress, value);
        }

        public Criteria andReceiverAddressLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverAddress, value);
        }

        public Criteria andReceiverAddressLike(String value) {
            return like(receiverAddress, value);
        }

        public Criteria andReceiverAddressNotLike(String value) {
            return notLike(receiverAddress, value);
        }

        public Criteria andReceiverAddressIn(List<String> values) {
            return in(receiverAddress, values);
        }

        public Criteria andReceiverAddressNotIn(List<String> values) {
            return notIn(receiverAddress, values);
        }

        public Criteria andReceiverAddressBetween(String value1, String value2) {
            return between(receiverAddress, value1, value2);
        }

        public Criteria andReceiverAddressNotBetween(String value1, String value2) {
            return notBetween(receiverAddress, value1, value2);
        }
        public Criteria andReceiverNameIsNull() {
            return isNull(receiverName);
        }

        public Criteria andReceiverNameIsNotNull() {
            return isNotNull(receiverName);
        }

        public Criteria andReceiverNameEqualTo(String value) {
            return equalTo(receiverName, value);
        }

        public Criteria andReceiverNameNotEqualTo(String value) {
            return notEqualTo(receiverName, value);
        }

        public Criteria andReceiverNameGreaterThan(String value) {
            return greaterThan(receiverName, value);
        }

        public Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverName, value);
        }

        public Criteria andReceiverNameLessThan(String value) {
            return lessThan(receiverName, value);
        }

        public Criteria andReceiverNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverName, value);
        }

        public Criteria andReceiverNameLike(String value) {
            return like(receiverName, value);
        }

        public Criteria andReceiverNameNotLike(String value) {
            return notLike(receiverName, value);
        }

        public Criteria andReceiverNameIn(List<String> values) {
            return in(receiverName, values);
        }

        public Criteria andReceiverNameNotIn(List<String> values) {
            return notIn(receiverName, values);
        }

        public Criteria andReceiverNameBetween(String value1, String value2) {
            return between(receiverName, value1, value2);
        }

        public Criteria andReceiverNameNotBetween(String value1, String value2) {
            return notBetween(receiverName, value1, value2);
        }
        public Criteria andReceiverPhoneIsNull() {
            return isNull(receiverPhone);
        }

        public Criteria andReceiverPhoneIsNotNull() {
            return isNotNull(receiverPhone);
        }

        public Criteria andReceiverPhoneEqualTo(String value) {
            return equalTo(receiverPhone, value);
        }

        public Criteria andReceiverPhoneNotEqualTo(String value) {
            return notEqualTo(receiverPhone, value);
        }

        public Criteria andReceiverPhoneGreaterThan(String value) {
            return greaterThan(receiverPhone, value);
        }

        public Criteria andReceiverPhoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverPhone, value);
        }

        public Criteria andReceiverPhoneLessThan(String value) {
            return lessThan(receiverPhone, value);
        }

        public Criteria andReceiverPhoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverPhone, value);
        }

        public Criteria andReceiverPhoneLike(String value) {
            return like(receiverPhone, value);
        }

        public Criteria andReceiverPhoneNotLike(String value) {
            return notLike(receiverPhone, value);
        }

        public Criteria andReceiverPhoneIn(List<String> values) {
            return in(receiverPhone, values);
        }

        public Criteria andReceiverPhoneNotIn(List<String> values) {
            return notIn(receiverPhone, values);
        }

        public Criteria andReceiverPhoneBetween(String value1, String value2) {
            return between(receiverPhone, value1, value2);
        }

        public Criteria andReceiverPhoneNotBetween(String value1, String value2) {
            return notBetween(receiverPhone, value1, value2);
        }
        public Criteria andBuyerRemarkIsNull() {
            return isNull(buyerRemark);
        }

        public Criteria andBuyerRemarkIsNotNull() {
            return isNotNull(buyerRemark);
        }

        public Criteria andBuyerRemarkEqualTo(String value) {
            return equalTo(buyerRemark, value);
        }

        public Criteria andBuyerRemarkNotEqualTo(String value) {
            return notEqualTo(buyerRemark, value);
        }

        public Criteria andBuyerRemarkGreaterThan(String value) {
            return greaterThan(buyerRemark, value);
        }

        public Criteria andBuyerRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerRemark, value);
        }

        public Criteria andBuyerRemarkLessThan(String value) {
            return lessThan(buyerRemark, value);
        }

        public Criteria andBuyerRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerRemark, value);
        }

        public Criteria andBuyerRemarkLike(String value) {
            return like(buyerRemark, value);
        }

        public Criteria andBuyerRemarkNotLike(String value) {
            return notLike(buyerRemark, value);
        }

        public Criteria andBuyerRemarkIn(List<String> values) {
            return in(buyerRemark, values);
        }

        public Criteria andBuyerRemarkNotIn(List<String> values) {
            return notIn(buyerRemark, values);
        }

        public Criteria andBuyerRemarkBetween(String value1, String value2) {
            return between(buyerRemark, value1, value2);
        }

        public Criteria andBuyerRemarkNotBetween(String value1, String value2) {
            return notBetween(buyerRemark, value1, value2);
        }
        public Criteria andTaobaoTidIsNull() {
            return isNull(taobaoTid);
        }

        public Criteria andTaobaoTidIsNotNull() {
            return isNotNull(taobaoTid);
        }

        public Criteria andTaobaoTidEqualTo(Long value) {
            return equalTo(taobaoTid, value);
        }

        public Criteria andTaobaoTidNotEqualTo(Long value) {
            return notEqualTo(taobaoTid, value);
        }

        public Criteria andTaobaoTidGreaterThan(Long value) {
            return greaterThan(taobaoTid, value);
        }

        public Criteria andTaobaoTidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(taobaoTid, value);
        }

        public Criteria andTaobaoTidLessThan(Long value) {
            return lessThan(taobaoTid, value);
        }

        public Criteria andTaobaoTidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(taobaoTid, value);
        }

        public Criteria andTaobaoTidLike(String value) {
            return like(taobaoTid, value);
        }

        public Criteria andTaobaoTidNotLike(String value) {
            return notLike(taobaoTid, value);
        }

        public Criteria andTaobaoTidIn(List<Long> values) {
            return in(taobaoTid, values);
        }

        public Criteria andTaobaoTidNotIn(List<Long> values) {
            return notIn(taobaoTid, values);
        }

        public Criteria andTaobaoTidBetween(Long value1, Long value2) {
            return between(taobaoTid, value1, value2);
        }

        public Criteria andTaobaoTidNotBetween(Long value1, Long value2) {
            return notBetween(taobaoTid, value1, value2);
        }
        public Criteria andMarkDestinationIsNull() {
            return isNull(markDestination);
        }

        public Criteria andMarkDestinationIsNotNull() {
            return isNotNull(markDestination);
        }

        public Criteria andMarkDestinationEqualTo(String value) {
            return equalTo(markDestination, value);
        }

        public Criteria andMarkDestinationNotEqualTo(String value) {
            return notEqualTo(markDestination, value);
        }

        public Criteria andMarkDestinationGreaterThan(String value) {
            return greaterThan(markDestination, value);
        }

        public Criteria andMarkDestinationGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(markDestination, value);
        }

        public Criteria andMarkDestinationLessThan(String value) {
            return lessThan(markDestination, value);
        }

        public Criteria andMarkDestinationLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(markDestination, value);
        }

        public Criteria andMarkDestinationLike(String value) {
            return like(markDestination, value);
        }

        public Criteria andMarkDestinationNotLike(String value) {
            return notLike(markDestination, value);
        }

        public Criteria andMarkDestinationIn(List<String> values) {
            return in(markDestination, values);
        }

        public Criteria andMarkDestinationNotIn(List<String> values) {
            return notIn(markDestination, values);
        }

        public Criteria andMarkDestinationBetween(String value1, String value2) {
            return between(markDestination, value1, value2);
        }

        public Criteria andMarkDestinationNotBetween(String value1, String value2) {
            return notBetween(markDestination, value1, value2);
        }
        public Criteria andPackageNameIsNull() {
            return isNull(packageName);
        }

        public Criteria andPackageNameIsNotNull() {
            return isNotNull(packageName);
        }

        public Criteria andPackageNameEqualTo(String value) {
            return equalTo(packageName, value);
        }

        public Criteria andPackageNameNotEqualTo(String value) {
            return notEqualTo(packageName, value);
        }

        public Criteria andPackageNameGreaterThan(String value) {
            return greaterThan(packageName, value);
        }

        public Criteria andPackageNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(packageName, value);
        }

        public Criteria andPackageNameLessThan(String value) {
            return lessThan(packageName, value);
        }

        public Criteria andPackageNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(packageName, value);
        }

        public Criteria andPackageNameLike(String value) {
            return like(packageName, value);
        }

        public Criteria andPackageNameNotLike(String value) {
            return notLike(packageName, value);
        }

        public Criteria andPackageNameIn(List<String> values) {
            return in(packageName, values);
        }

        public Criteria andPackageNameNotIn(List<String> values) {
            return notIn(packageName, values);
        }

        public Criteria andPackageNameBetween(String value1, String value2) {
            return between(packageName, value1, value2);
        }

        public Criteria andPackageNameNotBetween(String value1, String value2) {
            return notBetween(packageName, value1, value2);
        }
        public Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
        public Criteria andTaobaoUserNickIsNull() {
            return isNull(taobaoUserNick);
        }

        public Criteria andTaobaoUserNickIsNotNull() {
            return isNotNull(taobaoUserNick);
        }

        public Criteria andTaobaoUserNickEqualTo(String value) {
            return equalTo(taobaoUserNick, value);
        }

        public Criteria andTaobaoUserNickNotEqualTo(String value) {
            return notEqualTo(taobaoUserNick, value);
        }

        public Criteria andTaobaoUserNickGreaterThan(String value) {
            return greaterThan(taobaoUserNick, value);
        }

        public Criteria andTaobaoUserNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(taobaoUserNick, value);
        }

        public Criteria andTaobaoUserNickLessThan(String value) {
            return lessThan(taobaoUserNick, value);
        }

        public Criteria andTaobaoUserNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(taobaoUserNick, value);
        }

        public Criteria andTaobaoUserNickLike(String value) {
            return like(taobaoUserNick, value);
        }

        public Criteria andTaobaoUserNickNotLike(String value) {
            return notLike(taobaoUserNick, value);
        }

        public Criteria andTaobaoUserNickIn(List<String> values) {
            return in(taobaoUserNick, values);
        }

        public Criteria andTaobaoUserNickNotIn(List<String> values) {
            return notIn(taobaoUserNick, values);
        }

        public Criteria andTaobaoUserNickBetween(String value1, String value2) {
            return between(taobaoUserNick, value1, value2);
        }

        public Criteria andTaobaoUserNickNotBetween(String value1, String value2) {
            return notBetween(taobaoUserNick, value1, value2);
        }
        public Criteria andReceiverQqIsNull() {
            return isNull(receiverQq);
        }

        public Criteria andReceiverQqIsNotNull() {
            return isNotNull(receiverQq);
        }

        public Criteria andReceiverQqEqualTo(String value) {
            return equalTo(receiverQq, value);
        }

        public Criteria andReceiverQqNotEqualTo(String value) {
            return notEqualTo(receiverQq, value);
        }

        public Criteria andReceiverQqGreaterThan(String value) {
            return greaterThan(receiverQq, value);
        }

        public Criteria andReceiverQqGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverQq, value);
        }

        public Criteria andReceiverQqLessThan(String value) {
            return lessThan(receiverQq, value);
        }

        public Criteria andReceiverQqLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverQq, value);
        }

        public Criteria andReceiverQqLike(String value) {
            return like(receiverQq, value);
        }

        public Criteria andReceiverQqNotLike(String value) {
            return notLike(receiverQq, value);
        }

        public Criteria andReceiverQqIn(List<String> values) {
            return in(receiverQq, values);
        }

        public Criteria andReceiverQqNotIn(List<String> values) {
            return notIn(receiverQq, values);
        }

        public Criteria andReceiverQqBetween(String value1, String value2) {
            return between(receiverQq, value1, value2);
        }

        public Criteria andReceiverQqNotBetween(String value1, String value2) {
            return notBetween(receiverQq, value1, value2);
        }
        public Criteria andBuyerNameIsNull() {
            return isNull(buyerName);
        }

        public Criteria andBuyerNameIsNotNull() {
            return isNotNull(buyerName);
        }

        public Criteria andBuyerNameEqualTo(String value) {
            return equalTo(buyerName, value);
        }

        public Criteria andBuyerNameNotEqualTo(String value) {
            return notEqualTo(buyerName, value);
        }

        public Criteria andBuyerNameGreaterThan(String value) {
            return greaterThan(buyerName, value);
        }

        public Criteria andBuyerNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerName, value);
        }

        public Criteria andBuyerNameLessThan(String value) {
            return lessThan(buyerName, value);
        }

        public Criteria andBuyerNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerName, value);
        }

        public Criteria andBuyerNameLike(String value) {
            return like(buyerName, value);
        }

        public Criteria andBuyerNameNotLike(String value) {
            return notLike(buyerName, value);
        }

        public Criteria andBuyerNameIn(List<String> values) {
            return in(buyerName, values);
        }

        public Criteria andBuyerNameNotIn(List<String> values) {
            return notIn(buyerName, values);
        }

        public Criteria andBuyerNameBetween(String value1, String value2) {
            return between(buyerName, value1, value2);
        }

        public Criteria andBuyerNameNotBetween(String value1, String value2) {
            return notBetween(buyerName, value1, value2);
        }
        public Criteria andBuyerTelephoneIsNull() {
            return isNull(buyerTelephone);
        }

        public Criteria andBuyerTelephoneIsNotNull() {
            return isNotNull(buyerTelephone);
        }

        public Criteria andBuyerTelephoneEqualTo(String value) {
            return equalTo(buyerTelephone, value);
        }

        public Criteria andBuyerTelephoneNotEqualTo(String value) {
            return notEqualTo(buyerTelephone, value);
        }

        public Criteria andBuyerTelephoneGreaterThan(String value) {
            return greaterThan(buyerTelephone, value);
        }

        public Criteria andBuyerTelephoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerTelephone, value);
        }

        public Criteria andBuyerTelephoneLessThan(String value) {
            return lessThan(buyerTelephone, value);
        }

        public Criteria andBuyerTelephoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerTelephone, value);
        }

        public Criteria andBuyerTelephoneLike(String value) {
            return like(buyerTelephone, value);
        }

        public Criteria andBuyerTelephoneNotLike(String value) {
            return notLike(buyerTelephone, value);
        }

        public Criteria andBuyerTelephoneIn(List<String> values) {
            return in(buyerTelephone, values);
        }

        public Criteria andBuyerTelephoneNotIn(List<String> values) {
            return notIn(buyerTelephone, values);
        }

        public Criteria andBuyerTelephoneBetween(String value1, String value2) {
            return between(buyerTelephone, value1, value2);
        }

        public Criteria andBuyerTelephoneNotBetween(String value1, String value2) {
            return notBetween(buyerTelephone, value1, value2);
        }
        public Criteria andBuyerQqIsNull() {
            return isNull(buyerQq);
        }

        public Criteria andBuyerQqIsNotNull() {
            return isNotNull(buyerQq);
        }

        public Criteria andBuyerQqEqualTo(String value) {
            return equalTo(buyerQq, value);
        }

        public Criteria andBuyerQqNotEqualTo(String value) {
            return notEqualTo(buyerQq, value);
        }

        public Criteria andBuyerQqGreaterThan(String value) {
            return greaterThan(buyerQq, value);
        }

        public Criteria andBuyerQqGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerQq, value);
        }

        public Criteria andBuyerQqLessThan(String value) {
            return lessThan(buyerQq, value);
        }

        public Criteria andBuyerQqLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerQq, value);
        }

        public Criteria andBuyerQqLike(String value) {
            return like(buyerQq, value);
        }

        public Criteria andBuyerQqNotLike(String value) {
            return notLike(buyerQq, value);
        }

        public Criteria andBuyerQqIn(List<String> values) {
            return in(buyerQq, values);
        }

        public Criteria andBuyerQqNotIn(List<String> values) {
            return notIn(buyerQq, values);
        }

        public Criteria andBuyerQqBetween(String value1, String value2) {
            return between(buyerQq, value1, value2);
        }

        public Criteria andBuyerQqNotBetween(String value1, String value2) {
            return notBetween(buyerQq, value1, value2);
        }
        public Criteria andBuyerWwIsNull() {
            return isNull(buyerWw);
        }

        public Criteria andBuyerWwIsNotNull() {
            return isNotNull(buyerWw);
        }

        public Criteria andBuyerWwEqualTo(String value) {
            return equalTo(buyerWw, value);
        }

        public Criteria andBuyerWwNotEqualTo(String value) {
            return notEqualTo(buyerWw, value);
        }

        public Criteria andBuyerWwGreaterThan(String value) {
            return greaterThan(buyerWw, value);
        }

        public Criteria andBuyerWwGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerWw, value);
        }

        public Criteria andBuyerWwLessThan(String value) {
            return lessThan(buyerWw, value);
        }

        public Criteria andBuyerWwLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerWw, value);
        }

        public Criteria andBuyerWwLike(String value) {
            return like(buyerWw, value);
        }

        public Criteria andBuyerWwNotLike(String value) {
            return notLike(buyerWw, value);
        }

        public Criteria andBuyerWwIn(List<String> values) {
            return in(buyerWw, values);
        }

        public Criteria andBuyerWwNotIn(List<String> values) {
            return notIn(buyerWw, values);
        }

        public Criteria andBuyerWwBetween(String value1, String value2) {
            return between(buyerWw, value1, value2);
        }

        public Criteria andBuyerWwNotBetween(String value1, String value2) {
            return notBetween(buyerWw, value1, value2);
        }
        public Criteria andReceiverZipIsNull() {
            return isNull(receiverZip);
        }

        public Criteria andReceiverZipIsNotNull() {
            return isNotNull(receiverZip);
        }

        public Criteria andReceiverZipEqualTo(String value) {
            return equalTo(receiverZip, value);
        }

        public Criteria andReceiverZipNotEqualTo(String value) {
            return notEqualTo(receiverZip, value);
        }

        public Criteria andReceiverZipGreaterThan(String value) {
            return greaterThan(receiverZip, value);
        }

        public Criteria andReceiverZipGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverZip, value);
        }

        public Criteria andReceiverZipLessThan(String value) {
            return lessThan(receiverZip, value);
        }

        public Criteria andReceiverZipLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverZip, value);
        }

        public Criteria andReceiverZipLike(String value) {
            return like(receiverZip, value);
        }

        public Criteria andReceiverZipNotLike(String value) {
            return notLike(receiverZip, value);
        }

        public Criteria andReceiverZipIn(List<String> values) {
            return in(receiverZip, values);
        }

        public Criteria andReceiverZipNotIn(List<String> values) {
            return notIn(receiverZip, values);
        }

        public Criteria andReceiverZipBetween(String value1, String value2) {
            return between(receiverZip, value1, value2);
        }

        public Criteria andReceiverZipNotBetween(String value1, String value2) {
            return notBetween(receiverZip, value1, value2);
        }
    }
}