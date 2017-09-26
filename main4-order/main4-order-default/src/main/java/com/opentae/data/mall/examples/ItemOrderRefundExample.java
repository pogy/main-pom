package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ItemOrderRefund;

import java.util.*;

public class ItemOrderRefundExample extends SgExample<ItemOrderRefundExample.Criteria> {
    public static final Class<ItemOrderRefund> beanClass = ItemOrderRefund.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn reason;
    public static EntityColumn soid;
    public static EntityColumn refundSubInfo;
    public static EntityColumn sellerProposalMoney;
    public static EntityColumn refundMoney;
    public static EntityColumn oid;
    public static EntityColumn failNumber;
    public static EntityColumn type;
    public static EntityColumn buyerReturnTime;
    public static EntityColumn buyerCourier;
    public static EntityColumn hopeMoney;
    public static EntityColumn number;
    public static EntityColumn userShow;
    public static EntityColumn userApply;
    public static EntityColumn failMsg;
    public static EntityColumn refundId;
    public static EntityColumn status;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        reason = listMap.get("reason");
        soid = listMap.get("soid");
        refundSubInfo = listMap.get("refundSubInfo");
        sellerProposalMoney = listMap.get("sellerProposalMoney");
        refundMoney = listMap.get("refundMoney");
        oid = listMap.get("oid");
        failNumber = listMap.get("failNumber");
        type = listMap.get("type");
        buyerReturnTime = listMap.get("buyerReturnTime");
        buyerCourier = listMap.get("buyerCourier");
        hopeMoney = listMap.get("hopeMoney");
        number = listMap.get("number");
        userShow = listMap.get("userShow");
        userApply = listMap.get("userApply");
        failMsg = listMap.get("failMsg");
        refundId = listMap.get("refundId");
        status = listMap.get("status");
        }

    public ItemOrderRefundExample() {
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

        public Criteria andReasonIsNull() {
            return isNull(reason);
        }

        public Criteria andReasonIsNotNull() {
            return isNotNull(reason);
        }

        public Criteria andReasonEqualTo(String value) {
            return equalTo(reason, value);
        }

        public Criteria andReasonNotEqualTo(String value) {
            return notEqualTo(reason, value);
        }

        public Criteria andReasonGreaterThan(String value) {
            return greaterThan(reason, value);
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(reason, value);
        }

        public Criteria andReasonLessThan(String value) {
            return lessThan(reason, value);
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(reason, value);
        }

        public Criteria andReasonLike(String value) {
            return like(reason, value);
        }

        public Criteria andReasonNotLike(String value) {
            return notLike(reason, value);
        }

        public Criteria andReasonIn(List<String> values) {
            return in(reason, values);
        }

        public Criteria andReasonNotIn(List<String> values) {
            return notIn(reason, values);
        }

        public Criteria andReasonBetween(String value1, String value2) {
            return between(reason, value1, value2);
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            return notBetween(reason, value1, value2);
        }
        public Criteria andSoidIsNull() {
            return isNull(soid);
        }

        public Criteria andSoidIsNotNull() {
            return isNotNull(soid);
        }

        public Criteria andSoidEqualTo(Long value) {
            return equalTo(soid, value);
        }

        public Criteria andSoidNotEqualTo(Long value) {
            return notEqualTo(soid, value);
        }

        public Criteria andSoidGreaterThan(Long value) {
            return greaterThan(soid, value);
        }

        public Criteria andSoidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(soid, value);
        }

        public Criteria andSoidLessThan(Long value) {
            return lessThan(soid, value);
        }

        public Criteria andSoidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(soid, value);
        }

        public Criteria andSoidIn(List<Long> values) {
            return in(soid, values);
        }

        public Criteria andSoidNotIn(List<Long> values) {
            return notIn(soid, values);
        }

        public Criteria andSoidBetween(Long value1, Long value2) {
            return between(soid, value1, value2);
        }

        public Criteria andSoidNotBetween(Long value1, Long value2) {
            return notBetween(soid, value1, value2);
        }
        public Criteria andRefundSubInfoIsNull() {
            return isNull(refundSubInfo);
        }

        public Criteria andRefundSubInfoIsNotNull() {
            return isNotNull(refundSubInfo);
        }

        public Criteria andRefundSubInfoEqualTo(Integer value) {
            return equalTo(refundSubInfo, value);
        }

        public Criteria andRefundSubInfoNotEqualTo(Integer value) {
            return notEqualTo(refundSubInfo, value);
        }

        public Criteria andRefundSubInfoGreaterThan(Integer value) {
            return greaterThan(refundSubInfo, value);
        }

        public Criteria andRefundSubInfoGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(refundSubInfo, value);
        }

        public Criteria andRefundSubInfoLessThan(Integer value) {
            return lessThan(refundSubInfo, value);
        }

        public Criteria andRefundSubInfoLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(refundSubInfo, value);
        }

        public Criteria andRefundSubInfoIn(List<Integer> values) {
            return in(refundSubInfo, values);
        }

        public Criteria andRefundSubInfoNotIn(List<Integer> values) {
            return notIn(refundSubInfo, values);
        }

        public Criteria andRefundSubInfoBetween(Integer value1, Integer value2) {
            return between(refundSubInfo, value1, value2);
        }

        public Criteria andRefundSubInfoNotBetween(Integer value1, Integer value2) {
            return notBetween(refundSubInfo, value1, value2);
        }
        public Criteria andSellerProposalMoneyIsNull() {
            return isNull(sellerProposalMoney);
        }

        public Criteria andSellerProposalMoneyIsNotNull() {
            return isNotNull(sellerProposalMoney);
        }

        public Criteria andSellerProposalMoneyEqualTo(Long value) {
            return equalTo(sellerProposalMoney, value);
        }

        public Criteria andSellerProposalMoneyNotEqualTo(Long value) {
            return notEqualTo(sellerProposalMoney, value);
        }

        public Criteria andSellerProposalMoneyGreaterThan(Long value) {
            return greaterThan(sellerProposalMoney, value);
        }

        public Criteria andSellerProposalMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerProposalMoney, value);
        }

        public Criteria andSellerProposalMoneyLessThan(Long value) {
            return lessThan(sellerProposalMoney, value);
        }

        public Criteria andSellerProposalMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerProposalMoney, value);
        }

        public Criteria andSellerProposalMoneyIn(List<Long> values) {
            return in(sellerProposalMoney, values);
        }

        public Criteria andSellerProposalMoneyNotIn(List<Long> values) {
            return notIn(sellerProposalMoney, values);
        }

        public Criteria andSellerProposalMoneyBetween(Long value1, Long value2) {
            return between(sellerProposalMoney, value1, value2);
        }

        public Criteria andSellerProposalMoneyNotBetween(Long value1, Long value2) {
            return notBetween(sellerProposalMoney, value1, value2);
        }
        public Criteria andRefundMoneyIsNull() {
            return isNull(refundMoney);
        }

        public Criteria andRefundMoneyIsNotNull() {
            return isNotNull(refundMoney);
        }

        public Criteria andRefundMoneyEqualTo(Long value) {
            return equalTo(refundMoney, value);
        }

        public Criteria andRefundMoneyNotEqualTo(Long value) {
            return notEqualTo(refundMoney, value);
        }

        public Criteria andRefundMoneyGreaterThan(Long value) {
            return greaterThan(refundMoney, value);
        }

        public Criteria andRefundMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(refundMoney, value);
        }

        public Criteria andRefundMoneyLessThan(Long value) {
            return lessThan(refundMoney, value);
        }

        public Criteria andRefundMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(refundMoney, value);
        }

        public Criteria andRefundMoneyIn(List<Long> values) {
            return in(refundMoney, values);
        }

        public Criteria andRefundMoneyNotIn(List<Long> values) {
            return notIn(refundMoney, values);
        }

        public Criteria andRefundMoneyBetween(Long value1, Long value2) {
            return between(refundMoney, value1, value2);
        }

        public Criteria andRefundMoneyNotBetween(Long value1, Long value2) {
            return notBetween(refundMoney, value1, value2);
        }
        public Criteria andOidIsNull() {
            return isNull(oid);
        }

        public Criteria andOidIsNotNull() {
            return isNotNull(oid);
        }

        public Criteria andOidEqualTo(Long value) {
            return equalTo(oid, value);
        }

        public Criteria andOidNotEqualTo(Long value) {
            return notEqualTo(oid, value);
        }

        public Criteria andOidGreaterThan(Long value) {
            return greaterThan(oid, value);
        }

        public Criteria andOidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(oid, value);
        }

        public Criteria andOidLessThan(Long value) {
            return lessThan(oid, value);
        }

        public Criteria andOidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(oid, value);
        }

        public Criteria andOidIn(List<Long> values) {
            return in(oid, values);
        }

        public Criteria andOidNotIn(List<Long> values) {
            return notIn(oid, values);
        }

        public Criteria andOidBetween(Long value1, Long value2) {
            return between(oid, value1, value2);
        }

        public Criteria andOidNotBetween(Long value1, Long value2) {
            return notBetween(oid, value1, value2);
        }
        public Criteria andFailNumberIsNull() {
            return isNull(failNumber);
        }

        public Criteria andFailNumberIsNotNull() {
            return isNotNull(failNumber);
        }

        public Criteria andFailNumberEqualTo(Integer value) {
            return equalTo(failNumber, value);
        }

        public Criteria andFailNumberNotEqualTo(Integer value) {
            return notEqualTo(failNumber, value);
        }

        public Criteria andFailNumberGreaterThan(Integer value) {
            return greaterThan(failNumber, value);
        }

        public Criteria andFailNumberGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(failNumber, value);
        }

        public Criteria andFailNumberLessThan(Integer value) {
            return lessThan(failNumber, value);
        }

        public Criteria andFailNumberLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(failNumber, value);
        }

        public Criteria andFailNumberIn(List<Integer> values) {
            return in(failNumber, values);
        }

        public Criteria andFailNumberNotIn(List<Integer> values) {
            return notIn(failNumber, values);
        }

        public Criteria andFailNumberBetween(Integer value1, Integer value2) {
            return between(failNumber, value1, value2);
        }

        public Criteria andFailNumberNotBetween(Integer value1, Integer value2) {
            return notBetween(failNumber, value1, value2);
        }
        public Criteria andTypeIsNull() {
            return isNull(type);
        }

        public Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
        public Criteria andBuyerReturnTimeIsNull() {
            return isNull(buyerReturnTime);
        }

        public Criteria andBuyerReturnTimeIsNotNull() {
            return isNotNull(buyerReturnTime);
        }

        public Criteria andBuyerReturnTimeEqualTo(Date value) {
            return equalTo(buyerReturnTime, value);
        }

        public Criteria andBuyerReturnTimeNotEqualTo(Date value) {
            return notEqualTo(buyerReturnTime, value);
        }

        public Criteria andBuyerReturnTimeGreaterThan(Date value) {
            return greaterThan(buyerReturnTime, value);
        }

        public Criteria andBuyerReturnTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(buyerReturnTime, value);
        }

        public Criteria andBuyerReturnTimeLessThan(Date value) {
            return lessThan(buyerReturnTime, value);
        }

        public Criteria andBuyerReturnTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(buyerReturnTime, value);
        }

        public Criteria andBuyerReturnTimeIn(List<Date> values) {
            return in(buyerReturnTime, values);
        }

        public Criteria andBuyerReturnTimeNotIn(List<Date> values) {
            return notIn(buyerReturnTime, values);
        }

        public Criteria andBuyerReturnTimeBetween(Date value1, Date value2) {
            return between(buyerReturnTime, value1, value2);
        }

        public Criteria andBuyerReturnTimeNotBetween(Date value1, Date value2) {
            return notBetween(buyerReturnTime, value1, value2);
        }
        public Criteria andBuyerCourierIsNull() {
            return isNull(buyerCourier);
        }

        public Criteria andBuyerCourierIsNotNull() {
            return isNotNull(buyerCourier);
        }

        public Criteria andBuyerCourierEqualTo(String value) {
            return equalTo(buyerCourier, value);
        }

        public Criteria andBuyerCourierNotEqualTo(String value) {
            return notEqualTo(buyerCourier, value);
        }

        public Criteria andBuyerCourierGreaterThan(String value) {
            return greaterThan(buyerCourier, value);
        }

        public Criteria andBuyerCourierGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerCourier, value);
        }

        public Criteria andBuyerCourierLessThan(String value) {
            return lessThan(buyerCourier, value);
        }

        public Criteria andBuyerCourierLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerCourier, value);
        }

        public Criteria andBuyerCourierLike(String value) {
            return like(buyerCourier, value);
        }

        public Criteria andBuyerCourierNotLike(String value) {
            return notLike(buyerCourier, value);
        }

        public Criteria andBuyerCourierIn(List<String> values) {
            return in(buyerCourier, values);
        }

        public Criteria andBuyerCourierNotIn(List<String> values) {
            return notIn(buyerCourier, values);
        }

        public Criteria andBuyerCourierBetween(String value1, String value2) {
            return between(buyerCourier, value1, value2);
        }

        public Criteria andBuyerCourierNotBetween(String value1, String value2) {
            return notBetween(buyerCourier, value1, value2);
        }
        public Criteria andHopeMoneyIsNull() {
            return isNull(hopeMoney);
        }

        public Criteria andHopeMoneyIsNotNull() {
            return isNotNull(hopeMoney);
        }

        public Criteria andHopeMoneyEqualTo(Long value) {
            return equalTo(hopeMoney, value);
        }

        public Criteria andHopeMoneyNotEqualTo(Long value) {
            return notEqualTo(hopeMoney, value);
        }

        public Criteria andHopeMoneyGreaterThan(Long value) {
            return greaterThan(hopeMoney, value);
        }

        public Criteria andHopeMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(hopeMoney, value);
        }

        public Criteria andHopeMoneyLessThan(Long value) {
            return lessThan(hopeMoney, value);
        }

        public Criteria andHopeMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(hopeMoney, value);
        }

        public Criteria andHopeMoneyIn(List<Long> values) {
            return in(hopeMoney, values);
        }

        public Criteria andHopeMoneyNotIn(List<Long> values) {
            return notIn(hopeMoney, values);
        }

        public Criteria andHopeMoneyBetween(Long value1, Long value2) {
            return between(hopeMoney, value1, value2);
        }

        public Criteria andHopeMoneyNotBetween(Long value1, Long value2) {
            return notBetween(hopeMoney, value1, value2);
        }
        public Criteria andNumberIsNull() {
            return isNull(number);
        }

        public Criteria andNumberIsNotNull() {
            return isNotNull(number);
        }

        public Criteria andNumberEqualTo(Integer value) {
            return equalTo(number, value);
        }

        public Criteria andNumberNotEqualTo(Integer value) {
            return notEqualTo(number, value);
        }

        public Criteria andNumberGreaterThan(Integer value) {
            return greaterThan(number, value);
        }

        public Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(number, value);
        }

        public Criteria andNumberLessThan(Integer value) {
            return lessThan(number, value);
        }

        public Criteria andNumberLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(number, value);
        }

        public Criteria andNumberIn(List<Integer> values) {
            return in(number, values);
        }

        public Criteria andNumberNotIn(List<Integer> values) {
            return notIn(number, values);
        }

        public Criteria andNumberBetween(Integer value1, Integer value2) {
            return between(number, value1, value2);
        }

        public Criteria andNumberNotBetween(Integer value1, Integer value2) {
            return notBetween(number, value1, value2);
        }
        public Criteria andUserShowIsNull() {
            return isNull(userShow);
        }

        public Criteria andUserShowIsNotNull() {
            return isNotNull(userShow);
        }

        public Criteria andUserShowEqualTo(Boolean value) {
            return equalTo(userShow, value);
        }

        public Criteria andUserShowNotEqualTo(Boolean value) {
            return notEqualTo(userShow, value);
        }

        public Criteria andUserShowGreaterThan(Boolean value) {
            return greaterThan(userShow, value);
        }

        public Criteria andUserShowGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(userShow, value);
        }

        public Criteria andUserShowLessThan(Boolean value) {
            return lessThan(userShow, value);
        }

        public Criteria andUserShowLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(userShow, value);
        }

        public Criteria andUserShowIn(List<Boolean> values) {
            return in(userShow, values);
        }

        public Criteria andUserShowNotIn(List<Boolean> values) {
            return notIn(userShow, values);
        }

        public Criteria andUserShowBetween(Boolean value1, Boolean value2) {
            return between(userShow, value1, value2);
        }

        public Criteria andUserShowNotBetween(Boolean value1, Boolean value2) {
            return notBetween(userShow, value1, value2);
        }
        public Criteria andUserApplyIsNull() {
            return isNull(userApply);
        }

        public Criteria andUserApplyIsNotNull() {
            return isNotNull(userApply);
        }

        public Criteria andUserApplyEqualTo(Boolean value) {
            return equalTo(userApply, value);
        }

        public Criteria andUserApplyNotEqualTo(Boolean value) {
            return notEqualTo(userApply, value);
        }

        public Criteria andUserApplyGreaterThan(Boolean value) {
            return greaterThan(userApply, value);
        }

        public Criteria andUserApplyGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(userApply, value);
        }

        public Criteria andUserApplyLessThan(Boolean value) {
            return lessThan(userApply, value);
        }

        public Criteria andUserApplyLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(userApply, value);
        }

        public Criteria andUserApplyIn(List<Boolean> values) {
            return in(userApply, values);
        }

        public Criteria andUserApplyNotIn(List<Boolean> values) {
            return notIn(userApply, values);
        }

        public Criteria andUserApplyBetween(Boolean value1, Boolean value2) {
            return between(userApply, value1, value2);
        }

        public Criteria andUserApplyNotBetween(Boolean value1, Boolean value2) {
            return notBetween(userApply, value1, value2);
        }
        public Criteria andFailMsgIsNull() {
            return isNull(failMsg);
        }

        public Criteria andFailMsgIsNotNull() {
            return isNotNull(failMsg);
        }

        public Criteria andFailMsgEqualTo(String value) {
            return equalTo(failMsg, value);
        }

        public Criteria andFailMsgNotEqualTo(String value) {
            return notEqualTo(failMsg, value);
        }

        public Criteria andFailMsgGreaterThan(String value) {
            return greaterThan(failMsg, value);
        }

        public Criteria andFailMsgGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(failMsg, value);
        }

        public Criteria andFailMsgLessThan(String value) {
            return lessThan(failMsg, value);
        }

        public Criteria andFailMsgLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(failMsg, value);
        }

        public Criteria andFailMsgLike(String value) {
            return like(failMsg, value);
        }

        public Criteria andFailMsgNotLike(String value) {
            return notLike(failMsg, value);
        }

        public Criteria andFailMsgIn(List<String> values) {
            return in(failMsg, values);
        }

        public Criteria andFailMsgNotIn(List<String> values) {
            return notIn(failMsg, values);
        }

        public Criteria andFailMsgBetween(String value1, String value2) {
            return between(failMsg, value1, value2);
        }

        public Criteria andFailMsgNotBetween(String value1, String value2) {
            return notBetween(failMsg, value1, value2);
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
        public Criteria andStatusIsNull() {
            return isNull(status);
        }

        public Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public Criteria andStatusEqualTo(Integer value) {
            return equalTo(status, value);
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            return notEqualTo(status, value);
        }

        public Criteria andStatusGreaterThan(Integer value) {
            return greaterThan(status, value);
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(status, value);
        }

        public Criteria andStatusLessThan(Integer value) {
            return lessThan(status, value);
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(status, value);
        }

        public Criteria andStatusIn(List<Integer> values) {
            return in(status, values);
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            return notIn(status, values);
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            return between(status, value1, value2);
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(status, value1, value2);
        }
    }
}