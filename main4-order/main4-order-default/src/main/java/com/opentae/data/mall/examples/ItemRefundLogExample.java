package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ItemRefundLog;

import java.util.*;
public class ItemRefundLogExample extends SgExample<ItemRefundLogExample.Criteria> {
    public static final Class<ItemRefundLog> beanClass = ItemRefundLog.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn msg;
    public static EntityColumn refundLogId;
    public static EntityColumn toStatus;
    public static EntityColumn fromStatus;
    public static EntityColumn createTime;
    public static EntityColumn imBuyer;
    public static EntityColumn refundId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        msg = listMap.get("msg");
        refundLogId = listMap.get("refundLogId");
        toStatus = listMap.get("toStatus");
        fromStatus = listMap.get("fromStatus");
        createTime = listMap.get("createTime");
        imBuyer = listMap.get("imBuyer");
        refundId = listMap.get("refundId");
        }

    public ItemRefundLogExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ItemRefundLogExample.Criteria createCriteriaInternal() {
        return new ItemRefundLogExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ItemRefundLogExample.Criteria andMsgIsNull() {
            return isNull(msg);
        }

        public ItemRefundLogExample.Criteria andMsgIsNotNull() {
            return isNotNull(msg);
        }

        public ItemRefundLogExample.Criteria andMsgEqualTo(String value) {
            return equalTo(msg, value);
        }

        public ItemRefundLogExample.Criteria andMsgNotEqualTo(String value) {
            return notEqualTo(msg, value);
        }

        public ItemRefundLogExample.Criteria andMsgGreaterThan(String value) {
            return greaterThan(msg, value);
        }

        public ItemRefundLogExample.Criteria andMsgGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(msg, value);
        }

        public ItemRefundLogExample.Criteria andMsgLessThan(String value) {
            return lessThan(msg, value);
        }

        public ItemRefundLogExample.Criteria andMsgLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(msg, value);
        }

        public ItemRefundLogExample.Criteria andMsgLike(String value) {
            return like(msg, value);
        }

        public ItemRefundLogExample.Criteria andMsgNotLike(String value) {
            return notLike(msg, value);
        }

        public ItemRefundLogExample.Criteria andMsgIn(List<String> values) {
            return in(msg, values);
        }

        public ItemRefundLogExample.Criteria andMsgNotIn(List<String> values) {
            return notIn(msg, values);
        }

        public ItemRefundLogExample.Criteria andMsgBetween(String value1, String value2) {
            return between(msg, value1, value2);
        }

        public ItemRefundLogExample.Criteria andMsgNotBetween(String value1, String value2) {
            return notBetween(msg, value1, value2);
        }
        public ItemRefundLogExample.Criteria andRefundLogIdIsNull() {
            return isNull(refundLogId);
        }

        public ItemRefundLogExample.Criteria andRefundLogIdIsNotNull() {
            return isNotNull(refundLogId);
        }

        public ItemRefundLogExample.Criteria andRefundLogIdEqualTo(Long value) {
            return equalTo(refundLogId, value);
        }

        public ItemRefundLogExample.Criteria andRefundLogIdNotEqualTo(Long value) {
            return notEqualTo(refundLogId, value);
        }

        public ItemRefundLogExample.Criteria andRefundLogIdGreaterThan(Long value) {
            return greaterThan(refundLogId, value);
        }

        public ItemRefundLogExample.Criteria andRefundLogIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(refundLogId, value);
        }

        public ItemRefundLogExample.Criteria andRefundLogIdLessThan(Long value) {
            return lessThan(refundLogId, value);
        }

        public ItemRefundLogExample.Criteria andRefundLogIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(refundLogId, value);
        }

        public ItemRefundLogExample.Criteria andRefundLogIdIn(List<Long> values) {
            return in(refundLogId, values);
        }

        public ItemRefundLogExample.Criteria andRefundLogIdNotIn(List<Long> values) {
            return notIn(refundLogId, values);
        }

        public ItemRefundLogExample.Criteria andRefundLogIdBetween(Long value1, Long value2) {
            return between(refundLogId, value1, value2);
        }

        public ItemRefundLogExample.Criteria andRefundLogIdNotBetween(Long value1, Long value2) {
            return notBetween(refundLogId, value1, value2);
        }
        public ItemRefundLogExample.Criteria andToStatusIsNull() {
            return isNull(toStatus);
        }

        public ItemRefundLogExample.Criteria andToStatusIsNotNull() {
            return isNotNull(toStatus);
        }

        public ItemRefundLogExample.Criteria andToStatusEqualTo(Integer value) {
            return equalTo(toStatus, value);
        }

        public ItemRefundLogExample.Criteria andToStatusNotEqualTo(Integer value) {
            return notEqualTo(toStatus, value);
        }

        public ItemRefundLogExample.Criteria andToStatusGreaterThan(Integer value) {
            return greaterThan(toStatus, value);
        }

        public ItemRefundLogExample.Criteria andToStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(toStatus, value);
        }

        public ItemRefundLogExample.Criteria andToStatusLessThan(Integer value) {
            return lessThan(toStatus, value);
        }

        public ItemRefundLogExample.Criteria andToStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(toStatus, value);
        }

        public ItemRefundLogExample.Criteria andToStatusIn(List<Integer> values) {
            return in(toStatus, values);
        }

        public ItemRefundLogExample.Criteria andToStatusNotIn(List<Integer> values) {
            return notIn(toStatus, values);
        }

        public ItemRefundLogExample.Criteria andToStatusBetween(Integer value1, Integer value2) {
            return between(toStatus, value1, value2);
        }

        public ItemRefundLogExample.Criteria andToStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(toStatus, value1, value2);
        }
        public ItemRefundLogExample.Criteria andFromStatusIsNull() {
            return isNull(fromStatus);
        }

        public ItemRefundLogExample.Criteria andFromStatusIsNotNull() {
            return isNotNull(fromStatus);
        }

        public ItemRefundLogExample.Criteria andFromStatusEqualTo(Integer value) {
            return equalTo(fromStatus, value);
        }

        public ItemRefundLogExample.Criteria andFromStatusNotEqualTo(Integer value) {
            return notEqualTo(fromStatus, value);
        }

        public ItemRefundLogExample.Criteria andFromStatusGreaterThan(Integer value) {
            return greaterThan(fromStatus, value);
        }

        public ItemRefundLogExample.Criteria andFromStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(fromStatus, value);
        }

        public ItemRefundLogExample.Criteria andFromStatusLessThan(Integer value) {
            return lessThan(fromStatus, value);
        }

        public ItemRefundLogExample.Criteria andFromStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(fromStatus, value);
        }

        public ItemRefundLogExample.Criteria andFromStatusIn(List<Integer> values) {
            return in(fromStatus, values);
        }

        public ItemRefundLogExample.Criteria andFromStatusNotIn(List<Integer> values) {
            return notIn(fromStatus, values);
        }

        public ItemRefundLogExample.Criteria andFromStatusBetween(Integer value1, Integer value2) {
            return between(fromStatus, value1, value2);
        }

        public ItemRefundLogExample.Criteria andFromStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(fromStatus, value1, value2);
        }
        public ItemRefundLogExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public ItemRefundLogExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public ItemRefundLogExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public ItemRefundLogExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public ItemRefundLogExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public ItemRefundLogExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public ItemRefundLogExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public ItemRefundLogExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public ItemRefundLogExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public ItemRefundLogExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public ItemRefundLogExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public ItemRefundLogExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public ItemRefundLogExample.Criteria andImBuyerIsNull() {
            return isNull(imBuyer);
        }

        public ItemRefundLogExample.Criteria andImBuyerIsNotNull() {
            return isNotNull(imBuyer);
        }

        public ItemRefundLogExample.Criteria andImBuyerEqualTo(Boolean value) {
            return equalTo(imBuyer, value);
        }

        public ItemRefundLogExample.Criteria andImBuyerNotEqualTo(Boolean value) {
            return notEqualTo(imBuyer, value);
        }

        public ItemRefundLogExample.Criteria andImBuyerGreaterThan(Boolean value) {
            return greaterThan(imBuyer, value);
        }

        public ItemRefundLogExample.Criteria andImBuyerGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(imBuyer, value);
        }

        public ItemRefundLogExample.Criteria andImBuyerLessThan(Boolean value) {
            return lessThan(imBuyer, value);
        }

        public ItemRefundLogExample.Criteria andImBuyerLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(imBuyer, value);
        }

        public ItemRefundLogExample.Criteria andImBuyerIn(List<Boolean> values) {
            return in(imBuyer, values);
        }

        public ItemRefundLogExample.Criteria andImBuyerNotIn(List<Boolean> values) {
            return notIn(imBuyer, values);
        }

        public ItemRefundLogExample.Criteria andImBuyerBetween(Boolean value1, Boolean value2) {
            return between(imBuyer, value1, value2);
        }

        public ItemRefundLogExample.Criteria andImBuyerNotBetween(Boolean value1, Boolean value2) {
            return notBetween(imBuyer, value1, value2);
        }
        public ItemRefundLogExample.Criteria andRefundIdIsNull() {
            return isNull(refundId);
        }

        public ItemRefundLogExample.Criteria andRefundIdIsNotNull() {
            return isNotNull(refundId);
        }

        public ItemRefundLogExample.Criteria andRefundIdEqualTo(Long value) {
            return equalTo(refundId, value);
        }

        public ItemRefundLogExample.Criteria andRefundIdNotEqualTo(Long value) {
            return notEqualTo(refundId, value);
        }

        public ItemRefundLogExample.Criteria andRefundIdGreaterThan(Long value) {
            return greaterThan(refundId, value);
        }

        public ItemRefundLogExample.Criteria andRefundIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(refundId, value);
        }

        public ItemRefundLogExample.Criteria andRefundIdLessThan(Long value) {
            return lessThan(refundId, value);
        }

        public ItemRefundLogExample.Criteria andRefundIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(refundId, value);
        }

        public ItemRefundLogExample.Criteria andRefundIdIn(List<Long> values) {
            return in(refundId, values);
        }

        public ItemRefundLogExample.Criteria andRefundIdNotIn(List<Long> values) {
            return notIn(refundId, values);
        }

        public ItemRefundLogExample.Criteria andRefundIdBetween(Long value1, Long value2) {
            return between(refundId, value1, value2);
        }

        public ItemRefundLogExample.Criteria andRefundIdNotBetween(Long value1, Long value2) {
            return notBetween(refundId, value1, value2);
        }
    }
}
