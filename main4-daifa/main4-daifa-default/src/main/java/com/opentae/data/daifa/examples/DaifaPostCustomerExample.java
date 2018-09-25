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
    public static EntityColumn isNeedCustomer;
    public static EntityColumn dfSellerId;
    public static EntityColumn expressCompanyCode;
    public static EntityColumn express;
    public static EntityColumn manual;
    public static EntityColumn customerName;
    public static EntityColumn useStatus;
    public static EntityColumn monthCode;
    public static EntityColumn allAddress;
    public static EntityColumn sendSite;
    public static EntityColumn expType;
    public static EntityColumn logisticCode;
    public static EntityColumn expressId;
    public static EntityColumn customerPwd;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        postCustomerId = listMap.get("postCustomerId");
        isNeedCustomer = listMap.get("isNeedCustomer");
        dfSellerId = listMap.get("dfSellerId");
        expressCompanyCode = listMap.get("expressCompanyCode");
        express = listMap.get("express");
        manual = listMap.get("manual");
        customerName = listMap.get("customerName");
        useStatus = listMap.get("useStatus");
        monthCode = listMap.get("monthCode");
        allAddress = listMap.get("allAddress");
        sendSite = listMap.get("sendSite");
        expType = listMap.get("expType");
        logisticCode = listMap.get("logisticCode");
        expressId = listMap.get("expressId");
        customerPwd = listMap.get("customerPwd");
        }

    public DaifaPostCustomerExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected DaifaPostCustomerExample.Criteria createCriteriaInternal() {
        return new DaifaPostCustomerExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public DaifaPostCustomerExample.Criteria andPostCustomerIdIsNull() {
            return isNull(postCustomerId);
        }

        public DaifaPostCustomerExample.Criteria andPostCustomerIdIsNotNull() {
            return isNotNull(postCustomerId);
        }

        public DaifaPostCustomerExample.Criteria andPostCustomerIdEqualTo(Long value) {
            return equalTo(postCustomerId, value);
        }

        public DaifaPostCustomerExample.Criteria andPostCustomerIdNotEqualTo(Long value) {
            return notEqualTo(postCustomerId, value);
        }

        public DaifaPostCustomerExample.Criteria andPostCustomerIdGreaterThan(Long value) {
            return greaterThan(postCustomerId, value);
        }

        public DaifaPostCustomerExample.Criteria andPostCustomerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(postCustomerId, value);
        }

        public DaifaPostCustomerExample.Criteria andPostCustomerIdLessThan(Long value) {
            return lessThan(postCustomerId, value);
        }

        public DaifaPostCustomerExample.Criteria andPostCustomerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(postCustomerId, value);
        }

        public DaifaPostCustomerExample.Criteria andPostCustomerIdIn(List<Long> values) {
            return in(postCustomerId, values);
        }

        public DaifaPostCustomerExample.Criteria andPostCustomerIdNotIn(List<Long> values) {
            return notIn(postCustomerId, values);
        }

        public DaifaPostCustomerExample.Criteria andPostCustomerIdBetween(Long value1, Long value2) {
            return between(postCustomerId, value1, value2);
        }

        public DaifaPostCustomerExample.Criteria andPostCustomerIdNotBetween(Long value1, Long value2) {
            return notBetween(postCustomerId, value1, value2);
        }
        public DaifaPostCustomerExample.Criteria andIsNeedCustomerIsNull() {
            return isNull(isNeedCustomer);
        }

        public DaifaPostCustomerExample.Criteria andIsNeedCustomerIsNotNull() {
            return isNotNull(isNeedCustomer);
        }

        public DaifaPostCustomerExample.Criteria andIsNeedCustomerEqualTo(Integer value) {
            return equalTo(isNeedCustomer, value);
        }

        public DaifaPostCustomerExample.Criteria andIsNeedCustomerNotEqualTo(Integer value) {
            return notEqualTo(isNeedCustomer, value);
        }

        public DaifaPostCustomerExample.Criteria andIsNeedCustomerGreaterThan(Integer value) {
            return greaterThan(isNeedCustomer, value);
        }

        public DaifaPostCustomerExample.Criteria andIsNeedCustomerGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(isNeedCustomer, value);
        }

        public DaifaPostCustomerExample.Criteria andIsNeedCustomerLessThan(Integer value) {
            return lessThan(isNeedCustomer, value);
        }

        public DaifaPostCustomerExample.Criteria andIsNeedCustomerLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(isNeedCustomer, value);
        }

        public DaifaPostCustomerExample.Criteria andIsNeedCustomerIn(List<Integer> values) {
            return in(isNeedCustomer, values);
        }

        public DaifaPostCustomerExample.Criteria andIsNeedCustomerNotIn(List<Integer> values) {
            return notIn(isNeedCustomer, values);
        }

        public DaifaPostCustomerExample.Criteria andIsNeedCustomerBetween(Integer value1, Integer value2) {
            return between(isNeedCustomer, value1, value2);
        }

        public DaifaPostCustomerExample.Criteria andIsNeedCustomerNotBetween(Integer value1, Integer value2) {
            return notBetween(isNeedCustomer, value1, value2);
        }
        public DaifaPostCustomerExample.Criteria andDfSellerIdIsNull() {
            return isNull(dfSellerId);
        }

        public DaifaPostCustomerExample.Criteria andDfSellerIdIsNotNull() {
            return isNotNull(dfSellerId);
        }

        public DaifaPostCustomerExample.Criteria andDfSellerIdEqualTo(Long value) {
            return equalTo(dfSellerId, value);
        }

        public DaifaPostCustomerExample.Criteria andDfSellerIdNotEqualTo(Long value) {
            return notEqualTo(dfSellerId, value);
        }

        public DaifaPostCustomerExample.Criteria andDfSellerIdGreaterThan(Long value) {
            return greaterThan(dfSellerId, value);
        }

        public DaifaPostCustomerExample.Criteria andDfSellerIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(dfSellerId, value);
        }

        public DaifaPostCustomerExample.Criteria andDfSellerIdLessThan(Long value) {
            return lessThan(dfSellerId, value);
        }

        public DaifaPostCustomerExample.Criteria andDfSellerIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(dfSellerId, value);
        }

        public DaifaPostCustomerExample.Criteria andDfSellerIdIn(List<Long> values) {
            return in(dfSellerId, values);
        }

        public DaifaPostCustomerExample.Criteria andDfSellerIdNotIn(List<Long> values) {
            return notIn(dfSellerId, values);
        }

        public DaifaPostCustomerExample.Criteria andDfSellerIdBetween(Long value1, Long value2) {
            return between(dfSellerId, value1, value2);
        }

        public DaifaPostCustomerExample.Criteria andDfSellerIdNotBetween(Long value1, Long value2) {
            return notBetween(dfSellerId, value1, value2);
        }
        public DaifaPostCustomerExample.Criteria andExpressCompanyCodeIsNull() {
            return isNull(expressCompanyCode);
        }

        public DaifaPostCustomerExample.Criteria andExpressCompanyCodeIsNotNull() {
            return isNotNull(expressCompanyCode);
        }

        public DaifaPostCustomerExample.Criteria andExpressCompanyCodeEqualTo(String value) {
            return equalTo(expressCompanyCode, value);
        }

        public DaifaPostCustomerExample.Criteria andExpressCompanyCodeNotEqualTo(String value) {
            return notEqualTo(expressCompanyCode, value);
        }

        public DaifaPostCustomerExample.Criteria andExpressCompanyCodeGreaterThan(String value) {
            return greaterThan(expressCompanyCode, value);
        }

        public DaifaPostCustomerExample.Criteria andExpressCompanyCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressCompanyCode, value);
        }

        public DaifaPostCustomerExample.Criteria andExpressCompanyCodeLessThan(String value) {
            return lessThan(expressCompanyCode, value);
        }

        public DaifaPostCustomerExample.Criteria andExpressCompanyCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressCompanyCode, value);
        }

        public DaifaPostCustomerExample.Criteria andExpressCompanyCodeLike(String value) {
            return like(expressCompanyCode, value);
        }

        public DaifaPostCustomerExample.Criteria andExpressCompanyCodeNotLike(String value) {
            return notLike(expressCompanyCode, value);
        }

        public DaifaPostCustomerExample.Criteria andExpressCompanyCodeIn(List<String> values) {
            return in(expressCompanyCode, values);
        }

        public DaifaPostCustomerExample.Criteria andExpressCompanyCodeNotIn(List<String> values) {
            return notIn(expressCompanyCode, values);
        }

        public DaifaPostCustomerExample.Criteria andExpressCompanyCodeBetween(String value1, String value2) {
            return between(expressCompanyCode, value1, value2);
        }

        public DaifaPostCustomerExample.Criteria andExpressCompanyCodeNotBetween(String value1, String value2) {
            return notBetween(expressCompanyCode, value1, value2);
        }
        public DaifaPostCustomerExample.Criteria andExpressIsNull() {
            return isNull(express);
        }

        public DaifaPostCustomerExample.Criteria andExpressIsNotNull() {
            return isNotNull(express);
        }

        public DaifaPostCustomerExample.Criteria andExpressEqualTo(String value) {
            return equalTo(express, value);
        }

        public DaifaPostCustomerExample.Criteria andExpressNotEqualTo(String value) {
            return notEqualTo(express, value);
        }

        public DaifaPostCustomerExample.Criteria andExpressGreaterThan(String value) {
            return greaterThan(express, value);
        }

        public DaifaPostCustomerExample.Criteria andExpressGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(express, value);
        }

        public DaifaPostCustomerExample.Criteria andExpressLessThan(String value) {
            return lessThan(express, value);
        }

        public DaifaPostCustomerExample.Criteria andExpressLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(express, value);
        }

        public DaifaPostCustomerExample.Criteria andExpressLike(String value) {
            return like(express, value);
        }

        public DaifaPostCustomerExample.Criteria andExpressNotLike(String value) {
            return notLike(express, value);
        }

        public DaifaPostCustomerExample.Criteria andExpressIn(List<String> values) {
            return in(express, values);
        }

        public DaifaPostCustomerExample.Criteria andExpressNotIn(List<String> values) {
            return notIn(express, values);
        }

        public DaifaPostCustomerExample.Criteria andExpressBetween(String value1, String value2) {
            return between(express, value1, value2);
        }

        public DaifaPostCustomerExample.Criteria andExpressNotBetween(String value1, String value2) {
            return notBetween(express, value1, value2);
        }
        public DaifaPostCustomerExample.Criteria andManualIsNull() {
            return isNull(manual);
        }

        public DaifaPostCustomerExample.Criteria andManualIsNotNull() {
            return isNotNull(manual);
        }

        public DaifaPostCustomerExample.Criteria andManualEqualTo(Integer value) {
            return equalTo(manual, value);
        }

        public DaifaPostCustomerExample.Criteria andManualNotEqualTo(Integer value) {
            return notEqualTo(manual, value);
        }

        public DaifaPostCustomerExample.Criteria andManualGreaterThan(Integer value) {
            return greaterThan(manual, value);
        }

        public DaifaPostCustomerExample.Criteria andManualGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(manual, value);
        }

        public DaifaPostCustomerExample.Criteria andManualLessThan(Integer value) {
            return lessThan(manual, value);
        }

        public DaifaPostCustomerExample.Criteria andManualLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(manual, value);
        }

        public DaifaPostCustomerExample.Criteria andManualIn(List<Integer> values) {
            return in(manual, values);
        }

        public DaifaPostCustomerExample.Criteria andManualNotIn(List<Integer> values) {
            return notIn(manual, values);
        }

        public DaifaPostCustomerExample.Criteria andManualBetween(Integer value1, Integer value2) {
            return between(manual, value1, value2);
        }

        public DaifaPostCustomerExample.Criteria andManualNotBetween(Integer value1, Integer value2) {
            return notBetween(manual, value1, value2);
        }
        public DaifaPostCustomerExample.Criteria andCustomerNameIsNull() {
            return isNull(customerName);
        }

        public DaifaPostCustomerExample.Criteria andCustomerNameIsNotNull() {
            return isNotNull(customerName);
        }

        public DaifaPostCustomerExample.Criteria andCustomerNameEqualTo(String value) {
            return equalTo(customerName, value);
        }

        public DaifaPostCustomerExample.Criteria andCustomerNameNotEqualTo(String value) {
            return notEqualTo(customerName, value);
        }

        public DaifaPostCustomerExample.Criteria andCustomerNameGreaterThan(String value) {
            return greaterThan(customerName, value);
        }

        public DaifaPostCustomerExample.Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(customerName, value);
        }

        public DaifaPostCustomerExample.Criteria andCustomerNameLessThan(String value) {
            return lessThan(customerName, value);
        }

        public DaifaPostCustomerExample.Criteria andCustomerNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(customerName, value);
        }

        public DaifaPostCustomerExample.Criteria andCustomerNameLike(String value) {
            return like(customerName, value);
        }

        public DaifaPostCustomerExample.Criteria andCustomerNameNotLike(String value) {
            return notLike(customerName, value);
        }

        public DaifaPostCustomerExample.Criteria andCustomerNameIn(List<String> values) {
            return in(customerName, values);
        }

        public DaifaPostCustomerExample.Criteria andCustomerNameNotIn(List<String> values) {
            return notIn(customerName, values);
        }

        public DaifaPostCustomerExample.Criteria andCustomerNameBetween(String value1, String value2) {
            return between(customerName, value1, value2);
        }

        public DaifaPostCustomerExample.Criteria andCustomerNameNotBetween(String value1, String value2) {
            return notBetween(customerName, value1, value2);
        }
        public DaifaPostCustomerExample.Criteria andUseStatusIsNull() {
            return isNull(useStatus);
        }

        public DaifaPostCustomerExample.Criteria andUseStatusIsNotNull() {
            return isNotNull(useStatus);
        }

        public DaifaPostCustomerExample.Criteria andUseStatusEqualTo(Integer value) {
            return equalTo(useStatus, value);
        }

        public DaifaPostCustomerExample.Criteria andUseStatusNotEqualTo(Integer value) {
            return notEqualTo(useStatus, value);
        }

        public DaifaPostCustomerExample.Criteria andUseStatusGreaterThan(Integer value) {
            return greaterThan(useStatus, value);
        }

        public DaifaPostCustomerExample.Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(useStatus, value);
        }

        public DaifaPostCustomerExample.Criteria andUseStatusLessThan(Integer value) {
            return lessThan(useStatus, value);
        }

        public DaifaPostCustomerExample.Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(useStatus, value);
        }

        public DaifaPostCustomerExample.Criteria andUseStatusIn(List<Integer> values) {
            return in(useStatus, values);
        }

        public DaifaPostCustomerExample.Criteria andUseStatusNotIn(List<Integer> values) {
            return notIn(useStatus, values);
        }

        public DaifaPostCustomerExample.Criteria andUseStatusBetween(Integer value1, Integer value2) {
            return between(useStatus, value1, value2);
        }

        public DaifaPostCustomerExample.Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(useStatus, value1, value2);
        }
        public DaifaPostCustomerExample.Criteria andMonthCodeIsNull() {
            return isNull(monthCode);
        }

        public DaifaPostCustomerExample.Criteria andMonthCodeIsNotNull() {
            return isNotNull(monthCode);
        }

        public DaifaPostCustomerExample.Criteria andMonthCodeEqualTo(String value) {
            return equalTo(monthCode, value);
        }

        public DaifaPostCustomerExample.Criteria andMonthCodeNotEqualTo(String value) {
            return notEqualTo(monthCode, value);
        }

        public DaifaPostCustomerExample.Criteria andMonthCodeGreaterThan(String value) {
            return greaterThan(monthCode, value);
        }

        public DaifaPostCustomerExample.Criteria andMonthCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(monthCode, value);
        }

        public DaifaPostCustomerExample.Criteria andMonthCodeLessThan(String value) {
            return lessThan(monthCode, value);
        }

        public DaifaPostCustomerExample.Criteria andMonthCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(monthCode, value);
        }

        public DaifaPostCustomerExample.Criteria andMonthCodeLike(String value) {
            return like(monthCode, value);
        }

        public DaifaPostCustomerExample.Criteria andMonthCodeNotLike(String value) {
            return notLike(monthCode, value);
        }

        public DaifaPostCustomerExample.Criteria andMonthCodeIn(List<String> values) {
            return in(monthCode, values);
        }

        public DaifaPostCustomerExample.Criteria andMonthCodeNotIn(List<String> values) {
            return notIn(monthCode, values);
        }

        public DaifaPostCustomerExample.Criteria andMonthCodeBetween(String value1, String value2) {
            return between(monthCode, value1, value2);
        }

        public DaifaPostCustomerExample.Criteria andMonthCodeNotBetween(String value1, String value2) {
            return notBetween(monthCode, value1, value2);
        }
        public DaifaPostCustomerExample.Criteria andAllAddressIsNull() {
            return isNull(allAddress);
        }

        public DaifaPostCustomerExample.Criteria andAllAddressIsNotNull() {
            return isNotNull(allAddress);
        }

        public DaifaPostCustomerExample.Criteria andAllAddressEqualTo(Boolean value) {
            return equalTo(allAddress, value);
        }

        public DaifaPostCustomerExample.Criteria andAllAddressNotEqualTo(Boolean value) {
            return notEqualTo(allAddress, value);
        }

        public DaifaPostCustomerExample.Criteria andAllAddressGreaterThan(Boolean value) {
            return greaterThan(allAddress, value);
        }

        public DaifaPostCustomerExample.Criteria andAllAddressGreaterThanOrEqualTo(Boolean value) {
            return greaterThanOrEqualTo(allAddress, value);
        }

        public DaifaPostCustomerExample.Criteria andAllAddressLessThan(Boolean value) {
            return lessThan(allAddress, value);
        }

        public DaifaPostCustomerExample.Criteria andAllAddressLessThanOrEqualTo(Boolean value) {
            return lessThanOrEqualTo(allAddress, value);
        }

        public DaifaPostCustomerExample.Criteria andAllAddressIn(List<Boolean> values) {
            return in(allAddress, values);
        }

        public DaifaPostCustomerExample.Criteria andAllAddressNotIn(List<Boolean> values) {
            return notIn(allAddress, values);
        }

        public DaifaPostCustomerExample.Criteria andAllAddressBetween(Boolean value1, Boolean value2) {
            return between(allAddress, value1, value2);
        }

        public DaifaPostCustomerExample.Criteria andAllAddressNotBetween(Boolean value1, Boolean value2) {
            return notBetween(allAddress, value1, value2);
        }
        public DaifaPostCustomerExample.Criteria andSendSiteIsNull() {
            return isNull(sendSite);
        }

        public DaifaPostCustomerExample.Criteria andSendSiteIsNotNull() {
            return isNotNull(sendSite);
        }

        public DaifaPostCustomerExample.Criteria andSendSiteEqualTo(String value) {
            return equalTo(sendSite, value);
        }

        public DaifaPostCustomerExample.Criteria andSendSiteNotEqualTo(String value) {
            return notEqualTo(sendSite, value);
        }

        public DaifaPostCustomerExample.Criteria andSendSiteGreaterThan(String value) {
            return greaterThan(sendSite, value);
        }

        public DaifaPostCustomerExample.Criteria andSendSiteGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(sendSite, value);
        }

        public DaifaPostCustomerExample.Criteria andSendSiteLessThan(String value) {
            return lessThan(sendSite, value);
        }

        public DaifaPostCustomerExample.Criteria andSendSiteLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(sendSite, value);
        }

        public DaifaPostCustomerExample.Criteria andSendSiteLike(String value) {
            return like(sendSite, value);
        }

        public DaifaPostCustomerExample.Criteria andSendSiteNotLike(String value) {
            return notLike(sendSite, value);
        }

        public DaifaPostCustomerExample.Criteria andSendSiteIn(List<String> values) {
            return in(sendSite, values);
        }

        public DaifaPostCustomerExample.Criteria andSendSiteNotIn(List<String> values) {
            return notIn(sendSite, values);
        }

        public DaifaPostCustomerExample.Criteria andSendSiteBetween(String value1, String value2) {
            return between(sendSite, value1, value2);
        }

        public DaifaPostCustomerExample.Criteria andSendSiteNotBetween(String value1, String value2) {
            return notBetween(sendSite, value1, value2);
        }
        public DaifaPostCustomerExample.Criteria andExpTypeIsNull() {
            return isNull(expType);
        }

        public DaifaPostCustomerExample.Criteria andExpTypeIsNotNull() {
            return isNotNull(expType);
        }

        public DaifaPostCustomerExample.Criteria andExpTypeEqualTo(Integer value) {
            return equalTo(expType, value);
        }

        public DaifaPostCustomerExample.Criteria andExpTypeNotEqualTo(Integer value) {
            return notEqualTo(expType, value);
        }

        public DaifaPostCustomerExample.Criteria andExpTypeGreaterThan(Integer value) {
            return greaterThan(expType, value);
        }

        public DaifaPostCustomerExample.Criteria andExpTypeGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(expType, value);
        }

        public DaifaPostCustomerExample.Criteria andExpTypeLessThan(Integer value) {
            return lessThan(expType, value);
        }

        public DaifaPostCustomerExample.Criteria andExpTypeLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(expType, value);
        }

        public DaifaPostCustomerExample.Criteria andExpTypeIn(List<Integer> values) {
            return in(expType, values);
        }

        public DaifaPostCustomerExample.Criteria andExpTypeNotIn(List<Integer> values) {
            return notIn(expType, values);
        }

        public DaifaPostCustomerExample.Criteria andExpTypeBetween(Integer value1, Integer value2) {
            return between(expType, value1, value2);
        }

        public DaifaPostCustomerExample.Criteria andExpTypeNotBetween(Integer value1, Integer value2) {
            return notBetween(expType, value1, value2);
        }
        public DaifaPostCustomerExample.Criteria andLogisticCodeIsNull() {
            return isNull(logisticCode);
        }

        public DaifaPostCustomerExample.Criteria andLogisticCodeIsNotNull() {
            return isNotNull(logisticCode);
        }

        public DaifaPostCustomerExample.Criteria andLogisticCodeEqualTo(String value) {
            return equalTo(logisticCode, value);
        }

        public DaifaPostCustomerExample.Criteria andLogisticCodeNotEqualTo(String value) {
            return notEqualTo(logisticCode, value);
        }

        public DaifaPostCustomerExample.Criteria andLogisticCodeGreaterThan(String value) {
            return greaterThan(logisticCode, value);
        }

        public DaifaPostCustomerExample.Criteria andLogisticCodeGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(logisticCode, value);
        }

        public DaifaPostCustomerExample.Criteria andLogisticCodeLessThan(String value) {
            return lessThan(logisticCode, value);
        }

        public DaifaPostCustomerExample.Criteria andLogisticCodeLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(logisticCode, value);
        }

        public DaifaPostCustomerExample.Criteria andLogisticCodeLike(String value) {
            return like(logisticCode, value);
        }

        public DaifaPostCustomerExample.Criteria andLogisticCodeNotLike(String value) {
            return notLike(logisticCode, value);
        }

        public DaifaPostCustomerExample.Criteria andLogisticCodeIn(List<String> values) {
            return in(logisticCode, values);
        }

        public DaifaPostCustomerExample.Criteria andLogisticCodeNotIn(List<String> values) {
            return notIn(logisticCode, values);
        }

        public DaifaPostCustomerExample.Criteria andLogisticCodeBetween(String value1, String value2) {
            return between(logisticCode, value1, value2);
        }

        public DaifaPostCustomerExample.Criteria andLogisticCodeNotBetween(String value1, String value2) {
            return notBetween(logisticCode, value1, value2);
        }
        public DaifaPostCustomerExample.Criteria andExpressIdIsNull() {
            return isNull(expressId);
        }

        public DaifaPostCustomerExample.Criteria andExpressIdIsNotNull() {
            return isNotNull(expressId);
        }

        public DaifaPostCustomerExample.Criteria andExpressIdEqualTo(Long value) {
            return equalTo(expressId, value);
        }

        public DaifaPostCustomerExample.Criteria andExpressIdNotEqualTo(Long value) {
            return notEqualTo(expressId, value);
        }

        public DaifaPostCustomerExample.Criteria andExpressIdGreaterThan(Long value) {
            return greaterThan(expressId, value);
        }

        public DaifaPostCustomerExample.Criteria andExpressIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(expressId, value);
        }

        public DaifaPostCustomerExample.Criteria andExpressIdLessThan(Long value) {
            return lessThan(expressId, value);
        }

        public DaifaPostCustomerExample.Criteria andExpressIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(expressId, value);
        }

        public DaifaPostCustomerExample.Criteria andExpressIdIn(List<Long> values) {
            return in(expressId, values);
        }

        public DaifaPostCustomerExample.Criteria andExpressIdNotIn(List<Long> values) {
            return notIn(expressId, values);
        }

        public DaifaPostCustomerExample.Criteria andExpressIdBetween(Long value1, Long value2) {
            return between(expressId, value1, value2);
        }

        public DaifaPostCustomerExample.Criteria andExpressIdNotBetween(Long value1, Long value2) {
            return notBetween(expressId, value1, value2);
        }
        public DaifaPostCustomerExample.Criteria andCustomerPwdIsNull() {
            return isNull(customerPwd);
        }

        public DaifaPostCustomerExample.Criteria andCustomerPwdIsNotNull() {
            return isNotNull(customerPwd);
        }

        public DaifaPostCustomerExample.Criteria andCustomerPwdEqualTo(String value) {
            return equalTo(customerPwd, value);
        }

        public DaifaPostCustomerExample.Criteria andCustomerPwdNotEqualTo(String value) {
            return notEqualTo(customerPwd, value);
        }

        public DaifaPostCustomerExample.Criteria andCustomerPwdGreaterThan(String value) {
            return greaterThan(customerPwd, value);
        }

        public DaifaPostCustomerExample.Criteria andCustomerPwdGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(customerPwd, value);
        }

        public DaifaPostCustomerExample.Criteria andCustomerPwdLessThan(String value) {
            return lessThan(customerPwd, value);
        }

        public DaifaPostCustomerExample.Criteria andCustomerPwdLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(customerPwd, value);
        }

        public DaifaPostCustomerExample.Criteria andCustomerPwdLike(String value) {
            return like(customerPwd, value);
        }

        public DaifaPostCustomerExample.Criteria andCustomerPwdNotLike(String value) {
            return notLike(customerPwd, value);
        }

        public DaifaPostCustomerExample.Criteria andCustomerPwdIn(List<String> values) {
            return in(customerPwd, values);
        }

        public DaifaPostCustomerExample.Criteria andCustomerPwdNotIn(List<String> values) {
            return notIn(customerPwd, values);
        }

        public DaifaPostCustomerExample.Criteria andCustomerPwdBetween(String value1, String value2) {
            return between(customerPwd, value1, value2);
        }

        public DaifaPostCustomerExample.Criteria andCustomerPwdNotBetween(String value1, String value2) {
            return notBetween(customerPwd, value1, value2);
        }
    }
}