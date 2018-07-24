package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguActivityApprove;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class ShiguActivityApproveExample extends SgExample<ShiguActivityApproveExample.Criteria> {
    public static final Class<ShiguActivityApprove> beanClass = ShiguActivityApprove.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn activityId;
    public static EntityColumn item;
    public static EntityColumn phone;
    public static EntityColumn cateId;
    public static EntityColumn shopId;
    public static EntityColumn userId;
    public static EntityColumn approveId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        activityId = listMap.get("activityId");
        item = listMap.get("item");
        phone = listMap.get("phone");
        cateId = listMap.get("cateId");
        shopId = listMap.get("shopId");
        userId = listMap.get("userId");
        approveId = listMap.get("approveId");
        }

    public ShiguActivityApproveExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguActivityApproveExample.Criteria createCriteriaInternal() {
        return new ShiguActivityApproveExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguActivityApproveExample.Criteria andActivityIdIsNull() {
            return isNull(activityId);
        }

        public ShiguActivityApproveExample.Criteria andActivityIdIsNotNull() {
            return isNotNull(activityId);
        }

        public ShiguActivityApproveExample.Criteria andActivityIdEqualTo(Long value) {
            return equalTo(activityId, value);
        }

        public ShiguActivityApproveExample.Criteria andActivityIdNotEqualTo(Long value) {
            return notEqualTo(activityId, value);
        }

        public ShiguActivityApproveExample.Criteria andActivityIdGreaterThan(Long value) {
            return greaterThan(activityId, value);
        }

        public ShiguActivityApproveExample.Criteria andActivityIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(activityId, value);
        }

        public ShiguActivityApproveExample.Criteria andActivityIdLessThan(Long value) {
            return lessThan(activityId, value);
        }

        public ShiguActivityApproveExample.Criteria andActivityIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(activityId, value);
        }

        public ShiguActivityApproveExample.Criteria andActivityIdIn(List<Long> values) {
            return in(activityId, values);
        }

        public ShiguActivityApproveExample.Criteria andActivityIdNotIn(List<Long> values) {
            return notIn(activityId, values);
        }

        public ShiguActivityApproveExample.Criteria andActivityIdBetween(Long value1, Long value2) {
            return between(activityId, value1, value2);
        }

        public ShiguActivityApproveExample.Criteria andActivityIdNotBetween(Long value1, Long value2) {
            return notBetween(activityId, value1, value2);
        }
        public ShiguActivityApproveExample.Criteria andItemIsNull() {
            return isNull(item);
        }

        public ShiguActivityApproveExample.Criteria andItemIsNotNull() {
            return isNotNull(item);
        }

        public ShiguActivityApproveExample.Criteria andItemEqualTo(String value) {
            return equalTo(item, value);
        }

        public ShiguActivityApproveExample.Criteria andItemNotEqualTo(String value) {
            return notEqualTo(item, value);
        }

        public ShiguActivityApproveExample.Criteria andItemGreaterThan(String value) {
            return greaterThan(item, value);
        }

        public ShiguActivityApproveExample.Criteria andItemGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(item, value);
        }

        public ShiguActivityApproveExample.Criteria andItemLessThan(String value) {
            return lessThan(item, value);
        }

        public ShiguActivityApproveExample.Criteria andItemLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(item, value);
        }

        public ShiguActivityApproveExample.Criteria andItemLike(String value) {
            return like(item, value);
        }

        public ShiguActivityApproveExample.Criteria andItemNotLike(String value) {
            return notLike(item, value);
        }

        public ShiguActivityApproveExample.Criteria andItemIn(List<String> values) {
            return in(item, values);
        }

        public ShiguActivityApproveExample.Criteria andItemNotIn(List<String> values) {
            return notIn(item, values);
        }

        public ShiguActivityApproveExample.Criteria andItemBetween(String value1, String value2) {
            return between(item, value1, value2);
        }

        public ShiguActivityApproveExample.Criteria andItemNotBetween(String value1, String value2) {
            return notBetween(item, value1, value2);
        }
        public ShiguActivityApproveExample.Criteria andPhoneIsNull() {
            return isNull(phone);
        }

        public ShiguActivityApproveExample.Criteria andPhoneIsNotNull() {
            return isNotNull(phone);
        }

        public ShiguActivityApproveExample.Criteria andPhoneEqualTo(String value) {
            return equalTo(phone, value);
        }

        public ShiguActivityApproveExample.Criteria andPhoneNotEqualTo(String value) {
            return notEqualTo(phone, value);
        }

        public ShiguActivityApproveExample.Criteria andPhoneGreaterThan(String value) {
            return greaterThan(phone, value);
        }

        public ShiguActivityApproveExample.Criteria andPhoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(phone, value);
        }

        public ShiguActivityApproveExample.Criteria andPhoneLessThan(String value) {
            return lessThan(phone, value);
        }

        public ShiguActivityApproveExample.Criteria andPhoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(phone, value);
        }

        public ShiguActivityApproveExample.Criteria andPhoneLike(String value) {
            return like(phone, value);
        }

        public ShiguActivityApproveExample.Criteria andPhoneNotLike(String value) {
            return notLike(phone, value);
        }

        public ShiguActivityApproveExample.Criteria andPhoneIn(List<String> values) {
            return in(phone, values);
        }

        public ShiguActivityApproveExample.Criteria andPhoneNotIn(List<String> values) {
            return notIn(phone, values);
        }

        public ShiguActivityApproveExample.Criteria andPhoneBetween(String value1, String value2) {
            return between(phone, value1, value2);
        }

        public ShiguActivityApproveExample.Criteria andPhoneNotBetween(String value1, String value2) {
            return notBetween(phone, value1, value2);
        }
        public ShiguActivityApproveExample.Criteria andCateIdIsNull() {
            return isNull(cateId);
        }

        public ShiguActivityApproveExample.Criteria andCateIdIsNotNull() {
            return isNotNull(cateId);
        }

        public ShiguActivityApproveExample.Criteria andCateIdEqualTo(Long value) {
            return equalTo(cateId, value);
        }

        public ShiguActivityApproveExample.Criteria andCateIdNotEqualTo(Long value) {
            return notEqualTo(cateId, value);
        }

        public ShiguActivityApproveExample.Criteria andCateIdGreaterThan(Long value) {
            return greaterThan(cateId, value);
        }

        public ShiguActivityApproveExample.Criteria andCateIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cateId, value);
        }

        public ShiguActivityApproveExample.Criteria andCateIdLessThan(Long value) {
            return lessThan(cateId, value);
        }

        public ShiguActivityApproveExample.Criteria andCateIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cateId, value);
        }

        public ShiguActivityApproveExample.Criteria andCateIdIn(List<Long> values) {
            return in(cateId, values);
        }

        public ShiguActivityApproveExample.Criteria andCateIdNotIn(List<Long> values) {
            return notIn(cateId, values);
        }

        public ShiguActivityApproveExample.Criteria andCateIdBetween(Long value1, Long value2) {
            return between(cateId, value1, value2);
        }

        public ShiguActivityApproveExample.Criteria andCateIdNotBetween(Long value1, Long value2) {
            return notBetween(cateId, value1, value2);
        }
        public ShiguActivityApproveExample.Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public ShiguActivityApproveExample.Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public ShiguActivityApproveExample.Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public ShiguActivityApproveExample.Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public ShiguActivityApproveExample.Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public ShiguActivityApproveExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public ShiguActivityApproveExample.Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public ShiguActivityApproveExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public ShiguActivityApproveExample.Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public ShiguActivityApproveExample.Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public ShiguActivityApproveExample.Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public ShiguActivityApproveExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
        }
        public ShiguActivityApproveExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public ShiguActivityApproveExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public ShiguActivityApproveExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public ShiguActivityApproveExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public ShiguActivityApproveExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public ShiguActivityApproveExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public ShiguActivityApproveExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public ShiguActivityApproveExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public ShiguActivityApproveExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public ShiguActivityApproveExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public ShiguActivityApproveExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public ShiguActivityApproveExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public ShiguActivityApproveExample.Criteria andApproveIdIsNull() {
            return isNull(approveId);
        }

        public ShiguActivityApproveExample.Criteria andApproveIdIsNotNull() {
            return isNotNull(approveId);
        }

        public ShiguActivityApproveExample.Criteria andApproveIdEqualTo(Long value) {
            return equalTo(approveId, value);
        }

        public ShiguActivityApproveExample.Criteria andApproveIdNotEqualTo(Long value) {
            return notEqualTo(approveId, value);
        }

        public ShiguActivityApproveExample.Criteria andApproveIdGreaterThan(Long value) {
            return greaterThan(approveId, value);
        }

        public ShiguActivityApproveExample.Criteria andApproveIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(approveId, value);
        }

        public ShiguActivityApproveExample.Criteria andApproveIdLessThan(Long value) {
            return lessThan(approveId, value);
        }

        public ShiguActivityApproveExample.Criteria andApproveIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(approveId, value);
        }

        public ShiguActivityApproveExample.Criteria andApproveIdIn(List<Long> values) {
            return in(approveId, values);
        }

        public ShiguActivityApproveExample.Criteria andApproveIdNotIn(List<Long> values) {
            return notIn(approveId, values);
        }

        public ShiguActivityApproveExample.Criteria andApproveIdBetween(Long value1, Long value2) {
            return between(approveId, value1, value2);
        }

        public ShiguActivityApproveExample.Criteria andApproveIdNotBetween(Long value1, Long value2) {
            return notBetween(approveId, value1, value2);
        }
    }
}
