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
    protected ItemOrderRefundExample.Criteria createCriteriaInternal() {
        return new ItemOrderRefundExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ItemOrderRefundExample.Criteria andReasonIsNull() {
            return isNull(reason);
        }

        public ItemOrderRefundExample.Criteria andReasonIsNotNull() {
            return isNotNull(reason);
        }

        public ItemOrderRefundExample.Criteria andReasonEqualTo(String value) {
            return equalTo(reason, value);
        }

        public ItemOrderRefundExample.Criteria andReasonNotEqualTo(String value) {
            return notEqualTo(reason, value);
        }

        public ItemOrderRefundExample.Criteria andReasonGreaterThan(String value) {
            return greaterThan(reason, value);
        }

        public ItemOrderRefundExample.Criteria andReasonGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(reason, value);
        }

        public ItemOrderRefundExample.Criteria andReasonLessThan(String value) {
            return lessThan(reason, value);
        }

        public ItemOrderRefundExample.Criteria andReasonLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(reason, value);
        }

        public ItemOrderRefundExample.Criteria andReasonLike(String value) {
            return like(reason, value);
        }

        public ItemOrderRefundExample.Criteria andReasonNotLike(String value) {
            return notLike(reason, value);
        }

        public ItemOrderRefundExample.Criteria andReasonIn(List<String> values) {
            return in(reason, values);
        }

        public ItemOrderRefundExample.Criteria andReasonNotIn(List<String> values) {
            return notIn(reason, values);
        }

        public ItemOrderRefundExample.Criteria andReasonBetween(String value1, String value2) {
            return between(reason, value1, value2);
        }

        public ItemOrderRefundExample.Criteria andReasonNotBetween(String value1, String value2) {
            return notBetween(reason, value1, value2);
        }
        public ItemOrderRefundExample.Criteria andSoidIsNull() {
            return isNull(soid);
        }

        public ItemOrderRefundExample.Criteria andSoidIsNotNull() {
            return isNotNull(soid);
        }

        public ItemOrderRefundExample.Criteria andSoidEqualTo(Long value) {
            return equalTo(soid, value);
        }

        public ItemOrderRefundExample.Criteria andSoidNotEqualTo(Long value) {
            return notEqualTo(soid, value);
        }

        public ItemOrderRefundExample.Criteria andSoidGreaterThan(Long value) {
            return greaterThan(soid, value);
        }

        public ItemOrderRefundExample.Criteria andSoidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(soid, value);
        }

        public ItemOrderRefundExample.Criteria andSoidLessThan(Long value) {
            return lessThan(soid, value);
        }

        public ItemOrderRefundExample.Criteria andSoidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(soid, value);
        }

        public ItemOrderRefundExample.Criteria andSoidIn(List<Long> values) {
            return in(soid, values);
        }

        public ItemOrderRefundExample.Criteria andSoidNotIn(List<Long> values) {
            return notIn(soid, values);
        }

        public ItemOrderRefundExample.Criteria andSoidBetween(Long value1, Long value2) {
            return between(soid, value1, value2);
        }

        public ItemOrderRefundExample.Criteria andSoidNotBetween(Long value1, Long value2) {
            return notBetween(soid, value1, value2);
        }
        public ItemOrderRefundExample.Criteria andRefundSubInfoIsNull() {
            return isNull(refundSubInfo);
        }

        public ItemOrderRefundExample.Criteria andRefundSubInfoIsNotNull() {
            return isNotNull(refundSubInfo);
        }

        public ItemOrderRefundExample.Criteria andRefundSubInfoEqualTo(Integer value) {
            return equalTo(refundSubInfo, value);
        }

        public ItemOrderRefundExample.Criteria andRefundSubInfoNotEqualTo(Integer value) {
            return notEqualTo(refundSubInfo, value);
        }

        public ItemOrderRefundExample.Criteria andRefundSubInfoGreaterThan(Integer value) {
            return greaterThan(refundSubInfo, value);
        }

        public ItemOrderRefundExample.Criteria andRefundSubInfoGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(refundSubInfo, value);
        }

        public ItemOrderRefundExample.Criteria andRefundSubInfoLessThan(Integer value) {
            return lessThan(refundSubInfo, value);
        }

        public ItemOrderRefundExample.Criteria andRefundSubInfoLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(refundSubInfo, value);
        }

        public ItemOrderRefundExample.Criteria andRefundSubInfoIn(List<Integer> values) {
            return in(refundSubInfo, values);
        }

        public ItemOrderRefundExample.Criteria andRefundSubInfoNotIn(List<Integer> values) {
            return notIn(refundSubInfo, values);
        }

        public ItemOrderRefundExample.Criteria andRefundSubInfoBetween(Integer value1, Integer value2) {
            return between(refundSubInfo, value1, value2);
        }

        public ItemOrderRefundExample.Criteria andRefundSubInfoNotBetween(Integer value1, Integer value2) {
            return notBetween(refundSubInfo, value1, value2);
        }
        public ItemOrderRefundExample.Criteria andSellerProposalMoneyIsNull() {
            return isNull(sellerProposalMoney);
        }

        public ItemOrderRefundExample.Criteria andSellerProposalMoneyIsNotNull() {
            return isNotNull(sellerProposalMoney);
        }

        public ItemOrderRefundExample.Criteria andSellerProposalMoneyEqualTo(Long value) {
            return equalTo(sellerProposalMoney, value);
        }

        public ItemOrderRefundExample.Criteria andSellerProposalMoneyNotEqualTo(Long value) {
            return notEqualTo(sellerProposalMoney, value);
        }

        public ItemOrderRefundExample.Criteria andSellerProposalMoneyGreaterThan(Long value) {
            return greaterThan(sellerProposalMoney, value);
        }

        public ItemOrderRefundExample.Criteria andSellerProposalMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerProposalMoney, value);
        }

        public ItemOrderRefundExample.Criteria andSellerProposalMoneyLessThan(Long value) {
            return lessThan(sellerProposalMoney, value);
        }

        public ItemOrderRefundExample.Criteria andSellerProposalMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerProposalMoney, value);
        }

        public ItemOrderRefundExample.Criteria andSellerProposalMoneyIn(List<Long> values) {
            return in(sellerProposalMoney, values);
        }

        public ItemOrderRefundExample.Criteria andSellerProposalMoneyNotIn(List<Long> values) {
            return notIn(sellerProposalMoney, values);
        }

        public ItemOrderRefundExample.Criteria andSellerProposalMoneyBetween(Long value1, Long value2) {
            return between(sellerProposalMoney, value1, value2);
        }

        public ItemOrderRefundExample.Criteria andSellerProposalMoneyNotBetween(Long value1, Long value2) {
            return notBetween(sellerProposalMoney, value1, value2);
        }
        public ItemOrderRefundExample.Criteria andRefundMoneyIsNull() {
            return isNull(refundMoney);
        }

        public ItemOrderRefundExample.Criteria andRefundMoneyIsNotNull() {
            return isNotNull(refundMoney);
        }

        public ItemOrderRefundExample.Criteria andRefundMoneyEqualTo(Long value) {
            return equalTo(refundMoney, value);
        }

        public ItemOrderRefundExample.Criteria andRefundMoneyNotEqualTo(Long value) {
            return notEqualTo(refundMoney, value);
        }

        public ItemOrderRefundExample.Criteria andRefundMoneyGreaterThan(Long value) {
            return greaterThan(refundMoney, value);
        }

        public ItemOrderRefundExample.Criteria andRefundMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(refundMoney, value);
        }

        public ItemOrderRefundExample.Criteria andRefundMoneyLessThan(Long value) {
            return lessThan(refundMoney, value);
        }

        public ItemOrderRefundExample.Criteria andRefundMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(refundMoney, value);
        }

        public ItemOrderRefundExample.Criteria andRefundMoneyIn(List<Long> values) {
            return in(refundMoney, values);
        }

        public ItemOrderRefundExample.Criteria andRefundMoneyNotIn(List<Long> values) {
            return notIn(refundMoney, values);
        }

        public ItemOrderRefundExample.Criteria andRefundMoneyBetween(Long value1, Long value2) {
            return between(refundMoney, value1, value2);
        }

        public ItemOrderRefundExample.Criteria andRefundMoneyNotBetween(Long value1, Long value2) {
            return notBetween(refundMoney, value1, value2);
        }
        public ItemOrderRefundExample.Criteria andOidIsNull() {
            return isNull(oid);
        }

        public ItemOrderRefundExample.Criteria andOidIsNotNull() {
            return isNotNull(oid);
        }

        public ItemOrderRefundExample.Criteria andOidEqualTo(Long value) {
            return equalTo(oid, value);
        }

        public ItemOrderRefundExample.Criteria andOidNotEqualTo(Long value) {
            return notEqualTo(oid, value);
        }

        public ItemOrderRefundExample.Criteria andOidGreaterThan(Long value) {
            return greaterThan(oid, value);
        }

        public ItemOrderRefundExample.Criteria andOidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(oid, value);
        }

        public ItemOrderRefundExample.Criteria andOidLessThan(Long value) {
            return lessThan(oid, value);
        }

        public ItemOrderRefundExample.Criteria andOidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(oid, value);
        }

        public ItemOrderRefundExample.Criteria andOidIn(List<Long> values) {
            return in(oid, values);
        }

        public ItemOrderRefundExample.Criteria andOidNotIn(List<Long> values) {
            return notIn(oid, values);
        }

        public ItemOrderRefundExample.Criteria andOidBetween(Long value1, Long value2) {
            return between(oid, value1, value2);
        }

        public ItemOrderRefundExample.Criteria andOidNotBetween(Long value1, Long value2) {
            return notBetween(oid, value1, value2);
        }
        public ItemOrderRefundExample.Criteria andFailNumberIsNull() {
            return isNull(failNumber);
        }

        public ItemOrderRefundExample.Criteria andFailNumberIsNotNull() {
            return isNotNull(failNumber);
        }

        public ItemOrderRefundExample.Criteria andFailNumberEqualTo(Integer value) {
            return equalTo(failNumber, value);
        }

        public ItemOrderRefundExample.Criteria andFailNumberNotEqualTo(Integer value) {
            return notEqualTo(failNumber, value);
        }

        public ItemOrderRefundExample.Criteria andFailNumberGreaterThan(Integer value) {
            return greaterThan(failNumber, value);
        }

        public ItemOrderRefundExample.Criteria andFailNumberGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(failNumber, value);
        }

        public ItemOrderRefundExample.Criteria andFailNumberLessThan(Integer value) {
            return lessThan(failNumber, value);
        }

        public ItemOrderRefundExample.Criteria andFailNumberLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(failNumber, value);
        }

        public ItemOrderRefundExample.Criteria andFailNumberIn(List<Integer> values) {
            return in(failNumber, values);
        }

        public ItemOrderRefundExample.Criteria andFailNumberNotIn(List<Integer> values) {
            return notIn(failNumber, values);
        }

        public ItemOrderRefundExample.Criteria andFailNumberBetween(Integer value1, Integer value2) {
            return between(failNumber, value1, value2);
        }

        public ItemOrderRefundExample.Criteria andFailNumberNotBetween(Integer value1, Integer value2) {
            return notBetween(failNumber, value1, value2);
        }
        public ItemOrderRefundExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public ItemOrderRefundExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public ItemOrderRefundExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public ItemOrderRefundExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public ItemOrderRefundExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public ItemOrderRefundExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public ItemOrderRefundExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public ItemOrderRefundExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public ItemOrderRefundExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public ItemOrderRefundExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public ItemOrderRefundExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public ItemOrderRefundExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
        public ItemOrderRefundExample.Criteria andBuyerReturnTimeIsNull() {
            return isNull(buyerReturnTime);
        }

        public ItemOrderRefundExample.Criteria andBuyerReturnTimeIsNotNull() {
            return isNotNull(buyerReturnTime);
        }

        public ItemOrderRefundExample.Criteria andBuyerReturnTimeEqualTo(Date value) {
            return equalTo(buyerReturnTime, value);
        }

        public ItemOrderRefundExample.Criteria andBuyerReturnTimeNotEqualTo(Date value) {
            return notEqualTo(buyerReturnTime, value);
        }

        public ItemOrderRefundExample.Criteria andBuyerReturnTimeGreaterThan(Date value) {
            return greaterThan(buyerReturnTime, value);
        }

        public ItemOrderRefundExample.Criteria andBuyerReturnTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(buyerReturnTime, value);
        }

        public ItemOrderRefundExample.Criteria andBuyerReturnTimeLessThan(Date value) {
            return lessThan(buyerReturnTime, value);
        }

        public ItemOrderRefundExample.Criteria andBuyerReturnTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(buyerReturnTime, value);
        }

        public ItemOrderRefundExample.Criteria andBuyerReturnTimeIn(List<Date> values) {
            return in(buyerReturnTime, values);
        }

        public ItemOrderRefundExample.Criteria andBuyerReturnTimeNotIn(List<Date> values) {
            return notIn(buyerReturnTime, values);
        }

        public ItemOrderRefundExample.Criteria andBuyerReturnTimeBetween(Date value1, Date value2) {
            return between(buyerReturnTime, value1, value2);
        }

        public ItemOrderRefundExample.Criteria andBuyerReturnTimeNotBetween(Date value1, Date value2) {
            return notBetween(buyerReturnTime, value1, value2);
        }
        public ItemOrderRefundExample.Criteria andBuyerCourierIsNull() {
            return isNull(buyerCourier);
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierIsNotNull() {
            return isNotNull(buyerCourier);
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierEqualTo(String value) {
            return equalTo(buyerCourier, value);
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierNotEqualTo(String value) {
            return notEqualTo(buyerCourier, value);
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierGreaterThan(String value) {
            return greaterThan(buyerCourier, value);
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(buyerCourier, value);
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierLessThan(String value) {
            return lessThan(buyerCourier, value);
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(buyerCourier, value);
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierLike(String value) {
            return like(buyerCourier, value);
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierNotLike(String value) {
            return notLike(buyerCourier, value);
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierIn(List<String> values) {
            return in(buyerCourier, values);
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierNotIn(List<String> values) {
            return notIn(buyerCourier, values);
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierBetween(String value1, String value2) {
            return between(buyerCourier, value1, value2);
        }

        public ItemOrderRefundExample.Criteria andBuyerCourierNotBetween(String value1, String value2) {
            return notBetween(buyerCourier, value1, value2);
        }
        public ItemOrderRefundExample.Criteria andHopeMoneyIsNull() {
            return isNull(hopeMoney);
        }

        public ItemOrderRefundExample.Criteria andHopeMoneyIsNotNull() {
            return isNotNull(hopeMoney);
        }

        public ItemOrderRefundExample.Criteria andHopeMoneyEqualTo(Long value) {
            return equalTo(hopeMoney, value);
        }

        public ItemOrderRefundExample.Criteria andHopeMoneyNotEqualTo(Long value) {
            return notEqualTo(hopeMoney, value);
        }

        public ItemOrderRefundExample.Criteria andHopeMoneyGreaterThan(Long value) {
            return greaterThan(hopeMoney, value);
        }

        public ItemOrderRefundExample.Criteria andHopeMoneyGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(hopeMoney, value);
        }

        public ItemOrderRefundExample.Criteria andHopeMoneyLessThan(Long value) {
            return lessThan(hopeMoney, value);
        }

        public ItemOrderRefundExample.Criteria andHopeMoneyLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(hopeMoney, value);
        }

        public ItemOrderRefundExample.Criteria andHopeMoneyIn(List<Long> values) {
            return in(hopeMoney, values);
        }

        public ItemOrderRefundExample.Criteria andHopeMoneyNotIn(List<Long> values) {
            return notIn(hopeMoney, values);
        }

        public ItemOrderRefundExample.Criteria andHopeMoneyBetween(Long value1, Long value2) {
            return between(hopeMoney, value1, value2);
        }

        public ItemOrderRefundExample.Criteria andHopeMoneyNotBetween(Long value1, Long value2) {
            return notBetween(hopeMoney, value1, value2);
        }
        public ItemOrderRefundExample.Criteria andNumberIsNull() {
            return isNull(number);
        }

        public ItemOrderRefundExample.Criteria andNumberIsNotNull() {
            return isNotNull(number);
        }

        public ItemOrderRefundExample.Criteria andNumberEqualTo(Integer value) {
            return equalTo(number, value);
        }

        public ItemOrderRefundExample.Criteria andNumberNotEqualTo(Integer value) {
            return notEqualTo(number, value);
        }

        public ItemOrderRefundExample.Criteria andNumberGreaterThan(Integer value) {
            return greaterThan(number, value);
        }

        public ItemOrderRefundExample.Criteria andNumberGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(number, value);
        }

        public ItemOrderRefundExample.Criteria andNumberLessThan(Integer value) {
            return lessThan(number, value);
        }

        public ItemOrderRefundExample.Criteria andNumberLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(number, value);
        }

        public ItemOrderRefundExample.Criteria andNumberIn(List<Integer> values) {
            return in(number, values);
        }

        public ItemOrderRefundExample.Criteria andNumberNotIn(List<Integer> values) {
            return notIn(number, values);
        }

        public ItemOrderRefundExample.Criteria andNumberBetween(Integer value1, Integer value2) {
            return between(number, value1, value2);
        }

        public ItemOrderRefundExample.Criteria andNumberNotBetween(Integer value1, Integer value2) {
            return notBetween(number, value1, value2);
        }
        public ItemOrderRefundExample.Criteria andUserShowIsNull() {
            return isNull(userShow);
        }

        public ItemOrderRefundExample.Criteria andUserShowIsNotNull() {
            return isNotNull(userShow);
        }

        public ItemOrderRefundExample.Criteria andUserShowEqualTo(Boolean value) {
            return equalTo(userShow, value);
        }

        public ItemOrderRefundExample.Criteria andUserShowNotEqualTo(Boolean value) {
            return notEqualTo(userShow, value);
        }

        public ItemOrderRefundExample.Criteria andUserShowGreaterThan(Boolean value) {
            return greaterThan(userShow, value);
        }

        public ItemOrderRefundExample.Criteria andUserShowGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(userShow, value);
        }

        public ItemOrderRefundExample.Criteria andUserShowLessThan(Boolean value) {
            return lessThan(userShow, value);
        }

        public ItemOrderRefundExample.Criteria andUserShowLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(userShow, value);
        }

        public ItemOrderRefundExample.Criteria andUserShowIn(List<Boolean> values) {
            return in(userShow, values);
        }

        public ItemOrderRefundExample.Criteria andUserShowNotIn(List<Boolean> values) {
            return notIn(userShow, values);
        }

        public ItemOrderRefundExample.Criteria andUserShowBetween(Boolean value1, Boolean value2) {
            return between(userShow, value1, value2);
        }

        public ItemOrderRefundExample.Criteria andUserShowNotBetween(Boolean value1, Boolean value2) {
            return notBetween(userShow, value1, value2);
        }
        public ItemOrderRefundExample.Criteria andUserApplyIsNull() {
            return isNull(userApply);
        }

        public ItemOrderRefundExample.Criteria andUserApplyIsNotNull() {
            return isNotNull(userApply);
        }

        public ItemOrderRefundExample.Criteria andUserApplyEqualTo(Boolean value) {
            return equalTo(userApply, value);
        }

        public ItemOrderRefundExample.Criteria andUserApplyNotEqualTo(Boolean value) {
            return notEqualTo(userApply, value);
        }

        public ItemOrderRefundExample.Criteria andUserApplyGreaterThan(Boolean value) {
            return greaterThan(userApply, value);
        }

        public ItemOrderRefundExample.Criteria andUserApplyGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(userApply, value);
        }

        public ItemOrderRefundExample.Criteria andUserApplyLessThan(Boolean value) {
            return lessThan(userApply, value);
        }

        public ItemOrderRefundExample.Criteria andUserApplyLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(userApply, value);
        }

        public ItemOrderRefundExample.Criteria andUserApplyIn(List<Boolean> values) {
            return in(userApply, values);
        }

        public ItemOrderRefundExample.Criteria andUserApplyNotIn(List<Boolean> values) {
            return notIn(userApply, values);
        }

        public ItemOrderRefundExample.Criteria andUserApplyBetween(Boolean value1, Boolean value2) {
            return between(userApply, value1, value2);
        }

        public ItemOrderRefundExample.Criteria andUserApplyNotBetween(Boolean value1, Boolean value2) {
            return notBetween(userApply, value1, value2);
        }
        public ItemOrderRefundExample.Criteria andFailMsgIsNull() {
            return isNull(failMsg);
        }

        public ItemOrderRefundExample.Criteria andFailMsgIsNotNull() {
            return isNotNull(failMsg);
        }

        public ItemOrderRefundExample.Criteria andFailMsgEqualTo(String value) {
            return equalTo(failMsg, value);
        }

        public ItemOrderRefundExample.Criteria andFailMsgNotEqualTo(String value) {
            return notEqualTo(failMsg, value);
        }

        public ItemOrderRefundExample.Criteria andFailMsgGreaterThan(String value) {
            return greaterThan(failMsg, value);
        }

        public ItemOrderRefundExample.Criteria andFailMsgGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(failMsg, value);
        }

        public ItemOrderRefundExample.Criteria andFailMsgLessThan(String value) {
            return lessThan(failMsg, value);
        }

        public ItemOrderRefundExample.Criteria andFailMsgLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(failMsg, value);
        }

        public ItemOrderRefundExample.Criteria andFailMsgLike(String value) {
            return like(failMsg, value);
        }

        public ItemOrderRefundExample.Criteria andFailMsgNotLike(String value) {
            return notLike(failMsg, value);
        }

        public ItemOrderRefundExample.Criteria andFailMsgIn(List<String> values) {
            return in(failMsg, values);
        }

        public ItemOrderRefundExample.Criteria andFailMsgNotIn(List<String> values) {
            return notIn(failMsg, values);
        }

        public ItemOrderRefundExample.Criteria andFailMsgBetween(String value1, String value2) {
            return between(failMsg, value1, value2);
        }

        public ItemOrderRefundExample.Criteria andFailMsgNotBetween(String value1, String value2) {
            return notBetween(failMsg, value1, value2);
        }
        public ItemOrderRefundExample.Criteria andRefundIdIsNull() {
            return isNull(refundId);
        }

        public ItemOrderRefundExample.Criteria andRefundIdIsNotNull() {
            return isNotNull(refundId);
        }

        public ItemOrderRefundExample.Criteria andRefundIdEqualTo(Long value) {
            return equalTo(refundId, value);
        }

        public ItemOrderRefundExample.Criteria andRefundIdNotEqualTo(Long value) {
            return notEqualTo(refundId, value);
        }

        public ItemOrderRefundExample.Criteria andRefundIdGreaterThan(Long value) {
            return greaterThan(refundId, value);
        }

        public ItemOrderRefundExample.Criteria andRefundIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(refundId, value);
        }

        public ItemOrderRefundExample.Criteria andRefundIdLessThan(Long value) {
            return lessThan(refundId, value);
        }

        public ItemOrderRefundExample.Criteria andRefundIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(refundId, value);
        }

        public ItemOrderRefundExample.Criteria andRefundIdIn(List<Long> values) {
            return in(refundId, values);
        }

        public ItemOrderRefundExample.Criteria andRefundIdNotIn(List<Long> values) {
            return notIn(refundId, values);
        }

        public ItemOrderRefundExample.Criteria andRefundIdBetween(Long value1, Long value2) {
            return between(refundId, value1, value2);
        }

        public ItemOrderRefundExample.Criteria andRefundIdNotBetween(Long value1, Long value2) {
            return notBetween(refundId, value1, value2);
        }
        public ItemOrderRefundExample.Criteria andStatusIsNull() {
            return isNull(status);
        }

        public ItemOrderRefundExample.Criteria andStatusIsNotNull() {
            return isNotNull(status);
        }

        public ItemOrderRefundExample.Criteria andStatusEqualTo(Integer value) {
            return equalTo(status, value);
        }

        public ItemOrderRefundExample.Criteria andStatusNotEqualTo(Integer value) {
            return notEqualTo(status, value);
        }

        public ItemOrderRefundExample.Criteria andStatusGreaterThan(Integer value) {
            return greaterThan(status, value);
        }

        public ItemOrderRefundExample.Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(status, value);
        }

        public ItemOrderRefundExample.Criteria andStatusLessThan(Integer value) {
            return lessThan(status, value);
        }

        public ItemOrderRefundExample.Criteria andStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(status, value);
        }

        public ItemOrderRefundExample.Criteria andStatusIn(List<Integer> values) {
            return in(status, values);
        }

        public ItemOrderRefundExample.Criteria andStatusNotIn(List<Integer> values) {
            return notIn(status, values);
        }

        public ItemOrderRefundExample.Criteria andStatusBetween(Integer value1, Integer value2) {
            return between(status, value1, value2);
        }

        public ItemOrderRefundExample.Criteria andStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(status, value1, value2);
        }
    }
}