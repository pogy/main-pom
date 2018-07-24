package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguGoodsTaoRelation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class ShiguGoodsTaoRelationExample extends SgExample<ShiguGoodsTaoRelationExample.Criteria> {
    public static final Class<ShiguGoodsTaoRelation> beanClass = ShiguGoodsTaoRelation.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn webSite;
    public static EntityColumn goodsId;
    public static EntityColumn numIid;
    public static EntityColumn relationId;
    public static EntityColumn userId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        webSite = listMap.get("webSite");
        goodsId = listMap.get("goodsId");
        numIid = listMap.get("numIid");
        relationId = listMap.get("relationId");
        userId = listMap.get("userId");
        }

    public ShiguGoodsTaoRelationExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguGoodsTaoRelationExample.Criteria createCriteriaInternal() {
        return new ShiguGoodsTaoRelationExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public ShiguGoodsTaoRelationExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdIsNull() {
            return isNull(goodsId);
        }

        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdIsNotNull() {
            return isNotNull(goodsId);
        }

        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdEqualTo(Long value) {
            return equalTo(goodsId, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdNotEqualTo(Long value) {
            return notEqualTo(goodsId, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdGreaterThan(Long value) {
            return greaterThan(goodsId, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsId, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdLessThan(Long value) {
            return lessThan(goodsId, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsId, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdIn(List<Long> values) {
            return in(goodsId, values);
        }

        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdNotIn(List<Long> values) {
            return notIn(goodsId, values);
        }

        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdBetween(Long value1, Long value2) {
            return between(goodsId, value1, value2);
        }

        public ShiguGoodsTaoRelationExample.Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsId, value1, value2);
        }
        public ShiguGoodsTaoRelationExample.Criteria andNumIidIsNull() {
            return isNull(numIid);
        }

        public ShiguGoodsTaoRelationExample.Criteria andNumIidIsNotNull() {
            return isNotNull(numIid);
        }

        public ShiguGoodsTaoRelationExample.Criteria andNumIidEqualTo(Long value) {
            return equalTo(numIid, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andNumIidNotEqualTo(Long value) {
            return notEqualTo(numIid, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andNumIidGreaterThan(Long value) {
            return greaterThan(numIid, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andNumIidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(numIid, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andNumIidLessThan(Long value) {
            return lessThan(numIid, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andNumIidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(numIid, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andNumIidIn(List<Long> values) {
            return in(numIid, values);
        }

        public ShiguGoodsTaoRelationExample.Criteria andNumIidNotIn(List<Long> values) {
            return notIn(numIid, values);
        }

        public ShiguGoodsTaoRelationExample.Criteria andNumIidBetween(Long value1, Long value2) {
            return between(numIid, value1, value2);
        }

        public ShiguGoodsTaoRelationExample.Criteria andNumIidNotBetween(Long value1, Long value2) {
            return notBetween(numIid, value1, value2);
        }
        public ShiguGoodsTaoRelationExample.Criteria andRelationIdIsNull() {
            return isNull(relationId);
        }

        public ShiguGoodsTaoRelationExample.Criteria andRelationIdIsNotNull() {
            return isNotNull(relationId);
        }

        public ShiguGoodsTaoRelationExample.Criteria andRelationIdEqualTo(Long value) {
            return equalTo(relationId, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andRelationIdNotEqualTo(Long value) {
            return notEqualTo(relationId, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andRelationIdGreaterThan(Long value) {
            return greaterThan(relationId, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andRelationIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(relationId, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andRelationIdLessThan(Long value) {
            return lessThan(relationId, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andRelationIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(relationId, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andRelationIdIn(List<Long> values) {
            return in(relationId, values);
        }

        public ShiguGoodsTaoRelationExample.Criteria andRelationIdNotIn(List<Long> values) {
            return notIn(relationId, values);
        }

        public ShiguGoodsTaoRelationExample.Criteria andRelationIdBetween(Long value1, Long value2) {
            return between(relationId, value1, value2);
        }

        public ShiguGoodsTaoRelationExample.Criteria andRelationIdNotBetween(Long value1, Long value2) {
            return notBetween(relationId, value1, value2);
        }
        public ShiguGoodsTaoRelationExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public ShiguGoodsTaoRelationExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public ShiguGoodsTaoRelationExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public ShiguGoodsTaoRelationExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public ShiguGoodsTaoRelationExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public ShiguGoodsTaoRelationExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public ShiguGoodsTaoRelationExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
    }
}