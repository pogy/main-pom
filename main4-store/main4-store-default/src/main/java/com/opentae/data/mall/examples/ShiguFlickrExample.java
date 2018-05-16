package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ShiguFlickr;

import java.util.*;
public class ShiguFlickrExample extends SgExample<ShiguFlickrExample.Criteria> {
    public static final Class<ShiguFlickr> beanClass = ShiguFlickr.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn fId;
    public static EntityColumn fCover;
    public static EntityColumn fDesc;
    public static EntityColumn storeId;
    public static EntityColumn webSite;
    public static EntityColumn modifyTime;
    public static EntityColumn fName;
    public static EntityColumn createTime;
    public static EntityColumn fStatus;
    public static EntityColumn remark5;
    public static EntityColumn clicks;
    public static EntityColumn remark4;
    public static EntityColumn remark1;
    public static EntityColumn remark3;
    public static EntityColumn cId;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        fId = listMap.get("fId");
        fCover = listMap.get("fCover");
        fDesc = listMap.get("fDesc");
        storeId = listMap.get("storeId");
        webSite = listMap.get("webSite");
        modifyTime = listMap.get("modifyTime");
        fName = listMap.get("fName");
        createTime = listMap.get("createTime");
        fStatus = listMap.get("fStatus");
        remark5 = listMap.get("remark5");
        clicks = listMap.get("clicks");
        remark4 = listMap.get("remark4");
        remark1 = listMap.get("remark1");
        remark3 = listMap.get("remark3");
        cId = listMap.get("cId");
        remark2 = listMap.get("remark2");
        }

    public ShiguFlickrExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ShiguFlickrExample.Criteria createCriteriaInternal() {
        return new ShiguFlickrExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ShiguFlickrExample.Criteria andFIdIsNull() {
            return isNull(fId);
        }

        public ShiguFlickrExample.Criteria andFIdIsNotNull() {
            return isNotNull(fId);
        }

        public ShiguFlickrExample.Criteria andFIdEqualTo(Long value) {
            return equalTo(fId, value);
        }

        public ShiguFlickrExample.Criteria andFIdNotEqualTo(Long value) {
            return notEqualTo(fId, value);
        }

        public ShiguFlickrExample.Criteria andFIdGreaterThan(Long value) {
            return greaterThan(fId, value);
        }

        public ShiguFlickrExample.Criteria andFIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(fId, value);
        }

        public ShiguFlickrExample.Criteria andFIdLessThan(Long value) {
            return lessThan(fId, value);
        }

        public ShiguFlickrExample.Criteria andFIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(fId, value);
        }

        public ShiguFlickrExample.Criteria andFIdIn(List<Long> values) {
            return in(fId, values);
        }

        public ShiguFlickrExample.Criteria andFIdNotIn(List<Long> values) {
            return notIn(fId, values);
        }

        public ShiguFlickrExample.Criteria andFIdBetween(Long value1, Long value2) {
            return between(fId, value1, value2);
        }

        public ShiguFlickrExample.Criteria andFIdNotBetween(Long value1, Long value2) {
            return notBetween(fId, value1, value2);
        }
        public ShiguFlickrExample.Criteria andFCoverIsNull() {
            return isNull(fCover);
        }

        public ShiguFlickrExample.Criteria andFCoverIsNotNull() {
            return isNotNull(fCover);
        }

        public ShiguFlickrExample.Criteria andFCoverEqualTo(String value) {
            return equalTo(fCover, value);
        }

        public ShiguFlickrExample.Criteria andFCoverNotEqualTo(String value) {
            return notEqualTo(fCover, value);
        }

        public ShiguFlickrExample.Criteria andFCoverGreaterThan(String value) {
            return greaterThan(fCover, value);
        }

        public ShiguFlickrExample.Criteria andFCoverGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(fCover, value);
        }

        public ShiguFlickrExample.Criteria andFCoverLessThan(String value) {
            return lessThan(fCover, value);
        }

        public ShiguFlickrExample.Criteria andFCoverLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(fCover, value);
        }

        public ShiguFlickrExample.Criteria andFCoverLike(String value) {
            return like(fCover, value);
        }

        public ShiguFlickrExample.Criteria andFCoverNotLike(String value) {
            return notLike(fCover, value);
        }

        public ShiguFlickrExample.Criteria andFCoverIn(List<String> values) {
            return in(fCover, values);
        }

        public ShiguFlickrExample.Criteria andFCoverNotIn(List<String> values) {
            return notIn(fCover, values);
        }

        public ShiguFlickrExample.Criteria andFCoverBetween(String value1, String value2) {
            return between(fCover, value1, value2);
        }

        public ShiguFlickrExample.Criteria andFCoverNotBetween(String value1, String value2) {
            return notBetween(fCover, value1, value2);
        }
        public ShiguFlickrExample.Criteria andFDescIsNull() {
            return isNull(fDesc);
        }

        public ShiguFlickrExample.Criteria andFDescIsNotNull() {
            return isNotNull(fDesc);
        }

        public ShiguFlickrExample.Criteria andFDescEqualTo(String value) {
            return equalTo(fDesc, value);
        }

        public ShiguFlickrExample.Criteria andFDescNotEqualTo(String value) {
            return notEqualTo(fDesc, value);
        }

        public ShiguFlickrExample.Criteria andFDescGreaterThan(String value) {
            return greaterThan(fDesc, value);
        }

        public ShiguFlickrExample.Criteria andFDescGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(fDesc, value);
        }

        public ShiguFlickrExample.Criteria andFDescLessThan(String value) {
            return lessThan(fDesc, value);
        }

        public ShiguFlickrExample.Criteria andFDescLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(fDesc, value);
        }

        public ShiguFlickrExample.Criteria andFDescLike(String value) {
            return like(fDesc, value);
        }

        public ShiguFlickrExample.Criteria andFDescNotLike(String value) {
            return notLike(fDesc, value);
        }

        public ShiguFlickrExample.Criteria andFDescIn(List<String> values) {
            return in(fDesc, values);
        }

        public ShiguFlickrExample.Criteria andFDescNotIn(List<String> values) {
            return notIn(fDesc, values);
        }

        public ShiguFlickrExample.Criteria andFDescBetween(String value1, String value2) {
            return between(fDesc, value1, value2);
        }

        public ShiguFlickrExample.Criteria andFDescNotBetween(String value1, String value2) {
            return notBetween(fDesc, value1, value2);
        }
        public ShiguFlickrExample.Criteria andStoreIdIsNull() {
            return isNull(storeId);
        }

        public ShiguFlickrExample.Criteria andStoreIdIsNotNull() {
            return isNotNull(storeId);
        }

        public ShiguFlickrExample.Criteria andStoreIdEqualTo(Long value) {
            return equalTo(storeId, value);
        }

        public ShiguFlickrExample.Criteria andStoreIdNotEqualTo(Long value) {
            return notEqualTo(storeId, value);
        }

        public ShiguFlickrExample.Criteria andStoreIdGreaterThan(Long value) {
            return greaterThan(storeId, value);
        }

        public ShiguFlickrExample.Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(storeId, value);
        }

        public ShiguFlickrExample.Criteria andStoreIdLessThan(Long value) {
            return lessThan(storeId, value);
        }

        public ShiguFlickrExample.Criteria andStoreIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(storeId, value);
        }

        public ShiguFlickrExample.Criteria andStoreIdIn(List<Long> values) {
            return in(storeId, values);
        }

        public ShiguFlickrExample.Criteria andStoreIdNotIn(List<Long> values) {
            return notIn(storeId, values);
        }

        public ShiguFlickrExample.Criteria andStoreIdBetween(Long value1, Long value2) {
            return between(storeId, value1, value2);
        }

        public ShiguFlickrExample.Criteria andStoreIdNotBetween(Long value1, Long value2) {
            return notBetween(storeId, value1, value2);
        }
        public ShiguFlickrExample.Criteria andWebSiteIsNull() {
            return isNull(webSite);
        }

        public ShiguFlickrExample.Criteria andWebSiteIsNotNull() {
            return isNotNull(webSite);
        }

        public ShiguFlickrExample.Criteria andWebSiteEqualTo(String value) {
            return equalTo(webSite, value);
        }

        public ShiguFlickrExample.Criteria andWebSiteNotEqualTo(String value) {
            return notEqualTo(webSite, value);
        }

        public ShiguFlickrExample.Criteria andWebSiteGreaterThan(String value) {
            return greaterThan(webSite, value);
        }

        public ShiguFlickrExample.Criteria andWebSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(webSite, value);
        }

        public ShiguFlickrExample.Criteria andWebSiteLessThan(String value) {
            return lessThan(webSite, value);
        }

        public ShiguFlickrExample.Criteria andWebSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(webSite, value);
        }

        public ShiguFlickrExample.Criteria andWebSiteLike(String value) {
            return like(webSite, value);
        }

        public ShiguFlickrExample.Criteria andWebSiteNotLike(String value) {
            return notLike(webSite, value);
        }

        public ShiguFlickrExample.Criteria andWebSiteIn(List<String> values) {
            return in(webSite, values);
        }

        public ShiguFlickrExample.Criteria andWebSiteNotIn(List<String> values) {
            return notIn(webSite, values);
        }

        public ShiguFlickrExample.Criteria andWebSiteBetween(String value1, String value2) {
            return between(webSite, value1, value2);
        }

        public ShiguFlickrExample.Criteria andWebSiteNotBetween(String value1, String value2) {
            return notBetween(webSite, value1, value2);
        }
        public ShiguFlickrExample.Criteria andModifyTimeIsNull() {
            return isNull(modifyTime);
        }

        public ShiguFlickrExample.Criteria andModifyTimeIsNotNull() {
            return isNotNull(modifyTime);
        }

        public ShiguFlickrExample.Criteria andModifyTimeEqualTo(Date value) {
            return equalTo(modifyTime, value);
        }

        public ShiguFlickrExample.Criteria andModifyTimeNotEqualTo(Date value) {
            return notEqualTo(modifyTime, value);
        }

        public ShiguFlickrExample.Criteria andModifyTimeGreaterThan(Date value) {
            return greaterThan(modifyTime, value);
        }

        public ShiguFlickrExample.Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(modifyTime, value);
        }

        public ShiguFlickrExample.Criteria andModifyTimeLessThan(Date value) {
            return lessThan(modifyTime, value);
        }

        public ShiguFlickrExample.Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(modifyTime, value);
        }

        public ShiguFlickrExample.Criteria andModifyTimeIn(List<Date> values) {
            return in(modifyTime, values);
        }

        public ShiguFlickrExample.Criteria andModifyTimeNotIn(List<Date> values) {
            return notIn(modifyTime, values);
        }

        public ShiguFlickrExample.Criteria andModifyTimeBetween(Date value1, Date value2) {
            return between(modifyTime, value1, value2);
        }

        public ShiguFlickrExample.Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            return notBetween(modifyTime, value1, value2);
        }
        public ShiguFlickrExample.Criteria andFNameIsNull() {
            return isNull(fName);
        }

        public ShiguFlickrExample.Criteria andFNameIsNotNull() {
            return isNotNull(fName);
        }

        public ShiguFlickrExample.Criteria andFNameEqualTo(String value) {
            return equalTo(fName, value);
        }

        public ShiguFlickrExample.Criteria andFNameNotEqualTo(String value) {
            return notEqualTo(fName, value);
        }

        public ShiguFlickrExample.Criteria andFNameGreaterThan(String value) {
            return greaterThan(fName, value);
        }

        public ShiguFlickrExample.Criteria andFNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(fName, value);
        }

        public ShiguFlickrExample.Criteria andFNameLessThan(String value) {
            return lessThan(fName, value);
        }

        public ShiguFlickrExample.Criteria andFNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(fName, value);
        }

        public ShiguFlickrExample.Criteria andFNameLike(String value) {
            return like(fName, value);
        }

        public ShiguFlickrExample.Criteria andFNameNotLike(String value) {
            return notLike(fName, value);
        }

        public ShiguFlickrExample.Criteria andFNameIn(List<String> values) {
            return in(fName, values);
        }

        public ShiguFlickrExample.Criteria andFNameNotIn(List<String> values) {
            return notIn(fName, values);
        }

        public ShiguFlickrExample.Criteria andFNameBetween(String value1, String value2) {
            return between(fName, value1, value2);
        }

        public ShiguFlickrExample.Criteria andFNameNotBetween(String value1, String value2) {
            return notBetween(fName, value1, value2);
        }
        public ShiguFlickrExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public ShiguFlickrExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public ShiguFlickrExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public ShiguFlickrExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public ShiguFlickrExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public ShiguFlickrExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public ShiguFlickrExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public ShiguFlickrExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public ShiguFlickrExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public ShiguFlickrExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public ShiguFlickrExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public ShiguFlickrExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public ShiguFlickrExample.Criteria andFStatusIsNull() {
            return isNull(fStatus);
        }

        public ShiguFlickrExample.Criteria andFStatusIsNotNull() {
            return isNotNull(fStatus);
        }

        public ShiguFlickrExample.Criteria andFStatusEqualTo(Integer value) {
            return equalTo(fStatus, value);
        }

        public ShiguFlickrExample.Criteria andFStatusNotEqualTo(Integer value) {
            return notEqualTo(fStatus, value);
        }

        public ShiguFlickrExample.Criteria andFStatusGreaterThan(Integer value) {
            return greaterThan(fStatus, value);
        }

        public ShiguFlickrExample.Criteria andFStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(fStatus, value);
        }

        public ShiguFlickrExample.Criteria andFStatusLessThan(Integer value) {
            return lessThan(fStatus, value);
        }

        public ShiguFlickrExample.Criteria andFStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(fStatus, value);
        }

        public ShiguFlickrExample.Criteria andFStatusIn(List<Integer> values) {
            return in(fStatus, values);
        }

        public ShiguFlickrExample.Criteria andFStatusNotIn(List<Integer> values) {
            return notIn(fStatus, values);
        }

        public ShiguFlickrExample.Criteria andFStatusBetween(Integer value1, Integer value2) {
            return between(fStatus, value1, value2);
        }

        public ShiguFlickrExample.Criteria andFStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(fStatus, value1, value2);
        }
        public ShiguFlickrExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public ShiguFlickrExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public ShiguFlickrExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public ShiguFlickrExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public ShiguFlickrExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public ShiguFlickrExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public ShiguFlickrExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public ShiguFlickrExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public ShiguFlickrExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public ShiguFlickrExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public ShiguFlickrExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public ShiguFlickrExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public ShiguFlickrExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public ShiguFlickrExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public ShiguFlickrExample.Criteria andClicksIsNull() {
            return isNull(clicks);
        }

        public ShiguFlickrExample.Criteria andClicksIsNotNull() {
            return isNotNull(clicks);
        }

        public ShiguFlickrExample.Criteria andClicksEqualTo(Long value) {
            return equalTo(clicks, value);
        }

        public ShiguFlickrExample.Criteria andClicksNotEqualTo(Long value) {
            return notEqualTo(clicks, value);
        }

        public ShiguFlickrExample.Criteria andClicksGreaterThan(Long value) {
            return greaterThan(clicks, value);
        }

        public ShiguFlickrExample.Criteria andClicksGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(clicks, value);
        }

        public ShiguFlickrExample.Criteria andClicksLessThan(Long value) {
            return lessThan(clicks, value);
        }

        public ShiguFlickrExample.Criteria andClicksLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(clicks, value);
        }

        public ShiguFlickrExample.Criteria andClicksIn(List<Long> values) {
            return in(clicks, values);
        }

        public ShiguFlickrExample.Criteria andClicksNotIn(List<Long> values) {
            return notIn(clicks, values);
        }

        public ShiguFlickrExample.Criteria andClicksBetween(Long value1, Long value2) {
            return between(clicks, value1, value2);
        }

        public ShiguFlickrExample.Criteria andClicksNotBetween(Long value1, Long value2) {
            return notBetween(clicks, value1, value2);
        }
        public ShiguFlickrExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public ShiguFlickrExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public ShiguFlickrExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public ShiguFlickrExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public ShiguFlickrExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public ShiguFlickrExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public ShiguFlickrExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public ShiguFlickrExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public ShiguFlickrExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public ShiguFlickrExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public ShiguFlickrExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public ShiguFlickrExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public ShiguFlickrExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public ShiguFlickrExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public ShiguFlickrExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public ShiguFlickrExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public ShiguFlickrExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public ShiguFlickrExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public ShiguFlickrExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public ShiguFlickrExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public ShiguFlickrExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public ShiguFlickrExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public ShiguFlickrExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public ShiguFlickrExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public ShiguFlickrExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public ShiguFlickrExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public ShiguFlickrExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public ShiguFlickrExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public ShiguFlickrExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public ShiguFlickrExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public ShiguFlickrExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public ShiguFlickrExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public ShiguFlickrExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public ShiguFlickrExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public ShiguFlickrExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public ShiguFlickrExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public ShiguFlickrExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public ShiguFlickrExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public ShiguFlickrExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public ShiguFlickrExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public ShiguFlickrExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public ShiguFlickrExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public ShiguFlickrExample.Criteria andCIdIsNull() {
            return isNull(cId);
        }

        public ShiguFlickrExample.Criteria andCIdIsNotNull() {
            return isNotNull(cId);
        }

        public ShiguFlickrExample.Criteria andCIdEqualTo(Long value) {
            return equalTo(cId, value);
        }

        public ShiguFlickrExample.Criteria andCIdNotEqualTo(Long value) {
            return notEqualTo(cId, value);
        }

        public ShiguFlickrExample.Criteria andCIdGreaterThan(Long value) {
            return greaterThan(cId, value);
        }

        public ShiguFlickrExample.Criteria andCIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(cId, value);
        }

        public ShiguFlickrExample.Criteria andCIdLessThan(Long value) {
            return lessThan(cId, value);
        }

        public ShiguFlickrExample.Criteria andCIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(cId, value);
        }

        public ShiguFlickrExample.Criteria andCIdIn(List<Long> values) {
            return in(cId, values);
        }

        public ShiguFlickrExample.Criteria andCIdNotIn(List<Long> values) {
            return notIn(cId, values);
        }

        public ShiguFlickrExample.Criteria andCIdBetween(Long value1, Long value2) {
            return between(cId, value1, value2);
        }

        public ShiguFlickrExample.Criteria andCIdNotBetween(Long value1, Long value2) {
            return notBetween(cId, value1, value2);
        }
        public ShiguFlickrExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public ShiguFlickrExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public ShiguFlickrExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public ShiguFlickrExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public ShiguFlickrExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public ShiguFlickrExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public ShiguFlickrExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public ShiguFlickrExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public ShiguFlickrExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public ShiguFlickrExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public ShiguFlickrExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public ShiguFlickrExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public ShiguFlickrExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public ShiguFlickrExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}