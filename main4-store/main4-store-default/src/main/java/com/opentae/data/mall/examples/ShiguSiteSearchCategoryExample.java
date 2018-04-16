package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguSiteSearchCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShiguSiteSearchCategoryExample extends SgExample<ShiguSiteSearchCategoryExample.Criteria> {
    public static final Class<ShiguSiteSearchCategory> beanClass = ShiguSiteSearchCategory.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn display;
    public static EntityColumn sex;
    public static EntityColumn cname;
    public static EntityColumn icon;
    public static EntityColumn topCid;
    public static EntityColumn hot;
    public static EntityColumn type;
    public static EntityColumn cStatus;
    public static EntityColumn webSite;
    public static EntityColumn parentCname;
    public static EntityColumn parentCid;
    public static EntityColumn infoType;
    public static EntityColumn pageType;
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
        sex = listMap.get("sex");
        cname = listMap.get("cname");
        icon = listMap.get("icon");
        topCid = listMap.get("topCid");
        hot = listMap.get("hot");
        type = listMap.get("type");
        cStatus = listMap.get("cStatus");
        webSite = listMap.get("webSite");
        parentCname = listMap.get("parentCname");
        parentCid = listMap.get("parentCid");
        infoType = listMap.get("infoType");
        pageType = listMap.get("pageType");
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
    protected Criteria createCriteriaInternal() {
        return new Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public Criteria andDisplayIsNull() {
            return isNull(display);
        }

        public Criteria andDisplayIsNotNull() {
            return isNotNull(display);
        }

        public Criteria andDisplayEqualTo(Integer value) {
            return equalTo(display, value);
        }

        public Criteria andDisplayNotEqualTo(Integer value) {
            return notEqualTo(display, value);
        }

        public Criteria andDisplayGreaterThan(Integer value) {
            return greaterThan(display, value);
        }

        public Criteria andDisplayGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(display, value);
        }

        public Criteria andDisplayLessThan(Integer value) {
            return lessThan(display, value);
        }

        public Criteria andDisplayLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(display, value);
        }

        public Criteria andDisplayIn(List<Integer> values) {
            return in(display, values);
        }

        public Criteria andDisplayNotIn(List<Integer> values) {
            return notIn(display, values);
        }

        public Criteria andDisplayBetween(Integer value1, Integer value2) {
            return between(display, value1, value2);
        }

        public Criteria andDisplayNotBetween(Integer value1, Integer value2) {
            return notBetween(display, value1, value2);
        }
        public Criteria andSexIsNull() {
            return isNull(sex);
        }

        public Criteria andSexIsNotNull() {
            return isNotNull(sex);
        }

        public Criteria andSexEqualTo(Integer value) {
            return equalTo(sex, value);
        }

        public Criteria andSexNotEqualTo(Integer value) {
            return notEqualTo(sex, value);
        }

        public Criteria andSexGreaterThan(Integer value) {
            return greaterThan(sex, value);
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(sex, value);
        }

        public Criteria andSexLessThan(Integer value) {
            return lessThan(sex, value);
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(sex, value);
        }

        public Criteria andSexIn(List<Integer> values) {
            return in(sex, values);
        }

        public Criteria andSexNotIn(List<Integer> values) {
            return notIn(sex, values);
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            return between(sex, value1, value2);
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            return notBetween(sex, value1, value2);
        }
        public Criteria andCnameIsNull() {
            return isNull(cname);
        }

        public Criteria andCnameIsNotNull() {
            return isNotNull(cname);
        }

        public Criteria andCnameEqualTo(String value) {
            return equalTo(cname, value);
        }

        public Criteria andCnameNotEqualTo(String value) {
            return notEqualTo(cname, value);
        }

        public Criteria andCnameGreaterThan(String value) {
            return greaterThan(cname, value);
        }

        public Criteria andCnameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(cname, value);
        }

        public Criteria andCnameLessThan(String value) {
            return lessThan(cname, value);
        }

        public Criteria andCnameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(cname, value);
        }

        public Criteria andCnameLike(String value) {
            return like(cname, value);
        }

        public Criteria andCnameNotLike(String value) {
            return notLike(cname, value);
        }

        public Criteria andCnameIn(List<String> values) {
            return in(cname, values);
        }

        public Criteria andCnameNotIn(List<String> values) {
            return notIn(cname, values);
        }

        public Criteria andCnameBetween(String value1, String value2) {
            return between(cname, value1, value2);
        }

        public Criteria andCnameNotBetween(String value1, String value2) {
            return notBetween(cname, value1, value2);
        }
        public Criteria andIconIsNull() {
            return isNull(icon);
        }

        public Criteria andIconIsNotNull() {
            return isNotNull(icon);
        }

        public Criteria andIconEqualTo(String value) {
            return equalTo(icon, value);
        }

        public Criteria andIconNotEqualTo(String value) {
            return notEqualTo(icon, value);
        }

        public Criteria andIconGreaterThan(String value) {
            return greaterThan(icon, value);
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(icon, value);
        }

        public Criteria andIconLessThan(String value) {
            return lessThan(icon, value);
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(icon, value);
        }

        public Criteria andIconLike(String value) {
            return like(icon, value);
        }

        public Criteria andIconNotLike(String value) {
            return notLike(icon, value);
        }

        public Criteria andIconIn(List<String> values) {
            return in(icon, values);
        }

        public Criteria andIconNotIn(List<String> values) {
            return notIn(icon, values);
        }

        public Criteria andIconBetween(String value1, String value2) {
            return between(icon, value1, value2);
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            return notBetween(icon, value1, value2);
        }
        public Criteria andTopCidIsNull() {
            return isNull(topCid);
        }

        public Criteria andTopCidIsNotNull() {
            return isNotNull(topCid);
        }

        public Criteria andTopCidEqualTo(Long value) {
            return equalTo(topCid, value);
        }

        public Criteria andTopCidNotEqualTo(Long value) {
            return notEqualTo(topCid, value);
        }

        public Criteria andTopCidGreaterThan(Long value) {
            return greaterThan(topCid, value);
        }

        public Criteria andTopCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(topCid, value);
        }

        public Criteria andTopCidLessThan(Long value) {
            return lessThan(topCid, value);
        }

        public Criteria andTopCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(topCid, value);
        }

        public Criteria andTopCidIn(List<Long> values) {
            return in(topCid, values);
        }

        public Criteria andTopCidNotIn(List<Long> values) {
            return notIn(topCid, values);
        }

        public Criteria andTopCidBetween(Long value1, Long value2) {
            return between(topCid, value1, value2);
        }

        public Criteria andTopCidNotBetween(Long value1, Long value2) {
            return notBetween(topCid, value1, value2);
        }
        public Criteria andHotIsNull() {
            return isNull(hot);
        }

        public Criteria andHotIsNotNull() {
            return isNotNull(hot);
        }

        public Criteria andHotEqualTo(Integer value) {
            return equalTo(hot, value);
        }

        public Criteria andHotNotEqualTo(Integer value) {
            return notEqualTo(hot, value);
        }

        public Criteria andHotGreaterThan(Integer value) {
            return greaterThan(hot, value);
        }

        public Criteria andHotGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(hot, value);
        }

        public Criteria andHotLessThan(Integer value) {
            return lessThan(hot, value);
        }

        public Criteria andHotLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(hot, value);
        }

        public Criteria andHotIn(List<Integer> values) {
            return in(hot, values);
        }

        public Criteria andHotNotIn(List<Integer> values) {
            return notIn(hot, values);
        }

        public Criteria andHotBetween(Integer value1, Integer value2) {
            return between(hot, value1, value2);
        }

        public Criteria andHotNotBetween(Integer value1, Integer value2) {
            return notBetween(hot, value1, value2);
        }
        public Criteria andTypeIsNull() {
            return isNull(type);
        }

        public Criteria andTypeIsNotNull() {
            return isNotNull(type);
        }

        public Criteria andTypeEqualTo(Integer value) {
            return equalTo(type, value);
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            return notEqualTo(type, value);
        }

        public Criteria andTypeGreaterThan(Integer value) {
            return greaterThan(type, value);
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(type, value);
        }

        public Criteria andTypeLessThan(Integer value) {
            return lessThan(type, value);
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(type, value);
        }

        public Criteria andTypeIn(List<Integer> values) {
            return in(type, values);
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            return notIn(type, values);
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            return between(type, value1, value2);
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(type, value1, value2);
        }
        public Criteria andCStatusIsNull() {
            return isNull(cStatus);
        }

        public Criteria andCStatusIsNotNull() {
            return isNotNull(cStatus);
        }

        public Criteria andCStatusEqualTo(Integer value) {
            return equalTo(cStatus, value);
        }

        public Criteria andCStatusNotEqualTo(Integer value) {
            return notEqualTo(cStatus, value);
        }

        public Criteria andCStatusGreaterThan(Integer value) {
            return greaterThan(cStatus, value);
        }

        public Criteria andCStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(cStatus, value);
        }

        public Criteria andCStatusLessThan(Integer value) {
            return lessThan(cStatus, value);
        }

        public Criteria andCStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(cStatus, value);
        }

        public Criteria andCStatusIn(List<Integer> values) {
            return in(cStatus, values);
        }

        public Criteria andCStatusNotIn(List<Integer> values) {
            return notIn(cStatus, values);
        }

        public Criteria andCStatusBetween(Integer value1, Integer value2) {
            return between(cStatus, value1, value2);
        }

        public Criteria andCStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(cStatus, value1, value2);
        }
        public Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public Criteria andParentCnameIsNull() {
            return isNull(parentCname);
        }

        public Criteria andParentCnameIsNotNull() {
            return isNotNull(parentCname);
        }

        public Criteria andParentCnameEqualTo(String value) {
            return equalTo(parentCname, value);
        }

        public Criteria andParentCnameNotEqualTo(String value) {
            return notEqualTo(parentCname, value);
        }

        public Criteria andParentCnameGreaterThan(String value) {
            return greaterThan(parentCname, value);
        }

        public Criteria andParentCnameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(parentCname, value);
        }

        public Criteria andParentCnameLessThan(String value) {
            return lessThan(parentCname, value);
        }

        public Criteria andParentCnameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(parentCname, value);
        }

        public Criteria andParentCnameLike(String value) {
            return like(parentCname, value);
        }

        public Criteria andParentCnameNotLike(String value) {
            return notLike(parentCname, value);
        }

        public Criteria andParentCnameIn(List<String> values) {
            return in(parentCname, values);
        }

        public Criteria andParentCnameNotIn(List<String> values) {
            return notIn(parentCname, values);
        }

        public Criteria andParentCnameBetween(String value1, String value2) {
            return between(parentCname, value1, value2);
        }

        public Criteria andParentCnameNotBetween(String value1, String value2) {
            return notBetween(parentCname, value1, value2);
        }
        public Criteria andParentCidIsNull() {
            return isNull(parentCid);
        }

        public Criteria andParentCidIsNotNull() {
            return isNotNull(parentCid);
        }

        public Criteria andParentCidEqualTo(Long value) {
            return equalTo(parentCid, value);
        }

        public Criteria andParentCidNotEqualTo(Long value) {
            return notEqualTo(parentCid, value);
        }

        public Criteria andParentCidGreaterThan(Long value) {
            return greaterThan(parentCid, value);
        }

        public Criteria andParentCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(parentCid, value);
        }

        public Criteria andParentCidLessThan(Long value) {
            return lessThan(parentCid, value);
        }

        public Criteria andParentCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(parentCid, value);
        }

        public Criteria andParentCidIn(List<Long> values) {
            return in(parentCid, values);
        }

        public Criteria andParentCidNotIn(List<Long> values) {
            return notIn(parentCid, values);
        }

        public Criteria andParentCidBetween(Long value1, Long value2) {
            return between(parentCid, value1, value2);
        }

        public Criteria andParentCidNotBetween(Long value1, Long value2) {
            return notBetween(parentCid, value1, value2);
        }
        public Criteria andInfoTypeIsNull() {
            return isNull(infoType);
        }

        public Criteria andInfoTypeIsNotNull() {
            return isNotNull(infoType);
        }

        public Criteria andInfoTypeEqualTo(Integer value) {
            return equalTo(infoType, value);
        }

        public Criteria andInfoTypeNotEqualTo(Integer value) {
            return notEqualTo(infoType, value);
        }

        public Criteria andInfoTypeGreaterThan(Integer value) {
            return greaterThan(infoType, value);
        }

        public Criteria andInfoTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(infoType, value);
        }

        public Criteria andInfoTypeLessThan(Integer value) {
            return lessThan(infoType, value);
        }

        public Criteria andInfoTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(infoType, value);
        }

        public Criteria andInfoTypeIn(List<Integer> values) {
            return in(infoType, values);
        }

        public Criteria andInfoTypeNotIn(List<Integer> values) {
            return notIn(infoType, values);
        }

        public Criteria andInfoTypeBetween(Integer value1, Integer value2) {
            return between(infoType, value1, value2);
        }

        public Criteria andInfoTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(infoType, value1, value2);
        }
        public Criteria andPageTypeIsNull() {
            return isNull(pageType);
        }

        public Criteria andPageTypeIsNotNull() {
            return isNotNull(pageType);
        }

        public Criteria andPageTypeEqualTo(Integer value) {
            return equalTo(pageType, value);
        }

        public Criteria andPageTypeNotEqualTo(Integer value) {
            return notEqualTo(pageType, value);
        }

        public Criteria andPageTypeGreaterThan(Integer value) {
            return greaterThan(pageType, value);
        }

        public Criteria andPageTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(pageType, value);
        }

        public Criteria andPageTypeLessThan(Integer value) {
            return lessThan(pageType, value);
        }

        public Criteria andPageTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(pageType, value);
        }

        public Criteria andPageTypeIn(List<Integer> values) {
            return in(pageType, values);
        }

        public Criteria andPageTypeNotIn(List<Integer> values) {
            return notIn(pageType, values);
        }

        public Criteria andPageTypeBetween(Integer value1, Integer value2) {
            return between(pageType, value1, value2);
        }

        public Criteria andPageTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(pageType, value1, value2);
        }
        public Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public Criteria andIdIsNull() {
            return isNull(id);
        }

        public Criteria andIdIsNotNull() {
            return isNotNull(id);
        }

        public Criteria andIdEqualTo(Long value) {
            return equalTo(id, value);
        }

        public Criteria andIdNotEqualTo(Long value) {
            return notEqualTo(id, value);
        }

        public Criteria andIdGreaterThan(Long value) {
            return greaterThan(id, value);
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(id, value);
        }

        public Criteria andIdLessThan(Long value) {
            return lessThan(id, value);
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(id, value);
        }

        public Criteria andIdIn(List<Long> values) {
            return in(id, values);
        }

        public Criteria andIdNotIn(List<Long> values) {
            return notIn(id, values);
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            return between(id, value1, value2);
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            return notBetween(id, value1, value2);
        }
        public Criteria andKeywordIsNull() {
            return isNull(keyword);
        }

        public Criteria andKeywordIsNotNull() {
            return isNotNull(keyword);
        }

        public Criteria andKeywordEqualTo(String value) {
            return equalTo(keyword, value);
        }

        public Criteria andKeywordNotEqualTo(String value) {
            return notEqualTo(keyword, value);
        }

        public Criteria andKeywordGreaterThan(String value) {
            return greaterThan(keyword, value);
        }

        public Criteria andKeywordGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(keyword, value);
        }

        public Criteria andKeywordLessThan(String value) {
            return lessThan(keyword, value);
        }

        public Criteria andKeywordLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(keyword, value);
        }

        public Criteria andKeywordLike(String value) {
            return like(keyword, value);
        }

        public Criteria andKeywordNotLike(String value) {
            return notLike(keyword, value);
        }

        public Criteria andKeywordIn(List<String> values) {
            return in(keyword, values);
        }

        public Criteria andKeywordNotIn(List<String> values) {
            return notIn(keyword, values);
        }

        public Criteria andKeywordBetween(String value1, String value2) {
            return between(keyword, value1, value2);
        }

        public Criteria andKeywordNotBetween(String value1, String value2) {
            return notBetween(keyword, value1, value2);
        }
        public Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public Criteria andCidIsNull() {
            return isNull(cid);
        }

        public Criteria andCidIsNotNull() {
            return isNotNull(cid);
        }

        public Criteria andCidEqualTo(Long value) {
            return equalTo(cid, value);
        }

        public Criteria andCidNotEqualTo(Long value) {
            return notEqualTo(cid, value);
        }

        public Criteria andCidGreaterThan(Long value) {
            return greaterThan(cid, value);
        }

        public Criteria andCidGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cid, value);
        }

        public Criteria andCidLessThan(Long value) {
            return lessThan(cid, value);
        }

        public Criteria andCidLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cid, value);
        }

        public Criteria andCidIn(List<Long> values) {
            return in(cid, values);
        }

        public Criteria andCidNotIn(List<Long> values) {
            return notIn(cid, values);
        }

        public Criteria andCidBetween(Long value1, Long value2) {
            return between(cid, value1, value2);
        }

        public Criteria andCidNotBetween(Long value1, Long value2) {
            return notBetween(cid, value1, value2);
        }
        public Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}