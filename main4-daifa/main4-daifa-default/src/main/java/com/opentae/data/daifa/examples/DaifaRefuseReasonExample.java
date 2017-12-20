package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaRefuseReason;

import java.util.*;

public class DaifaRefuseReasonExample extends SgExample<DaifaRefuseReasonExample.Criteria> {
    public static final Class<DaifaRefuseReason> beanClass = DaifaRefuseReason.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn createTime;
    public static EntityColumn dealReason;
    public static EntityColumn dealReasonId;
    public static EntityColumn dealReasonType;
    public static EntityColumn useStatus;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        createTime = listMap.get("createTime");
        dealReason = listMap.get("dealReason");
        dealReasonId = listMap.get("dealReasonId");
        dealReasonType = listMap.get("dealReasonType");
        useStatus = listMap.get("useStatus");
        }

    public DaifaRefuseReasonExample() {
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
        public Criteria andDealReasonIsNull() {
            return isNull(dealReason);
        }

        public Criteria andDealReasonIsNotNull() {
            return isNotNull(dealReason);
        }

        public Criteria andDealReasonEqualTo(String value) {
            return equalTo(dealReason, value);
        }

        public Criteria andDealReasonNotEqualTo(String value) {
            return notEqualTo(dealReason, value);
        }

        public Criteria andDealReasonGreaterThan(String value) {
            return greaterThan(dealReason, value);
        }

        public Criteria andDealReasonGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(dealReason, value);
        }

        public Criteria andDealReasonLessThan(String value) {
            return lessThan(dealReason, value);
        }

        public Criteria andDealReasonLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(dealReason, value);
        }

        public Criteria andDealReasonLike(String value) {
            return like(dealReason, value);
        }

        public Criteria andDealReasonNotLike(String value) {
            return notLike(dealReason, value);
        }

        public Criteria andDealReasonIn(List<String> values) {
            return in(dealReason, values);
        }

        public Criteria andDealReasonNotIn(List<String> values) {
            return notIn(dealReason, values);
        }

        public Criteria andDealReasonBetween(String value1, String value2) {
            return between(dealReason, value1, value2);
        }

        public Criteria andDealReasonNotBetween(String value1, String value2) {
            return notBetween(dealReason, value1, value2);
        }
        public Criteria andDealReasonIdIsNull() {
            return isNull(dealReasonId);
        }

        public Criteria andDealReasonIdIsNotNull() {
            return isNotNull(dealReasonId);
        }

        public Criteria andDealReasonIdEqualTo(Long value) {
            return equalTo(dealReasonId, value);
        }

        public Criteria andDealReasonIdNotEqualTo(Long value) {
            return notEqualTo(dealReasonId, value);
        }

        public Criteria andDealReasonIdGreaterThan(Long value) {
            return greaterThan(dealReasonId, value);
        }

        public Criteria andDealReasonIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dealReasonId, value);
        }

        public Criteria andDealReasonIdLessThan(Long value) {
            return lessThan(dealReasonId, value);
        }

        public Criteria andDealReasonIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dealReasonId, value);
        }

        public Criteria andDealReasonIdIn(List<Long> values) {
            return in(dealReasonId, values);
        }

        public Criteria andDealReasonIdNotIn(List<Long> values) {
            return notIn(dealReasonId, values);
        }

        public Criteria andDealReasonIdBetween(Long value1, Long value2) {
            return between(dealReasonId, value1, value2);
        }

        public Criteria andDealReasonIdNotBetween(Long value1, Long value2) {
            return notBetween(dealReasonId, value1, value2);
        }
        public Criteria andDealReasonTypeIsNull() {
            return isNull(dealReasonType);
        }

        public Criteria andDealReasonTypeIsNotNull() {
            return isNotNull(dealReasonType);
        }

        public Criteria andDealReasonTypeEqualTo(Integer value) {
            return equalTo(dealReasonType, value);
        }

        public Criteria andDealReasonTypeNotEqualTo(Integer value) {
            return notEqualTo(dealReasonType, value);
        }

        public Criteria andDealReasonTypeGreaterThan(Integer value) {
            return greaterThan(dealReasonType, value);
        }

        public Criteria andDealReasonTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(dealReasonType, value);
        }

        public Criteria andDealReasonTypeLessThan(Integer value) {
            return lessThan(dealReasonType, value);
        }

        public Criteria andDealReasonTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(dealReasonType, value);
        }

        public Criteria andDealReasonTypeIn(List<Integer> values) {
            return in(dealReasonType, values);
        }

        public Criteria andDealReasonTypeNotIn(List<Integer> values) {
            return notIn(dealReasonType, values);
        }

        public Criteria andDealReasonTypeBetween(Integer value1, Integer value2) {
            return between(dealReasonType, value1, value2);
        }

        public Criteria andDealReasonTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(dealReasonType, value1, value2);
        }
        public Criteria andUseStatusIsNull() {
            return isNull(useStatus);
        }

        public Criteria andUseStatusIsNotNull() {
            return isNotNull(useStatus);
        }

        public Criteria andUseStatusEqualTo(Integer value) {
            return equalTo(useStatus, value);
        }

        public Criteria andUseStatusNotEqualTo(Integer value) {
            return notEqualTo(useStatus, value);
        }

        public Criteria andUseStatusGreaterThan(Integer value) {
            return greaterThan(useStatus, value);
        }

        public Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(useStatus, value);
        }

        public Criteria andUseStatusLessThan(Integer value) {
            return lessThan(useStatus, value);
        }

        public Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(useStatus, value);
        }

        public Criteria andUseStatusIn(List<Integer> values) {
            return in(useStatus, values);
        }

        public Criteria andUseStatusNotIn(List<Integer> values) {
            return notIn(useStatus, values);
        }

        public Criteria andUseStatusBetween(Integer value1, Integer value2) {
            return between(useStatus, value1, value2);
        }

        public Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(useStatus, value1, value2);
        }
    }
}