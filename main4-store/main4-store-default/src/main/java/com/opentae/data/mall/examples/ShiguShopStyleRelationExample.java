package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguShopStyleRelation;

import java.util.*;
public class ShiguShopStyleRelationExample extends SgExample<ShiguShopStyleRelationExample.Criteria> {
    public static final Class<ShiguShopStyleRelation> beanClass = ShiguShopStyleRelation.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn webSite;
    public static EntityColumn gmtModify;
    public static EntityColumn shopParentStyleIds;
    public static EntityColumn shopId;
    public static EntityColumn id;
    public static EntityColumn gmtCreate;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        webSite = listMap.get("webSite");
        gmtModify = listMap.get("gmtModify");
        shopParentStyleIds = listMap.get("shopParentStyleIds");
        shopId = listMap.get("shopId");
        id = listMap.get("id");
        gmtCreate = listMap.get("gmtCreate");
        }

    public ShiguShopStyleRelationExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguShopStyleRelationExample.Criteria createCriteriaInternal() {
        return new ShiguShopStyleRelationExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguShopStyleRelationExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public ShiguShopStyleRelationExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public ShiguShopStyleRelationExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public ShiguShopStyleRelationExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public ShiguShopStyleRelationExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public ShiguShopStyleRelationExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public ShiguShopStyleRelationExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public ShiguShopStyleRelationExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public ShiguShopStyleRelationExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public ShiguShopStyleRelationExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public ShiguShopStyleRelationExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public ShiguShopStyleRelationExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public ShiguShopStyleRelationExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public ShiguShopStyleRelationExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public ShiguShopStyleRelationExample.Criteria andGmtModifyIsNull() {
            return isNull(gmtModify);
        }

        public ShiguShopStyleRelationExample.Criteria andGmtModifyIsNotNull() {
            return isNotNull(gmtModify);
        }

        public ShiguShopStyleRelationExample.Criteria andGmtModifyEqualTo(Date value) {
            return equalTo(gmtModify, value);
        }

        public ShiguShopStyleRelationExample.Criteria andGmtModifyNotEqualTo(Date value) {
            return notEqualTo(gmtModify, value);
        }

        public ShiguShopStyleRelationExample.Criteria andGmtModifyGreaterThan(Date value) {
            return greaterThan(gmtModify, value);
        }

        public ShiguShopStyleRelationExample.Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtModify, value);
        }

        public ShiguShopStyleRelationExample.Criteria andGmtModifyLessThan(Date value) {
            return lessThan(gmtModify, value);
        }

        public ShiguShopStyleRelationExample.Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtModify, value);
        }

        public ShiguShopStyleRelationExample.Criteria andGmtModifyIn(List<Date> values) {
            return in(gmtModify, values);
        }

        public ShiguShopStyleRelationExample.Criteria andGmtModifyNotIn(List<Date> values) {
            return notIn(gmtModify, values);
        }

        public ShiguShopStyleRelationExample.Criteria andGmtModifyBetween(Date value1, Date value2) {
            return between(gmtModify, value1, value2);
        }

        public ShiguShopStyleRelationExample.Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            return notBetween(gmtModify, value1, value2);
        }
        public ShiguShopStyleRelationExample.Criteria andShopParentStyleIdsIsNull() {
            return isNull(shopParentStyleIds);
        }

        public ShiguShopStyleRelationExample.Criteria andShopParentStyleIdsIsNotNull() {
            return isNotNull(shopParentStyleIds);
        }

        public ShiguShopStyleRelationExample.Criteria andShopParentStyleIdsEqualTo(String value) {
            return equalTo(shopParentStyleIds, value);
        }

        public ShiguShopStyleRelationExample.Criteria andShopParentStyleIdsNotEqualTo(String value) {
            return notEqualTo(shopParentStyleIds, value);
        }

        public ShiguShopStyleRelationExample.Criteria andShopParentStyleIdsGreaterThan(String value) {
            return greaterThan(shopParentStyleIds, value);
        }

        public ShiguShopStyleRelationExample.Criteria andShopParentStyleIdsGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(shopParentStyleIds, value);
        }

        public ShiguShopStyleRelationExample.Criteria andShopParentStyleIdsLessThan(String value) {
            return lessThan(shopParentStyleIds, value);
        }

        public ShiguShopStyleRelationExample.Criteria andShopParentStyleIdsLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(shopParentStyleIds, value);
        }

        public ShiguShopStyleRelationExample.Criteria andShopParentStyleIdsLike(String value) {
            return like(shopParentStyleIds, value);
        }

        public ShiguShopStyleRelationExample.Criteria andShopParentStyleIdsNotLike(String value) {
            return notLike(shopParentStyleIds, value);
        }

        public ShiguShopStyleRelationExample.Criteria andShopParentStyleIdsIn(List<String> values) {
            return in(shopParentStyleIds, values);
        }

        public ShiguShopStyleRelationExample.Criteria andShopParentStyleIdsNotIn(List<String> values) {
            return notIn(shopParentStyleIds, values);
        }

        public ShiguShopStyleRelationExample.Criteria andShopParentStyleIdsBetween(String value1, String value2) {
            return between(shopParentStyleIds, value1, value2);
        }

        public ShiguShopStyleRelationExample.Criteria andShopParentStyleIdsNotBetween(String value1, String value2) {
            return notBetween(shopParentStyleIds, value1, value2);
        }
        public ShiguShopStyleRelationExample.Criteria andShopIdIsNull() {
            return isNull(shopId);
        }

        public ShiguShopStyleRelationExample.Criteria andShopIdIsNotNull() {
            return isNotNull(shopId);
        }

        public ShiguShopStyleRelationExample.Criteria andShopIdEqualTo(Long value) {
            return equalTo(shopId, value);
        }

        public ShiguShopStyleRelationExample.Criteria andShopIdNotEqualTo(Long value) {
            return notEqualTo(shopId, value);
        }

        public ShiguShopStyleRelationExample.Criteria andShopIdGreaterThan(Long value) {
            return greaterThan(shopId, value);
        }

        public ShiguShopStyleRelationExample.Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(shopId, value);
        }

        public ShiguShopStyleRelationExample.Criteria andShopIdLessThan(Long value) {
            return lessThan(shopId, value);
        }

        public ShiguShopStyleRelationExample.Criteria andShopIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(shopId, value);
        }

        public ShiguShopStyleRelationExample.Criteria andShopIdIn(List<Long> values) {
            return in(shopId, values);
        }

        public ShiguShopStyleRelationExample.Criteria andShopIdNotIn(List<Long> values) {
            return notIn(shopId, values);
        }

        public ShiguShopStyleRelationExample.Criteria andShopIdBetween(Long value1, Long value2) {
            return between(shopId, value1, value2);
        }

        public ShiguShopStyleRelationExample.Criteria andShopIdNotBetween(Long value1, Long value2) {
            return notBetween(shopId, value1, value2);
        }
        public ShiguShopStyleRelationExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ShiguShopStyleRelationExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ShiguShopStyleRelationExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public ShiguShopStyleRelationExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public ShiguShopStyleRelationExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public ShiguShopStyleRelationExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ShiguShopStyleRelationExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public ShiguShopStyleRelationExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public ShiguShopStyleRelationExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public ShiguShopStyleRelationExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public ShiguShopStyleRelationExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public ShiguShopStyleRelationExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public ShiguShopStyleRelationExample.Criteria andGmtCreateIsNull() {
            return isNull(gmtCreate);
        }

        public ShiguShopStyleRelationExample.Criteria andGmtCreateIsNotNull() {
            return isNotNull(gmtCreate);
        }

        public ShiguShopStyleRelationExample.Criteria andGmtCreateEqualTo(Date value) {
            return equalTo(gmtCreate, value);
        }

        public ShiguShopStyleRelationExample.Criteria andGmtCreateNotEqualTo(Date value) {
            return notEqualTo(gmtCreate, value);
        }

        public ShiguShopStyleRelationExample.Criteria andGmtCreateGreaterThan(Date value) {
            return greaterThan(gmtCreate, value);
        }

        public ShiguShopStyleRelationExample.Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreate, value);
        }

        public ShiguShopStyleRelationExample.Criteria andGmtCreateLessThan(Date value) {
            return lessThan(gmtCreate, value);
        }

        public ShiguShopStyleRelationExample.Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreate, value);
        }

        public ShiguShopStyleRelationExample.Criteria andGmtCreateIn(List<Date> values) {
            return in(gmtCreate, values);
        }

        public ShiguShopStyleRelationExample.Criteria andGmtCreateNotIn(List<Date> values) {
            return notIn(gmtCreate, values);
        }

        public ShiguShopStyleRelationExample.Criteria andGmtCreateBetween(Date value1, Date value2) {
            return between(gmtCreate, value1, value2);
        }

        public ShiguShopStyleRelationExample.Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreate, value1, value2);
        }
    }
}