package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaCallExpress;

import java.util.*;
public class DaifaCallExpressExample extends SgExample<DaifaCallExpressExample.Criteria> {
    public static final Class<DaifaCallExpress> beanClass = DaifaCallExpress.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn dfTradeId;
    public static EntityColumn sellerId;
    public static EntityColumn jsonData;
    public static EntityColumn sortingCode;
    public static EntityColumn createTime;
    public static EntityColumn packageCode;
    public static EntityColumn expressCode;
    public static EntityColumn packageName;
    public static EntityColumn expressId;
    public static EntityColumn markDestination;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        dfTradeId = listMap.get("dfTradeId");
        sellerId = listMap.get("sellerId");
        jsonData = listMap.get("jsonData");
        sortingCode = listMap.get("sortingCode");
        createTime = listMap.get("createTime");
        packageCode = listMap.get("packageCode");
        expressCode = listMap.get("expressCode");
        packageName = listMap.get("packageName");
        expressId = listMap.get("expressId");
        markDestination = listMap.get("markDestination");
        }

    public DaifaCallExpressExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaCallExpressExample.Criteria createCriteriaInternal() {
        return new DaifaCallExpressExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaCallExpressExample.Criteria andDfTradeIdIsNull() {
            return isNull(dfTradeId);
        }

        public DaifaCallExpressExample.Criteria andDfTradeIdIsNotNull() {
            return isNotNull(dfTradeId);
        }

        public DaifaCallExpressExample.Criteria andDfTradeIdEqualTo(Long value) {
            return equalTo(dfTradeId, value);
        }

        public DaifaCallExpressExample.Criteria andDfTradeIdNotEqualTo(Long value) {
            return notEqualTo(dfTradeId, value);
        }

        public DaifaCallExpressExample.Criteria andDfTradeIdGreaterThan(Long value) {
            return greaterThan(dfTradeId, value);
        }

        public DaifaCallExpressExample.Criteria andDfTradeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfTradeId, value);
        }

        public DaifaCallExpressExample.Criteria andDfTradeIdLessThan(Long value) {
            return lessThan(dfTradeId, value);
        }

        public DaifaCallExpressExample.Criteria andDfTradeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfTradeId, value);
        }

        public DaifaCallExpressExample.Criteria andDfTradeIdIn(List<Long> values) {
            return in(dfTradeId, values);
        }

        public DaifaCallExpressExample.Criteria andDfTradeIdNotIn(List<Long> values) {
            return notIn(dfTradeId, values);
        }

        public DaifaCallExpressExample.Criteria andDfTradeIdBetween(Long value1, Long value2) {
            return between(dfTradeId, value1, value2);
        }

        public DaifaCallExpressExample.Criteria andDfTradeIdNotBetween(Long value1, Long value2) {
            return notBetween(dfTradeId, value1, value2);
        }
        public DaifaCallExpressExample.Criteria andSellerIdIsNull() {
            return isNull(sellerId);
        }

        public DaifaCallExpressExample.Criteria andSellerIdIsNotNull() {
            return isNotNull(sellerId);
        }

        public DaifaCallExpressExample.Criteria andSellerIdEqualTo(Long value) {
            return equalTo(sellerId, value);
        }

        public DaifaCallExpressExample.Criteria andSellerIdNotEqualTo(Long value) {
            return notEqualTo(sellerId, value);
        }

        public DaifaCallExpressExample.Criteria andSellerIdGreaterThan(Long value) {
            return greaterThan(sellerId, value);
        }

        public DaifaCallExpressExample.Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerId, value);
        }

        public DaifaCallExpressExample.Criteria andSellerIdLessThan(Long value) {
            return lessThan(sellerId, value);
        }

        public DaifaCallExpressExample.Criteria andSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerId, value);
        }

        public DaifaCallExpressExample.Criteria andSellerIdIn(List<Long> values) {
            return in(sellerId, values);
        }

        public DaifaCallExpressExample.Criteria andSellerIdNotIn(List<Long> values) {
            return notIn(sellerId, values);
        }

        public DaifaCallExpressExample.Criteria andSellerIdBetween(Long value1, Long value2) {
            return between(sellerId, value1, value2);
        }

        public DaifaCallExpressExample.Criteria andSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(sellerId, value1, value2);
        }
        public DaifaCallExpressExample.Criteria andJsonDataIsNull() {
            return isNull(jsonData);
        }

        public DaifaCallExpressExample.Criteria andJsonDataIsNotNull() {
            return isNotNull(jsonData);
        }

        public DaifaCallExpressExample.Criteria andJsonDataEqualTo(String value) {
            return equalTo(jsonData, value);
        }

        public DaifaCallExpressExample.Criteria andJsonDataNotEqualTo(String value) {
            return notEqualTo(jsonData, value);
        }

        public DaifaCallExpressExample.Criteria andJsonDataGreaterThan(String value) {
            return greaterThan(jsonData, value);
        }

        public DaifaCallExpressExample.Criteria andJsonDataGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(jsonData, value);
        }

        public DaifaCallExpressExample.Criteria andJsonDataLessThan(String value) {
            return lessThan(jsonData, value);
        }

        public DaifaCallExpressExample.Criteria andJsonDataLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(jsonData, value);
        }

        public DaifaCallExpressExample.Criteria andJsonDataLike(String value) {
            return like(jsonData, value);
        }

        public DaifaCallExpressExample.Criteria andJsonDataNotLike(String value) {
            return notLike(jsonData, value);
        }

        public DaifaCallExpressExample.Criteria andJsonDataIn(List<String> values) {
            return in(jsonData, values);
        }

        public DaifaCallExpressExample.Criteria andJsonDataNotIn(List<String> values) {
            return notIn(jsonData, values);
        }

        public DaifaCallExpressExample.Criteria andJsonDataBetween(String value1, String value2) {
            return between(jsonData, value1, value2);
        }

        public DaifaCallExpressExample.Criteria andJsonDataNotBetween(String value1, String value2) {
            return notBetween(jsonData, value1, value2);
        }
        public DaifaCallExpressExample.Criteria andSortingCodeIsNull() {
            return isNull(sortingCode);
        }

        public DaifaCallExpressExample.Criteria andSortingCodeIsNotNull() {
            return isNotNull(sortingCode);
        }

        public DaifaCallExpressExample.Criteria andSortingCodeEqualTo(String value) {
            return equalTo(sortingCode, value);
        }

        public DaifaCallExpressExample.Criteria andSortingCodeNotEqualTo(String value) {
            return notEqualTo(sortingCode, value);
        }

        public DaifaCallExpressExample.Criteria andSortingCodeGreaterThan(String value) {
            return greaterThan(sortingCode, value);
        }

        public DaifaCallExpressExample.Criteria andSortingCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sortingCode, value);
        }

        public DaifaCallExpressExample.Criteria andSortingCodeLessThan(String value) {
            return lessThan(sortingCode, value);
        }

        public DaifaCallExpressExample.Criteria andSortingCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sortingCode, value);
        }

        public DaifaCallExpressExample.Criteria andSortingCodeLike(String value) {
            return like(sortingCode, value);
        }

        public DaifaCallExpressExample.Criteria andSortingCodeNotLike(String value) {
            return notLike(sortingCode, value);
        }

        public DaifaCallExpressExample.Criteria andSortingCodeIn(List<String> values) {
            return in(sortingCode, values);
        }

        public DaifaCallExpressExample.Criteria andSortingCodeNotIn(List<String> values) {
            return notIn(sortingCode, values);
        }

        public DaifaCallExpressExample.Criteria andSortingCodeBetween(String value1, String value2) {
            return between(sortingCode, value1, value2);
        }

        public DaifaCallExpressExample.Criteria andSortingCodeNotBetween(String value1, String value2) {
            return notBetween(sortingCode, value1, value2);
        }
        public DaifaCallExpressExample.Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public DaifaCallExpressExample.Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public DaifaCallExpressExample.Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public DaifaCallExpressExample.Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public DaifaCallExpressExample.Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public DaifaCallExpressExample.Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public DaifaCallExpressExample.Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public DaifaCallExpressExample.Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public DaifaCallExpressExample.Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public DaifaCallExpressExample.Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public DaifaCallExpressExample.Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public DaifaCallExpressExample.Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
        public DaifaCallExpressExample.Criteria andPackageCodeIsNull() {
            return isNull(packageCode);
        }

        public DaifaCallExpressExample.Criteria andPackageCodeIsNotNull() {
            return isNotNull(packageCode);
        }

        public DaifaCallExpressExample.Criteria andPackageCodeEqualTo(String value) {
            return equalTo(packageCode, value);
        }

        public DaifaCallExpressExample.Criteria andPackageCodeNotEqualTo(String value) {
            return notEqualTo(packageCode, value);
        }

        public DaifaCallExpressExample.Criteria andPackageCodeGreaterThan(String value) {
            return greaterThan(packageCode, value);
        }

        public DaifaCallExpressExample.Criteria andPackageCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(packageCode, value);
        }

        public DaifaCallExpressExample.Criteria andPackageCodeLessThan(String value) {
            return lessThan(packageCode, value);
        }

        public DaifaCallExpressExample.Criteria andPackageCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(packageCode, value);
        }

        public DaifaCallExpressExample.Criteria andPackageCodeLike(String value) {
            return like(packageCode, value);
        }

        public DaifaCallExpressExample.Criteria andPackageCodeNotLike(String value) {
            return notLike(packageCode, value);
        }

        public DaifaCallExpressExample.Criteria andPackageCodeIn(List<String> values) {
            return in(packageCode, values);
        }

        public DaifaCallExpressExample.Criteria andPackageCodeNotIn(List<String> values) {
            return notIn(packageCode, values);
        }

        public DaifaCallExpressExample.Criteria andPackageCodeBetween(String value1, String value2) {
            return between(packageCode, value1, value2);
        }

        public DaifaCallExpressExample.Criteria andPackageCodeNotBetween(String value1, String value2) {
            return notBetween(packageCode, value1, value2);
        }
        public DaifaCallExpressExample.Criteria andExpressCodeIsNull() {
            return isNull(expressCode);
        }

        public DaifaCallExpressExample.Criteria andExpressCodeIsNotNull() {
            return isNotNull(expressCode);
        }

        public DaifaCallExpressExample.Criteria andExpressCodeEqualTo(String value) {
            return equalTo(expressCode, value);
        }

        public DaifaCallExpressExample.Criteria andExpressCodeNotEqualTo(String value) {
            return notEqualTo(expressCode, value);
        }

        public DaifaCallExpressExample.Criteria andExpressCodeGreaterThan(String value) {
            return greaterThan(expressCode, value);
        }

        public DaifaCallExpressExample.Criteria andExpressCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressCode, value);
        }

        public DaifaCallExpressExample.Criteria andExpressCodeLessThan(String value) {
            return lessThan(expressCode, value);
        }

        public DaifaCallExpressExample.Criteria andExpressCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressCode, value);
        }

        public DaifaCallExpressExample.Criteria andExpressCodeLike(String value) {
            return like(expressCode, value);
        }

        public DaifaCallExpressExample.Criteria andExpressCodeNotLike(String value) {
            return notLike(expressCode, value);
        }

        public DaifaCallExpressExample.Criteria andExpressCodeIn(List<String> values) {
            return in(expressCode, values);
        }

        public DaifaCallExpressExample.Criteria andExpressCodeNotIn(List<String> values) {
            return notIn(expressCode, values);
        }

        public DaifaCallExpressExample.Criteria andExpressCodeBetween(String value1, String value2) {
            return between(expressCode, value1, value2);
        }

        public DaifaCallExpressExample.Criteria andExpressCodeNotBetween(String value1, String value2) {
            return notBetween(expressCode, value1, value2);
        }
        public DaifaCallExpressExample.Criteria andPackageNameIsNull() {
            return isNull(packageName);
        }

        public DaifaCallExpressExample.Criteria andPackageNameIsNotNull() {
            return isNotNull(packageName);
        }

        public DaifaCallExpressExample.Criteria andPackageNameEqualTo(String value) {
            return equalTo(packageName, value);
        }

        public DaifaCallExpressExample.Criteria andPackageNameNotEqualTo(String value) {
            return notEqualTo(packageName, value);
        }

        public DaifaCallExpressExample.Criteria andPackageNameGreaterThan(String value) {
            return greaterThan(packageName, value);
        }

        public DaifaCallExpressExample.Criteria andPackageNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(packageName, value);
        }

        public DaifaCallExpressExample.Criteria andPackageNameLessThan(String value) {
            return lessThan(packageName, value);
        }

        public DaifaCallExpressExample.Criteria andPackageNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(packageName, value);
        }

        public DaifaCallExpressExample.Criteria andPackageNameLike(String value) {
            return like(packageName, value);
        }

        public DaifaCallExpressExample.Criteria andPackageNameNotLike(String value) {
            return notLike(packageName, value);
        }

        public DaifaCallExpressExample.Criteria andPackageNameIn(List<String> values) {
            return in(packageName, values);
        }

        public DaifaCallExpressExample.Criteria andPackageNameNotIn(List<String> values) {
            return notIn(packageName, values);
        }

        public DaifaCallExpressExample.Criteria andPackageNameBetween(String value1, String value2) {
            return between(packageName, value1, value2);
        }

        public DaifaCallExpressExample.Criteria andPackageNameNotBetween(String value1, String value2) {
            return notBetween(packageName, value1, value2);
        }
        public DaifaCallExpressExample.Criteria andExpressIdIsNull() {
            return isNull(expressId);
        }

        public DaifaCallExpressExample.Criteria andExpressIdIsNotNull() {
            return isNotNull(expressId);
        }

        public DaifaCallExpressExample.Criteria andExpressIdEqualTo(Long value) {
            return equalTo(expressId, value);
        }

        public DaifaCallExpressExample.Criteria andExpressIdNotEqualTo(Long value) {
            return notEqualTo(expressId, value);
        }

        public DaifaCallExpressExample.Criteria andExpressIdGreaterThan(Long value) {
            return greaterThan(expressId, value);
        }

        public DaifaCallExpressExample.Criteria andExpressIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(expressId, value);
        }

        public DaifaCallExpressExample.Criteria andExpressIdLessThan(Long value) {
            return lessThan(expressId, value);
        }

        public DaifaCallExpressExample.Criteria andExpressIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(expressId, value);
        }

        public DaifaCallExpressExample.Criteria andExpressIdIn(List<Long> values) {
            return in(expressId, values);
        }

        public DaifaCallExpressExample.Criteria andExpressIdNotIn(List<Long> values) {
            return notIn(expressId, values);
        }

        public DaifaCallExpressExample.Criteria andExpressIdBetween(Long value1, Long value2) {
            return between(expressId, value1, value2);
        }

        public DaifaCallExpressExample.Criteria andExpressIdNotBetween(Long value1, Long value2) {
            return notBetween(expressId, value1, value2);
        }
        public DaifaCallExpressExample.Criteria andMarkDestinationIsNull() {
            return isNull(markDestination);
        }

        public DaifaCallExpressExample.Criteria andMarkDestinationIsNotNull() {
            return isNotNull(markDestination);
        }

        public DaifaCallExpressExample.Criteria andMarkDestinationEqualTo(String value) {
            return equalTo(markDestination, value);
        }

        public DaifaCallExpressExample.Criteria andMarkDestinationNotEqualTo(String value) {
            return notEqualTo(markDestination, value);
        }

        public DaifaCallExpressExample.Criteria andMarkDestinationGreaterThan(String value) {
            return greaterThan(markDestination, value);
        }

        public DaifaCallExpressExample.Criteria andMarkDestinationGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(markDestination, value);
        }

        public DaifaCallExpressExample.Criteria andMarkDestinationLessThan(String value) {
            return lessThan(markDestination, value);
        }

        public DaifaCallExpressExample.Criteria andMarkDestinationLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(markDestination, value);
        }

        public DaifaCallExpressExample.Criteria andMarkDestinationLike(String value) {
            return like(markDestination, value);
        }

        public DaifaCallExpressExample.Criteria andMarkDestinationNotLike(String value) {
            return notLike(markDestination, value);
        }

        public DaifaCallExpressExample.Criteria andMarkDestinationIn(List<String> values) {
            return in(markDestination, values);
        }

        public DaifaCallExpressExample.Criteria andMarkDestinationNotIn(List<String> values) {
            return notIn(markDestination, values);
        }

        public DaifaCallExpressExample.Criteria andMarkDestinationBetween(String value1, String value2) {
            return between(markDestination, value1, value2);
        }

        public DaifaCallExpressExample.Criteria andMarkDestinationNotBetween(String value1, String value2) {
            return notBetween(markDestination, value1, value2);
        }
    }
}