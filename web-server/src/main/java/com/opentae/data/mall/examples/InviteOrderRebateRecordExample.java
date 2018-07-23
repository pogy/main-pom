package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.InviteOrderRebateRecord;

import java.util.*;
public class InviteOrderRebateRecordExample extends SgExample<InviteOrderRebateRecordExample.Criteria> {
    public static final Class<InviteOrderRebateRecord> beanClass = InviteOrderRebateRecord.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn idinviteOrderRebateRecordId;
    public static EntityColumn inviteUserId;
    public static EntityColumn rebateAmount;
    public static EntityColumn orderId;
    public static EntityColumn rebateState;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        idinviteOrderRebateRecordId = listMap.get("idinviteOrderRebateRecordId");
        inviteUserId = listMap.get("inviteUserId");
        rebateAmount = listMap.get("rebateAmount");
        orderId = listMap.get("orderId");
        rebateState = listMap.get("rebateState");
        }

    public InviteOrderRebateRecordExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected InviteOrderRebateRecordExample.Criteria createCriteriaInternal() {
        return new InviteOrderRebateRecordExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public InviteOrderRebateRecordExample.Criteria andIdinviteOrderRebateRecordIdIsNull() {
            return isNull(idinviteOrderRebateRecordId);
        }

        public InviteOrderRebateRecordExample.Criteria andIdinviteOrderRebateRecordIdIsNotNull() {
            return isNotNull(idinviteOrderRebateRecordId);
        }

        public InviteOrderRebateRecordExample.Criteria andIdinviteOrderRebateRecordIdEqualTo(Integer value) {
            return equalTo(idinviteOrderRebateRecordId, value);
        }

        public InviteOrderRebateRecordExample.Criteria andIdinviteOrderRebateRecordIdNotEqualTo(Integer value) {
            return notEqualTo(idinviteOrderRebateRecordId, value);
        }

        public InviteOrderRebateRecordExample.Criteria andIdinviteOrderRebateRecordIdGreaterThan(Integer value) {
            return greaterThan(idinviteOrderRebateRecordId, value);
        }

        public InviteOrderRebateRecordExample.Criteria andIdinviteOrderRebateRecordIdGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(idinviteOrderRebateRecordId, value);
        }

        public InviteOrderRebateRecordExample.Criteria andIdinviteOrderRebateRecordIdLessThan(Integer value) {
            return lessThan(idinviteOrderRebateRecordId, value);
        }

        public InviteOrderRebateRecordExample.Criteria andIdinviteOrderRebateRecordIdLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(idinviteOrderRebateRecordId, value);
        }

        public InviteOrderRebateRecordExample.Criteria andIdinviteOrderRebateRecordIdIn(List<Integer> values) {
            return in(idinviteOrderRebateRecordId, values);
        }

        public InviteOrderRebateRecordExample.Criteria andIdinviteOrderRebateRecordIdNotIn(List<Integer> values) {
            return notIn(idinviteOrderRebateRecordId, values);
        }

        public InviteOrderRebateRecordExample.Criteria andIdinviteOrderRebateRecordIdBetween(Integer value1, Integer value2) {
            return between(idinviteOrderRebateRecordId, value1, value2);
        }

        public InviteOrderRebateRecordExample.Criteria andIdinviteOrderRebateRecordIdNotBetween(Integer value1, Integer value2) {
            return notBetween(idinviteOrderRebateRecordId, value1, value2);
        }
        public InviteOrderRebateRecordExample.Criteria andInviteUserIdIsNull() {
            return isNull(inviteUserId);
        }

        public InviteOrderRebateRecordExample.Criteria andInviteUserIdIsNotNull() {
            return isNotNull(inviteUserId);
        }

        public InviteOrderRebateRecordExample.Criteria andInviteUserIdEqualTo(Long value) {
            return equalTo(inviteUserId, value);
        }

        public InviteOrderRebateRecordExample.Criteria andInviteUserIdNotEqualTo(Long value) {
            return notEqualTo(inviteUserId, value);
        }

        public InviteOrderRebateRecordExample.Criteria andInviteUserIdGreaterThan(Long value) {
            return greaterThan(inviteUserId, value);
        }

        public InviteOrderRebateRecordExample.Criteria andInviteUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(inviteUserId, value);
        }

        public InviteOrderRebateRecordExample.Criteria andInviteUserIdLessThan(Long value) {
            return lessThan(inviteUserId, value);
        }

        public InviteOrderRebateRecordExample.Criteria andInviteUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(inviteUserId, value);
        }

        public InviteOrderRebateRecordExample.Criteria andInviteUserIdIn(List<Long> values) {
            return in(inviteUserId, values);
        }

        public InviteOrderRebateRecordExample.Criteria andInviteUserIdNotIn(List<Long> values) {
            return notIn(inviteUserId, values);
        }

        public InviteOrderRebateRecordExample.Criteria andInviteUserIdBetween(Long value1, Long value2) {
            return between(inviteUserId, value1, value2);
        }

        public InviteOrderRebateRecordExample.Criteria andInviteUserIdNotBetween(Long value1, Long value2) {
            return notBetween(inviteUserId, value1, value2);
        }
        public InviteOrderRebateRecordExample.Criteria andRebateAmountIsNull() {
            return isNull(rebateAmount);
        }

        public InviteOrderRebateRecordExample.Criteria andRebateAmountIsNotNull() {
            return isNotNull(rebateAmount);
        }

        public InviteOrderRebateRecordExample.Criteria andRebateAmountEqualTo(Long value) {
            return equalTo(rebateAmount, value);
        }

        public InviteOrderRebateRecordExample.Criteria andRebateAmountNotEqualTo(Long value) {
            return notEqualTo(rebateAmount, value);
        }

        public InviteOrderRebateRecordExample.Criteria andRebateAmountGreaterThan(Long value) {
            return greaterThan(rebateAmount, value);
        }

        public InviteOrderRebateRecordExample.Criteria andRebateAmountGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(rebateAmount, value);
        }

        public InviteOrderRebateRecordExample.Criteria andRebateAmountLessThan(Long value) {
            return lessThan(rebateAmount, value);
        }

        public InviteOrderRebateRecordExample.Criteria andRebateAmountLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(rebateAmount, value);
        }

        public InviteOrderRebateRecordExample.Criteria andRebateAmountIn(List<Long> values) {
            return in(rebateAmount, values);
        }

        public InviteOrderRebateRecordExample.Criteria andRebateAmountNotIn(List<Long> values) {
            return notIn(rebateAmount, values);
        }

        public InviteOrderRebateRecordExample.Criteria andRebateAmountBetween(Long value1, Long value2) {
            return between(rebateAmount, value1, value2);
        }

        public InviteOrderRebateRecordExample.Criteria andRebateAmountNotBetween(Long value1, Long value2) {
            return notBetween(rebateAmount, value1, value2);
        }
        public InviteOrderRebateRecordExample.Criteria andOrderIdIsNull() {
            return isNull(orderId);
        }

        public InviteOrderRebateRecordExample.Criteria andOrderIdIsNotNull() {
            return isNotNull(orderId);
        }

        public InviteOrderRebateRecordExample.Criteria andOrderIdEqualTo(Long value) {
            return equalTo(orderId, value);
        }

        public InviteOrderRebateRecordExample.Criteria andOrderIdNotEqualTo(Long value) {
            return notEqualTo(orderId, value);
        }

        public InviteOrderRebateRecordExample.Criteria andOrderIdGreaterThan(Long value) {
            return greaterThan(orderId, value);
        }

        public InviteOrderRebateRecordExample.Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(orderId, value);
        }

        public InviteOrderRebateRecordExample.Criteria andOrderIdLessThan(Long value) {
            return lessThan(orderId, value);
        }

        public InviteOrderRebateRecordExample.Criteria andOrderIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(orderId, value);
        }

        public InviteOrderRebateRecordExample.Criteria andOrderIdIn(List<Long> values) {
            return in(orderId, values);
        }

        public InviteOrderRebateRecordExample.Criteria andOrderIdNotIn(List<Long> values) {
            return notIn(orderId, values);
        }

        public InviteOrderRebateRecordExample.Criteria andOrderIdBetween(Long value1, Long value2) {
            return between(orderId, value1, value2);
        }

        public InviteOrderRebateRecordExample.Criteria andOrderIdNotBetween(Long value1, Long value2) {
            return notBetween(orderId, value1, value2);
        }
        public InviteOrderRebateRecordExample.Criteria andRebateStateIsNull() {
            return isNull(rebateState);
        }

        public InviteOrderRebateRecordExample.Criteria andRebateStateIsNotNull() {
            return isNotNull(rebateState);
        }

        public InviteOrderRebateRecordExample.Criteria andRebateStateEqualTo(Integer value) {
            return equalTo(rebateState, value);
        }

        public InviteOrderRebateRecordExample.Criteria andRebateStateNotEqualTo(Integer value) {
            return notEqualTo(rebateState, value);
        }

        public InviteOrderRebateRecordExample.Criteria andRebateStateGreaterThan(Integer value) {
            return greaterThan(rebateState, value);
        }

        public InviteOrderRebateRecordExample.Criteria andRebateStateGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(rebateState, value);
        }

        public InviteOrderRebateRecordExample.Criteria andRebateStateLessThan(Integer value) {
            return lessThan(rebateState, value);
        }

        public InviteOrderRebateRecordExample.Criteria andRebateStateLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(rebateState, value);
        }

        public InviteOrderRebateRecordExample.Criteria andRebateStateIn(List<Integer> values) {
            return in(rebateState, values);
        }

        public InviteOrderRebateRecordExample.Criteria andRebateStateNotIn(List<Integer> values) {
            return notIn(rebateState, values);
        }

        public InviteOrderRebateRecordExample.Criteria andRebateStateBetween(Integer value1, Integer value2) {
            return between(rebateState, value1, value2);
        }

        public InviteOrderRebateRecordExample.Criteria andRebateStateNotBetween(Integer value1, Integer value2) {
            return notBetween(rebateState, value1, value2);
        }
    }
}