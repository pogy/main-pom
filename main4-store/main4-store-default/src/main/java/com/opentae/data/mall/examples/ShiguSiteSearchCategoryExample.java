package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguSiteSearchCategory;

import java.util.*;
public class ShiguSiteSearchCategoryExample extends SgExample<ShiguSiteSearchCategoryExample.Criteria> {
    public static final Class<ShiguSiteSearchCategory> beanClass = ShiguSiteSearchCategory.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn display;
    public static EntityColumn cname;
    public static EntityColumn icon;
    public static EntityColumn topCid;
    public static EntityColumn type;
    public static EntityColumn cStatus;
    public static EntityColumn parentCname;
    public static EntityColumn parentCid;
    public static EntityColumn remark4;
    public static EntityColumn id;
    public static EntityColumn keyword;
    public static EntityColumn remark1;
    public static EntityColumn remark3;
    public static EntityColumn cid;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        display = listMap.get("display");
        cname = listMap.get("cname");
        icon = listMap.get("icon");
        topCid = listMap.get("topCid");
        type = listMap.get("type");
        cStatus = listMap.get("cStatus");
        parentCname = listMap.get("parentCname");
        parentCid = listMap.get("parentCid");
        remark4 = listMap.get("remark4");
        id = listMap.get("id");
        keyword = listMap.get("keyword");
        remark1 = listMap.get("remark1");
        remark3 = listMap.get("remark3");
        cid = listMap.get("cid");
        remark2 = listMap.get("remark2");
        }

    public ShiguSiteSearchCategoryExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguSiteSearchCategoryExample.Criteria createCriteriaInternal() {
        return new ShiguSiteSearchCategoryExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguSiteSearchCategoryExample.Criteria andDisplayIsNull() {
            return isNull(display);
        }

        public ShiguSiteSearchCategoryExample.Criteria andDisplayIsNotNull() {
            return isNotNull(display);
        }

        public ShiguSiteSearchCategoryExample.Criteria andDisplayEqualTo(Integer value) {
            return equalTo(display, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andDisplayNotEqualTo(Integer value) {
            return notEqualTo(display, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andDisplayGreaterThan(Integer value) {
            return greaterThan(display, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andDisplayGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(display, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andDisplayLessThan(Integer value) {
            return lessThan(display, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andDisplayLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(display, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andDisplayIn(List<Integer> values) {
            return in(display, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andDisplayNotIn(List<Integer> values) {
            return notIn(display, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andDisplayBetween(Integer value1, Integer value2) {
            return between(display, value1, value2);
        }

        public ShiguSiteSearchCategoryExample.Criteria andDisplayNotBetween(Integer value1, Integer value2) {
            return notBetween(display, value1, value2);
        }
        public ShiguSiteSearchCategoryExample.Criteria andCnameIsNull() {
            return isNull(cname);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCnameIsNotNull() {
            return isNotNull(cname);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCnameEqualTo(String value) {
            return equalTo(cname, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCnameNotEqualTo(String value) {
            return notEqualTo(cname, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCnameGreaterThan(String value) {
            return greaterThan(cname, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCnameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cname, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCnameLessThan(String value) {
            return lessThan(cname, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCnameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cname, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCnameLike(String value) {
            return like(cname, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCnameNotLike(String value) {
            return notLike(cname, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCnameIn(List<String> values) {
            return in(cname, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCnameNotIn(List<String> values) {
            return notIn(cname, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCnameBetween(String value1, String value2) {
            return between(cname, value1, value2);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCnameNotBetween(String value1, String value2) {
            return notBetween(cname, value1, value2);
        }
        public ShiguSiteSearchCategoryExample.Criteria andIconIsNull() {
            return isNull(icon);
        }

        public ShiguSiteSearchCategoryExample.Criteria andIconIsNotNull() {
            return isNotNull(icon);
        }

        public ShiguSiteSearchCategoryExample.Criteria andIconEqualTo(String value) {
            return equalTo(icon, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andIconNotEqualTo(String value) {
            return notEqualTo(icon, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andIconGreaterThan(String value) {
            return greaterThan(icon, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andIconGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(icon, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andIconLessThan(String value) {
            return lessThan(icon, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andIconLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(icon, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andIconLike(String value) {
            return like(icon, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andIconNotLike(String value) {
            return notLike(icon, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andIconIn(List<String> values) {
            return in(icon, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andIconNotIn(List<String> values) {
            return notIn(icon, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andIconBetween(String value1, String value2) {
            return between(icon, value1, value2);
        }

        public ShiguSiteSearchCategoryExample.Criteria andIconNotBetween(String value1, String value2) {
            return notBetween(icon, value1, value2);
        }
        public ShiguSiteSearchCategoryExample.Criteria andTopCidIsNull() {
            return isNull(topCid);
        }

        public ShiguSiteSearchCategoryExample.Criteria andTopCidIsNotNull() {
            return isNotNull(topCid);
        }

        public ShiguSiteSearchCategoryExample.Criteria andTopCidEqualTo(Long value) {
            return equalTo(topCid, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andTopCidNotEqualTo(Long value) {
            return notEqualTo(topCid, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andTopCidGreaterThan(Long value) {
            return greaterThan(topCid, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andTopCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(topCid, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andTopCidLessThan(Long value) {
            return lessThan(topCid, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andTopCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(topCid, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andTopCidIn(List<Long> values) {
            return in(topCid, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andTopCidNotIn(List<Long> values) {
            return notIn(topCid, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andTopCidBetween(Long value1, Long value2) {
            return between(topCid, value1, value2);
        }

        public ShiguSiteSearchCategoryExample.Criteria andTopCidNotBetween(Long value1, Long value2) {
            return notBetween(topCid, value1, value2);
        }
        public ShiguSiteSearchCategoryExample.Criteria andTypeIsNull() {
            return isNull(type);
        }

        public ShiguSiteSearchCategoryExample.Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public ShiguSiteSearchCategoryExample.Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public ShiguSiteSearchCategoryExample.Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
        public ShiguSiteSearchCategoryExample.Criteria andCStatusIsNull() {
            return isNull(cStatus);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCStatusIsNotNull() {
            return isNotNull(cStatus);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCStatusEqualTo(Integer value) {
            return equalTo(cStatus, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCStatusNotEqualTo(Integer value) {
            return notEqualTo(cStatus, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCStatusGreaterThan(Integer value) {
            return greaterThan(cStatus, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(cStatus, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCStatusLessThan(Integer value) {
            return lessThan(cStatus, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(cStatus, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCStatusIn(List<Integer> values) {
            return in(cStatus, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCStatusNotIn(List<Integer> values) {
            return notIn(cStatus, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCStatusBetween(Integer value1, Integer value2) {
            return between(cStatus, value1, value2);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(cStatus, value1, value2);
        }
        public ShiguSiteSearchCategoryExample.Criteria andParentCnameIsNull() {
            return isNull(parentCname);
        }

        public ShiguSiteSearchCategoryExample.Criteria andParentCnameIsNotNull() {
            return isNotNull(parentCname);
        }

        public ShiguSiteSearchCategoryExample.Criteria andParentCnameEqualTo(String value) {
            return equalTo(parentCname, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andParentCnameNotEqualTo(String value) {
            return notEqualTo(parentCname, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andParentCnameGreaterThan(String value) {
            return greaterThan(parentCname, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andParentCnameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(parentCname, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andParentCnameLessThan(String value) {
            return lessThan(parentCname, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andParentCnameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(parentCname, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andParentCnameLike(String value) {
            return like(parentCname, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andParentCnameNotLike(String value) {
            return notLike(parentCname, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andParentCnameIn(List<String> values) {
            return in(parentCname, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andParentCnameNotIn(List<String> values) {
            return notIn(parentCname, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andParentCnameBetween(String value1, String value2) {
            return between(parentCname, value1, value2);
        }

        public ShiguSiteSearchCategoryExample.Criteria andParentCnameNotBetween(String value1, String value2) {
            return notBetween(parentCname, value1, value2);
        }
        public ShiguSiteSearchCategoryExample.Criteria andParentCidIsNull() {
            return isNull(parentCid);
        }

        public ShiguSiteSearchCategoryExample.Criteria andParentCidIsNotNull() {
            return isNotNull(parentCid);
        }

        public ShiguSiteSearchCategoryExample.Criteria andParentCidEqualTo(Long value) {
            return equalTo(parentCid, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andParentCidNotEqualTo(Long value) {
            return notEqualTo(parentCid, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andParentCidGreaterThan(Long value) {
            return greaterThan(parentCid, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andParentCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentCid, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andParentCidLessThan(Long value) {
            return lessThan(parentCid, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andParentCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentCid, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andParentCidIn(List<Long> values) {
            return in(parentCid, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andParentCidNotIn(List<Long> values) {
            return notIn(parentCid, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andParentCidBetween(Long value1, Long value2) {
            return between(parentCid, value1, value2);
        }

        public ShiguSiteSearchCategoryExample.Criteria andParentCidNotBetween(Long value1, Long value2) {
            return notBetween(parentCid, value1, value2);
        }
        public ShiguSiteSearchCategoryExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public ShiguSiteSearchCategoryExample.Criteria andIdIsNull() {
            return isNull(id);
        }

        public ShiguSiteSearchCategoryExample.Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public ShiguSiteSearchCategoryExample.Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public ShiguSiteSearchCategoryExample.Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public ShiguSiteSearchCategoryExample.Criteria andKeywordIsNull() {
            return isNull(keyword);
        }

        public ShiguSiteSearchCategoryExample.Criteria andKeywordIsNotNull() {
            return isNotNull(keyword);
        }

        public ShiguSiteSearchCategoryExample.Criteria andKeywordEqualTo(String value) {
            return equalTo(keyword, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andKeywordNotEqualTo(String value) {
            return notEqualTo(keyword, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andKeywordGreaterThan(String value) {
            return greaterThan(keyword, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andKeywordGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(keyword, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andKeywordLessThan(String value) {
            return lessThan(keyword, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andKeywordLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(keyword, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andKeywordLike(String value) {
            return like(keyword, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andKeywordNotLike(String value) {
            return notLike(keyword, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andKeywordIn(List<String> values) {
            return in(keyword, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andKeywordNotIn(List<String> values) {
            return notIn(keyword, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andKeywordBetween(String value1, String value2) {
            return between(keyword, value1, value2);
        }

        public ShiguSiteSearchCategoryExample.Criteria andKeywordNotBetween(String value1, String value2) {
            return notBetween(keyword, value1, value2);
        }
        public ShiguSiteSearchCategoryExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public ShiguSiteSearchCategoryExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public ShiguSiteSearchCategoryExample.Criteria andCidIsNull() {
            return isNull(cid);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public ShiguSiteSearchCategoryExample.Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
        }
        public ShiguSiteSearchCategoryExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public ShiguSiteSearchCategoryExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}