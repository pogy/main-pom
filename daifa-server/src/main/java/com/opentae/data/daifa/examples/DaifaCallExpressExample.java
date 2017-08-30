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
    public static EntityColumn expressId;
    public static EntityColumn expressCode;
    public static EntityColumn markDestination;
    public static EntityColumn packageName;
    public static EntityColumn jsonData;
    public static EntityColumn createTime;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        dfTradeId = listMap.get("dfTradeId");
        sellerId = listMap.get("sellerId");
        expressId = listMap.get("expressId");
        expressCode = listMap.get("expressCode");
        markDestination = listMap.get("markDestination");
        packageName = listMap.get("packageName");
        jsonData = listMap.get("jsonData");
        createTime = listMap.get("createTime");
    }

    public DaifaCallExpressExample() {
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

        public Criteria andDfTradeIdIsNull() {
            return isNull(dfTradeId);
        }

        public Criteria andDfTradeIdIsNotNull() {
            return isNotNull(dfTradeId);
        }

        public Criteria andDfTradeIdEqualTo(Long value) {
            return equalTo(dfTradeId, value);
        }

        public Criteria andDfTradeIdNotEqualTo(Long value) {
            return notEqualTo(dfTradeId, value);
        }

        public Criteria andDfTradeIdGreaterThan(Long value) {
            return greaterThan(dfTradeId, value);
        }

        public Criteria andDfTradeIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfTradeId, value);
        }

        public Criteria andDfTradeIdLessThan(Long value) {
            return lessThan(dfTradeId, value);
        }

        public Criteria andDfTradeIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfTradeId, value);
        }

        public Criteria andDfTradeIdIn(List<Long> values) {
            return in(dfTradeId, values);
        }

        public Criteria andDfTradeIdNotIn(List<Long> values) {
            return notIn(dfTradeId, values);
        }

        public Criteria andDfTradeIdBetween(Long value1, Long value2) {
            return between(dfTradeId, value1, value2);
        }

        public Criteria andDfTradeIdNotBetween(Long value1, Long value2) {
            return notBetween(dfTradeId, value1, value2);
        }
        public Criteria andSellerIdIsNull() {
            return isNull(sellerId);
        }

        public Criteria andSellerIdIsNotNull() {
            return isNotNull(sellerId);
        }

        public Criteria andSellerIdEqualTo(Long value) {
            return equalTo(sellerId, value);
        }

        public Criteria andSellerIdNotEqualTo(Long value) {
            return notEqualTo(sellerId, value);
        }

        public Criteria andSellerIdGreaterThan(Long value) {
            return greaterThan(sellerId, value);
        }

        public Criteria andSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(sellerId, value);
        }

        public Criteria andSellerIdLessThan(Long value) {
            return lessThan(sellerId, value);
        }

        public Criteria andSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(sellerId, value);
        }

        public Criteria andSellerIdIn(List<Long> values) {
            return in(sellerId, values);
        }

        public Criteria andSellerIdNotIn(List<Long> values) {
            return notIn(sellerId, values);
        }

        public Criteria andSellerIdBetween(Long value1, Long value2) {
            return between(sellerId, value1, value2);
        }

        public Criteria andSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(sellerId, value1, value2);
        }
        public Criteria andExpressIdIsNull() {
            return isNull(expressId);
        }

        public Criteria andExpressIdIsNotNull() {
            return isNotNull(expressId);
        }

        public Criteria andExpressIdEqualTo(Long value) {
            return equalTo(expressId, value);
        }

        public Criteria andExpressIdNotEqualTo(Long value) {
            return notEqualTo(expressId, value);
        }

        public Criteria andExpressIdGreaterThan(Long value) {
            return greaterThan(expressId, value);
        }

        public Criteria andExpressIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(expressId, value);
        }

        public Criteria andExpressIdLessThan(Long value) {
            return lessThan(expressId, value);
        }

        public Criteria andExpressIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(expressId, value);
        }

        public Criteria andExpressIdIn(List<Long> values) {
            return in(expressId, values);
        }

        public Criteria andExpressIdNotIn(List<Long> values) {
            return notIn(expressId, values);
        }

        public Criteria andExpressIdBetween(Long value1, Long value2) {
            return between(expressId, value1, value2);
        }

        public Criteria andExpressIdNotBetween(Long value1, Long value2) {
            return notBetween(expressId, value1, value2);
        }
        public Criteria andExpressCodeIsNull() {
            return isNull(expressCode);
        }

        public Criteria andExpressCodeIsNotNull() {
            return isNotNull(expressCode);
        }

        public Criteria andExpressCodeEqualTo(String value) {
            return equalTo(expressCode, value);
        }

        public Criteria andExpressCodeNotEqualTo(String value) {
            return notEqualTo(expressCode, value);
        }

        public Criteria andExpressCodeGreaterThan(String value) {
            return greaterThan(expressCode, value);
        }

        public Criteria andExpressCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressCode, value);
        }

        public Criteria andExpressCodeLessThan(String value) {
            return lessThan(expressCode, value);
        }

        public Criteria andExpressCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressCode, value);
        }

        public Criteria andExpressCodeLike(String value) {
            return like(expressCode, value);
        }

        public Criteria andExpressCodeNotLike(String value) {
            return notLike(expressCode, value);
        }

        public Criteria andExpressCodeIn(List<String> values) {
            return in(expressCode, values);
        }

        public Criteria andExpressCodeNotIn(List<String> values) {
            return notIn(expressCode, values);
        }

        public Criteria andExpressCodeBetween(String value1, String value2) {
            return between(expressCode, value1, value2);
        }

        public Criteria andExpressCodeNotBetween(String value1, String value2) {
            return notBetween(expressCode, value1, value2);
        }
        public Criteria andMarkDestinationIsNull() {
            return isNull(markDestination);
        }

        public Criteria andMarkDestinationIsNotNull() {
            return isNotNull(markDestination);
        }

        public Criteria andMarkDestinationEqualTo(String value) {
            return equalTo(markDestination, value);
        }

        public Criteria andMarkDestinationNotEqualTo(String value) {
            return notEqualTo(markDestination, value);
        }

        public Criteria andMarkDestinationGreaterThan(String value) {
            return greaterThan(markDestination, value);
        }

        public Criteria andMarkDestinationGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(markDestination, value);
        }

        public Criteria andMarkDestinationLessThan(String value) {
            return lessThan(markDestination, value);
        }

        public Criteria andMarkDestinationLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(markDestination, value);
        }

        public Criteria andMarkDestinationLike(String value) {
            return like(markDestination, value);
        }

        public Criteria andMarkDestinationNotLike(String value) {
            return notLike(markDestination, value);
        }

        public Criteria andMarkDestinationIn(List<String> values) {
            return in(markDestination, values);
        }

        public Criteria andMarkDestinationNotIn(List<String> values) {
            return notIn(markDestination, values);
        }

        public Criteria andMarkDestinationBetween(String value1, String value2) {
            return between(markDestination, value1, value2);
        }

        public Criteria andMarkDestinationNotBetween(String value1, String value2) {
            return notBetween(markDestination, value1, value2);
        }
        public Criteria andPackageNameIsNull() {
            return isNull(packageName);
        }

        public Criteria andPackageNameIsNotNull() {
            return isNotNull(packageName);
        }

        public Criteria andPackageNameEqualTo(String value) {
            return equalTo(packageName, value);
        }

        public Criteria andPackageNameNotEqualTo(String value) {
            return notEqualTo(packageName, value);
        }

        public Criteria andPackageNameGreaterThan(String value) {
            return greaterThan(packageName, value);
        }

        public Criteria andPackageNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(packageName, value);
        }

        public Criteria andPackageNameLessThan(String value) {
            return lessThan(packageName, value);
        }

        public Criteria andPackageNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(packageName, value);
        }

        public Criteria andPackageNameLike(String value) {
            return like(packageName, value);
        }

        public Criteria andPackageNameNotLike(String value) {
            return notLike(packageName, value);
        }

        public Criteria andPackageNameIn(List<String> values) {
            return in(packageName, values);
        }

        public Criteria andPackageNameNotIn(List<String> values) {
            return notIn(packageName, values);
        }

        public Criteria andPackageNameBetween(String value1, String value2) {
            return between(packageName, value1, value2);
        }

        public Criteria andPackageNameNotBetween(String value1, String value2) {
            return notBetween(packageName, value1, value2);
        }
        public Criteria andJsonDataIsNull() {
            return isNull(jsonData);
        }

        public Criteria andJsonDataIsNotNull() {
            return isNotNull(jsonData);
        }

        public Criteria andJsonDataEqualTo(String value) {
            return equalTo(jsonData, value);
        }

        public Criteria andJsonDataNotEqualTo(String value) {
            return notEqualTo(jsonData, value);
        }

        public Criteria andJsonDataGreaterThan(String value) {
            return greaterThan(jsonData, value);
        }

        public Criteria andJsonDataGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(jsonData, value);
        }

        public Criteria andJsonDataLessThan(String value) {
            return lessThan(jsonData, value);
        }

        public Criteria andJsonDataLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(jsonData, value);
        }

        public Criteria andJsonDataLike(String value) {
            return like(jsonData, value);
        }

        public Criteria andJsonDataNotLike(String value) {
            return notLike(jsonData, value);
        }

        public Criteria andJsonDataIn(List<String> values) {
            return in(jsonData, values);
        }

        public Criteria andJsonDataNotIn(List<String> values) {
            return notIn(jsonData, values);
        }

        public Criteria andJsonDataBetween(String value1, String value2) {
            return between(jsonData, value1, value2);
        }

        public Criteria andJsonDataNotBetween(String value1, String value2) {
            return notBetween(jsonData, value1, value2);
        }
        public Criteria andCreateTimeIsNull() {
            return isNull(createTime);
        }

        public Criteria andCreateTimeIsNotNull() {
            return isNotNull(createTime);
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            return equalTo(createTime, value);
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            return notEqualTo(createTime, value);
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            return greaterThan(createTime, value);
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            return greaterThanOrEqualTo(createTime, value);
        }

        public Criteria andCreateTimeLessThan(Date value) {
            return lessThan(createTime, value);
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            return lessThanOrEqualTo(createTime, value);
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            return in(createTime, values);
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            return notIn(createTime, values);
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            return between(createTime, value1, value2);
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            return notBetween(createTime, value1, value2);
        }
    }
}