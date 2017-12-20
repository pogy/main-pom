package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.TinyItemCollect;

import java.util.*;
public class TinyItemCollectExample extends SgExample<TinyItemCollectExample.Criteria> {
    public static final Class<TinyItemCollect> beanClass = TinyItemCollect.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn website;
    public static EntityColumn goodsCollectId;
    public static EntityColumn marketname;
    public static EntityColumn piprice;
    public static EntityColumn id;
    public static EntityColumn imgsrc;
    public static EntityColumn title;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        website = listMap.get("website");
        goodsCollectId = listMap.get("goodsCollectId");
        marketname = listMap.get("marketname");
        piprice = listMap.get("piprice");
        id = listMap.get("id");
        imgsrc = listMap.get("imgsrc");
        title = listMap.get("title");
        }

    public TinyItemCollectExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected TinyItemCollectExample.Criteria createCriteriaInternal() {
        return new TinyItemCollectExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public TinyItemCollectExample.Criteria andWebsiteIsNull() {
            return isNull(website);
        }

        public TinyItemCollectExample.Criteria andWebsiteIsNotNull() {
            return isNotNull(website);
        }

        public TinyItemCollectExample.Criteria andWebsiteEqualTo(String value) {
            return equalTo(website, value);
        }

        public TinyItemCollectExample.Criteria andWebsiteNotEqualTo(String value) {
            return notEqualTo(website, value);
        }

        public TinyItemCollectExample.Criteria andWebsiteGreaterThan(String value) {
            return greaterThan(website, value);
        }

        public TinyItemCollectExample.Criteria andWebsiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(website, value);
        }

        public TinyItemCollectExample.Criteria andWebsiteLessThan(String value) {
            return lessThan(website, value);
        }

        public TinyItemCollectExample.Criteria andWebsiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(website, value);
        }

        public TinyItemCollectExample.Criteria andWebsiteLike(String value) {
            return like(website, value);
        }

        public TinyItemCollectExample.Criteria andWebsiteNotLike(String value) {
            return notLike(website, value);
        }

        public TinyItemCollectExample.Criteria andWebsiteIn(List<String> values) {
            return in(website, values);
        }

        public TinyItemCollectExample.Criteria andWebsiteNotIn(List<String> values) {
            return notIn(website, values);
        }

        public TinyItemCollectExample.Criteria andWebsiteBetween(String value1, String value2) {
            return between(website, value1, value2);
        }

        public TinyItemCollectExample.Criteria andWebsiteNotBetween(String value1, String value2) {
            return notBetween(website, value1, value2);
        }
        public TinyItemCollectExample.Criteria andGoodsCollectIdIsNull() {
            return isNull(goodsCollectId);
        }

        public TinyItemCollectExample.Criteria andGoodsCollectIdIsNotNull() {
            return isNotNull(goodsCollectId);
        }

        public TinyItemCollectExample.Criteria andGoodsCollectIdEqualTo(Long value) {
            return equalTo(goodsCollectId, value);
        }

        public TinyItemCollectExample.Criteria andGoodsCollectIdNotEqualTo(Long value) {
            return notEqualTo(goodsCollectId, value);
        }

        public TinyItemCollectExample.Criteria andGoodsCollectIdGreaterThan(Long value) {
            return greaterThan(goodsCollectId, value);
        }

        public TinyItemCollectExample.Criteria andGoodsCollectIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(goodsCollectId, value);
        }

        public TinyItemCollectExample.Criteria andGoodsCollectIdLessThan(Long value) {
            return lessThan(goodsCollectId, value);
        }

        public TinyItemCollectExample.Criteria andGoodsCollectIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(goodsCollectId, value);
        }

        public TinyItemCollectExample.Criteria andGoodsCollectIdIn(List<Long> values) {
            return in(goodsCollectId, values);
        }

        public TinyItemCollectExample.Criteria andGoodsCollectIdNotIn(List<Long> values) {
            return notIn(goodsCollectId, values);
        }

        public TinyItemCollectExample.Criteria andGoodsCollectIdBetween(Long value1, Long value2) {
            return between(goodsCollectId, value1, value2);
        }

        public TinyItemCollectExample.Criteria andGoodsCollectIdNotBetween(Long value1, Long value2) {
            return notBetween(goodsCollectId, value1, value2);
        }
        public TinyItemCollectExample.Criteria andMarketnameIsNull() {
            return isNull(marketname);
        }

        public TinyItemCollectExample.Criteria andMarketnameIsNotNull() {
            return isNotNull(marketname);
        }

        public TinyItemCollectExample.Criteria andMarketnameEqualTo(String value) {
            return equalTo(marketname, value);
        }

        public TinyItemCollectExample.Criteria andMarketnameNotEqualTo(String value) {
            return notEqualTo(marketname, value);
        }

        public TinyItemCollectExample.Criteria andMarketnameGreaterThan(String value) {
            return greaterThan(marketname, value);
        }

        public TinyItemCollectExample.Criteria andMarketnameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(marketname, value);
        }

        public TinyItemCollectExample.Criteria andMarketnameLessThan(String value) {
            return lessThan(marketname, value);
        }

        public TinyItemCollectExample.Criteria andMarketnameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(marketname, value);
        }

        public TinyItemCollectExample.Criteria andMarketnameLike(String value) {
            return like(marketname, value);
        }

        public TinyItemCollectExample.Criteria andMarketnameNotLike(String value) {
            return notLike(marketname, value);
        }

        public TinyItemCollectExample.Criteria andMarketnameIn(List<String> values) {
            return in(marketname, values);
        }

        public TinyItemCollectExample.Criteria andMarketnameNotIn(List<String> values) {
            return notIn(marketname, values);
        }

        public TinyItemCollectExample.Criteria andMarketnameBetween(String value1, String value2) {
            return between(marketname, value1, value2);
        }

        public TinyItemCollectExample.Criteria andMarketnameNotBetween(String value1, String value2) {
            return notBetween(marketname, value1, value2);
        }
        public TinyItemCollectExample.Criteria andPipriceIsNull() {
            return isNull(piprice);
        }

        public TinyItemCollectExample.Criteria andPipriceIsNotNull() {
            return isNotNull(piprice);
        }

        public TinyItemCollectExample.Criteria andPipriceEqualTo(String value) {
            return equalTo(piprice, value);
        }

        public TinyItemCollectExample.Criteria andPipriceNotEqualTo(String value) {
            return notEqualTo(piprice, value);
        }

        public TinyItemCollectExample.Criteria andPipriceGreaterThan(String value) {
            return greaterThan(piprice, value);
        }

        public TinyItemCollectExample.Criteria andPipriceGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(piprice, value);
        }

        public TinyItemCollectExample.Criteria andPipriceLessThan(String value) {
            return lessThan(piprice, value);
        }

        public TinyItemCollectExample.Criteria andPipriceLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(piprice, value);
        }

        public TinyItemCollectExample.Criteria andPipriceLike(String value) {
            return like(piprice, value);
        }

        public TinyItemCollectExample.Criteria andPipriceNotLike(String value) {
            return notLike(piprice, value);
        }

        public TinyItemCollectExample.Criteria andPipriceIn(List<String> values) {
            return in(piprice, values);
        }

        public TinyItemCollectExample.Criteria andPipriceNotIn(List<String> values) {
            return notIn(piprice, values);
        }

        public TinyItemCollectExample.Criteria andPipriceBetween(String value1, String value2) {
            return between(piprice, value1, value2);
        }

        public TinyItemCollectExample.Criteria andPipriceNotBetween(String value1, String value2) {
            return notBetween(piprice, value1, value2);
        }
        public TinyItemCollectExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public TinyItemCollectExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public TinyItemCollectExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public TinyItemCollectExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public TinyItemCollectExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public TinyItemCollectExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public TinyItemCollectExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public TinyItemCollectExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public TinyItemCollectExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public TinyItemCollectExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public TinyItemCollectExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public TinyItemCollectExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public TinyItemCollectExample.Criteria andImgsrcIsNull() {
            return isNull(imgsrc);
        }

        public TinyItemCollectExample.Criteria andImgsrcIsNotNull() {
            return isNotNull(imgsrc);
        }

        public TinyItemCollectExample.Criteria andImgsrcEqualTo(String value) {
            return equalTo(imgsrc, value);
        }

        public TinyItemCollectExample.Criteria andImgsrcNotEqualTo(String value) {
            return notEqualTo(imgsrc, value);
        }

        public TinyItemCollectExample.Criteria andImgsrcGreaterThan(String value) {
            return greaterThan(imgsrc, value);
        }

        public TinyItemCollectExample.Criteria andImgsrcGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(imgsrc, value);
        }

        public TinyItemCollectExample.Criteria andImgsrcLessThan(String value) {
            return lessThan(imgsrc, value);
        }

        public TinyItemCollectExample.Criteria andImgsrcLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(imgsrc, value);
        }

        public TinyItemCollectExample.Criteria andImgsrcLike(String value) {
            return like(imgsrc, value);
        }

        public TinyItemCollectExample.Criteria andImgsrcNotLike(String value) {
            return notLike(imgsrc, value);
        }

        public TinyItemCollectExample.Criteria andImgsrcIn(List<String> values) {
            return in(imgsrc, values);
        }

        public TinyItemCollectExample.Criteria andImgsrcNotIn(List<String> values) {
            return notIn(imgsrc, values);
        }

        public TinyItemCollectExample.Criteria andImgsrcBetween(String value1, String value2) {
            return between(imgsrc, value1, value2);
        }

        public TinyItemCollectExample.Criteria andImgsrcNotBetween(String value1, String value2) {
            return notBetween(imgsrc, value1, value2);
        }
        public TinyItemCollectExample.Criteria andTitleIsNull() {
            return isNull(title);
        }

        public TinyItemCollectExample.Criteria andTitleIsNotNull() {
            return isNotNull(title);
        }

        public TinyItemCollectExample.Criteria andTitleEqualTo(String value) {
            return equalTo(title, value);
        }

        public TinyItemCollectExample.Criteria andTitleNotEqualTo(String value) {
            return notEqualTo(title, value);
        }

        public TinyItemCollectExample.Criteria andTitleGreaterThan(String value) {
            return greaterThan(title, value);
        }

        public TinyItemCollectExample.Criteria andTitleGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(title, value);
        }

        public TinyItemCollectExample.Criteria andTitleLessThan(String value) {
            return lessThan(title, value);
        }

        public TinyItemCollectExample.Criteria andTitleLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(title, value);
        }

        public TinyItemCollectExample.Criteria andTitleLike(String value) {
            return like(title, value);
        }

        public TinyItemCollectExample.Criteria andTitleNotLike(String value) {
            return notLike(title, value);
        }

        public TinyItemCollectExample.Criteria andTitleIn(List<String> values) {
            return in(title, values);
        }

        public TinyItemCollectExample.Criteria andTitleNotIn(List<String> values) {
            return notIn(title, values);
        }

        public TinyItemCollectExample.Criteria andTitleBetween(String value1, String value2) {
            return between(title, value1, value2);
        }

        public TinyItemCollectExample.Criteria andTitleNotBetween(String value1, String value2) {
            return notBetween(title, value1, value2);
        }
    }
}
