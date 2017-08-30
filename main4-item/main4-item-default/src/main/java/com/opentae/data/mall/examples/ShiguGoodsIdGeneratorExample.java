package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguGoodsIdGenerator;

import java.util.*;
public class ShiguGoodsIdGeneratorExample extends SgExample<ShiguGoodsIdGeneratorExample.Criteria> {
    public static final Class<ShiguGoodsIdGenerator> beanClass = ShiguGoodsIdGenerator.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn webSite;
    public static EntityColumn remark;
    public static EntityColumn goodId;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        webSite = listMap.get("webSite");
        remark = listMap.get("remark");
        goodId = listMap.get("goodId");
        }

    public ShiguGoodsIdGeneratorExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguGoodsIdGeneratorExample.Criteria createCriteriaInternal() {
        return new ShiguGoodsIdGeneratorExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public ShiguGoodsIdGeneratorExample.Criteria andRemarkIsNull() {
            return isNull(remark);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andRemarkIsNotNull() {
            return isNotNull(remark);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andRemarkEqualTo(String value) {
            return equalTo(remark, value);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andRemarkNotEqualTo(String value) {
            return notEqualTo(remark, value);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andRemarkGreaterThan(String value) {
            return greaterThan(remark, value);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark, value);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andRemarkLessThan(String value) {
            return lessThan(remark, value);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark, value);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andRemarkLike(String value) {
            return like(remark, value);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andRemarkNotLike(String value) {
            return notLike(remark, value);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andRemarkIn(List<String> values) {
            return in(remark, values);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andRemarkNotIn(List<String> values) {
            return notIn(remark, values);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andRemarkBetween(String value1, String value2) {
            return between(remark, value1, value2);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andRemarkNotBetween(String value1, String value2) {
            return notBetween(remark, value1, value2);
        }
        public ShiguGoodsIdGeneratorExample.Criteria andGoodIdIsNull() {
            return isNull(goodId);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andGoodIdIsNotNull() {
            return isNotNull(goodId);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andGoodIdEqualTo(Long value) {
            return equalTo(goodId, value);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andGoodIdNotEqualTo(Long value) {
            return notEqualTo(goodId, value);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andGoodIdGreaterThan(Long value) {
            return greaterThan(goodId, value);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andGoodIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodId, value);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andGoodIdLessThan(Long value) {
            return lessThan(goodId, value);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andGoodIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodId, value);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andGoodIdIn(List<Long> values) {
            return in(goodId, values);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andGoodIdNotIn(List<Long> values) {
            return notIn(goodId, values);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andGoodIdBetween(Long value1, Long value2) {
            return between(goodId, value1, value2);
        }

        public ShiguGoodsIdGeneratorExample.Criteria andGoodIdNotBetween(Long value1, Long value2) {
            return notBetween(goodId, value1, value2);
        }
    }
}
