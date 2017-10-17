package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaTrade;

import java.util.*;
public class DaifaTradeExample extends SgExample<DaifaTradeExample.Criteria> {
    public static final Class<DaifaTrade> beanClass = DaifaTrade.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn buyerNick;
    public static EntityColumn payTime;
    public static EntityColumn afterRemark;
    public static EntityColumn tradeDiscountFee;
    public static EntityColumn buyerId;
    public static EntityColumn expressFee;
    public static EntityColumn buyerQq;
    public static EntityColumn buyerRemark;
    public static EntityColumn sellerId;
    public static EntityColumn receiverPhone;
    public static EntityColumn receiverQq;
    public static EntityColumn expressCode;
    public static EntityColumn lastDoTime;
    public static EntityColumn receiverZip;
    public static EntityColumn finishTime;
    public static EntityColumn daifaType;
    public static EntityColumn tradeCode;
    public static EntityColumn sendTime;
    public static EntityColumn dfTradeId;
    public static EntityColumn receiverAddress;
    public static EntityColumn taobaoUserNick;
    public static EntityColumn barCodeKey;
    public static EntityColumn tradeStatus;
    public static EntityColumn realPayMoney;
    public static EntityColumn receiverState;
    public static EntityColumn remark1;
    public static EntityColumn expressId;
    public static EntityColumn remark2;
    public static EntityColumn buyerTelephone;
    public static EntityColumn sellerName;
    public static EntityColumn goodsWeight;
    public static EntityColumn buyerWw;
    public static EntityColumn servicesFee;
    public static EntityColumn buyerWx;
    public static EntityColumn closeTime;
    public static EntityColumn goodsNum;
    public static EntityColumn goodsFee;
    public static EntityColumn isOld;
    public static EntityColumn printExpressStatus;
    public static EntityColumn receiverName;
    public static EntityColumn receiverMobile;
    public static EntityColumn goodsVolume;
    public static EntityColumn buyerName;
    public static EntityColumn taobaoTid;
    public static EntityColumn expressName;
    public static EntityColumn money;
    public static EntityColumn totalFee;
    public static EntityColumn createTime;
    public static EntityColumn sendStatus;
    public static EntityColumn payStatus;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        buyerNick = listMap.get("buyerNick");
        payTime = listMap.get("payTime");
        afterRemark = listMap.get("afterRemark");
        tradeDiscountFee = listMap.get("tradeDiscountFee");
        buyerId = listMap.get("buyerId");
        expressFee = listMap.get("expressFee");
        buyerQq = listMap.get("buyerQq");
        buyerRemark = listMap.get("buyerRemark");
        sellerId = listMap.get("sellerId");
        receiverPhone = listMap.get("receiverPhone");
        receiverQq = listMap.get("receiverQq");
        expressCode = listMap.get("expressCode");
        lastDoTime = listMap.get("lastDoTime");
        receiverZip = listMap.get("receiverZip");
        finishTime = listMap.get("finishTime");
        daifaType = listMap.get("daifaType");
        tradeCode = listMap.get("tradeCode");
        sendTime = listMap.get("sendTime");
        dfTradeId = listMap.get("dfTradeId");
        receiverAddress = listMap.get("receiverAddress");
        taobaoUserNick = listMap.get("taobaoUserNick");
        barCodeKey = listMap.get("barCodeKey");
        tradeStatus = listMap.get("tradeStatus");
        realPayMoney = listMap.get("realPayMoney");
        receiverState = listMap.get("receiverState");
        remark1 = listMap.get("remark1");
        expressId = listMap.get("expressId");
        remark2 = listMap.get("remark2");
        buyerTelephone = listMap.get("buyerTelephone");
        sellerName = listMap.get("sellerName");
        goodsWeight = listMap.get("goodsWeight");
        buyerWw = listMap.get("buyerWw");
        servicesFee = listMap.get("servicesFee");
        buyerWx = listMap.get("buyerWx");
        closeTime = listMap.get("closeTime");
        goodsNum = listMap.get("goodsNum");
        goodsFee = listMap.get("goodsFee");
        isOld = listMap.get("isOld");
        printExpressStatus = listMap.get("printExpressStatus");
        receiverName = listMap.get("receiverName");
        receiverMobile = listMap.get("receiverMobile");
        goodsVolume = listMap.get("goodsVolume");
        buyerName = listMap.get("buyerName");
        taobaoTid = listMap.get("taobaoTid");
        expressName = listMap.get("expressName");
        money = listMap.get("money");
        totalFee = listMap.get("totalFee");
        createTime = listMap.get("createTime");
        sendStatus = listMap.get("sendStatus");
        payStatus = listMap.get("payStatus");
        }

    public DaifaTradeExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaTradeExample.Criteria createCriteriaInternal() {
        return new DaifaTradeExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaTradeExample.Criteria andBuyerNickIsNull() {
            return isNull(buyerNick);
        }

        public DaifaTradeExample.Criteria andBuyerNickIsNotNull() {
            return isNotNull(buyerNick);
        }

        public DaifaTradeExample.Criteria andBuyerNickEqualTo(String value) {
            return equalTo(buyerNick, value);
        }

        public DaifaTradeExample.Criteria andBuyerNickNotEqualTo(String value) {
            return notEqualTo(buyerNick, value);
        }

        public DaifaTradeExample.Criteria andBuyerNickGreaterThan(String value) {
            return greaterThan(buyerNick, value);
        }

        public DaifaTradeExample.Criteria andBuyerNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerNick, value);
        }

        public DaifaTradeExample.Criteria andBuyerNickLessThan(String value) {
            return lessThan(buyerNick, value);
        }

        public DaifaTradeExample.Criteria andBuyerNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerNick, value);
        }

        public DaifaTradeExample.Criteria andBuyerNickLike(String value) {
            return like(buyerNick, value);
        }

        public DaifaTradeExample.Criteria andBuyerNickNotLike(String value) {
            return notLike(buyerNick, value);
        }

        public DaifaTradeExample.Criteria andBuyerNickIn(List<String> values) {
            return in(buyerNick, values);
        }

        public DaifaTradeExample.Criteria andBuyerNickNotIn(List<String> values) {
            return notIn(buyerNick, values);
        }

        public DaifaTradeExample.Criteria andBuyerNickBetween(String value1, String value2) {
            return between(buyerNick, value1, value2);
        }

        public DaifaTradeExample.Criteria andBuyerNickNotBetween(String value1, String value2) {
            return notBetween(buyerNick, value1, value2);
        }
        public DaifaTradeExample.Criteria andPayTimeIsNull() {
            return isNull(payTime);
        }

        public DaifaTradeExample.Criteria andPayTimeIsNotNull() {
            return isNotNull(payTime);
        }

        public DaifaTradeExample.Criteria andPayTimeEqualTo(Date value) {
            return equalTo(payTime, value);
        }

        public DaifaTradeExample.Criteria andPayTimeNotEqualTo(Date value) {
            return notEqualTo(payTime, value);
        }

        public DaifaTradeExample.Criteria andPayTimeGreaterThan(Date value) {
            return greaterThan(payTime, value);
        }

        public DaifaTradeExample.Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(payTime, value);
        }

        public DaifaTradeExample.Criteria andPayTimeLessThan(Date value) {
            return lessThan(payTime, value);
        }

        public DaifaTradeExample.Criteria andPayTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(payTime, value);
        }

        public DaifaTradeExample.Criteria andPayTimeIn(List<Date> values) {
            return in(payTime, values);
        }

        public DaifaTradeExample.Criteria andPayTimeNotIn(List<Date> values) {
            return notIn(payTime, values);
        }

        public DaifaTradeExample.Criteria andPayTimeBetween(Date value1, Date value2) {
            return between(payTime, value1, value2);
        }

        public DaifaTradeExample.Criteria andPayTimeNotBetween(Date value1, Date value2) {
            return notBetween(payTime, value1, value2);
        }
        public DaifaTradeExample.Criteria andAfterRemarkIsNull() {
            return isNull(afterRemark);
        }

        public DaifaTradeExample.Criteria andAfterRemarkIsNotNull() {
            return isNotNull(afterRemark);
        }

        public DaifaTradeExample.Criteria andAfterRemarkEqualTo(String value) {
            return equalTo(afterRemark, value);
        }

        public DaifaTradeExample.Criteria andAfterRemarkNotEqualTo(String value) {
            return notEqualTo(afterRemark, value);
        }

        public DaifaTradeExample.Criteria andAfterRemarkGreaterThan(String value) {
            return greaterThan(afterRemark, value);
        }

        public DaifaTradeExample.Criteria andAfterRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(afterRemark, value);
        }

        public DaifaTradeExample.Criteria andAfterRemarkLessThan(String value) {
            return lessThan(afterRemark, value);
        }

        public DaifaTradeExample.Criteria andAfterRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(afterRemark, value);
        }

        public DaifaTradeExample.Criteria andAfterRemarkLike(String value) {
            return like(afterRemark, value);
        }

        public DaifaTradeExample.Criteria andAfterRemarkNotLike(String value) {
            return notLike(afterRemark, value);
        }

        public DaifaTradeExample.Criteria andAfterRemarkIn(List<String> values) {
            return in(afterRemark, values);
        }

        public DaifaTradeExample.Criteria andAfterRemarkNotIn(List<String> values) {
            return notIn(afterRemark, values);
        }

        public DaifaTradeExample.Criteria andAfterRemarkBetween(String value1, String value2) {
            return between(afterRemark, value1, value2);
        }

        public DaifaTradeExample.Criteria andAfterRemarkNotBetween(String value1, String value2) {
            return notBetween(afterRemark, value1, value2);
        }
        public DaifaTradeExample.Criteria andTradeDiscountFeeIsNull() {
            return isNull(tradeDiscountFee);
        }

        public DaifaTradeExample.Criteria andTradeDiscountFeeIsNotNull() {
            return isNotNull(tradeDiscountFee);
        }

        public DaifaTradeExample.Criteria andTradeDiscountFeeEqualTo(String value) {
            return equalTo(tradeDiscountFee, value);
        }

        public DaifaTradeExample.Criteria andTradeDiscountFeeNotEqualTo(String value) {
            return notEqualTo(tradeDiscountFee, value);
        }

        public DaifaTradeExample.Criteria andTradeDiscountFeeGreaterThan(String value) {
            return greaterThan(tradeDiscountFee, value);
        }

        public DaifaTradeExample.Criteria andTradeDiscountFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(tradeDiscountFee, value);
        }

        public DaifaTradeExample.Criteria andTradeDiscountFeeLessThan(String value) {
            return lessThan(tradeDiscountFee, value);
        }

        public DaifaTradeExample.Criteria andTradeDiscountFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(tradeDiscountFee, value);
        }

        public DaifaTradeExample.Criteria andTradeDiscountFeeLike(String value) {
            return like(tradeDiscountFee, value);
        }

        public DaifaTradeExample.Criteria andTradeDiscountFeeNotLike(String value) {
            return notLike(tradeDiscountFee, value);
        }

        public DaifaTradeExample.Criteria andTradeDiscountFeeIn(List<String> values) {
            return in(tradeDiscountFee, values);
        }

        public DaifaTradeExample.Criteria andTradeDiscountFeeNotIn(List<String> values) {
            return notIn(tradeDiscountFee, values);
        }

        public DaifaTradeExample.Criteria andTradeDiscountFeeBetween(String value1, String value2) {
            return between(tradeDiscountFee, value1, value2);
        }

        public DaifaTradeExample.Criteria andTradeDiscountFeeNotBetween(String value1, String value2) {
            return notBetween(tradeDiscountFee, value1, value2);
        }
        public DaifaTradeExample.Criteria andBuyerIdIsNull() {
            return isNull(buyerId);
        }

        public DaifaTradeExample.Criteria andBuyerIdIsNotNull() {
            return isNotNull(buyerId);
        }

        public DaifaTradeExample.Criteria andBuyerIdEqualTo(Long value) {
            return equalTo(buyerId, value);
        }

        public DaifaTradeExample.Criteria andBuyerIdNotEqualTo(Long value) {
            return notEqualTo(buyerId, value);
        }

        public DaifaTradeExample.Criteria andBuyerIdGreaterThan(Long value) {
            return greaterThan(buyerId, value);
        }

        public DaifaTradeExample.Criteria andBuyerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(buyerId, value);
        }

        public DaifaTradeExample.Criteria andBuyerIdLessThan(Long value) {
            return lessThan(buyerId, value);
        }

        public DaifaTradeExample.Criteria andBuyerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(buyerId, value);
        }

        public DaifaTradeExample.Criteria andBuyerIdIn(List<Long> values) {
            return in(buyerId, values);
        }

        public DaifaTradeExample.Criteria andBuyerIdNotIn(List<Long> values) {
            return notIn(buyerId, values);
        }

        public DaifaTradeExample.Criteria andBuyerIdBetween(Long value1, Long value2) {
            return between(buyerId, value1, value2);
        }

        public DaifaTradeExample.Criteria andBuyerIdNotBetween(Long value1, Long value2) {
            return notBetween(buyerId, value1, value2);
        }
        public DaifaTradeExample.Criteria andExpressFeeIsNull() {
            return isNull(expressFee);
        }

        public DaifaTradeExample.Criteria andExpressFeeIsNotNull() {
            return isNotNull(expressFee);
        }

        public DaifaTradeExample.Criteria andExpressFeeEqualTo(String value) {
            return equalTo(expressFee, value);
        }

        public DaifaTradeExample.Criteria andExpressFeeNotEqualTo(String value) {
            return notEqualTo(expressFee, value);
        }

        public DaifaTradeExample.Criteria andExpressFeeGreaterThan(String value) {
            return greaterThan(expressFee, value);
        }

        public DaifaTradeExample.Criteria andExpressFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressFee, value);
        }

        public DaifaTradeExample.Criteria andExpressFeeLessThan(String value) {
            return lessThan(expressFee, value);
        }

        public DaifaTradeExample.Criteria andExpressFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressFee, value);
        }

        public DaifaTradeExample.Criteria andExpressFeeLike(String value) {
            return like(expressFee, value);
        }

        public DaifaTradeExample.Criteria andExpressFeeNotLike(String value) {
            return notLike(expressFee, value);
        }

        public DaifaTradeExample.Criteria andExpressFeeIn(List<String> values) {
            return in(expressFee, values);
        }

        public DaifaTradeExample.Criteria andExpressFeeNotIn(List<String> values) {
            return notIn(expressFee, values);
        }

        public DaifaTradeExample.Criteria andExpressFeeBetween(String value1, String value2) {
            return between(expressFee, value1, value2);
        }

        public DaifaTradeExample.Criteria andExpressFeeNotBetween(String value1, String value2) {
            return notBetween(expressFee, value1, value2);
        }
        public DaifaTradeExample.Criteria andBuyerQqIsNull() {
            return isNull(buyerQq);
        }

        public DaifaTradeExample.Criteria andBuyerQqIsNotNull() {
            return isNotNull(buyerQq);
        }

        public DaifaTradeExample.Criteria andBuyerQqEqualTo(String value) {
            return equalTo(buyerQq, value);
        }

        public DaifaTradeExample.Criteria andBuyerQqNotEqualTo(String value) {
            return notEqualTo(buyerQq, value);
        }

        public DaifaTradeExample.Criteria andBuyerQqGreaterThan(String value) {
            return greaterThan(buyerQq, value);
        }

        public DaifaTradeExample.Criteria andBuyerQqGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerQq, value);
        }

        public DaifaTradeExample.Criteria andBuyerQqLessThan(String value) {
            return lessThan(buyerQq, value);
        }

        public DaifaTradeExample.Criteria andBuyerQqLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerQq, value);
        }

        public DaifaTradeExample.Criteria andBuyerQqLike(String value) {
            return like(buyerQq, value);
        }

        public DaifaTradeExample.Criteria andBuyerQqNotLike(String value) {
            return notLike(buyerQq, value);
        }

        public DaifaTradeExample.Criteria andBuyerQqIn(List<String> values) {
            return in(buyerQq, values);
        }

        public DaifaTradeExample.Criteria andBuyerQqNotIn(List<String> values) {
            return notIn(buyerQq, values);
        }

        public DaifaTradeExample.Criteria andBuyerQqBetween(String value1, String value2) {
            return between(buyerQq, value1, value2);
        }

        public DaifaTradeExample.Criteria andBuyerQqNotBetween(String value1, String value2) {
            return notBetween(buyerQq, value1, value2);
        }
        public DaifaTradeExample.Criteria andBuyerRemarkIsNull() {
            return isNull(buyerRemark);
        }

        public DaifaTradeExample.Criteria andBuyerRemarkIsNotNull() {
            return isNotNull(buyerRemark);
        }

        public DaifaTradeExample.Criteria andBuyerRemarkEqualTo(String value) {
            return equalTo(buyerRemark, value);
        }

        public DaifaTradeExample.Criteria andBuyerRemarkNotEqualTo(String value) {
            return notEqualTo(buyerRemark, value);
        }

        public DaifaTradeExample.Criteria andBuyerRemarkGreaterThan(String value) {
            return greaterThan(buyerRemark, value);
        }

        public DaifaTradeExample.Criteria andBuyerRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerRemark, value);
        }

        public DaifaTradeExample.Criteria andBuyerRemarkLessThan(String value) {
            return lessThan(buyerRemark, value);
        }

        public DaifaTradeExample.Criteria andBuyerRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerRemark, value);
        }

        public DaifaTradeExample.Criteria andBuyerRemarkLike(String value) {
            return like(buyerRemark, value);
        }

        public DaifaTradeExample.Criteria andBuyerRemarkNotLike(String value) {
            return notLike(buyerRemark, value);
        }

        public DaifaTradeExample.Criteria andBuyerRemarkIn(List<String> values) {
            return in(buyerRemark, values);
        }

        public DaifaTradeExample.Criteria andBuyerRemarkNotIn(List<String> values) {
            return notIn(buyerRemark, values);
        }

        public DaifaTradeExample.Criteria andBuyerRemarkBetween(String value1, String value2) {
            return between(buyerRemark, value1, value2);
        }

        public DaifaTradeExample.Criteria andBuyerRemarkNotBetween(String value1, String value2) {
            return notBetween(buyerRemark, value1, value2);
        }
        public DaifaTradeExample.Criteria andSellerIdIsNull() {
            return isNull(sellerId);
        }

        public DaifaTradeExample.Criteria andSellerIdIsNotNull() {
            return isNotNull(sellerId);
        }

        public DaifaTradeExample.Criteria andSellerIdEqualTo(Long value) {
            return equalTo(sellerId, value);
        }

        public DaifaTradeExample.Criteria andSellerIdNotEqualTo(Long value) {
            return notEqualTo(sellerId, value);
        }

        public DaifaTradeExample.Criteria andSellerIdGreaterThan(Long value) {
            return greaterThan(sellerId, value);
        }

        public DaifaTradeExample.Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerId, value);
        }

        public DaifaTradeExample.Criteria andSellerIdLessThan(Long value) {
            return lessThan(sellerId, value);
        }

        public DaifaTradeExample.Criteria andSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerId, value);
        }

        public DaifaTradeExample.Criteria andSellerIdIn(List<Long> values) {
            return in(sellerId, values);
        }

        public DaifaTradeExample.Criteria andSellerIdNotIn(List<Long> values) {
            return notIn(sellerId, values);
        }

        public DaifaTradeExample.Criteria andSellerIdBetween(Long value1, Long value2) {
            return between(sellerId, value1, value2);
        }

        public DaifaTradeExample.Criteria andSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(sellerId, value1, value2);
        }
        public DaifaTradeExample.Criteria andReceiverPhoneIsNull() {
            return isNull(receiverPhone);
        }

        public DaifaTradeExample.Criteria andReceiverPhoneIsNotNull() {
            return isNotNull(receiverPhone);
        }

        public DaifaTradeExample.Criteria andReceiverPhoneEqualTo(String value) {
            return equalTo(receiverPhone, value);
        }

        public DaifaTradeExample.Criteria andReceiverPhoneNotEqualTo(String value) {
            return notEqualTo(receiverPhone, value);
        }

        public DaifaTradeExample.Criteria andReceiverPhoneGreaterThan(String value) {
            return greaterThan(receiverPhone, value);
        }

        public DaifaTradeExample.Criteria andReceiverPhoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverPhone, value);
        }

        public DaifaTradeExample.Criteria andReceiverPhoneLessThan(String value) {
            return lessThan(receiverPhone, value);
        }

        public DaifaTradeExample.Criteria andReceiverPhoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverPhone, value);
        }

        public DaifaTradeExample.Criteria andReceiverPhoneLike(String value) {
            return like(receiverPhone, value);
        }

        public DaifaTradeExample.Criteria andReceiverPhoneNotLike(String value) {
            return notLike(receiverPhone, value);
        }

        public DaifaTradeExample.Criteria andReceiverPhoneIn(List<String> values) {
            return in(receiverPhone, values);
        }

        public DaifaTradeExample.Criteria andReceiverPhoneNotIn(List<String> values) {
            return notIn(receiverPhone, values);
        }

        public DaifaTradeExample.Criteria andReceiverPhoneBetween(String value1, String value2) {
            return between(receiverPhone, value1, value2);
        }

        public DaifaTradeExample.Criteria andReceiverPhoneNotBetween(String value1, String value2) {
            return notBetween(receiverPhone, value1, value2);
        }
        public DaifaTradeExample.Criteria andReceiverQqIsNull() {
            return isNull(receiverQq);
        }

        public DaifaTradeExample.Criteria andReceiverQqIsNotNull() {
            return isNotNull(receiverQq);
        }

        public DaifaTradeExample.Criteria andReceiverQqEqualTo(String value) {
            return equalTo(receiverQq, value);
        }

        public DaifaTradeExample.Criteria andReceiverQqNotEqualTo(String value) {
            return notEqualTo(receiverQq, value);
        }

        public DaifaTradeExample.Criteria andReceiverQqGreaterThan(String value) {
            return greaterThan(receiverQq, value);
        }

        public DaifaTradeExample.Criteria andReceiverQqGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverQq, value);
        }

        public DaifaTradeExample.Criteria andReceiverQqLessThan(String value) {
            return lessThan(receiverQq, value);
        }

        public DaifaTradeExample.Criteria andReceiverQqLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverQq, value);
        }

        public DaifaTradeExample.Criteria andReceiverQqLike(String value) {
            return like(receiverQq, value);
        }

        public DaifaTradeExample.Criteria andReceiverQqNotLike(String value) {
            return notLike(receiverQq, value);
        }

        public DaifaTradeExample.Criteria andReceiverQqIn(List<String> values) {
            return in(receiverQq, values);
        }

        public DaifaTradeExample.Criteria andReceiverQqNotIn(List<String> values) {
            return notIn(receiverQq, values);
        }

        public DaifaTradeExample.Criteria andReceiverQqBetween(String value1, String value2) {
            return between(receiverQq, value1, value2);
        }

        public DaifaTradeExample.Criteria andReceiverQqNotBetween(String value1, String value2) {
            return notBetween(receiverQq, value1, value2);
        }
        public DaifaTradeExample.Criteria andExpressCodeIsNull() {
            return isNull(expressCode);
        }

        public DaifaTradeExample.Criteria andExpressCodeIsNotNull() {
            return isNotNull(expressCode);
        }

        public DaifaTradeExample.Criteria andExpressCodeEqualTo(String value) {
            return equalTo(expressCode, value);
        }

        public DaifaTradeExample.Criteria andExpressCodeNotEqualTo(String value) {
            return notEqualTo(expressCode, value);
        }

        public DaifaTradeExample.Criteria andExpressCodeGreaterThan(String value) {
            return greaterThan(expressCode, value);
        }

        public DaifaTradeExample.Criteria andExpressCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressCode, value);
        }

        public DaifaTradeExample.Criteria andExpressCodeLessThan(String value) {
            return lessThan(expressCode, value);
        }

        public DaifaTradeExample.Criteria andExpressCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressCode, value);
        }

        public DaifaTradeExample.Criteria andExpressCodeLike(String value) {
            return like(expressCode, value);
        }

        public DaifaTradeExample.Criteria andExpressCodeNotLike(String value) {
            return notLike(expressCode, value);
        }

        public DaifaTradeExample.Criteria andExpressCodeIn(List<String> values) {
            return in(expressCode, values);
        }

        public DaifaTradeExample.Criteria andExpressCodeNotIn(List<String> values) {
            return notIn(expressCode, values);
        }

        public DaifaTradeExample.Criteria andExpressCodeBetween(String value1, String value2) {
            return between(expressCode, value1, value2);
        }

        public DaifaTradeExample.Criteria andExpressCodeNotBetween(String value1, String value2) {
            return notBetween(expressCode, value1, value2);
        }
        public DaifaTradeExample.Criteria andLastDoTimeIsNull() {
            return isNull(lastDoTime);
        }

        public DaifaTradeExample.Criteria andLastDoTimeIsNotNull() {
            return isNotNull(lastDoTime);
        }

        public DaifaTradeExample.Criteria andLastDoTimeEqualTo(Date value) {
            return equalTo(lastDoTime, value);
        }

        public DaifaTradeExample.Criteria andLastDoTimeNotEqualTo(Date value) {
            return notEqualTo(lastDoTime, value);
        }

        public DaifaTradeExample.Criteria andLastDoTimeGreaterThan(Date value) {
            return greaterThan(lastDoTime, value);
        }

        public DaifaTradeExample.Criteria andLastDoTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastDoTime, value);
        }

        public DaifaTradeExample.Criteria andLastDoTimeLessThan(Date value) {
            return lessThan(lastDoTime, value);
        }

        public DaifaTradeExample.Criteria andLastDoTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastDoTime, value);
        }

        public DaifaTradeExample.Criteria andLastDoTimeIn(List<Date> values) {
            return in(lastDoTime, values);
        }

        public DaifaTradeExample.Criteria andLastDoTimeNotIn(List<Date> values) {
            return notIn(lastDoTime, values);
        }

        public DaifaTradeExample.Criteria andLastDoTimeBetween(Date value1, Date value2) {
            return between(lastDoTime, value1, value2);
        }

        public DaifaTradeExample.Criteria andLastDoTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastDoTime, value1, value2);
        }
        public DaifaTradeExample.Criteria andReceiverZipIsNull() {
            return isNull(receiverZip);
        }

        public DaifaTradeExample.Criteria andReceiverZipIsNotNull() {
            return isNotNull(receiverZip);
        }

        public DaifaTradeExample.Criteria andReceiverZipEqualTo(String value) {
            return equalTo(receiverZip, value);
        }

        public DaifaTradeExample.Criteria andReceiverZipNotEqualTo(String value) {
            return notEqualTo(receiverZip, value);
        }

        public DaifaTradeExample.Criteria andReceiverZipGreaterThan(String value) {
            return greaterThan(receiverZip, value);
        }

        public DaifaTradeExample.Criteria andReceiverZipGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverZip, value);
        }

        public DaifaTradeExample.Criteria andReceiverZipLessThan(String value) {
            return lessThan(receiverZip, value);
        }

        public DaifaTradeExample.Criteria andReceiverZipLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverZip, value);
        }

        public DaifaTradeExample.Criteria andReceiverZipLike(String value) {
            return like(receiverZip, value);
        }

        public DaifaTradeExample.Criteria andReceiverZipNotLike(String value) {
            return notLike(receiverZip, value);
        }

        public DaifaTradeExample.Criteria andReceiverZipIn(List<String> values) {
            return in(receiverZip, values);
        }

        public DaifaTradeExample.Criteria andReceiverZipNotIn(List<String> values) {
            return notIn(receiverZip, values);
        }

        public DaifaTradeExample.Criteria andReceiverZipBetween(String value1, String value2) {
            return between(receiverZip, value1, value2);
        }

        public DaifaTradeExample.Criteria andReceiverZipNotBetween(String value1, String value2) {
            return notBetween(receiverZip, value1, value2);
        }
        public DaifaTradeExample.Criteria andFinishTimeIsNull() {
            return isNull(finishTime);
        }

        public DaifaTradeExample.Criteria andFinishTimeIsNotNull() {
            return isNotNull(finishTime);
        }

        public DaifaTradeExample.Criteria andFinishTimeEqualTo(Date value) {
            return equalTo(finishTime, value);
        }

        public DaifaTradeExample.Criteria andFinishTimeNotEqualTo(Date value) {
            return notEqualTo(finishTime, value);
        }

        public DaifaTradeExample.Criteria andFinishTimeGreaterThan(Date value) {
            return greaterThan(finishTime, value);
        }

        public DaifaTradeExample.Criteria andFinishTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(finishTime, value);
        }

        public DaifaTradeExample.Criteria andFinishTimeLessThan(Date value) {
            return lessThan(finishTime, value);
        }

        public DaifaTradeExample.Criteria andFinishTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(finishTime, value);
        }

        public DaifaTradeExample.Criteria andFinishTimeIn(List<Date> values) {
            return in(finishTime, values);
        }

        public DaifaTradeExample.Criteria andFinishTimeNotIn(List<Date> values) {
            return notIn(finishTime, values);
        }

        public DaifaTradeExample.Criteria andFinishTimeBetween(Date value1, Date value2) {
            return between(finishTime, value1, value2);
        }

        public DaifaTradeExample.Criteria andFinishTimeNotBetween(Date value1, Date value2) {
            return notBetween(finishTime, value1, value2);
        }
        public DaifaTradeExample.Criteria andDaifaTypeIsNull() {
            return isNull(daifaType);
        }

        public DaifaTradeExample.Criteria andDaifaTypeIsNotNull() {
            return isNotNull(daifaType);
        }

        public DaifaTradeExample.Criteria andDaifaTypeEqualTo(Integer value) {
            return equalTo(daifaType, value);
        }

        public DaifaTradeExample.Criteria andDaifaTypeNotEqualTo(Integer value) {
            return notEqualTo(daifaType, value);
        }

        public DaifaTradeExample.Criteria andDaifaTypeGreaterThan(Integer value) {
            return greaterThan(daifaType, value);
        }

        public DaifaTradeExample.Criteria andDaifaTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(daifaType, value);
        }

        public DaifaTradeExample.Criteria andDaifaTypeLessThan(Integer value) {
            return lessThan(daifaType, value);
        }

        public DaifaTradeExample.Criteria andDaifaTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(daifaType, value);
        }

        public DaifaTradeExample.Criteria andDaifaTypeIn(List<Integer> values) {
            return in(daifaType, values);
        }

        public DaifaTradeExample.Criteria andDaifaTypeNotIn(List<Integer> values) {
            return notIn(daifaType, values);
        }

        public DaifaTradeExample.Criteria andDaifaTypeBetween(Integer value1, Integer value2) {
            return between(daifaType, value1, value2);
        }

        public DaifaTradeExample.Criteria andDaifaTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(daifaType, value1, value2);
        }
        public DaifaTradeExample.Criteria andTradeCodeIsNull() {
            return isNull(tradeCode);
        }

        public DaifaTradeExample.Criteria andTradeCodeIsNotNull() {
            return isNotNull(tradeCode);
        }

        public DaifaTradeExample.Criteria andTradeCodeEqualTo(String value) {
            return equalTo(tradeCode, value);
        }

        public DaifaTradeExample.Criteria andTradeCodeNotEqualTo(String value) {
            return notEqualTo(tradeCode, value);
        }

        public DaifaTradeExample.Criteria andTradeCodeGreaterThan(String value) {
            return greaterThan(tradeCode, value);
        }

        public DaifaTradeExample.Criteria andTradeCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(tradeCode, value);
        }

        public DaifaTradeExample.Criteria andTradeCodeLessThan(String value) {
            return lessThan(tradeCode, value);
        }

        public DaifaTradeExample.Criteria andTradeCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(tradeCode, value);
        }

        public DaifaTradeExample.Criteria andTradeCodeLike(String value) {
            return like(tradeCode, value);
        }

        public DaifaTradeExample.Criteria andTradeCodeNotLike(String value) {
            return notLike(tradeCode, value);
        }

        public DaifaTradeExample.Criteria andTradeCodeIn(List<String> values) {
            return in(tradeCode, values);
        }

        public DaifaTradeExample.Criteria andTradeCodeNotIn(List<String> values) {
            return notIn(tradeCode, values);
        }

        public DaifaTradeExample.Criteria andTradeCodeBetween(String value1, String value2) {
            return between(tradeCode, value1, value2);
        }

        public DaifaTradeExample.Criteria andTradeCodeNotBetween(String value1, String value2) {
            return notBetween(tradeCode, value1, value2);
        }
        public DaifaTradeExample.Criteria andSendTimeIsNull() {
            return isNull(sendTime);
        }

        public DaifaTradeExample.Criteria andSendTimeIsNotNull() {
            return isNotNull(sendTime);
        }

        public DaifaTradeExample.Criteria andSendTimeEqualTo(Date value) {
            return equalTo(sendTime, value);
        }

        public DaifaTradeExample.Criteria andSendTimeNotEqualTo(Date value) {
            return notEqualTo(sendTime, value);
        }

        public DaifaTradeExample.Criteria andSendTimeGreaterThan(Date value) {
            return greaterThan(sendTime, value);
        }

        public DaifaTradeExample.Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(sendTime, value);
        }

        public DaifaTradeExample.Criteria andSendTimeLessThan(Date value) {
            return lessThan(sendTime, value);
        }

        public DaifaTradeExample.Criteria andSendTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(sendTime, value);
        }

        public DaifaTradeExample.Criteria andSendTimeIn(List<Date> values) {
            return in(sendTime, values);
        }

        public DaifaTradeExample.Criteria andSendTimeNotIn(List<Date> values) {
            return notIn(sendTime, values);
        }

        public DaifaTradeExample.Criteria andSendTimeBetween(Date value1, Date value2) {
            return between(sendTime, value1, value2);
        }

        public DaifaTradeExample.Criteria andSendTimeNotBetween(Date value1, Date value2) {
            return notBetween(sendTime, value1, value2);
        }
        public DaifaTradeExample.Criteria andDfTradeIdIsNull() {
            return isNull(dfTradeId);
        }

        public DaifaTradeExample.Criteria andDfTradeIdIsNotNull() {
            return isNotNull(dfTradeId);
        }

        public DaifaTradeExample.Criteria andDfTradeIdEqualTo(Long value) {
            return equalTo(dfTradeId, value);
        }

        public DaifaTradeExample.Criteria andDfTradeIdNotEqualTo(Long value) {
            return notEqualTo(dfTradeId, value);
        }

        public DaifaTradeExample.Criteria andDfTradeIdGreaterThan(Long value) {
            return greaterThan(dfTradeId, value);
        }

        public DaifaTradeExample.Criteria andDfTradeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfTradeId, value);
        }
        public DaifaTradeExample.Criteria andDfTradeIdLike(String value) {
            return like(dfTradeId, value);
        }

        public DaifaTradeExample.Criteria andDfTradeIdNotLike(String value) {
            return notLike(dfTradeId, value);
        }
        public DaifaTradeExample.Criteria andDfTradeIdLessThan(Long value) {
            return lessThan(dfTradeId, value);
        }

        public DaifaTradeExample.Criteria andDfTradeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfTradeId, value);
        }

        public DaifaTradeExample.Criteria andDfTradeIdIn(List<Long> values) {
            return in(dfTradeId, values);
        }

        public DaifaTradeExample.Criteria andDfTradeIdNotIn(List<Long> values) {
            return notIn(dfTradeId, values);
        }

        public DaifaTradeExample.Criteria andDfTradeIdBetween(Long value1, Long value2) {
            return between(dfTradeId, value1, value2);
        }

        public DaifaTradeExample.Criteria andDfTradeIdNotBetween(Long value1, Long value2) {
            return notBetween(dfTradeId, value1, value2);
        }
        public DaifaTradeExample.Criteria andReceiverAddressIsNull() {
            return isNull(receiverAddress);
        }

        public DaifaTradeExample.Criteria andReceiverAddressIsNotNull() {
            return isNotNull(receiverAddress);
        }

        public DaifaTradeExample.Criteria andReceiverAddressEqualTo(String value) {
            return equalTo(receiverAddress, value);
        }

        public DaifaTradeExample.Criteria andReceiverAddressNotEqualTo(String value) {
            return notEqualTo(receiverAddress, value);
        }

        public DaifaTradeExample.Criteria andReceiverAddressGreaterThan(String value) {
            return greaterThan(receiverAddress, value);
        }

        public DaifaTradeExample.Criteria andReceiverAddressGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverAddress, value);
        }

        public DaifaTradeExample.Criteria andReceiverAddressLessThan(String value) {
            return lessThan(receiverAddress, value);
        }

        public DaifaTradeExample.Criteria andReceiverAddressLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverAddress, value);
        }

        public DaifaTradeExample.Criteria andReceiverAddressLike(String value) {
            return like(receiverAddress, value);
        }

        public DaifaTradeExample.Criteria andReceiverAddressNotLike(String value) {
            return notLike(receiverAddress, value);
        }

        public DaifaTradeExample.Criteria andReceiverAddressIn(List<String> values) {
            return in(receiverAddress, values);
        }

        public DaifaTradeExample.Criteria andReceiverAddressNotIn(List<String> values) {
            return notIn(receiverAddress, values);
        }

        public DaifaTradeExample.Criteria andReceiverAddressBetween(String value1, String value2) {
            return between(receiverAddress, value1, value2);
        }

        public DaifaTradeExample.Criteria andReceiverAddressNotBetween(String value1, String value2) {
            return notBetween(receiverAddress, value1, value2);
        }
        public DaifaTradeExample.Criteria andTaobaoUserNickIsNull() {
            return isNull(taobaoUserNick);
        }

        public DaifaTradeExample.Criteria andTaobaoUserNickIsNotNull() {
            return isNotNull(taobaoUserNick);
        }

        public DaifaTradeExample.Criteria andTaobaoUserNickEqualTo(String value) {
            return equalTo(taobaoUserNick, value);
        }

        public DaifaTradeExample.Criteria andTaobaoUserNickNotEqualTo(String value) {
            return notEqualTo(taobaoUserNick, value);
        }

        public DaifaTradeExample.Criteria andTaobaoUserNickGreaterThan(String value) {
            return greaterThan(taobaoUserNick, value);
        }

        public DaifaTradeExample.Criteria andTaobaoUserNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(taobaoUserNick, value);
        }

        public DaifaTradeExample.Criteria andTaobaoUserNickLessThan(String value) {
            return lessThan(taobaoUserNick, value);
        }

        public DaifaTradeExample.Criteria andTaobaoUserNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(taobaoUserNick, value);
        }

        public DaifaTradeExample.Criteria andTaobaoUserNickLike(String value) {
            return like(taobaoUserNick, value);
        }

        public DaifaTradeExample.Criteria andTaobaoUserNickNotLike(String value) {
            return notLike(taobaoUserNick, value);
        }

        public DaifaTradeExample.Criteria andTaobaoUserNickIn(List<String> values) {
            return in(taobaoUserNick, values);
        }

        public DaifaTradeExample.Criteria andTaobaoUserNickNotIn(List<String> values) {
            return notIn(taobaoUserNick, values);
        }

        public DaifaTradeExample.Criteria andTaobaoUserNickBetween(String value1, String value2) {
            return between(taobaoUserNick, value1, value2);
        }

        public DaifaTradeExample.Criteria andTaobaoUserNickNotBetween(String value1, String value2) {
            return notBetween(taobaoUserNick, value1, value2);
        }
        public DaifaTradeExample.Criteria andBarCodeKeyIsNull() {
            return isNull(barCodeKey);
        }

        public DaifaTradeExample.Criteria andBarCodeKeyIsNotNull() {
            return isNotNull(barCodeKey);
        }

        public DaifaTradeExample.Criteria andBarCodeKeyEqualTo(String value) {
            return equalTo(barCodeKey, value);
        }

        public DaifaTradeExample.Criteria andBarCodeKeyNotEqualTo(String value) {
            return notEqualTo(barCodeKey, value);
        }

        public DaifaTradeExample.Criteria andBarCodeKeyGreaterThan(String value) {
            return greaterThan(barCodeKey, value);
        }

        public DaifaTradeExample.Criteria andBarCodeKeyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(barCodeKey, value);
        }

        public DaifaTradeExample.Criteria andBarCodeKeyLessThan(String value) {
            return lessThan(barCodeKey, value);
        }

        public DaifaTradeExample.Criteria andBarCodeKeyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(barCodeKey, value);
        }

        public DaifaTradeExample.Criteria andBarCodeKeyLike(String value) {
            return like(barCodeKey, value);
        }

        public DaifaTradeExample.Criteria andBarCodeKeyNotLike(String value) {
            return notLike(barCodeKey, value);
        }

        public DaifaTradeExample.Criteria andBarCodeKeyIn(List<String> values) {
            return in(barCodeKey, values);
        }

        public DaifaTradeExample.Criteria andBarCodeKeyNotIn(List<String> values) {
            return notIn(barCodeKey, values);
        }

        public DaifaTradeExample.Criteria andBarCodeKeyBetween(String value1, String value2) {
            return between(barCodeKey, value1, value2);
        }

        public DaifaTradeExample.Criteria andBarCodeKeyNotBetween(String value1, String value2) {
            return notBetween(barCodeKey, value1, value2);
        }
        public DaifaTradeExample.Criteria andTradeStatusIsNull() {
            return isNull(tradeStatus);
        }

        public DaifaTradeExample.Criteria andTradeStatusIsNotNull() {
            return isNotNull(tradeStatus);
        }

        public DaifaTradeExample.Criteria andTradeStatusEqualTo(Integer value) {
            return equalTo(tradeStatus, value);
        }

        public DaifaTradeExample.Criteria andTradeStatusNotEqualTo(Integer value) {
            return notEqualTo(tradeStatus, value);
        }

        public DaifaTradeExample.Criteria andTradeStatusGreaterThan(Integer value) {
            return greaterThan(tradeStatus, value);
        }

        public DaifaTradeExample.Criteria andTradeStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(tradeStatus, value);
        }

        public DaifaTradeExample.Criteria andTradeStatusLessThan(Integer value) {
            return lessThan(tradeStatus, value);
        }

        public DaifaTradeExample.Criteria andTradeStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(tradeStatus, value);
        }

        public DaifaTradeExample.Criteria andTradeStatusIn(List<Integer> values) {
            return in(tradeStatus, values);
        }

        public DaifaTradeExample.Criteria andTradeStatusNotIn(List<Integer> values) {
            return notIn(tradeStatus, values);
        }

        public DaifaTradeExample.Criteria andTradeStatusBetween(Integer value1, Integer value2) {
            return between(tradeStatus, value1, value2);
        }

        public DaifaTradeExample.Criteria andTradeStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(tradeStatus, value1, value2);
        }
        public DaifaTradeExample.Criteria andRealPayMoneyIsNull() {
            return isNull(realPayMoney);
        }

        public DaifaTradeExample.Criteria andRealPayMoneyIsNotNull() {
            return isNotNull(realPayMoney);
        }

        public DaifaTradeExample.Criteria andRealPayMoneyEqualTo(String value) {
            return equalTo(realPayMoney, value);
        }

        public DaifaTradeExample.Criteria andRealPayMoneyNotEqualTo(String value) {
            return notEqualTo(realPayMoney, value);
        }

        public DaifaTradeExample.Criteria andRealPayMoneyGreaterThan(String value) {
            return greaterThan(realPayMoney, value);
        }

        public DaifaTradeExample.Criteria andRealPayMoneyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(realPayMoney, value);
        }

        public DaifaTradeExample.Criteria andRealPayMoneyLessThan(String value) {
            return lessThan(realPayMoney, value);
        }

        public DaifaTradeExample.Criteria andRealPayMoneyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(realPayMoney, value);
        }

        public DaifaTradeExample.Criteria andRealPayMoneyLike(String value) {
            return like(realPayMoney, value);
        }

        public DaifaTradeExample.Criteria andRealPayMoneyNotLike(String value) {
            return notLike(realPayMoney, value);
        }

        public DaifaTradeExample.Criteria andRealPayMoneyIn(List<String> values) {
            return in(realPayMoney, values);
        }

        public DaifaTradeExample.Criteria andRealPayMoneyNotIn(List<String> values) {
            return notIn(realPayMoney, values);
        }

        public DaifaTradeExample.Criteria andRealPayMoneyBetween(String value1, String value2) {
            return between(realPayMoney, value1, value2);
        }

        public DaifaTradeExample.Criteria andRealPayMoneyNotBetween(String value1, String value2) {
            return notBetween(realPayMoney, value1, value2);
        }
        public DaifaTradeExample.Criteria andReceiverStateIsNull() {
            return isNull(receiverState);
        }

        public DaifaTradeExample.Criteria andReceiverStateIsNotNull() {
            return isNotNull(receiverState);
        }

        public DaifaTradeExample.Criteria andReceiverStateEqualTo(String value) {
            return equalTo(receiverState, value);
        }

        public DaifaTradeExample.Criteria andReceiverStateNotEqualTo(String value) {
            return notEqualTo(receiverState, value);
        }

        public DaifaTradeExample.Criteria andReceiverStateGreaterThan(String value) {
            return greaterThan(receiverState, value);
        }

        public DaifaTradeExample.Criteria andReceiverStateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverState, value);
        }

        public DaifaTradeExample.Criteria andReceiverStateLessThan(String value) {
            return lessThan(receiverState, value);
        }

        public DaifaTradeExample.Criteria andReceiverStateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverState, value);
        }

        public DaifaTradeExample.Criteria andReceiverStateLike(String value) {
            return like(receiverState, value);
        }

        public DaifaTradeExample.Criteria andReceiverStateNotLike(String value) {
            return notLike(receiverState, value);
        }

        public DaifaTradeExample.Criteria andReceiverStateIn(List<String> values) {
            return in(receiverState, values);
        }

        public DaifaTradeExample.Criteria andReceiverStateNotIn(List<String> values) {
            return notIn(receiverState, values);
        }

        public DaifaTradeExample.Criteria andReceiverStateBetween(String value1, String value2) {
            return between(receiverState, value1, value2);
        }

        public DaifaTradeExample.Criteria andReceiverStateNotBetween(String value1, String value2) {
            return notBetween(receiverState, value1, value2);
        }
        public DaifaTradeExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public DaifaTradeExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public DaifaTradeExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public DaifaTradeExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public DaifaTradeExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public DaifaTradeExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public DaifaTradeExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public DaifaTradeExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public DaifaTradeExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public DaifaTradeExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public DaifaTradeExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public DaifaTradeExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public DaifaTradeExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public DaifaTradeExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public DaifaTradeExample.Criteria andExpressIdIsNull() {
            return isNull(expressId);
        }

        public DaifaTradeExample.Criteria andExpressIdIsNotNull() {
            return isNotNull(expressId);
        }

        public DaifaTradeExample.Criteria andExpressIdEqualTo(Long value) {
            return equalTo(expressId, value);
        }

        public DaifaTradeExample.Criteria andExpressIdNotEqualTo(Long value) {
            return notEqualTo(expressId, value);
        }

        public DaifaTradeExample.Criteria andExpressIdGreaterThan(Long value) {
            return greaterThan(expressId, value);
        }

        public DaifaTradeExample.Criteria andExpressIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(expressId, value);
        }

        public DaifaTradeExample.Criteria andExpressIdLessThan(Long value) {
            return lessThan(expressId, value);
        }

        public DaifaTradeExample.Criteria andExpressIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(expressId, value);
        }

        public DaifaTradeExample.Criteria andExpressIdIn(List<Long> values) {
            return in(expressId, values);
        }

        public DaifaTradeExample.Criteria andExpressIdNotIn(List<Long> values) {
            return notIn(expressId, values);
        }

        public DaifaTradeExample.Criteria andExpressIdBetween(Long value1, Long value2) {
            return between(expressId, value1, value2);
        }

        public DaifaTradeExample.Criteria andExpressIdNotBetween(Long value1, Long value2) {
            return notBetween(expressId, value1, value2);
        }
        public DaifaTradeExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public DaifaTradeExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public DaifaTradeExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public DaifaTradeExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public DaifaTradeExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public DaifaTradeExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public DaifaTradeExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public DaifaTradeExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public DaifaTradeExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public DaifaTradeExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public DaifaTradeExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public DaifaTradeExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public DaifaTradeExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public DaifaTradeExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
        public DaifaTradeExample.Criteria andBuyerTelephoneIsNull() {
            return isNull(buyerTelephone);
        }

        public DaifaTradeExample.Criteria andBuyerTelephoneIsNotNull() {
            return isNotNull(buyerTelephone);
        }

        public DaifaTradeExample.Criteria andBuyerTelephoneEqualTo(String value) {
            return equalTo(buyerTelephone, value);
        }

        public DaifaTradeExample.Criteria andBuyerTelephoneNotEqualTo(String value) {
            return notEqualTo(buyerTelephone, value);
        }

        public DaifaTradeExample.Criteria andBuyerTelephoneGreaterThan(String value) {
            return greaterThan(buyerTelephone, value);
        }

        public DaifaTradeExample.Criteria andBuyerTelephoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerTelephone, value);
        }

        public DaifaTradeExample.Criteria andBuyerTelephoneLessThan(String value) {
            return lessThan(buyerTelephone, value);
        }

        public DaifaTradeExample.Criteria andBuyerTelephoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerTelephone, value);
        }

        public DaifaTradeExample.Criteria andBuyerTelephoneLike(String value) {
            return like(buyerTelephone, value);
        }

        public DaifaTradeExample.Criteria andBuyerTelephoneNotLike(String value) {
            return notLike(buyerTelephone, value);
        }

        public DaifaTradeExample.Criteria andBuyerTelephoneIn(List<String> values) {
            return in(buyerTelephone, values);
        }

        public DaifaTradeExample.Criteria andBuyerTelephoneNotIn(List<String> values) {
            return notIn(buyerTelephone, values);
        }

        public DaifaTradeExample.Criteria andBuyerTelephoneBetween(String value1, String value2) {
            return between(buyerTelephone, value1, value2);
        }

        public DaifaTradeExample.Criteria andBuyerTelephoneNotBetween(String value1, String value2) {
            return notBetween(buyerTelephone, value1, value2);
        }
        public DaifaTradeExample.Criteria andSellerNameIsNull() {
            return isNull(sellerName);
        }

        public DaifaTradeExample.Criteria andSellerNameIsNotNull() {
            return isNotNull(sellerName);
        }

        public DaifaTradeExample.Criteria andSellerNameEqualTo(String value) {
            return equalTo(sellerName, value);
        }

        public DaifaTradeExample.Criteria andSellerNameNotEqualTo(String value) {
            return notEqualTo(sellerName, value);
        }

        public DaifaTradeExample.Criteria andSellerNameGreaterThan(String value) {
            return greaterThan(sellerName, value);
        }

        public DaifaTradeExample.Criteria andSellerNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sellerName, value);
        }

        public DaifaTradeExample.Criteria andSellerNameLessThan(String value) {
            return lessThan(sellerName, value);
        }

        public DaifaTradeExample.Criteria andSellerNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sellerName, value);
        }

        public DaifaTradeExample.Criteria andSellerNameLike(String value) {
            return like(sellerName, value);
        }

        public DaifaTradeExample.Criteria andSellerNameNotLike(String value) {
            return notLike(sellerName, value);
        }

        public DaifaTradeExample.Criteria andSellerNameIn(List<String> values) {
            return in(sellerName, values);
        }

        public DaifaTradeExample.Criteria andSellerNameNotIn(List<String> values) {
            return notIn(sellerName, values);
        }

        public DaifaTradeExample.Criteria andSellerNameBetween(String value1, String value2) {
            return between(sellerName, value1, value2);
        }

        public DaifaTradeExample.Criteria andSellerNameNotBetween(String value1, String value2) {
            return notBetween(sellerName, value1, value2);
        }
        public DaifaTradeExample.Criteria andGoodsWeightIsNull() {
            return isNull(goodsWeight);
        }

        public DaifaTradeExample.Criteria andGoodsWeightIsNotNull() {
            return isNotNull(goodsWeight);
        }

        public DaifaTradeExample.Criteria andGoodsWeightEqualTo(String value) {
            return equalTo(goodsWeight, value);
        }

        public DaifaTradeExample.Criteria andGoodsWeightNotEqualTo(String value) {
            return notEqualTo(goodsWeight, value);
        }

        public DaifaTradeExample.Criteria andGoodsWeightGreaterThan(String value) {
            return greaterThan(goodsWeight, value);
        }

        public DaifaTradeExample.Criteria andGoodsWeightGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsWeight, value);
        }

        public DaifaTradeExample.Criteria andGoodsWeightLessThan(String value) {
            return lessThan(goodsWeight, value);
        }

        public DaifaTradeExample.Criteria andGoodsWeightLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsWeight, value);
        }

        public DaifaTradeExample.Criteria andGoodsWeightLike(String value) {
            return like(goodsWeight, value);
        }

        public DaifaTradeExample.Criteria andGoodsWeightNotLike(String value) {
            return notLike(goodsWeight, value);
        }

        public DaifaTradeExample.Criteria andGoodsWeightIn(List<String> values) {
            return in(goodsWeight, values);
        }

        public DaifaTradeExample.Criteria andGoodsWeightNotIn(List<String> values) {
            return notIn(goodsWeight, values);
        }

        public DaifaTradeExample.Criteria andGoodsWeightBetween(String value1, String value2) {
            return between(goodsWeight, value1, value2);
        }

        public DaifaTradeExample.Criteria andGoodsWeightNotBetween(String value1, String value2) {
            return notBetween(goodsWeight, value1, value2);
        }
        public DaifaTradeExample.Criteria andBuyerWwIsNull() {
            return isNull(buyerWw);
        }

        public DaifaTradeExample.Criteria andBuyerWwIsNotNull() {
            return isNotNull(buyerWw);
        }

        public DaifaTradeExample.Criteria andBuyerWwEqualTo(String value) {
            return equalTo(buyerWw, value);
        }

        public DaifaTradeExample.Criteria andBuyerWwNotEqualTo(String value) {
            return notEqualTo(buyerWw, value);
        }

        public DaifaTradeExample.Criteria andBuyerWwGreaterThan(String value) {
            return greaterThan(buyerWw, value);
        }

        public DaifaTradeExample.Criteria andBuyerWwGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerWw, value);
        }

        public DaifaTradeExample.Criteria andBuyerWwLessThan(String value) {
            return lessThan(buyerWw, value);
        }

        public DaifaTradeExample.Criteria andBuyerWwLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerWw, value);
        }

        public DaifaTradeExample.Criteria andBuyerWwLike(String value) {
            return like(buyerWw, value);
        }

        public DaifaTradeExample.Criteria andBuyerWwNotLike(String value) {
            return notLike(buyerWw, value);
        }

        public DaifaTradeExample.Criteria andBuyerWwIn(List<String> values) {
            return in(buyerWw, values);
        }

        public DaifaTradeExample.Criteria andBuyerWwNotIn(List<String> values) {
            return notIn(buyerWw, values);
        }

        public DaifaTradeExample.Criteria andBuyerWwBetween(String value1, String value2) {
            return between(buyerWw, value1, value2);
        }

        public DaifaTradeExample.Criteria andBuyerWwNotBetween(String value1, String value2) {
            return notBetween(buyerWw, value1, value2);
        }
        public DaifaTradeExample.Criteria andServicesFeeIsNull() {
            return isNull(servicesFee);
        }

        public DaifaTradeExample.Criteria andServicesFeeIsNotNull() {
            return isNotNull(servicesFee);
        }

        public DaifaTradeExample.Criteria andServicesFeeEqualTo(String value) {
            return equalTo(servicesFee, value);
        }

        public DaifaTradeExample.Criteria andServicesFeeNotEqualTo(String value) {
            return notEqualTo(servicesFee, value);
        }

        public DaifaTradeExample.Criteria andServicesFeeGreaterThan(String value) {
            return greaterThan(servicesFee, value);
        }

        public DaifaTradeExample.Criteria andServicesFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(servicesFee, value);
        }

        public DaifaTradeExample.Criteria andServicesFeeLessThan(String value) {
            return lessThan(servicesFee, value);
        }

        public DaifaTradeExample.Criteria andServicesFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(servicesFee, value);
        }

        public DaifaTradeExample.Criteria andServicesFeeLike(String value) {
            return like(servicesFee, value);
        }

        public DaifaTradeExample.Criteria andServicesFeeNotLike(String value) {
            return notLike(servicesFee, value);
        }

        public DaifaTradeExample.Criteria andServicesFeeIn(List<String> values) {
            return in(servicesFee, values);
        }

        public DaifaTradeExample.Criteria andServicesFeeNotIn(List<String> values) {
            return notIn(servicesFee, values);
        }

        public DaifaTradeExample.Criteria andServicesFeeBetween(String value1, String value2) {
            return between(servicesFee, value1, value2);
        }

        public DaifaTradeExample.Criteria andServicesFeeNotBetween(String value1, String value2) {
            return notBetween(servicesFee, value1, value2);
        }
        public DaifaTradeExample.Criteria andBuyerWxIsNull() {
            return isNull(buyerWx);
        }

        public DaifaTradeExample.Criteria andBuyerWxIsNotNull() {
            return isNotNull(buyerWx);
        }

        public DaifaTradeExample.Criteria andBuyerWxEqualTo(String value) {
            return equalTo(buyerWx, value);
        }

        public DaifaTradeExample.Criteria andBuyerWxNotEqualTo(String value) {
            return notEqualTo(buyerWx, value);
        }

        public DaifaTradeExample.Criteria andBuyerWxGreaterThan(String value) {
            return greaterThan(buyerWx, value);
        }

        public DaifaTradeExample.Criteria andBuyerWxGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerWx, value);
        }

        public DaifaTradeExample.Criteria andBuyerWxLessThan(String value) {
            return lessThan(buyerWx, value);
        }

        public DaifaTradeExample.Criteria andBuyerWxLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerWx, value);
        }

        public DaifaTradeExample.Criteria andBuyerWxLike(String value) {
            return like(buyerWx, value);
        }

        public DaifaTradeExample.Criteria andBuyerWxNotLike(String value) {
            return notLike(buyerWx, value);
        }

        public DaifaTradeExample.Criteria andBuyerWxIn(List<String> values) {
            return in(buyerWx, values);
        }

        public DaifaTradeExample.Criteria andBuyerWxNotIn(List<String> values) {
            return notIn(buyerWx, values);
        }

        public DaifaTradeExample.Criteria andBuyerWxBetween(String value1, String value2) {
            return between(buyerWx, value1, value2);
        }

        public DaifaTradeExample.Criteria andBuyerWxNotBetween(String value1, String value2) {
            return notBetween(buyerWx, value1, value2);
        }
        public DaifaTradeExample.Criteria andCloseTimeIsNull() {
            return isNull(closeTime);
        }

        public DaifaTradeExample.Criteria andCloseTimeIsNotNull() {
            return isNotNull(closeTime);
        }

        public DaifaTradeExample.Criteria andCloseTimeEqualTo(Date value) {
            return equalTo(closeTime, value);
        }

        public DaifaTradeExample.Criteria andCloseTimeNotEqualTo(Date value) {
            return notEqualTo(closeTime, value);
        }

        public DaifaTradeExample.Criteria andCloseTimeGreaterThan(Date value) {
            return greaterThan(closeTime, value);
        }

        public DaifaTradeExample.Criteria andCloseTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(closeTime, value);
        }

        public DaifaTradeExample.Criteria andCloseTimeLessThan(Date value) {
            return lessThan(closeTime, value);
        }

        public DaifaTradeExample.Criteria andCloseTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(closeTime, value);
        }

        public DaifaTradeExample.Criteria andCloseTimeIn(List<Date> values) {
            return in(closeTime, values);
        }

        public DaifaTradeExample.Criteria andCloseTimeNotIn(List<Date> values) {
            return notIn(closeTime, values);
        }

        public DaifaTradeExample.Criteria andCloseTimeBetween(Date value1, Date value2) {
            return between(closeTime, value1, value2);
        }

        public DaifaTradeExample.Criteria andCloseTimeNotBetween(Date value1, Date value2) {
            return notBetween(closeTime, value1, value2);
        }
        public DaifaTradeExample.Criteria andGoodsNumIsNull() {
            return isNull(goodsNum);
        }

        public DaifaTradeExample.Criteria andGoodsNumIsNotNull() {
            return isNotNull(goodsNum);
        }

        public DaifaTradeExample.Criteria andGoodsNumEqualTo(Integer value) {
            return equalTo(goodsNum, value);
        }

        public DaifaTradeExample.Criteria andGoodsNumNotEqualTo(Integer value) {
            return notEqualTo(goodsNum, value);
        }

        public DaifaTradeExample.Criteria andGoodsNumGreaterThan(Integer value) {
            return greaterThan(goodsNum, value);
        }

        public DaifaTradeExample.Criteria andGoodsNumGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(goodsNum, value);
        }

        public DaifaTradeExample.Criteria andGoodsNumLessThan(Integer value) {
            return lessThan(goodsNum, value);
        }

        public DaifaTradeExample.Criteria andGoodsNumLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(goodsNum, value);
        }

        public DaifaTradeExample.Criteria andGoodsNumIn(List<Integer> values) {
            return in(goodsNum, values);
        }

        public DaifaTradeExample.Criteria andGoodsNumNotIn(List<Integer> values) {
            return notIn(goodsNum, values);
        }

        public DaifaTradeExample.Criteria andGoodsNumBetween(Integer value1, Integer value2) {
            return between(goodsNum, value1, value2);
        }

        public DaifaTradeExample.Criteria andGoodsNumNotBetween(Integer value1, Integer value2) {
            return notBetween(goodsNum, value1, value2);
        }
        public DaifaTradeExample.Criteria andGoodsFeeIsNull() {
            return isNull(goodsFee);
        }

        public DaifaTradeExample.Criteria andGoodsFeeIsNotNull() {
            return isNotNull(goodsFee);
        }

        public DaifaTradeExample.Criteria andGoodsFeeEqualTo(String value) {
            return equalTo(goodsFee, value);
        }

        public DaifaTradeExample.Criteria andGoodsFeeNotEqualTo(String value) {
            return notEqualTo(goodsFee, value);
        }

        public DaifaTradeExample.Criteria andGoodsFeeGreaterThan(String value) {
            return greaterThan(goodsFee, value);
        }

        public DaifaTradeExample.Criteria andGoodsFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsFee, value);
        }

        public DaifaTradeExample.Criteria andGoodsFeeLessThan(String value) {
            return lessThan(goodsFee, value);
        }

        public DaifaTradeExample.Criteria andGoodsFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsFee, value);
        }

        public DaifaTradeExample.Criteria andGoodsFeeLike(String value) {
            return like(goodsFee, value);
        }

        public DaifaTradeExample.Criteria andGoodsFeeNotLike(String value) {
            return notLike(goodsFee, value);
        }

        public DaifaTradeExample.Criteria andGoodsFeeIn(List<String> values) {
            return in(goodsFee, values);
        }

        public DaifaTradeExample.Criteria andGoodsFeeNotIn(List<String> values) {
            return notIn(goodsFee, values);
        }

        public DaifaTradeExample.Criteria andGoodsFeeBetween(String value1, String value2) {
            return between(goodsFee, value1, value2);
        }

        public DaifaTradeExample.Criteria andGoodsFeeNotBetween(String value1, String value2) {
            return notBetween(goodsFee, value1, value2);
        }
        public DaifaTradeExample.Criteria andIsOldIsNull() {
            return isNull(isOld);
        }

        public DaifaTradeExample.Criteria andIsOldIsNotNull() {
            return isNotNull(isOld);
        }

        public DaifaTradeExample.Criteria andIsOldEqualTo(Integer value) {
            return equalTo(isOld, value);
        }

        public DaifaTradeExample.Criteria andIsOldNotEqualTo(Integer value) {
            return notEqualTo(isOld, value);
        }

        public DaifaTradeExample.Criteria andIsOldGreaterThan(Integer value) {
            return greaterThan(isOld, value);
        }

        public DaifaTradeExample.Criteria andIsOldGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isOld, value);
        }

        public DaifaTradeExample.Criteria andIsOldLessThan(Integer value) {
            return lessThan(isOld, value);
        }

        public DaifaTradeExample.Criteria andIsOldLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isOld, value);
        }

        public DaifaTradeExample.Criteria andIsOldIn(List<Integer> values) {
            return in(isOld, values);
        }

        public DaifaTradeExample.Criteria andIsOldNotIn(List<Integer> values) {
            return notIn(isOld, values);
        }

        public DaifaTradeExample.Criteria andIsOldBetween(Integer value1, Integer value2) {
            return between(isOld, value1, value2);
        }

        public DaifaTradeExample.Criteria andIsOldNotBetween(Integer value1, Integer value2) {
            return notBetween(isOld, value1, value2);
        }
        public DaifaTradeExample.Criteria andPrintExpressStatusIsNull() {
            return isNull(printExpressStatus);
        }

        public DaifaTradeExample.Criteria andPrintExpressStatusIsNotNull() {
            return isNotNull(printExpressStatus);
        }

        public DaifaTradeExample.Criteria andPrintExpressStatusEqualTo(Integer value) {
            return equalTo(printExpressStatus, value);
        }

        public DaifaTradeExample.Criteria andPrintExpressStatusNotEqualTo(Integer value) {
            return notEqualTo(printExpressStatus, value);
        }

        public DaifaTradeExample.Criteria andPrintExpressStatusGreaterThan(Integer value) {
            return greaterThan(printExpressStatus, value);
        }

        public DaifaTradeExample.Criteria andPrintExpressStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(printExpressStatus, value);
        }

        public DaifaTradeExample.Criteria andPrintExpressStatusLessThan(Integer value) {
            return lessThan(printExpressStatus, value);
        }

        public DaifaTradeExample.Criteria andPrintExpressStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(printExpressStatus, value);
        }

        public DaifaTradeExample.Criteria andPrintExpressStatusIn(List<Integer> values) {
            return in(printExpressStatus, values);
        }

        public DaifaTradeExample.Criteria andPrintExpressStatusNotIn(List<Integer> values) {
            return notIn(printExpressStatus, values);
        }

        public DaifaTradeExample.Criteria andPrintExpressStatusBetween(Integer value1, Integer value2) {
            return between(printExpressStatus, value1, value2);
        }

        public DaifaTradeExample.Criteria andPrintExpressStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(printExpressStatus, value1, value2);
        }
        public DaifaTradeExample.Criteria andReceiverNameIsNull() {
            return isNull(receiverName);
        }

        public DaifaTradeExample.Criteria andReceiverNameIsNotNull() {
            return isNotNull(receiverName);
        }

        public DaifaTradeExample.Criteria andReceiverNameEqualTo(String value) {
            return equalTo(receiverName, value);
        }

        public DaifaTradeExample.Criteria andReceiverNameNotEqualTo(String value) {
            return notEqualTo(receiverName, value);
        }

        public DaifaTradeExample.Criteria andReceiverNameGreaterThan(String value) {
            return greaterThan(receiverName, value);
        }

        public DaifaTradeExample.Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverName, value);
        }

        public DaifaTradeExample.Criteria andReceiverNameLessThan(String value) {
            return lessThan(receiverName, value);
        }

        public DaifaTradeExample.Criteria andReceiverNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverName, value);
        }

        public DaifaTradeExample.Criteria andReceiverNameLike(String value) {
            return like(receiverName, value);
        }

        public DaifaTradeExample.Criteria andReceiverNameNotLike(String value) {
            return notLike(receiverName, value);
        }

        public DaifaTradeExample.Criteria andReceiverNameIn(List<String> values) {
            return in(receiverName, values);
        }

        public DaifaTradeExample.Criteria andReceiverNameNotIn(List<String> values) {
            return notIn(receiverName, values);
        }

        public DaifaTradeExample.Criteria andReceiverNameBetween(String value1, String value2) {
            return between(receiverName, value1, value2);
        }

        public DaifaTradeExample.Criteria andReceiverNameNotBetween(String value1, String value2) {
            return notBetween(receiverName, value1, value2);
        }
        public DaifaTradeExample.Criteria andReceiverMobileIsNull() {
            return isNull(receiverMobile);
        }

        public DaifaTradeExample.Criteria andReceiverMobileIsNotNull() {
            return isNotNull(receiverMobile);
        }

        public DaifaTradeExample.Criteria andReceiverMobileEqualTo(String value) {
            return equalTo(receiverMobile, value);
        }

        public DaifaTradeExample.Criteria andReceiverMobileNotEqualTo(String value) {
            return notEqualTo(receiverMobile, value);
        }

        public DaifaTradeExample.Criteria andReceiverMobileGreaterThan(String value) {
            return greaterThan(receiverMobile, value);
        }

        public DaifaTradeExample.Criteria andReceiverMobileGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverMobile, value);
        }

        public DaifaTradeExample.Criteria andReceiverMobileLessThan(String value) {
            return lessThan(receiverMobile, value);
        }

        public DaifaTradeExample.Criteria andReceiverMobileLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverMobile, value);
        }

        public DaifaTradeExample.Criteria andReceiverMobileLike(String value) {
            return like(receiverMobile, value);
        }

        public DaifaTradeExample.Criteria andReceiverMobileNotLike(String value) {
            return notLike(receiverMobile, value);
        }

        public DaifaTradeExample.Criteria andReceiverMobileIn(List<String> values) {
            return in(receiverMobile, values);
        }

        public DaifaTradeExample.Criteria andReceiverMobileNotIn(List<String> values) {
            return notIn(receiverMobile, values);
        }

        public DaifaTradeExample.Criteria andReceiverMobileBetween(String value1, String value2) {
            return between(receiverMobile, value1, value2);
        }

        public DaifaTradeExample.Criteria andReceiverMobileNotBetween(String value1, String value2) {
            return notBetween(receiverMobile, value1, value2);
        }
        public DaifaTradeExample.Criteria andGoodsVolumeIsNull() {
            return isNull(goodsVolume);
        }

        public DaifaTradeExample.Criteria andGoodsVolumeIsNotNull() {
            return isNotNull(goodsVolume);
        }

        public DaifaTradeExample.Criteria andGoodsVolumeEqualTo(String value) {
            return equalTo(goodsVolume, value);
        }

        public DaifaTradeExample.Criteria andGoodsVolumeNotEqualTo(String value) {
            return notEqualTo(goodsVolume, value);
        }

        public DaifaTradeExample.Criteria andGoodsVolumeGreaterThan(String value) {
            return greaterThan(goodsVolume, value);
        }

        public DaifaTradeExample.Criteria andGoodsVolumeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(goodsVolume, value);
        }

        public DaifaTradeExample.Criteria andGoodsVolumeLessThan(String value) {
            return lessThan(goodsVolume, value);
        }

        public DaifaTradeExample.Criteria andGoodsVolumeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(goodsVolume, value);
        }

        public DaifaTradeExample.Criteria andGoodsVolumeLike(String value) {
            return like(goodsVolume, value);
        }

        public DaifaTradeExample.Criteria andGoodsVolumeNotLike(String value) {
            return notLike(goodsVolume, value);
        }

        public DaifaTradeExample.Criteria andGoodsVolumeIn(List<String> values) {
            return in(goodsVolume, values);
        }

        public DaifaTradeExample.Criteria andGoodsVolumeNotIn(List<String> values) {
            return notIn(goodsVolume, values);
        }

        public DaifaTradeExample.Criteria andGoodsVolumeBetween(String value1, String value2) {
            return between(goodsVolume, value1, value2);
        }

        public DaifaTradeExample.Criteria andGoodsVolumeNotBetween(String value1, String value2) {
            return notBetween(goodsVolume, value1, value2);
        }
        public DaifaTradeExample.Criteria andBuyerNameIsNull() {
            return isNull(buyerName);
        }

        public DaifaTradeExample.Criteria andBuyerNameIsNotNull() {
            return isNotNull(buyerName);
        }

        public DaifaTradeExample.Criteria andBuyerNameEqualTo(String value) {
            return equalTo(buyerName, value);
        }

        public DaifaTradeExample.Criteria andBuyerNameNotEqualTo(String value) {
            return notEqualTo(buyerName, value);
        }

        public DaifaTradeExample.Criteria andBuyerNameGreaterThan(String value) {
            return greaterThan(buyerName, value);
        }

        public DaifaTradeExample.Criteria andBuyerNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerName, value);
        }

        public DaifaTradeExample.Criteria andBuyerNameLessThan(String value) {
            return lessThan(buyerName, value);
        }

        public DaifaTradeExample.Criteria andBuyerNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerName, value);
        }

        public DaifaTradeExample.Criteria andBuyerNameLike(String value) {
            return like(buyerName, value);
        }

        public DaifaTradeExample.Criteria andBuyerNameNotLike(String value) {
            return notLike(buyerName, value);
        }

        public DaifaTradeExample.Criteria andBuyerNameIn(List<String> values) {
            return in(buyerName, values);
        }

        public DaifaTradeExample.Criteria andBuyerNameNotIn(List<String> values) {
            return notIn(buyerName, values);
        }

        public DaifaTradeExample.Criteria andBuyerNameBetween(String value1, String value2) {
            return between(buyerName, value1, value2);
        }

        public DaifaTradeExample.Criteria andBuyerNameNotBetween(String value1, String value2) {
            return notBetween(buyerName, value1, value2);
        }
        public DaifaTradeExample.Criteria andTaobaoTidIsNull() {
            return isNull(taobaoTid);
        }

        public DaifaTradeExample.Criteria andTaobaoTidIsNotNull() {
            return isNotNull(taobaoTid);
        }

        public DaifaTradeExample.Criteria andTaobaoTidEqualTo(Long value) {
            return equalTo(taobaoTid, value);
        }

        public DaifaTradeExample.Criteria andTaobaoTidNotEqualTo(Long value) {
            return notEqualTo(taobaoTid, value);
        }

        public DaifaTradeExample.Criteria andTaobaoTidGreaterThan(Long value) {
            return greaterThan(taobaoTid, value);
        }

        public DaifaTradeExample.Criteria andTaobaoTidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(taobaoTid, value);
        }

        public DaifaTradeExample.Criteria andTaobaoTidLessThan(Long value) {
            return lessThan(taobaoTid, value);
        }

        public DaifaTradeExample.Criteria andTaobaoTidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(taobaoTid, value);
        }

        public DaifaTradeExample.Criteria andTaobaoTidIn(List<Long> values) {
            return in(taobaoTid, values);
        }

        public DaifaTradeExample.Criteria andTaobaoTidNotIn(List<Long> values) {
            return notIn(taobaoTid, values);
        }

        public DaifaTradeExample.Criteria andTaobaoTidBetween(Long value1, Long value2) {
            return between(taobaoTid, value1, value2);
        }

        public DaifaTradeExample.Criteria andTaobaoTidNotBetween(Long value1, Long value2) {
            return notBetween(taobaoTid, value1, value2);
        }
        public DaifaTradeExample.Criteria andExpressNameIsNull() {
            return isNull(expressName);
        }

        public DaifaTradeExample.Criteria andExpressNameIsNotNull() {
            return isNotNull(expressName);
        }

        public DaifaTradeExample.Criteria andExpressNameEqualTo(String value) {
            return equalTo(expressName, value);
        }

        public DaifaTradeExample.Criteria andExpressNameNotEqualTo(String value) {
            return notEqualTo(expressName, value);
        }

        public DaifaTradeExample.Criteria andExpressNameGreaterThan(String value) {
            return greaterThan(expressName, value);
        }

        public DaifaTradeExample.Criteria andExpressNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressName, value);
        }

        public DaifaTradeExample.Criteria andExpressNameLessThan(String value) {
            return lessThan(expressName, value);
        }

        public DaifaTradeExample.Criteria andExpressNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressName, value);
        }

        public DaifaTradeExample.Criteria andExpressNameLike(String value) {
            return like(expressName, value);
        }

        public DaifaTradeExample.Criteria andExpressNameNotLike(String value) {
            return notLike(expressName, value);
        }

        public DaifaTradeExample.Criteria andExpressNameIn(List<String> values) {
            return in(expressName, values);
        }

        public DaifaTradeExample.Criteria andExpressNameNotIn(List<String> values) {
            return notIn(expressName, values);
        }

        public DaifaTradeExample.Criteria andExpressNameBetween(String value1, String value2) {
            return between(expressName, value1, value2);
        }

        public DaifaTradeExample.Criteria andExpressNameNotBetween(String value1, String value2) {
            return notBetween(expressName, value1, value2);
        }
        public DaifaTradeExample.Criteria andMoneyIsNull() {
            return isNull(money);
        }

        public DaifaTradeExample.Criteria andMoneyIsNotNull() {
            return isNotNull(money);
        }

        public DaifaTradeExample.Criteria andMoneyEqualTo(String value) {
            return equalTo(money, value);
        }

        public DaifaTradeExample.Criteria andMoneyNotEqualTo(String value) {
            return notEqualTo(money, value);
        }

        public DaifaTradeExample.Criteria andMoneyGreaterThan(String value) {
            return greaterThan(money, value);
        }

        public DaifaTradeExample.Criteria andMoneyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(money, value);
        }

        public DaifaTradeExample.Criteria andMoneyLessThan(String value) {
            return lessThan(money, value);
        }

        public DaifaTradeExample.Criteria andMoneyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(money, value);
        }

        public DaifaTradeExample.Criteria andMoneyLike(String value) {
            return like(money, value);
        }

        public DaifaTradeExample.Criteria andMoneyNotLike(String value) {
            return notLike(money, value);
        }

        public DaifaTradeExample.Criteria andMoneyIn(List<String> values) {
            return in(money, values);
        }

        public DaifaTradeExample.Criteria andMoneyNotIn(List<String> values) {
            return notIn(money, values);
        }

        public DaifaTradeExample.Criteria andMoneyBetween(String value1, String value2) {
            return between(money, value1, value2);
        }

        public DaifaTradeExample.Criteria andMoneyNotBetween(String value1, String value2) {
            return notBetween(money, value1, value2);
        }
        public DaifaTradeExample.Criteria andTotalFeeIsNull() {
            return isNull(totalFee);
        }

        public DaifaTradeExample.Criteria andTotalFeeIsNotNull() {
            return isNotNull(totalFee);
        }

        public DaifaTradeExample.Criteria andTotalFeeEqualTo(String value) {
            return equalTo(totalFee, value);
        }

        public DaifaTradeExample.Criteria andTotalFeeNotEqualTo(String value) {
            return notEqualTo(totalFee, value);
        }

        public DaifaTradeExample.Criteria andTotalFeeGreaterThan(String value) {
            return greaterThan(totalFee, value);
        }

        public DaifaTradeExample.Criteria andTotalFeeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(totalFee, value);
        }

        public DaifaTradeExample.Criteria andTotalFeeLessThan(String value) {
            return lessThan(totalFee, value);
        }

        public DaifaTradeExample.Criteria andTotalFeeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(totalFee, value);
        }

        public DaifaTradeExample.Criteria andTotalFeeLike(String value) {
            return like(totalFee, value);
        }

        public DaifaTradeExample.Criteria andTotalFeeNotLike(String value) {
            return notLike(totalFee, value);
        }

        public DaifaTradeExample.Criteria andTotalFeeIn(List<String> values) {
            return in(totalFee, values);
        }

        public DaifaTradeExample.Criteria andTotalFeeNotIn(List<String> values) {
            return notIn(totalFee, values);
        }

        public DaifaTradeExample.Criteria andTotalFeeBetween(String value1, String value2) {
            return between(totalFee, value1, value2);
        }

        public DaifaTradeExample.Criteria andTotalFeeNotBetween(String value1, String value2) {
            return notBetween(totalFee, value1, value2);
        }
        public DaifaTradeExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaTradeExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaTradeExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public DaifaTradeExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaTradeExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaTradeExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaTradeExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public DaifaTradeExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaTradeExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public DaifaTradeExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public DaifaTradeExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaTradeExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public DaifaTradeExample.Criteria andSendStatusIsNull() {
            return isNull(sendStatus);
        }

        public DaifaTradeExample.Criteria andSendStatusIsNotNull() {
            return isNotNull(sendStatus);
        }

        public DaifaTradeExample.Criteria andSendStatusEqualTo(Integer value) {
            return equalTo(sendStatus, value);
        }

        public DaifaTradeExample.Criteria andSendStatusNotEqualTo(Integer value) {
            return notEqualTo(sendStatus, value);
        }

        public DaifaTradeExample.Criteria andSendStatusGreaterThan(Integer value) {
            return greaterThan(sendStatus, value);
        }

        public DaifaTradeExample.Criteria andSendStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sendStatus, value);
        }

        public DaifaTradeExample.Criteria andSendStatusLessThan(Integer value) {
            return lessThan(sendStatus, value);
        }

        public DaifaTradeExample.Criteria andSendStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sendStatus, value);
        }

        public DaifaTradeExample.Criteria andSendStatusIn(List<Integer> values) {
            return in(sendStatus, values);
        }

        public DaifaTradeExample.Criteria andSendStatusNotIn(List<Integer> values) {
            return notIn(sendStatus, values);
        }

        public DaifaTradeExample.Criteria andSendStatusBetween(Integer value1, Integer value2) {
            return between(sendStatus, value1, value2);
        }

        public DaifaTradeExample.Criteria andSendStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(sendStatus, value1, value2);
        }
        public DaifaTradeExample.Criteria andPayStatusIsNull() {
            return isNull(payStatus);
        }

        public DaifaTradeExample.Criteria andPayStatusIsNotNull() {
            return isNotNull(payStatus);
        }

        public DaifaTradeExample.Criteria andPayStatusEqualTo(Integer value) {
            return equalTo(payStatus, value);
        }

        public DaifaTradeExample.Criteria andPayStatusNotEqualTo(Integer value) {
            return notEqualTo(payStatus, value);
        }

        public DaifaTradeExample.Criteria andPayStatusGreaterThan(Integer value) {
            return greaterThan(payStatus, value);
        }

        public DaifaTradeExample.Criteria andPayStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(payStatus, value);
        }

        public DaifaTradeExample.Criteria andPayStatusLessThan(Integer value) {
            return lessThan(payStatus, value);
        }

        public DaifaTradeExample.Criteria andPayStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(payStatus, value);
        }

        public DaifaTradeExample.Criteria andPayStatusIn(List<Integer> values) {
            return in(payStatus, values);
        }

        public DaifaTradeExample.Criteria andPayStatusNotIn(List<Integer> values) {
            return notIn(payStatus, values);
        }

        public DaifaTradeExample.Criteria andPayStatusBetween(Integer value1, Integer value2) {
            return between(payStatus, value1, value2);
        }

        public DaifaTradeExample.Criteria andPayStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(payStatus, value1, value2);
        }
        public DaifaTradeExample.Criteria andCustomSql(String sql){
            this.addCriterion(sql);
            return this;
        }
    }
}