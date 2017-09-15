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
    protected DaifaRefuseReasonExample.Criteria createCriteriaInternal() {
        return new DaifaRefuseReasonExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaRefuseReasonExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaRefuseReasonExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaRefuseReasonExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public DaifaRefuseReasonExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaRefuseReasonExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaRefuseReasonExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaRefuseReasonExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public DaifaRefuseReasonExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaRefuseReasonExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public DaifaRefuseReasonExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public DaifaRefuseReasonExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaRefuseReasonExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public DaifaRefuseReasonExample.Criteria andDealReasonIsNull() {
            return isNull(dealReason);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonIsNotNull() {
            return isNotNull(dealReason);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonEqualTo(String value) {
            return equalTo(dealReason, value);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonNotEqualTo(String value) {
            return notEqualTo(dealReason, value);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonGreaterThan(String value) {
            return greaterThan(dealReason, value);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(dealReason, value);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonLessThan(String value) {
            return lessThan(dealReason, value);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(dealReason, value);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonLike(String value) {
            return like(dealReason, value);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonNotLike(String value) {
            return notLike(dealReason, value);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonIn(List<String> values) {
            return in(dealReason, values);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonNotIn(List<String> values) {
            return notIn(dealReason, values);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonBetween(String value1, String value2) {
            return between(dealReason, value1, value2);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonNotBetween(String value1, String value2) {
            return notBetween(dealReason, value1, value2);
        }
        public DaifaRefuseReasonExample.Criteria andDealReasonIdIsNull() {
            return isNull(dealReasonId);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonIdIsNotNull() {
            return isNotNull(dealReasonId);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonIdEqualTo(Long value) {
            return equalTo(dealReasonId, value);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonIdNotEqualTo(Long value) {
            return notEqualTo(dealReasonId, value);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonIdGreaterThan(Long value) {
            return greaterThan(dealReasonId, value);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dealReasonId, value);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonIdLessThan(Long value) {
            return lessThan(dealReasonId, value);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dealReasonId, value);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonIdIn(List<Long> values) {
            return in(dealReasonId, values);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonIdNotIn(List<Long> values) {
            return notIn(dealReasonId, values);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonIdBetween(Long value1, Long value2) {
            return between(dealReasonId, value1, value2);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonIdNotBetween(Long value1, Long value2) {
            return notBetween(dealReasonId, value1, value2);
        }
        public DaifaRefuseReasonExample.Criteria andDealReasonTypeIsNull() {
            return isNull(dealReasonType);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonTypeIsNotNull() {
            return isNotNull(dealReasonType);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonTypeEqualTo(Integer value) {
            return equalTo(dealReasonType, value);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonTypeNotEqualTo(Integer value) {
            return notEqualTo(dealReasonType, value);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonTypeGreaterThan(Integer value) {
            return greaterThan(dealReasonType, value);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(dealReasonType, value);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonTypeLessThan(Integer value) {
            return lessThan(dealReasonType, value);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(dealReasonType, value);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonTypeIn(List<Integer> values) {
            return in(dealReasonType, values);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonTypeNotIn(List<Integer> values) {
            return notIn(dealReasonType, values);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonTypeBetween(Integer value1, Integer value2) {
            return between(dealReasonType, value1, value2);
        }

        public DaifaRefuseReasonExample.Criteria andDealReasonTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(dealReasonType, value1, value2);
        }
        public DaifaRefuseReasonExample.Criteria andUseStatusIsNull() {
            return isNull(useStatus);
        }

        public DaifaRefuseReasonExample.Criteria andUseStatusIsNotNull() {
            return isNotNull(useStatus);
        }

        public DaifaRefuseReasonExample.Criteria andUseStatusEqualTo(Integer value) {
            return equalTo(useStatus, value);
        }

        public DaifaRefuseReasonExample.Criteria andUseStatusNotEqualTo(Integer value) {
            return notEqualTo(useStatus, value);
        }

        public DaifaRefuseReasonExample.Criteria andUseStatusGreaterThan(Integer value) {
            return greaterThan(useStatus, value);
        }

        public DaifaRefuseReasonExample.Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(useStatus, value);
        }

        public DaifaRefuseReasonExample.Criteria andUseStatusLessThan(Integer value) {
            return lessThan(useStatus, value);
        }

        public DaifaRefuseReasonExample.Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(useStatus, value);
        }

        public DaifaRefuseReasonExample.Criteria andUseStatusIn(List<Integer> values) {
            return in(useStatus, values);
        }

        public DaifaRefuseReasonExample.Criteria andUseStatusNotIn(List<Integer> values) {
            return notIn(useStatus, values);
        }

        public DaifaRefuseReasonExample.Criteria andUseStatusBetween(Integer value1, Integer value2) {
            return between(useStatus, value1, value2);
        }

        public DaifaRefuseReasonExample.Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(useStatus, value1, value2);
        }
    }
}