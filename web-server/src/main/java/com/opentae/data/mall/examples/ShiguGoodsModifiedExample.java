package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguGoodsModified;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class ShiguGoodsModifiedExample extends SgExample<ShiguGoodsModifiedExample.Criteria> {
    public static final Class<ShiguGoodsModified> beanClass = ShiguGoodsModified.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn itemId;
    public static EntityColumn hasSetGoodsno;
    public static EntityColumn hasSetPrice;
    public static EntityColumn hasSetTitle;
    public static EntityColumn modifyId;
    public static EntityColumn hasSetPiprice;
    public static EntityColumn hasModInstock;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        itemId = listMap.get("itemId");
        hasSetGoodsno = listMap.get("hasSetGoodsno");
        hasSetPrice = listMap.get("hasSetPrice");
        hasSetTitle = listMap.get("hasSetTitle");
        modifyId = listMap.get("modifyId");
        hasSetPiprice = listMap.get("hasSetPiprice");
        hasModInstock = listMap.get("hasModInstock");
        }

    public ShiguGoodsModifiedExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguGoodsModifiedExample.Criteria createCriteriaInternal() {
        return new ShiguGoodsModifiedExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdIsNull() {
            return isNull(itemId);
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdIsNotNull() {
            return isNotNull(itemId);
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdEqualTo(Long value) {
            return equalTo(itemId, value);
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdNotEqualTo(Long value) {
            return notEqualTo(itemId, value);
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdGreaterThan(Long value) {
            return greaterThan(itemId, value);
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(itemId, value);
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdLessThan(Long value) {
            return lessThan(itemId, value);
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(itemId, value);
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdIn(List<Long> values) {
            return in(itemId, values);
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdNotIn(List<Long> values) {
            return notIn(itemId, values);
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdBetween(Long value1, Long value2) {
            return between(itemId, value1, value2);
        }

        public ShiguGoodsModifiedExample.Criteria andItemIdNotBetween(Long value1, Long value2) {
            return notBetween(itemId, value1, value2);
        }
        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoIsNull() {
            return isNull(hasSetGoodsno);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoIsNotNull() {
            return isNotNull(hasSetGoodsno);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoEqualTo(Integer value) {
            return equalTo(hasSetGoodsno, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoNotEqualTo(Integer value) {
            return notEqualTo(hasSetGoodsno, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoGreaterThan(Integer value) {
            return greaterThan(hasSetGoodsno, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(hasSetGoodsno, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoLessThan(Integer value) {
            return lessThan(hasSetGoodsno, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(hasSetGoodsno, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoIn(List<Integer> values) {
            return in(hasSetGoodsno, values);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoNotIn(List<Integer> values) {
            return notIn(hasSetGoodsno, values);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoBetween(Integer value1, Integer value2) {
            return between(hasSetGoodsno, value1, value2);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetGoodsnoNotBetween(Integer value1, Integer value2) {
            return notBetween(hasSetGoodsno, value1, value2);
        }
        public ShiguGoodsModifiedExample.Criteria andHasSetPriceIsNull() {
            return isNull(hasSetPrice);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPriceIsNotNull() {
            return isNotNull(hasSetPrice);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPriceEqualTo(Integer value) {
            return equalTo(hasSetPrice, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPriceNotEqualTo(Integer value) {
            return notEqualTo(hasSetPrice, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPriceGreaterThan(Integer value) {
            return greaterThan(hasSetPrice, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPriceGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(hasSetPrice, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPriceLessThan(Integer value) {
            return lessThan(hasSetPrice, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPriceLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(hasSetPrice, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPriceIn(List<Integer> values) {
            return in(hasSetPrice, values);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPriceNotIn(List<Integer> values) {
            return notIn(hasSetPrice, values);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPriceBetween(Integer value1, Integer value2) {
            return between(hasSetPrice, value1, value2);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPriceNotBetween(Integer value1, Integer value2) {
            return notBetween(hasSetPrice, value1, value2);
        }
        public ShiguGoodsModifiedExample.Criteria andHasSetTitleIsNull() {
            return isNull(hasSetTitle);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetTitleIsNotNull() {
            return isNotNull(hasSetTitle);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetTitleEqualTo(Integer value) {
            return equalTo(hasSetTitle, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetTitleNotEqualTo(Integer value) {
            return notEqualTo(hasSetTitle, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetTitleGreaterThan(Integer value) {
            return greaterThan(hasSetTitle, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetTitleGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(hasSetTitle, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetTitleLessThan(Integer value) {
            return lessThan(hasSetTitle, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetTitleLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(hasSetTitle, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetTitleIn(List<Integer> values) {
            return in(hasSetTitle, values);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetTitleNotIn(List<Integer> values) {
            return notIn(hasSetTitle, values);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetTitleBetween(Integer value1, Integer value2) {
            return between(hasSetTitle, value1, value2);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetTitleNotBetween(Integer value1, Integer value2) {
            return notBetween(hasSetTitle, value1, value2);
        }
        public ShiguGoodsModifiedExample.Criteria andModifyIdIsNull() {
            return isNull(modifyId);
        }

        public ShiguGoodsModifiedExample.Criteria andModifyIdIsNotNull() {
            return isNotNull(modifyId);
        }

        public ShiguGoodsModifiedExample.Criteria andModifyIdEqualTo(Long value) {
            return equalTo(modifyId, value);
        }

        public ShiguGoodsModifiedExample.Criteria andModifyIdNotEqualTo(Long value) {
            return notEqualTo(modifyId, value);
        }

        public ShiguGoodsModifiedExample.Criteria andModifyIdGreaterThan(Long value) {
            return greaterThan(modifyId, value);
        }

        public ShiguGoodsModifiedExample.Criteria andModifyIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(modifyId, value);
        }

        public ShiguGoodsModifiedExample.Criteria andModifyIdLessThan(Long value) {
            return lessThan(modifyId, value);
        }

        public ShiguGoodsModifiedExample.Criteria andModifyIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(modifyId, value);
        }

        public ShiguGoodsModifiedExample.Criteria andModifyIdIn(List<Long> values) {
            return in(modifyId, values);
        }

        public ShiguGoodsModifiedExample.Criteria andModifyIdNotIn(List<Long> values) {
            return notIn(modifyId, values);
        }

        public ShiguGoodsModifiedExample.Criteria andModifyIdBetween(Long value1, Long value2) {
            return between(modifyId, value1, value2);
        }

        public ShiguGoodsModifiedExample.Criteria andModifyIdNotBetween(Long value1, Long value2) {
            return notBetween(modifyId, value1, value2);
        }
        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceIsNull() {
            return isNull(hasSetPiprice);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceIsNotNull() {
            return isNotNull(hasSetPiprice);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceEqualTo(Integer value) {
            return equalTo(hasSetPiprice, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceNotEqualTo(Integer value) {
            return notEqualTo(hasSetPiprice, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceGreaterThan(Integer value) {
            return greaterThan(hasSetPiprice, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(hasSetPiprice, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceLessThan(Integer value) {
            return lessThan(hasSetPiprice, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(hasSetPiprice, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceIn(List<Integer> values) {
            return in(hasSetPiprice, values);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceNotIn(List<Integer> values) {
            return notIn(hasSetPiprice, values);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceBetween(Integer value1, Integer value2) {
            return between(hasSetPiprice, value1, value2);
        }

        public ShiguGoodsModifiedExample.Criteria andHasSetPipriceNotBetween(Integer value1, Integer value2) {
            return notBetween(hasSetPiprice, value1, value2);
        }
        public ShiguGoodsModifiedExample.Criteria andHasModInstockIsNull() {
            return isNull(hasModInstock);
        }

        public ShiguGoodsModifiedExample.Criteria andHasModInstockIsNotNull() {
            return isNotNull(hasModInstock);
        }

        public ShiguGoodsModifiedExample.Criteria andHasModInstockEqualTo(Integer value) {
            return equalTo(hasModInstock, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasModInstockNotEqualTo(Integer value) {
            return notEqualTo(hasModInstock, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasModInstockGreaterThan(Integer value) {
            return greaterThan(hasModInstock, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasModInstockGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(hasModInstock, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasModInstockLessThan(Integer value) {
            return lessThan(hasModInstock, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasModInstockLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(hasModInstock, value);
        }

        public ShiguGoodsModifiedExample.Criteria andHasModInstockIn(List<Integer> values) {
            return in(hasModInstock, values);
        }

        public ShiguGoodsModifiedExample.Criteria andHasModInstockNotIn(List<Integer> values) {
            return notIn(hasModInstock, values);
        }

        public ShiguGoodsModifiedExample.Criteria andHasModInstockBetween(Integer value1, Integer value2) {
            return between(hasModInstock, value1, value2);
        }

        public ShiguGoodsModifiedExample.Criteria andHasModInstockNotBetween(Integer value1, Integer value2) {
            return notBetween(hasModInstock, value1, value2);
        }
    }
}