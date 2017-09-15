package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaAfterMoneyConsult;

import java.util.*;
public class DaifaAfterMoneyConsultExample extends SgExample<DaifaAfterMoneyConsultExample.Criteria> {
    public static final Class<DaifaAfterMoneyConsult> beanClass = DaifaAfterMoneyConsult.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn consultType;
    public static EntityColumn consultMoney;
    public static EntityColumn createTime;
    public static EntityColumn afterSaleSubId;
    public static EntityColumn consultBatch;
    public static EntityColumn remark1;
    public static EntityColumn afterConsultId;
    public static EntityColumn refundId;
    public static EntityColumn lastDoTime;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        consultType = listMap.get("consultType");
        consultMoney = listMap.get("consultMoney");
        createTime = listMap.get("createTime");
        afterSaleSubId = listMap.get("afterSaleSubId");
        consultBatch = listMap.get("consultBatch");
        remark1 = listMap.get("remark1");
        afterConsultId = listMap.get("afterConsultId");
        refundId = listMap.get("refundId");
        lastDoTime = listMap.get("lastDoTime");
        remark2 = listMap.get("remark2");
        }

    public DaifaAfterMoneyConsultExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaAfterMoneyConsultExample.Criteria createCriteriaInternal() {
        return new DaifaAfterMoneyConsultExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeIsNull() {
            return isNull(consultType);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeIsNotNull() {
            return isNotNull(consultType);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeEqualTo(Integer value) {
            return equalTo(consultType, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeNotEqualTo(Integer value) {
            return notEqualTo(consultType, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeGreaterThan(Integer value) {
            return greaterThan(consultType, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(consultType, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeLessThan(Integer value) {
            return lessThan(consultType, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(consultType, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeIn(List<Integer> values) {
            return in(consultType, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeNotIn(List<Integer> values) {
            return notIn(consultType, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeBetween(Integer value1, Integer value2) {
            return between(consultType, value1, value2);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(consultType, value1, value2);
        }
        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyIsNull() {
            return isNull(consultMoney);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyIsNotNull() {
            return isNotNull(consultMoney);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyEqualTo(String value) {
            return equalTo(consultMoney, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyNotEqualTo(String value) {
            return notEqualTo(consultMoney, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyGreaterThan(String value) {
            return greaterThan(consultMoney, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(consultMoney, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyLessThan(String value) {
            return lessThan(consultMoney, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(consultMoney, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyLike(String value) {
            return like(consultMoney, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyNotLike(String value) {
            return notLike(consultMoney, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyIn(List<String> values) {
            return in(consultMoney, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyNotIn(List<String> values) {
            return notIn(consultMoney, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyBetween(String value1, String value2) {
            return between(consultMoney, value1, value2);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultMoneyNotBetween(String value1, String value2) {
            return notBetween(consultMoney, value1, value2);
        }
        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaAfterMoneyConsultExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public DaifaAfterMoneyConsultExample.Criteria andAfterSaleSubIdIsNull() {
            return isNull(afterSaleSubId);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterSaleSubIdIsNotNull() {
            return isNotNull(afterSaleSubId);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterSaleSubIdEqualTo(Long value) {
            return equalTo(afterSaleSubId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterSaleSubIdNotEqualTo(Long value) {
            return notEqualTo(afterSaleSubId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterSaleSubIdGreaterThan(Long value) {
            return greaterThan(afterSaleSubId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterSaleSubIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(afterSaleSubId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterSaleSubIdLessThan(Long value) {
            return lessThan(afterSaleSubId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterSaleSubIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(afterSaleSubId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterSaleSubIdIn(List<Long> values) {
            return in(afterSaleSubId, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterSaleSubIdNotIn(List<Long> values) {
            return notIn(afterSaleSubId, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterSaleSubIdBetween(Long value1, Long value2) {
            return between(afterSaleSubId, value1, value2);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterSaleSubIdNotBetween(Long value1, Long value2) {
            return notBetween(afterSaleSubId, value1, value2);
        }
        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchIsNull() {
            return isNull(consultBatch);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchIsNotNull() {
            return isNotNull(consultBatch);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchEqualTo(Integer value) {
            return equalTo(consultBatch, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchNotEqualTo(Integer value) {
            return notEqualTo(consultBatch, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchGreaterThan(Integer value) {
            return greaterThan(consultBatch, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(consultBatch, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchLessThan(Integer value) {
            return lessThan(consultBatch, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(consultBatch, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchIn(List<Integer> values) {
            return in(consultBatch, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchNotIn(List<Integer> values) {
            return notIn(consultBatch, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchBetween(Integer value1, Integer value2) {
            return between(consultBatch, value1, value2);
        }

        public DaifaAfterMoneyConsultExample.Criteria andConsultBatchNotBetween(Integer value1, Integer value2) {
            return notBetween(consultBatch, value1, value2);
        }
        public DaifaAfterMoneyConsultExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdIsNull() {
            return isNull(afterConsultId);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdIsNotNull() {
            return isNotNull(afterConsultId);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdEqualTo(Long value) {
            return equalTo(afterConsultId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdNotEqualTo(Long value) {
            return notEqualTo(afterConsultId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdGreaterThan(Long value) {
            return greaterThan(afterConsultId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(afterConsultId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdLessThan(Long value) {
            return lessThan(afterConsultId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(afterConsultId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdIn(List<Long> values) {
            return in(afterConsultId, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdNotIn(List<Long> values) {
            return notIn(afterConsultId, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdBetween(Long value1, Long value2) {
            return between(afterConsultId, value1, value2);
        }

        public DaifaAfterMoneyConsultExample.Criteria andAfterConsultIdNotBetween(Long value1, Long value2) {
            return notBetween(afterConsultId, value1, value2);
        }
        public DaifaAfterMoneyConsultExample.Criteria andRefundIdIsNull() {
            return isNull(refundId);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRefundIdIsNotNull() {
            return isNotNull(refundId);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRefundIdEqualTo(Long value) {
            return equalTo(refundId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRefundIdNotEqualTo(Long value) {
            return notEqualTo(refundId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRefundIdGreaterThan(Long value) {
            return greaterThan(refundId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRefundIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(refundId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRefundIdLessThan(Long value) {
            return lessThan(refundId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRefundIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(refundId, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRefundIdIn(List<Long> values) {
            return in(refundId, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRefundIdNotIn(List<Long> values) {
            return notIn(refundId, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRefundIdBetween(Long value1, Long value2) {
            return between(refundId, value1, value2);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRefundIdNotBetween(Long value1, Long value2) {
            return notBetween(refundId, value1, value2);
        }
        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeIsNull() {
            return isNull(lastDoTime);
        }

        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeIsNotNull() {
            return isNotNull(lastDoTime);
        }

        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeEqualTo(Date value) {
            return equalTo(lastDoTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeNotEqualTo(Date value) {
            return notEqualTo(lastDoTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeGreaterThan(Date value) {
            return greaterThan(lastDoTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(lastDoTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeLessThan(Date value) {
            return lessThan(lastDoTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(lastDoTime, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeIn(List<Date> values) {
            return in(lastDoTime, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeNotIn(List<Date> values) {
            return notIn(lastDoTime, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeBetween(Date value1, Date value2) {
            return between(lastDoTime, value1, value2);
        }

        public DaifaAfterMoneyConsultExample.Criteria andLastDoTimeNotBetween(Date value1, Date value2) {
            return notBetween(lastDoTime, value1, value2);
        }
        public DaifaAfterMoneyConsultExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public DaifaAfterMoneyConsultExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}