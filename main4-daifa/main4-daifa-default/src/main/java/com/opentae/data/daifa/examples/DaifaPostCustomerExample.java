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
    public static EntityColumn postId;
    public static EntityColumn postName;
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
        postId = listMap.get("postId");
        postName = listMap.get("postName");
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
        public DaifaPostCustomerExample.Criteria andPostIdIsNull() {
            return isNull(postId);
        }

        public DaifaPostCustomerExample.Criteria andPostIdIsNotNull() {
            return isNotNull(postId);
        }

        public DaifaPostCustomerExample.Criteria andPostIdEqualTo(Long value) {
            return equalTo(postId, value);
        }

        public DaifaPostCustomerExample.Criteria andPostIdNotEqualTo(Long value) {
            return notEqualTo(postId, value);
        }

        public DaifaPostCustomerExample.Criteria andPostIdGreaterThan(Long value) {
            return greaterThan(postId, value);
        }

        public DaifaPostCustomerExample.Criteria andPostIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(postId, value);
        }

        public DaifaPostCustomerExample.Criteria andPostIdLessThan(Long value) {
            return lessThan(postId, value);
        }

        public DaifaPostCustomerExample.Criteria andPostIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(postId, value);
        }

        public DaifaPostCustomerExample.Criteria andPostIdIn(List<Long> values) {
            return in(postId, values);
        }

        public DaifaPostCustomerExample.Criteria andPostIdNotIn(List<Long> values) {
            return notIn(postId, values);
        }

        public DaifaPostCustomerExample.Criteria andPostIdBetween(Long value1, Long value2) {
            return between(postId, value1, value2);
        }

        public DaifaPostCustomerExample.Criteria andPostIdNotBetween(Long value1, Long value2) {
            return notBetween(postId, value1, value2);
        }
        public DaifaPostCustomerExample.Criteria andPostNameIsNull() {
            return isNull(postName);
        }

        public DaifaPostCustomerExample.Criteria andPostNameIsNotNull() {
            return isNotNull(postName);
        }

        public DaifaPostCustomerExample.Criteria andPostNameEqualTo(String value) {
            return equalTo(postName, value);
        }

        public DaifaPostCustomerExample.Criteria andPostNameNotEqualTo(String value) {
            return notEqualTo(postName, value);
        }

        public DaifaPostCustomerExample.Criteria andPostNameGreaterThan(String value) {
            return greaterThan(postName, value);
        }

        public DaifaPostCustomerExample.Criteria andPostNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(postName, value);
        }

        public DaifaPostCustomerExample.Criteria andPostNameLessThan(String value) {
            return lessThan(postName, value);
        }

        public DaifaPostCustomerExample.Criteria andPostNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(postName, value);
        }

        public DaifaPostCustomerExample.Criteria andPostNameLike(String value) {
            return like(postName, value);
        }

        public DaifaPostCustomerExample.Criteria andPostNameNotLike(String value) {
            return notLike(postName, value);
        }

        public DaifaPostCustomerExample.Criteria andPostNameIn(List<String> values) {
            return in(postName, values);
        }

        public DaifaPostCustomerExample.Criteria andPostNameNotIn(List<String> values) {
            return notIn(postName, values);
        }

        public DaifaPostCustomerExample.Criteria andPostNameBetween(String value1, String value2) {
            return between(postName, value1, value2);
        }

        public DaifaPostCustomerExample.Criteria andPostNameNotBetween(String value1, String value2) {
            return notBetween(postName, value1, value2);
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
    }
}