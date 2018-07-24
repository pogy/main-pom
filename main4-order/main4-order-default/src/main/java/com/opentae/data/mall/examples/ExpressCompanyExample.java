package com.opentae.data.mall.examples;

import com.opentae.core.mybatis.SgExample;
import com.opentae.core.mybatis.example.EntityColumn;
import com.opentae.core.mybatis.example.EntityTable;
import com.opentae.core.mybatis.mapperhelper.EntityHelper;
import com.opentae.data.mall.beans.ExpressCompany;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class ExpressCompanyExample extends SgExample<ExpressCompanyExample.Criteria> {
    public static final Class<ExpressCompany> beanClass = ExpressCompany.class;
    public static final EntityTable entityTable = EntityHelper.getEntityTable(beanClass);
    public static EntityColumn expressName;
    public static EntityColumn enName;
    public static EntityColumn remark5;
    public static EntityColumn remark4;
    public static EntityColumn expressCompanyId;
    public static EntityColumn shortName;
    public static EntityColumn remark1;
    public static EntityColumn remark3;
    public static EntityColumn useStatus;
    public static EntityColumn remark2;
    static {
        Set<EntityColumn> columns = entityTable.getEntityClassColumns();
        Map<String, EntityColumn> listMap = new HashMap<>();
        for (EntityColumn column : columns) {
            listMap.put(column.getProperty(), column);
        }
        expressName = listMap.get("expressName");
        enName = listMap.get("enName");
        remark5 = listMap.get("remark5");
        remark4 = listMap.get("remark4");
        expressCompanyId = listMap.get("expressCompanyId");
        shortName = listMap.get("shortName");
        remark1 = listMap.get("remark1");
        remark3 = listMap.get("remark3");
        useStatus = listMap.get("useStatus");
        remark2 = listMap.get("remark2");
        }

    public ExpressCompanyExample() {
        this.setTableAlias(entityTable.getName());
    }

    @Override
    public EntityTable getEntityTable() {
        return entityTable;
    }

    @Override
    protected ExpressCompanyExample.Criteria createCriteriaInternal() {
        return new ExpressCompanyExample.Criteria(this);
    }

    public static class Criteria extends SgExample.GeneratedCriteria<Criteria> {
        protected Criteria(SgExample example) {
            super(example);
        }

        public ExpressCompanyExample.Criteria andExpressNameIsNull() {
            return isNull(expressName);
        }

        public ExpressCompanyExample.Criteria andExpressNameIsNotNull() {
            return isNotNull(expressName);
        }

        public ExpressCompanyExample.Criteria andExpressNameEqualTo(String value) {
            return equalTo(expressName, value);
        }

        public ExpressCompanyExample.Criteria andExpressNameNotEqualTo(String value) {
            return notEqualTo(expressName, value);
        }

        public ExpressCompanyExample.Criteria andExpressNameGreaterThan(String value) {
            return greaterThan(expressName, value);
        }

        public ExpressCompanyExample.Criteria andExpressNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(expressName, value);
        }

        public ExpressCompanyExample.Criteria andExpressNameLessThan(String value) {
            return lessThan(expressName, value);
        }

        public ExpressCompanyExample.Criteria andExpressNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(expressName, value);
        }

        public ExpressCompanyExample.Criteria andExpressNameLike(String value) {
            return like(expressName, value);
        }

        public ExpressCompanyExample.Criteria andExpressNameNotLike(String value) {
            return notLike(expressName, value);
        }

        public ExpressCompanyExample.Criteria andExpressNameIn(List<String> values) {
            return in(expressName, values);
        }

        public ExpressCompanyExample.Criteria andExpressNameNotIn(List<String> values) {
            return notIn(expressName, values);
        }

        public ExpressCompanyExample.Criteria andExpressNameBetween(String value1, String value2) {
            return between(expressName, value1, value2);
        }

        public ExpressCompanyExample.Criteria andExpressNameNotBetween(String value1, String value2) {
            return notBetween(expressName, value1, value2);
        }
        public ExpressCompanyExample.Criteria andEnNameIsNull() {
            return isNull(enName);
        }

        public ExpressCompanyExample.Criteria andEnNameIsNotNull() {
            return isNotNull(enName);
        }

        public ExpressCompanyExample.Criteria andEnNameEqualTo(String value) {
            return equalTo(enName, value);
        }

        public ExpressCompanyExample.Criteria andEnNameNotEqualTo(String value) {
            return notEqualTo(enName, value);
        }

        public ExpressCompanyExample.Criteria andEnNameGreaterThan(String value) {
            return greaterThan(enName, value);
        }

        public ExpressCompanyExample.Criteria andEnNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(enName, value);
        }

        public ExpressCompanyExample.Criteria andEnNameLessThan(String value) {
            return lessThan(enName, value);
        }

        public ExpressCompanyExample.Criteria andEnNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(enName, value);
        }

        public ExpressCompanyExample.Criteria andEnNameLike(String value) {
            return like(enName, value);
        }

        public ExpressCompanyExample.Criteria andEnNameNotLike(String value) {
            return notLike(enName, value);
        }

        public ExpressCompanyExample.Criteria andEnNameIn(List<String> values) {
            return in(enName, values);
        }

        public ExpressCompanyExample.Criteria andEnNameNotIn(List<String> values) {
            return notIn(enName, values);
        }

        public ExpressCompanyExample.Criteria andEnNameBetween(String value1, String value2) {
            return between(enName, value1, value2);
        }

        public ExpressCompanyExample.Criteria andEnNameNotBetween(String value1, String value2) {
            return notBetween(enName, value1, value2);
        }
        public ExpressCompanyExample.Criteria andRemark5IsNull() {
            return isNull(remark5);
        }

        public ExpressCompanyExample.Criteria andRemark5IsNotNull() {
            return isNotNull(remark5);
        }

        public ExpressCompanyExample.Criteria andRemark5EqualTo(String value) {
            return equalTo(remark5, value);
        }

        public ExpressCompanyExample.Criteria andRemark5NotEqualTo(String value) {
            return notEqualTo(remark5, value);
        }

        public ExpressCompanyExample.Criteria andRemark5GreaterThan(String value) {
            return greaterThan(remark5, value);
        }

        public ExpressCompanyExample.Criteria andRemark5GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark5, value);
        }

        public ExpressCompanyExample.Criteria andRemark5LessThan(String value) {
            return lessThan(remark5, value);
        }

        public ExpressCompanyExample.Criteria andRemark5LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark5, value);
        }

        public ExpressCompanyExample.Criteria andRemark5Like(String value) {
            return like(remark5, value);
        }

        public ExpressCompanyExample.Criteria andRemark5NotLike(String value) {
            return notLike(remark5, value);
        }

        public ExpressCompanyExample.Criteria andRemark5In(List<String> values) {
            return in(remark5, values);
        }

        public ExpressCompanyExample.Criteria andRemark5NotIn(List<String> values) {
            return notIn(remark5, values);
        }

        public ExpressCompanyExample.Criteria andRemark5Between(String value1, String value2) {
            return between(remark5, value1, value2);
        }

        public ExpressCompanyExample.Criteria andRemark5NotBetween(String value1, String value2) {
            return notBetween(remark5, value1, value2);
        }
        public ExpressCompanyExample.Criteria andRemark4IsNull() {
            return isNull(remark4);
        }

        public ExpressCompanyExample.Criteria andRemark4IsNotNull() {
            return isNotNull(remark4);
        }

        public ExpressCompanyExample.Criteria andRemark4EqualTo(String value) {
            return equalTo(remark4, value);
        }

        public ExpressCompanyExample.Criteria andRemark4NotEqualTo(String value) {
            return notEqualTo(remark4, value);
        }

        public ExpressCompanyExample.Criteria andRemark4GreaterThan(String value) {
            return greaterThan(remark4, value);
        }

        public ExpressCompanyExample.Criteria andRemark4GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark4, value);
        }

        public ExpressCompanyExample.Criteria andRemark4LessThan(String value) {
            return lessThan(remark4, value);
        }

        public ExpressCompanyExample.Criteria andRemark4LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark4, value);
        }

        public ExpressCompanyExample.Criteria andRemark4Like(String value) {
            return like(remark4, value);
        }

        public ExpressCompanyExample.Criteria andRemark4NotLike(String value) {
            return notLike(remark4, value);
        }

        public ExpressCompanyExample.Criteria andRemark4In(List<String> values) {
            return in(remark4, values);
        }

        public ExpressCompanyExample.Criteria andRemark4NotIn(List<String> values) {
            return notIn(remark4, values);
        }

        public ExpressCompanyExample.Criteria andRemark4Between(String value1, String value2) {
            return between(remark4, value1, value2);
        }

        public ExpressCompanyExample.Criteria andRemark4NotBetween(String value1, String value2) {
            return notBetween(remark4, value1, value2);
        }
        public ExpressCompanyExample.Criteria andExpressCompanyIdIsNull() {
            return isNull(expressCompanyId);
        }

        public ExpressCompanyExample.Criteria andExpressCompanyIdIsNotNull() {
            return isNotNull(expressCompanyId);
        }

        public ExpressCompanyExample.Criteria andExpressCompanyIdEqualTo(Long value) {
            return equalTo(expressCompanyId, value);
        }

        public ExpressCompanyExample.Criteria andExpressCompanyIdNotEqualTo(Long value) {
            return notEqualTo(expressCompanyId, value);
        }

        public ExpressCompanyExample.Criteria andExpressCompanyIdGreaterThan(Long value) {
            return greaterThan(expressCompanyId, value);
        }

        public ExpressCompanyExample.Criteria andExpressCompanyIdGreaterThanOrEqualTo(Long value) {
            return greaterThanOrEqualTo(expressCompanyId, value);
        }

        public ExpressCompanyExample.Criteria andExpressCompanyIdLessThan(Long value) {
            return lessThan(expressCompanyId, value);
        }

        public ExpressCompanyExample.Criteria andExpressCompanyIdLessThanOrEqualTo(Long value) {
            return lessThanOrEqualTo(expressCompanyId, value);
        }

        public ExpressCompanyExample.Criteria andExpressCompanyIdIn(List<Long> values) {
            return in(expressCompanyId, values);
        }

        public ExpressCompanyExample.Criteria andExpressCompanyIdNotIn(List<Long> values) {
            return notIn(expressCompanyId, values);
        }

        public ExpressCompanyExample.Criteria andExpressCompanyIdBetween(Long value1, Long value2) {
            return between(expressCompanyId, value1, value2);
        }

        public ExpressCompanyExample.Criteria andExpressCompanyIdNotBetween(Long value1, Long value2) {
            return notBetween(expressCompanyId, value1, value2);
        }
        public ExpressCompanyExample.Criteria andShortNameIsNull() {
            return isNull(shortName);
        }

        public ExpressCompanyExample.Criteria andShortNameIsNotNull() {
            return isNotNull(shortName);
        }

        public ExpressCompanyExample.Criteria andShortNameEqualTo(String value) {
            return equalTo(shortName, value);
        }

        public ExpressCompanyExample.Criteria andShortNameNotEqualTo(String value) {
            return notEqualTo(shortName, value);
        }

        public ExpressCompanyExample.Criteria andShortNameGreaterThan(String value) {
            return greaterThan(shortName, value);
        }

        public ExpressCompanyExample.Criteria andShortNameGreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(shortName, value);
        }

        public ExpressCompanyExample.Criteria andShortNameLessThan(String value) {
            return lessThan(shortName, value);
        }

        public ExpressCompanyExample.Criteria andShortNameLessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(shortName, value);
        }

        public ExpressCompanyExample.Criteria andShortNameLike(String value) {
            return like(shortName, value);
        }

        public ExpressCompanyExample.Criteria andShortNameNotLike(String value) {
            return notLike(shortName, value);
        }

        public ExpressCompanyExample.Criteria andShortNameIn(List<String> values) {
            return in(shortName, values);
        }

        public ExpressCompanyExample.Criteria andShortNameNotIn(List<String> values) {
            return notIn(shortName, values);
        }

        public ExpressCompanyExample.Criteria andShortNameBetween(String value1, String value2) {
            return between(shortName, value1, value2);
        }

        public ExpressCompanyExample.Criteria andShortNameNotBetween(String value1, String value2) {
            return notBetween(shortName, value1, value2);
        }
        public ExpressCompanyExample.Criteria andRemark1IsNull() {
            return isNull(remark1);
        }

        public ExpressCompanyExample.Criteria andRemark1IsNotNull() {
            return isNotNull(remark1);
        }

        public ExpressCompanyExample.Criteria andRemark1EqualTo(String value) {
            return equalTo(remark1, value);
        }

        public ExpressCompanyExample.Criteria andRemark1NotEqualTo(String value) {
            return notEqualTo(remark1, value);
        }

        public ExpressCompanyExample.Criteria andRemark1GreaterThan(String value) {
            return greaterThan(remark1, value);
        }

        public ExpressCompanyExample.Criteria andRemark1GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark1, value);
        }

        public ExpressCompanyExample.Criteria andRemark1LessThan(String value) {
            return lessThan(remark1, value);
        }

        public ExpressCompanyExample.Criteria andRemark1LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark1, value);
        }

        public ExpressCompanyExample.Criteria andRemark1Like(String value) {
            return like(remark1, value);
        }

        public ExpressCompanyExample.Criteria andRemark1NotLike(String value) {
            return notLike(remark1, value);
        }

        public ExpressCompanyExample.Criteria andRemark1In(List<String> values) {
            return in(remark1, values);
        }

        public ExpressCompanyExample.Criteria andRemark1NotIn(List<String> values) {
            return notIn(remark1, values);
        }

        public ExpressCompanyExample.Criteria andRemark1Between(String value1, String value2) {
            return between(remark1, value1, value2);
        }

        public ExpressCompanyExample.Criteria andRemark1NotBetween(String value1, String value2) {
            return notBetween(remark1, value1, value2);
        }
        public ExpressCompanyExample.Criteria andRemark3IsNull() {
            return isNull(remark3);
        }

        public ExpressCompanyExample.Criteria andRemark3IsNotNull() {
            return isNotNull(remark3);
        }

        public ExpressCompanyExample.Criteria andRemark3EqualTo(String value) {
            return equalTo(remark3, value);
        }

        public ExpressCompanyExample.Criteria andRemark3NotEqualTo(String value) {
            return notEqualTo(remark3, value);
        }

        public ExpressCompanyExample.Criteria andRemark3GreaterThan(String value) {
            return greaterThan(remark3, value);
        }

        public ExpressCompanyExample.Criteria andRemark3GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark3, value);
        }

        public ExpressCompanyExample.Criteria andRemark3LessThan(String value) {
            return lessThan(remark3, value);
        }

        public ExpressCompanyExample.Criteria andRemark3LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark3, value);
        }

        public ExpressCompanyExample.Criteria andRemark3Like(String value) {
            return like(remark3, value);
        }

        public ExpressCompanyExample.Criteria andRemark3NotLike(String value) {
            return notLike(remark3, value);
        }

        public ExpressCompanyExample.Criteria andRemark3In(List<String> values) {
            return in(remark3, values);
        }

        public ExpressCompanyExample.Criteria andRemark3NotIn(List<String> values) {
            return notIn(remark3, values);
        }

        public ExpressCompanyExample.Criteria andRemark3Between(String value1, String value2) {
            return between(remark3, value1, value2);
        }

        public ExpressCompanyExample.Criteria andRemark3NotBetween(String value1, String value2) {
            return notBetween(remark3, value1, value2);
        }
        public ExpressCompanyExample.Criteria andUseStatusIsNull() {
            return isNull(useStatus);
        }

        public ExpressCompanyExample.Criteria andUseStatusIsNotNull() {
            return isNotNull(useStatus);
        }

        public ExpressCompanyExample.Criteria andUseStatusEqualTo(Integer value) {
            return equalTo(useStatus, value);
        }

        public ExpressCompanyExample.Criteria andUseStatusNotEqualTo(Integer value) {
            return notEqualTo(useStatus, value);
        }

        public ExpressCompanyExample.Criteria andUseStatusGreaterThan(Integer value) {
            return greaterThan(useStatus, value);
        }

        public ExpressCompanyExample.Criteria andUseStatusGreaterThanOrEqualTo(Integer value) {
            return greaterThanOrEqualTo(useStatus, value);
        }

        public ExpressCompanyExample.Criteria andUseStatusLessThan(Integer value) {
            return lessThan(useStatus, value);
        }

        public ExpressCompanyExample.Criteria andUseStatusLessThanOrEqualTo(Integer value) {
            return lessThanOrEqualTo(useStatus, value);
        }

        public ExpressCompanyExample.Criteria andUseStatusIn(List<Integer> values) {
            return in(useStatus, values);
        }

        public ExpressCompanyExample.Criteria andUseStatusNotIn(List<Integer> values) {
            return notIn(useStatus, values);
        }

        public ExpressCompanyExample.Criteria andUseStatusBetween(Integer value1, Integer value2) {
            return between(useStatus, value1, value2);
        }

        public ExpressCompanyExample.Criteria andUseStatusNotBetween(Integer value1, Integer value2) {
            return notBetween(useStatus, value1, value2);
        }
        public ExpressCompanyExample.Criteria andRemark2IsNull() {
            return isNull(remark2);
        }

        public ExpressCompanyExample.Criteria andRemark2IsNotNull() {
            return isNotNull(remark2);
        }

        public ExpressCompanyExample.Criteria andRemark2EqualTo(String value) {
            return equalTo(remark2, value);
        }

        public ExpressCompanyExample.Criteria andRemark2NotEqualTo(String value) {
            return notEqualTo(remark2, value);
        }

        public ExpressCompanyExample.Criteria andRemark2GreaterThan(String value) {
            return greaterThan(remark2, value);
        }

        public ExpressCompanyExample.Criteria andRemark2GreaterThanOrEqualTo(String value) {
            return greaterThanOrEqualTo(remark2, value);
        }

        public ExpressCompanyExample.Criteria andRemark2LessThan(String value) {
            return lessThan(remark2, value);
        }

        public ExpressCompanyExample.Criteria andRemark2LessThanOrEqualTo(String value) {
            return lessThanOrEqualTo(remark2, value);
        }

        public ExpressCompanyExample.Criteria andRemark2Like(String value) {
            return like(remark2, value);
        }

        public ExpressCompanyExample.Criteria andRemark2NotLike(String value) {
            return notLike(remark2, value);
        }

        public ExpressCompanyExample.Criteria andRemark2In(List<String> values) {
            return in(remark2, values);
        }

        public ExpressCompanyExample.Criteria andRemark2NotIn(List<String> values) {
            return notIn(remark2, values);
        }

        public ExpressCompanyExample.Criteria andRemark2Between(String value1, String value2) {
            return between(remark2, value1, value2);
        }

        public ExpressCompanyExample.Criteria andRemark2NotBetween(String value1, String value2) {
            return notBetween(remark2, value1, value2);
        }
    }
}
