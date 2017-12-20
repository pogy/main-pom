package com.opentae.data.daifa.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.daifa.beans.DaifaPostCustomer;

import java.util.*;
public class DaifaPostCustomerExample extends SgExample<DaifaPostCustomerExample.Criteria> {
    public static final Class<DaifaPostCustomer> beanClass = DaifaPostCustomer.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn postCustomerId;
    public static EntityColumn dfSellerId;
    public static EntityColumn useStatus;
    public static EntityColumn expressId;
    public static EntityColumn express;
    public static EntityColumn expressCompanyCode;
    public static EntityColumn isNeedCustomer;
    public static EntityColumn customerName;
    public static EntityColumn customerPwd;
    public static EntityColumn monthCode;
    public static EntityColumn sendSite;
    public static EntityColumn logisticCode;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        postCustomerId = listMap.get("postCustomerId");
        dfSellerId = listMap.get("dfSellerId");
        useStatus = listMap.get("useStatus");
        expressId = listMap.get("expressId");
        express = listMap.get("express");
        expressCompanyCode = listMap.get("expressCompanyCode");
        isNeedCustomer = listMap.get("isNeedCustomer");
        customerName = listMap.get("customerName");
        customerPwd = listMap.get("customerPwd");
        monthCode = listMap.get("monthCode");
        sendSite = listMap.get("sendSite");
        logisticCode = listMap.get("logisticCode");
    }

    public DaifaPostCustomerExample() {
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

        public Criteria andPostCustomerIdIsNull() {
            return isNull(postCustomerId);
        }

        public Criteria andPostCustomerIdIsNotNull() {
            return isNotNull(postCustomerId);
        }

        public Criteria andPostCustomerIdEqualTo(Long value) {
            return equalTo(postCustomerId, value);
        }

        public Criteria andPostCustomerIdNotEqualTo(Long value) {
            return notEqualTo(postCustomerId, value);
        }

        public Criteria andPostCustomerIdGreaterThan(Long value) {
            return greaterThan(postCustomerId, value);
        }

        public Criteria andPostCustomerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(postCustomerId, value);
        }

        public Criteria andPostCustomerIdLessThan(Long value) {
            return lessThan(postCustomerId, value);
        }

        public Criteria andPostCustomerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(postCustomerId, value);
        }

        public Criteria andPostCustomerIdIn(List<Long> values) {
            return in(postCustomerId, values);
        }

        public Criteria andPostCustomerIdNotIn(List<Long> values) {
            return notIn(postCustomerId, values);
        }

        public Criteria andPostCustomerIdBetween(Long value1, Long value2) {
            return between(postCustomerId, value1, value2);
        }

        public Criteria andPostCustomerIdNotBetween(Long value1, Long value2) {
            return notBetween(postCustomerId, value1, value2);
        }
        public Criteria andDfSellerIdIsNull() {
            return isNull(dfSellerId);
        }

        public Criteria andDfSellerIdIsNotNull() {
            return isNotNull(dfSellerId);
        }

        public Criteria andDfSellerIdEqualTo(Long value) {
            return equalTo(dfSellerId, value);
        }

        public Criteria andDfSellerIdNotEqualTo(Long value) {
            return notEqualTo(dfSellerId, value);
        }

        public Criteria andDfSellerIdGreaterThan(Long value) {
            return greaterThan(dfSellerId, value);
        }

        public Criteria andDfSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfSellerId, value);
        }

        public Criteria andDfSellerIdLessThan(Long value) {
            return lessThan(dfSellerId, value);
        }

        public Criteria andDfSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfSellerId, value);
        }

        public Criteria andDfSellerIdIn(List<Long> values) {
            return in(dfSellerId, values);
        }

        public Criteria andDfSellerIdNotIn(List<Long> values) {
            return notIn(dfSellerId, values);
        }

        public Criteria andDfSellerIdBetween(Long value1, Long value2) {
            return between(dfSellerId, value1, value2);
        }

        public Criteria andDfSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(dfSellerId, value1, value2);
        }
        public Criteria andUseStatusIsNull() {
            return isNull(useStatus);
        }

        public Criteria andUseStatusIsNotNull() {
            return isNotNull(useStatus);
        }

        public Criteria andUseStatusEqualTo(Integer value) {
            return equalTo(useStatus, value);
        }

        public Criteria andUseStatusNotEqualTo(Integer value) {
            return notEqualTo(useStatus, value);
        }

        public Criteria andUseStatusGreaterThan(Integer value) {
            return greaterThan(useStatus, value);
        }

        public Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(useStatus, value);
        }

        public Criteria andUseStatusLessThan(Integer value) {
            return lessThan(useStatus, value);
        }

        public Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(useStatus, value);
        }

        public Criteria andUseStatusIn(List<Integer> values) {
            return in(useStatus, values);
        }

        public Criteria andUseStatusNotIn(List<Integer> values) {
            return notIn(useStatus, values);
        }

        public Criteria andUseStatusBetween(Integer value1, Integer value2) {
            return between(useStatus, value1, value2);
        }

        public Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(useStatus, value1, value2);
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
        public Criteria andExpressIsNull() {
            return isNull(express);
        }

        public Criteria andExpressIsNotNull() {
            return isNotNull(express);
        }

        public Criteria andExpressEqualTo(String value) {
            return equalTo(express, value);
        }

        public Criteria andExpressNotEqualTo(String value) {
            return notEqualTo(express, value);
        }

        public Criteria andExpressGreaterThan(String value) {
            return greaterThan(express, value);
        }

        public Criteria andExpressGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(express, value);
        }

        public Criteria andExpressLessThan(String value) {
            return lessThan(express, value);
        }

        public Criteria andExpressLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(express, value);
        }

        public Criteria andExpressLike(String value) {
            return like(express, value);
        }

        public Criteria andExpressNotLike(String value) {
            return notLike(express, value);
        }

        public Criteria andExpressIn(List<String> values) {
            return in(express, values);
        }

        public Criteria andExpressNotIn(List<String> values) {
            return notIn(express, values);
        }

        public Criteria andExpressBetween(String value1, String value2) {
            return between(express, value1, value2);
        }

        public Criteria andExpressNotBetween(String value1, String value2) {
            return notBetween(express, value1, value2);
        }
        public Criteria andExpressCompanyCodeIsNull() {
            return isNull(expressCompanyCode);
        }

        public Criteria andExpressCompanyCodeIsNotNull() {
            return isNotNull(expressCompanyCode);
        }

        public Criteria andExpressCompanyCodeEqualTo(String value) {
            return equalTo(expressCompanyCode, value);
        }

        public Criteria andExpressCompanyCodeNotEqualTo(String value) {
            return notEqualTo(expressCompanyCode, value);
        }

        public Criteria andExpressCompanyCodeGreaterThan(String value) {
            return greaterThan(expressCompanyCode, value);
        }

        public Criteria andExpressCompanyCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressCompanyCode, value);
        }

        public Criteria andExpressCompanyCodeLessThan(String value) {
            return lessThan(expressCompanyCode, value);
        }

        public Criteria andExpressCompanyCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressCompanyCode, value);
        }

        public Criteria andExpressCompanyCodeLike(String value) {
            return like(expressCompanyCode, value);
        }

        public Criteria andExpressCompanyCodeNotLike(String value) {
            return notLike(expressCompanyCode, value);
        }

        public Criteria andExpressCompanyCodeIn(List<String> values) {
            return in(expressCompanyCode, values);
        }

        public Criteria andExpressCompanyCodeNotIn(List<String> values) {
            return notIn(expressCompanyCode, values);
        }

        public Criteria andExpressCompanyCodeBetween(String value1, String value2) {
            return between(expressCompanyCode, value1, value2);
        }

        public Criteria andExpressCompanyCodeNotBetween(String value1, String value2) {
            return notBetween(expressCompanyCode, value1, value2);
        }
        public Criteria andIsNeedCustomerIsNull() {
            return isNull(isNeedCustomer);
        }

        public Criteria andIsNeedCustomerIsNotNull() {
            return isNotNull(isNeedCustomer);
        }

        public Criteria andIsNeedCustomerEqualTo(Integer value) {
            return equalTo(isNeedCustomer, value);
        }

        public Criteria andIsNeedCustomerNotEqualTo(Integer value) {
            return notEqualTo(isNeedCustomer, value);
        }

        public Criteria andIsNeedCustomerGreaterThan(Integer value) {
            return greaterThan(isNeedCustomer, value);
        }

        public Criteria andIsNeedCustomerGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isNeedCustomer, value);
        }

        public Criteria andIsNeedCustomerLessThan(Integer value) {
            return lessThan(isNeedCustomer, value);
        }

        public Criteria andIsNeedCustomerLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isNeedCustomer, value);
        }

        public Criteria andIsNeedCustomerIn(List<Integer> values) {
            return in(isNeedCustomer, values);
        }

        public Criteria andIsNeedCustomerNotIn(List<Integer> values) {
            return notIn(isNeedCustomer, values);
        }

        public Criteria andIsNeedCustomerBetween(Integer value1, Integer value2) {
            return between(isNeedCustomer, value1, value2);
        }

        public Criteria andIsNeedCustomerNotBetween(Integer value1, Integer value2) {
            return notBetween(isNeedCustomer, value1, value2);
        }
        public Criteria andCustomerNameIsNull() {
            return isNull(customerName);
        }

        public Criteria andCustomerNameIsNotNull() {
            return isNotNull(customerName);
        }

        public Criteria andCustomerNameEqualTo(String value) {
            return equalTo(customerName, value);
        }

        public Criteria andCustomerNameNotEqualTo(String value) {
            return notEqualTo(customerName, value);
        }

        public Criteria andCustomerNameGreaterThan(String value) {
            return greaterThan(customerName, value);
        }

        public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(customerName, value);
        }

        public Criteria andCustomerNameLessThan(String value) {
            return lessThan(customerName, value);
        }

        public Criteria andCustomerNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(customerName, value);
        }

        public Criteria andCustomerNameLike(String value) {
            return like(customerName, value);
        }

        public Criteria andCustomerNameNotLike(String value) {
            return notLike(customerName, value);
        }

        public Criteria andCustomerNameIn(List<String> values) {
            return in(customerName, values);
        }

        public Criteria andCustomerNameNotIn(List<String> values) {
            return notIn(customerName, values);
        }

        public Criteria andCustomerNameBetween(String value1, String value2) {
            return between(customerName, value1, value2);
        }

        public Criteria andCustomerNameNotBetween(String value1, String value2) {
            return notBetween(customerName, value1, value2);
        }
        public Criteria andCustomerPwdIsNull() {
            return isNull(customerPwd);
        }

        public Criteria andCustomerPwdIsNotNull() {
            return isNotNull(customerPwd);
        }

        public Criteria andCustomerPwdEqualTo(String value) {
            return equalTo(customerPwd, value);
        }

        public Criteria andCustomerPwdNotEqualTo(String value) {
            return notEqualTo(customerPwd, value);
        }

        public Criteria andCustomerPwdGreaterThan(String value) {
            return greaterThan(customerPwd, value);
        }

        public Criteria andCustomerPwdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(customerPwd, value);
        }

        public Criteria andCustomerPwdLessThan(String value) {
            return lessThan(customerPwd, value);
        }

        public Criteria andCustomerPwdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(customerPwd, value);
        }

        public Criteria andCustomerPwdLike(String value) {
            return like(customerPwd, value);
        }

        public Criteria andCustomerPwdNotLike(String value) {
            return notLike(customerPwd, value);
        }

        public Criteria andCustomerPwdIn(List<String> values) {
            return in(customerPwd, values);
        }

        public Criteria andCustomerPwdNotIn(List<String> values) {
            return notIn(customerPwd, values);
        }

        public Criteria andCustomerPwdBetween(String value1, String value2) {
            return between(customerPwd, value1, value2);
        }

        public Criteria andCustomerPwdNotBetween(String value1, String value2) {
            return notBetween(customerPwd, value1, value2);
        }
        public Criteria andMonthCodeIsNull() {
            return isNull(monthCode);
        }

        public Criteria andMonthCodeIsNotNull() {
            return isNotNull(monthCode);
        }

        public Criteria andMonthCodeEqualTo(String value) {
            return equalTo(monthCode, value);
        }

        public Criteria andMonthCodeNotEqualTo(String value) {
            return notEqualTo(monthCode, value);
        }

        public Criteria andMonthCodeGreaterThan(String value) {
            return greaterThan(monthCode, value);
        }

        public Criteria andMonthCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(monthCode, value);
        }

        public Criteria andMonthCodeLessThan(String value) {
            return lessThan(monthCode, value);
        }

        public Criteria andMonthCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(monthCode, value);
        }

        public Criteria andMonthCodeLike(String value) {
            return like(monthCode, value);
        }

        public Criteria andMonthCodeNotLike(String value) {
            return notLike(monthCode, value);
        }

        public Criteria andMonthCodeIn(List<String> values) {
            return in(monthCode, values);
        }

        public Criteria andMonthCodeNotIn(List<String> values) {
            return notIn(monthCode, values);
        }

        public Criteria andMonthCodeBetween(String value1, String value2) {
            return between(monthCode, value1, value2);
        }

        public Criteria andMonthCodeNotBetween(String value1, String value2) {
            return notBetween(monthCode, value1, value2);
        }
        public Criteria andSendSiteIsNull() {
            return isNull(sendSite);
        }

        public Criteria andSendSiteIsNotNull() {
            return isNotNull(sendSite);
        }

        public Criteria andSendSiteEqualTo(String value) {
            return equalTo(sendSite, value);
        }

        public Criteria andSendSiteNotEqualTo(String value) {
            return notEqualTo(sendSite, value);
        }

        public Criteria andSendSiteGreaterThan(String value) {
            return greaterThan(sendSite, value);
        }

        public Criteria andSendSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sendSite, value);
        }

        public Criteria andSendSiteLessThan(String value) {
            return lessThan(sendSite, value);
        }

        public Criteria andSendSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sendSite, value);
        }

        public Criteria andSendSiteLike(String value) {
            return like(sendSite, value);
        }

        public Criteria andSendSiteNotLike(String value) {
            return notLike(sendSite, value);
        }

        public Criteria andSendSiteIn(List<String> values) {
            return in(sendSite, values);
        }

        public Criteria andSendSiteNotIn(List<String> values) {
            return notIn(sendSite, values);
        }

        public Criteria andSendSiteBetween(String value1, String value2) {
            return between(sendSite, value1, value2);
        }

        public Criteria andSendSiteNotBetween(String value1, String value2) {
            return notBetween(sendSite, value1, value2);
        }
        public Criteria andLogisticCodeIsNull() {
            return isNull(logisticCode);
        }

        public Criteria andLogisticCodeIsNotNull() {
            return isNotNull(logisticCode);
        }

        public Criteria andLogisticCodeEqualTo(String value) {
            return equalTo(logisticCode, value);
        }

        public Criteria andLogisticCodeNotEqualTo(String value) {
            return notEqualTo(logisticCode, value);
        }

        public Criteria andLogisticCodeGreaterThan(String value) {
            return greaterThan(logisticCode, value);
        }

        public Criteria andLogisticCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(logisticCode, value);
        }

        public Criteria andLogisticCodeLessThan(String value) {
            return lessThan(logisticCode, value);
        }

        public Criteria andLogisticCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(logisticCode, value);
        }

        public Criteria andLogisticCodeLike(String value) {
            return like(logisticCode, value);
        }

        public Criteria andLogisticCodeNotLike(String value) {
            return notLike(logisticCode, value);
        }

        public Criteria andLogisticCodeIn(List<String> values) {
            return in(logisticCode, values);
        }

        public Criteria andLogisticCodeNotIn(List<String> values) {
            return notIn(logisticCode, values);
        }

        public Criteria andLogisticCodeBetween(String value1, String value2) {
            return between(logisticCode, value1, value2);
        }

        public Criteria andLogisticCodeNotBetween(String value1, String value2) {
            return notBetween(logisticCode, value1, value2);
        }
    }
}
