package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguShopApply;

import java.util.*;
public class ShiguShopApplyExample extends SgExample<ShiguShopApplyExample.Criteria> {
    public static final Class<ShiguShopApply> beanClass = ShiguShopApply.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn mainBus;
    public static EntityColumn canExamine;
    public static EntityColumn tbuserId;
    public static EntityColumn shopNum;
    public static EntityColumn ip;
    public static EntityColumn tbshopId;
    public static EntityColumn ruzhuId;
    public static EntityColumn telephone;
    public static EntityColumn userId;
    public static EntityColumn tbNick;
    public static EntityColumn marketId;
    public static EntityColumn tags;
    public static EntityColumn imAliww;
    public static EntityColumn webSite;
    public static EntityColumn floorId;
    public static EntityColumn tbUrl;
    public static EntityColumn imWx;
    public static EntityColumn imQq;
    public static EntityColumn applyTime;
    public static EntityColumn applyStatus;
    public static EntityColumn email;
    public static EntityColumn refuseReason;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        mainBus = listMap.get("mainBus");
        canExamine = listMap.get("canExamine");
        tbuserId = listMap.get("tbuserId");
        shopNum = listMap.get("shopNum");
        ip = listMap.get("ip");
        tbshopId = listMap.get("tbshopId");
        ruzhuId = listMap.get("ruzhuId");
        telephone = listMap.get("telephone");
        userId = listMap.get("userId");
        tbNick = listMap.get("tbNick");
        marketId = listMap.get("marketId");
        tags = listMap.get("tags");
        imAliww = listMap.get("imAliww");
        webSite = listMap.get("webSite");
        floorId = listMap.get("floorId");
        tbUrl = listMap.get("tbUrl");
        imWx = listMap.get("imWx");
        imQq = listMap.get("imQq");
        applyTime = listMap.get("applyTime");
        applyStatus = listMap.get("applyStatus");
        email = listMap.get("email");
        refuseReason = listMap.get("refuseReason");
        }

    public ShiguShopApplyExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguShopApplyExample.Criteria createCriteriaInternal() {
        return new ShiguShopApplyExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguShopApplyExample.Criteria andMainBusIsNull() {
            return isNull(mainBus);
        }

        public ShiguShopApplyExample.Criteria andMainBusIsNotNull() {
            return isNotNull(mainBus);
        }

        public ShiguShopApplyExample.Criteria andMainBusEqualTo(String value) {
            return equalTo(mainBus, value);
        }

        public ShiguShopApplyExample.Criteria andMainBusNotEqualTo(String value) {
            return notEqualTo(mainBus, value);
        }

        public ShiguShopApplyExample.Criteria andMainBusGreaterThan(String value) {
            return greaterThan(mainBus, value);
        }

        public ShiguShopApplyExample.Criteria andMainBusGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(mainBus, value);
        }

        public ShiguShopApplyExample.Criteria andMainBusLessThan(String value) {
            return lessThan(mainBus, value);
        }

        public ShiguShopApplyExample.Criteria andMainBusLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(mainBus, value);
        }

        public ShiguShopApplyExample.Criteria andMainBusLike(String value) {
            return like(mainBus, value);
        }

        public ShiguShopApplyExample.Criteria andMainBusNotLike(String value) {
            return notLike(mainBus, value);
        }

        public ShiguShopApplyExample.Criteria andMainBusIn(List<String> values) {
            return in(mainBus, values);
        }

        public ShiguShopApplyExample.Criteria andMainBusNotIn(List<String> values) {
            return notIn(mainBus, values);
        }

        public ShiguShopApplyExample.Criteria andMainBusBetween(String value1, String value2) {
            return between(mainBus, value1, value2);
        }

        public ShiguShopApplyExample.Criteria andMainBusNotBetween(String value1, String value2) {
            return notBetween(mainBus, value1, value2);
        }
        public ShiguShopApplyExample.Criteria andCanExamineIsNull() {
            return isNull(canExamine);
        }

        public ShiguShopApplyExample.Criteria andCanExamineIsNotNull() {
            return isNotNull(canExamine);
        }

        public ShiguShopApplyExample.Criteria andCanExamineEqualTo(Integer value) {
            return equalTo(canExamine, value);
        }

        public ShiguShopApplyExample.Criteria andCanExamineNotEqualTo(Integer value) {
            return notEqualTo(canExamine, value);
        }

        public ShiguShopApplyExample.Criteria andCanExamineGreaterThan(Integer value) {
            return greaterThan(canExamine, value);
        }

        public ShiguShopApplyExample.Criteria andCanExamineGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(canExamine, value);
        }

        public ShiguShopApplyExample.Criteria andCanExamineLessThan(Integer value) {
            return lessThan(canExamine, value);
        }

        public ShiguShopApplyExample.Criteria andCanExamineLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(canExamine, value);
        }

        public ShiguShopApplyExample.Criteria andCanExamineIn(List<Integer> values) {
            return in(canExamine, values);
        }

        public ShiguShopApplyExample.Criteria andCanExamineNotIn(List<Integer> values) {
            return notIn(canExamine, values);
        }

        public ShiguShopApplyExample.Criteria andCanExamineBetween(Integer value1, Integer value2) {
            return between(canExamine, value1, value2);
        }

        public ShiguShopApplyExample.Criteria andCanExamineNotBetween(Integer value1, Integer value2) {
            return notBetween(canExamine, value1, value2);
        }
        public ShiguShopApplyExample.Criteria andTbuserIdIsNull() {
            return isNull(tbuserId);
        }

        public ShiguShopApplyExample.Criteria andTbuserIdIsNotNull() {
            return isNotNull(tbuserId);
        }

        public ShiguShopApplyExample.Criteria andTbuserIdEqualTo(String value) {
            return equalTo(tbuserId, value);
        }

        public ShiguShopApplyExample.Criteria andTbuserIdNotEqualTo(String value) {
            return notEqualTo(tbuserId, value);
        }

        public ShiguShopApplyExample.Criteria andTbuserIdGreaterThan(String value) {
            return greaterThan(tbuserId, value);
        }

        public ShiguShopApplyExample.Criteria andTbuserIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(tbuserId, value);
        }

        public ShiguShopApplyExample.Criteria andTbuserIdLessThan(String value) {
            return lessThan(tbuserId, value);
        }

        public ShiguShopApplyExample.Criteria andTbuserIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(tbuserId, value);
        }

        public ShiguShopApplyExample.Criteria andTbuserIdLike(String value) {
            return like(tbuserId, value);
        }

        public ShiguShopApplyExample.Criteria andTbuserIdNotLike(String value) {
            return notLike(tbuserId, value);
        }

        public ShiguShopApplyExample.Criteria andTbuserIdIn(List<String> values) {
            return in(tbuserId, values);
        }

        public ShiguShopApplyExample.Criteria andTbuserIdNotIn(List<String> values) {
            return notIn(tbuserId, values);
        }

        public ShiguShopApplyExample.Criteria andTbuserIdBetween(String value1, String value2) {
            return between(tbuserId, value1, value2);
        }

        public ShiguShopApplyExample.Criteria andTbuserIdNotBetween(String value1, String value2) {
            return notBetween(tbuserId, value1, value2);
        }
        public ShiguShopApplyExample.Criteria andShopNumIsNull() {
            return isNull(shopNum);
        }

        public ShiguShopApplyExample.Criteria andShopNumIsNotNull() {
            return isNotNull(shopNum);
        }

        public ShiguShopApplyExample.Criteria andShopNumEqualTo(String value) {
            return equalTo(shopNum, value);
        }

        public ShiguShopApplyExample.Criteria andShopNumNotEqualTo(String value) {
            return notEqualTo(shopNum, value);
        }

        public ShiguShopApplyExample.Criteria andShopNumGreaterThan(String value) {
            return greaterThan(shopNum, value);
        }

        public ShiguShopApplyExample.Criteria andShopNumGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(shopNum, value);
        }

        public ShiguShopApplyExample.Criteria andShopNumLessThan(String value) {
            return lessThan(shopNum, value);
        }

        public ShiguShopApplyExample.Criteria andShopNumLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(shopNum, value);
        }

        public ShiguShopApplyExample.Criteria andShopNumLike(String value) {
            return like(shopNum, value);
        }

        public ShiguShopApplyExample.Criteria andShopNumNotLike(String value) {
            return notLike(shopNum, value);
        }

        public ShiguShopApplyExample.Criteria andShopNumIn(List<String> values) {
            return in(shopNum, values);
        }

        public ShiguShopApplyExample.Criteria andShopNumNotIn(List<String> values) {
            return notIn(shopNum, values);
        }

        public ShiguShopApplyExample.Criteria andShopNumBetween(String value1, String value2) {
            return between(shopNum, value1, value2);
        }

        public ShiguShopApplyExample.Criteria andShopNumNotBetween(String value1, String value2) {
            return notBetween(shopNum, value1, value2);
        }
        public ShiguShopApplyExample.Criteria andIpIsNull() {
            return isNull(ip);
        }

        public ShiguShopApplyExample.Criteria andIpIsNotNull() {
            return isNotNull(ip);
        }

        public ShiguShopApplyExample.Criteria andIpEqualTo(String value) {
            return equalTo(ip, value);
        }

        public ShiguShopApplyExample.Criteria andIpNotEqualTo(String value) {
            return notEqualTo(ip, value);
        }

        public ShiguShopApplyExample.Criteria andIpGreaterThan(String value) {
            return greaterThan(ip, value);
        }

        public ShiguShopApplyExample.Criteria andIpGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(ip, value);
        }

        public ShiguShopApplyExample.Criteria andIpLessThan(String value) {
            return lessThan(ip, value);
        }

        public ShiguShopApplyExample.Criteria andIpLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(ip, value);
        }

        public ShiguShopApplyExample.Criteria andIpLike(String value) {
            return like(ip, value);
        }

        public ShiguShopApplyExample.Criteria andIpNotLike(String value) {
            return notLike(ip, value);
        }

        public ShiguShopApplyExample.Criteria andIpIn(List<String> values) {
            return in(ip, values);
        }

        public ShiguShopApplyExample.Criteria andIpNotIn(List<String> values) {
            return notIn(ip, values);
        }

        public ShiguShopApplyExample.Criteria andIpBetween(String value1, String value2) {
            return between(ip, value1, value2);
        }

        public ShiguShopApplyExample.Criteria andIpNotBetween(String value1, String value2) {
            return notBetween(ip, value1, value2);
        }
        public ShiguShopApplyExample.Criteria andTbshopIdIsNull() {
            return isNull(tbshopId);
        }

        public ShiguShopApplyExample.Criteria andTbshopIdIsNotNull() {
            return isNotNull(tbshopId);
        }

        public ShiguShopApplyExample.Criteria andTbshopIdEqualTo(String value) {
            return equalTo(tbshopId, value);
        }

        public ShiguShopApplyExample.Criteria andTbshopIdNotEqualTo(String value) {
            return notEqualTo(tbshopId, value);
        }

        public ShiguShopApplyExample.Criteria andTbshopIdGreaterThan(String value) {
            return greaterThan(tbshopId, value);
        }

        public ShiguShopApplyExample.Criteria andTbshopIdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(tbshopId, value);
        }

        public ShiguShopApplyExample.Criteria andTbshopIdLessThan(String value) {
            return lessThan(tbshopId, value);
        }

        public ShiguShopApplyExample.Criteria andTbshopIdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(tbshopId, value);
        }

        public ShiguShopApplyExample.Criteria andTbshopIdLike(String value) {
            return like(tbshopId, value);
        }

        public ShiguShopApplyExample.Criteria andTbshopIdNotLike(String value) {
            return notLike(tbshopId, value);
        }

        public ShiguShopApplyExample.Criteria andTbshopIdIn(List<String> values) {
            return in(tbshopId, values);
        }

        public ShiguShopApplyExample.Criteria andTbshopIdNotIn(List<String> values) {
            return notIn(tbshopId, values);
        }

        public ShiguShopApplyExample.Criteria andTbshopIdBetween(String value1, String value2) {
            return between(tbshopId, value1, value2);
        }

        public ShiguShopApplyExample.Criteria andTbshopIdNotBetween(String value1, String value2) {
            return notBetween(tbshopId, value1, value2);
        }
        public ShiguShopApplyExample.Criteria andRuzhuIdIsNull() {
            return isNull(ruzhuId);
        }

        public ShiguShopApplyExample.Criteria andRuzhuIdIsNotNull() {
            return isNotNull(ruzhuId);
        }

        public ShiguShopApplyExample.Criteria andRuzhuIdEqualTo(Long value) {
            return equalTo(ruzhuId, value);
        }

        public ShiguShopApplyExample.Criteria andRuzhuIdNotEqualTo(Long value) {
            return notEqualTo(ruzhuId, value);
        }

        public ShiguShopApplyExample.Criteria andRuzhuIdGreaterThan(Long value) {
            return greaterThan(ruzhuId, value);
        }

        public ShiguShopApplyExample.Criteria andRuzhuIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(ruzhuId, value);
        }

        public ShiguShopApplyExample.Criteria andRuzhuIdLessThan(Long value) {
            return lessThan(ruzhuId, value);
        }

        public ShiguShopApplyExample.Criteria andRuzhuIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(ruzhuId, value);
        }

        public ShiguShopApplyExample.Criteria andRuzhuIdIn(List<Long> values) {
            return in(ruzhuId, values);
        }

        public ShiguShopApplyExample.Criteria andRuzhuIdNotIn(List<Long> values) {
            return notIn(ruzhuId, values);
        }

        public ShiguShopApplyExample.Criteria andRuzhuIdBetween(Long value1, Long value2) {
            return between(ruzhuId, value1, value2);
        }

        public ShiguShopApplyExample.Criteria andRuzhuIdNotBetween(Long value1, Long value2) {
            return notBetween(ruzhuId, value1, value2);
        }
        public ShiguShopApplyExample.Criteria andTelephoneIsNull() {
            return isNull(telephone);
        }

        public ShiguShopApplyExample.Criteria andTelephoneIsNotNull() {
            return isNotNull(telephone);
        }

        public ShiguShopApplyExample.Criteria andTelephoneEqualTo(String value) {
            return equalTo(telephone, value);
        }

        public ShiguShopApplyExample.Criteria andTelephoneNotEqualTo(String value) {
            return notEqualTo(telephone, value);
        }

        public ShiguShopApplyExample.Criteria andTelephoneGreaterThan(String value) {
            return greaterThan(telephone, value);
        }

        public ShiguShopApplyExample.Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(telephone, value);
        }

        public ShiguShopApplyExample.Criteria andTelephoneLessThan(String value) {
            return lessThan(telephone, value);
        }

        public ShiguShopApplyExample.Criteria andTelephoneLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(telephone, value);
        }

        public ShiguShopApplyExample.Criteria andTelephoneLike(String value) {
            return like(telephone, value);
        }

        public ShiguShopApplyExample.Criteria andTelephoneNotLike(String value) {
            return notLike(telephone, value);
        }

        public ShiguShopApplyExample.Criteria andTelephoneIn(List<String> values) {
            return in(telephone, values);
        }

        public ShiguShopApplyExample.Criteria andTelephoneNotIn(List<String> values) {
            return notIn(telephone, values);
        }

        public ShiguShopApplyExample.Criteria andTelephoneBetween(String value1, String value2) {
            return between(telephone, value1, value2);
        }

        public ShiguShopApplyExample.Criteria andTelephoneNotBetween(String value1, String value2) {
            return notBetween(telephone, value1, value2);
        }
        public ShiguShopApplyExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public ShiguShopApplyExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public ShiguShopApplyExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public ShiguShopApplyExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public ShiguShopApplyExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public ShiguShopApplyExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public ShiguShopApplyExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public ShiguShopApplyExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public ShiguShopApplyExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public ShiguShopApplyExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public ShiguShopApplyExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public ShiguShopApplyExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public ShiguShopApplyExample.Criteria andTbNickIsNull() {
            return isNull(tbNick);
        }

        public ShiguShopApplyExample.Criteria andTbNickIsNotNull() {
            return isNotNull(tbNick);
        }

        public ShiguShopApplyExample.Criteria andTbNickEqualTo(String value) {
            return equalTo(tbNick, value);
        }

        public ShiguShopApplyExample.Criteria andTbNickNotEqualTo(String value) {
            return notEqualTo(tbNick, value);
        }

        public ShiguShopApplyExample.Criteria andTbNickGreaterThan(String value) {
            return greaterThan(tbNick, value);
        }

        public ShiguShopApplyExample.Criteria andTbNickGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(tbNick, value);
        }

        public ShiguShopApplyExample.Criteria andTbNickLessThan(String value) {
            return lessThan(tbNick, value);
        }

        public ShiguShopApplyExample.Criteria andTbNickLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(tbNick, value);
        }

        public ShiguShopApplyExample.Criteria andTbNickLike(String value) {
            return like(tbNick, value);
        }

        public ShiguShopApplyExample.Criteria andTbNickNotLike(String value) {
            return notLike(tbNick, value);
        }

        public ShiguShopApplyExample.Criteria andTbNickIn(List<String> values) {
            return in(tbNick, values);
        }

        public ShiguShopApplyExample.Criteria andTbNickNotIn(List<String> values) {
            return notIn(tbNick, values);
        }

        public ShiguShopApplyExample.Criteria andTbNickBetween(String value1, String value2) {
            return between(tbNick, value1, value2);
        }

        public ShiguShopApplyExample.Criteria andTbNickNotBetween(String value1, String value2) {
            return notBetween(tbNick, value1, value2);
        }
        public ShiguShopApplyExample.Criteria andMarketIdIsNull() {
            return isNull(marketId);
        }

        public ShiguShopApplyExample.Criteria andMarketIdIsNotNull() {
            return isNotNull(marketId);
        }

        public ShiguShopApplyExample.Criteria andMarketIdEqualTo(Long value) {
            return equalTo(marketId, value);
        }

        public ShiguShopApplyExample.Criteria andMarketIdNotEqualTo(Long value) {
            return notEqualTo(marketId, value);
        }

        public ShiguShopApplyExample.Criteria andMarketIdGreaterThan(Long value) {
            return greaterThan(marketId, value);
        }

        public ShiguShopApplyExample.Criteria andMarketIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(marketId, value);
        }

        public ShiguShopApplyExample.Criteria andMarketIdLessThan(Long value) {
            return lessThan(marketId, value);
        }

        public ShiguShopApplyExample.Criteria andMarketIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(marketId, value);
        }

        public ShiguShopApplyExample.Criteria andMarketIdIn(List<Long> values) {
            return in(marketId, values);
        }

        public ShiguShopApplyExample.Criteria andMarketIdNotIn(List<Long> values) {
            return notIn(marketId, values);
        }

        public ShiguShopApplyExample.Criteria andMarketIdBetween(Long value1, Long value2) {
            return between(marketId, value1, value2);
        }

        public ShiguShopApplyExample.Criteria andMarketIdNotBetween(Long value1, Long value2) {
            return notBetween(marketId, value1, value2);
        }
        public ShiguShopApplyExample.Criteria andTagsIsNull() {
            return isNull(tags);
        }

        public ShiguShopApplyExample.Criteria andTagsIsNotNull() {
            return isNotNull(tags);
        }

        public ShiguShopApplyExample.Criteria andTagsEqualTo(String value) {
            return equalTo(tags, value);
        }

        public ShiguShopApplyExample.Criteria andTagsNotEqualTo(String value) {
            return notEqualTo(tags, value);
        }

        public ShiguShopApplyExample.Criteria andTagsGreaterThan(String value) {
            return greaterThan(tags, value);
        }

        public ShiguShopApplyExample.Criteria andTagsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(tags, value);
        }

        public ShiguShopApplyExample.Criteria andTagsLessThan(String value) {
            return lessThan(tags, value);
        }

        public ShiguShopApplyExample.Criteria andTagsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(tags, value);
        }

        public ShiguShopApplyExample.Criteria andTagsLike(String value) {
            return like(tags, value);
        }

        public ShiguShopApplyExample.Criteria andTagsNotLike(String value) {
            return notLike(tags, value);
        }

        public ShiguShopApplyExample.Criteria andTagsIn(List<String> values) {
            return in(tags, values);
        }

        public ShiguShopApplyExample.Criteria andTagsNotIn(List<String> values) {
            return notIn(tags, values);
        }

        public ShiguShopApplyExample.Criteria andTagsBetween(String value1, String value2) {
            return between(tags, value1, value2);
        }

        public ShiguShopApplyExample.Criteria andTagsNotBetween(String value1, String value2) {
            return notBetween(tags, value1, value2);
        }
        public ShiguShopApplyExample.Criteria andImAliwwIsNull() {
            return isNull(imAliww);
        }

        public ShiguShopApplyExample.Criteria andImAliwwIsNotNull() {
            return isNotNull(imAliww);
        }

        public ShiguShopApplyExample.Criteria andImAliwwEqualTo(String value) {
            return equalTo(imAliww, value);
        }

        public ShiguShopApplyExample.Criteria andImAliwwNotEqualTo(String value) {
            return notEqualTo(imAliww, value);
        }

        public ShiguShopApplyExample.Criteria andImAliwwGreaterThan(String value) {
            return greaterThan(imAliww, value);
        }

        public ShiguShopApplyExample.Criteria andImAliwwGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(imAliww, value);
        }

        public ShiguShopApplyExample.Criteria andImAliwwLessThan(String value) {
            return lessThan(imAliww, value);
        }

        public ShiguShopApplyExample.Criteria andImAliwwLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(imAliww, value);
        }

        public ShiguShopApplyExample.Criteria andImAliwwLike(String value) {
            return like(imAliww, value);
        }

        public ShiguShopApplyExample.Criteria andImAliwwNotLike(String value) {
            return notLike(imAliww, value);
        }

        public ShiguShopApplyExample.Criteria andImAliwwIn(List<String> values) {
            return in(imAliww, values);
        }

        public ShiguShopApplyExample.Criteria andImAliwwNotIn(List<String> values) {
            return notIn(imAliww, values);
        }

        public ShiguShopApplyExample.Criteria andImAliwwBetween(String value1, String value2) {
            return between(imAliww, value1, value2);
        }

        public ShiguShopApplyExample.Criteria andImAliwwNotBetween(String value1, String value2) {
            return notBetween(imAliww, value1, value2);
        }
        public ShiguShopApplyExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public ShiguShopApplyExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public ShiguShopApplyExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public ShiguShopApplyExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public ShiguShopApplyExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public ShiguShopApplyExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public ShiguShopApplyExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public ShiguShopApplyExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public ShiguShopApplyExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public ShiguShopApplyExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public ShiguShopApplyExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public ShiguShopApplyExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public ShiguShopApplyExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public ShiguShopApplyExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public ShiguShopApplyExample.Criteria andFloorIdIsNull() {
            return isNull(floorId);
        }

        public ShiguShopApplyExample.Criteria andFloorIdIsNotNull() {
            return isNotNull(floorId);
        }

        public ShiguShopApplyExample.Criteria andFloorIdEqualTo(Long value) {
            return equalTo(floorId, value);
        }

        public ShiguShopApplyExample.Criteria andFloorIdNotEqualTo(Long value) {
            return notEqualTo(floorId, value);
        }

        public ShiguShopApplyExample.Criteria andFloorIdGreaterThan(Long value) {
            return greaterThan(floorId, value);
        }

        public ShiguShopApplyExample.Criteria andFloorIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(floorId, value);
        }

        public ShiguShopApplyExample.Criteria andFloorIdLessThan(Long value) {
            return lessThan(floorId, value);
        }

        public ShiguShopApplyExample.Criteria andFloorIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(floorId, value);
        }

        public ShiguShopApplyExample.Criteria andFloorIdIn(List<Long> values) {
            return in(floorId, values);
        }

        public ShiguShopApplyExample.Criteria andFloorIdNotIn(List<Long> values) {
            return notIn(floorId, values);
        }

        public ShiguShopApplyExample.Criteria andFloorIdBetween(Long value1, Long value2) {
            return between(floorId, value1, value2);
        }

        public ShiguShopApplyExample.Criteria andFloorIdNotBetween(Long value1, Long value2) {
            return notBetween(floorId, value1, value2);
        }
        public ShiguShopApplyExample.Criteria andTbUrlIsNull() {
            return isNull(tbUrl);
        }

        public ShiguShopApplyExample.Criteria andTbUrlIsNotNull() {
            return isNotNull(tbUrl);
        }

        public ShiguShopApplyExample.Criteria andTbUrlEqualTo(String value) {
            return equalTo(tbUrl, value);
        }

        public ShiguShopApplyExample.Criteria andTbUrlNotEqualTo(String value) {
            return notEqualTo(tbUrl, value);
        }

        public ShiguShopApplyExample.Criteria andTbUrlGreaterThan(String value) {
            return greaterThan(tbUrl, value);
        }

        public ShiguShopApplyExample.Criteria andTbUrlGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(tbUrl, value);
        }

        public ShiguShopApplyExample.Criteria andTbUrlLessThan(String value) {
            return lessThan(tbUrl, value);
        }

        public ShiguShopApplyExample.Criteria andTbUrlLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(tbUrl, value);
        }

        public ShiguShopApplyExample.Criteria andTbUrlLike(String value) {
            return like(tbUrl, value);
        }

        public ShiguShopApplyExample.Criteria andTbUrlNotLike(String value) {
            return notLike(tbUrl, value);
        }

        public ShiguShopApplyExample.Criteria andTbUrlIn(List<String> values) {
            return in(tbUrl, values);
        }

        public ShiguShopApplyExample.Criteria andTbUrlNotIn(List<String> values) {
            return notIn(tbUrl, values);
        }

        public ShiguShopApplyExample.Criteria andTbUrlBetween(String value1, String value2) {
            return between(tbUrl, value1, value2);
        }

        public ShiguShopApplyExample.Criteria andTbUrlNotBetween(String value1, String value2) {
            return notBetween(tbUrl, value1, value2);
        }
        public ShiguShopApplyExample.Criteria andImWxIsNull() {
            return isNull(imWx);
        }

        public ShiguShopApplyExample.Criteria andImWxIsNotNull() {
            return isNotNull(imWx);
        }

        public ShiguShopApplyExample.Criteria andImWxEqualTo(String value) {
            return equalTo(imWx, value);
        }

        public ShiguShopApplyExample.Criteria andImWxNotEqualTo(String value) {
            return notEqualTo(imWx, value);
        }

        public ShiguShopApplyExample.Criteria andImWxGreaterThan(String value) {
            return greaterThan(imWx, value);
        }

        public ShiguShopApplyExample.Criteria andImWxGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(imWx, value);
        }

        public ShiguShopApplyExample.Criteria andImWxLessThan(String value) {
            return lessThan(imWx, value);
        }

        public ShiguShopApplyExample.Criteria andImWxLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(imWx, value);
        }

        public ShiguShopApplyExample.Criteria andImWxLike(String value) {
            return like(imWx, value);
        }

        public ShiguShopApplyExample.Criteria andImWxNotLike(String value) {
            return notLike(imWx, value);
        }

        public ShiguShopApplyExample.Criteria andImWxIn(List<String> values) {
            return in(imWx, values);
        }

        public ShiguShopApplyExample.Criteria andImWxNotIn(List<String> values) {
            return notIn(imWx, values);
        }

        public ShiguShopApplyExample.Criteria andImWxBetween(String value1, String value2) {
            return between(imWx, value1, value2);
        }

        public ShiguShopApplyExample.Criteria andImWxNotBetween(String value1, String value2) {
            return notBetween(imWx, value1, value2);
        }
        public ShiguShopApplyExample.Criteria andImQqIsNull() {
            return isNull(imQq);
        }

        public ShiguShopApplyExample.Criteria andImQqIsNotNull() {
            return isNotNull(imQq);
        }

        public ShiguShopApplyExample.Criteria andImQqEqualTo(String value) {
            return equalTo(imQq, value);
        }

        public ShiguShopApplyExample.Criteria andImQqNotEqualTo(String value) {
            return notEqualTo(imQq, value);
        }

        public ShiguShopApplyExample.Criteria andImQqGreaterThan(String value) {
            return greaterThan(imQq, value);
        }

        public ShiguShopApplyExample.Criteria andImQqGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(imQq, value);
        }

        public ShiguShopApplyExample.Criteria andImQqLessThan(String value) {
            return lessThan(imQq, value);
        }

        public ShiguShopApplyExample.Criteria andImQqLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(imQq, value);
        }

        public ShiguShopApplyExample.Criteria andImQqLike(String value) {
            return like(imQq, value);
        }

        public ShiguShopApplyExample.Criteria andImQqNotLike(String value) {
            return notLike(imQq, value);
        }

        public ShiguShopApplyExample.Criteria andImQqIn(List<String> values) {
            return in(imQq, values);
        }

        public ShiguShopApplyExample.Criteria andImQqNotIn(List<String> values) {
            return notIn(imQq, values);
        }

        public ShiguShopApplyExample.Criteria andImQqBetween(String value1, String value2) {
            return between(imQq, value1, value2);
        }

        public ShiguShopApplyExample.Criteria andImQqNotBetween(String value1, String value2) {
            return notBetween(imQq, value1, value2);
        }
        public ShiguShopApplyExample.Criteria andApplyTimeIsNull() {
            return isNull(applyTime);
        }

        public ShiguShopApplyExample.Criteria andApplyTimeIsNotNull() {
            return isNotNull(applyTime);
        }

        public ShiguShopApplyExample.Criteria andApplyTimeEqualTo(Date value) {
            return equalTo(applyTime, value);
        }

        public ShiguShopApplyExample.Criteria andApplyTimeNotEqualTo(Date value) {
            return notEqualTo(applyTime, value);
        }

        public ShiguShopApplyExample.Criteria andApplyTimeGreaterThan(Date value) {
            return greaterThan(applyTime, value);
        }

        public ShiguShopApplyExample.Criteria andApplyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(applyTime, value);
        }

        public ShiguShopApplyExample.Criteria andApplyTimeLessThan(Date value) {
            return lessThan(applyTime, value);
        }

        public ShiguShopApplyExample.Criteria andApplyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(applyTime, value);
        }

        public ShiguShopApplyExample.Criteria andApplyTimeIn(List<Date> values) {
            return in(applyTime, values);
        }

        public ShiguShopApplyExample.Criteria andApplyTimeNotIn(List<Date> values) {
            return notIn(applyTime, values);
        }

        public ShiguShopApplyExample.Criteria andApplyTimeBetween(Date value1, Date value2) {
            return between(applyTime, value1, value2);
        }

        public ShiguShopApplyExample.Criteria andApplyTimeNotBetween(Date value1, Date value2) {
            return notBetween(applyTime, value1, value2);
        }
        public ShiguShopApplyExample.Criteria andApplyStatusIsNull() {
            return isNull(applyStatus);
        }

        public ShiguShopApplyExample.Criteria andApplyStatusIsNotNull() {
            return isNotNull(applyStatus);
        }

        public ShiguShopApplyExample.Criteria andApplyStatusEqualTo(Integer value) {
            return equalTo(applyStatus, value);
        }

        public ShiguShopApplyExample.Criteria andApplyStatusNotEqualTo(Integer value) {
            return notEqualTo(applyStatus, value);
        }

        public ShiguShopApplyExample.Criteria andApplyStatusGreaterThan(Integer value) {
            return greaterThan(applyStatus, value);
        }

        public ShiguShopApplyExample.Criteria andApplyStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(applyStatus, value);
        }

        public ShiguShopApplyExample.Criteria andApplyStatusLessThan(Integer value) {
            return lessThan(applyStatus, value);
        }

        public ShiguShopApplyExample.Criteria andApplyStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(applyStatus, value);
        }

        public ShiguShopApplyExample.Criteria andApplyStatusIn(List<Integer> values) {
            return in(applyStatus, values);
        }

        public ShiguShopApplyExample.Criteria andApplyStatusNotIn(List<Integer> values) {
            return notIn(applyStatus, values);
        }

        public ShiguShopApplyExample.Criteria andApplyStatusBetween(Integer value1, Integer value2) {
            return between(applyStatus, value1, value2);
        }

        public ShiguShopApplyExample.Criteria andApplyStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(applyStatus, value1, value2);
        }
        public ShiguShopApplyExample.Criteria andEmailIsNull() {
            return isNull(email);
        }

        public ShiguShopApplyExample.Criteria andEmailIsNotNull() {
            return isNotNull(email);
        }

        public ShiguShopApplyExample.Criteria andEmailEqualTo(String value) {
            return equalTo(email, value);
        }

        public ShiguShopApplyExample.Criteria andEmailNotEqualTo(String value) {
            return notEqualTo(email, value);
        }

        public ShiguShopApplyExample.Criteria andEmailGreaterThan(String value) {
            return greaterThan(email, value);
        }

        public ShiguShopApplyExample.Criteria andEmailGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(email, value);
        }

        public ShiguShopApplyExample.Criteria andEmailLessThan(String value) {
            return lessThan(email, value);
        }

        public ShiguShopApplyExample.Criteria andEmailLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(email, value);
        }

        public ShiguShopApplyExample.Criteria andEmailLike(String value) {
            return like(email, value);
        }

        public ShiguShopApplyExample.Criteria andEmailNotLike(String value) {
            return notLike(email, value);
        }

        public ShiguShopApplyExample.Criteria andEmailIn(List<String> values) {
            return in(email, values);
        }

        public ShiguShopApplyExample.Criteria andEmailNotIn(List<String> values) {
            return notIn(email, values);
        }

        public ShiguShopApplyExample.Criteria andEmailBetween(String value1, String value2) {
            return between(email, value1, value2);
        }

        public ShiguShopApplyExample.Criteria andEmailNotBetween(String value1, String value2) {
            return notBetween(email, value1, value2);
        }
        public ShiguShopApplyExample.Criteria andRefuseReasonIsNull() {
            return isNull(refuseReason);
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonIsNotNull() {
            return isNotNull(refuseReason);
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonEqualTo(String value) {
            return equalTo(refuseReason, value);
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonNotEqualTo(String value) {
            return notEqualTo(refuseReason, value);
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonGreaterThan(String value) {
            return greaterThan(refuseReason, value);
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(refuseReason, value);
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonLessThan(String value) {
            return lessThan(refuseReason, value);
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(refuseReason, value);
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonLike(String value) {
            return like(refuseReason, value);
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonNotLike(String value) {
            return notLike(refuseReason, value);
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonIn(List<String> values) {
            return in(refuseReason, values);
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonNotIn(List<String> values) {
            return notIn(refuseReason, values);
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonBetween(String value1, String value2) {
            return between(refuseReason, value1, value2);
        }

        public ShiguShopApplyExample.Criteria andRefuseReasonNotBetween(String value1, String value2) {
            return notBetween(refuseReason, value1, value2);
        }
    }
}
