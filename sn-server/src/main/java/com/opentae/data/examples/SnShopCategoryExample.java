package com.opentae.data.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.beans.SnShopCategory;

import java.util.*;
public class SnShopCategoryExample extends SgExample<SnShopCategoryExample.Criteria> {
    public static final Class<SnShopCategory> beanClass = SnShopCategory.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn isFirst;
    public static EntityColumn gmtModif;
    public static EntityColumn categoryCode;
    public static EntityColumn id;
    public static EntityColumn categorySort;
    public static EntityColumn gmtCreat;
    public static EntityColumn categorySet;
    public static EntityColumn categoryName;
    public static EntityColumn categoryImg;
    public static EntityColumn firstId;
    public static EntityColumn username;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        isFirst = listMap.get("isFirst");
        gmtModif = listMap.get("gmtModif");
        categoryCode = listMap.get("categoryCode");
        id = listMap.get("id");
        categorySort = listMap.get("categorySort");
        gmtCreat = listMap.get("gmtCreat");
        categorySet = listMap.get("categorySet");
        categoryName = listMap.get("categoryName");
        categoryImg = listMap.get("categoryImg");
        firstId = listMap.get("firstId");
        username = listMap.get("username");
        }

    public SnShopCategoryExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected SnShopCategoryExample.Criteria createCriteriaInternal() {
        return new SnShopCategoryExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public SnShopCategoryExample.Criteria andIsFirstIsNull() {
            return isNull(isFirst);
        }

        public SnShopCategoryExample.Criteria andIsFirstIsNotNull() {
            return isNotNull(isFirst);
        }

        public SnShopCategoryExample.Criteria andIsFirstEqualTo(Integer value) {
            return equalTo(isFirst, value);
        }

        public SnShopCategoryExample.Criteria andIsFirstNotEqualTo(Integer value) {
            return notEqualTo(isFirst, value);
        }

        public SnShopCategoryExample.Criteria andIsFirstGreaterThan(Integer value) {
            return greaterThan(isFirst, value);
        }

        public SnShopCategoryExample.Criteria andIsFirstGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isFirst, value);
        }

        public SnShopCategoryExample.Criteria andIsFirstLessThan(Integer value) {
            return lessThan(isFirst, value);
        }

        public SnShopCategoryExample.Criteria andIsFirstLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isFirst, value);
        }

        public SnShopCategoryExample.Criteria andIsFirstIn(List<Integer> values) {
            return in(isFirst, values);
        }

        public SnShopCategoryExample.Criteria andIsFirstNotIn(List<Integer> values) {
            return notIn(isFirst, values);
        }

        public SnShopCategoryExample.Criteria andIsFirstBetween(Integer value1, Integer value2) {
            return between(isFirst, value1, value2);
        }

        public SnShopCategoryExample.Criteria andIsFirstNotBetween(Integer value1, Integer value2) {
            return notBetween(isFirst, value1, value2);
        }
        public SnShopCategoryExample.Criteria andGmtModifIsNull() {
            return isNull(gmtModif);
        }

        public SnShopCategoryExample.Criteria andGmtModifIsNotNull() {
            return isNotNull(gmtModif);
        }

        public SnShopCategoryExample.Criteria andGmtModifEqualTo(Date value) {
            return equalTo(gmtModif, value);
        }

        public SnShopCategoryExample.Criteria andGmtModifNotEqualTo(Date value) {
            return notEqualTo(gmtModif, value);
        }

        public SnShopCategoryExample.Criteria andGmtModifGreaterThan(Date value) {
            return greaterThan(gmtModif, value);
        }

        public SnShopCategoryExample.Criteria andGmtModifGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtModif, value);
        }

        public SnShopCategoryExample.Criteria andGmtModifLessThan(Date value) {
            return lessThan(gmtModif, value);
        }

        public SnShopCategoryExample.Criteria andGmtModifLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtModif, value);
        }

        public SnShopCategoryExample.Criteria andGmtModifIn(List<Date> values) {
            return in(gmtModif, values);
        }

        public SnShopCategoryExample.Criteria andGmtModifNotIn(List<Date> values) {
            return notIn(gmtModif, values);
        }

        public SnShopCategoryExample.Criteria andGmtModifBetween(Date value1, Date value2) {
            return between(gmtModif, value1, value2);
        }

        public SnShopCategoryExample.Criteria andGmtModifNotBetween(Date value1, Date value2) {
            return notBetween(gmtModif, value1, value2);
        }
        public SnShopCategoryExample.Criteria andCategoryCodeIsNull() {
            return isNull(categoryCode);
        }

        public SnShopCategoryExample.Criteria andCategoryCodeIsNotNull() {
            return isNotNull(categoryCode);
        }

        public SnShopCategoryExample.Criteria andCategoryCodeEqualTo(String value) {
            return equalTo(categoryCode, value);
        }

        public SnShopCategoryExample.Criteria andCategoryCodeNotEqualTo(String value) {
            return notEqualTo(categoryCode, value);
        }

        public SnShopCategoryExample.Criteria andCategoryCodeGreaterThan(String value) {
            return greaterThan(categoryCode, value);
        }

        public SnShopCategoryExample.Criteria andCategoryCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(categoryCode, value);
        }

        public SnShopCategoryExample.Criteria andCategoryCodeLessThan(String value) {
            return lessThan(categoryCode, value);
        }

        public SnShopCategoryExample.Criteria andCategoryCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(categoryCode, value);
        }

        public SnShopCategoryExample.Criteria andCategoryCodeLike(String value) {
            return like(categoryCode, value);
        }

        public SnShopCategoryExample.Criteria andCategoryCodeNotLike(String value) {
            return notLike(categoryCode, value);
        }

        public SnShopCategoryExample.Criteria andCategoryCodeIn(List<String> values) {
            return in(categoryCode, values);
        }

        public SnShopCategoryExample.Criteria andCategoryCodeNotIn(List<String> values) {
            return notIn(categoryCode, values);
        }

        public SnShopCategoryExample.Criteria andCategoryCodeBetween(String value1, String value2) {
            return between(categoryCode, value1, value2);
        }

        public SnShopCategoryExample.Criteria andCategoryCodeNotBetween(String value1, String value2) {
            return notBetween(categoryCode, value1, value2);
        }
        public SnShopCategoryExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public SnShopCategoryExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public SnShopCategoryExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public SnShopCategoryExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public SnShopCategoryExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public SnShopCategoryExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public SnShopCategoryExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public SnShopCategoryExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public SnShopCategoryExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public SnShopCategoryExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public SnShopCategoryExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public SnShopCategoryExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public SnShopCategoryExample.Criteria andCategorySortIsNull() {
            return isNull(categorySort);
        }

        public SnShopCategoryExample.Criteria andCategorySortIsNotNull() {
            return isNotNull(categorySort);
        }

        public SnShopCategoryExample.Criteria andCategorySortEqualTo(Integer value) {
            return equalTo(categorySort, value);
        }

        public SnShopCategoryExample.Criteria andCategorySortNotEqualTo(Integer value) {
            return notEqualTo(categorySort, value);
        }

        public SnShopCategoryExample.Criteria andCategorySortGreaterThan(Integer value) {
            return greaterThan(categorySort, value);
        }

        public SnShopCategoryExample.Criteria andCategorySortGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(categorySort, value);
        }

        public SnShopCategoryExample.Criteria andCategorySortLessThan(Integer value) {
            return lessThan(categorySort, value);
        }

        public SnShopCategoryExample.Criteria andCategorySortLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(categorySort, value);
        }

        public SnShopCategoryExample.Criteria andCategorySortIn(List<Integer> values) {
            return in(categorySort, values);
        }

        public SnShopCategoryExample.Criteria andCategorySortNotIn(List<Integer> values) {
            return notIn(categorySort, values);
        }

        public SnShopCategoryExample.Criteria andCategorySortBetween(Integer value1, Integer value2) {
            return between(categorySort, value1, value2);
        }

        public SnShopCategoryExample.Criteria andCategorySortNotBetween(Integer value1, Integer value2) {
            return notBetween(categorySort, value1, value2);
        }
        public SnShopCategoryExample.Criteria andGmtCreatIsNull() {
            return isNull(gmtCreat);
        }

        public SnShopCategoryExample.Criteria andGmtCreatIsNotNull() {
            return isNotNull(gmtCreat);
        }

        public SnShopCategoryExample.Criteria andGmtCreatEqualTo(Date value) {
            return equalTo(gmtCreat, value);
        }

        public SnShopCategoryExample.Criteria andGmtCreatNotEqualTo(Date value) {
            return notEqualTo(gmtCreat, value);
        }

        public SnShopCategoryExample.Criteria andGmtCreatGreaterThan(Date value) {
            return greaterThan(gmtCreat, value);
        }

        public SnShopCategoryExample.Criteria andGmtCreatGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(gmtCreat, value);
        }

        public SnShopCategoryExample.Criteria andGmtCreatLessThan(Date value) {
            return lessThan(gmtCreat, value);
        }

        public SnShopCategoryExample.Criteria andGmtCreatLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(gmtCreat, value);
        }

        public SnShopCategoryExample.Criteria andGmtCreatIn(List<Date> values) {
            return in(gmtCreat, values);
        }

        public SnShopCategoryExample.Criteria andGmtCreatNotIn(List<Date> values) {
            return notIn(gmtCreat, values);
        }

        public SnShopCategoryExample.Criteria andGmtCreatBetween(Date value1, Date value2) {
            return between(gmtCreat, value1, value2);
        }

        public SnShopCategoryExample.Criteria andGmtCreatNotBetween(Date value1, Date value2) {
            return notBetween(gmtCreat, value1, value2);
        }
        public SnShopCategoryExample.Criteria andCategorySetIsNull() {
            return isNull(categorySet);
        }

        public SnShopCategoryExample.Criteria andCategorySetIsNotNull() {
            return isNotNull(categorySet);
        }

        public SnShopCategoryExample.Criteria andCategorySetEqualTo(Integer value) {
            return equalTo(categorySet, value);
        }

        public SnShopCategoryExample.Criteria andCategorySetNotEqualTo(Integer value) {
            return notEqualTo(categorySet, value);
        }

        public SnShopCategoryExample.Criteria andCategorySetGreaterThan(Integer value) {
            return greaterThan(categorySet, value);
        }

        public SnShopCategoryExample.Criteria andCategorySetGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(categorySet, value);
        }

        public SnShopCategoryExample.Criteria andCategorySetLessThan(Integer value) {
            return lessThan(categorySet, value);
        }

        public SnShopCategoryExample.Criteria andCategorySetLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(categorySet, value);
        }

        public SnShopCategoryExample.Criteria andCategorySetIn(List<Integer> values) {
            return in(categorySet, values);
        }

        public SnShopCategoryExample.Criteria andCategorySetNotIn(List<Integer> values) {
            return notIn(categorySet, values);
        }

        public SnShopCategoryExample.Criteria andCategorySetBetween(Integer value1, Integer value2) {
            return between(categorySet, value1, value2);
        }

        public SnShopCategoryExample.Criteria andCategorySetNotBetween(Integer value1, Integer value2) {
            return notBetween(categorySet, value1, value2);
        }
        public SnShopCategoryExample.Criteria andCategoryNameIsNull() {
            return isNull(categoryName);
        }

        public SnShopCategoryExample.Criteria andCategoryNameIsNotNull() {
            return isNotNull(categoryName);
        }

        public SnShopCategoryExample.Criteria andCategoryNameEqualTo(String value) {
            return equalTo(categoryName, value);
        }

        public SnShopCategoryExample.Criteria andCategoryNameNotEqualTo(String value) {
            return notEqualTo(categoryName, value);
        }

        public SnShopCategoryExample.Criteria andCategoryNameGreaterThan(String value) {
            return greaterThan(categoryName, value);
        }

        public SnShopCategoryExample.Criteria andCategoryNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(categoryName, value);
        }

        public SnShopCategoryExample.Criteria andCategoryNameLessThan(String value) {
            return lessThan(categoryName, value);
        }

        public SnShopCategoryExample.Criteria andCategoryNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(categoryName, value);
        }

        public SnShopCategoryExample.Criteria andCategoryNameLike(String value) {
            return like(categoryName, value);
        }

        public SnShopCategoryExample.Criteria andCategoryNameNotLike(String value) {
            return notLike(categoryName, value);
        }

        public SnShopCategoryExample.Criteria andCategoryNameIn(List<String> values) {
            return in(categoryName, values);
        }

        public SnShopCategoryExample.Criteria andCategoryNameNotIn(List<String> values) {
            return notIn(categoryName, values);
        }

        public SnShopCategoryExample.Criteria andCategoryNameBetween(String value1, String value2) {
            return between(categoryName, value1, value2);
        }

        public SnShopCategoryExample.Criteria andCategoryNameNotBetween(String value1, String value2) {
            return notBetween(categoryName, value1, value2);
        }
        public SnShopCategoryExample.Criteria andCategoryImgIsNull() {
            return isNull(categoryImg);
        }

        public SnShopCategoryExample.Criteria andCategoryImgIsNotNull() {
            return isNotNull(categoryImg);
        }

        public SnShopCategoryExample.Criteria andCategoryImgEqualTo(String value) {
            return equalTo(categoryImg, value);
        }

        public SnShopCategoryExample.Criteria andCategoryImgNotEqualTo(String value) {
            return notEqualTo(categoryImg, value);
        }

        public SnShopCategoryExample.Criteria andCategoryImgGreaterThan(String value) {
            return greaterThan(categoryImg, value);
        }

        public SnShopCategoryExample.Criteria andCategoryImgGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(categoryImg, value);
        }

        public SnShopCategoryExample.Criteria andCategoryImgLessThan(String value) {
            return lessThan(categoryImg, value);
        }

        public SnShopCategoryExample.Criteria andCategoryImgLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(categoryImg, value);
        }

        public SnShopCategoryExample.Criteria andCategoryImgLike(String value) {
            return like(categoryImg, value);
        }

        public SnShopCategoryExample.Criteria andCategoryImgNotLike(String value) {
            return notLike(categoryImg, value);
        }

        public SnShopCategoryExample.Criteria andCategoryImgIn(List<String> values) {
            return in(categoryImg, values);
        }

        public SnShopCategoryExample.Criteria andCategoryImgNotIn(List<String> values) {
            return notIn(categoryImg, values);
        }

        public SnShopCategoryExample.Criteria andCategoryImgBetween(String value1, String value2) {
            return between(categoryImg, value1, value2);
        }

        public SnShopCategoryExample.Criteria andCategoryImgNotBetween(String value1, String value2) {
            return notBetween(categoryImg, value1, value2);
        }
        public SnShopCategoryExample.Criteria andFirstIdIsNull() {
            return isNull(firstId);
        }

        public SnShopCategoryExample.Criteria andFirstIdIsNotNull() {
            return isNotNull(firstId);
        }

        public SnShopCategoryExample.Criteria andFirstIdEqualTo(Integer value) {
            return equalTo(firstId, value);
        }

        public SnShopCategoryExample.Criteria andFirstIdNotEqualTo(Integer value) {
            return notEqualTo(firstId, value);
        }

        public SnShopCategoryExample.Criteria andFirstIdGreaterThan(Integer value) {
            return greaterThan(firstId, value);
        }

        public SnShopCategoryExample.Criteria andFirstIdGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(firstId, value);
        }

        public SnShopCategoryExample.Criteria andFirstIdLessThan(Integer value) {
            return lessThan(firstId, value);
        }

        public SnShopCategoryExample.Criteria andFirstIdLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(firstId, value);
        }

        public SnShopCategoryExample.Criteria andFirstIdIn(List<Integer> values) {
            return in(firstId, values);
        }

        public SnShopCategoryExample.Criteria andFirstIdNotIn(List<Integer> values) {
            return notIn(firstId, values);
        }

        public SnShopCategoryExample.Criteria andFirstIdBetween(Integer value1, Integer value2) {
            return between(firstId, value1, value2);
        }

        public SnShopCategoryExample.Criteria andFirstIdNotBetween(Integer value1, Integer value2) {
            return notBetween(firstId, value1, value2);
        }
        public SnShopCategoryExample.Criteria andUsernameIsNull() {
            return isNull(username);
        }

        public SnShopCategoryExample.Criteria andUsernameIsNotNull() {
            return isNotNull(username);
        }

        public SnShopCategoryExample.Criteria andUsernameEqualTo(String value) {
            return equalTo(username, value);
        }

        public SnShopCategoryExample.Criteria andUsernameNotEqualTo(String value) {
            return notEqualTo(username, value);
        }

        public SnShopCategoryExample.Criteria andUsernameGreaterThan(String value) {
            return greaterThan(username, value);
        }

        public SnShopCategoryExample.Criteria andUsernameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(username, value);
        }

        public SnShopCategoryExample.Criteria andUsernameLessThan(String value) {
            return lessThan(username, value);
        }

        public SnShopCategoryExample.Criteria andUsernameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(username, value);
        }

        public SnShopCategoryExample.Criteria andUsernameLike(String value) {
            return like(username, value);
        }

        public SnShopCategoryExample.Criteria andUsernameNotLike(String value) {
            return notLike(username, value);
        }

        public SnShopCategoryExample.Criteria andUsernameIn(List<String> values) {
            return in(username, values);
        }

        public SnShopCategoryExample.Criteria andUsernameNotIn(List<String> values) {
            return notIn(username, values);
        }

        public SnShopCategoryExample.Criteria andUsernameBetween(String value1, String value2) {
            return between(username, value1, value2);
        }

        public SnShopCategoryExample.Criteria andUsernameNotBetween(String value1, String value2) {
            return notBetween(username, value1, value2);
        }
    }
}