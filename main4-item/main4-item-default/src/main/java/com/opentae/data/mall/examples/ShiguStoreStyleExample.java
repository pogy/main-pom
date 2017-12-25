package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguStoreStyle;

import java.util.*;
public class ShiguStoreStyleExample extends SgExample<ShiguStoreStyleExample.Criteria> {
    public static final Class<ShiguStoreStyle> beanClass = ShiguStoreStyle.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn webSite;
    public static EntityColumn styleType;
    public static EntityColumn styleId;
    public static EntityColumn remark5;
    public static EntityColumn remark4;
    public static EntityColumn remark;
    public static EntityColumn styleName;
    public static EntityColumn remark1;
    public static EntityColumn userId;
    public static EntityColumn remark3;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        webSite = listMap.get("webSite");
        styleType = listMap.get("styleType");
        styleId = listMap.get("styleId");
        remark5 = listMap.get("remark5");
        remark4 = listMap.get("remark4");
        remark = listMap.get("remark");
        styleName = listMap.get("styleName");
        remark1 = listMap.get("remark1");
        userId = listMap.get("userId");
        remark3 = listMap.get("remark3");
        remark2 = listMap.get("remark2");
        }

    public ShiguStoreStyleExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguStoreStyleExample.Criteria createCriteriaInternal() {
        return new ShiguStoreStyleExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguStoreStyleExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public ShiguStoreStyleExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public ShiguStoreStyleExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public ShiguStoreStyleExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public ShiguStoreStyleExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public ShiguStoreStyleExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public ShiguStoreStyleExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public ShiguStoreStyleExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public ShiguStoreStyleExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public ShiguStoreStyleExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public ShiguStoreStyleExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public ShiguStoreStyleExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public ShiguStoreStyleExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public ShiguStoreStyleExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public ShiguStoreStyleExample.Criteria andStyleTypeIsNull() {
            return isNull(styleType);
        }

        public ShiguStoreStyleExample.Criteria andStyleTypeIsNotNull() {
            return isNotNull(styleType);
        }

        public ShiguStoreStyleExample.Criteria andStyleTypeEqualTo(Integer value) {
            return equalTo(styleType, value);
        }

        public ShiguStoreStyleExample.Criteria andStyleTypeNotEqualTo(Integer value) {
            return notEqualTo(styleType, value);
        }

        public ShiguStoreStyleExample.Criteria andStyleTypeGreaterThan(Integer value) {
            return greaterThan(styleType, value);
        }

        public ShiguStoreStyleExample.Criteria andStyleTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(styleType, value);
        }

        public ShiguStoreStyleExample.Criteria andStyleTypeLessThan(Integer value) {
            return lessThan(styleType, value);
        }

        public ShiguStoreStyleExample.Criteria andStyleTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(styleType, value);
        }

        public ShiguStoreStyleExample.Criteria andStyleTypeIn(List<Integer> values) {
            return in(styleType, values);
        }

        public ShiguStoreStyleExample.Criteria andStyleTypeNotIn(List<Integer> values) {
            return notIn(styleType, values);
        }

        public ShiguStoreStyleExample.Criteria andStyleTypeBetween(Integer value1, Integer value2) {
            return between(styleType, value1, value2);
        }

        public ShiguStoreStyleExample.Criteria andStyleTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(styleType, value1, value2);
        }
        public ShiguStoreStyleExample.Criteria andStyleIdIsNull() {
            return isNull(styleId);
        }

        public ShiguStoreStyleExample.Criteria andStyleIdIsNotNull() {
            return isNotNull(styleId);
        }

        public ShiguStoreStyleExample.Criteria andStyleIdEqualTo(Long value) {
            return equalTo(styleId, value);
        }

        public ShiguStoreStyleExample.Criteria andStyleIdNotEqualTo(Long value) {
            return notEqualTo(styleId, value);
        }

        public ShiguStoreStyleExample.Criteria andStyleIdGreaterThan(Long value) {
            return greaterThan(styleId, value);
        }

        public ShiguStoreStyleExample.Criteria andStyleIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(styleId, value);
        }

        public ShiguStoreStyleExample.Criteria andStyleIdLessThan(Long value) {
            return lessThan(styleId, value);
        }

        public ShiguStoreStyleExample.Criteria andStyleIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(styleId, value);
        }

        public ShiguStoreStyleExample.Criteria andStyleIdIn(List<Long> values) {
            return in(styleId, values);
        }

        public ShiguStoreStyleExample.Criteria andStyleIdNotIn(List<Long> values) {
            return notIn(styleId, values);
        }

        public ShiguStoreStyleExample.Criteria andStyleIdBetween(Long value1, Long value2) {
            return between(styleId, value1, value2);
        }

        public ShiguStoreStyleExample.Criteria andStyleIdNotBetween(Long value1, Long value2) {
            return notBetween(styleId, value1, value2);
        }
        public ShiguStoreStyleExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public ShiguStoreStyleExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public ShiguStoreStyleExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public ShiguStoreStyleExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public ShiguStoreStyleExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public ShiguStoreStyleExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public ShiguStoreStyleExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public ShiguStoreStyleExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public ShiguStoreStyleExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public ShiguStoreStyleExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public ShiguStoreStyleExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public ShiguStoreStyleExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public ShiguStoreStyleExample.Criteria andRemarkIsNull() {
            return isNull(remark);
        }

        public ShiguStoreStyleExample.Criteria andRemarkIsNotNull() {
            return isNotNull(remark);
        }

        public ShiguStoreStyleExample.Criteria andRemarkEqualTo(String value) {
            return equalTo(remark, value);
        }

        public ShiguStoreStyleExample.Criteria andRemarkNotEqualTo(String value) {
            return notEqualTo(remark, value);
        }

        public ShiguStoreStyleExample.Criteria andRemarkGreaterThan(String value) {
            return greaterThan(remark, value);
        }

        public ShiguStoreStyleExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark, value);
        }

        public ShiguStoreStyleExample.Criteria andRemarkLessThan(String value) {
            return lessThan(remark, value);
        }

        public ShiguStoreStyleExample.Criteria andRemarkLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark, value);
        }

        public ShiguStoreStyleExample.Criteria andRemarkLike(String value) {
            return like(remark, value);
        }

        public ShiguStoreStyleExample.Criteria andRemarkNotLike(String value) {
            return notLike(remark, value);
        }

        public ShiguStoreStyleExample.Criteria andRemarkIn(List<String> values) {
            return in(remark, values);
        }

        public ShiguStoreStyleExample.Criteria andRemarkNotIn(List<String> values) {
            return notIn(remark, values);
        }

        public ShiguStoreStyleExample.Criteria andRemarkBetween(String value1, String value2) {
            return between(remark, value1, value2);
        }

        public ShiguStoreStyleExample.Criteria andRemarkNotBetween(String value1, String value2) {
            return notBetween(remark, value1, value2);
        }
        public ShiguStoreStyleExample.Criteria andStyleNameIsNull() {
            return isNull(styleName);
        }

        public ShiguStoreStyleExample.Criteria andStyleNameIsNotNull() {
            return isNotNull(styleName);
        }

        public ShiguStoreStyleExample.Criteria andStyleNameEqualTo(String value) {
            return equalTo(styleName, value);
        }

        public ShiguStoreStyleExample.Criteria andStyleNameNotEqualTo(String value) {
            return notEqualTo(styleName, value);
        }

        public ShiguStoreStyleExample.Criteria andStyleNameGreaterThan(String value) {
            return greaterThan(styleName, value);
        }

        public ShiguStoreStyleExample.Criteria andStyleNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(styleName, value);
        }

        public ShiguStoreStyleExample.Criteria andStyleNameLessThan(String value) {
            return lessThan(styleName, value);
        }

        public ShiguStoreStyleExample.Criteria andStyleNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(styleName, value);
        }

        public ShiguStoreStyleExample.Criteria andStyleNameLike(String value) {
            return like(styleName, value);
        }

        public ShiguStoreStyleExample.Criteria andStyleNameNotLike(String value) {
            return notLike(styleName, value);
        }

        public ShiguStoreStyleExample.Criteria andStyleNameIn(List<String> values) {
            return in(styleName, values);
        }

        public ShiguStoreStyleExample.Criteria andStyleNameNotIn(List<String> values) {
            return notIn(styleName, values);
        }

        public ShiguStoreStyleExample.Criteria andStyleNameBetween(String value1, String value2) {
            return between(styleName, value1, value2);
        }

        public ShiguStoreStyleExample.Criteria andStyleNameNotBetween(String value1, String value2) {
            return notBetween(styleName, value1, value2);
        }
        public ShiguStoreStyleExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public ShiguStoreStyleExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public ShiguStoreStyleExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public ShiguStoreStyleExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public ShiguStoreStyleExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public ShiguStoreStyleExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public ShiguStoreStyleExample.Criteria andUserIdIsNull() {
            return isNull(userId);
        }

        public ShiguStoreStyleExample.Criteria andUserIdIsNotNull() {
            return isNotNull(userId);
        }

        public ShiguStoreStyleExample.Criteria andUserIdEqualTo(Long value) {
            return equalTo(userId, value);
        }

        public ShiguStoreStyleExample.Criteria andUserIdNotEqualTo(Long value) {
            return notEqualTo(userId, value);
        }

        public ShiguStoreStyleExample.Criteria andUserIdGreaterThan(Long value) {
            return greaterThan(userId, value);
        }

        public ShiguStoreStyleExample.Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(userId, value);
        }

        public ShiguStoreStyleExample.Criteria andUserIdLessThan(Long value) {
            return lessThan(userId, value);
        }

        public ShiguStoreStyleExample.Criteria andUserIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(userId, value);
        }

        public ShiguStoreStyleExample.Criteria andUserIdIn(List<Long> values) {
            return in(userId, values);
        }

        public ShiguStoreStyleExample.Criteria andUserIdNotIn(List<Long> values) {
            return notIn(userId, values);
        }

        public ShiguStoreStyleExample.Criteria andUserIdBetween(Long value1, Long value2) {
            return between(userId, value1, value2);
        }

        public ShiguStoreStyleExample.Criteria andUserIdNotBetween(Long value1, Long value2) {
            return notBetween(userId, value1, value2);
        }
        public ShiguStoreStyleExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public ShiguStoreStyleExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public ShiguStoreStyleExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public ShiguStoreStyleExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public ShiguStoreStyleExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public ShiguStoreStyleExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public ShiguStoreStyleExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public ShiguStoreStyleExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public ShiguStoreStyleExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public ShiguStoreStyleExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public ShiguStoreStyleExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public ShiguStoreStyleExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public ShiguStoreStyleExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}