package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaAfterSale;

import java.util.*;
public class DaifaAfterSaleExample extends SgExample<DaifaAfterSaleExample.Criteria> {
    public static final Class<DaifaAfterSale> beanClass = DaifaAfterSale.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn buyerTelephone;
    public static EntityColumn receiverName;
    public static EntityColumn receiverMobile;
    public static EntityColumn tradeCode;
    public static EntityColumn remark;
    public static EntityColumn afterSaleId;
    public static EntityColumn buyerName;
    public static EntityColumn buyerId;
    public static EntityColumn dfTradeId;
    public static EntityColumn receiverAddress;
    public static EntityColumn buyerQq;
    public static EntityColumn buyerWw;
    public static EntityColumn buyerRemark;
    public static EntityColumn sellerId;
    public static EntityColumn money;
    public static EntityColumn createTime;
    public static EntityColumn receiverQq;
    public static EntityColumn receiverState;
    public static EntityColumn remark1;
    public static EntityColumn receiverZip;
    public static EntityColumn createDate;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        buyerTelephone = listMap.get("buyerTelephone");
        receiverName = listMap.get("receiverName");
        receiverMobile = listMap.get("receiverMobile");
        tradeCode = listMap.get("tradeCode");
        remark = listMap.get("remark");
        afterSaleId = listMap.get("afterSaleId");
        buyerName = listMap.get("buyerName");
        buyerId = listMap.get("buyerId");
        dfTradeId = listMap.get("dfTradeId");
        receiverAddress = listMap.get("receiverAddress");
        buyerQq = listMap.get("buyerQq");
        buyerWw = listMap.get("buyerWw");
        buyerRemark = listMap.get("buyerRemark");
        sellerId = listMap.get("sellerId");
        money = listMap.get("money");
        createTime = listMap.get("createTime");
        receiverQq = listMap.get("receiverQq");
        receiverState = listMap.get("receiverState");
        remark1 = listMap.get("remark1");
        receiverZip = listMap.get("receiverZip");
        createDate = listMap.get("createDate");
        remark2 = listMap.get("remark2");
    }

    public DaifaAfterSaleExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaAfterSaleExample.Criteria createCriteriaInternal() {
        return new DaifaAfterSaleExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneIsNull() {
            return isNull(buyerTelephone);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneIsNotNull() {
            return isNotNull(buyerTelephone);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneEqualTo(String value) {
            return equalTo(buyerTelephone, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneNotEqualTo(String value) {
            return notEqualTo(buyerTelephone, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneGreaterThan(String value) {
            return greaterThan(buyerTelephone, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerTelephone, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneLessThan(String value) {
            return lessThan(buyerTelephone, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerTelephone, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneLike(String value) {
            return like(buyerTelephone, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneNotLike(String value) {
            return notLike(buyerTelephone, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneIn(List<String> values) {
            return in(buyerTelephone, values);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneNotIn(List<String> values) {
            return notIn(buyerTelephone, values);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneBetween(String value1, String value2) {
            return between(buyerTelephone, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andBuyerTelephoneNotBetween(String value1, String value2) {
            return notBetween(buyerTelephone, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andReceiverNameIsNull() {
            return isNull(receiverName);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameIsNotNull() {
            return isNotNull(receiverName);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameEqualTo(String value) {
            return equalTo(receiverName, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameNotEqualTo(String value) {
            return notEqualTo(receiverName, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameGreaterThan(String value) {
            return greaterThan(receiverName, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverName, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameLessThan(String value) {
            return lessThan(receiverName, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverName, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameLike(String value) {
            return like(receiverName, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameNotLike(String value) {
            return notLike(receiverName, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameIn(List<String> values) {
            return in(receiverName, values);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameNotIn(List<String> values) {
            return notIn(receiverName, values);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameBetween(String value1, String value2) {
            return between(receiverName, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andReceiverNameNotBetween(String value1, String value2) {
            return notBetween(receiverName, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andReceiverMobileIsNull() {
            return isNull(receiverMobile);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileIsNotNull() {
            return isNotNull(receiverMobile);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileEqualTo(String value) {
            return equalTo(receiverMobile, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileNotEqualTo(String value) {
            return notEqualTo(receiverMobile, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileGreaterThan(String value) {
            return greaterThan(receiverMobile, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverMobile, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileLessThan(String value) {
            return lessThan(receiverMobile, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverMobile, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileLike(String value) {
            return like(receiverMobile, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileNotLike(String value) {
            return notLike(receiverMobile, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileIn(List<String> values) {
            return in(receiverMobile, values);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileNotIn(List<String> values) {
            return notIn(receiverMobile, values);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileBetween(String value1, String value2) {
            return between(receiverMobile, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andReceiverMobileNotBetween(String value1, String value2) {
            return notBetween(receiverMobile, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andTradeCodeIsNull() {
            return isNull(tradeCode);
        }

        public DaifaAfterSaleExample.Criteria andTradeCodeIsNotNull() {
            return isNotNull(tradeCode);
        }

        public DaifaAfterSaleExample.Criteria andTradeCodeEqualTo(String value) {
            return equalTo(tradeCode, value);
        }

        public DaifaAfterSaleExample.Criteria andTradeCodeNotEqualTo(String value) {
            return notEqualTo(tradeCode, value);
        }

        public DaifaAfterSaleExample.Criteria andTradeCodeGreaterThan(String value) {
            return greaterThan(tradeCode, value);
        }

        public DaifaAfterSaleExample.Criteria andTradeCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(tradeCode, value);
        }

        public DaifaAfterSaleExample.Criteria andTradeCodeLessThan(String value) {
            return lessThan(tradeCode, value);
        }

        public DaifaAfterSaleExample.Criteria andTradeCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(tradeCode, value);
        }

        public DaifaAfterSaleExample.Criteria andTradeCodeLike(String value) {
            return like(tradeCode, value);
        }

        public DaifaAfterSaleExample.Criteria andTradeCodeNotLike(String value) {
            return notLike(tradeCode, value);
        }

        public DaifaAfterSaleExample.Criteria andTradeCodeIn(List<String> values) {
            return in(tradeCode, values);
        }

        public DaifaAfterSaleExample.Criteria andTradeCodeNotIn(List<String> values) {
            return notIn(tradeCode, values);
        }

        public DaifaAfterSaleExample.Criteria andTradeCodeBetween(String value1, String value2) {
            return between(tradeCode, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andTradeCodeNotBetween(String value1, String value2) {
            return notBetween(tradeCode, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andRemarkIsNull() {
            return isNull(remark);
        }

        public DaifaAfterSaleExample.Criteria andRemarkIsNotNull() {
            return isNotNull(remark);
        }

        public DaifaAfterSaleExample.Criteria andRemarkEqualTo(String value) {
            return equalTo(remark, value);
        }

        public DaifaAfterSaleExample.Criteria andRemarkNotEqualTo(String value) {
            return notEqualTo(remark, value);
        }

        public DaifaAfterSaleExample.Criteria andRemarkGreaterThan(String value) {
            return greaterThan(remark, value);
        }

        public DaifaAfterSaleExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark, value);
        }

        public DaifaAfterSaleExample.Criteria andRemarkLessThan(String value) {
            return lessThan(remark, value);
        }

        public DaifaAfterSaleExample.Criteria andRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark, value);
        }

        public DaifaAfterSaleExample.Criteria andRemarkLike(String value) {
            return like(remark, value);
        }

        public DaifaAfterSaleExample.Criteria andRemarkNotLike(String value) {
            return notLike(remark, value);
        }

        public DaifaAfterSaleExample.Criteria andRemarkIn(List<String> values) {
            return in(remark, values);
        }

        public DaifaAfterSaleExample.Criteria andRemarkNotIn(List<String> values) {
            return notIn(remark, values);
        }

        public DaifaAfterSaleExample.Criteria andRemarkBetween(String value1, String value2) {
            return between(remark, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andRemarkNotBetween(String value1, String value2) {
            return notBetween(remark, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andAfterSaleIdIsNull() {
            return isNull(afterSaleId);
        }

        public DaifaAfterSaleExample.Criteria andAfterSaleIdIsNotNull() {
            return isNotNull(afterSaleId);
        }

        public DaifaAfterSaleExample.Criteria andAfterSaleIdEqualTo(Long value) {
            return equalTo(afterSaleId, value);
        }

        public DaifaAfterSaleExample.Criteria andAfterSaleIdNotEqualTo(Long value) {
            return notEqualTo(afterSaleId, value);
        }

        public DaifaAfterSaleExample.Criteria andAfterSaleIdGreaterThan(Long value) {
            return greaterThan(afterSaleId, value);
        }

        public DaifaAfterSaleExample.Criteria andAfterSaleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(afterSaleId, value);
        }

        public DaifaAfterSaleExample.Criteria andAfterSaleIdLessThan(Long value) {
            return lessThan(afterSaleId, value);
        }

        public DaifaAfterSaleExample.Criteria andAfterSaleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(afterSaleId, value);
        }

        public DaifaAfterSaleExample.Criteria andAfterSaleIdIn(List<Long> values) {
            return in(afterSaleId, values);
        }

        public DaifaAfterSaleExample.Criteria andAfterSaleIdNotIn(List<Long> values) {
            return notIn(afterSaleId, values);
        }

        public DaifaAfterSaleExample.Criteria andAfterSaleIdBetween(Long value1, Long value2) {
            return between(afterSaleId, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andAfterSaleIdNotBetween(Long value1, Long value2) {
            return notBetween(afterSaleId, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andBuyerNameIsNull() {
            return isNull(buyerName);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameIsNotNull() {
            return isNotNull(buyerName);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameEqualTo(String value) {
            return equalTo(buyerName, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameNotEqualTo(String value) {
            return notEqualTo(buyerName, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameGreaterThan(String value) {
            return greaterThan(buyerName, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerName, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameLessThan(String value) {
            return lessThan(buyerName, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerName, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameLike(String value) {
            return like(buyerName, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameNotLike(String value) {
            return notLike(buyerName, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameIn(List<String> values) {
            return in(buyerName, values);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameNotIn(List<String> values) {
            return notIn(buyerName, values);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameBetween(String value1, String value2) {
            return between(buyerName, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andBuyerNameNotBetween(String value1, String value2) {
            return notBetween(buyerName, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andBuyerIdIsNull() {
            return isNull(buyerId);
        }

        public DaifaAfterSaleExample.Criteria andBuyerIdIsNotNull() {
            return isNotNull(buyerId);
        }

        public DaifaAfterSaleExample.Criteria andBuyerIdEqualTo(Integer value) {
            return equalTo(buyerId, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerIdNotEqualTo(Integer value) {
            return notEqualTo(buyerId, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerIdGreaterThan(Integer value) {
            return greaterThan(buyerId, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerIdGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(buyerId, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerIdLessThan(Integer value) {
            return lessThan(buyerId, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerIdLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(buyerId, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerIdIn(List<Integer> values) {
            return in(buyerId, values);
        }

        public DaifaAfterSaleExample.Criteria andBuyerIdNotIn(List<Integer> values) {
            return notIn(buyerId, values);
        }

        public DaifaAfterSaleExample.Criteria andBuyerIdBetween(Integer value1, Integer value2) {
            return between(buyerId, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andBuyerIdNotBetween(Integer value1, Integer value2) {
            return notBetween(buyerId, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andDfTradeIdLike(String value) {
            return like(dfTradeId, value);
        }

        public DaifaAfterSaleExample.Criteria andDfTradeIdNotLike(String value) {
            return notLike(dfTradeId, value);
        }

        public DaifaAfterSaleExample.Criteria andDfTradeIdIsNull() {
            return isNull(dfTradeId);
        }

        public DaifaAfterSaleExample.Criteria andDfTradeIdIsNotNull() {
            return isNotNull(dfTradeId);
        }

        public DaifaAfterSaleExample.Criteria andDfTradeIdEqualTo(Long value) {
            return equalTo(dfTradeId, value);
        }

        public DaifaAfterSaleExample.Criteria andDfTradeIdNotEqualTo(Long value) {
            return notEqualTo(dfTradeId, value);
        }

        public DaifaAfterSaleExample.Criteria andDfTradeIdGreaterThan(Long value) {
            return greaterThan(dfTradeId, value);
        }

        public DaifaAfterSaleExample.Criteria andDfTradeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfTradeId, value);
        }

        public DaifaAfterSaleExample.Criteria andDfTradeIdLessThan(Long value) {
            return lessThan(dfTradeId, value);
        }

        public DaifaAfterSaleExample.Criteria andDfTradeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfTradeId, value);
        }

        public DaifaAfterSaleExample.Criteria andDfTradeIdIn(List<Long> values) {
            return in(dfTradeId, values);
        }

        public DaifaAfterSaleExample.Criteria andDfTradeIdNotIn(List<Long> values) {
            return notIn(dfTradeId, values);
        }

        public DaifaAfterSaleExample.Criteria andDfTradeIdBetween(Long value1, Long value2) {
            return between(dfTradeId, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andDfTradeIdNotBetween(Long value1, Long value2) {
            return notBetween(dfTradeId, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andReceiverAddressIsNull() {
            return isNull(receiverAddress);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressIsNotNull() {
            return isNotNull(receiverAddress);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressEqualTo(String value) {
            return equalTo(receiverAddress, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressNotEqualTo(String value) {
            return notEqualTo(receiverAddress, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressGreaterThan(String value) {
            return greaterThan(receiverAddress, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverAddress, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressLessThan(String value) {
            return lessThan(receiverAddress, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverAddress, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressLike(String value) {
            return like(receiverAddress, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressNotLike(String value) {
            return notLike(receiverAddress, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressIn(List<String> values) {
            return in(receiverAddress, values);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressNotIn(List<String> values) {
            return notIn(receiverAddress, values);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressBetween(String value1, String value2) {
            return between(receiverAddress, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andReceiverAddressNotBetween(String value1, String value2) {
            return notBetween(receiverAddress, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andBuyerQqIsNull() {
            return isNull(buyerQq);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqIsNotNull() {
            return isNotNull(buyerQq);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqEqualTo(String value) {
            return equalTo(buyerQq, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqNotEqualTo(String value) {
            return notEqualTo(buyerQq, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqGreaterThan(String value) {
            return greaterThan(buyerQq, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerQq, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqLessThan(String value) {
            return lessThan(buyerQq, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerQq, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqLike(String value) {
            return like(buyerQq, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqNotLike(String value) {
            return notLike(buyerQq, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqIn(List<String> values) {
            return in(buyerQq, values);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqNotIn(List<String> values) {
            return notIn(buyerQq, values);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqBetween(String value1, String value2) {
            return between(buyerQq, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andBuyerQqNotBetween(String value1, String value2) {
            return notBetween(buyerQq, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andBuyerWwIsNull() {
            return isNull(buyerWw);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwIsNotNull() {
            return isNotNull(buyerWw);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwEqualTo(String value) {
            return equalTo(buyerWw, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwNotEqualTo(String value) {
            return notEqualTo(buyerWw, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwGreaterThan(String value) {
            return greaterThan(buyerWw, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerWw, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwLessThan(String value) {
            return lessThan(buyerWw, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerWw, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwLike(String value) {
            return like(buyerWw, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwNotLike(String value) {
            return notLike(buyerWw, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwIn(List<String> values) {
            return in(buyerWw, values);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwNotIn(List<String> values) {
            return notIn(buyerWw, values);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwBetween(String value1, String value2) {
            return between(buyerWw, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andBuyerWwNotBetween(String value1, String value2) {
            return notBetween(buyerWw, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andBuyerRemarkIsNull() {
            return isNull(buyerRemark);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkIsNotNull() {
            return isNotNull(buyerRemark);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkEqualTo(String value) {
            return equalTo(buyerRemark, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkNotEqualTo(String value) {
            return notEqualTo(buyerRemark, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkGreaterThan(String value) {
            return greaterThan(buyerRemark, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerRemark, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkLessThan(String value) {
            return lessThan(buyerRemark, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerRemark, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkLike(String value) {
            return like(buyerRemark, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkNotLike(String value) {
            return notLike(buyerRemark, value);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkIn(List<String> values) {
            return in(buyerRemark, values);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkNotIn(List<String> values) {
            return notIn(buyerRemark, values);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkBetween(String value1, String value2) {
            return between(buyerRemark, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andBuyerRemarkNotBetween(String value1, String value2) {
            return notBetween(buyerRemark, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andSellerIdIsNull() {
            return isNull(sellerId);
        }

        public DaifaAfterSaleExample.Criteria andSellerIdIsNotNull() {
            return isNotNull(sellerId);
        }

        public DaifaAfterSaleExample.Criteria andSellerIdEqualTo(Long value) {
            return equalTo(sellerId, value);
        }

        public DaifaAfterSaleExample.Criteria andSellerIdNotEqualTo(Long value) {
            return notEqualTo(sellerId, value);
        }

        public DaifaAfterSaleExample.Criteria andSellerIdGreaterThan(Long value) {
            return greaterThan(sellerId, value);
        }

        public DaifaAfterSaleExample.Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerId, value);
        }

        public DaifaAfterSaleExample.Criteria andSellerIdLessThan(Long value) {
            return lessThan(sellerId, value);
        }

        public DaifaAfterSaleExample.Criteria andSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerId, value);
        }

        public DaifaAfterSaleExample.Criteria andSellerIdIn(List<Long> values) {
            return in(sellerId, values);
        }

        public DaifaAfterSaleExample.Criteria andSellerIdNotIn(List<Long> values) {
            return notIn(sellerId, values);
        }

        public DaifaAfterSaleExample.Criteria andSellerIdBetween(Long value1, Long value2) {
            return between(sellerId, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(sellerId, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andMoneyIsNull() {
            return isNull(money);
        }

        public DaifaAfterSaleExample.Criteria andMoneyIsNotNull() {
            return isNotNull(money);
        }

        public DaifaAfterSaleExample.Criteria andMoneyEqualTo(String value) {
            return equalTo(money, value);
        }

        public DaifaAfterSaleExample.Criteria andMoneyNotEqualTo(String value) {
            return notEqualTo(money, value);
        }

        public DaifaAfterSaleExample.Criteria andMoneyGreaterThan(String value) {
            return greaterThan(money, value);
        }

        public DaifaAfterSaleExample.Criteria andMoneyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(money, value);
        }

        public DaifaAfterSaleExample.Criteria andMoneyLessThan(String value) {
            return lessThan(money, value);
        }

        public DaifaAfterSaleExample.Criteria andMoneyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(money, value);
        }

        public DaifaAfterSaleExample.Criteria andMoneyLike(String value) {
            return like(money, value);
        }

        public DaifaAfterSaleExample.Criteria andMoneyNotLike(String value) {
            return notLike(money, value);
        }

        public DaifaAfterSaleExample.Criteria andMoneyIn(List<String> values) {
            return in(money, values);
        }

        public DaifaAfterSaleExample.Criteria andMoneyNotIn(List<String> values) {
            return notIn(money, values);
        }

        public DaifaAfterSaleExample.Criteria andMoneyBetween(String value1, String value2) {
            return between(money, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andMoneyNotBetween(String value1, String value2) {
            return notBetween(money, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaAfterSaleExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaAfterSaleExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public DaifaAfterSaleExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public DaifaAfterSaleExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andReceiverQqIsNull() {
            return isNull(receiverQq);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqIsNotNull() {
            return isNotNull(receiverQq);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqEqualTo(String value) {
            return equalTo(receiverQq, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqNotEqualTo(String value) {
            return notEqualTo(receiverQq, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqGreaterThan(String value) {
            return greaterThan(receiverQq, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverQq, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqLessThan(String value) {
            return lessThan(receiverQq, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverQq, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqLike(String value) {
            return like(receiverQq, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqNotLike(String value) {
            return notLike(receiverQq, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqIn(List<String> values) {
            return in(receiverQq, values);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqNotIn(List<String> values) {
            return notIn(receiverQq, values);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqBetween(String value1, String value2) {
            return between(receiverQq, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andReceiverQqNotBetween(String value1, String value2) {
            return notBetween(receiverQq, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andReceiverStateIsNull() {
            return isNull(receiverState);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateIsNotNull() {
            return isNotNull(receiverState);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateEqualTo(String value) {
            return equalTo(receiverState, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateNotEqualTo(String value) {
            return notEqualTo(receiverState, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateGreaterThan(String value) {
            return greaterThan(receiverState, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverState, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateLessThan(String value) {
            return lessThan(receiverState, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverState, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateLike(String value) {
            return like(receiverState, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateNotLike(String value) {
            return notLike(receiverState, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateIn(List<String> values) {
            return in(receiverState, values);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateNotIn(List<String> values) {
            return notIn(receiverState, values);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateBetween(String value1, String value2) {
            return between(receiverState, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andReceiverStateNotBetween(String value1, String value2) {
            return notBetween(receiverState, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public DaifaAfterSaleExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public DaifaAfterSaleExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public DaifaAfterSaleExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public DaifaAfterSaleExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andReceiverZipIsNull() {
            return isNull(receiverZip);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipIsNotNull() {
            return isNotNull(receiverZip);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipEqualTo(String value) {
            return equalTo(receiverZip, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipNotEqualTo(String value) {
            return notEqualTo(receiverZip, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipGreaterThan(String value) {
            return greaterThan(receiverZip, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(receiverZip, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipLessThan(String value) {
            return lessThan(receiverZip, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(receiverZip, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipLike(String value) {
            return like(receiverZip, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipNotLike(String value) {
            return notLike(receiverZip, value);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipIn(List<String> values) {
            return in(receiverZip, values);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipNotIn(List<String> values) {
            return notIn(receiverZip, values);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipBetween(String value1, String value2) {
            return between(receiverZip, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andReceiverZipNotBetween(String value1, String value2) {
            return notBetween(receiverZip, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andCreateDateIsNull() {
            return isNull(createDate);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateIsNotNull() {
            return isNotNull(createDate);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateEqualTo(String value) {
            return equalTo(createDate, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateNotEqualTo(String value) {
            return notEqualTo(createDate, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateGreaterThan(String value) {
            return greaterThan(createDate, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(createDate, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateLessThan(String value) {
            return lessThan(createDate, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(createDate, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateLike(String value) {
            return like(createDate, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateNotLike(String value) {
            return notLike(createDate, value);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateIn(List<String> values) {
            return in(createDate, values);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateNotIn(List<String> values) {
            return notIn(createDate, values);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateBetween(String value1, String value2) {
            return between(createDate, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andCreateDateNotBetween(String value1, String value2) {
            return notBetween(createDate, value1, value2);
        }
        public DaifaAfterSaleExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public DaifaAfterSaleExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public DaifaAfterSaleExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public DaifaAfterSaleExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public DaifaAfterSaleExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public DaifaAfterSaleExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public DaifaAfterSaleExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}